package com.tencent.mm.plugin.webview.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.m;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.aqx;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g
{
  private Map<String, HashMap<String, dox>> CtB;
  private b CtC;
  public Map<String, a> Ctq;
  private JsapiPermissionWrapper Ctr;
  private GeneralControlWrapper Cts;
  private final JsapiPermissionWrapper Ctt;
  private final GeneralControlWrapper Ctu;
  
  public g(b paramb)
  {
    AppMethodBeat.i(205379);
    this.CtB = new HashMap();
    this.Ctt = new JsapiPermissionWrapper(2);
    this.Ctu = GeneralControlWrapper.DIt;
    this.CtC = paramb;
    ac.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + this.Ctr + ", hardcodeGenCtrl = " + this.Cts);
    this.Ctq = new HashMap();
    AppMethodBeat.o(205379);
  }
  
  private static boolean Vc(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2);
  }
  
  private static String aBE(String paramString)
  {
    AppMethodBeat.i(205388);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(205388);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(205388);
    return paramString;
  }
  
  private a aCH(String paramString)
  {
    AppMethodBeat.i(205384);
    if ((!bs.isNullOrNil(paramString)) && (this.Ctq != null))
    {
      paramString = aBE(paramString);
      if (this.Ctq.containsKey(paramString))
      {
        paramString = (a)this.Ctq.get(paramString);
        AppMethodBeat.o(205384);
        return paramString;
      }
    }
    AppMethodBeat.o(205384);
    return null;
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(205380);
    this.Ctr = paramJsapiPermissionWrapper;
    if ((ab.ivB == null) || (ab.ivB.length() == 0)) {
      ac.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
    }
    int i;
    for (;;)
    {
      this.Cts = paramGeneralControlWrapper;
      if ((ab.ivC != null) && (ab.ivC.length() != 0)) {
        break label159;
      }
      ac.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
      AppMethodBeat.o(205380);
      return;
      try
      {
        i = bs.getInt(ab.ivB, 0);
        if (i < 0) {
          ac.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
        }
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        ac.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + paramJsapiPermissionWrapper.getMessage());
        this.Ctr = null;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.Ctr);
      break;
      this.Ctr = new JsapiPermissionWrapper(i);
    }
    try
    {
      label159:
      i = bs.getInt(ab.ivC, 0);
      ac.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
      paramJsapiPermissionWrapper = new aqx();
      paramJsapiPermissionWrapper.EJW = i;
      this.Cts = new GeneralControlWrapper(paramJsapiPermissionWrapper);
      ac.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.Cts);
      AppMethodBeat.o(205380);
      return;
    }
    catch (Exception paramJsapiPermissionWrapper)
    {
      for (;;)
      {
        ac.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { paramJsapiPermissionWrapper.getMessage() });
        this.Cts = null;
      }
    }
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(205381);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.WebViewPermission", "update fail, url is null");
      AppMethodBeat.o(205381);
      return;
    }
    if (paramGeneralControlWrapper != null)
    {
      bool1 = bool2;
      if ((paramGeneralControlWrapper.DIu & 0x80000) != 0) {
        bool1 = true;
      }
      ac.d("MicroMsg.GeneralControlWrapper", "needClearData, ret = ".concat(String.valueOf(bool1)));
    }
    com.tencent.mm.plugin.webview.modeltools.c.ci(paramString, bool1);
    String str = aBE(paramString);
    paramString = paramJsapiPermissionWrapper;
    if (paramJsapiPermissionWrapper == null) {
      paramString = this.Ctt;
    }
    paramJsapiPermissionWrapper = paramGeneralControlWrapper;
    if (paramGeneralControlWrapper == null) {
      paramJsapiPermissionWrapper = this.Ctu;
    }
    ac.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + paramString + ", genCtrl = " + paramJsapiPermissionWrapper + ", url = " + str);
    this.Ctq.put(str, new a(paramString, paramJsapiPermissionWrapper));
    AppMethodBeat.o(205381);
  }
  
  public final boolean aCI(String paramString)
  {
    AppMethodBeat.i(205387);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.WebViewPermission", "hasJsPerm fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(205387);
      return false;
    }
    String str = aBE(paramString);
    if (this.Ctq == null)
    {
      ac.e("MicroMsg.WebViewPermission", "hasJsPerm fail, permMap is null");
      AppMethodBeat.o(205387);
      return false;
    }
    a locala = (a)this.Ctq.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw hasJsPerm, jsPerm = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.Cjp)
    {
      ac.i("MicroMsg.WebViewPermission", paramString + ", url = " + str);
      if ((locala == null) || (locala.Cjp == null) || (locala.Cjp.equals(this.Ctt))) {
        break;
      }
      AppMethodBeat.o(205387);
      return true;
    }
    AppMethodBeat.o(205387);
    return false;
  }
  
  public final void ax(Bundle paramBundle)
  {
    AppMethodBeat.i(205385);
    Object localObject2 = paramBundle.getStringArrayList("jsapi_preverify_fun_list");
    Object localObject1 = x.aIi(x.aBE(paramBundle.getString("jsapi_preverify_commit_url")));
    if (!this.CtB.containsKey(localObject1)) {
      this.CtB.put(localObject1, new HashMap());
    }
    localObject1 = (HashMap)this.CtB.get(localObject1);
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      dox localdox;
      try
      {
        localdox = new dox();
        localdox.parseFrom(paramBundle.getByteArray(str));
        if (!Vc(localdox.state)) {
          break label191;
        }
        ac.w("MicroMsg.WebViewPermission", "skip update control bytes by preverify, %s, %d, %d", new Object[] { str, Integer.valueOf(localdox.state), Integer.valueOf(localdox.FWr) });
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.WebViewPermission", localException, "parse preverify info", new Object[0]);
      }
      continue;
      label191:
      ((HashMap)localObject1).put(localException, localdox);
      ac.i("MicroMsg.WebViewPermission", "update control bytes by preverify, %s, %d, %d", new Object[] { localException, Integer.valueOf(localdox.state), Integer.valueOf(localdox.FWr) });
    }
    AppMethodBeat.o(205385);
  }
  
  public final JsapiPermissionWrapper eCm()
  {
    AppMethodBeat.i(205383);
    Object localObject1;
    if (this.Ctr != null)
    {
      ac.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.Ctr);
      localObject1 = this.Ctr;
      AppMethodBeat.o(205383);
      return localObject1;
    }
    Object localObject3;
    Object localObject2;
    if (this.CtC != null)
    {
      localObject1 = aCH(this.CtC.eyH());
      localObject3 = this.CtC.eyI();
      if (!bs.isNullOrNil((String)localObject3))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = aCH((String)localObject3);
        }
        localObject1 = x.aIi((String)localObject3);
      }
    }
    for (;;)
    {
      if (localObject2 != null) {}
      for (localObject2 = ((a)localObject2).Cjp;; localObject2 = null)
      {
        localObject3 = localObject2;
        int j;
        if (localObject1 != null)
        {
          localObject3 = localObject2;
          if (this.CtB.containsKey(localObject1)) {
            if (localObject2 == null)
            {
              localObject2 = new JsapiPermissionWrapper(new byte[0]);
              j = 0;
              localObject1 = (HashMap)this.CtB.get(localObject1);
              localObject3 = ((HashMap)localObject1).keySet().iterator();
            }
          }
        }
        label392:
        label395:
        for (;;)
        {
          label204:
          String str;
          Object localObject4;
          int i;
          if (((Iterator)localObject3).hasNext())
          {
            str = (String)((Iterator)localObject3).next();
            localObject4 = com.tencent.mm.protocal.c.aIy(str);
            if (localObject4 != null) {
              i = ((c.g)localObject4).eQY();
            }
          }
          for (;;)
          {
            label244:
            if (i < 0) {
              break label395;
            }
            if (j != 0) {}
            int m;
            for (int k = ((JsapiPermissionWrapper)localObject2).XF(i);; k = 2)
            {
              m = ((dox)((HashMap)localObject1).get(str)).state;
              if (k != 0) {
                break label331;
              }
              ((JsapiPermissionWrapper)localObject2).a(i, (byte)0);
              break label204;
              localObject2 = ((JsapiPermissionWrapper)localObject2).eRq();
              j = 1;
              break;
              localObject4 = m.Ckz;
              localObject4 = m.aBv(str);
              if (localObject4 == null) {
                break label392;
              }
              i = ((a)localObject4).ezX();
              break label244;
            }
            label331:
            if (k == 2)
            {
              ((JsapiPermissionWrapper)localObject2).a(i, (byte)m);
              break label204;
            }
            ((JsapiPermissionWrapper)localObject2).a(i, (byte)k);
            break label204;
            localObject3 = localObject2;
            if (localObject3 == null)
            {
              localObject1 = this.Ctt;
              AppMethodBeat.o(205383);
              return localObject1;
            }
            AppMethodBeat.o(205383);
            return localObject3;
            i = -1;
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
  
  public final GeneralControlWrapper eCn()
  {
    GeneralControlWrapper localGeneralControlWrapper = null;
    AppMethodBeat.i(205386);
    if (this.Cts != null)
    {
      ac.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.Cts);
      localObject = this.Cts;
      AppMethodBeat.o(205386);
      return localObject;
    }
    if (this.CtC != null)
    {
      a locala = aCH(this.CtC.eyH());
      localObject = locala;
      if (locala != null) {}
    }
    for (Object localObject = aCH(this.CtC.eyI());; localObject = null)
    {
      if (localObject != null) {
        localGeneralControlWrapper = ((a)localObject).Ctv;
      }
      if (localGeneralControlWrapper == null)
      {
        localObject = this.Ctu;
        AppMethodBeat.o(205386);
        return localObject;
      }
      AppMethodBeat.o(205386);
      return localGeneralControlWrapper;
    }
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(205382);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.WebViewPermission", "has fail, url is null");
      AppMethodBeat.o(205382);
      return false;
    }
    paramString = aBE(paramString);
    if (this.Ctq == null)
    {
      ac.e("MicroMsg.WebViewPermission", "has fail, permMap is null");
      AppMethodBeat.o(205382);
      return false;
    }
    paramString = (a)this.Ctq.get(paramString);
    if ((paramString != null) && (paramString.Cjp != this.Ctt) && (paramString.Ctv != this.Ctu))
    {
      AppMethodBeat.o(205382);
      return true;
    }
    AppMethodBeat.o(205382);
    return false;
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
      AppMethodBeat.i(205378);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Permission: jsPerm = ");
      ((StringBuilder)localObject).append(this.Cjp);
      ((StringBuilder)localObject).append(", genCtrl = ");
      ((StringBuilder)localObject).append(this.Ctv);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(205378);
      return localObject;
    }
  }
  
  public static abstract interface b
  {
    public abstract String eyH();
    
    public abstract String eyI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.g
 * JD-Core Version:    0.7.0.1
 */