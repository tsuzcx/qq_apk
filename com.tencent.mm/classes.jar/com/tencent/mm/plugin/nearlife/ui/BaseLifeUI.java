package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.m.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLifeUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String dct = "";
  protected String dnB = "";
  boolean fjF = false;
  private r fvI;
  boolean gqP = false;
  protected boolean hem = true;
  boolean inh = false;
  protected String jko = "";
  private int sOL = 1;
  MMLoadMoreListView sUz;
  public int sVb = -1;
  private boolean sVh;
  int sceneType = 0;
  private boolean uaF = false;
  private View ubX;
  private NearLifeErrorContent ubY;
  private a ubZ;
  private a uca;
  private View ucb;
  private TextView ucc;
  private TextView ucd;
  private com.tencent.mm.modelgeo.d uce = com.tencent.mm.modelgeo.d.axT();
  private com.tencent.mm.plugin.nearlife.b.d ucf;
  private int ucg;
  private List<bld> uch;
  protected bld uci = null;
  protected float ucj = 0.0F;
  protected float uck = 0.0F;
  protected int ucl = 0;
  protected float ucm = 0.0F;
  protected long ucn = -1L;
  protected long uco = -1L;
  protected long ucp = -1L;
  protected int ucq = 0;
  protected boolean ucr = false;
  protected int ucs = -1;
  protected boolean uct = false;
  boolean ucu = false;
  protected boolean ucv = true;
  private View.OnClickListener ucw = new BaseLifeUI.1(this);
  private View.OnClickListener ucx = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(26561);
      if (BaseLifeUI.this.uci == null)
      {
        ad.e("MicroMsg.BaseLifeUI", "Location is null");
        AppMethodBeat.o(26561);
        return;
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(11138, new Object[] { "1", Integer.valueOf(BaseLifeUI.b(BaseLifeUI.this).getCount() + 1), BaseLifeUI.this.jko });
      paramAnonymousView = new Intent();
      paramAnonymousView.setClass(BaseLifeUI.this, NearLifeCreatePoiUI.class);
      paramAnonymousView.putExtra("get_lat", BaseLifeUI.this.uci.COJ);
      paramAnonymousView.putExtra("get_lng", BaseLifeUI.this.uci.COI);
      paramAnonymousView.putExtra("get_preci", BaseLifeUI.this.uci.DfE);
      paramAnonymousView.putExtra("get_poi_name", BaseLifeUI.b(BaseLifeUI.this).cWj());
      paramAnonymousView.putExtra("get_cur_lat", BaseLifeUI.this.ucj);
      paramAnonymousView.putExtra("get_cur_lng", BaseLifeUI.this.uck);
      paramAnonymousView.putExtra("get_accuracy", BaseLifeUI.this.ucm);
      paramAnonymousView.putExtra("get_loctype", BaseLifeUI.this.ucl);
      paramAnonymousView.putExtra("search_id", BaseLifeUI.this.jko);
      paramAnonymousView.putExtra("get_is_mars", BaseLifeUI.this.hem);
      BaseLifeUI.this.startActivityForResult(paramAnonymousView, 1);
      AppMethodBeat.o(26561);
    }
  };
  private b.a ucy = new b.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
    {
      AppMethodBeat.i(26572);
      if (BaseLifeUI.this.gqP)
      {
        AppMethodBeat.o(26572);
        return false;
      }
      if (BaseLifeUI.this.fjF)
      {
        AppMethodBeat.o(26572);
        return false;
      }
      if (!paramAnonymousBoolean)
      {
        if ((!BaseLifeUI.j(BaseLifeUI.this)) && (!com.tencent.mm.modelgeo.d.axU()))
        {
          BaseLifeUI.k(BaseLifeUI.this);
          com.tencent.mm.ui.base.h.a(BaseLifeUI.this, BaseLifeUI.this.getString(2131760082), BaseLifeUI.this.getString(2131755906), BaseLifeUI.this.getString(2131760598), BaseLifeUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(26571);
              com.tencent.mm.modelgeo.d.cv(BaseLifeUI.this);
              AppMethodBeat.o(26571);
            }
          }, null);
        }
        AppMethodBeat.o(26572);
        return true;
      }
      o.a(2003, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
      BaseLifeUI.this.fjF = true;
      ad.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
      BaseLifeUI.this.uci = new bld();
      BaseLifeUI.this.uci.DfG = "";
      BaseLifeUI.this.uci.DfH = 0;
      BaseLifeUI.this.uci.COJ = paramAnonymousFloat2;
      BaseLifeUI.this.uci.COI = paramAnonymousFloat1;
      BaseLifeUI.this.uci.DfF = "";
      BaseLifeUI.this.uci.DfE = ((int)paramAnonymousDouble2);
      BaseLifeUI.this.ucj = paramAnonymousFloat2;
      BaseLifeUI.this.uck = paramAnonymousFloat1;
      BaseLifeUI.this.ucl = paramAnonymousInt;
      BaseLifeUI.this.ucm = ((float)paramAnonymousDouble2);
      Object localObject = BaseLifeUI.this;
      label418:
      BaseLifeUI localBaseLifeUI;
      if (BaseLifeUI.l(BaseLifeUI.this) == null)
      {
        paramAnonymousBoolean = false;
        ((BaseLifeUI)localObject).hem = paramAnonymousBoolean;
        localObject = BaseLifeUI.f(BaseLifeUI.this).ubQ;
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label569;
        }
        localObject = (BackwardSupportUtil.ExifHelper.LatLongData)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
        BaseLifeUI.this.p(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).dpb, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).hil);
        BaseLifeUI.this.uct = BaseLifeUI.k(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).dpb, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).hil, paramAnonymousFloat2, paramAnonymousFloat1);
        BaseLifeUI.f(BaseLifeUI.this).ubU = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.uci.COJ, BaseLifeUI.this.uci.COI);
        BaseLifeUI.b(BaseLifeUI.this).ubU = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.uci.COJ, BaseLifeUI.this.uci.COI);
        localBaseLifeUI = BaseLifeUI.this;
        if (!BaseLifeUI.this.inh) {
          break label583;
        }
      }
      label569:
      label583:
      for (localObject = BaseLifeUI.b(BaseLifeUI.this);; localObject = BaseLifeUI.f(BaseLifeUI.this))
      {
        BaseLifeUI.a(localBaseLifeUI, (a)localObject);
        BaseLifeUI.m(BaseLifeUI.this);
        BaseLifeUI.this.addSearchMenu(true, BaseLifeUI.i(BaseLifeUI.this));
        AppMethodBeat.o(26572);
        return false;
        paramAnonymousBoolean = BaseLifeUI.l(BaseLifeUI.this).hem;
        break;
        BaseLifeUI.this.p(paramAnonymousFloat2, paramAnonymousFloat1);
        break label418;
      }
    }
  };
  
  private void Ij(int paramInt)
  {
    this.sUz.removeFooterView(this.ubX);
    this.sUz.removeFooterView(this.ucb);
    this.sUz.eSP();
    this.ucb.setVisibility(paramInt);
    this.ucc.setVisibility(paramInt);
    this.ucd.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.sUz.addFooterView(this.ucb);
      return;
    }
    this.sUz.eSL();
    this.sUz.addFooterView(this.ubX);
  }
  
  private void cWo()
  {
    if (!this.inh) {
      ad.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }
    for (;;)
    {
      return;
      try
      {
        int i = Integer.valueOf(com.tencent.mm.m.g.Zd().getValue("POICreateForbiden")).intValue();
        ad.i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", new Object[] { Integer.valueOf(i) });
        if (i == 1) {}
      }
      catch (Exception localException)
      {
        label56:
        String str;
        break label56;
      }
    }
    if (!this.uca.ajd(this.uca.cWj()))
    {
      str = String.format(getResources().getString(2131761604), new Object[] { this.uca.cWj() });
      this.ucc.setText(str);
      Ij(0);
      return;
    }
    Ij(8);
  }
  
  private boolean nM(boolean paramBoolean)
  {
    bld localbld;
    do
    {
      if (this.ucf != null)
      {
        ad.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
      }
      if (this.uch.size() - 1 <= this.ucg)
      {
        this.ucg = -1;
        ad.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
        return false;
      }
      this.ucg += 1;
      localbld = (bld)this.uch.get(this.ucg);
      if (this.ucg == 0) {
        this.ucq += 1;
      }
      if (!this.inh) {
        break;
      }
      i = this.uca.b(new BackwardSupportUtil.ExifHelper.LatLongData(localbld.COJ, localbld.COI));
    } while (i <= 0);
    SKBuiltinBuffer_t localSKBuiltinBuffer_t;
    if (this.inh)
    {
      localSKBuiltinBuffer_t = this.uca.a(new BackwardSupportUtil.ExifHelper.LatLongData(localbld.COJ, localbld.COI));
      label166:
      if (!this.inh) {
        break label249;
      }
    }
    label249:
    for (int i = 1;; i = 0)
    {
      if (com.tencent.mm.plugin.nearlife.b.d.Ig(i)) {
        break label255;
      }
      this.ucg = -1;
      return false;
      i = this.ubZ.b(new BackwardSupportUtil.ExifHelper.LatLongData(localbld.COJ, localbld.COI));
      break;
      localSKBuiltinBuffer_t = this.ubZ.a(new BackwardSupportUtil.ExifHelper.LatLongData(localbld.COJ, localbld.COI));
      break label166;
    }
    label255:
    if (-1L == this.ucn) {
      this.ucn = System.currentTimeMillis();
    }
    int j = this.sceneType;
    float f1 = localbld.COI;
    float f2 = localbld.COJ;
    int k = localbld.DfE;
    int m = localbld.DfH;
    String str2 = localbld.DfF;
    String str3 = localbld.DfG;
    if (this.inh) {}
    for (String str1 = this.uca.cWj();; str1 = "")
    {
      this.ucf = new com.tencent.mm.plugin.nearlife.b.d(i, j, f1, f2, k, m, str2, str3, localSKBuiltinBuffer_t, str1, this.sVb, paramBoolean, false);
      az.aeS().a(this.ucf, 0);
      ad.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", new Object[] { Integer.valueOf(this.ucg), Float.valueOf(localbld.COJ), Float.valueOf(localbld.COI) });
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
          if (this.uct)
          {
            paramString = com.tencent.mm.plugin.report.service.h.vKh;
            if (!paramBoolean1) {
              break label402;
            }
            j = 5;
            paramString.f(11139, new Object[] { Integer.valueOf(j) });
          }
          if (!paramBoolean1) {
            break label408;
          }
          paramString = this.uca.Ii(paramInt).sWi;
          localObject1 = paramString;
          if (this.uca.getCount() <= 0) {
            break label545;
          }
          str1 = this.uca.Ii(1).dnB;
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
      if (bt.isNullOrNil(paramString))
      {
        str1 = this.dnB;
        localObject2 = localObject1;
        j = i;
      }
      if (this.uci == null) {}
      for (paramString = "null/null";; paramString = String.format("%f/%f", new Object[] { Float.valueOf(this.uci.COJ), Float.valueOf(this.uci.COI) }))
      {
        ad.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt + 1), str2, Integer.valueOf(paramInt), localObject2, str1 });
        com.tencent.mm.plugin.report.service.h.vKh.f(11135, new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt + 1), Long.valueOf(this.ucn), Long.valueOf(this.ucp), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.uco), Integer.valueOf(this.ucq), paramString, str2, Integer.valueOf(this.sVb), localObject2, com.tencent.mm.compatible.deviceinfo.q.cG(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
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
        str1 = this.ubZ.Ii(paramInt).sWi;
        localObject1 = str1;
        if (this.ubZ.getCount() <= 0) {
          break label545;
        }
        paramString = this.ubZ.Ii(1).dnB;
        localObject1 = str1;
        break label130;
        if (this.ucr) {
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
  
  public abstract a cWl();
  
  public abstract a cWm();
  
  public void cWn()
  {
    ad.d("MicroMsg.BaseLifeUI", "init header");
    this.ucb = View.inflate(this, 2131493673, null);
    this.ucc = ((TextView)this.ucb.findViewById(2131306116));
    this.ucd = ((TextView)this.ucb.findViewById(2131306115));
    this.ucb.setOnClickListener(this.ucx);
    this.ubX = View.inflate(this, 2131495103, null);
    this.sUz.addFooterView(this.ubX);
    this.ubX.setVisibility(8);
  }
  
  public int getLayoutId()
  {
    return 2131494998;
  }
  
  public void initView()
  {
    this.sUz = ((MMLoadMoreListView)findViewById(2131302680));
    this.sUz.setFooterTips(getString(2131761492));
    this.ubY = ((NearLifeErrorContent)findViewById(2131302679));
    cWn();
    this.ubZ = cWl();
    this.uca = cWm();
    this.sUz.setAdapter(this.ubZ);
    this.ubY.setListView(this.sUz);
    this.ubZ.notifyDataSetChanged();
    setBackBtn(new BaseLifeUI.3(this));
    setToTop(new BaseLifeUI.4(this));
    this.fvI = new r((byte)0);
    this.fvI.Htp = new r.b()
    {
      public final boolean BX(String paramAnonymousString)
      {
        AppMethodBeat.i(26569);
        ad.d("MicroMsg.BaseLifeUI", "search key click");
        BaseLifeUI.b(BaseLifeUI.this, paramAnonymousString);
        AppMethodBeat.o(26569);
        return false;
      }
      
      public final void BY(String paramAnonymousString)
      {
        AppMethodBeat.i(26566);
        ad.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", new Object[] { paramAnonymousString });
        if (bt.isNullOrNil(paramAnonymousString))
        {
          aIl();
          AppMethodBeat.o(26566);
          return;
        }
        BaseLifeUI.a(BaseLifeUI.this, paramAnonymousString);
        AppMethodBeat.o(26566);
      }
      
      public final void aIj()
      {
        AppMethodBeat.i(26567);
        ad.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
        BaseLifeUI.this.inh = false;
        BaseLifeUI.this.sUz.setAdapter(BaseLifeUI.f(BaseLifeUI.this));
        BaseLifeUI.f(BaseLifeUI.this).notifyDataSetChanged();
        BaseLifeUI.g(BaseLifeUI.this).Ik(BaseLifeUI.f(BaseLifeUI.this).ubW);
        if ((!BaseLifeUI.f(BaseLifeUI.this).cWk()) && (BaseLifeUI.h(BaseLifeUI.this) != null)) {
          BaseLifeUI.h(BaseLifeUI.this).setVisibility(0);
        }
        BaseLifeUI.this.sUz.setOnTouchListener(null);
        BaseLifeUI.e(BaseLifeUI.this);
        BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.f(BaseLifeUI.this));
        AppMethodBeat.o(26567);
      }
      
      public final void aIk()
      {
        AppMethodBeat.i(26568);
        ad.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
        BaseLifeUI.this.ucr = true;
        BaseLifeUI.i(BaseLifeUI.this).setHint(BaseLifeUI.this.getString(2131761491));
        BaseLifeUI.this.inh = true;
        BaseLifeUI.b(BaseLifeUI.this).cWi();
        BaseLifeUI.this.sUz.setAdapter(BaseLifeUI.b(BaseLifeUI.this));
        BaseLifeUI.b(BaseLifeUI.this).notifyDataSetChanged();
        BaseLifeUI.this.sUz.eSN();
        BaseLifeUI.g(BaseLifeUI.this).Ik(BaseLifeUI.b(BaseLifeUI.this).ubW);
        if (BaseLifeUI.h(BaseLifeUI.this) != null) {
          BaseLifeUI.h(BaseLifeUI.this).setVisibility(8);
        }
        BaseLifeUI.this.sUz.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
          {
            AppMethodBeat.i(26564);
            BaseLifeUI.this.hideVKB();
            AppMethodBeat.o(26564);
            return false;
          }
        });
        BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.b(BaseLifeUI.this));
        AppMethodBeat.o(26568);
      }
      
      public final void aIl()
      {
        AppMethodBeat.i(26565);
        ad.d("MicroMsg.BaseLifeUI", "click clear");
        if (BaseLifeUI.c(BaseLifeUI.this) != null)
        {
          az.aeS().a(BaseLifeUI.c(BaseLifeUI.this));
          BaseLifeUI.d(BaseLifeUI.this);
        }
        BaseLifeUI.b(BaseLifeUI.this).cWi();
        BaseLifeUI.e(BaseLifeUI.this);
        AppMethodBeat.o(26565);
      }
      
      public final void aIm() {}
    };
    this.sUz.setOnLoadMoreListener(new BaseLifeUI.6(this));
    this.sUz.eSM();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.d("MicroMsg.BaseLifeUI", "onActivityResult requestCode %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
    this.ucv = getIntent().getBooleanExtra("poi_show_none", true);
    this.sVb = ((int)(System.currentTimeMillis() / 1000L));
    com.tencent.mm.plugin.nearlife.b.d.clear();
    az.aeS().a(603, this);
    this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
    this.dnB = getIntent().getStringExtra("request_id");
    this.uch = new ArrayList();
    initView();
  }
  
  public void onDestroy()
  {
    az.aeS().b(603, this);
    super.onDestroy();
    if (this.uce != null) {
      this.uce.c(this.ucy);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.uce.c(this.ucy);
  }
  
  public void onResume()
  {
    super.onResume();
    this.ubZ.notifyDataSetChanged();
    this.sUz.eSO();
    if (this.uce != null) {
      this.uce.a(this.ucy, true);
    }
    this.gqP = false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    if (paramn.getType() != 603) {
      return;
    }
    this.sUz.eSN();
    com.tencent.mm.plugin.nearlife.b.d locald = (com.tencent.mm.plugin.nearlife.b.d)paramn;
    LogoImageView localLogoImageView;
    Object localObject;
    if (!bt.isNullOrNil(locald.dct))
    {
      this.dct = locald.dct;
      localLogoImageView = (LogoImageView)this.ubX.findViewById(2131303550);
      localObject = this.dct;
      az.arV();
      localLogoImageView.imagePath = c.apX();
      localLogoImageView.url = ((String)localObject);
      localLogoImageView.gnh = 0;
      localLogoImageView.gni = 0;
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label168;
      }
      localLogoImageView.setVisibility(8);
    }
    int i;
    for (;;)
    {
      this.jko = locald.jko;
      this.sOL = locald.sOL;
      i = ((com.tencent.mm.plugin.nearlife.b.d)paramn).diR;
      com.tencent.mm.plugin.nearlife.b.d.Ih(i);
      if (this.ucf != null) {
        break;
      }
      ad.d("MicroMsg.BaseLifeUI", "scene is null");
      return;
      label168:
      if (((String)localObject).startsWith("http"))
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(localLogoImageView.imagePath + com.tencent.mm.b.g.getMessageDigest(((String)localObject).getBytes()));
        if (localBitmap != null)
        {
          localObject = localBitmap;
          if (localLogoImageView.gnh > 0)
          {
            localObject = localBitmap;
            if (localLogoImageView.gni > 0) {
              localObject = f.a(localBitmap, localLogoImageView.gnh, localLogoImageView.gni, true, false);
            }
          }
          localLogoImageView.setImageBitmap((Bitmap)localObject);
        }
        else
        {
          com.tencent.mm.sdk.g.b.c(new LogoImageView.a((String)localObject, localLogoImageView.handler), "LogoImageView_download");
        }
      }
      else if (!i.eK((String)localObject))
      {
        localLogoImageView.setVisibility(8);
      }
      else
      {
        if ((localLogoImageView.gnh <= 0) || (localLogoImageView.gni <= 0)) {}
        for (localObject = f.aFi((String)localObject);; localObject = f.e((String)localObject, localLogoImageView.gnh, localLogoImageView.gni, true))
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
    ad.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", new Object[] { Integer.valueOf(this.ucg), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
    if ((paramInt2 == 0) || (paramInt2 == 101))
    {
      i = 1;
      if ((paramInt1 == 0) || (i != 0)) {
        break label538;
      }
      ad.d("MicroMsg.BaseLifeUI", "error");
      if (!this.inh) {
        break label530;
      }
      paramString = this.uca;
      label471:
      if ((this.uch.size() - 1 == this.ucg) && (paramString.getCount() == 0))
      {
        paramString.ubW = 1;
        this.ubY.Ik(paramString.ubW);
      }
    }
    for (;;)
    {
      this.ucf = null;
      nM(false);
      return;
      i = 0;
      break;
      label530:
      paramString = this.ubZ;
      break label471;
      label538:
      if (-1L == this.uco) {
        this.uco = System.currentTimeMillis();
      }
      this.ucp = System.currentTimeMillis();
      paramn = locald.ubK;
      paramString = (bld)this.uch.get(this.ucg);
      localObject = new BackwardSupportUtil.ExifHelper.LatLongData(paramString.COJ, paramString.COI);
      if ((this.inh) && (!this.ucf.ubL)) {
        this.uca.cWi();
      }
      if (this.inh)
      {
        this.uca.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, locald.ckO(), locald.cWh());
        label654:
        if ((paramn != null) && (paramn.size() != 0)) {
          break label828;
        }
        if (!this.inh) {
          break label820;
        }
      }
      label820:
      for (paramString = this.uca;; paramString = this.ubZ)
      {
        if (this.uch.size() - 1 == this.ucg)
        {
          if (paramString.getCount() == 0) {
            this.ubY.Ik(paramString.ubW);
          }
          this.sUz.eSN();
          if ((!paramString.cWk()) && (paramInt2 != 101)) {
            cWo();
          }
        }
        if ((!this.ubZ.cWk()) && (this.ubX != null) && (!this.inh)) {
          this.ubX.setVisibility(0);
        }
        if ((this.ubX == null) || (this.inh)) {
          break label926;
        }
        this.ubX.setVisibility(0);
        break;
        this.ubZ.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, locald.ckO(), locald.cWh());
        break label654;
      }
      label828:
      if (this.inh) {}
      for (paramString = this.uca;; paramString = this.ubZ)
      {
        this.sUz.setVisibility(0);
        paramString.ubW = 0;
        this.ubY.Ik(this.uca.ubW);
        paramString.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, paramn);
        paramString.notifyDataSetChanged();
        if ((this.uch.size() - 1 != this.ucg) || (paramString.cWk())) {
          break;
        }
        this.sUz.eSN();
        cWo();
        break;
      }
      label926:
      if (this.ubX != null) {
        this.ubX.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI
 * JD-Core Version:    0.7.0.1
 */