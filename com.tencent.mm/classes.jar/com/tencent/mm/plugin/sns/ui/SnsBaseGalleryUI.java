package com.tencent.mm.plugin.sns.ui;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ay;
import com.tencent.mm.f.a.ba;
import com.tencent.mm.f.a.ur;
import com.tencent.mm.f.a.ur.a;
import com.tencent.mm.f.a.xb;
import com.tencent.mm.f.a.xp;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView.b;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.a;
import com.tencent.mm.ui.base.MMViewPager.l;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.List;

public abstract class SnsBaseGalleryUI
  extends MMActivity
  implements a.a<String, com.tencent.mm.plugin.scanner.word.b>, c.b, SnsInfoFlip.b, y.a
{
  private MMViewPager CcM;
  private boolean IYi = true;
  private FlipView.b KDM = new FlipView.b()
  {
    public final void fTF()
    {
      AppMethodBeat.i(224820);
      SnsBaseGalleryUI.a(SnsBaseGalleryUI.this).reset();
      AppMethodBeat.o(224820);
    }
    
    public final void hI(List<Integer> paramAnonymousList)
    {
      AppMethodBeat.i(224819);
      if ((paramAnonymousList != null) && (paramAnonymousList.contains(Integer.valueOf(9)))) {
        SnsBaseGalleryUI.a(SnsBaseGalleryUI.this).jc(2, SnsBaseGalleryUI.this.fVR());
      }
      AppMethodBeat.o(224819);
    }
  };
  private LinearLayout KNQ;
  x KNR;
  private LinearLayout KNS;
  y KNT;
  boolean KNU = true;
  private TextView KNV = null;
  protected SnsInfoFlip KNW;
  protected Button KNX;
  private com.tencent.mm.plugin.scanner.word.b KNY = null;
  protected MultiCodeMaskView KNZ;
  private int KOa = -1;
  private FlipView.c KOb = new FlipView.c()
  {
    public final boolean a(ArrayList<ImageQBarDataBean> paramAnonymousArrayList1, ArrayList<PointF> paramAnonymousArrayList, ArrayList<ImageQBarDataBean> paramAnonymousArrayList2, final SnsInfo paramAnonymousSnsInfo, final String paramAnonymousString)
    {
      AppMethodBeat.i(269289);
      if (SnsBaseGalleryUI.this.KNZ != null)
      {
        if (SnsBaseGalleryUI.this.KNW != null) {
          SnsBaseGalleryUI.this.KNZ.a(paramAnonymousArrayList1, paramAnonymousArrayList, paramAnonymousArrayList2, SnsBaseGalleryUI.this.KNW.getMeasuredHeight());
        }
        for (;;)
        {
          SnsBaseGalleryUI.this.KNZ.setMMultiCodeMaskViewListener(new MultiCodeMaskView.b()
          {
            public final void a(ArrayList<ImageQBarDataBean> paramAnonymous2ArrayList, ImageQBarDataBean paramAnonymous2ImageQBarDataBean, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(198372);
              if (SnsBaseGalleryUI.this.KNW != null)
              {
                SnsBaseGalleryUI.this.KNW.KDJ = paramAnonymous2ImageQBarDataBean;
                SnsBaseGalleryUI.this.KNW.a(paramAnonymous2ImageQBarDataBean, paramAnonymousSnsInfo, paramAnonymousString);
              }
              if (paramAnonymous2Boolean) {}
              for (int i = 1;; i = 2)
              {
                j localj = j.IAG;
                j.a(SnsBaseGalleryUI.this.KNW.BrO.longValue(), i, paramAnonymous2ArrayList, paramAnonymous2ImageQBarDataBean, SnsBaseGalleryUI.this.KNW.BrP.longValue(), 1);
                AppMethodBeat.o(198372);
                return;
              }
            }
            
            public final void as(ArrayList<ImageQBarDataBean> paramAnonymous2ArrayList)
            {
              AppMethodBeat.i(198365);
              j localj = j.IAG;
              j.a(SnsBaseGalleryUI.this.KNW.BrO.longValue(), 3, paramAnonymous2ArrayList, null, SnsBaseGalleryUI.this.KNW.BrP.longValue(), 1);
              if (SnsBaseGalleryUI.this.KNW != null) {
                SnsBaseGalleryUI.this.KNW.KDJ = null;
              }
              AppMethodBeat.o(198365);
            }
          });
          AppMethodBeat.o(269289);
          return true;
          SnsBaseGalleryUI.this.KNZ.a(paramAnonymousArrayList1, paramAnonymousArrayList, paramAnonymousArrayList2, SnsBaseGalleryUI.this.KNZ.getRootView().getMeasuredHeight());
        }
      }
      AppMethodBeat.o(269289);
      return false;
    }
  };
  private long KOc = 0L;
  private com.tencent.mm.plugin.scanner.api.a.a KOd = null;
  private com.tencent.mm.plugin.scanner.api.a.b KOe = ((com.tencent.mm.plugin.scanner.api.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.scanner.api.b.class)).fBV();
  private com.tencent.mm.plugin.scanner.api.a.c KOf = new com.tencent.mm.plugin.scanner.api.a.c()
  {
    public final void fBY()
    {
      AppMethodBeat.i(238517);
      SnsBaseGalleryUI.b(SnsBaseGalleryUI.this);
      AppMethodBeat.o(238517);
    }
    
    public final void fBZ()
    {
      AppMethodBeat.i(238526);
      Log.i("MicroMsg.SnsBaseGalleryUI", "alvinluo dealWithImageOcr onDialogShow");
      SnsBaseGalleryUI.b(SnsBaseGalleryUI.this);
      SnsBaseGalleryUI localSnsBaseGalleryUI = SnsBaseGalleryUI.this;
      localSnsBaseGalleryUI.KNU = false;
      localSnsBaseGalleryUI.setTitleVisibility(8);
      if (localSnsBaseGalleryUI.KNR != null) {
        localSnsBaseGalleryUI.KNR.setVisibility(8);
      }
      SnsBaseGalleryUI.this.dlq();
      AppMethodBeat.o(238526);
    }
    
    public final void fCa()
    {
      AppMethodBeat.i(238523);
      SnsBaseGalleryUI.c(SnsBaseGalleryUI.this);
      AppMethodBeat.o(238523);
    }
    
    public final void fCb()
    {
      AppMethodBeat.i(238520);
      SnsBaseGalleryUI.c(SnsBaseGalleryUI.this);
      SnsBaseGalleryUI.this.dlq();
      AppMethodBeat.o(238520);
    }
  };
  private IListener<xp> KOg = new IListener() {};
  private IListener<xb> KOh = new IListener() {};
  private View.OnLongClickListener aHT = new View.OnLongClickListener()
  {
    public final boolean onLongClick(View paramAnonymousView)
    {
      AppMethodBeat.i(228159);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
      if (SnsBaseGalleryUI.this.KNW == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(228159);
        return false;
      }
      paramAnonymousView = SnsBaseGalleryUI.this.KNW.getCntMedia();
      if ((paramAnonymousView != null) && (paramAnonymousView.rWu == 2) && (SnsBaseGalleryUI.this.fVP()) && (com.tencent.mm.plugin.scanner.n.fBO()))
      {
        paramAnonymousView = g.D(SnsBaseGalleryUI.this.KNW.getCntMedia());
        SnsBaseGalleryUI.this.cE(paramAnonymousView, true);
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(228159);
      return false;
    }
  };
  private com.tencent.mm.plugin.scanner.word.a wNb;
  int wNc = 0;
  private int wNd = 0;
  private ImageView wNf;
  private ImageView wNg;
  private ImageView wNh;
  private ValueAnimator wNi;
  private IListener<ur> wNj = new IListener() {};
  private p wNk = new p.a()
  {
    public final void onNetworkChange(int paramAnonymousInt)
    {
      AppMethodBeat.i(266246);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98486);
          if ((com.tencent.mm.kernel.h.aGY().bih() != 6) && (com.tencent.mm.kernel.h.aGY().bih() != 4) && (SnsBaseGalleryUI.i(SnsBaseGalleryUI.this) == 1))
          {
            com.tencent.mm.ui.base.h.c(SnsBaseGalleryUI.this, SnsBaseGalleryUI.this.getString(i.j.app_network_unavailable), "", true);
            SnsBaseGalleryUI.this.dlo();
          }
          AppMethodBeat.o(98486);
        }
      });
      AppMethodBeat.o(266246);
    }
  };
  
  private void bca(String paramString)
  {
    if (this.wNb == null) {
      this.wNb = new ImageWordScanDetailEngine(this, (byte)0);
    }
    if (!Util.isNullOrNil(paramString)) {
      this.wNb.a(paramString, this);
    }
  }
  
  private void dlp()
  {
    this.wNf.setVisibility(0);
    this.wNg.setVisibility(0);
    this.wNh.setVisibility(0);
    this.wNi.setRepeatMode(1);
    this.wNi.setRepeatCount(-1);
    this.wNi.start();
  }
  
  private void fVL()
  {
    if (this.KNW != null)
    {
      this.KNW.setEnableSingleClickOver(true);
      this.KNW.setShowLongClickMenu(true);
    }
    if (this.CcM != null)
    {
      this.CcM.setEnableGalleryScale(true);
      this.CcM.setSingleMode(false);
    }
  }
  
  private boolean fVM()
  {
    boolean bool = true;
    if (this.wNd == 1)
    {
      ba localba = new ba();
      localba.fwL.scene = 1;
      localba.fwL.fwM = this.wNc;
      EventCenter.instance.publish(localba);
    }
    if (this.wNi.isRunning()) {}
    for (;;)
    {
      dlo();
      this.wNc = 0;
      return bool;
      bool = false;
    }
  }
  
  private boolean fVS()
  {
    return fVQ() == 3;
  }
  
  private void fVT()
  {
    this.wNf.setVisibility(8);
    this.wNg.setVisibility(8);
    this.wNh.setVisibility(8);
  }
  
  private void setNeedTranslationImg(boolean paramBoolean)
  {
    if (com.tencent.mm.plugin.scanner.n.fBR())
    {
      this.KNW.setNeedTranslationImg(true);
      return;
    }
    this.KNW.setNeedTranslationImg(paramBoolean);
  }
  
  public void a(cvt paramcvt, int paramInt, String paramString)
  {
    this.KNY = null;
    if ((paramcvt.rWu == 2) && (com.tencent.mm.plugin.scanner.n.fBO()) && (fVP()))
    {
      if (paramInt != this.KOa)
      {
        setNeedTranslationImg(false);
        this.KNW.setNeedOCRImg(false);
        this.wNc = 0;
      }
      this.KOa = paramInt;
      paramString = aj.fOI().bbl(paramString);
      if ((paramString != null) && (!paramString.isWaitPost())) {
        cE(g.D(paramcvt), false);
      }
    }
    for (;;)
    {
      if (this.KNT != null)
      {
        paramcvt = this.KNT;
        paramcvt.KEs = false;
        paramcvt.KEt = false;
      }
      return;
      setNeedTranslationImg(false);
      this.KNW.setNeedOCRImg(false);
    }
  }
  
  protected void aB(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void aYK(String paramString) {}
  
  public void addView(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.KNQ.addView(paramView, localLayoutParams);
  }
  
  @SuppressLint({"ResourceAsColor"})
  public final void ak(boolean paramBoolean, int paramInt)
  {
    this.KNR = new x(this, paramInt, paramBoolean);
    this.KNR.setBackgroundColor(i.c.transparent);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.KNR.getBackground().setAlpha(50);
    this.KNS.addView(this.KNR, localLayoutParams);
    paramInt = getIntent().getIntExtra("sns_source", 0);
    this.KNR.setSnsSource(paramInt);
  }
  
  protected final void cE(String paramString, boolean paramBoolean)
  {
    if (!com.tencent.mm.plugin.scanner.n.fBM()) {
      bca(paramString);
    }
    while (!paramBoolean) {
      return;
    }
    bca(paramString);
  }
  
  public final void cq(String paramString, boolean paramBoolean) {}
  
  public final void cr(String paramString, boolean paramBoolean)
  {
    if ((com.tencent.mm.plugin.scanner.n.fBO()) && (fVP()) && (paramBoolean) && (!Util.isNullOrNil(paramString)) && (paramString.equals(this.KNW.getSelectedMediaId()))) {
      cE(g.D(this.KNW.getCntMedia()), false);
    }
  }
  
  public final void dlo()
  {
    this.KNW.setEnableSingleClickOver(true);
    this.wNd = 0;
    dlq();
  }
  
  public final void dlq()
  {
    fVT();
    this.wNi.setRepeatMode(1);
    this.wNi.setRepeatCount(0);
    this.wNi.end();
  }
  
  public final void fLL() {}
  
  public void fTH()
  {
    int j = 8;
    boolean bool = false;
    if (!this.IYi) {
      return;
    }
    x localx;
    if (this.KNU)
    {
      i = 8;
      setTitleVisibility(i);
      if (this.KNR != null)
      {
        localx = this.KNR;
        if (!this.KNU) {
          break label76;
        }
      }
    }
    label76:
    for (int i = j;; i = 0)
    {
      localx.setVisibility(i);
      if (!this.KNU) {
        bool = true;
      }
      this.KNU = bool;
      return;
      i = 0;
      break;
    }
  }
  
  protected final boolean fVN()
  {
    return (fVO()) || (fVM());
  }
  
  protected final boolean fVO()
  {
    fVL();
    return (this.KOd != null) && (this.KOd.PN(this.KOc));
  }
  
  protected boolean fVP()
  {
    return false;
  }
  
  protected int fVQ()
  {
    return 3;
  }
  
  protected int fVR()
  {
    return 3;
  }
  
  public final int getFromScene()
  {
    return getIntent().getIntExtra("key_from_scene", 0);
  }
  
  public int getLayoutId()
  {
    return i.g.sns_gallery_img;
  }
  
  public void gl(String paramString, int paramInt) {}
  
  public void gm(String paramString, int paramInt)
  {
    if ((!this.IYi) || (aj.isInValid())) {
      return;
    }
    paramString = aj.fOI().bbl(paramString);
    if ((paramString == null) || (paramString.field_snsId == 0L))
    {
      enableOptionMenu(false);
      return;
    }
    enableOptionMenu(true);
  }
  
  public final void lm(String paramString1, String paramString2)
  {
    if (!this.IYi) {
      return;
    }
    setMMTitle(paramString1);
    setMMSubTitle(paramString2);
  }
  
  public void onBackPressed()
  {
    if ((this.KNZ != null) && (this.KNZ.getVisibility() == 0))
    {
      long l = 0L;
      if (this.KNW != null) {
        l = this.KNW.BrO.longValue();
      }
      this.KNZ.F(l, false);
      return;
    }
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.KOd != null) {
      this.KOd.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aj.fOD().aX(3, true);
    this.KNQ = ((LinearLayout)findViewById(i.f.layout_content));
    this.KNS = ((LinearLayout)findViewById(i.f.content));
    this.KNT = new y(this, this, getFromScene());
    paramBundle = this.KNT;
    Log.i("MicroMsg.GalleryTitleManager", "onAttach");
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(218, paramBundle);
    EventCenter.instance.addListener(paramBundle.wKS);
    EventCenter.instance.addListener(paramBundle.KDP);
    this.KNT.KDM = new FlipView.b()
    {
      public final void fTF()
      {
        AppMethodBeat.i(237299);
        SnsBaseGalleryUI.a(SnsBaseGalleryUI.this).reset();
        AppMethodBeat.o(237299);
      }
      
      public final void hI(List<Integer> paramAnonymousList)
      {
        AppMethodBeat.i(237298);
        if ((paramAnonymousList != null) && (paramAnonymousList.contains(Integer.valueOf(11)))) {
          SnsBaseGalleryUI.a(SnsBaseGalleryUI.this).jc(2, SnsBaseGalleryUI.this.fVR());
        }
        AppMethodBeat.o(237298);
      }
    };
    this.KNZ = ((MultiCodeMaskView)findViewById(i.f.multi_code_mask_view));
    if (fVP())
    {
      this.wNf = ((ImageView)findViewById(i.f.scan_translate_line));
      this.wNg = ((ImageView)findViewById(i.f.scan_translate_layer));
      this.wNh = ((ImageView)findViewById(i.f.scan_translate_close_btn));
      paramBundle = (FrameLayout.LayoutParams)this.wNh.getLayoutParams();
      paramBundle.bottomMargin += ar.aB(this);
      this.wNh.setLayoutParams(paramBundle);
      this.wNh.setOnClickListener(new SnsBaseGalleryUI.9(this));
      this.wNf = ((ImageView)findViewById(i.f.scan_translate_line));
      this.wNi = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.wNi.setDuration(5000L);
      this.wNi.addListener(new SnsBaseGalleryUI.11(this));
      int i = getWindowManager().getDefaultDisplay().getHeight();
      this.wNi.addUpdateListener(new SnsBaseGalleryUI.12(this, i));
    }
    aj.fOD().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject;
    if (this.KNT != null)
    {
      localObject = this.KNT;
      Log.i("MicroMsg.GalleryTitleManager", "onDetach");
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(218, (i)localObject);
      EventCenter.instance.removeListener(((y)localObject).wKS);
      EventCenter.instance.removeListener(((y)localObject).KDP);
    }
    if (this.KNW != null)
    {
      this.KNW.CcM.Wni.removeMessages(1);
      localObject = this.KNW;
      Log.i("MicroMsg.SnsInfoFlip", "sns info flip on detach.");
      if (((SnsInfoFlip)localObject).KRM != null)
      {
        ((SnsInfoFlip)localObject).KRM.fWv();
        ((SnsInfoFlip)localObject).KRM.clear();
      }
      aj.fOD().b((c.b)localObject);
      this.KNW.onDestroy();
    }
    if (this.KNZ != null) {
      this.KNZ.fBH();
    }
    if (fVP()) {
      dlo();
    }
    com.tencent.mm.kernel.h.aHF().b(this.wNk);
    EventCenter.instance.removeListener(this.wNj);
    aj.fOD().b(this);
  }
  
  public void onPause()
  {
    if (this.KNW != null) {
      this.KNW.onPause();
    }
    if (this.KNT != null)
    {
      y localy = this.KNT;
      if (localy.KDJ != null)
      {
        ay localay = new ay();
        localay.fwH.activity = ((Activity)localy.context);
        localay.fwH.fwI = localy.KDJ.IAH;
        EventCenter.instance.publish(localay);
        localy.KDJ = null;
      }
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.KNR != null) {
      this.KNR.bfU();
    }
    if (fVP())
    {
      com.tencent.mm.kernel.h.aHF().a(this.wNk);
      EventCenter.instance.addListener(this.KOg);
      EventCenter.instance.addListener(this.wNj);
      EventCenter.instance.addListener(this.KOh);
    }
    if (this.KNW != null)
    {
      this.KNW.setOnMenuShowListener(this.KDM);
      this.KNW.setOnLongClickListener(this.aHT);
      this.KNW.setOnMultiCodeListener(this.KOb);
      if (com.tencent.mm.plugin.scanner.n.fBR()) {
        setNeedTranslationImg(true);
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    EventCenter.instance.removeListener(this.KOg);
    EventCenter.instance.removeListener(this.KOh);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
 * JD-Core Version:    0.7.0.1
 */