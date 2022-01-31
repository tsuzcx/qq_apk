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
import com.tencent.mm.a.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.1;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.2;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.3;
import com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView;
import com.tencent.mm.plugin.sight.encode.ui.SightCameraView;
import com.tencent.mm.plugin.sight.encode.ui.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vfs.e;
import java.util.HashSet;

public class SightForwardUI
  extends MMActivity
{
  private MainSightForwardContainerView AAW;
  private String mPath;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130970068;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35276);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    getSupportActionBar().hide();
    this.mPath = getIntent().getStringExtra("sight_local_path");
    if (!com.tencent.mm.plugin.sight.base.d.Zn(this.mPath))
    {
      ab.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", new Object[] { this.mPath });
      finish();
      AppMethodBeat.o(35276);
      return;
    }
    if (!aw.RG())
    {
      ab.e("MicroMsg.SightForwardUI", "acc not ready");
      finish();
      AppMethodBeat.o(35276);
      return;
    }
    paramBundle = t.ve(String.valueOf(SystemClock.elapsedRealtime()));
    o.alE();
    paramBundle = t.vf(paramBundle);
    if (e.C(this.mPath, paramBundle) <= 0L)
    {
      ab.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", new Object[] { this.mPath, paramBundle });
      finish();
      AppMethodBeat.o(35276);
      return;
    }
    this.mPath = paramBundle;
    ab.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", new Object[] { this.mPath });
    this.AAW = ((MainSightForwardContainerView)findViewById(2131825889));
    this.AAW.setIMainSightViewCallback(new SightForwardUI.1(this));
    paramBundle = this.AAW;
    Object localObject = this.mPath;
    paramBundle.jdB = this;
    paramBundle.qVU = ((String)localObject);
    paramBundle.qVS = g.getMD5((String)localObject);
    long l = System.currentTimeMillis();
    paramBundle.qVV = 1.333333F;
    paramBundle.qVL = ((SightCameraView)((ViewStub)paramBundle.findViewById(2131825890)).inflate());
    paramBundle.qVL.setTargetWidth(com.tencent.mm.pluginsdk.i.a.oHW);
    paramBundle.qVL.setFixPreviewRate(paramBundle.qVV);
    paramBundle.qVL.setVisibility(0);
    paramBundle.qVP = paramBundle.findViewById(2131825895);
    paramBundle.qVP.setLayoutParams(new RelativeLayout.LayoutParams(-1, getSupportActionBar().getHeight()));
    paramBundle.qVO = paramBundle.findViewById(2131825896);
    paramBundle.ouI = paramBundle.findViewById(2131825897);
    paramBundle.qVN = paramBundle.findViewById(2131825891);
    paramBundle.qVO.setOnClickListener(new MainSightForwardContainerView.1(paramBundle));
    paramBundle.ouI.setOnClickListener(new MainSightForwardContainerView.2(paramBundle));
    paramBundle.cnf();
    ab.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.AAW.cne();
    paramBundle = this.AAW;
    if (paramBundle.qVK == null)
    {
      localObject = paramBundle.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject).widthPixels / paramBundle.qVV;
      paramBundle.qVK = ((MainSightSelectContactView)paramBundle.findViewById(2131825894));
      MainSightSelectContactView localMainSightSelectContactView = paramBundle.qVK;
      MMFragmentActivity localMMFragmentActivity = paramBundle.jdB;
      int i = (int)(((DisplayMetrics)localObject).heightPixels - f);
      int j = ((DisplayMetrics)localObject).heightPixels;
      localMainSightSelectContactView.jdB = localMMFragmentActivity;
      localMainSightSelectContactView.qWw = i;
      localMainSightSelectContactView.setMainSightContentView(paramBundle);
      localMainSightSelectContactView.addView(View.inflate(localMainSightSelectContactView.getContext(), 2130970069, null), -1, -2);
      localMainSightSelectContactView.mListView = ((ListView)localMainSightSelectContactView.findViewById(2131820911));
      localMainSightSelectContactView.qWz = new c(localMainSightSelectContactView);
      localMainSightSelectContactView.qWC = new LinearLayout(localMainSightSelectContactView.getContext());
      localMainSightSelectContactView.qWC.addView(new View(localMainSightSelectContactView.getContext()), -1, localMainSightSelectContactView.qWB.getViewHeight() - localMainSightSelectContactView.qWw);
      localMainSightSelectContactView.qWC.getChildAt(0).setBackgroundColor(0);
      localMainSightSelectContactView.mListView.addHeaderView(localMainSightSelectContactView.qWC);
      localMainSightSelectContactView.mListView.setAdapter(localMainSightSelectContactView.qWz);
      localMainSightSelectContactView.mListView.setOnItemClickListener(paramBundle);
      localMainSightSelectContactView.qWG = new HashSet();
      localMainSightSelectContactView.qWH = new HashSet();
      localMainSightSelectContactView.mListView.setOnScrollListener(localMainSightSelectContactView);
      localMainSightSelectContactView.qWx = new com.tencent.mm.plugin.sight.encode.ui.d();
      localMainSightSelectContactView.qWx.qWs = localMainSightSelectContactView;
      paramBundle.qVK.setSearchView(paramBundle.findViewById(2131823242));
      paramBundle.qVK.setEmptyBgView(paramBundle.findViewById(2131825892));
      paramBundle.qVK.setMainSightContentView(paramBundle);
    }
    paramBundle.kX(true);
    paramBundle.qVL.postDelayed(new MainSightForwardContainerView.3(paramBundle), 50L);
    AppMethodBeat.o(35276);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(35278);
    super.onPause();
    this.AAW.onPause();
    AppMethodBeat.o(35278);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(35277);
    super.onResume();
    this.AAW.onResume();
    AppMethodBeat.o(35277);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SightForwardUI
 * JD-Core Version:    0.7.0.1
 */