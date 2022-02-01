package com.tencent.mm.plugin.webview.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.m;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g
{
  public Map<String, a> DWW;
  private JsapiPermissionWrapper DWX;
  private GeneralControlWrapper DWY;
  private final JsapiPermissionWrapper DWZ;
  private final GeneralControlWrapper DXa;
  private Map<String, HashMap<String, duo>> DXi;
  private b DXj;
  
  public g(b paramb)
  {
    AppMethodBeat.i(213981);
    this.DXi = new HashMap();
    this.DWZ = new JsapiPermissionWrapper(2);
    this.DXa = GeneralControlWrapper.FnA;
    this.DXj = paramb;
    ad.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + this.DWX + ", hardcodeGenCtrl = " + this.DWY);
    this.DWW = new HashMap();
    AppMethodBeat.o(213981);
  }
  
  private static boolean WS(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2);
  }
  
  private static String aHc(String paramString)
  {
    AppMethodBeat.i(213990);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(213990);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(213990);
    return paramString;
  }
  
  private a aIj(String paramString)
  {
    AppMethodBeat.i(213986);
    if ((!bt.isNullOrNil(paramString)) && (this.DWW != null))
    {
      paramString = aHc(paramString);
      if (this.DWW.containsKey(paramString))
      {
        paramString = (a)this.DWW.get(paramString);
        AppMethodBeat.o(213986);
        return paramString;
      }
    }
    AppMethodBeat.o(213986);
    return null;
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(213982);
    this.DWX = paramJsapiPermissionWrapper;
    if ((ac.iOI == null) || (ac.iOI.length() == 0)) {
      ad.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
    }
    int i;
    for (;;)
    {
      this.DWY = paramGeneralControlWrapper;
      if ((ac.iOJ != null) && (ac.iOJ.length() != 0)) {
        break label159;
      }
      ad.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
      AppMethodBeat.o(213982);
      return;
      try
      {
        i = bt.getInt(ac.iOI, 0);
        if (i < 0) {
          ad.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
        }
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        ad.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + paramJsapiPermissionWrapper.getMessage());
        this.DWX = null;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.DWX);
      break;
      this.DWX = new JsapiPermissionWrapper(i);
    }
    try
    {
      label159:
      i = bt.getInt(ac.iOJ, 0);
      ad.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
      paramJsapiPermissionWrapper = new aut();
      paramJsapiPermissionWrapper.GsY = i;
      this.DWY = new GeneralControlWrapper(paramJsapiPermissionWrapper);
      ad.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.DWY);
      AppMethodBeat.o(213982);
      return;
    }
    catch (Exception paramJsapiPermissionWrapper)
    {
      for (;;)
      {
        ad.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { paramJsapiPermissionWrapper.getMessage() });
        this.DWY = null;
      }
    }
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(213983);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WebViewPermission", "update fail, url is null");
      AppMethodBeat.o(213983);
      return;
    }
    if (paramGeneralControlWrapper != null)
    {
      bool1 = bool2;
      if ((paramGeneralControlWrapper.FnB & 0x80000) != 0) {
        bool1 = true;
      }
      ad.d("MicroMsg.GeneralControlWrapper", "needClearData, ret = ".concat(String.valueOf(bool1)));
    }
    com.tencent.mm.plugin.webview.modeltools.c.cp(paramString, bool1);
    String str = aHc(paramString);
    paramString = paramJsapiPermissionWrapper;
    if (paramJsapiPermissionWrapper == null) {
      paramString = this.DWZ;
    }
    paramJsapiPermissionWrapper = paramGeneralControlWrapper;
    if (paramGeneralControlWrapper == null) {
      paramJsapiPermissionWrapper = this.DXa;
    }
    ad.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + paramString + ", genCtrl = " + paramJsapiPermissionWrapper + ", url = " + str);
    this.DWW.put(str, new a(paramString, paramJsapiPermissionWrapper));
    AppMethodBeat.o(213983);
  }
  
  public final void aE(Bundle paramBundle)
  {
    AppMethodBeat.i(213987);
    Object localObject2 = paramBundle.getStringArrayList("jsapi_preverify_fun_list");
    Object localObject1 = x.aNK(x.aHc(paramBundle.getString("jsapi_preverify_commit_url")));
    if (!this.DXi.containsKey(localObject1)) {
      this.DXi.put(localObject1, new HashMap());
    }
    localObject1 = (HashMap)this.DXi.get(localObject1);
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      duo localduo;
      try
      {
        localduo = new duo();
        localduo.parseFrom(paramBundle.getByteArray(str));
        if (!WS(localduo.state)) {
          break label188;
        }
        ad.w("MicroMsg.WebViewPermission", "skip update control bytes by preverify, %s, %d, %d", new Object[] { str, Integer.valueOf(localduo.state), Integer.valueOf(localduo.HHh) });
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.WebViewPermission", localException, "parse preverify info", new Object[0]);
      }
      continue;
      label188:
      ((HashMap)localObject1).put(localException, localduo);
      ad.i("MicroMsg.WebViewPermission", "update control bytes by preverify, %s, %d, %d", new Object[] { localException, Integer.valueOf(localduo.state), Integer.valueOf(localduo.HHh) });
    }
    AppMethodBeat.o(213987);
  }
  
  public final boolean aIk(String paramString)
  {
    AppMethodBeat.i(213989);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WebViewPermission", "hasJsPerm fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(213989);
      return false;
    }
    String str = aHc(paramString);
    if (this.DWW == null)
    {
      ad.e("MicroMsg.WebViewPermission", "hasJsPerm fail, permMap is null");
      AppMethodBeat.o(213989);
      return false;
    }
    a locala = (a)this.DWW.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw hasJsPerm, jsPerm = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.DzO)
    {
      ad.i("MicroMsg.WebViewPermission", paramString + ", url = " + str);
      if ((locala == null) || (locala.DzO == null) || (locala.DzO.equals(this.DWZ))) {
        break;
      }
      AppMethodBeat.o(213989);
      return true;
    }
    AppMethodBeat.o(213989);
    return false;
  }
  
  public final JsapiPermissionWrapper eRg()
  {
    AppMethodBeat.i(213985);
    Object localObject1;
    if (this.DWX != null)
    {
      ad.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.DWX);
      localObject1 = this.DWX;
      AppMethodBeat.o(213985);
      return localObject1;
    }
    Object localObject3;
    Object localObject2;
    if (this.DXj != null)
    {
      localObject1 = aIj(this.DXj.eNw());
      localObject3 = this.DXj.eNx();
      if (!bt.isNullOrNil((String)localObject3))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = aIj((String)localObject3);
        }
        localObject1 = x.aNK((String)localObject3);
      }
    }
    for (;;)
    {
      if (localObject2 != null) {}
      for (localObject2 = ((a)localObject2).DzO;; localObject2 = null)
      {
        localObject3 = localObject2;
        int j;
        if (localObject1 != null)
        {
          localObject3 = localObject2;
          if (this.DXi.containsKey(localObject1)) {
            if (localObject2 == null)
            {
              localObject2 = new JsapiPermissionWrapper(new byte[0]);
              j = 0;
              localObject1 = (HashMap)this.DXi.get(localObject1);
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
            localObject4 = com.tencent.mm.protocal.c.aOb(str);
            if (localObject4 != null) {
              i = ((c.g)localObject4).fgc();
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
            for (int k = ((JsapiPermissionWrapper)localObject2).ZB(i);; k = 2)
            {
              m = ((duo)((HashMap)localObject1).get(str)).state;
              if (k != 0) {
                break label331;
              }
              ((JsapiPermissionWrapper)localObject2).a(i, (byte)0);
              break label204;
              localObject2 = ((JsapiPermissionWrapper)localObject2).fgu();
              j = 1;
              break;
              localObject4 = m.DNE;
              localObject4 = m.aGS(str);
              if (localObject4 == null) {
                break label392;
              }
              i = ((a)localObject4).eOL();
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
              localObject1 = this.DWZ;
              AppMethodBeat.o(213985);
              return localObject1;
            }
            AppMethodBeat.o(213985);
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
  
  public final GeneralControlWrapper eRh()
  {
    GeneralControlWrapper localGeneralControlWrapper = null;
    AppMethodBeat.i(213988);
    if (this.DWY != null)
    {
      ad.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.DWY);
      localObject = this.DWY;
      AppMethodBeat.o(213988);
      return localObject;
    }
    if (this.DXj != null)
    {
      a locala = aIj(this.DXj.eNw());
      localObject = locala;
      if (locala != null) {}
    }
    for (Object localObject = aIj(this.DXj.eNx());; localObject = null)
    {
      if (localObject != null) {
        localGeneralControlWrapper = ((a)localObject).DXb;
      }
      if (localGeneralControlWrapper == null)
      {
        localObject = this.DXa;
        AppMethodBeat.o(213988);
        return localObject;
      }
      AppMethodBeat.o(213988);
      return localGeneralControlWrapper;
    }
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(213984);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WebViewPermission", "has fail, url is null");
      AppMethodBeat.o(213984);
      return false;
    }
    paramString = aHc(paramString);
    if (this.DWW == null)
    {
      ad.e("MicroMsg.WebViewPermission", "has fail, permMap is null");
      AppMethodBeat.o(213984);
      return false;
    }
    paramString = (a)this.DWW.get(paramString);
    if ((paramString != null) && (paramString.DzO != this.DWZ) && (paramString.DXb != this.DXa))
    {
      AppMethodBeat.o(213984);
      return true;
    }
    AppMethodBeat.o(213984);
    return false;
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
      AppMethodBeat.i(213980);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Permission: jsPerm = ");
      ((StringBuilder)localObject).append(this.DzO);
      ((StringBuilder)localObject).append(", genCtrl = ");
      ((StringBuilder)localObject).append(this.DXb);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(213980);
      return localObject;
    }
  }
  
  public static abstract interface b
  {
    public abstract String eNw();
    
    public abstract String eNx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.g
 * JD-Core Version:    0.7.0.1
 */