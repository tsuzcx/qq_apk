package com.tencent.mm.plugin.webview.f;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.p;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.protocal.protobuf.epn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g
{
  public Map<String, a> Jce;
  private JsapiPermissionWrapper Jcf;
  private GeneralControlWrapper Jcg;
  private final JsapiPermissionWrapper Jch;
  private final GeneralControlWrapper Jci;
  private Map<String, HashMap<String, epn>> Jcq;
  private b Jcr;
  
  public g(b paramb)
  {
    AppMethodBeat.i(224492);
    this.Jcq = new HashMap();
    this.Jch = new JsapiPermissionWrapper(2);
    this.Jci = GeneralControlWrapper.Kzh;
    this.Jcr = paramb;
    Log.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + this.Jcf + ", hardcodeGenCtrl = " + this.Jcg);
    this.Jce = new HashMap();
    AppMethodBeat.o(224492);
  }
  
  private static String aYy(String paramString)
  {
    AppMethodBeat.i(224501);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(224501);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(224501);
    return paramString;
  }
  
  private a aZJ(String paramString)
  {
    AppMethodBeat.i(224497);
    if ((!Util.isNullOrNil(paramString)) && (this.Jce != null))
    {
      paramString = aYy(paramString);
      if (this.Jce.containsKey(paramString))
      {
        paramString = (a)this.Jce.get(paramString);
        AppMethodBeat.o(224497);
        return paramString;
      }
    }
    AppMethodBeat.o(224497);
    return null;
  }
  
  private static boolean agg(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2);
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(224493);
    this.Jcf = paramJsapiPermissionWrapper;
    if ((ac.jOx == null) || (ac.jOx.length() == 0)) {
      Log.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
    }
    int i;
    for (;;)
    {
      this.Jcg = paramGeneralControlWrapper;
      if ((ac.jOy != null) && (ac.jOy.length() != 0)) {
        break label159;
      }
      Log.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
      AppMethodBeat.o(224493);
      return;
      try
      {
        i = Util.getInt(ac.jOx, 0);
        if (i < 0) {
          Log.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
        }
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        Log.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + paramJsapiPermissionWrapper.getMessage());
        this.Jcf = null;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.Jcf);
      break;
      this.Jcf = new JsapiPermissionWrapper(i);
    }
    try
    {
      label159:
      i = Util.getInt(ac.jOy, 0);
      Log.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
      paramJsapiPermissionWrapper = new bgt();
      paramJsapiPermissionWrapper.LQC = i;
      this.Jcg = new GeneralControlWrapper(paramJsapiPermissionWrapper);
      Log.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.Jcg);
      AppMethodBeat.o(224493);
      return;
    }
    catch (Exception paramJsapiPermissionWrapper)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { paramJsapiPermissionWrapper.getMessage() });
        this.Jcg = null;
      }
    }
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(224494);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewPermission", "update fail, url is null");
      AppMethodBeat.o(224494);
      return;
    }
    if (paramGeneralControlWrapper != null)
    {
      bool1 = bool2;
      if ((paramGeneralControlWrapper.Kzi & 0x80000) != 0) {
        bool1 = true;
      }
      Log.d("MicroMsg.GeneralControlWrapper", "needClearData, ret = ".concat(String.valueOf(bool1)));
    }
    com.tencent.mm.plugin.webview.modeltools.c.cN(paramString, bool1);
    String str = aYy(paramString);
    paramString = paramJsapiPermissionWrapper;
    if (paramJsapiPermissionWrapper == null) {
      paramString = this.Jch;
    }
    paramJsapiPermissionWrapper = paramGeneralControlWrapper;
    if (paramGeneralControlWrapper == null) {
      paramJsapiPermissionWrapper = this.Jci;
    }
    Log.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + paramString + ", genCtrl = " + paramJsapiPermissionWrapper + ", url = " + str);
    this.Jce.put(str, new a(paramString, paramJsapiPermissionWrapper));
    AppMethodBeat.o(224494);
  }
  
  public final void aR(Bundle paramBundle)
  {
    AppMethodBeat.i(224498);
    Object localObject2 = paramBundle.getStringArrayList("jsapi_preverify_fun_list");
    Object localObject1 = z.bfK(z.aYy(paramBundle.getString("jsapi_preverify_commit_url")));
    if (!this.Jcq.containsKey(localObject1)) {
      this.Jcq.put(localObject1, new HashMap());
    }
    localObject1 = (HashMap)this.Jcq.get(localObject1);
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      epn localepn;
      try
      {
        localepn = new epn();
        localepn.parseFrom(paramBundle.getByteArray(str));
        if (!agg(localepn.state)) {
          break label188;
        }
        Log.w("MicroMsg.WebViewPermission", "skip update control bytes by preverify, %s, %d, %d", new Object[] { str, Integer.valueOf(localepn.state), Integer.valueOf(localepn.Nnk) });
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WebViewPermission", localException, "parse preverify info", new Object[0]);
      }
      continue;
      label188:
      ((HashMap)localObject1).put(localException, localepn);
      Log.i("MicroMsg.WebViewPermission", "update control bytes by preverify, %s, %d, %d", new Object[] { localException, Integer.valueOf(localepn.state), Integer.valueOf(localepn.Nnk) });
    }
    AppMethodBeat.o(224498);
  }
  
  public final boolean aZK(String paramString)
  {
    AppMethodBeat.i(224500);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewPermission", "hasJsPerm fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(224500);
      return false;
    }
    String str = aYy(paramString);
    if (this.Jce == null)
    {
      Log.e("MicroMsg.WebViewPermission", "hasJsPerm fail, permMap is null");
      AppMethodBeat.o(224500);
      return false;
    }
    a locala = (a)this.Jce.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw hasJsPerm, jsPerm = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.IBv)
    {
      Log.i("MicroMsg.WebViewPermission", paramString + ", url = " + str);
      if ((locala == null) || (locala.IBv == null) || (locala.IBv.equals(this.Jch))) {
        break;
      }
      AppMethodBeat.o(224500);
      return true;
    }
    AppMethodBeat.o(224500);
    return false;
  }
  
  public final JsapiPermissionWrapper gdH()
  {
    AppMethodBeat.i(224496);
    Object localObject1;
    if (this.Jcf != null)
    {
      Log.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.Jcf);
      localObject1 = this.Jcf;
      AppMethodBeat.o(224496);
      return localObject1;
    }
    Object localObject3;
    Object localObject2;
    if (this.Jcr != null)
    {
      localObject1 = aZJ(this.Jcr.fZK());
      localObject3 = this.Jcr.fZL();
      if (!Util.isNullOrNil((String)localObject3))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = aZJ((String)localObject3);
        }
        localObject1 = z.bfK((String)localObject3);
      }
    }
    for (;;)
    {
      if (localObject2 != null) {}
      for (localObject2 = ((a)localObject2).IBv;; localObject2 = null)
      {
        localObject3 = localObject2;
        int j;
        if (localObject1 != null)
        {
          localObject3 = localObject2;
          if (this.Jcq.containsKey(localObject1)) {
            if (localObject2 == null)
            {
              localObject2 = new JsapiPermissionWrapper(new byte[0]);
              j = 0;
              localObject1 = (HashMap)this.Jcq.get(localObject1);
              localObject3 = ((HashMap)localObject1).keySet().iterator();
            }
          }
        }
        label392:
        label395:
        for (;;)
        {
          label204:
          String str;
          Object localObject4;
          int i;
          if (((Iterator)localObject3).hasNext())
          {
            str = (String)((Iterator)localObject3).next();
            localObject4 = com.tencent.mm.protocal.c.bgb(str);
            if (localObject4 != null) {
              i = ((c.g)localObject4).gtt();
            }
          }
          for (;;)
          {
            label244:
            if (i < 0) {
              break label395;
            }
            if (j != 0) {}
            int m;
            for (int k = ((JsapiPermissionWrapper)localObject2).aiW(i);; k = 2)
            {
              m = ((epn)((HashMap)localObject1).get(str)).state;
              if (k != 0) {
                break label331;
              }
              ((JsapiPermissionWrapper)localObject2).a(i, (byte)0);
              break label204;
              localObject2 = ((JsapiPermissionWrapper)localObject2).gtN();
              j = 1;
              break;
              localObject4 = p.ISk;
              localObject4 = p.aYo(str);
              if (localObject4 == null) {
                break label392;
              }
              i = ((a)localObject4).ePA();
              break label244;
            }
            label331:
            if (k == 2)
            {
              ((JsapiPermissionWrapper)localObject2).a(i, (byte)m);
              break label204;
            }
            ((JsapiPermissionWrapper)localObject2).a(i, (byte)k);
            break label204;
            localObject3 = localObject2;
            if (localObject3 == null)
            {
              localObject1 = this.Jch;
              AppMethodBeat.o(224496);
              return localObject1;
            }
            AppMethodBeat.o(224496);
            return localObject3;
            i = -1;
          }
        }
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
      continue;
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  public final GeneralControlWrapper gdI()
  {
    GeneralControlWrapper localGeneralControlWrapper = null;
    AppMethodBeat.i(224499);
    if (this.Jcg != null)
    {
      Log.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.Jcg);
      localObject = this.Jcg;
      AppMethodBeat.o(224499);
      return localObject;
    }
    if (this.Jcr != null)
    {
      a locala = aZJ(this.Jcr.fZK());
      localObject = locala;
      if (locala != null) {}
    }
    for (Object localObject = aZJ(this.Jcr.fZL());; localObject = null)
    {
      if (localObject != null) {
        localGeneralControlWrapper = ((a)localObject).Jcj;
      }
      if (localGeneralControlWrapper == null)
      {
        localObject = this.Jci;
        AppMethodBeat.o(224499);
        return localObject;
      }
      AppMethodBeat.o(224499);
      return localGeneralControlWrapper;
    }
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(224495);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewPermission", "has fail, url is null");
      AppMethodBeat.o(224495);
      return false;
    }
    paramString = aYy(paramString);
    if (this.Jce == null)
    {
      Log.e("MicroMsg.WebViewPermission", "has fail, permMap is null");
      AppMethodBeat.o(224495);
      return false;
    }
    paramString = (a)this.Jce.get(paramString);
    if ((paramString != null) && (paramString.IBv != this.Jch) && (paramString.Jcj != this.Jci))
    {
      AppMethodBeat.o(224495);
      return true;
    }
    AppMethodBeat.o(224495);
    return false;
  }
  
  static final class a
  {
    public JsapiPermissionWrapper IBv;
    public GeneralControlWrapper Jcj;
    
    public a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
    {
      this.IBv = paramJsapiPermissionWrapper;
      this.Jcj = paramGeneralControlWrapper;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(224491);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Permission: jsPerm = ");
      ((StringBuilder)localObject).append(this.IBv);
      ((StringBuilder)localObject).append(", genCtrl = ");
      ((StringBuilder)localObject).append(this.Jcj);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(224491);
      return localObject;
    }
  }
  
  public static abstract interface b
  {
    public abstract String fZK();
    
    public abstract String fZL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.g
 * JD-Core Version:    0.7.0.1
 */