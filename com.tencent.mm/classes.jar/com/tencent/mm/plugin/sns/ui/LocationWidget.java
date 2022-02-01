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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LocationWidget
  extends LinearLayout
{
  private float bOt;
  private String dlj;
  private int exP;
  private String exW;
  private String gPy;
  private float hEE;
  private float hEF;
  private boolean hEP;
  private Activity jHh;
  private int score;
  private c.a tWR;
  private c ucr;
  private boy vlN;
  private com.tencent.mm.modelgeo.d vld;
  private float vlj;
  private b.a vlx;
  private View yAO;
  private View yAP;
  private int[] yAQ;
  private ImageView[] yAR;
  private int yAS;
  private TextView yAT;
  private byte[] yAU;
  private String yAV;
  private String yAW;
  private int yAX;
  private float yAY;
  private int yAZ;
  private a yBa;
  private boolean yBb;
  private b yBc;
  private ImageView yxG;
  private TextView yyT;
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97941);
    this.yAQ = new int[] { 2131304356, 2131304357, 2131304358, 2131304359, 2131304360 };
    this.yAR = new ImageView[5];
    this.hEE = -1000.0F;
    this.hEF = -1000.0F;
    this.yAX = 0;
    this.vlN = null;
    this.exP = 0;
    this.yAY = 0.0F;
    this.vlj = 0.0F;
    this.bOt = 0.0F;
    this.yAZ = -1;
    this.hEP = true;
    this.vld = com.tencent.mm.modelgeo.d.aEL();
    this.yBa = null;
    this.yBb = false;
    this.tWR = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(97938);
        ac.i("MicroMsg.LocationWidget", "get info %s", new Object[] { paramAnonymousAddr.toString() });
        if (!LocationWidget.e(LocationWidget.this))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.f(LocationWidget.this);
        if (!bs.isNullOrNil(LocationWidget.g(LocationWidget.this)))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.a(LocationWidget.this, paramAnonymousAddr.hEv);
        LocationWidget.f(LocationWidget.this);
        AppMethodBeat.o(97938);
      }
    };
    this.vlx = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(97939);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(97939);
          return true;
        }
        ac.d("MicroMsg.LocationWidget", "get location %f %f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.aIu();
        if (paramAnonymousInt == 0)
        {
          paramAnonymousBoolean = false;
          if (LocationWidget.h(LocationWidget.this) != null) {
            break label113;
          }
        }
        label113:
        for (boolean bool = false;; bool = LocationWidget.h(LocationWidget.this).hEP)
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
    this.yBc = null;
    l((MMActivity)paramContext);
    AppMethodBeat.o(97941);
  }
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97940);
    this.yAQ = new int[] { 2131304356, 2131304357, 2131304358, 2131304359, 2131304360 };
    this.yAR = new ImageView[5];
    this.hEE = -1000.0F;
    this.hEF = -1000.0F;
    this.yAX = 0;
    this.vlN = null;
    this.exP = 0;
    this.yAY = 0.0F;
    this.vlj = 0.0F;
    this.bOt = 0.0F;
    this.yAZ = -1;
    this.hEP = true;
    this.vld = com.tencent.mm.modelgeo.d.aEL();
    this.yBa = null;
    this.yBb = false;
    this.tWR = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(97938);
        ac.i("MicroMsg.LocationWidget", "get info %s", new Object[] { paramAnonymousAddr.toString() });
        if (!LocationWidget.e(LocationWidget.this))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.f(LocationWidget.this);
        if (!bs.isNullOrNil(LocationWidget.g(LocationWidget.this)))
        {
          AppMethodBeat.o(97938);
          return;
        }
        LocationWidget.a(LocationWidget.this, paramAnonymousAddr.hEv);
        LocationWidget.f(LocationWidget.this);
        AppMethodBeat.o(97938);
      }
    };
    this.vlx = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(97939);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(97939);
          return true;
        }
        ac.d("MicroMsg.LocationWidget", "get location %f %f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.aIu();
        if (paramAnonymousInt == 0)
        {
          paramAnonymousBoolean = false;
          if (LocationWidget.h(LocationWidget.this) != null) {
            break label113;
          }
        }
        label113:
        for (boolean bool = false;; bool = LocationWidget.h(LocationWidget.this).hEP)
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
    this.yBc = null;
    l((MMActivity)paramContext);
    AppMethodBeat.o(97940);
  }
  
  private void az(ArrayList<Exif.a> paramArrayList)
  {
    AppMethodBeat.i(97945);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(97945);
      return;
    }
    h.wUl.kvStat(11139, "1");
    Exif.a locala1;
    if ((Math.abs(-1000.0F - this.hEE) > 1.0E-006D) && (Math.abs(-1000.0F - this.hEF) > 1.0E-006D))
    {
      locala1 = (Exif.a)paramArrayList.get(paramArrayList.size() - 1);
      if (b(locala1.latitude, locala1.longitude, this.hEE, this.hEF)) {
        h.wUl.kvStat(11139, "2");
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
        h.wUl.kvStat(11139, "3");
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
    if (r.c(paramDouble1, paramDouble2, paramDouble3, paramDouble4) > 1000.0D)
    {
      AppMethodBeat.o(97946);
      return true;
    }
    AppMethodBeat.o(97946);
    return false;
  }
  
  private void dNB()
  {
    int i = 0;
    AppMethodBeat.i(97943);
    ac.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", new Object[] { Integer.valueOf(this.yAS), this.yAW, Integer.valueOf(this.yAX), Integer.valueOf(this.exP), Boolean.valueOf(bu.eWq()) });
    if ((bu.eWq()) || (this.yAS == 0) || (bs.isNullOrNil(this.yAW)) || (this.yAX == 1) || ((this.exP & 0x1) == 0))
    {
      this.yAP.setVisibility(8);
      AppMethodBeat.o(97943);
      return;
    }
    this.yAP.setVisibility(0);
    while (i < this.score)
    {
      this.yAR[i].setImageResource(getSelectedStarImageResource());
      i += 1;
    }
    i = this.score;
    while (i < 5)
    {
      this.yAR[i].setImageResource(getNormalStarImageResource());
      i += 1;
    }
    AppMethodBeat.o(97943);
  }
  
  private void dND()
  {
    AppMethodBeat.i(97949);
    if ((this.yAT != null) && (this.yyT != null))
    {
      if (bs.isNullOrNil(this.gPy)) {
        break label124;
      }
      this.yAT.setText(this.gPy);
      this.yAT.setTextColor(getResources().getColor(2131100464));
      this.yyT.setVisibility(8);
    }
    while ((!bs.isNullOrNil(this.gPy)) || (!bs.isNullOrNil(this.exW)))
    {
      this.yxG.setImageDrawable(am.k(this.jHh, 2131689533, getContext().getResources().getColor(2131101171)));
      AppMethodBeat.o(97949);
      return;
      label124:
      if (!bs.isNullOrNil(this.exW))
      {
        this.yAT.setText(this.exW);
        this.yAT.setTextColor(getResources().getColor(2131100464));
        this.yyT.setVisibility(8);
      }
      else
      {
        this.yAT.setText(2131763887);
        this.yAT.setTextColor(getResources().getColor(2131100711));
        this.yyT.setVisibility(8);
      }
    }
    this.yxG.setImageDrawable(am.k(this.jHh, 2131689532, getContext().getResources().getColor(2131100499)));
    AppMethodBeat.o(97949);
  }
  
  private void dNE()
  {
    AppMethodBeat.i(97952);
    if (this.yBa != null)
    {
      boolean bool = this.yBa.dNG();
      Object localObject = this.yBa.dNF();
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        AppMethodBeat.o(97952);
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        Exif.a locala = (Exif.a)((Iterator)localObject).next();
        ac.d("MicroMsg.LocationWidget", "snsreport lat lng %f, %f", new Object[] { Double.valueOf(locala.latitude), Double.valueOf(locala.longitude) });
        h localh = h.wUl;
        int j = (int)(locala.latitude * 1000000.0D);
        int k = (int)(locala.longitude * 1000000.0D);
        if (bool) {}
        for (int i = 1;; i = 2)
        {
          localh.f(11345, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(2) });
          break;
        }
      }
    }
    AppMethodBeat.o(97952);
  }
  
  private void l(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97942);
    this.jHh = paramMMActivity;
    View localView = View.inflate(paramMMActivity, getLayoutResource(), this);
    this.yAO = localView.findViewById(2131301522);
    this.yAT = ((TextView)this.yAO.findViewById(2131301545));
    this.yyT = ((TextView)this.yAO.findViewById(2131301535));
    this.yxG = ((ImageView)this.yAO.findViewById(2131301530));
    this.yAP = localView.findViewById(2131304354);
    final int i = 0;
    while (i < 5)
    {
      this.yAR[i] = ((ImageView)this.yAP.findViewById(this.yAQ[i]));
      this.yAR[i].setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97936);
          if (LocationWidget.a(LocationWidget.this) == i + 1) {
            LocationWidget.b(LocationWidget.this);
          }
          for (;;)
          {
            LocationWidget.c(LocationWidget.this);
            AppMethodBeat.o(97936);
            return;
            LocationWidget.a(LocationWidget.this, i + 1);
          }
        }
      });
      i += 1;
    }
    this.ucr = c.aEI();
    this.yAO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97937);
        if (com.tencent.mm.aw.b.CQ((String)com.tencent.mm.kernel.g.agR().agA().get(274436, null)))
        {
          if (!com.tencent.mm.pluginsdk.permission.b.o(LocationWidget.d(LocationWidget.this), "android.permission.ACCESS_COARSE_LOCATION"))
          {
            if (!((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRN, Boolean.FALSE)).booleanValue())
            {
              com.tencent.mm.plugin.account.a.b.a.b(LocationWidget.d(LocationWidget.this), LocationWidget.this.getResources().getString(2131760740, new Object[] { ab.eUO() }), 30764, true);
              AppMethodBeat.o(97937);
              return;
            }
            com.tencent.mm.pluginsdk.permission.b.b(LocationWidget.d(LocationWidget.this), "android.permission.ACCESS_COARSE_LOCATION", 64);
            AppMethodBeat.o(97937);
          }
        }
        else
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(LocationWidget.d(LocationWidget.this), "android.permission.ACCESS_COARSE_LOCATION", 64, "", "");
          ac.i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool)
          {
            AppMethodBeat.o(97937);
            return;
          }
        }
        LocationWidget.this.dNC();
        AppMethodBeat.o(97937);
      }
    });
    this.yAW = paramMMActivity.getIntent().getStringExtra("kpoi_id");
    if (!bs.isNullOrNil(this.yAW))
    {
      this.hEE = paramMMActivity.getIntent().getFloatExtra("k_lat", -1000.0F);
      this.hEF = paramMMActivity.getIntent().getFloatExtra("k_lng", -1000.0F);
      this.gPy = paramMMActivity.getIntent().getStringExtra("kpoi_name");
      this.yAV = paramMMActivity.getIntent().getStringExtra("Kpoi_address");
      dND();
    }
    if (com.tencent.mm.kernel.g.agP().afY()) {}
    for (this.yAS = bs.getInt(com.tencent.mm.m.g.ZY().getValue("SnsPostPOICommentSwitch"), 0);; this.yAS = 0)
    {
      dNB();
      AppMethodBeat.o(97942);
      return;
    }
  }
  
  public final boolean aI(Intent paramIntent)
  {
    AppMethodBeat.i(97948);
    if (paramIntent == null)
    {
      AppMethodBeat.o(97948);
      return true;
    }
    this.yAX = paramIntent.getIntExtra("get_poi_classify_type", 0);
    this.exP = paramIntent.getIntExtra("get_poi_showflag", 0);
    ac.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", new Object[] { Integer.valueOf(this.yAX) });
    this.gPy = bs.bG(paramIntent.getStringExtra("get_poi_name"), "");
    this.exW = bs.bG(paramIntent.getStringExtra("get_city"), "");
    this.hEE = paramIntent.getFloatExtra("get_lat", -1000.0F);
    this.hEF = paramIntent.getFloatExtra("get_lng", -1000.0F);
    ac.i("MicroMsg.LocationWidget", "check cur lat " + this.yAY + " " + this.vlj);
    this.yAY = paramIntent.getFloatExtra("get_cur_lat", 0.0F);
    this.vlj = paramIntent.getFloatExtra("get_cur_lng", 0.0F);
    this.yAZ = paramIntent.getIntExtra("get_loctype", -1);
    this.bOt = paramIntent.getFloatExtra("get_accuracy", 0.0F);
    this.hEP = paramIntent.getBooleanExtra("get_is_mars", true);
    this.dlj = paramIntent.getStringExtra("request_id");
    Object localObject = com.tencent.mm.modelstat.e.aIu();
    boolean bool;
    if (this.yAZ == 0)
    {
      bool = false;
      ((com.tencent.mm.modelstat.e)localObject).a(2003, bool, this.hEP, this.hEF, this.hEE, (int)this.bOt);
      this.yAU = paramIntent.getByteArrayExtra("location_ctx");
      if (bs.isNullOrNil(this.gPy)) {
        break label610;
      }
      this.yAV = bs.bG(paramIntent.getStringExtra("get_poi_address"), "");
      this.yAW = bs.bG(paramIntent.getStringExtra("get_poi_classify_id"), "");
      this.vlN = new boy();
    }
    for (;;)
    {
      try
      {
        this.vlN = ((boy)this.vlN.parseFrom(paramIntent.getByteArrayExtra("get_poi_item_buf")));
        if (!bs.isNullOrNil(this.yAW))
        {
          this.vlN = new boy();
          this.vlN.vku = this.yAW;
          this.vlN.ndI = this.yAX;
          this.vlN.Title = this.gPy;
          this.vlN.vkz.add(new crm().aJV(this.yAV));
        }
        ac.d("MicroMsg.LocationWidget", "label %s poiname %s", new Object[] { this.yAV, this.gPy });
        dND();
        dNB();
        this.yBc = new b();
        localObject = this.yBc;
        if (paramIntent != null)
        {
          ((b)localObject).index = paramIntent.getIntExtra("report_index", -1);
          ((b)localObject).vlm = paramIntent.getLongExtra("first_start_time", 0L);
          ((b)localObject).vln = paramIntent.getLongExtra("lastSuccStamp", 0L);
          ((b)localObject).vlo = paramIntent.getLongExtra("firstSuccStamp", 0L);
          ((b)localObject).vlp = paramIntent.getIntExtra("reqLoadCnt", 0);
          ((b)localObject).udn = paramIntent.getIntExtra("entry_time", 0);
          ((b)localObject).jKB = paramIntent.getStringExtra("search_id");
        }
        AppMethodBeat.o(97948);
        return true;
        bool = true;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        this.vlN = null;
        continue;
      }
      label610:
      if (!bs.isNullOrNil(this.exW))
      {
        this.gPy = "";
        this.yAV = "";
        this.yAW = "";
        this.vlN = null;
      }
      else
      {
        this.hEE = -1000.0F;
        this.hEF = -1000.0F;
        this.gPy = "";
        this.yAV = "";
        this.exW = "";
        this.yAW = "";
        this.vlN = null;
      }
    }
  }
  
  public final void dNC()
  {
    AppMethodBeat.i(97944);
    Intent localIntent = new Intent();
    localIntent.putExtra("near_life_scene", 1);
    try
    {
      localIntent.putExtra("get_poi_item_buf", this.vlN.toByteArray());
      if (!bs.isNullOrNil(this.yAW))
      {
        localIntent.putExtra("get_poi_classify_id", this.yAW);
        localIntent.putExtra("get_lat", this.hEE);
        localIntent.putExtra("get_lng", this.hEF);
        localIntent.putExtra("request_id", this.dlj);
        if (this.yBa == null) {
          break label237;
        }
        Object localObject = this.yBa.dNF();
        if (localObject == null) {
          break label237;
        }
        az((ArrayList)localObject);
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
        ac.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        continue;
        if (!bs.isNullOrNil(this.exW)) {
          localIntent.putExtra("get_city", this.exW);
        }
      }
      label237:
      com.tencent.mm.br.d.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 10);
      AppMethodBeat.o(97944);
    }
  }
  
  public brd getCurLocation()
  {
    AppMethodBeat.i(97951);
    brd localbrd = new brd();
    localbrd.Ehu = this.yAY;
    localbrd.Eht = this.vlj;
    localbrd.bOt = this.bOt;
    localbrd.yAZ = this.yAZ;
    AppMethodBeat.o(97951);
    return localbrd;
  }
  
  protected int getLayoutResource()
  {
    return 2131494601;
  }
  
  public brd getLocation()
  {
    AppMethodBeat.i(97950);
    brd localbrd = new brd();
    localbrd.Ehu = this.hEE;
    localbrd.Eht = this.hEF;
    localbrd.Fgo = 0;
    localbrd.score = this.score;
    if (this.yAU != null) {
      localbrd.Fgp = new com.tencent.mm.bw.b(this.yAU);
    }
    if (!bs.isNullOrNil(this.gPy))
    {
      localbrd.yAV = this.yAV;
      localbrd.gPy = this.gPy;
      localbrd.EFm = this.yAW;
      localbrd.iJV = this.exW;
      if ((this.yAX != 0) && (this.yAX == 1))
      {
        localbrd.yAX = 2;
        ac.d("MicroMsg.LocationWidget", "getlocation type %d", new Object[] { Integer.valueOf(localbrd.yAX) });
      }
    }
    for (;;)
    {
      if (this.yBc != null)
      {
        String str = String.format("%f/%f", new Object[] { Float.valueOf(localbrd.Ehu), Float.valueOf(localbrd.Eht) });
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("index " + this.yBc.index);
        localStringBuffer.append("firstStartStamp " + this.yBc.vlm);
        localStringBuffer.append("lastSuccStamp " + this.yBc.vlo);
        localStringBuffer.append("firstSuccStamp " + this.yBc.vln);
        localStringBuffer.append("reqLoadCnt " + this.yBc.vlp);
        localStringBuffer.append("classifyId " + this.yAW);
        localStringBuffer.append("entryTime " + this.yBc.udn);
        localStringBuffer.append("searchId" + this.yBc.jKB);
        ac.d("MicroMsg.LocationWidget", "report %s", new Object[] { localStringBuffer.toString() });
        h.wUl.f(11135, new Object[] { Integer.valueOf(5), Integer.valueOf(this.yBc.index + 1), Long.valueOf(this.yBc.vlm), Long.valueOf(this.yBc.vlo), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.yBc.vln), Integer.valueOf(this.yBc.vlp), str, this.yAW, Integer.valueOf(this.yBc.udn), this.yBc.jKB, q.cF(true) });
      }
      dNE();
      AppMethodBeat.o(97950);
      return localbrd;
      localbrd.yAX = 1;
      break;
      if (!bs.isNullOrNil(this.exW)) {
        localbrd.iJV = this.exW;
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
    return this.exP;
  }
  
  public void setLocationWidgetListener(a parama)
  {
    this.yBa = parama;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(97947);
    if (this.vld != null) {
      this.vld.c(this.vlx);
    }
    if (this.ucr != null) {
      this.ucr.a(this.tWR);
    }
    AppMethodBeat.o(97947);
  }
  
  public static abstract interface a
  {
    public abstract ArrayList<Exif.a> dNF();
    
    public abstract boolean dNG();
  }
  
  final class b
  {
    int index;
    String jKB = "";
    int udn = 0;
    long vlm = -1L;
    long vln = -1L;
    long vlo = -1L;
    int vlp = 0;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget
 * JD-Core Version:    0.7.0.1
 */