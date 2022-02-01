package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.j.g;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  implements ac
{
  private byte[] Ahi = null;
  private String Ahj;
  private int Ahk;
  private CdnImageView Ahl = null;
  private TextView Ahm = null;
  private int Ahn;
  private String Aho = "";
  private String Ahp = "";
  private e Ahq = null;
  private String Ahr = "";
  private String appId = "";
  private String appName = "";
  private String dIt;
  private String dzD = "";
  private MMActivity fNT;
  private int h = -1;
  private Bitmap hPl = null;
  private String link = "";
  private boolean pGA = false;
  private String rSl = "";
  private View rY = null;
  private String title = "";
  private TextView titleTv = null;
  private int w = -1;
  private int zFi = 1;
  
  public r(MMActivity paramMMActivity)
  {
    this.fNT = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bwk parambwk, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97869);
    paramLinkedList = new bd(22);
    paramPInt.value = paramLinkedList.beN;
    if (paramInt3 > a.zsC) {
      paramLinkedList.QI(2);
    }
    if (parami != null) {
      paramLinkedList.jy(parami.token, parami.HmQ);
    }
    paramLinkedList.aAF(this.title).aAD(this.Ahp).aAE(this.link).aAA(paramString1);
    boolean bool2 = false;
    boolean bool1;
    if (!bu.isNullOrNil(this.dzD))
    {
      bool1 = paramLinkedList.a(o.bb(this.dzD, 0, -1), this.Ahp, this.title, this.Ahn, this.Aho);
      bool2 = bool1;
      if (!bool1)
      {
        ae.i("MicroMsg.EmotionListShareWidget", "set userData user imgurl ");
        bool2 = paramLinkedList.c(this.rSl, this.rSl, this.Ahp, this.Ahn, this.Aho);
      }
      if (!bool2) {
        ae.e("MicroMsg.EmotionListShareWidget", "set userData faild");
      }
      paramLinkedList.cc(this.zFi, this.Ahr);
      paramLinkedList.QN(this.Ahk);
      paramLinkedList.aAI(this.dIt);
      paramLinkedList.aAJ(this.Ahj);
      paramLinkedList.QL(paramInt1);
      paramLinkedList.g(null, null, null, paramInt4, paramInt5);
      if (!paramBoolean) {
        break label470;
      }
      paramLinkedList.QO(1);
    }
    for (;;)
    {
      paramLinkedList.fU(paramList2);
      if (!bu.isNullOrNil(this.appId))
      {
        paramLinkedList.aAG(this.appId);
        paramLinkedList.aAH(this.appName);
      }
      parami = new LinkedList();
      if (paramList1 == null) {
        break label480;
      }
      new LinkedList();
      paramString1 = com.tencent.mm.pluginsdk.i.d.feg();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if (!paramString1.contains(paramList2))
        {
          paramPInt = new did();
          paramPInt.nIJ = paramList2;
          parami.add(paramPInt);
        }
      }
      bool1 = bool2;
      if (bu.isNullOrNil(this.rSl)) {
        break;
      }
      bool1 = bool2;
      if (q.aIW() == null) {
        break;
      }
      q.aIW();
      parami = com.tencent.mm.av.d.wA(this.rSl);
      bool1 = bool2;
      if (parami == null) {
        break;
      }
      bool1 = paramLinkedList.a(h.aB(parami), this.Ahp, this.title, this.Ahn, this.Aho);
      break;
      label470:
      paramLinkedList.QO(0);
    }
    label480:
    paramLinkedList.aV(parami);
    paramLinkedList.a(parambwk);
    paramInt1 = paramLinkedList.commit();
    if (this.Ahq != null)
    {
      this.Ahq.qa(paramInt1);
      g.zLJ.c(this.Ahq);
    }
    ah.dXA().dWc();
    this.fNT.finish();
    AppMethodBeat.o(97869);
    return false;
  }
  
  public final void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(97867);
    this.Ahq = e.w(this.fNT.getIntent());
    this.w = this.fNT.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.fNT.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.Ahk = this.fNT.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.link = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.rSl = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.dzD = this.fNT.getIntent().getStringExtra("KsnsUpload_imgPath");
    this.pGA = this.fNT.getIntent().getBooleanExtra("ksnsis_video", false);
    this.dIt = bu.bI(this.fNT.getIntent().getStringExtra("src_username"), "");
    this.Ahj = bu.bI(this.fNT.getIntent().getStringExtra("src_displayname"), "");
    this.Ahp = bu.bI(this.fNT.getIntent().getStringExtra("KContentObjDesc"), "");
    this.Aho = bu.bI(this.fNT.getIntent().getStringExtra("KUploadProduct_UserData"), "");
    this.appName = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.appId = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.Ahn = this.fNT.getIntent().getIntExtra("KUploadProduct_subType", 0);
    if (this.fNT.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.zFi = 1;; this.zFi = 0)
    {
      this.Ahr = bu.bI(this.fNT.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(97867);
      return;
    }
  }
  
  public final void ar(Bundle paramBundle) {}
  
  public final boolean edl()
  {
    return true;
  }
  
  public final View edm()
  {
    AppMethodBeat.i(97868);
    this.rY = z.jV(this.fNT).inflate(2131495816, null);
    this.Ahl = ((CdnImageView)this.rY.findViewById(2131300948));
    this.titleTv = ((TextView)this.rY.findViewById(2131305950));
    this.Ahm = ((TextView)this.rY.findViewById(2131304202));
    if (this.pGA)
    {
      this.rY.findViewById(2131305185).setVisibility(0);
      this.titleTv.setText(this.title);
      if (bu.isNullOrNil(this.rSl)) {
        break label178;
      }
      this.Ahl.setVisibility(0);
      this.Ahl.setUrl(this.rSl);
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.data.r.b(this.Ahl, this.fNT);
      View localView = this.rY;
      AppMethodBeat.o(97868);
      return localView;
      this.rY.findViewById(2131305185).setVisibility(8);
      break;
      label178:
      if (!bu.cF(this.Ahi))
      {
        this.Ahl.setVisibility(0);
        this.hPl = h.cu(this.Ahi);
        this.Ahl.setImageBitmap(this.hPl);
      }
      else
      {
        this.Ahl.setVisibility(8);
      }
    }
  }
  
  public final boolean edn()
  {
    return true;
  }
  
  public final boolean edo()
  {
    AppMethodBeat.i(97870);
    if ((this.hPl != null) && (!this.hPl.isRecycled())) {
      this.hPl.recycle();
    }
    AppMethodBeat.o(97870);
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.r
 * JD-Core Version:    0.7.0.1
 */