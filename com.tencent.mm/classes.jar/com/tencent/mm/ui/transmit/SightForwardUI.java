package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.sight.base.f;
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
import com.tencent.mm.vfs.u;
import java.util.HashSet;

public class SightForwardUI
  extends MMActivity
{
  private MainSightForwardContainerView XYX;
  private String mPath;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.eiq;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39483);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    getSupportActionBar().hide();
    this.mPath = getIntent().getStringExtra("sight_local_path");
    if (!f.aYf(this.mPath))
    {
      Log.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", new Object[] { this.mPath });
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    if (!bh.aHB())
    {
      Log.e("MicroMsg.SightForwardUI", "acc not ready");
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    paramBundle = x.XR(String.valueOf(SystemClock.elapsedRealtime()));
    s.bqB();
    paramBundle = x.XT(paramBundle);
    if (u.on(this.mPath, paramBundle) <= 0L)
    {
      Log.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", new Object[] { this.mPath, paramBundle });
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    this.mPath = paramBundle;
    Log.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", new Object[] { this.mPath });
    this.XYX = ((MainSightForwardContainerView)findViewById(R.h.dHE));
    this.XYX.setIMainSightViewCallback(new SightForwardUI.1(this));
    paramBundle = this.XYX;
    Object localObject = this.mPath;
    paramBundle.Jvc = this;
    paramBundle.JuY = ((String)localObject);
    paramBundle.JuW = u.buc((String)localObject);
    long l = System.currentTimeMillis();
    paramBundle.JuZ = 1.333333F;
    paramBundle.JuP = ((SightCameraView)((ViewStub)paramBundle.findViewById(R.h.duT)).inflate());
    paramBundle.JuP.setTargetWidth(com.tencent.mm.pluginsdk.m.a.Fao);
    paramBundle.JuP.setFixPreviewRate(paramBundle.JuZ);
    paramBundle.JuP.setVisibility(0);
    paramBundle.JuT = paramBundle.findViewById(R.h.dXX);
    paramBundle.JuT.setLayoutParams(new RelativeLayout.LayoutParams(-1, getSupportActionBar().getHeight()));
    paramBundle.JuS = paramBundle.findViewById(R.h.dLT);
    paramBundle.EKB = paramBundle.findViewById(R.h.dLU);
    paramBundle.JuR = paramBundle.findViewById(R.h.duS);
    paramBundle.JuS.setOnClickListener(new MainSightForwardContainerView.1(paramBundle));
    paramBundle.EKB.setOnClickListener(new MainSightForwardContainerView.2(paramBundle));
    paramBundle.fJh();
    Log.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.XYX.fJg();
    paramBundle = this.XYX;
    if (paramBundle.JuO == null)
    {
      localObject = paramBundle.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject).widthPixels / paramBundle.JuZ;
      paramBundle.JuO = ((MainSightSelectContactView)paramBundle.findViewById(R.h.dTB));
      MainSightSelectContactView localMainSightSelectContactView = paramBundle.JuO;
      MMFragmentActivity localMMFragmentActivity = paramBundle.Jvc;
      int i = (int)(((DisplayMetrics)localObject).heightPixels - f);
      int j = ((DisplayMetrics)localObject).heightPixels;
      localMainSightSelectContactView.Jvc = localMMFragmentActivity;
      localMainSightSelectContactView.JvA = i;
      localMainSightSelectContactView.setMainSightContentView(paramBundle);
      localMainSightSelectContactView.addView(View.inflate(localMainSightSelectContactView.getContext(), R.i.eir, null), -1, -2);
      localMainSightSelectContactView.mListView = ((ListView)localMainSightSelectContactView.findViewById(R.h.select_contact_lv));
      localMainSightSelectContactView.JvD = new c(localMainSightSelectContactView);
      localMainSightSelectContactView.JvG = new LinearLayout(localMainSightSelectContactView.getContext());
      localMainSightSelectContactView.JvG.addView(new View(localMainSightSelectContactView.getContext()), -1, localMainSightSelectContactView.JvF.getViewHeight() - localMainSightSelectContactView.JvA);
      localMainSightSelectContactView.JvG.getChildAt(0).setBackgroundColor(0);
      localMainSightSelectContactView.mListView.addHeaderView(localMainSightSelectContactView.JvG);
      localMainSightSelectContactView.mListView.setAdapter(localMainSightSelectContactView.JvD);
      localMainSightSelectContactView.mListView.setOnItemClickListener(paramBundle);
      localMainSightSelectContactView.JvK = new HashSet();
      localMainSightSelectContactView.JvL = new HashSet();
      localMainSightSelectContactView.mListView.setOnScrollListener(localMainSightSelectContactView);
      localMainSightSelectContactView.JvB = new d();
      localMainSightSelectContactView.JvB.Jvw = localMainSightSelectContactView;
      paramBundle.JuO.setSearchView(paramBundle.findViewById(R.h.dTs));
      paramBundle.JuO.setEmptyBgView(paramBundle.findViewById(R.h.dFu));
      paramBundle.JuO.setMainSightContentView(paramBundle);
    }
    paramBundle.yg(true);
    paramBundle.JuP.postDelayed(new MainSightForwardContainerView.3(paramBundle), 50L);
    AppMethodBeat.o(39483);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39485);
    super.onPause();
    this.XYX.onPause();
    AppMethodBeat.o(39485);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39484);
    super.onResume();
    this.XYX.onResume();
    AppMethodBeat.o(39484);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SightForwardUI
 * JD-Core Version:    0.7.0.1
 */