package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.j.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ae
  implements ab
{
  private String appName;
  String djj;
  MMActivity iMV;
  private c kce;
  boolean lrL;
  String mediaId;
  private View qe;
  private TextView titleTv;
  private int xXU;
  private boolean yAm;
  private boolean yAn;
  WXMediaMessage yAo;
  ImageView yBx;
  private Bitmap yBy;
  private int yyR;
  private CdnImageView yyS;
  private TextView yyT;
  private d yyX;
  private String yyY;
  
  public ae(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97981);
    this.yAo = null;
    this.yyS = null;
    this.titleTv = null;
    this.yyT = null;
    this.djj = "";
    this.appName = "";
    this.yAm = false;
    this.yAn = false;
    this.lrL = false;
    this.yyX = null;
    this.xXU = 1;
    this.yyY = "";
    this.kce = new c() {};
    this.iMV = paramMMActivity;
    com.tencent.mm.sdk.b.a.GpY.c(this.kce);
    AppMethodBeat.o(97981);
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, brd parambrd, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97985);
    af.dHN();
    paramString1 = ba.b(this.yAo, paramString1, this.djj, this.appName);
    if (paramString1 == null)
    {
      ac.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", new Object[] { this.djj, this.appName });
      AppMethodBeat.o(97985);
      return false;
    }
    paramPInt.value = paramString1.aUt;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.xMh) {
      paramString1.Ou(4);
    }
    paramString1.Oy(this.yyR);
    if (this.yAm) {
      paramString1.Oy(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = com.tencent.mm.pluginsdk.g.j.fdk();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramPInt.contains(paramString2))
        {
          dbw localdbw = new dbw();
          localdbw.ncR = paramString2;
          paramLinkedList.add(localdbw);
        }
      }
    }
    paramString1.aT(paramLinkedList);
    if (parami != null) {
      paramString1.jf(parami.token, parami.FjO);
    }
    paramString1.a(parambrd);
    if (paramBoolean) {
      paramString1.Oz(1);
    }
    for (;;)
    {
      paramString1.fy(paramList2).Ow(paramInt1);
      paramString1.g(null, null, null, paramInt4, paramInt5);
      paramString1.bV(this.xXU, this.yyY);
      if ((this.yAn) && (this.yAo != null))
      {
        paramString1.auf(this.yAo.mediaTagName);
        paramString1.aw(this.djj, this.yAo.messageExt, this.yAo.messageAction);
      }
      paramInt1 = paramString1.commit();
      if (this.yyX != null)
      {
        this.yyX.pu(paramInt1);
        h.yes.c(this.yyX);
      }
      af.dHN().dGr();
      this.iMV.finish();
      AppMethodBeat.o(97985);
      return false;
      paramString1.Oz(0);
    }
  }
  
  public final void ak(Bundle paramBundle)
  {
    AppMethodBeat.i(97982);
    this.yAo = new SendMessageToWX.Req(this.iMV.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    this.mediaId = this.iMV.getIntent().getStringExtra("Ksnsupload_musicid");
    this.yyX = d.w(this.iMV.getIntent());
    this.djj = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.yAm = this.iMV.getIntent().getBooleanExtra("KThrid_app", false);
    this.yAn = this.iMV.getIntent().getBooleanExtra("KSnsAction", false);
    this.yyR = this.iMV.getIntent().getIntExtra("Ksnsupload_source", 0);
    if (this.iMV.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.xXU = 1;; this.xXU = 0)
    {
      this.yyY = bs.bG(this.iMV.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(97982);
      return;
    }
  }
  
  public final void al(Bundle paramBundle) {}
  
  final void dNN()
  {
    AppMethodBeat.i(97983);
    new ao(this.iMV.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97978);
        com.tencent.mm.ay.a.aGt();
        ae.this.lrL = false;
        AppMethodBeat.o(97978);
      }
    });
    AppMethodBeat.o(97983);
  }
  
  public final boolean dNr()
  {
    return true;
  }
  
  public final View dNs()
  {
    AppMethodBeat.i(97984);
    this.qe = z.jD(this.iMV).inflate(2131495817, null);
    this.yyS = ((CdnImageView)this.qe.findViewById(2131300948));
    this.titleTv = ((TextView)this.qe.findViewById(2131305950));
    this.yyT = ((TextView)this.qe.findViewById(2131304202));
    this.qe.findViewById(2131305185).setVisibility(8);
    this.titleTv.setText(this.yAo.title);
    if (this.yAo.thumbData != null) {
      this.yBy = com.tencent.mm.sdk.platformtools.f.ck(this.yAo.thumbData);
    }
    this.yyS.setImageBitmap(this.yBy);
    if (!bs.isNullOrNil(this.yAo.description))
    {
      this.yyT.setText(this.yAo.description);
      this.yyT.setVisibility(0);
      this.yBx = ((ImageView)this.qe.findViewById(2131305185));
      this.yBx.setVisibility(0);
      if ((!com.tencent.mm.ay.a.aGv()) || (!this.lrL)) {
        break label273;
      }
      this.yBx.setImageResource(2131233393);
    }
    for (;;)
    {
      this.yBx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97980);
          if (com.tencent.mm.ay.a.aGv())
          {
            ae.this.dNN();
            AppMethodBeat.o(97980);
            return;
          }
          paramAnonymousView = ae.this;
          if (paramAnonymousView.yAo == null)
          {
            ac.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
            AppMethodBeat.o(97980);
            return;
          }
          new ao(paramAnonymousView.iMV.getMainLooper()).post(new ae.3(paramAnonymousView));
          AppMethodBeat.o(97980);
        }
      });
      q.b(this.yyS, this.iMV);
      View localView = this.qe;
      AppMethodBeat.o(97984);
      return localView;
      this.yyT.setVisibility(8);
      break;
      label273:
      this.yBx.setImageResource(2131233395);
    }
  }
  
  public final boolean dNt()
  {
    AppMethodBeat.i(97986);
    if ((this.yBy != null) && (!this.yBy.isRecycled())) {
      this.yBy.recycle();
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.kce);
    if ((com.tencent.mm.ay.a.aGv()) && (this.lrL)) {
      dNN();
    }
    boolean bool = com.tencent.mm.ay.a.aGv();
    AppMethodBeat.o(97986);
    return bool;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ae
 * JD-Core Version:    0.7.0.1
 */