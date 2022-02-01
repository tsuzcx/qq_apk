package com.tencent.mm.plugin.webview.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  private Map<String, a> PYM;
  private JsapiPermissionWrapper PYN;
  private GeneralControlWrapper PYO;
  private final JsapiPermissionWrapper PYP;
  private final GeneralControlWrapper PYQ;
  
  public d()
  {
    AppMethodBeat.i(211840);
    this.PYM = new HashMap();
    this.PYP = new JsapiPermissionWrapper(2);
    this.PYQ = GeneralControlWrapper.RAY;
    this.PYN = null;
    if ((ac.mFH == null) || (ac.mFH.length() == 0))
    {
      Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
      this.PYO = null;
      if ((ac.mFI != null) && (ac.mFI.length() != 0)) {
        break label223;
      }
      Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
    }
    for (;;)
    {
      int i;
      for (;;)
      {
        Log.i("MicroMsg.LuggageGetA8KeyPermission", "hardcodeJsPerm = " + null + ", hardcodeGenCtrl = " + null);
        AppMethodBeat.o(211840);
        return;
        try
        {
          i = Util.getInt(ac.mFH, 0);
          if (i < 0) {
            Log.w("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
          }
        }
        catch (Exception localException1)
        {
          Log.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + localException1.getMessage());
          this.PYN = null;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.PYN);
        break;
        this.PYN = new JsapiPermissionWrapper(i);
      }
      try
      {
        label223:
        i = Util.getInt(ac.mFI, 0);
        Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
        bob localbob = new bob();
        localbob.SZd = i;
        this.PYO = new GeneralControlWrapper(localbob);
        Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.PYO);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { localException2.getMessage() });
          this.PYO = null;
        }
      }
    }
  }
  
  private static String bks(String paramString)
  {
    AppMethodBeat.i(211857);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(211857);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(211857);
    return paramString;
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(211845);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.LuggageGetA8KeyPermission", "update fail, url is null");
      AppMethodBeat.o(211845);
      return;
    }
    paramString = bks(paramString);
    Log.i("MicroMsg.LuggageGetA8KeyPermission", "edw update, jsPerm = " + paramJsapiPermissionWrapper + ", genCtrl = " + paramGeneralControlWrapper + ", url = " + paramString);
    this.PYM.put(paramString, new a(paramJsapiPermissionWrapper, paramGeneralControlWrapper));
    AppMethodBeat.o(211845);
  }
  
  public final GeneralControlWrapper blA(String paramString)
  {
    AppMethodBeat.i(211854);
    if (this.PYO != null)
    {
      Log.i("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.PYO);
      paramString = this.PYO;
      AppMethodBeat.o(211854);
      return paramString;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.PYQ;
      AppMethodBeat.o(211854);
      return paramString;
    }
    String str = bks(paramString);
    a locala = (a)this.PYM.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.PYR)
    {
      Log.i("MicroMsg.LuggageGetA8KeyPermission", paramString + ", url = " + str);
      if (locala != null) {
        break;
      }
      paramString = this.PYQ;
      AppMethodBeat.o(211854);
      return paramString;
    }
    paramString = locala.PYR;
    AppMethodBeat.o(211854);
    return paramString;
  }
  
  public final JsapiPermissionWrapper blE(String paramString)
  {
    AppMethodBeat.i(211852);
    if (this.PYN != null)
    {
      Log.i("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm, return hardcodeJsPerm = " + this.PYN);
      paramString = this.PYN;
      AppMethodBeat.o(211852);
      return paramString;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.PYP;
      AppMethodBeat.o(211852);
      return paramString;
    }
    paramString = bks(paramString);
    if (this.PYM == null)
    {
      Log.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, permMap is null");
      paramString = this.PYP;
      AppMethodBeat.o(211852);
      return paramString;
    }
    paramString = (a)this.PYM.get(paramString);
    if (paramString == null)
    {
      paramString = this.PYP;
      AppMethodBeat.o(211852);
      return paramString;
    }
    paramString = paramString.PvI;
    AppMethodBeat.o(211852);
    return paramString;
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(211848);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.LuggageGetA8KeyPermission", "has fail, url is null");
      AppMethodBeat.o(211848);
      return false;
    }
    paramString = bks(paramString);
    paramString = (a)this.PYM.get(paramString);
    if ((paramString != null) && (paramString.PvI != this.PYP) && (paramString.PYR != this.PYQ))
    {
      AppMethodBeat.o(211848);
      return true;
    }
    AppMethodBeat.o(211848);
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
      AppMethodBeat.i(207661);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Permission: jsPerm = ");
      ((StringBuilder)localObject).append(this.PvI);
      ((StringBuilder)localObject).append(", genCtrl = ");
      ((StringBuilder)localObject).append(this.PYR);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(207661);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.d
 * JD-Core Version:    0.7.0.1
 */