package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ar
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
  private int loG = 9;
  private View sc = null;
  private String title = "";
  private TextView titleTv = null;
  private boolean tkD = false;
  private String twt = "";
  private int w = -1;
  
  public ar(MMActivity paramMMActivity, int paramInt)
  {
    this.gte = paramMMActivity;
    this.loG = paramInt;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98207);
    paramLinkedList = new bf(this.loG, this.gte);
    paramPInt.value = paramLinkedList.beK;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.DCT) {
      paramLinkedList.YF(2);
    }
    paramLinkedList.aPB(this.title).aPz(this.EpL).aPA(this.link).aPw(paramString1);
    if (!Util.isNullOrNil(this.dRr))
    {
      paramLinkedList.a(s.aW(this.dRr, 0, -1), this.EpL, this.title, this.EpJ, this.EpK);
      if (parami != null) {
        paramLinkedList.kl(parami.token, parami.Mte);
      }
      paramLinkedList.ct(this.DPi, this.EpN);
      paramLinkedList.YK(this.EpG);
      paramLinkedList.aPE(this.eag);
      paramLinkedList.aPF(this.EpF);
      paramLinkedList.YI(paramInt1);
      paramLinkedList.g(null, null, null, paramInt4, paramInt5);
      if (!paramBoolean) {
        break label395;
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
        break label405;
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
      if ((Util.isNullOrNil(this.twt)) || (q.bcQ() == null)) {
        break;
      }
      q.bcQ();
      paramString1 = d.EP(this.twt);
      if (paramString1 == null) {
        break;
      }
      paramLinkedList.b(BitmapUtil.Bitmap2Bytes(paramString1), "", "");
      break;
      label395:
      paramLinkedList.YL(0);
    }
    label405:
    paramLinkedList.bq(parami);
    paramLinkedList.a(paramcjy);
    paramInt1 = paramLinkedList.commit();
    if (this.EpM != null)
    {
      this.EpM.tQ(paramInt1);
      g.DVR.c(this.EpM);
    }
    aj.faK().eZn();
    this.gte.finish();
    AppMethodBeat.o(98207);
    return false;
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(98205);
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
      AppMethodBeat.o(98205);
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
    AppMethodBeat.i(98206);
    this.sc = aa.jQ(this.gte).inflate(2131496778, null);
    this.EpH = ((CdnImageView)this.sc.findViewById(2131302578));
    this.titleTv = ((TextView)this.sc.findViewById(2131309253));
    this.EpI = ((TextView)this.sc.findViewById(2131307116));
    if (this.tkD)
    {
      this.sc.findViewById(2131308376).setVisibility(0);
      this.titleTv.setText(this.title);
      if (this.loG == 13) {
        this.titleTv.setText(this.title + "\n" + this.EpL);
      }
      if (Util.isNullOrNil(this.twt)) {
        break label224;
      }
      this.EpH.setVisibility(0);
      this.EpH.setUrl(this.twt);
    }
    for (;;)
    {
      r.b(this.EpH, this.gte);
      View localView = this.sc;
      AppMethodBeat.o(98206);
      return localView;
      this.sc.findViewById(2131308376).setVisibility(8);
      break;
      label224:
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
    AppMethodBeat.i(98208);
    if ((this.iKs != null) && (!this.iKs.isRecycled())) {
      this.iKs.recycle();
    }
    AppMethodBeat.o(98208);
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ar
 * JD-Core Version:    0.7.0.1
 */