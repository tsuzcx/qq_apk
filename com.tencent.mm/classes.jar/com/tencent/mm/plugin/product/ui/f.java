package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.a.ox.b;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.i;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.df;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f
  implements com.tencent.mm.al.g
{
  static int mScene = 0;
  Activity jgS;
  private a uxA;
  private com.tencent.mm.sdk.b.c uxB;
  boolean uxx;
  private boolean uxy;
  com.tencent.mm.plugin.product.b.c uxz;
  
  public f(Activity paramActivity, a parama)
  {
    AppMethodBeat.i(66965);
    this.uxx = false;
    this.uxy = false;
    this.uxB = new com.tencent.mm.sdk.b.c() {};
    this.jgS = paramActivity;
    com.tencent.mm.plugin.product.a.a.dbi();
    this.uxz = com.tencent.mm.plugin.product.a.a.dbj();
    this.uxA = parama;
    AppMethodBeat.o(66965);
  }
  
  private void dbJ()
  {
    AppMethodBeat.i(66969);
    Object localObject1 = com.tencent.mm.plugin.product.a.a.dbi().dbk();
    Object localObject2 = this.uxz.dbq();
    if ((localObject2 != null) && (!bt.isNullOrNil(((chi)localObject2).saB)) && (!((chi)localObject2).saB.contains(";")))
    {
      ((d)localObject1).uwa.remove(((chi)localObject2).saB);
      ((d)localObject1).uwa.add(((chi)localObject2).saB);
      ((d)localObject1).dbD();
    }
    localObject2 = new Intent(this.jgS, MallProductUI.class);
    ((Intent)localObject2).putExtra("key_go_finish", true);
    ((Intent)localObject2).addFlags(67108864);
    localObject1 = this.jgS;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(66969);
  }
  
  public final void dbI()
  {
    AppMethodBeat.i(66968);
    m localm = this.uxz.uvI;
    cs localcs = new cs();
    ago localago = new ago();
    agu localagu = new agu();
    agn localagn = new agn();
    localagu.aEl(u.aqG());
    localagu.aEm(u.aqG());
    localagu.VM(11);
    localagu.vv(bt.eGO());
    localagn.aEe(localm.uwm.name);
    localagn.aEf(this.uxz.dbC());
    localagn.VJ(localm.uwj);
    localagn.aEh(this.uxz.a(localm));
    localagn.aEg(localm.dbE());
    localcs.deQ.title = localm.uwm.name;
    localcs.deQ.desc = this.uxz.dbC();
    localcs.deQ.deS = localago;
    localcs.deQ.type = 11;
    localago.a(localagu);
    localago.b(localagn);
    localcs.deQ.activity = this.jgS;
    localcs.deQ.deW = 5;
    com.tencent.mm.sdk.b.a.ESL.l(localcs);
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
        this.uxz.az(paramIntent);
        if (this.uxA != null) {
          this.uxA.E(0, 0, "");
        }
        com.tencent.mm.kernel.g.afC();
        Object localObject = com.tencent.mm.kernel.g.afA().gcy;
        paramIntent = this.uxz;
        if (paramIntent.uvI != null) {}
        for (paramIntent = paramIntent.uvI.uwi;; paramIntent = "")
        {
          ((q)localObject).a(new com.tencent.mm.plugin.product.b.g(paramIntent, this.uxz.uvK, this.uxz.uvO), 0);
          AppMethodBeat.o(66971);
          return;
        }
        localObject = new xk();
        ((xk)localObject).dDy.result = paramInt1;
        ((xk)localObject).dDy.intent = paramIntent;
        this.uxB.callback((com.tencent.mm.sdk.b.b)localObject);
        AppMethodBeat.o(66971);
        return;
        if (this.uxA != null)
        {
          this.uxA.E(0, 0, "");
          AppMethodBeat.o(66971);
          return;
          this.jgS.showDialog(-10002);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(new i(this.uxz.uvK, this.uxz.uvR), 0);
          AppMethodBeat.o(66971);
          return;
          if ((paramInt2 == -1) && (paramIntent != null))
          {
            this.uxz.az(paramIntent);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(new j(this.uxz.dby(), mScene), 0);
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
        this.uxz.a(paramn.uwe, paramn.uwf);
        if (this.uxA != null) {
          this.uxA.E(paramInt1, paramInt2, paramString);
        }
        if (!bt.isNullOrNil(paramn.uwe.uwi))
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(11007, new Object[] { this.uxz.dbr(), paramn.uwe.uwi, Integer.valueOf(mScene), Integer.valueOf(1) });
          AppMethodBeat.o(66970);
          return;
        }
        com.tencent.mm.plugin.report.service.h.vKh.f(11007, new Object[] { this.uxz.dbr(), paramn.uwd, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(66970);
        return;
      }
      Object localObject2;
      Object localObject1;
      if ((paramn instanceof j))
      {
        localObject2 = (j)paramn;
        paramString = this.uxz;
        paramn = ((j)localObject2).uvK;
        localObject1 = ((j)localObject2).uvV;
        localObject2 = ((j)localObject2).uvW;
        paramString.uvK = paramn;
        paramString.uvW = ((LinkedList)localObject2);
        paramString.uvV = ((LinkedList)localObject1);
        paramString.IY(0);
        paramString = this.jgS;
        paramn = new Intent(this.jgS, MallProductSubmitUI.class);
        paramn = new com.tencent.mm.hellhoundlib.b.a().bd(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.adn(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramn.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.vKh.f(11009, new Object[] { this.uxz.dbr(), this.uxz.uvI.uwi, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.product.b.f)) {
        break label864;
      }
      if ((paramn instanceof l))
      {
        paramString = ((l)paramn).uwh;
        paramInt1 = 6;
        if (mScene == 7) {
          paramInt1 = 1001;
        }
        ad.d("MicroMsg.MallProductUI", "payScene:".concat(String.valueOf(paramInt1)));
        com.tencent.mm.pluginsdk.wallet.f.a(this.jgS, paramString, this.uxz.getAppId(), paramInt1, 3);
        com.tencent.mm.sdk.b.a.ESL.c(this.uxB);
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramn instanceof k))
      {
        com.tencent.mm.ui.base.h.cf(this.jgS, this.jgS.getString(2131761137));
        dbJ();
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.product.b.g)) {
        try
        {
          this.jgS.dismissDialog(-10002);
          paramString = this.uxz;
          paramString.uvV = ((com.tencent.mm.plugin.product.b.g)paramn).uvV;
          paramString.IY(0);
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
        this.jgS.dismissDialog(-10002);
        localObject2 = (i)paramn;
        paramn = this.uxz;
        localObject1 = ((i)localObject2).mUrl;
        localObject2 = ((i)localObject2).uwg;
        if ((!bt.isNullOrNil((String)localObject1)) && (localObject2 != null) && (((LinkedList)localObject2).size() > 0))
        {
          if (paramn.uvZ == null) {
            paramn.uvZ = new HashMap();
          }
          paramn.uvZ.put(localObject1, localObject2);
        }
        if (this.uxA != null) {
          this.uxA.E(paramInt1, paramInt2, paramString);
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
        paramn = paramInt2 + " : " + this.jgS.getString(2131761118);
      }
      if (this.uxA != null) {
        this.uxA.E(paramInt1, paramInt2, paramn);
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
    this.uxz.a(paramn.uwe, paramn.uwf);
    if (this.uxA != null) {
      this.uxA.E(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(66970);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(66966);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(553, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(554, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(555, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(556, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(557, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(578, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(579, this);
    AppMethodBeat.o(66966);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(66967);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(553, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(554, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(555, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(556, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(557, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(578, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(579, this);
    AppMethodBeat.o(66967);
  }
  
  public static abstract interface a
  {
    public abstract void E(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.f
 * JD-Core Version:    0.7.0.1
 */