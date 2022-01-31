package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
  implements y
{
  private String appId = "";
  private String appName = "";
  private String cGN;
  private MMActivity cmc;
  private Bitmap frG = null;
  private int h = -1;
  private String imgPath = "";
  private View jIo = null;
  private String link = "";
  private boolean mCu = false;
  private String rGa = "";
  private byte[] rGb = null;
  private String rGc;
  private int rGd;
  private CdnImageView rGe = null;
  private TextView rGf = null;
  private int rGg;
  private String rGh = "";
  private String rGi = "";
  private b rGj = null;
  private String title = "";
  private TextView titleTv = null;
  private int w = -1;
  
  public m(MMActivity paramMMActivity)
  {
    this.cmc = paramMMActivity;
  }
  
  public final void V(Bundle paramBundle)
  {
    AppMethodBeat.i(38211);
    this.rGj = b.w(this.cmc.getIntent());
    this.w = this.cmc.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.cmc.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.rGd = this.cmc.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.link = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.rGa = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.imgPath = this.cmc.getIntent().getStringExtra("KsnsUpload_imgPath");
    this.mCu = this.cmc.getIntent().getBooleanExtra("ksnsis_video", false);
    this.cGN = bo.bf(this.cmc.getIntent().getStringExtra("src_username"), "");
    this.rGc = bo.bf(this.cmc.getIntent().getStringExtra("src_displayname"), "");
    this.rGi = bo.bf(this.cmc.getIntent().getStringExtra("KContentObjDesc"), "");
    this.rGh = bo.bf(this.cmc.getIntent().getStringExtra("KUploadProduct_UserData"), "");
    this.appName = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.appId = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.rGg = this.cmc.getIntent().getIntExtra("KUploadProduct_subType", 0);
    AppMethodBeat.o(38211);
  }
  
  public final void W(Bundle paramBundle) {}
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bap parambap, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(38213);
    paramString2 = new ay(17);
    paramPInt.value = paramString2.ayi;
    if (paramInt3 > a.raX) {
      paramString2.DS(2);
    }
    if (parami != null) {
      paramString2.go(parami.token, parami.xsy);
    }
    paramString2.aaQ(this.title).aaO(this.rGi).aaP(this.link).aaL(paramString1);
    boolean bool2 = false;
    boolean bool1;
    if (!bo.isNullOrNil(this.imgPath))
    {
      bool1 = paramString2.a(e.i(this.imgPath, 0, -1), this.rGi, this.title, this.rGg, this.rGh);
      bool2 = bool1;
      if (!bool1)
      {
        ab.i("MicroMsg.EmojiDesignerShareWidget", "set userData user imgurl ");
        bool2 = paramString2.b(this.rGa, this.rGa, this.rGi, this.rGg, this.rGh);
      }
      if (!bool2) {
        ab.e("MicroMsg.EmojiDesignerShareWidget", "set userData faild");
      }
      paramString2.DW(this.rGd);
      paramString2.aaT(this.cGN);
      paramString2.aaU(this.rGc);
      paramString2.g(null, null, null, paramInt4, paramInt5);
      paramString2.DU(paramInt1);
      if (!paramBoolean) {
        break label456;
      }
      paramString2.DX(1);
    }
    for (;;)
    {
      paramString2.dc(paramList2);
      if (!bo.isNullOrNil(this.appId))
      {
        paramString2.aaR(this.appId);
        paramString2.aaS(this.appName);
      }
      parami = new LinkedList();
      if (paramList1 == null) {
        break label466;
      }
      new LinkedList();
      paramString1 = t.aac();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if (!paramString1.contains(paramList2))
        {
          paramPInt = new cfm();
          paramPInt.jJA = paramList2;
          parami.add(paramPInt);
        }
      }
      bool1 = bool2;
      if (bo.isNullOrNil(this.rGa)) {
        break;
      }
      bool1 = bool2;
      if (o.ahB() == null) {
        break;
      }
      o.ahB();
      parami = c.lK(this.rGa);
      bool1 = bool2;
      if (parami == null) {
        break;
      }
      bool1 = paramString2.a(com.tencent.mm.sdk.platformtools.d.aj(parami), this.rGi, this.title, this.rGg, this.rGh);
      break;
      label456:
      paramString2.DX(0);
    }
    label466:
    paramString2.av(parami);
    paramString2.a(parambap);
    paramInt1 = paramString2.commit();
    if (this.rGj != null)
    {
      this.rGj.lX(paramInt1);
      com.tencent.mm.plugin.sns.i.g.roZ.c(this.rGj);
    }
    ag.cpb().cnP();
    this.cmc.finish();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().KC(this.rGh);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().KD(this.rGh);
    AppMethodBeat.o(38213);
    return false;
  }
  
  public final boolean ctu()
  {
    return true;
  }
  
  public final View ctv()
  {
    AppMethodBeat.i(38212);
    this.jIo = w.hM(this.cmc).inflate(2130971051, null);
    this.rGe = ((CdnImageView)this.jIo.findViewById(2131825855));
    this.titleTv = ((TextView)this.jIo.findViewById(2131825857));
    this.rGf = ((TextView)this.jIo.findViewById(2131825858));
    if (this.mCu)
    {
      this.jIo.findViewById(2131824765).setVisibility(0);
      this.titleTv.setText(this.title);
      if (bo.isNullOrNil(this.rGa)) {
        break label178;
      }
      this.rGe.setVisibility(0);
      this.rGe.setUrl(this.rGa);
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.data.i.b(this.rGe, this.cmc);
      View localView = this.jIo;
      AppMethodBeat.o(38212);
      return localView;
      this.jIo.findViewById(2131824765).setVisibility(8);
      break;
      label178:
      if (!bo.ce(this.rGb))
      {
        this.rGe.setVisibility(0);
        this.frG = com.tencent.mm.sdk.platformtools.d.bT(this.rGb);
        this.rGe.setImageBitmap(this.frG);
      }
      else
      {
        this.rGe.setVisibility(8);
      }
    }
  }
  
  public final boolean ctw()
  {
    AppMethodBeat.i(38214);
    if ((this.frG != null) && (!this.frG.isRecycled())) {
      this.frG.recycle();
    }
    AppMethodBeat.o(38214);
    return false;
  }
  
  public final boolean j(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.m
 * JD-Core Version:    0.7.0.1
 */