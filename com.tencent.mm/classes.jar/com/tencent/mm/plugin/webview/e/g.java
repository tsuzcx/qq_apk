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
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g
{
  public Map<String, a> EoY;
  private JsapiPermissionWrapper EoZ;
  private GeneralControlWrapper Epa;
  private final JsapiPermissionWrapper Epb;
  private final GeneralControlWrapper Epc;
  private Map<String, HashMap<String, dvl>> Epk;
  private b Epl;
  
  public g(b paramb)
  {
    AppMethodBeat.i(213812);
    this.Epk = new HashMap();
    this.Epb = new JsapiPermissionWrapper(2);
    this.Epc = GeneralControlWrapper.FFY;
    this.Epl = paramb;
    ae.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + this.EoZ + ", hardcodeGenCtrl = " + this.Epa);
    this.EoY = new HashMap();
    AppMethodBeat.o(213812);
  }
  
  private static boolean Xy(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2);
  }
  
  private static String aIw(String paramString)
  {
    AppMethodBeat.i(213821);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(213821);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(213821);
    return paramString;
  }
  
  private a aJC(String paramString)
  {
    AppMethodBeat.i(213817);
    if ((!bu.isNullOrNil(paramString)) && (this.EoY != null))
    {
      paramString = aIw(paramString);
      if (this.EoY.containsKey(paramString))
      {
        paramString = (a)this.EoY.get(paramString);
        AppMethodBeat.o(213817);
        return paramString;
      }
    }
    AppMethodBeat.o(213817);
    return null;
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(213813);
    this.EoZ = paramJsapiPermissionWrapper;
    if ((ac.iRC == null) || (ac.iRC.length() == 0)) {
      ae.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
    }
    int i;
    for (;;)
    {
      this.Epa = paramGeneralControlWrapper;
      if ((ac.iRD != null) && (ac.iRD.length() != 0)) {
        break label159;
      }
      ae.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
      AppMethodBeat.o(213813);
      return;
      try
      {
        i = bu.getInt(ac.iRC, 0);
        if (i < 0) {
          ae.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
        }
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        ae.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + paramJsapiPermissionWrapper.getMessage());
        this.EoZ = null;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.EoZ);
      break;
      this.EoZ = new JsapiPermissionWrapper(i);
    }
    try
    {
      label159:
      i = bu.getInt(ac.iRD, 0);
      ae.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[] { Integer.valueOf(i) });
      paramJsapiPermissionWrapper = new avj();
      paramJsapiPermissionWrapper.GMw = i;
      this.Epa = new GeneralControlWrapper(paramJsapiPermissionWrapper);
      ae.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.Epa);
      AppMethodBeat.o(213813);
      return;
    }
    catch (Exception paramJsapiPermissionWrapper)
    {
      for (;;)
      {
        ae.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[] { paramJsapiPermissionWrapper.getMessage() });
        this.Epa = null;
      }
    }
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(213814);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.WebViewPermission", "update fail, url is null");
      AppMethodBeat.o(213814);
      return;
    }
    if (paramGeneralControlWrapper != null)
    {
      bool1 = bool2;
      if ((paramGeneralControlWrapper.FFZ & 0x80000) != 0) {
        bool1 = true;
      }
      ae.d("MicroMsg.GeneralControlWrapper", "needClearData, ret = ".concat(String.valueOf(bool1)));
    }
    com.tencent.mm.plugin.webview.modeltools.c.ct(paramString, bool1);
    String str = aIw(paramString);
    paramString = paramJsapiPermissionWrapper;
    if (paramJsapiPermissionWrapper == null) {
      paramString = this.Epb;
    }
    paramJsapiPermissionWrapper = paramGeneralControlWrapper;
    if (paramGeneralControlWrapper == null) {
      paramJsapiPermissionWrapper = this.Epc;
    }
    ae.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + paramString + ", genCtrl = " + paramJsapiPermissionWrapper + ", url = " + str);
    this.EoY.put(str, new a(paramString, paramJsapiPermissionWrapper));
    AppMethodBeat.o(213814);
  }
  
  public final void aF(Bundle paramBundle)
  {
    AppMethodBeat.i(213818);
    Object localObject2 = paramBundle.getStringArrayList("jsapi_preverify_fun_list");
    Object localObject1 = x.aPh(x.aIw(paramBundle.getString("jsapi_preverify_commit_url")));
    if (!this.Epk.containsKey(localObject1)) {
      this.Epk.put(localObject1, new HashMap());
    }
    localObject1 = (HashMap)this.Epk.get(localObject1);
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      dvl localdvl;
      try
      {
        localdvl = new dvl();
        localdvl.parseFrom(paramBundle.getByteArray(str));
        if (!Xy(localdvl.state)) {
          break label188;
        }
        ae.w("MicroMsg.WebViewPermission", "skip update control bytes by preverify, %s, %d, %d", new Object[] { str, Integer.valueOf(localdvl.state), Integer.valueOf(localdvl.IaU) });
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.WebViewPermission", localException, "parse preverify info", new Object[0]);
      }
      continue;
      label188:
      ((HashMap)localObject1).put(localException, localdvl);
      ae.i("MicroMsg.WebViewPermission", "update control bytes by preverify, %s, %d, %d", new Object[] { localException, Integer.valueOf(localdvl.state), Integer.valueOf(localdvl.IaU) });
    }
    AppMethodBeat.o(213818);
  }
  
  public final boolean aJD(String paramString)
  {
    AppMethodBeat.i(213820);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.WebViewPermission", "hasJsPerm fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(213820);
      return false;
    }
    String str = aIw(paramString);
    if (this.EoY == null)
    {
      ae.e("MicroMsg.WebViewPermission", "hasJsPerm fail, permMap is null");
      AppMethodBeat.o(213820);
      return false;
    }
    a locala = (a)this.EoY.get(str);
    StringBuilder localStringBuilder = new StringBuilder("edw hasJsPerm, jsPerm = ");
    if (locala == null) {}
    for (paramString = null;; paramString = locala.DRw)
    {
      ae.i("MicroMsg.WebViewPermission", paramString + ", url = " + str);
      if ((locala == null) || (locala.DRw == null) || (locala.DRw.equals(this.Epb))) {
        break;
      }
      AppMethodBeat.o(213820);
      return true;
    }
    AppMethodBeat.o(213820);
    return false;
  }
  
  public final JsapiPermissionWrapper eUS()
  {
    AppMethodBeat.i(213816);
    Object localObject1;
    if (this.EoZ != null)
    {
      ae.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.EoZ);
      localObject1 = this.EoZ;
      AppMethodBeat.o(213816);
      return localObject1;
    }
    Object localObject3;
    Object localObject2;
    if (this.Epl != null)
    {
      localObject1 = aJC(this.Epl.eRh());
      localObject3 = this.Epl.eRi();
      if (!bu.isNullOrNil((String)localObject3))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = aJC((String)localObject3);
        }
        localObject1 = x.aPh((String)localObject3);
      }
    }
    for (;;)
    {
      if (localObject2 != null) {}
      for (localObject2 = ((a)localObject2).DRw;; localObject2 = null)
      {
        localObject3 = localObject2;
        int j;
        if (localObject1 != null)
        {
          localObject3 = localObject2;
          if (this.Epk.containsKey(localObject1)) {
            if (localObject2 == null)
            {
              localObject2 = new JsapiPermissionWrapper(new byte[0]);
              j = 0;
              localObject1 = (HashMap)this.Epk.get(localObject1);
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
            localObject4 = com.tencent.mm.protocal.c.aPy(str);
            if (localObject4 != null) {
              i = ((c.g)localObject4).fjS();
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
            for (int k = ((JsapiPermissionWrapper)localObject2).aah(i);; k = 2)
            {
              m = ((dvl)((HashMap)localObject1).get(str)).state;
              if (k != 0) {
                break label331;
              }
              ((JsapiPermissionWrapper)localObject2).a(i, (byte)0);
              break label204;
              localObject2 = ((JsapiPermissionWrapper)localObject2).fkk();
              j = 1;
              break;
              localObject4 = m.EfD;
              localObject4 = m.aIm(str);
              if (localObject4 == null) {
                break label392;
              }
              i = ((a)localObject4).eSw();
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
              localObject1 = this.Epb;
              AppMethodBeat.o(213816);
              return localObject1;
            }
            AppMethodBeat.o(213816);
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
  
  public final GeneralControlWrapper eUT()
  {
    GeneralControlWrapper localGeneralControlWrapper = null;
    AppMethodBeat.i(213819);
    if (this.Epa != null)
    {
      ae.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.Epa);
      localObject = this.Epa;
      AppMethodBeat.o(213819);
      return localObject;
    }
    if (this.Epl != null)
    {
      a locala = aJC(this.Epl.eRh());
      localObject = locala;
      if (locala != null) {}
    }
    for (Object localObject = aJC(this.Epl.eRi());; localObject = null)
    {
      if (localObject != null) {
        localGeneralControlWrapper = ((a)localObject).Epd;
      }
      if (localGeneralControlWrapper == null)
      {
        localObject = this.Epc;
        AppMethodBeat.o(213819);
        return localObject;
      }
      AppMethodBeat.o(213819);
      return localGeneralControlWrapper;
    }
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(213815);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.WebViewPermission", "has fail, url is null");
      AppMethodBeat.o(213815);
      return false;
    }
    paramString = aIw(paramString);
    if (this.EoY == null)
    {
      ae.e("MicroMsg.WebViewPermission", "has fail, permMap is null");
      AppMethodBeat.o(213815);
      return false;
    }
    paramString = (a)this.EoY.get(paramString);
    if ((paramString != null) && (paramString.DRw != this.Epb) && (paramString.Epd != this.Epc))
    {
      AppMethodBeat.o(213815);
      return true;
    }
    AppMethodBeat.o(213815);
    return false;
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
      AppMethodBeat.i(213811);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Permission: jsPerm = ");
      ((StringBuilder)localObject).append(this.DRw);
      ((StringBuilder)localObject).append(", genCtrl = ");
      ((StringBuilder)localObject).append(this.Epd);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(213811);
      return localObject;
    }
  }
  
  public static abstract interface b
  {
    public abstract String eRh();
    
    public abstract String eRi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.g
 * JD-Core Version:    0.7.0.1
 */