package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.e;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ak
  implements ag
{
  private static e LGf;
  private boolean Akx;
  private ImageView RcO = null;
  private ImageIndicatorView RcP = null;
  private com.tencent.mm.modelsns.h ReI = null;
  private String appId;
  private String appName;
  private View doN = null;
  private String iag;
  private MMActivity lzt = null;
  private String mSessionId;
  private ImageView sIV = null;
  private String title = "";
  
  static
  {
    AppMethodBeat.i(308486);
    e.a locala = new e.a();
    locala.nqd = true;
    locala.nqc = true;
    LGf = locala.blI();
    AppMethodBeat.o(308486);
  }
  
  public ak(MMActivity paramMMActivity)
  {
    this.lzt = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, djv paramdjv, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(308496);
    paramLinkedList = new bg(36, this.lzt);
    if (this.ReI != null) {
      paramLinkedList.a(this.ReI);
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
    paramInt1 = paramLinkedList.FW();
    if (this.Akx) {
      j.QFS.QGG = paramInt1;
    }
    al.hgx().hej();
    this.lzt.finish();
    AppMethodBeat.o(308496);
    return false;
  }
  
  public final void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(308489);
    this.title = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.iag = Util.nullAs(this.lzt.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = Util.nullAs(this.lzt.getIntent().getStringExtra("reportSessionId"), "");
    this.appId = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Akx = this.lzt.getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
    j.QFS.LYR = this.lzt.getIntent().getLongExtra("finder_feed_id", 0L);
    paramBundle = this.lzt.getIntent().getStringExtra("ksnsupload_mega_video_object_xml");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "finderMegaVideo", null);
      if (paramBundle != null)
      {
        this.ReI = new com.tencent.mm.modelsns.h();
        this.ReI.i("", paramBundle);
      }
    }
    AppMethodBeat.o(308489);
  }
  
  public final void ba(Bundle paramBundle) {}
  
  public final boolean hlP()
  {
    return this.ReI != null;
  }
  
  public final View hlQ()
  {
    AppMethodBeat.i(308491);
    this.doN = af.mU(this.lzt).inflate(b.g.sns_finder_media_item, null);
    this.sIV = ((ImageView)this.doN.findViewById(b.f.sns_finder_media_thumb));
    this.RcO = ((ImageView)this.doN.findViewById(b.f.sns_finder_media_status_icon));
    this.RcP = ((ImageIndicatorView)this.doN.findViewById(b.f.sns_finder_media_image_count_indicator));
    Object localObject1;
    if ((this.ReI != null) && (this.ReI.oUe != null))
    {
      localObject1 = this.ReI.oUe;
      if (!Util.isNullOrNil(((doc)localObject1).mediaList))
      {
        localObject1 = (dob)((doc)localObject1).mediaList.get(0);
        Object localObject2 = o.a((int)((dob)localObject1).width, (int)((dob)localObject1).height, this.lzt, false);
        localObject2 = new ViewGroup.LayoutParams(((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
        this.doN.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.doN.requestLayout();
        if (TextUtils.isEmpty(((dob)localObject1).coverUrl)) {
          break label260;
        }
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImage(((dob)localObject1).coverUrl, this.sIV);
      }
    }
    for (;;)
    {
      this.RcO.setVisibility(0);
      this.RcP.setVisibility(8);
      this.doN.setOnClickListener(new ak.1(this));
      localObject1 = this.doN;
      AppMethodBeat.o(308491);
      return localObject1;
      label260:
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImage(((dob)localObject1).thumbUrl, this.sIV);
    }
  }
  
  public final boolean hlR()
  {
    return true;
  }
  
  public final boolean hlS()
  {
    return true;
  }
  
  public final boolean hlT()
  {
    return false;
  }
  
  public final boolean n(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak
 * JD-Core Version:    0.7.0.1
 */