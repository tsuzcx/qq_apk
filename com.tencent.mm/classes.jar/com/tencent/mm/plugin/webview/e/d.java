package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aqx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  Map<String, a> Ctq;
  private JsapiPermissionWrapper Ctr;
  private GeneralControlWrapper Cts;
  final JsapiPermissionWrapper Ctt;
  final GeneralControlWrapper Ctu;
  
  public d()
  {
    AppMethodBeat.i(205370);
    this.Ctq = new HashMap();
    this.Ctt = new JsapiPermissionWrapper(2);
    this.Ctu = GeneralControlWrapper.DIt;
    this.Ctr = null;
    if ((ab.ivB == null) || (ab.ivB.length() == 0))
    {
      ac.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
      this.Cts = null;
      if ((ab.ivC != null) && (ab.ivC.length() != 0)) {
        break label223;
      }
      ac.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
    }
    for (;;)
    {
      int i;
      for (;;)
      {
        ac.i("MicroMsg.LuggageGetA8KeyPermission", "hardcodeJsPerm = " + null + ", hardcodeGenCtrl = " + null);
        AppMethodBeat.o(205370);
        return;
        try
        {
          i = bs.getInt(ab.ivB, 0);
          if (i < 0) {
            ac.w("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
          }
        }
        catch (Exception localException1)
        {
          ac.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + localException1.getMessage());
          this.Ctr = null;
        }
      }
      for (;;)
      {
        ac.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.Ctr);
        break;
        this.Ctr = new JsapiPermissionWrapper(i);
      }
      try
      {
        label223:
        i = bs.getInt(ab.ivC, 0);
        ac.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
        aqx localaqx = new aqx();
        localaqx.EJW = i;
        this.Cts = new GeneralControlWrapper(localaqx);
        ac.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.Cts);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { localException2.getMessage() });
          this.Cts = null;
        }
      }
    }
  }
  
  static String aBE(String paramString)
  {
    AppMethodBeat.i(205374);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(205374);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(205374);
    return paramString;
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(205371);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.LuggageGetA8KeyPermission", "update fail, url is null");
      AppMethodBeat.o(205371);
      return;
    }
    paramString = aBE(paramString);
    ac.i("MicroMsg.LuggageGetA8KeyPermission", "edw update, jsPerm = " + paramJsapiPermissionWrapper + ", genCtrl = " + paramGeneralControlWrapper + ", url = " + paramString);
    this.Ctq.put(paramString, new a(paramJsapiPermissionWrapper, paramGeneralControlWrapper));
    AppMethodBeat.o(205371);
  }
  
  public final JsapiPermissionWrapper aCC(String paramString)
  {
    AppMethodBeat.i(205372);
    if (this.Ctr != null)
    {
      ac.i("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm, return hardcodeJsPerm = " + this.Ctr);
      paramString = this.Ctr;
      AppMethodBeat.o(205372);
      return paramString;
    }
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.Ctt;
      AppMethodBeat.o(205372);
      return paramString;
    }
    paramString = aBE(paramString);
    if (this.Ctq == null)
    {
      ac.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, permMap is null");
      paramString = this.Ctt;
      AppMethodBeat.o(205372);
      return paramString;
    }
    paramString = (a)this.Ctq.get(paramString);
    if (paramString == null)
    {
      paramString = this.Ctt;
      AppMethodBeat.o(205372);
      return paramString;
    }
    paramString = paramString.Cjp;
    AppMethodBeat.o(205372);
    return paramString;
  }
  
  public final GeneralControlWrapper aCD(String paramString)
  {
    AppMethodBeat.i(205373);
    if (this.Cts != null)
    {
      ac.i("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.Cts);
      paramString = this.Cts;
      AppMethodBeat.o(205373);
      return paramString;
    }
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.Ctu;
      AppMethodBeat.o(205373);
      return paramString;
    }
    String str = aBE(paramString);
    a locala = (a)this.Ctq.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.Ctv)
    {
      ac.i("MicroMsg.LuggageGetA8KeyPermission", paramString + ", url = " + str);
      if (locala != null) {
        break;
      }
      paramString = this.Ctu;
      AppMethodBeat.o(205373);
      return paramString;
    }
    paramString = locala.Ctv;
    AppMethodBeat.o(205373);
    return paramString;
  }
  
  static final class a
  {
    public JsapiPermissionWrapper Cjp;
    public GeneralControlWrapper Ctv;
    
    public a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
    {
      this.Cjp = paramJsapiPermissionWrapper;
      this.Ctv = paramGeneralControlWrapper;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205369);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Permission: jsPerm = ");
      ((StringBuilder)localObject).append(this.Cjp);
      ((StringBuilder)localObject).append(", genCtrl = ");
      ((StringBuilder)localObject).append(this.Ctv);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(205369);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.d
 * JD-Core Version:    0.7.0.1
 */