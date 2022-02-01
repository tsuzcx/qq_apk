package com.tencent.mm.sensitive.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sensitive.b.a.a;
import com.tencent.mm.sensitive.b.a.b;
import com.tencent.mm.sensitive.b.a.e;
import com.tencent.mm.sensitive.b.a.f;
import com.tencent.mm.sensitive.b.a.g;
import com.tencent.mm.sensitive.b.a.h;
import com.tencent.mm.sensitive.b.a.i;
import com.tencent.mm.sensitive.b.a.j;
import com.tencent.mm.sensitive.b.a.k;
import com.tencent.mm.sensitive.b.a.l;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/methodconfig/MethodCheckMap;", "", "()V", "Map", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/sensitive/methodconfig/IMethodCheckConfig;", "Lkotlin/collections/HashMap;", "getMap", "()Ljava/util/HashMap;", "addPrimaryChangedListenerCheck", "Lcom/tencent/mm/sensitive/methodconfig/method/AddPrimaryChangedListenerCheck;", "getAddPrimaryChangedListenerCheck", "()Lcom/tencent/mm/sensitive/methodconfig/method/AddPrimaryChangedListenerCheck;", "getConnectionCheck", "Lcom/tencent/mm/sensitive/methodconfig/method/GetConnectionInfoCheck;", "getGetConnectionCheck", "()Lcom/tencent/mm/sensitive/methodconfig/method/GetConnectionInfoCheck;", "getDeviceIdCheck", "Lcom/tencent/mm/sensitive/methodconfig/method/GetDeviceIdCheck;", "getGetDeviceIdCheck", "()Lcom/tencent/mm/sensitive/methodconfig/method/GetDeviceIdCheck;", "getDeviceIdWithFeatureCheck", "Lcom/tencent/mm/sensitive/methodconfig/method/GetDeviceIdWithFeatureCheck;", "getGetDeviceIdWithFeatureCheck", "()Lcom/tencent/mm/sensitive/methodconfig/method/GetDeviceIdWithFeatureCheck;", "getImeiCheck", "Lcom/tencent/mm/sensitive/methodconfig/method/GetImeiCheck;", "getGetImeiCheck", "()Lcom/tencent/mm/sensitive/methodconfig/method/GetImeiCheck;", "getInstallPkgCheck", "Lcom/tencent/mm/sensitive/methodconfig/method/GetInstallPkgCheck;", "getGetInstallPkgCheck", "()Lcom/tencent/mm/sensitive/methodconfig/method/GetInstallPkgCheck;", "getSerial", "Lcom/tencent/mm/sensitive/methodconfig/method/GetSerialCheck;", "getGetSerial", "()Lcom/tencent/mm/sensitive/methodconfig/method/GetSerialCheck;", "getSerialForPkg", "Lcom/tencent/mm/sensitive/methodconfig/method/GetSerialForPkgCheck;", "getGetSerialForPkg", "()Lcom/tencent/mm/sensitive/methodconfig/method/GetSerialForPkgCheck;", "getSubscriberIdCheck", "Lcom/tencent/mm/sensitive/methodconfig/method/GetSubscriberIdCheck;", "getGetSubscriberIdCheck", "()Lcom/tencent/mm/sensitive/methodconfig/method/GetSubscriberIdCheck;", "getSubscriberIdForSubscriber", "Lcom/tencent/mm/sensitive/methodconfig/method/GetSubscriberIdForSubscriber;", "getGetSubscriberIdForSubscriber", "()Lcom/tencent/mm/sensitive/methodconfig/method/GetSubscriberIdForSubscriber;", "listenForSubscriberCheck", "Lcom/tencent/mm/sensitive/methodconfig/method/ListenForSubscriberCheck;", "getListenForSubscriberCheck", "()Lcom/tencent/mm/sensitive/methodconfig/method/ListenForSubscriberCheck;", "queryIntentActivitiesCheck", "Lcom/tencent/mm/sensitive/methodconfig/method/QueryIntentActivitiesCheck;", "getQueryIntentActivitiesCheck", "()Lcom/tencent/mm/sensitive/methodconfig/method/QueryIntentActivitiesCheck;", "saveCache", "", "methodName", "value", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final HashMap<String, c> acun;
  public static final d acve;
  private static final b acvf;
  private static final com.tencent.mm.sensitive.b.a.c acvg;
  private static final com.tencent.mm.sensitive.b.a.d acvh;
  private static final e acvi;
  private static final f acvj;
  private static final i acvk;
  private static final j acvl;
  private static final h acvm;
  private static final g acvn;
  private static final l acvo;
  private static final a acvp;
  private static final k acvq;
  
  static
  {
    AppMethodBeat.i(241086);
    acve = new d();
    acvf = new b();
    acvg = new com.tencent.mm.sensitive.b.a.c();
    acvh = new com.tencent.mm.sensitive.b.a.d();
    acvi = new e();
    acvj = new f();
    acvk = new i();
    acvl = new j();
    acvm = new h();
    acvn = new g();
    acvo = new l();
    acvp = new a();
    acvq = new k();
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("getConnectionInfo", acvf);
    ((Map)localHashMap).put("getInstalledPackages", acvj);
    ((Map)localHashMap).put("getDeviceId", acvg);
    ((Map)localHashMap).put("getSubscriberId", acvk);
    ((Map)localHashMap).put("getDeviceIdWithFeature", acvh);
    ((Map)localHashMap).put("getImeiForSlot", acvi);
    ((Map)localHashMap).put("getSubscriberIdForSubscriber", acvl);
    ((Map)localHashMap).put("getSerialForPackage", acvm);
    ((Map)localHashMap).put("getSerial", acvn);
    ((Map)localHashMap).put("queryIntentActivities", acvo);
    ((Map)localHashMap).put("addPrimaryClipChangedListener", acvp);
    ((Map)localHashMap).put("listenForSubscriber", acvq);
    acun = localHashMap;
    AppMethodBeat.o(241086);
  }
  
  public static void Q(String paramString, Object paramObject)
  {
    AppMethodBeat.i(241076);
    s.u(paramString, "methodName");
    s.u(paramObject, "value");
    paramString = (c)acun.get(paramString);
    if (paramString != null) {
      paramString.gC(paramObject);
    }
    AppMethodBeat.o(241076);
  }
  
  public static HashMap<String, c> gUz()
  {
    return acun;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.b.d
 * JD-Core Version:    0.7.0.1
 */