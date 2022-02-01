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
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ah
  implements ad
{
  private static com.tencent.mm.loader.c.e Aer;
  private ImageView EpU = null;
  private ImageIndicatorView EpV = null;
  private com.tencent.mm.modelsns.g ErO = null;
  private String appId;
  private String appName;
  private String eam;
  private MMActivity gte = null;
  private ImageView mEx = null;
  private String mSessionId;
  private View sc = null;
  private boolean thE;
  private String title = "";
  
  static
  {
    AppMethodBeat.i(203309);
    e.a locala = new e.a();
    locala.hZJ = true;
    locala.hZI = true;
    Aer = locala.aJT();
    AppMethodBeat.o(203309);
  }
  
  public ah(MMActivity paramMMActivity)
  {
    this.gte = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(203307);
    paramLinkedList = new bf(36, this.gte);
    if (this.ErO != null) {
      paramLinkedList.a(this.ErO);
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
    paramInt1 = paramLinkedList.commit();
    if (this.thE) {
      com.tencent.mm.plugin.sns.k.e.DUQ.DVC = paramInt1;
    }
    com.tencent.mm.plugin.sns.model.aj.faK().eZn();
    this.gte.finish();
    AppMethodBeat.o(203307);
    return false;
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(203305);
    this.title = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.eam = Util.nullAs(this.gte.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = Util.nullAs(this.gte.getIntent().getStringExtra("reportSessionId"), "");
    this.appId = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.thE = this.gte.getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
    com.tencent.mm.plugin.sns.k.e.DUQ.Aqq = this.gte.getIntent().getLongExtra("finder_feed_id", 0L);
    paramBundle = this.gte.getIntent().getStringExtra("ksnsupload_mega_video_object_xml");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "finderMegaVideo", null);
      if (paramBundle != null)
      {
        this.ErO = new com.tencent.mm.modelsns.g();
        this.ErO.j("", paramBundle);
      }
    }
    AppMethodBeat.o(203305);
  }
  
  public final void aD(Bundle paramBundle) {}
  
  public final boolean ffA()
  {
    return this.ErO != null;
  }
  
  public final View ffB()
  {
    AppMethodBeat.i(203306);
    this.sc = aa.jQ(this.gte).inflate(2131496437, null);
    this.mEx = ((ImageView)this.sc.findViewById(2131308127));
    this.EpU = ((ImageView)this.sc.findViewById(2131308126));
    this.EpV = ((ImageIndicatorView)this.sc.findViewById(2131308124));
    Object localObject1;
    if ((this.ErO != null) && (this.ErO.jlh != null))
    {
      localObject1 = this.ErO.jlh;
      if (!Util.isNullOrNil(((col)localObject1).mediaList))
      {
        localObject1 = (cok)((col)localObject1).mediaList.get(0);
        Object localObject2 = n.a((int)((cok)localObject1).width, (int)((cok)localObject1).height, this.gte, false);
        localObject2 = new ViewGroup.LayoutParams(((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
        this.sc.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.sc.requestLayout();
        if (TextUtils.isEmpty(((cok)localObject1).coverUrl)) {
          break label260;
        }
        ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImage(((cok)localObject1).coverUrl, this.mEx);
      }
    }
    for (;;)
    {
      this.EpU.setVisibility(0);
      this.EpV.setVisibility(8);
      this.sc.setOnClickListener(new ah.1(this));
      localObject1 = this.sc;
      AppMethodBeat.o(203306);
      return localObject1;
      label260:
      ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImage(((cok)localObject1).thumbUrl, this.mEx);
    }
  }
  
  public final boolean ffC()
  {
    return true;
  }
  
  public final boolean ffD()
  {
    return true;
  }
  
  public final boolean ffE()
  {
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ah
 * JD-Core Version:    0.7.0.1
 */