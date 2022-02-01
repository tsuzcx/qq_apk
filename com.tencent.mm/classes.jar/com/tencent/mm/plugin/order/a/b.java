package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
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
  com.tencent.mm.plugin.order.model.b MDG;
  private com.tencent.mm.plugin.order.b.b MDH;
  private c MDI;
  private cl.a MDJ;
  private List<WeakReference<Object>> eNV;
  private MMHandler mHandler;
  private cl.a wXR;
  
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
    com.tencent.mm.wallet_core.a.n("ShowOrdersInfoProcess", a.class);
    AppMethodBeat.o(66646);
  }
  
  public b()
  {
    AppMethodBeat.i(66639);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.MDG = null;
    this.MDI = null;
    this.eNV = new ArrayList();
    this.MDJ = new cl.a()
    {
      public final void a(final g.a paramAnonymousa)
      {
        AppMethodBeat.i(66636);
        paramAnonymousa = w.a(paramAnonymousa.mpN.YFG);
        Log.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:".concat(String.valueOf(paramAnonymousa)));
        b.a(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66635);
            Object localObject1 = b.this;
            h.baC().aZJ();
            if (((b)localObject1).MDG == null) {
              ((b)localObject1).MDG = new com.tencent.mm.plugin.order.model.b();
            }
            localObject1 = ((b)localObject1).MDG;
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
                  if (!((com.tencent.mm.plugin.order.model.b)localObject1).MEa.contains(localObject2))
                  {
                    ((com.tencent.mm.plugin.order.model.b)localObject1).MEa.add(localObject2);
                    h.baF();
                    h.baE().ban().B(204817, Integer.valueOf(((com.tencent.mm.plugin.order.model.b)localObject1).MEa.size()));
                    Log.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + ((com.tencent.mm.plugin.order.model.b)localObject1).MEa.size());
                    ((com.tencent.mm.plugin.order.model.b)localObject1).aFe();
                    b.gxv().onChange();
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
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.wXR = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(66638);
        String str = w.a(paramAnonymousa.mpN.YFG);
        Log.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:".concat(String.valueOf(str)));
        b.a(b.this).post(new b.3.1(this, str, paramAnonymousa));
        AppMethodBeat.o(66638);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    AppMethodBeat.o(66639);
  }
  
  public static String fWo()
  {
    AppMethodBeat.i(66645);
    if (h.baz())
    {
      String str = d.bzL() + "order";
      AppMethodBeat.o(66645);
      return str;
    }
    AppMethodBeat.o(66645);
    return "";
  }
  
  public static b gxv()
  {
    AppMethodBeat.i(66640);
    b localb = (b)y.aL(b.class);
    AppMethodBeat.o(66640);
    return localb;
  }
  
  public static com.tencent.mm.plugin.order.b.b gxx()
  {
    AppMethodBeat.i(66643);
    h.baC().aZJ();
    if (gxv().MDH == null)
    {
      localObject = gxv();
      h.baF();
      ((b)localObject).MDH = new com.tencent.mm.plugin.order.b.b(h.baE().mCN);
    }
    Object localObject = gxv().MDH;
    AppMethodBeat.o(66643);
    return localObject;
  }
  
  public static c gxy()
  {
    AppMethodBeat.i(66644);
    h.baC().aZJ();
    if (gxv().MDI == null) {
      gxv().MDI = new c();
    }
    c localc = gxv().MDI;
    AppMethodBeat.o(66644);
    return localc;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void gxw()
  {
    AppMethodBeat.i(66641);
    if (this.eNV == null)
    {
      AppMethodBeat.o(66641);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.eNV.get(i);
      if (localWeakReference != null) {
        localWeakReference.get();
      }
      i += 1;
    }
    AppMethodBeat.o(66641);
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    this.MDG = null;
    this.MDI = null;
  }
  
  public void onAccountRelease() {}
  
  public final void onChange()
  {
    AppMethodBeat.i(66642);
    if (this.eNV == null)
    {
      AppMethodBeat.o(66642);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.eNV.get(i);
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