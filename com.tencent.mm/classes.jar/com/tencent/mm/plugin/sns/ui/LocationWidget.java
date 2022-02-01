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
import com.tencent.mm.k.i;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatLocaleUtil;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LocationWidget
  extends LinearLayout
{
  private d Hji;
  private c.a Kcf;
  private com.tencent.mm.modelgeo.c Khx;
  private b.a MqJ;
  private dgz MqZ;
  private float Mqv;
  private WeImageView Rbm;
  private View ReO;
  private View ReP;
  private int[] ReQ;
  private ImageView[] ReR;
  private int ReS;
  private TextView ReT;
  private String ReU;
  private String ReV;
  private int ReW;
  private float ReX;
  private float ReY;
  private int ReZ;
  private a Rfa;
  private boolean Rfb;
  private b Rfc;
  private String city;
  private byte[] ctx;
  private String hOG;
  private Activity mContext;
  private float oDT;
  private float oDU;
  private boolean oEg;
  private String poiName;
  private int score;
  private int showFlag;
  private TextView ycd;
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97941);
    this.ReQ = new int[] { b.f.score_iv_1, b.f.score_iv_2, b.f.score_iv_3, b.f.score_iv_4, b.f.score_iv_5 };
    this.ReR = new ImageView[5];
    this.oDT = -1000.0F;
    this.oDU = -1000.0F;
    this.ReW = 0;
    this.MqZ = null;
    this.showFlag = 0;
    this.ReX = 0.0F;
    this.Mqv = 0.0F;
    this.ReY = 0.0F;
    this.ReZ = -1;
    this.oEg = true;
    this.Hji = d.bJl();
    this.Rfa = null;
    this.Rfb = false;
    this.Kcf = new c.a()
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
        LocationWidget.a(LocationWidget.this, paramAnonymousAddr.oDK);
        LocationWidget.f(LocationWidget.this);
        AppMethodBeat.o(97938);
      }
    };
    this.MqJ = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(307749);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(307749);
          return true;
        }
        Log.d("MicroMsg.LocationWidget", "get location %f %f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        n.a(2003, paramAnonymousFloat1, paramAnonymousFloat2, 0);
        if (!LocationWidget.e(LocationWidget.this))
        {
          AppMethodBeat.o(307749);
          return false;
        }
        if ((LocationWidget.h(LocationWidget.this) == -1000.0F) || (LocationWidget.i(LocationWidget.this) == -1000.0F))
        {
          LocationWidget.a(LocationWidget.this, paramAnonymousFloat2);
          LocationWidget.b(LocationWidget.this, paramAnonymousFloat1);
        }
        AppMethodBeat.o(307749);
        return false;
      }
    };
    this.Rfc = null;
    s((MMActivity)paramContext);
    AppMethodBeat.o(97941);
  }
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97940);
    this.ReQ = new int[] { b.f.score_iv_1, b.f.score_iv_2, b.f.score_iv_3, b.f.score_iv_4, b.f.score_iv_5 };
    this.ReR = new ImageView[5];
    this.oDT = -1000.0F;
    this.oDU = -1000.0F;
    this.ReW = 0;
    this.MqZ = null;
    this.showFlag = 0;
    this.ReX = 0.0F;
    this.Mqv = 0.0F;
    this.ReY = 0.0F;
    this.ReZ = -1;
    this.oEg = true;
    this.Hji = d.bJl();
    this.Rfa = null;
    this.Rfb = false;
    this.Kcf = new c.a()
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
        LocationWidget.a(LocationWidget.this, paramAnonymousAddr.oDK);
        LocationWidget.f(LocationWidget.this);
        AppMethodBeat.o(97938);
      }
    };
    this.MqJ = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(307749);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(307749);
          return true;
        }
        Log.d("MicroMsg.LocationWidget", "get location %f %f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        n.a(2003, paramAnonymousFloat1, paramAnonymousFloat2, 0);
        if (!LocationWidget.e(LocationWidget.this))
        {
          AppMethodBeat.o(307749);
          return false;
        }
        if ((LocationWidget.h(LocationWidget.this) == -1000.0F) || (LocationWidget.i(LocationWidget.this) == -1000.0F))
        {
          LocationWidget.a(LocationWidget.this, paramAnonymousFloat2);
          LocationWidget.b(LocationWidget.this, paramAnonymousFloat1);
        }
        AppMethodBeat.o(307749);
        return false;
      }
    };
    this.Rfc = null;
    s((MMActivity)paramContext);
    AppMethodBeat.o(97940);
  }
  
  private void bD(ArrayList<Exif.a> paramArrayList)
  {
    AppMethodBeat.i(97945);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(97945);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(11139, "1");
    Exif.a locala1;
    if ((Math.abs(-1000.0F - this.oDT) > 1.0E-006D) && (Math.abs(-1000.0F - this.oDU) > 1.0E-006D))
    {
      locala1 = (Exif.a)paramArrayList.get(paramArrayList.size() - 1);
      if (e(locala1.latitude, locala1.longitude, this.oDT, this.oDU)) {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(11139, "2");
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
      if (e(locala1.latitude, locala1.longitude, locala2.latitude, locala2.longitude)) {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(11139, "3");
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
  
  private static boolean e(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(97946);
    if (t.f(paramDouble1, paramDouble2, paramDouble3, paramDouble4) > 1000.0D)
    {
      AppMethodBeat.o(97946);
      return true;
    }
    AppMethodBeat.o(97946);
    return false;
  }
  
  private void hme()
  {
    int i = 0;
    AppMethodBeat.i(97943);
    Log.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", new Object[] { Integer.valueOf(this.ReS), this.ReV, Integer.valueOf(this.ReW), Integer.valueOf(this.showFlag), Boolean.valueOf(WeChatLocaleUtil.isOverseasUserByWechatLanguage()) });
    if ((WeChatLocaleUtil.isOverseasUserByWechatLanguage()) || (this.ReS == 0) || (Util.isNullOrNil(this.ReV)) || (this.ReW == 1) || ((this.showFlag & 0x1) == 0))
    {
      this.ReP.setVisibility(8);
      AppMethodBeat.o(97943);
      return;
    }
    this.ReP.setVisibility(0);
    while (i < this.score)
    {
      this.ReR[i].setImageResource(getSelectedStarImageResource());
      i += 1;
    }
    i = this.score;
    while (i < 5)
    {
      this.ReR[i].setImageResource(getNormalStarImageResource());
      i += 1;
    }
    AppMethodBeat.o(97943);
  }
  
  private void hmg()
  {
    AppMethodBeat.i(97949);
    if ((this.ReT != null) && (this.ycd != null))
    {
      if (Util.isNullOrNil(this.poiName)) {
        break label107;
      }
      this.ReT.setText(this.poiName);
      this.ReT.setTextColor(getResources().getColor(b.c.green_text_color));
      this.ycd.setVisibility(8);
    }
    while ((!Util.isNullOrNil(this.poiName)) || (!Util.isNullOrNil(this.city)))
    {
      this.Rbm.oR(b.i.album_location_icon_pressed, b.c.wechat_green);
      AppMethodBeat.o(97949);
      return;
      label107:
      if (!Util.isNullOrNil(this.city))
      {
        this.ReT.setText(this.city);
        this.ReT.setTextColor(getResources().getColor(b.c.green_text_color));
        this.ycd.setVisibility(8);
      }
      else
      {
        this.ReT.setText(b.j.sns_location_tips);
        this.ReT.setTextColor(getResources().getColor(b.c.normal_text_color));
        this.ycd.setVisibility(8);
      }
    }
    this.Rbm.oR(b.i.album_location_icon_normal, b.c.icon_color);
    AppMethodBeat.o(97949);
  }
  
  private void hmh()
  {
    AppMethodBeat.i(97952);
    if (this.Rfa != null)
    {
      boolean bool = this.Rfa.hmj();
      Object localObject = this.Rfa.hmi();
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
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
        int j = (int)(locala.latitude * 1000000.0D);
        int k = (int)(locala.longitude * 1000000.0D);
        if (bool) {}
        for (int i = 1;; i = 2)
        {
          localh.b(11345, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(2) });
          break;
        }
      }
    }
    AppMethodBeat.o(97952);
  }
  
  private void s(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97942);
    this.mContext = paramMMActivity;
    View localView = View.inflate(paramMMActivity, getLayoutResource(), this);
    this.ReO = localView.findViewById(b.f.location_contentview);
    this.ReT = ((TextView)this.ReO.findViewById(b.f.location_tips));
    this.ycd = ((TextView)this.ReO.findViewById(b.f.location_poi));
    this.Rbm = ((WeImageView)this.ReO.findViewById(b.f.location_iv));
    this.ReP = localView.findViewById(b.f.score_contentview);
    final int i = 0;
    while (i < 5)
    {
      this.ReR[i] = ((ImageView)this.ReP.findViewById(this.ReQ[i]));
      this.ReR[i].setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97936);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LocationWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    this.Khx = com.tencent.mm.modelgeo.c.bJh();
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97937);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(paramAnonymousView.getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97937);
          return;
        }
        if (com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null)))
        {
          int i;
          if ((com.tencent.mm.pluginsdk.permission.b.s(LocationWidget.d(LocationWidget.this), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.s(LocationWidget.d(LocationWidget.this), "android.permission.ACCESS_COARSE_LOCATION")))
          {
            i = 1;
            if (i != 0) {
              break label306;
            }
            if (((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXn, Boolean.FALSE)).booleanValue()) {
              break label209;
            }
            com.tencent.mm.plugin.account.sdk.c.a.b(LocationWidget.d(LocationWidget.this), LocationWidget.this.getResources().getString(b.j.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
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
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(LocationWidget.d(LocationWidget.this), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 64, null);
          Log.i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97937);
            return;
          }
        }
        label306:
        LocationWidget.this.hmf();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97937);
      }
    });
    this.ReV = paramMMActivity.getIntent().getStringExtra("kpoi_id");
    if (!Util.isNullOrNil(this.ReV))
    {
      this.oDT = paramMMActivity.getIntent().getFloatExtra("k_lat", -1000.0F);
      this.oDU = paramMMActivity.getIntent().getFloatExtra("k_lng", -1000.0F);
      this.poiName = paramMMActivity.getIntent().getStringExtra("kpoi_name");
      this.ReU = paramMMActivity.getIntent().getStringExtra("Kpoi_address");
      hmg();
    }
    if (com.tencent.mm.kernel.h.baC().aZN()) {}
    for (this.ReS = Util.getInt(i.aRC().getValue("SnsPostPOICommentSwitch"), 0);; this.ReS = 0)
    {
      hme();
      AppMethodBeat.o(97942);
      return;
    }
  }
  
  public final boolean by(Intent paramIntent)
  {
    AppMethodBeat.i(97948);
    if (paramIntent == null)
    {
      AppMethodBeat.o(97948);
      return true;
    }
    this.ReW = paramIntent.getIntExtra("get_poi_classify_type", 0);
    this.showFlag = paramIntent.getIntExtra("get_poi_showflag", 0);
    Log.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", new Object[] { Integer.valueOf(this.ReW) });
    this.poiName = Util.nullAs(paramIntent.getStringExtra("get_poi_name"), "");
    this.city = Util.nullAs(paramIntent.getStringExtra("get_city"), "");
    this.oDT = paramIntent.getFloatExtra("get_lat", -1000.0F);
    this.oDU = paramIntent.getFloatExtra("get_lng", -1000.0F);
    Log.i("MicroMsg.LocationWidget", "check cur lat " + this.ReX + " " + this.Mqv);
    this.ReX = paramIntent.getFloatExtra("get_cur_lat", 0.0F);
    this.Mqv = paramIntent.getFloatExtra("get_cur_lng", 0.0F);
    this.ReZ = paramIntent.getIntExtra("get_loctype", -1);
    this.ReY = paramIntent.getFloatExtra("get_accuracy", 0.0F);
    this.oEg = paramIntent.getBooleanExtra("get_is_mars", true);
    this.hOG = paramIntent.getStringExtra("request_id");
    this.ctx = paramIntent.getByteArrayExtra("location_ctx");
    if (!Util.isNullOrNil(this.poiName))
    {
      this.ReU = Util.nullAs(paramIntent.getStringExtra("get_poi_address"), "");
      this.ReV = Util.nullAs(paramIntent.getStringExtra("get_poi_classify_id"), "");
      this.MqZ = new dgz();
    }
    for (;;)
    {
      try
      {
        this.MqZ = ((dgz)this.MqZ.parseFrom(paramIntent.getByteArrayExtra("get_poi_item_buf")));
        if (!Util.isNullOrNil(this.ReV))
        {
          this.MqZ = new dgz();
          this.MqZ.MpI = this.ReV;
          this.MqZ.vhJ = this.ReW;
          this.MqZ.hAP = this.poiName;
          this.MqZ.MpN.add(new etl().btH(this.ReU));
        }
        Log.d("MicroMsg.LocationWidget", "label %s poiname %s", new Object[] { this.ReU, this.poiName });
        hmg();
        hme();
        this.Rfc = new b();
        b localb = this.Rfc;
        if (paramIntent != null)
        {
          localb.index = paramIntent.getIntExtra("report_index", -1);
          localb.Mqy = paramIntent.getLongExtra("first_start_time", 0L);
          localb.Mqz = paramIntent.getLongExtra("lastSuccStamp", 0L);
          localb.MqA = paramIntent.getLongExtra("firstSuccStamp", 0L);
          localb.MqB = paramIntent.getIntExtra("reqLoadCnt", 0);
          localb.Kis = paramIntent.getIntExtra("entry_time", 0);
          localb.mpa = paramIntent.getStringExtra("search_id");
        }
        AppMethodBeat.o(97948);
        return true;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        this.MqZ = null;
        continue;
      }
      if (!Util.isNullOrNil(this.city))
      {
        this.poiName = "";
        this.ReU = "";
        this.ReV = "";
        this.MqZ = null;
      }
      else
      {
        this.oDT = -1000.0F;
        this.oDU = -1000.0F;
        this.poiName = "";
        this.ReU = "";
        this.city = "";
        this.ReV = "";
        this.MqZ = null;
      }
    }
  }
  
  public djv getCurLocation()
  {
    AppMethodBeat.i(97951);
    djv localdjv = new djv();
    localdjv.ZaH = this.ReX;
    localdjv.ZaG = this.Mqv;
    localdjv.ReY = this.ReY;
    localdjv.ReZ = this.ReZ;
    AppMethodBeat.o(97951);
    return localdjv;
  }
  
  protected int getLayoutResource()
  {
    return b.g.location_widget;
  }
  
  public djv getLocation()
  {
    AppMethodBeat.i(97950);
    djv localdjv = new djv();
    localdjv.ZaH = this.oDT;
    localdjv.ZaG = this.oDU;
    localdjv.aaPO = 0;
    localdjv.score = this.score;
    if (this.ctx != null) {
      localdjv.aaPP = new com.tencent.mm.bx.b(this.ctx);
    }
    if (!Util.isNullOrNil(this.poiName))
    {
      localdjv.ReU = this.ReU;
      localdjv.poiName = this.poiName;
      localdjv.ZWG = this.ReV;
      localdjv.pSh = this.city;
      if ((this.ReW != 0) && (this.ReW == 1))
      {
        localdjv.ReW = 2;
        Log.d("MicroMsg.LocationWidget", "getlocation type %d", new Object[] { Integer.valueOf(localdjv.ReW) });
      }
    }
    for (;;)
    {
      if (this.Rfc != null)
      {
        String str = String.format("%f/%f", new Object[] { Float.valueOf(localdjv.ZaH), Float.valueOf(localdjv.ZaG) });
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("index " + this.Rfc.index);
        localStringBuffer.append("firstStartStamp " + this.Rfc.Mqy);
        localStringBuffer.append("lastSuccStamp " + this.Rfc.MqA);
        localStringBuffer.append("firstSuccStamp " + this.Rfc.Mqz);
        localStringBuffer.append("reqLoadCnt " + this.Rfc.MqB);
        localStringBuffer.append("classifyId " + this.ReV);
        localStringBuffer.append("entryTime " + this.Rfc.Kis);
        localStringBuffer.append("searchId" + this.Rfc.mpa);
        Log.d("MicroMsg.LocationWidget", "report %s", new Object[] { localStringBuffer.toString() });
        com.tencent.mm.plugin.report.service.h.OAn.b(11135, new Object[] { Integer.valueOf(5), Integer.valueOf(this.Rfc.index + 1), Long.valueOf(this.Rfc.Mqy), Long.valueOf(this.Rfc.MqA), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.Rfc.Mqz), Integer.valueOf(this.Rfc.MqB), str, this.ReV, Integer.valueOf(this.Rfc.Kis), this.Rfc.mpa, q.eD(true) });
      }
      hmh();
      AppMethodBeat.o(97950);
      return localdjv;
      localdjv.ReW = 1;
      break;
      if (!Util.isNullOrNil(this.city)) {
        localdjv.pSh = this.city;
      }
    }
  }
  
  protected int getNormalStarImageResource()
  {
    return b.i.sns_shoot_star_normal;
  }
  
  protected int getNormalStateImageResource()
  {
    return b.i.album_location_icon_normal;
  }
  
  protected int getSelectedStarImageResource()
  {
    return b.i.sns_shoot_star_selected;
  }
  
  protected int getSelectedStateImageResource()
  {
    return b.i.album_location_icon_pressed;
  }
  
  public int getShowFlag()
  {
    return this.showFlag;
  }
  
  public final void hmf()
  {
    AppMethodBeat.i(97944);
    Intent localIntent = new Intent();
    localIntent.putExtra("near_life_scene", 1);
    try
    {
      localIntent.putExtra("get_poi_item_buf", this.MqZ.toByteArray());
      if (!Util.isNullOrNil(this.ReV))
      {
        localIntent.putExtra("get_poi_classify_id", this.ReV);
        localIntent.putExtra("get_lat", this.oDT);
        localIntent.putExtra("get_lng", this.oDU);
        localIntent.putExtra("request_id", this.hOG);
        if (this.Rfa == null) {
          break label237;
        }
        Object localObject = this.Rfa.hmi();
        if (localObject == null) {
          break label237;
        }
        bD((ArrayList)localObject);
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
      com.tencent.mm.br.c.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 10);
      l.kK(12, 10);
      AppMethodBeat.o(97944);
    }
  }
  
  public void setLocationWidgetListener(a parama)
  {
    this.Rfa = parama;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(97947);
    if (this.Hji != null) {
      this.Hji.a(this.MqJ);
    }
    if (this.Khx != null) {
      this.Khx.a(this.Kcf);
    }
    AppMethodBeat.o(97947);
  }
  
  public static abstract interface a
  {
    public abstract ArrayList<Exif.a> hmi();
    
    public abstract boolean hmj();
  }
  
  final class b
  {
    int Kis = 0;
    long MqA = -1L;
    int MqB = 0;
    long Mqy = -1L;
    long Mqz = -1L;
    int index;
    String mpa = "";
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget
 * JD-Core Version:    0.7.0.1
 */