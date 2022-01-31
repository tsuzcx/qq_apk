package com.tencent.mm.plugin.webview.luggage.permission;

import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.aak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  Map<String, a.a> reE = new HashMap();
  JsapiPermissionWrapper reF = null;
  GeneralControlWrapper reG;
  final JsapiPermissionWrapper reH = new JsapiPermissionWrapper(2);
  final GeneralControlWrapper reI = GeneralControlWrapper.spk;
  
  public a()
  {
    if ((ae.eSK == null) || (ae.eSK.length() == 0))
    {
      y.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
      this.reG = null;
      if ((ae.eSL != null) && (ae.eSL.length() != 0)) {
        break label213;
      }
      y.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
    }
    for (;;)
    {
      int i;
      for (;;)
      {
        y.i("MicroMsg.LuggageGetA8KeyPermission", "hardcodeJsPerm = " + null + ", hardcodeGenCtrl = " + null);
        return;
        try
        {
          i = bk.getInt(ae.eSK, 0);
          if (i < 0) {
            y.w("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
          }
        }
        catch (Exception localException1)
        {
          y.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + localException1.getMessage());
          this.reF = null;
        }
      }
      for (;;)
      {
        y.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.reF);
        break;
        this.reF = new JsapiPermissionWrapper(i);
      }
      try
      {
        label213:
        i = bk.getInt(ae.eSL, 0);
        y.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
        aak localaak = new aak();
        localaak.sZE = i;
        this.reG = new GeneralControlWrapper(localaak);
        y.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.reG);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          y.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { localException2.getMessage() });
          this.reG = null;
        }
      }
    }
  }
  
  static String RL(String paramString)
  {
    int i = paramString.indexOf("#");
    if (i < 0) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.LuggageGetA8KeyPermission", "update fail, url is null");
      return;
    }
    paramString = RL(paramString);
    y.i("MicroMsg.LuggageGetA8KeyPermission", "edw update, jsPerm = " + paramJsapiPermissionWrapper + ", genCtrl = " + paramGeneralControlWrapper + ", url = " + paramString);
    this.reE.put(paramString, new a.a(paramJsapiPermissionWrapper, paramGeneralControlWrapper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.permission.a
 * JD-Core Version:    0.7.0.1
 */