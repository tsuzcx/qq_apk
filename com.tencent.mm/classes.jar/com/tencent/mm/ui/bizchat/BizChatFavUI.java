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
import com.tencent.mm.al.a.b.a;
import com.tencent.mm.al.a.b.a.b;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.d.a;
import com.tencent.mm.al.a.d.a.b;
import com.tencent.mm.al.a.h;
import com.tencent.mm.al.a.x;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.s.a;

public class BizChatFavUI
  extends MMActivity
  implements p
{
  private b.a PaP;
  private d.a PaQ;
  private c PaV;
  private TextView emptyTipTv;
  private boolean isCurrentActivity;
  private com.tencent.mm.ui.base.q nUq;
  private ListView pli;
  private o.g plk;
  private String ppO;
  private long ppv;
  
  public final void a(int paramInt, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(33983);
    if (this.nUq != null) {
      this.nUq.dismiss();
    }
    AppMethodBeat.o(33983);
  }
  
  public int getLayoutId()
  {
    return 2131494000;
  }
  
  public void initView()
  {
    AppMethodBeat.i(33984);
    this.pli = ((ListView)findViewById(2131309254));
    this.emptyTipTv = ((TextView)findViewById(2131300096));
    this.emptyTipTv.setText(2131756832);
    this.pli.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33972);
        com.tencent.mm.av.q.bcV().onScrollStateChanged(paramAnonymousInt);
        AppMethodBeat.o(33972);
      }
    });
    this.PaV = new c(this, new s.a()
    {
      public final void bnE()
      {
        AppMethodBeat.i(33973);
        BizChatFavUI.this.setMMTitle(aa.getDisplayName(BizChatFavUI.a(BizChatFavUI.this)));
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
    }, this.ppO);
    this.PaV.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dr(View paramAnonymousView)
      {
        AppMethodBeat.i(33974);
        int i = BizChatFavUI.e(BizChatFavUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(33974);
        return i;
      }
    });
    this.PaV.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(33975);
        BizChatFavUI.e(BizChatFavUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(33975);
      }
    });
    this.PaV.a(new MMSlideDelView.f()
    {
      public final void cZ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(33976);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.BizChatFavUI", "onItemDel object null");
          AppMethodBeat.o(33976);
          return;
        }
        AppMethodBeat.o(33976);
      }
    });
    this.pli.setAdapter(this.PaV);
    this.plk = new o.g()
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
    this.pli.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33966);
        if (paramAnonymousInt < BizChatFavUI.e(BizChatFavUI.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
          AppMethodBeat.o(33966);
          return true;
        }
        locall.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizChatFavUI.this, BizChatFavUI.g(BizChatFavUI.this));
        AppMethodBeat.o(33966);
        return true;
      }
    });
    this.pli.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33967);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatFavUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
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
    this.ppO = getIntent().getStringExtra("Contact_User");
    Log.i("MicroMsg.BizChatFavUI", "[registerListener]");
    this.PaP = new b.a()
    {
      public final void a(b.a.b paramAnonymousb)
      {
        AppMethodBeat.i(33965);
        if ((paramAnonymousb != null) && (paramAnonymousb.iPF != null) && (BizChatFavUI.a(BizChatFavUI.this).equals(paramAnonymousb.iPF.field_brandUserName)))
        {
          Log.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
          if (BizChatFavUI.b(BizChatFavUI.this)) {
            BizChatFavUI.c(BizChatFavUI.this).anp();
          }
        }
        AppMethodBeat.o(33965);
      }
    };
    this.PaQ = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(33970);
        if ((paramAnonymousb != null) && (paramAnonymousb.iPP != null))
        {
          Log.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
          Log.d("MicroMsg.BizChatFavUI", "needToUpdate:%s", new Object[] { Boolean.valueOf(ag.baj().bs(paramAnonymousb.iPE).field_needToUpdate) });
          if (BizChatFavUI.b(BizChatFavUI.this)) {
            BizChatFavUI.c(BizChatFavUI.this).anp();
          }
        }
        AppMethodBeat.o(33970);
      }
    };
    ag.bak().a(this.PaP, getMainLooper());
    ag.baj().a(this.PaQ, getMainLooper());
    initView();
    ag.baq();
    paramBundle = new com.tencent.mm.al.a.t(this.ppO);
    g.aAg().hqi.a(paramBundle, 0);
    AppMethodBeat.o(33978);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(33982);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.ppv = ((com.tencent.mm.al.a.c)this.PaV.getItem(paramView.position)).field_bizChatLocalId;
    paramContextMenu.add(paramView.position, 0, 1, 2131756833);
    AppMethodBeat.o(33982);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33979);
    Log.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
    ag.bak().a(this.PaP);
    ag.baj().a(this.PaQ);
    this.PaV.ebf();
    super.onDestroy();
    AppMethodBeat.o(33979);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33981);
    this.PaV.onPause();
    this.isCurrentActivity = false;
    bg.getNotification().CY("");
    super.onPause();
    AppMethodBeat.o(33981);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33980);
    super.onResume();
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.ppO);
    if ((localas == null) || (!com.tencent.mm.contact.c.oR(localas.field_type)))
    {
      finish();
      AppMethodBeat.o(33980);
      return;
    }
    setTitleMuteIconVisibility(8);
    this.isCurrentActivity = true;
    this.PaV.onNotifyChange(null, null);
    bg.getNotification().CY(this.ppO);
    AppMethodBeat.o(33980);
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