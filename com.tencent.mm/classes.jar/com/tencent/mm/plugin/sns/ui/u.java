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
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.b.a.dz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class u
  implements ad
{
  private static com.tencent.mm.loader.c.e Aer;
  private static int EpR;
  private static int EpS;
  private static int EpT;
  private IListener DLK;
  private ImageView EpU;
  private ImageIndicatorView EpV;
  private com.tencent.mm.modelsns.e EpW;
  private int EpX;
  private String appId;
  private String appName;
  private String eam;
  private MMActivity gte;
  private ImageView mEx;
  private String mSessionId;
  private View sc;
  private boolean thE;
  private String title;
  
  static
  {
    AppMethodBeat.i(203245);
    EpR = -1;
    EpS = 0;
    EpT = 1;
    e.a locala = new e.a();
    locala.hZJ = true;
    locala.hZI = true;
    Aer = locala.aJT();
    AppMethodBeat.o(203245);
  }
  
  public u(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(203237);
    this.gte = null;
    this.title = "";
    this.sc = null;
    this.mEx = null;
    this.EpU = null;
    this.EpV = null;
    this.EpW = null;
    this.EpX = EpR;
    this.DLK = new IListener() {};
    this.gte = paramMMActivity;
    AppMethodBeat.o(203237);
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(203241);
    paramLinkedList = new bf(28, this.gte);
    if (this.EpW != null) {
      paramLinkedList.a(this.EpW);
    }
    paramPInt.value = paramLinkedList.beK;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.DCT) {
      paramLinkedList.YF(4);
    }
    paramLinkedList.aPB(this.title).aPw(paramString1);
    paramLinkedList.aPz(Util.nullAs(this.gte.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
    paramLinkedList.YI(paramInt1);
    if (paramBoolean) {
      paramLinkedList.YL(1);
    }
    for (;;)
    {
      paramLinkedList.gR(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.i.a.gnq();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          ebm localebm = new ebm();
          localebm.UserName = paramPInt;
          paramString1.add(localebm);
        }
      }
      paramLinkedList.YL(0);
    }
    if (parami != null) {
      paramLinkedList.kl(parami.token, parami.Mte);
    }
    paramLinkedList.bq(paramString1);
    if (!Util.isNullOrNil(this.appId)) {
      paramLinkedList.aPC(this.appId);
    }
    if (!Util.isNullOrNil(this.appName)) {
      paramLinkedList.aPD(Util.nullAs(this.appName, ""));
    }
    paramLinkedList.a(paramcjy);
    paramLinkedList.aPy(paramString2);
    paramLinkedList.aPH(this.eam);
    paramLinkedList.setSessionId(this.mSessionId);
    if (ffF())
    {
      if (this.EpX != EpR) {
        break label444;
      }
      if (paramLinkedList.DPf != null) {
        paramLinkedList.DPf.setPostHolding();
      }
    }
    paramInt1 = paramLinkedList.commit();
    if (this.EpX == EpT)
    {
      com.tencent.mm.plugin.sns.k.e.DUQ.DVE.esJ = 1L;
      com.tencent.mm.plugin.sns.k.e.DUQ.fcF();
    }
    for (com.tencent.mm.plugin.sns.k.e.DUQ.DVD = 0;; com.tencent.mm.plugin.sns.k.e.DUQ.DVD = paramInt1)
    {
      if (this.thE) {
        com.tencent.mm.plugin.sns.k.e.DUQ.DVC = paramInt1;
      }
      com.tencent.mm.plugin.sns.model.aj.faK().eZn();
      this.gte.finish();
      AppMethodBeat.o(203241);
      return false;
      label444:
      if ((this.EpX != EpT) || (paramLinkedList.DPf == null)) {
        break;
      }
      paramLinkedList.DPf.setItemDie();
      break;
    }
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(203239);
    this.title = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.eam = Util.nullAs(this.gte.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = Util.nullAs(this.gte.getIntent().getStringExtra("reportSessionId"), "");
    this.appId = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.thE = this.gte.getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
    int i = this.gte.getIntent().getIntExtra("finder_post_from_sns_type", 3);
    com.tencent.mm.plugin.sns.k.e.DUQ.Aqq = this.gte.getIntent().getLongExtra("finder_feed_id", 0L);
    paramBundle = this.gte.getIntent().getStringExtra("ksnsupload_finder_object_xml");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "finderFeed", null);
      if (paramBundle != null)
      {
        this.EpW = new com.tencent.mm.modelsns.e();
        this.EpW.j("", paramBundle);
      }
    }
    paramBundle = r.eZx();
    com.tencent.mm.plugin.sns.k.e.DUQ.DVE.evg = i;
    dz localdz = com.tencent.mm.plugin.sns.k.e.DUQ.DVE;
    localdz.eBX = localdz.x("MonmentSessionId", paramBundle, true);
    if ((this.EpW != null) && (this.EpW.jlg != null)) {
      com.tencent.mm.plugin.sns.k.e.DUQ.DVE.ql(this.EpW.jlg.objectId);
    }
    EventCenter.instance.addListener(this.DLK);
    AppMethodBeat.o(203239);
  }
  
  public final void aD(Bundle paramBundle) {}
  
  public final boolean ffA()
  {
    return this.EpW != null;
  }
  
  public final View ffB()
  {
    AppMethodBeat.i(203240);
    this.sc = aa.jQ(this.gte).inflate(2131496437, null);
    this.mEx = ((ImageView)this.sc.findViewById(2131308127));
    this.EpU = ((ImageView)this.sc.findViewById(2131308126));
    this.EpV = ((ImageIndicatorView)this.sc.findViewById(2131308124));
    Object localObject1;
    bch localbch;
    Object localObject2;
    if ((this.EpW != null) && (this.EpW.jlg != null))
    {
      localObject1 = this.EpW.jlg;
      if (!Util.isNullOrNil(((bcj)localObject1).mediaList))
      {
        localbch = (bch)((bcj)localObject1).mediaList.get(0);
        if (((bcj)localObject1).vXJ != 4) {
          break label266;
        }
        localObject2 = n.a((int)localbch.width, (int)localbch.height, this.gte, false);
        localObject2 = new ViewGroup.LayoutParams(((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
        this.sc.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.sc.requestLayout();
        ((com.tencent.mm.plugin.i.a.aj)g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImage(localbch.thumbUrl, this.mEx);
      }
      if (((bcj)localObject1).vXJ != 4) {
        break label330;
      }
      this.EpU.setVisibility(0);
      this.EpV.setVisibility(8);
    }
    for (;;)
    {
      this.sc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(203236);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/FinderMediaWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          u.b(u.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/FinderMediaWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203236);
        }
      });
      localObject1 = this.sc;
      AppMethodBeat.o(203240);
      return localObject1;
      label266:
      localObject2 = n.a((int)localbch.width, (int)localbch.height, this.gte);
      localObject2 = new ViewGroup.LayoutParams(((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
      this.sc.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.sc.requestLayout();
      break;
      label330:
      this.EpU.setVisibility(8);
      this.EpV.setVisibility(8);
      this.EpV.FdA = ((bcj)localObject1).dJl;
    }
  }
  
  public final boolean ffC()
  {
    return true;
  }
  
  public final boolean ffD()
  {
    AppMethodBeat.i(203243);
    boolean bool = ffF();
    AppMethodBeat.o(203243);
    return bool;
  }
  
  public final boolean ffE()
  {
    AppMethodBeat.i(203242);
    EventCenter.instance.removeListener(this.DLK);
    AppMethodBeat.o(203242);
    return false;
  }
  
  final boolean ffF()
  {
    AppMethodBeat.i(203238);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.EpW != null)
    {
      bool1 = bool2;
      if (this.EpW.jlg != null)
      {
        bool1 = bool2;
        if (this.EpW.jlg.localId > 0L)
        {
          bool1 = bool2;
          if (r.aOw(this.EpW.jlg.objectId) <= 0L)
          {
            bool1 = bool2;
            if (Util.isNullOrNil(this.EpW.jlg.objectNonceId)) {
              bool1 = true;
            }
          }
        }
      }
    }
    AppMethodBeat.o(203238);
    return bool1;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.u
 * JD-Core Version:    0.7.0.1
 */