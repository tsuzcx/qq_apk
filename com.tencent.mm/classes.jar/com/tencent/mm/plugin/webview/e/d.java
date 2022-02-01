package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  Map<String, a> EoY;
  private JsapiPermissionWrapper EoZ;
  private GeneralControlWrapper Epa;
  final JsapiPermissionWrapper Epb;
  final GeneralControlWrapper Epc;
  
  public d()
  {
    AppMethodBeat.i(213803);
    this.EoY = new HashMap();
    this.Epb = new JsapiPermissionWrapper(2);
    this.Epc = GeneralControlWrapper.FFY;
    this.EoZ = null;
    if ((ac.iRC == null) || (ac.iRC.length() == 0))
    {
      ae.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
      this.Epa = null;
      if ((ac.iRD != null) && (ac.iRD.length() != 0)) {
        break label223;
      }
      ae.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
    }
    for (;;)
    {
      int i;
      for (;;)
      {
        ae.i("MicroMsg.LuggageGetA8KeyPermission", "hardcodeJsPerm = " + null + ", hardcodeGenCtrl = " + null);
        AppMethodBeat.o(213803);
        return;
        try
        {
          i = bu.getInt(ac.iRC, 0);
          if (i < 0) {
            ae.w("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
          }
        }
        catch (Exception localException1)
        {
          ae.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + localException1.getMessage());
          this.EoZ = null;
        }
      }
      for (;;)
      {
        ae.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.EoZ);
        break;
        this.EoZ = new JsapiPermissionWrapper(i);
      }
      try
      {
        label223:
        i = bu.getInt(ac.iRD, 0);
        ae.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
        avj localavj = new avj();
        localavj.GMw = i;
        this.Epa = new GeneralControlWrapper(localavj);
        ae.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.Epa);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { localException2.getMessage() });
          this.Epa = null;
        }
      }
    }
  }
  
  static String aIw(String paramString)
  {
    AppMethodBeat.i(213807);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(213807);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(213807);
    return paramString;
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(213804);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.LuggageGetA8KeyPermission", "update fail, url is null");
      AppMethodBeat.o(213804);
      return;
    }
    paramString = aIw(paramString);
    ae.i("MicroMsg.LuggageGetA8KeyPermission", "edw update, jsPerm = " + paramJsapiPermissionWrapper + ", genCtrl = " + paramGeneralControlWrapper + ", url = " + paramString);
    this.EoY.put(paramString, new a(paramJsapiPermissionWrapper, paramGeneralControlWrapper));
    AppMethodBeat.o(213804);
  }
  
  public final JsapiPermissionWrapper aJx(String paramString)
  {
    AppMethodBeat.i(213805);
    if (this.EoZ != null)
    {
      ae.i("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm, return hardcodeJsPerm = " + this.EoZ);
      paramString = this.EoZ;
      AppMethodBeat.o(213805);
      return paramString;
    }
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.Epb;
      AppMethodBeat.o(213805);
      return paramString;
    }
    paramString = aIw(paramString);
    if (this.EoY == null)
    {
      ae.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, permMap is null");
      paramString = this.Epb;
      AppMethodBeat.o(213805);
      return paramString;
    }
    paramString = (a)this.EoY.get(paramString);
    if (paramString == null)
    {
      paramString = this.Epb;
      AppMethodBeat.o(213805);
      return paramString;
    }
    paramString = paramString.DRw;
    AppMethodBeat.o(213805);
    return paramString;
  }
  
  public final GeneralControlWrapper aJy(String paramString)
  {
    AppMethodBeat.i(213806);
    if (this.Epa != null)
    {
      ae.i("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.Epa);
      paramString = this.Epa;
      AppMethodBeat.o(213806);
      return paramString;
    }
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.Epc;
      AppMethodBeat.o(213806);
      return paramString;
    }
    String str = aIw(paramString);
    a locala = (a)this.EoY.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.Epd)
    {
      ae.i("MicroMsg.LuggageGetA8KeyPermission", paramString + ", url = " + str);
      if (locala != null) {
        break;
      }
      paramString = this.Epc;
      AppMethodBeat.o(213806);
      return paramString;
    }
    paramString = locala.Epd;
    AppMethodBeat.o(213806);
    return paramString;
  }
  
  static final class a
  {
    public JsapiPermissionWrapper DRw;
    public GeneralControlWrapper Epd;
    
    public a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
    {
      this.DRw = paramJsapiPermissionWrapper;
      this.Epd = paramGeneralControlWrapper;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(213802);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Permission: jsPerm = ");
      ((StringBuilder)localObject).append(this.DRw);
      ((StringBuilder)localObject).append(", genCtrl = ");
      ((StringBuilder)localObject).append(this.Epd);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(213802);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.d
 * JD-Core Version:    0.7.0.1
 */