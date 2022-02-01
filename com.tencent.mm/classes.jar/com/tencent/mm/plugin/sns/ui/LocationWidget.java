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
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.n.f;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatLocaleUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LocationWidget
  extends LinearLayout
{
  private b.a ABI;
  private chj ABY;
  private float ABu;
  private TextView EpI;
  private View ErT;
  private View ErU;
  private int[] ErV;
  private ImageView[] ErW;
  private int ErX;
  private TextView ErY;
  private String ErZ;
  private String Esa;
  private int Esb;
  private float Esc;
  private int Esd;
  private a Ese;
  private boolean Esf;
  private b Esg;
  private float cjn;
  private byte[] ctx;
  private String dPI;
  private String fuK;
  private float iUY;
  private float iUZ;
  private boolean iVk;
  private String kHV;
  private Activity mContext;
  private int score;
  private int showFlag;
  private ImageView uzC;
  private d uzs;
  private c.a yFD;
  private com.tencent.mm.modelgeo.c yKY;
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97941);
    this.ErV = new int[] { 2131307290, 2131307291, 2131307292, 2131307293, 2131307294 };
    this.ErW = new ImageView[5];
    this.iUY = -1000.0F;
    this.iUZ = -1000.0F;
    this.Esb = 0;
    this.ABY = null;
    this.showFlag = 0;
    this.Esc = 0.0F;
    this.ABu = 0.0F;
    this.cjn = 0.0F;
    this.Esd = -1;
    this.iVk = true;
    this.uzs = d.bca();
    this.Ese = null;
    this.Esf = false;
    this.yFD = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(97938);
        Log.i("MicroMsg.LocationWidget", "get info %s", new Object[] { paramAnonymousAddr.toString() });
        if (!LocationWidget.e(LocationWidget.this))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.f(LocationWidget.this);
        if (!Util.isNullOrNil(LocationWidget.g(LocationWidget.this)))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.a(LocationWidget.this, paramAnonymousAddr.iUQ);
        LocationWidget.f(LocationWidget.this);
        AppMethodBeat.o(97938);
      }
    };
    this.ABI = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(97939);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(97939);
          return true;
        }
        Log.d("MicroMsg.LocationWidget", "get location %f %f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.bge();
        if (paramAnonymousInt == 0)
        {
          paramAnonymousBoolean = false;
          if (LocationWidget.h(LocationWidget.this) != null) {
            break label113;
          }
        }
        label113:
        for (boolean bool = false;; bool = LocationWidget.h(LocationWidget.this).iVk)
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
    this.Esg = null;
    n((MMActivity)paramContext);
    AppMethodBeat.o(97941);
  }
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97940);
    this.ErV = new int[] { 2131307290, 2131307291, 2131307292, 2131307293, 2131307294 };
    this.ErW = new ImageView[5];
    this.iUY = -1000.0F;
    this.iUZ = -1000.0F;
    this.Esb = 0;
    this.ABY = null;
    this.showFlag = 0;
    this.Esc = 0.0F;
    this.ABu = 0.0F;
    this.cjn = 0.0F;
    this.Esd = -1;
    this.iVk = true;
    this.uzs = d.bca();
    this.Ese = null;
    this.Esf = false;
    this.yFD = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(97938);
        Log.i("MicroMsg.LocationWidget", "get info %s", new Object[] { paramAnonymousAddr.toString() });
        if (!LocationWidget.e(LocationWidget.this))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.f(LocationWidget.this);
        if (!Util.isNullOrNil(LocationWidget.g(LocationWidget.this)))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.a(LocationWidget.this, paramAnonymousAddr.iUQ);
        LocationWidget.f(LocationWidget.this);
        AppMethodBeat.o(97938);
      }
    };
    this.ABI = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(97939);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(97939);
          return true;
        }
        Log.d("MicroMsg.LocationWidget", "get location %f %f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.bge();
        if (paramAnonymousInt == 0)
        {
          paramAnonymousBoolean = false;
          if (LocationWidget.h(LocationWidget.this) != null) {
            break label113;
          }
        }
        label113:
        for (boolean bool = false;; bool = LocationWidget.h(LocationWidget.this).iVk)
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
    this.Esg = null;
    n((MMActivity)paramContext);
    AppMethodBeat.o(97940);
  }
  
  private void aP(ArrayList<Exif.a> paramArrayList)
  {
    AppMethodBeat.i(97945);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(97945);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(11139, "1");
    Exif.a locala1;
    if ((Math.abs(-1000.0F - this.iUY) > 1.0E-006D) && (Math.abs(-1000.0F - this.iUZ) > 1.0E-006D))
    {
      locala1 = (Exif.a)paramArrayList.get(paramArrayList.size() - 1);
      if (b(locala1.latitude, locala1.longitude, this.iUY, this.iUZ)) {
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(11139, "2");
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
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(11139, "3");
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
  
  private void ffO()
  {
    int i = 0;
    AppMethodBeat.i(97943);
    Log.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", new Object[] { Integer.valueOf(this.ErX), this.Esa, Integer.valueOf(this.Esb), Integer.valueOf(this.showFlag), Boolean.valueOf(WeChatLocaleUtil.isOverseasUserByWechatLanguage()) });
    if ((WeChatLocaleUtil.isOverseasUserByWechatLanguage()) || (this.ErX == 0) || (Util.isNullOrNil(this.Esa)) || (this.Esb == 1) || ((this.showFlag & 0x1) == 0))
    {
      this.ErU.setVisibility(8);
      AppMethodBeat.o(97943);
      return;
    }
    this.ErU.setVisibility(0);
    while (i < this.score)
    {
      this.ErW[i].setImageResource(getSelectedStarImageResource());
      i += 1;
    }
    i = this.score;
    while (i < 5)
    {
      this.ErW[i].setImageResource(getNormalStarImageResource());
      i += 1;
    }
    AppMethodBeat.o(97943);
  }
  
  private void ffQ()
  {
    AppMethodBeat.i(97949);
    if ((this.ErY != null) && (this.EpI != null))
    {
      if (Util.isNullOrNil(this.kHV)) {
        break label124;
      }
      this.ErY.setText(this.kHV);
      this.ErY.setTextColor(getResources().getColor(2131100566));
      this.EpI.setVisibility(8);
    }
    while ((!Util.isNullOrNil(this.kHV)) || (!Util.isNullOrNil(this.fuK)))
    {
      this.uzC.setImageDrawable(ar.m(this.mContext, 2131689536, getContext().getResources().getColor(2131101414)));
      AppMethodBeat.o(97949);
      return;
      label124:
      if (!Util.isNullOrNil(this.fuK))
      {
        this.ErY.setText(this.fuK);
        this.ErY.setTextColor(getResources().getColor(2131100566));
        this.EpI.setVisibility(8);
      }
      else
      {
        this.ErY.setText(2131766114);
        this.ErY.setTextColor(getResources().getColor(2131100904));
        this.EpI.setVisibility(8);
      }
    }
    this.uzC.setImageDrawable(ar.m(this.mContext, 2131689535, getContext().getResources().getColor(2131100634)));
    AppMethodBeat.o(97949);
  }
  
  private void ffR()
  {
    AppMethodBeat.i(97952);
    if (this.Ese != null)
    {
      boolean bool = this.Ese.ffT();
      Object localObject = this.Ese.ffS();
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        AppMethodBeat.o(97952);
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        Exif.a locala = (Exif.a)((Iterator)localObject).next();
        Log.d("MicroMsg.LocationWidget", "snsreport lat lng %f, %f", new Object[] { Double.valueOf(locala.latitude), Double.valueOf(locala.longitude) });
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
        int j = (int)(locala.latitude * 1000000.0D);
        int k = (int)(locala.longitude * 1000000.0D);
        if (bool) {}
        for (int i = 1;; i = 2)
        {
          localh.a(11345, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(2) });
          break;
        }
      }
    }
    AppMethodBeat.o(97952);
  }
  
  private void n(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97942);
    this.mContext = paramMMActivity;
    View localView = View.inflate(paramMMActivity, getLayoutResource(), this);
    this.ErT = localView.findViewById(2131303728);
    this.ErY = ((TextView)this.ErT.findViewById(2131303755));
    this.EpI = ((TextView)this.ErT.findViewById(2131303744));
    this.uzC = ((ImageView)this.ErT.findViewById(2131303736));
    this.ErU = localView.findViewById(2131307288);
    final int i = 0;
    while (i < 5)
    {
      this.ErW[i] = ((ImageView)this.ErU.findViewById(this.ErV[i]));
      this.ErW[i].setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97936);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LocationWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    this.yKY = com.tencent.mm.modelgeo.c.bbX();
    this.ErT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97937);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(paramAnonymousView.getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97937);
          return;
        }
        if (com.tencent.mm.aw.b.Pi((String)g.aAh().azQ().get(274436, null)))
        {
          int i;
          if ((com.tencent.mm.pluginsdk.permission.b.n(LocationWidget.d(LocationWidget.this), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.n(LocationWidget.d(LocationWidget.this), "android.permission.ACCESS_COARSE_LOCATION")))
          {
            i = 1;
            if (i != 0) {
              break label306;
            }
            if (((Boolean)g.aAh().azQ().get(ar.a.Oho, Boolean.FALSE)).booleanValue()) {
              break label208;
            }
            com.tencent.mm.plugin.account.a.b.a.b(LocationWidget.d(LocationWidget.this), LocationWidget.this.getResources().getString(2131762481, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97937);
            return;
            i = 0;
            break;
            label208:
            com.tencent.mm.pluginsdk.permission.b.a(LocationWidget.d(LocationWidget.this), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 64);
          }
        }
        else
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(LocationWidget.d(LocationWidget.this), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 64, null, null);
          Log.i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97937);
            return;
          }
        }
        label306:
        LocationWidget.this.ffP();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97937);
      }
    });
    this.Esa = paramMMActivity.getIntent().getStringExtra("kpoi_id");
    if (!Util.isNullOrNil(this.Esa))
    {
      this.iUY = paramMMActivity.getIntent().getFloatExtra("k_lat", -1000.0F);
      this.iUZ = paramMMActivity.getIntent().getFloatExtra("k_lng", -1000.0F);
      this.kHV = paramMMActivity.getIntent().getStringExtra("kpoi_name");
      this.ErZ = paramMMActivity.getIntent().getStringExtra("Kpoi_address");
      ffQ();
    }
    if (g.aAf().azp()) {}
    for (this.ErX = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsPostPOICommentSwitch"), 0);; this.ErX = 0)
    {
      ffO();
      AppMethodBeat.o(97942);
      return;
    }
  }
  
  public final boolean aY(Intent paramIntent)
  {
    AppMethodBeat.i(97948);
    if (paramIntent == null)
    {
      AppMethodBeat.o(97948);
      return true;
    }
    this.Esb = paramIntent.getIntExtra("get_poi_classify_type", 0);
    this.showFlag = paramIntent.getIntExtra("get_poi_showflag", 0);
    Log.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", new Object[] { Integer.valueOf(this.Esb) });
    this.kHV = Util.nullAs(paramIntent.getStringExtra("get_poi_name"), "");
    this.fuK = Util.nullAs(paramIntent.getStringExtra("get_city"), "");
    this.iUY = paramIntent.getFloatExtra("get_lat", -1000.0F);
    this.iUZ = paramIntent.getFloatExtra("get_lng", -1000.0F);
    Log.i("MicroMsg.LocationWidget", "check cur lat " + this.Esc + " " + this.ABu);
    this.Esc = paramIntent.getFloatExtra("get_cur_lat", 0.0F);
    this.ABu = paramIntent.getFloatExtra("get_cur_lng", 0.0F);
    this.Esd = paramIntent.getIntExtra("get_loctype", -1);
    this.cjn = paramIntent.getFloatExtra("get_accuracy", 0.0F);
    this.iVk = paramIntent.getBooleanExtra("get_is_mars", true);
    this.dPI = paramIntent.getStringExtra("request_id");
    Object localObject = com.tencent.mm.modelstat.e.bge();
    boolean bool;
    if (this.Esd == 0)
    {
      bool = false;
      ((com.tencent.mm.modelstat.e)localObject).a(2003, bool, this.iVk, this.iUZ, this.iUY, (int)this.cjn);
      this.ctx = paramIntent.getByteArrayExtra("location_ctx");
      if (Util.isNullOrNil(this.kHV)) {
        break label610;
      }
      this.ErZ = Util.nullAs(paramIntent.getStringExtra("get_poi_address"), "");
      this.Esa = Util.nullAs(paramIntent.getStringExtra("get_poi_classify_id"), "");
      this.ABY = new chj();
    }
    for (;;)
    {
      try
      {
        this.ABY = ((chj)this.ABY.parseFrom(paramIntent.getByteArrayExtra("get_poi_item_buf")));
        if (!Util.isNullOrNil(this.Esa))
        {
          this.ABY = new chj();
          this.ABY.AAG = this.Esa;
          this.ABY.oUv = this.Esb;
          this.ABY.Title = this.kHV;
          this.ABY.AAL.add(new dqi().bhy(this.ErZ));
        }
        Log.d("MicroMsg.LocationWidget", "label %s poiname %s", new Object[] { this.ErZ, this.kHV });
        ffQ();
        ffO();
        this.Esg = new b();
        localObject = this.Esg;
        if (paramIntent != null)
        {
          ((b)localObject).index = paramIntent.getIntExtra("report_index", -1);
          ((b)localObject).ABx = paramIntent.getLongExtra("first_start_time", 0L);
          ((b)localObject).ABy = paramIntent.getLongExtra("lastSuccStamp", 0L);
          ((b)localObject).ABz = paramIntent.getLongExtra("firstSuccStamp", 0L);
          ((b)localObject).ABA = paramIntent.getIntExtra("reqLoadCnt", 0);
          ((b)localObject).yLS = paramIntent.getIntExtra("entry_time", 0);
          ((b)localObject).hes = paramIntent.getStringExtra("search_id");
        }
        AppMethodBeat.o(97948);
        return true;
        bool = true;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        this.ABY = null;
        continue;
      }
      label610:
      if (!Util.isNullOrNil(this.fuK))
      {
        this.kHV = "";
        this.ErZ = "";
        this.Esa = "";
        this.ABY = null;
      }
      else
      {
        this.iUY = -1000.0F;
        this.iUZ = -1000.0F;
        this.kHV = "";
        this.ErZ = "";
        this.fuK = "";
        this.Esa = "";
        this.ABY = null;
      }
    }
  }
  
  public final void ffP()
  {
    AppMethodBeat.i(97944);
    Intent localIntent = new Intent();
    localIntent.putExtra("near_life_scene", 1);
    try
    {
      localIntent.putExtra("get_poi_item_buf", this.ABY.toByteArray());
      if (!Util.isNullOrNil(this.Esa))
      {
        localIntent.putExtra("get_poi_classify_id", this.Esa);
        localIntent.putExtra("get_lat", this.iUY);
        localIntent.putExtra("get_lng", this.iUZ);
        localIntent.putExtra("request_id", this.dPI);
        if (this.Ese == null) {
          break label237;
        }
        Object localObject = this.Ese.ffS();
        if (localObject == null) {
          break label237;
        }
        aP((ArrayList)localObject);
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
        Log.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        continue;
        if (!Util.isNullOrNil(this.fuK)) {
          localIntent.putExtra("get_city", this.fuK);
        }
      }
      label237:
      com.tencent.mm.br.c.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 10);
      AppMethodBeat.o(97944);
    }
  }
  
  public cjy getCurLocation()
  {
    AppMethodBeat.i(97951);
    cjy localcjy = new cjy();
    localcjy.LbD = this.Esc;
    localcjy.LbC = this.ABu;
    localcjy.cjn = this.cjn;
    localcjy.Esd = this.Esd;
    AppMethodBeat.o(97951);
    return localcjy;
  }
  
  protected int getLayoutResource()
  {
    return 2131495312;
  }
  
  public cjy getLocation()
  {
    AppMethodBeat.i(97950);
    cjy localcjy = new cjy();
    localcjy.LbD = this.iUY;
    localcjy.LbC = this.iUZ;
    localcjy.Mpv = 0;
    localcjy.score = this.score;
    if (this.ctx != null) {
      localcjy.Mpw = new com.tencent.mm.bw.b(this.ctx);
    }
    if (!Util.isNullOrNil(this.kHV))
    {
      localcjy.ErZ = this.ErZ;
      localcjy.kHV = this.kHV;
      localcjy.LIb = this.Esa;
      localcjy.kea = this.fuK;
      if ((this.Esb != 0) && (this.Esb == 1))
      {
        localcjy.Esb = 2;
        Log.d("MicroMsg.LocationWidget", "getlocation type %d", new Object[] { Integer.valueOf(localcjy.Esb) });
      }
    }
    for (;;)
    {
      if (this.Esg != null)
      {
        String str = String.format("%f/%f", new Object[] { Float.valueOf(localcjy.LbD), Float.valueOf(localcjy.LbC) });
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("index " + this.Esg.index);
        localStringBuffer.append("firstStartStamp " + this.Esg.ABx);
        localStringBuffer.append("lastSuccStamp " + this.Esg.ABz);
        localStringBuffer.append("firstSuccStamp " + this.Esg.ABy);
        localStringBuffer.append("reqLoadCnt " + this.Esg.ABA);
        localStringBuffer.append("classifyId " + this.Esa);
        localStringBuffer.append("entryTime " + this.Esg.yLS);
        localStringBuffer.append("searchId" + this.Esg.hes);
        Log.d("MicroMsg.LocationWidget", "report %s", new Object[] { localStringBuffer.toString() });
        com.tencent.mm.plugin.report.service.h.CyF.a(11135, new Object[] { Integer.valueOf(5), Integer.valueOf(this.Esg.index + 1), Long.valueOf(this.Esg.ABx), Long.valueOf(this.Esg.ABz), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.Esg.ABy), Integer.valueOf(this.Esg.ABA), str, this.Esa, Integer.valueOf(this.Esg.yLS), this.Esg.hes, q.dr(true) });
      }
      ffR();
      AppMethodBeat.o(97950);
      return localcjy;
      localcjy.Esb = 1;
      break;
      if (!Util.isNullOrNil(this.fuK)) {
        localcjy.kea = this.fuK;
      }
    }
  }
  
  protected int getNormalStarImageResource()
  {
    return 2131691541;
  }
  
  protected int getNormalStateImageResource()
  {
    return 2131689535;
  }
  
  protected int getSelectedStarImageResource()
  {
    return 2131691542;
  }
  
  protected int getSelectedStateImageResource()
  {
    return 2131689536;
  }
  
  public int getShowFlag()
  {
    return this.showFlag;
  }
  
  public void setLocationWidgetListener(a parama)
  {
    this.Ese = parama;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(97947);
    if (this.uzs != null) {
      this.uzs.c(this.ABI);
    }
    if (this.yKY != null) {
      this.yKY.a(this.yFD);
    }
    AppMethodBeat.o(97947);
  }
  
  public static abstract interface a
  {
    public abstract ArrayList<Exif.a> ffS();
    
    public abstract boolean ffT();
  }
  
  final class b
  {
    int ABA = 0;
    long ABx = -1L;
    long ABy = -1L;
    long ABz = -1L;
    String hes = "";
    int index;
    int yLS = 0;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget
 * JD-Core Version:    0.7.0.1
 */