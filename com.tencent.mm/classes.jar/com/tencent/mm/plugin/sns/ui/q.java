package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  implements ad
{
  private int DPi = 1;
  private byte[] EpE = null;
  private String EpF;
  private int EpG;
  private CdnImageView EpH = null;
  private TextView EpI = null;
  private int EpJ;
  private String EpK = "";
  private String EpL = "";
  private k EpM = null;
  private String EpN = "";
  private String appId = "";
  private String appName = "";
  private String dRr = "";
  private String eag;
  private MMActivity gte;
  private int h = -1;
  private Bitmap iKs = null;
  private String link = "";
  private View sc = null;
  private String title = "";
  private TextView titleTv = null;
  private boolean tkD = false;
  private String twt = "";
  private int w = -1;
  
  public q(MMActivity paramMMActivity)
  {
    this.gte = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97865);
    paramLinkedList = new bf(10, this.gte);
    paramPInt.value = paramLinkedList.beK;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.DCT) {
      paramLinkedList.YF(2);
    }
    if (parami != null) {
      paramLinkedList.kl(parami.token, parami.Mte);
    }
    paramLinkedList.aPB(this.title).aPz(this.EpL).aPA(this.link).aPw(paramString1);
    boolean bool2 = false;
    boolean bool1;
    if (!Util.isNullOrNil(this.dRr))
    {
      bool1 = paramLinkedList.a(s.aW(this.dRr, 0, -1), this.EpL, this.title, this.EpJ, this.EpK);
      bool2 = bool1;
      if (!bool1)
      {
        Log.i("MicroMsg.EmojiShareWidget", "set userData user imgurl ");
        bool2 = paramLinkedList.c(this.twt, this.twt, this.EpL, this.EpJ, this.EpK);
      }
      if (!bool2) {
        Log.e("MicroMsg.EmojiShareWidget", "set userData faild");
      }
      paramLinkedList.ct(this.DPi, this.EpN);
      paramLinkedList.YK(this.EpG);
      paramLinkedList.aPE(this.eag);
      paramLinkedList.aPF(this.EpF);
      if (!paramBoolean) {
        break label455;
      }
      paramLinkedList.YL(1);
    }
    for (;;)
    {
      paramLinkedList.gR(paramList2);
      if (!Util.isNullOrNil(this.appId))
      {
        paramLinkedList.aPC(this.appId);
        paramLinkedList.aPD(this.appName);
      }
      parami = new LinkedList();
      if (paramList1 == null) {
        break label465;
      }
      new LinkedList();
      paramString1 = com.tencent.mm.pluginsdk.i.a.gnq();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if (!paramString1.contains(paramList2))
        {
          paramPInt = new ebm();
          paramPInt.UserName = paramList2;
          parami.add(paramPInt);
        }
      }
      bool1 = bool2;
      if (Util.isNullOrNil(this.twt)) {
        break;
      }
      bool1 = bool2;
      if (com.tencent.mm.av.q.bcQ() == null) {
        break;
      }
      com.tencent.mm.av.q.bcQ();
      parami = com.tencent.mm.av.d.EP(this.twt);
      bool1 = bool2;
      if (parami == null) {
        break;
      }
      bool1 = paramLinkedList.a(BitmapUtil.Bitmap2PngBytes(parami), this.EpL, this.title, this.EpJ, this.EpK);
      break;
      label455:
      paramLinkedList.YL(0);
    }
    label465:
    paramLinkedList.bq(parami).YI(paramInt1);
    paramLinkedList.g(null, null, null, paramInt4, paramInt5);
    paramLinkedList.a(paramcjy);
    paramInt1 = paramLinkedList.commit();
    if (this.EpM != null)
    {
      this.EpM.tQ(paramInt1);
      com.tencent.mm.plugin.sns.k.g.DVR.c(this.EpM);
    }
    aj.faK().eZn();
    this.gte.finish();
    parami = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amt(this.EpK);
    h.CyF.a(10993, new Object[] { Integer.valueOf(1), parami });
    AppMethodBeat.o(97865);
    return false;
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(97863);
    this.EpM = k.w(this.gte.getIntent());
    this.w = this.gte.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.gte.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.link = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.twt = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.dRr = this.gte.getIntent().getStringExtra("KsnsUpload_imgPath");
    this.tkD = this.gte.getIntent().getBooleanExtra("ksnsis_video", false);
    this.eag = Util.nullAs(this.gte.getIntent().getStringExtra("src_username"), "");
    this.EpF = Util.nullAs(this.gte.getIntent().getStringExtra("src_displayname"), "");
    this.EpL = Util.nullAs(this.gte.getIntent().getStringExtra("KContentObjDesc"), "");
    this.EpK = Util.nullAs(this.gte.getIntent().getStringExtra("KUploadProduct_UserData"), "");
    this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.appId = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.EpJ = this.gte.getIntent().getIntExtra("KUploadProduct_subType", 0);
    if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.DPi = 1;; this.DPi = 0)
    {
      this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(97863);
      return;
    }
  }
  
  public final void aD(Bundle paramBundle) {}
  
  public final boolean ffA()
  {
    return true;
  }
  
  public final View ffB()
  {
    AppMethodBeat.i(97864);
    this.sc = aa.jQ(this.gte).inflate(2131496778, null);
    this.EpH = ((CdnImageView)this.sc.findViewById(2131302578));
    this.titleTv = ((TextView)this.sc.findViewById(2131309253));
    this.EpI = ((TextView)this.sc.findViewById(2131307116));
    if (this.tkD)
    {
      this.sc.findViewById(2131308376).setVisibility(0);
      this.titleTv.setText(this.title);
      if (Util.isNullOrNil(this.twt)) {
        break label178;
      }
      this.EpH.setVisibility(0);
      this.EpH.setUrl(this.twt);
    }
    for (;;)
    {
      r.b(this.EpH, this.gte);
      View localView = this.sc;
      AppMethodBeat.o(97864);
      return localView;
      this.sc.findViewById(2131308376).setVisibility(8);
      break;
      label178:
      if (!Util.isNullOrNil(this.EpE))
      {
        this.EpH.setVisibility(0);
        this.iKs = BitmapUtil.decodeByteArray(this.EpE);
        this.EpH.setImageBitmap(this.iKs);
      }
      else
      {
        this.EpH.setVisibility(8);
      }
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
    AppMethodBeat.i(97866);
    if ((this.iKs != null) && (!this.iKs.isRecycled())) {
      this.iKs.recycle();
    }
    AppMethodBeat.o(97866);
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.q
 * JD-Core Version:    0.7.0.1
 */