package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.abh;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.rj;
import com.tencent.mm.f.a.rj.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.g;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.dp;
import com.tencent.mm.protocal.protobuf.dtx;
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
  implements com.tencent.mm.an.i
{
  static int mScene = 0;
  boolean GUL;
  private boolean GUM;
  com.tencent.mm.plugin.product.b.c GUN;
  private a GUO;
  private IListener GUP;
  Activity mContext;
  
  public f(Activity paramActivity, a parama)
  {
    AppMethodBeat.i(66965);
    this.GUL = false;
    this.GUM = false;
    this.GUP = new IListener() {};
    this.mContext = paramActivity;
    com.tencent.mm.plugin.product.a.a.foU();
    this.GUN = com.tencent.mm.plugin.product.a.a.foV();
    this.GUO = parama;
    AppMethodBeat.o(66965);
  }
  
  private void fpv()
  {
    AppMethodBeat.i(66969);
    Object localObject1 = com.tencent.mm.plugin.product.a.a.foU().foW();
    Object localObject2 = this.GUN.fpc();
    if ((localObject2 != null) && (!Util.isNullOrNil(((dtx)localObject2).COk)) && (!((dtx)localObject2).COk.contains(";")))
    {
      ((d)localObject1).GTn.remove(((dtx)localObject2).COk);
      ((d)localObject1).GTn.add(((dtx)localObject2).COk);
      ((d)localObject1).fpp();
    }
    localObject2 = new Intent(this.mContext, MallProductUI.class);
    ((Intent)localObject2).putExtra("key_go_finish", true);
    ((Intent)localObject2).addFlags(67108864);
    localObject1 = this.mContext;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(66969);
  }
  
  public final void fpu()
  {
    AppMethodBeat.i(66968);
    m localm = this.GUN.GSV;
    dd localdd = new dd();
    aoc localaoc = new aoc();
    aoi localaoi = new aoi();
    aob localaob = new aob();
    localaoi.btx(z.bcZ());
    localaoi.bty(z.bcZ());
    localaoi.arz(11);
    localaoi.Ue(Util.nowMilliSecond());
    localaob.btq(localm.GTz.name);
    localaob.btr(this.GUN.fpo());
    localaob.arw(localm.GTw);
    localaob.btt(this.GUN.a(localm));
    localaob.bts(localm.fpq());
    localdd.fyI.title = localm.GTz.name;
    localdd.fyI.desc = this.GUN.fpo();
    localdd.fyI.fyK = localaoc;
    localdd.fyI.type = 11;
    localaoc.a(localaoi);
    localaoc.b(localaob);
    localdd.fyI.activity = this.mContext;
    localdd.fyI.fyP = 5;
    EventCenter.instance.publish(localdd);
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
        this.GUN.aN(paramIntent);
        if (this.GUO != null) {
          this.GUO.F(0, 0, "");
        }
        com.tencent.mm.kernel.h.aHH();
        Object localObject = com.tencent.mm.kernel.h.aHF().kcd;
        paramIntent = this.GUN;
        if (paramIntent.GSV != null) {}
        for (paramIntent = paramIntent.GSV.GTv;; paramIntent = "")
        {
          ((t)localObject).a(new g(paramIntent, this.GUN.GSX, this.GUN.GTb), 0);
          AppMethodBeat.o(66971);
          return;
        }
        localObject = new abh();
        ((abh)localObject).gaZ.result = paramInt1;
        ((abh)localObject).gaZ.intent = paramIntent;
        this.GUP.callback((IEvent)localObject);
        AppMethodBeat.o(66971);
        return;
        if (this.GUO != null)
        {
          this.GUO.F(0, 0, "");
          AppMethodBeat.o(66971);
          return;
          this.mContext.showDialog(-10002);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.product.b.i(this.GUN.GSX, this.GUN.GTe), 0);
          AppMethodBeat.o(66971);
          return;
          if ((paramInt2 == -1) && (paramIntent != null))
          {
            this.GUN.aN(paramIntent);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(new j(this.GUN.fpk(), mScene), 0);
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
        this.GUN.a(paramq.GTr, paramq.GTs);
        if (this.GUO != null) {
          this.GUO.F(paramInt1, paramInt2, paramString);
        }
        if (!Util.isNullOrNil(paramq.GTr.GTv))
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(11007, new Object[] { this.GUN.fpd(), paramq.GTr.GTv, Integer.valueOf(mScene), Integer.valueOf(1) });
          AppMethodBeat.o(66970);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(11007, new Object[] { this.GUN.fpd(), paramq.GTq, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(66970);
        return;
      }
      Object localObject2;
      Object localObject1;
      if ((paramq instanceof j))
      {
        localObject2 = (j)paramq;
        paramString = this.GUN;
        paramq = ((j)localObject2).GSX;
        localObject1 = ((j)localObject2).GTi;
        localObject2 = ((j)localObject2).GTj;
        paramString.GSX = paramq;
        paramString.GTj = ((LinkedList)localObject2);
        paramString.GTi = ((LinkedList)localObject1);
        paramString.abf(0);
        paramString = this.mContext;
        paramq = new Intent(this.mContext, MallProductSubmitUI.class);
        paramq = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, paramq.aFh(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramq.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.IzE.a(11009, new Object[] { this.GUN.fpd(), this.GUN.GSV.GTv, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.product.b.f)) {
        break label864;
      }
      if ((paramq instanceof l))
      {
        paramString = ((l)paramq).GTu;
        paramInt1 = 6;
        if (mScene == 7) {
          paramInt1 = 1001;
        }
        Log.d("MicroMsg.MallProductUI", "payScene:".concat(String.valueOf(paramInt1)));
        com.tencent.mm.pluginsdk.wallet.f.c(this.mContext, paramString, this.GUN.getAppId(), paramInt1, 3);
        EventCenter.instance.addListener(this.GUP);
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramq instanceof k))
      {
        com.tencent.mm.ui.base.h.cO(this.mContext, this.mContext.getString(a.i.mall_product_submit_buy_free));
        fpv();
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramq instanceof g)) {
        try
        {
          this.mContext.dismissDialog(-10002);
          paramString = this.GUN;
          paramString.GTi = ((g)paramq).GTi;
          paramString.abf(0);
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
        paramq = this.GUN;
        localObject1 = ((com.tencent.mm.plugin.product.b.i)localObject2).mUrl;
        localObject2 = ((com.tencent.mm.plugin.product.b.i)localObject2).GTt;
        if ((!Util.isNullOrNil((String)localObject1)) && (localObject2 != null) && (((LinkedList)localObject2).size() > 0))
        {
          if (paramq.GTm == null) {
            paramq.GTm = new HashMap();
          }
          paramq.GTm.put(localObject1, localObject2);
        }
        if (this.GUO != null) {
          this.GUO.F(paramInt1, paramInt2, paramString);
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
        paramq = paramInt2 + " : " + this.mContext.getString(a.i.mall_product_data_err);
      }
      if (this.GUO != null) {
        this.GUO.F(paramInt1, paramInt2, paramq);
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
    this.GUN.a(paramq.GTr, paramq.GTs);
    if (this.GUO != null) {
      this.GUO.F(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(66970);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(66966);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(553, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(554, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(555, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(556, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(557, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(578, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(579, this);
    AppMethodBeat.o(66966);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(66967);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(553, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(554, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(555, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(556, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(557, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(578, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(579, this);
    AppMethodBeat.o(66967);
  }
  
  public static abstract interface a
  {
    public abstract void F(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.f
 * JD-Core Version:    0.7.0.1
 */