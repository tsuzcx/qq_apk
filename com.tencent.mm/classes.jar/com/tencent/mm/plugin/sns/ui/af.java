package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.g;
import com.tencent.mm.plugin.sns.j.h;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class af
  implements ac
{
  private byte[] Ahi = null;
  private String Ahj;
  private int Ahk;
  CdnImageView Ahl = null;
  private TextView Ahm = null;
  private e Ahq = null;
  private String Ahr = "";
  private boolean AiJ = false;
  private boolean AiK = false;
  private WXMediaMessage AiL = null;
  private int AiQ = 0;
  private e AiR = null;
  private int AiS = 0;
  private String AjS;
  jb AjT = null;
  private String appId;
  private String appName;
  private String dIt;
  private String dIz;
  private final MMActivity fNT;
  public String hEZ = "";
  public String hFa = "";
  private String mSessionId;
  private View rY = null;
  private String title = "";
  private TextView titleTv = null;
  private int zFi = 1;
  
  public af(MMActivity paramMMActivity)
  {
    this.fNT = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bwk parambwk, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(219704);
    paramLinkedList = new bd(33);
    paramPInt.value = paramLinkedList.beN;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.zsC) {
      paramLinkedList.QI(4);
    }
    paramLinkedList.aAF(this.title).aAA(paramString1);
    paramLinkedList.aAD(bu.bI(this.fNT.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
    if (this.AiS == 15) {
      paramLinkedList.aAD(bu.bI(this.fNT.getIntent().getStringExtra("fav_note_link_description"), ""));
    }
    if (this.AjT != null)
    {
      paramString1 = this.AjT;
      if (paramString1 != null) {
        paramLinkedList.zFb.HUG.GtD = paramString1;
      }
    }
    paramLinkedList.cc(this.zFi, this.Ahr);
    paramLinkedList.QN(this.Ahk);
    paramLinkedList.aAI(this.dIt);
    paramLinkedList.aAJ(this.Ahj);
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
      paramList2 = com.tencent.mm.pluginsdk.i.d.feg();
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
    if (this.AiJ) {
      paramLinkedList.QN(5);
    }
    paramLinkedList.a(parambwk);
    if ((this.AiK) && (this.AiL != null))
    {
      paramLinkedList.aAB(this.AiL.mediaTagName);
      paramLinkedList.aD(this.appId, this.AiL.messageExt, this.AiL.messageAction);
    }
    paramLinkedList.aAC(paramString2);
    paramLinkedList.aAL(this.dIz);
    paramLinkedList.setSessionId(this.mSessionId);
    paramLinkedList.QJ(this.AiQ);
    paramInt1 = paramLinkedList.commit();
    if (this.Ahq != null)
    {
      this.Ahq.qa(paramInt1);
      g.zLJ.c(this.Ahq);
    }
    if (this.AiR != null)
    {
      this.AiR.qa(paramInt1);
      h.zLJ.c(this.AiR);
      this.AiR.aLH();
    }
    ah.dXA().dWc();
    this.fNT.finish();
    AppMethodBeat.o(219704);
    return false;
  }
  
  public final void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(219702);
    this.appId = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Ahk = this.fNT.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.dIt = bu.bI(this.fNT.getIntent().getStringExtra("src_username"), "");
    this.Ahj = bu.bI(this.fNT.getIntent().getStringExtra("src_displayname"), "");
    this.dIz = bu.bI(this.fNT.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = bu.bI(this.fNT.getIntent().getStringExtra("reportSessionId"), "");
    this.AjS = bu.bI(this.fNT.getIntent().getStringExtra("ksnsupload_mp_video_xml"), "");
    if (!bu.isNullOrNil(this.AjS))
    {
      paramBundle = bx.M(this.AjS, "mmbrandmpvideo");
      if (paramBundle != null) {
        this.AjT = com.tencent.mm.modelsns.d.k("", paramBundle);
      }
    }
    AppMethodBeat.o(219702);
  }
  
  public final void ar(Bundle paramBundle) {}
  
  public final boolean edl()
  {
    return true;
  }
  
  public final View edm()
  {
    AppMethodBeat.i(219703);
    this.rY = z.jV(this.fNT).inflate(2131495816, null);
    this.rY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219701);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/MPVideoWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        if (af.this.AjT != null)
        {
          localObject = new Rect();
          int[] arrayOfInt = new int[2];
          af.this.Ahl.getLocationOnScreen(arrayOfInt);
          ((Rect)localObject).set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + af.this.Ahl.getMeasuredWidth(), arrayOfInt[1] + af.this.Ahl.getMeasuredHeight());
          com.tencent.mm.modelsns.d.a(paramAnonymousView.getContext(), af.this.AjT, (Rect)localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/MPVideoWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(219701);
      }
    });
    this.Ahl = ((CdnImageView)this.rY.findViewById(2131300948));
    this.titleTv = ((TextView)this.rY.findViewById(2131305950));
    this.Ahm = ((TextView)this.rY.findViewById(2131304202));
    Object localObject = (ImageView)this.rY.findViewById(2131305185);
    ((ImageView)localObject).setImageDrawable(ao.k(this.fNT, 2131690672, -1));
    ((ImageView)localObject).setVisibility(0);
    this.Ahl.setVisibility(0);
    if (this.AjT != null)
    {
      this.Ahl.setUrl(this.AjT.hGe);
      this.titleTv.setText(this.AjT.title);
    }
    r.b(this.Ahl, this.fNT);
    localObject = this.rY;
    AppMethodBeat.o(219703);
    return localObject;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.af
 * JD-Core Version:    0.7.0.1
 */