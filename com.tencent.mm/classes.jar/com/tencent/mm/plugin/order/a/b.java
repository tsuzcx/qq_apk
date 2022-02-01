package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storagebase.h.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class b
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ap mHandler;
  private cc.a nSR;
  private List<WeakReference<Object>> nqa;
  com.tencent.mm.plugin.order.model.b unF;
  private com.tencent.mm.plugin.order.b.b unG;
  private c unH;
  private cc.a unI;
  
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
    this.mHandler = new ap(Looper.getMainLooper());
    this.unF = null;
    this.unH = null;
    this.nqa = new ArrayList();
    this.unI = new cc.a()
    {
      public final void a(final f.a paramAnonymousa)
      {
        AppMethodBeat.i(66636);
        paramAnonymousa = z.a(paramAnonymousa.fTo.Cxz);
        ad.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:".concat(String.valueOf(paramAnonymousa)));
        b.a(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66635);
            Object localObject1 = b.this;
            g.afz().aeD();
            if (((b)localObject1).unF == null) {
              ((b)localObject1).unF = new com.tencent.mm.plugin.order.model.b();
            }
            localObject1 = ((b)localObject1).unF;
            Object localObject2 = paramAnonymousa;
            if (!bt.isNullOrNil((String)localObject2))
            {
              localObject2 = bw.K((String)localObject2, "sysmsg");
              if (localObject2 == null)
              {
                AppMethodBeat.o(66635);
                return;
              }
              try
              {
                localObject2 = (String)((Map)localObject2).get(".sysmsg.wxpay.transid");
                if (!bt.isNullOrNil((String)localObject2))
                {
                  ad.d("MicroMsg.WalletOrdersManager", "transid ".concat(String.valueOf(localObject2)));
                  if (!((com.tencent.mm.plugin.order.model.b)localObject1).unZ.contains(localObject2))
                  {
                    ((com.tencent.mm.plugin.order.model.b)localObject1).unZ.add(localObject2);
                    g.afC();
                    g.afB().afk().set(204817, Integer.valueOf(((com.tencent.mm.plugin.order.model.b)localObject1).unZ.size()));
                    ad.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + ((com.tencent.mm.plugin.order.model.b)localObject1).unZ.size());
                    ((com.tencent.mm.plugin.order.model.b)localObject1).dac();
                    b.cZY().onChange();
                  }
                }
                AppMethodBeat.o(66635);
                return;
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.WalletOrdersManager", "cmdid error");
              }
            }
            AppMethodBeat.o(66635);
          }
        });
        AppMethodBeat.o(66636);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.nSR = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(66638);
        String str = z.a(paramAnonymousa.fTo.Cxz);
        ad.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:".concat(String.valueOf(str)));
        b.a(b.this).post(new b.3.1(this, str, paramAnonymousa));
        AppMethodBeat.o(66638);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    AppMethodBeat.o(66639);
  }
  
  public static String cKR()
  {
    AppMethodBeat.i(66645);
    if (g.afw())
    {
      String str = d.apW() + "order";
      AppMethodBeat.o(66645);
      return str;
    }
    AppMethodBeat.o(66645);
    return "";
  }
  
  public static b cZY()
  {
    AppMethodBeat.i(66640);
    b localb = (b)t.ap(b.class);
    AppMethodBeat.o(66640);
    return localb;
  }
  
  public static com.tencent.mm.plugin.order.b.b daa()
  {
    AppMethodBeat.i(66643);
    g.afz().aeD();
    if (cZY().unG == null)
    {
      localObject = cZY();
      g.afC();
      ((b)localObject).unG = new com.tencent.mm.plugin.order.b.b(g.afB().gda);
    }
    Object localObject = cZY().unG;
    AppMethodBeat.o(66643);
    return localObject;
  }
  
  public static c dab()
  {
    AppMethodBeat.i(66644);
    g.afz().aeD();
    if (cZY().unH == null) {
      cZY().unH = new c();
    }
    c localc = cZY().unH;
    AppMethodBeat.o(66644);
    return localc;
  }
  
  public final void cZZ()
  {
    AppMethodBeat.i(66641);
    if (this.nqa == null)
    {
      AppMethodBeat.o(66641);
      return;
    }
    int i = 0;
    while (i < this.nqa.size())
    {
      WeakReference localWeakReference = (WeakReference)this.nqa.get(i);
      if (localWeakReference != null) {
        localWeakReference.get();
      }
      i += 1;
    }
    AppMethodBeat.o(66641);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    this.unF = null;
    this.unH = null;
  }
  
  public void onAccountRelease() {}
  
  public final void onChange()
  {
    AppMethodBeat.i(66642);
    if (this.nqa == null)
    {
      AppMethodBeat.o(66642);
      return;
    }
    int i = 0;
    while (i < this.nqa.size())
    {
      WeakReference localWeakReference = (WeakReference)this.nqa.get(i);
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