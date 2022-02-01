package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LocationWidget
  extends LinearLayout
{
  private float bYG;
  private String dwW;
  private int ePo;
  private String ePv;
  private float hXj;
  private float hXk;
  private boolean hXu;
  private String jDf;
  private Activity kbt;
  private int score;
  private c.a uZA;
  private c vfb;
  private float wqB;
  private b.a wqP;
  private com.tencent.mm.modelgeo.d wqv;
  private btl wrf;
  private ImageView zOS;
  private TextView zQf;
  private View zSd;
  private View zSe;
  private int[] zSf;
  private ImageView[] zSg;
  private int zSh;
  private TextView zSi;
  private byte[] zSj;
  private String zSk;
  private String zSl;
  private int zSm;
  private float zSn;
  private int zSo;
  private a zSp;
  private boolean zSq;
  private b zSr;
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97941);
    this.zSf = new int[] { 2131304356, 2131304357, 2131304358, 2131304359, 2131304360 };
    this.zSg = new ImageView[5];
    this.hXj = -1000.0F;
    this.hXk = -1000.0F;
    this.zSm = 0;
    this.wrf = null;
    this.ePo = 0;
    this.zSn = 0.0F;
    this.wqB = 0.0F;
    this.bYG = 0.0F;
    this.zSo = -1;
    this.hXu = true;
    this.wqv = com.tencent.mm.modelgeo.d.aHQ();
    this.zSp = null;
    this.zSq = false;
    this.uZA = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(97938);
        ad.i("MicroMsg.LocationWidget", "get info %s", new Object[] { paramAnonymousAddr.toString() });
        if (!LocationWidget.e(LocationWidget.this))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.f(LocationWidget.this);
        if (!bt.isNullOrNil(LocationWidget.g(LocationWidget.this)))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.a(LocationWidget.this, paramAnonymousAddr.hXa);
        LocationWidget.f(LocationWidget.this);
        AppMethodBeat.o(97938);
      }
    };
    this.wqP = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(97939);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(97939);
          return true;
        }
        ad.d("MicroMsg.LocationWidget", "get location %f %f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.aLE();
        if (paramAnonymousInt == 0)
        {
          paramAnonymousBoolean = false;
          if (LocationWidget.h(LocationWidget.this) != null) {
            break label113;
          }
        }
        label113:
        for (boolean bool = false;; bool = LocationWidget.h(LocationWidget.this).hXu)
        {
          locale.a(2003, paramAnonymousBoolean, bool, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
          o.a(2003, paramAnonymousFloat1, paramAnonymousFloat2, 0);
          if (LocationWidget.e(LocationWidget.this)) {
            break label128;
          }
          AppMethodBeat.o(97939);
          return false;
          paramAnonymousBoolean = true;
          break;
        }
        label128:
        if ((LocationWidget.i(LocationWidget.this) == -1000.0F) || (LocationWidget.j(LocationWidget.this) == -1000.0F))
        {
          LocationWidget.a(LocationWidget.this, paramAnonymousFloat2);
          LocationWidget.b(LocationWidget.this, paramAnonymousFloat1);
        }
        AppMethodBeat.o(97939);
        return false;
      }
    };
    this.zSr = null;
    n((MMActivity)paramContext);
    AppMethodBeat.o(97941);
  }
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97940);
    this.zSf = new int[] { 2131304356, 2131304357, 2131304358, 2131304359, 2131304360 };
    this.zSg = new ImageView[5];
    this.hXj = -1000.0F;
    this.hXk = -1000.0F;
    this.zSm = 0;
    this.wrf = null;
    this.ePo = 0;
    this.zSn = 0.0F;
    this.wqB = 0.0F;
    this.bYG = 0.0F;
    this.zSo = -1;
    this.hXu = true;
    this.wqv = com.tencent.mm.modelgeo.d.aHQ();
    this.zSp = null;
    this.zSq = false;
    this.uZA = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(97938);
        ad.i("MicroMsg.LocationWidget", "get info %s", new Object[] { paramAnonymousAddr.toString() });
        if (!LocationWidget.e(LocationWidget.this))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.f(LocationWidget.this);
        if (!bt.isNullOrNil(LocationWidget.g(LocationWidget.this)))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.a(LocationWidget.this, paramAnonymousAddr.hXa);
        LocationWidget.f(LocationWidget.this);
        AppMethodBeat.o(97938);
      }
    };
    this.wqP = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(97939);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(97939);
          return true;
        }
        ad.d("MicroMsg.LocationWidget", "get location %f %f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.aLE();
        if (paramAnonymousInt == 0)
        {
          paramAnonymousBoolean = false;
          if (LocationWidget.h(LocationWidget.this) != null) {
            break label113;
          }
        }
        label113:
        for (boolean bool = false;; bool = LocationWidget.h(LocationWidget.this).hXu)
        {
          locale.a(2003, paramAnonymousBoolean, bool, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
          o.a(2003, paramAnonymousFloat1, paramAnonymousFloat2, 0);
          if (LocationWidget.e(LocationWidget.this)) {
            break label128;
          }
          AppMethodBeat.o(97939);
          return false;
          paramAnonymousBoolean = true;
          break;
        }
        label128:
        if ((LocationWidget.i(LocationWidget.this) == -1000.0F) || (LocationWidget.j(LocationWidget.this) == -1000.0F))
        {
          LocationWidget.a(LocationWidget.this, paramAnonymousFloat2);
          LocationWidget.b(LocationWidget.this, paramAnonymousFloat1);
        }
        AppMethodBeat.o(97939);
        return false;
      }
    };
    this.zSr = null;
    n((MMActivity)paramContext);
    AppMethodBeat.o(97940);
  }
  
  private void ax(ArrayList<Exif.a> paramArrayList)
  {
    AppMethodBeat.i(97945);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(97945);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.kvStat(11139, "1");
    Exif.a locala1;
    if ((Math.abs(-1000.0F - this.hXj) > 1.0E-006D) && (Math.abs(-1000.0F - this.hXk) > 1.0E-006D))
    {
      locala1 = (Exif.a)paramArrayList.get(paramArrayList.size() - 1);
      if (b(locala1.latitude, locala1.longitude, this.hXj, this.hXk)) {
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(11139, "2");
      }
    }
    int i = 0;
    if (i < paramArrayList.size())
    {
      j = i + 1;
      label135:
      if (j >= paramArrayList.size()) {
        break label226;
      }
      locala1 = (Exif.a)paramArrayList.get(i);
      Exif.a locala2 = (Exif.a)paramArrayList.get(j);
      if (b(locala1.latitude, locala1.longitude, locala2.latitude, locala2.longitude)) {
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(11139, "3");
      }
    }
    label226:
    for (int j = 0;; j = 1)
    {
      if (j != 0)
      {
        i += 1;
        break;
        j += 1;
        break label135;
      }
      AppMethodBeat.o(97945);
      return;
    }
  }
  
  private static boolean b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(97946);
    if (s.c(paramDouble1, paramDouble2, paramDouble3, paramDouble4) > 1000.0D)
    {
      AppMethodBeat.o(97946);
      return true;
    }
    AppMethodBeat.o(97946);
    return false;
  }
  
  private void dZQ()
  {
    int i = 0;
    AppMethodBeat.i(97943);
    ad.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", new Object[] { Integer.valueOf(this.zSh), this.zSl, Integer.valueOf(this.zSm), Integer.valueOf(this.ePo), Boolean.valueOf(bv.fma()) });
    if ((bv.fma()) || (this.zSh == 0) || (bt.isNullOrNil(this.zSl)) || (this.zSm == 1) || ((this.ePo & 0x1) == 0))
    {
      this.zSe.setVisibility(8);
      AppMethodBeat.o(97943);
      return;
    }
    this.zSe.setVisibility(0);
    while (i < this.score)
    {
      this.zSg[i].setImageResource(getSelectedStarImageResource());
      i += 1;
    }
    i = this.score;
    while (i < 5)
    {
      this.zSg[i].setImageResource(getNormalStarImageResource());
      i += 1;
    }
    AppMethodBeat.o(97943);
  }
  
  private void dZS()
  {
    AppMethodBeat.i(97949);
    if ((this.zSi != null) && (this.zQf != null))
    {
      if (bt.isNullOrNil(this.jDf)) {
        break label124;
      }
      this.zSi.setText(this.jDf);
      this.zSi.setTextColor(getResources().getColor(2131100464));
      this.zQf.setVisibility(8);
    }
    while ((!bt.isNullOrNil(this.jDf)) || (!bt.isNullOrNil(this.ePv)))
    {
      this.zOS.setImageDrawable(ao.k(this.kbt, 2131689533, getContext().getResources().getColor(2131101171)));
      AppMethodBeat.o(97949);
      return;
      label124:
      if (!bt.isNullOrNil(this.ePv))
      {
        this.zSi.setText(this.ePv);
        this.zSi.setTextColor(getResources().getColor(2131100464));
        this.zQf.setVisibility(8);
      }
      else
      {
        this.zSi.setText(2131763887);
        this.zSi.setTextColor(getResources().getColor(2131100711));
        this.zQf.setVisibility(8);
      }
    }
    this.zOS.setImageDrawable(ao.k(this.kbt, 2131689532, getContext().getResources().getColor(2131100499)));
    AppMethodBeat.o(97949);
  }
  
  private void dZT()
  {
    AppMethodBeat.i(97952);
    if (this.zSp != null)
    {
      boolean bool = this.zSp.dZV();
      Object localObject = this.zSp.dZU();
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        AppMethodBeat.o(97952);
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        Exif.a locala = (Exif.a)((Iterator)localObject).next();
        ad.d("MicroMsg.LocationWidget", "snsreport lat lng %f, %f", new Object[] { Double.valueOf(locala.latitude), Double.valueOf(locala.longitude) });
        com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
        int j = (int)(locala.latitude * 1000000.0D);
        int k = (int)(locala.longitude * 1000000.0D);
        if (bool) {}
        for (int i = 1;; i = 2)
        {
          localg.f(11345, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(2) });
          break;
        }
      }
    }
    AppMethodBeat.o(97952);
  }
  
  private void n(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97942);
    this.kbt = paramMMActivity;
    View localView = View.inflate(paramMMActivity, getLayoutResource(), this);
    this.zSd = localView.findViewById(2131301522);
    this.zSi = ((TextView)this.zSd.findViewById(2131301545));
    this.zQf = ((TextView)this.zSd.findViewById(2131301535));
    this.zOS = ((ImageView)this.zSd.findViewById(2131301530));
    this.zSe = localView.findViewById(2131304354);
    final int i = 0;
    while (i < 5)
    {
      this.zSg[i] = ((ImageView)this.zSe.findViewById(this.zSf[i]));
      this.zSg[i].setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97936);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LocationWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (LocationWidget.a(LocationWidget.this) == i + 1) {
            LocationWidget.b(LocationWidget.this);
          }
          for (;;)
          {
            LocationWidget.c(LocationWidget.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97936);
            return;
            LocationWidget.a(LocationWidget.this, i + 1);
          }
        }
      });
      i += 1;
    }
    this.vfb = c.aHN();
    this.zSd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97937);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (com.tencent.mm.ax.b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null)))
        {
          if (!com.tencent.mm.pluginsdk.permission.b.n(LocationWidget.d(LocationWidget.this), "android.permission.ACCESS_COARSE_LOCATION"))
          {
            if (!((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEr, Boolean.FALSE)).booleanValue()) {
              com.tencent.mm.plugin.account.a.b.a.b(LocationWidget.d(LocationWidget.this), LocationWidget.this.getResources().getString(2131760740, new Object[] { ac.fks() }), 30764, true);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(97937);
              return;
              com.tencent.mm.pluginsdk.permission.b.b(LocationWidget.d(LocationWidget.this), "android.permission.ACCESS_COARSE_LOCATION", 64);
            }
          }
        }
        else
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(LocationWidget.d(LocationWidget.this), "android.permission.ACCESS_COARSE_LOCATION", 64, "", "");
          ad.i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97937);
            return;
          }
        }
        LocationWidget.this.dZR();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97937);
      }
    });
    this.zSl = paramMMActivity.getIntent().getStringExtra("kpoi_id");
    if (!bt.isNullOrNil(this.zSl))
    {
      this.hXj = paramMMActivity.getIntent().getFloatExtra("k_lat", -1000.0F);
      this.hXk = paramMMActivity.getIntent().getFloatExtra("k_lng", -1000.0F);
      this.jDf = paramMMActivity.getIntent().getStringExtra("kpoi_name");
      this.zSk = paramMMActivity.getIntent().getStringExtra("Kpoi_address");
      dZS();
    }
    if (com.tencent.mm.kernel.g.ajA().aiK()) {}
    for (this.zSh = bt.getInt(com.tencent.mm.n.g.acA().getValue("SnsPostPOICommentSwitch"), 0);; this.zSh = 0)
    {
      dZQ();
      AppMethodBeat.o(97942);
      return;
    }
  }
  
  public final boolean aN(Intent paramIntent)
  {
    AppMethodBeat.i(97948);
    if (paramIntent == null)
    {
      AppMethodBeat.o(97948);
      return true;
    }
    this.zSm = paramIntent.getIntExtra("get_poi_classify_type", 0);
    this.ePo = paramIntent.getIntExtra("get_poi_showflag", 0);
    ad.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", new Object[] { Integer.valueOf(this.zSm) });
    this.jDf = bt.bI(paramIntent.getStringExtra("get_poi_name"), "");
    this.ePv = bt.bI(paramIntent.getStringExtra("get_city"), "");
    this.hXj = paramIntent.getFloatExtra("get_lat", -1000.0F);
    this.hXk = paramIntent.getFloatExtra("get_lng", -1000.0F);
    ad.i("MicroMsg.LocationWidget", "check cur lat " + this.zSn + " " + this.wqB);
    this.zSn = paramIntent.getFloatExtra("get_cur_lat", 0.0F);
    this.wqB = paramIntent.getFloatExtra("get_cur_lng", 0.0F);
    this.zSo = paramIntent.getIntExtra("get_loctype", -1);
    this.bYG = paramIntent.getFloatExtra("get_accuracy", 0.0F);
    this.hXu = paramIntent.getBooleanExtra("get_is_mars", true);
    this.dwW = paramIntent.getStringExtra("request_id");
    Object localObject = com.tencent.mm.modelstat.e.aLE();
    boolean bool;
    if (this.zSo == 0)
    {
      bool = false;
      ((com.tencent.mm.modelstat.e)localObject).a(2003, bool, this.hXu, this.hXk, this.hXj, (int)this.bYG);
      this.zSj = paramIntent.getByteArrayExtra("location_ctx");
      if (bt.isNullOrNil(this.jDf)) {
        break label610;
      }
      this.zSk = bt.bI(paramIntent.getStringExtra("get_poi_address"), "");
      this.zSl = bt.bI(paramIntent.getStringExtra("get_poi_classify_id"), "");
      this.wrf = new btl();
    }
    for (;;)
    {
      try
      {
        this.wrf = ((btl)this.wrf.parseFrom(paramIntent.getByteArrayExtra("get_poi_item_buf")));
        if (!bt.isNullOrNil(this.zSl))
        {
          this.wrf = new btl();
          this.wrf.wpM = this.zSl;
          this.wrf.nEf = this.zSm;
          this.wrf.Title = this.jDf;
          this.wrf.wpR.add(new cwt().aPy(this.zSk));
        }
        ad.d("MicroMsg.LocationWidget", "label %s poiname %s", new Object[] { this.zSk, this.jDf });
        dZS();
        dZQ();
        this.zSr = new b();
        localObject = this.zSr;
        if (paramIntent != null)
        {
          ((b)localObject).index = paramIntent.getIntExtra("report_index", -1);
          ((b)localObject).wqE = paramIntent.getLongExtra("first_start_time", 0L);
          ((b)localObject).wqF = paramIntent.getLongExtra("lastSuccStamp", 0L);
          ((b)localObject).wqG = paramIntent.getLongExtra("firstSuccStamp", 0L);
          ((b)localObject).wqH = paramIntent.getIntExtra("reqLoadCnt", 0);
          ((b)localObject).vfX = paramIntent.getIntExtra("entry_time", 0);
          ((b)localObject).keN = paramIntent.getStringExtra("search_id");
        }
        AppMethodBeat.o(97948);
        return true;
        bool = true;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        this.wrf = null;
        continue;
      }
      label610:
      if (!bt.isNullOrNil(this.ePv))
      {
        this.jDf = "";
        this.zSk = "";
        this.zSl = "";
        this.wrf = null;
      }
      else
      {
        this.hXj = -1000.0F;
        this.hXk = -1000.0F;
        this.jDf = "";
        this.zSk = "";
        this.ePv = "";
        this.zSl = "";
        this.wrf = null;
      }
    }
  }
  
  public final void dZR()
  {
    AppMethodBeat.i(97944);
    Intent localIntent = new Intent();
    localIntent.putExtra("near_life_scene", 1);
    try
    {
      localIntent.putExtra("get_poi_item_buf", this.wrf.toByteArray());
      if (!bt.isNullOrNil(this.zSl))
      {
        localIntent.putExtra("get_poi_classify_id", this.zSl);
        localIntent.putExtra("get_lat", this.hXj);
        localIntent.putExtra("get_lng", this.hXk);
        localIntent.putExtra("request_id", this.dwW);
        if (this.zSp == null) {
          break label237;
        }
        Object localObject = this.zSp.dZU();
        if (localObject == null) {
          break label237;
        }
        ax((ArrayList)localObject);
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Exif.a locala = (Exif.a)((Iterator)localObject).next();
          localArrayList.add(String.format("%f\n%f", new Object[] { Double.valueOf(locala.latitude), Double.valueOf(locala.longitude) }));
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        continue;
        if (!bt.isNullOrNil(this.ePv)) {
          localIntent.putExtra("get_city", this.ePv);
        }
      }
      label237:
      com.tencent.mm.bs.d.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 10);
      AppMethodBeat.o(97944);
    }
  }
  
  public bvq getCurLocation()
  {
    AppMethodBeat.i(97951);
    bvq localbvq = new bvq();
    localbvq.FOB = this.zSn;
    localbvq.FOA = this.wqB;
    localbvq.bYG = this.bYG;
    localbvq.zSo = this.zSo;
    AppMethodBeat.o(97951);
    return localbvq;
  }
  
  protected int getLayoutResource()
  {
    return 2131494601;
  }
  
  public bvq getLocation()
  {
    AppMethodBeat.i(97950);
    bvq localbvq = new bvq();
    localbvq.FOB = this.hXj;
    localbvq.FOA = this.hXk;
    localbvq.GPQ = 0;
    localbvq.score = this.score;
    if (this.zSj != null) {
      localbvq.GPR = new com.tencent.mm.bx.b(this.zSj);
    }
    if (!bt.isNullOrNil(this.jDf))
    {
      localbvq.zSk = this.zSk;
      localbvq.jDf = this.jDf;
      localbvq.Gnu = this.zSl;
      localbvq.jde = this.ePv;
      if ((this.zSm != 0) && (this.zSm == 1))
      {
        localbvq.zSm = 2;
        ad.d("MicroMsg.LocationWidget", "getlocation type %d", new Object[] { Integer.valueOf(localbvq.zSm) });
      }
    }
    for (;;)
    {
      if (this.zSr != null)
      {
        String str = String.format("%f/%f", new Object[] { Float.valueOf(localbvq.FOB), Float.valueOf(localbvq.FOA) });
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("index " + this.zSr.index);
        localStringBuffer.append("firstStartStamp " + this.zSr.wqE);
        localStringBuffer.append("lastSuccStamp " + this.zSr.wqG);
        localStringBuffer.append("firstSuccStamp " + this.zSr.wqF);
        localStringBuffer.append("reqLoadCnt " + this.zSr.wqH);
        localStringBuffer.append("classifyId " + this.zSl);
        localStringBuffer.append("entryTime " + this.zSr.vfX);
        localStringBuffer.append("searchId" + this.zSr.keN);
        ad.d("MicroMsg.LocationWidget", "report %s", new Object[] { localStringBuffer.toString() });
        com.tencent.mm.plugin.report.service.g.yhR.f(11135, new Object[] { Integer.valueOf(5), Integer.valueOf(this.zSr.index + 1), Long.valueOf(this.zSr.wqE), Long.valueOf(this.zSr.wqG), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.zSr.wqF), Integer.valueOf(this.zSr.wqH), str, this.zSl, Integer.valueOf(this.zSr.vfX), this.zSr.keN, q.cH(true) });
      }
      dZT();
      AppMethodBeat.o(97950);
      return localbvq;
      localbvq.zSm = 1;
      break;
      if (!bt.isNullOrNil(this.ePv)) {
        localbvq.jde = this.ePv;
      }
    }
  }
  
  protected int getNormalStarImageResource()
  {
    return 2131691219;
  }
  
  protected int getNormalStateImageResource()
  {
    return 2131689532;
  }
  
  protected int getSelectedStarImageResource()
  {
    return 2131691220;
  }
  
  protected int getSelectedStateImageResource()
  {
    return 2131689533;
  }
  
  public int getShowFlag()
  {
    return this.ePo;
  }
  
  public void setLocationWidgetListener(a parama)
  {
    this.zSp = parama;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(97947);
    if (this.wqv != null) {
      this.wqv.c(this.wqP);
    }
    if (this.vfb != null) {
      this.vfb.a(this.uZA);
    }
    AppMethodBeat.o(97947);
  }
  
  public static abstract interface a
  {
    public abstract ArrayList<Exif.a> dZU();
    
    public abstract boolean dZV();
  }
  
  final class b
  {
    int index;
    String keN = "";
    int vfX = 0;
    long wqE = -1L;
    long wqF = -1L;
    long wqG = -1L;
    int wqH = 0;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget
 * JD-Core Version:    0.7.0.1
 */