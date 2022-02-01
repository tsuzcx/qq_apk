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
import com.tencent.mm.model.bc;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.HashSet;

public class SightForwardUI
  extends MMActivity
{
  private MainSightForwardContainerView Llq;
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
    if (!e.ayM(this.mPath))
    {
      ae.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", new Object[] { this.mPath });
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    if (!bc.ajM())
    {
      ae.e("MicroMsg.SightForwardUI", "acc not ready");
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    paramBundle = t.HH(String.valueOf(SystemClock.elapsedRealtime()));
    com.tencent.mm.modelvideo.o.aNh();
    paramBundle = t.HJ(paramBundle);
    if (com.tencent.mm.vfs.o.mF(this.mPath, paramBundle) <= 0L)
    {
      ae.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", new Object[] { this.mPath, paramBundle });
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    this.mPath = paramBundle;
    ae.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", new Object[] { this.mPath });
    this.Llq = ((MainSightForwardContainerView)findViewById(2131300232));
    this.Llq.setIMainSightViewCallback(new SightForwardUI.1(this));
    paramBundle = this.Llq;
    Object localObject = this.mPath;
    paramBundle.nbm = this;
    paramBundle.zkD = ((String)localObject);
    paramBundle.zkB = com.tencent.mm.vfs.o.aRh((String)localObject);
    long l = System.currentTimeMillis();
    paramBundle.zkE = 1.333333F;
    paramBundle.zku = ((SightCameraView)((ViewStub)paramBundle.findViewById(2131297684)).inflate());
    paramBundle.zku.setTargetWidth(com.tencent.mm.pluginsdk.l.a.waK);
    paramBundle.zku.setFixPreviewRate(paramBundle.zkE);
    paramBundle.zku.setVisibility(0);
    paramBundle.zky = paramBundle.findViewById(2131306023);
    paramBundle.zky.setLayoutParams(new RelativeLayout.LayoutParams(-1, getSupportActionBar().getHeight()));
    paramBundle.zkx = paramBundle.findViewById(2131301993);
    paramBundle.vKs = paramBundle.findViewById(2131301994);
    paramBundle.zkw = paramBundle.findViewById(2131297682);
    paramBundle.zkx.setOnClickListener(new MainSightForwardContainerView.1(paramBundle));
    paramBundle.vKs.setOnClickListener(new MainSightForwardContainerView.2(paramBundle));
    paramBundle.dUe();
    ae.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.Llq.dUd();
    paramBundle = this.Llq;
    if (paramBundle.zkt == null)
    {
      localObject = paramBundle.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject).widthPixels / paramBundle.zkE;
      paramBundle.zkt = ((MainSightSelectContactView)paramBundle.findViewById(2131304509));
      MainSightSelectContactView localMainSightSelectContactView = paramBundle.zkt;
      MMFragmentActivity localMMFragmentActivity = paramBundle.nbm;
      int i = (int)(((DisplayMetrics)localObject).heightPixels - f);
      int j = ((DisplayMetrics)localObject).heightPixels;
      localMainSightSelectContactView.nbm = localMMFragmentActivity;
      localMainSightSelectContactView.zle = i;
      localMainSightSelectContactView.setMainSightContentView(paramBundle);
      localMainSightSelectContactView.addView(View.inflate(localMainSightSelectContactView.getContext(), 2131494683, null), -1, -2);
      localMainSightSelectContactView.mListView = ((ListView)localMainSightSelectContactView.findViewById(2131304508));
      localMainSightSelectContactView.zlh = new c(localMainSightSelectContactView);
      localMainSightSelectContactView.zlk = new LinearLayout(localMainSightSelectContactView.getContext());
      localMainSightSelectContactView.zlk.addView(new View(localMainSightSelectContactView.getContext()), -1, localMainSightSelectContactView.zlj.getViewHeight() - localMainSightSelectContactView.zle);
      localMainSightSelectContactView.zlk.getChildAt(0).setBackgroundColor(0);
      localMainSightSelectContactView.mListView.addHeaderView(localMainSightSelectContactView.zlk);
      localMainSightSelectContactView.mListView.setAdapter(localMainSightSelectContactView.zlh);
      localMainSightSelectContactView.mListView.setOnItemClickListener(paramBundle);
      localMainSightSelectContactView.zlo = new HashSet();
      localMainSightSelectContactView.zlp = new HashSet();
      localMainSightSelectContactView.mListView.setOnScrollListener(localMainSightSelectContactView);
      localMainSightSelectContactView.zlf = new d();
      localMainSightSelectContactView.zlf.zla = localMainSightSelectContactView;
      paramBundle.zkt.setSearchView(paramBundle.findViewById(2131304452));
      paramBundle.zkt.setEmptyBgView(paramBundle.findViewById(2131299459));
      paramBundle.zkt.setMainSightContentView(paramBundle);
    }
    paramBundle.rn(true);
    paramBundle.zku.postDelayed(new MainSightForwardContainerView.3(paramBundle), 50L);
    AppMethodBeat.o(39483);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39485);
    super.onPause();
    this.Llq.onPause();
    AppMethodBeat.o(39485);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39484);
    super.onResume();
    this.Llq.onResume();
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