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
import com.tencent.mm.g.a.tf;
import com.tencent.mm.g.a.tf.b;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ao
  implements ab
{
  private boolean ddj;
  private String desc;
  ProgressDialog fts;
  MMActivity iMV;
  String md5;
  ProgressBar progressBar;
  private View qe;
  private com.tencent.mm.sdk.b.c rhM;
  String thumbPath;
  String videoPath;
  private int xXU;
  private boolean yBC;
  private Bitmap yBD;
  bb yBS;
  com.tencent.mm.plugin.sight.decode.a.a yFm;
  com.tencent.mm.plugin.sight.decode.ui.c yFn;
  private int yyR;
  private d yyX;
  private String yyY;
  
  public ao(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(98288);
    this.qe = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.md5 = "";
    this.ddj = false;
    this.yBC = false;
    this.yBD = null;
    this.yFn = null;
    this.yyX = null;
    this.xXU = 1;
    this.yyY = "";
    this.rhM = new com.tencent.mm.sdk.b.c() {};
    this.yBS = null;
    this.desc = "";
    this.fts = null;
    this.iMV = paramMMActivity;
    AppMethodBeat.o(98288);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, brd parambrd, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98291);
    if (this.yBS != null)
    {
      AppMethodBeat.o(98291);
      return false;
    }
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramLinkedList = com.tencent.mm.pluginsdk.g.j.fdk();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramLinkedList.contains(paramString2))
        {
          dbw localdbw = new dbw();
          localdbw.ncR = paramString2;
          parami.add(localdbw);
        }
      }
    }
    this.yBS = new bb(15);
    paramPInt.value = this.yBS.aUt;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.xMh) {
      this.yBS.Ou(3);
    }
    paramString1 = this.yBS.aue(paramString1);
    new LinkedList();
    paramString1.a(parambrd).aT(parami).Ow(paramInt1).Ox(paramInt2).fy(paramList2);
    if (paramBoolean) {
      this.yBS.Oz(1);
    }
    for (;;)
    {
      this.yBS.fy(paramList2).Ow(paramInt1);
      this.yBS.Oy(this.yyR);
      this.yBS.bV(this.xXU, this.yyY);
      this.yBS.g(null, null, null, paramInt4, paramInt5);
      if (!com.tencent.mm.vfs.i.eA(this.videoPath)) {
        break;
      }
      dOD();
      AppMethodBeat.o(98291);
      return true;
      this.yBS.Oz(0);
    }
    ac.i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
    parami = this.iMV;
    this.iMV.getString(2131755906);
    this.fts = com.tencent.mm.ui.base.h.b(parami, this.iMV.getString(2131763977), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        ao.this.yBS = null;
      }
    });
    AppMethodBeat.o(98291);
    return true;
  }
  
  public final void ak(Bundle paramBundle)
  {
    AppMethodBeat.i(98289);
    this.yyX = d.w(this.iMV.getIntent());
    this.thumbPath = this.iMV.getIntent().getStringExtra("KSightThumbPath");
    this.videoPath = this.iMV.getIntent().getStringExtra("KSightPath");
    this.md5 = this.iMV.getIntent().getStringExtra("sight_md5");
    this.yyR = this.iMV.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = new tf();
    paramBundle.dwf.type = 2;
    com.tencent.mm.sdk.b.a.GpY.l(paramBundle);
    if (bs.isNullOrNil(this.videoPath))
    {
      this.videoPath = bs.bG(paramBundle.dwg.dwk, "");
      ac.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
    }
    if (bs.isNullOrNil(this.md5))
    {
      paramBundle = bs.bG(paramBundle.dwg.dwi, "");
      this.md5 = paramBundle;
      ac.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.md5 });
      com.tencent.mm.sdk.b.a.GpY.c(this.rhM);
      if (!this.iMV.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
        break label287;
      }
    }
    label287:
    for (this.xXU = 1;; this.xXU = 0)
    {
      this.yyY = bs.bG(this.iMV.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98289);
      return;
      paramBundle = this.md5;
      break;
    }
  }
  
  public final void al(Bundle paramBundle) {}
  
  public final boolean dNr()
  {
    return true;
  }
  
  public final View dNs()
  {
    AppMethodBeat.i(98290);
    this.qe = View.inflate(this.iMV, 2131495819, null);
    this.yFm = ((com.tencent.mm.plugin.sight.decode.a.a)this.qe.findViewById(2131300914));
    this.yFm.setDrawableWidth(com.tencent.mm.cc.a.fromDPToPix(this.iMV, 90));
    this.progressBar = ((ProgressBar)this.qe.findViewById(2131301489));
    this.iMV.getResources().getDisplayMetrics();
    this.qe.findViewById(2131298069).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98287);
        if (!com.tencent.mm.vfs.i.eA(ao.this.videoPath))
        {
          ac.i("MicroMsg.SightWidget", "click videopath is not exist " + ao.this.videoPath);
          AppMethodBeat.o(98287);
          return;
        }
        if (ao.this.yFn != null)
        {
          ao.this.yFn.dismiss();
          ao.this.yFn = null;
        }
        ao.this.yFn = new com.tencent.mm.plugin.sight.decode.ui.c(ao.this.iMV);
        paramAnonymousView = ao.this.yFn;
        String str1 = ao.this.videoPath;
        String str2 = ao.this.thumbPath;
        paramAnonymousView.gKe = str1;
        paramAnonymousView.imagePath = str2;
        paramAnonymousView = ao.this.yFn;
        paramAnonymousView.dzm = 0;
        paramAnonymousView.xDt = 0;
        paramAnonymousView.qME = 1;
        ao.this.yFn.show();
        AppMethodBeat.o(98287);
      }
    });
    ac.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + com.tencent.mm.vfs.i.aSp(this.videoPath) + " " + com.tencent.mm.vfs.i.aSp(this.thumbPath));
    if (com.tencent.mm.vfs.i.eA(this.videoPath))
    {
      this.yFm.e(this.videoPath, false, 0);
      this.progressBar.setVisibility(8);
      ac.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.md5 });
    }
    for (;;)
    {
      Object localObject = this.qe;
      AppMethodBeat.o(98290);
      return localObject;
      localObject = q.asX(this.thumbPath);
      if (localObject != null)
      {
        this.yBD = ((n)localObject).avS();
        if (q.I(this.yBD)) {
          this.yFm.setThumbBmp(this.yBD);
        }
      }
      this.progressBar.setVisibility(0);
    }
  }
  
  public final boolean dNt()
  {
    AppMethodBeat.i(98293);
    if (this.fts != null) {
      this.fts.dismiss();
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.rhM);
    if (q.I(this.yBD)) {
      this.yBD.recycle();
    }
    AppMethodBeat.o(98293);
    return false;
  }
  
  final void dOD()
  {
    AppMethodBeat.i(98292);
    if (this.yBC)
    {
      AppMethodBeat.o(98292);
      return;
    }
    if (!this.yBS.y(this.videoPath, this.thumbPath, this.desc, this.md5))
    {
      ac.i("MicroMsg.SightWidget", "videopath " + com.tencent.mm.vfs.i.aSp(this.videoPath) + " thumb: " + com.tencent.mm.vfs.i.aSp(this.thumbPath));
      t.makeText(this.iMV, 2131763075, 0).show();
      AppMethodBeat.o(98292);
      return;
    }
    Object localObject1 = new tf();
    ((tf)localObject1).dwf.type = 0;
    ((tf)localObject1).dwf.dwh = true;
    com.tencent.mm.sdk.b.a.GpY.l((b)localObject1);
    this.yBC = true;
    int i = this.yBS.commit();
    if (this.yyX != null)
    {
      this.yyX.pu(i);
      com.tencent.mm.plugin.sns.j.h.yes.c(this.yyX);
    }
    af.dHZ().yEp = 0L;
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("sns_resume_state", false);
    ((Intent)localObject2).putExtra("sns_timeline_NeedFirstLoadint", true);
    ((Intent)localObject2).setClass(this.iMV, SnsTimeLineUI.class);
    ((Intent)localObject2).addFlags(67108864);
    localObject1 = this.iMV;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.iMV.setResult(-1);
    this.iMV.finish();
    AppMethodBeat.o(98292);
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ao
 * JD-Core Version:    0.7.0.1
 */