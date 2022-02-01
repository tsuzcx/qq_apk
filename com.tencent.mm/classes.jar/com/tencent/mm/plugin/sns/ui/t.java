package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class t
  implements ac
{
  private static com.tencent.mm.loader.c.e zQq;
  private String appId;
  private String appName;
  private String dHu;
  private MMActivity fLP = null;
  private ImageView lta = null;
  private String mSessionId;
  private View rY = null;
  private boolean rzM;
  private String title = "";
  private ImageView zQn = null;
  private ImageIndicatorView zQo = null;
  private b zQp = null;
  
  static
  {
    AppMethodBeat.i(198140);
    e.a locala = new e.a();
    locala.heb = true;
    locala.hea = true;
    zQq = locala.arf();
    AppMethodBeat.o(198140);
  }
  
  public t(MMActivity paramMMActivity)
  {
    this.fLP = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, bvq parambvq, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(198138);
    paramLinkedList = new bc(28);
    if (this.zQp != null) {
      paramLinkedList.a(this.zQp);
    }
    paramPInt.value = paramLinkedList.beN;
    if (paramInt3 > a.zbZ) {
      paramLinkedList.Qb(4);
    }
    paramLinkedList.azo(this.title).azj(paramString1);
    paramLinkedList.azm(bt.bI(this.fLP.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
    paramLinkedList.Qe(paramInt1);
    if (paramBoolean) {
      paramLinkedList.Qh(1);
    }
    for (;;)
    {
      paramLinkedList.fL(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break;
      }
      new LinkedList();
      paramList2 = d.fas();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          dhj localdhj = new dhj();
          localdhj.nDo = paramPInt;
          paramString1.add(localdhj);
        }
      }
      paramLinkedList.Qh(0);
    }
    if (parami != null) {
      paramLinkedList.jr(parami.token, parami.GTp);
    }
    paramLinkedList.aU(paramString1);
    if (!bt.isNullOrNil(this.appId)) {
      paramLinkedList.azp(this.appId);
    }
    if (!bt.isNullOrNil(this.appName)) {
      paramLinkedList.azq(bt.bI(this.appName, ""));
    }
    paramLinkedList.a(parambvq);
    paramLinkedList.azl(paramString2);
    paramLinkedList.azu(this.dHu);
    paramLinkedList.setSessionId(this.mSessionId);
    paramInt1 = paramLinkedList.commit();
    if (this.rzM) {
      com.tencent.mm.plugin.sns.j.e.ztz.zuj = paramInt1;
    }
    ag.dUa().dSE();
    this.fLP.finish();
    AppMethodBeat.o(198138);
    return false;
  }
  
  public final void ap(Bundle paramBundle)
  {
    AppMethodBeat.i(198136);
    this.title = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.dHu = bt.bI(this.fLP.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = bt.bI(this.fLP.getIntent().getStringExtra("reportSessionId"), "");
    this.appId = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.rzM = this.fLP.getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
    com.tencent.mm.plugin.sns.j.e.ztz.zuk = this.fLP.getIntent().getLongExtra("finder_feed_id", 0L);
    paramBundle = this.fLP.getIntent().getStringExtra("ksnsupload_finder_object_xml");
    if (!bt.isNullOrNil(paramBundle))
    {
      paramBundle = bw.M(paramBundle, "finderFeed");
      if (paramBundle != null)
      {
        this.zQp = new b();
        this.zQp.i("", paramBundle);
      }
    }
    AppMethodBeat.o(198136);
  }
  
  public final void aq(Bundle paramBundle) {}
  
  public final boolean dZG()
  {
    return this.zQp != null;
  }
  
  public final View dZH()
  {
    AppMethodBeat.i(198137);
    this.rY = z.jO(this.fLP).inflate(2131496489, null);
    this.lta = ((ImageView)this.rY.findViewById(2131308430));
    this.zQn = ((ImageView)this.rY.findViewById(2131308429));
    this.zQo = ((ImageIndicatorView)this.rY.findViewById(2131308427));
    Object localObject1;
    ari localari;
    Object localObject2;
    if ((this.zQp != null) && (this.zQp.inc != null))
    {
      localObject1 = this.zQp.inc;
      if (!bt.hj(((arj)localObject1).mediaList))
      {
        localari = (ari)((arj)localObject1).mediaList.get(0);
        if (((arj)localObject1).Gpi != 4) {
          break label266;
        }
        localObject2 = h.a((int)localari.width, (int)localari.height, this.fLP, false);
        localObject2 = new ViewGroup.LayoutParams(((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
        this.rY.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.rY.requestLayout();
        ((com.tencent.mm.plugin.i.a.t)g.ad(com.tencent.mm.plugin.i.a.t.class)).loadImage(localari.thumbUrl, this.lta);
      }
      if (((arj)localObject1).Gpi != 4) {
        break label330;
      }
      this.zQn.setVisibility(0);
      this.zQo.setVisibility(8);
    }
    for (;;)
    {
      this.rY.setOnClickListener(new t.1(this));
      localObject1 = this.rY;
      AppMethodBeat.o(198137);
      return localObject1;
      label266:
      localObject2 = h.a((int)localari.width, (int)localari.height, this.fLP);
      localObject2 = new ViewGroup.LayoutParams(((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
      this.rY.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.rY.requestLayout();
      break;
      label330:
      this.zQn.setVisibility(8);
      this.zQo.setVisibility(8);
      this.zQo.ABt = ((arj)localObject1).dqU;
    }
  }
  
  public final boolean dZI()
  {
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.t
 * JD-Core Version:    0.7.0.1
 */