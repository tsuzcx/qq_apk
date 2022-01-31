package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class b
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private bz.a kMG;
  private List<WeakReference<Object>> kkV;
  private ak mHandler;
  com.tencent.mm.plugin.order.model.b poF;
  private com.tencent.mm.plugin.order.b.b poG;
  private com.tencent.mm.plugin.order.model.c poH;
  private bz.a poI;
  
  static
  {
    AppMethodBeat.i(43738);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("ORDERCOMMONMSGXML_TABLE".hashCode()), new b.1());
    com.tencent.mm.wallet_core.a.h("ShowOrdersInfoProcess", a.class);
    AppMethodBeat.o(43738);
  }
  
  public b()
  {
    AppMethodBeat.i(43731);
    this.mHandler = new ak(Looper.getMainLooper());
    this.poF = null;
    this.poH = null;
    this.kkV = new ArrayList();
    this.poI = new b.2(this);
    this.kMG = new bz.a()
    {
      public final void a(final e.a paramAnonymousa)
      {
        AppMethodBeat.i(43730);
        final String str = aa.a(paramAnonymousa.eyJ.woR);
        ab.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:".concat(String.valueOf(str)));
        b.a(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(43729);
            Object localObject1 = b.can();
            Object localObject2 = str;
            Object localObject3 = paramAnonymousa.eyJ.pIE;
            j localj;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localj = com.tencent.mm.plugin.order.model.c.WG((String)localObject2);
              if (localj == null)
              {
                ab.i("MicroMsg.MallPayMsgManager", "payMsg == null");
                AppMethodBeat.o(43729);
                return;
              }
              if ((!TextUtils.isEmpty(localj.pqh)) || (!TextUtils.isEmpty(localj.pqy)) || (!TextUtils.isEmpty(localj.pqx)) || (!TextUtils.isEmpty(localj.cDI)) || (!TextUtils.isEmpty(localj.pqt)) || (!TextUtils.isEmpty(localj.pqu)) || (!TextUtils.isEmpty(localj.pqs)) || (!TextUtils.isEmpty(localj.pqw)) || (!TextUtils.isEmpty(localj.pqv)) || (!TextUtils.isEmpty(localj.pqr))) {
                if ((localj.pqr != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.pqr)))
                {
                  int i = Integer.valueOf(localj.pqr).intValue();
                  if ((i != 2) && (i != 1)) {}
                }
                else
                {
                  if (!TextUtils.isEmpty(localj.pqt)) {
                    break label452;
                  }
                  localj.cDC = ((String)localObject3);
                  ab.i("MicroMsg.MallPayMsgManager", "msgid: " + localj.cDC);
                  ab.i("MicroMsg.MallPayMsgManager", "msgType: " + localj.pqr);
                  if (((com.tencent.mm.plugin.order.model.c)localObject1).WI(localj.cDC)) {
                    break label481;
                  }
                  ((com.tencent.mm.plugin.order.model.c)localObject1).kmd.add(localj);
                  ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, "0");
                  label304:
                  ((com.tencent.mm.plugin.order.model.c)localObject1).car();
                  localObject1 = b.cak();
                  if (localj != null)
                  {
                    localObject2 = new blp();
                    if ((TextUtils.isEmpty(localj.pqt)) || (!com.tencent.mm.plugin.order.c.c.isNumeric(localj.pqt))) {
                      break label555;
                    }
                    ((blp)localObject2).CreateTime = Integer.valueOf(localj.pqt).intValue();
                  }
                }
              }
            }
            for (((blp)localObject2).pqc = Integer.valueOf(localj.pqt).intValue();; ((blp)localObject2).pqc = ((int)(System.currentTimeMillis() / 1000L)))
            {
              ((blp)localObject2).pqf = 100000;
              ((blp)localObject2).pqh = localj.pqh;
              ((blp)localObject2).ppY = localj.cDC;
              ((blp)localObject2).pqb = localj.pqv;
              ((blp)localObject2).xAm = -1;
              ((blp)localObject2).pqi = localj.pqs;
              ((blp)localObject2).pqj = localj.pqv;
              ((blp)localObject2).pqk = localj.cDI;
              ((b)localObject1).cal();
              AppMethodBeat.o(43729);
              return;
              label452:
              localj.cDC = ((String)localObject3 + localj.pqt);
              break;
              label481:
              ab.e("MicroMsg.MallPayMsgManager", "msg for id " + localj.cDC + " is exist!!");
              localObject3 = ((com.tencent.mm.plugin.order.model.c)localObject1).WK(localj.cDC);
              ((com.tencent.mm.plugin.order.model.c)localObject1).WH(localj.cDC);
              ((com.tencent.mm.plugin.order.model.c)localObject1).kmd.add(localj);
              ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, ((com.tencent.mm.plugin.order.b.a)localObject3).field_isRead);
              break label304;
              label555:
              ((blp)localObject2).CreateTime = ((int)(System.currentTimeMillis() / 1000L));
            }
          }
        });
        AppMethodBeat.o(43730);
      }
    };
    AppMethodBeat.o(43731);
  }
  
  public static String bMI()
  {
    AppMethodBeat.i(43737);
    if (g.RG())
    {
      String str = com.tencent.mm.plugin.i.c.YK() + "order";
      AppMethodBeat.o(43737);
      return str;
    }
    AppMethodBeat.o(43737);
    return "";
  }
  
  public static b cak()
  {
    AppMethodBeat.i(43732);
    b localb = (b)q.S(b.class);
    AppMethodBeat.o(43732);
    return localb;
  }
  
  public static com.tencent.mm.plugin.order.b.b cam()
  {
    AppMethodBeat.i(43735);
    g.RJ().QQ();
    if (cak().poG == null)
    {
      localObject = cak();
      g.RM();
      ((b)localObject).poG = new com.tencent.mm.plugin.order.b.b(g.RL().eHS);
    }
    Object localObject = cak().poG;
    AppMethodBeat.o(43735);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.order.model.c can()
  {
    AppMethodBeat.i(43736);
    g.RJ().QQ();
    if (cak().poH == null) {
      cak().poH = new com.tencent.mm.plugin.order.model.c();
    }
    com.tencent.mm.plugin.order.model.c localc = cak().poH;
    AppMethodBeat.o(43736);
    return localc;
  }
  
  public final void cal()
  {
    AppMethodBeat.i(43733);
    if (this.kkV == null)
    {
      AppMethodBeat.o(43733);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.kkV.get(i);
      if (localWeakReference != null) {
        localWeakReference.get();
      }
      i += 1;
    }
    AppMethodBeat.o(43733);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    this.poF = null;
    this.poH = null;
  }
  
  public void onAccountRelease() {}
  
  public final void onChange()
  {
    AppMethodBeat.i(43734);
    if (this.kkV == null)
    {
      AppMethodBeat.o(43734);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.kkV.get(i);
      if (localWeakReference != null) {
        localWeakReference.get();
      }
      i += 1;
    }
    AppMethodBeat.o(43734);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b
 * JD-Core Version:    0.7.0.1
 */