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
import com.tencent.mm.model.ba;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vfs.i;
import java.util.HashSet;

public class SightForwardUI
  extends MMActivity
{
  private MainSightForwardContainerView KOS;
  private String mPath;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494682;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39483);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    getSupportActionBar().hide();
    this.mPath = getIntent().getStringExtra("sight_local_path");
    if (!e.axw(this.mPath))
    {
      ad.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", new Object[] { this.mPath });
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    if (!ba.ajx())
    {
      ad.e("MicroMsg.SightForwardUI", "acc not ready");
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    paramBundle = t.Hf(String.valueOf(SystemClock.elapsedRealtime()));
    o.aMJ();
    paramBundle = t.Hh(paramBundle);
    if (i.mz(this.mPath, paramBundle) <= 0L)
    {
      ad.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", new Object[] { this.mPath, paramBundle });
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    this.mPath = paramBundle;
    ad.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", new Object[] { this.mPath });
    this.KOS = ((MainSightForwardContainerView)findViewById(2131300232));
    this.KOS.setIMainSightViewCallback(new SightForwardUI.1(this));
    paramBundle = this.KOS;
    Object localObject = this.mPath;
    paramBundle.mWg = this;
    paramBundle.yUt = ((String)localObject);
    paramBundle.yUr = i.aPK((String)localObject);
    long l = System.currentTimeMillis();
    paramBundle.yUu = 1.333333F;
    paramBundle.yUk = ((SightCameraView)((ViewStub)paramBundle.findViewById(2131297684)).inflate());
    paramBundle.yUk.setTargetWidth(com.tencent.mm.pluginsdk.l.a.vOH);
    paramBundle.yUk.setFixPreviewRate(paramBundle.yUu);
    paramBundle.yUk.setVisibility(0);
    paramBundle.yUo = paramBundle.findViewById(2131306023);
    paramBundle.yUo.setLayoutParams(new RelativeLayout.LayoutParams(-1, getSupportActionBar().getHeight()));
    paramBundle.yUn = paramBundle.findViewById(2131301993);
    paramBundle.vyo = paramBundle.findViewById(2131301994);
    paramBundle.yUm = paramBundle.findViewById(2131297682);
    paramBundle.yUn.setOnClickListener(new MainSightForwardContainerView.1(paramBundle));
    paramBundle.vyo.setOnClickListener(new MainSightForwardContainerView.2(paramBundle));
    paramBundle.dQH();
    ad.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.KOS.dQG();
    paramBundle = this.KOS;
    if (paramBundle.yUj == null)
    {
      localObject = paramBundle.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject).widthPixels / paramBundle.yUu;
      paramBundle.yUj = ((MainSightSelectContactView)paramBundle.findViewById(2131304509));
      MainSightSelectContactView localMainSightSelectContactView = paramBundle.yUj;
      MMFragmentActivity localMMFragmentActivity = paramBundle.mWg;
      int i = (int)(((DisplayMetrics)localObject).heightPixels - f);
      int j = ((DisplayMetrics)localObject).heightPixels;
      localMainSightSelectContactView.mWg = localMMFragmentActivity;
      localMainSightSelectContactView.yUU = i;
      localMainSightSelectContactView.setMainSightContentView(paramBundle);
      localMainSightSelectContactView.addView(View.inflate(localMainSightSelectContactView.getContext(), 2131494683, null), -1, -2);
      localMainSightSelectContactView.mListView = ((ListView)localMainSightSelectContactView.findViewById(2131304508));
      localMainSightSelectContactView.yUX = new c(localMainSightSelectContactView);
      localMainSightSelectContactView.yVa = new LinearLayout(localMainSightSelectContactView.getContext());
      localMainSightSelectContactView.yVa.addView(new View(localMainSightSelectContactView.getContext()), -1, localMainSightSelectContactView.yUZ.getViewHeight() - localMainSightSelectContactView.yUU);
      localMainSightSelectContactView.yVa.getChildAt(0).setBackgroundColor(0);
      localMainSightSelectContactView.mListView.addHeaderView(localMainSightSelectContactView.yVa);
      localMainSightSelectContactView.mListView.setAdapter(localMainSightSelectContactView.yUX);
      localMainSightSelectContactView.mListView.setOnItemClickListener(paramBundle);
      localMainSightSelectContactView.yVe = new HashSet();
      localMainSightSelectContactView.yVf = new HashSet();
      localMainSightSelectContactView.mListView.setOnScrollListener(localMainSightSelectContactView);
      localMainSightSelectContactView.yUV = new d();
      localMainSightSelectContactView.yUV.yUQ = localMainSightSelectContactView;
      paramBundle.yUj.setSearchView(paramBundle.findViewById(2131304452));
      paramBundle.yUj.setEmptyBgView(paramBundle.findViewById(2131299459));
      paramBundle.yUj.setMainSightContentView(paramBundle);
    }
    paramBundle.rg(true);
    paramBundle.yUk.postDelayed(new MainSightForwardContainerView.3(paramBundle), 50L);
    AppMethodBeat.o(39483);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39485);
    super.onPause();
    this.KOS.onPause();
    AppMethodBeat.o(39485);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39484);
    super.onResume();
    this.KOS.onResume();
    AppMethodBeat.o(39484);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SightForwardUI
 * JD-Core Version:    0.7.0.1
 */