package com.tencent.mm.plugin.nearlife.ui;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.protocal.protobuf.dha;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.sensitive.d.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.s.c;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLifeUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private boolean EPg = false;
  private boolean EPk;
  private com.tencent.mm.modelgeo.d Hji = com.tencent.mm.modelgeo.d.bJl();
  private int Kcm = 1;
  MMLoadMoreListView KhR;
  public int Kis = -1;
  private String MpW = "";
  protected long MqA = -1L;
  protected int MqB = 0;
  protected boolean MqC = false;
  protected int MqD = -1;
  protected boolean MqE = false;
  boolean MqF = false;
  protected boolean MqG = true;
  private View.OnClickListener MqH = new BaseLifeUI.1(this);
  private View.OnClickListener MqI = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(26561);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      if (BaseLifeUI.this.Mqt == null)
      {
        Log.e("MicroMsg.BaseLifeUI", "Location is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26561);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(11138, new Object[] { "1", Integer.valueOf(BaseLifeUI.b(BaseLifeUI.this).getCount() + 1), BaseLifeUI.this.mpa });
      paramAnonymousView = new Intent();
      paramAnonymousView.setClass(BaseLifeUI.this, NearLifeCreatePoiUI.class);
      paramAnonymousView.putExtra("get_lat", BaseLifeUI.this.Mqt.ZaH);
      paramAnonymousView.putExtra("get_lng", BaseLifeUI.this.Mqt.ZaG);
      paramAnonymousView.putExtra("get_preci", BaseLifeUI.this.Mqt.Zyl);
      paramAnonymousView.putExtra("get_poi_name", BaseLifeUI.b(BaseLifeUI.this).gsU());
      paramAnonymousView.putExtra("get_cur_lat", BaseLifeUI.this.Mqu);
      paramAnonymousView.putExtra("get_cur_lng", BaseLifeUI.this.Mqv);
      paramAnonymousView.putExtra("get_accuracy", BaseLifeUI.this.Mqx);
      paramAnonymousView.putExtra("get_loctype", BaseLifeUI.this.Mqw);
      paramAnonymousView.putExtra("search_id", BaseLifeUI.this.mpa);
      paramAnonymousView.putExtra("get_is_mars", BaseLifeUI.this.oEg);
      BaseLifeUI.this.startActivityForResult(paramAnonymousView, 1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26561);
    }
  };
  private b.a MqJ = new b.a()
  {
    public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
    {
      AppMethodBeat.i(267282);
      if (BaseLifeUI.this.nzW)
      {
        AppMethodBeat.o(267282);
        return false;
      }
      if (BaseLifeUI.this.lsB)
      {
        AppMethodBeat.o(267282);
        return false;
      }
      if (!paramAnonymousBoolean)
      {
        if ((!BaseLifeUI.i(BaseLifeUI.this)) && (!com.tencent.mm.modelgeo.d.bJm()))
        {
          BaseLifeUI.j(BaseLifeUI.this);
          k.a(BaseLifeUI.this, BaseLifeUI.this.getString(R.l.gps_disable_tip), BaseLifeUI.this.getString(R.l.app_tip), BaseLifeUI.this.getString(R.l.jump_to_settings), BaseLifeUI.this.getString(R.l.app_cancel), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(267280);
              com.tencent.mm.modelgeo.d.dP(BaseLifeUI.this);
              AppMethodBeat.o(267280);
            }
          }, null);
        }
        AppMethodBeat.o(267282);
        return true;
      }
      n.a(2003, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
      BaseLifeUI.this.lsB = true;
      if (BaseLifeUI.k(BaseLifeUI.this) != null) {
        BaseLifeUI.k(BaseLifeUI.this).a(BaseLifeUI.l(BaseLifeUI.this));
      }
      Log.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
      BaseLifeUI.this.Mqt = new dha();
      BaseLifeUI.this.Mqt.Zyn = "";
      BaseLifeUI.this.Mqt.Zyo = 0;
      BaseLifeUI.this.Mqt.ZaH = paramAnonymousFloat2;
      BaseLifeUI.this.Mqt.ZaG = paramAnonymousFloat1;
      BaseLifeUI.this.Mqt.Zym = "";
      BaseLifeUI.this.Mqt.Zyl = ((int)paramAnonymousDouble2);
      BaseLifeUI.this.Mqu = paramAnonymousFloat2;
      BaseLifeUI.this.Mqv = paramAnonymousFloat1;
      BaseLifeUI.this.Mqw = paramAnonymousInt;
      BaseLifeUI.this.Mqx = ((float)paramAnonymousDouble2);
      Object localObject = BaseLifeUI.this;
      label445:
      BaseLifeUI localBaseLifeUI;
      if (BaseLifeUI.k(BaseLifeUI.this) == null)
      {
        paramAnonymousBoolean = false;
        ((BaseLifeUI)localObject).oEg = paramAnonymousBoolean;
        localObject = BaseLifeUI.f(BaseLifeUI.this).Mqc;
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label595;
        }
        localObject = (BackwardSupportUtil.ExifHelper.LatLongData)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
        BaseLifeUI.this.r(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).latitude, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).longtitude);
        BaseLifeUI.this.MqE = BaseLifeUI.u(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).latitude, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).longtitude, paramAnonymousFloat2, paramAnonymousFloat1);
        BaseLifeUI.f(BaseLifeUI.this).Mqg = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.Mqt.ZaH, BaseLifeUI.this.Mqt.ZaG);
        BaseLifeUI.b(BaseLifeUI.this).Mqg = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.Mqt.ZaH, BaseLifeUI.this.Mqt.ZaG);
        localBaseLifeUI = BaseLifeUI.this;
        if (!BaseLifeUI.this.pVy) {
          break label609;
        }
      }
      label595:
      label609:
      for (localObject = BaseLifeUI.b(BaseLifeUI.this);; localObject = BaseLifeUI.f(BaseLifeUI.this))
      {
        BaseLifeUI.a(localBaseLifeUI, (a)localObject);
        BaseLifeUI.m(BaseLifeUI.this);
        BaseLifeUI.this.addSearchMenu(true, BaseLifeUI.this.lMw);
        AppMethodBeat.o(267282);
        return false;
        paramAnonymousBoolean = BaseLifeUI.k(BaseLifeUI.this).oEg;
        break;
        BaseLifeUI.this.r(paramAnonymousFloat2, paramAnonymousFloat1);
        break label445;
      }
    }
  };
  private View Mqj;
  private NearLifeErrorContent Mqk;
  private a Mql;
  private a Mqm;
  private View Mqn;
  private TextView Mqo;
  private TextView Mqp;
  private com.tencent.mm.plugin.nearlife.b.d Mqq;
  private int Mqr;
  private List<dha> Mqs;
  protected dha Mqt = null;
  protected float Mqu = 0.0F;
  protected float Mqv = 0.0F;
  protected int Mqw = 0;
  protected float Mqx = 0.0F;
  protected long Mqy = -1L;
  protected long Mqz = -1L;
  protected String hOG = "";
  protected com.tencent.mm.ui.tools.s lMw;
  boolean lsB = false;
  protected String mpa = "";
  boolean nzW = false;
  protected boolean oEg = true;
  boolean pVy = false;
  int sceneType = 0;
  
  private boolean Ab(boolean paramBoolean)
  {
    dha localdha;
    do
    {
      if (this.Mqq != null)
      {
        Log.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
      }
      if (this.Mqs.size() - 1 <= this.Mqr)
      {
        this.Mqr = -1;
        Log.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
        return false;
      }
      this.Mqr += 1;
      localdha = (dha)this.Mqs.get(this.Mqr);
      if (this.Mqr == 0) {
        this.MqB += 1;
      }
      if (!this.pVy) {
        break;
      }
      i = this.Mqm.b(new BackwardSupportUtil.ExifHelper.LatLongData(localdha.ZaH, localdha.ZaG));
    } while (i <= 0);
    gol localgol;
    if (this.pVy)
    {
      localgol = this.Mqm.a(new BackwardSupportUtil.ExifHelper.LatLongData(localdha.ZaH, localdha.ZaG));
      label164:
      if (!this.pVy) {
        break label247;
      }
    }
    label247:
    for (int i = 1;; i = 0)
    {
      if (com.tencent.mm.plugin.nearlife.b.d.aey(i)) {
        break label253;
      }
      this.Mqr = -1;
      return false;
      i = this.Mql.b(new BackwardSupportUtil.ExifHelper.LatLongData(localdha.ZaH, localdha.ZaG));
      break;
      localgol = this.Mql.a(new BackwardSupportUtil.ExifHelper.LatLongData(localdha.ZaH, localdha.ZaG));
      break label164;
    }
    label253:
    if (-1L == this.Mqy) {
      this.Mqy = System.currentTimeMillis();
    }
    int j = this.sceneType;
    float f1 = localdha.ZaG;
    float f2 = localdha.ZaH;
    int k = localdha.Zyl;
    int m = localdha.Zyo;
    String str2 = localdha.Zym;
    String str3 = localdha.Zyn;
    if (this.pVy) {}
    for (String str1 = this.Mqm.gsU();; str1 = "")
    {
      this.Mqq = new com.tencent.mm.plugin.nearlife.b.d(i, j, f1, f2, k, m, str2, str3, localgol, str1, this.Kis, paramBoolean, false);
      bh.aZW().a(this.Mqq, 0);
      Log.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", new Object[] { Integer.valueOf(this.Mqr), Float.valueOf(localdha.ZaH), Float.valueOf(localdha.ZaG) });
      return true;
    }
  }
  
  private void aeB(int paramInt)
  {
    this.KhR.removeFooterView(this.Mqj);
    this.KhR.removeFooterView(this.Mqn);
    this.KhR.jmv();
    this.Mqn.setVisibility(paramInt);
    this.Mqo.setVisibility(paramInt);
    this.Mqp.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.KhR.addFooterView(this.Mqn);
      return;
    }
    this.KhR.cPA();
    this.KhR.addFooterView(this.Mqj);
  }
  
  private void gsZ()
  {
    if (!this.pVy) {
      Log.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }
    for (;;)
    {
      return;
      if (gta()) {}
      try
      {
        int i = Integer.valueOf(i.aRC().getValue("POICreateForbiden")).intValue();
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
    if (!this.Mqm.aPP(this.Mqm.gsU()))
    {
      str = String.format(getResources().getString(R.l.gON), new Object[] { this.Mqm.gsU() });
      this.Mqo.setText(str);
      aeB(0);
      return;
    }
    aeB(8);
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
          if (this.MqE)
          {
            paramString = com.tencent.mm.plugin.report.service.h.OAn;
            if (!paramBoolean1) {
              break label402;
            }
            j = 5;
            paramString.b(11139, new Object[] { Integer.valueOf(j) });
          }
          if (!paramBoolean1) {
            break label408;
          }
          paramString = this.Mqm.aeA(paramInt).KjC;
          localObject1 = paramString;
          if (this.Mqm.getCount() <= 0) {
            break label545;
          }
          str1 = this.Mqm.aeA(1).hOG;
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
        str1 = this.hOG;
        localObject2 = localObject1;
        j = i;
      }
      if (this.Mqt == null) {}
      for (paramString = "null/null";; paramString = String.format("%f/%f", new Object[] { Float.valueOf(this.Mqt.ZaH), Float.valueOf(this.Mqt.ZaG) }))
      {
        Log.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt + 1), str2, Integer.valueOf(paramInt), localObject2, str1 });
        com.tencent.mm.plugin.report.service.h.OAn.b(11135, new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt + 1), Long.valueOf(this.Mqy), Long.valueOf(this.MqA), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.Mqz), Integer.valueOf(this.MqB), paramString, str2, Integer.valueOf(this.Kis), localObject2, q.eD(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
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
        str1 = this.Mql.aeA(paramInt).KjC;
        localObject1 = str1;
        if (this.Mql.getCount() <= 0) {
          break label545;
        }
        paramString = this.Mql.aeA(1).hOG;
        localObject1 = str1;
        break label130;
        if (this.MqC) {
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
  
  public int getLayoutId()
  {
    return R.i.gmr;
  }
  
  public abstract a gsW();
  
  public abstract a gsX();
  
  public void gsY()
  {
    Log.d("MicroMsg.BaseLifeUI", "init header");
    this.Mqn = View.inflate(this, R.i.giM, null);
    this.Mqo = ((TextView)this.Mqn.findViewById(R.h.gaL));
    this.Mqp = ((TextView)this.Mqn.findViewById(R.h.gaK));
    this.Mqn.setOnClickListener(this.MqI);
    this.Mqj = View.inflate(this, R.i.gmW, null);
    this.KhR.addFooterView(this.Mqj);
    this.Mqj.setVisibility(8);
  }
  
  protected boolean gta()
  {
    return true;
  }
  
  public void initView()
  {
    this.KhR = ((MMLoadMoreListView)findViewById(R.h.fPd));
    this.KhR.setFooterTips(getString(R.l.gOm));
    this.Mqk = ((NearLifeErrorContent)findViewById(R.h.fPc));
    gsY();
    this.Mql = gsW();
    this.Mqm = gsX();
    this.KhR.setAdapter(this.Mql);
    this.Mqk.setListView(this.KhR);
    this.Mql.notifyDataSetChanged();
    setBackBtn(new BaseLifeUI.3(this));
    setToTop(new BaseLifeUI.4(this));
    this.lMw = new com.tencent.mm.ui.tools.s(true);
    this.lMw.afKz = new s.c()
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
          bWy();
          AppMethodBeat.o(26566);
          return;
        }
        BaseLifeUI.a(BaseLifeUI.this, paramAnonymousString);
        AppMethodBeat.o(26566);
      }
      
      public final void bWw()
      {
        AppMethodBeat.i(26567);
        Log.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
        BaseLifeUI.this.pVy = false;
        BaseLifeUI.this.KhR.setAdapter(BaseLifeUI.f(BaseLifeUI.this));
        BaseLifeUI.f(BaseLifeUI.this).notifyDataSetChanged();
        BaseLifeUI.g(BaseLifeUI.this).aeC(BaseLifeUI.f(BaseLifeUI.this).Mqi);
        if ((!BaseLifeUI.f(BaseLifeUI.this).gsV()) && (BaseLifeUI.h(BaseLifeUI.this) != null)) {
          BaseLifeUI.h(BaseLifeUI.this).setVisibility(0);
        }
        BaseLifeUI.this.KhR.setOnTouchListener(null);
        BaseLifeUI.e(BaseLifeUI.this);
        BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.f(BaseLifeUI.this));
        AppMethodBeat.o(26567);
      }
      
      public final void bWx()
      {
        AppMethodBeat.i(26568);
        Log.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
        BaseLifeUI.this.MqC = true;
        BaseLifeUI.this.lMw.setHint(BaseLifeUI.this.getString(R.l.gOl));
        BaseLifeUI.this.pVy = true;
        BaseLifeUI.b(BaseLifeUI.this).gsT();
        BaseLifeUI.this.KhR.setAdapter(BaseLifeUI.b(BaseLifeUI.this));
        BaseLifeUI.b(BaseLifeUI.this).notifyDataSetChanged();
        BaseLifeUI.this.KhR.jmt();
        BaseLifeUI.g(BaseLifeUI.this).aeC(BaseLifeUI.b(BaseLifeUI.this).Mqi);
        if (BaseLifeUI.h(BaseLifeUI.this) != null) {
          BaseLifeUI.h(BaseLifeUI.this).setVisibility(8);
        }
        BaseLifeUI.this.KhR.setOnTouchListener(new View.OnTouchListener()
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
      
      public final void bWy()
      {
        AppMethodBeat.i(26565);
        Log.d("MicroMsg.BaseLifeUI", "click clear");
        if (BaseLifeUI.c(BaseLifeUI.this) != null)
        {
          bh.aZW().a(BaseLifeUI.c(BaseLifeUI.this));
          BaseLifeUI.d(BaseLifeUI.this);
        }
        BaseLifeUI.b(BaseLifeUI.this).gsT();
        BaseLifeUI.e(BaseLifeUI.this);
        AppMethodBeat.o(26565);
      }
      
      public final void bWz() {}
    };
    this.KhR.setOnLoadMoreListener(new BaseLifeUI.6(this));
    this.KhR.jms();
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
    this.MqG = getIntent().getBooleanExtra("poi_show_none", true);
    this.Kis = ((int)(System.currentTimeMillis() / 1000L));
    com.tencent.mm.plugin.nearlife.b.d.clear();
    bh.aZW().a(603, this);
    this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
    this.hOG = getIntent().getStringExtra("request_id");
    this.Mqs = new ArrayList();
    initView();
  }
  
  public void onDestroy()
  {
    bh.aZW().b(603, this);
    super.onDestroy();
    if (this.Hji != null) {
      this.Hji.a(this.MqJ);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.Hji.a(this.MqJ);
  }
  
  public void onResume()
  {
    super.onResume();
    this.Mql.notifyDataSetChanged();
    this.KhR.jmu();
    if ((!((com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class)).checkAndShowPermissionDialog(d.c.actu, new d.f()
    {
      public final void onOp(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(267276);
        if (paramAnonymousBoolean.booleanValue())
        {
          BaseLifeUI.this.onBusinessPermissionGranted(d.c.actu.value);
          AppMethodBeat.o(267276);
          return;
        }
        BaseLifeUI.this.onBusinessPermissionDenied(d.c.actu.value);
        AppMethodBeat.o(267276);
      }
    })) && (this.Hji != null)) {
      this.Hji.a(this.MqJ, true, false);
    }
    this.nzW = false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    if (paramp.getType() != 603) {
      return;
    }
    this.KhR.jmt();
    com.tencent.mm.plugin.nearlife.b.d locald = (com.tencent.mm.plugin.nearlife.b.d)paramp;
    LogoImageView localLogoImageView;
    Object localObject;
    if (!Util.isNullOrNil(locald.MpW))
    {
      this.MpW = locald.MpW;
      localLogoImageView = (LogoImageView)this.Mqj.findViewById(R.h.fTJ);
      localObject = this.MpW;
      bh.bCz();
      localLogoImageView.imagePath = c.bzM();
      localLogoImageView.url = ((String)localObject);
      localLogoImageView.nxO = 0;
      localLogoImageView.nxP = 0;
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label168;
      }
      localLogoImageView.setVisibility(8);
    }
    int i;
    for (;;)
    {
      this.mpa = locald.mpa;
      this.Kcm = locald.Kcm;
      i = ((com.tencent.mm.plugin.nearlife.b.d)paramp).hHC;
      com.tencent.mm.plugin.nearlife.b.d.aez(i);
      if (this.Mqq != null) {
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
          if (localLogoImageView.nxO > 0)
          {
            localObject = localBitmap;
            if (localLogoImageView.nxP > 0) {
              localObject = BitmapUtil.extractThumbNail(localBitmap, localLogoImageView.nxO, localLogoImageView.nxP, true, false);
            }
          }
          localLogoImageView.setImageBitmap((Bitmap)localObject);
        }
        else
        {
          ThreadPool.post(new LogoImageView.a((String)localObject, localLogoImageView.handler), "LogoImageView_download");
        }
      }
      else if (!y.ZC((String)localObject))
      {
        localLogoImageView.setVisibility(8);
      }
      else
      {
        if ((localLogoImageView.nxO <= 0) || (localLogoImageView.nxP <= 0)) {}
        for (localObject = BitmapUtil.getBitmapNative((String)localObject);; localObject = BitmapUtil.extractThumbNail((String)localObject, localLogoImageView.nxO, localLogoImageView.nxP, true))
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
    Log.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", new Object[] { Integer.valueOf(this.Mqr), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
    if ((paramInt2 == 0) || (paramInt2 == 101))
    {
      i = 1;
      if ((paramInt1 == 0) || (i != 0)) {
        break label538;
      }
      Log.d("MicroMsg.BaseLifeUI", "error");
      if (!this.pVy) {
        break label530;
      }
      paramString = this.Mqm;
      label471:
      if ((this.Mqs.size() - 1 == this.Mqr) && (paramString.getCount() == 0))
      {
        paramString.Mqi = 1;
        this.Mqk.aeC(paramString.Mqi);
      }
    }
    for (;;)
    {
      this.Mqq = null;
      Ab(false);
      return;
      i = 0;
      break;
      label530:
      paramString = this.Mql;
      break label471;
      label538:
      if (-1L == this.Mqz) {
        this.Mqz = System.currentTimeMillis();
      }
      this.MqA = System.currentTimeMillis();
      paramp = locald.MpX;
      paramString = (dha)this.Mqs.get(this.Mqr);
      localObject = new BackwardSupportUtil.ExifHelper.LatLongData(paramString.ZaH, paramString.ZaG);
      if ((this.pVy) && (!this.Mqq.AXC)) {
        this.Mqm.gsT();
      }
      if (this.pVy)
      {
        this.Mqm.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, locald.dVZ(), locald.gsS());
        label654:
        if ((paramp != null) && (paramp.size() != 0)) {
          break label828;
        }
        if (!this.pVy) {
          break label820;
        }
      }
      label820:
      for (paramString = this.Mqm;; paramString = this.Mql)
      {
        if (this.Mqs.size() - 1 == this.Mqr)
        {
          if (paramString.getCount() == 0) {
            this.Mqk.aeC(paramString.Mqi);
          }
          this.KhR.jmt();
          if ((!paramString.gsV()) && (paramInt2 != 101)) {
            gsZ();
          }
        }
        if ((!this.Mql.gsV()) && (this.Mqj != null) && (!this.pVy)) {
          this.Mqj.setVisibility(0);
        }
        if ((this.Mqj == null) || (this.pVy)) {
          break label926;
        }
        this.Mqj.setVisibility(0);
        break;
        this.Mql.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, locald.dVZ(), locald.gsS());
        break label654;
      }
      label828:
      if (this.pVy) {}
      for (paramString = this.Mqm;; paramString = this.Mql)
      {
        this.KhR.setVisibility(0);
        paramString.Mqi = 0;
        this.Mqk.aeC(this.Mqm.Mqi);
        paramString.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, paramp);
        paramString.notifyDataSetChanged();
        if ((this.Mqs.size() - 1 != this.Mqr) || (paramString.gsV())) {
          break;
        }
        this.KhR.jmt();
        gsZ();
        break;
      }
      label926:
      if (this.Mqj != null) {
        this.Mqj.setVisibility(8);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public abstract void r(double paramDouble1, double paramDouble2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI
 * JD-Core Version:    0.7.0.1
 */