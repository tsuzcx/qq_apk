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
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class aj
  implements af
{
  private static e FKT;
  private ImageView KDh = null;
  private ImageIndicatorView KDi = null;
  private com.tencent.mm.modelsns.h KFi = null;
  private String appId;
  private String appName;
  private View bvK = null;
  private String fUj;
  private MMActivity iXq = null;
  private String mSessionId;
  private ImageView pDJ = null;
  private String title = "";
  private boolean wNV;
  
  static
  {
    AppMethodBeat.i(270705);
    e.a locala = new e.a();
    locala.kOp = true;
    locala.kOo = true;
    FKT = locala.aRT();
    AppMethodBeat.o(270705);
  }
  
  public aj(MMActivity paramMMActivity)
  {
    this.iXq = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, cst paramcst, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(270703);
    paramLinkedList = new be(36, this.iXq);
    if (this.KFi != null) {
      paramLinkedList.a(this.KFi);
    }
    paramPInt.value = paramLinkedList.aOl;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.JPj) {
      paramLinkedList.afW(4);
    }
    paramLinkedList.bax(this.title).bas(paramString1);
    paramLinkedList.bav(Util.nullAs(this.iXq.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
    paramLinkedList.afZ(paramInt1);
    if (paramBoolean) {
      paramLinkedList.agc(1);
    }
    for (;;)
    {
      paramLinkedList.hA(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.j.a.hhW();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          elm localelm = new elm();
          localelm.UserName = paramPInt;
          paramString1.add(localelm);
        }
      }
      paramLinkedList.agc(0);
    }
    if (parami != null) {
      paramLinkedList.kG(parami.token, parami.TEk);
    }
    paramLinkedList.bL(paramString1);
    if (!Util.isNullOrNil(this.appId)) {
      paramLinkedList.bay(this.appId);
    }
    if (!Util.isNullOrNil(this.appName)) {
      paramLinkedList.baz(Util.nullAs(this.appName, ""));
    }
    paramLinkedList.a(paramcst);
    paramLinkedList.bau(paramString2);
    paramLinkedList.baD(this.fUj);
    paramLinkedList.setSessionId(this.mSessionId);
    paramInt1 = paramLinkedList.in();
    if (this.wNV) {
      g.Kia.KiM = paramInt1;
    }
    com.tencent.mm.plugin.sns.model.aj.fOE().fNd();
    this.iXq.finish();
    AppMethodBeat.o(270703);
    return false;
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(270701);
    this.title = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.fUj = Util.nullAs(this.iXq.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = Util.nullAs(this.iXq.getIntent().getStringExtra("reportSessionId"), "");
    this.appId = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.wNV = this.iXq.getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
    g.Kia.Gdf = this.iXq.getIntent().getLongExtra("finder_feed_id", 0L);
    paramBundle = this.iXq.getIntent().getStringExtra("ksnsupload_mega_video_object_xml");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "finderMegaVideo", null);
      if (paramBundle != null)
      {
        this.KFi = new com.tencent.mm.modelsns.h();
        this.KFi.i("", paramBundle);
      }
    }
    AppMethodBeat.o(270701);
  }
  
  public final void az(Bundle paramBundle) {}
  
  public final boolean fTA()
  {
    return false;
  }
  
  public final boolean fTw()
  {
    return this.KFi != null;
  }
  
  public final View fTx()
  {
    AppMethodBeat.i(270702);
    this.bvK = ad.kS(this.iXq).inflate(i.g.sns_finder_media_item, null);
    this.pDJ = ((ImageView)this.bvK.findViewById(i.f.sns_finder_media_thumb));
    this.KDh = ((ImageView)this.bvK.findViewById(i.f.sns_finder_media_status_icon));
    this.KDi = ((ImageIndicatorView)this.bvK.findViewById(i.f.sns_finder_media_image_count_indicator));
    Object localObject1;
    if ((this.KFi != null) && (this.KFi.mbk != null))
    {
      localObject1 = this.KFi.mbk;
      if (!Util.isNullOrNil(((cwx)localObject1).mediaList))
      {
        localObject1 = (cww)((cwx)localObject1).mediaList.get(0);
        Object localObject2 = o.a((int)((cww)localObject1).width, (int)((cww)localObject1).height, this.iXq, false);
        localObject2 = new ViewGroup.LayoutParams(((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
        this.bvK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.bvK.requestLayout();
        if (TextUtils.isEmpty(((cww)localObject1).coverUrl)) {
          break label260;
        }
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadImage(((cww)localObject1).coverUrl, this.pDJ);
      }
    }
    for (;;)
    {
      this.KDh.setVisibility(0);
      this.KDi.setVisibility(8);
      this.bvK.setOnClickListener(new aj.1(this));
      localObject1 = this.bvK;
      AppMethodBeat.o(270702);
      return localObject1;
      label260:
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadImage(((cww)localObject1).thumbUrl, this.pDJ);
    }
  }
  
  public final boolean fTy()
  {
    return true;
  }
  
  public final boolean fTz()
  {
    return true;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aj
 * JD-Core Version:    0.7.0.1
 */