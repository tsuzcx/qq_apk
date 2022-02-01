package com.tencent.mm.plugin.welab.e;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final b Xzq;
  public Map<String, Integer> XyG;
  public String tag;
  
  static
  {
    AppMethodBeat.i(146307);
    Xzq = new b();
    AppMethodBeat.o(146307);
  }
  
  private b()
  {
    AppMethodBeat.i(146299);
    this.XyG = new HashMap();
    this.tag = "";
    iDP();
    AppMethodBeat.o(146299);
  }
  
  private boolean bnx(String paramString)
  {
    AppMethodBeat.i(146302);
    if ((this.XyG.containsKey(paramString)) && (((Integer)this.XyG.get(paramString)).intValue() == 1))
    {
      AppMethodBeat.o(146302);
      return true;
    }
    AppMethodBeat.o(146302);
    return false;
  }
  
  public static b iDO()
  {
    return Xzq;
  }
  
  private void iDP()
  {
    AppMethodBeat.i(146300);
    this.tag = ((String)h.baE().ban().get(at.a.acRL, null));
    Log.i("WeLabRedPointMgr", "load red tag " + this.tag);
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
            this.XyG.put(localObject[0], Integer.valueOf(Util.safeParseInt(localObject[1])));
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(146300);
  }
  
  public static void iDQ()
  {
    AppMethodBeat.i(146304);
    Object localObject = com.tencent.mm.plugin.welab.b.iDA().iDB();
    if ((localObject != null) && (((List)localObject).isEmpty())) {}
    localObject = ((List)localObject).iterator();
    com.tencent.mm.plugin.welab.d.a.a locala;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      locala = (com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next();
    } while ((locala == null) || (!Xzq.e(locala)));
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        c.aYo().dX(266267, 266241);
      }
      AppMethodBeat.o(146304);
      return;
    }
  }
  
  public static boolean iDR()
  {
    AppMethodBeat.i(146305);
    boolean bool = c.aYo().dW(266267, 266241);
    AppMethodBeat.o(146305);
    return bool;
  }
  
  public static boolean iDS()
  {
    AppMethodBeat.i(146306);
    boolean bool = MMApplicationContext.getDefaultPreference().getBoolean("key_has_enter_welab", false);
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
    if (bnx(parama.field_LabsAppId))
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
    if ((parama.field_RedPoint == 1) && (!bnx(parama.field_LabsAppId)) && (parama.MX())) {
      c.aYo().R(266267, true);
    }
    AppMethodBeat.o(146303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e.b
 * JD-Core Version:    0.7.0.1
 */