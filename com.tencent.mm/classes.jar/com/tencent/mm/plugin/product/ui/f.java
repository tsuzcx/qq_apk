package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.i;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f
  implements com.tencent.mm.al.f
{
  static int mScene = 0;
  Activity kbt;
  private f.a wNA;
  private com.tencent.mm.sdk.b.c wNB;
  boolean wNx;
  private boolean wNy;
  com.tencent.mm.plugin.product.b.c wNz;
  
  public f(Activity paramActivity, f.a parama)
  {
    AppMethodBeat.i(66965);
    this.wNx = false;
    this.wNy = false;
    this.wNB = new com.tencent.mm.sdk.b.c() {};
    this.kbt = paramActivity;
    com.tencent.mm.plugin.product.a.a.dzs();
    this.wNz = com.tencent.mm.plugin.product.a.a.dzt();
    this.wNA = parama;
    AppMethodBeat.o(66965);
  }
  
  private void dzT()
  {
    AppMethodBeat.i(66969);
    Object localObject1 = com.tencent.mm.plugin.product.a.a.dzs().dzu();
    Object localObject2 = this.wNz.dzA();
    if ((localObject2 != null) && (!bt.isNullOrNil(((crm)localObject2).ugo)) && (!((crm)localObject2).ugo.contains(";")))
    {
      ((d)localObject1).wLZ.remove(((crm)localObject2).ugo);
      ((d)localObject1).wLZ.add(((crm)localObject2).ugo);
      ((d)localObject1).dzN();
    }
    localObject2 = new Intent(this.kbt, MallProductUI.class);
    ((Intent)localObject2).putExtra("key_go_finish", true);
    ((Intent)localObject2).addFlags(67108864);
    localObject1 = this.kbt;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(66969);
  }
  
  public final void dzS()
  {
    AppMethodBeat.i(66968);
    m localm = this.wNz.wLH;
    cv localcv = new cv();
    akd localakd = new akd();
    akj localakj = new akj();
    akc localakc = new akc();
    localakj.aPf(u.aAm());
    localakj.aPg(u.aAm());
    localakj.ZR(11);
    localakj.CM(bt.flT());
    localakc.aOY(localm.wMl.name);
    localakc.aOZ(this.wNz.dzM());
    localakc.ZO(localm.wMi);
    localakc.aPb(this.wNz.a(localm));
    localakc.aPa(localm.dzO());
    localcv.dnG.title = localm.wMl.name;
    localcv.dnG.desc = this.wNz.dzM();
    localcv.dnG.dnI = localakd;
    localcv.dnG.type = 11;
    localakd.a(localakj);
    localakd.b(localakc);
    localcv.dnG.activity = this.kbt;
    localcv.dnG.dnM = 5;
    com.tencent.mm.sdk.b.a.IbL.l(localcv);
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
        this.wNz.aF(paramIntent);
        if (this.wNA != null) {
          this.wNA.E(0, 0, "");
        }
        com.tencent.mm.kernel.g.ajD();
        Object localObject = com.tencent.mm.kernel.g.ajB().gAO;
        paramIntent = this.wNz;
        if (paramIntent.wLH != null) {}
        for (paramIntent = paramIntent.wLH.wMh;; paramIntent = "")
        {
          ((q)localObject).a(new com.tencent.mm.plugin.product.b.g(paramIntent, this.wNz.wLJ, this.wNz.wLN), 0);
          AppMethodBeat.o(66971);
          return;
        }
        localObject = new yp();
        ((yp)localObject).dNx.result = paramInt1;
        ((yp)localObject).dNx.intent = paramIntent;
        this.wNB.callback((com.tencent.mm.sdk.b.b)localObject);
        AppMethodBeat.o(66971);
        return;
        if (this.wNA != null)
        {
          this.wNA.E(0, 0, "");
          AppMethodBeat.o(66971);
          return;
          this.kbt.showDialog(-10002);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(new i(this.wNz.wLJ, this.wNz.wLQ), 0);
          AppMethodBeat.o(66971);
          return;
          if ((paramInt2 == -1) && (paramIntent != null))
          {
            this.wNz.aF(paramIntent);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(new j(this.wNz.dzI(), mScene), 0);
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66970);
    ad.d("MicroMsg.MallProductUI", "errCode: " + paramInt2 + ", errMsg: " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.product.b.h))
      {
        paramn = (com.tencent.mm.plugin.product.b.h)paramn;
        this.wNz.a(paramn.wMd, paramn.wMe);
        if (this.wNA != null) {
          this.wNA.E(paramInt1, paramInt2, paramString);
        }
        if (!bt.isNullOrNil(paramn.wMd.wMh))
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(11007, new Object[] { this.wNz.dzB(), paramn.wMd.wMh, Integer.valueOf(mScene), Integer.valueOf(1) });
          AppMethodBeat.o(66970);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(11007, new Object[] { this.wNz.dzB(), paramn.wMc, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(66970);
        return;
      }
      Object localObject2;
      Object localObject1;
      if ((paramn instanceof j))
      {
        localObject2 = (j)paramn;
        paramString = this.wNz;
        paramn = ((j)localObject2).wLJ;
        localObject1 = ((j)localObject2).wLU;
        localObject2 = ((j)localObject2).wLV;
        paramString.wLJ = paramn;
        paramString.wLV = ((LinkedList)localObject2);
        paramString.wLU = ((LinkedList)localObject1);
        paramString.MA(0);
        paramString = this.kbt;
        paramn = new Intent(this.kbt, MallProductSubmitUI.class);
        paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahp(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramn.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.g.yhR.f(11009, new Object[] { this.wNz.dzB(), this.wNz.wLH.wMh, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.product.b.f)) {
        break label864;
      }
      if ((paramn instanceof l))
      {
        paramString = ((l)paramn).wMg;
        paramInt1 = 6;
        if (mScene == 7) {
          paramInt1 = 1001;
        }
        ad.d("MicroMsg.MallProductUI", "payScene:".concat(String.valueOf(paramInt1)));
        com.tencent.mm.pluginsdk.wallet.f.a(this.kbt, paramString, this.wNz.getAppId(), paramInt1, 3);
        com.tencent.mm.sdk.b.a.IbL.c(this.wNB);
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramn instanceof k))
      {
        com.tencent.mm.ui.base.h.cl(this.kbt, this.kbt.getString(2131761137));
        dzT();
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.product.b.g)) {
        try
        {
          this.kbt.dismissDialog(-10002);
          paramString = this.wNz;
          paramString.wLU = ((com.tencent.mm.plugin.product.b.g)paramn).wLU;
          paramString.MA(0);
          AppMethodBeat.o(66970);
          return;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ad.e("MicroMsg.MallProductUI", paramString.toString());
          }
        }
      }
      if (!(paramn instanceof i)) {
        break label864;
      }
      try
      {
        this.kbt.dismissDialog(-10002);
        localObject2 = (i)paramn;
        paramn = this.wNz;
        localObject1 = ((i)localObject2).mUrl;
        localObject2 = ((i)localObject2).wMf;
        if ((!bt.isNullOrNil((String)localObject1)) && (localObject2 != null) && (((LinkedList)localObject2).size() > 0))
        {
          if (paramn.wLY == null) {
            paramn.wLY = new HashMap();
          }
          paramn.wLY.put(localObject1, localObject2);
        }
        if (this.wNA != null) {
          this.wNA.E(paramInt1, paramInt2, paramString);
        }
        AppMethodBeat.o(66970);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.MallProductUI", localException.toString());
        }
      }
    }
    switch (paramInt2)
    {
    default: 
      ad.i("MicroMsg.MallProductUI", "unkown errCode ".concat(String.valueOf(paramInt2)));
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
        paramn = paramInt2 + " : " + this.kbt.getString(2131761118);
      }
      if (this.wNA != null) {
        this.wNA.E(paramInt1, paramInt2, paramn);
      }
      break;
    }
    label864:
    do
    {
      AppMethodBeat.o(66970);
      return;
      ad.i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
    } while (!(paramn instanceof com.tencent.mm.plugin.product.b.h));
    paramn = (com.tencent.mm.plugin.product.b.h)paramn;
    this.wNz.a(paramn.wMd, paramn.wMe);
    if (this.wNA != null) {
      this.wNA.E(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(66970);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(66966);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(553, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(554, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(555, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(556, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(557, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(578, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(579, this);
    AppMethodBeat.o(66966);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(66967);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(553, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(554, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(555, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(556, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(557, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(578, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(579, this);
    AppMethodBeat.o(66967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.f
 * JD-Core Version:    0.7.0.1
 */