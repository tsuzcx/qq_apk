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
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.f.b.a;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.chatting.k.g;
import com.tencent.mm.ui.tools.s;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MediaHistoryListUI
  extends MMActivity
  implements b.b
{
  private com.tencent.mm.modelvoiceaddr.ui.b PBw;
  private b.a Pws;
  private String gAn;
  private TextView gAp;
  private RecyclerView mRecyclerView;
  private ProgressDialog qoU;
  
  private void ku(boolean paramBoolean)
  {
    AppMethodBeat.i(36391);
    Log.i("MicroMsg.MediaHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.qoU = q.a(this, getString(2131762446), true, 0, null);
      AppMethodBeat.o(36391);
      return;
    }
    if ((this.qoU != null) && (this.qoU.isShowing()))
    {
      this.qoU.dismiss();
      this.qoU = null;
    }
    AppMethodBeat.o(36391);
  }
  
  public final void D(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36388);
    ku(false);
    Log.i("MicroMsg.MediaHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.gAp.setVisibility(0);
      this.mRecyclerView.setVisibility(8);
      this.gAp.setText(getString(2131757493));
      AppMethodBeat.o(36388);
      return;
    }
    this.gAp.setVisibility(8);
    this.mRecyclerView.setVisibility(0);
    this.mRecyclerView.getAdapter().atj.notifyChanged();
    AppMethodBeat.o(36388);
  }
  
  public final void dr(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36390);
    if (paramBoolean)
    {
      String str = getString(2131757497, new Object[] { paramString });
      this.gAp.setVisibility(0);
      this.mRecyclerView.setVisibility(8);
      TextView localTextView = this.gAp;
      this.gAp.getContext();
      localTextView.setText(com.tencent.mm.plugin.fts.a.f.b(str, paramString));
      AppMethodBeat.o(36390);
      return;
    }
    this.gAp.setVisibility(8);
    this.mRecyclerView.setVisibility(0);
    AppMethodBeat.o(36390);
  }
  
  public final void gSc()
  {
    AppMethodBeat.i(36387);
    ku(true);
    AppMethodBeat.o(36387);
  }
  
  public int getLayoutId()
  {
    return 2131495478;
  }
  
  public void initView()
  {
    AppMethodBeat.i(36380);
    this.PBw = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.PBw.CK(false);
    this.PBw.a(this.Pws.gSa());
    this.PBw.jxF = false;
    this.gAp = ((TextView)findViewById(2131307411));
    this.mRecyclerView = ((RecyclerView)findViewById(2131302345));
    findViewById(2131299200).setBackgroundColor(getResources().getColor(2131099650));
    this.mRecyclerView.setBackgroundColor(getResources().getColor(2131099650));
    this.mRecyclerView.setLayoutManager(this.Pws.gRW());
    this.mRecyclerView.a(this.Pws.gRX());
    this.mRecyclerView.setAdapter(this.Pws.bmS(this.gAn));
    this.mRecyclerView.setHasFixedSize(true);
    setMMTitle(this.Pws.bmB());
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
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296366), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.gAn = getIntent().getStringExtra("kintent_talker");
    int i = getIntent().getIntExtra("key_media_type", -1);
    paramBundle = null;
    switch (i)
    {
    }
    while (paramBundle == null)
    {
      Log.e("MicroMsg.MediaHistoryListUI", "[onCreate] presenter is null!");
      AppMethodBeat.o(36379);
      return;
      paramBundle = new com.tencent.mm.ui.chatting.k.d(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.k.h(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.k.f(this);
      continue;
      paramBundle = new g(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.k.a(this);
    }
    paramBundle.a(this);
    setActionbarColor(android.support.v4.content.b.n(getContext(), 2131100898));
    hideActionbarLine();
    initView();
    this.Pws.gRY();
    boolean bool = ab.Eq(this.gAn);
    bg.aVF();
    paramBundle = c.aSX().Ke(this.gAn);
    if (bool)
    {
      if (this.Pws.getType() == 6)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.bax().size()), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Pws.getType() == -1)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(paramBundle.bax().size()), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Pws.getType() == 3)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramBundle.bax().size()), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Pws.getType() == 5)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.bax().size()), Integer.valueOf(1), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Pws.getType() == 33)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.bax().size()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(8) });
        AppMethodBeat.o(36379);
      }
    }
    else
    {
      if (this.Pws.getType() == 6)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Pws.getType() == -1)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Pws.getType() == 3)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Pws.getType() == 5)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.Pws.getType() == 33) {
        com.tencent.mm.plugin.report.service.h.CyF.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8) });
      }
    }
    AppMethodBeat.o(36379);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(36383);
    if (this.PBw != null)
    {
      this.PBw.a(this, paramMenu);
      paramMenu = this.PBw;
      String str = this.Pws.gSb();
      if ((paramMenu.Qwh != null) && (!Util.isNullOrNil(str))) {
        paramMenu.Qwh.setSelectedTag(str);
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
    AppMethodBeat.o(36383);
    return false;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(36381);
    super.onDestroy();
    this.Pws.onDetach();
    AppMethodBeat.o(36381);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(36389);
    Log.i("MicroMsg.MediaHistoryListUI", "[onRefreshed]");
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
      this.PBw.clearFocus();
    }
    AppMethodBeat.o(36382);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(36384);
    this.PBw.a(this, paramMenu);
    AppMethodBeat.o(36384);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI
 * JD-Core Version:    0.7.0.1
 */