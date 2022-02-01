package com.tencent.mm.plugin.webview.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  Map<String, a> Jce;
  private JsapiPermissionWrapper Jcf;
  private GeneralControlWrapper Jcg;
  final JsapiPermissionWrapper Jch;
  final GeneralControlWrapper Jci;
  
  public d()
  {
    AppMethodBeat.i(224483);
    this.Jce = new HashMap();
    this.Jch = new JsapiPermissionWrapper(2);
    this.Jci = GeneralControlWrapper.Kzh;
    this.Jcf = null;
    if ((ac.jOx == null) || (ac.jOx.length() == 0))
    {
      Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
      this.Jcg = null;
      if ((ac.jOy != null) && (ac.jOy.length() != 0)) {
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
        AppMethodBeat.o(224483);
        return;
        try
        {
          i = Util.getInt(ac.jOx, 0);
          if (i < 0) {
            Log.w("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
          }
        }
        catch (Exception localException1)
        {
          Log.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + localException1.getMessage());
          this.Jcf = null;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.Jcf);
        break;
        this.Jcf = new JsapiPermissionWrapper(i);
      }
      try
      {
        label223:
        i = Util.getInt(ac.jOy, 0);
        Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
        bgt localbgt = new bgt();
        localbgt.LQC = i;
        this.Jcg = new GeneralControlWrapper(localbgt);
        Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.Jcg);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { localException2.getMessage() });
          this.Jcg = null;
        }
      }
    }
  }
  
  static String aYy(String paramString)
  {
    AppMethodBeat.i(224487);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(224487);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(224487);
    return paramString;
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(224484);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.LuggageGetA8KeyPermission", "update fail, url is null");
      AppMethodBeat.o(224484);
      return;
    }
    paramString = aYy(paramString);
    Log.i("MicroMsg.LuggageGetA8KeyPermission", "edw update, jsPerm = " + paramJsapiPermissionWrapper + ", genCtrl = " + paramGeneralControlWrapper + ", url = " + paramString);
    this.Jce.put(paramString, new a(paramJsapiPermissionWrapper, paramGeneralControlWrapper));
    AppMethodBeat.o(224484);
  }
  
  public final JsapiPermissionWrapper aZE(String paramString)
  {
    AppMethodBeat.i(224485);
    if (this.Jcf != null)
    {
      Log.i("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm, return hardcodeJsPerm = " + this.Jcf);
      paramString = this.Jcf;
      AppMethodBeat.o(224485);
      return paramString;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.Jch;
      AppMethodBeat.o(224485);
      return paramString;
    }
    paramString = aYy(paramString);
    if (this.Jce == null)
    {
      Log.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, permMap is null");
      paramString = this.Jch;
      AppMethodBeat.o(224485);
      return paramString;
    }
    paramString = (a)this.Jce.get(paramString);
    if (paramString == null)
    {
      paramString = this.Jch;
      AppMethodBeat.o(224485);
      return paramString;
    }
    paramString = paramString.IBv;
    AppMethodBeat.o(224485);
    return paramString;
  }
  
  public final GeneralControlWrapper aZF(String paramString)
  {
    AppMethodBeat.i(224486);
    if (this.Jcg != null)
    {
      Log.i("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.Jcg);
      paramString = this.Jcg;
      AppMethodBeat.o(224486);
      return paramString;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.Jci;
      AppMethodBeat.o(224486);
      return paramString;
    }
    String str = aYy(paramString);
    a locala = (a)this.Jce.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.Jcj)
    {
      Log.i("MicroMsg.LuggageGetA8KeyPermission", paramString + ", url = " + str);
      if (locala != null) {
        break;
      }
      paramString = this.Jci;
      AppMethodBeat.o(224486);
      return paramString;
    }
    paramString = locala.Jcj;
    AppMethodBeat.o(224486);
    return paramString;
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
      AppMethodBeat.i(224482);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Permission: jsPerm = ");
      ((StringBuilder)localObject).append(this.IBv);
      ((StringBuilder)localObject).append(", genCtrl = ");
      ((StringBuilder)localObject).append(this.Jcj);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(224482);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.d
 * JD-Core Version:    0.7.0.1
 */