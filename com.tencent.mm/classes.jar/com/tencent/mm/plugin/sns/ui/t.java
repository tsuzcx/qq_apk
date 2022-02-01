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
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class t
  implements ac
{
  private static com.tencent.mm.loader.c.e Ahx;
  private ImageView Ahu = null;
  private ImageIndicatorView Ahv = null;
  private b Ahw = null;
  private String appId;
  private String appName;
  private String dIz;
  private MMActivity fNT = null;
  private ImageView lxz = null;
  private String mSessionId;
  private boolean rHX;
  private View rY = null;
  private String title = "";
  
  static
  {
    AppMethodBeat.i(219657);
    e.a locala = new e.a();
    locala.hgP = true;
    locala.hgO = true;
    Ahx = locala.aru();
    AppMethodBeat.o(219657);
  }
  
  public t(MMActivity paramMMActivity)
  {
    this.fNT = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, bwk parambwk, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(219655);
    paramLinkedList = new bd(28);
    if (this.Ahw != null) {
      paramLinkedList.a(this.Ahw);
    }
    paramPInt.value = paramLinkedList.beN;
    if (paramInt3 > a.zsC) {
      paramLinkedList.QI(4);
    }
    paramLinkedList.aAF(this.title).aAA(paramString1);
    paramLinkedList.aAD(bu.bI(this.fNT.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
    paramLinkedList.QL(paramInt1);
    if (paramBoolean) {
      paramLinkedList.QO(1);
    }
    for (;;)
    {
      paramLinkedList.fU(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break;
      }
      new LinkedList();
      paramList2 = d.feg();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          did localdid = new did();
          localdid.nIJ = paramPInt;
          paramString1.add(localdid);
        }
      }
      paramLinkedList.QO(0);
    }
    if (parami != null) {
      paramLinkedList.jy(parami.token, parami.HmQ);
    }
    paramLinkedList.aV(paramString1);
    if (!bu.isNullOrNil(this.appId)) {
      paramLinkedList.aAG(this.appId);
    }
    if (!bu.isNullOrNil(this.appName)) {
      paramLinkedList.aAH(bu.bI(this.appName, ""));
    }
    paramLinkedList.a(parambwk);
    paramLinkedList.aAC(paramString2);
    paramLinkedList.aAL(this.dIz);
    paramLinkedList.setSessionId(this.mSessionId);
    paramInt1 = paramLinkedList.commit();
    if (this.rHX) {
      com.tencent.mm.plugin.sns.j.e.zKO.zLA = paramInt1;
    }
    ah.dXA().dWc();
    this.fNT.finish();
    AppMethodBeat.o(219655);
    return false;
  }
  
  public final void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(219653);
    this.title = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.dIz = bu.bI(this.fNT.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = bu.bI(this.fNT.getIntent().getStringExtra("reportSessionId"), "");
    this.appId = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.rHX = this.fNT.getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
    com.tencent.mm.plugin.sns.j.e.zKO.zLB = this.fNT.getIntent().getLongExtra("finder_feed_id", 0L);
    paramBundle = this.fNT.getIntent().getStringExtra("ksnsupload_finder_object_xml");
    if (!bu.isNullOrNil(paramBundle))
    {
      paramBundle = bx.M(paramBundle, "finderFeed");
      if (paramBundle != null)
      {
        this.Ahw = new b();
        this.Ahw.j("", paramBundle);
      }
    }
    AppMethodBeat.o(219653);
  }
  
  public final void ar(Bundle paramBundle) {}
  
  public final boolean edl()
  {
    return this.Ahw != null;
  }
  
  public final View edm()
  {
    AppMethodBeat.i(219654);
    this.rY = z.jV(this.fNT).inflate(2131496489, null);
    this.lxz = ((ImageView)this.rY.findViewById(2131308430));
    this.Ahu = ((ImageView)this.rY.findViewById(2131308429));
    this.Ahv = ((ImageIndicatorView)this.rY.findViewById(2131308427));
    Object localObject1;
    arx localarx;
    Object localObject2;
    if ((this.Ahw != null) && (this.Ahw.ipW != null))
    {
      localObject1 = this.Ahw.ipW;
      if (!bu.ht(((ary)localObject1).mediaList))
      {
        localarx = (arx)((ary)localObject1).mediaList.get(0);
        if (((ary)localObject1).GIy != 4) {
          break label266;
        }
        localObject2 = h.a((int)localarx.width, (int)localarx.height, this.fNT, false);
        localObject2 = new ViewGroup.LayoutParams(((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
        this.rY.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.rY.requestLayout();
        ((com.tencent.mm.plugin.i.a.t)g.ad(com.tencent.mm.plugin.i.a.t.class)).loadImage(localarx.thumbUrl, this.lxz);
      }
      if (((ary)localObject1).GIy != 4) {
        break label330;
      }
      this.Ahu.setVisibility(0);
      this.Ahv.setVisibility(8);
    }
    for (;;)
    {
      this.rY.setOnClickListener(new t.1(this));
      localObject1 = this.rY;
      AppMethodBeat.o(219654);
      return localObject1;
      label266:
      localObject2 = h.a((int)localarx.width, (int)localarx.height, this.fNT);
      localObject2 = new ViewGroup.LayoutParams(((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
      this.rY.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.rY.requestLayout();
      break;
      label330:
      this.Ahu.setVisibility(8);
      this.Ahv.setVisibility(8);
      this.Ahv.ASU = ((ary)localObject1).drZ;
    }
  }
  
  public final boolean edn()
  {
    return true;
  }
  
  public final boolean edo()
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