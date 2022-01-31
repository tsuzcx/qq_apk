package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.i;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f
  implements com.tencent.mm.ai.f
{
  static int mScene = 0;
  Activity gQx;
  boolean pvP;
  private boolean pvQ;
  com.tencent.mm.plugin.product.b.c pvR;
  private f.a pvS;
  private com.tencent.mm.sdk.b.c pvT;
  
  public f(Activity paramActivity, f.a parama)
  {
    AppMethodBeat.i(44060);
    this.pvP = false;
    this.pvQ = false;
    this.pvT = new f.3(this);
    this.gQx = paramActivity;
    com.tencent.mm.plugin.product.a.a.caT();
    this.pvR = com.tencent.mm.plugin.product.a.a.caU();
    this.pvS = parama;
    AppMethodBeat.o(44060);
  }
  
  private void cbu()
  {
    AppMethodBeat.i(44064);
    Object localObject = com.tencent.mm.plugin.product.a.a.caT().caV();
    bse localbse = this.pvR.cbb();
    if ((localbse != null) && (!bo.isNullOrNil(localbse.nqY)) && (!localbse.nqY.contains(";")))
    {
      ((d)localObject).puo.remove(localbse.nqY);
      ((d)localObject).puo.add(localbse.nqY);
      ((d)localObject).cbo();
    }
    localObject = new Intent(this.gQx, MallProductUI.class);
    ((Intent)localObject).putExtra("key_go_finish", true);
    ((Intent)localObject).addFlags(67108864);
    this.gQx.startActivity((Intent)localObject);
    AppMethodBeat.o(44064);
  }
  
  public final void cbt()
  {
    AppMethodBeat.i(44063);
    com.tencent.mm.plugin.product.b.m localm = this.pvR.ptU;
    cm localcm = new cm();
    acq localacq = new acq();
    acw localacw = new acw();
    acp localacp = new acp();
    localacw.aon(r.Zn());
    localacw.aoo(r.Zn());
    localacw.MR(11);
    localacw.nI(bo.aoy());
    localacp.aog(localm.puA.name);
    localacp.aoh(this.pvR.cbn());
    localacp.MO(localm.pux);
    localacp.aoj(this.pvR.a(localm));
    localacp.aoi(localm.cbp());
    localcm.cpR.title = localm.puA.name;
    localcm.cpR.desc = this.pvR.cbn();
    localcm.cpR.cpT = localacq;
    localcm.cpR.type = 11;
    localacq.a(localacw);
    localacq.b(localacp);
    localcm.cpR.activity = this.gQx;
    localcm.cpR.cpY = 5;
    com.tencent.mm.sdk.b.a.ymk.l(localcm);
    AppMethodBeat.o(44063);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(44066);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(44066);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        this.pvR.ak(paramIntent);
        if (this.pvS != null) {
          this.pvS.w(0, 0, "");
        }
        com.tencent.mm.kernel.g.RM();
        Object localObject = com.tencent.mm.kernel.g.RK().eHt;
        paramIntent = this.pvR;
        if (paramIntent.ptU != null) {}
        for (paramIntent = paramIntent.ptU.puw;; paramIntent = "")
        {
          ((p)localObject).a(new com.tencent.mm.plugin.product.b.g(paramIntent, this.pvR.ptW, this.pvR.puc), 0);
          AppMethodBeat.o(44066);
          return;
        }
        localObject = new vk();
        ((vk)localObject).cMA.result = paramInt1;
        ((vk)localObject).cMA.intent = paramIntent;
        this.pvT.callback((com.tencent.mm.sdk.b.b)localObject);
        AppMethodBeat.o(44066);
        return;
        if (this.pvS != null)
        {
          this.pvS.w(0, 0, "");
          AppMethodBeat.o(44066);
          return;
          this.gQx.showDialog(-10002);
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RK().eHt.a(new i(this.pvR.ptW, this.pvR.puf), 0);
          AppMethodBeat.o(44066);
          return;
          if ((paramInt2 == -1) && (paramIntent != null))
          {
            this.pvR.ak(paramIntent);
            com.tencent.mm.kernel.g.RM();
            com.tencent.mm.kernel.g.RK().eHt.a(new j(this.pvR.cbj(), mScene), 0);
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(44065);
    ab.d("MicroMsg.MallProductUI", "errCode: " + paramInt2 + ", errMsg: " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.product.b.h))
      {
        paramm = (com.tencent.mm.plugin.product.b.h)paramm;
        this.pvR.a(paramm.pus, paramm.put);
        if (this.pvS != null) {
          this.pvS.w(paramInt1, paramInt2, paramString);
        }
        if (!bo.isNullOrNil(paramm.pus.puw))
        {
          com.tencent.mm.plugin.report.service.h.qsU.e(11007, new Object[] { this.pvR.cbc(), paramm.pus.puw, Integer.valueOf(mScene), Integer.valueOf(1) });
          AppMethodBeat.o(44065);
          return;
        }
        com.tencent.mm.plugin.report.service.h.qsU.e(11007, new Object[] { this.pvR.cbc(), paramm.pur, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(44065);
        return;
      }
      Object localObject2;
      Object localObject1;
      if ((paramm instanceof j))
      {
        localObject2 = (j)paramm;
        paramString = this.pvR;
        paramm = ((j)localObject2).ptW;
        localObject1 = ((j)localObject2).puj;
        localObject2 = ((j)localObject2).puk;
        paramString.ptW = paramm;
        paramString.puk = ((LinkedList)localObject2);
        paramString.puj = ((LinkedList)localObject1);
        paramString.Bm(0);
        this.gQx.startActivity(new Intent(this.gQx, MallProductSubmitUI.class));
        com.tencent.mm.plugin.report.service.h.qsU.e(11009, new Object[] { this.pvR.cbc(), this.pvR.ptU.puw, Integer.valueOf(mScene), Integer.valueOf(1) });
        AppMethodBeat.o(44065);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.product.b.f)) {
        break label796;
      }
      if ((paramm instanceof l))
      {
        paramString = ((l)paramm).puv;
        paramInt1 = 6;
        if (mScene == 7) {
          paramInt1 = 1001;
        }
        ab.d("MicroMsg.MallProductUI", "payScene:".concat(String.valueOf(paramInt1)));
        com.tencent.mm.pluginsdk.wallet.h.a(this.gQx, paramString, this.pvR.getAppId(), paramInt1, 3);
        com.tencent.mm.sdk.b.a.ymk.c(this.pvT);
        AppMethodBeat.o(44065);
        return;
      }
      if ((paramm instanceof k))
      {
        com.tencent.mm.ui.base.h.bO(this.gQx, this.gQx.getString(2131301490));
        cbu();
        AppMethodBeat.o(44065);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.product.b.g)) {
        try
        {
          this.gQx.dismissDialog(-10002);
          paramString = this.pvR;
          paramString.puj = ((com.tencent.mm.plugin.product.b.g)paramm).puj;
          paramString.Bm(0);
          AppMethodBeat.o(44065);
          return;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ab.e("MicroMsg.MallProductUI", paramString.toString());
          }
        }
      }
      if (!(paramm instanceof i)) {
        break label796;
      }
      try
      {
        this.gQx.dismissDialog(-10002);
        localObject2 = (i)paramm;
        paramm = this.pvR;
        localObject1 = ((i)localObject2).mUrl;
        localObject2 = ((i)localObject2).puu;
        if ((!bo.isNullOrNil((String)localObject1)) && (localObject2 != null) && (((LinkedList)localObject2).size() > 0))
        {
          if (paramm.pun == null) {
            paramm.pun = new HashMap();
          }
          paramm.pun.put(localObject1, localObject2);
        }
        if (this.pvS != null) {
          this.pvS.w(paramInt1, paramInt2, paramString);
        }
        AppMethodBeat.o(44065);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.MallProductUI", localException.toString());
        }
      }
    }
    switch (paramInt2)
    {
    default: 
      ab.i("MicroMsg.MallProductUI", "unkown errCode ".concat(String.valueOf(paramInt2)));
      paramm = paramString;
      if (bo.isNullOrNil(paramString)) {
        paramm = paramInt2 + " : " + this.gQx.getString(2131301471);
      }
      if (this.pvS != null) {
        this.pvS.w(paramInt1, paramInt2, paramm);
      }
      break;
    }
    label796:
    do
    {
      AppMethodBeat.o(44065);
      return;
      ab.i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
    } while (!(paramm instanceof com.tencent.mm.plugin.product.b.h));
    paramm = (com.tencent.mm.plugin.product.b.h)paramm;
    this.pvR.a(paramm.pus, paramm.put);
    if (this.pvS != null) {
      this.pvS.w(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(44065);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(44061);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(553, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(554, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(555, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(556, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(557, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(578, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(579, this);
    AppMethodBeat.o(44061);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(44062);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(553, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(554, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(555, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(556, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(557, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(578, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(579, this);
    AppMethodBeat.o(44062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.f
 * JD-Core Version:    0.7.0.1
 */