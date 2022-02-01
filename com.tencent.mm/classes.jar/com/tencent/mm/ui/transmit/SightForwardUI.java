package com.tencent.mm.ui.transmit;

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
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.v;
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
import com.tencent.mm.vfs.y;
import java.util.HashSet;

public class SightForwardUI
  extends MMActivity
{
  private MainSightForwardContainerView afPI;
  private String mPath;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.glq;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39483);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    getSupportActionBar().hide();
    this.mPath = getIntent().getStringExtra("sight_local_path");
    if (!f.aVW(this.mPath))
    {
      Log.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", new Object[] { this.mPath });
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    if (!bh.baz())
    {
      Log.e("MicroMsg.SightForwardUI", "acc not ready");
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    paramBundle = aa.PV(String.valueOf(SystemClock.elapsedRealtime()));
    v.bOh();
    paramBundle = aa.PX(paramBundle);
    if (y.O(this.mPath, paramBundle, false) <= 0L)
    {
      Log.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", new Object[] { this.mPath, paramBundle });
      finish();
      AppMethodBeat.o(39483);
      return;
    }
    this.mPath = paramBundle;
    Log.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", new Object[] { this.mPath });
    this.afPI = ((MainSightForwardContainerView)findViewById(R.h.fIO));
    this.afPI.setIMainSightViewCallback(new SightForwardUI.1(this));
    paramBundle = this.afPI;
    Object localObject = this.mPath;
    paramBundle.PIA = this;
    paramBundle.PIw = ((String)localObject);
    paramBundle.PIu = y.bub((String)localObject);
    long l = System.currentTimeMillis();
    paramBundle.PIx = 1.333333F;
    paramBundle.PIn = ((SightCameraView)((ViewStub)paramBundle.findViewById(R.h.fvl)).inflate());
    paramBundle.PIn.setTargetWidth(com.tencent.mm.pluginsdk.l.a.KVY);
    paramBundle.PIn.setFixPreviewRate(paramBundle.PIx);
    paramBundle.PIn.setVisibility(0);
    paramBundle.PIr = paramBundle.findViewById(R.h.gaD);
    paramBundle.PIr.setLayoutParams(new RelativeLayout.LayoutParams(-1, getSupportActionBar().getHeight()));
    paramBundle.PIq = paramBundle.findViewById(R.h.fNB);
    paramBundle.KEA = paramBundle.findViewById(R.h.fNC);
    paramBundle.PIp = paramBundle.findViewById(R.h.fvk);
    paramBundle.PIq.setOnClickListener(new MainSightForwardContainerView.1(paramBundle));
    paramBundle.KEA.setOnClickListener(new MainSightForwardContainerView.2(paramBundle));
    paramBundle.gZa();
    Log.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.afPI.gYZ();
    paramBundle = this.afPI;
    if (paramBundle.PIm == null)
    {
      localObject = paramBundle.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject).widthPixels / paramBundle.PIx;
      paramBundle.PIm = ((MainSightSelectContactView)paramBundle.findViewById(R.h.fVI));
      MainSightSelectContactView localMainSightSelectContactView = paramBundle.PIm;
      MMFragmentActivity localMMFragmentActivity = paramBundle.PIA;
      int i = (int)(((DisplayMetrics)localObject).heightPixels - f);
      int j = ((DisplayMetrics)localObject).heightPixels;
      localMainSightSelectContactView.PIA = localMMFragmentActivity;
      localMainSightSelectContactView.PIY = i;
      localMainSightSelectContactView.setMainSightContentView(paramBundle);
      localMainSightSelectContactView.addView(View.inflate(localMainSightSelectContactView.getContext(), R.i.glr, null), -1, -2);
      localMainSightSelectContactView.mListView = ((ListView)localMainSightSelectContactView.findViewById(R.h.select_contact_lv));
      localMainSightSelectContactView.PJb = new c(localMainSightSelectContactView);
      localMainSightSelectContactView.PJe = new LinearLayout(localMainSightSelectContactView.getContext());
      localMainSightSelectContactView.PJe.addView(new View(localMainSightSelectContactView.getContext()), -1, localMainSightSelectContactView.PJd.getViewHeight() - localMainSightSelectContactView.PIY);
      localMainSightSelectContactView.PJe.getChildAt(0).setBackgroundColor(0);
      localMainSightSelectContactView.mListView.addHeaderView(localMainSightSelectContactView.PJe);
      localMainSightSelectContactView.mListView.setAdapter(localMainSightSelectContactView.PJb);
      localMainSightSelectContactView.mListView.setOnItemClickListener(paramBundle);
      localMainSightSelectContactView.PJi = new HashSet();
      localMainSightSelectContactView.PJj = new HashSet();
      localMainSightSelectContactView.mListView.setOnScrollListener(localMainSightSelectContactView);
      localMainSightSelectContactView.PIZ = new d();
      localMainSightSelectContactView.PIZ.PIU = localMainSightSelectContactView;
      paramBundle.PIm.setSearchView(paramBundle.findViewById(R.h.search_view));
      paramBundle.PIm.setEmptyBgView(paramBundle.findViewById(R.h.fGA));
      paramBundle.PIm.setMainSightContentView(paramBundle);
    }
    paramBundle.Dk(true);
    paramBundle.PIn.postDelayed(new MainSightForwardContainerView.3(paramBundle), 50L);
    AppMethodBeat.o(39483);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39485);
    super.onPause();
    this.afPI.onPause();
    AppMethodBeat.o(39485);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39484);
    super.onResume();
    this.afPI.onResume();
    AppMethodBeat.o(39484);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SightForwardUI
 * JD-Core Version:    0.7.0.1
 */