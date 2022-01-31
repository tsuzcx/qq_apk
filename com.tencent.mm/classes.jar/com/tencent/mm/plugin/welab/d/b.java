package com.tencent.mm.plugin.welab.d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.y.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final b rEY = new b();
  public Map<String, Integer> rEw = new HashMap();
  public String tag = "";
  
  private b()
  {
    chf();
  }
  
  private boolean Uo(String paramString)
  {
    return (this.rEw.containsKey(paramString)) && (((Integer)this.rEw.get(paramString)).intValue() == 1);
  }
  
  private void chf()
  {
    this.tag = ((String)g.DP().Dz().get(ac.a.uwv, null));
    y.i("WeLabRedPointMgr", "load red tag " + this.tag);
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
            this.rEw.put(localObject[0], Integer.valueOf(bk.ZR(localObject[1])));
          }
        }
        i += 1;
      }
    }
  }
  
  public static b chq()
  {
    return rEY;
  }
  
  public static void chr()
  {
    Object localObject = com.tencent.mm.plugin.welab.b.chc().chd();
    if ((localObject != null) && (((List)localObject).isEmpty())) {}
    localObject = ((List)localObject).iterator();
    com.tencent.mm.plugin.welab.c.a.a locala;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      locala = (com.tencent.mm.plugin.welab.c.a.a)((Iterator)localObject).next();
    } while ((locala == null) || (!rEY.e(locala)));
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        c.BS().bd(266267, 266241);
      }
      return;
    }
  }
  
  public static boolean chs()
  {
    return c.BS().bc(266267, 266241);
  }
  
  public static boolean cht()
  {
    return ae.cqS().getBoolean("key_has_enter_welab", false);
  }
  
  public final boolean e(com.tencent.mm.plugin.welab.c.a.a parama)
  {
    int i;
    if (parama.field_RedPoint == 1)
    {
      if ((!parama.caB()) && (parama.field_Switch != 3)) {
        break label31;
      }
      i = 1;
      if (i == 0) {
        break label36;
      }
    }
    label31:
    label36:
    while (Uo(parama.field_LabsAppId))
    {
      return false;
      i = 0;
      break;
    }
    return true;
  }
  
  public final void f(com.tencent.mm.plugin.welab.c.a.a parama)
  {
    if ((parama.field_RedPoint == 1) && (!Uo(parama.field_LabsAppId)) && (parama.chm())) {
      c.BS().w(266267, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d.b
 * JD-Core Version:    0.7.0.1
 */