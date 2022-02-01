package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.a.qj.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f
  implements com.tencent.mm.ak.i
{
  static int mScene = 0;
  boolean BaN;
  private boolean BaO;
  com.tencent.mm.plugin.product.b.c BaP;
  private a BaQ;
  private IListener BaR;
  Activity mContext;
  
  public f(Activity paramActivity, a parama)
  {
    AppMethodBeat.i(66965);
    this.BaN = false;
    this.BaO = false;
    this.BaR = new IListener() {};
    this.mContext = paramActivity;
    com.tencent.mm.plugin.product.a.a.eDb();
    this.BaP = com.tencent.mm.plugin.product.a.a.eDc();
    this.BaQ = parama;
    AppMethodBeat.o(66965);
  }
  
  private void eDC()
  {
    AppMethodBeat.i(66969);
    Object localObject1 = com.tencent.mm.plugin.product.a.a.eDb().eDd();
    Object localObject2 = this.BaP.eDj();
    if ((localObject2 != null) && (!Util.isNullOrNil(((dki)localObject2).xKd)) && (!((dki)localObject2).xKd.contains(";")))
    {
      ((d)localObject1).AZp.remove(((dki)localObject2).xKd);
      ((d)localObject1).AZp.add(((dki)localObject2).xKd);
      ((d)localObject1).eDw();
    }
    localObject2 = new Intent(this.mContext, MallProductUI.class);
    ((Intent)localObject2).putExtra("key_go_finish", true);
    ((Intent)localObject2).addFlags(67108864);
    localObject1 = this.mContext;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(66969);
  }
  
  public final void eDB()
  {
    AppMethodBeat.i(66968);
    m localm = this.BaP.AYX;
    cz localcz = new cz();
    anb localanb = new anb();
    anh localanh = new anh();
    ana localana = new ana();
    localanh.bhf(z.aTY());
    localanh.bhg(z.aTY());
    localanh.ajm(11);
    localanh.MA(Util.nowMilliSecond());
    localana.bgY(localm.AZB.name);
    localana.bgZ(this.BaP.eDv());
    localana.ajj(localm.AZy);
    localana.bhb(this.BaP.a(localm));
    localana.bha(localm.eDx());
    localcz.dFZ.title = localm.AZB.name;
    localcz.dFZ.desc = this.BaP.eDv();
    localcz.dFZ.dGb = localanb;
    localcz.dFZ.type = 11;
    localanb.a(localanh);
    localanb.b(localana);
    localcz.dFZ.activity = this.mContext;
    localcz.dFZ.dGf = 5;
    EventCenter.instance.publish(localcz);
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
        this.BaP.aO(paramIntent);
        if (this.BaQ != null) {
          this.BaQ.D(0, 0, "");
        }
        com.tencent.mm.kernel.g.aAi();
        Object localObject = com.tencent.mm.kernel.g.aAg().hqi;
        paramIntent = this.BaP;
        if (paramIntent.AYX != null) {}
        for (paramIntent = paramIntent.AYX.AZx;; paramIntent = "")
        {
          ((t)localObject).a(new com.tencent.mm.plugin.product.b.g(paramIntent, this.BaP.AYZ, this.BaP.AZd), 0);
          AppMethodBeat.o(66971);
          return;
        }
        localObject = new aaa();
        ((aaa)localObject).egJ.result = paramInt1;
        ((aaa)localObject).egJ.intent = paramIntent;
        this.BaR.callback((IEvent)localObject);
        AppMethodBeat.o(66971);
        return;
        if (this.BaQ != null)
        {
          this.BaQ.D(0, 0, "");
          AppMethodBeat.o(66971);
          return;
          this.mContext.showDialog(-10002);
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.product.b.i(this.BaP.AYZ, this.BaP.AZg), 0);
          AppMethodBeat.o(66971);
          return;
          if ((paramInt2 == -1) && (paramIntent != null))
          {
            this.BaP.aO(paramIntent);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(new j(this.BaP.eDr(), mScene), 0);
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(66970);
    Log.d("MicroMsg.MallProductUI", "errCode: " + paramInt2 + ", errMsg: " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof com.tencent.mm.plugin.product.b.h))
      {
        paramq = (com.tencent.mm.plugin.product.b.h)paramq;
        this.BaP.a(paramq.AZt, paramq.AZu);
        if (this.BaQ != null) {
          this.BaQ.D(paramInt1, paramInt2, paramString);
        }
        if (!Util.isNullOrNil(paramq.AZt.AZx))
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(11007, new Object[] { this.BaP.eDk(), paramq.AZt.AZx, Integer.valueOf(mScene), Integer.valueOf(1) });
          AppMethodBeat.o(66970);
          return;
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(11007, new Object[] { this.BaP.eDk(), paramq.AZs, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(66970);
        return;
      }
      Object localObject2;
      Object localObject1;
      if ((paramq instanceof j))
      {
        localObject2 = (j)paramq;
        paramString = this.BaP;
        paramq = ((j)localObject2).AYZ;
        localObject1 = ((j)localObject2).AZk;
        localObject2 = ((j)localObject2).AZl;
        paramString.AYZ = paramq;
        paramString.AZl = ((LinkedList)localObject2);
        paramString.AZk = ((LinkedList)localObject1);
        paramString.Ut(0);
        paramString = this.mContext;
        paramq = new Intent(this.mContext, MallProductSubmitUI.class);
        paramq = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramq.axQ(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramq.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.CyF.a(11009, new Object[] { this.BaP.eDk(), this.BaP.AYX.AZx, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.product.b.f)) {
        break label864;
      }
      if ((paramq instanceof l))
      {
        paramString = ((l)paramq).AZw;
        paramInt1 = 6;
        if (mScene == 7) {
          paramInt1 = 1001;
        }
        Log.d("MicroMsg.MallProductUI", "payScene:".concat(String.valueOf(paramInt1)));
        com.tencent.mm.pluginsdk.wallet.f.a(this.mContext, paramString, this.BaP.getAppId(), paramInt1, 3);
        EventCenter.instance.addListener(this.BaR);
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramq instanceof k))
      {
        com.tencent.mm.ui.base.h.cD(this.mContext, this.mContext.getString(2131762924));
        eDC();
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.product.b.g)) {
        try
        {
          this.mContext.dismissDialog(-10002);
          paramString = this.BaP;
          paramString.AZk = ((com.tencent.mm.plugin.product.b.g)paramq).AZk;
          paramString.Ut(0);
          AppMethodBeat.o(66970);
          return;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.e("MicroMsg.MallProductUI", paramString.toString());
          }
        }
      }
      if (!(paramq instanceof com.tencent.mm.plugin.product.b.i)) {
        break label864;
      }
      try
      {
        this.mContext.dismissDialog(-10002);
        localObject2 = (com.tencent.mm.plugin.product.b.i)paramq;
        paramq = this.BaP;
        localObject1 = ((com.tencent.mm.plugin.product.b.i)localObject2).mUrl;
        localObject2 = ((com.tencent.mm.plugin.product.b.i)localObject2).AZv;
        if ((!Util.isNullOrNil((String)localObject1)) && (localObject2 != null) && (((LinkedList)localObject2).size() > 0))
        {
          if (paramq.AZo == null) {
            paramq.AZo = new HashMap();
          }
          paramq.AZo.put(localObject1, localObject2);
        }
        if (this.BaQ != null) {
          this.BaQ.D(paramInt1, paramInt2, paramString);
        }
        AppMethodBeat.o(66970);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.MallProductUI", localException.toString());
        }
      }
    }
    switch (paramInt2)
    {
    default: 
      Log.i("MicroMsg.MallProductUI", "unkown errCode ".concat(String.valueOf(paramInt2)));
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = paramInt2 + " : " + this.mContext.getString(2131762905);
      }
      if (this.BaQ != null) {
        this.BaQ.D(paramInt1, paramInt2, paramq);
      }
      break;
    }
    label864:
    do
    {
      AppMethodBeat.o(66970);
      return;
      Log.i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
    } while (!(paramq instanceof com.tencent.mm.plugin.product.b.h));
    paramq = (com.tencent.mm.plugin.product.b.h)paramq;
    this.BaP.a(paramq.AZt, paramq.AZu);
    if (this.BaQ != null) {
      this.BaQ.D(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(66970);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(66966);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(553, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(554, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(555, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(556, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(557, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(578, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(579, this);
    AppMethodBeat.o(66966);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(66967);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(553, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(554, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(555, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(556, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(557, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(578, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(579, this);
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