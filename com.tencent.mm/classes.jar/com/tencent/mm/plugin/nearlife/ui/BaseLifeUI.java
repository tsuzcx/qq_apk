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
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.n.f;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.tools.t.b;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLifeUI
  extends MMActivity
  implements i
{
  private int EjD = 1;
  public int EpL = -1;
  MMLoadMoreListView Epk;
  private String GtW = "";
  protected long GuA = -1L;
  protected long GuB = -1L;
  protected int GuC = 0;
  protected boolean GuD = false;
  protected int GuE = -1;
  protected boolean GuF = false;
  boolean GuG = false;
  protected boolean GuH = true;
  private View.OnClickListener GuI = new BaseLifeUI.1(this);
  private View.OnClickListener GuJ = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(26561);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (BaseLifeUI.this.Guu == null)
      {
        Log.e("MicroMsg.BaseLifeUI", "Location is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26561);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(11138, new Object[] { "1", Integer.valueOf(BaseLifeUI.b(BaseLifeUI.this).getCount() + 1), BaseLifeUI.this.jQi });
      paramAnonymousView = new Intent();
      paramAnonymousView.setClass(BaseLifeUI.this, NearLifeCreatePoiUI.class);
      paramAnonymousView.putExtra("get_lat", BaseLifeUI.this.Guu.ScP);
      paramAnonymousView.putExtra("get_lng", BaseLifeUI.this.Guu.ScO);
      paramAnonymousView.putExtra("get_preci", BaseLifeUI.this.Guu.Sxt);
      paramAnonymousView.putExtra("get_poi_name", BaseLifeUI.b(BaseLifeUI.this).fiD());
      paramAnonymousView.putExtra("get_cur_lat", BaseLifeUI.this.Guv);
      paramAnonymousView.putExtra("get_cur_lng", BaseLifeUI.this.Guw);
      paramAnonymousView.putExtra("get_accuracy", BaseLifeUI.this.Guy);
      paramAnonymousView.putExtra("get_loctype", BaseLifeUI.this.Gux);
      paramAnonymousView.putExtra("search_id", BaseLifeUI.this.jQi);
      paramAnonymousView.putExtra("get_is_mars", BaseLifeUI.this.lLE);
      BaseLifeUI.this.startActivityForResult(paramAnonymousView, 1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26561);
    }
  };
  private b.a GuK = new b.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
    {
      AppMethodBeat.i(26572);
      if (BaseLifeUI.this.kUn)
      {
        AppMethodBeat.o(26572);
        return false;
      }
      if (BaseLifeUI.this.iQF)
      {
        AppMethodBeat.o(26572);
        return false;
      }
      if (!paramAnonymousBoolean)
      {
        if ((!BaseLifeUI.i(BaseLifeUI.this)) && (!com.tencent.mm.modelgeo.d.blr()))
        {
          BaseLifeUI.j(BaseLifeUI.this);
          com.tencent.mm.ui.base.h.a(BaseLifeUI.this, BaseLifeUI.this.getString(R.l.gps_disable_tip), BaseLifeUI.this.getString(R.l.app_tip), BaseLifeUI.this.getString(R.l.jump_to_settings), BaseLifeUI.this.getString(R.l.app_cancel), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(26571);
              com.tencent.mm.modelgeo.d.cW(BaseLifeUI.this);
              AppMethodBeat.o(26571);
            }
          }, null);
        }
        AppMethodBeat.o(26572);
        return true;
      }
      n.a(2003, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
      BaseLifeUI.this.iQF = true;
      Log.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
      BaseLifeUI.this.Guu = new cqg();
      BaseLifeUI.this.Guu.Sxv = "";
      BaseLifeUI.this.Guu.Sxw = 0;
      BaseLifeUI.this.Guu.ScP = paramAnonymousFloat2;
      BaseLifeUI.this.Guu.ScO = paramAnonymousFloat1;
      BaseLifeUI.this.Guu.Sxu = "";
      BaseLifeUI.this.Guu.Sxt = ((int)paramAnonymousDouble2);
      BaseLifeUI.this.Guv = paramAnonymousFloat2;
      BaseLifeUI.this.Guw = paramAnonymousFloat1;
      BaseLifeUI.this.Gux = paramAnonymousInt;
      BaseLifeUI.this.Guy = ((float)paramAnonymousDouble2);
      Object localObject = BaseLifeUI.this;
      label422:
      BaseLifeUI localBaseLifeUI;
      if (BaseLifeUI.k(BaseLifeUI.this) == null)
      {
        paramAnonymousBoolean = false;
        ((BaseLifeUI)localObject).lLE = paramAnonymousBoolean;
        localObject = BaseLifeUI.f(BaseLifeUI.this).Gud;
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label573;
        }
        localObject = (BackwardSupportUtil.ExifHelper.LatLongData)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
        BaseLifeUI.this.n(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).latitude, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).longtitude);
        BaseLifeUI.this.GuF = BaseLifeUI.q(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).latitude, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).longtitude, paramAnonymousFloat2, paramAnonymousFloat1);
        BaseLifeUI.f(BaseLifeUI.this).Guh = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.Guu.ScP, BaseLifeUI.this.Guu.ScO);
        BaseLifeUI.b(BaseLifeUI.this).Guh = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.Guu.ScP, BaseLifeUI.this.Guu.ScO);
        localBaseLifeUI = BaseLifeUI.this;
        if (!BaseLifeUI.this.mYQ) {
          break label587;
        }
      }
      label573:
      label587:
      for (localObject = BaseLifeUI.b(BaseLifeUI.this);; localObject = BaseLifeUI.f(BaseLifeUI.this))
      {
        BaseLifeUI.a(localBaseLifeUI, (a)localObject);
        BaseLifeUI.l(BaseLifeUI.this);
        BaseLifeUI.this.addSearchMenu(true, BaseLifeUI.this.jjS);
        AppMethodBeat.o(26572);
        return false;
        paramAnonymousBoolean = BaseLifeUI.k(BaseLifeUI.this).lLE;
        break;
        BaseLifeUI.this.n(paramAnonymousFloat2, paramAnonymousFloat1);
        break label422;
      }
    }
  };
  private View Guk;
  private NearLifeErrorContent Gul;
  private a Gum;
  private a Gun;
  private View Guo;
  private TextView Gup;
  private TextView Guq;
  private com.tencent.mm.plugin.nearlife.b.d Gur;
  private int Gus;
  private List<cqg> Gut;
  protected cqg Guu = null;
  protected float Guv = 0.0F;
  protected float Guw = 0.0F;
  protected int Gux = 0;
  protected float Guy = 0.0F;
  protected long Guz = -1L;
  protected String fIY = "";
  boolean iQF = false;
  protected String jQi = "";
  protected com.tencent.mm.ui.tools.t jjS;
  boolean kUn = false;
  protected boolean lLE = true;
  boolean mYQ = false;
  int sceneType = 0;
  private com.tencent.mm.modelgeo.d yUU = com.tencent.mm.modelgeo.d.blq();
  private boolean zHE = false;
  private boolean zHI;
  
  private void aai(int paramInt)
  {
    this.Epk.removeFooterView(this.Guk);
    this.Epk.removeFooterView(this.Guo);
    this.Epk.hJN();
    this.Guo.setVisibility(paramInt);
    this.Gup.setVisibility(paramInt);
    this.Guq.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.Epk.addFooterView(this.Guo);
      return;
    }
    this.Epk.cnx();
    this.Epk.addFooterView(this.Guk);
  }
  
  private void fiI()
  {
    if (!this.mYQ) {
      Log.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }
    for (;;)
    {
      return;
      if (gBE()) {}
      try
      {
        int i = Integer.valueOf(com.tencent.mm.n.h.axc().getValue("POICreateForbiden")).intValue();
        Log.i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", new Object[] { Integer.valueOf(i) });
        if (i == 1) {}
      }
      catch (Exception localException)
      {
        label63:
        String str;
        break label63;
      }
    }
    if (!this.Gun.aSQ(this.Gun.fiD()))
    {
      str = String.format(getResources().getString(R.l.eMG), new Object[] { this.Gun.fiD() });
      this.Gup.setText(str);
      aai(0);
      return;
    }
    aai(8);
  }
  
  private boolean vF(boolean paramBoolean)
  {
    cqg localcqg;
    do
    {
      if (this.Gur != null)
      {
        Log.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
      }
      if (this.Gut.size() - 1 <= this.Gus)
      {
        this.Gus = -1;
        Log.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
        return false;
      }
      this.Gus += 1;
      localcqg = (cqg)this.Gut.get(this.Gus);
      if (this.Gus == 0) {
        this.GuC += 1;
      }
      if (!this.mYQ) {
        break;
      }
      i = this.Gun.b(new BackwardSupportUtil.ExifHelper.LatLongData(localcqg.ScP, localcqg.ScO));
    } while (i <= 0);
    eae localeae;
    if (this.mYQ)
    {
      localeae = this.Gun.a(new BackwardSupportUtil.ExifHelper.LatLongData(localcqg.ScP, localcqg.ScO));
      label166:
      if (!this.mYQ) {
        break label249;
      }
    }
    label249:
    for (int i = 1;; i = 0)
    {
      if (com.tencent.mm.plugin.nearlife.b.d.aaf(i)) {
        break label255;
      }
      this.Gus = -1;
      return false;
      i = this.Gum.b(new BackwardSupportUtil.ExifHelper.LatLongData(localcqg.ScP, localcqg.ScO));
      break;
      localeae = this.Gum.a(new BackwardSupportUtil.ExifHelper.LatLongData(localcqg.ScP, localcqg.ScO));
      break label166;
    }
    label255:
    if (-1L == this.Guz) {
      this.Guz = System.currentTimeMillis();
    }
    int j = this.sceneType;
    float f1 = localcqg.ScO;
    float f2 = localcqg.ScP;
    int k = localcqg.Sxt;
    int m = localcqg.Sxw;
    String str2 = localcqg.Sxu;
    String str3 = localcqg.Sxv;
    if (this.mYQ) {}
    for (String str1 = this.Gun.fiD();; str1 = "")
    {
      this.Gur = new com.tencent.mm.plugin.nearlife.b.d(i, j, f1, f2, k, m, str2, str3, localeae, str1, this.EpL, paramBoolean, false);
      bh.aGY().a(this.Gur, 0);
      Log.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", new Object[] { Integer.valueOf(this.Gus), Float.valueOf(localcqg.ScP), Float.valueOf(localcqg.ScO) });
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
          if (this.GuF)
          {
            paramString = com.tencent.mm.plugin.report.service.h.IzE;
            if (!paramBoolean1) {
              break label402;
            }
            j = 5;
            paramString.a(11139, new Object[] { Integer.valueOf(j) });
          }
          if (!paramBoolean1) {
            break label408;
          }
          paramString = this.Gun.aah(paramInt).EqW;
          localObject1 = paramString;
          if (this.Gun.getCount() <= 0) {
            break label545;
          }
          str1 = this.Gun.aah(1).fIY;
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
        str1 = this.fIY;
        localObject2 = localObject1;
        j = i;
      }
      if (this.Guu == null) {}
      for (paramString = "null/null";; paramString = String.format("%f/%f", new Object[] { Float.valueOf(this.Guu.ScP), Float.valueOf(this.Guu.ScO) }))
      {
        Log.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt + 1), str2, Integer.valueOf(paramInt), localObject2, str1 });
        com.tencent.mm.plugin.report.service.h.IzE.a(11135, new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt + 1), Long.valueOf(this.Guz), Long.valueOf(this.GuB), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.GuA), Integer.valueOf(this.GuC), paramString, str2, Integer.valueOf(this.EpL), localObject2, com.tencent.mm.compatible.deviceinfo.q.dR(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
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
        str1 = this.Gum.aah(paramInt).EqW;
        localObject1 = str1;
        if (this.Gum.getCount() <= 0) {
          break label545;
        }
        paramString = this.Gum.aah(1).fIY;
        localObject1 = str1;
        break label130;
        if (this.GuD) {
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
  
  public abstract a fiF();
  
  public abstract a fiG();
  
  public void fiH()
  {
    Log.d("MicroMsg.BaseLifeUI", "init header");
    this.Guo = View.inflate(this, R.i.efN, null);
    this.Gup = ((TextView)this.Guo.findViewById(R.h.dYf));
    this.Guq = ((TextView)this.Guo.findViewById(R.h.dYe));
    this.Guo.setOnClickListener(this.GuJ);
    this.Guk = View.inflate(this, R.i.ejT, null);
    this.Epk.addFooterView(this.Guk);
    this.Guk.setVisibility(8);
  }
  
  protected boolean gBE()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return R.i.ejq;
  }
  
  public void initView()
  {
    this.Epk = ((MMLoadMoreListView)findViewById(R.h.dNj));
    this.Epk.setFooterTips(getString(R.l.eMo));
    this.Gul = ((NearLifeErrorContent)findViewById(R.h.dNi));
    fiH();
    this.Gum = fiF();
    this.Gun = fiG();
    this.Epk.setAdapter(this.Gum);
    this.Gul.setListView(this.Epk);
    this.Gum.notifyDataSetChanged();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26562);
        BaseLifeUI.this.a(-1, false, "", BaseLifeUI.this.GuG);
        BaseLifeUI.this.finish();
        AppMethodBeat.o(26562);
        return true;
      }
    });
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26563);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = BaseLifeUI.this.Epk;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26563);
      }
    });
    this.jjS = new com.tencent.mm.ui.tools.t((byte)0);
    this.jjS.XUl = new t.b()
    {
      public final boolean aat(String paramAnonymousString)
      {
        AppMethodBeat.i(26569);
        Log.d("MicroMsg.BaseLifeUI", "search key click");
        BaseLifeUI.b(BaseLifeUI.this, paramAnonymousString);
        AppMethodBeat.o(26569);
        return false;
      }
      
      public final void aau(String paramAnonymousString)
      {
        AppMethodBeat.i(26566);
        Log.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", new Object[] { paramAnonymousString });
        if (Util.isNullOrNil(paramAnonymousString))
        {
          bxJ();
          AppMethodBeat.o(26566);
          return;
        }
        BaseLifeUI.a(BaseLifeUI.this, paramAnonymousString);
        AppMethodBeat.o(26566);
      }
      
      public final void bxH()
      {
        AppMethodBeat.i(26567);
        Log.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
        BaseLifeUI.this.mYQ = false;
        BaseLifeUI.this.Epk.setAdapter(BaseLifeUI.f(BaseLifeUI.this));
        BaseLifeUI.f(BaseLifeUI.this).notifyDataSetChanged();
        BaseLifeUI.g(BaseLifeUI.this).aaj(BaseLifeUI.f(BaseLifeUI.this).Guj);
        if ((!BaseLifeUI.f(BaseLifeUI.this).fiE()) && (BaseLifeUI.h(BaseLifeUI.this) != null)) {
          BaseLifeUI.h(BaseLifeUI.this).setVisibility(0);
        }
        BaseLifeUI.this.Epk.setOnTouchListener(null);
        BaseLifeUI.e(BaseLifeUI.this);
        BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.f(BaseLifeUI.this));
        AppMethodBeat.o(26567);
      }
      
      public final void bxI()
      {
        AppMethodBeat.i(26568);
        Log.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
        BaseLifeUI.this.GuD = true;
        BaseLifeUI.this.jjS.setHint(BaseLifeUI.this.getString(R.l.eMn));
        BaseLifeUI.this.mYQ = true;
        BaseLifeUI.b(BaseLifeUI.this).fiC();
        BaseLifeUI.this.Epk.setAdapter(BaseLifeUI.b(BaseLifeUI.this));
        BaseLifeUI.b(BaseLifeUI.this).notifyDataSetChanged();
        BaseLifeUI.this.Epk.hJL();
        BaseLifeUI.g(BaseLifeUI.this).aaj(BaseLifeUI.b(BaseLifeUI.this).Guj);
        if (BaseLifeUI.h(BaseLifeUI.this) != null) {
          BaseLifeUI.h(BaseLifeUI.this).setVisibility(8);
        }
        BaseLifeUI.this.Epk.setOnTouchListener(new View.OnTouchListener()
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
      
      public final void bxJ()
      {
        AppMethodBeat.i(26565);
        Log.d("MicroMsg.BaseLifeUI", "click clear");
        if (BaseLifeUI.c(BaseLifeUI.this) != null)
        {
          bh.aGY().a(BaseLifeUI.c(BaseLifeUI.this));
          BaseLifeUI.d(BaseLifeUI.this);
        }
        BaseLifeUI.b(BaseLifeUI.this).fiC();
        BaseLifeUI.e(BaseLifeUI.this);
        AppMethodBeat.o(26565);
      }
      
      public final void bxK() {}
    };
    this.Epk.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void onLoadMore()
      {
        AppMethodBeat.i(26570);
        BaseLifeUI.a(BaseLifeUI.this);
        AppMethodBeat.o(26570);
      }
    });
    this.Epk.hJK();
  }
  
  public abstract void n(double paramDouble1, double paramDouble2);
  
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
    this.GuH = getIntent().getBooleanExtra("poi_show_none", true);
    this.EpL = ((int)(System.currentTimeMillis() / 1000L));
    com.tencent.mm.plugin.nearlife.b.d.clear();
    bh.aGY().a(603, this);
    this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
    this.fIY = getIntent().getStringExtra("request_id");
    this.Gut = new ArrayList();
    initView();
  }
  
  public void onDestroy()
  {
    bh.aGY().b(603, this);
    super.onDestroy();
    if (this.yUU != null) {
      this.yUU.b(this.GuK);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.yUU.b(this.GuK);
  }
  
  public void onResume()
  {
    super.onResume();
    this.Gum.notifyDataSetChanged();
    this.Epk.hJM();
    if (this.yUU != null) {
      this.yUU.a(this.GuK, true);
    }
    this.kUn = false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    if (paramq.getType() != 603) {
      return;
    }
    this.Epk.hJL();
    com.tencent.mm.plugin.nearlife.b.d locald = (com.tencent.mm.plugin.nearlife.b.d)paramq;
    LogoImageView localLogoImageView;
    Object localObject;
    if (!Util.isNullOrNil(locald.GtW))
    {
      this.GtW = locald.GtW;
      localLogoImageView = (LogoImageView)this.Guk.findViewById(R.h.dRJ);
      localObject = this.GtW;
      bh.beI();
      localLogoImageView.imagePath = c.bbX();
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
      this.jQi = locald.jQi;
      this.EjD = locald.EjD;
      i = ((com.tencent.mm.plugin.nearlife.b.d)paramq).fCN;
      com.tencent.mm.plugin.nearlife.b.d.aag(i);
      if (this.Gur != null) {
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
      else if (!u.agG((String)localObject))
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
    Log.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", new Object[] { Integer.valueOf(this.Gus), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
    if ((paramInt2 == 0) || (paramInt2 == 101))
    {
      i = 1;
      if ((paramInt1 == 0) || (i != 0)) {
        break label538;
      }
      Log.d("MicroMsg.BaseLifeUI", "error");
      if (!this.mYQ) {
        break label530;
      }
      paramString = this.Gun;
      label471:
      if ((this.Gut.size() - 1 == this.Gus) && (paramString.getCount() == 0))
      {
        paramString.Guj = 1;
        this.Gul.aaj(paramString.Guj);
      }
    }
    for (;;)
    {
      this.Gur = null;
      vF(false);
      return;
      i = 0;
      break;
      label530:
      paramString = this.Gum;
      break label471;
      label538:
      if (-1L == this.GuA) {
        this.GuA = System.currentTimeMillis();
      }
      this.GuB = System.currentTimeMillis();
      paramq = locald.GtX;
      paramString = (cqg)this.Gut.get(this.Gus);
      localObject = new BackwardSupportUtil.ExifHelper.LatLongData(paramString.ScP, paramString.ScO);
      if ((this.mYQ) && (!this.Gur.GtY)) {
        this.Gun.fiC();
      }
      if (this.mYQ)
      {
        this.Gun.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, locald.doo(), locald.fiB());
        label654:
        if ((paramq != null) && (paramq.size() != 0)) {
          break label828;
        }
        if (!this.mYQ) {
          break label820;
        }
      }
      label820:
      for (paramString = this.Gun;; paramString = this.Gum)
      {
        if (this.Gut.size() - 1 == this.Gus)
        {
          if (paramString.getCount() == 0) {
            this.Gul.aaj(paramString.Guj);
          }
          this.Epk.hJL();
          if ((!paramString.fiE()) && (paramInt2 != 101)) {
            fiI();
          }
        }
        if ((!this.Gum.fiE()) && (this.Guk != null) && (!this.mYQ)) {
          this.Guk.setVisibility(0);
        }
        if ((this.Guk == null) || (this.mYQ)) {
          break label926;
        }
        this.Guk.setVisibility(0);
        break;
        this.Gum.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, locald.doo(), locald.fiB());
        break label654;
      }
      label828:
      if (this.mYQ) {}
      for (paramString = this.Gun;; paramString = this.Gum)
      {
        this.Epk.setVisibility(0);
        paramString.Guj = 0;
        this.Gul.aaj(this.Gun.Guj);
        paramString.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, paramq);
        paramString.notifyDataSetChanged();
        if ((this.Gut.size() - 1 != this.Gus) || (paramString.fiE())) {
          break;
        }
        this.Epk.hJL();
        fiI();
        break;
      }
      label926:
      if (this.Guk != null) {
        this.Guk.setVisibility(8);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI
 * JD-Core Version:    0.7.0.1
 */