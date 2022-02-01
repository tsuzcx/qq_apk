package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.c;
import com.tencent.mm.av.o;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.j.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  implements ab
{
  private String appId = "";
  private String appName = "";
  private String dmK = "";
  private String dvl;
  private int h = -1;
  private Bitmap hua = null;
  private MMActivity iMV;
  private String link = "";
  private boolean oWm = false;
  private String qYH = "";
  private View qe = null;
  private String title = "";
  private TextView titleTv = null;
  private int w = -1;
  private int xXU = 1;
  private byte[] yyP = null;
  private String yyQ;
  private int yyR;
  private CdnImageView yyS = null;
  private TextView yyT = null;
  private int yyU;
  private String yyV = "";
  private String yyW = "";
  private d yyX = null;
  private String yyY = "";
  
  public r(MMActivity paramMMActivity)
  {
    this.iMV = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, brd parambrd, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97869);
    paramLinkedList = new bb(22);
    paramPInt.value = paramLinkedList.aUt;
    if (paramInt3 > a.xMh) {
      paramLinkedList.Ou(2);
    }
    if (parami != null) {
      paramLinkedList.jf(parami.token, parami.FjO);
    }
    paramLinkedList.auj(this.title).auh(this.yyW).aui(this.link).aue(paramString1);
    boolean bool2 = false;
    boolean bool1;
    if (!bs.isNullOrNil(this.dmK))
    {
      bool1 = paramLinkedList.a(com.tencent.mm.vfs.i.aU(this.dmK, 0, -1), this.yyW, this.title, this.yyU, this.yyV);
      bool2 = bool1;
      if (!bool1)
      {
        ac.i("MicroMsg.EmotionListShareWidget", "set userData user imgurl ");
        bool2 = paramLinkedList.c(this.qYH, this.qYH, this.yyW, this.yyU, this.yyV);
      }
      if (!bool2) {
        ac.e("MicroMsg.EmotionListShareWidget", "set userData faild");
      }
      paramLinkedList.bV(this.xXU, this.yyY);
      paramLinkedList.Oy(this.yyR);
      paramLinkedList.aum(this.dvl);
      paramLinkedList.aun(this.yyQ);
      paramLinkedList.Ow(paramInt1);
      paramLinkedList.g(null, null, null, paramInt4, paramInt5);
      if (!paramBoolean) {
        break label470;
      }
      paramLinkedList.Oz(1);
    }
    for (;;)
    {
      paramLinkedList.fy(paramList2);
      if (!bs.isNullOrNil(this.appId))
      {
        paramLinkedList.auk(this.appId);
        paramLinkedList.aul(this.appName);
      }
      parami = new LinkedList();
      if (paramList1 == null) {
        break label480;
      }
      new LinkedList();
      paramString1 = com.tencent.mm.pluginsdk.g.j.fdk();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if (!paramString1.contains(paramList2))
        {
          paramPInt = new dbw();
          paramPInt.ncR = paramList2;
          parami.add(paramPInt);
        }
      }
      bool1 = bool2;
      if (bs.isNullOrNil(this.qYH)) {
        break;
      }
      bool1 = bool2;
      if (o.aFw() == null) {
        break;
      }
      o.aFw();
      parami = c.te(this.qYH);
      bool1 = bool2;
      if (parami == null) {
        break;
      }
      bool1 = paramLinkedList.a(f.ay(parami), this.yyW, this.title, this.yyU, this.yyV);
      break;
      label470:
      paramLinkedList.Oz(0);
    }
    label480:
    paramLinkedList.aT(parami);
    paramLinkedList.a(parambrd);
    paramInt1 = paramLinkedList.commit();
    if (this.yyX != null)
    {
      this.yyX.pu(paramInt1);
      h.yes.c(this.yyX);
    }
    af.dHN().dGr();
    this.iMV.finish();
    AppMethodBeat.o(97869);
    return false;
  }
  
  public final void ak(Bundle paramBundle)
  {
    AppMethodBeat.i(97867);
    this.yyX = d.w(this.iMV.getIntent());
    this.w = this.iMV.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.iMV.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.yyR = this.iMV.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.link = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.qYH = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.dmK = this.iMV.getIntent().getStringExtra("KsnsUpload_imgPath");
    this.oWm = this.iMV.getIntent().getBooleanExtra("ksnsis_video", false);
    this.dvl = bs.bG(this.iMV.getIntent().getStringExtra("src_username"), "");
    this.yyQ = bs.bG(this.iMV.getIntent().getStringExtra("src_displayname"), "");
    this.yyW = bs.bG(this.iMV.getIntent().getStringExtra("KContentObjDesc"), "");
    this.yyV = bs.bG(this.iMV.getIntent().getStringExtra("KUploadProduct_UserData"), "");
    this.appName = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.appId = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.yyU = this.iMV.getIntent().getIntExtra("KUploadProduct_subType", 0);
    if (this.iMV.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.xXU = 1;; this.xXU = 0)
    {
      this.yyY = bs.bG(this.iMV.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(97867);
      return;
    }
  }
  
  public final void al(Bundle paramBundle) {}
  
  public final boolean dNr()
  {
    return true;
  }
  
  public final View dNs()
  {
    AppMethodBeat.i(97868);
    this.qe = z.jD(this.iMV).inflate(2131495816, null);
    this.yyS = ((CdnImageView)this.qe.findViewById(2131300948));
    this.titleTv = ((TextView)this.qe.findViewById(2131305950));
    this.yyT = ((TextView)this.qe.findViewById(2131304202));
    if (this.oWm)
    {
      this.qe.findViewById(2131305185).setVisibility(0);
      this.titleTv.setText(this.title);
      if (bs.isNullOrNil(this.qYH)) {
        break label178;
      }
      this.yyS.setVisibility(0);
      this.yyS.setUrl(this.qYH);
    }
    for (;;)
    {
      q.b(this.yyS, this.iMV);
      View localView = this.qe;
      AppMethodBeat.o(97868);
      return localView;
      this.qe.findViewById(2131305185).setVisibility(8);
      break;
      label178:
      if (!bs.cv(this.yyP))
      {
        this.yyS.setVisibility(0);
        this.hua = f.ck(this.yyP);
        this.yyS.setImageBitmap(this.hua);
      }
      else
      {
        this.yyS.setVisibility(8);
      }
    }
  }
  
  public final boolean dNt()
  {
    AppMethodBeat.i(97870);
    if ((this.hua != null) && (!this.hua.isRecycled())) {
      this.hua.recycle();
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