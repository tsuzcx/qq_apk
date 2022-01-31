package com.tencent.mm.plugin.webview.luggage.permission;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static final Pattern uUE;
  private String ikj;
  private String mAppId;
  private int mScene;
  private boolean uUA;
  private a uUB;
  private final HashMap<String, String> uUC;
  private LuggageGetA8Key.RunCgiTask uUD;
  private final HashSet<String> uUw;
  private byte[] uUx;
  private int uUy;
  private boolean uUz;
  
  static
  {
    AppMethodBeat.i(6480);
    uUE = Pattern.compile(".*#.*wechat_redirect");
    AppMethodBeat.o(6480);
  }
  
  public LuggageGetA8Key()
  {
    AppMethodBeat.i(6467);
    this.uUw = new HashSet();
    this.mScene = 0;
    this.ikj = "";
    this.mAppId = "";
    this.uUx = new byte[0];
    this.uUz = true;
    this.uUA = false;
    this.uUC = new HashMap();
    this.uUy = ((int)System.currentTimeMillis());
    this.uUB = new a();
    AppMethodBeat.o(6467);
  }
  
  private static void a(String paramString, afg paramafg, LuggageGetA8Key.a parama)
  {
    AppMethodBeat.i(6477);
    int i = paramafg.wld;
    String str = paramafg.ntu;
    Object localObject = paramafg.wYy;
    HashMap localHashMap = new HashMap();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        avl localavl = (avl)((Iterator)localObject).next();
        localHashMap.put(localavl.wxP, localavl.qsu);
      }
    }
    switch (i)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(6477);
      return;
    case 1: 
      if ((str == null) || (str.length() == 0))
      {
        ab.e("MicroMsg.LuggageGetA8Key", "getA8key-text fail, invalid content");
        AppMethodBeat.o(6477);
        return;
      }
      parama.hp(paramString, str);
      AppMethodBeat.o(6477);
      return;
    case 2: 
    case 7: 
      parama.e(paramString, paramafg.wYn, localHashMap);
      AppMethodBeat.o(6477);
      return;
    }
    parama.e(paramString, paramafg.wYn, localHashMap);
    AppMethodBeat.o(6477);
  }
  
  private static String agP(String paramString)
  {
    AppMethodBeat.i(6476);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(6476);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(6476);
    return paramString;
  }
  
  private static boolean gI(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 0) && (paramInt2 == 0);
  }
  
  private static boolean gJ(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -2005);
  }
  
  public final boolean a(String paramString, int paramInt, LuggageGetA8Key.a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(6474);
        boolean bool;
        if (agW(paramString))
        {
          AppMethodBeat.o(6474);
          bool = true;
          return bool;
        }
        a locala = this.uUB;
        if (bo.isNullOrNil(paramString))
        {
          ab.e("MicroMsg.LuggageGetA8KeyPermission", "has fail, url is null");
          break label351;
          if (i != 0)
          {
            AppMethodBeat.o(6474);
            bool = false;
          }
        }
        else
        {
          Object localObject = a.agP(paramString);
          localObject = (a.a)locala.uUM.get(localObject);
          if ((localObject == null) || (((a.a)localObject).uUR == locala.uUP) || (((a.a)localObject).uUS == locala.uUQ)) {
            break label351;
          }
          i = 1;
          continue;
        }
        if ((paramInt == 5) && (this.uUA))
        {
          ab.w("MicroMsg.LuggageGetA8Key", "disable iframe request");
          AppMethodBeat.o(6474);
          bool = false;
          continue;
        }
        this.uUw.add(paramString);
        if (parama != null) {
          parama.PQ(paramString);
        }
        if (this.uUD != null)
        {
          this.uUD.aBk();
          this.uUD = null;
          ab.i("MicroMsg.LuggageGetA8Key", "runCgiTask set null: %s", new Object[] { paramString });
        }
        if (paramInt == -1)
        {
          paramInt = agV(paramString);
          ab.i("MicroMsg.LuggageGetA8Key", "startGetA8Key, url: %s", new Object[] { paramString });
          try
          {
            this.uUD = new LuggageGetA8Key.RunCgiTask(paramString, this.ikj, this.mScene, paramInt, this.uUy, this.mAppId, this.uUx);
            this.uUD.uUJ = new LuggageGetA8Key.1(this, paramString, paramInt, parama);
            AppBrandMainProcessService.a(this.uUD);
            AppMethodBeat.o(6474);
            bool = true;
          }
          catch (Exception paramString)
          {
            ab.i("MicroMsg.LuggageGetA8Key", "ERROR %s", new Object[] { paramString });
            AppMethodBeat.o(6474);
            bool = false;
          }
          continue;
        }
        continue;
      }
      finally {}
      label351:
      int i = 0;
    }
  }
  
  public final boolean a(String paramString, LuggageGetA8Key.a parama)
  {
    try
    {
      AppMethodBeat.i(6475);
      boolean bool = a(paramString, -1, parama);
      AppMethodBeat.o(6475);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final JsapiPermissionWrapper agS(String paramString)
  {
    AppMethodBeat.i(6468);
    paramString = this.uUB.agS(paramString);
    AppMethodBeat.o(6468);
    return paramString;
  }
  
  public final GeneralControlWrapper agT(String paramString)
  {
    AppMethodBeat.i(6469);
    paramString = this.uUB.agT(paramString);
    AppMethodBeat.o(6469);
    return paramString;
  }
  
  public final String agU(String paramString)
  {
    AppMethodBeat.i(6471);
    synchronized (this.uUC)
    {
      ab.i("MicroMsg.LuggageGetA8Key", "getShareUrl, dropHashUrl = " + agP(paramString));
      Iterator localIterator = this.uUC.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ab.i("MicroMsg.LuggageGetA8Key", "getShareUrl, Key = %s, value = %s", new Object[] { str, this.uUC.get(str) });
      }
    }
    paramString = (String)this.uUC.get(agP(paramString));
    AppMethodBeat.o(6471);
    return paramString;
  }
  
  public final int agV(String paramString)
  {
    AppMethodBeat.i(6472);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.LuggageGetA8Key", "getReason fail, url is null");
      AppMethodBeat.o(6472);
      return 0;
    }
    if (this.uUz)
    {
      this.uUz = false;
      AppMethodBeat.o(6472);
      return 0;
    }
    if (uUE.matcher(paramString).find())
    {
      AppMethodBeat.o(6472);
      return 2;
    }
    AppMethodBeat.o(6472);
    return 1;
  }
  
  public final boolean agW(String paramString)
  {
    AppMethodBeat.i(6473);
    boolean bool = this.uUw.contains(paramString);
    AppMethodBeat.o(6473);
    return bool;
  }
  
  public final boolean dN(String paramString, int paramInt)
  {
    AppMethodBeat.i(6470);
    if (agS(paramString).MB(paramInt) == 1)
    {
      AppMethodBeat.o(6470);
      return true;
    }
    AppMethodBeat.o(6470);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(153128);
    if (this.uUD != null)
    {
      this.uUD.aBk();
      this.uUD = null;
      ab.i("MicroMsg.LuggageGetA8Key", "destroy runCgiTask set null");
    }
    AppMethodBeat.o(153128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key
 * JD-Core Version:    0.7.0.1
 */