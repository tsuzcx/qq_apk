package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.mmdata.rpt.gj;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class v
  implements ag
{
  private static com.tencent.mm.loader.b.e LGf;
  private static int RcL;
  private static int RcM;
  private static int RcN;
  private boolean Akx;
  private IListener QvW;
  private ImageView RcO;
  private ImageIndicatorView RcP;
  private com.tencent.mm.modelsns.e RcQ;
  private int RcR;
  private String appId;
  private String appName;
  private View doN;
  private String iag;
  private MMActivity lzt;
  private String mSessionId;
  private ImageView sIV;
  private String title;
  
  static
  {
    AppMethodBeat.i(308002);
    RcL = -1;
    RcM = 0;
    RcN = 1;
    e.a locala = new e.a();
    locala.nqd = true;
    locala.nqc = true;
    LGf = locala.blI();
    AppMethodBeat.o(308002);
  }
  
  public v(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(307990);
    this.lzt = null;
    this.title = "";
    this.doN = null;
    this.sIV = null;
    this.RcO = null;
    this.RcP = null;
    this.RcQ = null;
    this.RcR = RcL;
    this.QvW = new FinderMediaWidget.1(this, f.hfK);
    this.lzt = paramMMActivity;
    AppMethodBeat.o(307990);
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, djv paramdjv, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(308022);
    paramLinkedList = new bg(28, this.lzt);
    if (this.RcQ != null) {
      paramLinkedList.a(this.RcQ);
    }
    paramPInt.value = paramLinkedList.cIh;
    if (paramInt3 > com.tencent.mm.plugin.sns.d.a.Qkq) {
      paramLinkedList.akL(4);
    }
    paramLinkedList.aYR(this.title).aYM(paramString1);
    paramLinkedList.aYP(Util.nullAs(this.lzt.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
    paramLinkedList.akO(paramInt1);
    if (paramBoolean) {
      paramLinkedList.akR(1);
    }
    for (;;)
    {
      paramLinkedList.kB(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.platformtools.a.iIX();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if ((paramList2 != null) && (!paramList2.contains(paramPInt)))
        {
          ffw localffw = new ffw();
          localffw.UserName = paramPInt;
          paramString1.add(localffw);
        }
      }
      paramLinkedList.akR(0);
    }
    if (parami != null) {
      paramLinkedList.mm(parami.token, parami.aaTQ);
    }
    paramLinkedList.bU(paramString1);
    if (!Util.isNullOrNil(this.appId)) {
      paramLinkedList.aYS(this.appId);
    }
    if (!Util.isNullOrNil(this.appName)) {
      paramLinkedList.aYT(Util.nullAs(this.appName, ""));
    }
    paramLinkedList.a(paramdjv);
    paramLinkedList.aYO(paramString2);
    paramLinkedList.aYX(this.iag);
    paramLinkedList.setSessionId(this.mSessionId);
    if (hlV())
    {
      if (this.RcR != RcL) {
        break label449;
      }
      if (paramLinkedList.QzC != null) {
        paramLinkedList.QzC.setPostHolding();
      }
    }
    paramInt1 = paramLinkedList.FW();
    if (this.RcR == RcN)
    {
      j.QFS.QGI.iyr = 1L;
      j.QFS.hiw();
    }
    for (j.QFS.QGH = 0;; j.QFS.QGH = paramInt1)
    {
      if (this.Akx) {
        j.QFS.QGG = paramInt1;
      }
      al.hgx().hej();
      this.lzt.finish();
      AppMethodBeat.o(308022);
      return false;
      label449:
      if ((this.RcR != RcN) || (paramLinkedList.QzC == null)) {
        break;
      }
      paramLinkedList.QzC.setItemDie();
      break;
    }
  }
  
  public final void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(308005);
    this.title = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.iag = Util.nullAs(this.lzt.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = Util.nullAs(this.lzt.getIntent().getStringExtra("reportSessionId"), "");
    this.appId = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Akx = this.lzt.getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
    int i = this.lzt.getIntent().getIntExtra("finder_post_from_sns_type", 3);
    j.QFS.LYR = this.lzt.getIntent().getLongExtra("finder_feed_id", 0L);
    paramBundle = this.lzt.getIntent().getStringExtra("ksnsupload_finder_object_xml");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "finderFeed", null);
      if (paramBundle != null)
      {
        this.RcQ = new com.tencent.mm.modelsns.e();
        this.RcQ.i("", paramBundle);
      }
    }
    paramBundle = t.heR();
    j.QFS.QGI.iAZ = i;
    gj localgj = j.QFS.QGI;
    localgj.iKT = localgj.F("MonmentSessionId", paramBundle, true);
    if ((this.RcQ != null) && (this.RcQ.oUc != null)) {
      j.QFS.QGI.qT(this.RcQ.oUc.objectId);
    }
    this.QvW.alive();
    AppMethodBeat.o(308005);
  }
  
  public final void ba(Bundle paramBundle) {}
  
  public final boolean hlP()
  {
    return this.RcQ != null;
  }
  
  public final View hlQ()
  {
    AppMethodBeat.i(308014);
    this.doN = af.mU(this.lzt).inflate(b.g.sns_finder_media_item, null);
    this.sIV = ((ImageView)this.doN.findViewById(b.f.sns_finder_media_thumb));
    this.RcO = ((ImageView)this.doN.findViewById(b.f.sns_finder_media_status_icon));
    this.RcP = ((ImageIndicatorView)this.doN.findViewById(b.f.sns_finder_media_image_count_indicator));
    Object localObject1;
    bvj localbvj;
    Object localObject2;
    if ((this.RcQ != null) && (this.RcQ.oUc != null))
    {
      localObject1 = this.RcQ.oUc;
      if (!Util.isNullOrNil(((bvl)localObject1).mediaList))
      {
        localbvj = (bvj)((bvl)localObject1).mediaList.get(0);
        if (((bvl)localObject1).GfT != 4) {
          break label266;
        }
        localObject2 = o.a((int)localbvj.width, (int)localbvj.height, this.lzt, false);
        localObject2 = new ViewGroup.LayoutParams(((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
        this.doN.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.doN.requestLayout();
        ((cn)h.az(cn.class)).loadImage(localbvj.thumbUrl, this.sIV);
      }
      if (((bvl)localObject1).GfT != 4) {
        break label330;
      }
      this.RcO.setVisibility(0);
      this.RcP.setVisibility(8);
    }
    for (;;)
    {
      this.doN.setOnClickListener(new v.1(this));
      localObject1 = this.doN;
      AppMethodBeat.o(308014);
      return localObject1;
      label266:
      localObject2 = o.a((int)localbvj.width, (int)localbvj.height, this.lzt);
      localObject2 = new ViewGroup.LayoutParams(((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
      this.doN.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.doN.requestLayout();
      break;
      label330:
      this.RcO.setVisibility(8);
      this.RcP.setVisibility(8);
      this.RcP.RVj = ((bvl)localObject1).hGP;
    }
  }
  
  public final boolean hlR()
  {
    return true;
  }
  
  public final boolean hlS()
  {
    AppMethodBeat.i(308029);
    boolean bool = hlV();
    AppMethodBeat.o(308029);
    return bool;
  }
  
  public final boolean hlT()
  {
    AppMethodBeat.i(308027);
    this.QvW.dead();
    AppMethodBeat.o(308027);
    return false;
  }
  
  final boolean hlV()
  {
    AppMethodBeat.i(308003);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.RcQ != null)
    {
      bool1 = bool2;
      if (this.RcQ.oUc != null)
      {
        bool1 = bool2;
        if (this.RcQ.oUc.localId > 0L)
        {
          bool1 = bool2;
          if (t.aXD(this.RcQ.oUc.objectId) <= 0L)
          {
            bool1 = bool2;
            if (Util.isNullOrNil(this.RcQ.oUc.objectNonceId)) {
              bool1 = true;
            }
          }
        }
      }
    }
    AppMethodBeat.o(308003);
    return bool1;
  }
  
  public final boolean n(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.v
 * JD-Core Version:    0.7.0.1
 */