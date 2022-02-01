package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.i;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f
  implements com.tencent.mm.ak.f
{
  static int mScene = 0;
  Activity keK;
  boolean xdl;
  private boolean xdm;
  com.tencent.mm.plugin.product.b.c xdn;
  private a xdo;
  private com.tencent.mm.sdk.b.c xdp;
  
  public f(Activity paramActivity, a parama)
  {
    AppMethodBeat.i(66965);
    this.xdl = false;
    this.xdm = false;
    this.xdp = new com.tencent.mm.sdk.b.c() {};
    this.keK = paramActivity;
    com.tencent.mm.plugin.product.a.a.dCJ();
    this.xdn = com.tencent.mm.plugin.product.a.a.dCK();
    this.xdo = parama;
    AppMethodBeat.o(66965);
  }
  
  private void dDk()
  {
    AppMethodBeat.i(66969);
    Object localObject1 = com.tencent.mm.plugin.product.a.a.dCJ().dCL();
    Object localObject2 = this.xdn.dCR();
    if ((localObject2 != null) && (!bu.isNullOrNil(((csg)localObject2).urL)) && (!((csg)localObject2).urL.contains(";")))
    {
      ((d)localObject1).xbN.remove(((csg)localObject2).urL);
      ((d)localObject1).xbN.add(((csg)localObject2).urL);
      ((d)localObject1).dDe();
    }
    localObject2 = new Intent(this.keK, MallProductUI.class);
    ((Intent)localObject2).putExtra("key_go_finish", true);
    ((Intent)localObject2).addFlags(67108864);
    localObject1 = this.keK;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(66969);
  }
  
  public final void dDj()
  {
    AppMethodBeat.i(66968);
    m localm = this.xdn.xbv;
    cw localcw = new cw();
    akn localakn = new akn();
    akt localakt = new akt();
    akm localakm = new akm();
    localakt.aQC(v.aAC());
    localakt.aQD(v.aAC());
    localakt.aax(11);
    localakt.Dk(bu.fpO());
    localakm.aQv(localm.xbZ.name);
    localakm.aQw(this.xdn.dDd());
    localakm.aau(localm.xbW);
    localakm.aQy(this.xdn.a(localm));
    localakm.aQx(localm.dDf());
    localcw.doL.title = localm.xbZ.name;
    localcw.doL.desc = this.xdn.dDd();
    localcw.doL.doN = localakn;
    localcw.doL.type = 11;
    localakn.a(localakt);
    localakn.b(localakm);
    localcw.doL.activity = this.keK;
    localcw.doL.doR = 5;
    com.tencent.mm.sdk.b.a.IvT.l(localcw);
    AppMethodBeat.o(66968);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66971);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(66971);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        this.xdn.aG(paramIntent);
        if (this.xdo != null) {
          this.xdo.E(0, 0, "");
        }
        com.tencent.mm.kernel.g.ajS();
        Object localObject = com.tencent.mm.kernel.g.ajQ().gDv;
        paramIntent = this.xdn;
        if (paramIntent.xbv != null) {}
        for (paramIntent = paramIntent.xbv.xbV;; paramIntent = "")
        {
          ((q)localObject).a(new com.tencent.mm.plugin.product.b.g(paramIntent, this.xdn.xbx, this.xdn.xbB), 0);
          AppMethodBeat.o(66971);
          return;
        }
        localObject = new yv();
        ((yv)localObject).dON.result = paramInt1;
        ((yv)localObject).dON.intent = paramIntent;
        this.xdp.callback((com.tencent.mm.sdk.b.b)localObject);
        AppMethodBeat.o(66971);
        return;
        if (this.xdo != null)
        {
          this.xdo.E(0, 0, "");
          AppMethodBeat.o(66971);
          return;
          this.keK.showDialog(-10002);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.a(new i(this.xdn.xbx, this.xdn.xbE), 0);
          AppMethodBeat.o(66971);
          return;
          if ((paramInt2 == -1) && (paramIntent != null))
          {
            this.xdn.aG(paramIntent);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(new j(this.xdn.dCZ(), mScene), 0);
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66970);
    ae.d("MicroMsg.MallProductUI", "errCode: " + paramInt2 + ", errMsg: " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.product.b.h))
      {
        paramn = (com.tencent.mm.plugin.product.b.h)paramn;
        this.xdn.a(paramn.xbR, paramn.xbS);
        if (this.xdo != null) {
          this.xdo.E(paramInt1, paramInt2, paramString);
        }
        if (!bu.isNullOrNil(paramn.xbR.xbV))
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(11007, new Object[] { this.xdn.dCS(), paramn.xbR.xbV, Integer.valueOf(mScene), Integer.valueOf(1) });
          AppMethodBeat.o(66970);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(11007, new Object[] { this.xdn.dCS(), paramn.xbQ, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(66970);
        return;
      }
      Object localObject2;
      Object localObject1;
      if ((paramn instanceof j))
      {
        localObject2 = (j)paramn;
        paramString = this.xdn;
        paramn = ((j)localObject2).xbx;
        localObject1 = ((j)localObject2).xbI;
        localObject2 = ((j)localObject2).xbJ;
        paramString.xbx = paramn;
        paramString.xbJ = ((LinkedList)localObject2);
        paramString.xbI = ((LinkedList)localObject1);
        paramString.Ng(0);
        paramString = this.keK;
        paramn = new Intent(this.keK, MallProductSubmitUI.class);
        paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahE(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramn.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.g.yxI.f(11009, new Object[] { this.xdn.dCS(), this.xdn.xbv.xbV, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.product.b.f)) {
        break label864;
      }
      if ((paramn instanceof l))
      {
        paramString = ((l)paramn).xbU;
        paramInt1 = 6;
        if (mScene == 7) {
          paramInt1 = 1001;
        }
        ae.d("MicroMsg.MallProductUI", "payScene:".concat(String.valueOf(paramInt1)));
        com.tencent.mm.pluginsdk.wallet.f.a(this.keK, paramString, this.xdn.getAppId(), paramInt1, 3);
        com.tencent.mm.sdk.b.a.IvT.c(this.xdp);
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramn instanceof k))
      {
        com.tencent.mm.ui.base.h.cm(this.keK, this.keK.getString(2131761137));
        dDk();
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.product.b.g)) {
        try
        {
          this.keK.dismissDialog(-10002);
          paramString = this.xdn;
          paramString.xbI = ((com.tencent.mm.plugin.product.b.g)paramn).xbI;
          paramString.Ng(0);
          AppMethodBeat.o(66970);
          return;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ae.e("MicroMsg.MallProductUI", paramString.toString());
          }
        }
      }
      if (!(paramn instanceof i)) {
        break label864;
      }
      try
      {
        this.keK.dismissDialog(-10002);
        localObject2 = (i)paramn;
        paramn = this.xdn;
        localObject1 = ((i)localObject2).mUrl;
        localObject2 = ((i)localObject2).xbT;
        if ((!bu.isNullOrNil((String)localObject1)) && (localObject2 != null) && (((LinkedList)localObject2).size() > 0))
        {
          if (paramn.xbM == null) {
            paramn.xbM = new HashMap();
          }
          paramn.xbM.put(localObject1, localObject2);
        }
        if (this.xdo != null) {
          this.xdo.E(paramInt1, paramInt2, paramString);
        }
        AppMethodBeat.o(66970);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.MallProductUI", localException.toString());
        }
      }
    }
    switch (paramInt2)
    {
    default: 
      ae.i("MicroMsg.MallProductUI", "unkown errCode ".concat(String.valueOf(paramInt2)));
      paramn = paramString;
      if (bu.isNullOrNil(paramString)) {
        paramn = paramInt2 + " : " + this.keK.getString(2131761118);
      }
      if (this.xdo != null) {
        this.xdo.E(paramInt1, paramInt2, paramn);
      }
      break;
    }
    label864:
    do
    {
      AppMethodBeat.o(66970);
      return;
      ae.i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
    } while (!(paramn instanceof com.tencent.mm.plugin.product.b.h));
    paramn = (com.tencent.mm.plugin.product.b.h)paramn;
    this.xdn.a(paramn.xbR, paramn.xbS);
    if (this.xdo != null) {
      this.xdo.E(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(66970);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(66966);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(553, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(554, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(555, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(556, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(557, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(578, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(579, this);
    AppMethodBeat.o(66966);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(66967);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(553, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(554, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(555, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(556, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(557, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(578, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(579, this);
    AppMethodBeat.o(66967);
  }
  
  public static abstract interface a
  {
    public abstract void E(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.f
 * JD-Core Version:    0.7.0.1
 */