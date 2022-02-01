package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  Map<String, a> Bbe;
  private JsapiPermissionWrapper Bbf;
  private GeneralControlWrapper Bbg;
  final JsapiPermissionWrapper Bbh;
  final GeneralControlWrapper Bbi;
  
  public d()
  {
    AppMethodBeat.i(189741);
    this.Bbe = new HashMap();
    this.Bbh = new JsapiPermissionWrapper(2);
    this.Bbi = GeneralControlWrapper.Cqb;
    this.Bbf = null;
    if ((ab.hVx == null) || (ab.hVx.length() == 0))
    {
      ad.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
      this.Bbg = null;
      if ((ab.hVy != null) && (ab.hVy.length() != 0)) {
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
        AppMethodBeat.o(189741);
        return;
        try
        {
          i = bt.getInt(ab.hVx, 0);
          if (i < 0) {
            ad.w("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
          }
        }
        catch (Exception localException1)
        {
          ad.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + localException1.getMessage());
          this.Bbf = null;
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.Bbf);
        break;
        this.Bbf = new JsapiPermissionWrapper(i);
      }
      try
      {
        label223:
        i = bt.getInt(ab.hVy, 0);
        ad.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
        ant localant = new ant();
        localant.DoW = i;
        this.Bbg = new GeneralControlWrapper(localant);
        ad.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.Bbg);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { localException2.getMessage() });
          this.Bbg = null;
        }
      }
    }
  }
  
  static String awm(String paramString)
  {
    AppMethodBeat.i(189745);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(189745);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(189745);
    return paramString;
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(189742);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.LuggageGetA8KeyPermission", "update fail, url is null");
      AppMethodBeat.o(189742);
      return;
    }
    paramString = awm(paramString);
    ad.i("MicroMsg.LuggageGetA8KeyPermission", "edw update, jsPerm = " + paramJsapiPermissionWrapper + ", genCtrl = " + paramGeneralControlWrapper + ", url = " + paramString);
    this.Bbe.put(paramString, new a(paramJsapiPermissionWrapper, paramGeneralControlWrapper));
    AppMethodBeat.o(189742);
  }
  
  public final JsapiPermissionWrapper axk(String paramString)
  {
    AppMethodBeat.i(189743);
    if (this.Bbf != null)
    {
      ad.i("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm, return hardcodeJsPerm = " + this.Bbf);
      paramString = this.Bbf;
      AppMethodBeat.o(189743);
      return paramString;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.Bbh;
      AppMethodBeat.o(189743);
      return paramString;
    }
    paramString = awm(paramString);
    if (this.Bbe == null)
    {
      ad.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, permMap is null");
      paramString = this.Bbh;
      AppMethodBeat.o(189743);
      return paramString;
    }
    paramString = (a)this.Bbe.get(paramString);
    if (paramString == null)
    {
      paramString = this.Bbh;
      AppMethodBeat.o(189743);
      return paramString;
    }
    paramString = paramString.ARc;
    AppMethodBeat.o(189743);
    return paramString;
  }
  
  public final GeneralControlWrapper axl(String paramString)
  {
    AppMethodBeat.i(189744);
    if (this.Bbg != null)
    {
      ad.i("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.Bbg);
      paramString = this.Bbg;
      AppMethodBeat.o(189744);
      return paramString;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = this.Bbi;
      AppMethodBeat.o(189744);
      return paramString;
    }
    String str = awm(paramString);
    a locala = (a)this.Bbe.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.Bbj)
    {
      ad.i("MicroMsg.LuggageGetA8KeyPermission", paramString + ", url = " + str);
      if (locala != null) {
        break;
      }
      paramString = this.Bbi;
      AppMethodBeat.o(189744);
      return paramString;
    }
    paramString = locala.Bbj;
    AppMethodBeat.o(189744);
    return paramString;
  }
  
  static final class a
  {
    public JsapiPermissionWrapper ARc;
    public GeneralControlWrapper Bbj;
    
    public a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
    {
      this.ARc = paramJsapiPermissionWrapper;
      this.Bbj = paramGeneralControlWrapper;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189740);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Permission: jsPerm = ");
      ((StringBuilder)localObject).append(this.ARc);
      ((StringBuilder)localObject).append(", genCtrl = ");
      ((StringBuilder)localObject).append(this.Bbj);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(189740);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.d
 * JD-Core Version:    0.7.0.1
 */