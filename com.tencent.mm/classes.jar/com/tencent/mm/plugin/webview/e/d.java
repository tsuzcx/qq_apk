package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  private Map<String, a> WPq;
  private JsapiPermissionWrapper WPr;
  private GeneralControlWrapper WPs;
  private final JsapiPermissionWrapper WPt;
  private final GeneralControlWrapper WPu;
  
  public d()
  {
    AppMethodBeat.i(294829);
    this.WPq = new HashMap();
    this.WPt = new JsapiPermissionWrapper(2);
    this.WPu = GeneralControlWrapper.YxB;
    this.WPr = null;
    if ((z.pCh == null) || (z.pCh.length() == 0))
    {
      Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
      this.WPs = null;
      if ((z.pCi != null) && (z.pCi.length() != 0)) {
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
        AppMethodBeat.o(294829);
        return;
        try
        {
          i = Util.getInt(z.pCh, 0);
          if (i < 0) {
            Log.w("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
          }
        }
        catch (Exception localException1)
        {
          Log.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + localException1.getMessage());
          this.WPr = null;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.WPr);
        break;
        this.WPr = new JsapiPermissionWrapper(i);
      }
      try
      {
        label223:
        i = Util.getInt(z.pCi, 0);
        Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
        ccm localccm = new ccm();
        localccm.aalV = i;
        this.WPs = new GeneralControlWrapper(localccm);
        Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.WPs);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { localException2.getMessage() });
          this.WPs = null;
        }
      }
    }
  }
  
  private static String bkc(String paramString)
  {
    AppMethodBeat.i(294835);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(294835);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(294835);
    return paramString;
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(294840);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.LuggageGetA8KeyPermission", "update fail, url is null");
      AppMethodBeat.o(294840);
      return;
    }
    paramString = bkc(paramString);
    Log.i("MicroMsg.LuggageGetA8KeyPermission", "edw update, jsPerm = " + paramJsapiPermissionWrapper + ", genCtrl = " + paramGeneralControlWrapper + ", url = " + paramString);
    this.WPq.put(paramString, new a(paramJsapiPermissionWrapper, paramGeneralControlWrapper));
    AppMethodBeat.o(294840);
  }
  
  public final GeneralControlWrapper blc(String paramString)
  {
    AppMethodBeat.i(294862);
    if (this.WPs != null)
    {
      Log.i("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.WPs);
      paramString = this.WPs;
      AppMethodBeat.o(294862);
      return paramString;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.WPu;
      AppMethodBeat.o(294862);
      return paramString;
    }
    String str = bkc(paramString);
    a locala = (a)this.WPq.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.WPv)
    {
      Log.i("MicroMsg.LuggageGetA8KeyPermission", paramString + ", url = " + str);
      if (locala != null) {
        break;
      }
      paramString = this.WPu;
      AppMethodBeat.o(294862);
      return paramString;
    }
    paramString = locala.WPv;
    AppMethodBeat.o(294862);
    return paramString;
  }
  
  public final JsapiPermissionWrapper blf(String paramString)
  {
    AppMethodBeat.i(294855);
    if (this.WPr != null)
    {
      Log.i("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm, return hardcodeJsPerm = " + this.WPr);
      paramString = this.WPr;
      AppMethodBeat.o(294855);
      return paramString;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.WPt;
      AppMethodBeat.o(294855);
      return paramString;
    }
    paramString = bkc(paramString);
    if (this.WPq == null)
    {
      Log.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, permMap is null");
      paramString = this.WPt;
      AppMethodBeat.o(294855);
      return paramString;
    }
    paramString = (a)this.WPq.get(paramString);
    if (paramString == null)
    {
      paramString = this.WPt;
      AppMethodBeat.o(294855);
      return paramString;
    }
    paramString = paramString.WlV;
    AppMethodBeat.o(294855);
    return paramString;
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(294848);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.LuggageGetA8KeyPermission", "has fail, url is null");
      AppMethodBeat.o(294848);
      return false;
    }
    paramString = bkc(paramString);
    paramString = (a)this.WPq.get(paramString);
    if ((paramString != null) && (paramString.WlV != this.WPt) && (paramString.WPv != this.WPu))
    {
      AppMethodBeat.o(294848);
      return true;
    }
    AppMethodBeat.o(294848);
    return false;
  }
  
  static final class a
  {
    public GeneralControlWrapper WPv;
    public JsapiPermissionWrapper WlV;
    
    public a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
    {
      this.WlV = paramJsapiPermissionWrapper;
      this.WPv = paramGeneralControlWrapper;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(294804);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Permission: jsPerm = ");
      ((StringBuilder)localObject).append(this.WlV);
      ((StringBuilder)localObject).append(", genCtrl = ");
      ((StringBuilder)localObject).append(this.WPv);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(294804);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.d
 * JD-Core Version:    0.7.0.1
 */