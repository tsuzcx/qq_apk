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
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatLocaleUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LocationWidget
  extends LinearLayout
{
  private c.a Ejw;
  private com.tencent.mm.modelgeo.c EoR;
  private b.a GuK;
  private float Guw;
  private cqf Gva;
  private TextView KCR;
  private a KFA;
  private boolean KFB;
  private b KFC;
  private View KFo;
  private View KFp;
  private int[] KFq;
  private ImageView[] KFr;
  private int KFs;
  private TextView KFt;
  private String KFu;
  private String KFv;
  private int KFw;
  private float KFx;
  private float KFy;
  private int KFz;
  private String city;
  private byte[] ctx;
  private String fIY;
  private boolean lLE;
  private float lLr;
  private float lLs;
  private Activity mContext;
  private String poiName;
  private int score;
  private int showFlag;
  private d yUU;
  private ImageView yVe;
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97941);
    this.KFq = new int[] { i.f.score_iv_1, i.f.score_iv_2, i.f.score_iv_3, i.f.score_iv_4, i.f.score_iv_5 };
    this.KFr = new ImageView[5];
    this.lLr = -1000.0F;
    this.lLs = -1000.0F;
    this.KFw = 0;
    this.Gva = null;
    this.showFlag = 0;
    this.KFx = 0.0F;
    this.Guw = 0.0F;
    this.KFy = 0.0F;
    this.KFz = -1;
    this.lLE = true;
    this.yUU = d.blq();
    this.KFA = null;
    this.KFB = false;
    this.Ejw = new c.a()
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
        LocationWidget.a(LocationWidget.this, paramAnonymousAddr.lLi);
        LocationWidget.f(LocationWidget.this);
        AppMethodBeat.o(97938);
      }
    };
    this.GuK = new b.a()
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
        n.a(2003, paramAnonymousFloat1, paramAnonymousFloat2, 0);
        if (!LocationWidget.e(LocationWidget.this))
        {
          AppMethodBeat.o(97939);
          return false;
        }
        if ((LocationWidget.h(LocationWidget.this) == -1000.0F) || (LocationWidget.i(LocationWidget.this) == -1000.0F))
        {
          LocationWidget.a(LocationWidget.this, paramAnonymousFloat2);
          LocationWidget.b(LocationWidget.this, paramAnonymousFloat1);
        }
        AppMethodBeat.o(97939);
        return false;
      }
    };
    this.KFC = null;
    o((MMActivity)paramContext);
    AppMethodBeat.o(97941);
  }
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97940);
    this.KFq = new int[] { i.f.score_iv_1, i.f.score_iv_2, i.f.score_iv_3, i.f.score_iv_4, i.f.score_iv_5 };
    this.KFr = new ImageView[5];
    this.lLr = -1000.0F;
    this.lLs = -1000.0F;
    this.KFw = 0;
    this.Gva = null;
    this.showFlag = 0;
    this.KFx = 0.0F;
    this.Guw = 0.0F;
    this.KFy = 0.0F;
    this.KFz = -1;
    this.lLE = true;
    this.yUU = d.blq();
    this.KFA = null;
    this.KFB = false;
    this.Ejw = new c.a()
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
        LocationWidget.a(LocationWidget.this, paramAnonymousAddr.lLi);
        LocationWidget.f(LocationWidget.this);
        AppMethodBeat.o(97938);
      }
    };
    this.GuK = new b.a()
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
        n.a(2003, paramAnonymousFloat1, paramAnonymousFloat2, 0);
        if (!LocationWidget.e(LocationWidget.this))
        {
          AppMethodBeat.o(97939);
          return false;
        }
        if ((LocationWidget.h(LocationWidget.this) == -1000.0F) || (LocationWidget.i(LocationWidget.this) == -1000.0F))
        {
          LocationWidget.a(LocationWidget.this, paramAnonymousFloat2);
          LocationWidget.b(LocationWidget.this, paramAnonymousFloat1);
        }
        AppMethodBeat.o(97939);
        return false;
      }
    };
    this.KFC = null;
    o((MMActivity)paramContext);
    AppMethodBeat.o(97940);
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
  
  private void bd(ArrayList<Exif.a> paramArrayList)
  {
    AppMethodBeat.i(97945);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(97945);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(11139, "1");
    Exif.a locala1;
    if ((Math.abs(-1000.0F - this.lLr) > 1.0E-006D) && (Math.abs(-1000.0F - this.lLs) > 1.0E-006D))
    {
      locala1 = (Exif.a)paramArrayList.get(paramArrayList.size() - 1);
      if (b(locala1.latitude, locala1.longitude, this.lLr, this.lLs)) {
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(11139, "2");
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
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(11139, "3");
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
  
  private void fTL()
  {
    int i = 0;
    AppMethodBeat.i(97943);
    Log.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", new Object[] { Integer.valueOf(this.KFs), this.KFv, Integer.valueOf(this.KFw), Integer.valueOf(this.showFlag), Boolean.valueOf(WeChatLocaleUtil.isOverseasUserByWechatLanguage()) });
    if ((WeChatLocaleUtil.isOverseasUserByWechatLanguage()) || (this.KFs == 0) || (Util.isNullOrNil(this.KFv)) || (this.KFw == 1) || ((this.showFlag & 0x1) == 0))
    {
      this.KFp.setVisibility(8);
      AppMethodBeat.o(97943);
      return;
    }
    this.KFp.setVisibility(0);
    while (i < this.score)
    {
      this.KFr[i].setImageResource(getSelectedStarImageResource());
      i += 1;
    }
    i = this.score;
    while (i < 5)
    {
      this.KFr[i].setImageResource(getNormalStarImageResource());
      i += 1;
    }
    AppMethodBeat.o(97943);
  }
  
  private void fTN()
  {
    AppMethodBeat.i(97949);
    if ((this.KFt != null) && (this.KCR != null))
    {
      if (Util.isNullOrNil(this.poiName)) {
        break label124;
      }
      this.KFt.setText(this.poiName);
      this.KFt.setTextColor(getResources().getColor(i.c.green_text_color));
      this.KCR.setVisibility(8);
    }
    while ((!Util.isNullOrNil(this.poiName)) || (!Util.isNullOrNil(this.city)))
    {
      this.yVe.setImageDrawable(au.o(this.mContext, i.i.album_location_icon_pressed, getContext().getResources().getColor(i.c.wechat_green)));
      AppMethodBeat.o(97949);
      return;
      label124:
      if (!Util.isNullOrNil(this.city))
      {
        this.KFt.setText(this.city);
        this.KFt.setTextColor(getResources().getColor(i.c.green_text_color));
        this.KCR.setVisibility(8);
      }
      else
      {
        this.KFt.setText(i.j.sns_location_tips);
        this.KFt.setTextColor(getResources().getColor(i.c.normal_text_color));
        this.KCR.setVisibility(8);
      }
    }
    this.yVe.setImageDrawable(au.o(this.mContext, i.i.album_location_icon_normal, getContext().getResources().getColor(i.c.icon_color)));
    AppMethodBeat.o(97949);
  }
  
  private void fTO()
  {
    AppMethodBeat.i(97952);
    if (this.KFA != null)
    {
      boolean bool = this.KFA.fTQ();
      Object localObject = this.KFA.fTP();
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
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
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
  
  private void o(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97942);
    this.mContext = paramMMActivity;
    View localView = View.inflate(paramMMActivity, getLayoutResource(), this);
    this.KFo = localView.findViewById(i.f.location_contentview);
    this.KFt = ((TextView)this.KFo.findViewById(i.f.location_tips));
    this.KCR = ((TextView)this.KFo.findViewById(i.f.location_poi));
    this.yVe = ((ImageView)this.KFo.findViewById(i.f.location_iv));
    this.KFp = localView.findViewById(i.f.score_contentview);
    final int i = 0;
    while (i < 5)
    {
      this.KFr[i] = ((ImageView)this.KFp.findViewById(this.KFq[i]));
      this.KFr[i].setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97936);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LocationWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
    this.EoR = com.tencent.mm.modelgeo.c.bln();
    this.KFo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97937);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(paramAnonymousView.getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97937);
          return;
        }
        if (com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null)))
        {
          int i;
          if ((com.tencent.mm.pluginsdk.permission.b.o(LocationWidget.d(LocationWidget.this), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.o(LocationWidget.d(LocationWidget.this), "android.permission.ACCESS_COARSE_LOCATION")))
          {
            i = 1;
            if (i != 0) {
              break label307;
            }
            if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvE, Boolean.FALSE)).booleanValue()) {
              break label209;
            }
            com.tencent.mm.plugin.account.sdk.b.a.b(LocationWidget.d(LocationWidget.this), LocationWidget.this.getResources().getString(i.j.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97937);
            return;
            i = 0;
            break;
            label209:
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
        label307:
        LocationWidget.this.fTM();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97937);
      }
    });
    this.KFv = paramMMActivity.getIntent().getStringExtra("kpoi_id");
    if (!Util.isNullOrNil(this.KFv))
    {
      this.lLr = paramMMActivity.getIntent().getFloatExtra("k_lat", -1000.0F);
      this.lLs = paramMMActivity.getIntent().getFloatExtra("k_lng", -1000.0F);
      this.poiName = paramMMActivity.getIntent().getStringExtra("kpoi_name");
      this.KFu = paramMMActivity.getIntent().getStringExtra("Kpoi_address");
      fTN();
    }
    if (com.tencent.mm.kernel.h.aHE().aGM()) {}
    for (this.KFs = Util.getInt(com.tencent.mm.n.h.axc().getValue("SnsPostPOICommentSwitch"), 0);; this.KFs = 0)
    {
      fTL();
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
    this.KFw = paramIntent.getIntExtra("get_poi_classify_type", 0);
    this.showFlag = paramIntent.getIntExtra("get_poi_showflag", 0);
    Log.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", new Object[] { Integer.valueOf(this.KFw) });
    this.poiName = Util.nullAs(paramIntent.getStringExtra("get_poi_name"), "");
    this.city = Util.nullAs(paramIntent.getStringExtra("get_city"), "");
    this.lLr = paramIntent.getFloatExtra("get_lat", -1000.0F);
    this.lLs = paramIntent.getFloatExtra("get_lng", -1000.0F);
    Log.i("MicroMsg.LocationWidget", "check cur lat " + this.KFx + " " + this.Guw);
    this.KFx = paramIntent.getFloatExtra("get_cur_lat", 0.0F);
    this.Guw = paramIntent.getFloatExtra("get_cur_lng", 0.0F);
    this.KFz = paramIntent.getIntExtra("get_loctype", -1);
    this.KFy = paramIntent.getFloatExtra("get_accuracy", 0.0F);
    this.lLE = paramIntent.getBooleanExtra("get_is_mars", true);
    this.fIY = paramIntent.getStringExtra("request_id");
    this.ctx = paramIntent.getByteArrayExtra("location_ctx");
    if (!Util.isNullOrNil(this.poiName))
    {
      this.KFu = Util.nullAs(paramIntent.getStringExtra("get_poi_address"), "");
      this.KFv = Util.nullAs(paramIntent.getStringExtra("get_poi_classify_id"), "");
      this.Gva = new cqf();
    }
    for (;;)
    {
      try
      {
        this.Gva = ((cqf)this.Gva.parseFrom(paramIntent.getByteArrayExtra("get_poi_item_buf")));
        if (!Util.isNullOrNil(this.KFv))
        {
          this.Gva = new cqf();
          this.Gva.GtI = this.KFv;
          this.Gva.rWu = this.KFw;
          this.Gva.fwr = this.poiName;
          this.Gva.GtN.add(new eaf().btQ(this.KFu));
        }
        Log.d("MicroMsg.LocationWidget", "label %s poiname %s", new Object[] { this.KFu, this.poiName });
        fTN();
        fTL();
        this.KFC = new b();
        b localb = this.KFC;
        if (paramIntent != null)
        {
          localb.index = paramIntent.getIntExtra("report_index", -1);
          localb.Guz = paramIntent.getLongExtra("first_start_time", 0L);
          localb.GuA = paramIntent.getLongExtra("lastSuccStamp", 0L);
          localb.GuB = paramIntent.getLongExtra("firstSuccStamp", 0L);
          localb.GuC = paramIntent.getIntExtra("reqLoadCnt", 0);
          localb.EpL = paramIntent.getIntExtra("entry_time", 0);
          localb.jQi = paramIntent.getStringExtra("search_id");
        }
        AppMethodBeat.o(97948);
        return true;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        this.Gva = null;
        continue;
      }
      if (!Util.isNullOrNil(this.city))
      {
        this.poiName = "";
        this.KFu = "";
        this.KFv = "";
        this.Gva = null;
      }
      else
      {
        this.lLr = -1000.0F;
        this.lLs = -1000.0F;
        this.poiName = "";
        this.KFu = "";
        this.city = "";
        this.KFv = "";
        this.Gva = null;
      }
    }
  }
  
  public final void fTM()
  {
    AppMethodBeat.i(97944);
    Intent localIntent = new Intent();
    localIntent.putExtra("near_life_scene", 1);
    try
    {
      localIntent.putExtra("get_poi_item_buf", this.Gva.toByteArray());
      if (!Util.isNullOrNil(this.KFv))
      {
        localIntent.putExtra("get_poi_classify_id", this.KFv);
        localIntent.putExtra("get_lat", this.lLr);
        localIntent.putExtra("get_lng", this.lLs);
        localIntent.putExtra("request_id", this.fIY);
        if (this.KFA == null) {
          break label237;
        }
        Object localObject = this.KFA.fTP();
        if (localObject == null) {
          break label237;
        }
        bd((ArrayList)localObject);
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
        if (!Util.isNullOrNil(this.city)) {
          localIntent.putExtra("get_city", this.city);
        }
      }
      label237:
      com.tencent.mm.by.c.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 10);
      AppMethodBeat.o(97944);
    }
  }
  
  public cst getCurLocation()
  {
    AppMethodBeat.i(97951);
    cst localcst = new cst();
    localcst.ScP = this.KFx;
    localcst.ScO = this.Guw;
    localcst.KFy = this.KFy;
    localcst.KFz = this.KFz;
    AppMethodBeat.o(97951);
    return localcst;
  }
  
  protected int getLayoutResource()
  {
    return i.g.location_widget;
  }
  
  public cst getLocation()
  {
    AppMethodBeat.i(97950);
    cst localcst = new cst();
    localcst.ScP = this.lLr;
    localcst.ScO = this.lLs;
    localcst.TAA = 0;
    localcst.score = this.score;
    if (this.ctx != null) {
      localcst.TAB = new com.tencent.mm.cd.b(this.ctx);
    }
    if (!Util.isNullOrNil(this.poiName))
    {
      localcst.KFu = this.KFu;
      localcst.poiName = this.poiName;
      localcst.SOz = this.KFv;
      localcst.mVA = this.city;
      if ((this.KFw != 0) && (this.KFw == 1))
      {
        localcst.KFw = 2;
        Log.d("MicroMsg.LocationWidget", "getlocation type %d", new Object[] { Integer.valueOf(localcst.KFw) });
      }
    }
    for (;;)
    {
      if (this.KFC != null)
      {
        String str = String.format("%f/%f", new Object[] { Float.valueOf(localcst.ScP), Float.valueOf(localcst.ScO) });
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("index " + this.KFC.index);
        localStringBuffer.append("firstStartStamp " + this.KFC.Guz);
        localStringBuffer.append("lastSuccStamp " + this.KFC.GuB);
        localStringBuffer.append("firstSuccStamp " + this.KFC.GuA);
        localStringBuffer.append("reqLoadCnt " + this.KFC.GuC);
        localStringBuffer.append("classifyId " + this.KFv);
        localStringBuffer.append("entryTime " + this.KFC.EpL);
        localStringBuffer.append("searchId" + this.KFC.jQi);
        Log.d("MicroMsg.LocationWidget", "report %s", new Object[] { localStringBuffer.toString() });
        com.tencent.mm.plugin.report.service.h.IzE.a(11135, new Object[] { Integer.valueOf(5), Integer.valueOf(this.KFC.index + 1), Long.valueOf(this.KFC.Guz), Long.valueOf(this.KFC.GuB), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.KFC.GuA), Integer.valueOf(this.KFC.GuC), str, this.KFv, Integer.valueOf(this.KFC.EpL), this.KFC.jQi, q.dR(true) });
      }
      fTO();
      AppMethodBeat.o(97950);
      return localcst;
      localcst.KFw = 1;
      break;
      if (!Util.isNullOrNil(this.city)) {
        localcst.mVA = this.city;
      }
    }
  }
  
  protected int getNormalStarImageResource()
  {
    return i.i.sns_shoot_star_normal;
  }
  
  protected int getNormalStateImageResource()
  {
    return i.i.album_location_icon_normal;
  }
  
  protected int getSelectedStarImageResource()
  {
    return i.i.sns_shoot_star_selected;
  }
  
  protected int getSelectedStateImageResource()
  {
    return i.i.album_location_icon_pressed;
  }
  
  public int getShowFlag()
  {
    return this.showFlag;
  }
  
  public void setLocationWidgetListener(a parama)
  {
    this.KFA = parama;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(97947);
    if (this.yUU != null) {
      this.yUU.b(this.GuK);
    }
    if (this.EoR != null) {
      this.EoR.a(this.Ejw);
    }
    AppMethodBeat.o(97947);
  }
  
  public static abstract interface a
  {
    public abstract ArrayList<Exif.a> fTP();
    
    public abstract boolean fTQ();
  }
  
  final class b
  {
    int EpL = 0;
    long GuA = -1L;
    long GuB = -1L;
    int GuC = 0;
    long Guz = -1L;
    int index;
    String jQi = "";
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget
 * JD-Core Version:    0.7.0.1
 */