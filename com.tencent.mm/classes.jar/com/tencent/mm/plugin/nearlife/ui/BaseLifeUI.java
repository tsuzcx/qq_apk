package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLifeUI
  extends MMActivity
  implements f
{
  boolean dZw = false;
  boolean eUJ = false;
  private com.tencent.mm.ui.tools.q eiV;
  protected boolean fBM = true;
  boolean gzX = false;
  protected String hng = "";
  private int oal = 1;
  MMLoadMoreListView ofL;
  private boolean ogA;
  public int ogt = -1;
  protected String ohe = "";
  private boolean pdi = false;
  private a peA;
  private a peB;
  private View peC;
  private TextView peD;
  private TextView peE;
  private com.tencent.mm.modelgeo.d peF = com.tencent.mm.modelgeo.d.agQ();
  private com.tencent.mm.plugin.nearlife.b.c peG;
  private int peH;
  private List<azt> peI;
  protected azt peJ = null;
  protected float peK = 0.0F;
  protected float peL = 0.0F;
  protected int peM = 0;
  protected float peN = 0.0F;
  protected long peO = -1L;
  protected long peP = -1L;
  protected long peQ = -1L;
  protected int peR = 0;
  protected boolean peS = false;
  protected int peT = -1;
  protected boolean peU = false;
  boolean peV = false;
  protected boolean peW = true;
  private View.OnClickListener peX = new BaseLifeUI.1(this);
  private View.OnClickListener peY = new BaseLifeUI.2(this);
  private b.a peZ = new BaseLifeUI.7(this);
  private String pek = "";
  private View pey;
  private NearLifeErrorContent pez;
  int sceneType = 0;
  
  private void AG(int paramInt)
  {
    this.ofL.removeFooterView(this.pey);
    this.ofL.removeFooterView(this.peC);
    this.ofL.dEb();
    this.peC.setVisibility(paramInt);
    this.peD.setVisibility(paramInt);
    this.peE.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.ofL.addFooterView(this.peC);
      return;
    }
    this.ofL.dDX();
    this.ofL.addFooterView(this.pey);
  }
  
  private void bWO()
  {
    if (!this.gzX) {
      ab.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }
    for (;;)
    {
      return;
      try
      {
        int i = Integer.valueOf(com.tencent.mm.m.g.Nq().getValue("POICreateForbiden")).intValue();
        ab.i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", new Object[] { Integer.valueOf(i) });
        if (i == 1) {}
      }
      catch (Exception localException)
      {
        label56:
        String str;
        break label56;
      }
    }
    if (!this.peB.VQ(this.peB.bWJ()))
    {
      str = String.format(getResources().getString(2131301844), new Object[] { this.peB.bWJ() });
      this.peD.setText(str);
      AG(0);
      return;
    }
    AG(8);
  }
  
  private boolean jR(boolean paramBoolean)
  {
    azt localazt;
    do
    {
      if (this.peG != null)
      {
        ab.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
      }
      if (this.peI.size() - 1 <= this.peH)
      {
        this.peH = -1;
        ab.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
        return false;
      }
      this.peH += 1;
      localazt = (azt)this.peI.get(this.peH);
      if (this.peH == 0) {
        this.peR += 1;
      }
      if (!this.gzX) {
        break;
      }
      i = this.peB.b(new BackwardSupportUtil.ExifHelper.LatLongData(localazt.wDi, localazt.wDh));
    } while (i <= 0);
    SKBuiltinBuffer_t localSKBuiltinBuffer_t;
    if (this.gzX)
    {
      localSKBuiltinBuffer_t = this.peB.a(new BackwardSupportUtil.ExifHelper.LatLongData(localazt.wDi, localazt.wDh));
      label166:
      if (!this.gzX) {
        break label249;
      }
    }
    label249:
    for (int i = 1;; i = 0)
    {
      if (com.tencent.mm.plugin.nearlife.b.c.AD(i)) {
        break label255;
      }
      this.peH = -1;
      return false;
      i = this.peA.b(new BackwardSupportUtil.ExifHelper.LatLongData(localazt.wDi, localazt.wDh));
      break;
      localSKBuiltinBuffer_t = this.peA.a(new BackwardSupportUtil.ExifHelper.LatLongData(localazt.wDi, localazt.wDh));
      break label166;
    }
    label255:
    if (-1L == this.peO) {
      this.peO = System.currentTimeMillis();
    }
    int j = this.sceneType;
    float f1 = localazt.wDh;
    float f2 = localazt.wDi;
    int k = localazt.wSk;
    int m = localazt.wSn;
    String str2 = localazt.wSl;
    String str3 = localazt.wSm;
    if (this.gzX) {}
    for (String str1 = this.peB.bWJ();; str1 = "")
    {
      this.peG = new com.tencent.mm.plugin.nearlife.b.c(i, j, f1, f2, k, m, str2, str3, localSKBuiltinBuffer_t, str1, this.ogt, paramBoolean, false);
      aw.Rc().a(this.peG, 0);
      ab.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", new Object[] { Integer.valueOf(this.peH), Float.valueOf(localazt.wDi), Float.valueOf(localazt.wDh) });
      return true;
    }
  }
  
  protected final void a(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    String str2 = paramString;
    if (paramString != null)
    {
      str2 = paramString;
      if (paramString.startsWith("mm_")) {
        str2 = "";
      }
    }
    Object localObject2 = "";
    int i;
    int j;
    label63:
    Object localObject1;
    String str1;
    if (paramInt >= 0) {
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          i = 43;
          if (this.peU)
          {
            paramString = h.qsU;
            if (!paramBoolean1) {
              break label402;
            }
            j = 5;
            paramString.e(11139, new Object[] { Integer.valueOf(j) });
          }
          if (!paramBoolean1) {
            break label408;
          }
          paramString = this.peB.AF(paramInt).ohd;
          localObject1 = paramString;
          if (this.peB.getCount() <= 0) {
            break label545;
          }
          str1 = this.peB.AF(1).ohe;
          localObject1 = paramString;
          paramString = str1;
        }
      }
    }
    for (;;)
    {
      label130:
      j = i;
      str1 = paramString;
      localObject2 = localObject1;
      if (bo.isNullOrNil(paramString))
      {
        str1 = this.ohe;
        localObject2 = localObject1;
        j = i;
      }
      if (this.peJ == null) {}
      for (paramString = "null/null";; paramString = String.format("%f/%f", new Object[] { Float.valueOf(this.peJ.wDi), Float.valueOf(this.peJ.wDh) }))
      {
        ab.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt + 1), str2, Integer.valueOf(paramInt), localObject2, str1 });
        h.qsU.e(11135, new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt + 1), Long.valueOf(this.peO), Long.valueOf(this.peQ), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.peP), Integer.valueOf(this.peR), paramString, str2, Integer.valueOf(this.ogt), localObject2, com.tencent.mm.compatible.e.q.bP(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
        return;
        i = 3;
        break;
        if (paramBoolean2)
        {
          i = 41;
          break;
        }
        i = 1;
        break;
        label402:
        j = 4;
        break label63;
        label408:
        str1 = this.peA.AF(paramInt).ohd;
        localObject1 = str1;
        if (this.peA.getCount() <= 0) {
          break label545;
        }
        paramString = this.peA.AF(1).ohe;
        localObject1 = str1;
        break label130;
        if (this.peS) {
          if (paramBoolean2) {
            i = 44;
          }
        }
        for (;;)
        {
          str1 = "";
          j = i;
          break;
          i = 4;
          continue;
          if (paramBoolean2) {
            i = 42;
          } else {
            i = 2;
          }
        }
      }
      label545:
      paramString = "";
    }
  }
  
  public abstract a bWL();
  
  public abstract a bWM();
  
  public void bWN()
  {
    ab.d("MicroMsg.BaseLifeUI", "init header");
    this.peC = View.inflate(this, 2130969285, null);
    this.peD = ((TextView)this.peC.findViewById(2131823272));
    this.peE = ((TextView)this.peC.findViewById(2131823271));
    this.peC.setOnClickListener(this.peY);
    this.pey = View.inflate(this, 2130970430, null);
    this.ofL.addFooterView(this.pey);
    this.pey.setVisibility(8);
  }
  
  public int getLayoutId()
  {
    return 2130970341;
  }
  
  public void initView()
  {
    this.ofL = ((MMLoadMoreListView)findViewById(2131826484));
    this.ofL.setFooterTips(getString(2131301746));
    this.pez = ((NearLifeErrorContent)findViewById(2131826485));
    bWN();
    this.peA = bWL();
    this.peB = bWM();
    this.ofL.setAdapter(this.peA);
    this.pez.setListView(this.ofL);
    this.peA.notifyDataSetChanged();
    setBackBtn(new BaseLifeUI.3(this));
    setToTop(new BaseLifeUI.4(this));
    this.eiV = new com.tencent.mm.ui.tools.q((byte)0);
    this.eiV.Axg = new BaseLifeUI.5(this);
    this.ofL.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void Kt()
      {
        AppMethodBeat.i(22946);
        BaseLifeUI.a(BaseLifeUI.this);
        AppMethodBeat.o(22946);
      }
    });
    this.ofL.dDY();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.d("MicroMsg.BaseLifeUI", "onActivityResult requestCode %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    setResult(-1, paramIntent);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.peW = getIntent().getBooleanExtra("poi_show_none", true);
    this.ogt = ((int)(System.currentTimeMillis() / 1000L));
    com.tencent.mm.plugin.nearlife.b.c.clear();
    aw.Rc().a(603, this);
    this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
    this.ohe = getIntent().getStringExtra("request_id");
    this.peI = new ArrayList();
    initView();
  }
  
  public void onDestroy()
  {
    aw.Rc().b(603, this);
    super.onDestroy();
    if (this.peF != null) {
      this.peF.c(this.peZ);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.peF.c(this.peZ);
  }
  
  public void onResume()
  {
    super.onResume();
    this.peA.notifyDataSetChanged();
    this.ofL.dEa();
    if (this.peF != null) {
      this.peF.a(this.peZ, true);
    }
    this.eUJ = false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() != 603) {
      return;
    }
    this.ofL.dDZ();
    com.tencent.mm.plugin.nearlife.b.c localc = (com.tencent.mm.plugin.nearlife.b.c)paramm;
    LogoImageView localLogoImageView;
    Object localObject;
    if (!bo.isNullOrNil(localc.pek))
    {
      this.pek = localc.pek;
      localLogoImageView = (LogoImageView)this.pey.findViewById(2131826759);
      localObject = this.pek;
      aw.aaz();
      localLogoImageView.imagePath = com.tencent.mm.model.c.YL();
      localLogoImageView.url = ((String)localObject);
      localLogoImageView.eRu = 0;
      localLogoImageView.eRv = 0;
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label168;
      }
      localLogoImageView.setVisibility(8);
    }
    int i;
    for (;;)
    {
      this.hng = localc.hng;
      this.oal = localc.oal;
      i = ((com.tencent.mm.plugin.nearlife.b.c)paramm).ctW;
      com.tencent.mm.plugin.nearlife.b.c.AE(i);
      if (this.peG != null) {
        break;
      }
      ab.d("MicroMsg.BaseLifeUI", "scene is null");
      return;
      label168:
      if (((String)localObject).startsWith("http"))
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(localLogoImageView.imagePath + com.tencent.mm.a.g.w(((String)localObject).getBytes()));
        if (localBitmap != null)
        {
          localObject = localBitmap;
          if (localLogoImageView.eRu > 0)
          {
            localObject = localBitmap;
            if (localLogoImageView.eRv > 0) {
              localObject = com.tencent.mm.sdk.platformtools.d.a(localBitmap, localLogoImageView.eRu, localLogoImageView.eRv, true, false);
            }
          }
          localLogoImageView.setImageBitmap((Bitmap)localObject);
        }
        else
        {
          com.tencent.mm.sdk.g.d.post(new LogoImageView.a((String)localObject, localLogoImageView.handler), "LogoImageView_download");
        }
      }
      else if (!com.tencent.mm.a.e.cN((String)localObject))
      {
        localLogoImageView.setVisibility(8);
      }
      else
      {
        if ((localLogoImageView.eRu <= 0) || (localLogoImageView.eRv <= 0)) {}
        for (localObject = com.tencent.mm.sdk.platformtools.d.aoV((String)localObject);; localObject = com.tencent.mm.sdk.platformtools.d.d((String)localObject, localLogoImageView.eRu, localLogoImageView.eRv, true))
        {
          if (localObject != null) {
            break label371;
          }
          localLogoImageView.setVisibility(8);
          break;
        }
        label371:
        localLogoImageView.setImageBitmap((Bitmap)localObject);
      }
    }
    ab.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", new Object[] { Integer.valueOf(this.peH), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
    if ((paramInt2 == 0) || (paramInt2 == 101))
    {
      i = 1;
      if ((paramInt1 == 0) || (i != 0)) {
        break label538;
      }
      ab.d("MicroMsg.BaseLifeUI", "error");
      if (!this.gzX) {
        break label530;
      }
      paramString = this.peB;
      label471:
      if ((this.peI.size() - 1 == this.peH) && (paramString.getCount() == 0))
      {
        paramString.pex = 1;
        this.pez.AH(paramString.pex);
      }
    }
    for (;;)
    {
      this.peG = null;
      jR(false);
      return;
      i = 0;
      break;
      label530:
      paramString = this.peA;
      break label471;
      label538:
      if (-1L == this.peP) {
        this.peP = System.currentTimeMillis();
      }
      this.peQ = System.currentTimeMillis();
      paramm = localc.pel;
      paramString = (azt)this.peI.get(this.peH);
      localObject = new BackwardSupportUtil.ExifHelper.LatLongData(paramString.wDi, paramString.wDh);
      if ((this.gzX) && (!this.peG.pem)) {
        this.peB.bWI();
      }
      if (this.gzX)
      {
        this.peB.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, localc.bWH(), localc.bWG());
        label654:
        if ((paramm != null) && (paramm.size() != 0)) {
          break label828;
        }
        if (!this.gzX) {
          break label820;
        }
      }
      label820:
      for (paramString = this.peB;; paramString = this.peA)
      {
        if (this.peI.size() - 1 == this.peH)
        {
          if (paramString.getCount() == 0) {
            this.pez.AH(paramString.pex);
          }
          this.ofL.dDZ();
          if ((!paramString.bWK()) && (paramInt2 != 101)) {
            bWO();
          }
        }
        if ((!this.peA.bWK()) && (this.pey != null) && (!this.gzX)) {
          this.pey.setVisibility(0);
        }
        if ((this.pey == null) || (this.gzX)) {
          break label926;
        }
        this.pey.setVisibility(0);
        break;
        this.peA.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, localc.bWH(), localc.bWG());
        break label654;
      }
      label828:
      if (this.gzX) {}
      for (paramString = this.peB;; paramString = this.peA)
      {
        this.ofL.setVisibility(0);
        paramString.pex = 0;
        this.pez.AH(this.peB.pex);
        paramString.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, paramm);
        paramString.notifyDataSetChanged();
        if ((this.peI.size() - 1 != this.peH) || (paramString.bWK())) {
          break;
        }
        this.ofL.dDZ();
        bWO();
        break;
      }
      label926:
      if (this.pey != null) {
        this.pey.setVisibility(8);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public abstract void p(double paramDouble1, double paramDouble2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI
 * JD-Core Version:    0.7.0.1
 */