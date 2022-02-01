package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.f.b.a;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.chatting.k.a;

public class AppBrandHistoryListUI
  extends MMActivity
  implements b.b
{
  private b.a JPh;
  private RecyclerView anl;
  private String fTa;
  private TextView fTc;
  private ProgressDialog oTu;
  
  private void jt(boolean paramBoolean)
  {
    AppMethodBeat.i(35874);
    ad.i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.oTu = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(35874);
      return;
    }
    if ((this.oTu != null) && (this.oTu.isShowing()))
    {
      this.oTu.dismiss();
      this.oTu = null;
    }
    AppMethodBeat.o(35874);
  }
  
  public final void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(35872);
    jt(false);
    ad.i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.fTc.setVisibility(0);
      this.anl.setVisibility(8);
      this.fTc.setText(getString(2131757279));
      AppMethodBeat.o(35872);
      return;
    }
    this.fTc.setVisibility(8);
    this.anl.setVisibility(0);
    this.anl.getAdapter().ap(0, paramInt);
    AppMethodBeat.o(35872);
  }
  
  public final void cS(String paramString, boolean paramBoolean) {}
  
  public final void fFI()
  {
    AppMethodBeat.i(35871);
    jt(true);
    AppMethodBeat.o(35871);
  }
  
  public int getLayoutId()
  {
    return 2131493094;
  }
  
  public void initView()
  {
    AppMethodBeat.i(35869);
    setMMTitle(getString(2131757040));
    this.fTc = ((TextView)findViewById(2131304436));
    this.anl = ((RecyclerView)findViewById(2131300757));
    this.anl.setBackgroundColor(-1);
    this.anl.setLayoutManager(this.JPh.bZB());
    this.anl.setAdapter(this.JPh.aWm(this.fTa));
    this.anl.setHasFixedSize(true);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(35867);
        AppBrandHistoryListUI.this.finish();
        AppMethodBeat.o(35867);
        return true;
      }
    });
    AppMethodBeat.o(35869);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35868);
    super.onCreate(paramBundle);
    this.fTa = getIntent().getStringExtra("Chat_User");
    new a(this).a(this);
    initView();
    this.JPh.fFE();
    if (w.vF(this.fTa))
    {
      g.yhR.f(14562, new Object[] { this.fTa, Integer.valueOf(0) });
      AppMethodBeat.o(35868);
      return;
    }
    g.yhR.f(14562, new Object[] { this.fTa, Integer.valueOf(1) });
    AppMethodBeat.o(35868);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35870);
    super.onDestroy();
    this.JPh.onDetach();
    AppMethodBeat.o(35870);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(35873);
    ad.i("MicroMsg.AppBrandHistoryListUI", "[onRefreshed]");
    finish();
    AppMethodBeat.o(35873);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.AppBrandHistoryListUI
 * JD-Core Version:    0.7.0.1
 */