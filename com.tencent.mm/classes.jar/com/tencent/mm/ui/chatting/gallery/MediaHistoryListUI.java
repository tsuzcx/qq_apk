package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.e.b.a;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.chatting.i.g;
import com.tencent.mm.ui.tools.q;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MediaHistoryListUI
  extends MMActivity
  implements b.b
{
  private RecyclerView adt;
  private String ejr;
  private TextView ejt;
  private ProgressDialog kFY;
  private b.a zJG;
  private com.tencent.mm.modelvoiceaddr.ui.b zNZ;
  
  private void fV(boolean paramBoolean)
  {
    AppMethodBeat.i(32451);
    ab.i("MicroMsg.MediaHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.kFY = p.b(this, getString(2131301086), true, null);
      AppMethodBeat.o(32451);
      return;
    }
    if ((this.kFY != null) && (this.kFY.isShowing()))
    {
      this.kFY.dismiss();
      this.kFY = null;
    }
    AppMethodBeat.o(32451);
  }
  
  public final void co(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(32450);
    if (paramBoolean)
    {
      String str = getString(2131298292, new Object[] { paramString });
      this.ejt.setVisibility(0);
      this.adt.setVisibility(8);
      TextView localTextView = this.ejt;
      this.ejt.getContext();
      localTextView.setText(com.tencent.mm.plugin.fts.a.f.a(str, paramString));
      AppMethodBeat.o(32450);
      return;
    }
    this.ejt.setVisibility(8);
    this.adt.setVisibility(0);
    AppMethodBeat.o(32450);
  }
  
  public final void dJU()
  {
    AppMethodBeat.i(32447);
    fV(true);
    AppMethodBeat.o(32447);
  }
  
  public int getLayoutId()
  {
    return 2130970131;
  }
  
  public void initView()
  {
    AppMethodBeat.i(32440);
    this.zNZ = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.zNZ.ru(false);
    this.zNZ.a(this.zJG.dJS());
    this.zNZ.gcJ = false;
    this.ejt = ((TextView)findViewById(2131821515));
    this.adt = ((RecyclerView)findViewById(2131821516));
    findViewById(2131821514).setBackgroundColor(-1);
    this.adt.setBackgroundColor(-1);
    this.adt.setLayoutManager(this.zJG.bgA());
    this.adt.a(this.zJG.dJP());
    this.adt.setAdapter(this.zJG.auc(this.ejr));
    this.adt.setHasFixedSize(true);
    setMMTitle(this.zJG.apc());
    AppMethodBeat.o(32440);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(32446);
    super.onBackPressed();
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(32446);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32439);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131820956), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.ejr = getIntent().getStringExtra("kintent_talker");
    int i = getIntent().getIntExtra("key_media_type", -1);
    paramBundle = null;
    switch (i)
    {
    }
    while (paramBundle == null)
    {
      ab.e("MicroMsg.MediaHistoryListUI", "[onCreate] presenter is null!");
      AppMethodBeat.o(32439);
      return;
      paramBundle = new com.tencent.mm.ui.chatting.i.d(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.i.h(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.i.f(this);
      continue;
      paramBundle = new g(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.i.a(this);
    }
    paramBundle.a(this);
    setActionbarColor(android.support.v4.content.b.m(getContext(), 2131690316));
    hideActionbarLine();
    initView();
    this.zJG.dJQ();
    boolean bool = t.lA(this.ejr);
    aw.aaz();
    paramBundle = c.YJ().oV(this.ejr);
    if (bool)
    {
      if (this.zJG.getType() == 6)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.afx().size()), Integer.valueOf(1) });
        AppMethodBeat.o(32439);
        return;
      }
      if (this.zJG.getType() == -1)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(paramBundle.afx().size()), Integer.valueOf(1) });
        AppMethodBeat.o(32439);
        return;
      }
      if (this.zJG.getType() == 3)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramBundle.afx().size()), Integer.valueOf(1) });
        AppMethodBeat.o(32439);
        return;
      }
      if (this.zJG.getType() == 5)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.afx().size()), Integer.valueOf(1), Integer.valueOf(1) });
        AppMethodBeat.o(32439);
        return;
      }
      if (this.zJG.getType() == 33)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.afx().size()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(8) });
        AppMethodBeat.o(32439);
      }
    }
    else
    {
      if (this.zJG.getType() == 6)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(32439);
        return;
      }
      if (this.zJG.getType() == -1)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(32439);
        return;
      }
      if (this.zJG.getType() == 3)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(32439);
        return;
      }
      if (this.zJG.getType() == 5)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        AppMethodBeat.o(32439);
        return;
      }
      if (this.zJG.getType() == 33) {
        com.tencent.mm.plugin.report.service.h.qsU.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8) });
      }
    }
    AppMethodBeat.o(32439);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(32443);
    this.zNZ.a(this, paramMenu);
    paramMenu = this.zNZ;
    String str = this.zJG.dJT();
    if ((paramMenu.Axf != null) && (!bo.isNullOrNil(str))) {
      paramMenu.Axf.setSelectedTag(str);
    }
    getContentView().postDelayed(new MediaHistoryListUI.1(this), 200L);
    AppMethodBeat.o(32443);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32441);
    super.onDestroy();
    this.zJG.onDetach();
    AppMethodBeat.o(32441);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(32449);
    ab.i("MicroMsg.MediaHistoryListUI", "[onRefreshed]");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(32449);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(32445);
    if (paramKeyEvent.getAction() == 4)
    {
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(32445);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(32445);
    return bool;
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(32442);
    super.onKeyboardStateChanged();
    if (keyboardState() == 2) {
      this.zNZ.clearFocus();
    }
    AppMethodBeat.o(32442);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(32444);
    this.zNZ.a(this, paramMenu);
    AppMethodBeat.o(32444);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void s(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(32448);
    fV(false);
    ab.i("MicroMsg.MediaHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.ejt.setVisibility(0);
      this.adt.setVisibility(8);
      this.ejt.setText(getString(2131298288));
      AppMethodBeat.o(32448);
      return;
    }
    this.ejt.setVisibility(8);
    this.adt.setVisibility(0);
    this.adt.getAdapter().ajb.notifyChanged();
    AppMethodBeat.o(32448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI
 * JD-Core Version:    0.7.0.1
 */