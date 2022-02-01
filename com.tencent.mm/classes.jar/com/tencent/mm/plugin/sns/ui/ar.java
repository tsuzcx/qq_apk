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
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.a.tx.b;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.j.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ar
  implements ac
{
  private String desc;
  private boolean doF;
  MMActivity fLP;
  ProgressDialog fMu;
  String md5;
  ProgressBar progressBar;
  private com.tencent.mm.sdk.b.c rVT;
  private View rY;
  String thumbPath;
  String videoPath;
  private int zQd;
  private e zQj;
  private String zQk;
  private boolean zSW;
  private Bitmap zSX;
  bc zTm;
  com.tencent.mm.plugin.sight.decode.a.a zWH;
  com.tencent.mm.plugin.sight.decode.ui.c zWI;
  private int znT;
  
  public ar(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(98288);
    this.rY = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.md5 = "";
    this.doF = false;
    this.zSW = false;
    this.zSX = null;
    this.zWI = null;
    this.zQj = null;
    this.znT = 1;
    this.zQk = "";
    this.rVT = new com.tencent.mm.sdk.b.c() {};
    this.zTm = null;
    this.desc = "";
    this.fMu = null;
    this.fLP = paramMMActivity;
    AppMethodBeat.o(98288);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bvq parambvq, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98291);
    if (this.zTm != null)
    {
      AppMethodBeat.o(98291);
      return false;
    }
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramLinkedList = d.fas();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramLinkedList.contains(paramString2))
        {
          dhj localdhj = new dhj();
          localdhj.nDo = paramString2;
          parami.add(localdhj);
        }
      }
    }
    this.zTm = new bc(15);
    paramPInt.value = this.zTm.beN;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.zbZ) {
      this.zTm.Qb(3);
    }
    paramString1 = this.zTm.azj(paramString1);
    new LinkedList();
    paramString1.a(parambvq).aU(parami).Qe(paramInt1).Qf(paramInt2).fL(paramList2);
    if (paramBoolean) {
      this.zTm.Qh(1);
    }
    for (;;)
    {
      this.zTm.fL(paramList2).Qe(paramInt1);
      this.zTm.Qg(this.zQd);
      this.zTm.cc(this.znT, this.zQk);
      this.zTm.g(null, null, null, paramInt4, paramInt5);
      if (!com.tencent.mm.vfs.i.fv(this.videoPath)) {
        break;
      }
      eaR();
      AppMethodBeat.o(98291);
      return true;
      this.zTm.Qh(0);
    }
    ad.i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
    parami = this.fLP;
    this.fLP.getString(2131755906);
    this.fMu = h.b(parami, this.fLP.getString(2131763977), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        ar.this.zTm = null;
      }
    });
    AppMethodBeat.o(98291);
    return true;
  }
  
  public final void ap(Bundle paramBundle)
  {
    AppMethodBeat.i(98289);
    this.zQj = e.w(this.fLP.getIntent());
    this.thumbPath = this.fLP.getIntent().getStringExtra("KSightThumbPath");
    this.videoPath = this.fLP.getIntent().getStringExtra("KSightPath");
    this.md5 = this.fLP.getIntent().getStringExtra("sight_md5");
    this.zQd = this.fLP.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = new tx();
    paramBundle.dIp.type = 2;
    com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
    if (bt.isNullOrNil(this.videoPath))
    {
      this.videoPath = bt.bI(paramBundle.dIq.dIu, "");
      ad.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
    }
    if (bt.isNullOrNil(this.md5))
    {
      paramBundle = bt.bI(paramBundle.dIq.dIs, "");
      this.md5 = paramBundle;
      ad.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.md5 });
      com.tencent.mm.sdk.b.a.IbL.c(this.rVT);
      if (!this.fLP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
        break label287;
      }
    }
    label287:
    for (this.znT = 1;; this.znT = 0)
    {
      this.zQk = bt.bI(this.fLP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98289);
      return;
      paramBundle = this.md5;
      break;
    }
  }
  
  public final void aq(Bundle paramBundle) {}
  
  public final boolean dZG()
  {
    return true;
  }
  
  public final View dZH()
  {
    AppMethodBeat.i(98290);
    this.rY = View.inflate(this.fLP, 2131495819, null);
    this.zWH = ((com.tencent.mm.plugin.sight.decode.a.a)this.rY.findViewById(2131300914));
    this.zWH.setDrawableWidth(com.tencent.mm.cc.a.fromDPToPix(this.fLP, 90));
    this.progressBar = ((ProgressBar)this.rY.findViewById(2131301489));
    this.fLP.getResources().getDisplayMetrics();
    this.rY.findViewById(2131298069).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98287);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (!com.tencent.mm.vfs.i.fv(ar.this.videoPath))
        {
          ad.i("MicroMsg.SightWidget", "click videopath is not exist " + ar.this.videoPath);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98287);
          return;
        }
        if (ar.this.zWI != null)
        {
          ar.this.zWI.dismiss();
          ar.this.zWI = null;
        }
        ar.this.zWI = new com.tencent.mm.plugin.sight.decode.ui.c(ar.this.fLP);
        paramAnonymousView = ar.this.zWI;
        localObject = ar.this.videoPath;
        String str = ar.this.thumbPath;
        paramAnonymousView.hdP = ((String)localObject);
        paramAnonymousView.imagePath = str;
        paramAnonymousView = ar.this.zWI;
        paramAnonymousView.dLy = 0;
        paramAnonymousView.ySd = 0;
        paramAnonymousView.rwG = 1;
        ar.this.zWI.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98287);
      }
    });
    ad.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + com.tencent.mm.vfs.i.aYo(this.videoPath) + " " + com.tencent.mm.vfs.i.aYo(this.thumbPath));
    if (com.tencent.mm.vfs.i.fv(this.videoPath))
    {
      this.zWH.e(this.videoPath, false, 0);
      this.progressBar.setVisibility(8);
      ad.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.md5 });
    }
    for (;;)
    {
      Object localObject = this.rY;
      AppMethodBeat.o(98290);
      return localObject;
      localObject = q.ayc(this.thumbPath);
      if (localObject != null)
      {
        this.zSX = ((n)localObject).ayF();
        if (q.I(this.zSX)) {
          this.zWH.setThumbBmp(this.zSX);
        }
      }
      this.progressBar.setVisibility(0);
    }
  }
  
  public final boolean dZI()
  {
    AppMethodBeat.i(98293);
    if (this.fMu != null) {
      this.fMu.dismiss();
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.rVT);
    if (q.I(this.zSX)) {
      this.zSX.recycle();
    }
    AppMethodBeat.o(98293);
    return false;
  }
  
  final void eaR()
  {
    AppMethodBeat.i(98292);
    if (this.zSW)
    {
      AppMethodBeat.o(98292);
      return;
    }
    if (!this.zTm.z(this.videoPath, this.thumbPath, this.desc, this.md5))
    {
      ad.i("MicroMsg.SightWidget", "videopath " + com.tencent.mm.vfs.i.aYo(this.videoPath) + " thumb: " + com.tencent.mm.vfs.i.aYo(this.thumbPath));
      t.makeText(this.fLP, 2131763075, 0).show();
      AppMethodBeat.o(98292);
      return;
    }
    Object localObject1 = new tx();
    ((tx)localObject1).dIp.type = 0;
    ((tx)localObject1).dIp.dIr = true;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    this.zSW = true;
    int i = this.zTm.commit();
    if (this.zQj != null)
    {
      this.zQj.pX(i);
      g.zus.c(this.zQj);
    }
    ag.dUm().zVK = 0L;
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("sns_resume_state", false);
    ((Intent)localObject2).putExtra("sns_timeline_NeedFirstLoadint", true);
    ((Intent)localObject2).setClass(this.fLP, SnsTimeLineUI.class);
    ((Intent)localObject2).addFlags(67108864);
    localObject1 = this.fLP;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.fLP.setResult(-1);
    this.fLP.finish();
    AppMethodBeat.o(98292);
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ar
 * JD-Core Version:    0.7.0.1
 */