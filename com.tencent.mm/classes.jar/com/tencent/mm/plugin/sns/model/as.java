package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.g.a.wz;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.LinkedList;

public final class as
{
  private static HashMap<String, b> zCZ;
  private static LinkedList<a> zDa;
  private static c zDb;
  
  static
  {
    AppMethodBeat.i(95951);
    zCZ = new HashMap();
    zDa = new LinkedList();
    zDb = new c() {};
    AppMethodBeat.o(95951);
  }
  
  private static boolean Nb()
  {
    AppMethodBeat.i(95933);
    if (!d.aJN("translate"))
    {
      AppMethodBeat.o(95933);
      return false;
    }
    String str = g.acL().getValue("TranslateSnsOff");
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(95933);
      return true;
    }
    if (bu.aSB(str) != 0)
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
    if (Nb())
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
    if ((paramb.eQZ & 0x2) != 0) {
      paramb.zDe = false;
    }
    for (;;)
    {
      zCZ.put(paramb.id, paramb);
      AppMethodBeat.o(95937);
      return;
      if ((paramb.eQZ & 0x4) != 0) {
        paramb.zDf = false;
      }
    }
  }
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(95940);
    if ((paramm != null) && (paramm.zyl != null))
    {
      String str = paramm.hFS;
      if (bu.isNullOrNil(str))
      {
        ae.i("MicroMsg.SnsTranslateManager", "commentContent is empty, quit translate");
        AppMethodBeat.o(95940);
        return;
      }
      Object localObject = new StringBuilder();
      if (paramm.zyl.HNk != 0) {}
      for (long l = paramm.zyl.HNk;; l = paramm.zyl.HNm)
      {
        localObject = l;
        paramm = jw(paramm.AgZ, (String)localObject);
        if (!zCZ.containsKey(paramm)) {
          break label190;
        }
        localObject = (b)zCZ.get(paramm);
        if ((!((b)localObject).hLB) || (bu.isNullOrNil(((b)localObject).result))) {
          break;
        }
        ae.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", new Object[] { paramm });
        j(((b)localObject).id, 2, ((b)localObject).result, ((b)localObject).hTy);
        AppMethodBeat.o(95940);
        return;
      }
      zCZ.remove(paramm);
      label190:
      localObject = new wz();
      ((wz)localObject).dMx.id = paramm;
      ((wz)localObject).dMx.dMy = str;
      ((wz)localObject).dMx.type = 3;
      a.IvT.l((b)localObject);
      fb(paramm, 2);
      localObject = new a((byte)0);
      ((a)localObject).id = paramm;
      ((a)localObject).zDc = str;
      ((a)localObject).type = 3;
      zDa.add(localObject);
      ae.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", new Object[] { ((a)localObject).id });
    }
    AppMethodBeat.o(95940);
  }
  
  public static b aAt(String paramString)
  {
    AppMethodBeat.i(95948);
    if (zCZ.containsKey(paramString))
    {
      paramString = (b)zCZ.get(paramString);
      AppMethodBeat.o(95948);
      return paramString;
    }
    AppMethodBeat.o(95948);
    return null;
  }
  
  public static void b(Menu paramMenu, boolean paramBoolean)
  {
    AppMethodBeat.i(95935);
    if (Nb())
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
    if ((paramb.eQZ & 0x2) != 0) {
      paramb.zDe = true;
    }
    for (;;)
    {
      zCZ.put(paramb.id, paramb);
      AppMethodBeat.o(95938);
      return;
      if ((paramb.eQZ & 0x4) != 0) {
        paramb.zDf = true;
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
      if (paramm.zyl.HNk == 0) {
        break label115;
      }
    }
    label115:
    for (long l = paramm.zyl.HNk;; l = paramm.zyl.HNm)
    {
      localObject = l;
      paramm = jw(paramm.AgZ, (String)localObject);
      b(aAt(paramm));
      localObject = new vl();
      ((vl)localObject).dKI.type = 2;
      ((vl)localObject).dKI.id = paramm;
      a.IvT.l((b)localObject);
      ae.d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", new Object[] { paramm });
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
      if ((paramb.eQZ & 0x2) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static HashMap<String, b> dYo()
  {
    return zCZ;
  }
  
  private static void fb(String paramString, int paramInt)
  {
    AppMethodBeat.i(95942);
    if (!zCZ.containsKey(paramString))
    {
      localObject = new b();
      ((b)localObject).id = paramString;
      ((b)localObject).hTy = null;
      ((b)localObject).result = null;
      ((b)localObject).hLB = false;
      ((b)localObject).aGQ = false;
      ((b)localObject).zDf = true;
      ((b)localObject).zDe = true;
      zCZ.put(paramString, localObject);
    }
    Object localObject = new vk();
    ((vk)localObject).dKH.type = paramInt;
    ((vk)localObject).dKH.id = paramString;
    a.IvT.l((b)localObject);
    AppMethodBeat.o(95942);
  }
  
  public static void fc(String paramString, int paramInt)
  {
    AppMethodBeat.i(95945);
    if (zCZ.containsKey(paramString))
    {
      b localb = (b)zCZ.get(paramString);
      localb.eQZ |= paramInt;
      zCZ.put(paramString, localb);
    }
    AppMethodBeat.o(95945);
  }
  
  public static void fd(String paramString, int paramInt)
  {
    AppMethodBeat.i(95946);
    if (zCZ.containsKey(paramString))
    {
      b localb = (b)zCZ.get(paramString);
      localb.eQZ &= (paramInt ^ 0xFFFFFFFF);
      if ((paramInt != 2) && (paramInt == 4)) {
        localb.zDf = true;
      }
      zCZ.put(paramString, localb);
    }
    AppMethodBeat.o(95946);
  }
  
  public static boolean fe(String paramString, int paramInt)
  {
    AppMethodBeat.i(95947);
    if (zCZ.containsKey(paramString))
    {
      if ((((b)zCZ.get(paramString)).eQZ & paramInt) != 0)
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
    a.IvT.c(zDb);
    AppMethodBeat.o(95931);
  }
  
  private static void j(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95943);
    if (zCZ.containsKey(paramString1))
    {
      localObject = (b)zCZ.get(paramString1);
      ((b)localObject).hTy = paramString3;
      ((b)localObject).result = paramString2;
      ((b)localObject).hLB = true;
      ((b)localObject).aGQ = bu.isNullOrNil(paramString2);
      zCZ.put(paramString1, localObject);
    }
    if (bu.isNullOrNil(paramString2)) {
      Toast.makeText(ak.getContext(), 2131764043, 1).show();
    }
    Object localObject = new vi();
    ((vi)localObject).dKE.type = paramInt;
    ((vi)localObject).dKE.id = paramString1;
    ((vi)localObject).dKE.result = paramString2;
    ((vi)localObject).dKE.dKF = paramString3;
    a.IvT.l((b)localObject);
    AppMethodBeat.o(95943);
  }
  
  public static String jw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95944);
    paramString1 = paramString1 + ";" + paramString2;
    AppMethodBeat.o(95944);
    return paramString1;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(95932);
    a.IvT.d(zDb);
    AppMethodBeat.o(95932);
  }
  
  public static void x(p paramp)
  {
    AppMethodBeat.i(95936);
    if (paramp != null)
    {
      String str = paramp.getSnsId();
      ae.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", new Object[] { str });
      if (paramp.field_snsId == 0L)
      {
        ae.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
        zCZ.remove(str);
        j(str, 1, null, null);
        AppMethodBeat.o(95936);
        return;
      }
      Object localObject;
      if (zCZ.containsKey(str))
      {
        localObject = (b)zCZ.get(str);
        if ((((b)localObject).hLB) && (!((b)localObject).aGQ))
        {
          ae.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", new Object[] { str });
          j(((b)localObject).id, 1, ((b)localObject).result, ((b)localObject).hTy);
          AppMethodBeat.o(95936);
          return;
        }
        zCZ.remove(str);
      }
      if (paramp.ebP() != null)
      {
        localObject = paramp.ebP().HUD;
        wz localwz = new wz();
        localwz.dMx.id = str;
        localwz.dMx.dMy = ((String)localObject);
        localwz.dMx.type = 2;
        a.IvT.l(localwz);
        fb(paramp.getSnsId(), 1);
        paramp = new a((byte)0);
        paramp.id = str;
        paramp.zDc = ((String)localObject);
        paramp.type = 2;
        zDa.add(paramp);
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
      b(aAt(paramp));
      vl localvl = new vl();
      localvl.dKI.type = 1;
      localvl.dKI.id = paramp;
      a.IvT.l(localvl);
      ae.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", new Object[] { paramp });
    }
    AppMethodBeat.o(95939);
  }
  
  static final class a
  {
    String dKF;
    String id;
    int type;
    String zDc;
    String zDd;
    
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
    public int eQZ;
    public boolean hLB;
    public String hTy;
    public String id;
    public String result;
    public boolean zDe;
    public boolean zDf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as
 * JD-Core Version:    0.7.0.1
 */