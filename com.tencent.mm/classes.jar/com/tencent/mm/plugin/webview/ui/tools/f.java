package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.aak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  Map<String, a> reE;
  private JsapiPermissionWrapper reF;
  private GeneralControlWrapper reG;
  private final JsapiPermissionWrapper reH = new JsapiPermissionWrapper(2);
  private final GeneralControlWrapper reI = GeneralControlWrapper.spk;
  private f.b rmU;
  
  public f(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper, f.b paramb)
  {
    this.reF = paramJsapiPermissionWrapper;
    if ((ae.eSK == null) || (ae.eSK.length() == 0))
    {
      y.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
      this.reG = paramGeneralControlWrapper;
      if ((ae.eSL != null) && (ae.eSL.length() != 0)) {
        break label223;
      }
      y.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
    }
    for (;;)
    {
      int i;
      for (;;)
      {
        this.rmU = paramb;
        y.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + paramJsapiPermissionWrapper + ", hardcodeGenCtrl = " + paramGeneralControlWrapper);
        this.reE = new HashMap();
        return;
        try
        {
          i = bk.getInt(ae.eSK, 0);
          if (i < 0) {
            y.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
          }
        }
        catch (Exception localException1)
        {
          y.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + localException1.getMessage());
          this.reF = null;
        }
      }
      for (;;)
      {
        y.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.reF);
        break;
        this.reF = new JsapiPermissionWrapper(i);
      }
      try
      {
        label223:
        i = bk.getInt(ae.eSL, 0);
        y.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
        aak localaak = new aak();
        localaak.sZE = i;
        this.reG = new GeneralControlWrapper(localaak);
        y.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.reG);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          y.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { localException2.getMessage() });
          this.reG = null;
        }
      }
    }
  }
  
  private static String RL(String paramString)
  {
    int i = paramString.indexOf("#");
    if (i < 0) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  public final JsapiPermissionWrapper RP(String paramString)
  {
    if (this.reF != null)
    {
      y.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.reF);
      return this.reF;
    }
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.WebViewPermission", "getJsPerm fail, url = " + paramString);
      return this.reH;
    }
    paramString = RL(paramString);
    if (this.reE == null)
    {
      y.e("MicroMsg.WebViewPermission", "getJsPerm fail, permMap is null");
      return this.reH;
    }
    paramString = (a)this.reE.get(paramString);
    if (paramString == null) {
      return this.reH;
    }
    return paramString.reJ;
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.WebViewPermission", "update fail, url is null");
      return;
    }
    String str = RL(paramString);
    paramString = paramJsapiPermissionWrapper;
    if (paramJsapiPermissionWrapper == null) {
      paramString = this.reH;
    }
    paramJsapiPermissionWrapper = paramGeneralControlWrapper;
    if (paramGeneralControlWrapper == null) {
      paramJsapiPermissionWrapper = this.reI;
    }
    y.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + paramString + ", genCtrl = " + paramJsapiPermissionWrapper + ", url = " + str);
    this.reE.put(str, new a(paramString, paramJsapiPermissionWrapper));
  }
  
  public final JsapiPermissionWrapper cdI()
  {
    if (this.reF != null)
    {
      y.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.reF);
      return this.reF;
    }
    return RP(this.rmU.cdK());
  }
  
  public final GeneralControlWrapper cdJ()
  {
    Object localObject = this.rmU.cdK();
    if (this.reG != null)
    {
      y.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.reG);
      return this.reG;
    }
    if (bk.bl((String)localObject))
    {
      y.e("MicroMsg.WebViewPermission", "getGenCtrl fail, url = " + (String)localObject);
      return this.reI;
    }
    String str = RL((String)localObject);
    a locala = (a)this.reE.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
    if (locala == null) {}
    for (localObject = null;; localObject = locala.reK)
    {
      y.i("MicroMsg.WebViewPermission", localObject + ", url = " + str);
      if (locala != null) {
        break;
      }
      return this.reI;
    }
    return locala.reK;
  }
  
  public final boolean has(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.WebViewPermission", "has fail, url is null");
      return false;
    }
    paramString = RL(paramString);
    paramString = (a)this.reE.get(paramString);
    return (paramString != null) && (paramString.reJ != this.reH) && (paramString.reK != this.reI);
  }
  
  private static final class a
  {
    public JsapiPermissionWrapper reJ;
    public GeneralControlWrapper reK;
    
    public a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
    {
      this.reJ = paramJsapiPermissionWrapper;
      this.reK = paramGeneralControlWrapper;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Permission: jsPerm = ");
      localStringBuilder.append(this.reJ);
      localStringBuilder.append(", genCtrl = ");
      localStringBuilder.append(this.reK);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */