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
import com.tencent.mm.g.a.ty;
import com.tencent.mm.g.a.ty.b;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.g;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ar
  implements ac
{
  private int Ahk;
  private e Ahq;
  private String Ahr;
  private boolean Akd;
  private Bitmap Ake;
  bd Akt;
  com.tencent.mm.plugin.sight.decode.a.a AnQ;
  com.tencent.mm.plugin.sight.decode.ui.c AnR;
  private String desc;
  private boolean dpK;
  MMActivity fNT;
  ProgressDialog fOC;
  String md5;
  ProgressBar progressBar;
  private View rY;
  private com.tencent.mm.sdk.b.c seA;
  String thumbPath;
  String videoPath;
  private int zFi;
  
  public ar(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(98288);
    this.rY = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.md5 = "";
    this.dpK = false;
    this.Akd = false;
    this.Ake = null;
    this.AnR = null;
    this.Ahq = null;
    this.zFi = 1;
    this.Ahr = "";
    this.seA = new com.tencent.mm.sdk.b.c() {};
    this.Akt = null;
    this.desc = "";
    this.fOC = null;
    this.fNT = paramMMActivity;
    AppMethodBeat.o(98288);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bwk parambwk, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98291);
    if (this.Akt != null)
    {
      AppMethodBeat.o(98291);
      return false;
    }
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramLinkedList = d.feg();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramLinkedList.contains(paramString2))
        {
          did localdid = new did();
          localdid.nIJ = paramString2;
          parami.add(localdid);
        }
      }
    }
    this.Akt = new bd(15);
    paramPInt.value = this.Akt.beN;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.zsC) {
      this.Akt.QI(3);
    }
    paramString1 = this.Akt.aAA(paramString1);
    new LinkedList();
    paramString1.a(parambwk).aV(parami).QL(paramInt1).QM(paramInt2).fU(paramList2);
    if (paramBoolean) {
      this.Akt.QO(1);
    }
    for (;;)
    {
      this.Akt.fU(paramList2).QL(paramInt1);
      this.Akt.QN(this.Ahk);
      this.Akt.cc(this.zFi, this.Ahr);
      this.Akt.g(null, null, null, paramInt4, paramInt5);
      if (!o.fB(this.videoPath)) {
        break;
      }
      eex();
      AppMethodBeat.o(98291);
      return true;
      this.Akt.QO(0);
    }
    ae.i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
    parami = this.fNT;
    this.fNT.getString(2131755906);
    this.fOC = h.b(parami, this.fNT.getString(2131763977), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        ar.this.Akt = null;
      }
    });
    AppMethodBeat.o(98291);
    return true;
  }
  
  public final void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(98289);
    this.Ahq = e.w(this.fNT.getIntent());
    this.thumbPath = this.fNT.getIntent().getStringExtra("KSightThumbPath");
    this.videoPath = this.fNT.getIntent().getStringExtra("KSightPath");
    this.md5 = this.fNT.getIntent().getStringExtra("sight_md5");
    this.Ahk = this.fNT.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = new ty();
    paramBundle.dJt.type = 2;
    com.tencent.mm.sdk.b.a.IvT.l(paramBundle);
    if (bu.isNullOrNil(this.videoPath))
    {
      this.videoPath = bu.bI(paramBundle.dJu.dJy, "");
      ae.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
    }
    if (bu.isNullOrNil(this.md5))
    {
      paramBundle = bu.bI(paramBundle.dJu.dJw, "");
      this.md5 = paramBundle;
      ae.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.md5 });
      com.tencent.mm.sdk.b.a.IvT.c(this.seA);
      if (!this.fNT.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
        break label287;
      }
    }
    label287:
    for (this.zFi = 1;; this.zFi = 0)
    {
      this.Ahr = bu.bI(this.fNT.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98289);
      return;
      paramBundle = this.md5;
      break;
    }
  }
  
  public final void ar(Bundle paramBundle) {}
  
  public final boolean edl()
  {
    return true;
  }
  
  public final View edm()
  {
    AppMethodBeat.i(98290);
    this.rY = View.inflate(this.fNT, 2131495819, null);
    this.AnQ = ((com.tencent.mm.plugin.sight.decode.a.a)this.rY.findViewById(2131300914));
    this.AnQ.setDrawableWidth(com.tencent.mm.cb.a.fromDPToPix(this.fNT, 90));
    this.progressBar = ((ProgressBar)this.rY.findViewById(2131301489));
    this.fNT.getResources().getDisplayMetrics();
    this.rY.findViewById(2131298069).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98287);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (!o.fB(ar.this.videoPath))
        {
          ae.i("MicroMsg.SightWidget", "click videopath is not exist " + ar.this.videoPath);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98287);
          return;
        }
        if (ar.this.AnR != null)
        {
          ar.this.AnR.dismiss();
          ar.this.AnR = null;
        }
        ar.this.AnR = new com.tencent.mm.plugin.sight.decode.ui.c(ar.this.fNT);
        paramAnonymousView = ar.this.AnR;
        localObject = ar.this.videoPath;
        String str = ar.this.thumbPath;
        paramAnonymousView.hgD = ((String)localObject);
        paramAnonymousView.imagePath = str;
        paramAnonymousView = ar.this.AnR;
        paramAnonymousView.dMN = 0;
        paramAnonymousView.zin = 0;
        paramAnonymousView.rES = 1;
        ar.this.AnR.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98287);
      }
    });
    ae.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + o.aZR(this.videoPath) + " " + o.aZR(this.thumbPath));
    if (o.fB(this.videoPath))
    {
      this.AnQ.e(this.videoPath, false, 0);
      this.progressBar.setVisibility(8);
      ae.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.md5 });
    }
    for (;;)
    {
      Object localObject = this.rY;
      AppMethodBeat.o(98290);
      return localObject;
      localObject = r.azt(this.thumbPath);
      if (localObject != null)
      {
        this.Ake = ((n)localObject).ayU();
        if (r.J(this.Ake)) {
          this.AnQ.setThumbBmp(this.Ake);
        }
      }
      this.progressBar.setVisibility(0);
    }
  }
  
  public final boolean edn()
  {
    return true;
  }
  
  public final boolean edo()
  {
    AppMethodBeat.i(98293);
    if (this.fOC != null) {
      this.fOC.dismiss();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.seA);
    if (r.J(this.Ake)) {
      this.Ake.recycle();
    }
    AppMethodBeat.o(98293);
    return false;
  }
  
  final void eex()
  {
    AppMethodBeat.i(98292);
    if (this.Akd)
    {
      AppMethodBeat.o(98292);
      return;
    }
    if (!this.Akt.z(this.videoPath, this.thumbPath, this.desc, this.md5))
    {
      ae.i("MicroMsg.SightWidget", "videopath " + o.aZR(this.videoPath) + " thumb: " + o.aZR(this.thumbPath));
      t.makeText(this.fNT, 2131763075, 0).show();
      AppMethodBeat.o(98292);
      return;
    }
    Object localObject1 = new ty();
    ((ty)localObject1).dJt.type = 0;
    ((ty)localObject1).dJt.dJv = true;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    this.Akd = true;
    int i = this.Akt.commit();
    if (this.Ahq != null)
    {
      this.Ahq.qa(i);
      g.zLJ.c(this.Ahq);
    }
    ah.dXM().AmS = 0L;
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("sns_resume_state", false);
    ((Intent)localObject2).putExtra("sns_timeline_NeedFirstLoadint", true);
    ((Intent)localObject2).setClass(this.fNT, SnsTimeLineUI.class);
    ((Intent)localObject2).addFlags(67108864);
    localObject1 = this.fNT;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.fNT.setResult(-1);
    this.fNT.finish();
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