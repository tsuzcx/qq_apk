package com.tencent.mm.plugin.welab.e;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.y.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final b EQO;
  public Map<String, Integer> EQj;
  public String tag;
  
  static
  {
    AppMethodBeat.i(146307);
    EQO = new b();
    AppMethodBeat.o(146307);
  }
  
  private b()
  {
    AppMethodBeat.i(146299);
    this.EQj = new HashMap();
    this.tag = "";
    faq();
    AppMethodBeat.o(146299);
  }
  
  private boolean aLt(String paramString)
  {
    AppMethodBeat.i(146302);
    if ((this.EQj.containsKey(paramString)) && (((Integer)this.EQj.get(paramString)).intValue() == 1))
    {
      AppMethodBeat.o(146302);
      return true;
    }
    AppMethodBeat.o(146302);
    return false;
  }
  
  public static b fap()
  {
    return EQO;
  }
  
  private void faq()
  {
    AppMethodBeat.i(146300);
    this.tag = ((String)g.ajR().ajA().get(am.a.ITS, null));
    ae.i("WeLabRedPointMgr", "load red tag " + this.tag);
    if (!TextUtils.isEmpty(this.tag))
    {
      String[] arrayOfString = this.tag.split("&");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfString[i];
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("=");
          if ((localObject != null) && (localObject.length == 2)) {
            this.EQj.put(localObject[0], Integer.valueOf(bu.aSB(localObject[1])));
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(146300);
  }
  
  public static void far()
  {
    AppMethodBeat.i(146304);
    Object localObject = com.tencent.mm.plugin.welab.a.faa().fab();
    if ((localObject != null) && (((List)localObject).isEmpty())) {}
    localObject = ((List)localObject).iterator();
    com.tencent.mm.plugin.welab.d.a.a locala;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      locala = (com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next();
    } while ((locala == null) || (!EQO.e(locala)));
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        c.ahI().cK(266267, 266241);
      }
      AppMethodBeat.o(146304);
      return;
    }
  }
  
  public static boolean fas()
  {
    AppMethodBeat.i(146305);
    boolean bool = c.ahI().cJ(266267, 266241);
    AppMethodBeat.o(146305);
    return bool;
  }
  
  public static boolean fat()
  {
    AppMethodBeat.i(146306);
    boolean bool = ak.fox().getBoolean("key_has_enter_welab", false);
    AppMethodBeat.o(146306);
    return bool;
  }
  
  public final boolean e(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(146301);
    if ((parama.field_RedPoint != 1) || (parama.isOffline()))
    {
      AppMethodBeat.o(146301);
      return false;
    }
    if (aLt(parama.field_LabsAppId))
    {
      AppMethodBeat.o(146301);
      return false;
    }
    AppMethodBeat.o(146301);
    return true;
  }
  
  public final void f(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(146303);
    if ((parama.field_RedPoint == 1) && (!aLt(parama.field_LabsAppId)) && (parama.faj())) {
      c.ahI().x(266267, true);
    }
    AppMethodBeat.o(146303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e.b
 * JD-Core Version:    0.7.0.1
 */