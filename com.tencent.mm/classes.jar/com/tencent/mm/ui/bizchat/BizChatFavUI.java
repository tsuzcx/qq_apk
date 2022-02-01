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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.a.b.a;
import com.tencent.mm.am.a.b.a.b;
import com.tencent.mm.am.a.d;
import com.tencent.mm.am.a.d.a;
import com.tencent.mm.am.a.d.a.b;
import com.tencent.mm.am.a.h;
import com.tencent.mm.am.a.t;
import com.tencent.mm.am.a.x;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q.a;
import com.tencent.mm.ui.tools.l;

public class BizChatFavUI
  extends MMActivity
  implements com.tencent.mm.am.o
{
  private b.a Ghp;
  private d.a Ghq;
  private c Ghu;
  private TextView emptyTipTv;
  private boolean isCurrentActivity;
  private p lAj;
  private ListView mRu;
  private n.d mRw;
  private long mUQ;
  private String mVj;
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(33983);
    if (this.lAj != null) {
      this.lAj.dismiss();
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
    this.mRu = ((ListView)findViewById(2131305951));
    this.emptyTipTv = ((TextView)findViewById(2131299468));
    this.emptyTipTv.setText(2131756676);
    this.mRu.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33972);
        com.tencent.mm.aw.o.ayJ().cq(paramAnonymousInt);
        AppMethodBeat.o(33972);
      }
    });
    this.Ghu = new c(this, new q.a()
    {
      public final void aIp()
      {
        AppMethodBeat.i(33973);
        BizChatFavUI.this.setMMTitle(v.sh(BizChatFavUI.a(BizChatFavUI.this)));
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
    }, this.mVj);
    this.Ghu.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dw(View paramAnonymousView)
      {
        AppMethodBeat.i(33974);
        int i = BizChatFavUI.e(BizChatFavUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(33974);
        return i;
      }
    });
    this.Ghu.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(33975);
        BizChatFavUI.e(BizChatFavUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(33975);
      }
    });
    this.Ghu.a(new MMSlideDelView.f()
    {
      public final void cO(Object paramAnonymousObject)
      {
        AppMethodBeat.i(33976);
        if (paramAnonymousObject == null)
        {
          ad.e("MicroMsg.BizChatFavUI", "onItemDel object null");
          AppMethodBeat.o(33976);
          return;
        }
        AppMethodBeat.o(33976);
      }
    });
    this.mRu.setAdapter(this.Ghu);
    this.mRw = new n.d()
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
    final l locall = new l(this);
    this.mRu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33966);
        if (paramAnonymousInt < BizChatFavUI.e(BizChatFavUI.this).getHeaderViewsCount())
        {
          ad.w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
          AppMethodBeat.o(33966);
          return true;
        }
        locall.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizChatFavUI.this, BizChatFavUI.g(BizChatFavUI.this));
        AppMethodBeat.o(33966);
        return true;
      }
    });
    this.mRu.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33967);
        paramAnonymousAdapterView = (com.tencent.mm.am.a.c)BizChatFavUI.c(BizChatFavUI.this).getItem(paramAnonymousInt);
        BizChatFavUI.b(BizChatFavUI.this, paramAnonymousAdapterView.field_bizChatLocalId);
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
    this.mVj = getIntent().getStringExtra("Contact_User");
    ad.i("MicroMsg.BizChatFavUI", "[registerListener]");
    this.Ghp = new b.a()
    {
      public final void a(b.a.b paramAnonymousb)
      {
        AppMethodBeat.i(33965);
        if ((paramAnonymousb != null) && (paramAnonymousb.gYG != null) && (BizChatFavUI.a(BizChatFavUI.this).equals(paramAnonymousb.gYG.field_brandUserName)))
        {
          ad.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
          if (BizChatFavUI.b(BizChatFavUI.this)) {
            BizChatFavUI.c(BizChatFavUI.this).Wd();
          }
        }
        AppMethodBeat.o(33965);
      }
    };
    this.Ghq = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(33970);
        if ((paramAnonymousb != null) && (paramAnonymousb.gYQ != null))
        {
          ad.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
          ad.d("MicroMsg.BizChatFavUI", "needToUpdate:%s", new Object[] { Boolean.valueOf(com.tencent.mm.am.af.awg().bg(paramAnonymousb.gYF).field_needToUpdate) });
          if (BizChatFavUI.b(BizChatFavUI.this)) {
            BizChatFavUI.c(BizChatFavUI.this).Wd();
          }
        }
        AppMethodBeat.o(33970);
      }
    };
    com.tencent.mm.am.af.awh().a(this.Ghp, getMainLooper());
    com.tencent.mm.am.af.awg().a(this.Ghq, getMainLooper());
    initView();
    com.tencent.mm.am.af.awm();
    paramBundle = new t(this.mVj);
    g.afA().gcy.a(paramBundle, 0);
    AppMethodBeat.o(33978);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(33982);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.mUQ = ((com.tencent.mm.am.a.c)this.Ghu.getItem(paramView.position)).field_bizChatLocalId;
    paramContextMenu.add(paramView.position, 0, 1, 2131756677);
    AppMethodBeat.o(33982);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33979);
    ad.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
    com.tencent.mm.am.af.awh().a(this.Ghp);
    com.tencent.mm.am.af.awg().a(this.Ghq);
    this.Ghu.cHX();
    super.onDestroy();
    AppMethodBeat.o(33979);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33981);
    this.Ghu.onPause();
    this.isCurrentActivity = false;
    az.getNotification().ou("");
    super.onPause();
    AppMethodBeat.o(33981);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33980);
    super.onResume();
    com.tencent.mm.storage.af localaf = ((k)g.ab(k.class)).apM().aHY(this.mVj);
    if ((localaf == null) || (!com.tencent.mm.n.b.ls(localaf.field_type)))
    {
      finish();
      AppMethodBeat.o(33980);
      return;
    }
    setTitleMuteIconVisibility(8);
    this.isCurrentActivity = true;
    this.Ghu.a(null, null);
    az.getNotification().ou(this.mVj);
    AppMethodBeat.o(33980);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatFavUI
 * JD-Core Version:    0.7.0.1
 */