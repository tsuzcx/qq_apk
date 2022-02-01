package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.protocal.protobuf.db;
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
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  com.tencent.mm.plugin.order.model.b GGP;
  private com.tencent.mm.plugin.order.b.b GGQ;
  private c GGR;
  private ck.a GGS;
  private List<WeakReference<Object>> cSF;
  private MMHandler mHandler;
  private ck.a tUv;
  
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
    this.GGP = null;
    this.GGR = null;
    this.cSF = new ArrayList();
    this.GGS = new ck.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(66636);
        paramAnonymousa = z.a(paramAnonymousa.jQG.RIF);
        Log.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:".concat(String.valueOf(paramAnonymousa)));
        b.a(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66635);
            Object localObject1 = b.this;
            h.aHE().aGH();
            if (((b)localObject1).GGP == null) {
              ((b)localObject1).GGP = new com.tencent.mm.plugin.order.model.b();
            }
            localObject1 = ((b)localObject1).GGP;
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
                  if (!((com.tencent.mm.plugin.order.model.b)localObject1).GHj.contains(localObject2))
                  {
                    ((com.tencent.mm.plugin.order.model.b)localObject1).GHj.add(localObject2);
                    h.aHH();
                    h.aHG().aHp().i(204817, Integer.valueOf(((com.tencent.mm.plugin.order.model.b)localObject1).GHj.size()));
                    Log.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + ((com.tencent.mm.plugin.order.model.b)localObject1).GHj.size());
                    ((com.tencent.mm.plugin.order.model.b)localObject1).adf();
                    b.fmH().onChange();
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
    this.tUv = new ck.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(66638);
        String str = z.a(paramAnonymousa.jQG.RIF);
        Log.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:".concat(String.valueOf(str)));
        b.a(b.this).post(new b.3.1(this, str, paramAnonymousa));
        AppMethodBeat.o(66638);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    AppMethodBeat.o(66639);
  }
  
  public static String eNV()
  {
    AppMethodBeat.i(66645);
    if (h.aHB())
    {
      String str = d.bbW() + "order";
      AppMethodBeat.o(66645);
      return str;
    }
    AppMethodBeat.o(66645);
    return "";
  }
  
  public static b fmH()
  {
    AppMethodBeat.i(66640);
    b localb = (b)y.as(b.class);
    AppMethodBeat.o(66640);
    return localb;
  }
  
  public static com.tencent.mm.plugin.order.b.b fmJ()
  {
    AppMethodBeat.i(66643);
    h.aHE().aGH();
    if (fmH().GGQ == null)
    {
      localObject = fmH();
      h.aHH();
      ((b)localObject).GGQ = new com.tencent.mm.plugin.order.b.b(h.aHG().kcF);
    }
    Object localObject = fmH().GGQ;
    AppMethodBeat.o(66643);
    return localObject;
  }
  
  public static c fmK()
  {
    AppMethodBeat.i(66644);
    h.aHE().aGH();
    if (fmH().GGR == null) {
      fmH().GGR = new c();
    }
    c localc = fmH().GGR;
    AppMethodBeat.o(66644);
    return localc;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final void fmI()
  {
    AppMethodBeat.i(66641);
    if (this.cSF == null)
    {
      AppMethodBeat.o(66641);
      return;
    }
    int i = 0;
    while (i < this.cSF.size())
    {
      WeakReference localWeakReference = (WeakReference)this.cSF.get(i);
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
    this.GGP = null;
    this.GGR = null;
  }
  
  public void onAccountRelease() {}
  
  public final void onChange()
  {
    AppMethodBeat.i(66642);
    if (this.cSF == null)
    {
      AppMethodBeat.o(66642);
      return;
    }
    int i = 0;
    while (i < this.cSF.size())
    {
      WeakReference localWeakReference = (WeakReference)this.cSF.get(i);
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