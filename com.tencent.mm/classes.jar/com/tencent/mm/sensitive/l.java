package com.tencent.mm.sensitive;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sensitive.c.b;
import com.tencent.mm.sensitive.c.c;
import com.tencent.mm.sensitive.c.d;
import com.tencent.mm.sensitive.c.e;
import com.tencent.mm.sensitive.c.f;
import com.tencent.mm.sensitive.c.g;
import com.tencent.mm.sensitive.c.h;
import com.tencent.mm.sensitive.c.i;
import com.tencent.mm.sensitive.c.j;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/ServiceBinderMap;", "", "()V", "Map", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/sensitive/processor/IHookSysServiceProcessor;", "Lkotlin/collections/HashMap;", "getMap", "()Ljava/util/HashMap;", "hookClipServiceProcessor", "Lcom/tencent/mm/sensitive/processor/HookClipServiceProcessor;", "getHookClipServiceProcessor", "()Lcom/tencent/mm/sensitive/processor/HookClipServiceProcessor;", "hookDeviceIdsPolicyServiceProcessor", "Lcom/tencent/mm/sensitive/processor/HookDeviceIdsPolicyServiceProcessor;", "getHookDeviceIdsPolicyServiceProcessor", "()Lcom/tencent/mm/sensitive/processor/HookDeviceIdsPolicyServiceProcessor;", "hookPhoneRegisterProcessor", "Lcom/tencent/mm/sensitive/processor/HookPhoneRegisterProcessor;", "getHookPhoneRegisterProcessor", "()Lcom/tencent/mm/sensitive/processor/HookPhoneRegisterProcessor;", "locationManagerProcessor", "Lcom/tencent/mm/sensitive/processor/HookLocationManagerProcessor;", "getLocationManagerProcessor", "()Lcom/tencent/mm/sensitive/processor/HookLocationManagerProcessor;", "packageManagerProcessor", "Lcom/tencent/mm/sensitive/processor/HookPackageManagerProcessor;", "getPackageManagerProcessor", "()Lcom/tencent/mm/sensitive/processor/HookPackageManagerProcessor;", "phoneSubInfoProcessor", "Lcom/tencent/mm/sensitive/processor/HookPhoneSubInfoProcessor;", "getPhoneSubInfoProcessor", "()Lcom/tencent/mm/sensitive/processor/HookPhoneSubInfoProcessor;", "telephonyManagerProcessor", "Lcom/tencent/mm/sensitive/processor/HookTelephonyManagerProcessor;", "getTelephonyManagerProcessor", "()Lcom/tencent/mm/sensitive/processor/HookTelephonyManagerProcessor;", "wifiManagerProcessor", "Lcom/tencent/mm/sensitive/processor/HookWifiManagerProcessor;", "getWifiManagerProcessor", "()Lcom/tencent/mm/sensitive/processor/HookWifiManagerProcessor;", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l acue;
  private static final e acuf;
  private static final i acug;
  private static final h acuh;
  private static final g acui;
  private static final d acuj;
  private static final c acuk;
  private static final b acul;
  private static final f acum;
  private static final HashMap<String, j> acun;
  
  static
  {
    AppMethodBeat.i(240892);
    acue = new l();
    acuf = new e();
    acug = new i();
    acuh = new h();
    acui = new g();
    acuj = new d();
    acuk = new c();
    acul = new b();
    acum = new f();
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("package", acuf);
    ((Map)localHashMap).put("wifi", acug);
    ((Map)localHashMap).put("phone", acuh);
    ((Map)localHashMap).put("iphonesubinfo", acui);
    ((Map)localHashMap).put("location", acuj);
    ((Map)localHashMap).put("device_identifiers", acuk);
    ((Map)localHashMap).put("clipboard", acul);
    ((Map)localHashMap).put("telephony.registry", acum);
    acun = localHashMap;
    AppMethodBeat.o(240892);
  }
  
  public static HashMap<String, j> gUz()
  {
    return acun;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sensitive.l
 * JD-Core Version:    0.7.0.1
 */