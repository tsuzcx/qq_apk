package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.g.a.ue;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.LinkedList;

public final class ap
{
  private static HashMap<String, b> wJg;
  private static LinkedList<a> wJh;
  private static c wJi;
  
  static
  {
    AppMethodBeat.i(95951);
    wJg = new HashMap();
    wJh = new LinkedList();
    wJi = new c() {};
    AppMethodBeat.o(95951);
  }
  
  private static boolean LA()
  {
    AppMethodBeat.i(95933);
    if (!d.axB("translate"))
    {
      AppMethodBeat.o(95933);
      return false;
    }
    String str = g.Zd().getValue("TranslateSnsOff");
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(95933);
      return true;
    }
    if (bt.aGh(str) != 0)
    {
      AppMethodBeat.o(95933);
      return false;
    }
    AppMethodBeat.o(95933);
    return true;
  }
  
  public static void NX()
  {
    AppMethodBeat.i(95932);
    a.ESL.d(wJi);
    AppMethodBeat.o(95932);
  }
  
  public static void a(Menu paramMenu, boolean paramBoolean)
  {
    AppMethodBeat.i(95934);
    if (LA())
    {
      if (paramBoolean)
      {
        paramMenu.add(0, 14, 0, 2131764042);
        AppMethodBeat.o(95934);
        return;
      }
      paramMenu.add(0, 15, 0, 2131764042);
    }
    AppMethodBeat.o(95934);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(95937);
    if ((paramb.evt & 0x2) != 0) {
      paramb.wJl = false;
    }
    for (;;)
    {
      wJg.put(paramb.id, paramb);
      AppMethodBeat.o(95937);
      return;
      if ((paramb.evt & 0x4) != 0) {
        paramb.wJm = false;
      }
    }
  }
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(95940);
    if ((paramm != null) && (paramm.wFh != null))
    {
      String str = paramm.gKr;
      if (bt.isNullOrNil(str))
      {
        ad.i("MicroMsg.SnsTranslateManager", "commentContent is empty, quit translate");
        AppMethodBeat.o(95940);
        return;
      }
      Object localObject = new StringBuilder();
      if (paramm.wFh.Ema != 0) {}
      for (long l = paramm.wFh.Ema;; l = paramm.wFh.Emc)
      {
        localObject = l;
        paramm = iG(paramm.xlP, (String)localObject);
        if (!wJg.containsKey(paramm)) {
          break label190;
        }
        localObject = (b)wJg.get(paramm);
        if ((!((b)localObject).gPQ) || (bt.isNullOrNil(((b)localObject).result))) {
          break;
        }
        ad.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", new Object[] { paramm });
        f(((b)localObject).id, 2, ((b)localObject).result, ((b)localObject).gXN);
        AppMethodBeat.o(95940);
        return;
      }
      wJg.remove(paramm);
      label190:
      localObject = new vr();
      ((vr)localObject).dBi.id = paramm;
      ((vr)localObject).dBi.dBj = str;
      ((vr)localObject).dBi.type = 3;
      a.ESL.l((b)localObject);
      es(paramm, 2);
      localObject = new a((byte)0);
      ((a)localObject).id = paramm;
      ((a)localObject).wJj = str;
      ((a)localObject).type = 3;
      wJh.add(localObject);
      ad.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", new Object[] { ((a)localObject).id });
    }
    AppMethodBeat.o(95940);
  }
  
  public static b aoL(String paramString)
  {
    AppMethodBeat.i(95948);
    if (wJg.containsKey(paramString))
    {
      paramString = (b)wJg.get(paramString);
      AppMethodBeat.o(95948);
      return paramString;
    }
    AppMethodBeat.o(95948);
    return null;
  }
  
  public static void b(Menu paramMenu, boolean paramBoolean)
  {
    AppMethodBeat.i(95935);
    if (LA())
    {
      if (paramBoolean)
      {
        paramMenu.add(0, 16, 0, 2131764044);
        AppMethodBeat.o(95935);
        return;
      }
      paramMenu.add(0, 17, 0, 2131764044);
    }
    AppMethodBeat.o(95935);
  }
  
  private static void b(b paramb)
  {
    AppMethodBeat.i(95938);
    if ((paramb.evt & 0x2) != 0) {
      paramb.wJl = true;
    }
    for (;;)
    {
      wJg.put(paramb.id, paramb);
      AppMethodBeat.o(95938);
      return;
      if ((paramb.evt & 0x4) != 0) {
        paramb.wJm = true;
      }
    }
  }
  
  public static void b(m paramm)
  {
    AppMethodBeat.i(95941);
    Object localObject;
    if (paramm != null)
    {
      localObject = new StringBuilder();
      if (paramm.wFh.Ema == 0) {
        break label115;
      }
    }
    label115:
    for (long l = paramm.wFh.Ema;; l = paramm.wFh.Emc)
    {
      localObject = l;
      paramm = iG(paramm.xlP, (String)localObject);
      b(aoL(paramm));
      localObject = new ue();
      ((ue)localObject).dzw.type = 2;
      ((ue)localObject).dzw.id = paramm;
      a.ESL.l((b)localObject);
      ad.d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", new Object[] { paramm });
      AppMethodBeat.o(95941);
      return;
    }
  }
  
  public static boolean c(b paramb)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramb != null)
    {
      bool1 = bool2;
      if ((paramb.evt & 0x2) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static HashMap<String, b> dub()
  {
    return wJg;
  }
  
  private static void es(String paramString, int paramInt)
  {
    AppMethodBeat.i(95942);
    if (!wJg.containsKey(paramString))
    {
      localObject = new b();
      ((b)localObject).id = paramString;
      ((b)localObject).gXN = null;
      ((b)localObject).result = null;
      ((b)localObject).gPQ = false;
      ((b)localObject).aEj = false;
      ((b)localObject).wJm = true;
      ((b)localObject).wJl = true;
      wJg.put(paramString, localObject);
    }
    Object localObject = new ud();
    ((ud)localObject).dzv.type = paramInt;
    ((ud)localObject).dzv.id = paramString;
    a.ESL.l((b)localObject);
    AppMethodBeat.o(95942);
  }
  
  public static void et(String paramString, int paramInt)
  {
    AppMethodBeat.i(95945);
    if (wJg.containsKey(paramString))
    {
      b localb = (b)wJg.get(paramString);
      localb.evt |= paramInt;
      wJg.put(paramString, localb);
    }
    AppMethodBeat.o(95945);
  }
  
  public static void eu(String paramString, int paramInt)
  {
    AppMethodBeat.i(95946);
    if (wJg.containsKey(paramString))
    {
      b localb = (b)wJg.get(paramString);
      localb.evt &= (paramInt ^ 0xFFFFFFFF);
      if ((paramInt != 2) && (paramInt == 4)) {
        localb.wJm = true;
      }
      wJg.put(paramString, localb);
    }
    AppMethodBeat.o(95946);
  }
  
  public static boolean ev(String paramString, int paramInt)
  {
    AppMethodBeat.i(95947);
    if (wJg.containsKey(paramString))
    {
      if ((((b)wJg.get(paramString)).evt & paramInt) != 0)
      {
        AppMethodBeat.o(95947);
        return true;
      }
      AppMethodBeat.o(95947);
      return false;
    }
    AppMethodBeat.o(95947);
    return false;
  }
  
  private static void f(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95943);
    if (wJg.containsKey(paramString1))
    {
      localObject = (b)wJg.get(paramString1);
      ((b)localObject).gXN = paramString3;
      ((b)localObject).result = paramString2;
      ((b)localObject).gPQ = true;
      ((b)localObject).aEj = bt.isNullOrNil(paramString2);
      wJg.put(paramString1, localObject);
    }
    if (bt.isNullOrNil(paramString2)) {
      Toast.makeText(aj.getContext(), 2131764043, 1).show();
    }
    Object localObject = new ub();
    ((ub)localObject).dzs.type = paramInt;
    ((ub)localObject).dzs.id = paramString1;
    ((ub)localObject).dzs.result = paramString2;
    ((ub)localObject).dzs.dzt = paramString3;
    a.ESL.l((b)localObject);
    AppMethodBeat.o(95943);
  }
  
  public static String iG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95944);
    paramString1 = paramString1 + ";" + paramString2;
    AppMethodBeat.o(95944);
    return paramString1;
  }
  
  public static void init()
  {
    AppMethodBeat.i(95931);
    a.ESL.c(wJi);
    AppMethodBeat.o(95931);
  }
  
  public static void u(p paramp)
  {
    AppMethodBeat.i(95936);
    if (paramp != null)
    {
      String str = paramp.getSnsId();
      ad.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", new Object[] { str });
      if (paramp.field_snsId == 0L)
      {
        ad.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
        wJg.remove(str);
        f(str, 1, null, null);
        AppMethodBeat.o(95936);
        return;
      }
      Object localObject;
      if (wJg.containsKey(str))
      {
        localObject = (b)wJg.get(str);
        if ((((b)localObject).gPQ) && (!((b)localObject).aEj))
        {
          ad.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", new Object[] { str });
          f(((b)localObject).id, 1, ((b)localObject).result, ((b)localObject).gXN);
          AppMethodBeat.o(95936);
          return;
        }
        wJg.remove(str);
      }
      if (paramp.dxy() != null)
      {
        localObject = paramp.dxy().Etj;
        vr localvr = new vr();
        localvr.dBi.id = str;
        localvr.dBi.dBj = ((String)localObject);
        localvr.dBi.type = 2;
        a.ESL.l(localvr);
        es(paramp.getSnsId(), 1);
        paramp = new a((byte)0);
        paramp.id = str;
        paramp.wJj = ((String)localObject);
        paramp.type = 2;
        wJh.add(paramp);
      }
    }
    AppMethodBeat.o(95936);
  }
  
  public static void v(p paramp)
  {
    AppMethodBeat.i(95939);
    if (paramp != null)
    {
      paramp = paramp.getSnsId();
      b(aoL(paramp));
      ue localue = new ue();
      localue.dzw.type = 1;
      localue.dzw.id = paramp;
      a.ESL.l(localue);
      ad.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", new Object[] { paramp });
    }
    AppMethodBeat.o(95939);
  }
  
  static final class a
  {
    String dzt;
    String id;
    int type;
    String wJj;
    String wJk;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(95930);
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.id.equals(paramObject.id)) && (this.type == paramObject.type))
        {
          AppMethodBeat.o(95930);
          return true;
        }
        AppMethodBeat.o(95930);
        return false;
      }
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(95930);
      return bool;
    }
  }
  
  public static final class b
  {
    public boolean aEj;
    public int evt;
    public boolean gPQ;
    public String gXN;
    public String id;
    public String result;
    public boolean wJl;
    public boolean wJm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ap
 * JD-Core Version:    0.7.0.1
 */