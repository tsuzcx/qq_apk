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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vfs.i;
import java.util.HashSet;

public class SightForwardUI
  extends MMActivity
{
  private MainSightForwardContainerView Hxq;
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
    if (!e.ann(this.mPath))
    {
      ad.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", new Object[] { this.mPath });
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    if (!az.afw())
    {
      ad.e("MicroMsg.SightForwardUI", "acc not ready");
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    paramBundle = t.zP(String.valueOf(SystemClock.elapsedRealtime()));
    o.aCI();
    paramBundle = t.zQ(paramBundle);
    if (i.lC(this.mPath, paramBundle) <= 0L)
    {
      ad.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", new Object[] { this.mPath, paramBundle });
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    this.mPath = paramBundle;
    ad.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", new Object[] { this.mPath });
    this.Hxq = ((MainSightForwardContainerView)findViewById(2131300232));
    this.Hxq.setIMainSightViewCallback(new SightForwardUI.1(this));
    paramBundle = this.Hxq;
    Object localObject = this.mPath;
    paramBundle.lTx = this;
    paramBundle.wut = ((String)localObject);
    paramBundle.wur = i.aEN((String)localObject);
    long l = System.currentTimeMillis();
    paramBundle.wuu = 1.333333F;
    paramBundle.wuk = ((SightCameraView)((ViewStub)paramBundle.findViewById(2131297684)).inflate());
    paramBundle.wuk.setTargetWidth(com.tencent.mm.pluginsdk.j.a.tDe);
    paramBundle.wuk.setFixPreviewRate(paramBundle.wuu);
    paramBundle.wuk.setVisibility(0);
    paramBundle.wuo = paramBundle.findViewById(2131306023);
    paramBundle.wuo.setLayoutParams(new RelativeLayout.LayoutParams(-1, getSupportActionBar().getHeight()));
    paramBundle.wun = paramBundle.findViewById(2131301993);
    paramBundle.tns = paramBundle.findViewById(2131301994);
    paramBundle.wum = paramBundle.findViewById(2131297682);
    paramBundle.wun.setOnClickListener(new MainSightForwardContainerView.1(paramBundle));
    paramBundle.tns.setOnClickListener(new MainSightForwardContainerView.2(paramBundle));
    paramBundle.dqW();
    ad.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.Hxq.dqV();
    paramBundle = this.Hxq;
    if (paramBundle.wuj == null)
    {
      localObject = paramBundle.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject).widthPixels / paramBundle.wuu;
      paramBundle.wuj = ((MainSightSelectContactView)paramBundle.findViewById(2131304509));
      MainSightSelectContactView localMainSightSelectContactView = paramBundle.wuj;
      MMFragmentActivity localMMFragmentActivity = paramBundle.lTx;
      int i = (int)(((DisplayMetrics)localObject).heightPixels - f);
      int j = ((DisplayMetrics)localObject).heightPixels;
      localMainSightSelectContactView.lTx = localMMFragmentActivity;
      localMainSightSelectContactView.wuU = i;
      localMainSightSelectContactView.setMainSightContentView(paramBundle);
      localMainSightSelectContactView.addView(View.inflate(localMainSightSelectContactView.getContext(), 2131494683, null), -1, -2);
      localMainSightSelectContactView.mListView = ((ListView)localMainSightSelectContactView.findViewById(2131304508));
      localMainSightSelectContactView.wuX = new c(localMainSightSelectContactView);
      localMainSightSelectContactView.wva = new LinearLayout(localMainSightSelectContactView.getContext());
      localMainSightSelectContactView.wva.addView(new View(localMainSightSelectContactView.getContext()), -1, localMainSightSelectContactView.wuZ.getViewHeight() - localMainSightSelectContactView.wuU);
      localMainSightSelectContactView.wva.getChildAt(0).setBackgroundColor(0);
      localMainSightSelectContactView.mListView.addHeaderView(localMainSightSelectContactView.wva);
      localMainSightSelectContactView.mListView.setAdapter(localMainSightSelectContactView.wuX);
      localMainSightSelectContactView.mListView.setOnItemClickListener(paramBundle);
      localMainSightSelectContactView.wve = new HashSet();
      localMainSightSelectContactView.wvf = new HashSet();
      localMainSightSelectContactView.mListView.setOnScrollListener(localMainSightSelectContactView);
      localMainSightSelectContactView.wuV = new d();
      localMainSightSelectContactView.wuV.wuQ = localMainSightSelectContactView;
      paramBundle.wuj.setSearchView(paramBundle.findViewById(2131304452));
      paramBundle.wuj.setEmptyBgView(paramBundle.findViewById(2131299459));
      paramBundle.wuj.setMainSightContentView(paramBundle);
    }
    paramBundle.pF(true);
    paramBundle.wuk.postDelayed(new MainSightForwardContainerView.3(paramBundle), 50L);
    AppMethodBeat.o(39483);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39485);
    super.onPause();
    this.Hxq.onPause();
    AppMethodBeat.o(39485);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39484);
    super.onResume();
    this.Hxq.onResume();
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