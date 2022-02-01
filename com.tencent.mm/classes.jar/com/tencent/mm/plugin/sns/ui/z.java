package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.a.tm;
import com.tencent.mm.autogen.mmdata.rpt.ap;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.d.c.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.ah;

public final class z
  implements com.tencent.mm.am.h
{
  IListener Ahp;
  ArrayList<ImageQBarDataBean> GYe;
  private SnsInfo PJQ;
  private dmz QcU;
  SnsCmdList RdQ;
  private final a RdR;
  private boolean RdS;
  private int RdT;
  boolean RdU;
  boolean RdV;
  private boolean RdW;
  private final String RdX;
  com.tencent.mm.plugin.sns.ui.d.c Rde;
  private String Rdf;
  private String Rdi;
  private String Rdj;
  private String Rdk;
  private String Rdl;
  private long Rdm;
  ImageQBarDataBean Rdo;
  FlipView.b Rdq;
  IListener Rdt;
  private String cY;
  final Context context;
  private int fromScene;
  private ScanCodeSheetItemLogic rAP;
  public com.tencent.mm.ui.base.w tipDialog;
  public int vhG;
  
  public z(Context paramContext, a parama, int paramInt)
  {
    AppMethodBeat.i(308055);
    this.RdQ = new SnsCmdList();
    this.tipDialog = null;
    this.vhG = 0;
    this.Rde = null;
    this.RdT = 0;
    this.RdU = false;
    this.RdV = false;
    this.RdW = false;
    this.GYe = new ArrayList();
    this.Rdo = null;
    this.Ahp = new GalleryTitleManager.10(this, com.tencent.mm.app.f.hfK);
    this.Rdt = new GalleryTitleManager.11(this, com.tencent.mm.app.f.hfK);
    this.context = paramContext;
    this.fromScene = paramInt;
    this.RdR = parama;
    this.RdX = ((Activity)paramContext).getIntent().getStringExtra("sns_gallery_pre_title");
    this.rAP = new ScanCodeSheetItemLogic(paramContext, new ScanCodeSheetItemLogic.a()
    {
      public final void onFetchedCodeInfo()
      {
        AppMethodBeat.i(97895);
        if ((z.a(z.this) != null) && (z.a(z.this).cDi().isShowing()))
        {
          z.b(z.this);
          z.this.a(z.c(z.this), z.d(z.this), z.e(z.this));
        }
        AppMethodBeat.o(97895);
      }
    });
    AppMethodBeat.o(308055);
  }
  
  private void a(final SnsInfo paramSnsInfo, dmz paramdmz, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(308062);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.Rde != null)
    {
      if (this.RdW) {
        this.RdW = false;
      }
      this.Rde.b(this.PJQ, paramdmz);
      localObject1 = this.Rde;
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(Integer.valueOf(1003));
      if (com.tencent.mm.br.c.blq("favorite")) {
        ((ArrayList)localObject2).add(Integer.valueOf(1006));
      }
      if ((((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) && (paramSnsInfo.field_type == 1) && (t.akt(this.fromScene)) && (!aj.aBu()))
      {
        ((ArrayList)localObject2).add(Integer.valueOf(1010));
        if (!this.RdW)
        {
          localObject3 = new ap();
          ap localap = ((ap)localObject3).kC("").kD(t.uA(this.PJQ.field_snsId));
          localap.ioZ = t.aku(this.fromScene);
          localap.ilm = 1;
          localap.imW = 81;
          ((ap)localObject3).kE("");
          ((ap)localObject3).kF("");
          ((ap)localObject3).kG(g.getMD5(com.tencent.mm.plugin.sns.model.as.mg(al.getAccSnsPath(), paramdmz.Id) + t.k(paramdmz)));
          ((ap)localObject3).ipe = System.currentTimeMillis();
          ((ap)localObject3).bMH();
          com.tencent.mm.plugin.websearch.api.as.a((com.tencent.mm.plugin.report.a)localObject3);
        }
      }
      paramdmz = com.tencent.mm.plugin.sns.ui.d.c.RUl;
      paramdmz = c.a.la((List)localObject2);
      localObject2 = new ArrayList();
      if ((paramSnsInfo.field_type != 15) && (paramSnsInfo.field_type != 5)) {
        break label499;
      }
      ((ArrayList)localObject2).add(Integer.valueOf(1013));
      a((ArrayList)localObject2, paramSnsInfo);
    }
    for (;;)
    {
      localObject3 = new ex();
      ((ex)localObject3).hFc.hES = paramSnsInfo.getLocalid();
      ((ex)localObject3).publish();
      if (((ex)localObject3).hFd.hEn) {
        ((ArrayList)localObject2).add(Integer.valueOf(1008));
      }
      localObject3 = com.tencent.mm.plugin.sns.ui.d.c.RUl;
      ((com.tencent.mm.plugin.sns.ui.d.c)localObject1).a(paramdmz, c.a.la((List)localObject2), null);
      this.Rde.d(new u.i()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(308310);
          z.a(z.this, paramSnsInfo);
          AppMethodBeat.o(308310);
        }
      });
      com.tencent.mm.plugin.sns.ui.d.a.a(this.Rde, null, this.GYe);
      AppMethodBeat.o(308062);
      return;
      localObject1 = (Activity)this.context;
      if (this.RdS) {}
      for (int i = 5;; i = 6)
      {
        this.Rde = new com.tencent.mm.plugin.sns.ui.d.c((Activity)localObject1, i);
        localObject1 = this.Rde;
        localObject2 = this.rAP;
        kotlin.g.b.s.u(localObject2, "value");
        ((com.tencent.mm.plugin.sns.ui.d.c)localObject1).RUn = ((ScanCodeSheetItemLogic)localObject2);
        break;
      }
      label499:
      if (paramSnsInfo.field_type == 1)
      {
        ((ArrayList)localObject2).add(Integer.valueOf(1002));
        if (!com.tencent.mm.plugin.sns.storage.ai.bao(paramSnsInfo.getLocalid())) {
          ((ArrayList)localObject2).add(Integer.valueOf(1012));
        }
        a((ArrayList)localObject2, paramSnsInfo);
        if (paramBoolean1) {
          ((ArrayList)localObject2).add(Integer.valueOf(1009));
        }
        if (paramBoolean2) {
          ((ArrayList)localObject2).add(Integer.valueOf(1011));
        }
      }
      else
      {
        ((ArrayList)localObject2).add(Integer.valueOf(1014));
        a((ArrayList)localObject2, paramSnsInfo);
      }
    }
  }
  
  private void a(ArrayList<Integer> paramArrayList, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(308056);
    if (this.RdS)
    {
      if (paramSnsInfo.getLocalPrivate() <= 0) {
        break label69;
      }
      if ((!Util.isNullOrNil(al.hgg())) && (al.hgg().equals(paramSnsInfo.getUserName()))) {
        paramArrayList.add(Integer.valueOf(1005));
      }
    }
    for (;;)
    {
      paramArrayList.add(Integer.valueOf(-1));
      AppMethodBeat.o(308056);
      return;
      label69:
      paramArrayList.add(Integer.valueOf(1000));
    }
  }
  
  private void a(List<Integer> paramList, final SnsInfo paramSnsInfo, final dmz paramdmz, final int paramInt)
  {
    AppMethodBeat.i(308066);
    paramSnsInfo = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(97902);
        if (z.f(z.this) != null) {
          z.f(z.this).hlY();
        }
        z.a(z.this, paramAnonymousMenuItem.getItemId(), paramSnsInfo, paramdmz);
        AppMethodBeat.o(97902);
      }
    };
    this.Rde.e(paramSnsInfo);
    this.Rde.bM(new kotlin.g.a.a() {});
    this.Rde.dDn();
    if (this.Rdq != null) {
      this.Rdq.kJ(paramList);
    }
    AppMethodBeat.o(308066);
  }
  
  protected final void X(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97916);
    if ((paramSnsInfo.isWaitPost()) || (paramSnsInfo.isDieItem()))
    {
      al.hgB().alC(paramSnsInfo.localid);
      this.RdQ.akp(paramSnsInfo.localid);
      AppMethodBeat.o(97916);
      return;
    }
    al.hgA().uQ(paramSnsInfo.field_snsId);
    paramSnsInfo = new com.tencent.mm.plugin.sns.model.s(paramSnsInfo.field_snsId, 1);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramSnsInfo, 0);
    Context localContext = this.context;
    this.context.getString(b.j.app_tip);
    this.tipDialog = k.a(localContext, this.context.getString(b.j.sns_deling_sns), true, new z.7(this, paramSnsInfo));
    AppMethodBeat.o(97916);
  }
  
  public final void a(boolean paramBoolean, SnsInfo paramSnsInfo, dmz paramdmz)
  {
    AppMethodBeat.i(97912);
    a(paramBoolean, paramSnsInfo, paramdmz, this.RdU, this.RdV, false, 0);
    AppMethodBeat.o(97912);
  }
  
  public final void a(boolean paramBoolean1, SnsInfo paramSnsInfo, dmz paramdmz, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    AppMethodBeat.i(308141);
    this.RdS = paramBoolean1;
    this.PJQ = paramSnsInfo;
    this.QcU = paramdmz;
    this.cY = paramdmz.Id;
    this.RdU = paramBoolean2;
    this.RdV = paramBoolean3;
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(308141);
      return;
    }
    paramSnsInfo.getTimeLine();
    ArrayList localArrayList = new ArrayList();
    a(paramSnsInfo, paramdmz, paramBoolean2, paramBoolean3);
    a(localArrayList, paramSnsInfo, paramdmz, paramInt);
    if (paramBoolean4)
    {
      com.tencent.mm.kernel.h.baF();
      if (com.tencent.mm.kernel.h.baD().mCm.bFQ() != 0)
      {
        paramSnsInfo = new tm();
        paramdmz = com.tencent.mm.plugin.sns.model.as.mg(al.getAccSnsPath(), this.cY) + t.k(paramdmz);
        paramSnsInfo.hXd.filePath = paramdmz;
        this.Rdm = System.currentTimeMillis();
        paramSnsInfo.hXd.hBk = this.Rdm;
        this.Rdf = paramdmz;
        paramSnsInfo.publish();
      }
    }
    AppMethodBeat.o(308141);
  }
  
  public final void alE(int paramInt)
  {
    AppMethodBeat.i(97909);
    if (paramInt == 0)
    {
      AppMethodBeat.o(97909);
      return;
    }
    this.RdQ.akp(paramInt);
    AppMethodBeat.o(97909);
  }
  
  public final void hlZ()
  {
    AppMethodBeat.i(97911);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_cmd_list", this.RdQ);
    ((Activity)this.context).setResult(-1, localIntent);
    ((Activity)this.context).finish();
    AppMethodBeat.o(97911);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(97918);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramp == null))
    {
      AppMethodBeat.o(97918);
      return;
    }
    Log.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramp.getType() + " @" + hashCode());
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    paramString = (com.tencent.mm.plugin.sns.model.s)paramp;
    switch (paramString.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(97918);
      return;
      this.RdQ.akp(paramString.icg);
      this.RdR.hf(com.tencent.mm.plugin.sns.storage.ai.bF("sns_table_", paramString.icg), paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.RdQ.akq(paramString.icg);
      this.RdR.hf("", paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.RdR.hf("", paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.RdQ.akq(paramString.icg);
      this.RdR.hf(com.tencent.mm.plugin.sns.storage.ai.bF("sns_table_", paramString.icg), paramString.type);
    }
  }
  
  public static abstract interface a
  {
    public abstract void hf(String paramString, int paramInt);
    
    public abstract void hg(String paramString, int paramInt);
    
    public abstract void hma();
    
    public abstract void mV(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.z
 * JD-Core Version:    0.7.0.1
 */