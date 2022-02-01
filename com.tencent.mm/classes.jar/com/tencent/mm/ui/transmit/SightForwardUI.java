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
import com.tencent.mm.model.az;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vfs.i;
import java.util.HashSet;

public class SightForwardUI
  extends MMActivity
{
  private MainSightForwardContainerView IXN;
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
    if (!e.asw(this.mPath))
    {
      ac.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", new Object[] { this.mPath });
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    if (!az.agM())
    {
      ac.e("MicroMsg.SightForwardUI", "acc not ready");
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    paramBundle = t.DU(String.valueOf(SystemClock.elapsedRealtime()));
    o.aJy();
    paramBundle = t.DV(paramBundle);
    if (i.lZ(this.mPath, paramBundle) <= 0L)
    {
      ac.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", new Object[] { this.mPath, paramBundle });
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    this.mPath = paramBundle;
    ac.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", new Object[] { this.mPath });
    this.IXN = ((MainSightForwardContainerView)findViewById(2131300232));
    this.IXN.setIMainSightViewCallback(new SightForwardUI.1(this));
    paramBundle = this.IXN;
    Object localObject = this.mPath;
    paramBundle.mvz = this;
    paramBundle.xFJ = ((String)localObject);
    paramBundle.xFH = i.aKe((String)localObject);
    long l = System.currentTimeMillis();
    paramBundle.xFK = 1.333333F;
    paramBundle.xFA = ((SightCameraView)((ViewStub)paramBundle.findViewById(2131297684)).inflate());
    paramBundle.xFA.setTargetWidth(com.tencent.mm.pluginsdk.j.a.uLB);
    paramBundle.xFA.setFixPreviewRate(paramBundle.xFK);
    paramBundle.xFA.setVisibility(0);
    paramBundle.xFE = paramBundle.findViewById(2131306023);
    paramBundle.xFE.setLayoutParams(new RelativeLayout.LayoutParams(-1, getSupportActionBar().getHeight()));
    paramBundle.xFD = paramBundle.findViewById(2131301993);
    paramBundle.uvL = paramBundle.findViewById(2131301994);
    paramBundle.xFC = paramBundle.findViewById(2131297682);
    paramBundle.xFD.setOnClickListener(new MainSightForwardContainerView.1(paramBundle));
    paramBundle.uvL.setOnClickListener(new MainSightForwardContainerView.2(paramBundle));
    paramBundle.dFf();
    ac.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.IXN.dFe();
    paramBundle = this.IXN;
    if (paramBundle.xFz == null)
    {
      localObject = paramBundle.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject).widthPixels / paramBundle.xFK;
      paramBundle.xFz = ((MainSightSelectContactView)paramBundle.findViewById(2131304509));
      MainSightSelectContactView localMainSightSelectContactView = paramBundle.xFz;
      MMFragmentActivity localMMFragmentActivity = paramBundle.mvz;
      int i = (int)(((DisplayMetrics)localObject).heightPixels - f);
      int j = ((DisplayMetrics)localObject).heightPixels;
      localMainSightSelectContactView.mvz = localMMFragmentActivity;
      localMainSightSelectContactView.xGk = i;
      localMainSightSelectContactView.setMainSightContentView(paramBundle);
      localMainSightSelectContactView.addView(View.inflate(localMainSightSelectContactView.getContext(), 2131494683, null), -1, -2);
      localMainSightSelectContactView.mListView = ((ListView)localMainSightSelectContactView.findViewById(2131304508));
      localMainSightSelectContactView.xGn = new c(localMainSightSelectContactView);
      localMainSightSelectContactView.xGq = new LinearLayout(localMainSightSelectContactView.getContext());
      localMainSightSelectContactView.xGq.addView(new View(localMainSightSelectContactView.getContext()), -1, localMainSightSelectContactView.xGp.getViewHeight() - localMainSightSelectContactView.xGk);
      localMainSightSelectContactView.xGq.getChildAt(0).setBackgroundColor(0);
      localMainSightSelectContactView.mListView.addHeaderView(localMainSightSelectContactView.xGq);
      localMainSightSelectContactView.mListView.setAdapter(localMainSightSelectContactView.xGn);
      localMainSightSelectContactView.mListView.setOnItemClickListener(paramBundle);
      localMainSightSelectContactView.xGu = new HashSet();
      localMainSightSelectContactView.xGv = new HashSet();
      localMainSightSelectContactView.mListView.setOnScrollListener(localMainSightSelectContactView);
      localMainSightSelectContactView.xGl = new d();
      localMainSightSelectContactView.xGl.xGg = localMainSightSelectContactView;
      paramBundle.xFz.setSearchView(paramBundle.findViewById(2131304452));
      paramBundle.xFz.setEmptyBgView(paramBundle.findViewById(2131299459));
      paramBundle.xFz.setMainSightContentView(paramBundle);
    }
    paramBundle.qE(true);
    paramBundle.xFA.postDelayed(new MainSightForwardContainerView.3(paramBundle), 50L);
    AppMethodBeat.o(39483);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39485);
    super.onPause();
    this.IXN.onPause();
    AppMethodBeat.o(39485);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39484);
    super.onResume();
    this.IXN.onResume();
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