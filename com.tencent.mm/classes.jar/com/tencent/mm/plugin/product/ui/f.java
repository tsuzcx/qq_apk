package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.g.a.pg.b;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.i;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.cml;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f
  implements com.tencent.mm.ak.g
{
  static int mScene = 0;
  Activity jHh;
  boolean vGq;
  private boolean vGr;
  com.tencent.mm.plugin.product.b.c vGs;
  private a vGt;
  private com.tencent.mm.sdk.b.c vGu;
  
  public f(Activity paramActivity, a parama)
  {
    AppMethodBeat.i(66965);
    this.vGq = false;
    this.vGr = false;
    this.vGu = new com.tencent.mm.sdk.b.c() {};
    this.jHh = paramActivity;
    com.tencent.mm.plugin.product.a.a.doQ();
    this.vGs = com.tencent.mm.plugin.product.a.a.doR();
    this.vGt = parama;
    AppMethodBeat.o(66965);
  }
  
  private void dpr()
  {
    AppMethodBeat.i(66969);
    Object localObject1 = com.tencent.mm.plugin.product.a.a.doQ().doS();
    Object localObject2 = this.vGs.doY();
    if ((localObject2 != null) && (!bs.isNullOrNil(((cml)localObject2).tiv)) && (!((cml)localObject2).tiv.contains(";")))
    {
      ((d)localObject1).vET.remove(((cml)localObject2).tiv);
      ((d)localObject1).vET.add(((cml)localObject2).tiv);
      ((d)localObject1).dpl();
    }
    localObject2 = new Intent(this.jHh, MallProductUI.class);
    ((Intent)localObject2).putExtra("key_go_finish", true);
    ((Intent)localObject2).addFlags(67108864);
    localObject1 = this.jHh;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(66969);
  }
  
  public final void dpq()
  {
    AppMethodBeat.i(66968);
    m localm = this.vGs.vEB;
    cs localcs = new cs();
    ahn localahn = new ahn();
    aht localaht = new aht();
    ahm localahm = new ahm();
    localaht.aJC(u.axw());
    localaht.aJD(u.axw());
    localaht.XV(11);
    localaht.zY(bs.eWj());
    localahm.aJv(localm.vFf.name);
    localahm.aJw(this.vGs.dpk());
    localahm.XS(localm.vFc);
    localahm.aJy(this.vGs.a(localm));
    localahm.aJx(localm.dpm());
    localcs.dck.title = localm.vFf.name;
    localcs.dck.desc = this.vGs.dpk();
    localcs.dck.dcm = localahn;
    localcs.dck.type = 11;
    localahn.a(localaht);
    localahn.b(localahm);
    localcs.dck.activity = this.jHh;
    localcs.dck.dcq = 5;
    com.tencent.mm.sdk.b.a.GpY.l(localcs);
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
        this.vGs.aA(paramIntent);
        if (this.vGt != null) {
          this.vGt.D(0, 0, "");
        }
        com.tencent.mm.kernel.g.agS();
        Object localObject = com.tencent.mm.kernel.g.agQ().ghe;
        paramIntent = this.vGs;
        if (paramIntent.vEB != null) {}
        for (paramIntent = paramIntent.vEB.vFb;; paramIntent = "")
        {
          ((q)localObject).a(new com.tencent.mm.plugin.product.b.g(paramIntent, this.vGs.vED, this.vGs.vEH), 0);
          AppMethodBeat.o(66971);
          return;
        }
        localObject = new xv();
        ((xv)localObject).dBk.result = paramInt1;
        ((xv)localObject).dBk.intent = paramIntent;
        this.vGu.callback((com.tencent.mm.sdk.b.b)localObject);
        AppMethodBeat.o(66971);
        return;
        if (this.vGt != null)
        {
          this.vGt.D(0, 0, "");
          AppMethodBeat.o(66971);
          return;
          this.jHh.showDialog(-10002);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(new i(this.vGs.vED, this.vGs.vEK), 0);
          AppMethodBeat.o(66971);
          return;
          if ((paramInt2 == -1) && (paramIntent != null))
          {
            this.vGs.aA(paramIntent);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(new j(this.vGs.dpg(), mScene), 0);
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66970);
    ac.d("MicroMsg.MallProductUI", "errCode: " + paramInt2 + ", errMsg: " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.product.b.h))
      {
        paramn = (com.tencent.mm.plugin.product.b.h)paramn;
        this.vGs.a(paramn.vEX, paramn.vEY);
        if (this.vGt != null) {
          this.vGt.D(paramInt1, paramInt2, paramString);
        }
        if (!bs.isNullOrNil(paramn.vEX.vFb))
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(11007, new Object[] { this.vGs.doZ(), paramn.vEX.vFb, Integer.valueOf(mScene), Integer.valueOf(1) });
          AppMethodBeat.o(66970);
          return;
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(11007, new Object[] { this.vGs.doZ(), paramn.vEW, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(66970);
        return;
      }
      Object localObject2;
      Object localObject1;
      if ((paramn instanceof j))
      {
        localObject2 = (j)paramn;
        paramString = this.vGs;
        paramn = ((j)localObject2).vED;
        localObject1 = ((j)localObject2).vEO;
        localObject2 = ((j)localObject2).vEP;
        paramString.vED = paramn;
        paramString.vEP = ((LinkedList)localObject2);
        paramString.vEO = ((LinkedList)localObject1);
        paramString.KX(0);
        paramString = this.jHh;
        paramn = new Intent(this.jHh, MallProductSubmitUI.class);
        paramn = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.aeD(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramn.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.wUl.f(11009, new Object[] { this.vGs.doZ(), this.vGs.vEB.vFb, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.product.b.f)) {
        break label864;
      }
      if ((paramn instanceof l))
      {
        paramString = ((l)paramn).vFa;
        paramInt1 = 6;
        if (mScene == 7) {
          paramInt1 = 1001;
        }
        ac.d("MicroMsg.MallProductUI", "payScene:".concat(String.valueOf(paramInt1)));
        com.tencent.mm.pluginsdk.wallet.f.a(this.jHh, paramString, this.vGs.getAppId(), paramInt1, 3);
        com.tencent.mm.sdk.b.a.GpY.c(this.vGu);
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramn instanceof k))
      {
        com.tencent.mm.ui.base.h.cg(this.jHh, this.jHh.getString(2131761137));
        dpr();
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.product.b.g)) {
        try
        {
          this.jHh.dismissDialog(-10002);
          paramString = this.vGs;
          paramString.vEO = ((com.tencent.mm.plugin.product.b.g)paramn).vEO;
          paramString.KX(0);
          AppMethodBeat.o(66970);
          return;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ac.e("MicroMsg.MallProductUI", paramString.toString());
          }
        }
      }
      if (!(paramn instanceof i)) {
        break label864;
      }
      try
      {
        this.jHh.dismissDialog(-10002);
        localObject2 = (i)paramn;
        paramn = this.vGs;
        localObject1 = ((i)localObject2).mUrl;
        localObject2 = ((i)localObject2).vEZ;
        if ((!bs.isNullOrNil((String)localObject1)) && (localObject2 != null) && (((LinkedList)localObject2).size() > 0))
        {
          if (paramn.vES == null) {
            paramn.vES = new HashMap();
          }
          paramn.vES.put(localObject1, localObject2);
        }
        if (this.vGt != null) {
          this.vGt.D(paramInt1, paramInt2, paramString);
        }
        AppMethodBeat.o(66970);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.MallProductUI", localException.toString());
        }
      }
    }
    switch (paramInt2)
    {
    default: 
      ac.i("MicroMsg.MallProductUI", "unkown errCode ".concat(String.valueOf(paramInt2)));
      paramn = paramString;
      if (bs.isNullOrNil(paramString)) {
        paramn = paramInt2 + " : " + this.jHh.getString(2131761118);
      }
      if (this.vGt != null) {
        this.vGt.D(paramInt1, paramInt2, paramn);
      }
      break;
    }
    label864:
    do
    {
      AppMethodBeat.o(66970);
      return;
      ac.i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
    } while (!(paramn instanceof com.tencent.mm.plugin.product.b.h));
    paramn = (com.tencent.mm.plugin.product.b.h)paramn;
    this.vGs.a(paramn.vEX, paramn.vEY);
    if (this.vGt != null) {
      this.vGt.D(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(66970);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(66966);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(553, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(554, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(555, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(556, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(557, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(578, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(579, this);
    AppMethodBeat.o(66966);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(66967);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(553, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(554, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(555, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(556, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(557, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(578, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(579, this);
    AppMethodBeat.o(66967);
  }
  
  public static abstract interface a
  {
    public abstract void D(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.f
 * JD-Core Version:    0.7.0.1
 */