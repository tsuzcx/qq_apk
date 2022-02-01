package com.tencent.mm.sensitive;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sensitive.business.BusinessStackRecorder;
import com.tencent.mm.sensitive.business.BusinessStackRecorder.a;
import com.tencent.mm.sensitive.business.a.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.r;
import kotlin.v;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bu;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/PluginSensitive;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/sensitive/IPluginSensitive;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "hookSuccessSize", "", "checkAndShowPermissionDialog", "", "permission", "Lcom/tencent/mm/sensitive/IPluginSensitive$PERMISSION;", "business", "Lcom/tencent/mm/sensitive/IPluginSensitive$BUSINESS;", "listener", "Lcom/tencent/mm/sensitive/IPluginSensitive$onDialogOptionListener;", "checkBusinessPermission", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "dumpSwitchStatus", "execute", "getPermissionBusinessDesc", "Landroid/util/Pair;", "getPermissionBusinessTitle", "getPermissionConfigMMkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getPermissionDefaultDesc", "(Ljava/lang/String;)Ljava/lang/Integer;", "getPermissionIcon", "getPermissionWxTitle", "isFrequencyLimit", "appid", "isPermissionGranted", "Lcom/tencent/mm/sensitive/IPluginSensitive$PERMISSION_RESULT;", "activity", "Landroid/app/Activity;", "isSwitchExist", "isUsingOldPermissionDialog", "markEnterBusiness", "markExitBusiness", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "openBusinessSwitchOnPermissionGranted", "requestPermission", "callback", "Lcom/tencent/mm/sensitive/IPluginSensitive$onPermissionResultCallback;", "Companion", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginSensitive
  extends f
  implements com.tencent.mm.kernel.api.c, d
{
  public static final PluginSensitive.a actU;
  private static final String actW;
  private static final long actX;
  private static final Map<d.c, String[]> actY;
  private final String TAG = "PluginSensitive";
  private int actV;
  
  static
  {
    AppMethodBeat.i(240928);
    actU = new PluginSensitive.a((byte)0);
    actW = "freq_mmkv_key";
    actX = 172800L;
    actY = ak.f(new r[] { v.Y(d.c.actu, new String[] { "android.permission.ACCESS_FINE_LOCATION" }), v.Y(d.c.actv, new String[] { "android.permission.READ_CONTACTS" }), v.Y(d.c.actw, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" }), v.Y(d.c.acty, new String[] { "android.permission.RECORD_AUDIO" }), v.Y(d.c.actA, new String[] { "android.permission.ACTIVITY_RECOGNITION" }), v.Y(d.c.actx, new String[] { "android.permission.CAMERA" }) });
    AppMethodBeat.o(240928);
  }
  
  public final boolean checkAndShowPermissionDialog(d.c paramc, d.a parama, d.f paramf)
  {
    AppMethodBeat.i(241001);
    s.u(paramc, "permission");
    s.u(parama, "business");
    s.u(paramf, "listener");
    com.tencent.mm.sensitive.ui.a locala = com.tencent.mm.sensitive.ui.a.acvO;
    boolean bool = com.tencent.mm.sensitive.ui.a.a(paramc, parama, (kotlin.g.a.b)new d(paramf));
    AppMethodBeat.o(241001);
    return bool;
  }
  
  public final boolean checkAndShowPermissionDialog(d.c paramc, d.f paramf)
  {
    AppMethodBeat.i(240991);
    s.u(paramc, "permission");
    s.u(paramf, "listener");
    boolean bool2 = false;
    Object localObject1 = BusinessStackRecorder.acuv;
    localObject1 = BusinessStackRecorder.a.iTW();
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      Object localObject2 = i.actT;
      localObject1 = i.bup((String)localObject1);
      bool1 = bool2;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.sensitive.ui.a.acvO;
        bool1 = com.tencent.mm.sensitive.ui.a.a(paramc, (d.a)localObject1, (kotlin.g.a.b)new c(paramf));
      }
    }
    AppMethodBeat.o(240991);
    return bool1;
  }
  
  public final boolean checkBusinessPermission(d.c paramc, d.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(240979);
    s.u(paramc, "permission");
    Object localObject1;
    if (parama == null)
    {
      localObject1 = null;
      parama = (d.a)localObject1;
      if (localObject1 == null)
      {
        parama = BusinessStackRecorder.acuv;
        parama = BusinessStackRecorder.a.iTW();
        if (parama != null) {
          break label79;
        }
      }
    }
    for (parama = null;; parama = i.bup(parama))
    {
      paramc = paramc.value;
      s.s(paramc, "permission.value");
      localObject1 = getPermissionConfigMMkv(paramc);
      if (localObject1 != null) {
        break label92;
      }
      AppMethodBeat.o(240979);
      return true;
      localObject1 = parama;
      break;
      label79:
      localObject1 = i.actT;
    }
    label92:
    if (parama == null) {}
    for (paramc = localObject2;; paramc = parama.value)
    {
      boolean bool = ((MultiProcessMMKV)localObject1).getBoolean(paramc, true);
      AppMethodBeat.o(240979);
      return bool;
    }
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(240945);
    super.configure(paramg);
    AppMethodBeat.o(240945);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(240936);
    dependsOn(com.tencent.mm.plugin.report.c.class);
    AppMethodBeat.o(240936);
  }
  
  public final String dumpSwitchStatus()
  {
    AppMethodBeat.i(241104);
    Object localObject1 = new JSONArray();
    Object localObject2 = com.tencent.mm.sensitive.business.a.acuK;
    localObject2 = ((Map)com.tencent.mm.sensitive.business.a.iUa()).entrySet().iterator();
    if (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      d.c localc = (d.c)((Map.Entry)localObject3).getKey();
      boolean bool;
      label86:
      label118:
      Object localObject4;
      JSONObject localJSONObject;
      if (localc == d.c.actB)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.lw(MMApplicationContext.getContext());
        if (!bool) {
          break label299;
        }
        localObject3 = ((Map)((com.tencent.mm.sensitive.business.a.b)((Map.Entry)localObject3).getValue()).acuV).entrySet().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (d.a)((Map.Entry)((Iterator)localObject3).next()).getKey();
          localJSONObject = new JSONObject();
          localJSONObject.put("type", localc.qDL);
          localJSONObject.put("biz", ((d.a)localObject4).qDL);
          Object localObject5 = localc.value;
          s.s(localObject5, "permission.value");
          localObject5 = getPermissionConfigMMkv((String)localObject5);
          if ((localObject5 == null) || (((MultiProcessMMKV)localObject5).getBoolean(((d.a)localObject4).value, true) != true)) {
            break label301;
          }
          i = 1;
          label229:
          if (i == 0) {
            break label306;
          }
        }
      }
      label299:
      label301:
      label306:
      for (int i = 1;; i = 2)
      {
        localJSONObject.put("status", i);
        ((JSONArray)localObject1).put(localJSONObject);
        break label118;
        break;
        localObject4 = (String[])actY.get(localc);
        if (localObject4 == null)
        {
          bool = false;
          break label86;
        }
        bool = com.tencent.mm.pluginsdk.permission.b.g(MMApplicationContext.getContext(), (String[])Arrays.copyOf((Object[])localObject4, localObject4.length));
        break label86;
        break;
        i = 0;
        break label229;
      }
    }
    localObject1 = ((JSONArray)localObject1).toString();
    s.s(localObject1, "jsonArray.toString()");
    localObject1 = n.a((String)localObject1, ',', ';');
    AppMethodBeat.o(241104);
    return localObject1;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(240959);
    kotlinx.coroutines.j.a((aq)bu.ajwo, null, null, (kotlin.g.a.m)new e(this, null), 3);
    AppMethodBeat.o(240959);
  }
  
  public final Pair<Integer, Integer> getPermissionBusinessDesc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241020);
    s.u(paramString1, "permission");
    s.u(paramString2, "business");
    Object localObject = i.actT;
    paramString1 = i.buq(paramString1);
    localObject = i.actT;
    paramString2 = i.bup(paramString2);
    if ((paramString1 != null) && (paramString2 != null))
    {
      localObject = com.tencent.mm.sensitive.business.a.acuK;
      paramString1 = (com.tencent.mm.sensitive.business.a.b)com.tencent.mm.sensitive.business.a.iUa().get(paramString1);
      if (paramString1 != null)
      {
        paramString1 = (a.a)paramString1.acuV.get(paramString2);
        if (paramString1 == null) {}
      }
    }
    for (paramString1 = new Pair(Integer.valueOf(paramString1.acuP), Integer.valueOf(paramString1.acuQ));; paramString1 = null)
    {
      AppMethodBeat.o(241020);
      return paramString1;
    }
  }
  
  public final String getPermissionBusinessTitle(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241025);
    s.u(paramString1, "permission");
    s.u(paramString2, "business");
    com.tencent.mm.sensitive.business.a locala = com.tencent.mm.sensitive.business.a.acuK;
    paramString1 = (String)com.tencent.mm.sensitive.business.a.iUc().get(paramString1);
    locala = com.tencent.mm.sensitive.business.a.acuK;
    paramString2 = (String)com.tencent.mm.sensitive.business.a.iUd().get(paramString2);
    if ((paramString1 != null) && (paramString2 != null)) {}
    for (paramString1 = MMApplicationContext.getContext().getString(j.d.settings_permission_business_dialog_title, new Object[] { paramString2, paramString1 });; paramString1 = null)
    {
      AppMethodBeat.o(241025);
      return paramString1;
    }
  }
  
  public final MultiProcessMMKV getPermissionConfigMMkv(String paramString)
  {
    AppMethodBeat.i(241122);
    s.u(paramString, "permission");
    i locali = i.actT;
    if (i.buq(paramString) == null)
    {
      AppMethodBeat.o(241122);
      return null;
    }
    paramString = MultiProcessMMKV.getMMKV(com.tencent.mm.kernel.b.aZP() + '_' + paramString);
    AppMethodBeat.o(241122);
    return paramString;
  }
  
  public final Integer getPermissionDefaultDesc(String paramString)
  {
    int j = -1;
    AppMethodBeat.i(241011);
    s.u(paramString, "permission");
    Object localObject = i.actT;
    paramString = i.buq(paramString);
    if (paramString == null)
    {
      paramString = null;
      if (paramString != null) {
        break label99;
      }
    }
    label99:
    for (int i = j;; i = paramString.intValue())
    {
      AppMethodBeat.o(241011);
      return Integer.valueOf(i);
      localObject = com.tencent.mm.sensitive.business.a.acuK;
      paramString = (com.tencent.mm.sensitive.business.a.b)com.tencent.mm.sensitive.business.a.iUa().get(paramString);
      if (paramString == null) {
        i = -1;
      }
      for (;;)
      {
        paramString = Integer.valueOf(i);
        break;
        paramString = paramString.acuT;
        if (paramString == null) {
          i = -1;
        } else {
          i = paramString.intValue();
        }
      }
    }
  }
  
  public final Integer getPermissionIcon(String paramString)
  {
    int j = -1;
    AppMethodBeat.i(241070);
    s.u(paramString, "permission");
    Object localObject = i.actT;
    paramString = i.buq(paramString);
    if (paramString == null)
    {
      paramString = null;
      if (paramString != null) {
        break label99;
      }
    }
    label99:
    for (int i = j;; i = paramString.intValue())
    {
      AppMethodBeat.o(241070);
      return Integer.valueOf(i);
      localObject = com.tencent.mm.sensitive.business.a.acuK;
      paramString = (com.tencent.mm.sensitive.business.a.b)com.tencent.mm.sensitive.business.a.iUa().get(paramString);
      if (paramString == null) {
        i = -1;
      }
      for (;;)
      {
        paramString = Integer.valueOf(i);
        break;
        paramString = paramString.acuU;
        if (paramString == null) {
          i = -1;
        } else {
          i = paramString.intValue();
        }
      }
    }
  }
  
  public final String getPermissionWxTitle(String paramString)
  {
    AppMethodBeat.i(241036);
    s.u(paramString, "permission");
    Object localObject = com.tencent.mm.sensitive.business.a.acuK;
    paramString = (String)com.tencent.mm.sensitive.business.a.iUc().get(paramString);
    localObject = (CharSequence)paramString;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label92;
      }
      i = 1;
      label53:
      if (i == 0) {
        break label97;
      }
      label57:
      if (paramString == null) {
        break label102;
      }
    }
    label92:
    label97:
    label102:
    for (paramString = MMApplicationContext.getContext().getString(j.d.settings_permission_dialog_title, new Object[] { paramString });; paramString = null)
    {
      AppMethodBeat.o(241036);
      return paramString;
      i = 0;
      break;
      i = 0;
      break label53;
      paramString = null;
      break label57;
    }
  }
  
  public final boolean isFrequencyLimit(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241083);
    s.u(paramString1, "appid");
    s.u(paramString2, "permission");
    com.tencent.mm.sensitive.business.a locala = com.tencent.mm.sensitive.business.a.acuK;
    paramString2 = (d.c)com.tencent.mm.sensitive.business.a.iUb().get(paramString2);
    if (paramString2 != null)
    {
      paramString1 = paramString1 + '_' + paramString2.value;
      long l = MultiProcessMMKV.getMMKV(actW).getLong(paramString1, -1L);
      if ((l != -1L) && (cn.bDu() - l < actX))
      {
        AppMethodBeat.o(241083);
        return true;
      }
      AppMethodBeat.o(241083);
      return false;
    }
    AppMethodBeat.o(241083);
    return false;
  }
  
  public final d.d isPermissionGranted(Activity paramActivity, String paramString, int paramInt)
  {
    int k = 1;
    int j = 0;
    AppMethodBeat.i(241090);
    s.u(paramActivity, "activity");
    s.u(paramString, "permission");
    if (androidx.core.content.a.checkSelfPermission((Context)paramActivity, paramString) == 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramActivity = d.d.actD;
      AppMethodBeat.o(241090);
      return paramActivity;
    }
    paramActivity = com.tencent.mm.sensitive.business.a.acuK;
    paramString = (d.c)com.tencent.mm.sensitive.business.a.iUb().get(paramString);
    paramActivity = i.actT;
    paramActivity = i.ayl(paramInt);
    boolean bool;
    if ((paramString != null) && (paramActivity != null))
    {
      paramString = paramString.value;
      s.s(paramString, "pEnum.value");
      paramString = getPermissionConfigMMkv(paramString);
      if (paramString != null)
      {
        String str = paramActivity.value;
        if (!paramActivity.acts.booleanValue())
        {
          bool = true;
          if (paramString.getBoolean(str, bool) != true) {
            break label183;
          }
          paramInt = k;
          label150:
          paramActivity = ah.aiuX;
          label154:
          if (paramActivity != null) {
            break label207;
          }
          paramInt = j;
        }
      }
    }
    label183:
    label207:
    for (;;)
    {
      if (paramInt == 0)
      {
        paramActivity = d.d.actE;
        AppMethodBeat.o(241090);
        return paramActivity;
        bool = false;
        break;
        paramInt = 0;
        break label150;
        paramActivity = null;
        paramInt = 0;
        break label154;
      }
      paramActivity = d.d.actF;
      AppMethodBeat.o(241090);
      return paramActivity;
    }
  }
  
  public final boolean isSwitchExist(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241042);
    s.u(paramString1, "permission");
    s.u(paramString2, "business");
    Object localObject = i.actT;
    paramString1 = i.buq(paramString1);
    localObject = i.actT;
    paramString2 = i.bup(paramString2);
    if ((paramString1 != null) && (paramString2 != null))
    {
      localObject = com.tencent.mm.sensitive.business.a.acuK;
      paramString1 = (com.tencent.mm.sensitive.business.a.b)com.tencent.mm.sensitive.business.a.iUa().get(paramString1);
      if (paramString1 == null) {}
    }
    for (boolean bool = paramString1.acuV.containsKey(paramString2);; bool = false)
    {
      AppMethodBeat.o(241042);
      return bool;
    }
  }
  
  public final boolean isUsingOldPermissionDialog()
  {
    AppMethodBeat.i(241115);
    com.tencent.mm.sensitive.ui.a locala = com.tencent.mm.sensitive.ui.a.acvO;
    boolean bool = com.tencent.mm.sensitive.ui.a.iUw();
    AppMethodBeat.o(241115);
    return bool;
  }
  
  public final void markEnterBusiness(String paramString)
  {
    AppMethodBeat.i(240965);
    s.u(paramString, "business");
    BusinessStackRecorder.a locala = BusinessStackRecorder.acuv;
    BusinessStackRecorder.a.iTY().bG("com.tencent.mm.sensitive.SENSITIVE_PAGE_ENTER", paramString, "");
    AppMethodBeat.o(240965);
  }
  
  public final void markExitBusiness(String paramString)
  {
    AppMethodBeat.i(240967);
    s.u(paramString, "business");
    BusinessStackRecorder.a locala = BusinessStackRecorder.acuv;
    BusinessStackRecorder.a.iTY().bG("com.tencent.mm.sensitive.SENSITIVE_PAGE_EXIT", paramString, "");
    AppMethodBeat.o(240967);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(241127);
    paramc = com.tencent.mm.sensitive.ui.a.acvO;
    com.tencent.mm.sensitive.ui.a.qT(true);
    AppMethodBeat.o(241127);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(241131);
    com.tencent.mm.sensitive.ui.a locala = com.tencent.mm.sensitive.ui.a.acvO;
    com.tencent.mm.sensitive.ui.a.qT(false);
    AppMethodBeat.o(241131);
  }
  
  public final void openBusinessSwitchOnPermissionGranted(d.c paramc)
  {
    AppMethodBeat.i(241110);
    s.u(paramc, "permission");
    Object localObject1 = com.tencent.mm.sensitive.business.a.acuK;
    localObject1 = (com.tencent.mm.sensitive.business.a.b)com.tencent.mm.sensitive.business.a.iUa().get(paramc);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.sensitive.business.a.b)localObject1).acuV;
      if (localObject1 != null)
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
          Object localObject2 = paramc.value;
          s.s(localObject2, "permission.value");
          localObject2 = getPermissionConfigMMkv((String)localObject2);
          if (localObject2 != null) {
            ((MultiProcessMMKV)localObject2).putBoolean(((d.a)localEntry.getKey()).value, true);
          }
        }
      }
    }
    AppMethodBeat.o(241110);
  }
  
  public final void requestPermission(final Activity paramActivity, final String paramString1, final String paramString2, final int paramInt, d.g paramg)
  {
    AppMethodBeat.i(241097);
    s.u(paramActivity, "activity");
    s.u(paramString1, "appid");
    s.u(paramString2, "permission");
    s.u(paramg, "callback");
    Object localObject1 = com.tencent.mm.sensitive.business.a.acuK;
    d.c localc = (d.c)com.tencent.mm.sensitive.business.a.iUb().get(paramString2);
    localObject1 = i.actT;
    d.a locala = i.ayl(paramInt);
    if (localc == null)
    {
      localObject1 = d.d.actG;
      ((d.d)localObject1).value = "unknown permission";
      localObject2 = ah.aiuX;
      paramg.onResult((d.d)localObject1);
    }
    if (locala == null)
    {
      localObject1 = d.d.actG;
      ((d.d)localObject1).value = "unknown business";
      localObject2 = ah.aiuX;
      paramg.onResult((d.d)localObject1);
    }
    Object localObject2 = new StringBuilder().append(paramString1).append('_');
    if (localc == null) {}
    for (localObject1 = null;; localObject1 = localc.value)
    {
      localObject1 = localObject1;
      localObject2 = MultiProcessMMKV.getMMKV(actW);
      if (localObject2 != null) {
        ((MultiProcessMMKV)localObject2).putLong((String)localObject1, cn.bDu());
      }
      if ((localc != null) && (locala != null)) {
        localObject1 = isPermissionGranted(paramActivity, paramString2, paramInt);
      }
      switch (b.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        paramg.onResult(d.d.actF);
        AppMethodBeat.o(241097);
        return;
      }
    }
    com.tencent.mm.pluginsdk.permission.b.a((Context)paramActivity, 0, (com.tencent.mm.pluginsdk.permission.c)new f(paramg, this, paramActivity, paramString1, paramString2, paramInt), new String[] { paramString2 });
    AppMethodBeat.o(241097);
    return;
    paramString1 = com.tencent.mm.sensitive.ui.a.acvO;
    paramString2 = (kotlin.g.a.b)new g(paramg);
    s.u(localc, "permission");
    s.u(locala, "business");
    if ((!com.tencent.mm.sensitive.ui.a.iUw()) && (com.tencent.mm.sensitive.ui.a.a(localc, locala)))
    {
      paramString1 = com.tencent.mm.sensitive.ui.a.a(localc);
      if (paramString1 == null) {
        break label425;
      }
      if (paramString1.booleanValue()) {
        break label414;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label420;
      }
      label380:
      if (paramString1 == null) {
        break label425;
      }
      paramString1.booleanValue();
    }
    label389:
    label392:
    label414:
    label420:
    label425:
    do
    {
      paramInt = 0;
      if (paramInt != 0) {
        break label517;
      }
      paramg.onResult(d.d.actF);
      AppMethodBeat.o(241097);
      return;
      paramInt = 0;
      break;
      paramString1 = null;
      break label380;
      paramString1 = MultiProcessMMKV.getMMKV(localc.value);
    } while (paramString1 == null);
    localObject1 = locala.value;
    boolean bool;
    if (!locala.acts.booleanValue())
    {
      bool = true;
      label459:
      paramString1 = Boolean.valueOf(paramString1.getBoolean((String)localObject1, bool));
      if (paramString1.booleanValue()) {
        break label525;
      }
      paramInt = 1;
      label481:
      if (paramInt == 0) {
        break label531;
      }
      label486:
      if (paramString1 == null) {
        break label534;
      }
      paramString1.booleanValue();
      if (paramActivity != null) {
        break label536;
      }
    }
    for (paramActivity = null;; paramActivity = ah.aiuX)
    {
      if (paramActivity == null) {
        com.tencent.mm.sensitive.ui.a.b(localc, locala, paramString2);
      }
      paramInt = 1;
      break label392;
      label517:
      break;
      bool = false;
      break label459;
      label525:
      paramInt = 0;
      break label481;
      label531:
      paramString1 = null;
      break label486;
      label534:
      break label389;
      label536:
      com.tencent.mm.sensitive.ui.a.a(paramActivity, localc, locala, paramString2);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isOk", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    c(d.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isOk", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    d(d.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(PluginSensitive paramPluginSensitive, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240934);
      paramd = new e(this.actZ, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(240934);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240926);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240926);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      long l = SystemClock.uptimeMillis();
      localObject1 = new ah.d();
      paramObject = l.acue;
      Object localObject2 = ((Map)l.gUz()).entrySet().iterator();
      Object localObject3;
      Object localObject4;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        paramObject = ((Map.Entry)localObject3).getValue();
        localObject4 = (CharSequence)((com.tencent.mm.sensitive.c.j)paramObject).iUk();
        int i;
        if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0))
        {
          i = 1;
          label149:
          if (i != 0) {
            break label225;
          }
          i = 1;
          label155:
          if (i == 0) {
            break label230;
          }
        }
        Object localObject5;
        for (;;)
        {
          localObject5 = (com.tencent.mm.sensitive.c.j)paramObject;
          if (localObject5 != null) {
            break label235;
          }
          paramObject = null;
          label172:
          if (paramObject != null) {
            break label396;
          }
          Log.i("Kenneth-methodCall", "service " + (String)((Map.Entry)localObject3).getKey() + " hook failed, processName:" + MMApplicationContext.getProcessName());
          break;
          i = 0;
          break label149;
          label225:
          i = 0;
          break label155;
          label230:
          paramObject = null;
        }
        label235:
        paramObject = new m((String)((Map.Entry)localObject3).getKey(), ((com.tencent.mm.sensitive.c.j)localObject5).iUk(), ((com.tencent.mm.sensitive.c.j)localObject5).iUi());
        localObject4 = paramObject.iTK();
        if (!((Boolean)((r)localObject4).bsC).booleanValue())
        {
          paramObject = com.tencent.mm.sensitive.d.a.acvx;
          com.tencent.mm.sensitive.d.a.bur((String)((Map.Entry)localObject3).getKey());
          label304:
          localObject5 = new StringBuilder("service ").append((String)((Map.Entry)localObject3).getKey()).append(" hook ");
          if (!((Boolean)((r)localObject4).bsC).booleanValue()) {
            break label444;
          }
        }
        label396:
        label442:
        label444:
        for (paramObject = "success";; paramObject = "failed")
        {
          Log.i("Kenneth-methodCall", paramObject + " , processName:" + MMApplicationContext.getProcessName() + ", errMsg:" + (String)((r)localObject4).bsD);
          paramObject = ah.aiuX;
          break label172;
          break;
          ((ah.d)localObject1).aixb += 1;
          paramObject = paramObject.acup;
          if (paramObject == null) {}
          for (paramObject = null;; paramObject = paramObject.eUp)
          {
            if (paramObject == null) {
              break label442;
            }
            ((com.tencent.mm.sensitive.c.j)localObject5).gD(paramObject);
            break;
          }
          break label304;
        }
      }
      paramObject = com.tencent.mm.sensitive.d.a.acvx;
      com.tencent.mm.sensitive.d.a.aM(SystemClock.uptimeMillis() - l, ((ah.d)localObject1).aixb);
      try
      {
        paramObject = b.acsz;
        b.iTG();
        androidx.core.app.a.a((androidx.core.app.a.b)new e());
        if (s.p(MMApplicationContext.getProcessName(), "com.tencent.mm"))
        {
          paramObject = MMApplicationContext.getContext();
          localObject2 = BusinessStackRecorder.acuv;
          localObject2 = (BroadcastReceiver)BusinessStackRecorder.a.iTY();
          localObject3 = new IntentFilter();
          localObject4 = BusinessStackRecorder.acuv;
          ((IntentFilter)localObject3).addAction(BusinessStackRecorder.iTN());
          localObject4 = BusinessStackRecorder.acuv;
          ((IntentFilter)localObject3).addAction(BusinessStackRecorder.iTO());
          localObject4 = ah.aiuX;
          paramObject.registerReceiver((BroadcastReceiver)localObject2, (IntentFilter)localObject3);
          RequestFloatWindowPermissionDialog.a((RequestFloatWindowPermissionDialog.a)h.actP);
        }
        paramObject = BusinessStackRecorder.acuv;
        BusinessStackRecorder.a.iTY();
        BusinessStackRecorder.iTM();
        paramObject = a.acsv;
        a.ayW();
        paramObject = g.actM;
        g.ayW();
        paramObject = c.acsB;
        c.ayW();
        paramObject = new StringBuilder("hook duration=").append(SystemClock.uptimeMillis() - l).append(",successCount = ").append(((ah.d)localObject1).aixb).append(",count = ");
        localObject1 = l.acue;
        Log.i("Kenneth-methodCall", l.gUz().size() + ",processName:" + MMApplicationContext.getProcessName());
        paramObject = ah.aiuX;
        AppMethodBeat.o(240926);
        return paramObject;
      }
      finally
      {
        for (;;)
        {
          localObject2 = com.tencent.mm.sensitive.d.a.acvx;
          com.tencent.mm.sensitive.d.a.pB("HookContentProvider", "HookContentProvider:");
          Log.i("Kenneth-methodCall", "hook provider failed:" + paramObject.getMessage() + ",size = " + PluginSensitive.access$getHookSuccessSize$p(this.actZ));
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/sensitive/PluginSensitive$requestPermission$3$1", "Lcom/tencent/mm/pluginsdk/permission/PermissionListener;", "onRequestPermissionsResult", "", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.pluginsdk.permission.c
  {
    f(d.g paramg, PluginSensitive paramPluginSensitive, Activity paramActivity, String paramString1, String paramString2, int paramInt) {}
    
    public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      int i = 0;
      AppMethodBeat.i(240898);
      if (paramArrayOfInt != null)
      {
        int j = paramArrayOfInt.length;
        paramInt = 0;
        if (paramInt < j) {
          if (paramArrayOfInt[paramInt] != -1) {}
        }
      }
      for (paramInt = i;; paramInt = 1)
      {
        if (paramInt == 0)
        {
          this.acua.onResult(d.d.actD);
          AppMethodBeat.o(240898);
          return;
          paramInt += 1;
          break;
        }
        jdField_this.requestPermission(paramActivity, paramString1, paramString2, paramInt, this.acua);
        AppMethodBeat.o(240898);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isOk", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    g(d.g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sensitive.PluginSensitive
 * JD-Core Version:    0.7.0.1
 */