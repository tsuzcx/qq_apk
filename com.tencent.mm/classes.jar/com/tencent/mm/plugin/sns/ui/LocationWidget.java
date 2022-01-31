package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LocationWidget
  extends LinearLayout
{
  private float boo;
  private String city;
  private int dqG;
  private String eSM;
  private float fBB;
  private float fBC;
  private boolean fBM;
  private Activity gQx;
  private c.a oae;
  private c ofr;
  private String ohe;
  private com.tencent.mm.modelgeo.d peF;
  private float peL;
  private b.a peZ;
  private azs pfp;
  private ImageView rFb;
  private TextView rGf;
  private View rHX;
  private View rHY;
  private int[] rHZ;
  private ImageView[] rIa;
  private int rIb;
  private TextView rIc;
  private byte[] rId;
  private String rIe;
  private String rIf;
  private int rIg;
  private float rIh;
  private int rIi;
  private LocationWidget.a rIj;
  private boolean rIk;
  private LocationWidget.b rIl;
  private int score;
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38290);
    this.rHZ = new int[] { 2131825446, 2131825447, 2131825448, 2131825449, 2131825450 };
    this.rIa = new ImageView[5];
    this.fBB = -1000.0F;
    this.fBC = -1000.0F;
    this.rIg = 0;
    this.pfp = null;
    this.dqG = 0;
    this.rIh = 0.0F;
    this.peL = 0.0F;
    this.boo = 0.0F;
    this.rIi = -1;
    this.fBM = true;
    this.peF = com.tencent.mm.modelgeo.d.agQ();
    this.rIj = null;
    this.rIk = false;
    this.oae = new LocationWidget.3(this);
    this.peZ = new LocationWidget.4(this);
    this.rIl = null;
    j((MMActivity)paramContext);
    AppMethodBeat.o(38290);
  }
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38289);
    this.rHZ = new int[] { 2131825446, 2131825447, 2131825448, 2131825449, 2131825450 };
    this.rIa = new ImageView[5];
    this.fBB = -1000.0F;
    this.fBC = -1000.0F;
    this.rIg = 0;
    this.pfp = null;
    this.dqG = 0;
    this.rIh = 0.0F;
    this.peL = 0.0F;
    this.boo = 0.0F;
    this.rIi = -1;
    this.fBM = true;
    this.peF = com.tencent.mm.modelgeo.d.agQ();
    this.rIj = null;
    this.rIk = false;
    this.oae = new LocationWidget.3(this);
    this.peZ = new LocationWidget.4(this);
    this.rIl = null;
    j((MMActivity)paramContext);
    AppMethodBeat.o(38289);
  }
  
  private void Q(ArrayList<Exif.a> paramArrayList)
  {
    AppMethodBeat.i(38294);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(38294);
      return;
    }
    h.qsU.kvStat(11139, "1");
    Exif.a locala1;
    if ((Math.abs(-1000.0F - this.fBB) > 1.0E-006D) && (Math.abs(-1000.0F - this.fBC) > 1.0E-006D))
    {
      locala1 = (Exif.a)paramArrayList.get(paramArrayList.size() - 1);
      if (b(locala1.latitude, locala1.longitude, this.fBB, this.fBC)) {
        h.qsU.kvStat(11139, "2");
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
        h.qsU.kvStat(11139, "3");
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
      AppMethodBeat.o(38294);
      return;
    }
  }
  
  private static boolean b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(38295);
    if (t.c(paramDouble1, paramDouble2, paramDouble3, paramDouble4) > 1000.0D)
    {
      AppMethodBeat.o(38295);
      return true;
    }
    AppMethodBeat.o(38295);
    return false;
  }
  
  private void ctF()
  {
    int i = 0;
    AppMethodBeat.i(38292);
    ab.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", new Object[] { Integer.valueOf(this.rIb), this.rIf, Integer.valueOf(this.rIg), Integer.valueOf(this.dqG), Boolean.valueOf(bq.duf()) });
    if ((bq.duf()) || (this.rIb == 0) || (bo.isNullOrNil(this.rIf)) || (this.rIg == 1) || ((this.dqG & 0x1) == 0))
    {
      this.rHY.setVisibility(8);
      AppMethodBeat.o(38292);
      return;
    }
    this.rHY.setVisibility(0);
    while (i < this.score)
    {
      this.rIa[i].setImageResource(getSelectedStarImageResource());
      i += 1;
    }
    i = this.score;
    while (i < 5)
    {
      this.rIa[i].setImageResource(getNormalStarImageResource());
      i += 1;
    }
    AppMethodBeat.o(38292);
  }
  
  private void ctH()
  {
    AppMethodBeat.i(38298);
    if ((this.rIc != null) && (this.rGf != null))
    {
      if (bo.isNullOrNil(this.eSM)) {
        break label124;
      }
      this.rIc.setText(this.eSM);
      this.rIc.setTextColor(getResources().getColor(2131690139));
      this.rGf.setVisibility(8);
    }
    while ((!bo.isNullOrNil(this.eSM)) || (!bo.isNullOrNil(this.city)))
    {
      this.rFb.setImageDrawable(aj.g(this.gQx, 2131230778, getContext().getResources().getColor(2131690701)));
      AppMethodBeat.o(38298);
      return;
      label124:
      if (!bo.isNullOrNil(this.city))
      {
        this.rIc.setText(this.city);
        this.rIc.setTextColor(getResources().getColor(2131690139));
        this.rGf.setVisibility(8);
      }
      else
      {
        this.rIc.setText(2131303876);
        this.rIc.setTextColor(getResources().getColor(2131690322));
        this.rGf.setVisibility(8);
      }
    }
    this.rFb.setImageDrawable(aj.g(this.gQx, 2131230777, -16777216));
    AppMethodBeat.o(38298);
  }
  
  private void ctI()
  {
    AppMethodBeat.i(38301);
    if (this.rIj != null)
    {
      boolean bool = this.rIj.ctK();
      Object localObject = this.rIj.ctJ();
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        AppMethodBeat.o(38301);
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        Exif.a locala = (Exif.a)((Iterator)localObject).next();
        ab.d("MicroMsg.LocationWidget", "snsreport lat lng %f, %f", new Object[] { Double.valueOf(locala.latitude), Double.valueOf(locala.longitude) });
        h localh = h.qsU;
        int j = (int)(locala.latitude * 1000000.0D);
        int k = (int)(locala.longitude * 1000000.0D);
        if (bool) {}
        for (int i = 1;; i = 2)
        {
          localh.e(11345, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(2) });
          break;
        }
      }
    }
    AppMethodBeat.o(38301);
  }
  
  private void j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(38291);
    this.gQx = paramMMActivity;
    View localView = View.inflate(paramMMActivity, getLayoutResource(), this);
    this.rHX = localView.findViewById(2131825440);
    this.rIc = ((TextView)this.rHX.findViewById(2131825439));
    this.rGf = ((TextView)this.rHX.findViewById(2131825442));
    this.rFb = ((ImageView)this.rHX.findViewById(2131825441));
    this.rHY = localView.findViewById(2131825443);
    int i = 0;
    while (i < 5)
    {
      this.rIa[i] = ((ImageView)this.rHY.findViewById(this.rHZ[i]));
      this.rIa[i].setOnClickListener(new LocationWidget.1(this, i));
      i += 1;
    }
    this.ofr = c.agN();
    this.rHX.setOnClickListener(new LocationWidget.2(this));
    this.rIf = paramMMActivity.getIntent().getStringExtra("kpoi_id");
    if (!bo.isNullOrNil(this.rIf))
    {
      this.fBB = paramMMActivity.getIntent().getFloatExtra("k_lat", -1000.0F);
      this.fBC = paramMMActivity.getIntent().getFloatExtra("k_lng", -1000.0F);
      this.eSM = paramMMActivity.getIntent().getStringExtra("kpoi_name");
      this.rIe = paramMMActivity.getIntent().getStringExtra("Kpoi_address");
      ctH();
    }
    if (com.tencent.mm.kernel.g.RJ().QU()) {}
    for (this.rIb = bo.getInt(com.tencent.mm.m.g.Nq().getValue("SnsPostPOICommentSwitch"), 0);; this.rIb = 0)
    {
      ctF();
      AppMethodBeat.o(38291);
      return;
    }
  }
  
  public final boolean an(Intent paramIntent)
  {
    AppMethodBeat.i(38297);
    if (paramIntent == null)
    {
      AppMethodBeat.o(38297);
      return true;
    }
    this.rIg = paramIntent.getIntExtra("get_poi_classify_type", 0);
    this.dqG = paramIntent.getIntExtra("get_poi_showflag", 0);
    ab.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", new Object[] { Integer.valueOf(this.rIg) });
    this.eSM = bo.bf(paramIntent.getStringExtra("get_poi_name"), "");
    this.city = bo.bf(paramIntent.getStringExtra("get_city"), "");
    this.fBB = paramIntent.getFloatExtra("get_lat", -1000.0F);
    this.fBC = paramIntent.getFloatExtra("get_lng", -1000.0F);
    ab.i("MicroMsg.LocationWidget", "check cur lat " + this.rIh + " " + this.peL);
    this.rIh = paramIntent.getFloatExtra("get_cur_lat", 0.0F);
    this.peL = paramIntent.getFloatExtra("get_cur_lng", 0.0F);
    this.rIi = paramIntent.getIntExtra("get_loctype", -1);
    this.boo = paramIntent.getFloatExtra("get_accuracy", 0.0F);
    this.fBM = paramIntent.getBooleanExtra("get_is_mars", true);
    this.ohe = paramIntent.getStringExtra("request_id");
    Object localObject = com.tencent.mm.modelstat.e.akz();
    boolean bool;
    if (this.rIi == 0)
    {
      bool = false;
      ((com.tencent.mm.modelstat.e)localObject).a(2003, bool, this.fBM, this.fBC, this.fBB, (int)this.boo);
      this.rId = paramIntent.getByteArrayExtra("location_ctx");
      if (bo.isNullOrNil(this.eSM)) {
        break label610;
      }
      this.rIe = bo.bf(paramIntent.getStringExtra("get_poi_address"), "");
      this.rIf = bo.bf(paramIntent.getStringExtra("get_poi_classify_id"), "");
      this.pfp = new azs();
    }
    for (;;)
    {
      try
      {
        this.pfp = ((azs)this.pfp.parseFrom(paramIntent.getByteArrayExtra("get_poi_item_buf")));
        if (!bo.isNullOrNil(this.rIf))
        {
          this.pfp = new azs();
          this.pfp.pdW = this.rIf;
          this.pfp.jKs = this.rIg;
          this.pfp.Title = this.eSM;
          this.pfp.peb.add(new bwc().aoF(this.rIe));
        }
        ab.d("MicroMsg.LocationWidget", "label %s poiname %s", new Object[] { this.rIe, this.eSM });
        ctH();
        ctF();
        this.rIl = new LocationWidget.b(this);
        localObject = this.rIl;
        if (paramIntent != null)
        {
          ((LocationWidget.b)localObject).index = paramIntent.getIntExtra("report_index", -1);
          ((LocationWidget.b)localObject).peO = paramIntent.getLongExtra("first_start_time", 0L);
          ((LocationWidget.b)localObject).peP = paramIntent.getLongExtra("lastSuccStamp", 0L);
          ((LocationWidget.b)localObject).peQ = paramIntent.getLongExtra("firstSuccStamp", 0L);
          ((LocationWidget.b)localObject).peR = paramIntent.getIntExtra("reqLoadCnt", 0);
          ((LocationWidget.b)localObject).ogt = paramIntent.getIntExtra("entry_time", 0);
          ((LocationWidget.b)localObject).hng = paramIntent.getStringExtra("search_id");
        }
        AppMethodBeat.o(38297);
        return true;
        bool = true;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        this.pfp = null;
        continue;
      }
      label610:
      if (!bo.isNullOrNil(this.city))
      {
        this.eSM = "";
        this.rIe = "";
        this.rIf = "";
        this.pfp = null;
      }
      else
      {
        this.fBB = -1000.0F;
        this.fBC = -1000.0F;
        this.eSM = "";
        this.rIe = "";
        this.city = "";
        this.rIf = "";
        this.pfp = null;
      }
    }
  }
  
  public final void ctG()
  {
    AppMethodBeat.i(38293);
    Intent localIntent = new Intent();
    localIntent.putExtra("near_life_scene", 1);
    try
    {
      localIntent.putExtra("get_poi_item_buf", this.pfp.toByteArray());
      if (!bo.isNullOrNil(this.rIf))
      {
        localIntent.putExtra("get_poi_classify_id", this.rIf);
        localIntent.putExtra("get_lat", this.fBB);
        localIntent.putExtra("get_lng", this.fBC);
        localIntent.putExtra("request_id", this.ohe);
        if (this.rIj == null) {
          break label237;
        }
        Object localObject = this.rIj.ctJ();
        if (localObject == null) {
          break label237;
        }
        Q((ArrayList)localObject);
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
        ab.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        continue;
        if (!bo.isNullOrNil(this.city)) {
          localIntent.putExtra("get_city", this.city);
        }
      }
      label237:
      com.tencent.mm.bq.d.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 10);
      AppMethodBeat.o(38293);
    }
  }
  
  public bap getCurLocation()
  {
    AppMethodBeat.i(38300);
    bap localbap = new bap();
    localbap.wDi = this.rIh;
    localbap.wDh = this.peL;
    localbap.boo = this.boo;
    localbap.rIi = this.rIi;
    AppMethodBeat.o(38300);
    return localbap;
  }
  
  protected int getLayoutResource()
  {
    return 2130969996;
  }
  
  public bap getLocation()
  {
    AppMethodBeat.i(38299);
    bap localbap = new bap();
    localbap.wDi = this.fBB;
    localbap.wDh = this.fBC;
    localbap.xpQ = 0;
    localbap.score = this.score;
    if (this.rId != null) {
      localbap.xpR = new b(this.rId);
    }
    if (!bo.isNullOrNil(this.eSM))
    {
      localbap.rIe = this.rIe;
      localbap.eSM = this.eSM;
      localbap.xpN = this.rIf;
      localbap.gwR = this.city;
      if ((this.rIg != 0) && (this.rIg == 1))
      {
        localbap.rIg = 2;
        ab.d("MicroMsg.LocationWidget", "getlocation type %d", new Object[] { Integer.valueOf(localbap.rIg) });
      }
    }
    for (;;)
    {
      if (this.rIl != null)
      {
        String str = String.format("%f/%f", new Object[] { Float.valueOf(localbap.wDi), Float.valueOf(localbap.wDh) });
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("index " + this.rIl.index);
        localStringBuffer.append("firstStartStamp " + this.rIl.peO);
        localStringBuffer.append("lastSuccStamp " + this.rIl.peQ);
        localStringBuffer.append("firstSuccStamp " + this.rIl.peP);
        localStringBuffer.append("reqLoadCnt " + this.rIl.peR);
        localStringBuffer.append("classifyId " + this.rIf);
        localStringBuffer.append("entryTime " + this.rIl.ogt);
        localStringBuffer.append("searchId" + this.rIl.hng);
        ab.d("MicroMsg.LocationWidget", "report %s", new Object[] { localStringBuffer.toString() });
        h.qsU.e(11135, new Object[] { Integer.valueOf(5), Integer.valueOf(this.rIl.index + 1), Long.valueOf(this.rIl.peO), Long.valueOf(this.rIl.peQ), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.rIl.peP), Integer.valueOf(this.rIl.peR), str, this.rIf, Integer.valueOf(this.rIl.ogt), this.rIl.hng, q.bP(true) });
      }
      ctI();
      AppMethodBeat.o(38299);
      return localbap;
      localbap.rIg = 1;
      break;
      if (!bo.isNullOrNil(this.city)) {
        localbap.gwR = this.city;
      }
    }
  }
  
  protected int getNormalStarImageResource()
  {
    return 2131232032;
  }
  
  protected int getNormalStateImageResource()
  {
    return 2131230777;
  }
  
  protected int getSelectedStarImageResource()
  {
    return 2131232033;
  }
  
  protected int getSelectedStateImageResource()
  {
    return 2131230778;
  }
  
  public int getShowFlag()
  {
    return this.dqG;
  }
  
  public void setLocationWidgetListener(LocationWidget.a parama)
  {
    this.rIj = parama;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(38296);
    if (this.peF != null) {
      this.peF.c(this.peZ);
    }
    if (this.ofr != null) {
      this.ofr.a(this.oae);
    }
    AppMethodBeat.o(38296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget
 * JD-Core Version:    0.7.0.1
 */