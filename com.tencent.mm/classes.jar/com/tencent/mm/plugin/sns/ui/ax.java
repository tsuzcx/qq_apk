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
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.xr;
import com.tencent.mm.autogen.a.xr.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.memory.m;
import com.tencent.mm.plugin.sight.decode.ui.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.statistics.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ax
  implements ag
{
  private int QzF;
  private com.tencent.mm.modelsns.l RcD;
  private String RcE;
  private int Rcy;
  private boolean RfN;
  private Bitmap RfO;
  bg Rgf;
  com.tencent.mm.plugin.sight.decode.model.a RjV;
  c RjW;
  private String desc;
  private View doN;
  private boolean hEn;
  ProgressDialog lzP;
  MMActivity lzt;
  String md5;
  ProgressBar progressBar;
  private IListener qmO;
  String thumbPath;
  String videoPath;
  
  public ax(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(98288);
    this.doN = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.md5 = "";
    this.hEn = false;
    this.RfN = false;
    this.RfO = null;
    this.RjW = null;
    this.RcD = null;
    this.QzF = 1;
    this.RcE = "";
    this.qmO = new SightWidget.1(this, f.hfK);
    this.Rgf = null;
    this.desc = "";
    this.lzP = null;
    this.lzt = paramMMActivity;
    AppMethodBeat.o(98288);
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, djv paramdjv, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98291);
    if (this.Rgf != null)
    {
      AppMethodBeat.o(98291);
      return false;
    }
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramLinkedList = com.tencent.mm.pluginsdk.platformtools.a.iIX();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if ((paramLinkedList != null) && (!paramLinkedList.contains(paramString2)))
        {
          ffw localffw = new ffw();
          localffw.UserName = paramString2;
          parami.add(localffw);
        }
      }
    }
    this.Rgf = new bg(15, this.lzt);
    paramPInt.value = this.Rgf.cIh;
    if (paramInt3 > com.tencent.mm.plugin.sns.d.a.Qkq) {
      this.Rgf.akL(3);
    }
    paramString1 = this.Rgf.aYM(paramString1);
    new LinkedList();
    paramString1.a(paramdjv).bU(parami).akO(paramInt1).akP(paramInt2).kB(paramList2);
    if (paramBoolean) {
      this.Rgf.akR(1);
    }
    for (;;)
    {
      this.Rgf.kB(paramList2).akO(paramInt1);
      this.Rgf.akQ(this.Rcy);
      this.Rgf.df(this.QzF, this.RcE);
      this.Rgf.i(null, null, null, paramInt4, paramInt5);
      if (!y.ZC(this.videoPath)) {
        break;
      }
      hnl();
      AppMethodBeat.o(98291);
      return true;
      this.Rgf.akR(0);
    }
    Log.i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
    parami = this.lzt;
    this.lzt.getString(b.j.app_tip);
    this.lzP = k.a(parami, this.lzt.getString(b.j.sns_sight_send_wait), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        ax.this.Rgf = null;
      }
    });
    AppMethodBeat.o(98291);
    return true;
  }
  
  public final void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(98289);
    this.RcD = com.tencent.mm.modelsns.l.y(this.lzt.getIntent());
    this.thumbPath = this.lzt.getIntent().getStringExtra("KSightThumbPath");
    this.videoPath = this.lzt.getIntent().getStringExtra("KSightPath");
    this.md5 = this.lzt.getIntent().getStringExtra("sight_md5");
    this.Rcy = this.lzt.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = new xr();
    paramBundle.iba.type = 2;
    paramBundle.publish();
    if (Util.isNullOrNil(this.videoPath))
    {
      this.videoPath = Util.nullAs(paramBundle.ibb.ibf, "");
      Log.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
    }
    if (Util.isNullOrNil(this.md5))
    {
      paramBundle = Util.nullAs(paramBundle.ibb.ibd, "");
      this.md5 = paramBundle;
      Log.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.md5 });
      this.qmO.alive();
      if (!this.lzt.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
        break label282;
      }
    }
    label282:
    for (this.QzF = 1;; this.QzF = 0)
    {
      this.RcE = Util.nullAs(this.lzt.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98289);
      return;
      paramBundle = this.md5;
      break;
    }
  }
  
  public final void ba(Bundle paramBundle) {}
  
  public final boolean hlP()
  {
    return true;
  }
  
  public final View hlQ()
  {
    AppMethodBeat.i(98290);
    this.doN = View.inflate(this.lzt, b.g.upload_sight_widget, null);
    this.RjV = ((com.tencent.mm.plugin.sight.decode.model.a)this.doN.findViewById(b.f.image));
    this.RjV.setDrawableWidth(com.tencent.mm.cd.a.fromDPToPix(this.lzt, 90));
    this.progressBar = ((ProgressBar)this.doN.findViewById(b.f.load_progress));
    this.lzt.getResources().getDisplayMetrics();
    this.doN.findViewById(b.f.chatting_click_area).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98287);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        if (!y.ZC(ax.this.videoPath))
        {
          Log.i("MicroMsg.SightWidget", "click videopath is not exist " + ax.this.videoPath);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98287);
          return;
        }
        if (ax.this.RjW != null)
        {
          ax.this.RjW.dismiss();
          ax.this.RjW = null;
        }
        ax.this.RjW = new c(ax.this.lzt);
        paramAnonymousView = ax.this.RjW;
        localObject = ax.this.videoPath;
        String str = ax.this.thumbPath;
        paramAnonymousView.fullPath = ((String)localObject);
        paramAnonymousView.imagePath = str;
        paramAnonymousView = ax.this.RjW;
        paramAnonymousView.ieW = 0;
        paramAnonymousView.PGl = 0;
        paramAnonymousView.Ahg = 1;
        ax.this.RjW.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98287);
      }
    });
    Log.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + y.bEl(this.videoPath) + " " + y.bEl(this.thumbPath));
    if (y.ZC(this.videoPath))
    {
      this.RjV.e(this.videoPath, false, 0);
      this.progressBar.setVisibility(8);
      Log.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.md5 });
    }
    for (;;)
    {
      Object localObject = this.doN;
      AppMethodBeat.o(98290);
      return localObject;
      localObject = t.aXx(this.thumbPath);
      if (localObject != null)
      {
        this.RfO = ((m)localObject).bvQ();
        if (t.S(this.RfO)) {
          this.RjV.setThumbBmp(this.RfO);
        }
      }
      this.progressBar.setVisibility(0);
    }
  }
  
  public final boolean hlR()
  {
    return true;
  }
  
  public final boolean hlS()
  {
    return true;
  }
  
  public final boolean hlT()
  {
    AppMethodBeat.i(98293);
    if (this.lzP != null) {
      this.lzP.dismiss();
    }
    this.qmO.dead();
    if (t.S(this.RfO)) {
      this.RfO.recycle();
    }
    AppMethodBeat.o(98293);
    return false;
  }
  
  final void hnl()
  {
    AppMethodBeat.i(98292);
    if (this.RfN)
    {
      AppMethodBeat.o(98292);
      return;
    }
    if (!this.Rgf.K(this.videoPath, this.thumbPath, this.desc, this.md5))
    {
      Log.i("MicroMsg.SightWidget", "videopath " + y.bEl(this.videoPath) + " thumb: " + y.bEl(this.thumbPath));
      aa.makeText(this.lzt, b.j.sendrequest_send_fail, 0).show();
      AppMethodBeat.o(98292);
      return;
    }
    Object localObject1 = new xr();
    ((xr)localObject1).iba.type = 0;
    ((xr)localObject1).iba.ibc = true;
    ((xr)localObject1).publish();
    this.RfN = true;
    int i = this.Rgf.FW();
    if (this.RcD != null)
    {
      this.RcD.wQ(i);
      com.tencent.mm.plugin.sns.statistics.l.QGY.c(this.RcD);
    }
    al.hgM().RiX = 0L;
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("sns_resume_state", false);
    ((Intent)localObject2).putExtra("sns_timeline_NeedFirstLoadint", true);
    ((Intent)localObject2).setClass(this.lzt, SnsTimeLineUI.class);
    ((Intent)localObject2).addFlags(67108864);
    localObject1 = this.lzt;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.lzt.setResult(-1);
    this.lzt.finish();
    AppMethodBeat.o(98292);
  }
  
  public final boolean n(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ax
 * JD-Core Version:    0.7.0.1
 */