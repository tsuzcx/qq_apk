package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.f.b.a;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.chatting.l.d;
import com.tencent.mm.ui.chatting.l.g;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.t;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MediaHistoryListUI
  extends MMActivity
  implements b.b
{
  private b.a WQK;
  private b WWt;
  private String jkq;
  private TextView jks;
  private RecyclerView mRecyclerView;
  private ProgressDialog tND;
  
  private void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(36391);
    Log.i("MicroMsg.MediaHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.tND = s.a(this, getString(R.l.loading_tips), true, 0, null);
      AppMethodBeat.o(36391);
      return;
    }
    if ((this.tND != null) && (this.tND.isShowing()))
    {
      this.tND.dismiss();
      this.tND = null;
    }
    AppMethodBeat.o(36391);
  }
  
  public final void H(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36388);
    lG(false);
    Log.i("MicroMsg.MediaHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.jks.setVisibility(0);
      this.mRecyclerView.setVisibility(8);
      this.jks.setText(getString(R.l.ewF));
      AppMethodBeat.o(36388);
      return;
    }
    this.jks.setVisibility(8);
    this.mRecyclerView.setVisibility(0);
    this.mRecyclerView.getAdapter().alc.notifyChanged();
    AppMethodBeat.o(36388);
  }
  
  public final void dD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36390);
    if (paramBoolean)
    {
      String str = getString(R.l.ewH, new Object[] { paramString });
      this.jks.setVisibility(0);
      this.mRecyclerView.setVisibility(8);
      TextView localTextView = this.jks;
      this.jks.getContext();
      localTextView.setText(com.tencent.mm.plugin.fts.a.f.b(str, paramString));
      AppMethodBeat.o(36390);
      return;
    }
    this.jks.setVisibility(8);
    this.mRecyclerView.setVisibility(0);
    AppMethodBeat.o(36390);
  }
  
  public int getLayoutId()
  {
    return R.i.eiF;
  }
  
  public final void hRy()
  {
    AppMethodBeat.i(36387);
    lG(true);
    AppMethodBeat.o(36387);
  }
  
  public void initView()
  {
    AppMethodBeat.i(36380);
    this.WWt = new b();
    this.WWt.He(false);
    this.WWt.a(this.WQK.hRw());
    this.WWt.mni = false;
    this.jks = ((TextView)findViewById(R.h.search_nothing_hint));
    this.mRecyclerView = ((RecyclerView)findViewById(R.h.history_recycler_view));
    findViewById(R.h.content_history).setBackgroundColor(getResources().getColor(R.e.BG_2));
    this.mRecyclerView.setBackgroundColor(getResources().getColor(R.e.BG_2));
    this.mRecyclerView.setLayoutManager(this.WQK.hRs());
    this.mRecyclerView.a(this.WQK.hRt());
    this.mRecyclerView.setAdapter(this.WQK.bzt(this.jkq));
    this.mRecyclerView.setHasFixedSize(true);
    setMMTitle(this.WQK.bwJ());
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
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(R.h.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.jkq = getIntent().getStringExtra("kintent_talker");
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
      paramBundle = new d(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.l.h(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.l.f(this);
      continue;
      paramBundle = new g(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.l.a(this);
    }
    paramBundle.a(this);
    setActionbarColor(androidx.core.content.a.w(getContext(), R.e.normal_actionbar_color));
    hideActionbarLine();
    initView();
    this.WQK.hRu();
    boolean bool = ab.Lj(this.jkq);
    bh.beI();
    paramBundle = c.bbV().Rx(this.jkq);
    if (bool)
    {
      if (this.WQK.getType() == 6)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.bjL().size()), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.WQK.getType() == -1)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(paramBundle.bjL().size()), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.WQK.getType() == 3)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramBundle.bjL().size()), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.WQK.getType() == 5)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.bjL().size()), Integer.valueOf(1), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.WQK.getType() == 33)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramBundle.bjL().size()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(8) });
        AppMethodBeat.o(36379);
      }
    }
    else
    {
      if (this.WQK.getType() == 6)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.WQK.getType() == -1)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.WQK.getType() == 3)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.WQK.getType() == 5)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        AppMethodBeat.o(36379);
        return;
      }
      if (this.WQK.getType() == 33) {
        com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8) });
      }
    }
    AppMethodBeat.o(36379);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(36383);
    if (this.WWt != null)
    {
      this.WWt.a(this, paramMenu);
      paramMenu = this.WWt;
      String str = this.WQK.hRx();
      if ((paramMenu.XUk != null) && (!Util.isNullOrNil(str))) {
        paramMenu.XUk.setSelectedTag(str);
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
    this.WQK.onDetach();
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
      this.WWt.clearFocus();
    }
    AppMethodBeat.o(36382);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(36384);
    this.WWt.a(this, paramMenu);
    AppMethodBeat.o(36384);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI
 * JD-Core Version:    0.7.0.1
 */