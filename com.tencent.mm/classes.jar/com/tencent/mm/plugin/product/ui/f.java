package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.product.model.b;
import com.tencent.mm.plugin.product.model.e;
import com.tencent.mm.plugin.product.model.g;
import com.tencent.mm.plugin.product.model.i;
import com.tencent.mm.plugin.product.model.j;
import com.tencent.mm.plugin.product.model.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ems;
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
  implements com.tencent.mm.am.h
{
  static int mScene = 0;
  boolean MSn;
  private boolean MSo;
  b MSp;
  private a MSq;
  private IListener MSr;
  Activity mContext;
  
  public f(Activity paramActivity, a parama)
  {
    AppMethodBeat.i(66965);
    this.MSn = false;
    this.MSo = false;
    this.MSr = new MallProductHelper.4(this, com.tencent.mm.app.f.hfK);
    this.mContext = paramActivity;
    com.tencent.mm.plugin.product.a.a.gzY();
    this.MSp = com.tencent.mm.plugin.product.a.a.gzZ();
    this.MSq = parama;
    AppMethodBeat.o(66965);
  }
  
  private void gAz()
  {
    AppMethodBeat.i(66969);
    Object localObject1 = com.tencent.mm.plugin.product.a.a.gzY().gAa();
    Object localObject2 = this.MSp.gAg();
    if ((localObject2 != null) && (!Util.isNullOrNil(((ems)localObject2).IIu)) && (!((ems)localObject2).IIu.contains(";")))
    {
      ((com.tencent.mm.plugin.product.model.c)localObject1).MQR.remove(((ems)localObject2).IIu);
      ((com.tencent.mm.plugin.product.model.c)localObject1).MQR.add(((ems)localObject2).IIu);
      ((com.tencent.mm.plugin.product.model.c)localObject1).gAt();
    }
    localObject2 = new Intent(this.mContext, MallProductUI.class);
    ((Intent)localObject2).putExtra("key_go_finish", true);
    ((Intent)localObject2).addFlags(67108864);
    localObject1 = this.mContext;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(66969);
  }
  
  public final void gAy()
  {
    AppMethodBeat.i(66968);
    l locall = this.MSp.MQz;
    dn localdn = new dn();
    arv localarv = new arv();
    asb localasb = new asb();
    aru localaru = new aru();
    localasb.bto(z.bAM());
    localasb.btp(z.bAM());
    localasb.axH(11);
    localasb.yu(Util.nowMilliSecond());
    localaru.bth(locall.MRd.name);
    localaru.bti(this.MSp.gAs());
    localaru.axE(locall.MRa);
    localaru.btk(this.MSp.a(locall));
    localaru.btj(locall.gAu());
    localdn.hDr.title = locall.MRd.name;
    localdn.hDr.desc = this.MSp.gAs();
    localdn.hDr.hDt = localarv;
    localdn.hDr.type = 11;
    localarv.a(localasb);
    localarv.b(localaru);
    localdn.hDr.activity = this.mContext;
    localdn.hDr.hDy = 5;
    localdn.publish();
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
        this.MSp.bm(paramIntent);
        if (this.MSq != null) {
          this.MSq.J(0, 0, "");
        }
        com.tencent.mm.kernel.h.baF();
        Object localObject = com.tencent.mm.kernel.h.baD().mCm;
        paramIntent = this.MSp;
        if (paramIntent.MQz != null) {}
        for (paramIntent = paramIntent.MQz.MQZ;; paramIntent = "")
        {
          ((s)localObject).a(new com.tencent.mm.plugin.product.model.f(paramIntent, this.MSp.MQB, this.MSp.MQF), 0);
          AppMethodBeat.o(66971);
          return;
        }
        localObject = new ade();
        ((ade)localObject).ihj.result = paramInt1;
        ((ade)localObject).ihj.intent = paramIntent;
        this.MSr.callback((IEvent)localObject);
        AppMethodBeat.o(66971);
        return;
        if (this.MSq != null)
        {
          this.MSq.J(0, 0, "");
          AppMethodBeat.o(66971);
          return;
          this.mContext.showDialog(-10002);
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.product.model.h(this.MSp.MQB, this.MSp.MQI), 0);
          AppMethodBeat.o(66971);
          return;
          if ((paramInt2 == -1) && (paramIntent != null))
          {
            this.MSp.bm(paramIntent);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(new i(this.MSp.gAo(), mScene), 0);
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(66970);
    Log.d("MicroMsg.MallProductUI", "errCode: " + paramInt2 + ", errMsg: " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof g))
      {
        paramp = (g)paramp;
        this.MSp.a(paramp.MQV, paramp.MQW);
        if (this.MSq != null) {
          this.MSq.J(paramInt1, paramInt2, paramString);
        }
        if (!Util.isNullOrNil(paramp.MQV.MQZ))
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(11007, new Object[] { this.MSp.gAh(), paramp.MQV.MQZ, Integer.valueOf(mScene), Integer.valueOf(1) });
          AppMethodBeat.o(66970);
          return;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(11007, new Object[] { this.MSp.gAh(), paramp.MQU, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(66970);
        return;
      }
      Object localObject2;
      Object localObject1;
      if ((paramp instanceof i))
      {
        localObject2 = (i)paramp;
        paramString = this.MSp;
        paramp = ((i)localObject2).MQB;
        localObject1 = ((i)localObject2).MQM;
        localObject2 = ((i)localObject2).MQN;
        paramString.MQB = paramp;
        paramString.MQN = ((LinkedList)localObject2);
        paramString.MQM = ((LinkedList)localObject1);
        paramString.afy(0);
        paramString = this.mContext;
        paramp = new Intent(this.mContext, MallProductSubmitUI.class);
        paramp = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, paramp.aYi(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramp.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.OAn.b(11009, new Object[] { this.MSp.gAh(), this.MSp.MQz.MQZ, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramp instanceof e)) {
        break label864;
      }
      if ((paramp instanceof com.tencent.mm.plugin.product.model.k))
      {
        paramString = ((com.tencent.mm.plugin.product.model.k)paramp).MQY;
        paramInt1 = 6;
        if (mScene == 7) {
          paramInt1 = 1001;
        }
        Log.d("MicroMsg.MallProductUI", "payScene:".concat(String.valueOf(paramInt1)));
        com.tencent.mm.pluginsdk.wallet.f.b(this.mContext, paramString, this.MSp.getAppId(), paramInt1, 3);
        this.MSr.alive();
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramp instanceof j))
      {
        com.tencent.mm.ui.base.k.cZ(this.mContext, this.mContext.getString(a.i.mall_product_submit_buy_free));
        gAz();
        AppMethodBeat.o(66970);
        return;
      }
      if ((paramp instanceof com.tencent.mm.plugin.product.model.f)) {
        try
        {
          this.mContext.dismissDialog(-10002);
          paramString = this.MSp;
          paramString.MQM = ((com.tencent.mm.plugin.product.model.f)paramp).MQM;
          paramString.afy(0);
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
      if (!(paramp instanceof com.tencent.mm.plugin.product.model.h)) {
        break label864;
      }
      try
      {
        this.mContext.dismissDialog(-10002);
        localObject2 = (com.tencent.mm.plugin.product.model.h)paramp;
        paramp = this.MSp;
        localObject1 = ((com.tencent.mm.plugin.product.model.h)localObject2).mUrl;
        localObject2 = ((com.tencent.mm.plugin.product.model.h)localObject2).MQX;
        if ((!Util.isNullOrNil((String)localObject1)) && (localObject2 != null) && (((LinkedList)localObject2).size() > 0))
        {
          if (paramp.MQQ == null) {
            paramp.MQQ = new HashMap();
          }
          paramp.MQQ.put(localObject1, localObject2);
        }
        if (this.MSq != null) {
          this.MSq.J(paramInt1, paramInt2, paramString);
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
      paramp = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramp = paramInt2 + " : " + this.mContext.getString(a.i.mall_product_data_err);
      }
      if (this.MSq != null) {
        this.MSq.J(paramInt1, paramInt2, paramp);
      }
      break;
    }
    label864:
    do
    {
      AppMethodBeat.o(66970);
      return;
      Log.i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
    } while (!(paramp instanceof g));
    paramp = (g)paramp;
    this.MSp.a(paramp.MQV, paramp.MQW);
    if (this.MSq != null) {
      this.MSq.J(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(66970);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(66966);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(553, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(554, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(555, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(556, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(557, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(578, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(579, this);
    AppMethodBeat.o(66966);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(66967);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(553, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(554, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(555, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(556, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(557, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(578, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(579, this);
    AppMethodBeat.o(66967);
  }
  
  public static abstract interface a
  {
    public abstract void J(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.f
 * JD-Core Version:    0.7.0.1
 */