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
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.protocal.c.atn;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bm;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LocationWidget
  extends LinearLayout
{
  private float aXH = 0.0F;
  private String cCB;
  private int cCu = 0;
  private float elk = -1000.0F;
  private float ell = -1000.0F;
  private boolean elu = true;
  private Activity fyk;
  private b.a lCS = new LocationWidget.3(this);
  private String lFn;
  private com.tencent.mm.modelgeo.b lIe;
  private String lJQ;
  private c mEC = c.Ob();
  private float mEI = 0.0F;
  private a.a mEU = new LocationWidget.4(this);
  private atn mFj = null;
  private ImageView oNr;
  private TextView oOu;
  private View oQl;
  private View oQm;
  private int[] oQn = { i.f.score_iv_1, i.f.score_iv_2, i.f.score_iv_3, i.f.score_iv_4, i.f.score_iv_5 };
  private ImageView[] oQo = new ImageView[5];
  private int oQp;
  private TextView oQq;
  private byte[] oQr;
  private String oQs;
  private String oQt;
  private int oQu = 0;
  private float oQv = 0.0F;
  private int oQw = -1;
  private LocationWidget.a oQx = null;
  private boolean oQy = false;
  private LocationWidget.b oQz = null;
  private int score;
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    i((MMActivity)paramContext);
  }
  
  public LocationWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    i((MMActivity)paramContext);
  }
  
  private void O(ArrayList<Exif.a> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    label203:
    label210:
    label213:
    for (;;)
    {
      return;
      h.nFQ.aC(11139, "1");
      Exif.a locala1;
      if ((Math.abs(-1000.0F - this.elk) > 1.0E-006D) && (Math.abs(-1000.0F - this.ell) > 1.0E-006D))
      {
        locala1 = (Exif.a)paramArrayList.get(paramArrayList.size() - 1);
        if (b(locala1.latitude, locala1.longitude, this.elk, this.ell)) {
          h.nFQ.aC(11139, "2");
        }
      }
      int i = 0;
      label113:
      if (i < paramArrayList.size())
      {
        j = i + 1;
        label125:
        if (j >= paramArrayList.size()) {
          break label210;
        }
        locala1 = (Exif.a)paramArrayList.get(i);
        Exif.a locala2 = (Exif.a)paramArrayList.get(j);
        if (!b(locala1.latitude, locala1.longitude, locala2.latitude, locala2.longitude)) {
          break label203;
        }
        h.nFQ.aC(11139, "3");
      }
      for (int j = 0;; j = 1)
      {
        if (j == 0) {
          break label213;
        }
        i += 1;
        break label113;
        break;
        j += 1;
        break label125;
      }
    }
  }
  
  private static boolean b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return com.tencent.mm.pluginsdk.q.c(paramDouble1, paramDouble2, paramDouble3, paramDouble4) > 1000.0D;
  }
  
  private void bHB()
  {
    if ((this.oQq != null) && (this.oOu != null))
    {
      if (bk.bl(this.lFn)) {
        break label93;
      }
      this.oQq.setText(this.lFn);
      this.oQq.setTextColor(getResources().getColor(i.c.green_text_color));
      this.oOu.setVisibility(8);
    }
    while ((!bk.bl(this.lFn)) || (!bk.bl(this.cCB)))
    {
      this.oNr.setImageResource(getSelectedStateImageResource());
      return;
      label93:
      if (!bk.bl(this.cCB))
      {
        this.oQq.setText(this.cCB);
        this.oQq.setTextColor(getResources().getColor(i.c.green_text_color));
        this.oOu.setVisibility(8);
      }
      else
      {
        this.oQq.setText(i.j.sns_location_tips);
        this.oQq.setTextColor(getResources().getColor(i.c.normal_text_color));
        this.oOu.setVisibility(8);
      }
    }
    this.oNr.setImageResource(getNormalStateImageResource());
  }
  
  private void bHC()
  {
    boolean bool;
    if (this.oQx != null)
    {
      bool = this.oQx.bHE();
      localObject = this.oQx.bHD();
      if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {}
    }
    else
    {
      return;
    }
    Object localObject = ((ArrayList)localObject).iterator();
    label50:
    h localh;
    int j;
    int k;
    if (((Iterator)localObject).hasNext())
    {
      Exif.a locala = (Exif.a)((Iterator)localObject).next();
      y.d("MicroMsg.LocationWidget", "snsreport lat lng %f, %f", new Object[] { Double.valueOf(locala.latitude), Double.valueOf(locala.longitude) });
      localh = h.nFQ;
      j = (int)(locala.latitude * 1000000.0D);
      k = (int)(locala.longitude * 1000000.0D);
      if (!bool) {
        break label184;
      }
    }
    label184:
    for (int i = 1;; i = 2)
    {
      localh.f(11345, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(2) });
      break label50;
      break;
    }
  }
  
  private void bHz()
  {
    int i = 0;
    y.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", new Object[] { Integer.valueOf(this.oQp), this.oQt, Integer.valueOf(this.oQu), Integer.valueOf(this.cCu), Boolean.valueOf(bm.csh()) });
    if ((bm.csh()) || (this.oQp == 0) || (bk.bl(this.oQt)) || (this.oQu == 1) || ((this.cCu & 0x1) == 0)) {
      this.oQm.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.oQm.setVisibility(0);
      while (i < this.score)
      {
        this.oQo[i].setImageResource(getSelectedStarImageResource());
        i += 1;
      }
      i = this.score;
      while (i < 5)
      {
        this.oQo[i].setImageResource(getNormalStarImageResource());
        i += 1;
      }
    }
  }
  
  private void i(MMActivity paramMMActivity)
  {
    this.fyk = paramMMActivity;
    View localView = View.inflate(paramMMActivity, getLayoutResource(), this);
    this.oQl = localView.findViewById(i.f.location_contentview);
    this.oQq = ((TextView)this.oQl.findViewById(i.f.location_tips));
    this.oOu = ((TextView)this.oQl.findViewById(i.f.location_poi));
    this.oNr = ((ImageView)this.oQl.findViewById(i.f.location_iv));
    this.oQm = localView.findViewById(i.f.score_contentview);
    int i = 0;
    while (i < 5)
    {
      this.oQo[i] = ((ImageView)this.oQm.findViewById(this.oQn[i]));
      this.oQo[i].setOnClickListener(new LocationWidget.1(this, i));
      i += 1;
    }
    this.lIe = com.tencent.mm.modelgeo.b.NZ();
    this.oQl.setOnClickListener(new LocationWidget.2(this));
    this.oQt = paramMMActivity.getIntent().getStringExtra("kpoi_id");
    if (!bk.bl(this.oQt))
    {
      this.elk = paramMMActivity.getIntent().getFloatExtra("k_lat", -1000.0F);
      this.ell = paramMMActivity.getIntent().getFloatExtra("k_lng", -1000.0F);
      this.lFn = paramMMActivity.getIntent().getStringExtra("kpoi_name");
      this.oQs = paramMMActivity.getIntent().getStringExtra("Kpoi_address");
      bHB();
    }
    if (com.tencent.mm.kernel.g.DN().Dc()) {}
    for (this.oQp = bk.getInt(com.tencent.mm.m.g.AA().getValue("SnsPostPOICommentSwitch"), 0);; this.oQp = 0)
    {
      bHz();
      return;
    }
  }
  
  public final boolean U(Intent paramIntent)
  {
    if (paramIntent == null) {
      return true;
    }
    this.oQu = paramIntent.getIntExtra("get_poi_classify_type", 0);
    this.cCu = paramIntent.getIntExtra("get_poi_showflag", 0);
    y.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", new Object[] { Integer.valueOf(this.oQu) });
    this.lFn = bk.aM(paramIntent.getStringExtra("get_poi_name"), "");
    this.cCB = bk.aM(paramIntent.getStringExtra("get_city"), "");
    this.elk = paramIntent.getFloatExtra("get_lat", -1000.0F);
    this.ell = paramIntent.getFloatExtra("get_lng", -1000.0F);
    y.i("MicroMsg.LocationWidget", "check cur lat " + this.oQv + " " + this.mEI);
    this.oQv = paramIntent.getFloatExtra("get_cur_lat", 0.0F);
    this.mEI = paramIntent.getFloatExtra("get_cur_lng", 0.0F);
    this.oQw = paramIntent.getIntExtra("get_loctype", -1);
    this.aXH = paramIntent.getFloatExtra("get_accuracy", 0.0F);
    this.elu = paramIntent.getBooleanExtra("get_is_mars", true);
    this.lJQ = paramIntent.getStringExtra("request_id");
    Object localObject = com.tencent.mm.modelstat.e.Rq();
    boolean bool;
    if (this.oQw == 0)
    {
      bool = false;
      ((com.tencent.mm.modelstat.e)localObject).a(2003, bool, this.elu, this.ell, this.elk, (int)this.aXH);
      this.oQr = paramIntent.getByteArrayExtra("location_ctx");
      if (bk.bl(this.lFn)) {
        break label596;
      }
      this.oQs = bk.aM(paramIntent.getStringExtra("get_poi_address"), "");
      this.oQt = bk.aM(paramIntent.getStringExtra("get_poi_classify_id"), "");
      this.mFj = new atn();
    }
    for (;;)
    {
      try
      {
        this.mFj = ((atn)this.mFj.aH(paramIntent.getByteArrayExtra("get_poi_item_buf")));
        if (!bk.bl(this.oQt))
        {
          this.mFj = new atn();
          this.mFj.mDU = this.oQt;
          this.mFj.hQR = this.oQu;
          this.mFj.bGw = this.lFn;
          this.mFj.mDZ.add(new bml().YI(this.oQs));
        }
        y.d("MicroMsg.LocationWidget", "label %s poiname %s", new Object[] { this.oQs, this.lFn });
        bHB();
        bHz();
        this.oQz = new LocationWidget.b(this);
        localObject = this.oQz;
        if (paramIntent == null) {
          break;
        }
        ((LocationWidget.b)localObject).index = paramIntent.getIntExtra("report_index", -1);
        ((LocationWidget.b)localObject).mEL = paramIntent.getLongExtra("first_start_time", 0L);
        ((LocationWidget.b)localObject).mEM = paramIntent.getLongExtra("lastSuccStamp", 0L);
        ((LocationWidget.b)localObject).mEN = paramIntent.getLongExtra("firstSuccStamp", 0L);
        ((LocationWidget.b)localObject).mEO = paramIntent.getIntExtra("reqLoadCnt", 0);
        ((LocationWidget.b)localObject).lJg = paramIntent.getIntExtra("entry_time", 0);
        ((LocationWidget.b)localObject).fTF = paramIntent.getStringExtra("search_id");
        return true;
        bool = true;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        this.mFj = null;
        continue;
      }
      label596:
      if (!bk.bl(this.cCB))
      {
        this.lFn = "";
        this.oQs = "";
        this.oQt = "";
        this.mFj = null;
      }
      else
      {
        this.elk = -1000.0F;
        this.ell = -1000.0F;
        this.lFn = "";
        this.oQs = "";
        this.cCB = "";
        this.oQt = "";
        this.mFj = null;
      }
    }
  }
  
  public final void bHA()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("near_life_scene", 1);
    try
    {
      localIntent.putExtra("get_poi_item_buf", this.mFj.toByteArray());
      if (!bk.bl(this.oQt))
      {
        localIntent.putExtra("get_poi_classify_id", this.oQt);
        localIntent.putExtra("get_lat", this.elk);
        localIntent.putExtra("get_lng", this.ell);
        localIntent.putExtra("request_id", this.lJQ);
        if (this.oQx == null) {
          break label232;
        }
        Object localObject = this.oQx.bHD();
        if (localObject == null) {
          break label232;
        }
        O((ArrayList)localObject);
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
        y.printErrStackTrace("MicroMsg.LocationWidget", localException, "", new Object[0]);
        continue;
        if (!bk.bl(this.cCB)) {
          localIntent.putExtra("get_city", this.cCB);
        }
      }
      label232:
      d.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 10);
    }
  }
  
  public aui getCurLocation()
  {
    aui localaui = new aui();
    localaui.sGK = this.oQv;
    localaui.sGJ = this.mEI;
    localaui.aXH = this.aXH;
    localaui.oQw = this.oQw;
    return localaui;
  }
  
  protected int getLayoutResource()
  {
    return i.g.location_widget;
  }
  
  public aui getLocation()
  {
    aui localaui = new aui();
    localaui.sGK = this.elk;
    localaui.sGJ = this.ell;
    localaui.tpT = 0;
    localaui.score = this.score;
    if (this.oQr != null) {
      localaui.tpU = new com.tencent.mm.bv.b(this.oQr);
    }
    if (!bk.bl(this.lFn))
    {
      localaui.oQs = this.oQs;
      localaui.lFn = this.lFn;
      localaui.tpQ = this.oQt;
      localaui.ffj = this.cCB;
      if ((this.oQu != 0) && (this.oQu == 1))
      {
        localaui.oQu = 2;
        y.d("MicroMsg.LocationWidget", "getlocation type %d", new Object[] { Integer.valueOf(localaui.oQu) });
      }
    }
    for (;;)
    {
      if (this.oQz != null)
      {
        String str = String.format("%f/%f", new Object[] { Float.valueOf(localaui.sGK), Float.valueOf(localaui.sGJ) });
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("index " + this.oQz.index);
        localStringBuffer.append("firstStartStamp " + this.oQz.mEL);
        localStringBuffer.append("lastSuccStamp " + this.oQz.mEN);
        localStringBuffer.append("firstSuccStamp " + this.oQz.mEM);
        localStringBuffer.append("reqLoadCnt " + this.oQz.mEO);
        localStringBuffer.append("classifyId " + this.oQt);
        localStringBuffer.append("entryTime " + this.oQz.lJg);
        localStringBuffer.append("searchId" + this.oQz.fTF);
        y.d("MicroMsg.LocationWidget", "report %s", new Object[] { localStringBuffer.toString() });
        h.nFQ.f(11135, new Object[] { Integer.valueOf(5), Integer.valueOf(this.oQz.index + 1), Long.valueOf(this.oQz.mEL), Long.valueOf(this.oQz.mEN), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.oQz.mEM), Integer.valueOf(this.oQz.mEO), str, this.oQt, Integer.valueOf(this.oQz.lJg), this.oQz.fTF, com.tencent.mm.compatible.e.q.zf() });
      }
      bHC();
      return localaui;
      localaui.oQu = 1;
      break;
      if (!bk.bl(this.cCB)) {
        localaui.ffj = this.cCB;
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
    return this.cCu;
  }
  
  public void setLocationWidgetListener(LocationWidget.a parama)
  {
    this.oQx = parama;
  }
  
  public final void stop()
  {
    if (this.mEC != null) {
      this.mEC.c(this.mEU);
    }
    if (this.lIe != null) {
      this.lIe.a(this.lCS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget
 * JD-Core Version:    0.7.0.1
 */