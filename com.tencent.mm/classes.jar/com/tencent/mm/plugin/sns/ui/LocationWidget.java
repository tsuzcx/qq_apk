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
import com.tencent.mm.bx.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LocationWidget
  extends LinearLayout
{
  private float bQL;
  private String dnB;
  private String evA;
  private int evt;
  private String goQ;
  private float heb;
  private float hec;
  private boolean hem;
  private Activity jgS;
  private c.a sOE;
  private c sUf;
  private int score;
  private blc ucO;
  private com.tencent.mm.modelgeo.d uce;
  private float uck;
  private b.a ucy;
  private ImageView xkO;
  private TextView xmb;
  private View xnX;
  private View xnY;
  private int[] xnZ;
  private ImageView[] xoa;
  private int xob;
  private TextView xoc;
  private byte[] xod;
  private String xoe;
  private String xof;
  private int xog;
  private float xoh;
  private int xoi;
  private a xoj;
  private boolean xok;
  private b xol;
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97941);
    this.xnZ = new int[] { 2131304356, 2131304357, 2131304358, 2131304359, 2131304360 };
    this.xoa = new ImageView[5];
    this.heb = -1000.0F;
    this.hec = -1000.0F;
    this.xog = 0;
    this.ucO = null;
    this.evt = 0;
    this.xoh = 0.0F;
    this.uck = 0.0F;
    this.bQL = 0.0F;
    this.xoi = -1;
    this.hem = true;
    this.uce = com.tencent.mm.modelgeo.d.axT();
    this.xoj = null;
    this.xok = false;
    this.sOE = new c.a()
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
        LocationWidget.a(LocationWidget.this, paramAnonymousAddr.hdS);
        LocationWidget.f(LocationWidget.this);
        AppMethodBeat.o(97938);
      }
    };
    this.ucy = new b.a()
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
        com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.aBE();
        if (paramAnonymousInt == 0)
        {
          paramAnonymousBoolean = false;
          if (LocationWidget.h(LocationWidget.this) != null) {
            break label113;
          }
        }
        label113:
        for (boolean bool = false;; bool = LocationWidget.h(LocationWidget.this).hem)
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
    this.xol = null;
    l((MMActivity)paramContext);
    AppMethodBeat.o(97941);
  }
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97940);
    this.xnZ = new int[] { 2131304356, 2131304357, 2131304358, 2131304359, 2131304360 };
    this.xoa = new ImageView[5];
    this.heb = -1000.0F;
    this.hec = -1000.0F;
    this.xog = 0;
    this.ucO = null;
    this.evt = 0;
    this.xoh = 0.0F;
    this.uck = 0.0F;
    this.bQL = 0.0F;
    this.xoi = -1;
    this.hem = true;
    this.uce = com.tencent.mm.modelgeo.d.axT();
    this.xoj = null;
    this.xok = false;
    this.sOE = new c.a()
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
        LocationWidget.a(LocationWidget.this, paramAnonymousAddr.hdS);
        LocationWidget.f(LocationWidget.this);
        AppMethodBeat.o(97938);
      }
    };
    this.ucy = new b.a()
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
        com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.aBE();
        if (paramAnonymousInt == 0)
        {
          paramAnonymousBoolean = false;
          if (LocationWidget.h(LocationWidget.this) != null) {
            break label113;
          }
        }
        label113:
        for (boolean bool = false;; bool = LocationWidget.h(LocationWidget.this).hem)
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
    this.xol = null;
    l((MMActivity)paramContext);
    AppMethodBeat.o(97940);
  }
  
  private void an(ArrayList<Exif.a> paramArrayList)
  {
    AppMethodBeat.i(97945);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(97945);
      return;
    }
    h.vKh.kvStat(11139, "1");
    Exif.a locala1;
    if ((Math.abs(-1000.0F - this.heb) > 1.0E-006D) && (Math.abs(-1000.0F - this.hec) > 1.0E-006D))
    {
      locala1 = (Exif.a)paramArrayList.get(paramArrayList.size() - 1);
      if (b(locala1.latitude, locala1.longitude, this.heb, this.hec)) {
        h.vKh.kvStat(11139, "2");
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
        h.vKh.kvStat(11139, "3");
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
  
  private void dze()
  {
    int i = 0;
    AppMethodBeat.i(97943);
    ad.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", new Object[] { Integer.valueOf(this.xob), this.xof, Integer.valueOf(this.xog), Integer.valueOf(this.evt), Boolean.valueOf(bv.eGV()) });
    if ((bv.eGV()) || (this.xob == 0) || (bt.isNullOrNil(this.xof)) || (this.xog == 1) || ((this.evt & 0x1) == 0))
    {
      this.xnY.setVisibility(8);
      AppMethodBeat.o(97943);
      return;
    }
    this.xnY.setVisibility(0);
    while (i < this.score)
    {
      this.xoa[i].setImageResource(getSelectedStarImageResource());
      i += 1;
    }
    i = this.score;
    while (i < 5)
    {
      this.xoa[i].setImageResource(getNormalStarImageResource());
      i += 1;
    }
    AppMethodBeat.o(97943);
  }
  
  private void dzg()
  {
    AppMethodBeat.i(97949);
    if ((this.xoc != null) && (this.xmb != null))
    {
      if (bt.isNullOrNil(this.goQ)) {
        break label124;
      }
      this.xoc.setText(this.goQ);
      this.xoc.setTextColor(getResources().getColor(2131100464));
      this.xmb.setVisibility(8);
    }
    while ((!bt.isNullOrNil(this.goQ)) || (!bt.isNullOrNil(this.evA)))
    {
      this.xkO.setImageDrawable(am.i(this.jgS, 2131689533, getContext().getResources().getColor(2131101171)));
      AppMethodBeat.o(97949);
      return;
      label124:
      if (!bt.isNullOrNil(this.evA))
      {
        this.xoc.setText(this.evA);
        this.xoc.setTextColor(getResources().getColor(2131100464));
        this.xmb.setVisibility(8);
      }
      else
      {
        this.xoc.setText(2131763887);
        this.xoc.setTextColor(getResources().getColor(2131100711));
        this.xmb.setVisibility(8);
      }
    }
    this.xkO.setImageDrawable(am.i(this.jgS, 2131689532, getContext().getResources().getColor(2131100499)));
    AppMethodBeat.o(97949);
  }
  
  private void dzh()
  {
    AppMethodBeat.i(97952);
    if (this.xoj != null)
    {
      boolean bool = this.xoj.dzj();
      Object localObject = this.xoj.dzi();
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
        h localh = h.vKh;
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
    this.jgS = paramMMActivity;
    View localView = View.inflate(paramMMActivity, getLayoutResource(), this);
    this.xnX = localView.findViewById(2131301522);
    this.xoc = ((TextView)this.xnX.findViewById(2131301545));
    this.xmb = ((TextView)this.xnX.findViewById(2131301535));
    this.xkO = ((ImageView)this.xnX.findViewById(2131301530));
    this.xnY = localView.findViewById(2131304354);
    final int i = 0;
    while (i < 5)
    {
      this.xoa[i] = ((ImageView)this.xnY.findViewById(this.xnZ[i]));
      this.xoa[i].setOnClickListener(new View.OnClickListener()
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
    this.sUf = c.axQ();
    this.xnX.setOnClickListener(new LocationWidget.2(this));
    this.xof = paramMMActivity.getIntent().getStringExtra("kpoi_id");
    if (!bt.isNullOrNil(this.xof))
    {
      this.heb = paramMMActivity.getIntent().getFloatExtra("k_lat", -1000.0F);
      this.hec = paramMMActivity.getIntent().getFloatExtra("k_lng", -1000.0F);
      this.goQ = paramMMActivity.getIntent().getStringExtra("kpoi_name");
      this.xoe = paramMMActivity.getIntent().getStringExtra("Kpoi_address");
      dzg();
    }
    if (com.tencent.mm.kernel.g.afz().aeI()) {}
    for (this.xob = bt.getInt(com.tencent.mm.m.g.Zd().getValue("SnsPostPOICommentSwitch"), 0);; this.xob = 0)
    {
      dze();
      AppMethodBeat.o(97942);
      return;
    }
  }
  
  public final boolean aG(Intent paramIntent)
  {
    AppMethodBeat.i(97948);
    if (paramIntent == null)
    {
      AppMethodBeat.o(97948);
      return true;
    }
    this.xog = paramIntent.getIntExtra("get_poi_classify_type", 0);
    this.evt = paramIntent.getIntExtra("get_poi_showflag", 0);
    ad.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", new Object[] { Integer.valueOf(this.xog) });
    this.goQ = bt.by(paramIntent.getStringExtra("get_poi_name"), "");
    this.evA = bt.by(paramIntent.getStringExtra("get_city"), "");
    this.heb = paramIntent.getFloatExtra("get_lat", -1000.0F);
    this.hec = paramIntent.getFloatExtra("get_lng", -1000.0F);
    ad.i("MicroMsg.LocationWidget", "check cur lat " + this.xoh + " " + this.uck);
    this.xoh = paramIntent.getFloatExtra("get_cur_lat", 0.0F);
    this.uck = paramIntent.getFloatExtra("get_cur_lng", 0.0F);
    this.xoi = paramIntent.getIntExtra("get_loctype", -1);
    this.bQL = paramIntent.getFloatExtra("get_accuracy", 0.0F);
    this.hem = paramIntent.getBooleanExtra("get_is_mars", true);
    this.dnB = paramIntent.getStringExtra("request_id");
    Object localObject = com.tencent.mm.modelstat.e.aBE();
    boolean bool;
    if (this.xoi == 0)
    {
      bool = false;
      ((com.tencent.mm.modelstat.e)localObject).a(2003, bool, this.hem, this.hec, this.heb, (int)this.bQL);
      this.xod = paramIntent.getByteArrayExtra("location_ctx");
      if (bt.isNullOrNil(this.goQ)) {
        break label610;
      }
      this.xoe = bt.by(paramIntent.getStringExtra("get_poi_address"), "");
      this.xof = bt.by(paramIntent.getStringExtra("get_poi_classify_id"), "");
      this.ucO = new blc();
    }
    for (;;)
    {
      try
      {
        this.ucO = ((blc)this.ucO.parseFrom(paramIntent.getByteArrayExtra("get_poi_item_buf")));
        if (!bt.isNullOrNil(this.xof))
        {
          this.ucO = new blc();
          this.ucO.ubw = this.xof;
          this.ucO.mBH = this.xog;
          this.ucO.Title = this.goQ;
          this.ucO.ubB.add(new cmf().aEE(this.xoe));
        }
        ad.d("MicroMsg.LocationWidget", "label %s poiname %s", new Object[] { this.xoe, this.goQ });
        dzg();
        dze();
        this.xol = new b();
        localObject = this.xol;
        if (paramIntent != null)
        {
          ((b)localObject).index = paramIntent.getIntExtra("report_index", -1);
          ((b)localObject).ucn = paramIntent.getLongExtra("first_start_time", 0L);
          ((b)localObject).uco = paramIntent.getLongExtra("lastSuccStamp", 0L);
          ((b)localObject).ucp = paramIntent.getLongExtra("firstSuccStamp", 0L);
          ((b)localObject).ucq = paramIntent.getIntExtra("reqLoadCnt", 0);
          ((b)localObject).sVb = paramIntent.getIntExtra("entry_time", 0);
          ((b)localObject).jko = paramIntent.getStringExtra("search_id");
        }
        AppMethodBeat.o(97948);
        return true;
        bool = true;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        this.ucO = null;
        continue;
      }
      label610:
      if (!bt.isNullOrNil(this.evA))
      {
        this.goQ = "";
        this.xoe = "";
        this.xof = "";
        this.ucO = null;
      }
      else
      {
        this.heb = -1000.0F;
        this.hec = -1000.0F;
        this.goQ = "";
        this.xoe = "";
        this.evA = "";
        this.xof = "";
        this.ucO = null;
      }
    }
  }
  
  public final void dzf()
  {
    AppMethodBeat.i(97944);
    Intent localIntent = new Intent();
    localIntent.putExtra("near_life_scene", 1);
    try
    {
      localIntent.putExtra("get_poi_item_buf", this.ucO.toByteArray());
      if (!bt.isNullOrNil(this.xof))
      {
        localIntent.putExtra("get_poi_classify_id", this.xof);
        localIntent.putExtra("get_lat", this.heb);
        localIntent.putExtra("get_lng", this.hec);
        localIntent.putExtra("request_id", this.dnB);
        if (this.xoj == null) {
          break label237;
        }
        Object localObject = this.xoj.dzi();
        if (localObject == null) {
          break label237;
        }
        an((ArrayList)localObject);
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
        if (!bt.isNullOrNil(this.evA)) {
          localIntent.putExtra("get_city", this.evA);
        }
      }
      label237:
      com.tencent.mm.bs.d.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 10);
      AppMethodBeat.o(97944);
    }
  }
  
  public bmn getCurLocation()
  {
    AppMethodBeat.i(97951);
    bmn localbmn = new bmn();
    localbmn.COJ = this.xoh;
    localbmn.COI = this.uck;
    localbmn.bQL = this.bQL;
    localbmn.xoi = this.xoi;
    AppMethodBeat.o(97951);
    return localbmn;
  }
  
  protected int getLayoutResource()
  {
    return 2131494601;
  }
  
  public bmn getLocation()
  {
    AppMethodBeat.i(97950);
    bmn localbmn = new bmn();
    localbmn.COJ = this.heb;
    localbmn.COI = this.hec;
    localbmn.DJZ = 0;
    localbmn.score = this.score;
    if (this.xod != null) {
      localbmn.DKa = new b(this.xod);
    }
    if (!bt.isNullOrNil(this.goQ))
    {
      localbmn.xoe = this.xoe;
      localbmn.goQ = this.goQ;
      localbmn.DlE = this.xof;
      localbmn.ijO = this.evA;
      if ((this.xog != 0) && (this.xog == 1))
      {
        localbmn.xog = 2;
        ad.d("MicroMsg.LocationWidget", "getlocation type %d", new Object[] { Integer.valueOf(localbmn.xog) });
      }
    }
    for (;;)
    {
      if (this.xol != null)
      {
        String str = String.format("%f/%f", new Object[] { Float.valueOf(localbmn.COJ), Float.valueOf(localbmn.COI) });
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("index " + this.xol.index);
        localStringBuffer.append("firstStartStamp " + this.xol.ucn);
        localStringBuffer.append("lastSuccStamp " + this.xol.ucp);
        localStringBuffer.append("firstSuccStamp " + this.xol.uco);
        localStringBuffer.append("reqLoadCnt " + this.xol.ucq);
        localStringBuffer.append("classifyId " + this.xof);
        localStringBuffer.append("entryTime " + this.xol.sVb);
        localStringBuffer.append("searchId" + this.xol.jko);
        ad.d("MicroMsg.LocationWidget", "report %s", new Object[] { localStringBuffer.toString() });
        h.vKh.f(11135, new Object[] { Integer.valueOf(5), Integer.valueOf(this.xol.index + 1), Long.valueOf(this.xol.ucn), Long.valueOf(this.xol.ucp), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.xol.uco), Integer.valueOf(this.xol.ucq), str, this.xof, Integer.valueOf(this.xol.sVb), this.xol.jko, q.cG(true) });
      }
      dzh();
      AppMethodBeat.o(97950);
      return localbmn;
      localbmn.xog = 1;
      break;
      if (!bt.isNullOrNil(this.evA)) {
        localbmn.ijO = this.evA;
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
    return this.evt;
  }
  
  public void setLocationWidgetListener(a parama)
  {
    this.xoj = parama;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(97947);
    if (this.uce != null) {
      this.uce.c(this.ucy);
    }
    if (this.sUf != null) {
      this.sUf.a(this.sOE);
    }
    AppMethodBeat.o(97947);
  }
  
  public static abstract interface a
  {
    public abstract ArrayList<Exif.a> dzi();
    
    public abstract boolean dzj();
  }
  
  final class b
  {
    int index;
    String jko = "";
    int sVb = 0;
    long ucn = -1L;
    long uco = -1L;
    long ucp = -1L;
    int ucq = 0;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget
 * JD-Core Version:    0.7.0.1
 */