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
import com.tencent.mm.f.a.wa;
import com.tencent.mm.f.a.wa.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.plugin.sight.decode.ui.c;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.k.k;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aw
  implements af
{
  private int KCP;
  private l KCV;
  private String KCW;
  be KGE;
  private boolean KGn;
  private Bitmap KGo;
  com.tencent.mm.plugin.sight.decode.a.a KKt;
  c KKu;
  private int Kcp;
  private View bvK;
  private String desc;
  private boolean fzO;
  ProgressDialog iXX;
  MMActivity iXq;
  String md5;
  ProgressBar progressBar;
  String thumbPath;
  String videoPath;
  private IListener xyI;
  
  public aw(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(98288);
    this.bvK = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.md5 = "";
    this.fzO = false;
    this.KGn = false;
    this.KGo = null;
    this.KKu = null;
    this.KCV = null;
    this.Kcp = 1;
    this.KCW = "";
    this.xyI = new IListener() {};
    this.KGE = null;
    this.desc = "";
    this.iXX = null;
    this.iXq = paramMMActivity;
    AppMethodBeat.o(98288);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cst paramcst, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98291);
    if (this.KGE != null)
    {
      AppMethodBeat.o(98291);
      return false;
    }
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramLinkedList = com.tencent.mm.pluginsdk.j.a.hhW();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramLinkedList.contains(paramString2))
        {
          elm localelm = new elm();
          localelm.UserName = paramString2;
          parami.add(localelm);
        }
      }
    }
    this.KGE = new be(15, this.iXq);
    paramPInt.value = this.KGE.aOl;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.JPj) {
      this.KGE.afW(3);
    }
    paramString1 = this.KGE.bas(paramString1);
    new LinkedList();
    paramString1.a(paramcst).bL(parami).afZ(paramInt1).aga(paramInt2).hA(paramList2);
    if (paramBoolean) {
      this.KGE.agc(1);
    }
    for (;;)
    {
      this.KGE.hA(paramList2).afZ(paramInt1);
      this.KGE.agb(this.KCP);
      this.KGE.ct(this.Kcp, this.KCW);
      this.KGE.i(null, null, null, paramInt4, paramInt5);
      if (!u.agG(this.videoPath)) {
        break;
      }
      fUV();
      AppMethodBeat.o(98291);
      return true;
      this.KGE.agc(0);
    }
    Log.i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
    parami = this.iXq;
    this.iXq.getString(i.j.app_tip);
    this.iXX = h.a(parami, this.iXq.getString(i.j.sns_sight_send_wait), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        aw.this.KGE = null;
      }
    });
    AppMethodBeat.o(98291);
    return true;
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(98289);
    this.KCV = l.x(this.iXq.getIntent());
    this.thumbPath = this.iXq.getIntent().getStringExtra("KSightThumbPath");
    this.videoPath = this.iXq.getIntent().getStringExtra("KSightPath");
    this.md5 = this.iXq.getIntent().getStringExtra("sight_md5");
    this.KCP = this.iXq.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = new wa();
    paramBundle.fVd.type = 2;
    EventCenter.instance.publish(paramBundle);
    if (Util.isNullOrNil(this.videoPath))
    {
      this.videoPath = Util.nullAs(paramBundle.fVe.fVi, "");
      Log.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
    }
    if (Util.isNullOrNil(this.md5))
    {
      paramBundle = Util.nullAs(paramBundle.fVe.fVg, "");
      this.md5 = paramBundle;
      Log.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.md5 });
      EventCenter.instance.addListener(this.xyI);
      if (!this.iXq.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
        break label287;
      }
    }
    label287:
    for (this.Kcp = 1;; this.Kcp = 0)
    {
      this.KCW = Util.nullAs(this.iXq.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98289);
      return;
      paramBundle = this.md5;
      break;
    }
  }
  
  public final void az(Bundle paramBundle) {}
  
  public final boolean fTA()
  {
    AppMethodBeat.i(98293);
    if (this.iXX != null) {
      this.iXX.dismiss();
    }
    EventCenter.instance.removeListener(this.xyI);
    if (t.K(this.KGo)) {
      this.KGo.recycle();
    }
    AppMethodBeat.o(98293);
    return false;
  }
  
  public final boolean fTw()
  {
    return true;
  }
  
  public final View fTx()
  {
    AppMethodBeat.i(98290);
    this.bvK = View.inflate(this.iXq, i.g.upload_sight_widget, null);
    this.KKt = ((com.tencent.mm.plugin.sight.decode.a.a)this.bvK.findViewById(i.f.image));
    this.KKt.setDrawableWidth(com.tencent.mm.ci.a.fromDPToPix(this.iXq, 90));
    this.progressBar = ((ProgressBar)this.bvK.findViewById(i.f.load_progress));
    this.iXq.getResources().getDisplayMetrics();
    this.bvK.findViewById(i.f.chatting_click_area).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98287);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        if (!u.agG(aw.this.videoPath))
        {
          Log.i("MicroMsg.SightWidget", "click videopath is not exist " + aw.this.videoPath);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98287);
          return;
        }
        if (aw.this.KKu != null)
        {
          aw.this.KKu.dismiss();
          aw.this.KKu = null;
        }
        aw.this.KKu = new c(aw.this.iXq);
        paramAnonymousView = aw.this.KKu;
        localObject = aw.this.videoPath;
        String str = aw.this.thumbPath;
        paramAnonymousView.fullPath = ((String)localObject);
        paramAnonymousView.imagePath = str;
        paramAnonymousView = aw.this.KKu;
        paramAnonymousView.fYU = 0;
        paramAnonymousView.JsJ = 0;
        paramAnonymousView.wKJ = 1;
        aw.this.KKu.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98287);
      }
    });
    Log.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + u.bBQ(this.videoPath) + " " + u.bBQ(this.thumbPath));
    if (u.agG(this.videoPath))
    {
      this.KKt.f(this.videoPath, false, 0);
      this.progressBar.setVisibility(8);
      Log.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.md5 });
    }
    for (;;)
    {
      Object localObject = this.bvK;
      AppMethodBeat.o(98290);
      return localObject;
      localObject = t.aZm(this.thumbPath);
      if (localObject != null)
      {
        this.KGo = ((n)localObject).baV();
        if (t.K(this.KGo)) {
          this.KKt.setThumbBmp(this.KGo);
        }
      }
      this.progressBar.setVisibility(0);
    }
  }
  
  public final boolean fTy()
  {
    return true;
  }
  
  public final boolean fTz()
  {
    return true;
  }
  
  final void fUV()
  {
    AppMethodBeat.i(98292);
    if (this.KGn)
    {
      AppMethodBeat.o(98292);
      return;
    }
    if (!this.KGE.I(this.videoPath, this.thumbPath, this.desc, this.md5))
    {
      Log.i("MicroMsg.SightWidget", "videopath " + u.bBQ(this.videoPath) + " thumb: " + u.bBQ(this.thumbPath));
      w.makeText(this.iXq, i.j.sendrequest_send_fail, 0).show();
      AppMethodBeat.o(98292);
      return;
    }
    Object localObject1 = new wa();
    ((wa)localObject1).fVd.type = 0;
    ((wa)localObject1).fVd.fVf = true;
    EventCenter.instance.publish((IEvent)localObject1);
    this.KGn = true;
    int i = this.KGE.in();
    if (this.KCV != null)
    {
      this.KCV.wQ(i);
      com.tencent.mm.plugin.sns.k.i.Kjb.c(this.KCV);
    }
    aj.fOS().KJv = 0L;
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("sns_resume_state", false);
    ((Intent)localObject2).putExtra("sns_timeline_NeedFirstLoadint", true);
    ((Intent)localObject2).setClass(this.iXq, SnsTimeLineUI.class);
    ((Intent)localObject2).addFlags(67108864);
    localObject1 = this.iXq;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.iXq.setResult(-1);
    this.iXq.finish();
    AppMethodBeat.o(98292);
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aw
 * JD-Core Version:    0.7.0.1
 */