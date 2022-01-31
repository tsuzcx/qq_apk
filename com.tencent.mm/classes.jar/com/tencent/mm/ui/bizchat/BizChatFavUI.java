package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.a.b.a;
import com.tencent.mm.aj.a.d;
import com.tencent.mm.aj.a.d.a;
import com.tencent.mm.aj.a.s;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public class BizChatFavUI
  extends MMActivity
  implements n
{
  private TextView emptyTipTv;
  private com.tencent.mm.ui.base.p iMZ;
  private boolean isCurrentActivity;
  private ListView jSl;
  private n.d jSn;
  private String jUE;
  private long jUy;
  private b.a zts;
  private d.a ztt;
  private c zty;
  
  public final void a(int paramInt, m paramm)
  {
    AppMethodBeat.i(30125);
    if (this.iMZ != null) {
      this.iMZ.dismiss();
    }
    AppMethodBeat.o(30125);
  }
  
  public int getLayoutId()
  {
    return 2130969433;
  }
  
  public void initView()
  {
    AppMethodBeat.i(30129);
    this.jSl = ((ListView)findViewById(2131823736));
    this.emptyTipTv = ((TextView)findViewById(2131821852));
    this.emptyTipTv.setText(2131297754);
    this.jSl.setOnScrollListener(new BizChatFavUI.8(this));
    this.zty = new c(this, new BizChatFavUI.9(this), this.jUE);
    this.zty.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dc(View paramAnonymousView)
      {
        AppMethodBeat.i(30116);
        int i = BizChatFavUI.e(BizChatFavUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(30116);
        return i;
      }
    });
    this.zty.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(30117);
        BizChatFavUI.e(BizChatFavUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(30117);
      }
    });
    this.zty.a(new MMSlideDelView.f()
    {
      public final void bC(Object paramAnonymousObject)
      {
        AppMethodBeat.i(30118);
        if (paramAnonymousObject == null)
        {
          ab.e("MicroMsg.BizChatFavUI", "onItemDel object null");
          AppMethodBeat.o(30118);
          return;
        }
        AppMethodBeat.o(30118);
      }
    });
    this.jSl.setAdapter(this.zty);
    this.jSn = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(30119);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(30119);
          return;
          BizChatFavUI.a(BizChatFavUI.this, BizChatFavUI.f(BizChatFavUI.this));
        }
      }
    };
    l locall = new l(this);
    this.jSl.setOnItemLongClickListener(new BizChatFavUI.2(this, locall));
    this.jSl.setOnItemClickListener(new BizChatFavUI.3(this));
    setBackBtn(new BizChatFavUI.7(this));
    AppMethodBeat.o(30129);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30120);
    super.onCreate(paramBundle);
    this.jUE = getIntent().getStringExtra("Contact_User");
    ab.i("MicroMsg.BizChatFavUI", "[registerListener]");
    this.zts = new BizChatFavUI.1(this);
    this.ztt = new BizChatFavUI.6(this);
    z.afl().a(this.zts, getMainLooper());
    z.afk().a(this.ztt, getMainLooper());
    initView();
    z.afq();
    paramBundle = new s(this.jUE);
    g.RK().eHt.a(paramBundle, 0);
    AppMethodBeat.o(30120);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(30124);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.jUy = ((com.tencent.mm.aj.a.c)this.zty.getItem(paramView.position)).field_bizChatLocalId;
    paramContextMenu.add(paramView.position, 0, 1, 2131297755);
    AppMethodBeat.o(30124);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30121);
    ab.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
    z.afl().a(this.zts);
    z.afk().a(this.ztt);
    this.zty.bKb();
    super.onDestroy();
    AppMethodBeat.o(30121);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30123);
    this.zty.onPause();
    this.isCurrentActivity = false;
    aw.getNotification().kD("");
    super.onPause();
    AppMethodBeat.o(30123);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(30122);
    super.onResume();
    ad localad = ((j)g.E(j.class)).YA().arw(this.jUE);
    if ((localad == null) || (!a.je(localad.field_type)))
    {
      finish();
      AppMethodBeat.o(30122);
      return;
    }
    setTitleMuteIconVisibility(8);
    this.isCurrentActivity = true;
    this.zty.a(null, null);
    aw.getNotification().kD(this.jUE);
    AppMethodBeat.o(30122);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatFavUI
 * JD-Core Version:    0.7.0.1
 */