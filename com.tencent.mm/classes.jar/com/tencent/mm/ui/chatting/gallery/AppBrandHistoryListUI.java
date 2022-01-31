package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.d.b.a;
import com.tencent.mm.ui.chatting.d.b.b;
import com.tencent.mm.ui.chatting.h.a;

public class AppBrandHistoryListUI
  extends MMActivity
  implements b.b
{
  private RecyclerView acI;
  private String drJ;
  private TextView drL;
  private ProgressDialog khj;
  private b.a vtF;
  
  private void ew(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.khj = p.b(this, getString(R.l.loading_tips), true, 0, null);
    }
    while ((this.khj == null) || (!this.khj.isShowing())) {
      return;
    }
    this.khj.dismiss();
    this.khj = null;
  }
  
  public final void bM(String paramString, boolean paramBoolean) {}
  
  public final void cFR()
  {
    ew(true);
  }
  
  protected final int getLayoutId()
  {
    return R.i.appbrand_history_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(getString(R.l.chat_app_brand));
    this.drL = ((TextView)findViewById(R.h.search_nothing_hint));
    this.acI = ((RecyclerView)findViewById(R.h.history_recycler_view));
    this.acI.setBackgroundColor(-1);
    this.acI.setLayoutManager(this.vtF.aRV());
    this.acI.setAdapter(this.vtF.adA(this.drJ));
    this.acI.setHasFixedSize(true);
    setBackBtn(new AppBrandHistoryListUI.1(this));
  }
  
  public final void k(boolean paramBoolean, int paramInt)
  {
    ew(false);
    y.i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.drL.setVisibility(0);
      this.acI.setVisibility(8);
      this.drL.setText(getString(R.l.chatting_record_noting_hint));
      return;
    }
    this.drL.setVisibility(8);
    this.acI.setVisibility(0);
    this.acI.getAdapter().agL.notifyChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.drJ = getIntent().getStringExtra("Chat_User");
    new a(this).a(this);
    initView();
    this.vtF.cFN();
    if (s.fn(this.drJ))
    {
      h.nFQ.f(14562, new Object[] { this.drJ, Integer.valueOf(0) });
      return;
    }
    h.nFQ.f(14562, new Object[] { this.drJ, Integer.valueOf(1) });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.vtF.onDetach();
  }
  
  public final void onFinish()
  {
    y.i("MicroMsg.AppBrandHistoryListUI", "[onRefreshed]");
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.AppBrandHistoryListUI
 * JD-Core Version:    0.7.0.1
 */