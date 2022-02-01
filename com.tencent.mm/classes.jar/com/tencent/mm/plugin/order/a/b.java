package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
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
  private ao mHandler;
  private List<WeakReference<Object>> nTa;
  private cc.a owm;
  com.tencent.mm.plugin.order.model.b vwB;
  private com.tencent.mm.plugin.order.b.b vwC;
  private c vwD;
  private cc.a vwE;
  
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
    this.mHandler = new ao(Looper.getMainLooper());
    this.vwB = null;
    this.vwD = null;
    this.nTa = new ArrayList();
    this.vwE = new cc.a()
    {
      public final void a(final f.a paramAnonymousa)
      {
        AppMethodBeat.i(66636);
        paramAnonymousa = z.a(paramAnonymousa.fXi.DPV);
        ac.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:".concat(String.valueOf(paramAnonymousa)));
        b.a(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66635);
            Object localObject1 = b.this;
            g.agP().afT();
            if (((b)localObject1).vwB == null) {
              ((b)localObject1).vwB = new com.tencent.mm.plugin.order.model.b();
            }
            localObject1 = ((b)localObject1).vwB;
            Object localObject2 = paramAnonymousa;
            if (!bs.isNullOrNil((String)localObject2))
            {
              localObject2 = bv.L((String)localObject2, "sysmsg");
              if (localObject2 == null)
              {
                AppMethodBeat.o(66635);
                return;
              }
              try
              {
                localObject2 = (String)((Map)localObject2).get(".sysmsg.wxpay.transid");
                if (!bs.isNullOrNil((String)localObject2))
                {
                  ac.d("MicroMsg.WalletOrdersManager", "transid ".concat(String.valueOf(localObject2)));
                  if (!((com.tencent.mm.plugin.order.model.b)localObject1).vwV.contains(localObject2))
                  {
                    ((com.tencent.mm.plugin.order.model.b)localObject1).vwV.add(localObject2);
                    g.agS();
                    g.agR().agA().set(204817, Integer.valueOf(((com.tencent.mm.plugin.order.model.b)localObject1).vwV.size()));
                    ac.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + ((com.tencent.mm.plugin.order.model.b)localObject1).vwV.size());
                    ((com.tencent.mm.plugin.order.model.b)localObject1).dnK();
                    b.dnG().onChange();
                  }
                }
                AppMethodBeat.o(66635);
                return;
              }
              catch (Exception localException)
              {
                ac.e("MicroMsg.WalletOrdersManager", "cmdid error");
              }
            }
            AppMethodBeat.o(66635);
          }
        });
        AppMethodBeat.o(66636);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.owm = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(66638);
        String str = z.a(paramAnonymousa.fXi.DPV);
        ac.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:".concat(String.valueOf(str)));
        b.a(b.this).post(new b.3.1(this, str, paramAnonymousa));
        AppMethodBeat.o(66638);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    AppMethodBeat.o(66639);
  }
  
  public static String cYx()
  {
    AppMethodBeat.i(66645);
    if (g.agM())
    {
      String str = d.awL() + "order";
      AppMethodBeat.o(66645);
      return str;
    }
    AppMethodBeat.o(66645);
    return "";
  }
  
  public static b dnG()
  {
    AppMethodBeat.i(66640);
    b localb = (b)t.ap(b.class);
    AppMethodBeat.o(66640);
    return localb;
  }
  
  public static com.tencent.mm.plugin.order.b.b dnI()
  {
    AppMethodBeat.i(66643);
    g.agP().afT();
    if (dnG().vwC == null)
    {
      localObject = dnG();
      g.agS();
      ((b)localObject).vwC = new com.tencent.mm.plugin.order.b.b(g.agR().ghG);
    }
    Object localObject = dnG().vwC;
    AppMethodBeat.o(66643);
    return localObject;
  }
  
  public static c dnJ()
  {
    AppMethodBeat.i(66644);
    g.agP().afT();
    if (dnG().vwD == null) {
      dnG().vwD = new c();
    }
    c localc = dnG().vwD;
    AppMethodBeat.o(66644);
    return localc;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final void dnH()
  {
    AppMethodBeat.i(66641);
    if (this.nTa == null)
    {
      AppMethodBeat.o(66641);
      return;
    }
    int i = 0;
    while (i < this.nTa.size())
    {
      WeakReference localWeakReference = (WeakReference)this.nTa.get(i);
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
    this.vwB = null;
    this.vwD = null;
  }
  
  public void onAccountRelease() {}
  
  public final void onChange()
  {
    AppMethodBeat.i(66642);
    if (this.nTa == null)
    {
      AppMethodBeat.o(66642);
      return;
    }
    int i = 0;
    while (i < this.nTa.size())
    {
      WeakReference localWeakReference = (WeakReference)this.nTa.get(i);
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