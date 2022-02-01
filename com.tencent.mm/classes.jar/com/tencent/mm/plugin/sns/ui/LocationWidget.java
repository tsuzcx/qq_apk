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
import com.tencent.mm.protocal.protobuf.buf;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LocationWidget
  extends LinearLayout
{
  private ImageView AfZ;
  private TextView Ahm;
  private View Ajk;
  private View Ajl;
  private int[] Ajm;
  private ImageView[] Ajn;
  private int Ajo;
  private TextView Ajp;
  private byte[] Ajq;
  private String Ajr;
  private String Ajs;
  private int Ajt;
  private float Aju;
  private int Ajv;
  private a Ajw;
  private boolean Ajx;
  private b Ajy;
  private float bYG;
  private String dyb;
  private int eQZ;
  private String eRg;
  private float iab;
  private float iac;
  private boolean iam;
  private String jGd;
  private Activity keK;
  private int score;
  private c.a vlL;
  private c vri;
  private buf wGO;
  private com.tencent.mm.modelgeo.d wGe;
  private float wGk;
  private b.a wGy;
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97941);
    this.Ajm = new int[] { 2131304356, 2131304357, 2131304358, 2131304359, 2131304360 };
    this.Ajn = new ImageView[5];
    this.iab = -1000.0F;
    this.iac = -1000.0F;
    this.Ajt = 0;
    this.wGO = null;
    this.eQZ = 0;
    this.Aju = 0.0F;
    this.wGk = 0.0F;
    this.bYG = 0.0F;
    this.Ajv = -1;
    this.iam = true;
    this.wGe = com.tencent.mm.modelgeo.d.aIh();
    this.Ajw = null;
    this.Ajx = false;
    this.vlL = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(97938);
        ae.i("MicroMsg.LocationWidget", "get info %s", new Object[] { paramAnonymousAddr.toString() });
        if (!LocationWidget.e(LocationWidget.this))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.f(LocationWidget.this);
        if (!bu.isNullOrNil(LocationWidget.g(LocationWidget.this)))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.a(LocationWidget.this, paramAnonymousAddr.hZS);
        LocationWidget.f(LocationWidget.this);
        AppMethodBeat.o(97938);
      }
    };
    this.wGy = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(97939);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(97939);
          return true;
        }
        ae.d("MicroMsg.LocationWidget", "get location %f %f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.aMb();
        if (paramAnonymousInt == 0)
        {
          paramAnonymousBoolean = false;
          if (LocationWidget.h(LocationWidget.this) != null) {
            break label113;
          }
        }
        label113:
        for (boolean bool = false;; bool = LocationWidget.h(LocationWidget.this).iam)
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
    this.Ajy = null;
    n((MMActivity)paramContext);
    AppMethodBeat.o(97941);
  }
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97940);
    this.Ajm = new int[] { 2131304356, 2131304357, 2131304358, 2131304359, 2131304360 };
    this.Ajn = new ImageView[5];
    this.iab = -1000.0F;
    this.iac = -1000.0F;
    this.Ajt = 0;
    this.wGO = null;
    this.eQZ = 0;
    this.Aju = 0.0F;
    this.wGk = 0.0F;
    this.bYG = 0.0F;
    this.Ajv = -1;
    this.iam = true;
    this.wGe = com.tencent.mm.modelgeo.d.aIh();
    this.Ajw = null;
    this.Ajx = false;
    this.vlL = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(97938);
        ae.i("MicroMsg.LocationWidget", "get info %s", new Object[] { paramAnonymousAddr.toString() });
        if (!LocationWidget.e(LocationWidget.this))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.f(LocationWidget.this);
        if (!bu.isNullOrNil(LocationWidget.g(LocationWidget.this)))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.a(LocationWidget.this, paramAnonymousAddr.hZS);
        LocationWidget.f(LocationWidget.this);
        AppMethodBeat.o(97938);
      }
    };
    this.wGy = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(97939);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(97939);
          return true;
        }
        ae.d("MicroMsg.LocationWidget", "get location %f %f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.aMb();
        if (paramAnonymousInt == 0)
        {
          paramAnonymousBoolean = false;
          if (LocationWidget.h(LocationWidget.this) != null) {
            break label113;
          }
        }
        label113:
        for (boolean bool = false;; bool = LocationWidget.h(LocationWidget.this).iam)
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
    this.Ajy = null;
    n((MMActivity)paramContext);
    AppMethodBeat.o(97940);
  }
  
  private void ay(ArrayList<Exif.a> paramArrayList)
  {
    AppMethodBeat.i(97945);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(97945);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(11139, "1");
    Exif.a locala1;
    if ((Math.abs(-1000.0F - this.iab) > 1.0E-006D) && (Math.abs(-1000.0F - this.iac) > 1.0E-006D))
    {
      locala1 = (Exif.a)paramArrayList.get(paramArrayList.size() - 1);
      if (b(locala1.latitude, locala1.longitude, this.iab, this.iac)) {
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(11139, "2");
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
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(11139, "3");
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
  
  private void edw()
  {
    int i = 0;
    AppMethodBeat.i(97943);
    ae.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", new Object[] { Integer.valueOf(this.Ajo), this.Ajs, Integer.valueOf(this.Ajt), Integer.valueOf(this.eQZ), Boolean.valueOf(bw.fpV()) });
    if ((bw.fpV()) || (this.Ajo == 0) || (bu.isNullOrNil(this.Ajs)) || (this.Ajt == 1) || ((this.eQZ & 0x1) == 0))
    {
      this.Ajl.setVisibility(8);
      AppMethodBeat.o(97943);
      return;
    }
    this.Ajl.setVisibility(0);
    while (i < this.score)
    {
      this.Ajn[i].setImageResource(getSelectedStarImageResource());
      i += 1;
    }
    i = this.score;
    while (i < 5)
    {
      this.Ajn[i].setImageResource(getNormalStarImageResource());
      i += 1;
    }
    AppMethodBeat.o(97943);
  }
  
  private void edy()
  {
    AppMethodBeat.i(97949);
    if ((this.Ajp != null) && (this.Ahm != null))
    {
      if (bu.isNullOrNil(this.jGd)) {
        break label124;
      }
      this.Ajp.setText(this.jGd);
      this.Ajp.setTextColor(getResources().getColor(2131100464));
      this.Ahm.setVisibility(8);
    }
    while ((!bu.isNullOrNil(this.jGd)) || (!bu.isNullOrNil(this.eRg)))
    {
      this.AfZ.setImageDrawable(ao.k(this.keK, 2131689533, getContext().getResources().getColor(2131101171)));
      AppMethodBeat.o(97949);
      return;
      label124:
      if (!bu.isNullOrNil(this.eRg))
      {
        this.Ajp.setText(this.eRg);
        this.Ajp.setTextColor(getResources().getColor(2131100464));
        this.Ahm.setVisibility(8);
      }
      else
      {
        this.Ajp.setText(2131763887);
        this.Ajp.setTextColor(getResources().getColor(2131100711));
        this.Ahm.setVisibility(8);
      }
    }
    this.AfZ.setImageDrawable(ao.k(this.keK, 2131689532, getContext().getResources().getColor(2131100499)));
    AppMethodBeat.o(97949);
  }
  
  private void edz()
  {
    AppMethodBeat.i(97952);
    if (this.Ajw != null)
    {
      boolean bool = this.Ajw.edB();
      Object localObject = this.Ajw.edA();
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        AppMethodBeat.o(97952);
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        Exif.a locala = (Exif.a)((Iterator)localObject).next();
        ae.d("MicroMsg.LocationWidget", "snsreport lat lng %f, %f", new Object[] { Double.valueOf(locala.latitude), Double.valueOf(locala.longitude) });
        com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
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
    this.keK = paramMMActivity;
    View localView = View.inflate(paramMMActivity, getLayoutResource(), this);
    this.Ajk = localView.findViewById(2131301522);
    this.Ajp = ((TextView)this.Ajk.findViewById(2131301545));
    this.Ahm = ((TextView)this.Ajk.findViewById(2131301535));
    this.AfZ = ((ImageView)this.Ajk.findViewById(2131301530));
    this.Ajl = localView.findViewById(2131304354);
    final int i = 0;
    while (i < 5)
    {
      this.Ajn[i] = ((ImageView)this.Ajl.findViewById(this.Ajm[i]));
      this.Ajn[i].setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97936);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LocationWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    this.vri = c.aIe();
    this.Ajk.setOnClickListener(new LocationWidget.2(this));
    this.Ajs = paramMMActivity.getIntent().getStringExtra("kpoi_id");
    if (!bu.isNullOrNil(this.Ajs))
    {
      this.iab = paramMMActivity.getIntent().getFloatExtra("k_lat", -1000.0F);
      this.iac = paramMMActivity.getIntent().getFloatExtra("k_lng", -1000.0F);
      this.jGd = paramMMActivity.getIntent().getStringExtra("kpoi_name");
      this.Ajr = paramMMActivity.getIntent().getStringExtra("Kpoi_address");
      edy();
    }
    if (com.tencent.mm.kernel.g.ajP().aiZ()) {}
    for (this.Ajo = bu.getInt(com.tencent.mm.n.g.acL().getValue("SnsPostPOICommentSwitch"), 0);; this.Ajo = 0)
    {
      edw();
      AppMethodBeat.o(97942);
      return;
    }
  }
  
  public final boolean aO(Intent paramIntent)
  {
    AppMethodBeat.i(97948);
    if (paramIntent == null)
    {
      AppMethodBeat.o(97948);
      return true;
    }
    this.Ajt = paramIntent.getIntExtra("get_poi_classify_type", 0);
    this.eQZ = paramIntent.getIntExtra("get_poi_showflag", 0);
    ae.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", new Object[] { Integer.valueOf(this.Ajt) });
    this.jGd = bu.bI(paramIntent.getStringExtra("get_poi_name"), "");
    this.eRg = bu.bI(paramIntent.getStringExtra("get_city"), "");
    this.iab = paramIntent.getFloatExtra("get_lat", -1000.0F);
    this.iac = paramIntent.getFloatExtra("get_lng", -1000.0F);
    ae.i("MicroMsg.LocationWidget", "check cur lat " + this.Aju + " " + this.wGk);
    this.Aju = paramIntent.getFloatExtra("get_cur_lat", 0.0F);
    this.wGk = paramIntent.getFloatExtra("get_cur_lng", 0.0F);
    this.Ajv = paramIntent.getIntExtra("get_loctype", -1);
    this.bYG = paramIntent.getFloatExtra("get_accuracy", 0.0F);
    this.iam = paramIntent.getBooleanExtra("get_is_mars", true);
    this.dyb = paramIntent.getStringExtra("request_id");
    Object localObject = com.tencent.mm.modelstat.e.aMb();
    boolean bool;
    if (this.Ajv == 0)
    {
      bool = false;
      ((com.tencent.mm.modelstat.e)localObject).a(2003, bool, this.iam, this.iac, this.iab, (int)this.bYG);
      this.Ajq = paramIntent.getByteArrayExtra("location_ctx");
      if (bu.isNullOrNil(this.jGd)) {
        break label610;
      }
      this.Ajr = bu.bI(paramIntent.getStringExtra("get_poi_address"), "");
      this.Ajs = bu.bI(paramIntent.getStringExtra("get_poi_classify_id"), "");
      this.wGO = new buf();
    }
    for (;;)
    {
      try
      {
        this.wGO = ((buf)this.wGO.parseFrom(paramIntent.getByteArrayExtra("get_poi_item_buf")));
        if (!bu.isNullOrNil(this.Ajs))
        {
          this.wGO = new buf();
          this.wGO.wFv = this.Ajs;
          this.wGO.nJA = this.Ajt;
          this.wGO.Title = this.jGd;
          this.wGO.wFA.add(new cxn().aQV(this.Ajr));
        }
        ae.d("MicroMsg.LocationWidget", "label %s poiname %s", new Object[] { this.Ajr, this.jGd });
        edy();
        edw();
        this.Ajy = new b();
        localObject = this.Ajy;
        if (paramIntent != null)
        {
          ((b)localObject).index = paramIntent.getIntExtra("report_index", -1);
          ((b)localObject).wGn = paramIntent.getLongExtra("first_start_time", 0L);
          ((b)localObject).wGo = paramIntent.getLongExtra("lastSuccStamp", 0L);
          ((b)localObject).wGp = paramIntent.getLongExtra("firstSuccStamp", 0L);
          ((b)localObject).wGq = paramIntent.getIntExtra("reqLoadCnt", 0);
          ((b)localObject).vse = paramIntent.getIntExtra("entry_time", 0);
          ((b)localObject).kid = paramIntent.getStringExtra("search_id");
        }
        AppMethodBeat.o(97948);
        return true;
        bool = true;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        this.wGO = null;
        continue;
      }
      label610:
      if (!bu.isNullOrNil(this.eRg))
      {
        this.jGd = "";
        this.Ajr = "";
        this.Ajs = "";
        this.wGO = null;
      }
      else
      {
        this.iab = -1000.0F;
        this.iac = -1000.0F;
        this.jGd = "";
        this.Ajr = "";
        this.eRg = "";
        this.Ajs = "";
        this.wGO = null;
      }
    }
  }
  
  public final void edx()
  {
    AppMethodBeat.i(97944);
    Intent localIntent = new Intent();
    localIntent.putExtra("near_life_scene", 1);
    try
    {
      localIntent.putExtra("get_poi_item_buf", this.wGO.toByteArray());
      if (!bu.isNullOrNil(this.Ajs))
      {
        localIntent.putExtra("get_poi_classify_id", this.Ajs);
        localIntent.putExtra("get_lat", this.iab);
        localIntent.putExtra("get_lng", this.iac);
        localIntent.putExtra("request_id", this.dyb);
        if (this.Ajw == null) {
          break label237;
        }
        Object localObject = this.Ajw.edA();
        if (localObject == null) {
          break label237;
        }
        ay((ArrayList)localObject);
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
        ae.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        continue;
        if (!bu.isNullOrNil(this.eRg)) {
          localIntent.putExtra("get_city", this.eRg);
        }
      }
      label237:
      com.tencent.mm.br.d.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 10);
      AppMethodBeat.o(97944);
    }
  }
  
  public bwk getCurLocation()
  {
    AppMethodBeat.i(97951);
    bwk localbwk = new bwk();
    localbwk.Gha = this.Aju;
    localbwk.GgZ = this.wGk;
    localbwk.bYG = this.bYG;
    localbwk.Ajv = this.Ajv;
    AppMethodBeat.o(97951);
    return localbwk;
  }
  
  protected int getLayoutResource()
  {
    return 2131494601;
  }
  
  public bwk getLocation()
  {
    AppMethodBeat.i(97950);
    bwk localbwk = new bwk();
    localbwk.Gha = this.iab;
    localbwk.GgZ = this.iac;
    localbwk.Hjs = 0;
    localbwk.score = this.score;
    if (this.Ajq != null) {
      localbwk.Hjt = new com.tencent.mm.bw.b(this.Ajq);
    }
    if (!bu.isNullOrNil(this.jGd))
    {
      localbwk.Ajr = this.Ajr;
      localbwk.jGd = this.jGd;
      localbwk.GGA = this.Ajs;
      localbwk.jfX = this.eRg;
      if ((this.Ajt != 0) && (this.Ajt == 1))
      {
        localbwk.Ajt = 2;
        ae.d("MicroMsg.LocationWidget", "getlocation type %d", new Object[] { Integer.valueOf(localbwk.Ajt) });
      }
    }
    for (;;)
    {
      if (this.Ajy != null)
      {
        String str = String.format("%f/%f", new Object[] { Float.valueOf(localbwk.Gha), Float.valueOf(localbwk.GgZ) });
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("index " + this.Ajy.index);
        localStringBuffer.append("firstStartStamp " + this.Ajy.wGn);
        localStringBuffer.append("lastSuccStamp " + this.Ajy.wGp);
        localStringBuffer.append("firstSuccStamp " + this.Ajy.wGo);
        localStringBuffer.append("reqLoadCnt " + this.Ajy.wGq);
        localStringBuffer.append("classifyId " + this.Ajs);
        localStringBuffer.append("entryTime " + this.Ajy.vse);
        localStringBuffer.append("searchId" + this.Ajy.kid);
        ae.d("MicroMsg.LocationWidget", "report %s", new Object[] { localStringBuffer.toString() });
        com.tencent.mm.plugin.report.service.g.yxI.f(11135, new Object[] { Integer.valueOf(5), Integer.valueOf(this.Ajy.index + 1), Long.valueOf(this.Ajy.wGn), Long.valueOf(this.Ajy.wGp), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.Ajy.wGo), Integer.valueOf(this.Ajy.wGq), str, this.Ajs, Integer.valueOf(this.Ajy.vse), this.Ajy.kid, q.cH(true) });
      }
      edz();
      AppMethodBeat.o(97950);
      return localbwk;
      localbwk.Ajt = 1;
      break;
      if (!bu.isNullOrNil(this.eRg)) {
        localbwk.jfX = this.eRg;
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
    return this.eQZ;
  }
  
  public void setLocationWidgetListener(a parama)
  {
    this.Ajw = parama;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(97947);
    if (this.wGe != null) {
      this.wGe.c(this.wGy);
    }
    if (this.vri != null) {
      this.vri.a(this.vlL);
    }
    AppMethodBeat.o(97947);
  }
  
  public static abstract interface a
  {
    public abstract ArrayList<Exif.a> edA();
    
    public abstract boolean edB();
  }
  
  final class b
  {
    int index;
    String kid = "";
    int vse = 0;
    long wGn = -1L;
    long wGo = -1L;
    long wGp = -1L;
    int wGq = 0;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget
 * JD-Core Version:    0.7.0.1
 */