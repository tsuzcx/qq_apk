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
import com.tencent.mm.ak.q;
import com.tencent.mm.al.a.b.a;
import com.tencent.mm.al.a.b.a.b;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.d.a;
import com.tencent.mm.al.a.d.a.b;
import com.tencent.mm.al.a.h;
import com.tencent.mm.al.a.t;
import com.tencent.mm.al.a.x;
import com.tencent.mm.al.af;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.l;

public class BizChatFavUI
  extends MMActivity
  implements com.tencent.mm.al.o
{
  private b.a HHe;
  private d.a HHf;
  private c HHj;
  private TextView emptyTipTv;
  private boolean isCurrentActivity;
  private p mcf;
  private ListView ntK;
  private n.d ntM;
  private String nxJ;
  private long nxq;
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(33983);
    if (this.mcf != null) {
      this.mcf.dismiss();
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
    this.ntK = ((ListView)findViewById(2131305951));
    this.emptyTipTv = ((TextView)findViewById(2131299468));
    this.emptyTipTv.setText(2131756676);
    this.ntK.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33972);
        com.tencent.mm.av.o.aFB().cp(paramAnonymousInt);
        AppMethodBeat.o(33972);
      }
    });
    this.HHj = new c(this, new r.a()
    {
      public final void aPg()
      {
        AppMethodBeat.i(33973);
        BizChatFavUI.this.setMMTitle(v.wk(BizChatFavUI.a(BizChatFavUI.this)));
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
    }, this.nxJ);
    this.HHj.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dy(View paramAnonymousView)
      {
        AppMethodBeat.i(33974);
        int i = BizChatFavUI.e(BizChatFavUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(33974);
        return i;
      }
    });
    this.HHj.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(33975);
        BizChatFavUI.e(BizChatFavUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(33975);
      }
    });
    this.HHj.a(new MMSlideDelView.f()
    {
      public final void cN(Object paramAnonymousObject)
      {
        AppMethodBeat.i(33976);
        if (paramAnonymousObject == null)
        {
          ac.e("MicroMsg.BizChatFavUI", "onItemDel object null");
          AppMethodBeat.o(33976);
          return;
        }
        AppMethodBeat.o(33976);
      }
    });
    this.ntK.setAdapter(this.HHj);
    this.ntM = new n.d()
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
    this.ntK.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33966);
        if (paramAnonymousInt < BizChatFavUI.e(BizChatFavUI.this).getHeaderViewsCount())
        {
          ac.w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
          AppMethodBeat.o(33966);
          return true;
        }
        locall.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizChatFavUI.this, BizChatFavUI.g(BizChatFavUI.this));
        AppMethodBeat.o(33966);
        return true;
      }
    });
    this.ntK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33967);
        paramAnonymousAdapterView = (com.tencent.mm.al.a.c)BizChatFavUI.c(BizChatFavUI.this).getItem(paramAnonymousInt);
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
    this.nxJ = getIntent().getStringExtra("Contact_User");
    ac.i("MicroMsg.BizChatFavUI", "[registerListener]");
    this.HHe = new b.a()
    {
      public final void a(b.a.b paramAnonymousb)
      {
        AppMethodBeat.i(33965);
        if ((paramAnonymousb != null) && (paramAnonymousb.hzf != null) && (BizChatFavUI.a(BizChatFavUI.this).equals(paramAnonymousb.hzf.field_brandUserName)))
        {
          ac.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
          if (BizChatFavUI.b(BizChatFavUI.this)) {
            BizChatFavUI.c(BizChatFavUI.this).Xb();
          }
        }
        AppMethodBeat.o(33965);
      }
    };
    this.HHf = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(33970);
        if ((paramAnonymousb != null) && (paramAnonymousb.hzp != null))
        {
          ac.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
          ac.d("MicroMsg.BizChatFavUI", "needToUpdate:%s", new Object[] { Boolean.valueOf(af.aCY().bd(paramAnonymousb.hze).field_needToUpdate) });
          if (BizChatFavUI.b(BizChatFavUI.this)) {
            BizChatFavUI.c(BizChatFavUI.this).Xb();
          }
        }
        AppMethodBeat.o(33970);
      }
    };
    af.aCZ().a(this.HHe, getMainLooper());
    af.aCY().a(this.HHf, getMainLooper());
    initView();
    af.aDe();
    paramBundle = new t(this.nxJ);
    g.agQ().ghe.a(paramBundle, 0);
    AppMethodBeat.o(33978);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(33982);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.nxq = ((com.tencent.mm.al.a.c)this.HHj.getItem(paramView.position)).field_bizChatLocalId;
    paramContextMenu.add(paramView.position, 0, 1, 2131756677);
    AppMethodBeat.o(33982);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33979);
    ac.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
    af.aCZ().a(this.HHe);
    af.aCY().a(this.HHf);
    this.HHj.cVi();
    super.onDestroy();
    AppMethodBeat.o(33979);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33981);
    this.HHj.onPause();
    this.isCurrentActivity = false;
    az.getNotification().rA("");
    super.onPause();
    AppMethodBeat.o(33981);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33980);
    super.onResume();
    ai localai = ((k)g.ab(k.class)).awB().aNt(this.nxJ);
    if ((localai == null) || (!com.tencent.mm.n.b.ln(localai.field_type)))
    {
      finish();
      AppMethodBeat.o(33980);
      return;
    }
    setTitleMuteIconVisibility(8);
    this.isCurrentActivity = true;
    this.HHj.a(null, null);
    az.getNotification().rA(this.nxJ);
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