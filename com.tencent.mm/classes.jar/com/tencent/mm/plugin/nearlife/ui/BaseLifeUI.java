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
import com.tencent.mm.ak.n;
import com.tencent.mm.m.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLifeUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  protected String dlj = "";
  boolean fmZ = false;
  private r fzp;
  boolean gRx = false;
  protected boolean hEP = true;
  boolean iNn = false;
  protected String jKB = "";
  int sceneType = 0;
  private int tWY = 1;
  MMLoadMoreListView ucL;
  public int udn = -1;
  private boolean udt;
  private boolean vjE = false;
  private String vkI = "";
  private View vkW;
  private NearLifeErrorContent vkX;
  private a vkY;
  private a vkZ;
  private View vla;
  private TextView vlb;
  private TextView vlc;
  private com.tencent.mm.modelgeo.d vld = com.tencent.mm.modelgeo.d.aEL();
  private com.tencent.mm.plugin.nearlife.b.d vle;
  private int vlf;
  private List<boz> vlg;
  protected boz vlh = null;
  protected float vli = 0.0F;
  protected float vlj = 0.0F;
  protected int vlk = 0;
  protected float vll = 0.0F;
  protected long vlm = -1L;
  protected long vln = -1L;
  protected long vlo = -1L;
  protected int vlp = 0;
  protected boolean vlq = false;
  protected int vlr = -1;
  protected boolean vls = false;
  boolean vlt = false;
  protected boolean vlu = true;
  private View.OnClickListener vlv = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(26560);
      BaseLifeUI.a(BaseLifeUI.this);
      AppMethodBeat.o(26560);
    }
  };
  private View.OnClickListener vlw = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(26561);
      if (BaseLifeUI.this.vlh == null)
      {
        ac.e("MicroMsg.BaseLifeUI", "Location is null");
        AppMethodBeat.o(26561);
        return;
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(11138, new Object[] { "1", Integer.valueOf(BaseLifeUI.b(BaseLifeUI.this).getCount() + 1), BaseLifeUI.this.jKB });
      paramAnonymousView = new Intent();
      paramAnonymousView.setClass(BaseLifeUI.this, NearLifeCreatePoiUI.class);
      paramAnonymousView.putExtra("get_lat", BaseLifeUI.this.vlh.Ehu);
      paramAnonymousView.putExtra("get_lng", BaseLifeUI.this.vlh.Eht);
      paramAnonymousView.putExtra("get_preci", BaseLifeUI.this.vlh.EyK);
      paramAnonymousView.putExtra("get_poi_name", BaseLifeUI.b(BaseLifeUI.this).djR());
      paramAnonymousView.putExtra("get_cur_lat", BaseLifeUI.this.vli);
      paramAnonymousView.putExtra("get_cur_lng", BaseLifeUI.this.vlj);
      paramAnonymousView.putExtra("get_accuracy", BaseLifeUI.this.vll);
      paramAnonymousView.putExtra("get_loctype", BaseLifeUI.this.vlk);
      paramAnonymousView.putExtra("search_id", BaseLifeUI.this.jKB);
      paramAnonymousView.putExtra("get_is_mars", BaseLifeUI.this.hEP);
      BaseLifeUI.this.startActivityForResult(paramAnonymousView, 1);
      AppMethodBeat.o(26561);
    }
  };
  private b.a vlx = new b.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
    {
      AppMethodBeat.i(26572);
      if (BaseLifeUI.this.gRx)
      {
        AppMethodBeat.o(26572);
        return false;
      }
      if (BaseLifeUI.this.fmZ)
      {
        AppMethodBeat.o(26572);
        return false;
      }
      if (!paramAnonymousBoolean)
      {
        if ((!BaseLifeUI.j(BaseLifeUI.this)) && (!com.tencent.mm.modelgeo.d.aEM()))
        {
          BaseLifeUI.k(BaseLifeUI.this);
          com.tencent.mm.ui.base.h.a(BaseLifeUI.this, BaseLifeUI.this.getString(2131760082), BaseLifeUI.this.getString(2131755906), BaseLifeUI.this.getString(2131760598), BaseLifeUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(26571);
              com.tencent.mm.modelgeo.d.cE(BaseLifeUI.this);
              AppMethodBeat.o(26571);
            }
          }, null);
        }
        AppMethodBeat.o(26572);
        return true;
      }
      o.a(2003, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
      BaseLifeUI.this.fmZ = true;
      ac.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
      BaseLifeUI.this.vlh = new boz();
      BaseLifeUI.this.vlh.EyM = "";
      BaseLifeUI.this.vlh.EyN = 0;
      BaseLifeUI.this.vlh.Ehu = paramAnonymousFloat2;
      BaseLifeUI.this.vlh.Eht = paramAnonymousFloat1;
      BaseLifeUI.this.vlh.EyL = "";
      BaseLifeUI.this.vlh.EyK = ((int)paramAnonymousDouble2);
      BaseLifeUI.this.vli = paramAnonymousFloat2;
      BaseLifeUI.this.vlj = paramAnonymousFloat1;
      BaseLifeUI.this.vlk = paramAnonymousInt;
      BaseLifeUI.this.vll = ((float)paramAnonymousDouble2);
      Object localObject = BaseLifeUI.this;
      label418:
      BaseLifeUI localBaseLifeUI;
      if (BaseLifeUI.l(BaseLifeUI.this) == null)
      {
        paramAnonymousBoolean = false;
        ((BaseLifeUI)localObject).hEP = paramAnonymousBoolean;
        localObject = BaseLifeUI.f(BaseLifeUI.this).vkP;
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label569;
        }
        localObject = (BackwardSupportUtil.ExifHelper.LatLongData)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
        BaseLifeUI.this.p(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).dmL, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).hIO);
        BaseLifeUI.this.vls = BaseLifeUI.k(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).dmL, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).hIO, paramAnonymousFloat2, paramAnonymousFloat1);
        BaseLifeUI.f(BaseLifeUI.this).vkT = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.vlh.Ehu, BaseLifeUI.this.vlh.Eht);
        BaseLifeUI.b(BaseLifeUI.this).vkT = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.vlh.Ehu, BaseLifeUI.this.vlh.Eht);
        localBaseLifeUI = BaseLifeUI.this;
        if (!BaseLifeUI.this.iNn) {
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
        paramAnonymousBoolean = BaseLifeUI.l(BaseLifeUI.this).hEP;
        break;
        BaseLifeUI.this.p(paramAnonymousFloat2, paramAnonymousFloat1);
        break label418;
      }
    }
  };
  
  private void Ki(int paramInt)
  {
    this.ucL.removeFooterView(this.vkW);
    this.ucL.removeFooterView(this.vla);
    this.ucL.fiz();
    this.vla.setVisibility(paramInt);
    this.vlb.setVisibility(paramInt);
    this.vlc.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.ucL.addFooterView(this.vla);
      return;
    }
    this.ucL.fiv();
    this.ucL.addFooterView(this.vkW);
  }
  
  private void djW()
  {
    if (!this.iNn) {
      ac.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }
    for (;;)
    {
      return;
      try
      {
        int i = Integer.valueOf(com.tencent.mm.m.g.ZY().getValue("POICreateForbiden")).intValue();
        ac.i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", new Object[] { Integer.valueOf(i) });
        if (i == 1) {}
      }
      catch (Exception localException)
      {
        label56:
        String str;
        break label56;
      }
    }
    if (!this.vkZ.aob(this.vkZ.djR()))
    {
      str = String.format(getResources().getString(2131761604), new Object[] { this.vkZ.djR() });
      this.vlb.setText(str);
      Ki(0);
      return;
    }
    Ki(8);
  }
  
  private boolean oG(boolean paramBoolean)
  {
    boz localboz;
    do
    {
      if (this.vle != null)
      {
        ac.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
      }
      if (this.vlg.size() - 1 <= this.vlf)
      {
        this.vlf = -1;
        ac.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
        return false;
      }
      this.vlf += 1;
      localboz = (boz)this.vlg.get(this.vlf);
      if (this.vlf == 0) {
        this.vlp += 1;
      }
      if (!this.iNn) {
        break;
      }
      i = this.vkZ.b(new BackwardSupportUtil.ExifHelper.LatLongData(localboz.Ehu, localboz.Eht));
    } while (i <= 0);
    SKBuiltinBuffer_t localSKBuiltinBuffer_t;
    if (this.iNn)
    {
      localSKBuiltinBuffer_t = this.vkZ.a(new BackwardSupportUtil.ExifHelper.LatLongData(localboz.Ehu, localboz.Eht));
      label166:
      if (!this.iNn) {
        break label249;
      }
    }
    label249:
    for (int i = 1;; i = 0)
    {
      if (com.tencent.mm.plugin.nearlife.b.d.Kf(i)) {
        break label255;
      }
      this.vlf = -1;
      return false;
      i = this.vkY.b(new BackwardSupportUtil.ExifHelper.LatLongData(localboz.Ehu, localboz.Eht));
      break;
      localSKBuiltinBuffer_t = this.vkY.a(new BackwardSupportUtil.ExifHelper.LatLongData(localboz.Ehu, localboz.Eht));
      break label166;
    }
    label255:
    if (-1L == this.vlm) {
      this.vlm = System.currentTimeMillis();
    }
    int j = this.sceneType;
    float f1 = localboz.Eht;
    float f2 = localboz.Ehu;
    int k = localboz.EyK;
    int m = localboz.EyN;
    String str2 = localboz.EyL;
    String str3 = localboz.EyM;
    if (this.iNn) {}
    for (String str1 = this.vkZ.djR();; str1 = "")
    {
      this.vle = new com.tencent.mm.plugin.nearlife.b.d(i, j, f1, f2, k, m, str2, str3, localSKBuiltinBuffer_t, str1, this.udn, paramBoolean, false);
      az.agi().a(this.vle, 0);
      ac.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", new Object[] { Integer.valueOf(this.vlf), Float.valueOf(localboz.Ehu), Float.valueOf(localboz.Eht) });
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
          if (this.vls)
          {
            paramString = com.tencent.mm.plugin.report.service.h.wUl;
            if (!paramBoolean1) {
              break label402;
            }
            j = 5;
            paramString.f(11139, new Object[] { Integer.valueOf(j) });
          }
          if (!paramBoolean1) {
            break label408;
          }
          paramString = this.vkZ.Kh(paramInt).uev;
          localObject1 = paramString;
          if (this.vkZ.getCount() <= 0) {
            break label545;
          }
          str1 = this.vkZ.Kh(1).dlj;
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
      if (bs.isNullOrNil(paramString))
      {
        str1 = this.dlj;
        localObject2 = localObject1;
        j = i;
      }
      if (this.vlh == null) {}
      for (paramString = "null/null";; paramString = String.format("%f/%f", new Object[] { Float.valueOf(this.vlh.Ehu), Float.valueOf(this.vlh.Eht) }))
      {
        ac.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt + 1), str2, Integer.valueOf(paramInt), localObject2, str1 });
        com.tencent.mm.plugin.report.service.h.wUl.f(11135, new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt + 1), Long.valueOf(this.vlm), Long.valueOf(this.vlo), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.vln), Integer.valueOf(this.vlp), paramString, str2, Integer.valueOf(this.udn), localObject2, com.tencent.mm.compatible.deviceinfo.q.cF(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
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
        str1 = this.vkY.Kh(paramInt).uev;
        localObject1 = str1;
        if (this.vkY.getCount() <= 0) {
          break label545;
        }
        paramString = this.vkY.Kh(1).dlj;
        localObject1 = str1;
        break label130;
        if (this.vlq) {
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
  
  public abstract a djT();
  
  public abstract a djU();
  
  public void djV()
  {
    ac.d("MicroMsg.BaseLifeUI", "init header");
    this.vla = View.inflate(this, 2131493673, null);
    this.vlb = ((TextView)this.vla.findViewById(2131306116));
    this.vlc = ((TextView)this.vla.findViewById(2131306115));
    this.vla.setOnClickListener(this.vlw);
    this.vkW = View.inflate(this, 2131495103, null);
    this.ucL.addFooterView(this.vkW);
    this.vkW.setVisibility(8);
  }
  
  public int getLayoutId()
  {
    return 2131494998;
  }
  
  public void initView()
  {
    this.ucL = ((MMLoadMoreListView)findViewById(2131302680));
    this.ucL.setFooterTips(getString(2131761492));
    this.vkX = ((NearLifeErrorContent)findViewById(2131302679));
    djV();
    this.vkY = djT();
    this.vkZ = djU();
    this.ucL.setAdapter(this.vkY);
    this.vkX.setListView(this.ucL);
    this.vkY.notifyDataSetChanged();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26562);
        BaseLifeUI.this.a(-1, false, "", BaseLifeUI.this.vlt);
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
        paramAnonymousView = BaseLifeUI.this.ucL;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        AppMethodBeat.o(26563);
      }
    });
    this.fzp = new r((byte)0);
    this.fzp.ITM = new r.b()
    {
      public final boolean Ga(String paramAnonymousString)
      {
        AppMethodBeat.i(26569);
        ac.d("MicroMsg.BaseLifeUI", "search key click");
        BaseLifeUI.b(BaseLifeUI.this, paramAnonymousString);
        AppMethodBeat.o(26569);
        return false;
      }
      
      public final void Gb(String paramAnonymousString)
      {
        AppMethodBeat.i(26566);
        ac.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", new Object[] { paramAnonymousString });
        if (bs.isNullOrNil(paramAnonymousString))
        {
          aPc();
          AppMethodBeat.o(26566);
          return;
        }
        BaseLifeUI.a(BaseLifeUI.this, paramAnonymousString);
        AppMethodBeat.o(26566);
      }
      
      public final void aPa()
      {
        AppMethodBeat.i(26567);
        ac.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
        BaseLifeUI.this.iNn = false;
        BaseLifeUI.this.ucL.setAdapter(BaseLifeUI.f(BaseLifeUI.this));
        BaseLifeUI.f(BaseLifeUI.this).notifyDataSetChanged();
        BaseLifeUI.g(BaseLifeUI.this).Kj(BaseLifeUI.f(BaseLifeUI.this).vkV);
        if ((!BaseLifeUI.f(BaseLifeUI.this).djS()) && (BaseLifeUI.h(BaseLifeUI.this) != null)) {
          BaseLifeUI.h(BaseLifeUI.this).setVisibility(0);
        }
        BaseLifeUI.this.ucL.setOnTouchListener(null);
        BaseLifeUI.e(BaseLifeUI.this);
        BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.f(BaseLifeUI.this));
        AppMethodBeat.o(26567);
      }
      
      public final void aPb()
      {
        AppMethodBeat.i(26568);
        ac.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
        BaseLifeUI.this.vlq = true;
        BaseLifeUI.i(BaseLifeUI.this).setHint(BaseLifeUI.this.getString(2131761491));
        BaseLifeUI.this.iNn = true;
        BaseLifeUI.b(BaseLifeUI.this).djQ();
        BaseLifeUI.this.ucL.setAdapter(BaseLifeUI.b(BaseLifeUI.this));
        BaseLifeUI.b(BaseLifeUI.this).notifyDataSetChanged();
        BaseLifeUI.this.ucL.fix();
        BaseLifeUI.g(BaseLifeUI.this).Kj(BaseLifeUI.b(BaseLifeUI.this).vkV);
        if (BaseLifeUI.h(BaseLifeUI.this) != null) {
          BaseLifeUI.h(BaseLifeUI.this).setVisibility(8);
        }
        BaseLifeUI.this.ucL.setOnTouchListener(new View.OnTouchListener()
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
      
      public final void aPc()
      {
        AppMethodBeat.i(26565);
        ac.d("MicroMsg.BaseLifeUI", "click clear");
        if (BaseLifeUI.c(BaseLifeUI.this) != null)
        {
          az.agi().a(BaseLifeUI.c(BaseLifeUI.this));
          BaseLifeUI.d(BaseLifeUI.this);
        }
        BaseLifeUI.b(BaseLifeUI.this).djQ();
        BaseLifeUI.e(BaseLifeUI.this);
        AppMethodBeat.o(26565);
      }
      
      public final void aPd() {}
    };
    this.ucL.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void Xa()
      {
        AppMethodBeat.i(26570);
        BaseLifeUI.a(BaseLifeUI.this);
        AppMethodBeat.o(26570);
      }
    });
    this.ucL.fiw();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.d("MicroMsg.BaseLifeUI", "onActivityResult requestCode %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
    this.vlu = getIntent().getBooleanExtra("poi_show_none", true);
    this.udn = ((int)(System.currentTimeMillis() / 1000L));
    com.tencent.mm.plugin.nearlife.b.d.clear();
    az.agi().a(603, this);
    this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
    this.dlj = getIntent().getStringExtra("request_id");
    this.vlg = new ArrayList();
    initView();
  }
  
  public void onDestroy()
  {
    az.agi().b(603, this);
    super.onDestroy();
    if (this.vld != null) {
      this.vld.c(this.vlx);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.vld.c(this.vlx);
  }
  
  public void onResume()
  {
    super.onResume();
    this.vkY.notifyDataSetChanged();
    this.ucL.fiy();
    if (this.vld != null) {
      this.vld.a(this.vlx, true);
    }
    this.gRx = false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    if (paramn.getType() != 603) {
      return;
    }
    this.ucL.fix();
    com.tencent.mm.plugin.nearlife.b.d locald = (com.tencent.mm.plugin.nearlife.b.d)paramn;
    LogoImageView localLogoImageView;
    Object localObject;
    if (!bs.isNullOrNil(locald.vkI))
    {
      this.vkI = locald.vkI;
      localLogoImageView = (LogoImageView)this.vkW.findViewById(2131303550);
      localObject = this.vkI;
      az.ayM();
      localLogoImageView.imagePath = c.awM();
      localLogoImageView.url = ((String)localObject);
      localLogoImageView.gNU = 0;
      localLogoImageView.gNV = 0;
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label168;
      }
      localLogoImageView.setVisibility(8);
    }
    int i;
    for (;;)
    {
      this.jKB = locald.jKB;
      this.tWY = locald.tWY;
      i = ((com.tencent.mm.plugin.nearlife.b.d)paramn).dgm;
      com.tencent.mm.plugin.nearlife.b.d.Kg(i);
      if (this.vle != null) {
        break;
      }
      ac.d("MicroMsg.BaseLifeUI", "scene is null");
      return;
      label168:
      if (((String)localObject).startsWith("http"))
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(localLogoImageView.imagePath + com.tencent.mm.b.g.getMessageDigest(((String)localObject).getBytes()));
        if (localBitmap != null)
        {
          localObject = localBitmap;
          if (localLogoImageView.gNU > 0)
          {
            localObject = localBitmap;
            if (localLogoImageView.gNV > 0) {
              localObject = f.a(localBitmap, localLogoImageView.gNU, localLogoImageView.gNV, true, false);
            }
          }
          localLogoImageView.setImageBitmap((Bitmap)localObject);
        }
        else
        {
          com.tencent.mm.sdk.g.b.c(new LogoImageView.a((String)localObject, localLogoImageView.handler), "LogoImageView_download");
        }
      }
      else if (!i.eA((String)localObject))
      {
        localLogoImageView.setVisibility(8);
      }
      else
      {
        if ((localLogoImageView.gNU <= 0) || (localLogoImageView.gNV <= 0)) {}
        for (localObject = f.aKz((String)localObject);; localObject = f.e((String)localObject, localLogoImageView.gNU, localLogoImageView.gNV, true))
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
    ac.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", new Object[] { Integer.valueOf(this.vlf), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
    if ((paramInt2 == 0) || (paramInt2 == 101))
    {
      i = 1;
      if ((paramInt1 == 0) || (i != 0)) {
        break label538;
      }
      ac.d("MicroMsg.BaseLifeUI", "error");
      if (!this.iNn) {
        break label530;
      }
      paramString = this.vkZ;
      label471:
      if ((this.vlg.size() - 1 == this.vlf) && (paramString.getCount() == 0))
      {
        paramString.vkV = 1;
        this.vkX.Kj(paramString.vkV);
      }
    }
    for (;;)
    {
      this.vle = null;
      oG(false);
      return;
      i = 0;
      break;
      label530:
      paramString = this.vkY;
      break label471;
      label538:
      if (-1L == this.vln) {
        this.vln = System.currentTimeMillis();
      }
      this.vlo = System.currentTimeMillis();
      paramn = locald.vkJ;
      paramString = (boz)this.vlg.get(this.vlf);
      localObject = new BackwardSupportUtil.ExifHelper.LatLongData(paramString.Ehu, paramString.Eht);
      if ((this.iNn) && (!this.vle.vkK)) {
        this.vkZ.djQ();
      }
      if (this.iNn)
      {
        this.vkZ.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, locald.csz(), locald.djP());
        label654:
        if ((paramn != null) && (paramn.size() != 0)) {
          break label828;
        }
        if (!this.iNn) {
          break label820;
        }
      }
      label820:
      for (paramString = this.vkZ;; paramString = this.vkY)
      {
        if (this.vlg.size() - 1 == this.vlf)
        {
          if (paramString.getCount() == 0) {
            this.vkX.Kj(paramString.vkV);
          }
          this.ucL.fix();
          if ((!paramString.djS()) && (paramInt2 != 101)) {
            djW();
          }
        }
        if ((!this.vkY.djS()) && (this.vkW != null) && (!this.iNn)) {
          this.vkW.setVisibility(0);
        }
        if ((this.vkW == null) || (this.iNn)) {
          break label926;
        }
        this.vkW.setVisibility(0);
        break;
        this.vkY.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, locald.csz(), locald.djP());
        break label654;
      }
      label828:
      if (this.iNn) {}
      for (paramString = this.vkZ;; paramString = this.vkY)
      {
        this.ucL.setVisibility(0);
        paramString.vkV = 0;
        this.vkX.Kj(this.vkZ.vkV);
        paramString.a((BackwardSupportUtil.ExifHelper.LatLongData)localObject, paramn);
        paramString.notifyDataSetChanged();
        if ((this.vlg.size() - 1 != this.vlf) || (paramString.djS())) {
          break;
        }
        this.ucL.fix();
        djW();
        break;
      }
      label926:
      if (this.vkW != null) {
        this.vkW.setVisibility(8);
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