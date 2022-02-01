package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.sw.b;
import com.tencent.mm.memory.n;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.k.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ao
  implements ab
{
  private String desc;
  private boolean dfO;
  ProgressDialog fpP;
  MMActivity imP;
  String md5;
  private View pf;
  ProgressBar progressBar;
  String thumbPath;
  String videoPath;
  private int wLo;
  private int xlZ;
  private d xmf;
  private String xmg;
  private boolean xoL;
  private Bitmap xoM;
  private com.tencent.mm.sdk.b.c xpb;
  ba xpc;
  com.tencent.mm.plugin.sight.decode.a.a xsw;
  com.tencent.mm.plugin.sight.decode.ui.c xsx;
  
  public ao(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(98288);
    this.pf = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.md5 = "";
    this.dfO = false;
    this.xoL = false;
    this.xoM = null;
    this.xsx = null;
    this.xmf = null;
    this.wLo = 1;
    this.xmg = "";
    this.xpb = new com.tencent.mm.sdk.b.c() {};
    this.xpc = null;
    this.desc = "";
    this.fpP = null;
    this.imP = paramMMActivity;
    AppMethodBeat.o(98288);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bmn parambmn, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98291);
    if (this.xpc != null)
    {
      AppMethodBeat.o(98291);
      return false;
    }
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramLinkedList = w.arx();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramLinkedList.contains(paramString2))
        {
          cwk localcwk = new cwk();
          localcwk.mAQ = paramString2;
          parami.add(localcwk);
        }
      }
    }
    this.xpc = new ba(15);
    paramPInt.value = this.xpc.aTB;
    if (paramInt3 > com.tencent.mm.plugin.sns.d.a.wzN) {
      this.xpc.Ms(3);
    }
    paramString1 = this.xpc.aoS(paramString1);
    new LinkedList();
    paramString1.a(parambmn).aM(parami).Mu(paramInt1).Mv(paramInt2).fq(paramList2);
    if (paramBoolean) {
      this.xpc.Mx(1);
    }
    for (;;)
    {
      this.xpc.fq(paramList2).Mu(paramInt1);
      this.xpc.Mw(this.xlZ);
      this.xpc.bR(this.wLo, this.xmg);
      this.xpc.g(null, null, null, paramInt4, paramInt5);
      if (!com.tencent.mm.vfs.i.eK(this.videoPath)) {
        break;
      }
      dAg();
      AppMethodBeat.o(98291);
      return true;
      this.xpc.Mx(0);
    }
    ad.i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
    parami = this.imP;
    this.imP.getString(2131755906);
    this.fpP = com.tencent.mm.ui.base.h.b(parami, this.imP.getString(2131763977), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        ao.this.xpc = null;
      }
    });
    AppMethodBeat.o(98291);
    return true;
  }
  
  public final void af(Bundle paramBundle)
  {
    AppMethodBeat.i(98289);
    this.xmf = d.w(this.imP.getIntent());
    this.thumbPath = this.imP.getIntent().getStringExtra("KSightThumbPath");
    this.videoPath = this.imP.getIntent().getStringExtra("KSightPath");
    this.md5 = this.imP.getIntent().getStringExtra("sight_md5");
    this.xlZ = this.imP.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = new sw();
    paramBundle.dyt.type = 2;
    com.tencent.mm.sdk.b.a.ESL.l(paramBundle);
    if (bt.isNullOrNil(this.videoPath))
    {
      this.videoPath = bt.by(paramBundle.dyu.dyy, "");
      ad.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
    }
    if (bt.isNullOrNil(this.md5))
    {
      paramBundle = bt.by(paramBundle.dyu.dyw, "");
      this.md5 = paramBundle;
      ad.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.md5 });
      com.tencent.mm.sdk.b.a.ESL.c(this.xpb);
      if (!this.imP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
        break label287;
      }
    }
    label287:
    for (this.wLo = 1;; this.wLo = 0)
    {
      this.xmg = bt.by(this.imP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98289);
      return;
      paramBundle = this.md5;
      break;
    }
  }
  
  public final void ag(Bundle paramBundle) {}
  
  final void dAg()
  {
    AppMethodBeat.i(98292);
    if (this.xoL)
    {
      AppMethodBeat.o(98292);
      return;
    }
    if (!this.xpc.w(this.videoPath, this.thumbPath, this.desc, this.md5))
    {
      ad.i("MicroMsg.SightWidget", "videopath " + com.tencent.mm.vfs.i.aMN(this.videoPath) + " thumb: " + com.tencent.mm.vfs.i.aMN(this.thumbPath));
      t.makeText(this.imP, 2131763075, 0).show();
      AppMethodBeat.o(98292);
      return;
    }
    Object localObject1 = new sw();
    ((sw)localObject1).dyt.type = 0;
    ((sw)localObject1).dyt.dyv = true;
    com.tencent.mm.sdk.b.a.ESL.l((b)localObject1);
    this.xoL = true;
    int i = this.xpc.commit();
    if (this.xmf != null)
    {
      this.xmf.oG(i);
      com.tencent.mm.plugin.sns.k.h.wRM.c(this.xmf);
    }
    af.dtC().xrz = 0L;
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("sns_resume_state", false);
    ((Intent)localObject2).putExtra("sns_timeline_NeedFirstLoadint", true);
    ((Intent)localObject2).setClass(this.imP, SnsTimeLineUI.class);
    ((Intent)localObject2).addFlags(67108864);
    localObject1 = this.imP;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.imP.setResult(-1);
    this.imP.finish();
    AppMethodBeat.o(98292);
  }
  
  public final boolean dyU()
  {
    return true;
  }
  
  public final View dyV()
  {
    AppMethodBeat.i(98290);
    this.pf = View.inflate(this.imP, 2131495819, null);
    this.xsw = ((com.tencent.mm.plugin.sight.decode.a.a)this.pf.findViewById(2131300914));
    this.xsw.setDrawableWidth(com.tencent.mm.cd.a.fromDPToPix(this.imP, 90));
    this.progressBar = ((ProgressBar)this.pf.findViewById(2131301489));
    this.imP.getResources().getDisplayMetrics();
    this.pf.findViewById(2131298069).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98287);
        if (!com.tencent.mm.vfs.i.eK(ao.this.videoPath))
        {
          ad.i("MicroMsg.SightWidget", "click videopath is not exist " + ao.this.videoPath);
          AppMethodBeat.o(98287);
          return;
        }
        if (ao.this.xsx != null)
        {
          ao.this.xsx.dismiss();
          ao.this.xsx = null;
        }
        ao.this.xsx = new com.tencent.mm.plugin.sight.decode.ui.c(ao.this.imP);
        paramAnonymousView = ao.this.xsx;
        String str1 = ao.this.videoPath;
        String str2 = ao.this.thumbPath;
        paramAnonymousView.gjt = str1;
        paramAnonymousView.imagePath = str2;
        paramAnonymousView = ao.this.xsx;
        paramAnonymousView.dBy = 0;
        paramAnonymousView.wsd = 0;
        paramAnonymousView.qeb = 1;
        ao.this.xsx.show();
        AppMethodBeat.o(98287);
      }
    });
    ad.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + com.tencent.mm.vfs.i.aMN(this.videoPath) + " " + com.tencent.mm.vfs.i.aMN(this.thumbPath));
    if (com.tencent.mm.vfs.i.eK(this.videoPath))
    {
      this.xsw.e(this.videoPath, false, 0);
      this.progressBar.setVisibility(8);
      ad.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.md5 });
    }
    for (;;)
    {
      Object localObject = this.pf;
      AppMethodBeat.o(98290);
      return localObject;
      localObject = q.anL(this.thumbPath);
      if (localObject != null)
      {
        this.xoM = ((n)localObject).apb();
        if (q.I(this.xoM)) {
          this.xsw.setThumbBmp(this.xoM);
        }
      }
      this.progressBar.setVisibility(0);
    }
  }
  
  public final boolean dyW()
  {
    AppMethodBeat.i(98293);
    if (this.fpP != null) {
      this.fpP.dismiss();
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.xpb);
    if (q.I(this.xoM)) {
      this.xoM.recycle();
    }
    AppMethodBeat.o(98293);
    return false;
  }
  
  public final boolean j(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ao
 * JD-Core Version:    0.7.0.1
 */