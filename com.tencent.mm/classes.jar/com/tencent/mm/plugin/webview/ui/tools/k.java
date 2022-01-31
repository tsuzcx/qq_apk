package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.webview.modeltools.c;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class k
{
  Map<String, k.a> uUM;
  private JsapiPermissionWrapper uUN;
  private GeneralControlWrapper uUO;
  private final JsapiPermissionWrapper uUP;
  private final GeneralControlWrapper uUQ;
  private b vcT;
  
  public k(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper, b paramb)
  {
    AppMethodBeat.i(7688);
    this.uUP = new JsapiPermissionWrapper(2);
    this.uUQ = GeneralControlWrapper.whY;
    this.uUN = paramJsapiPermissionWrapper;
    if ((ae.gkF == null) || (ae.gkF.length() == 0))
    {
      ab.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
      this.uUO = paramGeneralControlWrapper;
      if ((ae.gkG != null) && (ae.gkG.length() != 0)) {
        break label235;
      }
      ab.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
    }
    for (;;)
    {
      int i;
      for (;;)
      {
        this.vcT = paramb;
        ab.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + paramJsapiPermissionWrapper + ", hardcodeGenCtrl = " + paramGeneralControlWrapper);
        this.uUM = new HashMap();
        AppMethodBeat.o(7688);
        return;
        try
        {
          i = bo.getInt(ae.gkF, 0);
          if (i < 0) {
            ab.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
          }
        }
        catch (Exception localException1)
        {
          ab.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + localException1.getMessage());
          this.uUN = null;
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.uUN);
        break;
        this.uUN = new JsapiPermissionWrapper(i);
      }
      try
      {
        label235:
        i = bo.getInt(ae.gkG, 0);
        ab.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
        afc localafc = new afc();
        localafc.wXX = i;
        this.uUO = new GeneralControlWrapper(localafc);
        ab.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.uUO);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ab.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { localException2.getMessage() });
          this.uUO = null;
        }
      }
    }
  }
  
  private static String agP(String paramString)
  {
    AppMethodBeat.i(7695);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(7695);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(7695);
    return paramString;
  }
  
  private GeneralControlWrapper agT(String paramString)
  {
    AppMethodBeat.i(7694);
    if (this.uUO != null)
    {
      ab.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.uUO);
      paramString = this.uUO;
      AppMethodBeat.o(7694);
      return paramString;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WebViewPermission", "getGenCtrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.uUQ;
      AppMethodBeat.o(7694);
      return paramString;
    }
    String str = agP(paramString);
    k.a locala = (k.a)this.uUM.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.uUS)
    {
      ab.i("MicroMsg.WebViewPermission", paramString + ", url = " + str);
      if (locala != null) {
        break;
      }
      paramString = this.uUQ;
      AppMethodBeat.o(7694);
      return paramString;
    }
    paramString = locala.uUS;
    AppMethodBeat.o(7694);
    return paramString;
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(7689);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WebViewPermission", "update fail, url is null");
      AppMethodBeat.o(7689);
      return;
    }
    if (paramGeneralControlWrapper != null)
    {
      bool1 = bool2;
      if ((paramGeneralControlWrapper.whZ & 0x80000) != 0) {
        bool1 = true;
      }
      ab.d("MicroMsg.GeneralControlWrapper", "needClearData, ret = ".concat(String.valueOf(bool1)));
    }
    c.bM(paramString, bool1);
    String str = agP(paramString);
    paramString = paramJsapiPermissionWrapper;
    if (paramJsapiPermissionWrapper == null) {
      paramString = this.uUP;
    }
    paramJsapiPermissionWrapper = paramGeneralControlWrapper;
    if (paramGeneralControlWrapper == null) {
      paramJsapiPermissionWrapper = this.uUQ;
    }
    ab.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + paramString + ", genCtrl = " + paramJsapiPermissionWrapper + ", url = " + str);
    this.uUM.put(str, new k.a(paramString, paramJsapiPermissionWrapper));
    AppMethodBeat.o(7689);
  }
  
  public final JsapiPermissionWrapper agS(String paramString)
  {
    AppMethodBeat.i(7692);
    if (this.uUN != null)
    {
      ab.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.uUN);
      paramString = this.uUN;
      AppMethodBeat.o(7692);
      return paramString;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WebViewPermission", "getJsPerm fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.uUP;
      AppMethodBeat.o(7692);
      return paramString;
    }
    paramString = agP(paramString);
    if (this.uUM == null)
    {
      ab.e("MicroMsg.WebViewPermission", "getJsPerm fail, permMap is null");
      paramString = this.uUP;
      AppMethodBeat.o(7692);
      return paramString;
    }
    paramString = (k.a)this.uUM.get(paramString);
    if (paramString == null)
    {
      paramString = this.uUP;
      AppMethodBeat.o(7692);
      return paramString;
    }
    paramString = paramString.uUR;
    AppMethodBeat.o(7692);
    return paramString;
  }
  
  public final JsapiPermissionWrapper ddV()
  {
    AppMethodBeat.i(7691);
    if (this.uUN != null)
    {
      ab.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.uUN);
      localObject = this.uUN;
      AppMethodBeat.o(7691);
      return localObject;
    }
    if (this.vcT != null) {}
    for (Object localObject = this.vcT.aYZ();; localObject = null)
    {
      localObject = agS((String)localObject);
      AppMethodBeat.o(7691);
      return localObject;
    }
  }
  
  public final GeneralControlWrapper ddW()
  {
    AppMethodBeat.i(7693);
    if (this.vcT != null) {}
    for (Object localObject = this.vcT.aYZ();; localObject = null)
    {
      localObject = agT((String)localObject);
      AppMethodBeat.o(7693);
      return localObject;
    }
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(7690);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WebViewPermission", "has fail, url is null");
      AppMethodBeat.o(7690);
      return false;
    }
    paramString = agP(paramString);
    paramString = (k.a)this.uUM.get(paramString);
    if ((paramString != null) && (paramString.uUR != this.uUP) && (paramString.uUS != this.uUQ))
    {
      AppMethodBeat.o(7690);
      return true;
    }
    AppMethodBeat.o(7690);
    return false;
  }
  
  public static abstract interface b
  {
    public abstract String aYZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.k
 * JD-Core Version:    0.7.0.1
 */