package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storagebase.h.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class b
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private aq mHandler;
  private List<WeakReference<Object>> oCX;
  private cf.a pgl;
  com.tencent.mm.plugin.order.model.b wRG;
  private com.tencent.mm.plugin.order.b.b wRH;
  private c wRI;
  private cf.a wRJ;
  
  static
  {
    AppMethodBeat.i(66646);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("ORDERCOMMONMSGXML_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.order.b.b.SQL_CREATE;
      }
    });
    com.tencent.mm.wallet_core.a.i("ShowOrdersInfoProcess", a.class);
    AppMethodBeat.o(66646);
  }
  
  public b()
  {
    AppMethodBeat.i(66639);
    this.mHandler = new aq(Looper.getMainLooper());
    this.wRG = null;
    this.wRI = null;
    this.oCX = new ArrayList();
    this.wRJ = new cf.a()
    {
      public final void a(final e.a paramAnonymousa)
      {
        AppMethodBeat.i(66636);
        paramAnonymousa = z.a(paramAnonymousa.gte.FNI);
        ae.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:".concat(String.valueOf(paramAnonymousa)));
        b.a(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66635);
            Object localObject1 = b.this;
            g.ajP().aiU();
            if (((b)localObject1).wRG == null) {
              ((b)localObject1).wRG = new com.tencent.mm.plugin.order.model.b();
            }
            localObject1 = ((b)localObject1).wRG;
            Object localObject2 = paramAnonymousa;
            if (!bu.isNullOrNil((String)localObject2))
            {
              localObject2 = bx.M((String)localObject2, "sysmsg");
              if (localObject2 == null)
              {
                AppMethodBeat.o(66635);
                return;
              }
              try
              {
                localObject2 = (String)((Map)localObject2).get(".sysmsg.wxpay.transid");
                if (!bu.isNullOrNil((String)localObject2))
                {
                  ae.d("MicroMsg.WalletOrdersManager", "transid ".concat(String.valueOf(localObject2)));
                  if (!((com.tencent.mm.plugin.order.model.b)localObject1).wSa.contains(localObject2))
                  {
                    ((com.tencent.mm.plugin.order.model.b)localObject1).wSa.add(localObject2);
                    g.ajS();
                    g.ajR().ajA().set(204817, Integer.valueOf(((com.tencent.mm.plugin.order.model.b)localObject1).wSa.size()));
                    ae.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + ((com.tencent.mm.plugin.order.model.b)localObject1).wSa.size());
                    ((com.tencent.mm.plugin.order.model.b)localObject1).dBs();
                    b.dBo().onChange();
                  }
                }
                AppMethodBeat.o(66635);
                return;
              }
              catch (Exception localException)
              {
                ae.e("MicroMsg.WalletOrdersManager", "cmdid error");
              }
            }
            AppMethodBeat.o(66635);
          }
        });
        AppMethodBeat.o(66636);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.pgl = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(66638);
        String str = z.a(paramAnonymousa.gte.FNI);
        ae.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:".concat(String.valueOf(str)));
        b.a(b.this).post(new b.3.1(this, str, paramAnonymousa));
        AppMethodBeat.o(66638);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    AppMethodBeat.o(66639);
  }
  
  public static b dBo()
  {
    AppMethodBeat.i(66640);
    b localb = (b)u.ap(b.class);
    AppMethodBeat.o(66640);
    return localb;
  }
  
  public static com.tencent.mm.plugin.order.b.b dBq()
  {
    AppMethodBeat.i(66643);
    g.ajP().aiU();
    if (dBo().wRH == null)
    {
      localObject = dBo();
      g.ajS();
      ((b)localObject).wRH = new com.tencent.mm.plugin.order.b.b(g.ajR().gDX);
    }
    Object localObject = dBo().wRH;
    AppMethodBeat.o(66643);
    return localObject;
  }
  
  public static c dBr()
  {
    AppMethodBeat.i(66644);
    g.ajP().aiU();
    if (dBo().wRI == null) {
      dBo().wRI = new c();
    }
    c localc = dBo().wRI;
    AppMethodBeat.o(66644);
    return localc;
  }
  
  public static String dkI()
  {
    AppMethodBeat.i(66645);
    if (g.ajM())
    {
      String str = d.azQ() + "order";
      AppMethodBeat.o(66645);
      return str;
    }
    AppMethodBeat.o(66645);
    return "";
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final void dBp()
  {
    AppMethodBeat.i(66641);
    if (this.oCX == null)
    {
      AppMethodBeat.o(66641);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      WeakReference localWeakReference = (WeakReference)this.oCX.get(i);
      if (localWeakReference != null) {
        localWeakReference.get();
      }
      i += 1;
    }
    AppMethodBeat.o(66641);
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    this.wRG = null;
    this.wRI = null;
  }
  
  public void onAccountRelease() {}
  
  public final void onChange()
  {
    AppMethodBeat.i(66642);
    if (this.oCX == null)
    {
      AppMethodBeat.o(66642);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      WeakReference localWeakReference = (WeakReference)this.oCX.get(i);
      if (localWeakReference != null) {
        localWeakReference.get();
      }
      i += 1;
    }
    AppMethodBeat.o(66642);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b
 * JD-Core Version:    0.7.0.1
 */