package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.h.a.pv;
import com.tencent.mm.h.a.pv.b;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ak
  implements y
{
  MMActivity bER;
  String bIW = "";
  private boolean bJy = false;
  private String desc = "";
  ProgressDialog dnm = null;
  ProgressBar frw;
  private View hNa = null;
  private int oOs;
  private com.tencent.mm.modelsns.b oOy = null;
  private boolean oQL = false;
  private Bitmap oQM = null;
  private com.tencent.mm.sdk.b.c oQZ = new ak.1(this);
  ax oRa = null;
  com.tencent.mm.plugin.sight.decode.a.a oTM;
  com.tencent.mm.plugin.sight.decode.ui.c oTN = null;
  String thumbPath = "";
  String videoPath = "";
  
  public ak(MMActivity paramMMActivity)
  {
    this.bER = paramMMActivity;
  }
  
  public final void E(Bundle paramBundle)
  {
    this.oOy = com.tencent.mm.modelsns.b.i(this.bER.getIntent());
    this.thumbPath = this.bER.getIntent().getStringExtra("KSightThumbPath");
    this.videoPath = this.bER.getIntent().getStringExtra("KSightPath");
    this.bIW = this.bER.getIntent().getStringExtra("sight_md5");
    this.oOs = this.bER.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = new pv();
    paramBundle.bZp.type = 2;
    com.tencent.mm.sdk.b.a.udP.m(paramBundle);
    if (bk.bl(this.videoPath))
    {
      this.videoPath = bk.aM(paramBundle.bZq.bZu, "");
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
    }
    if (bk.bl(this.bIW)) {}
    for (paramBundle = bk.aM(paramBundle.bZq.bZs, "");; paramBundle = this.bIW)
    {
      this.bIW = paramBundle;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.bIW });
      com.tencent.mm.sdk.b.a.udP.c(this.oQZ);
      return;
    }
  }
  
  public final void F(Bundle paramBundle) {}
  
  public final boolean a(int paramInt1, int paramInt2, org.c.d.i parami, String paramString1, List<String> paramList1, aui paramaui, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    if (this.oRa != null) {
      return false;
    }
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramString2 = com.tencent.mm.model.s.Ha();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if (!paramString2.contains(str))
        {
          buw localbuw = new buw();
          localbuw.hPY = str;
          parami.add(localbuw);
        }
      }
    }
    this.oRa = new ax(15);
    paramPInt.value = this.oRa.avS;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.omJ) {
      this.oRa.xS(3);
    }
    paramString1 = this.oRa.NR(paramString1);
    new LinkedList();
    paramString1.a(paramaui).am(parami).xU(paramInt1).xV(paramInt2).cx(paramList2);
    if (paramBoolean) {
      this.oRa.xX(1);
    }
    for (;;)
    {
      this.oRa.cx(paramList2).xU(paramInt1);
      this.oRa.xW(this.oOs);
      this.oRa.f(null, null, null, paramInt4, paramInt5);
      if (!e.bK(this.videoPath)) {
        break;
      }
      bIa();
      return true;
      this.oRa.xX(0);
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
    parami = this.bER;
    this.bER.getString(i.j.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(parami, this.bER.getString(i.j.sns_sight_send_wait), true, new ak.3(this));
    return true;
  }
  
  public final boolean bHq()
  {
    return true;
  }
  
  public final View bHr()
  {
    this.hNa = View.inflate(this.bER, i.g.upload_sight_widget, null);
    this.oTM = ((com.tencent.mm.plugin.sight.decode.a.a)this.hNa.findViewById(i.f.image));
    this.oTM.setDrawableWidth(com.tencent.mm.cb.a.fromDPToPix(this.bER, 90));
    this.frw = ((ProgressBar)this.hNa.findViewById(i.f.load_progress));
    Object localObject = new DisplayMetrics();
    this.bER.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.hNa.findViewById(i.f.chatting_click_area).setOnClickListener(new ak.2(this));
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + e.aeQ(this.videoPath) + " " + e.aeQ(this.thumbPath));
    if (e.bK(this.videoPath))
    {
      this.oTM.aW(this.videoPath, false);
      this.frw.setVisibility(8);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.bIW });
    }
    for (;;)
    {
      return this.hNa;
      localObject = com.tencent.mm.plugin.sns.data.i.Na(this.thumbPath);
      if (localObject != null)
      {
        this.oQM = ((n)localObject).Fd();
        if (com.tencent.mm.plugin.sns.data.i.s(this.oQM)) {
          this.oTM.setThumbBmp(this.oQM);
        }
      }
      this.frw.setVisibility(0);
    }
  }
  
  public final boolean bHs()
  {
    if (this.dnm != null) {
      this.dnm.dismiss();
    }
    com.tencent.mm.sdk.b.a.udP.d(this.oQZ);
    if (com.tencent.mm.plugin.sns.data.i.s(this.oQM)) {
      this.oQM.recycle();
    }
    return false;
  }
  
  final void bIa()
  {
    if (this.oQL) {
      return;
    }
    if (!this.oRa.q(this.videoPath, this.thumbPath, this.desc, this.bIW))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SightWidget", "videopath " + e.aeQ(this.videoPath) + " thumb: " + e.aeQ(this.thumbPath));
      com.tencent.mm.ui.base.s.makeText(this.bER, i.j.sendrequest_send_fail, 0).show();
      return;
    }
    Object localObject = new pv();
    ((pv)localObject).bZp.type = 0;
    ((pv)localObject).bZp.bZr = true;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    this.oQL = true;
    int i = this.oRa.commit();
    if (this.oOy != null)
    {
      this.oOy.jf(i);
      f.ozP.c(this.oOy);
    }
    af.bDM().oSY = 0L;
    localObject = new Intent();
    ((Intent)localObject).putExtra("sns_resume_state", false);
    ((Intent)localObject).putExtra("sns_timeline_NeedFirstLoadint", true);
    ((Intent)localObject).setClass(this.bER, SnsTimeLineUI.class);
    ((Intent)localObject).addFlags(67108864);
    this.bER.startActivity((Intent)localObject);
    this.bER.setResult(-1);
    this.bER.finish();
  }
  
  public final boolean d(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak
 * JD-Core Version:    0.7.0.1
 */