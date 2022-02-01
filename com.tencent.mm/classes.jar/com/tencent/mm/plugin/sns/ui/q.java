package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.plugin.sns.k.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  implements ab
{
  private String appId = "";
  private String appName = "";
  private String dpa = "";
  private String dxz;
  private Bitmap gTB = null;
  private int h = -1;
  private MMActivity imP;
  private String link = "";
  private boolean osM = false;
  private View pf = null;
  private String qpB = "";
  private String title = "";
  private TextView titleTv = null;
  private int w = -1;
  private int wLo = 1;
  private byte[] xlX = null;
  private String xlY;
  private int xlZ;
  private CdnImageView xma = null;
  private TextView xmb = null;
  private int xmc;
  private String xmd = "";
  private String xme = "";
  private com.tencent.mm.modelsns.d xmf = null;
  private String xmg = "";
  
  public q(MMActivity paramMMActivity)
  {
    this.imP = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bmn parambmn, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97865);
    paramLinkedList = new ba(10);
    paramPInt.value = paramLinkedList.aTB;
    if (paramInt3 > a.wzN) {
      paramLinkedList.Ms(2);
    }
    if (parami != null) {
      paramLinkedList.iI(parami.token, parami.DNx);
    }
    paramLinkedList.aoX(this.title).aoV(this.xme).aoW(this.link).aoS(paramString1);
    boolean bool2 = false;
    boolean bool1;
    if (!bt.isNullOrNil(this.dpa))
    {
      bool1 = paramLinkedList.a(com.tencent.mm.vfs.i.aR(this.dpa, 0, -1), this.xme, this.title, this.xmc, this.xmd);
      bool2 = bool1;
      if (!bool1)
      {
        ad.i("MicroMsg.EmojiShareWidget", "set userData user imgurl ");
        bool2 = paramLinkedList.b(this.qpB, this.qpB, this.xme, this.xmc, this.xmd);
      }
      if (!bool2) {
        ad.e("MicroMsg.EmojiShareWidget", "set userData faild");
      }
      paramLinkedList.bR(this.wLo, this.xmg);
      paramLinkedList.Mw(this.xlZ);
      paramLinkedList.apa(this.dxz);
      paramLinkedList.apb(this.xlY);
      if (!paramBoolean) {
        break label451;
      }
      paramLinkedList.Mx(1);
    }
    for (;;)
    {
      paramLinkedList.fq(paramList2);
      if (!bt.isNullOrNil(this.appId))
      {
        paramLinkedList.aoY(this.appId);
        paramLinkedList.aoZ(this.appName);
      }
      parami = new LinkedList();
      if (paramList1 == null) {
        break label461;
      }
      new LinkedList();
      paramString1 = w.arx();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if (!paramString1.contains(paramList2))
        {
          paramPInt = new cwk();
          paramPInt.mAQ = paramList2;
          parami.add(paramPInt);
        }
      }
      bool1 = bool2;
      if (bt.isNullOrNil(this.qpB)) {
        break;
      }
      bool1 = bool2;
      if (o.ayE() == null) {
        break;
      }
      o.ayE();
      parami = c.pT(this.qpB);
      bool1 = bool2;
      if (parami == null) {
        break;
      }
      bool1 = paramLinkedList.a(f.aw(parami), this.xme, this.title, this.xmc, this.xmd);
      break;
      label451:
      paramLinkedList.Mx(0);
    }
    label461:
    paramLinkedList.aM(parami).Mu(paramInt1);
    paramLinkedList.g(null, null, null, paramInt4, paramInt5);
    paramLinkedList.a(parambmn);
    paramInt1 = paramLinkedList.commit();
    if (this.xmf != null)
    {
      this.xmf.oG(paramInt1);
      com.tencent.mm.plugin.sns.k.h.wRM.c(this.xmf);
    }
    af.dtq().drS();
    this.imP.finish();
    parami = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TH(this.xmd);
    com.tencent.mm.plugin.report.service.h.vKh.f(10993, new Object[] { Integer.valueOf(1), parami });
    AppMethodBeat.o(97865);
    return false;
  }
  
  public final void af(Bundle paramBundle)
  {
    AppMethodBeat.i(97863);
    this.xmf = com.tencent.mm.modelsns.d.w(this.imP.getIntent());
    this.w = this.imP.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.imP.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.xlZ = this.imP.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.link = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.qpB = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.dpa = this.imP.getIntent().getStringExtra("KsnsUpload_imgPath");
    this.osM = this.imP.getIntent().getBooleanExtra("ksnsis_video", false);
    this.dxz = bt.by(this.imP.getIntent().getStringExtra("src_username"), "");
    this.xlY = bt.by(this.imP.getIntent().getStringExtra("src_displayname"), "");
    this.xme = bt.by(this.imP.getIntent().getStringExtra("KContentObjDesc"), "");
    this.xmd = bt.by(this.imP.getIntent().getStringExtra("KUploadProduct_UserData"), "");
    this.appName = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.appId = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.xmc = this.imP.getIntent().getIntExtra("KUploadProduct_subType", 0);
    if (this.imP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.wLo = 1;; this.wLo = 0)
    {
      this.xmg = bt.by(this.imP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(97863);
      return;
    }
  }
  
  public final void ag(Bundle paramBundle) {}
  
  public final boolean dyU()
  {
    return true;
  }
  
  public final View dyV()
  {
    AppMethodBeat.i(97864);
    this.pf = y.js(this.imP).inflate(2131495816, null);
    this.xma = ((CdnImageView)this.pf.findViewById(2131300948));
    this.titleTv = ((TextView)this.pf.findViewById(2131305950));
    this.xmb = ((TextView)this.pf.findViewById(2131304202));
    if (this.osM)
    {
      this.pf.findViewById(2131305185).setVisibility(0);
      this.titleTv.setText(this.title);
      if (bt.isNullOrNil(this.qpB)) {
        break label178;
      }
      this.xma.setVisibility(0);
      this.xma.setUrl(this.qpB);
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.data.q.b(this.xma, this.imP);
      View localView = this.pf;
      AppMethodBeat.o(97864);
      return localView;
      this.pf.findViewById(2131305185).setVisibility(8);
      break;
      label178:
      if (!bt.cw(this.xlX))
      {
        this.xma.setVisibility(0);
        this.gTB = f.cl(this.xlX);
        this.xma.setImageBitmap(this.gTB);
      }
      else
      {
        this.xma.setVisibility(8);
      }
    }
  }
  
  public final boolean dyW()
  {
    AppMethodBeat.i(97866);
    if ((this.gTB != null) && (!this.gTB.isRecycled())) {
      this.gTB.recycle();
    }
    AppMethodBeat.o(97866);
    return false;
  }
  
  public final boolean j(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.q
 * JD-Core Version:    0.7.0.1
 */