package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.statusbar.c.a;

public class SnsUserUI
  extends MMActivity
  implements h.a
{
  private long eCX;
  private int eez;
  private long fAA;
  private com.tencent.mm.sdk.b.c hCe;
  private String ikj;
  private com.tencent.matrix.trace.e.b mCa;
  private View pyE;
  private c.a pyG;
  private boolean rHl;
  private String rXD;
  private boolean rXE;
  private int rXF;
  private boolean rXy;
  private MenuItem.OnMenuItemClickListener rYp;
  private at sbW;
  private SnsUIAction sbX;
  private an.a sbY;
  private SnsUIAction.a sbZ;
  private RelativeLayout sca;
  private TextView scb;
  private int scc;
  private Runnable scd;
  
  public SnsUserUI()
  {
    AppMethodBeat.i(39814);
    this.rXy = false;
    this.sca = null;
    this.scb = null;
    this.scc = 0;
    this.scd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39785);
        SnsUserUI.a(SnsUserUI.this).cvL();
        SnsUserUI.a(SnsUserUI.this).ctD();
        AppMethodBeat.o(39785);
      }
    };
    this.eCX = 0L;
    this.fAA = 0L;
    this.mCa = new SnsUserUI.15(this);
    this.rYp = new SnsUserUI.8(this);
    this.hCe = new SnsUserUI.11(this);
    AppMethodBeat.o(39814);
  }
  
  private void cwF()
  {
    AppMethodBeat.i(39824);
    if (com.tencent.mm.r.a.bM(this))
    {
      AppMethodBeat.o(39824);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 18, "", "");
    ab.d("MicroMsg.SnsUserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this });
    if (!bool)
    {
      AppMethodBeat.o(39824);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 18, "", "");
    ab.d("MicroMsg.SnsUserUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this });
    if (!bool)
    {
      AppMethodBeat.o(39824);
      return;
    }
    Object localObject1 = new SightParams(2, 0);
    o.alD();
    Object localObject2 = com.tencent.mm.plugin.mmsight.d.TU(o.getAccVideoPath());
    localObject1 = RecordConfigProvider.a((String)localObject2, com.tencent.mm.plugin.mmsight.d.TW((String)localObject2), ((SightParams)localObject1).fcu, ((SightParams)localObject1).fcu.duration * 1000, 2);
    if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVS, false)) {
      ((RecordConfigProvider)localObject1).qbm = 2;
    }
    localObject2 = new VideoCaptureReportInfo();
    ((VideoCaptureReportInfo)localObject2).mhr = 2;
    ((RecordConfigProvider)localObject1).qbE = ((VideoCaptureReportInfo)localObject2);
    localObject2 = new SnsUserUI.7(this);
    CaptureDataManager.qbh.qbg = ((CaptureDataManager.b)localObject2);
    if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVQ, true))
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.qbG;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 17, (RecordConfigProvider)localObject1);
      AppMethodBeat.o(39824);
      return;
    }
    n.G(getContext(), new Intent());
    AppMethodBeat.o(39824);
  }
  
  public final void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(39822);
    ag.bEf().removeCallbacks(this.scd);
    String str;
    if (this.sbW != null)
    {
      this.sbW.rUw = paramBoolean2;
      this.sbW.rKW = paramString1;
      str = this.sbW.meP;
      if (paramString1.compareTo(str) >= 0) {
        break label137;
      }
      ab.i("MicroMsg.SnsUserUI", "onNpAddSize addsize %s %s", new Object[] { paramString1, str });
      this.sbW.cvL();
    }
    for (;;)
    {
      this.sbW.ctD();
      if ((!paramBoolean3) || (this.rXD.equals(this.ikj))) {
        break;
      }
      this.sbX.kyS = true;
      this.sbX.bf(paramInt, paramString2);
      AppMethodBeat.o(39822);
      return;
      label137:
      ab.i("MicroMsg.SnsUserUI", "onNpAddSize addsize passed %s %s", new Object[] { paramString1, str });
    }
    if ((this.rXD.equals(this.ikj)) && (paramLong != 0L))
    {
      g.RM();
      g.RL().Ru().set(ac.a.yEZ, Long.valueOf(paramLong));
      this.sbW.me(paramLong);
    }
    this.sbX.kyS = paramBoolean1;
    if (paramBoolean1) {
      this.sbX.lu(false);
    }
    AppMethodBeat.o(39822);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, boolean paramBoolean4, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(39821);
    String str;
    if (this.sbW != null)
    {
      this.sbW.rKW = paramString1;
      str = this.sbW.meP;
      if (paramString1.compareTo(str) < 0)
      {
        ab.i("MicroMsg.SnsUserUI", "onFpSetSize addsize %s %s isNeedNP %s", new Object[] { paramString1, str, Boolean.valueOf(paramBoolean1) });
        this.sbW.cvL();
        this.sbW.ctD();
      }
    }
    else
    {
      if (((!paramBoolean4) && (bo.isNullOrNil(paramString2))) || (this.rXD.equals(this.ikj))) {
        break label180;
      }
      this.sbX.kyS = true;
      this.sbX.bf(paramInt, paramString2);
    }
    for (;;)
    {
      if (paramBoolean3) {
        this.sbX.rmc.cvh();
      }
      AppMethodBeat.o(39821);
      return;
      ab.i("MicroMsg.SnsUserUI", "onFpSetSize addsize passed %s %s isNeedNP %s", new Object[] { paramString1, str, Boolean.valueOf(paramBoolean1) });
      break;
      label180:
      if ((this.rXD.equals(this.ikj)) && (paramLong != 0L))
      {
        g.RM();
        g.RL().Ru().set(ac.a.yEZ, Long.valueOf(paramLong));
        this.sbW.me(paramLong);
      }
      this.sbX.kyS = paramBoolean2;
      if (paramBoolean2) {
        this.sbX.lu(false);
      } else if (paramBoolean1) {
        this.sbY.b(this.sbZ.getType(), this.ikj, this.rHl, this.rXF);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2130970860;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39820);
    this.sca = ((RelativeLayout)findViewById(2131828075));
    this.scb = ((TextView)findViewById(2131828076));
    this.sca.post(new SnsUserUI.16(this));
    this.sbW = new at(this, new SnsUserUI.17(this), this.ikj, new at.c() {});
    this.sbX.list.setAdapter(this.sbW);
    this.sbX.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
    });
    this.sbX.list.postDelayed(new SnsUserUI.2(this), 500L);
    setBackBtn(this.rYp, 2131230737);
    AppMethodBeat.o(39820);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39827);
    ab.i("MicroMsg.SnsUserUI", "on activity result, %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((5985 == paramInt1) && (paramInt2 == -1))
    {
      finish();
      AppMethodBeat.o(39827);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.sbX.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(39827);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(39825);
    finish();
    AppMethodBeat.o(39825);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39815);
    if (this.mController != null) {
      this.mController.aF(2, false);
    }
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    if (!g.RJ().QU())
    {
      finish();
      AppMethodBeat.o(39815);
      return;
    }
    this.pyE = findViewById(2131820956);
    String str2;
    String str3;
    if ((this.pyE == null) || (!com.tencent.mm.ui.statusbar.c.ApJ))
    {
      getWindow().getDecorView().setSystemUiVisibility(1280);
      setActionbarColor(getContext().getResources().getColor(2131690605));
      setTitleBarClickListener(new SnsUserUI.12(this), new SnsUserUI.13(this));
      this.sbY = ag.coV();
      this.rXF = getIntent().getIntExtra("sns_source", 0);
      this.ikj = getIntent().getStringExtra("sns_userName");
      if (this.ikj == null) {
        this.ikj = "";
      }
      g.RM();
      this.rXE = ((j)g.E(j.class)).YA().arr(this.ikj);
      this.rXD = r.Zn();
      this.rHl = this.rXD.equals(this.ikj);
      paramBundle = ag.coT();
      str2 = bo.bf(getIntent().getStringExtra("sns_signature"), "");
      str3 = bo.bf(getIntent().getStringExtra("sns_nickName"), "");
      if ((this.ikj != null) && (!this.ikj.equals(""))) {
        break label516;
      }
    }
    label516:
    for (paramBundle = paramBundle.arw(this.rXD);; paramBundle = paramBundle.arw(this.ikj))
    {
      String str1 = str3;
      Object localObject = str2;
      if (paramBundle != null)
      {
        str1 = str3;
        localObject = str2;
        if ((int)paramBundle.euF > 0)
        {
          localObject = paramBundle.signature;
          str1 = paramBundle.Oe();
          ab.i("MicroMsg.SnsUserUI", "contact:user[%s] id[%d] nickname[%s]", new Object[] { paramBundle.field_username, Integer.valueOf((int)paramBundle.euF), str1 });
        }
      }
      this.sbX = new SnsUIAction(this);
      this.sbX.a(this.rXD, this.ikj, str1, (String)localObject, this.rXE, this.rHl, this.rXF);
      paramBundle = this.sbX;
      localObject = new SnsUserUI.14(this);
      this.sbZ = ((SnsUIAction.a)localObject);
      paramBundle.saS = ((SnsUIAction.a)localObject);
      this.sbX.onCreate();
      getIntent().setExtrasClassLoader(getClass().getClassLoader());
      initView();
      com.tencent.mm.sdk.b.a.ymk.c(this.hCe);
      AppMethodBeat.o(39815);
      return;
      paramBundle = com.tencent.mm.ui.statusbar.c.aH(this);
      localObject = new SnsUserUI.4(this);
      this.pyG = ((c.a)localObject);
      paramBundle.a((c.a)localObject);
      getWindow().getDecorView().requestApplyInsets();
      com.tencent.mm.ui.statusbar.d.a(getWindow());
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39816);
    ag.bEf().removeCallbacks(this.scd);
    this.rXy = true;
    com.tencent.mm.sdk.b.a.ymk.d(this.hCe);
    com.tencent.mm.modelsns.b localb = com.tencent.mm.modelsns.b.w(getIntent());
    if (localb != null)
    {
      localb.update();
      localb.ake();
    }
    if ((this.sbX != null) && (this.sbX.tipDialog != null))
    {
      this.sbX.tipDialog.dismiss();
      this.sbX.tipDialog = null;
    }
    g.RM();
    if ((g.RJ().QU()) && (this.sbY != null)) {
      this.sbY.a(this, this.sbZ.getType());
    }
    if (this.sbX != null) {
      this.sbX.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(39816);
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(39817);
    super.onDrag();
    AppMethodBeat.o(39817);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39819);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSUserScrollEnable, this.eez);
    this.eez = 0;
    this.sbX.onPause();
    super.onPause();
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class)).bQQ;
      if (localc != null) {
        localc.b(this.mCa);
      }
    }
    if (bo.aox() > this.fAA) {}
    for (long l = bo.aox() - this.fAA;; l = 1L)
    {
      this.fAA = l;
      WXHardCoderJNI.reportFPS(704, WXHardCoderJNI.hcSNSUserScrollAction, 1, this.eCX, this.fAA);
      this.eCX = 0L;
      this.fAA = 0L;
      AppMethodBeat.o(39819);
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(39828);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.SnsUserUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(39828);
      return;
    }
    ab.i("MicroMsg.SnsUserUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    label212:
    for (;;)
    {
      AppMethodBeat.o(39828);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cwF();
        AppMethodBeat.o(39828);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131302067;; paramInt = 2131302075)
      {
        if (paramArrayOfInt[0] == 0) {
          break label212;
        }
        h.a(this, getString(paramInt), getString(2131302083), getString(2131300996), getString(2131296888), false, new SnsUserUI.9(this), new SnsUserUI.10(this));
        break;
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39818);
    this.fAA = bo.aox();
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class) != null))
    {
      localObject = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class)).bQQ;
      if (localObject != null) {
        ((com.tencent.matrix.trace.f.c)localObject).a(this.mCa);
      }
    }
    if (this.sbW != null) {
      this.sbW.notifyDataSetChanged();
    }
    setRequestedOrientation(-1);
    if (!this.rHl) {
      enableOptionMenu(false);
    }
    for (;;)
    {
      setBackBtn(this.rYp, 2131230737);
      if (!this.rHl) {
        break;
      }
      setMMTitle(2131303925);
      this.sbX.onResume();
      super.onResume();
      AppMethodBeat.o(39818);
      return;
      addIconOptionMenu(0, getString(2131303900), 2131230749, new SnsUserUI.3(this));
    }
    ab.d("MicroMsg.SnsUserUI", "SnsUserUI, userName:%s, title:%s", new Object[] { this.ikj, this.sbX.title });
    Object localObject = ag.coT().arw(this.ikj);
    if (localObject != null) {
      ab.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is not null");
    }
    for (localObject = ((com.tencent.mm.n.a)localObject).Of();; localObject = this.sbX.title)
    {
      setMMTitle(i.I((CharSequence)localObject));
      break;
      ab.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is null, title:%s", new Object[] { this.sbX.title });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(39823);
    super.setActionbarColor(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (this.pyE != null))
    {
      this.pyE.setBackgroundColor(getWindow().getStatusBarColor());
      com.tencent.mm.ui.statusbar.d.a(getWindow());
    }
    AppMethodBeat.o(39823);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    AppMethodBeat.i(39826);
    boolean bool = super.supportNavigationSwipeBack();
    AppMethodBeat.o(39826);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI
 * JD-Core Version:    0.7.0.1
 */