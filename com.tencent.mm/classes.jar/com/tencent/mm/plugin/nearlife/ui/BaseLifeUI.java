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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.n.f;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.s.b;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLifeUI
  extends MMActivity
  implements i
{
  private String AAU = "";
  protected int ABA = 0;
  protected boolean ABB = false;
  protected int ABC = -1;
  protected boolean ABD = false;
  boolean ABE = false;
  protected boolean ABF = true;
  private View.OnClickListener ABG = new BaseLifeUI.1(this);
  private View.OnClickListener ABH = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(26561);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (BaseLifeUI.this.ABs == null)
      {
        Log.e("MicroMsg.BaseLifeUI", "Location is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26561);
        return;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(11138, new Object[] { "1", Integer.valueOf(BaseLifeUI.b(BaseLifeUI.this).getCount() + 1), BaseLifeUI.this.hes });
      paramAnonymousView = new Intent();
      paramAnonymousView.setClass(BaseLifeUI.this, NearLifeCreatePoiUI.class);
      paramAnonymousView.putExtra("get_lat", BaseLifeUI.this.ABs.LbD);
      paramAnonymousView.putExtra("get_lng", BaseLifeUI.this.ABs.LbC);
      paramAnonymousView.putExtra("get_preci", BaseLifeUI.this.ABs.LuT);
      paramAnonymousView.putExtra("get_poi_name", BaseLifeUI.b(BaseLifeUI.this).exa());
      paramAnonymousView.putExtra("get_cur_lat", BaseLifeUI.this.ABt);
      paramAnonymousView.putExtra("get_cur_lng", BaseLifeUI.this.ABu);
      paramAnonymousView.putExtra("get_accuracy", BaseLifeUI.this.ABw);
      paramAnonymousView.putExtra("get_loctype", BaseLifeUI.this.ABv);
      paramAnonymousView.putExtra("search_id", BaseLifeUI.this.hes);
      paramAnonymousView.putExtra("get_is_mars", BaseLifeUI.this.iVk);
      BaseLifeUI.this.startActivityForResult(paramAnonymousView, 1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26561);
    }
  };
  private b.a ABI = new b.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
    {
      AppMethodBeat.i(26572);
      if (BaseLifeUI.this.ifz)
      {
        AppMethodBeat.o(26572);
        return false;
      }
      if (BaseLifeUI.this.gmw)
      {
        AppMethodBeat.o(26572);
        return false;
      }
      if (!paramAnonymousBoolean)
      {
        if ((!BaseLifeUI.j(BaseLifeUI.this)) && (!com.tencent.mm.modelgeo.d.bcc()))
        {
          BaseLifeUI.k(BaseLifeUI.this);
          com.tencent.mm.ui.base.h.a(BaseLifeUI.this, BaseLifeUI.this.getString(2131761461), BaseLifeUI.this.getString(2131755998), BaseLifeUI.this.getString(2131762043), BaseLifeUI.this.getString(2131755761), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(26571);
              com.tencent.mm.modelgeo.d.cZ(BaseLifeUI.this);
              AppMethodBeat.o(26571);
            }
          }, null);
        }
        AppMethodBeat.o(26572);
        return true;
      }
      o.a(2003, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
      BaseLifeUI.this.gmw = true;
      Log.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
      BaseLifeUI.this.ABs = new chk();
      BaseLifeUI.this.ABs.LuV = "";
      BaseLifeUI.this.ABs.LuW = 0;
      BaseLifeUI.this.ABs.LbD = paramAnonymousFloat2;
      BaseLifeUI.this.ABs.LbC = paramAnonymousFloat1;
      BaseLifeUI.this.ABs.LuU = "";
      BaseLifeUI.this.ABs.LuT = ((int)paramAnonymousDouble2);
      BaseLifeUI.this.ABt = paramAnonymousFloat2;
      BaseLifeUI.this.ABu = paramAnonymousFloat1;
      BaseLifeUI.this.ABv = paramAnonymousInt;
      BaseLifeUI.this.ABw = ((float)paramAnonymousDouble2);
      Object localObject = BaseLifeUI.this;
      label418:
      BaseLifeUI localBaseLifeUI;
      if (BaseLifeUI.l(BaseLifeUI.this) == null)
      {
        paramAnonymousBoolean = false;
        ((BaseLifeUI)localObject).iVk = paramAnonymousBoolean;
        localObject = BaseLifeUI.f(BaseLifeUI.this).ABb;
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label569;
        }
        localObject = (BackwardSupportUtil.ExifHelper.LatLongData)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
        BaseLifeUI.this.p(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).latitude, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).longtitude);
        BaseLifeUI.this.ABD = BaseLifeUI.p(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).latitude, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).longtitude, paramAnonymousFloat2, paramAnonymousFloat1);
        BaseLifeUI.f(BaseLifeUI.this).ABf = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.ABs.LbD, BaseLifeUI.this.ABs.LbC);
        BaseLifeUI.b(BaseLifeUI.this).ABf = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.ABs.LbD, BaseLifeUI.this.ABs.LbC);
        localBaseLifeUI = BaseLifeUI.this;
        if (!BaseLifeUI.this.khr) {
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
        paramAnonymousBoolean = BaseLifeUI.l(BaseLifeUI.this).iVk;
        break;
        BaseLifeUI.this.p(paramAnonymousFloat2, paramAnonymousFloat1);
        break label418;
      }
    }
  };
  private View ABi;
  private NearLifeErrorContent ABj;
  private a ABk;
  private a ABl;
  private View ABm;
  private TextView ABn;
  private TextView ABo;
  private com.tencent.mm.plugin.nearlife.b.d ABp;
  private int ABq;
  private List<chk> ABr;
  protected chk ABs = null;
  protected float ABt = 0.0F;
  protected float ABu = 0.0F;
  protected int ABv = 0;
  protected float ABw = 0.0F;
  protected long ABx = -1L;
  protected long ABy = -1L;
  protected long ABz = -1L;
  protected String dPI = "";
  boolean gmw = false;
  private com.tencent.mm.ui.tools.s gzP;
  protected String hes = "";
  protected boolean iVk = true;
  boolean ifz = false;
  boolean khr = false;
  int sceneType = 0;
  private boolean uSq = false;
  private boolean uSu;
  private com.tencent.mm.modelgeo.d uzs = com.tencent.mm.modelgeo.d.bca();
  private int yFK = 1;
  public int yLS = -1;
  MMLoadMoreListView yLr;
  
  private void Tw(int paramInt)
  {
    this.yLr.removeFooterView(this.ABi);
    this.yLr.removeFooterView(this.ABm);
    this.yLr.gKP();
    this.ABm.setVisibility(paramInt);
    this.ABn.setVisibility(paramInt);
    this.ABo.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.yLr.addFooterView(this.ABm);
      return;
    }
    this.yLr.gKL();
    this.yLr.addFooterView(this.ABi);
  }
  
  private void exf()
  {
    if (!this.khr) {
      Log.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }
    for (;;)
    {
      return;
      try
      {
        int i = Integer.valueOf(com.tencent.mm.n.h.aqJ().getValue("POICreateForbiden")).intValue();
        Log.i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", new Object[] { Integer.valueOf(i) });
        if (i == 1) {}
      }
      catch (Exception localException)
      {
        label56:
        String str;
        break label56;
      }
    }
    if (!this.ABl.aIw(this.ABl.exa()))
    {
      str = String.format(getResources().getString(2131763572), new Object[] { this.ABl.exa() });
      this.ABn.setText(str);
      Tw(0);
      return;
    }
    Tw(8);
  }
  
  private boolean ss(boolean paramBoolean)
  {
    chk localchk;
    do
    {
      if (this.ABp != null)
      {
        Log.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
      }
      if (this.ABr.size() - 1 <= this.ABq)
      {
        this.ABq = -1;
        Log.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
        return false;
      }
      this.ABq += 1;
      localchk = (chk)this.ABr.get(this.ABq);
      if (this.ABq == 0) {
        this.ABA += 1;
      }
      if (!this.khr) {
        break;
      }
      i = this.ABl.b(new BackwardSupportUtil.ExifHelper.LatLongData(localchk.LbD, localchk.LbC));
    } while (i <= 0);
    SKBuiltinBuffer_t localSKBuiltinBuffer_t;
    if (this.khr)
    {
      localSKBuiltinBuffer_t = this.ABl.a(new BackwardSupportUtil.ExifHelper.LatLongData(localchk.LbD, localchk.LbC));
      label166:
      if (!this.khr) {
        break label249;
      }
    }
    label249:
    for (int i = 1;; i = 0)
    {
      if (com.tencent.mm.plugin.nearlife.b.d.Tt(i)) {
        break label255;
      }
      this.ABq = -1;
      return false;
      i = this.ABk.b(new BackwardSupportUtil.ExifHelper.LatLongData(localchk.LbD, localchk.LbC));
      break;
      localSKBuiltinBuffer_t = this.ABk.a(new BackwardSupportUtil.ExifHelper.LatLongData(localchk.LbD, localchk.LbC));
      break label166;
    }
    label255:
    if (-1L == this.ABx) {
      this.ABx = System.currentTimeMillis();
    }
    int j = this.sceneType;
    float f1 = localchk.LbC;
    float f2 = localchk.LbD;
    int k = localchk.LuT;
    int m = localchk.LuW;
    String str2 = localchk.LuU;
    String str3 = localchk.LuV;
    if (this.khr) {}
    for (String str1 = this.ABl.exa();; str1 = "")
    {
      this.ABp = new com.tencent.mm.plugin.nearlife.b.d(i, j, f1, f2, k, m, str2, str3, localSKBuiltinBuffer_t, str1, this.yLS, paramBoolean, false);
      bg.azz().a(this.ABp, 0);
      Log.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", new Object[] { Integer.valueOf(this.ABq), Float.valueOf(localchk.LbD), Float.valueOf(localchk.LbC) });
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
          if (this.ABD)
          {
            paramString = com.tencent.mm.plugin.report.service.h.CyF;
            if (!paramBoolean1) {
              break label402;
            }
            j = 5;
            paramString.a(11139, new Object[] { Integer.valueOf(j) });
          }
          if (!paramBoolean1) {
            break label408;
          }
          paramString = this.ABl.Tv(paramInt).yMY;
          localObject1 = paramString;
          if (this.ABl.getCount() <= 0) {
            break label545;
          }
          str1 = this.ABl.Tv(1).dPI;
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
      if (Util.isNullOrNil(paramString))
      {
        str1 = this.dPI;
        localObject2 = localObject1;
        j = i;
      }
      if (this.ABs == null) {}
      for (paramString = "null/null";; paramString = String.format("%f/%f", new Object[] { Float.valueOf(this.ABs.LbD), Float.valueOf(this.ABs.LbC) }))
      {
        Log.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt + 1), str2, Integer.valueOf(paramInt), localObject2, str1 });
        com.tencent.mm.plugin.report.service.h.CyF.a(11135, new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt + 1), Long.valueOf(this.ABx), Long.valueOf(this.ABz), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.ABy), Integer.valueOf(this.ABA), paramString, str2, Integer.valueOf(this.yLS), localObject2, com.tencent.mm.compatible.deviceinfo.q.dr(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
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
        str1 = this.ABk.Tv(paramInt).yMY;
        localObject1 = str1;
        if (this.ABk.getCount() <= 0) {
          break label545;
        }
        paramString = this.ABk.Tv(1).dPI;
        localObject1 = str1;
        break label130;
        if (this.ABB) {
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
  
  public abstract a exc();
  
  public abstract a exd();
  
  public void exe()
  {
    Log.d("MicroMsg.BaseLifeUI", "init header");
    this.ABm = View.inflate(this, 2131493804, null);
    this.ABn = ((TextView)this.ABm.findViewById(2131309469));
    this.ABo = ((TextView)this.ABm.findViewById(2131309468));
    this.ABm.setOnClickListener(this.ABH);
    this.ABi = View.inflate(this, 2131495945, null);
    this.yLr.addFooterView(this.ABi);
    this.ABi.setVisibility(8);
  }
  
  public int getLayoutId()
  {
    return 2131495811;
  }
  
  public void initView()
  {
    this.yLr = ((MMLoadMoreListView)findViewById(2131305234));
    this.yLr.setFooterTips(getString(2131763434));
    this.ABj = ((NearLifeErrorContent)findViewById(2131305233));
    exe();
    this.ABk = exc();
    this.ABl = exd();
    this.yLr.setAdapter(this.ABk);
    this.ABj.setListView(this.yLr);
    this.ABk.notifyDataSetChanged();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26562);
        BaseLifeUI.this.a(-1, false, "", BaseLifeUI.this.ABE);
        BaseLifeUI.this.finish();
        AppMethodBeat.o(26562);
        return true;
      }
    });
    setToTop(new BaseLifeUI.4(this));
    this.gzP = new com.tencent.mm.ui.tools.s((byte)0);
    this.gzP.Qwi = new s.b()
    {
      public final boolean SN(String paramAnonymousString)
      {
        AppMethodBeat.i(26569);
        Log.d("MicroMsg.BaseLifeUI", "search key click");
        BaseLifeUI.b(BaseLifeUI.this, paramAnonymousString);
        AppMethodBeat.o(26569);
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(26566);
        Log.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", new Object[] { paramAnonymousString });
        if (Util.isNullOrNil(paramAnonymousString))
        {
          bnA();
          AppMethodBeat.o(26566);
          return;
        }
        BaseLifeUI.a(BaseLifeUI.this, paramAnonymousString);
        AppMethodBeat.o(26566);
      }
      
      public final void bnA()
      {
        AppMethodBeat.i(26565);
        Log.d("MicroMsg.BaseLifeUI", "click clear");
        if (BaseLifeUI.c(BaseLifeUI.this) != null)
        {
          bg.azz().a(BaseLifeUI.c(BaseLifeUI.this));
          BaseLifeUI.d(BaseLifeUI.this);
        }
        BaseLifeUI.b(BaseLifeUI.this).ewZ();
        BaseLifeUI.e(BaseLifeUI.this);
        AppMethodBeat.o(26565);
      }
      
      public final void bnB() {}
      
      public final void bny()
      {
        AppMethodBeat.i(26567);
        Log.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
        BaseLifeUI.this.khr = false;
        BaseLifeUI.this.yLr.setAdapter(BaseLifeUI.f(BaseLifeUI.this));
        BaseLifeUI.f(BaseLifeUI.this).notifyDataSetChanged();
        BaseLifeUI.g(BaseLifeUI.this).Tx(BaseLifeUI.f(BaseLifeUI.this).ABh);
        if ((!BaseLifeUI.f(BaseLifeUI.this).exb()) && (BaseLifeUI.h(BaseLifeUI.this) != null)) {
          BaseLifeUI.h(BaseLifeUI.this).setVisibility(0);
        }
        BaseLifeUI.this.yLr.setOnTouchListener(null);
        BaseLifeUI.e(BaseLifeUI.this);
        BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.f(BaseLifeUI.this));
        AppMethodBeat.o(26567);
      }
      
      public final void bnz()
      {
        AppMethodBeat.i(26568);
        Log.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
        BaseLifeUI.this.ABB = true;
        BaseLifeUI.i(BaseLifeUI.this).setHint(BaseLifeUI.this.getString(2131763433));
        BaseLifeUI.this.khr = true;
        BaseLifeUI.b(BaseLifeUI.this).ewZ();
        BaseLifeUI.this.yLr.setAdapter(BaseLifeUI.b(BaseLifeUI.this));
        BaseLifeUI.b(BaseLifeUI.this).notifyDataSetChanged();
        BaseLifeUI.this.yLr.gKN();
        BaseLifeUI.g(BaseLifeUI.this).Tx(BaseLifeUI.b(BaseLifeUI.this).ABh);
        if (BaseLifeUI.h(BaseLifeUI.this) != null) {
          BaseLifeUI.h(BaseLifeUI.this).setVisibility(8);
        }
        BaseLifeUI.this.yLr.setOnTouchListener(new View.OnTouchListener()
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
    };
    this.yLr.setOnLoadMoreListener(new BaseLifeUI.6(this));
    this.yLr.gKM();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.d("MicroMsg.BaseLifeUI", "onActivityResult requestCode %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
    this.ABF = getIntent().getBooleanExtra("poi_show_none", true);
    this.yLS = ((int)(System.currentTimeMillis() / 1000L));
    com.tencent.mm.plugin.nearlife.b.d.clear();
    bg.azz().a(603, this);
    this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
    this.dPI = getIntent().getStringExtra("request_id");
    this.ABr = new ArrayList();
    initView();
  }
  
  public void onDestroy()
  {
    bg.azz().b(603, this);
    super.onDestroy();
    if (this.uzs != null) {
      this.uzs.c(this.ABI);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.uzs.c(this.ABI);
  }
  
  public void onResume()
  {
    super.onResume();
    this.ABk.notifyDataSetChanged();
    this.yLr.gKO();
    if (this.uzs != null) {
      this.uzs.a(this.ABI, true);
    }
    this.ifz = false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    if (paramq.getType() != 603) {
      return;
    }
    this.yLr.gKN();
    com.tencent.mm.plugin.nearlife.b.d locald = (com.tencent.mm.plugin.nearlife.b.d)paramq;
    LogoImageView localLogoImageView;
    Object localObject;
    if (!Util.isNullOrNil(locald.AAU))
    {
      this.AAU = locald.AAU;
      localLogoImageView = (LogoImageView)this.ABi.findViewById(2131306325);
      localObject = this.AAU;
      bg.aVF();
      localLogoImageView.imagePath = c.aSZ();
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
      this.hes = locald.hes;
      this.yFK = locald.yFK;
      i = ((com.tencent.mm.plugin.nearlife.b.d)paramq).dJY;
      com.tencent.mm.plugin.nearlife.b.d.Tu(i);
      if (this.ABp != null) {
        break;
      }
      Log.d("MicroMsg.BaseLifeUI", "scene is null");
      return;
      label168:
      if (((String)localObject).startsWith("http"))
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(localLogoImageView.imagePath + g.getMessageDigest(((String)localObject).getBytes()));
        if (localBitmap != null)
        {
          localObject = localBitmap;
          if (localLogoImageView.targetWidth > 0)
          {
            localObject = localBitmap;
            if (localLogoImageView.targetHeight > 0) {
              localObject = BitmapUtil.extractThumbNail(localBitmap, localLogoImageView.targetWidth, localLogoImageView.targetHeight, true, false);
            }
          }
          localLogoImageView.setImageBitmap((Bitmap)localObject);
        }
        else
        {
          ThreadPool.post(new LogoImageView.a((String)localObject, localLogoImageView.handler), "LogoImageView_download");
        }
      }
      else if (!com.tencent.mm.vfs.s.YS((String)localObject))
      {
        localLogoImageView.setVisibility(8);
      }
      else
      {
        if ((localLogoImageView.targetWidth <= 0) || (localLogoImageView.targetHeight <= 0)) {}
        for (localObject = BitmapUtil.getBitmapNative((String)localObject);; localObject = BitmapUtil.extractThumbNail((String)localObject, localLogoImageView.targetWidth, localLogoImageView.targetHeight, true))
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
    Log.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", new Object[] { Integer.valueOf(this.ABq), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
    if ((paramInt2 == 0) || (paramInt2 == 101))
    {
      i = 1;
      if ((paramInt1 == 0) || (i != 0)) {
        break label538;
      }
      Log.d("MicroMsg.BaseLifeUI", "error");
      if (!this.khr) {
        break label530;
      }
      paramString = this.ABl;
      label471:
      if ((this.ABr.size() - 1 == this.ABq) && (paramString.getCount() == 0))
      {
        paramString.ABh = 1;
        this.ABj.Tx(paramString.ABh);
      }
    }
    for (;;)
    {
      this.ABp = null;
      ss(false);
      return;
      i = 0;
      break;
      label530:
      paramString = this.ABk;
      break label471;
      label538:
      if (-1L == this.ABy) {
        this.ABy = System.currentTimeMillis();
      }
      this.ABz = System.currentTimeMillis();
      paramq = locald.AAV;
      paramString = (chk)this.ABr.get(this.ABq);
      localObject = new BackwardSupportUtil.ExifHelper.LatLongData(paramString.LbD, paramString.LbC);
      if ((this.khr) && (!this.ABp.AAW)) {
        this.ABl.ewZ();
      }
      if (this.khr)
      {
        this.ABl.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, locald.cYA(), locald.ewY());
        label654:
        if ((paramq != null) && (paramq.size() != 0)) {
          break label828;
        }
        if (!this.khr) {
          break label820;
        }
      }
      label820:
      for (paramString = this.ABl;; paramString = this.ABk)
      {
        if (this.ABr.size() - 1 == this.ABq)
        {
          if (paramString.getCount() == 0) {
            this.ABj.Tx(paramString.ABh);
          }
          this.yLr.gKN();
          if ((!paramString.exb()) && (paramInt2 != 101)) {
            exf();
          }
        }
        if ((!this.ABk.exb()) && (this.ABi != null) && (!this.khr)) {
          this.ABi.setVisibility(0);
        }
        if ((this.ABi == null) || (this.khr)) {
          break label926;
        }
        this.ABi.setVisibility(0);
        break;
        this.ABk.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, locald.cYA(), locald.ewY());
        break label654;
      }
      label828:
      if (this.khr) {}
      for (paramString = this.ABl;; paramString = this.ABk)
      {
        this.yLr.setVisibility(0);
        paramString.ABh = 0;
        this.ABj.Tx(this.ABl.ABh);
        paramString.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, paramq);
        paramString.notifyDataSetChanged();
        if ((this.ABr.size() - 1 != this.ABq) || (paramString.exb())) {
          break;
        }
        this.yLr.gKN();
        exf();
        break;
      }
      label926:
      if (this.ABi != null) {
        this.ABi.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI
 * JD-Core Version:    0.7.0.1
 */