package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.e;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.statistics.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class au
  implements ag
{
  private String ADt = "";
  private boolean AnF = false;
  private int QzF = 1;
  private int RcA;
  private String RcB = "";
  private String RcC = "";
  private com.tencent.mm.modelsns.l RcD = null;
  private String RcE = "";
  private byte[] Rcw = null;
  private String Rcx;
  private int Rcy;
  private CdnImageView Rcz = null;
  private String appId = "";
  private String appName = "";
  private View doN = null;
  private int h = -1;
  private String hQn = "";
  private String iaa;
  private String link = "";
  private MMActivity lzt;
  private Bitmap orY = null;
  private int rmS = 9;
  private String title = "";
  private TextView titleTv = null;
  private int w = -1;
  private TextView ycd = null;
  
  public au(MMActivity paramMMActivity, int paramInt)
  {
    this.lzt = paramMMActivity;
    this.rmS = paramInt;
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, djv paramdjv, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98207);
    paramLinkedList = new bg(this.rmS, this.lzt);
    paramPInt.value = paramLinkedList.cIh;
    if (paramInt3 > com.tencent.mm.plugin.sns.d.a.Qkq) {
      paramLinkedList.akL(2);
    }
    paramLinkedList.aYR(this.title).aYP(this.RcC).aYQ(this.link).aYM(paramString1);
    if (!Util.isNullOrNil(this.hQn))
    {
      paramLinkedList.a(y.bi(this.hQn, 0, -1), this.RcC, this.title, this.RcA, this.RcB);
      if (parami != null) {
        paramLinkedList.mm(parami.token, parami.aaTQ);
      }
      paramLinkedList.df(this.QzF, this.RcE);
      paramLinkedList.akQ(this.Rcy);
      paramLinkedList.aYU(this.iaa);
      paramLinkedList.aYV(this.Rcx);
      paramLinkedList.akO(paramInt1);
      paramLinkedList.i(null, null, null, paramInt4, paramInt5);
      if (!paramBoolean) {
        break label400;
      }
      paramLinkedList.akR(1);
    }
    for (;;)
    {
      paramLinkedList.kB(paramList2);
      if (!Util.isNullOrNil(this.appId))
      {
        paramLinkedList.aYS(this.appId);
        paramLinkedList.aYT(this.appName);
      }
      parami = new LinkedList();
      if (paramList1 == null) {
        break label410;
      }
      new LinkedList();
      paramString1 = com.tencent.mm.pluginsdk.platformtools.a.iIX();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if ((paramString1 != null) && (!paramString1.contains(paramList2)))
        {
          paramPInt = new ffw();
          paramPInt.UserName = paramList2;
          parami.add(paramPInt);
        }
      }
      if ((Util.isNullOrNil(this.ADt)) || (r.bJZ() == null)) {
        break;
      }
      r.bJZ();
      paramString1 = e.Eo(this.ADt);
      if (paramString1 == null) {
        break;
      }
      paramLinkedList.b(BitmapUtil.Bitmap2Bytes(paramString1), "", "");
      break;
      label400:
      paramLinkedList.akR(0);
    }
    label410:
    paramLinkedList.bU(parami);
    paramLinkedList.a(paramdjv);
    paramInt1 = paramLinkedList.FW();
    if (this.RcD != null)
    {
      this.RcD.wQ(paramInt1);
      com.tencent.mm.plugin.sns.statistics.l.QGY.c(this.RcD);
    }
    al.hgx().hej();
    this.lzt.finish();
    AppMethodBeat.o(98207);
    return false;
  }
  
  public final void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(98205);
    this.RcD = com.tencent.mm.modelsns.l.y(this.lzt.getIntent());
    this.w = this.lzt.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.lzt.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.Rcy = this.lzt.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.link = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.ADt = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.hQn = this.lzt.getIntent().getStringExtra("KsnsUpload_imgPath");
    this.AnF = this.lzt.getIntent().getBooleanExtra("ksnsis_video", false);
    this.iaa = Util.nullAs(this.lzt.getIntent().getStringExtra("src_username"), "");
    this.Rcx = Util.nullAs(this.lzt.getIntent().getStringExtra("src_displayname"), "");
    this.RcC = Util.nullAs(this.lzt.getIntent().getStringExtra("KContentObjDesc"), "");
    this.RcB = Util.nullAs(this.lzt.getIntent().getStringExtra("KUploadProduct_UserData"), "");
    this.appName = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.appId = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.RcA = this.lzt.getIntent().getIntExtra("KUploadProduct_subType", 0);
    if (this.lzt.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.QzF = 1;; this.QzF = 0)
    {
      this.RcE = Util.nullAs(this.lzt.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98205);
      return;
    }
  }
  
  public final void ba(Bundle paramBundle) {}
  
  public final boolean hlP()
  {
    return true;
  }
  
  public final View hlQ()
  {
    AppMethodBeat.i(98206);
    this.doN = af.mU(this.lzt).inflate(b.g.upload_media_link, null);
    this.Rcz = ((CdnImageView)this.doN.findViewById(b.f.image_left));
    this.titleTv = ((TextView)this.doN.findViewById(b.f.titletext));
    this.ycd = ((TextView)this.doN.findViewById(b.f.righttext));
    if (this.AnF)
    {
      this.doN.findViewById(b.f.state).setVisibility(0);
      this.titleTv.setText(this.title);
      if (this.rmS == 13) {
        this.titleTv.setText(this.title + "\n" + this.RcC);
      }
      if (Util.isNullOrNil(this.ADt)) {
        break label224;
      }
      this.Rcz.setVisibility(0);
      this.Rcz.setUrl(this.ADt);
    }
    for (;;)
    {
      t.c(this.Rcz, this.lzt);
      View localView = this.doN;
      AppMethodBeat.o(98206);
      return localView;
      this.doN.findViewById(b.f.state).setVisibility(8);
      break;
      label224:
      if (!Util.isNullOrNil(this.Rcw))
      {
        this.Rcz.setVisibility(0);
        this.orY = BitmapUtil.decodeByteArray(this.Rcw);
        this.Rcz.setImageBitmap(this.orY);
      }
      else
      {
        this.Rcz.setVisibility(8);
      }
    }
  }
  
  public final boolean hlR()
  {
    return true;
  }
  
  public final boolean hlS()
  {
    return true;
  }
  
  public final boolean hlT()
  {
    AppMethodBeat.i(98208);
    if ((this.orY != null) && (!this.orY.isRecycled())) {
      this.orY.recycle();
    }
    AppMethodBeat.o(98208);
    return false;
  }
  
  public final boolean n(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au
 * JD-Core Version:    0.7.0.1
 */