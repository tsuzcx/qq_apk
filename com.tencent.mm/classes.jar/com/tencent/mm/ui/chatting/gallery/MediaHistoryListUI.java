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
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.e.b.a;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.chatting.j.g;
import com.tencent.mm.ui.tools.r;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MediaHistoryListUI
  extends MMActivity
  implements b.b
{
  private b.a HZS;
  private com.tencent.mm.modelvoiceaddr.ui.b Ier;
  private RecyclerView alu;
  private String fzK;
  private TextView fzM;
  private ProgressDialog opZ;
  
  private void ji(boolean paramBoolean)
  {
    AppMethodBeat.i(36391);
    ac.i("MicroMsg.MediaHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.opZ = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(36391);
      return;
    }
    if ((this.opZ != null) && (this.opZ.isShowing()))
    {
      this.opZ.dismiss();
      this.opZ = null;
    }
    AppMethodBeat.o(36391);
  }
  
  public final void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36388);
    ji(false);
    ac.i("MicroMsg.MediaHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.fzM.setVisibility(0);
      this.alu.setVisibility(8);
      this.fzM.setText(getString(2131757279));
      AppMethodBeat.o(36388);
      return;
    }
    this.fzM.setVisibility(8);
    this.alu.setVisibility(0);
    this.alu.getAdapter().arg.notifyChanged();
    AppMethodBeat.o(36388);
  }
  
  public final void cN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36390);
    if (paramBoolean)
    {
      String str = getString(2131757283, new Object[] { paramString });
      this.fzM.setVisibility(0);
      this.alu.setVisibility(8);
      TextView localTextView = this.fzM;
      this.fzM.getContext();
      localTextView.setText(com.tencent.mm.plugin.fts.a.f.b(str, paramString));
      AppMethodBeat.o(36390);
      return;
    }
    this.fzM.setVisibility(8);
    this.alu.setVisibility(0);
    AppMethodBeat.o(36390);
  }
  
  public final void fpd()
  {
    AppMethodBeat.i(36387);
    ji(true);
    AppMethodBeat.o(36387);
  }
  
  public int getLayoutId()
  {
    return 2131494749;
  }
  
  public void initView()
  {
    AppMethodBeat.i(36380);
    this.Ier = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.Ier.xO(false);
    this.Ier.a(this.HZS.fpb());
    this.Ier.igd = false;
    this.fzM = ((TextView)findViewById(2131304436));
    this.alu = ((RecyclerView)findViewById(2131300757));
    findViewById(2131298757).setBackgroundColor(getResources().getColor(2131099650));
    this.alu.setBackgroundColor(getResources().getColor(2131099650));
    this.alu.setLayoutManager(this.HZS.bUW());
    this.alu.a(this.HZS.foY());
    this.alu.setAdapter(this.HZS.aQt(this.fzK));
    this.alu.setHasFixedSize(true);
    setMMTitle(this.HZS.aOk());
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
    this.fzK = getIntent().getStringExtra("kintent_talker");
    int i = getIntent().getIntExtra("key_media_type", -1);
    paramBundle = null;
    switch (i)
    {
    }
    while (paramBundle == null)
    {
      ac.e("MicroMsg.MediaHistoryListUI", "[onCreate] presenter is null!");
      AppMethodBeat.o(36379);
      return;
      paramBundle = new com.tencent.mm.ui.chatting.j.d(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.j.h(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.j.f(this);
      continue;
      paramBundle = new g(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.j.a(this);
    }
    paramBundle.a(this);
    setActionbarColor(android.support.v4.content.b.n(getContext(), 2131100705));
    hideActionbarLine();
    initView();
    this.HZS.foZ();
    boolean bool = w.sQ(this.fzK);
    az.ayM();
    paramBundle = c.awK().xO(this.fzK);
    if (bool)
    {
      if (this.HZS.getType() == 6)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.aDl().size()), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.HZS.getType() == -1)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(paramBundle.aDl().size()), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.HZS.getType() == 3)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramBundle.aDl().size()), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.HZS.getType() == 5)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.aDl().size()), Integer.valueOf(1), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.HZS.getType() == 33)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.aDl().size()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(8) });
        AppMethodBeat.o(36379);
      }
    }
    else
    {
      if (this.HZS.getType() == 6)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.HZS.getType() == -1)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.HZS.getType() == 3)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.HZS.getType() == 5)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.HZS.getType() == 33) {
        com.tencent.mm.plugin.report.service.h.wUl.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8) });
      }
    }
    AppMethodBeat.o(36379);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(36383);
    this.Ier.a(this, paramMenu);
    paramMenu = this.Ier;
    String str = this.HZS.fpc();
    if ((paramMenu.ITL != null) && (!bs.isNullOrNil(str))) {
      paramMenu.ITL.setSelectedTag(str);
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
    this.HZS.onDetach();
    AppMethodBeat.o(36381);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(36389);
    ac.i("MicroMsg.MediaHistoryListUI", "[onRefreshed]");
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
      this.Ier.clearFocus();
    }
    AppMethodBeat.o(36382);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(36384);
    this.Ier.a(this, paramMenu);
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