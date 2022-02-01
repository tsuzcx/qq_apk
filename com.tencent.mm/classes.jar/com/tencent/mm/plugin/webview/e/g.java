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
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g
{
  public Map<String, a> Bbe;
  private JsapiPermissionWrapper Bbf;
  private GeneralControlWrapper Bbg;
  private final JsapiPermissionWrapper Bbh;
  private final GeneralControlWrapper Bbi;
  private Map<String, HashMap<String, dji>> Bbp;
  private b Bbq;
  
  public g(b paramb)
  {
    AppMethodBeat.i(189750);
    this.Bbp = new HashMap();
    this.Bbh = new JsapiPermissionWrapper(2);
    this.Bbi = GeneralControlWrapper.Cqb;
    this.Bbq = paramb;
    ad.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + this.Bbf + ", hardcodeGenCtrl = " + this.Bbg);
    this.Bbe = new HashMap();
    AppMethodBeat.o(189750);
  }
  
  private static boolean SU(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2);
  }
  
  private static String awm(String paramString)
  {
    AppMethodBeat.i(189759);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(189759);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(189759);
    return paramString;
  }
  
  private a axp(String paramString)
  {
    AppMethodBeat.i(189755);
    if ((!bt.isNullOrNil(paramString)) && (this.Bbe != null))
    {
      paramString = awm(paramString);
      if (this.Bbe.containsKey(paramString))
      {
        paramString = (a)this.Bbe.get(paramString);
        AppMethodBeat.o(189755);
        return paramString;
      }
    }
    AppMethodBeat.o(189755);
    return null;
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(189751);
    this.Bbf = paramJsapiPermissionWrapper;
    if ((ab.hVx == null) || (ab.hVx.length() == 0)) {
      ad.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
    }
    int i;
    for (;;)
    {
      this.Bbg = paramGeneralControlWrapper;
      if ((ab.hVy != null) && (ab.hVy.length() != 0)) {
        break label159;
      }
      ad.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
      AppMethodBeat.o(189751);
      return;
      try
      {
        i = bt.getInt(ab.hVx, 0);
        if (i < 0) {
          ad.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
        }
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        ad.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + paramJsapiPermissionWrapper.getMessage());
        this.Bbf = null;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.Bbf);
      break;
      this.Bbf = new JsapiPermissionWrapper(i);
    }
    try
    {
      label159:
      i = bt.getInt(ab.hVy, 0);
      ad.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
      paramJsapiPermissionWrapper = new ant();
      paramJsapiPermissionWrapper.DoW = i;
      this.Bbg = new GeneralControlWrapper(paramJsapiPermissionWrapper);
      ad.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.Bbg);
      AppMethodBeat.o(189751);
      return;
    }
    catch (Exception paramJsapiPermissionWrapper)
    {
      for (;;)
      {
        ad.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { paramJsapiPermissionWrapper.getMessage() });
        this.Bbg = null;
      }
    }
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(189752);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WebViewPermission", "update fail, url is null");
      AppMethodBeat.o(189752);
      return;
    }
    if (paramGeneralControlWrapper != null)
    {
      bool1 = bool2;
      if ((paramGeneralControlWrapper.Cqc & 0x80000) != 0) {
        bool1 = true;
      }
      ad.d("MicroMsg.GeneralControlWrapper", "needClearData, ret = ".concat(String.valueOf(bool1)));
    }
    com.tencent.mm.plugin.webview.modeltools.c.cc(paramString, bool1);
    String str = awm(paramString);
    paramString = paramJsapiPermissionWrapper;
    if (paramJsapiPermissionWrapper == null) {
      paramString = this.Bbh;
    }
    paramJsapiPermissionWrapper = paramGeneralControlWrapper;
    if (paramGeneralControlWrapper == null) {
      paramJsapiPermissionWrapper = this.Bbi;
    }
    ad.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + paramString + ", genCtrl = " + paramJsapiPermissionWrapper + ", url = " + str);
    this.Bbe.put(str, new a(paramString, paramJsapiPermissionWrapper));
    AppMethodBeat.o(189752);
  }
  
  public final void as(Bundle paramBundle)
  {
    AppMethodBeat.i(189756);
    Object localObject2 = paramBundle.getStringArrayList("jsapi_preverify_fun_list");
    Object localObject1 = x.aCQ(x.awm(paramBundle.getString("jsapi_preverify_commit_url")));
    if (!this.Bbp.containsKey(localObject1)) {
      this.Bbp.put(localObject1, new HashMap());
    }
    localObject1 = (HashMap)this.Bbp.get(localObject1);
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      dji localdji;
      try
      {
        localdji = new dji();
        localdji.parseFrom(paramBundle.getByteArray(str));
        if (!SU(localdji.state)) {
          break label188;
        }
        ad.w("MicroMsg.WebViewPermission", "skip update control bytes by preverify, %s, %d, %d", new Object[] { str, Integer.valueOf(localdji.state), Integer.valueOf(localdji.Ezn) });
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.WebViewPermission", localException, "parse preverify info", new Object[0]);
      }
      continue;
      label188:
      ((HashMap)localObject1).put(localException, localdji);
      ad.i("MicroMsg.WebViewPermission", "update control bytes by preverify, %s, %d, %d", new Object[] { localException, Integer.valueOf(localdji.state), Integer.valueOf(localdji.Ezn) });
    }
    AppMethodBeat.o(189756);
  }
  
  public final boolean axq(String paramString)
  {
    AppMethodBeat.i(189758);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WebViewPermission", "hasJsPerm fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(189758);
      return false;
    }
    String str = awm(paramString);
    if (this.Bbe == null)
    {
      ad.e("MicroMsg.WebViewPermission", "hasJsPerm fail, permMap is null");
      AppMethodBeat.o(189758);
      return false;
    }
    a locala = (a)this.Bbe.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw hasJsPerm, jsPerm = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.ARc)
    {
      ad.i("MicroMsg.WebViewPermission", paramString + ", url = " + str);
      if ((locala == null) || (locala.ARc == null) || (locala.ARc.equals(this.Bbh))) {
        break;
      }
      AppMethodBeat.o(189758);
      return true;
    }
    AppMethodBeat.o(189758);
    return false;
  }
  
  public final JsapiPermissionWrapper emR()
  {
    AppMethodBeat.i(189754);
    Object localObject1;
    if (this.Bbf != null)
    {
      ad.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.Bbf);
      localObject1 = this.Bbf;
      AppMethodBeat.o(189754);
      return localObject1;
    }
    Object localObject3;
    Object localObject2;
    if (this.Bbq != null)
    {
      localObject1 = axp(this.Bbq.ejm());
      localObject3 = this.Bbq.ejn();
      if (!bt.isNullOrNil((String)localObject3))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = axp((String)localObject3);
        }
        localObject1 = x.aCQ((String)localObject3);
      }
    }
    for (;;)
    {
      if (localObject2 != null) {}
      for (localObject2 = ((a)localObject2).ARc;; localObject2 = null)
      {
        localObject3 = localObject2;
        int j;
        if (localObject1 != null)
        {
          localObject3 = localObject2;
          if (this.Bbp.containsKey(localObject1)) {
            if (localObject2 == null)
            {
              localObject2 = new JsapiPermissionWrapper(new byte[0]);
              j = 0;
              localObject1 = (HashMap)this.Bbp.get(localObject1);
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
            localObject4 = com.tencent.mm.protocal.c.aDh(str);
            if (localObject4 != null) {
              i = ((c.g)localObject4).eBD();
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
            for (int k = ((JsapiPermissionWrapper)localObject2).Vw(i);; k = 2)
            {
              m = ((dji)((HashMap)localObject1).get(str)).state;
              if (k != 0) {
                break label331;
              }
              ((JsapiPermissionWrapper)localObject2).a(i, (byte)0);
              break label204;
              localObject2 = ((JsapiPermissionWrapper)localObject2).eBV();
              j = 1;
              break;
              localObject4 = m.ASm;
              localObject4 = m.awd(str);
              if (localObject4 == null) {
                break label392;
              }
              i = ((a)localObject4).ekB();
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
              localObject1 = this.Bbh;
              AppMethodBeat.o(189754);
              return localObject1;
            }
            AppMethodBeat.o(189754);
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
  
  public final GeneralControlWrapper emS()
  {
    GeneralControlWrapper localGeneralControlWrapper = null;
    AppMethodBeat.i(189757);
    if (this.Bbg != null)
    {
      ad.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.Bbg);
      localObject = this.Bbg;
      AppMethodBeat.o(189757);
      return localObject;
    }
    if (this.Bbq != null)
    {
      a locala = axp(this.Bbq.ejm());
      localObject = locala;
      if (locala != null) {}
    }
    for (Object localObject = axp(this.Bbq.ejn());; localObject = null)
    {
      if (localObject != null) {
        localGeneralControlWrapper = ((a)localObject).Bbj;
      }
      if (localGeneralControlWrapper == null)
      {
        localObject = this.Bbi;
        AppMethodBeat.o(189757);
        return localObject;
      }
      AppMethodBeat.o(189757);
      return localGeneralControlWrapper;
    }
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(189753);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WebViewPermission", "has fail, url is null");
      AppMethodBeat.o(189753);
      return false;
    }
    paramString = awm(paramString);
    if (this.Bbe == null)
    {
      ad.e("MicroMsg.WebViewPermission", "has fail, permMap is null");
      AppMethodBeat.o(189753);
      return false;
    }
    paramString = (a)this.Bbe.get(paramString);
    if ((paramString != null) && (paramString.ARc != this.Bbh) && (paramString.Bbj != this.Bbi))
    {
      AppMethodBeat.o(189753);
      return true;
    }
    AppMethodBeat.o(189753);
    return false;
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
      AppMethodBeat.i(189749);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Permission: jsPerm = ");
      ((StringBuilder)localObject).append(this.ARc);
      ((StringBuilder)localObject).append(", genCtrl = ");
      ((StringBuilder)localObject).append(this.Bbj);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(189749);
      return localObject;
    }
  }
  
  public static abstract interface b
  {
    public abstract String ejm();
    
    public abstract String ejn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.g
 * JD-Core Version:    0.7.0.1
 */