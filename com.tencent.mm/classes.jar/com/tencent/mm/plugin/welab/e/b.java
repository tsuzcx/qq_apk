package com.tencent.mm.plugin.welab.e;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.x.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final b vvH;
  public String tag;
  public Map<String, Integer> vuY;
  
  static
  {
    AppMethodBeat.i(80636);
    vvH = new b();
    AppMethodBeat.o(80636);
  }
  
  private b()
  {
    AppMethodBeat.i(80628);
    this.vuY = new HashMap();
    this.tag = "";
    dhD();
    AppMethodBeat.o(80628);
  }
  
  private boolean ajC(String paramString)
  {
    AppMethodBeat.i(80631);
    if ((this.vuY.containsKey(paramString)) && (((Integer)this.vuY.get(paramString)).intValue() == 1))
    {
      AppMethodBeat.o(80631);
      return true;
    }
    AppMethodBeat.o(80631);
    return false;
  }
  
  public static b dhC()
  {
    return vvH;
  }
  
  private void dhD()
  {
    AppMethodBeat.i(80629);
    this.tag = ((String)g.RL().Ru().get(ac.a.yGD, null));
    ab.i("WeLabRedPointMgr", "load red tag " + this.tag);
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
            this.vuY.put(localObject[0], Integer.valueOf(bo.apV(localObject[1])));
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(80629);
  }
  
  public static void dhE()
  {
    AppMethodBeat.i(80633);
    Object localObject = com.tencent.mm.plugin.welab.a.dhl().dhm();
    if ((localObject != null) && (((List)localObject).isEmpty())) {}
    localObject = ((List)localObject).iterator();
    com.tencent.mm.plugin.welab.d.a.a locala;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      locala = (com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next();
    } while ((locala == null) || (!vvH.e(locala)));
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        c.PJ().ce(266267, 266241);
      }
      AppMethodBeat.o(80633);
      return;
    }
  }
  
  public static boolean dhF()
  {
    AppMethodBeat.i(80634);
    boolean bool = c.PJ().cd(266267, 266241);
    AppMethodBeat.o(80634);
    return bool;
  }
  
  public static boolean dhG()
  {
    AppMethodBeat.i(80635);
    boolean bool = ah.dsQ().getBoolean("key_has_enter_welab", false);
    AppMethodBeat.o(80635);
    return bool;
  }
  
  public final boolean e(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(80630);
    if ((parama.field_RedPoint != 1) || (parama.dhu()))
    {
      AppMethodBeat.o(80630);
      return false;
    }
    if (ajC(parama.field_LabsAppId))
    {
      AppMethodBeat.o(80630);
      return false;
    }
    AppMethodBeat.o(80630);
    return true;
  }
  
  public final void f(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(80632);
    if ((parama.field_RedPoint == 1) && (!ajC(parama.field_LabsAppId)) && (parama.dhv())) {
      c.PJ().y(266267, true);
    }
    AppMethodBeat.o(80632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e.b
 * JD-Core Version:    0.7.0.1
 */