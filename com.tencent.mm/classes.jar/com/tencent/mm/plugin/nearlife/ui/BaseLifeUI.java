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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.n.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.btm;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLifeUI
  extends MMActivity
  implements f
{
  protected String dwW = "";
  boolean fFh = false;
  private r fSC;
  protected boolean hXu = true;
  boolean hjP = false;
  boolean jgw = false;
  protected String keN = "";
  int sceneType = 0;
  private int uZH = 1;
  public int vfX = -1;
  MMLoadMoreListView vfv;
  private boolean vgd;
  private boolean woX = false;
  protected float wqA = 0.0F;
  protected float wqB = 0.0F;
  protected int wqC = 0;
  protected float wqD = 0.0F;
  protected long wqE = -1L;
  protected long wqF = -1L;
  protected long wqG = -1L;
  protected int wqH = 0;
  protected boolean wqI = false;
  protected int wqJ = -1;
  protected boolean wqK = false;
  boolean wqL = false;
  protected boolean wqM = true;
  private View.OnClickListener wqN = new BaseLifeUI.1(this);
  private View.OnClickListener wqO = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(26561);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (BaseLifeUI.this.wqz == null)
      {
        ad.e("MicroMsg.BaseLifeUI", "Location is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26561);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(11138, new Object[] { "1", Integer.valueOf(BaseLifeUI.b(BaseLifeUI.this).getCount() + 1), BaseLifeUI.this.keN });
      paramAnonymousView = new Intent();
      paramAnonymousView.setClass(BaseLifeUI.this, NearLifeCreatePoiUI.class);
      paramAnonymousView.putExtra("get_lat", BaseLifeUI.this.wqz.FOB);
      paramAnonymousView.putExtra("get_lng", BaseLifeUI.this.wqz.FOA);
      paramAnonymousView.putExtra("get_preci", BaseLifeUI.this.wqz.Ggw);
      paramAnonymousView.putExtra("get_poi_name", BaseLifeUI.b(BaseLifeUI.this).dud());
      paramAnonymousView.putExtra("get_cur_lat", BaseLifeUI.this.wqA);
      paramAnonymousView.putExtra("get_cur_lng", BaseLifeUI.this.wqB);
      paramAnonymousView.putExtra("get_accuracy", BaseLifeUI.this.wqD);
      paramAnonymousView.putExtra("get_loctype", BaseLifeUI.this.wqC);
      paramAnonymousView.putExtra("search_id", BaseLifeUI.this.keN);
      paramAnonymousView.putExtra("get_is_mars", BaseLifeUI.this.hXu);
      BaseLifeUI.this.startActivityForResult(paramAnonymousView, 1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26561);
    }
  };
  private b.a wqP = new b.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
    {
      AppMethodBeat.i(26572);
      if (BaseLifeUI.this.hjP)
      {
        AppMethodBeat.o(26572);
        return false;
      }
      if (BaseLifeUI.this.fFh)
      {
        AppMethodBeat.o(26572);
        return false;
      }
      if (!paramAnonymousBoolean)
      {
        if ((!BaseLifeUI.j(BaseLifeUI.this)) && (!com.tencent.mm.modelgeo.d.aHR()))
        {
          BaseLifeUI.k(BaseLifeUI.this);
          h.a(BaseLifeUI.this, BaseLifeUI.this.getString(2131760082), BaseLifeUI.this.getString(2131755906), BaseLifeUI.this.getString(2131760598), BaseLifeUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(26571);
              com.tencent.mm.modelgeo.d.cB(BaseLifeUI.this);
              AppMethodBeat.o(26571);
            }
          }, null);
        }
        AppMethodBeat.o(26572);
        return true;
      }
      o.a(2003, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
      BaseLifeUI.this.fFh = true;
      ad.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
      BaseLifeUI.this.wqz = new btm();
      BaseLifeUI.this.wqz.Ggy = "";
      BaseLifeUI.this.wqz.Ggz = 0;
      BaseLifeUI.this.wqz.FOB = paramAnonymousFloat2;
      BaseLifeUI.this.wqz.FOA = paramAnonymousFloat1;
      BaseLifeUI.this.wqz.Ggx = "";
      BaseLifeUI.this.wqz.Ggw = ((int)paramAnonymousDouble2);
      BaseLifeUI.this.wqA = paramAnonymousFloat2;
      BaseLifeUI.this.wqB = paramAnonymousFloat1;
      BaseLifeUI.this.wqC = paramAnonymousInt;
      BaseLifeUI.this.wqD = ((float)paramAnonymousDouble2);
      Object localObject = BaseLifeUI.this;
      label418:
      BaseLifeUI localBaseLifeUI;
      if (BaseLifeUI.l(BaseLifeUI.this) == null)
      {
        paramAnonymousBoolean = false;
        ((BaseLifeUI)localObject).hXu = paramAnonymousBoolean;
        localObject = BaseLifeUI.f(BaseLifeUI.this).wqh;
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label569;
        }
        localObject = (BackwardSupportUtil.ExifHelper.LatLongData)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
        BaseLifeUI.this.p(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).dyz, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).ibC);
        BaseLifeUI.this.wqK = BaseLifeUI.m(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).dyz, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).ibC, paramAnonymousFloat2, paramAnonymousFloat1);
        BaseLifeUI.f(BaseLifeUI.this).wql = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.wqz.FOB, BaseLifeUI.this.wqz.FOA);
        BaseLifeUI.b(BaseLifeUI.this).wql = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.wqz.FOB, BaseLifeUI.this.wqz.FOA);
        localBaseLifeUI = BaseLifeUI.this;
        if (!BaseLifeUI.this.jgw) {
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
        paramAnonymousBoolean = BaseLifeUI.l(BaseLifeUI.this).hXu;
        break;
        BaseLifeUI.this.p(paramAnonymousFloat2, paramAnonymousFloat1);
        break label418;
      }
    }
  };
  private String wqa = "";
  private View wqo;
  private NearLifeErrorContent wqp;
  private a wqq;
  private a wqr;
  private View wqs;
  private TextView wqt;
  private TextView wqu;
  private com.tencent.mm.modelgeo.d wqv = com.tencent.mm.modelgeo.d.aHQ();
  private com.tencent.mm.plugin.nearlife.b.d wqw;
  private int wqx;
  private List<btm> wqy;
  protected btm wqz = null;
  
  private void LK(int paramInt)
  {
    this.vfv.removeFooterView(this.wqo);
    this.vfv.removeFooterView(this.wqs);
    this.vfv.fyO();
    this.wqs.setVisibility(paramInt);
    this.wqt.setVisibility(paramInt);
    this.wqu.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.vfv.addFooterView(this.wqs);
      return;
    }
    this.vfv.fyK();
    this.vfv.addFooterView(this.wqo);
  }
  
  private void dui()
  {
    if (!this.jgw) {
      ad.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }
    for (;;)
    {
      return;
      try
      {
        int i = Integer.valueOf(com.tencent.mm.n.g.acA().getValue("POICreateForbiden")).intValue();
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
    if (!this.wqr.ata(this.wqr.dud()))
    {
      str = String.format(getResources().getString(2131761604), new Object[] { this.wqr.dud() });
      this.wqt.setText(str);
      LK(0);
      return;
    }
    LK(8);
  }
  
  private boolean pf(boolean paramBoolean)
  {
    btm localbtm;
    do
    {
      if (this.wqw != null)
      {
        ad.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
      }
      if (this.wqy.size() - 1 <= this.wqx)
      {
        this.wqx = -1;
        ad.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
        return false;
      }
      this.wqx += 1;
      localbtm = (btm)this.wqy.get(this.wqx);
      if (this.wqx == 0) {
        this.wqH += 1;
      }
      if (!this.jgw) {
        break;
      }
      i = this.wqr.b(new BackwardSupportUtil.ExifHelper.LatLongData(localbtm.FOB, localbtm.FOA));
    } while (i <= 0);
    SKBuiltinBuffer_t localSKBuiltinBuffer_t;
    if (this.jgw)
    {
      localSKBuiltinBuffer_t = this.wqr.a(new BackwardSupportUtil.ExifHelper.LatLongData(localbtm.FOB, localbtm.FOA));
      label166:
      if (!this.jgw) {
        break label249;
      }
    }
    label249:
    for (int i = 1;; i = 0)
    {
      if (com.tencent.mm.plugin.nearlife.b.d.LH(i)) {
        break label255;
      }
      this.wqx = -1;
      return false;
      i = this.wqq.b(new BackwardSupportUtil.ExifHelper.LatLongData(localbtm.FOB, localbtm.FOA));
      break;
      localSKBuiltinBuffer_t = this.wqq.a(new BackwardSupportUtil.ExifHelper.LatLongData(localbtm.FOB, localbtm.FOA));
      break label166;
    }
    label255:
    if (-1L == this.wqE) {
      this.wqE = System.currentTimeMillis();
    }
    int j = this.sceneType;
    float f1 = localbtm.FOA;
    float f2 = localbtm.FOB;
    int k = localbtm.Ggw;
    int m = localbtm.Ggz;
    String str2 = localbtm.Ggx;
    String str3 = localbtm.Ggy;
    if (this.jgw) {}
    for (String str1 = this.wqr.dud();; str1 = "")
    {
      this.wqw = new com.tencent.mm.plugin.nearlife.b.d(i, j, f1, f2, k, m, str2, str3, localSKBuiltinBuffer_t, str1, this.vfX, paramBoolean, false);
      ba.aiU().a(this.wqw, 0);
      ad.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", new Object[] { Integer.valueOf(this.wqx), Float.valueOf(localbtm.FOB), Float.valueOf(localbtm.FOA) });
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
          if (this.wqK)
          {
            paramString = com.tencent.mm.plugin.report.service.g.yhR;
            if (!paramBoolean1) {
              break label402;
            }
            j = 5;
            paramString.f(11139, new Object[] { Integer.valueOf(j) });
          }
          if (!paramBoolean1) {
            break label408;
          }
          paramString = this.wqr.LJ(paramInt).vhe;
          localObject1 = paramString;
          if (this.wqr.getCount() <= 0) {
            break label545;
          }
          str1 = this.wqr.LJ(1).dwW;
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
        str1 = this.dwW;
        localObject2 = localObject1;
        j = i;
      }
      if (this.wqz == null) {}
      for (paramString = "null/null";; paramString = String.format("%f/%f", new Object[] { Float.valueOf(this.wqz.FOB), Float.valueOf(this.wqz.FOA) }))
      {
        ad.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt + 1), str2, Integer.valueOf(paramInt), localObject2, str1 });
        com.tencent.mm.plugin.report.service.g.yhR.f(11135, new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt + 1), Long.valueOf(this.wqE), Long.valueOf(this.wqG), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.wqF), Integer.valueOf(this.wqH), paramString, str2, Integer.valueOf(this.vfX), localObject2, com.tencent.mm.compatible.deviceinfo.q.cH(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
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
        str1 = this.wqq.LJ(paramInt).vhe;
        localObject1 = str1;
        if (this.wqq.getCount() <= 0) {
          break label545;
        }
        paramString = this.wqq.LJ(1).dwW;
        localObject1 = str1;
        break label130;
        if (this.wqI) {
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
  
  public abstract a duf();
  
  public abstract a dug();
  
  public void duh()
  {
    ad.d("MicroMsg.BaseLifeUI", "init header");
    this.wqs = View.inflate(this, 2131493673, null);
    this.wqt = ((TextView)this.wqs.findViewById(2131306116));
    this.wqu = ((TextView)this.wqs.findViewById(2131306115));
    this.wqs.setOnClickListener(this.wqO);
    this.wqo = View.inflate(this, 2131495103, null);
    this.vfv.addFooterView(this.wqo);
    this.wqo.setVisibility(8);
  }
  
  public int getLayoutId()
  {
    return 2131494998;
  }
  
  public void initView()
  {
    this.vfv = ((MMLoadMoreListView)findViewById(2131302680));
    this.vfv.setFooterTips(getString(2131761492));
    this.wqp = ((NearLifeErrorContent)findViewById(2131302679));
    duh();
    this.wqq = duf();
    this.wqr = dug();
    this.vfv.setAdapter(this.wqq);
    this.wqp.setListView(this.vfv);
    this.wqq.notifyDataSetChanged();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26562);
        BaseLifeUI.this.a(-1, false, "", BaseLifeUI.this.wqL);
        BaseLifeUI.this.finish();
        AppMethodBeat.o(26562);
        return true;
      }
    });
    setToTop(new BaseLifeUI.4(this));
    this.fSC = new r((byte)0);
    this.fSC.KKQ = new r.b()
    {
      public final boolean Jp(String paramAnonymousString)
      {
        AppMethodBeat.i(26569);
        ad.d("MicroMsg.BaseLifeUI", "search key click");
        BaseLifeUI.b(BaseLifeUI.this, paramAnonymousString);
        AppMethodBeat.o(26569);
        return false;
      }
      
      public final void Jq(String paramAnonymousString)
      {
        AppMethodBeat.i(26566);
        ad.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", new Object[] { paramAnonymousString });
        if (bt.isNullOrNil(paramAnonymousString))
        {
          aSo();
          AppMethodBeat.o(26566);
          return;
        }
        BaseLifeUI.a(BaseLifeUI.this, paramAnonymousString);
        AppMethodBeat.o(26566);
      }
      
      public final void aSm()
      {
        AppMethodBeat.i(26567);
        ad.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
        BaseLifeUI.this.jgw = false;
        BaseLifeUI.this.vfv.setAdapter(BaseLifeUI.f(BaseLifeUI.this));
        BaseLifeUI.f(BaseLifeUI.this).notifyDataSetChanged();
        BaseLifeUI.g(BaseLifeUI.this).LL(BaseLifeUI.f(BaseLifeUI.this).wqn);
        if ((!BaseLifeUI.f(BaseLifeUI.this).due()) && (BaseLifeUI.h(BaseLifeUI.this) != null)) {
          BaseLifeUI.h(BaseLifeUI.this).setVisibility(0);
        }
        BaseLifeUI.this.vfv.setOnTouchListener(null);
        BaseLifeUI.e(BaseLifeUI.this);
        BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.f(BaseLifeUI.this));
        AppMethodBeat.o(26567);
      }
      
      public final void aSn()
      {
        AppMethodBeat.i(26568);
        ad.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
        BaseLifeUI.this.wqI = true;
        BaseLifeUI.i(BaseLifeUI.this).setHint(BaseLifeUI.this.getString(2131761491));
        BaseLifeUI.this.jgw = true;
        BaseLifeUI.b(BaseLifeUI.this).duc();
        BaseLifeUI.this.vfv.setAdapter(BaseLifeUI.b(BaseLifeUI.this));
        BaseLifeUI.b(BaseLifeUI.this).notifyDataSetChanged();
        BaseLifeUI.this.vfv.fyM();
        BaseLifeUI.g(BaseLifeUI.this).LL(BaseLifeUI.b(BaseLifeUI.this).wqn);
        if (BaseLifeUI.h(BaseLifeUI.this) != null) {
          BaseLifeUI.h(BaseLifeUI.this).setVisibility(8);
        }
        BaseLifeUI.this.vfv.setOnTouchListener(new BaseLifeUI.5.1(this));
        BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.b(BaseLifeUI.this));
        AppMethodBeat.o(26568);
      }
      
      public final void aSo()
      {
        AppMethodBeat.i(26565);
        ad.d("MicroMsg.BaseLifeUI", "click clear");
        if (BaseLifeUI.c(BaseLifeUI.this) != null)
        {
          ba.aiU().a(BaseLifeUI.c(BaseLifeUI.this));
          BaseLifeUI.d(BaseLifeUI.this);
        }
        BaseLifeUI.b(BaseLifeUI.this).duc();
        BaseLifeUI.e(BaseLifeUI.this);
        AppMethodBeat.o(26565);
      }
      
      public final void aSp() {}
    };
    this.vfv.setOnLoadMoreListener(new BaseLifeUI.6(this));
    this.vfv.fyL();
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
    this.wqM = getIntent().getBooleanExtra("poi_show_none", true);
    this.vfX = ((int)(System.currentTimeMillis() / 1000L));
    com.tencent.mm.plugin.nearlife.b.d.clear();
    ba.aiU().a(603, this);
    this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
    this.dwW = getIntent().getStringExtra("request_id");
    this.wqy = new ArrayList();
    initView();
  }
  
  public void onDestroy()
  {
    ba.aiU().b(603, this);
    super.onDestroy();
    if (this.wqv != null) {
      this.wqv.c(this.wqP);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.wqv.c(this.wqP);
  }
  
  public void onResume()
  {
    super.onResume();
    this.wqq.notifyDataSetChanged();
    this.vfv.fyN();
    if (this.wqv != null) {
      this.wqv.a(this.wqP, true);
    }
    this.hjP = false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    if (paramn.getType() != 603) {
      return;
    }
    this.vfv.fyM();
    com.tencent.mm.plugin.nearlife.b.d locald = (com.tencent.mm.plugin.nearlife.b.d)paramn;
    LogoImageView localLogoImageView;
    Object localObject;
    if (!bt.isNullOrNil(locald.wqa))
    {
      this.wqa = locald.wqa;
      localLogoImageView = (LogoImageView)this.wqo.findViewById(2131303550);
      localObject = this.wqa;
      ba.aBQ();
      localLogoImageView.imagePath = c.azB();
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
      this.keN = locald.keN;
      this.uZH = locald.uZH;
      i = ((com.tencent.mm.plugin.nearlife.b.d)paramn).drI;
      com.tencent.mm.plugin.nearlife.b.d.LI(i);
      if (this.wqw != null) {
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
          if (localLogoImageView.targetWidth > 0)
          {
            localObject = localBitmap;
            if (localLogoImageView.targetHeight > 0) {
              localObject = com.tencent.mm.sdk.platformtools.g.a(localBitmap, localLogoImageView.targetWidth, localLogoImageView.targetHeight, true, false);
            }
          }
          localLogoImageView.setImageBitmap((Bitmap)localObject);
        }
        else
        {
          com.tencent.mm.sdk.g.b.c(new LogoImageView.a((String)localObject, localLogoImageView.handler), "LogoImageView_download");
        }
      }
      else if (!i.fv((String)localObject))
      {
        localLogoImageView.setVisibility(8);
      }
      else
      {
        if ((localLogoImageView.targetWidth <= 0) || (localLogoImageView.targetHeight <= 0)) {}
        for (localObject = com.tencent.mm.sdk.platformtools.g.aQf((String)localObject);; localObject = com.tencent.mm.sdk.platformtools.g.d((String)localObject, localLogoImageView.targetWidth, localLogoImageView.targetHeight, true))
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
    ad.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", new Object[] { Integer.valueOf(this.wqx), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
    if ((paramInt2 == 0) || (paramInt2 == 101))
    {
      i = 1;
      if ((paramInt1 == 0) || (i != 0)) {
        break label538;
      }
      ad.d("MicroMsg.BaseLifeUI", "error");
      if (!this.jgw) {
        break label530;
      }
      paramString = this.wqr;
      label471:
      if ((this.wqy.size() - 1 == this.wqx) && (paramString.getCount() == 0))
      {
        paramString.wqn = 1;
        this.wqp.LL(paramString.wqn);
      }
    }
    for (;;)
    {
      this.wqw = null;
      pf(false);
      return;
      i = 0;
      break;
      label530:
      paramString = this.wqq;
      break label471;
      label538:
      if (-1L == this.wqF) {
        this.wqF = System.currentTimeMillis();
      }
      this.wqG = System.currentTimeMillis();
      paramn = locald.wqb;
      paramString = (btm)this.wqy.get(this.wqx);
      localObject = new BackwardSupportUtil.ExifHelper.LatLongData(paramString.FOB, paramString.FOA);
      if ((this.jgw) && (!this.wqw.wqc)) {
        this.wqr.duc();
      }
      if (this.jgw)
      {
        this.wqr.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, locald.cyq(), locald.dub());
        label654:
        if ((paramn != null) && (paramn.size() != 0)) {
          break label828;
        }
        if (!this.jgw) {
          break label820;
        }
      }
      label820:
      for (paramString = this.wqr;; paramString = this.wqq)
      {
        if (this.wqy.size() - 1 == this.wqx)
        {
          if (paramString.getCount() == 0) {
            this.wqp.LL(paramString.wqn);
          }
          this.vfv.fyM();
          if ((!paramString.due()) && (paramInt2 != 101)) {
            dui();
          }
        }
        if ((!this.wqq.due()) && (this.wqo != null) && (!this.jgw)) {
          this.wqo.setVisibility(0);
        }
        if ((this.wqo == null) || (this.jgw)) {
          break label926;
        }
        this.wqo.setVisibility(0);
        break;
        this.wqq.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, locald.cyq(), locald.dub());
        break label654;
      }
      label828:
      if (this.jgw) {}
      for (paramString = this.wqr;; paramString = this.wqq)
      {
        this.vfv.setVisibility(0);
        paramString.wqn = 0;
        this.wqp.LL(this.wqr.wqn);
        paramString.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, paramn);
        paramString.notifyDataSetChanged();
        if ((this.wqy.size() - 1 != this.wqx) || (paramString.due())) {
          break;
        }
        this.vfv.fyM();
        dui();
        break;
      }
      label926:
      if (this.wqo != null) {
        this.wqo.setVisibility(8);
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