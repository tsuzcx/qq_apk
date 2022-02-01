package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  Map<String, a> DWW;
  private JsapiPermissionWrapper DWX;
  private GeneralControlWrapper DWY;
  final JsapiPermissionWrapper DWZ;
  final GeneralControlWrapper DXa;
  
  public d()
  {
    AppMethodBeat.i(213972);
    this.DWW = new HashMap();
    this.DWZ = new JsapiPermissionWrapper(2);
    this.DXa = GeneralControlWrapper.FnA;
    this.DWX = null;
    if ((ac.iOI == null) || (ac.iOI.length() == 0))
    {
      ad.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
      this.DWY = null;
      if ((ac.iOJ != null) && (ac.iOJ.length() != 0)) {
        break label223;
      }
      ad.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
    }
    for (;;)
    {
      int i;
      for (;;)
      {
        ad.i("MicroMsg.LuggageGetA8KeyPermission", "hardcodeJsPerm = " + null + ", hardcodeGenCtrl = " + null);
        AppMethodBeat.o(213972);
        return;
        try
        {
          i = bt.getInt(ac.iOI, 0);
          if (i < 0) {
            ad.w("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
          }
        }
        catch (Exception localException1)
        {
          ad.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + localException1.getMessage());
          this.DWX = null;
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.DWX);
        break;
        this.DWX = new JsapiPermissionWrapper(i);
      }
      try
      {
        label223:
        i = bt.getInt(ac.iOJ, 0);
        ad.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
        aut localaut = new aut();
        localaut.GsY = i;
        this.DWY = new GeneralControlWrapper(localaut);
        ad.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.DWY);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { localException2.getMessage() });
          this.DWY = null;
        }
      }
    }
  }
  
  static String aHc(String paramString)
  {
    AppMethodBeat.i(213976);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(213976);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(213976);
    return paramString;
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(213973);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.LuggageGetA8KeyPermission", "update fail, url is null");
      AppMethodBeat.o(213973);
      return;
    }
    paramString = aHc(paramString);
    ad.i("MicroMsg.LuggageGetA8KeyPermission", "edw update, jsPerm = " + paramJsapiPermissionWrapper + ", genCtrl = " + paramGeneralControlWrapper + ", url = " + paramString);
    this.DWW.put(paramString, new a(paramJsapiPermissionWrapper, paramGeneralControlWrapper));
    AppMethodBeat.o(213973);
  }
  
  public final JsapiPermissionWrapper aIe(String paramString)
  {
    AppMethodBeat.i(213974);
    if (this.DWX != null)
    {
      ad.i("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm, return hardcodeJsPerm = " + this.DWX);
      paramString = this.DWX;
      AppMethodBeat.o(213974);
      return paramString;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.DWZ;
      AppMethodBeat.o(213974);
      return paramString;
    }
    paramString = aHc(paramString);
    if (this.DWW == null)
    {
      ad.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, permMap is null");
      paramString = this.DWZ;
      AppMethodBeat.o(213974);
      return paramString;
    }
    paramString = (a)this.DWW.get(paramString);
    if (paramString == null)
    {
      paramString = this.DWZ;
      AppMethodBeat.o(213974);
      return paramString;
    }
    paramString = paramString.DzO;
    AppMethodBeat.o(213974);
    return paramString;
  }
  
  public final GeneralControlWrapper aIf(String paramString)
  {
    AppMethodBeat.i(213975);
    if (this.DWY != null)
    {
      ad.i("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.DWY);
      paramString = this.DWY;
      AppMethodBeat.o(213975);
      return paramString;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.DXa;
      AppMethodBeat.o(213975);
      return paramString;
    }
    String str = aHc(paramString);
    a locala = (a)this.DWW.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.DXb)
    {
      ad.i("MicroMsg.LuggageGetA8KeyPermission", paramString + ", url = " + str);
      if (locala != null) {
        break;
      }
      paramString = this.DXa;
      AppMethodBeat.o(213975);
      return paramString;
    }
    paramString = locala.DXb;
    AppMethodBeat.o(213975);
    return paramString;
  }
  
  static final class a
  {
    public GeneralControlWrapper DXb;
    public JsapiPermissionWrapper DzO;
    
    public a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
    {
      this.DzO = paramJsapiPermissionWrapper;
      this.DXb = paramGeneralControlWrapper;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(213971);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Permission: jsPerm = ");
      ((StringBuilder)localObject).append(this.DzO);
      ((StringBuilder)localObject).append(", genCtrl = ");
      ((StringBuilder)localObject).append(this.DXb);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(213971);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.d
 * JD-Core Version:    0.7.0.1
 */