package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseLifeUI
  extends MMActivity
  implements f
{
  boolean dic = false;
  private n drn;
  boolean edT = false;
  protected boolean elu = true;
  protected String fTF = "";
  boolean fiq = false;
  private int lCZ = 1;
  MMLoadMoreListView lIy;
  protected String lJQ = "";
  public int lJg = -1;
  private boolean mDo = false;
  private TextView mEA;
  private TextView mEB;
  private com.tencent.mm.modelgeo.c mEC = com.tencent.mm.modelgeo.c.Ob();
  private com.tencent.mm.plugin.nearlife.b.c mED;
  private int mEE;
  private List<ato> mEF;
  protected ato mEG = null;
  protected float mEH = 0.0F;
  protected float mEI = 0.0F;
  protected int mEJ = 0;
  protected float mEK = 0.0F;
  protected long mEL = -1L;
  protected long mEM = -1L;
  protected long mEN = -1L;
  protected int mEO = 0;
  protected boolean mEP = false;
  protected int mEQ = -1;
  protected boolean mER = false;
  private View.OnClickListener mES = new BaseLifeUI.1(this);
  private View.OnClickListener mET = new BaseLifeUI.2(this);
  private a.a mEU = new BaseLifeUI.7(this);
  private String mEi = "";
  private View mEv;
  private NearLifeErrorContent mEw;
  private a mEx;
  private a mEy;
  private View mEz;
  int sceneType = 0;
  
  private void bop()
  {
    if (!this.fiq) {
      y.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }
    for (;;)
    {
      return;
      try
      {
        i = Integer.valueOf(com.tencent.mm.m.g.AA().getValue("POICreateForbiden")).intValue();
        y.i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", new Object[] { Integer.valueOf(i) });
        if (i == 1) {}
      }
      catch (Exception localException)
      {
        int i;
        label56:
        Object localObject;
        String str;
        break label56;
      }
    }
    localObject = this.mEy;
    str = this.mEy.bok().trim();
    localObject = ((a)localObject).mEm.iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (!str.equals(((com.tencent.mm.plugin.nearlife.b.a)((Iterator)localObject).next()).bGw.trim()));
    for (i = 1; i == 0; i = 0)
    {
      str = String.format(getResources().getString(R.l.nl_create_poi_tips), new Object[] { this.mEy.bok() });
      this.mEA.setText(str);
      vi(0);
      return;
    }
    vi(8);
  }
  
  private boolean hV(boolean paramBoolean)
  {
    ato localato;
    do
    {
      if (this.mED != null)
      {
        y.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
      }
      if (this.mEF.size() - 1 <= this.mEE)
      {
        this.mEE = -1;
        y.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
        return false;
      }
      this.mEE += 1;
      localato = (ato)this.mEF.get(this.mEE);
      if (this.mEE == 0) {
        this.mEO += 1;
      }
      if (!this.fiq) {
        break;
      }
      i = this.mEy.b(new BackwardSupportUtil.ExifHelper.LatLongData(localato.sGK, localato.sGJ));
    } while (i <= 0);
    bmk localbmk;
    if (this.fiq)
    {
      localbmk = this.mEy.a(new BackwardSupportUtil.ExifHelper.LatLongData(localato.sGK, localato.sGJ));
      label166:
      if (!this.fiq) {
        break label249;
      }
    }
    label249:
    for (int i = 1;; i = 0)
    {
      if (com.tencent.mm.plugin.nearlife.b.c.vf(i)) {
        break label255;
      }
      this.mEE = -1;
      return false;
      i = this.mEx.b(new BackwardSupportUtil.ExifHelper.LatLongData(localato.sGK, localato.sGJ));
      break;
      localbmk = this.mEx.a(new BackwardSupportUtil.ExifHelper.LatLongData(localato.sGK, localato.sGJ));
      break label166;
    }
    label255:
    if (-1L == this.mEL) {
      this.mEL = System.currentTimeMillis();
    }
    int j = this.sceneType;
    float f1 = localato.sGJ;
    float f2 = localato.sGK;
    int k = localato.sUn;
    int m = localato.sUq;
    String str2 = localato.sUo;
    String str3 = localato.sUp;
    if (this.fiq) {}
    for (String str1 = this.mEy.bok();; str1 = "")
    {
      this.mED = new com.tencent.mm.plugin.nearlife.b.c(i, j, f1, f2, k, m, str2, str3, localbmk, str1, this.lJg, paramBoolean, false);
      au.Dk().a(this.mED, 0);
      y.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", new Object[] { Integer.valueOf(this.mEE), Float.valueOf(localato.sGK), Float.valueOf(localato.sGJ) });
      return true;
    }
  }
  
  private void vi(int paramInt)
  {
    this.lIy.removeFooterView(this.mEv);
    this.lIy.removeFooterView(this.mEz);
    MMLoadMoreListView localMMLoadMoreListView = this.lIy;
    localMMLoadMoreListView.removeFooterView(localMMLoadMoreListView.jcy);
    this.mEz.setVisibility(paramInt);
    this.mEA.setVisibility(paramInt);
    this.mEB.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.lIy.addFooterView(this.mEz);
      return;
    }
    localMMLoadMoreListView = this.lIy;
    if (localMMLoadMoreListView.jcy == null) {
      localMMLoadMoreListView.cAN();
    }
    try
    {
      localMMLoadMoreListView.removeFooterView(localMMLoadMoreListView.jcy);
      localMMLoadMoreListView.addFooterView(localMMLoadMoreListView.jcy);
      label111:
      this.lIy.addFooterView(this.mEv);
      return;
    }
    catch (Exception localException)
    {
      break label111;
    }
  }
  
  protected final void a(int paramInt, boolean paramBoolean, String paramString)
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
    label57:
    Object localObject1;
    String str1;
    if (paramInt >= 0) {
      if (paramBoolean)
      {
        i = 3;
        if (this.mER)
        {
          paramString = h.nFQ;
          if (!paramBoolean) {
            break label377;
          }
          j = 5;
          paramString.f(11139, new Object[] { Integer.valueOf(j) });
        }
        if (!paramBoolean) {
          break label383;
        }
        paramString = this.mEy.vh(paramInt).lJP;
        localObject1 = paramString;
        if (this.mEy.getCount() <= 0) {
          break label496;
        }
        str1 = this.mEy.vh(1).lJQ;
        localObject1 = paramString;
        paramString = str1;
      }
    }
    for (;;)
    {
      label124:
      j = i;
      str1 = paramString;
      localObject2 = localObject1;
      if (bk.bl(paramString))
      {
        str1 = this.lJQ;
        localObject2 = localObject1;
        j = i;
      }
      if (this.mEG == null) {}
      for (paramString = "null/null";; paramString = String.format("%f/%f", new Object[] { Float.valueOf(this.mEG.sGK), Float.valueOf(this.mEG.sGJ) }))
      {
        y.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt + 1), str2, Integer.valueOf(paramInt), localObject2, str1 });
        h.nFQ.f(11135, new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt + 1), Long.valueOf(this.mEL), Long.valueOf(this.mEN), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.mEM), Integer.valueOf(this.mEO), paramString, str2, Integer.valueOf(this.lJg), localObject2, q.zf(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
        return;
        i = 1;
        break;
        label377:
        j = 4;
        break label57;
        label383:
        str1 = this.mEx.vh(paramInt).lJP;
        localObject1 = str1;
        if (this.mEx.getCount() <= 0) {
          break label496;
        }
        paramString = this.mEx.vh(1).lJQ;
        localObject1 = str1;
        break label124;
        if (this.mEP) {}
        for (i = 4;; i = 2)
        {
          str1 = "";
          j = i;
          break;
        }
      }
      label496:
      paramString = "";
    }
  }
  
  public abstract a bom();
  
  public abstract a bon();
  
  public void boo()
  {
    y.d("MicroMsg.BaseLifeUI", "init header");
    this.mEz = View.inflate(this, R.i.create_poi_tips_footer, null);
    this.mEA = ((TextView)this.mEz.findViewById(R.h.tv_create_poi_tips));
    this.mEB = ((TextView)this.mEz.findViewById(R.h.tv_create_not_found_poi_tips));
    this.mEz.setOnClickListener(this.mET);
    this.mEv = View.inflate(this, R.i.power_by_footer, null);
    this.lIy.addFooterView(this.mEv);
    this.mEv.setVisibility(8);
  }
  
  protected int getLayoutId()
  {
    return R.i.near_life_ui;
  }
  
  public final void initView()
  {
    this.lIy = ((MMLoadMoreListView)findViewById(R.h.near_life_list));
    this.lIy.setFooterTips(getString(R.l.near_life_searching));
    this.mEw = ((NearLifeErrorContent)findViewById(R.h.near_life_errcontent));
    boo();
    this.mEx = bom();
    this.mEy = bon();
    this.lIy.setAdapter(this.mEx);
    this.mEw.setListView(this.lIy);
    this.mEx.notifyDataSetChanged();
    setBackBtn(new BaseLifeUI.3(this));
    new BaseLifeUI.4(this);
    this.drn = new n((byte)0);
    this.drn.weq = new BaseLifeUI.5(this);
    this.lIy.setOnLoadMoreListener(new BaseLifeUI.6(this));
    this.lIy.cAO();
  }
  
  public abstract void m(double paramDouble1, double paramDouble2);
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.d("MicroMsg.BaseLifeUI", "onActivityResult requestCode %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
    this.lJg = ((int)(System.currentTimeMillis() / 1000L));
    com.tencent.mm.plugin.nearlife.b.c.clear();
    au.Dk().a(603, this);
    this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
    this.lJQ = getIntent().getStringExtra("request_id");
    this.mEF = new ArrayList();
    initView();
    this.lIy.cAQ();
    if (this.mEC != null) {
      this.mEC.b(this.mEU);
    }
    this.edT = false;
  }
  
  protected void onDestroy()
  {
    au.Dk().b(603, this);
    super.onDestroy();
    if (this.mEC != null) {
      this.mEC.c(this.mEU);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.mEC.c(this.mEU);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mEx.notifyDataSetChanged();
    this.mEC.a(this.mEU, true);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() != 603) {
      return;
    }
    this.lIy.cAP();
    com.tencent.mm.plugin.nearlife.b.c localc = (com.tencent.mm.plugin.nearlife.b.c)paramm;
    LogoImageView localLogoImageView;
    Object localObject;
    if (!bk.bl(localc.mEi))
    {
      this.mEi = localc.mEi;
      localLogoImageView = (LogoImageView)this.mEv.findViewById(R.h.pwoer_by_logo_iv);
      localObject = this.mEi;
      au.Hx();
      localLogoImageView.imagePath = com.tencent.mm.model.c.FH();
      localLogoImageView.url = ((String)localObject);
      localLogoImageView.eIB = 0;
      localLogoImageView.eIC = 0;
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label168;
      }
      localLogoImageView.setVisibility(8);
    }
    int i;
    for (;;)
    {
      this.fTF = localc.fTF;
      this.lCZ = localc.lCZ;
      i = ((com.tencent.mm.plugin.nearlife.b.c)paramm).bMC;
      com.tencent.mm.plugin.nearlife.b.c.vg(i);
      if (this.mED != null) {
        break;
      }
      y.d("MicroMsg.BaseLifeUI", "scene is null");
      return;
      label168:
      if (((String)localObject).startsWith("http"))
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(localLogoImageView.imagePath + com.tencent.mm.a.g.o(((String)localObject).getBytes()));
        if (localBitmap != null)
        {
          localObject = localBitmap;
          if (localLogoImageView.eIB > 0)
          {
            localObject = localBitmap;
            if (localLogoImageView.eIC > 0) {
              localObject = com.tencent.mm.sdk.platformtools.c.a(localBitmap, localLogoImageView.eIB, localLogoImageView.eIC, true, false);
            }
          }
          localLogoImageView.setImageBitmap((Bitmap)localObject);
        }
        else
        {
          com.tencent.mm.sdk.f.e.post(new LogoImageView.a((String)localObject, localLogoImageView.handler), "LogoImageView_download");
        }
      }
      else if (!com.tencent.mm.a.e.bK((String)localObject))
      {
        localLogoImageView.setVisibility(8);
      }
      else
      {
        if ((localLogoImageView.eIB <= 0) || (localLogoImageView.eIC <= 0)) {}
        for (localObject = com.tencent.mm.sdk.platformtools.c.YW((String)localObject);; localObject = com.tencent.mm.sdk.platformtools.c.e((String)localObject, localLogoImageView.eIB, localLogoImageView.eIC, true))
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
    y.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", new Object[] { Integer.valueOf(this.mEE), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
    if ((paramInt2 == 0) || (paramInt2 == 101))
    {
      i = 1;
      if ((paramInt1 == 0) || (i != 0)) {
        break label538;
      }
      y.d("MicroMsg.BaseLifeUI", "error");
      if (!this.fiq) {
        break label530;
      }
      paramString = this.mEy;
      label471:
      if ((this.mEF.size() - 1 == this.mEE) && (paramString.getCount() == 0))
      {
        paramString.mEu = 1;
        this.mEw.vj(paramString.mEu);
      }
    }
    for (;;)
    {
      this.mED = null;
      hV(false);
      return;
      i = 0;
      break;
      label530:
      paramString = this.mEx;
      break label471;
      label538:
      if (-1L == this.mEM) {
        this.mEM = System.currentTimeMillis();
      }
      this.mEN = System.currentTimeMillis();
      paramm = localc.mEj;
      paramString = (ato)this.mEF.get(this.mEE);
      localObject = new BackwardSupportUtil.ExifHelper.LatLongData(paramString.sGK, paramString.sGJ);
      if ((this.fiq) && (!this.mED.mEk)) {
        this.mEy.boj();
      }
      if (this.fiq)
      {
        this.mEy.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, localc.boi(), localc.boh());
        label654:
        if ((paramm != null) && (paramm.size() != 0)) {
          break label828;
        }
        if (!this.fiq) {
          break label820;
        }
      }
      label820:
      for (paramString = this.mEy;; paramString = this.mEx)
      {
        if (this.mEF.size() - 1 == this.mEE)
        {
          if (paramString.getCount() == 0) {
            this.mEw.vj(paramString.mEu);
          }
          this.lIy.cAP();
          if ((!paramString.bol()) && (paramInt2 != 101)) {
            bop();
          }
        }
        if ((!this.mEx.bol()) && (this.mEv != null) && (!this.fiq)) {
          this.mEv.setVisibility(0);
        }
        if ((this.mEv == null) || (this.fiq)) {
          break label935;
        }
        this.mEv.setVisibility(0);
        break;
        this.mEx.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, localc.boi(), localc.boh());
        break label654;
      }
      label828:
      if (this.fiq) {}
      for (paramString = this.mEy;; paramString = this.mEx)
      {
        boolean bool = this.mED.mEk;
        this.lIy.setVisibility(0);
        paramString.mEu = 0;
        this.mEw.vj(this.mEy.mEu);
        paramString.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, paramm);
        paramString.notifyDataSetChanged();
        if ((this.mEF.size() - 1 != this.mEE) || (paramString.bol())) {
          break;
        }
        this.lIy.cAP();
        bop();
        break;
      }
      label935:
      if (this.mEv != null) {
        this.mEv.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI
 * JD-Core Version:    0.7.0.1
 */