package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ve;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.g.a.vh;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.LinkedList;

public final class ar
{
  private static HashMap<String, b> zlK;
  private static LinkedList<a> zlL;
  private static c zlM;
  
  static
  {
    AppMethodBeat.i(95951);
    zlK = new HashMap();
    zlL = new LinkedList();
    zlM = new c() {};
    AppMethodBeat.o(95951);
  }
  
  private static boolean Ng()
  {
    AppMethodBeat.i(95933);
    if (!d.aIu("translate"))
    {
      AppMethodBeat.o(95933);
      return false;
    }
    String str = g.acA().getValue("TranslateSnsOff");
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(95933);
      return true;
    }
    if (bt.aRe(str) != 0)
    {
      AppMethodBeat.o(95933);
      return false;
    }
    AppMethodBeat.o(95933);
    return true;
  }
  
  public static void a(Menu paramMenu, boolean paramBoolean)
  {
    AppMethodBeat.i(95934);
    if (Ng())
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
    if ((paramb.ePo & 0x2) != 0) {
      paramb.zlP = false;
    }
    for (;;)
    {
      zlK.put(paramb.id, paramb);
      AppMethodBeat.o(95937);
      return;
      if ((paramb.ePo & 0x4) != 0) {
        paramb.zlQ = false;
      }
    }
  }
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(95940);
    if ((paramm != null) && (paramm.zhw != null))
    {
      String str = paramm.hDa;
      if (bt.isNullOrNil(str))
      {
        ad.i("MicroMsg.SnsTranslateManager", "commentContent is empty, quit translate");
        AppMethodBeat.o(95940);
        return;
      }
      Object localObject = new StringBuilder();
      if (paramm.zhw.HtH != 0) {}
      for (long l = paramm.zhw.HtH;; l = paramm.zhw.HtJ)
      {
        localObject = l;
        paramm = jp(paramm.zPS, (String)localObject);
        if (!zlK.containsKey(paramm)) {
          break label190;
        }
        localObject = (b)zlK.get(paramm);
        if ((!((b)localObject).hII) || (bt.isNullOrNil(((b)localObject).result))) {
          break;
        }
        ad.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", new Object[] { paramm });
        j(((b)localObject).id, 2, ((b)localObject).result, ((b)localObject).hQG);
        AppMethodBeat.o(95940);
        return;
      }
      zlK.remove(paramm);
      label190:
      localObject = new wv();
      ((wv)localObject).dLi.id = paramm;
      ((wv)localObject).dLi.dLj = str;
      ((wv)localObject).dLi.type = 3;
      a.IbL.l((b)localObject);
      eS(paramm, 2);
      localObject = new a((byte)0);
      ((a)localObject).id = paramm;
      ((a)localObject).zlN = str;
      ((a)localObject).type = 3;
      zlL.add(localObject);
      ad.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", new Object[] { ((a)localObject).id });
    }
    AppMethodBeat.o(95940);
  }
  
  public static b azc(String paramString)
  {
    AppMethodBeat.i(95948);
    if (zlK.containsKey(paramString))
    {
      paramString = (b)zlK.get(paramString);
      AppMethodBeat.o(95948);
      return paramString;
    }
    AppMethodBeat.o(95948);
    return null;
  }
  
  public static void b(Menu paramMenu, boolean paramBoolean)
  {
    AppMethodBeat.i(95935);
    if (Ng())
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
    if ((paramb.ePo & 0x2) != 0) {
      paramb.zlP = true;
    }
    for (;;)
    {
      zlK.put(paramb.id, paramb);
      AppMethodBeat.o(95938);
      return;
      if ((paramb.ePo & 0x4) != 0) {
        paramb.zlQ = true;
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
      if (paramm.zhw.HtH == 0) {
        break label115;
      }
    }
    label115:
    for (long l = paramm.zhw.HtH;; l = paramm.zhw.HtJ)
    {
      localObject = l;
      paramm = jp(paramm.zPS, (String)localObject);
      b(azc(paramm));
      localObject = new vh();
      ((vh)localObject).dJu.type = 2;
      ((vh)localObject).dJu.id = paramm;
      a.IbL.l((b)localObject);
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
      if ((paramb.ePo & 0x2) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static HashMap<String, b> dUO()
  {
    return zlK;
  }
  
  private static void eS(String paramString, int paramInt)
  {
    AppMethodBeat.i(95942);
    if (!zlK.containsKey(paramString))
    {
      localObject = new b();
      ((b)localObject).id = paramString;
      ((b)localObject).hQG = null;
      ((b)localObject).result = null;
      ((b)localObject).hII = false;
      ((b)localObject).aGQ = false;
      ((b)localObject).zlQ = true;
      ((b)localObject).zlP = true;
      zlK.put(paramString, localObject);
    }
    Object localObject = new vg();
    ((vg)localObject).dJt.type = paramInt;
    ((vg)localObject).dJt.id = paramString;
    a.IbL.l((b)localObject);
    AppMethodBeat.o(95942);
  }
  
  public static void eT(String paramString, int paramInt)
  {
    AppMethodBeat.i(95945);
    if (zlK.containsKey(paramString))
    {
      b localb = (b)zlK.get(paramString);
      localb.ePo |= paramInt;
      zlK.put(paramString, localb);
    }
    AppMethodBeat.o(95945);
  }
  
  public static void eU(String paramString, int paramInt)
  {
    AppMethodBeat.i(95946);
    if (zlK.containsKey(paramString))
    {
      b localb = (b)zlK.get(paramString);
      localb.ePo &= (paramInt ^ 0xFFFFFFFF);
      if ((paramInt != 2) && (paramInt == 4)) {
        localb.zlQ = true;
      }
      zlK.put(paramString, localb);
    }
    AppMethodBeat.o(95946);
  }
  
  public static boolean eV(String paramString, int paramInt)
  {
    AppMethodBeat.i(95947);
    if (zlK.containsKey(paramString))
    {
      if ((((b)zlK.get(paramString)).ePo & paramInt) != 0)
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
  
  public static void init()
  {
    AppMethodBeat.i(95931);
    a.IbL.c(zlM);
    AppMethodBeat.o(95931);
  }
  
  private static void j(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95943);
    if (zlK.containsKey(paramString1))
    {
      localObject = (b)zlK.get(paramString1);
      ((b)localObject).hQG = paramString3;
      ((b)localObject).result = paramString2;
      ((b)localObject).hII = true;
      ((b)localObject).aGQ = bt.isNullOrNil(paramString2);
      zlK.put(paramString1, localObject);
    }
    if (bt.isNullOrNil(paramString2)) {
      Toast.makeText(aj.getContext(), 2131764043, 1).show();
    }
    Object localObject = new ve();
    ((ve)localObject).dJq.type = paramInt;
    ((ve)localObject).dJq.id = paramString1;
    ((ve)localObject).dJq.result = paramString2;
    ((ve)localObject).dJq.dJr = paramString3;
    a.IbL.l((b)localObject);
    AppMethodBeat.o(95943);
  }
  
  public static String jp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95944);
    paramString1 = paramString1 + ";" + paramString2;
    AppMethodBeat.o(95944);
    return paramString1;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(95932);
    a.IbL.d(zlM);
    AppMethodBeat.o(95932);
  }
  
  public static void x(p paramp)
  {
    AppMethodBeat.i(95936);
    if (paramp != null)
    {
      String str = paramp.getSnsId();
      ad.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", new Object[] { str });
      if (paramp.field_snsId == 0L)
      {
        ad.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
        zlK.remove(str);
        j(str, 1, null, null);
        AppMethodBeat.o(95936);
        return;
      }
      Object localObject;
      if (zlK.containsKey(str))
      {
        localObject = (b)zlK.get(str);
        if ((((b)localObject).hII) && (!((b)localObject).aGQ))
        {
          ad.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", new Object[] { str });
          j(((b)localObject).id, 1, ((b)localObject).result, ((b)localObject).hQG);
          AppMethodBeat.o(95936);
          return;
        }
        zlK.remove(str);
      }
      if (paramp.dYl() != null)
      {
        localObject = paramp.dYl().HAQ;
        wv localwv = new wv();
        localwv.dLi.id = str;
        localwv.dLi.dLj = ((String)localObject);
        localwv.dLi.type = 2;
        a.IbL.l(localwv);
        eS(paramp.getSnsId(), 1);
        paramp = new a((byte)0);
        paramp.id = str;
        paramp.zlN = ((String)localObject);
        paramp.type = 2;
        zlL.add(paramp);
      }
    }
    AppMethodBeat.o(95936);
  }
  
  public static void y(p paramp)
  {
    AppMethodBeat.i(95939);
    if (paramp != null)
    {
      paramp = paramp.getSnsId();
      b(azc(paramp));
      vh localvh = new vh();
      localvh.dJu.type = 1;
      localvh.dJu.id = paramp;
      a.IbL.l(localvh);
      ad.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", new Object[] { paramp });
    }
    AppMethodBeat.o(95939);
  }
  
  static final class a
  {
    String dJr;
    String id;
    int type;
    String zlN;
    String zlO;
    
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
    public boolean aGQ;
    public int ePo;
    public boolean hII;
    public String hQG;
    public String id;
    public String result;
    public boolean zlP;
    public boolean zlQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar
 * JD-Core Version:    0.7.0.1
 */