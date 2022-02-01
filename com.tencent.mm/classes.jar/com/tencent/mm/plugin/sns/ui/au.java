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
import com.tencent.mm.g.a.uw;
import com.tencent.mm.g.a.uw.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.sight.decode.ui.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class au
  implements ad
{
  private int DPi;
  private int EpG;
  private k EpM;
  private String EpN;
  private boolean EsQ;
  private Bitmap EsR;
  bf Eth;
  com.tencent.mm.plugin.sight.decode.a.a EwB;
  c EwC;
  private boolean dGX;
  private String desc;
  ProgressDialog gtM;
  MMActivity gte;
  String md5;
  ProgressBar progressBar;
  private View sc;
  private IListener tOh;
  String thumbPath;
  String videoPath;
  
  public au(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(98288);
    this.sc = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.md5 = "";
    this.dGX = false;
    this.EsQ = false;
    this.EsR = null;
    this.EwC = null;
    this.EpM = null;
    this.DPi = 1;
    this.EpN = "";
    this.tOh = new IListener() {};
    this.Eth = null;
    this.desc = "";
    this.gtM = null;
    this.gte = paramMMActivity;
    AppMethodBeat.o(98288);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98291);
    if (this.Eth != null)
    {
      AppMethodBeat.o(98291);
      return false;
    }
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramLinkedList = com.tencent.mm.pluginsdk.i.a.gnq();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramLinkedList.contains(paramString2))
        {
          ebm localebm = new ebm();
          localebm.UserName = paramString2;
          parami.add(localebm);
        }
      }
    }
    this.Eth = new bf(15, this.gte);
    paramPInt.value = this.Eth.beK;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.DCT) {
      this.Eth.YF(3);
    }
    paramString1 = this.Eth.aPw(paramString1);
    new LinkedList();
    paramString1.a(paramcjy).bq(parami).YI(paramInt1).YJ(paramInt2).gR(paramList2);
    if (paramBoolean) {
      this.Eth.YL(1);
    }
    for (;;)
    {
      this.Eth.gR(paramList2).YI(paramInt1);
      this.Eth.YK(this.EpG);
      this.Eth.ct(this.DPi, this.EpN);
      this.Eth.g(null, null, null, paramInt4, paramInt5);
      if (!s.YS(this.videoPath)) {
        break;
      }
      fgO();
      AppMethodBeat.o(98291);
      return true;
      this.Eth.YL(0);
    }
    Log.i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
    parami = this.gte;
    this.gte.getString(2131755998);
    this.gtM = h.a(parami, this.gte.getString(2131766215), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        au.this.Eth = null;
      }
    });
    AppMethodBeat.o(98291);
    return true;
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(98289);
    this.EpM = k.w(this.gte.getIntent());
    this.thumbPath = this.gte.getIntent().getStringExtra("KSightThumbPath");
    this.videoPath = this.gte.getIntent().getStringExtra("KSightPath");
    this.md5 = this.gte.getIntent().getStringExtra("sight_md5");
    this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = new uw();
    paramBundle.ebg.type = 2;
    EventCenter.instance.publish(paramBundle);
    if (Util.isNullOrNil(this.videoPath))
    {
      this.videoPath = Util.nullAs(paramBundle.ebh.ebl, "");
      Log.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
    }
    if (Util.isNullOrNil(this.md5))
    {
      paramBundle = Util.nullAs(paramBundle.ebh.ebj, "");
      this.md5 = paramBundle;
      Log.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.md5 });
      EventCenter.instance.addListener(this.tOh);
      if (!this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
        break label287;
      }
    }
    label287:
    for (this.DPi = 1;; this.DPi = 0)
    {
      this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98289);
      return;
      paramBundle = this.md5;
      break;
    }
  }
  
  public final void aD(Bundle paramBundle) {}
  
  public final boolean ffA()
  {
    return true;
  }
  
  public final View ffB()
  {
    AppMethodBeat.i(98290);
    this.sc = View.inflate(this.gte, 2131496782, null);
    this.EwB = ((com.tencent.mm.plugin.sight.decode.a.a)this.sc.findViewById(2131302526));
    this.EwB.setDrawableWidth(com.tencent.mm.cb.a.fromDPToPix(this.gte, 90));
    this.progressBar = ((ProgressBar)this.sc.findViewById(2131303688));
    this.gte.getResources().getDisplayMetrics();
    this.sc.findViewById(2131298411).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98287);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        if (!s.YS(au.this.videoPath))
        {
          Log.i("MicroMsg.SightWidget", "click videopath is not exist " + au.this.videoPath);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98287);
          return;
        }
        if (au.this.EwC != null)
        {
          au.this.EwC.dismiss();
          au.this.EwC = null;
        }
        au.this.EwC = new c(au.this.gte);
        paramAnonymousView = au.this.EwC;
        localObject = au.this.videoPath;
        String str = au.this.thumbPath;
        paramAnonymousView.fullPath = ((String)localObject);
        paramAnonymousView.imagePath = str;
        paramAnonymousView = au.this.EwC;
        paramAnonymousView.eeF = 0;
        paramAnonymousView.Dne = 0;
        paramAnonymousView.tex = 1;
        au.this.EwC.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98287);
      }
    });
    Log.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + s.boW(this.videoPath) + " " + s.boW(this.thumbPath));
    if (s.YS(this.videoPath))
    {
      this.EwB.e(this.videoPath, false, 0);
      this.progressBar.setVisibility(8);
      Log.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.md5 });
    }
    for (;;)
    {
      Object localObject = this.sc;
      AppMethodBeat.o(98290);
      return localObject;
      localObject = r.aOq(this.thumbPath);
      if (localObject != null)
      {
        this.EsR = ((n)localObject).aSa();
        if (r.M(this.EsR)) {
          this.EwB.setThumbBmp(this.EsR);
        }
      }
      this.progressBar.setVisibility(0);
    }
  }
  
  public final boolean ffC()
  {
    return true;
  }
  
  public final boolean ffD()
  {
    return true;
  }
  
  public final boolean ffE()
  {
    AppMethodBeat.i(98293);
    if (this.gtM != null) {
      this.gtM.dismiss();
    }
    EventCenter.instance.removeListener(this.tOh);
    if (r.M(this.EsR)) {
      this.EsR.recycle();
    }
    AppMethodBeat.o(98293);
    return false;
  }
  
  final void fgO()
  {
    AppMethodBeat.i(98292);
    if (this.EsQ)
    {
      AppMethodBeat.o(98292);
      return;
    }
    if (!this.Eth.D(this.videoPath, this.thumbPath, this.desc, this.md5))
    {
      Log.i("MicroMsg.SightWidget", "videopath " + s.boW(this.videoPath) + " thumb: " + s.boW(this.thumbPath));
      u.makeText(this.gte, 2131765235, 0).show();
      AppMethodBeat.o(98292);
      return;
    }
    Object localObject1 = new uw();
    ((uw)localObject1).ebg.type = 0;
    ((uw)localObject1).ebg.ebi = true;
    EventCenter.instance.publish((IEvent)localObject1);
    this.EsQ = true;
    int i = this.Eth.commit();
    if (this.EpM != null)
    {
      this.EpM.tQ(i);
      g.DVR.c(this.EpM);
    }
    aj.faY().EvE = 0L;
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("sns_resume_state", false);
    ((Intent)localObject2).putExtra("sns_timeline_NeedFirstLoadint", true);
    ((Intent)localObject2).setClass(this.gte, SnsTimeLineUI.class);
    ((Intent)localObject2).addFlags(67108864);
    localObject1 = this.gte;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.gte.setResult(-1);
    this.gte.finish();
    AppMethodBeat.o(98292);
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au
 * JD-Core Version:    0.7.0.1
 */