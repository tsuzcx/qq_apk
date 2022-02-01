package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storagebase.h.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class b
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ap mHandler;
  private cd.a oZH;
  private List<WeakReference<Object>> owv;
  com.tencent.mm.plugin.order.model.b wBV;
  private com.tencent.mm.plugin.order.b.b wBW;
  private c wBX;
  private cd.a wBY;
  
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
    this.wBV = null;
    this.wBX = null;
    this.owv = new ArrayList();
    this.wBY = new cd.a()
    {
      public final void a(final e.a paramAnonymousa)
      {
        AppMethodBeat.i(66636);
        paramAnonymousa = z.a(paramAnonymousa.gqE.Fvk);
        ad.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:".concat(String.valueOf(paramAnonymousa)));
        b.a(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66635);
            Object localObject1 = b.this;
            g.ajA().aiF();
            if (((b)localObject1).wBV == null) {
              ((b)localObject1).wBV = new com.tencent.mm.plugin.order.model.b();
            }
            localObject1 = ((b)localObject1).wBV;
            Object localObject2 = paramAnonymousa;
            if (!bt.isNullOrNil((String)localObject2))
            {
              localObject2 = bw.M((String)localObject2, "sysmsg");
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
                  if (!((com.tencent.mm.plugin.order.model.b)localObject1).wCp.contains(localObject2))
                  {
                    ((com.tencent.mm.plugin.order.model.b)localObject1).wCp.add(localObject2);
                    g.ajD();
                    g.ajC().ajl().set(204817, Integer.valueOf(((com.tencent.mm.plugin.order.model.b)localObject1).wCp.size()));
                    ad.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + ((com.tencent.mm.plugin.order.model.b)localObject1).wCp.size());
                    ((com.tencent.mm.plugin.order.model.b)localObject1).dyc();
                    b.dxY().onChange();
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
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.oZH = new cd.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(66638);
        String str = z.a(paramAnonymousa.gqE.Fvk);
        ad.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:".concat(String.valueOf(str)));
        b.a(b.this).post(new b.3.1(this, str, paramAnonymousa));
        AppMethodBeat.o(66638);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    AppMethodBeat.o(66639);
  }
  
  public static String dhJ()
  {
    AppMethodBeat.i(66645);
    if (g.ajx())
    {
      String str = d.azA() + "order";
      AppMethodBeat.o(66645);
      return str;
    }
    AppMethodBeat.o(66645);
    return "";
  }
  
  public static b dxY()
  {
    AppMethodBeat.i(66640);
    b localb = (b)t.ap(b.class);
    AppMethodBeat.o(66640);
    return localb;
  }
  
  public static com.tencent.mm.plugin.order.b.b dya()
  {
    AppMethodBeat.i(66643);
    g.ajA().aiF();
    if (dxY().wBW == null)
    {
      localObject = dxY();
      g.ajD();
      ((b)localObject).wBW = new com.tencent.mm.plugin.order.b.b(g.ajC().gBq);
    }
    Object localObject = dxY().wBW;
    AppMethodBeat.o(66643);
    return localObject;
  }
  
  public static c dyb()
  {
    AppMethodBeat.i(66644);
    g.ajA().aiF();
    if (dxY().wBX == null) {
      dxY().wBX = new c();
    }
    c localc = dxY().wBX;
    AppMethodBeat.o(66644);
    return localc;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final void dxZ()
  {
    AppMethodBeat.i(66641);
    if (this.owv == null)
    {
      AppMethodBeat.o(66641);
      return;
    }
    int i = 0;
    while (i < this.owv.size())
    {
      WeakReference localWeakReference = (WeakReference)this.owv.get(i);
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
    this.wBV = null;
    this.wBX = null;
  }
  
  public void onAccountRelease() {}
  
  public final void onChange()
  {
    AppMethodBeat.i(66642);
    if (this.owv == null)
    {
      AppMethodBeat.o(66642);
      return;
    }
    int i = 0;
    while (i < this.owv.size())
    {
      WeakReference localWeakReference = (WeakReference)this.owv.get(i);
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