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
import com.tencent.mm.am.a.b.a;
import com.tencent.mm.am.a.b.a.b;
import com.tencent.mm.am.a.d;
import com.tencent.mm.am.a.d.a;
import com.tencent.mm.am.a.d.a.b;
import com.tencent.mm.am.a.h;
import com.tencent.mm.am.a.t;
import com.tencent.mm.am.a.x;
import com.tencent.mm.am.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.r.a;

public class BizChatFavUI
  extends MMActivity
  implements com.tencent.mm.am.p
{
  private b.a JuV;
  private d.a JuW;
  private c Jva;
  private TextView emptyTipTv;
  private boolean isCurrentActivity;
  private com.tencent.mm.ui.base.p mCn;
  private ListView nUG;
  private n.e nUI;
  private long nYO;
  private String nZh;
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(33983);
    if (this.mCn != null) {
      this.mCn.dismiss();
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
    this.nUG = ((ListView)findViewById(2131305951));
    this.emptyTipTv = ((TextView)findViewById(2131299468));
    this.emptyTipTv.setText(2131756676);
    this.nUG.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33972);
        com.tencent.mm.aw.q.aIJ().cp(paramAnonymousInt);
        AppMethodBeat.o(33972);
      }
    });
    this.Jva = new c(this, new r.a()
    {
      public final void aSs()
      {
        AppMethodBeat.i(33973);
        BizChatFavUI.this.setMMTitle(v.zf(BizChatFavUI.a(BizChatFavUI.this)));
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
    }, this.nZh);
    this.Jva.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dA(View paramAnonymousView)
      {
        AppMethodBeat.i(33974);
        int i = BizChatFavUI.e(BizChatFavUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(33974);
        return i;
      }
    });
    this.Jva.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(33975);
        BizChatFavUI.e(BizChatFavUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(33975);
      }
    });
    this.Jva.a(new MMSlideDelView.f()
    {
      public final void cP(Object paramAnonymousObject)
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
    this.nUG.setAdapter(this.Jva);
    this.nUI = new n.e()
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
    this.nUG.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
    this.nUG.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33967);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatFavUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = (com.tencent.mm.am.a.c)BizChatFavUI.c(BizChatFavUI.this).getItem(paramAnonymousInt);
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
    this.nZh = getIntent().getStringExtra("Contact_User");
    ad.i("MicroMsg.BizChatFavUI", "[registerListener]");
    this.JuV = new b.a()
    {
      public final void a(b.a.b paramAnonymousb)
      {
        AppMethodBeat.i(33965);
        if ((paramAnonymousb != null) && (paramAnonymousb.hRA != null) && (BizChatFavUI.a(BizChatFavUI.this).equals(paramAnonymousb.hRA.field_brandUserName)))
        {
          ad.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
          if (BizChatFavUI.b(BizChatFavUI.this)) {
            BizChatFavUI.c(BizChatFavUI.this).Zu();
          }
        }
        AppMethodBeat.o(33965);
      }
    };
    this.JuW = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(33970);
        if ((paramAnonymousb != null) && (paramAnonymousb.hRK != null))
        {
          ad.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
          ad.d("MicroMsg.BizChatFavUI", "needToUpdate:%s", new Object[] { Boolean.valueOf(ag.aGb().bd(paramAnonymousb.hRz).field_needToUpdate) });
          if (BizChatFavUI.b(BizChatFavUI.this)) {
            BizChatFavUI.c(BizChatFavUI.this).Zu();
          }
        }
        AppMethodBeat.o(33970);
      }
    };
    ag.aGc().a(this.JuV, getMainLooper());
    ag.aGb().a(this.JuW, getMainLooper());
    initView();
    ag.aGh();
    paramBundle = new t(this.nZh);
    g.ajB().gAO.a(paramBundle, 0);
    AppMethodBeat.o(33978);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(33982);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.nYO = ((com.tencent.mm.am.a.c)this.Jva.getItem(paramView.position)).field_bizChatLocalId;
    paramContextMenu.add(paramView.position, 0, 1, 2131756677);
    AppMethodBeat.o(33982);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33979);
    ad.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
    ag.aGc().a(this.JuV);
    ag.aGb().a(this.JuW);
    this.Jva.det();
    super.onDestroy();
    AppMethodBeat.o(33979);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33981);
    this.Jva.onPause();
    this.isCurrentActivity = false;
    ba.getNotification().un("");
    super.onPause();
    AppMethodBeat.o(33981);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33980);
    super.onResume();
    am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.nZh);
    if ((localam == null) || (!com.tencent.mm.o.b.lM(localam.field_type)))
    {
      finish();
      AppMethodBeat.o(33980);
      return;
    }
    setTitleMuteIconVisibility(8);
    this.isCurrentActivity = true;
    this.Jva.a(null, null);
    ba.getNotification().un(this.nZh);
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