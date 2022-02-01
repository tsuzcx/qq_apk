package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.n.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLifeUI
  extends MMActivity
  implements f
{
  protected String dyb = "";
  boolean fHl = false;
  private r fUI;
  boolean hmD = false;
  protected boolean iam = true;
  boolean jjp = false;
  protected String kid = "";
  int sceneType = 0;
  private int vlS = 1;
  MMLoadMoreListView vrC;
  public int vse = -1;
  private boolean vsk;
  private boolean wEG = false;
  private String wFJ = "";
  private View wFX;
  private NearLifeErrorContent wFY;
  private a wFZ;
  private a wGa;
  private View wGb;
  private TextView wGc;
  private TextView wGd;
  private com.tencent.mm.modelgeo.d wGe = com.tencent.mm.modelgeo.d.aIh();
  private com.tencent.mm.plugin.nearlife.b.d wGf;
  private int wGg;
  private List<bug> wGh;
  protected bug wGi = null;
  protected float wGj = 0.0F;
  protected float wGk = 0.0F;
  protected int wGl = 0;
  protected float wGm = 0.0F;
  protected long wGn = -1L;
  protected long wGo = -1L;
  protected long wGp = -1L;
  protected int wGq = 0;
  protected boolean wGr = false;
  protected int wGs = -1;
  protected boolean wGt = false;
  boolean wGu = false;
  protected boolean wGv = true;
  private View.OnClickListener wGw = new BaseLifeUI.1(this);
  private View.OnClickListener wGx = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(26561);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (BaseLifeUI.this.wGi == null)
      {
        ae.e("MicroMsg.BaseLifeUI", "Location is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26561);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(11138, new Object[] { "1", Integer.valueOf(BaseLifeUI.b(BaseLifeUI.this).getCount() + 1), BaseLifeUI.this.kid });
      paramAnonymousView = new Intent();
      paramAnonymousView.setClass(BaseLifeUI.this, NearLifeCreatePoiUI.class);
      paramAnonymousView.putExtra("get_lat", BaseLifeUI.this.wGi.Gha);
      paramAnonymousView.putExtra("get_lng", BaseLifeUI.this.wGi.GgZ);
      paramAnonymousView.putExtra("get_preci", BaseLifeUI.this.wGi.Gzf);
      paramAnonymousView.putExtra("get_poi_name", BaseLifeUI.b(BaseLifeUI.this).dxs());
      paramAnonymousView.putExtra("get_cur_lat", BaseLifeUI.this.wGj);
      paramAnonymousView.putExtra("get_cur_lng", BaseLifeUI.this.wGk);
      paramAnonymousView.putExtra("get_accuracy", BaseLifeUI.this.wGm);
      paramAnonymousView.putExtra("get_loctype", BaseLifeUI.this.wGl);
      paramAnonymousView.putExtra("search_id", BaseLifeUI.this.kid);
      paramAnonymousView.putExtra("get_is_mars", BaseLifeUI.this.iam);
      BaseLifeUI.this.startActivityForResult(paramAnonymousView, 1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26561);
    }
  };
  private b.a wGy = new b.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
    {
      AppMethodBeat.i(26572);
      if (BaseLifeUI.this.hmD)
      {
        AppMethodBeat.o(26572);
        return false;
      }
      if (BaseLifeUI.this.fHl)
      {
        AppMethodBeat.o(26572);
        return false;
      }
      if (!paramAnonymousBoolean)
      {
        if ((!BaseLifeUI.j(BaseLifeUI.this)) && (!com.tencent.mm.modelgeo.d.aIi()))
        {
          BaseLifeUI.k(BaseLifeUI.this);
          com.tencent.mm.ui.base.h.a(BaseLifeUI.this, BaseLifeUI.this.getString(2131760082), BaseLifeUI.this.getString(2131755906), BaseLifeUI.this.getString(2131760598), BaseLifeUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(26571);
              com.tencent.mm.modelgeo.d.cD(BaseLifeUI.this);
              AppMethodBeat.o(26571);
            }
          }, null);
        }
        AppMethodBeat.o(26572);
        return true;
      }
      com.tencent.mm.modelstat.o.a(2003, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
      BaseLifeUI.this.fHl = true;
      ae.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
      BaseLifeUI.this.wGi = new bug();
      BaseLifeUI.this.wGi.Gzh = "";
      BaseLifeUI.this.wGi.Gzi = 0;
      BaseLifeUI.this.wGi.Gha = paramAnonymousFloat2;
      BaseLifeUI.this.wGi.GgZ = paramAnonymousFloat1;
      BaseLifeUI.this.wGi.Gzg = "";
      BaseLifeUI.this.wGi.Gzf = ((int)paramAnonymousDouble2);
      BaseLifeUI.this.wGj = paramAnonymousFloat2;
      BaseLifeUI.this.wGk = paramAnonymousFloat1;
      BaseLifeUI.this.wGl = paramAnonymousInt;
      BaseLifeUI.this.wGm = ((float)paramAnonymousDouble2);
      Object localObject = BaseLifeUI.this;
      label418:
      BaseLifeUI localBaseLifeUI;
      if (BaseLifeUI.l(BaseLifeUI.this) == null)
      {
        paramAnonymousBoolean = false;
        ((BaseLifeUI)localObject).iam = paramAnonymousBoolean;
        localObject = BaseLifeUI.f(BaseLifeUI.this).wFQ;
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label569;
        }
        localObject = (BackwardSupportUtil.ExifHelper.LatLongData)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
        BaseLifeUI.this.p(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).dzE, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).iev);
        BaseLifeUI.this.wGt = BaseLifeUI.m(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).dzE, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).iev, paramAnonymousFloat2, paramAnonymousFloat1);
        BaseLifeUI.f(BaseLifeUI.this).wFU = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.wGi.Gha, BaseLifeUI.this.wGi.GgZ);
        BaseLifeUI.b(BaseLifeUI.this).wFU = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.wGi.Gha, BaseLifeUI.this.wGi.GgZ);
        localBaseLifeUI = BaseLifeUI.this;
        if (!BaseLifeUI.this.jjp) {
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
        paramAnonymousBoolean = BaseLifeUI.l(BaseLifeUI.this).iam;
        break;
        BaseLifeUI.this.p(paramAnonymousFloat2, paramAnonymousFloat1);
        break label418;
      }
    }
  };
  
  private void Mp(int paramInt)
  {
    this.vrC.removeFooterView(this.wFX);
    this.vrC.removeFooterView(this.wGb);
    this.vrC.fCQ();
    this.wGb.setVisibility(paramInt);
    this.wGc.setVisibility(paramInt);
    this.wGd.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.vrC.addFooterView(this.wGb);
      return;
    }
    this.vrC.fCM();
    this.vrC.addFooterView(this.wFX);
  }
  
  private void dxx()
  {
    if (!this.jjp) {
      ae.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }
    for (;;)
    {
      return;
      try
      {
        int i = Integer.valueOf(com.tencent.mm.n.g.acL().getValue("POICreateForbiden")).intValue();
        ae.i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", new Object[] { Integer.valueOf(i) });
        if (i == 1) {}
      }
      catch (Exception localException)
      {
        label56:
        String str;
        break label56;
      }
    }
    if (!this.wGa.aun(this.wGa.dxs()))
    {
      str = String.format(getResources().getString(2131761604), new Object[] { this.wGa.dxs() });
      this.wGc.setText(str);
      Mp(0);
      return;
    }
    Mp(8);
  }
  
  private boolean pn(boolean paramBoolean)
  {
    bug localbug;
    do
    {
      if (this.wGf != null)
      {
        ae.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
      }
      if (this.wGh.size() - 1 <= this.wGg)
      {
        this.wGg = -1;
        ae.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
        return false;
      }
      this.wGg += 1;
      localbug = (bug)this.wGh.get(this.wGg);
      if (this.wGg == 0) {
        this.wGq += 1;
      }
      if (!this.jjp) {
        break;
      }
      i = this.wGa.b(new BackwardSupportUtil.ExifHelper.LatLongData(localbug.Gha, localbug.GgZ));
    } while (i <= 0);
    SKBuiltinBuffer_t localSKBuiltinBuffer_t;
    if (this.jjp)
    {
      localSKBuiltinBuffer_t = this.wGa.a(new BackwardSupportUtil.ExifHelper.LatLongData(localbug.Gha, localbug.GgZ));
      label166:
      if (!this.jjp) {
        break label249;
      }
    }
    label249:
    for (int i = 1;; i = 0)
    {
      if (com.tencent.mm.plugin.nearlife.b.d.Mm(i)) {
        break label255;
      }
      this.wGg = -1;
      return false;
      i = this.wFZ.b(new BackwardSupportUtil.ExifHelper.LatLongData(localbug.Gha, localbug.GgZ));
      break;
      localSKBuiltinBuffer_t = this.wFZ.a(new BackwardSupportUtil.ExifHelper.LatLongData(localbug.Gha, localbug.GgZ));
      break label166;
    }
    label255:
    if (-1L == this.wGn) {
      this.wGn = System.currentTimeMillis();
    }
    int j = this.sceneType;
    float f1 = localbug.GgZ;
    float f2 = localbug.Gha;
    int k = localbug.Gzf;
    int m = localbug.Gzi;
    String str2 = localbug.Gzg;
    String str3 = localbug.Gzh;
    if (this.jjp) {}
    for (String str1 = this.wGa.dxs();; str1 = "")
    {
      this.wGf = new com.tencent.mm.plugin.nearlife.b.d(i, j, f1, f2, k, m, str2, str3, localSKBuiltinBuffer_t, str1, this.vse, paramBoolean, false);
      bc.ajj().a(this.wGf, 0);
      ae.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", new Object[] { Integer.valueOf(this.wGg), Float.valueOf(localbug.Gha), Float.valueOf(localbug.GgZ) });
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
          if (this.wGt)
          {
            paramString = com.tencent.mm.plugin.report.service.g.yxI;
            if (!paramBoolean1) {
              break label402;
            }
            j = 5;
            paramString.f(11139, new Object[] { Integer.valueOf(j) });
          }
          if (!paramBoolean1) {
            break label408;
          }
          paramString = this.wGa.Mo(paramInt).vtl;
          localObject1 = paramString;
          if (this.wGa.getCount() <= 0) {
            break label545;
          }
          str1 = this.wGa.Mo(1).dyb;
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
      if (bu.isNullOrNil(paramString))
      {
        str1 = this.dyb;
        localObject2 = localObject1;
        j = i;
      }
      if (this.wGi == null) {}
      for (paramString = "null/null";; paramString = String.format("%f/%f", new Object[] { Float.valueOf(this.wGi.Gha), Float.valueOf(this.wGi.GgZ) }))
      {
        ae.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt + 1), str2, Integer.valueOf(paramInt), localObject2, str1 });
        com.tencent.mm.plugin.report.service.g.yxI.f(11135, new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt + 1), Long.valueOf(this.wGn), Long.valueOf(this.wGp), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.wGo), Integer.valueOf(this.wGq), paramString, str2, Integer.valueOf(this.vse), localObject2, com.tencent.mm.compatible.deviceinfo.q.cH(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
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
        str1 = this.wFZ.Mo(paramInt).vtl;
        localObject1 = str1;
        if (this.wFZ.getCount() <= 0) {
          break label545;
        }
        paramString = this.wFZ.Mo(1).dyb;
        localObject1 = str1;
        break label130;
        if (this.wGr) {
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
  
  public abstract a dxu();
  
  public abstract a dxv();
  
  public void dxw()
  {
    ae.d("MicroMsg.BaseLifeUI", "init header");
    this.wGb = View.inflate(this, 2131493673, null);
    this.wGc = ((TextView)this.wGb.findViewById(2131306116));
    this.wGd = ((TextView)this.wGb.findViewById(2131306115));
    this.wGb.setOnClickListener(this.wGx);
    this.wFX = View.inflate(this, 2131495103, null);
    this.vrC.addFooterView(this.wFX);
    this.wFX.setVisibility(8);
  }
  
  public int getLayoutId()
  {
    return 2131494998;
  }
  
  public void initView()
  {
    this.vrC = ((MMLoadMoreListView)findViewById(2131302680));
    this.vrC.setFooterTips(getString(2131761492));
    this.wFY = ((NearLifeErrorContent)findViewById(2131302679));
    dxw();
    this.wFZ = dxu();
    this.wGa = dxv();
    this.vrC.setAdapter(this.wFZ);
    this.wFY.setListView(this.vrC);
    this.wFZ.notifyDataSetChanged();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26562);
        BaseLifeUI.this.a(-1, false, "", BaseLifeUI.this.wGu);
        BaseLifeUI.this.finish();
        AppMethodBeat.o(26562);
        return true;
      }
    });
    setToTop(new BaseLifeUI.4(this));
    this.fUI = new r((byte)0);
    this.fUI.Lhk = new r.b()
    {
      public final boolean JO(String paramAnonymousString)
      {
        AppMethodBeat.i(26569);
        ae.d("MicroMsg.BaseLifeUI", "search key click");
        BaseLifeUI.b(BaseLifeUI.this, paramAnonymousString);
        AppMethodBeat.o(26569);
        return false;
      }
      
      public final void JP(String paramAnonymousString)
      {
        AppMethodBeat.i(26566);
        ae.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", new Object[] { paramAnonymousString });
        if (bu.isNullOrNil(paramAnonymousString))
        {
          aSN();
          AppMethodBeat.o(26566);
          return;
        }
        BaseLifeUI.a(BaseLifeUI.this, paramAnonymousString);
        AppMethodBeat.o(26566);
      }
      
      public final void aSL()
      {
        AppMethodBeat.i(26567);
        ae.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
        BaseLifeUI.this.jjp = false;
        BaseLifeUI.this.vrC.setAdapter(BaseLifeUI.f(BaseLifeUI.this));
        BaseLifeUI.f(BaseLifeUI.this).notifyDataSetChanged();
        BaseLifeUI.g(BaseLifeUI.this).Mq(BaseLifeUI.f(BaseLifeUI.this).wFW);
        if ((!BaseLifeUI.f(BaseLifeUI.this).dxt()) && (BaseLifeUI.h(BaseLifeUI.this) != null)) {
          BaseLifeUI.h(BaseLifeUI.this).setVisibility(0);
        }
        BaseLifeUI.this.vrC.setOnTouchListener(null);
        BaseLifeUI.e(BaseLifeUI.this);
        BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.f(BaseLifeUI.this));
        AppMethodBeat.o(26567);
      }
      
      public final void aSM()
      {
        AppMethodBeat.i(26568);
        ae.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
        BaseLifeUI.this.wGr = true;
        BaseLifeUI.i(BaseLifeUI.this).setHint(BaseLifeUI.this.getString(2131761491));
        BaseLifeUI.this.jjp = true;
        BaseLifeUI.b(BaseLifeUI.this).dxr();
        BaseLifeUI.this.vrC.setAdapter(BaseLifeUI.b(BaseLifeUI.this));
        BaseLifeUI.b(BaseLifeUI.this).notifyDataSetChanged();
        BaseLifeUI.this.vrC.fCO();
        BaseLifeUI.g(BaseLifeUI.this).Mq(BaseLifeUI.b(BaseLifeUI.this).wFW);
        if (BaseLifeUI.h(BaseLifeUI.this) != null) {
          BaseLifeUI.h(BaseLifeUI.this).setVisibility(8);
        }
        BaseLifeUI.this.vrC.setOnTouchListener(new BaseLifeUI.5.1(this));
        BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.b(BaseLifeUI.this));
        AppMethodBeat.o(26568);
      }
      
      public final void aSN()
      {
        AppMethodBeat.i(26565);
        ae.d("MicroMsg.BaseLifeUI", "click clear");
        if (BaseLifeUI.c(BaseLifeUI.this) != null)
        {
          bc.ajj().a(BaseLifeUI.c(BaseLifeUI.this));
          BaseLifeUI.d(BaseLifeUI.this);
        }
        BaseLifeUI.b(BaseLifeUI.this).dxr();
        BaseLifeUI.e(BaseLifeUI.this);
        AppMethodBeat.o(26565);
      }
      
      public final void aSO() {}
    };
    this.vrC.setOnLoadMoreListener(new BaseLifeUI.6(this));
    this.vrC.fCN();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ae.d("MicroMsg.BaseLifeUI", "onActivityResult requestCode %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
    this.wGv = getIntent().getBooleanExtra("poi_show_none", true);
    this.vse = ((int)(System.currentTimeMillis() / 1000L));
    com.tencent.mm.plugin.nearlife.b.d.clear();
    bc.ajj().a(603, this);
    this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
    this.dyb = getIntent().getStringExtra("request_id");
    this.wGh = new ArrayList();
    initView();
  }
  
  public void onDestroy()
  {
    bc.ajj().b(603, this);
    super.onDestroy();
    if (this.wGe != null) {
      this.wGe.c(this.wGy);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.wGe.c(this.wGy);
  }
  
  public void onResume()
  {
    super.onResume();
    this.wFZ.notifyDataSetChanged();
    this.vrC.fCP();
    if (this.wGe != null) {
      this.wGe.a(this.wGy, true);
    }
    this.hmD = false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    if (paramn.getType() != 603) {
      return;
    }
    this.vrC.fCO();
    com.tencent.mm.plugin.nearlife.b.d locald = (com.tencent.mm.plugin.nearlife.b.d)paramn;
    LogoImageView localLogoImageView;
    Object localObject;
    if (!bu.isNullOrNil(locald.wFJ))
    {
      this.wFJ = locald.wFJ;
      localLogoImageView = (LogoImageView)this.wFX.findViewById(2131303550);
      localObject = this.wFJ;
      bc.aCg();
      localLogoImageView.imagePath = c.azR();
      localLogoImageView.url = ((String)localObject);
      localLogoImageView.targetWidth = 0;
      localLogoImageView.targetHeight = 0;
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label168;
      }
      localLogoImageView.setVisibility(8);
    }
    int i;
    for (;;)
    {
      this.kid = locald.kid;
      this.vlS = locald.vlS;
      i = ((com.tencent.mm.plugin.nearlife.b.d)paramn).dsO;
      com.tencent.mm.plugin.nearlife.b.d.Mn(i);
      if (this.wGf != null) {
        break;
      }
      ae.d("MicroMsg.BaseLifeUI", "scene is null");
      return;
      label168:
      if (((String)localObject).startsWith("http"))
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(localLogoImageView.imagePath + com.tencent.mm.b.g.getMessageDigest(((String)localObject).getBytes()));
        if (localBitmap != null)
        {
          localObject = localBitmap;
          if (localLogoImageView.targetWidth > 0)
          {
            localObject = localBitmap;
            if (localLogoImageView.targetHeight > 0) {
              localObject = com.tencent.mm.sdk.platformtools.h.a(localBitmap, localLogoImageView.targetWidth, localLogoImageView.targetHeight, true, false);
            }
          }
          localLogoImageView.setImageBitmap((Bitmap)localObject);
        }
        else
        {
          com.tencent.mm.sdk.g.b.c(new LogoImageView.a((String)localObject, localLogoImageView.handler), "LogoImageView_download");
        }
      }
      else if (!com.tencent.mm.vfs.o.fB((String)localObject))
      {
        localLogoImageView.setVisibility(8);
      }
      else
      {
        if ((localLogoImageView.targetWidth <= 0) || (localLogoImageView.targetHeight <= 0)) {}
        for (localObject = com.tencent.mm.sdk.platformtools.h.aRC((String)localObject);; localObject = com.tencent.mm.sdk.platformtools.h.d((String)localObject, localLogoImageView.targetWidth, localLogoImageView.targetHeight, true))
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
    ae.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", new Object[] { Integer.valueOf(this.wGg), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
    if ((paramInt2 == 0) || (paramInt2 == 101))
    {
      i = 1;
      if ((paramInt1 == 0) || (i != 0)) {
        break label538;
      }
      ae.d("MicroMsg.BaseLifeUI", "error");
      if (!this.jjp) {
        break label530;
      }
      paramString = this.wGa;
      label471:
      if ((this.wGh.size() - 1 == this.wGg) && (paramString.getCount() == 0))
      {
        paramString.wFW = 1;
        this.wFY.Mq(paramString.wFW);
      }
    }
    for (;;)
    {
      this.wGf = null;
      pn(false);
      return;
      i = 0;
      break;
      label530:
      paramString = this.wFZ;
      break label471;
      label538:
      if (-1L == this.wGo) {
        this.wGo = System.currentTimeMillis();
      }
      this.wGp = System.currentTimeMillis();
      paramn = locald.wFK;
      paramString = (bug)this.wGh.get(this.wGg);
      localObject = new BackwardSupportUtil.ExifHelper.LatLongData(paramString.Gha, paramString.GgZ);
      if ((this.jjp) && (!this.wGf.wFL)) {
        this.wGa.dxr();
      }
      if (this.jjp)
      {
        this.wGa.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, locald.czR(), locald.dxq());
        label654:
        if ((paramn != null) && (paramn.size() != 0)) {
          break label828;
        }
        if (!this.jjp) {
          break label820;
        }
      }
      label820:
      for (paramString = this.wGa;; paramString = this.wFZ)
      {
        if (this.wGh.size() - 1 == this.wGg)
        {
          if (paramString.getCount() == 0) {
            this.wFY.Mq(paramString.wFW);
          }
          this.vrC.fCO();
          if ((!paramString.dxt()) && (paramInt2 != 101)) {
            dxx();
          }
        }
        if ((!this.wFZ.dxt()) && (this.wFX != null) && (!this.jjp)) {
          this.wFX.setVisibility(0);
        }
        if ((this.wFX == null) || (this.jjp)) {
          break label926;
        }
        this.wFX.setVisibility(0);
        break;
        this.wFZ.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, locald.czR(), locald.dxq());
        break label654;
      }
      label828:
      if (this.jjp) {}
      for (paramString = this.wGa;; paramString = this.wFZ)
      {
        this.vrC.setVisibility(0);
        paramString.wFW = 0;
        this.wFY.Mq(this.wGa.wFW);
        paramString.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, paramn);
        paramString.notifyDataSetChanged();
        if ((this.wGh.size() - 1 != this.wGg) || (paramString.dxt())) {
          break;
        }
        this.vrC.fCO();
        dxx();
        break;
      }
      label926:
      if (this.wFX != null) {
        this.wFX.setVisibility(8);
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