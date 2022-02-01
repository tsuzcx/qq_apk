package com.tencent.mm.plugin.webview.f;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.webview.core.n;
import com.tencent.mm.plugin.webview.modeltools.b;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.ezy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g
{
  public Map<String, a> PYM;
  private JsapiPermissionWrapper PYN;
  private GeneralControlWrapper PYO;
  private final JsapiPermissionWrapper PYP;
  private final GeneralControlWrapper PYQ;
  private Map<String, HashMap<String, ezy>> PYY;
  private b PYZ;
  
  public g(b paramb)
  {
    AppMethodBeat.i(210992);
    this.PYY = new HashMap();
    this.PYP = new JsapiPermissionWrapper(2);
    this.PYQ = GeneralControlWrapper.RAY;
    this.PYZ = paramb;
    Log.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + this.PYN + ", hardcodeGenCtrl = " + this.PYO);
    this.PYM = new HashMap();
    AppMethodBeat.o(210992);
  }
  
  private static boolean anV(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2);
  }
  
  private static String bks(String paramString)
  {
    AppMethodBeat.i(211014);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(211014);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(211014);
    return paramString;
  }
  
  private a blF(String paramString)
  {
    AppMethodBeat.i(211005);
    if ((!Util.isNullOrNil(paramString)) && (this.PYM != null))
    {
      paramString = bks(paramString);
      if (this.PYM.containsKey(paramString))
      {
        paramString = (a)this.PYM.get(paramString);
        AppMethodBeat.o(211005);
        return paramString;
      }
    }
    AppMethodBeat.o(211005);
    return null;
  }
  
  private void k(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(211008);
    Object localObject = paramBundle.getStringArrayList("jsapi_preverify_fun_list");
    paramString = ab.bse(ab.bks(paramString));
    if (!this.PYY.containsKey(paramString)) {
      this.PYY.put(paramString, new HashMap());
    }
    paramString = (HashMap)this.PYY.get(paramString);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      ezy localezy;
      try
      {
        localezy = new ezy();
        localezy.parseFrom(paramBundle.getByteArray(str));
        if (!anV(localezy.state)) {
          break label181;
        }
        Log.w("MicroMsg.WebViewPermission", "skip update control bytes by preverify, %s, %d, %d", new Object[] { str, Integer.valueOf(localezy.state), Integer.valueOf(localezy.UAb) });
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WebViewPermission", localException, "parse preverify info", new Object[0]);
      }
      continue;
      label181:
      paramString.put(localException, localezy);
      Log.i("MicroMsg.WebViewPermission", "update control bytes by preverify, %s, %d, %d", new Object[] { localException, Integer.valueOf(localezy.state), Integer.valueOf(localezy.UAb) });
    }
    AppMethodBeat.o(211008);
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(210997);
    this.PYN = paramJsapiPermissionWrapper;
    if ((ac.mFH == null) || (ac.mFH.length() == 0)) {
      Log.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
    }
    int i;
    for (;;)
    {
      this.PYO = paramGeneralControlWrapper;
      if ((ac.mFI != null) && (ac.mFI.length() != 0)) {
        break label159;
      }
      Log.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
      AppMethodBeat.o(210997);
      return;
      try
      {
        i = Util.getInt(ac.mFH, 0);
        if (i < 0) {
          Log.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
        }
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        Log.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + paramJsapiPermissionWrapper.getMessage());
        this.PYN = null;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.PYN);
      break;
      this.PYN = new JsapiPermissionWrapper(i);
    }
    try
    {
      label159:
      i = Util.getInt(ac.mFI, 0);
      Log.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
      paramJsapiPermissionWrapper = new bob();
      paramJsapiPermissionWrapper.SZd = i;
      this.PYO = new GeneralControlWrapper(paramJsapiPermissionWrapper);
      Log.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.PYO);
      AppMethodBeat.o(210997);
      return;
    }
    catch (Exception paramJsapiPermissionWrapper)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { paramJsapiPermissionWrapper.getMessage() });
        this.PYO = null;
      }
    }
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(210998);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewPermission", "update fail, url is null");
      AppMethodBeat.o(210998);
      return;
    }
    if (paramGeneralControlWrapper != null)
    {
      bool1 = bool2;
      if ((paramGeneralControlWrapper.RAZ & 0x80000) != 0) {
        bool1 = true;
      }
      Log.d("MicroMsg.GeneralControlWrapper", "needClearData, ret = ".concat(String.valueOf(bool1)));
    }
    b.db(paramString, bool1);
    String str = bks(paramString);
    paramString = paramJsapiPermissionWrapper;
    if (paramJsapiPermissionWrapper == null) {
      paramString = this.PYP;
    }
    paramJsapiPermissionWrapper = paramGeneralControlWrapper;
    if (paramGeneralControlWrapper == null) {
      paramJsapiPermissionWrapper = this.PYQ;
    }
    Log.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + paramString + ", genCtrl = " + paramJsapiPermissionWrapper + ", url = " + str);
    this.PYM.put(str, new a(paramString, paramJsapiPermissionWrapper));
    AppMethodBeat.o(210998);
  }
  
  public final void aN(Bundle paramBundle)
  {
    AppMethodBeat.i(211007);
    String str1 = paramBundle.getString("jsapi_preverify_commit_url");
    String str2 = paramBundle.getString("jsapi_preverify_current_url");
    k(paramBundle, str1);
    if (!Util.isEqual(str1, str2)) {
      k(paramBundle, str2);
    }
    AppMethodBeat.o(211007);
  }
  
  public final boolean blz(String paramString)
  {
    AppMethodBeat.i(211012);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewPermission", "hasJsPerm fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(211012);
      return false;
    }
    String str = bks(paramString);
    if (this.PYM == null)
    {
      Log.e("MicroMsg.WebViewPermission", "hasJsPerm fail, permMap is null");
      AppMethodBeat.o(211012);
      return false;
    }
    a locala = (a)this.PYM.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw hasJsPerm, jsPerm = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.PvI)
    {
      Log.i("MicroMsg.WebViewPermission", paramString + ", url = " + str);
      if ((locala == null) || (locala.PvI == null) || (locala.PvI.equals(this.PYP))) {
        break;
      }
      AppMethodBeat.o(211012);
      return true;
    }
    AppMethodBeat.o(211012);
    return false;
  }
  
  public final JsapiPermissionWrapper gWI()
  {
    AppMethodBeat.i(211003);
    Object localObject1;
    if (this.PYN != null)
    {
      Log.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.PYN);
      localObject1 = this.PYN;
      AppMethodBeat.o(211003);
      return localObject1;
    }
    Object localObject3;
    Object localObject2;
    if (this.PYZ != null)
    {
      localObject1 = blF(this.PYZ.gSD());
      localObject3 = this.PYZ.gSE();
      if (!Util.isNullOrNil((String)localObject3))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = blF((String)localObject3);
        }
        localObject1 = ab.bse((String)localObject3);
      }
    }
    for (;;)
    {
      if (localObject2 != null) {}
      label310:
      for (localObject2 = ((a)localObject2).PvI;; localObject2 = null)
      {
        localObject3 = localObject2;
        int i;
        if (localObject1 != null)
        {
          localObject3 = localObject2;
          if (this.PYY.containsKey(localObject1)) {
            if (localObject2 == null)
            {
              localObject2 = new JsapiPermissionWrapper(new byte[0]);
              i = 0;
              localObject1 = (HashMap)this.PYY.get(localObject1);
              localObject3 = ((HashMap)localObject1).keySet().iterator();
            }
          }
        }
        label204:
        label371:
        label374:
        for (;;)
        {
          String str;
          Object localObject4;
          if (((Iterator)localObject3).hasNext())
          {
            str = (String)((Iterator)localObject3).next();
            localObject4 = n.PJr;
            localObject4 = n.bjL(str);
            if (localObject4 == null) {
              break label371;
            }
          }
          for (int j = ((c.g)localObject4).hoG();; j = -1)
          {
            if (j < 0) {
              break label374;
            }
            if (i != 0) {}
            int m;
            for (int k = ((JsapiPermissionWrapper)localObject2).arj(j);; k = 2)
            {
              m = ((ezy)((HashMap)localObject1).get(str)).state;
              if (k != 0) {
                break label310;
              }
              ((JsapiPermissionWrapper)localObject2).a(j, (byte)0);
              break label204;
              localObject2 = ((JsapiPermissionWrapper)localObject2).hpd();
              i = 1;
              break;
            }
            if (k == 2)
            {
              ((JsapiPermissionWrapper)localObject2).a(j, (byte)m);
              break label204;
            }
            ((JsapiPermissionWrapper)localObject2).a(j, (byte)k);
            break label204;
            localObject3 = localObject2;
            if (localObject3 == null)
            {
              localObject1 = this.PYP;
              AppMethodBeat.o(211003);
              return localObject1;
            }
            AppMethodBeat.o(211003);
            return localObject3;
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
  
  public final GeneralControlWrapper gWJ()
  {
    GeneralControlWrapper localGeneralControlWrapper = null;
    AppMethodBeat.i(211009);
    if (this.PYO != null)
    {
      Log.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.PYO);
      localObject = this.PYO;
      AppMethodBeat.o(211009);
      return localObject;
    }
    if (this.PYZ != null)
    {
      a locala = blF(this.PYZ.gSD());
      localObject = locala;
      if (locala != null) {}
    }
    for (Object localObject = blF(this.PYZ.gSE());; localObject = null)
    {
      if (localObject != null) {
        localGeneralControlWrapper = ((a)localObject).PYR;
      }
      if (localGeneralControlWrapper == null)
      {
        localObject = this.PYQ;
        AppMethodBeat.o(211009);
        return localObject;
      }
      AppMethodBeat.o(211009);
      return localGeneralControlWrapper;
    }
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(211000);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewPermission", "has fail, url is null");
      AppMethodBeat.o(211000);
      return false;
    }
    paramString = bks(paramString);
    if (this.PYM == null)
    {
      Log.e("MicroMsg.WebViewPermission", "has fail, permMap is null");
      AppMethodBeat.o(211000);
      return false;
    }
    paramString = (a)this.PYM.get(paramString);
    if ((paramString != null) && (paramString.PvI != this.PYP) && (paramString.PYR != this.PYQ))
    {
      AppMethodBeat.o(211000);
      return true;
    }
    AppMethodBeat.o(211000);
    return false;
  }
  
  static final class a
  {
    public GeneralControlWrapper PYR;
    public JsapiPermissionWrapper PvI;
    
    public a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
    {
      this.PvI = paramJsapiPermissionWrapper;
      this.PYR = paramGeneralControlWrapper;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(214338);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Permission: jsPerm = ");
      ((StringBuilder)localObject).append(this.PvI);
      ((StringBuilder)localObject).append(", genCtrl = ");
      ((StringBuilder)localObject).append(this.PYR);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(214338);
      return localObject;
    }
  }
  
  public static abstract interface b
  {
    public abstract String gSD();
    
    public abstract String gSE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.g
 * JD-Core Version:    0.7.0.1
 */