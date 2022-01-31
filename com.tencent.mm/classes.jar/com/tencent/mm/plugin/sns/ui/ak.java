package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.g.a.rd.b;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ak
  implements y
{
  MMActivity cmc;
  private boolean cqS;
  String cqq;
  private String desc;
  ProgressDialog eeN;
  private View jIo;
  ProgressBar progressBar;
  private int rGd;
  private com.tencent.mm.modelsns.b rGj;
  private com.tencent.mm.sdk.b.c rIL;
  ay rIM;
  private boolean rIx;
  private Bitmap rIy;
  com.tencent.mm.plugin.sight.decode.a.a rLK;
  com.tencent.mm.plugin.sight.decode.ui.c rLL;
  String thumbPath;
  String videoPath;
  
  public ak(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(38600);
    this.jIo = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.cqq = "";
    this.cqS = false;
    this.rIx = false;
    this.rIy = null;
    this.rLL = null;
    this.rGj = null;
    this.rIL = new ak.1(this);
    this.rIM = null;
    this.desc = "";
    this.eeN = null;
    this.cmc = paramMMActivity;
    AppMethodBeat.o(38600);
  }
  
  public final void V(Bundle paramBundle)
  {
    AppMethodBeat.i(38601);
    this.rGj = com.tencent.mm.modelsns.b.w(this.cmc.getIntent());
    this.thumbPath = this.cmc.getIntent().getStringExtra("KSightThumbPath");
    this.videoPath = this.cmc.getIntent().getStringExtra("KSightPath");
    this.cqq = this.cmc.getIntent().getStringExtra("sight_md5");
    this.rGd = this.cmc.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = new rd();
    paramBundle.cHE.type = 2;
    com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
    if (bo.isNullOrNil(this.videoPath))
    {
      this.videoPath = bo.bf(paramBundle.cHF.cHJ, "");
      ab.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
    }
    if (bo.isNullOrNil(this.cqq)) {}
    for (paramBundle = bo.bf(paramBundle.cHF.cHH, "");; paramBundle = this.cqq)
    {
      this.cqq = paramBundle;
      ab.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.cqq });
      com.tencent.mm.sdk.b.a.ymk.c(this.rIL);
      AppMethodBeat.o(38601);
      return;
    }
  }
  
  public final void W(Bundle paramBundle) {}
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bap parambap, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(38603);
    if (this.rIM != null)
    {
      AppMethodBeat.o(38603);
      return false;
    }
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramString2 = com.tencent.mm.model.t.aac();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if (!paramString2.contains(str))
        {
          cfm localcfm = new cfm();
          localcfm.jJA = str;
          parami.add(localcfm);
        }
      }
    }
    this.rIM = new ay(15);
    paramPInt.value = this.rIM.ayi;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.raX) {
      this.rIM.DS(3);
    }
    paramString1 = this.rIM.aaL(paramString1);
    new LinkedList();
    paramString1.a(parambap).av(parami).DU(paramInt1).DV(paramInt2).dc(paramList2);
    if (paramBoolean) {
      this.rIM.DX(1);
    }
    for (;;)
    {
      this.rIM.dc(paramList2).DU(paramInt1);
      this.rIM.DW(this.rGd);
      this.rIM.g(null, null, null, paramInt4, paramInt5);
      if (!e.cN(this.videoPath)) {
        break;
      }
      cus();
      AppMethodBeat.o(38603);
      return true;
      this.rIM.DX(0);
    }
    ab.i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
    parami = this.cmc;
    this.cmc.getString(2131297087);
    this.eeN = h.b(parami, this.cmc.getString(2131303961), true, new ak.3(this));
    AppMethodBeat.o(38603);
    return true;
  }
  
  public final boolean ctu()
  {
    return true;
  }
  
  public final View ctv()
  {
    AppMethodBeat.i(38602);
    this.jIo = View.inflate(this.cmc, 2130971054, null);
    this.rLK = ((com.tencent.mm.plugin.sight.decode.a.a)this.jIo.findViewById(2131820629));
    this.rLK.setDrawableWidth(com.tencent.mm.cb.a.fromDPToPix(this.cmc, 90));
    this.progressBar = ((ProgressBar)this.jIo.findViewById(2131824014));
    this.cmc.getResources().getDisplayMetrics();
    this.jIo.findViewById(2131822580).setOnClickListener(new ak.2(this));
    ab.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + e.avI(this.videoPath) + " " + e.avI(this.thumbPath));
    if (e.cN(this.videoPath))
    {
      this.rLK.bl(this.videoPath, false);
      this.progressBar.setVisibility(8);
      ab.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.cqq });
    }
    for (;;)
    {
      Object localObject = this.jIo;
      AppMethodBeat.o(38602);
      return localObject;
      localObject = com.tencent.mm.plugin.sns.data.i.ZH(this.thumbPath);
      if (localObject != null)
      {
        this.rIy = ((n)localObject).XS();
        if (com.tencent.mm.plugin.sns.data.i.A(this.rIy)) {
          this.rLK.setThumbBmp(this.rIy);
        }
      }
      this.progressBar.setVisibility(0);
    }
  }
  
  public final boolean ctw()
  {
    AppMethodBeat.i(38605);
    if (this.eeN != null) {
      this.eeN.dismiss();
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.rIL);
    if (com.tencent.mm.plugin.sns.data.i.A(this.rIy)) {
      this.rIy.recycle();
    }
    AppMethodBeat.o(38605);
    return false;
  }
  
  final void cus()
  {
    AppMethodBeat.i(38604);
    if (this.rIx)
    {
      AppMethodBeat.o(38604);
      return;
    }
    if (!this.rIM.t(this.videoPath, this.thumbPath, this.desc, this.cqq))
    {
      ab.i("MicroMsg.SightWidget", "videopath " + e.avI(this.videoPath) + " thumb: " + e.avI(this.thumbPath));
      com.tencent.mm.ui.base.t.makeText(this.cmc, 2131303126, 0).show();
      AppMethodBeat.o(38604);
      return;
    }
    Object localObject = new rd();
    ((rd)localObject).cHE.type = 0;
    ((rd)localObject).cHE.cHG = true;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    this.rIx = true;
    int i = this.rIM.commit();
    if (this.rGj != null)
    {
      this.rGj.lX(i);
      g.roZ.c(this.rGj);
    }
    ag.cpm().rKV = 0L;
    localObject = new Intent();
    ((Intent)localObject).putExtra("sns_resume_state", false);
    ((Intent)localObject).putExtra("sns_timeline_NeedFirstLoadint", true);
    ((Intent)localObject).setClass(this.cmc, SnsTimeLineUI.class);
    ((Intent)localObject).addFlags(67108864);
    this.cmc.startActivity((Intent)localObject);
    this.cmc.setResult(-1);
    this.cmc.finish();
    AppMethodBeat.o(38604);
  }
  
  public final boolean j(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak
 * JD-Core Version:    0.7.0.1
 */