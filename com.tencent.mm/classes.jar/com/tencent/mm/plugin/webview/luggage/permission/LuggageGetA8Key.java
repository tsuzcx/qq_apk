package com.tencent.mm.plugin.webview.luggage.permission;

import android.text.TextUtils;
import com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService;
import com.tencent.mm.plugin.webview.luggage.ipc.MainProcessTask;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.aao;
import com.tencent.mm.protocal.c.apm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LuggageGetA8Key
{
  private static final Pattern reA = Pattern.compile(".*#.*wechat_redirect");
  private int fzn = 0;
  private String hcm = "";
  private final HashSet<String> kMM = new HashSet();
  private byte[] kMN = new byte[0];
  private String mAppId = "";
  private int rew = (int)System.currentTimeMillis();
  private boolean rex = true;
  private a rey = new a();
  private HashMap<String, String> rez = new HashMap();
  
  private static String RL(String paramString)
  {
    int i = paramString.indexOf("#");
    if (i < 0) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  private static void a(String paramString, aao paramaao, LuggageGetA8Key.a parama)
  {
    int i = paramaao.ssy;
    String str = paramaao.kVs;
    Object localObject = paramaao.tah;
    HashMap localHashMap = new HashMap();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        apm localapm = (apm)((Iterator)localObject).next();
        localHashMap.put(localapm.sCH, localapm.nFs);
      }
    }
    switch (i)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      return;
    case 1: 
      if ((str == null) || (str.length() == 0))
      {
        y.e("MicroMsg.LuggageGetA8Key", "getA8key-text fail, invalid content");
        return;
      }
      parama.fu(paramString, str);
      return;
    case 2: 
    case 7: 
      parama.b(paramString, paramaao.sZV, localHashMap);
      return;
    }
    parama.b(paramString, paramaao.sZV, localHashMap);
  }
  
  private static boolean eF(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 0) && (paramInt2 == 0);
  }
  
  private static boolean eG(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -2005);
  }
  
  public final JsapiPermissionWrapper RP(String paramString)
  {
    a locala = this.rey;
    if (locala.reF != null)
    {
      y.i("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm, return hardcodeJsPerm = " + locala.reF);
      return locala.reF;
    }
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, url = " + paramString);
      return locala.reH;
    }
    paramString = a.RL(paramString);
    if (locala.reE == null)
    {
      y.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, permMap is null");
      return locala.reH;
    }
    paramString = (a.a)locala.reE.get(paramString);
    if (paramString == null) {
      return locala.reH;
    }
    return paramString.reJ;
  }
  
  public final GeneralControlWrapper RQ(String paramString)
  {
    a locala = this.rey;
    if (locala.reG != null)
    {
      y.i("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl, return hardcodeGenCtrl = " + locala.reG);
      return locala.reG;
    }
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl fail, url = " + paramString);
      return locala.reI;
    }
    String str = a.RL(paramString);
    a.a locala1 = (a.a)locala.reE.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
    if (locala1 == null) {}
    for (paramString = null;; paramString = locala1.reK)
    {
      y.i("MicroMsg.LuggageGetA8KeyPermission", paramString + ", url = " + str);
      if (locala1 != null) {
        break;
      }
      return locala.reI;
    }
    return locala1.reK;
  }
  
  public final String RR(String paramString)
  {
    y.i("MicroMsg.LuggageGetA8Key", "getShareUrl, dropHashUrl = " + RL(paramString));
    Iterator localIterator = this.rez.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      y.i("MicroMsg.LuggageGetA8Key", "getShareUrl, Key = %s, value = %s", new Object[] { str, this.rez.get(str) });
    }
    return (String)this.rez.get(RL(paramString));
  }
  
  public final boolean a(String paramString, LuggageGetA8Key.a parama)
  {
    if (this.kMM.contains(paramString)) {
      return false;
    }
    Object localObject1 = this.rey;
    if (bk.bl(paramString)) {
      y.e("MicroMsg.LuggageGetA8KeyPermission", "has fail, url is null");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label102;
      }
      return false;
      Object localObject2 = a.RL(paramString);
      localObject2 = (a.a)((a)localObject1).reE.get(localObject2);
      if ((localObject2 == null) || (((a.a)localObject2).reJ == ((a)localObject1).reH) || (((a.a)localObject2).reK == ((a)localObject1).reI)) {
        break;
      }
    }
    label102:
    this.kMM.add(paramString);
    if (parama != null) {
      parama.EC(paramString);
    }
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        y.e("MicroMsg.LuggageGetA8Key", "getReason fail, url is null");
        i = 0;
      }
      for (;;)
      {
        localObject1 = new LuggageGetA8Key.RunCgiTask(paramString, this.hcm, this.fzn, i, this.rew, this.mAppId, this.kMN);
        ((LuggageGetA8Key.RunCgiTask)localObject1).kMP = new LuggageGetA8Key.1(this, paramString, i, (LuggageGetA8Key.RunCgiTask)localObject1, parama);
        LuggageMainProcessService.a((MainProcessTask)localObject1);
        break;
        if (this.rex)
        {
          this.rex = false;
          i = 0;
        }
        else
        {
          boolean bool = reA.matcher(paramString).find();
          if (bool) {
            i = 2;
          } else {
            i = 1;
          }
        }
      }
      return true;
    }
    catch (Exception paramString)
    {
      y.i("MicroMsg.LuggageGetA8Key", "ERROR %s", new Object[] { paramString });
    }
  }
  
  public final boolean cO(String paramString, int paramInt)
  {
    return RP(paramString).ED(paramInt) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key
 * JD-Core Version:    0.7.0.1
 */