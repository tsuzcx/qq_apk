package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.e.b.a;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.chatting.j.a;

public class AppBrandHistoryListUI
  extends MMActivity
  implements b.b
{
  private b.a GzX;
  private RecyclerView akA;
  private String fwd;
  private TextView fwf;
  private ProgressDialog nMZ;
  
  private void iF(boolean paramBoolean)
  {
    AppMethodBeat.i(35874);
    ad.i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.nMZ = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(35874);
      return;
    }
    if ((this.nMZ != null) && (this.nMZ.isShowing()))
    {
      this.nMZ.dismiss();
      this.nMZ = null;
    }
    AppMethodBeat.o(35874);
  }
  
  public final void A(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(35872);
    iF(false);
    ad.i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.fwf.setVisibility(0);
      this.akA.setVisibility(8);
      this.fwf.setText(getString(2131757279));
      AppMethodBeat.o(35872);
      return;
    }
    this.fwf.setVisibility(8);
    this.akA.setVisibility(0);
    this.akA.getAdapter().ao(0, paramInt);
    AppMethodBeat.o(35872);
  }
  
  public final void cH(String paramString, boolean paramBoolean) {}
  
  public final void eZo()
  {
    AppMethodBeat.i(35871);
    iF(true);
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
    this.fwf = ((TextView)findViewById(2131304436));
    this.akA = ((RecyclerView)findViewById(2131300757));
    this.akA.setBackgroundColor(-1);
    this.akA.setLayoutManager(this.GzX.bNL());
    this.akA.setAdapter(this.GzX.aKQ(this.fwd));
    this.akA.setHasFixedSize(true);
    setBackBtn(new AppBrandHistoryListUI.1(this));
    AppMethodBeat.o(35869);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35868);
    super.onCreate(paramBundle);
    this.fwd = getIntent().getStringExtra("Chat_User");
    new a(this).a(this);
    initView();
    this.GzX.eZk();
    if (w.pF(this.fwd))
    {
      h.vKh.f(14562, new Object[] { this.fwd, Integer.valueOf(0) });
      AppMethodBeat.o(35868);
      return;
    }
    h.vKh.f(14562, new Object[] { this.fwd, Integer.valueOf(1) });
    AppMethodBeat.o(35868);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35870);
    super.onDestroy();
    this.GzX.onDetach();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.AppBrandHistoryListUI
 * JD-Core Version:    0.7.0.1
 */