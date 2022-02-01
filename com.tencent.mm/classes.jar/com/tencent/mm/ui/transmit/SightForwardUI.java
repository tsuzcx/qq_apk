package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.1;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.2;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.3;
import com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView;
import com.tencent.mm.plugin.sight.encode.ui.SightCameraView;
import com.tencent.mm.plugin.sight.encode.ui.c;
import com.tencent.mm.plugin.sight.encode.ui.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vfs.s;
import java.util.HashSet;

public class SightForwardUI
  extends MMActivity
{
  private MainSightForwardContainerView QAy;
  private String mPath;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495408;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39483);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    getSupportActionBar().hide();
    this.mPath = getIntent().getStringExtra("sight_local_path");
    if (!e.aNw(this.mPath))
    {
      Log.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", new Object[] { this.mPath });
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    if (!bg.aAc())
    {
      Log.e("MicroMsg.SightForwardUI", "acc not ready");
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    paramBundle = t.Qu(String.valueOf(SystemClock.elapsedRealtime()));
    o.bhj();
    paramBundle = t.Qw(paramBundle);
    if (s.nw(this.mPath, paramBundle) <= 0L)
    {
      Log.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", new Object[] { this.mPath, paramBundle });
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    this.mPath = paramBundle;
    Log.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", new Object[] { this.mPath });
    this.QAy = ((MainSightForwardContainerView)findViewById(2131301706));
    this.QAy.setIMainSightViewCallback(new SightForwardUI.1(this));
    paramBundle = this.QAy;
    Object localObject = this.mPath;
    paramBundle.Dpx = this;
    paramBundle.Dpt = ((String)localObject);
    paramBundle.Dpr = s.bhK((String)localObject);
    long l = System.currentTimeMillis();
    paramBundle.Dpu = 1.333333F;
    paramBundle.Dpk = ((SightCameraView)((ViewStub)paramBundle.findViewById(2131297956)).inflate());
    paramBundle.Dpk.setTargetWidth(com.tencent.mm.pluginsdk.l.a.zuP);
    paramBundle.Dpk.setFixPreviewRate(paramBundle.Dpu);
    paramBundle.Dpk.setVisibility(0);
    paramBundle.Dpo = paramBundle.findViewById(2131309335);
    paramBundle.Dpo.setLayoutParams(new RelativeLayout.LayoutParams(-1, getSupportActionBar().getHeight()));
    paramBundle.Dpn = paramBundle.findViewById(2131304331);
    paramBundle.zfy = paramBundle.findViewById(2131304332);
    paramBundle.Dpm = paramBundle.findViewById(2131297954);
    paramBundle.Dpn.setOnClickListener(new MainSightForwardContainerView.1(paramBundle));
    paramBundle.zfy.setOnClickListener(new MainSightForwardContainerView.2(paramBundle));
    paramBundle.eWe();
    Log.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.QAy.eWd();
    paramBundle = this.QAy;
    if (paramBundle.Dpj == null)
    {
      localObject = paramBundle.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject).widthPixels / paramBundle.Dpu;
      paramBundle.Dpj = ((MainSightSelectContactView)paramBundle.findViewById(2131307515));
      MainSightSelectContactView localMainSightSelectContactView = paramBundle.Dpj;
      MMFragmentActivity localMMFragmentActivity = paramBundle.Dpx;
      int i = (int)(((DisplayMetrics)localObject).heightPixels - f);
      int j = ((DisplayMetrics)localObject).heightPixels;
      localMainSightSelectContactView.Dpx = localMMFragmentActivity;
      localMainSightSelectContactView.DpV = i;
      localMainSightSelectContactView.setMainSightContentView(paramBundle);
      localMainSightSelectContactView.addView(View.inflate(localMainSightSelectContactView.getContext(), 2131495409, null), -1, -2);
      localMainSightSelectContactView.mListView = ((ListView)localMainSightSelectContactView.findViewById(2131307514));
      localMainSightSelectContactView.DpY = new c(localMainSightSelectContactView);
      localMainSightSelectContactView.Dqb = new LinearLayout(localMainSightSelectContactView.getContext());
      localMainSightSelectContactView.Dqb.addView(new View(localMainSightSelectContactView.getContext()), -1, localMainSightSelectContactView.Dqa.getViewHeight() - localMainSightSelectContactView.DpV);
      localMainSightSelectContactView.Dqb.getChildAt(0).setBackgroundColor(0);
      localMainSightSelectContactView.mListView.addHeaderView(localMainSightSelectContactView.Dqb);
      localMainSightSelectContactView.mListView.setAdapter(localMainSightSelectContactView.DpY);
      localMainSightSelectContactView.mListView.setOnItemClickListener(paramBundle);
      localMainSightSelectContactView.Dqf = new HashSet();
      localMainSightSelectContactView.Dqg = new HashSet();
      localMainSightSelectContactView.mListView.setOnScrollListener(localMainSightSelectContactView);
      localMainSightSelectContactView.DpW = new d();
      localMainSightSelectContactView.DpW.DpR = localMainSightSelectContactView;
      paramBundle.Dpj.setSearchView(paramBundle.findViewById(2131307428));
      paramBundle.Dpj.setEmptyBgView(paramBundle.findViewById(2131300080));
      paramBundle.Dpj.setMainSightContentView(paramBundle);
    }
    paramBundle.uI(true);
    paramBundle.Dpk.postDelayed(new MainSightForwardContainerView.3(paramBundle), 50L);
    AppMethodBeat.o(39483);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39485);
    super.onPause();
    this.QAy.onPause();
    AppMethodBeat.o(39485);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39484);
    super.onResume();
    this.QAy.onResume();
    AppMethodBeat.o(39484);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SightForwardUI
 * JD-Core Version:    0.7.0.1
 */