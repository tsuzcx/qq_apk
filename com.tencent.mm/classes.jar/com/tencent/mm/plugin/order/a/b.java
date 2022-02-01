package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storagebase.h.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class b
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  com.tencent.mm.plugin.order.model.b ANB;
  private com.tencent.mm.plugin.order.b.b ANC;
  private c AND;
  private cj.a ANE;
  private MMHandler mHandler;
  private List<WeakReference<Object>> pQG;
  private cj.a qvw;
  
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
    com.tencent.mm.wallet_core.a.j("ShowOrdersInfoProcess", a.class);
    AppMethodBeat.o(66646);
  }
  
  public b()
  {
    AppMethodBeat.i(66639);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.ANB = null;
    this.AND = null;
    this.pQG = new ArrayList();
    this.ANE = new cj.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(66636);
        paramAnonymousa = z.a(paramAnonymousa.heO.KHn);
        Log.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:".concat(String.valueOf(paramAnonymousa)));
        b.a(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66635);
            Object localObject1 = b.this;
            g.aAf().azk();
            if (((b)localObject1).ANB == null) {
              ((b)localObject1).ANB = new com.tencent.mm.plugin.order.model.b();
            }
            localObject1 = ((b)localObject1).ANB;
            Object localObject2 = paramAnonymousa;
            if (!Util.isNullOrNil((String)localObject2))
            {
              localObject2 = XmlParser.parseXml((String)localObject2, "sysmsg", null);
              if (localObject2 == null)
              {
                AppMethodBeat.o(66635);
                return;
              }
              try
              {
                localObject2 = (String)((Map)localObject2).get(".sysmsg.wxpay.transid");
                if (!Util.isNullOrNil((String)localObject2))
                {
                  Log.d("MicroMsg.WalletOrdersManager", "transid ".concat(String.valueOf(localObject2)));
                  if (!((com.tencent.mm.plugin.order.model.b)localObject1).ANV.contains(localObject2))
                  {
                    ((com.tencent.mm.plugin.order.model.b)localObject1).ANV.add(localObject2);
                    g.aAi();
                    g.aAh().azQ().set(204817, Integer.valueOf(((com.tencent.mm.plugin.order.model.b)localObject1).ANV.size()));
                    Log.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + ((com.tencent.mm.plugin.order.model.b)localObject1).ANV.size());
                    ((com.tencent.mm.plugin.order.model.b)localObject1).Yy();
                    b.eBa().onChange();
                  }
                }
                AppMethodBeat.o(66635);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.WalletOrdersManager", "cmdid error");
              }
            }
            AppMethodBeat.o(66635);
          }
        });
        AppMethodBeat.o(66636);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.qvw = new cj.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(66638);
        String str = z.a(paramAnonymousa.heO.KHn);
        Log.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:".concat(String.valueOf(str)));
        b.a(b.this).post(new b.3.1(this, str, paramAnonymousa));
        AppMethodBeat.o(66638);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    AppMethodBeat.o(66639);
  }
  
  public static b eBa()
  {
    AppMethodBeat.i(66640);
    b localb = (b)y.at(b.class);
    AppMethodBeat.o(66640);
    return localb;
  }
  
  public static com.tencent.mm.plugin.order.b.b eBc()
  {
    AppMethodBeat.i(66643);
    g.aAf().azk();
    if (eBa().ANC == null)
    {
      localObject = eBa();
      g.aAi();
      ((b)localObject).ANC = new com.tencent.mm.plugin.order.b.b(g.aAh().hqK);
    }
    Object localObject = eBa().ANC;
    AppMethodBeat.o(66643);
    return localObject;
  }
  
  public static c eBd()
  {
    AppMethodBeat.i(66644);
    g.aAf().azk();
    if (eBa().AND == null) {
      eBa().AND = new c();
    }
    c localc = eBa().AND;
    AppMethodBeat.o(66644);
    return localc;
  }
  
  public static String eeA()
  {
    AppMethodBeat.i(66645);
    if (g.aAc())
    {
      String str = d.aSY() + "order";
      AppMethodBeat.o(66645);
      return str;
    }
    AppMethodBeat.o(66645);
    return "";
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final void eBb()
  {
    AppMethodBeat.i(66641);
    if (this.pQG == null)
    {
      AppMethodBeat.o(66641);
      return;
    }
    int i = 0;
    while (i < this.pQG.size())
    {
      WeakReference localWeakReference = (WeakReference)this.pQG.get(i);
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
    this.ANB = null;
    this.AND = null;
  }
  
  public void onAccountRelease() {}
  
  public final void onChange()
  {
    AppMethodBeat.i(66642);
    if (this.pQG == null)
    {
      AppMethodBeat.o(66642);
      return;
    }
    int i = 0;
    while (i < this.pQG.size())
    {
      WeakReference localWeakReference = (WeakReference)this.pQG.get(i);
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