package com.tencent.mm.plugin.webview.luggage.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  Map<String, a.a> uUM;
  private JsapiPermissionWrapper uUN;
  private GeneralControlWrapper uUO;
  final JsapiPermissionWrapper uUP;
  final GeneralControlWrapper uUQ;
  
  public a()
  {
    AppMethodBeat.i(6482);
    this.uUM = new HashMap();
    this.uUP = new JsapiPermissionWrapper(2);
    this.uUQ = GeneralControlWrapper.whY;
    this.uUN = null;
    if ((ae.gkF == null) || (ae.gkF.length() == 0))
    {
      ab.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
      this.uUO = null;
      if ((ae.gkG != null) && (ae.gkG.length() != 0)) {
        break label225;
      }
      ab.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
    }
    for (;;)
    {
      int i;
      for (;;)
      {
        ab.i("MicroMsg.LuggageGetA8KeyPermission", "hardcodeJsPerm = " + null + ", hardcodeGenCtrl = " + null);
        AppMethodBeat.o(6482);
        return;
        try
        {
          i = bo.getInt(ae.gkF, 0);
          if (i < 0) {
            ab.w("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
          }
        }
        catch (Exception localException1)
        {
          ab.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + localException1.getMessage());
          this.uUN = null;
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.uUN);
        break;
        this.uUN = new JsapiPermissionWrapper(i);
      }
      try
      {
        label225:
        i = bo.getInt(ae.gkG, 0);
        ab.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
        afc localafc = new afc();
        localafc.wXX = i;
        this.uUO = new GeneralControlWrapper(localafc);
        ab.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.uUO);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ab.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { localException2.getMessage() });
          this.uUO = null;
        }
      }
    }
  }
  
  static String agP(String paramString)
  {
    AppMethodBeat.i(6486);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(6486);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(6486);
    return paramString;
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(6483);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.LuggageGetA8KeyPermission", "update fail, url is null");
      AppMethodBeat.o(6483);
      return;
    }
    paramString = agP(paramString);
    ab.i("MicroMsg.LuggageGetA8KeyPermission", "edw update, jsPerm = " + paramJsapiPermissionWrapper + ", genCtrl = " + paramGeneralControlWrapper + ", url = " + paramString);
    this.uUM.put(paramString, new a.a(paramJsapiPermissionWrapper, paramGeneralControlWrapper));
    AppMethodBeat.o(6483);
  }
  
  public final JsapiPermissionWrapper agS(String paramString)
  {
    AppMethodBeat.i(6484);
    if (this.uUN != null)
    {
      ab.i("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm, return hardcodeJsPerm = " + this.uUN);
      paramString = this.uUN;
      AppMethodBeat.o(6484);
      return paramString;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.uUP;
      AppMethodBeat.o(6484);
      return paramString;
    }
    paramString = agP(paramString);
    if (this.uUM == null)
    {
      ab.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, permMap is null");
      paramString = this.uUP;
      AppMethodBeat.o(6484);
      return paramString;
    }
    paramString = (a.a)this.uUM.get(paramString);
    if (paramString == null)
    {
      paramString = this.uUP;
      AppMethodBeat.o(6484);
      return paramString;
    }
    paramString = paramString.uUR;
    AppMethodBeat.o(6484);
    return paramString;
  }
  
  public final GeneralControlWrapper agT(String paramString)
  {
    AppMethodBeat.i(6485);
    if (this.uUO != null)
    {
      ab.i("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.uUO);
      paramString = this.uUO;
      AppMethodBeat.o(6485);
      return paramString;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.uUQ;
      AppMethodBeat.o(6485);
      return paramString;
    }
    String str = agP(paramString);
    a.a locala = (a.a)this.uUM.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.uUS)
    {
      ab.i("MicroMsg.LuggageGetA8KeyPermission", paramString + ", url = " + str);
      if (locala != null) {
        break;
      }
      paramString = this.uUQ;
      AppMethodBeat.o(6485);
      return paramString;
    }
    paramString = locala.uUS;
    AppMethodBeat.o(6485);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.permission.a
 * JD-Core Version:    0.7.0.1
 */