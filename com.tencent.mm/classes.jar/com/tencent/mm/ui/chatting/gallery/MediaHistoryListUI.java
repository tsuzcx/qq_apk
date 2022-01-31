package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.d.b.a;
import com.tencent.mm.ui.chatting.d.b.b;
import com.tencent.mm.ui.chatting.h.g;
import com.tencent.mm.ui.tools.n;
import java.util.List;

@a(3)
public class MediaHistoryListUI
  extends MMActivity
  implements b.b
{
  private RecyclerView acI;
  private String drJ;
  private TextView drL;
  private ProgressDialog khj;
  private b.a vtF;
  private com.tencent.mm.modelvoiceaddr.ui.b vxN;
  
  private void ew(boolean paramBoolean)
  {
    y.i("MicroMsg.MediaHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.khj = p.b(this, getString(R.l.loading_tips), true, 0, null);
    }
    while ((this.khj == null) || (!this.khj.isShowing())) {
      return;
    }
    this.khj.dismiss();
    this.khj = null;
  }
  
  public final void bM(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = getString(R.l.chatting_record_search_noting_hint, new Object[] { paramString });
      this.drL.setVisibility(0);
      this.acI.setVisibility(8);
      TextView localTextView = this.drL;
      this.drL.getContext();
      localTextView.setText(com.tencent.mm.plugin.fts.a.f.a(str, paramString));
      return;
    }
    this.drL.setVisibility(8);
    this.acI.setVisibility(0);
  }
  
  public final void cFR()
  {
    ew(true);
  }
  
  protected final int getLayoutId()
  {
    return R.i.media_history_ui;
  }
  
  protected final void initView()
  {
    this.vxN = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.vxN.nK(false);
    this.vxN.a(this.vtF.cFP());
    this.vxN.eNe = false;
    this.drL = ((TextView)findViewById(R.h.search_nothing_hint));
    this.acI = ((RecyclerView)findViewById(R.h.history_recycler_view));
    findViewById(R.h.content_history).setBackgroundColor(-1);
    this.acI.setBackgroundColor(-1);
    this.acI.setLayoutManager(this.vtF.aRV());
    this.acI.a(this.vtF.cFM());
    this.acI.setAdapter(this.vtF.adA(this.drJ));
    this.acI.setHasFixedSize(true);
    setMMTitle(this.vtF.VE());
  }
  
  public final void k(boolean paramBoolean, int paramInt)
  {
    ew(false);
    y.i("MicroMsg.MediaHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
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
  
  public void onBackPressed()
  {
    super.onBackPressed();
    finish();
    overridePendingTransition(0, 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(R.h.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.drJ = getIntent().getStringExtra("kintent_talker");
    int i = getIntent().getIntExtra("key_media_type", -1);
    paramBundle = null;
    switch (i)
    {
    default: 
      if (paramBundle == null) {
        y.e("MicroMsg.MediaHistoryListUI", "[onCreate] presenter is null!");
      }
      break;
    }
    label668:
    do
    {
      do
      {
        return;
        paramBundle = new com.tencent.mm.ui.chatting.h.d(this);
        break;
        paramBundle = new com.tencent.mm.ui.chatting.h.h(this);
        break;
        paramBundle = new com.tencent.mm.ui.chatting.h.f(this);
        break;
        paramBundle = new g(this);
        break;
        paramBundle.a(this);
        ta(android.support.v4.content.b.i(this.mController.uMN, R.e.normal_actionbar_color));
        czo();
        initView();
        this.vtF.cFN();
        boolean bool = com.tencent.mm.model.s.fn(this.drJ);
        au.Hx();
        paramBundle = c.FF().io(this.drJ);
        if (!bool) {
          break label668;
        }
        if (this.vtF.getType() == 6)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.MN().size()), Integer.valueOf(1) });
          return;
        }
        if (this.vtF.getType() == -1)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(paramBundle.MN().size()), Integer.valueOf(1) });
          return;
        }
        if (this.vtF.getType() == 3)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramBundle.MN().size()), Integer.valueOf(1) });
          return;
        }
      } while (this.vtF.getType() != 5);
      com.tencent.mm.plugin.report.service.h.nFQ.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramBundle.MN().size()), Integer.valueOf(1), Integer.valueOf(1) });
      return;
      if (this.vtF.getType() == 6)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        return;
      }
      if (this.vtF.getType() == -1)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        return;
      }
      if (this.vtF.getType() == 3)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
        return;
      }
    } while (this.vtF.getType() != 5);
    com.tencent.mm.plugin.report.service.h.nFQ.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.vxN.a(this, paramMenu);
    paramMenu = this.vxN;
    String str = this.vtF.cFQ();
    if ((paramMenu.wep != null) && (!bk.bl(str))) {
      paramMenu.wep.setSelectedTag(str);
    }
    this.mController.contentView.postDelayed(new MediaHistoryListUI.1(this), 200L);
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.vtF.onDetach();
  }
  
  public final void onFinish()
  {
    y.i("MicroMsg.MediaHistoryListUI", "[onRefreshed]");
    finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 4)
    {
      finish();
      overridePendingTransition(0, 0);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void onKeyboardStateChanged()
  {
    super.onKeyboardStateChanged();
    if (this.mController.uNh == 2) {
      this.vxN.clearFocus();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.vxN.a(this, paramMenu);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI
 * JD-Core Version:    0.7.0.1
 */