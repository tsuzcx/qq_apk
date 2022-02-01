package com.tencent.mm.plugin.webview.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.webview.core.p;
import com.tencent.mm.plugin.webview.modeltools.c;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.fwc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g
{
  private Map<String, HashMap<String, fwc>> WPC;
  private b WPD;
  public Map<String, a> WPq;
  private JsapiPermissionWrapper WPr;
  private GeneralControlWrapper WPs;
  private final JsapiPermissionWrapper WPt;
  private final GeneralControlWrapper WPu;
  
  public g(b paramb)
  {
    AppMethodBeat.i(294832);
    this.WPC = new HashMap();
    this.WPt = new JsapiPermissionWrapper(2);
    this.WPu = GeneralControlWrapper.YxB;
    this.WPD = paramb;
    Log.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + this.WPr + ", hardcodeGenCtrl = " + this.WPs);
    this.WPq = new HashMap();
    AppMethodBeat.o(294832);
  }
  
  private static boolean atN(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2);
  }
  
  private static String bkc(String paramString)
  {
    AppMethodBeat.i(294871);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(294871);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(294871);
    return paramString;
  }
  
  private a blg(String paramString)
  {
    AppMethodBeat.i(294842);
    if ((!Util.isNullOrNil(paramString)) && (this.WPq != null))
    {
      paramString = bkc(paramString);
      if (this.WPq.containsKey(paramString))
      {
        paramString = (a)this.WPq.get(paramString);
        AppMethodBeat.o(294842);
        return paramString;
      }
    }
    AppMethodBeat.o(294842);
    return null;
  }
  
  private void iwq()
  {
    AppMethodBeat.i(294859);
    if ((z.pCh == null) || (z.pCh.length() == 0))
    {
      Log.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
      AppMethodBeat.o(294859);
      return;
    }
    try
    {
      int i = Util.getInt(z.pCh, 0);
      if (i < 0)
      {
        Log.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
        AppMethodBeat.o(294859);
        return;
      }
      this.WPr = new JsapiPermissionWrapper(i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + localException.getMessage());
        this.WPr = null;
      }
    }
    Log.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.WPr);
    AppMethodBeat.o(294859);
  }
  
  private void iwr()
  {
    AppMethodBeat.i(294866);
    if ((z.pCi == null) || (z.pCi.length() == 0))
    {
      Log.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
      AppMethodBeat.o(294866);
      return;
    }
    try
    {
      int i = Util.getInt(z.pCi, 0);
      Log.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
      ccm localccm = new ccm();
      localccm.aalV = i;
      this.WPs = new GeneralControlWrapper(localccm);
      Log.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.WPs);
      AppMethodBeat.o(294866);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { localException.getMessage() });
        this.WPs = null;
      }
    }
  }
  
  private void k(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(294854);
    Object localObject = paramBundle.getStringArrayList("jsapi_preverify_fun_list");
    paramString = aa.brV(aa.bkc(paramString));
    if (!this.WPC.containsKey(paramString)) {
      this.WPC.put(paramString, new HashMap());
    }
    paramString = (HashMap)this.WPC.get(paramString);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      fwc localfwc;
      try
      {
        localfwc = new fwc();
        localfwc.parseFrom(paramBundle.getByteArray(str));
        if (!atN(localfwc.state)) {
          break label182;
        }
        Log.w("MicroMsg.WebViewPermission", "skip update control bytes by preverify, %s, %d, %d", new Object[] { str, Integer.valueOf(localfwc.state), Integer.valueOf(localfwc.abUe) });
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WebViewPermission", localException, "parse preverify info", new Object[0]);
      }
      continue;
      label182:
      paramString.put(localException, localfwc);
      Log.i("MicroMsg.WebViewPermission", "update control bytes by preverify, %s, %d, %d", new Object[] { localException, Integer.valueOf(localfwc.state), Integer.valueOf(localfwc.abUe) });
    }
    AppMethodBeat.o(294854);
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(294878);
    this.WPr = paramJsapiPermissionWrapper;
    iwq();
    this.WPs = paramGeneralControlWrapper;
    iwr();
    AppMethodBeat.o(294878);
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(294887);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewPermission", "update fail, url is null");
      AppMethodBeat.o(294887);
      return;
    }
    if (paramGeneralControlWrapper != null) {}
    for (boolean bool = paramGeneralControlWrapper.iPN();; bool = false)
    {
      c.dI(paramString, bool);
      String str = bkc(paramString);
      paramString = paramJsapiPermissionWrapper;
      if (paramJsapiPermissionWrapper == null) {
        paramString = this.WPt;
      }
      paramJsapiPermissionWrapper = paramGeneralControlWrapper;
      if (paramGeneralControlWrapper == null) {
        paramJsapiPermissionWrapper = this.WPu;
      }
      Log.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + paramString + ", genCtrl = " + paramJsapiPermissionWrapper + ", url = " + str);
      this.WPq.put(str, new a(paramString, paramJsapiPermissionWrapper));
      AppMethodBeat.o(294887);
      return;
    }
  }
  
  public final boolean blh(String paramString)
  {
    AppMethodBeat.i(294924);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewPermission", "hasJsPerm fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(294924);
      return false;
    }
    String str = bkc(paramString);
    if (this.WPq == null)
    {
      Log.e("MicroMsg.WebViewPermission", "hasJsPerm fail, permMap is null");
      AppMethodBeat.o(294924);
      return false;
    }
    a locala = (a)this.WPq.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw hasJsPerm, jsPerm = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.WlV)
    {
      Log.i("MicroMsg.WebViewPermission", paramString + ", url = " + str);
      if ((locala == null) || (locala.WlV == null) || (locala.WlV.equals(this.WPt))) {
        break;
      }
      AppMethodBeat.o(294924);
      return true;
    }
    AppMethodBeat.o(294924);
    return false;
  }
  
  public final void br(Bundle paramBundle)
  {
    AppMethodBeat.i(294911);
    String str1 = paramBundle.getString("jsapi_preverify_commit_url");
    String str2 = paramBundle.getString("jsapi_preverify_current_url");
    k(paramBundle, str1);
    if (!Util.isEqual(str1, str2)) {
      k(paramBundle, str2);
    }
    AppMethodBeat.o(294911);
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(294891);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewPermission", "has fail, url is null");
      AppMethodBeat.o(294891);
      return false;
    }
    paramString = bkc(paramString);
    if (this.WPq == null)
    {
      Log.e("MicroMsg.WebViewPermission", "has fail, permMap is null");
      AppMethodBeat.o(294891);
      return false;
    }
    paramString = (a)this.WPq.get(paramString);
    if ((paramString != null) && (paramString.WlV != this.WPt) && (paramString.WPv != this.WPu))
    {
      AppMethodBeat.o(294891);
      return true;
    }
    AppMethodBeat.o(294891);
    return false;
  }
  
  public final JsapiPermissionWrapper iwo()
  {
    AppMethodBeat.i(294903);
    Object localObject1;
    if (this.WPr != null)
    {
      Log.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.WPr);
      localObject1 = this.WPr;
      AppMethodBeat.o(294903);
      return localObject1;
    }
    Object localObject3;
    Object localObject2;
    if (this.WPD != null)
    {
      localObject1 = blg(this.WPD.ise());
      localObject3 = this.WPD.isf();
      if (!Util.isNullOrNil((String)localObject3))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = blg((String)localObject3);
        }
        localObject1 = aa.brV((String)localObject3);
      }
    }
    for (;;)
    {
      if (localObject2 != null) {}
      label310:
      for (localObject2 = ((a)localObject2).WlV;; localObject2 = null)
      {
        localObject3 = localObject2;
        int i;
        if (localObject1 != null)
        {
          localObject3 = localObject2;
          if (this.WPC.containsKey(localObject1)) {
            if (localObject2 == null)
            {
              localObject2 = new JsapiPermissionWrapper(new byte[0]);
              i = 0;
              localObject1 = (HashMap)this.WPC.get(localObject1);
              localObject3 = ((HashMap)localObject1).keySet().iterator();
            }
          }
        }
        label204:
        label371:
        label374:
        for (;;)
        {
          String str;
          Object localObject4;
          if (((Iterator)localObject3).hasNext())
          {
            str = (String)((Iterator)localObject3).next();
            localObject4 = p.WzF;
            localObject4 = p.bjx(str);
            if (localObject4 == null) {
              break label371;
            }
          }
          for (int j = ((c.g)localObject4).iPC();; j = -1)
          {
            if (j < 0) {
              break label374;
            }
            if (i != 0) {}
            int m;
            for (int k = ((JsapiPermissionWrapper)localObject2).axr(j);; k = 2)
            {
              m = ((fwc)((HashMap)localObject1).get(str)).state;
              if (k != 0) {
                break label310;
              }
              ((JsapiPermissionWrapper)localObject2).a(j, (byte)0);
              break label204;
              localObject2 = ((JsapiPermissionWrapper)localObject2).iPY();
              i = 1;
              break;
            }
            if (k == 2)
            {
              ((JsapiPermissionWrapper)localObject2).a(j, (byte)m);
              break label204;
            }
            ((JsapiPermissionWrapper)localObject2).a(j, (byte)k);
            break label204;
            localObject3 = localObject2;
            if (localObject3 == null)
            {
              localObject1 = this.WPt;
              AppMethodBeat.o(294903);
              return localObject1;
            }
            AppMethodBeat.o(294903);
            return localObject3;
          }
        }
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
      continue;
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  public final GeneralControlWrapper iwp()
  {
    GeneralControlWrapper localGeneralControlWrapper = null;
    AppMethodBeat.i(294916);
    if (this.WPs != null)
    {
      Log.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.WPs);
      localObject = this.WPs;
      AppMethodBeat.o(294916);
      return localObject;
    }
    if (this.WPD != null)
    {
      a locala = blg(this.WPD.ise());
      localObject = locala;
      if (locala != null) {}
    }
    for (Object localObject = blg(this.WPD.isf());; localObject = null)
    {
      if (localObject != null) {
        localGeneralControlWrapper = ((a)localObject).WPv;
      }
      if (localGeneralControlWrapper == null)
      {
        localObject = this.WPu;
        AppMethodBeat.o(294916);
        return localObject;
      }
      AppMethodBeat.o(294916);
      return localGeneralControlWrapper;
    }
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
      AppMethodBeat.i(294836);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Permission: jsPerm = ");
      ((StringBuilder)localObject).append(this.WlV);
      ((StringBuilder)localObject).append(", genCtrl = ");
      ((StringBuilder)localObject).append(this.WPv);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(294836);
      return localObject;
    }
  }
  
  public static abstract interface b
  {
    public abstract String ise();
    
    public abstract String isf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.g
 * JD-Core Version:    0.7.0.1
 */