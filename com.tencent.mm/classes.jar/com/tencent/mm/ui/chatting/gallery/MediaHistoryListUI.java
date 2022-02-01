package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.f.b.a;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.chatting.k.h;
import com.tencent.mm.ui.tools.r;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MediaHistoryListUI
  extends MMActivity
  implements b.b
{
  private b.a Kkt;
  private com.tencent.mm.modelvoiceaddr.ui.b Kps;
  private RecyclerView anl;
  private String fVg;
  private TextView fVi;
  private ProgressDialog oZW;
  
  private void js(boolean paramBoolean)
  {
    AppMethodBeat.i(36391);
    ae.i("MicroMsg.MediaHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.oZW = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(36391);
      return;
    }
    if ((this.oZW != null) && (this.oZW.isShowing()))
    {
      this.oZW.dismiss();
      this.oZW = null;
    }
    AppMethodBeat.o(36391);
  }
  
  public final void C(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36388);
    js(false);
    ae.i("MicroMsg.MediaHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.fVi.setVisibility(0);
      this.anl.setVisibility(8);
      this.fVi.setText(getString(2131757279));
      AppMethodBeat.o(36388);
      return;
    }
    this.fVi.setVisibility(8);
    this.anl.setVisibility(0);
    this.anl.getAdapter().asY.notifyChanged();
    AppMethodBeat.o(36388);
  }
  
  public final void cW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36390);
    if (paramBoolean)
    {
      String str = getString(2131757283, new Object[] { paramString });
      this.fVi.setVisibility(0);
      this.anl.setVisibility(8);
      TextView localTextView = this.fVi;
      this.fVi.getContext();
      localTextView.setText(com.tencent.mm.plugin.fts.a.f.b(str, paramString));
      AppMethodBeat.o(36390);
      return;
    }
    this.fVi.setVisibility(8);
    this.anl.setVisibility(0);
    AppMethodBeat.o(36390);
  }
  
  public final void fJP()
  {
    AppMethodBeat.i(36387);
    js(true);
    AppMethodBeat.o(36387);
  }
  
  public int getLayoutId()
  {
    return 2131494749;
  }
  
  public void initView()
  {
    AppMethodBeat.i(36380);
    this.Kps = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.Kps.yP(false);
    this.Kps.a(this.Kkt.fJN());
    this.Kps.iCq = false;
    this.fVi = ((TextView)findViewById(2131304436));
    this.anl = ((RecyclerView)findViewById(2131300757));
    findViewById(2131298757).setBackgroundColor(getResources().getColor(2131099650));
    this.anl.setBackgroundColor(getResources().getColor(2131099650));
    this.anl.setLayoutManager(this.Kkt.caQ());
    this.anl.a(this.Kkt.fJK());
    this.anl.setAdapter(this.Kkt.aXN(this.fVg));
    this.anl.setHasFixedSize(true);
    setMMTitle(this.Kkt.aRV());
    AppMethodBeat.o(36380);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(36386);
    super.onBackPressed();
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(36386);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(36379);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296345), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.fVg = getIntent().getStringExtra("kintent_talker");
    int i = getIntent().getIntExtra("key_media_type", -1);
    paramBundle = null;
    switch (i)
    {
    }
    while (paramBundle == null)
    {
      ae.e("MicroMsg.MediaHistoryListUI", "[onCreate] presenter is null!");
      AppMethodBeat.o(36379);
      return;
      paramBundle = new com.tencent.mm.ui.chatting.k.d(this);
      continue;
      paramBundle = new h(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.k.f(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.k.g(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.k.a(this);
    }
    paramBundle.a(this);
    setActionbarColor(android.support.v4.content.b.n(getContext(), 2131100705));
    hideActionbarLine();
    initView();
    this.Kkt.fJL();
    boolean bool = x.wb(this.fVg);
    bc.aCg();
    paramBundle = c.azP().By(this.fVg);
    if (bool)
    {
      if (this.Kkt.getType() == 6)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.aGE().size()), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Kkt.getType() == -1)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(paramBundle.aGE().size()), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Kkt.getType() == 3)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramBundle.aGE().size()), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Kkt.getType() == 5)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.aGE().size()), Integer.valueOf(1), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Kkt.getType() == 33)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.aGE().size()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(8) });
        AppMethodBeat.o(36379);
      }
    }
    else
    {
      if (this.Kkt.getType() == 6)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Kkt.getType() == -1)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Kkt.getType() == 3)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Kkt.getType() == 5)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Kkt.getType() == 33) {
        com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8) });
      }
    }
    AppMethodBeat.o(36379);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(36383);
    this.Kps.a(this, paramMenu);
    paramMenu = this.Kps;
    String str = this.Kkt.fJO();
    if ((paramMenu.Lhj != null) && (!bu.isNullOrNil(str))) {
      paramMenu.Lhj.setSelectedTag(str);
    }
    getContentView().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36378);
        MediaHistoryListUI.a(MediaHistoryListUI.this).clearFocus();
        AppMethodBeat.o(36378);
      }
    }, 200L);
    AppMethodBeat.o(36383);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(36381);
    super.onDestroy();
    this.Kkt.onDetach();
    AppMethodBeat.o(36381);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(36389);
    ae.i("MicroMsg.MediaHistoryListUI", "[onRefreshed]");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(36389);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(36385);
    if (paramKeyEvent.getAction() == 4)
    {
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(36385);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(36385);
    return bool;
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(36382);
    super.onKeyboardStateChanged();
    if (keyboardState() == 2) {
      this.Kps.clearFocus();
    }
    AppMethodBeat.o(36382);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(36384);
    this.Kps.a(this, paramMenu);
    AppMethodBeat.o(36384);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI
 * JD-Core Version:    0.7.0.1
 */