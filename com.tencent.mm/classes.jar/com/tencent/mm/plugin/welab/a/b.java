package com.tencent.mm.plugin.welab.a;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.welab.e.a;
import com.tencent.mm.protocal.c.atd;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.welab.a.a.a
{
  private Map<String, Integer> rEw = new HashMap();
  private String tag = "";
  
  public b()
  {
    chf();
  }
  
  private void chf()
  {
    this.tag = ((String)g.DP().Dz().get(ac.a.uww, null));
    y.i("LabAppLifeService", "load red tag " + this.tag);
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
  
  public final boolean Uj(String paramString)
  {
    if (com.tencent.mm.plugin.welab.b.chc().Uf(paramString).field_Switch == 2)
    {
      y.i("LabAppLifeService", "appid %s is open ", new Object[] { paramString });
      return true;
    }
    y.i("LabAppLifeService", "appid %s is close", new Object[] { paramString });
    return false;
  }
  
  public final boolean Uk(String paramString)
  {
    return (this.rEw.get(paramString) == null) || (((Integer)this.rEw.get(paramString)).intValue() == 0);
  }
  
  public final boolean Ul(String paramString)
  {
    com.tencent.mm.plugin.welab.c.a.a locala = com.tencent.mm.plugin.welab.b.chc().Uf(paramString);
    paramString = new StringBuilder("hitExp ").append(paramString).append(", ");
    if (locala.isRunning()) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("LabAppLifeService", bool);
      if (!locala.isRunning()) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public final void br(String paramString, boolean paramBoolean)
  {
    int j = 1;
    y.i("LabAppLifeService", "switchEntry " + paramString + "," + paramBoolean);
    com.tencent.mm.plugin.welab.c.a.a locala = com.tencent.mm.plugin.welab.b.chc().Uf(paramString);
    if (paramBoolean)
    {
      i = 2;
      if (locala.field_Switch != i)
      {
        locala.field_Switch = i;
        com.tencent.mm.plugin.welab.b.chc().rEr.c(locala, new String[0]);
        Object localObject = new ate();
        atd localatd = new atd();
        localatd.toJ = bk.ZR(locala.field_expId);
        localatd.toK = locala.field_LabsAppId;
        if (locala.field_Switch != 2) {
          break label206;
        }
        i = j;
        label132:
        localatd.sYX = i;
        ((ate)localObject).dtH.add(localatd);
        localObject = new i.a(207, (com.tencent.mm.bv.a)localObject);
        ((j)g.r(j.class)).Fv().b((i.b)localObject);
        if (locala.field_Switch != 2) {
          break label211;
        }
      }
    }
    label206:
    label211:
    for (int i = 4;; i = 5)
    {
      com.tencent.mm.plugin.welab.e.q(paramString, i, false);
      return;
      i = 1;
      break;
      i = 2;
      break label132;
    }
  }
  
  public final void open(String paramString)
  {
    this.rEw.put(paramString, Integer.valueOf(1));
    this.tag = (this.tag + "&" + paramString + "=1");
    g.DP().Dz().c(ac.a.uww, this.tag);
    com.tencent.mm.plugin.welab.c.a.a locala = com.tencent.mm.plugin.welab.b.chc().Uf(paramString);
    e.a locala1 = new e.a();
    locala1.bOL = paramString;
    locala1.rEu = locala.field_expId;
    locala1.timeStamp = System.currentTimeMillis();
    locala1.action = 3;
    com.tencent.mm.plugin.welab.e.a(locala1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.a.b
 * JD-Core Version:    0.7.0.1
 */