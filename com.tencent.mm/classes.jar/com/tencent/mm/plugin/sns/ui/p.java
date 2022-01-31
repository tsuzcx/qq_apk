package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.as.o;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.plugin.sns.h.h;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  implements y
{
  private String appId = "";
  private String appName = "";
  private MMActivity bER;
  private String bYG;
  private String eAl = "";
  private TextView eXr = null;
  private Bitmap ebo = null;
  private int h = -1;
  private View hNa = null;
  private String imgPath = "";
  private boolean khM = false;
  private String oOp = "";
  private byte[] oOq = null;
  private String oOr;
  private int oOs;
  private CdnImageView oOt = null;
  private TextView oOu = null;
  private int oOv;
  private String oOw = "";
  private String oOx = "";
  private b oOy = null;
  private String title = "";
  private int w = -1;
  
  public p(MMActivity paramMMActivity)
  {
    this.bER = paramMMActivity;
  }
  
  public final void E(Bundle paramBundle)
  {
    this.oOy = b.i(this.bER.getIntent());
    this.w = this.bER.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.bER.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.oOs = this.bER.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.eAl = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.oOp = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.imgPath = this.bER.getIntent().getStringExtra("KsnsUpload_imgPath");
    this.khM = this.bER.getIntent().getBooleanExtra("ksnsis_video", false);
    this.bYG = bk.aM(this.bER.getIntent().getStringExtra("src_username"), "");
    this.oOr = bk.aM(this.bER.getIntent().getStringExtra("src_displayname"), "");
    this.oOx = bk.aM(this.bER.getIntent().getStringExtra("KContentObjDesc"), "");
    this.oOw = bk.aM(this.bER.getIntent().getStringExtra("KUploadProduct_UserData"), "");
    this.appName = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.appId = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.oOv = this.bER.getIntent().getIntExtra("KUploadProduct_subType", 0);
  }
  
  public final void F(Bundle paramBundle) {}
  
  public final boolean a(int paramInt1, int paramInt2, org.c.d.i parami, String paramString1, List<String> paramList1, aui paramaui, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    paramString2 = new ax(22);
    paramPInt.value = paramString2.avS;
    if (paramInt3 > a.omJ) {
      paramString2.xS(2);
    }
    if (parami != null) {
      paramString2.eM(parami.token, parami.tsv);
    }
    paramString2.NW(this.title).NU(this.oOx).NV(this.eAl).NR(paramString1);
    boolean bool2 = false;
    boolean bool1;
    if (!bk.bl(this.imgPath))
    {
      bool1 = paramString2.a(e.c(this.imgPath, 0, -1), this.oOx, this.title, this.oOv, this.oOw);
      bool2 = bool1;
      if (!bool1)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.EmotionListShareWidget", "set userData user imgurl ");
        bool2 = paramString2.b(this.oOp, this.oOp, this.oOx, this.oOv, this.oOw);
      }
      if (!bool2) {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.EmotionListShareWidget", "set userData faild");
      }
      paramString2.xW(this.oOs);
      paramString2.NZ(this.bYG);
      paramString2.Oa(this.oOr);
      paramString2.xU(paramInt1);
      paramString2.f(null, null, null, paramInt4, paramInt5);
      if (!paramBoolean) {
        break label451;
      }
      paramString2.xX(1);
    }
    for (;;)
    {
      paramString2.cx(paramList2);
      if (!bk.bl(this.appId))
      {
        paramString2.NX(this.appId);
        paramString2.NY(this.appName);
      }
      parami = new LinkedList();
      if (paramList1 == null) {
        break label461;
      }
      new LinkedList();
      paramString1 = s.Ha();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if (!paramString1.contains(paramList2))
        {
          paramPInt = new buw();
          paramPInt.hPY = paramList2;
          parami.add(paramPInt);
        }
      }
      bool1 = bool2;
      if (bk.bl(this.oOp)) {
        break;
      }
      bool1 = bool2;
      if (o.OI() == null) {
        break;
      }
      o.OI();
      parami = com.tencent.mm.as.c.jK(this.oOp);
      bool1 = bool2;
      if (parami == null) {
        break;
      }
      bool1 = paramString2.a(com.tencent.mm.sdk.platformtools.c.U(parami), this.oOx, this.title, this.oOv, this.oOw);
      break;
      label451:
      paramString2.xX(0);
    }
    label461:
    paramString2.am(parami);
    paramString2.a(paramaui);
    paramInt1 = paramString2.commit();
    if (this.oOy != null)
    {
      this.oOy.jf(paramInt1);
      f.ozP.c(this.oOy);
    }
    af.bDB().bCp();
    this.bER.finish();
    return false;
  }
  
  public final boolean bHq()
  {
    return true;
  }
  
  public final View bHr()
  {
    this.hNa = com.tencent.mm.ui.y.gt(this.bER).inflate(i.g.upload_media_link, null);
    this.oOt = ((CdnImageView)this.hNa.findViewById(i.f.image_left));
    this.eXr = ((TextView)this.hNa.findViewById(i.f.titletext));
    this.oOu = ((TextView)this.hNa.findViewById(i.f.righttext));
    if (this.khM)
    {
      this.hNa.findViewById(i.f.state).setVisibility(0);
      this.eXr.setText(this.title);
      if (bk.bl(this.oOp)) {
        break label164;
      }
      this.oOt.setVisibility(0);
      this.oOt.setUrl(this.oOp);
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.data.i.b(this.oOt, this.bER);
      return this.hNa;
      this.hNa.findViewById(i.f.state).setVisibility(8);
      break;
      label164:
      if (!bk.bE(this.oOq))
      {
        this.oOt.setVisibility(0);
        this.ebo = com.tencent.mm.sdk.platformtools.c.bu(this.oOq);
        this.oOt.setImageBitmap(this.ebo);
      }
      else
      {
        this.oOt.setVisibility(8);
      }
    }
  }
  
  public final boolean bHs()
  {
    if ((this.ebo != null) && (!this.ebo.isRecycled())) {
      this.ebo.recycle();
    }
    return false;
  }
  
  public final boolean d(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.p
 * JD-Core Version:    0.7.0.1
 */