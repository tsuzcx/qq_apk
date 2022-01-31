package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.mq;
import com.tencent.mm.g.b.a.t;
import com.tencent.mm.g.c.eg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.p.a;
import com.tencent.mm.plugin.scanner.util.p.b;
import com.tencent.mm.plugin.scanner.util.r.a;
import com.tencent.mm.plugin.scanner.util.r.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class ScanTranslationCaptureUI
  extends MMActivity
  implements Camera.PreviewCallback, TextureView.SurfaceTextureListener, f, p.b
{
  private SurfaceTexture bbI;
  private int cpt;
  private int eYe;
  private String fWT;
  private int fwt;
  private View gqb;
  private boolean gzb;
  private int iiX;
  private View qAA;
  private View qAB;
  private View qAC;
  private ImageView qAD;
  private View qAE;
  private View qAF;
  private View qAG;
  private TextView qAH;
  private Bitmap qAI;
  private Bitmap qAJ;
  private String qAK;
  private String qAL;
  private ScanTranslationCaptureUI.a qAM;
  private MMGestureGallery qAN;
  private ValueAnimator qAO;
  private ValueAnimator qAP;
  private int qAQ;
  private String qAR;
  private boolean qAS;
  private t qAT;
  private long[] qAU;
  private n qAV;
  private MMTextureView qAx;
  private View qAy;
  private View qAz;
  private j qvN;
  private ImageView qwk;
  private int qwo;
  private com.tencent.mm.sdk.b.c<mq> qwy;
  
  public ScanTranslationCaptureUI()
  {
    AppMethodBeat.i(81283);
    this.gzb = true;
    this.qwo = 0;
    this.cpt = 0;
    this.eYe = 0;
    this.qAT = new t();
    this.qAU = new long[2];
    this.qwy = new ScanTranslationCaptureUI.1(this);
    this.qAV = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(81268);
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(81267);
            if ((g.Rc().adt() != 6) && (g.Rc().adt() != 4) && (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1))
            {
              h.b(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131302918), "", true);
              ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
            }
            AppMethodBeat.o(81267);
          }
        });
        AppMethodBeat.o(81268);
      }
    };
    AppMethodBeat.o(81283);
  }
  
  private void P(Bitmap paramBitmap)
  {
    AppMethodBeat.i(138498);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(138498);
      return;
    }
    this.qAM.bitmap = paramBitmap;
    this.qAM.notifyDataSetChanged();
    AppMethodBeat.o(138498);
  }
  
  private void aFp()
  {
    AppMethodBeat.i(81301);
    getWindow().addFlags(2097280);
    int i = 1798;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 5894;
    }
    getWindow().getDecorView().setSystemUiVisibility(i);
    AppMethodBeat.o(81301);
  }
  
  private void bvO()
  {
    AppMethodBeat.i(81295);
    stopPreview();
    this.qvN.release();
    AppMethodBeat.o(81295);
  }
  
  private void ceV()
  {
    AppMethodBeat.i(81293);
    if (!com.tencent.mm.compatible.f.b.Me())
    {
      h.a(this, getString(2131297082), getString(2131297008), getString(2131297009), true, new ScanTranslationCaptureUI.9(this));
      AppMethodBeat.o(81293);
      return;
    }
    cjc();
    AppMethodBeat.o(81293);
  }
  
  private void ciB()
  {
    AppMethodBeat.i(81298);
    h.a(this, getString(2131302923), getString(2131297087), false, new ScanTranslationCaptureUI.13(this));
    AppMethodBeat.o(81298);
  }
  
  private void cja()
  {
    AppMethodBeat.i(81286);
    aa.dsG().equalsIgnoreCase("zh_CN");
    this.qAR = aa.gP(this);
    ab.i("MicroMsg.ScanTranslationCaptureUI", "targetLang %s", new Object[] { this.qAR });
    AppMethodBeat.o(81286);
  }
  
  private void cjb()
  {
    AppMethodBeat.i(81294);
    try
    {
      if (!this.qvN.isOpen())
      {
        long l = System.currentTimeMillis();
        this.qvN.open();
        this.qvN.a(new ScanTranslationCaptureUI.10(this));
        ab.i("MicroMsg.ScanTranslationCaptureUI", "open camera cost %s, failed count %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.qwo) });
        this.qvN.cjE();
        Rect localRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        this.qvN.f(new Point(localRect.width(), localRect.height()));
        if (this.fwt == 0) {
          cjf();
        }
        this.qwo = 0;
      }
      AppMethodBeat.o(81294);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      this.qwo += 1;
      if (this.qwo >= 5)
      {
        ciB();
        AppMethodBeat.o(81294);
        return;
      }
      al.p(new ScanTranslationCaptureUI.11(this), 30L);
      AppMethodBeat.o(81294);
    }
  }
  
  private void cjc()
  {
    AppMethodBeat.i(81299);
    ab.i("MicroMsg.ScanTranslationCaptureUI", "curState %d", new Object[] { Integer.valueOf(this.fwt) });
    if (!this.qvN.isOpen()) {
      cjb();
    }
    if ((this.fwt == 0) && (this.qvN.isOpen())) {
      cjf();
    }
    AppMethodBeat.o(81299);
  }
  
  private void cjd()
  {
    AppMethodBeat.i(81302);
    getController().setNavigationbarColor(getResources().getColor(2131690605));
    getWindow().getDecorView().setSystemUiVisibility(1796);
    AppMethodBeat.o(81302);
  }
  
  private void cje()
  {
    AppMethodBeat.i(81303);
    stopPreview();
    if ((g.Rc().adt() != 6) && (g.Rc().adt() != 4))
    {
      h.b(this, getString(2131302918), "", true);
      cjf();
      AppMethodBeat.o(81303);
      return;
    }
    this.qAT.cSM = 2L;
    this.qAQ = ((int)(com.tencent.mm.model.r.Zn().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
    this.fwt = 1;
    showTitleView();
    cjd();
    cja();
    if (this.qAR.equalsIgnoreCase("zh_CN"))
    {
      this.qAD.setImageResource(2131232133);
      this.qAF.setVisibility(0);
      this.qAG.setVisibility(0);
      this.qAC.setVisibility(8);
      this.qwk.setVisibility(0);
      this.qAB.setVisibility(8);
      this.qAN.setVisibility(0);
      this.qAH.setVisibility(8);
      this.qAO.setRepeatMode(1);
      this.qAO.setRepeatCount(-1);
      this.qAO.start();
    }
    try
    {
      if ((bo.isNullOrNil(this.fWT)) || (this.qAI == null)) {
        break label360;
      }
      this.qAL = com.tencent.mm.plugin.scanner.util.r.YO(this.fWT);
      str2 = this.fWT;
      if (this.cpt != 0) {
        break label390;
      }
      l = System.currentTimeMillis();
      d.a(this.qAI, 80, Bitmap.CompressFormat.JPEG, this.fWT, false);
      ab.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
      ab.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(com.tencent.mm.vfs.e.avI(this.fWT)) });
      localObject = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2;
        long l;
        Object localObject;
        label325:
        label360:
        ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localException, "", new Object[0]);
        label390:
        continue;
        ab.w("MicroMsg.ScanTranslationCaptureUI", "can not find old translation result!");
        String str1 = str2;
        if (this.eYe != 0)
        {
          l = System.currentTimeMillis();
          com.tencent.mm.plugin.scanner.e.chX();
          str1 = com.tencent.mm.plugin.scanner.e.Yv("jpg");
          d.a(this.qAI, 80, Bitmap.CompressFormat.JPEG, str1, false);
          ab.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          ab.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(com.tencent.mm.vfs.e.avI(str1)) });
        }
      }
    }
    this.qAU[1] = System.currentTimeMillis();
    com.tencent.mm.plugin.scanner.e.chX().qtu.a(this.qAL, (String)localObject, com.tencent.mm.i.a.MediaType_IMAGE, new r.a()
    {
      public final void a(String paramAnonymousString, r.b paramAnonymousb)
      {
        AppMethodBeat.i(138492);
        if ((!bo.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ScanTranslationCaptureUI.w(ScanTranslationCaptureUI.this))))
        {
          ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).cSN = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[1]));
          ab.i("MicroMsg.ScanTranslationCaptureUI", "upload img cost %d", new Object[] { Long.valueOf(ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).cSN) });
          switch (paramAnonymousb.errCode)
          {
          }
        }
        for (;;)
        {
          if ((ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1) && (ScanTranslationCaptureUI.y(ScanTranslationCaptureUI.this) != 0))
          {
            ab.i("delete tmp path %s", this.qtK);
            com.tencent.mm.vfs.e.deleteFile(this.qtK);
          }
          AppMethodBeat.o(138492);
          return;
          if (!bo.Q(new String[] { paramAnonymousb.fileId, paramAnonymousb.aeskey }))
          {
            ab.i("MicroMsg.ScanTranslationCaptureUI", "fileId %s", new Object[] { paramAnonymousb.fileId });
            paramAnonymousString = new com.tencent.mm.plugin.scanner.model.e(ScanTranslationCaptureUI.x(ScanTranslationCaptureUI.this), com.tencent.mm.a.e.cM(this.qtK), paramAnonymousb.fileId, paramAnonymousb.aeskey);
            g.Rc().a(paramAnonymousString, 0);
          }
          else
          {
            al.d(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(138489);
                ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).cSM = 3L;
                h.bO(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131302944));
                AppMethodBeat.o(138489);
              }
            });
            continue;
            al.d(new ScanTranslationCaptureUI.7.2(this));
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).cSM = 3L;
          }
        }
      }
    });
    for (;;)
    {
      g.Rc().a(294, this);
      AppMethodBeat.o(81303);
      return;
      this.qAD.setImageResource(2131232136);
      break;
      localObject = str2;
      if (this.cpt != 1) {
        break label325;
      }
      localObject = ag.cE(this.fWT + com.tencent.mm.vfs.e.avJ(this.fWT));
      localObject = com.tencent.mm.plugin.scanner.e.chX().cic().Yz((String)localObject);
      if (localObject == null) {
        break label533;
      }
      ab.i("MicroMsg.ScanTranslationCaptureUI", "already has translation result");
      this.qAK = ((eg)localObject).field_resultFile;
      this.qAJ = d.decodeFile(this.qAK, new BitmapFactory.Options());
      if (this.qAJ == null) {
        break label524;
      }
      al.p(new ScanTranslationCaptureUI.6(this), 500L);
    }
  }
  
  private void cjf()
  {
    AppMethodBeat.i(81304);
    aFp();
    startPreview();
    hideTitleView();
    this.qAU[0] = System.currentTimeMillis();
    if ((this.cpt == 0) && (!bo.isNullOrNil(this.fWT))) {
      com.tencent.mm.vfs.e.deleteFile(this.fWT);
    }
    this.qvN.cancelAutoFocus();
    this.fwt = 0;
    this.cpt = 0;
    this.fWT = null;
    this.qAK = null;
    this.qAI = null;
    this.qAJ = null;
    this.eYe = 0;
    this.qAF.setVisibility(8);
    this.qAG.setVisibility(8);
    this.qAB.setVisibility(0);
    this.qAC.setVisibility(8);
    this.qAN.setVisibility(8);
    this.qAx.setVisibility(0);
    this.qAH.setVisibility(0);
    this.qwk.setVisibility(8);
    cjh();
    g.Rc().b(294, this);
    AppMethodBeat.o(81304);
  }
  
  private void cjg()
  {
    AppMethodBeat.i(81305);
    cjd();
    this.fwt = 3;
    this.qAC.setVisibility(0);
    if (this.qAR.equalsIgnoreCase("zh_CN")) {
      this.qAD.setImageResource(2130840623);
    }
    for (;;)
    {
      this.qwk.setVisibility(8);
      cjh();
      if ((this.cpt != 1) || (!bo.isNullOrNil(this.qAK))) {
        break label223;
      }
      com.tencent.mm.plugin.scanner.e.chX();
      this.qAK = com.tencent.mm.plugin.scanner.e.Yu("jpg");
      try
      {
        d.a(this.qAJ, 80, Bitmap.CompressFormat.JPEG, this.qAK, false);
        com.tencent.mm.plugin.scanner.model.q localq = new com.tencent.mm.plugin.scanner.model.q();
        localq.field_originMD5 = ag.cE(this.fWT + com.tencent.mm.vfs.e.avJ(this.fWT));
        localq.field_resultFile = this.qAK;
        ab.i("MicroMsg.ScanTranslationCaptureUI", "insert translate result %s", new Object[] { this.qAK });
        com.tencent.mm.plugin.scanner.e.chX().cic().insert(localq);
        AppMethodBeat.o(81305);
        return;
      }
      catch (IOException localIOException)
      {
        ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localIOException, "save translate result file error", new Object[0]);
      }
      this.qAD.setImageResource(2130840625);
    }
    label223:
    AppMethodBeat.o(81305);
  }
  
  private void cjh()
  {
    AppMethodBeat.i(81306);
    this.qAO.setRepeatMode(1);
    this.qAO.setRepeatCount(0);
    this.qAO.end();
    AppMethodBeat.o(81306);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(81292);
    com.tencent.mm.plugin.scanner.e.chX().qtv.cjM();
    if (this.fwt == 0)
    {
      if (this.qAS)
      {
        ab.i("MicroMsg.ScanTranslationCaptureUI", "is playing animation");
        AppMethodBeat.o(81292);
        return;
      }
      this.qAP.addListener(new ScanTranslationCaptureUI.8(this));
      this.qAP.reverse();
      this.qAS = true;
      AppMethodBeat.o(81292);
      return;
    }
    if ((this.fwt == 1) || (this.fwt == 2) || (this.fwt == 3))
    {
      if (this.fwt == 1) {
        this.qAT.cSP = ((int)(System.currentTimeMillis() - this.qAU[1]));
      }
      if (this.qAT.cSM != 0L) {
        this.qAT.ake();
      }
      cjf();
    }
    AppMethodBeat.o(81292);
  }
  
  private void startPreview()
  {
    AppMethodBeat.i(81297);
    try
    {
      if ((this.bbI != null) && (this.qvN.isOpen()) && (!this.qvN.miS))
      {
        ab.i("MicroMsg.ScanTranslationCaptureUI", "start preview");
        this.qvN.k(this.bbI);
        this.qAz.setEnabled(true);
        AppMethodBeat.o(81297);
        return;
      }
      ab.i("MicroMsg.ScanTranslationCaptureUI", "can not start preview");
      AppMethodBeat.o(81297);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      ciB();
      AppMethodBeat.o(81297);
    }
  }
  
  private void stopPreview()
  {
    AppMethodBeat.i(81296);
    try
    {
      if (this.qvN.miS) {
        this.qvN.stopPreview();
      }
      AppMethodBeat.o(81296);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      ciB();
      AppMethodBeat.o(81296);
    }
  }
  
  public final void b(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(81311);
    if ((paramBitmap != null) && (paramInt == this.qAQ))
    {
      this.qAT.cSP = ((int)(System.currentTimeMillis() - this.qAU[1]));
      this.qAJ = paramBitmap;
      cjg();
      P(this.qAJ);
    }
    AppMethodBeat.o(81311);
  }
  
  public int getLayoutId()
  {
    return 2130970612;
  }
  
  public void initView()
  {
    AppMethodBeat.i(81285);
    this.gqb = findViewById(2131823717);
    this.gqb.setAlpha(0.0F);
    this.qAx = ((MMTextureView)findViewById(2131827438));
    this.qAx.setOpaque(false);
    this.qAx.setSurfaceTextureListener(this);
    this.qAN = ((MMGestureGallery)findViewById(2131827439));
    this.qAM = new ScanTranslationCaptureUI.a(this, (byte)0);
    this.qAN.setAdapter(this.qAM);
    this.qAB = findViewById(2131827443);
    this.qAy = findViewById(2131825087);
    this.qAy.setOnClickListener(new ScanTranslationCaptureUI.18(this));
    this.qAz = findViewById(2131827444);
    this.qAz.setOnClickListener(new ScanTranslationCaptureUI.19(this));
    this.qAz.setEnabled(false);
    this.qAH = ((TextView)findViewById(2131827442));
    this.qAA = findViewById(2131827445);
    this.qAA.setOnClickListener(new ScanTranslationCaptureUI.20(this));
    this.qAC = findViewById(2131827446);
    this.qAD = ((ImageView)this.qAC.findViewById(2131827447));
    this.qAD.setOnClickListener(new ScanTranslationCaptureUI.21(this));
    this.qAF = findViewById(2131827440);
    this.qAG = findViewById(2131827441);
    hideTitleView();
    setMMTitle(2131302894);
    setActionbarColor(getResources().getColor(2131690605));
    this.qwk = ((ImageView)findViewById(2131827417));
    this.qAE = this.qAC.findViewById(2131827448);
    this.qAE.setOnClickListener(new ScanTranslationCaptureUI.22(this));
    setBackBtn(new ScanTranslationCaptureUI.23(this));
    this.iiX = getWindowManager().getDefaultDisplay().getHeight();
    this.qAO = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.qAO.addListener(new ScanTranslationCaptureUI.24(this));
    this.qAO.addUpdateListener(new ScanTranslationCaptureUI.2(this));
    Object localObject = (RelativeLayout.LayoutParams)this.qAC.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin += af.fx(this);
    this.qAC.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.qAO.setDuration(5000L);
    com.tencent.mm.ui.base.b.a(this, null);
    this.gqb.setOnTouchListener(new ScanTranslationCaptureUI.3(this));
    cja();
    this.qAP = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.qAP.addUpdateListener(new ScanTranslationCaptureUI.4(this));
    this.qAP.addListener(new ScanTranslationCaptureUI.5(this));
    this.qAP.setDuration(300L);
    localObject = new mq();
    ((mq)localObject).cCN.action = 1;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(81285);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(81312);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 561) && (paramInt2 == -1))
    {
      paramIntent = com.tencent.mm.ui.tools.a.i(this, paramIntent, com.tencent.mm.plugin.i.c.YK());
      ab.i("MicroMsg.ScanTranslationCaptureUI", "select: [%s]", new Object[] { paramIntent });
      if (!bo.isNullOrNil(paramIntent))
      {
        this.fWT = paramIntent;
        this.cpt = 1;
        this.qAT.cSK = 2L;
        this.eYe = Exif.fromFile(paramIntent).getOrientationInDegree();
        ab.i("MicroMsg.ScanTranslationCaptureUI", "degree %s", new Object[] { Integer.valueOf(this.eYe) });
        paramIntent = d.decodeFile(paramIntent, new BitmapFactory.Options());
        if (paramIntent != null)
        {
          this.qAI = d.b(paramIntent, this.eYe);
          cje();
          P(this.qAI);
        }
      }
    }
    AppMethodBeat.o(81312);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(81284);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.qvN = new j(this, 3, false);
    initView();
    com.tencent.mm.sdk.b.a.ymk.c(this.qwy);
    this.qAT.cSK = 3L;
    AppMethodBeat.o(81284);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(81291);
    super.onDestroy();
    this.qAP.removeAllUpdateListeners();
    this.qAO.removeAllUpdateListeners();
    AppMethodBeat.o(81291);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(81289);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(81289);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(81289);
    return bool;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(81308);
    ab.i("MicroMsg.ScanTranslationCaptureUI", "get preview frame success, length %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length > 0)
      {
        this.qAI = null;
        long l = System.currentTimeMillis();
        paramCamera = this.qvN.miT;
        paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramCamera.x, paramCamera.y, null);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramArrayOfByte.compressToJpeg(new Rect(0, 0, paramCamera.x, paramCamera.y), 100, localByteArrayOutputStream);
        paramArrayOfByte = d.bT(localByteArrayOutputStream.toByteArray());
        int i = (int)(System.currentTimeMillis() - l);
        if (paramArrayOfByte != null)
        {
          l = System.currentTimeMillis();
          this.qAI = d.b(paramArrayOfByte, this.qvN.miX);
          ab.i("MicroMsg.ScanTranslationCaptureUI", "decode cost %d, rotate cost %d", new Object[] { Integer.valueOf(i), Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          if (this.qAI != null)
          {
            com.tencent.mm.plugin.scanner.e.chX();
            this.fWT = (com.tencent.mm.plugin.scanner.e.chZ() + String.format("%s_%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
            cje();
            P(this.qAI);
          }
        }
      }
      AppMethodBeat.o(81308);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(81308);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(81300);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(81300);
      return;
    }
    ab.i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(81300);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        ceV();
        AppMethodBeat.o(81300);
        return;
      }
      this.gzb = false;
      h.a(this, getString(2131302067), getString(2131302083), getString(2131300996), getString(2131296888), false, new DialogInterface.OnClickListener()new ScanTranslationCaptureUI.15
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(81270);
          ScanTranslationCaptureUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
          ScanTranslationCaptureUI.B(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(81270);
        }
      }, new ScanTranslationCaptureUI.15(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(81288);
    super.onResume();
    aFp();
    g.Rc().a(294, this);
    g.RK().a(this.qAV);
    if (this.gzb)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      ab.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(81288);
        return;
      }
      ceV();
      AppMethodBeat.o(81288);
      return;
    }
    cjc();
    AppMethodBeat.o(81288);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(81309);
    ab.i("MicroMsg.ScanTranslationCaptureUI", "errType %s, errCode %s, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.scanner.model.e)paramm).quk;
      if ((paramString != null) && (((com.tencent.mm.plugin.scanner.model.e)paramm).cnU == this.qAQ))
      {
        this.qAT.cSO = ((int)(System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.model.e)paramm).qul));
        ab.i("MicroMsg.ScanTranslationCaptureUI", "angle %f, translationInfos length %d", new Object[] { Float.valueOf(((com.tencent.mm.plugin.scanner.model.e)paramm).angle), Integer.valueOf(paramString.size()) });
        if (paramString.size() > 0)
        {
          this.qAT.cSM = 1L;
          com.tencent.mm.plugin.scanner.util.p localp = com.tencent.mm.plugin.scanner.e.chX().qtv;
          paramInt1 = this.qAQ;
          float f = ((com.tencent.mm.plugin.scanner.model.e)paramm).angle;
          Bitmap localBitmap = this.qAI;
          if ((paramInt1 != 0) && (paramString != null) && (paramString.size() > 0))
          {
            if ((localp.qDz != 0) && (paramInt1 != localp.qDz))
            {
              ab.i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", new Object[] { Integer.valueOf(localp.qDz), Integer.valueOf(paramInt1) });
              localp.cjM();
            }
            localp.qDz = paramInt1;
            localp.qDA = this;
            localp.qDB = new p.a(localp, paramInt1, paramString, f, localBitmap);
            localp.qDB.v(new Void[0]);
          }
          if (!bo.isNullOrNil(((com.tencent.mm.plugin.scanner.model.e)paramm).cie()))
          {
            this.qAR = ((com.tencent.mm.plugin.scanner.model.e)paramm).cie();
            AppMethodBeat.o(81309);
          }
        }
        else
        {
          this.qAT.cSP = ((int)(System.currentTimeMillis() - this.qAU[1]));
          h.a(this, getString(2131302944), "", false, new ScanTranslationCaptureUI.16(this));
        }
      }
      AppMethodBeat.o(81309);
      return;
    }
    this.qAT.cSM = 5L;
    this.qAT.cSP = ((int)(System.currentTimeMillis() - this.qAU[1]));
    paramm = getString(2131302944);
    if (!bo.isNullOrNil(paramString)) {}
    for (;;)
    {
      h.a(this, paramString, "", false, new ScanTranslationCaptureUI.17(this));
      AppMethodBeat.o(81309);
      return;
      paramString = paramm;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(81290);
    super.onStop();
    bvO();
    g.Rc().b(294, this);
    com.tencent.mm.sdk.b.a.ymk.d(this.qwy);
    g.RK().b(this.qAV);
    AppMethodBeat.o(81290);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(81307);
    ab.i("MicroMsg.ScanTranslationCaptureUI", "surface texture available");
    this.qAx.dEs();
    this.bbI = paramSurfaceTexture;
    if (this.gzb)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      ab.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(81307);
        return;
      }
      ceV();
      AppMethodBeat.o(81307);
      return;
    }
    if (!this.qvN.isOpen())
    {
      cjb();
      AppMethodBeat.o(81307);
      return;
    }
    cjf();
    AppMethodBeat.o(81307);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI
 * JD-Core Version:    0.7.0.1
 */