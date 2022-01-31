package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.g.a.si;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;

public final class aq
{
  private static HashMap<String, aq.b> riu;
  private static LinkedList<aq.a> riv;
  private static c riw;
  
  static
  {
    AppMethodBeat.i(36633);
    riu = new HashMap();
    riv = new LinkedList();
    riw = new aq.1();
    AppMethodBeat.o(36633);
  }
  
  private static boolean Cc()
  {
    AppMethodBeat.i(36615);
    if (!d.ahR("translate"))
    {
      AppMethodBeat.o(36615);
      return false;
    }
    String str = g.Nq().getValue("TranslateSnsOff");
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(36615);
      return true;
    }
    if (bo.apV(str) != 0)
    {
      AppMethodBeat.o(36615);
      return false;
    }
    AppMethodBeat.o(36615);
    return true;
  }
  
  public static void a(Menu paramMenu, boolean paramBoolean)
  {
    AppMethodBeat.i(36616);
    if (Cc())
    {
      if (paramBoolean)
      {
        paramMenu.add(0, 14, 0, 2131304025);
        AppMethodBeat.o(36616);
        return;
      }
      paramMenu.add(0, 15, 0, 2131304025);
    }
    AppMethodBeat.o(36616);
  }
  
  public static void a(aq.b paramb)
  {
    AppMethodBeat.i(36619);
    if ((paramb.dqG & 0x2) != 0) {
      paramb.riz = false;
    }
    for (;;)
    {
      riu.put(paramb.id, paramb);
      AppMethodBeat.o(36619);
      return;
      if ((paramb.dqG & 0x4) != 0) {
        paramb.riA = false;
      }
    }
  }
  
  public static void a(l paraml)
  {
    AppMethodBeat.i(36622);
    if ((paraml != null) && (paraml.reJ != null))
    {
      String str = paraml.ntu;
      if (bo.isNullOrNil(str))
      {
        ab.i("MicroMsg.SnsTranslateManager", "commentContent is empty, quit translate");
        AppMethodBeat.o(36622);
        return;
      }
      Object localObject = new StringBuilder();
      if (paraml.reJ.xNY != 0) {}
      for (long l = paraml.reJ.xNY;; l = paraml.reJ.xOa)
      {
        localObject = l;
        paraml = gm(paraml.rFY, (String)localObject);
        if (!riu.containsKey(paraml)) {
          break label190;
        }
        localObject = (aq.b)riu.get(paraml);
        if ((!((aq.b)localObject).fon) || (bo.isNullOrNil(((aq.b)localObject).result))) {
          break;
        }
        ab.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", new Object[] { paraml });
        f(((aq.b)localObject).id, 2, ((aq.b)localObject).result, ((aq.b)localObject).fwM);
        AppMethodBeat.o(36622);
        return;
      }
      riu.remove(paraml);
      label190:
      localObject = new tt();
      ((tt)localObject).cKm.id = paraml;
      ((tt)localObject).cKm.cKn = str;
      ((tt)localObject).cKm.type = 3;
      a.ymk.l((b)localObject);
      dk(paraml, 2);
      localObject = new aq.a((byte)0);
      ((aq.a)localObject).id = paraml;
      ((aq.a)localObject).rix = str;
      ((aq.a)localObject).type = 3;
      riv.add(localObject);
      ab.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", new Object[] { ((aq.a)localObject).id });
    }
    AppMethodBeat.o(36622);
  }
  
  public static aq.b aaD(String paramString)
  {
    AppMethodBeat.i(36630);
    if (riu.containsKey(paramString))
    {
      paramString = (aq.b)riu.get(paramString);
      AppMethodBeat.o(36630);
      return paramString;
    }
    AppMethodBeat.o(36630);
    return null;
  }
  
  public static void aoR()
  {
    AppMethodBeat.i(36614);
    a.ymk.d(riw);
    AppMethodBeat.o(36614);
  }
  
  public static void b(Menu paramMenu, boolean paramBoolean)
  {
    AppMethodBeat.i(36617);
    if (Cc())
    {
      if (paramBoolean)
      {
        paramMenu.add(0, 16, 0, 2131304027);
        AppMethodBeat.o(36617);
        return;
      }
      paramMenu.add(0, 17, 0, 2131304027);
    }
    AppMethodBeat.o(36617);
  }
  
  private static void b(aq.b paramb)
  {
    AppMethodBeat.i(36620);
    if ((paramb.dqG & 0x2) != 0) {
      paramb.riz = true;
    }
    for (;;)
    {
      riu.put(paramb.id, paramb);
      AppMethodBeat.o(36620);
      return;
      if ((paramb.dqG & 0x4) != 0) {
        paramb.riA = true;
      }
    }
  }
  
  public static void b(l paraml)
  {
    AppMethodBeat.i(36623);
    Object localObject;
    if (paraml != null)
    {
      localObject = new StringBuilder();
      if (paraml.reJ.xNY == 0) {
        break label115;
      }
    }
    label115:
    for (long l = paraml.reJ.xNY;; l = paraml.reJ.xOa)
    {
      localObject = l;
      paraml = gm(paraml.rFY, (String)localObject);
      b(aaD(paraml));
      localObject = new sj();
      ((sj)localObject).cIF.type = 2;
      ((sj)localObject).cIF.id = paraml;
      a.ymk.l((b)localObject);
      ab.d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", new Object[] { paraml });
      AppMethodBeat.o(36623);
      return;
    }
  }
  
  public static boolean c(aq.b paramb)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramb != null)
    {
      bool1 = bool2;
      if ((paramb.dqG & 0x2) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static HashMap<String, aq.b> cpH()
  {
    return riu;
  }
  
  private static void dk(String paramString, int paramInt)
  {
    AppMethodBeat.i(36624);
    if (!riu.containsKey(paramString))
    {
      localObject = new aq.b();
      ((aq.b)localObject).id = paramString;
      ((aq.b)localObject).fwM = null;
      ((aq.b)localObject).result = null;
      ((aq.b)localObject).fon = false;
      ((aq.b)localObject).frX = false;
      ((aq.b)localObject).riA = true;
      ((aq.b)localObject).riz = true;
      riu.put(paramString, localObject);
    }
    Object localObject = new si();
    ((si)localObject).cIE.type = paramInt;
    ((si)localObject).cIE.id = paramString;
    a.ymk.l((b)localObject);
    AppMethodBeat.o(36624);
  }
  
  public static void dl(String paramString, int paramInt)
  {
    AppMethodBeat.i(36627);
    if (riu.containsKey(paramString))
    {
      aq.b localb = (aq.b)riu.get(paramString);
      localb.dqG |= paramInt;
      riu.put(paramString, localb);
    }
    AppMethodBeat.o(36627);
  }
  
  public static void dm(String paramString, int paramInt)
  {
    AppMethodBeat.i(36628);
    if (riu.containsKey(paramString))
    {
      aq.b localb = (aq.b)riu.get(paramString);
      localb.dqG &= (paramInt ^ 0xFFFFFFFF);
      if ((paramInt != 2) && (paramInt == 4)) {
        localb.riA = true;
      }
      riu.put(paramString, localb);
    }
    AppMethodBeat.o(36628);
  }
  
  public static boolean dn(String paramString, int paramInt)
  {
    AppMethodBeat.i(36629);
    if (riu.containsKey(paramString))
    {
      if ((((aq.b)riu.get(paramString)).dqG & paramInt) != 0)
      {
        AppMethodBeat.o(36629);
        return true;
      }
      AppMethodBeat.o(36629);
      return false;
    }
    AppMethodBeat.o(36629);
    return false;
  }
  
  private static void f(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36625);
    if (riu.containsKey(paramString1))
    {
      localObject = (aq.b)riu.get(paramString1);
      ((aq.b)localObject).fwM = paramString3;
      ((aq.b)localObject).result = paramString2;
      ((aq.b)localObject).fon = true;
      ((aq.b)localObject).frX = bo.isNullOrNil(paramString2);
      riu.put(paramString1, localObject);
    }
    if (bo.isNullOrNil(paramString2)) {
      Toast.makeText(ah.getContext(), 2131304026, 1).show();
    }
    Object localObject = new sh();
    ((sh)localObject).cIC.type = paramInt;
    ((sh)localObject).cIC.id = paramString1;
    ((sh)localObject).cIC.result = paramString2;
    ((sh)localObject).cIC.cID = paramString3;
    a.ymk.l((b)localObject);
    AppMethodBeat.o(36625);
  }
  
  public static String gm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(36626);
    paramString1 = paramString1 + ";" + paramString2;
    AppMethodBeat.o(36626);
    return paramString1;
  }
  
  public static void init()
  {
    AppMethodBeat.i(36613);
    a.ymk.c(riw);
    AppMethodBeat.o(36613);
  }
  
  public static void r(n paramn)
  {
    AppMethodBeat.i(36618);
    if (paramn != null)
    {
      String str = paramn.getSnsId();
      ab.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", new Object[] { str });
      if (paramn.field_snsId == 0L)
      {
        ab.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
        riu.remove(str);
        f(str, 1, null, null);
        AppMethodBeat.o(36618);
        return;
      }
      Object localObject;
      if (riu.containsKey(str))
      {
        localObject = (aq.b)riu.get(str);
        if ((((aq.b)localObject).fon) && (!((aq.b)localObject).frX))
        {
          ab.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", new Object[] { str });
          f(((aq.b)localObject).id, 1, ((aq.b)localObject).result, ((aq.b)localObject).fwM);
          AppMethodBeat.o(36618);
          return;
        }
        riu.remove(str);
      }
      if (paramn.csh() != null)
      {
        localObject = paramn.csh().xTP;
        tt localtt = new tt();
        localtt.cKm.id = str;
        localtt.cKm.cKn = ((String)localObject);
        localtt.cKm.type = 2;
        a.ymk.l(localtt);
        dk(paramn.getSnsId(), 1);
        paramn = new aq.a((byte)0);
        paramn.id = str;
        paramn.rix = ((String)localObject);
        paramn.type = 2;
        riv.add(paramn);
      }
    }
    AppMethodBeat.o(36618);
  }
  
  public static void s(n paramn)
  {
    AppMethodBeat.i(36621);
    if (paramn != null)
    {
      paramn = paramn.getSnsId();
      b(aaD(paramn));
      sj localsj = new sj();
      localsj.cIF.type = 1;
      localsj.cIF.id = paramn;
      a.ymk.l(localsj);
      ab.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", new Object[] { paramn });
    }
    AppMethodBeat.o(36621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aq
 * JD-Core Version:    0.7.0.1
 */