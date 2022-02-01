package com.tencent.mm.plugin.welab.e;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.z.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final b Eys;
  public Map<String, Integer> ExN;
  public String tag;
  
  static
  {
    AppMethodBeat.i(146307);
    Eys = new b();
    AppMethodBeat.o(146307);
  }
  
  private b()
  {
    AppMethodBeat.i(146299);
    this.ExN = new HashMap();
    this.tag = "";
    eWE();
    AppMethodBeat.o(146299);
  }
  
  private boolean aJX(String paramString)
  {
    AppMethodBeat.i(146302);
    if ((this.ExN.containsKey(paramString)) && (((Integer)this.ExN.get(paramString)).intValue() == 1))
    {
      AppMethodBeat.o(146302);
      return true;
    }
    AppMethodBeat.o(146302);
    return false;
  }
  
  public static b eWD()
  {
    return Eys;
  }
  
  private void eWE()
  {
    AppMethodBeat.i(146300);
    this.tag = ((String)g.ajC().ajl().get(al.a.Izt, null));
    ad.i("WeLabRedPointMgr", "load red tag " + this.tag);
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
            this.ExN.put(localObject[0], Integer.valueOf(bt.aRe(localObject[1])));
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(146300);
  }
  
  public static void eWF()
  {
    AppMethodBeat.i(146304);
    Object localObject = com.tencent.mm.plugin.welab.a.eWo().eWp();
    if ((localObject != null) && (((List)localObject).isEmpty())) {}
    localObject = ((List)localObject).iterator();
    com.tencent.mm.plugin.welab.d.a.a locala;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      locala = (com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next();
    } while ((locala == null) || (!Eys.e(locala)));
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        c.aht().cK(266267, 266241);
      }
      AppMethodBeat.o(146304);
      return;
    }
  }
  
  public static boolean eWG()
  {
    AppMethodBeat.i(146305);
    boolean bool = c.aht().cJ(266267, 266241);
    AppMethodBeat.o(146305);
    return bool;
  }
  
  public static boolean eWH()
  {
    AppMethodBeat.i(146306);
    boolean bool = aj.fkD().getBoolean("key_has_enter_welab", false);
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
    if (aJX(parama.field_LabsAppId))
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
    if ((parama.field_RedPoint == 1) && (!aJX(parama.field_LabsAppId)) && (parama.eWx())) {
      c.aht().x(266267, true);
    }
    AppMethodBeat.o(146303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e.b
 * JD-Core Version:    0.7.0.1
 */