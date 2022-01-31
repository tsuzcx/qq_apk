package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.widget.VoIPVideoView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.lang.ref.WeakReference;
import java.util.Timer;

public class VoipVideoFragment
  extends VoipBaseFragment
{
  private SurfaceTexture bbI;
  private long iHv;
  private int kMB;
  private boolean kMD;
  private Runnable lym;
  private Timer mTimer;
  private TextView nXc;
  Bitmap oUE;
  int[] oUo;
  private OpenGlView tCX;
  private OpenGlView tCY;
  private OpenGlRender tCZ;
  private TextView tDA;
  private TextView tDB;
  private VoIPVideoView tDC;
  private com.tencent.mm.plugin.voip.video.e tDD;
  private Button tDE;
  private Button tDF;
  private boolean tDG;
  private int tDH;
  private int tDI;
  private int tDJ;
  private int tDK;
  private int tDL;
  private boolean tDM;
  private boolean tDN;
  private boolean tDO;
  public long tDP;
  private Bitmap tDQ;
  private VoipVideoFragment.a tDR;
  public int tDS;
  public int tDT;
  private int tDU;
  private int tDV;
  private HandlerThread tDW;
  private ap tDX;
  private boolean tDY;
  private PowerManager.WakeLock tDZ;
  private OpenGlRender tDa;
  private View tDb;
  private ImageView tDc;
  private TextView tDd;
  private TextView tDe;
  private TextView tDf;
  private TextView tDg;
  private View tDh;
  private TextView tDi;
  private TextView tDj;
  private TextView tDk;
  private RelativeLayout tDl;
  private Button tDm;
  private VoipSmallIconButton tDn;
  private VoipSmallIconButton tDo;
  private VoipSmallIconButton tDp;
  private VoipBigIconButton tDq;
  private VoipBigIconButton tDr;
  private VoipBigIconButton tDs;
  private VoipBigIconButton tDt;
  private VoipBigIconButton tDu;
  private VoipBigIconButton tDv;
  private TextView tDw;
  private TextView tDx;
  private TextView tDy;
  private TextView tDz;
  private View.OnClickListener tEa;
  private View.OnClickListener tEb;
  private View.OnClickListener tEc;
  private View.OnClickListener tEd;
  private View.OnClickListener tEe;
  private View.OnClickListener tEf;
  private View.OnClickListener tEg;
  private View.OnClickListener tEh;
  private View.OnClickListener tEi;
  private View.OnClickListener tEj;
  private View.OnClickListener tEk;
  private View.OnClickListener tEl;
  private Runnable tEm;
  int tEn;
  private int textureId;
  public int txY;
  public int txZ;
  private CaptureView txe;
  
  public VoipVideoFragment()
  {
    AppMethodBeat.i(4899);
    this.tDD = null;
    this.tDE = null;
    this.tDF = null;
    this.tDG = false;
    this.tDL = 0;
    this.tDM = false;
    this.kMD = false;
    this.tDN = false;
    this.tDP = 0L;
    this.tDQ = null;
    this.tDS = 0;
    this.tDT = 0;
    this.tDU = 0;
    this.iHv = 0L;
    this.tDV = 0;
    this.tDW = null;
    this.tDX = null;
    this.tDY = false;
    this.txY = 0;
    this.txZ = 0;
    this.bbI = null;
    this.tEa = new VoipVideoFragment.1(this);
    this.tEb = new VoipVideoFragment.12(this);
    this.tEc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(4886);
        if ((VoipVideoFragment.this.tCc != null) && (VoipVideoFragment.this.tCc.get() != null)) {
          ((c)VoipVideoFragment.this.tCc.get()).cMV();
        }
        AppMethodBeat.o(4886);
      }
    };
    this.tEd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(4889);
        ab.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
        if ((at.isWifi(VoipVideoFragment.this.getActivity())) || (r.cNv()))
        {
          VoipVideoFragment.c(VoipVideoFragment.this);
          AppMethodBeat.o(4889);
          return;
        }
        com.tencent.mm.ui.base.h.a(VoipVideoFragment.this.getActivity(), 2131304716, 2131304717, new VoipVideoFragment.14.1(this), new VoipVideoFragment.14.2(this));
        AppMethodBeat.o(4889);
      }
    };
    this.tEe = new VoipVideoFragment.15(this);
    this.tEf = new VoipVideoFragment.16(this);
    this.tEg = new VoipVideoFragment.17(this);
    this.tEh = new VoipVideoFragment.18(this);
    this.tEi = new VoipVideoFragment.19(this);
    this.tEj = new VoipVideoFragment.2(this);
    this.tEk = new VoipVideoFragment.3(this);
    this.tEl = new VoipVideoFragment.6(this);
    this.tEm = new VoipVideoFragment.7(this);
    this.lym = new VoipVideoFragment.8(this);
    this.oUo = null;
    this.tEn = 0;
    this.oUE = null;
    AppMethodBeat.o(4899);
  }
  
  private void HG(int paramInt)
  {
    AppMethodBeat.i(4922);
    this.tCA.cOZ();
    this.tDq.setEnabled(false);
    this.tDu.setEnabled(false);
    this.tDt.setEnabled(false);
    this.tDs.setEnabled(false);
    this.tDr.setEnabled(false);
    this.tDp.setEnabled(false);
    this.tDv.setEnabled(false);
    this.tDo.setEnabled(false);
    this.tDn.setEnabled(false);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.tCz != null) {
        this.tCz.U(true, false);
      }
      AppMethodBeat.o(4922);
      return;
      this.tDj.setVisibility(0);
      this.tDj.setText(2131304715);
    }
  }
  
  private void arF()
  {
    AppMethodBeat.i(4923);
    if ((this.mTimer == null) || (this.kMD))
    {
      AppMethodBeat.o(4923);
      return;
    }
    if (-1L == this.tCd) {
      this.tCd = bo.aox();
    }
    this.tDP = this.tCd;
    this.kMD = true;
    VoipVideoFragment.9 local9 = new VoipVideoFragment.9(this);
    this.mTimer.schedule(local9, 1000L, 1000L);
    this.tDW = com.tencent.mm.sdk.g.d.aqu("VoipVideoFragment_cpuStatThread");
    this.tDW.start();
    this.tDX = new ap(this.tDW.getLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(140181);
        if (VoipVideoFragment.v(VoipVideoFragment.this))
        {
          VoipVideoFragment.w(VoipVideoFragment.this);
          AppMethodBeat.o(140181);
          return true;
        }
        AppMethodBeat.o(140181);
        return false;
      }
    }, true);
    this.tDY = true;
    this.tDX.ag(1000L, 1000L);
    AppMethodBeat.o(4923);
  }
  
  private void b(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(4925);
    if ((this.tCu == null) || (paramCaptureView == null))
    {
      AppMethodBeat.o(4925);
      return;
    }
    this.tCu.removeView(this.txe);
    this.txe = null;
    this.txe = paramCaptureView;
    this.tCu.addView(paramCaptureView, new RelativeLayout.LayoutParams(1, 1));
    this.txe.setVisibility(0);
    this.txe.setAlpha(0.0F);
    ab.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
    AppMethodBeat.o(4925);
  }
  
  private void cPc()
  {
    AppMethodBeat.i(4902);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.tDL += 1;
    this.iMP.postDelayed(this.tEm, 10000L);
    AppMethodBeat.o(4902);
  }
  
  private void cPd()
  {
    AppMethodBeat.i(4913);
    this.tCX.setVisibility(0);
    if (this.tCw != null) {
      cOY();
    }
    this.tDb.setVisibility(0);
    this.tDd.setVisibility(0);
    if ((ad.arf(this.eaX)) && (!bo.aa(this.tDe.getText()))) {
      this.tDe.setVisibility(0);
    }
    for (;;)
    {
      this.tDf.setText(2131304700);
      this.tDh.setVisibility(0);
      this.tDc.setVisibility(0);
      this.tCA.a(this.tDg, tCt);
      this.tDv.setVisibility(8);
      this.tDu.setVisibility(8);
      this.tDq.setVisibility(8);
      this.tDt.setVisibility(8);
      this.tDs.setVisibility(0);
      this.tDp.setVisibility(0);
      this.tDr.setVisibility(0);
      this.tDo.setVisibility(8);
      if (this.tDO) {
        this.tDn.setVisibility(0);
      }
      this.tDk.setVisibility(8);
      if (com.tencent.mm.plugin.voip.b.cLC().txI != null)
      {
        this.tDk.setVisibility(0);
        this.tDk.setText(com.tencent.mm.plugin.voip.b.cLC().txI);
      }
      AppMethodBeat.o(4913);
      return;
      this.tDe.setVisibility(8);
    }
  }
  
  private void cPe()
  {
    AppMethodBeat.i(4914);
    this.tDh.setVisibility(0);
    this.tCX.setVisibility(0);
    this.tDf.setText(2131304698);
    if ((ad.arf(this.eaX)) && (!bo.aa(this.tDe.getText()))) {
      this.tDe.setVisibility(0);
    }
    for (;;)
    {
      this.tCv.setVisibility(8);
      this.tDj.setVisibility(8);
      this.tDk.setVisibility(8);
      if (com.tencent.mm.plugin.voip.b.cLC().txI != null)
      {
        this.tDk.setVisibility(0);
        this.tDk.setText(com.tencent.mm.plugin.voip.b.cLC().txI);
      }
      this.tCA.a(this.tDg, tCt);
      this.tDv.setVisibility(8);
      this.tDu.setVisibility(8);
      this.tDq.setVisibility(0);
      this.tDt.setVisibility(8);
      this.tDs.setVisibility(8);
      this.tDp.setVisibility(8);
      this.tDr.setVisibility(8);
      this.tDo.setVisibility(0);
      this.tDn.setVisibility(8);
      AppMethodBeat.o(4914);
      return;
      this.tDe.setVisibility(8);
    }
  }
  
  private void cPf()
  {
    boolean bool2 = true;
    AppMethodBeat.i(4915);
    if (this.tCw != null) {
      this.tCw.setVisibility(8);
    }
    if (this.tCY.getVisibility() == 0)
    {
      AppMethodBeat.o(4915);
      return;
    }
    label71:
    Point localPoint;
    if (this.txk) {
      if (!this.tDM)
      {
        bool1 = true;
        this.tDM = bool1;
        if (this.tDM) {
          break label400;
        }
        bool1 = true;
        localPoint = na(bool1);
        this.tCY.gp(localPoint.x, localPoint.y);
        if (ae.glv)
        {
          this.tDw.setVisibility(0);
          this.tDx.setVisibility(0);
          this.tDy.setVisibility(0);
          this.tDz.setVisibility(0);
          this.tDA.setVisibility(0);
          this.tDB.setVisibility(0);
        }
        this.tDb.setVisibility(8);
        this.tCX.setVisibility(0);
        this.tCY.setVisibility(0);
        this.tDi.setVisibility(0);
        this.tDm.setVisibility(0);
        this.tDv.setVisibility(0);
        this.tDu.setVisibility(0);
        this.tDq.setVisibility(8);
        this.tDt.setVisibility(0);
        this.tDs.setVisibility(8);
        this.tDp.setVisibility(8);
        this.tDr.setVisibility(8);
        this.tDo.setVisibility(8);
        this.tDn.setVisibility(8);
        setHWDecMode(this.tDS);
        ab.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.tDS) });
        if (this.tDM) {
          break label436;
        }
      }
    }
    label400:
    label436:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = na(bool1);
      ((MovableVideoView)this.tCY).gn(localPoint.x, localPoint.y);
      arF();
      if (ah.dsQ().getBoolean("voipfaceDebug", false))
      {
        this.tDE.setVisibility(0);
        this.tDF.setVisibility(0);
      }
      cPc();
      if (this.tCx == 4102) {
        gm(2131304607, 10000);
      }
      AppMethodBeat.o(4915);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label71;
      if (!this.tDM) {}
      for (bool1 = true;; bool1 = false)
      {
        this.tDM = bool1;
        this.tDC.setVisibility(8);
        break;
      }
    }
  }
  
  private void cPg()
  {
    AppMethodBeat.i(4921);
    this.tDf.setText(2131304766);
    this.tCA.a(this.tDg, tCt);
    AppMethodBeat.o(4921);
  }
  
  private void cPh()
  {
    AppMethodBeat.i(4924);
    View.OnClickListener local11 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(140182);
        com.tencent.mm.plugin.report.service.h.qsU.e(11079, new Object[] { Integer.valueOf(4) });
        if ((!VoipVideoFragment.k(VoipVideoFragment.this)) && (VoipVideoFragment.this.tCc.get() != null)) {
          VoipVideoFragment.o(VoipVideoFragment.this).getVisibility();
        }
        int i;
        if (VoipVideoFragment.o(VoipVideoFragment.this).getVisibility() == 0)
        {
          i = 4;
          if (i != 0) {
            break label250;
          }
        }
        label250:
        for (int j = 0;; j = 8)
        {
          VoipVideoFragment.o(VoipVideoFragment.this).setVisibility(j);
          VoipVideoFragment.s(VoipVideoFragment.this).setVisibility(j);
          VoipVideoFragment.t(VoipVideoFragment.this).setVisibility(j);
          VoipVideoFragment.b(VoipVideoFragment.this).setVisibility(j);
          VoipVideoFragment.a(VoipVideoFragment.this).setVisibility(j);
          paramAnonymousView = VoipVideoFragment.this;
          if (j == 0) {
            bool = true;
          }
          VoipVideoFragment.d(paramAnonymousView, bool);
          if (ae.glv)
          {
            VoipVideoFragment.x(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.y(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.z(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.A(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.B(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.C(VoipVideoFragment.this).setVisibility(j);
          }
          if (i == 0) {
            VoipVideoFragment.p(VoipVideoFragment.this);
          }
          AppMethodBeat.o(140182);
          return;
          i = 0;
          break;
        }
      }
    };
    this.tCu.setOnClickListener(local11);
    AppMethodBeat.o(4924);
  }
  
  private Point na(boolean paramBoolean)
  {
    AppMethodBeat.i(4928);
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    com.tencent.mm.plugin.voip.b.cLC();
    Point localPoint = new Point((int)(f * com.tencent.mm.plugin.voip.model.t.mW(paramBoolean)), i);
    AppMethodBeat.o(4928);
    return localPoint;
  }
  
  public final void HF(int paramInt) {}
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    AppMethodBeat.i(140186);
    this.bbI = paramSurfaceTexture;
    this.textureId = paramInt;
    if ((!this.tDN) || (this.tDa == null) || (this.tCZ == null))
    {
      ab.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture failed , texId:%d,mInitDone:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.tDN) });
      AppMethodBeat.o(140186);
      return;
    }
    this.tDa.a(this.bbI, this.textureId);
    this.tCZ.a(this.bbI, this.textureId);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture OK , textureId:%d", new Object[] { Integer.valueOf(this.textureId) });
    AppMethodBeat.o(140186);
  }
  
  public final void a(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(4904);
    this.txe = paramCaptureView;
    b(this.txe);
    AppMethodBeat.o(4904);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(4916);
    if (!this.tDN)
    {
      AppMethodBeat.o(4916);
      return;
    }
    if (OpenGlRender.tGO == 1)
    {
      if (this.tEn < paramInt1 * paramInt2) {
        this.oUo = null;
      }
      if (this.oUo == null)
      {
        this.tEn = (paramInt1 * paramInt2);
        this.oUo = new int[this.tEn];
      }
      if ((com.tencent.mm.plugin.voip.b.cLC().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.oUo, true) < 0) || (this.oUo == null))
      {
        AppMethodBeat.o(4916);
        return;
      }
      if (this.tDM) {
        this.tCZ.a(this.oUo, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      }
    }
    for (;;)
    {
      this.tDI += 1;
      if (paramInt6 > 0) {
        this.tDH += 1;
      }
      paramArrayOfByte = this.tDD;
      paramArrayOfByte.tFX = paramInt1;
      paramArrayOfByte.tFY = paramInt2;
      paramArrayOfByte = this.tDD;
      paramInt1 = this.tCu.getWidth();
      paramInt2 = this.tCu.getHeight();
      paramArrayOfByte.tFW = paramInt1;
      paramArrayOfByte.gu = paramInt2;
      AppMethodBeat.o(4916);
      return;
      this.tDa.a(this.oUo, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      continue;
      if (OpenGlRender.tGO == 2) {
        if (this.tDM) {
          this.tCZ.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
        } else {
          this.tDa.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
        }
      }
    }
  }
  
  protected final void aeH(String paramString)
  {
    AppMethodBeat.i(4908);
    if (this.tDk != null)
    {
      this.tDk.setVisibility(0);
      this.tDk.setText(paramString);
    }
    AppMethodBeat.o(4908);
  }
  
  public final void cNc()
  {
    AppMethodBeat.i(4919);
    if (!this.tDN)
    {
      AppMethodBeat.o(4919);
      return;
    }
    this.tDa.cPG();
    this.tCZ.cPG();
    AppMethodBeat.o(4919);
  }
  
  public final void cOP()
  {
    AppMethodBeat.i(4926);
    if (this.txe != null)
    {
      this.tCu.removeView(this.txe);
      this.tCu.addView(this.txe, new RelativeLayout.LayoutParams(1, 1));
      this.txe.setVisibility(0);
      this.txe.setAlpha(0.0F);
      ab.i("MicroMsg.Voip.VoipVideoFragment", "resetCaptureView");
    }
    AppMethodBeat.o(4926);
  }
  
  public final void cOQ()
  {
    AppMethodBeat.i(140184);
    if (this.tDa.tGW == 1)
    {
      this.tDa.cOQ();
      AppMethodBeat.o(140184);
      return;
    }
    if (this.tCZ.tGW == 1) {
      this.tCZ.cOQ();
    }
    AppMethodBeat.o(140184);
  }
  
  public final OpenGlRender cOU()
  {
    if (this.tDM) {
      return this.tCZ;
    }
    return this.tDa;
  }
  
  protected final void cOV()
  {
    AppMethodBeat.i(4911);
    if (this.nXc != null)
    {
      this.nXc.clearAnimation();
      this.nXc.setVisibility(8);
    }
    AppMethodBeat.o(4911);
  }
  
  public final void cOW()
  {
    AppMethodBeat.i(4912);
    this.tCX.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    MovableVideoView localMovableVideoView = (MovableVideoView)this.tCY;
    ab.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(localMovableVideoView.mWidth), Integer.valueOf(localMovableVideoView.tGn) });
    localMovableVideoView.mScreenWidth = 0;
    localMovableVideoView.gn(localMovableVideoView.mWidth, localMovableVideoView.tGn);
    AppMethodBeat.o(4912);
  }
  
  public final void cPb()
  {
    AppMethodBeat.i(140185);
    if ((this.tDa != null) && (this.tCZ != null))
    {
      if (!this.tDM) {
        break label119;
      }
      this.tCZ.HV(0);
      if ((this.tDS & 0x1) == 0) {
        break label108;
      }
      this.tDa.HV(1);
    }
    for (;;)
    {
      ab.i("MicroMsg.Voip.VoipVideoFragment", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d,mIsSmallViewShowSelf:%b, after changeSurfaceRender", new Object[] { Integer.valueOf(this.tDa.tGW), Integer.valueOf(this.tCZ.tGW), Boolean.valueOf(this.tDM) });
      AppMethodBeat.o(140185);
      return;
      label108:
      this.tDa.HV(0);
      continue;
      label119:
      this.tDa.HV(0);
      if ((this.tDS & 0x1) != 0) {
        this.tCZ.HV(1);
      } else {
        this.tCZ.HV(0);
      }
    }
  }
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(140187);
    if (!this.tDN)
    {
      AppMethodBeat.o(140187);
      return;
    }
    this.kMB += 1;
    if (OpenGlRender.tGO == 1)
    {
      if (this.tDM)
      {
        this.tDa.g(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
        AppMethodBeat.o(140187);
        return;
      }
      this.tCZ.g(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
      AppMethodBeat.o(140187);
      return;
    }
    if (this.tDM)
    {
      this.tDa.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
      AppMethodBeat.o(140187);
      return;
    }
    this.tCZ.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
    AppMethodBeat.o(140187);
  }
  
  public final OpenGlRender getFilterData()
  {
    if (this.tDM) {
      return this.tCZ;
    }
    return this.tDa;
  }
  
  public final void gj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140188);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "adjustHWViewAspectRatio, mInitDone:%b, HWDecsize:%dx%d,  lastHWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.tDN), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.txY), Integer.valueOf(this.txZ) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(140188);
      return;
    }
    if ((this.txY != paramInt1) || (this.txZ != paramInt2))
    {
      this.txY = paramInt1;
      this.txZ = paramInt2;
    }
    if (this.tDN)
    {
      this.tDa.gj(paramInt1, paramInt2);
      this.tCZ.gj(paramInt1, paramInt2);
    }
    AppMethodBeat.o(140188);
  }
  
  public final void gl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4903);
    super.gl(paramInt1, paramInt2);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + com.tencent.mm.plugin.voip.a.b.HN(paramInt2));
    if (this.tCu == null)
    {
      ab.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
      AppMethodBeat.o(4903);
      return;
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(4903);
      return;
      cPe();
      AppMethodBeat.o(4903);
      return;
      cPd();
      AppMethodBeat.o(4903);
      return;
      cPh();
      cPf();
      AppMethodBeat.o(4903);
      return;
      HG(paramInt1);
      AppMethodBeat.o(4903);
      return;
      cPg();
    }
  }
  
  protected final void gm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4909);
    if (this.tDj == null)
    {
      AppMethodBeat.o(4909);
      return;
    }
    this.tDj.setText(paramInt1);
    this.tDj.setVisibility(0);
    this.tDj.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.tDj.setBackgroundResource(2130840774);
    this.tDj.setCompoundDrawables(null, null, null, null);
    this.tDj.setCompoundDrawablePadding(0);
    this.iMP.removeCallbacks(this.lym);
    if (-1 != paramInt2) {
      this.iMP.postDelayed(this.lym, paramInt2);
    }
    AppMethodBeat.o(4909);
  }
  
  protected final void mZ(boolean paramBoolean)
  {
    AppMethodBeat.i(4910);
    if (this.nXc != null)
    {
      if (!paramBoolean) {
        break label49;
      }
      this.nXc.setText(2131304711);
    }
    for (;;)
    {
      this.nXc.clearAnimation();
      this.nXc.setVisibility(0);
      AppMethodBeat.o(4910);
      return;
      label49:
      this.nXc.setText(2131304710);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(4900);
    this.tCu = ((RelativeLayout)paramLayoutInflater.inflate(2130971112, paramViewGroup, false));
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)this.tCu.findViewById(2131828862)).setPadding(0, 0, 0, BackwardSupportUtil.b.b(getActivity(), 40.0F));
    }
    this.tCv = ((ImageView)this.tCu.findViewById(2131828841));
    this.tCw = ((ImageView)this.tCu.findViewById(2131828844));
    this.tDl = ((RelativeLayout)this.tCu.findViewById(2131828846));
    this.tCX = ((OpenGlView)this.tCu.findViewById(2131828843));
    this.tCX.go(mScreenWidth, mScreenHeight);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "steve: onCreateView!");
    this.tDv = ((VoipBigIconButton)this.tCu.findViewById(2131828873));
    this.tDv.setOnClickListener(this.tEl);
    this.tDu = ((VoipBigIconButton)this.tCu.findViewById(2131828872));
    this.tDu.setOnClickListener(this.tEb);
    this.tDq = ((VoipBigIconButton)this.tCu.findViewById(2131828863));
    this.tDq.setOnClickListener(this.tEg);
    this.tDt = ((VoipBigIconButton)this.tCu.findViewById(2131828869));
    this.tDt.setOnClickListener(this.tEa);
    this.tDs = ((VoipBigIconButton)this.tCu.findViewById(2131828867));
    this.tDs.setOnClickListener(this.tEe);
    this.tDp = ((VoipSmallIconButton)this.tCu.findViewById(2131828868));
    this.tDp.setOnClickListener(this.tEd);
    this.tDr = ((VoipBigIconButton)this.tCu.findViewById(2131828865));
    this.tDr.setOnClickListener(this.tEf);
    this.tDo = ((VoipSmallIconButton)this.tCu.findViewById(2131828864));
    this.tDo.setOnClickListener(this.tEc);
    boolean bool;
    if (com.tencent.mm.plugin.voip.a.d.wp("VOIPBlockIgnoreButton") == 0)
    {
      bool = true;
      this.tDO = bool;
      this.tDn = ((VoipSmallIconButton)this.tCu.findViewById(2131828866));
      this.tDn.setOnClickListener(this.tEi);
      if (!this.tDO) {
        this.tDn.setVisibility(8);
      }
      this.tDi = ((TextView)this.tCu.findViewById(2131828871));
      this.tDb = this.tCu.findViewById(2131828848);
      this.tDc = ((ImageView)this.tCu.findViewById(2131828849));
      a.b.a(this.tDc, this.eaX, 0.0588235F, true);
      this.tDd = ((TextView)this.tCu.findViewById(2131828851));
      this.tDe = ((TextView)this.tCu.findViewById(2131828852));
      this.tDf = ((TextView)this.tCu.findViewById(2131828854));
      this.tDg = ((TextView)this.tCu.findViewById(2131828855));
      this.tDh = this.tCu.findViewById(2131828853);
      j(this.tDg);
      this.tDj = ((TextView)this.tCu.findViewById(2131828875));
      this.tDk = ((TextView)this.tCu.findViewById(2131828874));
      this.tDm = ((Button)this.tCu.findViewById(2131828847));
      this.nXc = ((TextView)this.tCu.findViewById(2131825222));
      if (ae.glv)
      {
        this.tDw = ((TextView)this.tCu.findViewById(2131828856));
        this.tDx = ((TextView)this.tCu.findViewById(2131828857));
        this.tDy = ((TextView)this.tCu.findViewById(2131828858));
        this.tDz = ((TextView)this.tCu.findViewById(2131828859));
        this.tDA = ((TextView)this.tCu.findViewById(2131828860));
        this.tDB = ((TextView)this.tCu.findViewById(2131828861));
      }
      this.tDE = ((Button)this.tCu.findViewById(2131828876));
      this.tDF = ((Button)this.tCu.findViewById(2131828877));
      this.tDE.setVisibility(8);
      this.tDF.setVisibility(8);
      this.tDE.setOnClickListener(this.tEj);
      this.tDF.setOnClickListener(this.tEk);
      this.tDD = new com.tencent.mm.plugin.voip.video.e(getActivity());
      this.tCu.addView(this.tDD);
      this.tDD.setVisibility(8);
      this.tDm.setOnClickListener(this.tEh);
      b(this.txe);
      int i = com.tencent.mm.ui.base.t.hY(getActivity());
      ab.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: ".concat(String.valueOf(i)));
      ai(this.tDm, i);
      ai(this.tCu.findViewById(2131828870), i);
      ai(this.tDb, i);
      this.tDI = 0;
      this.tDH = 0;
      this.kMB = 0;
      this.tDJ = 0;
      this.tDK = 0;
      this.tDU = 0;
      this.tDV = 0;
      paramLayoutInflater = (WindowManager)getActivity().getSystemService("window");
      i = paramLayoutInflater.getDefaultDisplay().getHeight() / 5;
      int j = paramLayoutInflater.getDefaultDisplay().getWidth() * i / paramLayoutInflater.getDefaultDisplay().getHeight();
      this.tCY = new MovableVideoView(getActivity().getApplicationContext());
      ((MovableVideoView)this.tCY).gn(j, i);
      this.tCY.setVisibility(8);
      this.tCZ = new OpenGlRender(this.tCY, OpenGlRender.RenderRemote);
      this.tCY.setRenderer(this.tCZ);
      this.tCY.setRenderMode(0);
      this.tDa = new OpenGlRender(this.tCX, OpenGlRender.RenderLocal);
      this.tCX.setRenderer(this.tDa);
      this.tCX.setRenderMode(0);
      this.tCX.setVisibility(0);
      ab.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      if (!Build.MODEL.equals("Nexus 6")) {
        break label1480;
      }
      this.tCY.setZOrderOnTop(true);
    }
    for (;;)
    {
      this.tCu.addView(this.tCY);
      this.tCY.setOnClickListener(new VoipVideoFragment.4(this));
      paramLayoutInflater = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.eaX);
      this.tDd.setText(com.tencent.mm.pluginsdk.ui.d.j.b(getActivity(), s.a(paramLayoutInflater, this.eaX), this.tDd.getTextSize()));
      paramLayoutInflater = a.A(paramLayoutInflater);
      if (!bo.isNullOrNil(paramLayoutInflater)) {
        this.tDe.setText(paramLayoutInflater);
      }
      if (this.txk) {
        this.iMP.postDelayed(new VoipVideoFragment.5(this), 2000L);
      }
      this.tDC = ((VoIPVideoView)this.tCu.findViewById(2131828842));
      this.mTimer = new Timer("VoIP_video_talking_count");
      ab.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.tDT) });
      this.tDa.setVoipBeauty(this.tDT);
      this.tCZ.setVoipBeauty(this.tDT);
      this.tDN = true;
      gj(this.txY, this.txZ);
      gl(0, this.mStatus);
      this.tDZ = ((PowerManager)ah.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      this.tDZ.acquire();
      ab.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.tCu;
      AppMethodBeat.o(4900);
      return paramLayoutInflater;
      bool = false;
      break;
      label1480:
      this.tCY.setZOrderMediaOverlay(true);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(4901);
    this.kMD = false;
    super.onDestroy();
    AppMethodBeat.o(4901);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(4927);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    if ((this.tDX != null) && (this.tDW != null))
    {
      this.tDX.stopTimer();
      this.tDW.quit();
    }
    this.tDY = false;
    super.onDetach();
    AppMethodBeat.o(4927);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(4907);
    this.tDa.onStarted();
    this.tCZ.onStarted();
    super.onStart();
    AppMethodBeat.o(4907);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(4906);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "onStop");
    this.tDa.cPF();
    this.tCZ.cPF();
    if ((this.tDZ != null) && (this.tDZ.isHeld()))
    {
      ab.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      this.tDZ.release();
    }
    super.onStop();
    AppMethodBeat.o(4906);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(140183);
    if (this.tDM)
    {
      this.tCX.requestRender();
      AppMethodBeat.o(140183);
      return;
    }
    this.tCY.requestRender();
    AppMethodBeat.o(140183);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(4917);
    this.tDS = paramInt;
    ab.i("MicroMsg.Voip.VoipVideoFragment", "setHWDecMode, hwdec: %d, mIsSmallViewShowSelf:%b, before changeSurfaceRender", new Object[] { Integer.valueOf(this.tDS), Boolean.valueOf(this.tDM) });
    cPb();
    AppMethodBeat.o(4917);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(4920);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "setVoipBeauty isON:%d, mInitDone:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.tDN) });
    this.tDT = paramInt;
    if (!this.tDN)
    {
      AppMethodBeat.o(4920);
      return;
    }
    this.tDa.setVoipBeauty(this.tDT);
    this.tCZ.setVoipBeauty(this.tDT);
    AppMethodBeat.o(4920);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(4905);
    ab.b("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if (this.tCY != null) {
      this.tCY.setVisibility(4);
    }
    if (this.txe != null)
    {
      this.tCu.removeView(this.txe);
      this.txe = null;
      ab.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
    }
    if (this.tDR != null)
    {
      com.tencent.mm.sdk.g.d.ysm.remove(this.tDR);
      this.tDR = null;
    }
    super.uninit();
    AppMethodBeat.o(4905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment
 * JD-Core Version:    0.7.0.1
 */