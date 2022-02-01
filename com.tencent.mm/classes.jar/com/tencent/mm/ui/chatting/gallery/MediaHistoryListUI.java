package com.tencent.mm.ui.chatting.gallery;

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
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.e.b.a;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.chatting.presenter.d;
import com.tencent.mm.ui.chatting.presenter.g;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.s;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MediaHistoryListUI
  extends MMActivity
  implements b.b
{
  private b.a aeAe;
  private b aeFZ;
  private String lMU;
  private TextView lMW;
  private boolean lzR = false;
  private RecyclerView mRecyclerView;
  private ProgressDialog wQT;
  
  private void na(boolean paramBoolean)
  {
    AppMethodBeat.i(36391);
    Log.i("MicroMsg.MediaHistoryListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.wQT = w.a(this, getString(R.l.loading_tips), true, 0, null);
      AppMethodBeat.o(36391);
      return;
    }
    if ((this.wQT != null) && (this.wQT.isShowing()))
    {
      this.wQT.dismiss();
      this.wQT = null;
    }
    AppMethodBeat.o(36391);
  }
  
  public final void F(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36388);
    na(false);
    Log.i("MicroMsg.MediaHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.lMW.setVisibility(0);
      this.mRecyclerView.setVisibility(8);
      this.lMW.setText(getString(R.l.gzi));
      AppMethodBeat.o(36388);
      return;
    }
    this.lMW.setVisibility(8);
    this.mRecyclerView.setVisibility(0);
    this.mRecyclerView.getAdapter().bZE.notifyChanged();
    AppMethodBeat.o(36388);
  }
  
  public final void em(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36390);
    if (paramBoolean)
    {
      String str = getString(R.l.gzk, new Object[] { paramString });
      this.lMW.setVisibility(0);
      this.mRecyclerView.setVisibility(8);
      TextView localTextView = this.lMW;
      this.lMW.getContext();
      localTextView.setText(com.tencent.mm.plugin.fts.a.f.b(str, paramString));
      AppMethodBeat.o(36390);
      return;
    }
    this.lMW.setVisibility(8);
    this.mRecyclerView.setVisibility(0);
    AppMethodBeat.o(36390);
  }
  
  public int getLayoutId()
  {
    return R.i.glE;
  }
  
  public void initView()
  {
    AppMethodBeat.i(36380);
    this.lzR = getIntent().getBooleanExtra("detail_user_dismiss", false);
    this.aeFZ = new b();
    this.aeFZ.MY(false);
    this.aeFZ.a(this.aeAe.juT());
    this.aeFZ.pgU = false;
    this.lMW = ((TextView)findViewById(R.h.search_nothing_hint));
    this.mRecyclerView = ((RecyclerView)findViewById(R.h.history_recycler_view));
    findViewById(R.h.content_history).setBackgroundColor(getResources().getColor(R.e.BG_2));
    this.mRecyclerView.setBackgroundColor(getResources().getColor(R.e.BG_2));
    this.mRecyclerView.setLayoutManager(this.aeAe.juP());
    this.mRecyclerView.a(this.aeAe.juQ());
    this.mRecyclerView.setAdapter(this.aeAe.bBf(this.lMU));
    this.mRecyclerView.setHasFixedSize(true);
    setMMTitle(this.aeAe.bVz());
    AppMethodBeat.o(36380);
  }
  
  public final void juV()
  {
    AppMethodBeat.i(36387);
    na(true);
    AppMethodBeat.o(36387);
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
    int i = 2;
    AppMethodBeat.i(36379);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(R.h.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.lMU = getIntent().getStringExtra("kintent_talker");
    int j = getIntent().getIntExtra("key_media_type", -1);
    paramBundle = null;
    switch (j)
    {
    }
    while (paramBundle == null)
    {
      Log.e("MicroMsg.MediaHistoryListUI", "[onCreate] presenter is null!");
      AppMethodBeat.o(36379);
      return;
      paramBundle = new d(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.presenter.h(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.presenter.f(this);
      continue;
      paramBundle = new g(this);
      continue;
      paramBundle = new com.tencent.mm.ui.chatting.presenter.a(this);
    }
    paramBundle.a(this);
    setActionbarColor(androidx.core.content.a.w(getContext(), R.e.normal_actionbar_color));
    hideActionbarLine();
    initView();
    this.aeAe.juR();
    boolean bool = au.bwE(this.lMU);
    bh.bCz();
    paramBundle = c.bzK().Jv(this.lMU);
    if (bool)
    {
      com.tencent.mm.plugin.report.service.h localh;
      if (this.aeAe.getType() == 6)
      {
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        j = paramBundle.bHw().size();
        if (this.lzR) {}
        for (;;)
        {
          localh.b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(36379);
          return;
          i = 1;
        }
      }
      if (this.aeAe.getType() == -1)
      {
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        j = paramBundle.bHw().size();
        if (this.lzR) {}
        for (;;)
        {
          localh.b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(36379);
          return;
          i = 1;
        }
      }
      if (this.aeAe.getType() == 3)
      {
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        j = paramBundle.bHw().size();
        if (this.lzR) {}
        for (;;)
        {
          localh.b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(36379);
          return;
          i = 1;
        }
      }
      if (this.aeAe.getType() == 5)
      {
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        j = paramBundle.bHw().size();
        if (this.lzR) {}
        for (;;)
        {
          localh.b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(1) });
          AppMethodBeat.o(36379);
          return;
          i = 1;
        }
      }
      if (this.aeAe.getType() == 33)
      {
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        j = paramBundle.bHw().size();
        if (this.lzR) {}
        for (;;)
        {
          localh.b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(8) });
          AppMethodBeat.o(36379);
          return;
          i = 1;
        }
      }
    }
    else
    {
      if (this.aeAe.getType() == 6)
      {
        paramBundle = com.tencent.mm.plugin.report.service.h.OAn;
        if (this.lzR) {}
        for (;;)
        {
          paramBundle.b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
          AppMethodBeat.o(36379);
          return;
          i = 0;
        }
      }
      if (this.aeAe.getType() == -1)
      {
        paramBundle = com.tencent.mm.plugin.report.service.h.OAn;
        if (this.lzR) {}
        for (;;)
        {
          paramBundle.b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
          AppMethodBeat.o(36379);
          return;
          i = 0;
        }
      }
      if (this.aeAe.getType() == 3)
      {
        paramBundle = com.tencent.mm.plugin.report.service.h.OAn;
        if (this.lzR) {}
        for (;;)
        {
          paramBundle.b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i) });
          AppMethodBeat.o(36379);
          return;
          i = 0;
        }
      }
      if (this.aeAe.getType() == 5)
      {
        paramBundle = com.tencent.mm.plugin.report.service.h.OAn;
        if (this.lzR) {}
        for (;;)
        {
          paramBundle.b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(1) });
          AppMethodBeat.o(36379);
          return;
          i = 0;
        }
      }
      if (this.aeAe.getType() == 33)
      {
        paramBundle = com.tencent.mm.plugin.report.service.h.OAn;
        if (!this.lzR) {
          break label1529;
        }
      }
    }
    for (;;)
    {
      paramBundle.b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(8) });
      AppMethodBeat.o(36379);
      return;
      label1529:
      i = 0;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(36383);
    if (this.aeFZ != null)
    {
      this.aeFZ.a(this, paramMenu);
      paramMenu = this.aeFZ;
      String str = this.aeAe.juU();
      if ((paramMenu.afKy != null) && (!Util.isNullOrNil(str))) {
        paramMenu.afKy.setSelectedTag(str);
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
    this.aeAe.onDetach();
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
      this.aeFZ.clearFocus();
    }
    AppMethodBeat.o(36382);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(36384);
    this.aeFZ.a(this, paramMenu);
    AppMethodBeat.o(36384);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI
 * JD-Core Version:    0.7.0.1
 */