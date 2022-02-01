package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.a.b.a;
import com.tencent.mm.al.a.b.a.b;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.d.a;
import com.tencent.mm.al.a.d.a.b;
import com.tencent.mm.al.a.h;
import com.tencent.mm.al.a.t;
import com.tencent.mm.al.a.x;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.r.a;

public class BizChatFavUI
  extends MMActivity
  implements com.tencent.mm.al.p
{
  private b.a JPL;
  private d.a JPM;
  private c JPQ;
  private TextView emptyTipTv;
  private boolean isCurrentActivity;
  private com.tencent.mm.ui.base.p mHs;
  private ListView oam;
  private n.e oao;
  private String oeQ;
  private long oex;
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(33983);
    if (this.mHs != null) {
      this.mHs.dismiss();
    }
    AppMethodBeat.o(33983);
  }
  
  public int getLayoutId()
  {
    return 2131493845;
  }
  
  public void initView()
  {
    AppMethodBeat.i(33984);
    this.oam = ((ListView)findViewById(2131305951));
    this.emptyTipTv = ((TextView)findViewById(2131299468));
    this.emptyTipTv.setText(2131756676);
    this.oam.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33972);
        com.tencent.mm.av.q.aJb().cp(paramAnonymousInt);
        AppMethodBeat.o(33972);
      }
    });
    this.JPQ = new c(this, new r.a()
    {
      public final void aSR()
      {
        AppMethodBeat.i(33973);
        BizChatFavUI.this.setMMTitle(w.zP(BizChatFavUI.a(BizChatFavUI.this)));
        if (BizChatFavUI.c(BizChatFavUI.this).getCount() <= 0)
        {
          BizChatFavUI.d(BizChatFavUI.this).setVisibility(0);
          BizChatFavUI.e(BizChatFavUI.this).setVisibility(8);
          AppMethodBeat.o(33973);
          return;
        }
        BizChatFavUI.d(BizChatFavUI.this).setVisibility(8);
        BizChatFavUI.e(BizChatFavUI.this).setVisibility(0);
        AppMethodBeat.o(33973);
      }
    }, this.oeQ);
    this.JPQ.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dA(View paramAnonymousView)
      {
        AppMethodBeat.i(33974);
        int i = BizChatFavUI.e(BizChatFavUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(33974);
        return i;
      }
    });
    this.JPQ.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(33975);
        BizChatFavUI.e(BizChatFavUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(33975);
      }
    });
    this.JPQ.a(new MMSlideDelView.f()
    {
      public final void cQ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(33976);
        if (paramAnonymousObject == null)
        {
          ae.e("MicroMsg.BizChatFavUI", "onItemDel object null");
          AppMethodBeat.o(33976);
          return;
        }
        AppMethodBeat.o(33976);
      }
    });
    this.oam.setAdapter(this.JPQ);
    this.oao = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(33977);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(33977);
          return;
          BizChatFavUI.a(BizChatFavUI.this, BizChatFavUI.f(BizChatFavUI.this));
        }
      }
    };
    final com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(this);
    this.oam.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33966);
        if (paramAnonymousInt < BizChatFavUI.e(BizChatFavUI.this).getHeaderViewsCount())
        {
          ae.w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
          AppMethodBeat.o(33966);
          return true;
        }
        locall.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizChatFavUI.this, BizChatFavUI.g(BizChatFavUI.this));
        AppMethodBeat.o(33966);
        return true;
      }
    });
    this.oam.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33967);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatFavUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousAdapterView = (com.tencent.mm.al.a.c)BizChatFavUI.c(BizChatFavUI.this).getItem(paramAnonymousInt);
        BizChatFavUI.b(BizChatFavUI.this, paramAnonymousAdapterView.field_bizChatLocalId);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatFavUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(33967);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(33971);
        BizChatFavUI.this.finish();
        AppMethodBeat.o(33971);
        return true;
      }
    });
    AppMethodBeat.o(33984);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33978);
    super.onCreate(paramBundle);
    this.oeQ = getIntent().getStringExtra("Contact_User");
    ae.i("MicroMsg.BizChatFavUI", "[registerListener]");
    this.JPL = new b.a()
    {
      public final void a(b.a.b paramAnonymousb)
      {
        AppMethodBeat.i(33965);
        if ((paramAnonymousb != null) && (paramAnonymousb.hUs != null) && (BizChatFavUI.a(BizChatFavUI.this).equals(paramAnonymousb.hUs.field_brandUserName)))
        {
          ae.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
          if (BizChatFavUI.b(BizChatFavUI.this)) {
            BizChatFavUI.c(BizChatFavUI.this).ZD();
          }
        }
        AppMethodBeat.o(33965);
      }
    };
    this.JPM = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(33970);
        if ((paramAnonymousb != null) && (paramAnonymousb.hUC != null))
        {
          ae.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
          ae.d("MicroMsg.BizChatFavUI", "needToUpdate:%s", new Object[] { Boolean.valueOf(ag.aGr().bd(paramAnonymousb.hUr).field_needToUpdate) });
          if (BizChatFavUI.b(BizChatFavUI.this)) {
            BizChatFavUI.c(BizChatFavUI.this).ZD();
          }
        }
        AppMethodBeat.o(33970);
      }
    };
    ag.aGs().a(this.JPL, getMainLooper());
    ag.aGr().a(this.JPM, getMainLooper());
    initView();
    ag.aGx();
    paramBundle = new t(this.oeQ);
    g.ajQ().gDv.a(paramBundle, 0);
    AppMethodBeat.o(33978);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(33982);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.oex = ((com.tencent.mm.al.a.c)this.JPQ.getItem(paramView.position)).field_bizChatLocalId;
    paramContextMenu.add(paramView.position, 0, 1, 2131756677);
    AppMethodBeat.o(33982);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33979);
    ae.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
    ag.aGs().a(this.JPL);
    ag.aGr().a(this.JPM);
    this.JPQ.dhl();
    super.onDestroy();
    AppMethodBeat.o(33979);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33981);
    this.JPQ.onPause();
    this.isCurrentActivity = false;
    bc.getNotification().uI("");
    super.onPause();
    AppMethodBeat.o(33981);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33980);
    super.onResume();
    an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.oeQ);
    if ((localan == null) || (!com.tencent.mm.contact.c.lO(localan.field_type)))
    {
      finish();
      AppMethodBeat.o(33980);
      return;
    }
    setTitleMuteIconVisibility(8);
    this.isCurrentActivity = true;
    this.JPQ.a(null, null);
    bc.getNotification().uI(this.oeQ);
    AppMethodBeat.o(33980);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatFavUI
 * JD-Core Version:    0.7.0.1
 */