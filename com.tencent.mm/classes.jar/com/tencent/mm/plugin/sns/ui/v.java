package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.in;
import com.tencent.mm.f.b.a.ev;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class v
  implements af
{
  private static com.tencent.mm.loader.c.e FKT;
  private static int KDe;
  private static int KDf;
  private static int KDg;
  private IListener JYL;
  private ImageView KDh;
  private ImageIndicatorView KDi;
  private com.tencent.mm.modelsns.e KDj;
  private int KDk;
  private String appId;
  private String appName;
  private View bvK;
  private String fUj;
  private MMActivity iXq;
  private String mSessionId;
  private ImageView pDJ;
  private String title;
  private boolean wNV;
  
  static
  {
    AppMethodBeat.i(270372);
    KDe = -1;
    KDf = 0;
    KDg = 1;
    e.a locala = new e.a();
    locala.kOp = true;
    locala.kOo = true;
    FKT = locala.aRT();
    AppMethodBeat.o(270372);
  }
  
  public v(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(270345);
    this.iXq = null;
    this.title = "";
    this.bvK = null;
    this.pDJ = null;
    this.KDh = null;
    this.KDi = null;
    this.KDj = null;
    this.KDk = KDe;
    this.JYL = new IListener() {};
    this.iXq = paramMMActivity;
    AppMethodBeat.o(270345);
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, cst paramcst, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(270358);
    paramLinkedList = new be(28, this.iXq);
    if (this.KDj != null) {
      paramLinkedList.a(this.KDj);
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
    if (fTC())
    {
      if (this.KDk != KDe) {
        break label444;
      }
      if (paramLinkedList.Kcm != null) {
        paramLinkedList.Kcm.setPostHolding();
      }
    }
    paramInt1 = paramLinkedList.in();
    if (this.KDk == KDg)
    {
      g.Kia.KiO.goQ = 1L;
      g.Kia.fQy();
    }
    for (g.Kia.KiN = 0;; g.Kia.KiN = paramInt1)
    {
      if (this.wNV) {
        g.Kia.KiM = paramInt1;
      }
      aj.fOE().fNd();
      this.iXq.finish();
      AppMethodBeat.o(270358);
      return false;
      label444:
      if ((this.KDk != KDg) || (paramLinkedList.Kcm == null)) {
        break;
      }
      paramLinkedList.Kcm.setItemDie();
      break;
    }
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(270348);
    this.title = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.fUj = Util.nullAs(this.iXq.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = Util.nullAs(this.iXq.getIntent().getStringExtra("reportSessionId"), "");
    this.appId = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.wNV = this.iXq.getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
    int i = this.iXq.getIntent().getIntExtra("finder_post_from_sns_type", 3);
    g.Kia.Gdf = this.iXq.getIntent().getLongExtra("finder_feed_id", 0L);
    paramBundle = this.iXq.getIntent().getStringExtra("ksnsupload_finder_object_xml");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "finderFeed", null);
      if (paramBundle != null)
      {
        this.KDj = new com.tencent.mm.modelsns.e();
        this.KDj.i("", paramBundle);
      }
    }
    paramBundle = t.fNp();
    g.Kia.KiO.grk = i;
    ev localev = g.Kia.KiO;
    localev.gyE = localev.z("MonmentSessionId", paramBundle, true);
    if ((this.KDj != null) && (this.KDj.mbi != null)) {
      g.Kia.KiO.tg(this.KDj.mbi.objectId);
    }
    EventCenter.instance.addListener(this.JYL);
    AppMethodBeat.o(270348);
  }
  
  public final void az(Bundle paramBundle) {}
  
  public final boolean fTA()
  {
    AppMethodBeat.i(270361);
    EventCenter.instance.removeListener(this.JYL);
    AppMethodBeat.o(270361);
    return false;
  }
  
  final boolean fTC()
  {
    AppMethodBeat.i(270346);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.KDj != null)
    {
      bool1 = bool2;
      if (this.KDj.mbi != null)
      {
        bool1 = bool2;
        if (this.KDj.mbi.localId > 0L)
        {
          bool1 = bool2;
          if (t.aZs(this.KDj.mbi.objectId) <= 0L)
          {
            bool1 = bool2;
            if (Util.isNullOrNil(this.KDj.mbi.objectNonceId)) {
              bool1 = true;
            }
          }
        }
      }
    }
    AppMethodBeat.o(270346);
    return bool1;
  }
  
  public final boolean fTw()
  {
    return this.KDj != null;
  }
  
  public final View fTx()
  {
    AppMethodBeat.i(270352);
    this.bvK = ad.kS(this.iXq).inflate(i.g.sns_finder_media_item, null);
    this.pDJ = ((ImageView)this.bvK.findViewById(i.f.sns_finder_media_thumb));
    this.KDh = ((ImageView)this.bvK.findViewById(i.f.sns_finder_media_status_icon));
    this.KDi = ((ImageIndicatorView)this.bvK.findViewById(i.f.sns_finder_media_image_count_indicator));
    Object localObject1;
    bjc localbjc;
    Object localObject2;
    if ((this.KDj != null) && (this.KDj.mbi != null))
    {
      localObject1 = this.KDj.mbi;
      if (!Util.isNullOrNil(((bje)localObject1).mediaList))
      {
        localbjc = (bjc)((bje)localObject1).mediaList.get(0);
        if (((bje)localObject1).ACQ != 4) {
          break label266;
        }
        localObject2 = o.a((int)localbjc.width, (int)localbjc.height, this.iXq, false);
        localObject2 = new ViewGroup.LayoutParams(((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
        this.bvK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.bvK.requestLayout();
        ((ak)h.ag(ak.class)).loadImage(localbjc.thumbUrl, this.pDJ);
      }
      if (((bje)localObject1).ACQ != 4) {
        break label330;
      }
      this.KDh.setVisibility(0);
      this.KDi.setVisibility(8);
    }
    for (;;)
    {
      this.bvK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(205984);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/FinderMediaWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          v.b(v.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/FinderMediaWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205984);
        }
      });
      localObject1 = this.bvK;
      AppMethodBeat.o(270352);
      return localObject1;
      label266:
      localObject2 = o.a((int)localbjc.width, (int)localbjc.height, this.iXq);
      localObject2 = new ViewGroup.LayoutParams(((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
      this.bvK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.bvK.requestLayout();
      break;
      label330:
      this.KDh.setVisibility(8);
      this.KDi.setVisibility(8);
      this.KDi.Lsg = ((bje)localObject1).fCa;
    }
  }
  
  public final boolean fTy()
  {
    return true;
  }
  
  public final boolean fTz()
  {
    AppMethodBeat.i(270363);
    boolean bool = fTC();
    AppMethodBeat.o(270363);
    return bool;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.v
 * JD-Core Version:    0.7.0.1
 */