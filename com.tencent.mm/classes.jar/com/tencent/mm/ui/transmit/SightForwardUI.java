package com.tencent.mm.ui.transmit;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.1;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.2;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.3;
import com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView;
import com.tencent.mm.plugin.sight.encode.ui.SightCameraView;
import com.tencent.mm.plugin.sight.encode.ui.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vfs.e;
import java.util.HashSet;

public class SightForwardUI
  extends MMActivity
{
  private String mPath;
  private MainSightForwardContainerView whZ;
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.main_sight_forward_view;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    getSupportActionBar().hide();
    this.mPath = getIntent().getStringExtra("sight_local_path");
    if (!com.tencent.mm.plugin.sight.base.d.MG(this.mPath))
    {
      y.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", new Object[] { this.mPath });
      finish();
      return;
    }
    if (!au.DK())
    {
      y.e("MicroMsg.SightForwardUI", "acc not ready");
      finish();
      return;
    }
    paramBundle = t.nR(String.valueOf(SystemClock.elapsedRealtime()));
    o.Sr();
    paramBundle = t.nS(paramBundle);
    if (e.r(this.mPath, paramBundle) <= 0L)
    {
      y.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", new Object[] { this.mPath, paramBundle });
      finish();
      return;
    }
    this.mPath = paramBundle;
    y.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", new Object[] { this.mPath });
    this.whZ = ((MainSightForwardContainerView)findViewById(R.h.forward_view));
    this.whZ.setIMainSightViewCallback(new SightForwardUI.1(this));
    paramBundle = this.whZ;
    Object localObject = this.mPath;
    paramBundle.ohK = this;
    paramBundle.ohG = ((String)localObject);
    paramBundle.ohE = g.bQ((String)localObject);
    long l = System.currentTimeMillis();
    paramBundle.ohH = 1.333333F;
    paramBundle.ohx = ((SightCameraView)((ViewStub)paramBundle.findViewById(R.h.camera_video_view)).inflate());
    paramBundle.ohx.setTargetWidth(com.tencent.mm.pluginsdk.i.a.mhQ);
    paramBundle.ohx.setFixPreviewRate(paramBundle.ohH);
    paramBundle.ohx.setVisibility(0);
    paramBundle.ohB = paramBundle.findViewById(R.h.top_virtual_actionbar);
    paramBundle.ohB.setLayoutParams(new RelativeLayout.LayoutParams(-1, getSupportActionBar().getHeight()));
    paramBundle.ohA = paramBundle.findViewById(R.h.main_sight_close);
    paramBundle.lWx = paramBundle.findViewById(R.h.main_sight_send);
    paramBundle.ohz = paramBundle.findViewById(R.h.camera_shadow);
    paramBundle.ohA.setOnClickListener(new MainSightForwardContainerView.1(paramBundle));
    paramBundle.lWx.setOnClickListener(new MainSightForwardContainerView.2(paramBundle));
    paramBundle.bBG();
    y.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.whZ.bBF();
    paramBundle = this.whZ;
    if (paramBundle.ohw == null)
    {
      localObject = paramBundle.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject).widthPixels / paramBundle.ohH;
      paramBundle.ohw = ((MainSightSelectContactView)paramBundle.findViewById(R.h.select_contact_root));
      MainSightSelectContactView localMainSightSelectContactView = paramBundle.ohw;
      MMFragmentActivity localMMFragmentActivity = paramBundle.ohK;
      int i = (int)(((DisplayMetrics)localObject).heightPixels - f);
      int j = ((DisplayMetrics)localObject).heightPixels;
      localMainSightSelectContactView.ohK = localMMFragmentActivity;
      localMainSightSelectContactView.oij = i;
      localMainSightSelectContactView.setMainSightContentView(paramBundle);
      localMainSightSelectContactView.addView(View.inflate(localMainSightSelectContactView.getContext(), R.i.main_sight_select_contact_view, null), -1, -2);
      localMainSightSelectContactView.Nn = ((ListView)localMainSightSelectContactView.findViewById(R.h.select_contact_lv));
      localMainSightSelectContactView.oim = new c(localMainSightSelectContactView);
      localMainSightSelectContactView.oip = new LinearLayout(localMainSightSelectContactView.getContext());
      localMainSightSelectContactView.oip.addView(new View(localMainSightSelectContactView.getContext()), -1, localMainSightSelectContactView.oio.getViewHeight() - localMainSightSelectContactView.oij);
      localMainSightSelectContactView.oip.getChildAt(0).setBackgroundColor(0);
      localMainSightSelectContactView.Nn.addHeaderView(localMainSightSelectContactView.oip);
      localMainSightSelectContactView.Nn.setAdapter(localMainSightSelectContactView.oim);
      localMainSightSelectContactView.Nn.setOnItemClickListener(paramBundle);
      localMainSightSelectContactView.oit = new HashSet();
      localMainSightSelectContactView.oiu = new HashSet();
      localMainSightSelectContactView.Nn.setOnScrollListener(localMainSightSelectContactView);
      localMainSightSelectContactView.oik = new com.tencent.mm.plugin.sight.encode.ui.d();
      localMainSightSelectContactView.oik.oif = localMainSightSelectContactView;
      paramBundle.ohw.setSearchView(paramBundle.findViewById(R.h.search_view));
      paramBundle.ohw.setEmptyBgView(paramBundle.findViewById(R.h.empty_bg));
      paramBundle.ohw.setMainSightContentView(paramBundle);
    }
    paramBundle.iT(true);
    paramBundle.ohx.postDelayed(new MainSightForwardContainerView.3(paramBundle), 50L);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.whZ.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.whZ.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SightForwardUI
 * JD-Core Version:    0.7.0.1
 */