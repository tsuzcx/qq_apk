package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.qv;
import com.tencent.mm.h.a.qw;
import com.tencent.mm.h.a.qx;
import com.tencent.mm.h.a.sc;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;

public final class ap
{
  private static HashMap<String, ap.b> otC = new HashMap();
  private static LinkedList<ap.a> otD = new LinkedList();
  private static c otE = new ap.1();
  
  public static ap.b NJ(String paramString)
  {
    if (otC.containsKey(paramString)) {
      return (ap.b)otC.get(paramString);
    }
    return null;
  }
  
  public static void Vt()
  {
    a.udP.d(otE);
  }
  
  public static void a(Menu paramMenu, boolean paramBoolean)
  {
    if (tx())
    {
      if (paramBoolean) {
        paramMenu.add(0, 14, 0, i.j.sns_translate);
      }
    }
    else {
      return;
    }
    paramMenu.add(0, 15, 0, i.j.sns_translate);
  }
  
  public static void a(ap.b paramb)
  {
    if ((paramb.cCu & 0x2) != 0) {
      paramb.otH = false;
    }
    for (;;)
    {
      otC.put(paramb.id, paramb);
      return;
      if ((paramb.cCu & 0x4) != 0) {
        paramb.otI = false;
      }
    }
  }
  
  public static void a(l paraml)
  {
    String str;
    if ((paraml != null) && (paraml.oqc != null))
    {
      str = paraml.kVs;
      if (bk.bl(str)) {
        y.i("MicroMsg.SnsTranslateManager", "commentContent is empty, quit translate");
      }
    }
    else
    {
      return;
    }
    Object localObject = new StringBuilder();
    if (paraml.oqc.tJu != 0) {}
    for (long l = paraml.oqc.tJu;; l = paraml.oqc.tJx)
    {
      localObject = l;
      paraml = eK(paraml.oOn, (String)localObject);
      if (!otC.containsKey(paraml)) {
        break label175;
      }
      localObject = (ap.b)otC.get(paraml);
      if ((!((ap.b)localObject).dYj) || (bk.bl(((ap.b)localObject).result))) {
        break;
      }
      y.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", new Object[] { paraml });
      f(((ap.b)localObject).id, 2, ((ap.b)localObject).result, ((ap.b)localObject).egI);
      return;
    }
    otC.remove(paraml);
    label175:
    localObject = new sc();
    ((sc)localObject).cbJ.id = paraml;
    ((sc)localObject).cbJ.cbK = str;
    ((sc)localObject).cbJ.type = 3;
    a.udP.m((b)localObject);
    co(paraml, 2);
    localObject = new ap.a((byte)0);
    ((ap.a)localObject).id = paraml;
    ((ap.a)localObject).otF = str;
    ((ap.a)localObject).type = 3;
    otD.add(localObject);
    y.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", new Object[] { ((ap.a)localObject).id });
  }
  
  public static void b(Menu paramMenu, boolean paramBoolean)
  {
    if (tx())
    {
      if (paramBoolean) {
        paramMenu.add(0, 16, 0, i.j.sns_translate_original);
      }
    }
    else {
      return;
    }
    paramMenu.add(0, 17, 0, i.j.sns_translate_original);
  }
  
  private static void b(ap.b paramb)
  {
    if ((paramb.cCu & 0x2) != 0) {
      paramb.otH = true;
    }
    for (;;)
    {
      otC.put(paramb.id, paramb);
      return;
      if ((paramb.cCu & 0x4) != 0) {
        paramb.otI = true;
      }
    }
  }
  
  public static void b(l paraml)
  {
    Object localObject;
    if (paraml != null)
    {
      localObject = new StringBuilder();
      if (paraml.oqc.tJu == 0) {
        break label104;
      }
    }
    label104:
    for (long l = paraml.oqc.tJu;; l = paraml.oqc.tJx)
    {
      localObject = l;
      paraml = eK(paraml.oOn, (String)localObject);
      b(NJ(paraml));
      localObject = new qx();
      ((qx)localObject).caf.type = 2;
      ((qx)localObject).caf.id = paraml;
      a.udP.m((b)localObject);
      y.d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", new Object[] { paraml });
      return;
    }
  }
  
  public static HashMap<String, ap.b> bEi()
  {
    return otC;
  }
  
  public static boolean c(ap.b paramb)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramb != null)
    {
      bool1 = bool2;
      if ((paramb.cCu & 0x2) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static void co(String paramString, int paramInt)
  {
    if (!otC.containsKey(paramString))
    {
      localObject = new ap.b();
      ((ap.b)localObject).id = paramString;
      ((ap.b)localObject).egI = null;
      ((ap.b)localObject).result = null;
      ((ap.b)localObject).dYj = false;
      ((ap.b)localObject).ebE = false;
      ((ap.b)localObject).otI = true;
      ((ap.b)localObject).otH = true;
      otC.put(paramString, localObject);
    }
    Object localObject = new qw();
    ((qw)localObject).cae.type = paramInt;
    ((qw)localObject).cae.id = paramString;
    a.udP.m((b)localObject);
  }
  
  public static void cp(String paramString, int paramInt)
  {
    if (otC.containsKey(paramString))
    {
      ap.b localb = (ap.b)otC.get(paramString);
      localb.cCu |= paramInt;
      otC.put(paramString, localb);
    }
  }
  
  public static void cq(String paramString, int paramInt)
  {
    if (otC.containsKey(paramString))
    {
      ap.b localb = (ap.b)otC.get(paramString);
      localb.cCu &= (paramInt ^ 0xFFFFFFFF);
      if ((paramInt != 2) && (paramInt == 4)) {
        localb.otI = true;
      }
      otC.put(paramString, localb);
    }
  }
  
  public static boolean cr(String paramString, int paramInt)
  {
    if (otC.containsKey(paramString)) {
      return (((ap.b)otC.get(paramString)).cCu & paramInt) != 0;
    }
    return false;
  }
  
  public static String eK(String paramString1, String paramString2)
  {
    return paramString1 + ";" + paramString2;
  }
  
  private static void f(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (otC.containsKey(paramString1))
    {
      localObject = (ap.b)otC.get(paramString1);
      ((ap.b)localObject).egI = paramString3;
      ((ap.b)localObject).result = paramString2;
      ((ap.b)localObject).dYj = true;
      ((ap.b)localObject).ebE = bk.bl(paramString2);
      otC.put(paramString1, localObject);
    }
    if (bk.bl(paramString2)) {
      Toast.makeText(ae.getContext(), i.j.sns_translate_failed, 1).show();
    }
    Object localObject = new qv();
    ((qv)localObject).cac.type = paramInt;
    ((qv)localObject).cac.id = paramString1;
    ((qv)localObject).cac.result = paramString2;
    ((qv)localObject).cac.cad = paramString3;
    a.udP.m((b)localObject);
  }
  
  public static void init()
  {
    a.udP.c(otE);
  }
  
  public static void r(n paramn)
  {
    String str;
    if (paramn != null)
    {
      str = paramn.bGk();
      y.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", new Object[] { str });
      if (paramn.field_snsId != 0L) {
        break label58;
      }
      y.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
      otC.remove(str);
      f(str, 1, null, null);
    }
    label58:
    do
    {
      return;
      if (otC.containsKey(str))
      {
        localObject = (ap.b)otC.get(str);
        if ((((ap.b)localObject).dYj) && (!((ap.b)localObject).ebE))
        {
          y.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", new Object[] { str });
          f(((ap.b)localObject).id, 1, ((ap.b)localObject).result, ((ap.b)localObject).egI);
          return;
        }
        otC.remove(str);
      }
    } while (paramn.bGe() == null);
    Object localObject = paramn.bGe().tNo;
    sc localsc = new sc();
    localsc.cbJ.id = str;
    localsc.cbJ.cbK = ((String)localObject);
    localsc.cbJ.type = 2;
    a.udP.m(localsc);
    co(paramn.bGk(), 1);
    paramn = new ap.a((byte)0);
    paramn.id = str;
    paramn.otF = ((String)localObject);
    paramn.type = 2;
    otD.add(paramn);
  }
  
  public static void s(n paramn)
  {
    if (paramn != null)
    {
      paramn = paramn.bGk();
      b(NJ(paramn));
      qx localqx = new qx();
      localqx.caf.type = 1;
      localqx.caf.id = paramn;
      a.udP.m(localqx);
      y.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", new Object[] { paramn });
    }
  }
  
  private static boolean tx()
  {
    if (!d.SP("translate")) {}
    String str;
    do
    {
      return false;
      str = g.AA().getValue("TranslateSnsOff");
      if (bk.bl(str)) {
        return true;
      }
    } while (bk.ZR(str) != 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ap
 * JD-Core Version:    0.7.0.1
 */