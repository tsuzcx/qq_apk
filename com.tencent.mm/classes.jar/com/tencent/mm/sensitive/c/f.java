package com.tencent.mm.sensitive.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a.a;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/processor/HookPhoneRegisterProcessor;", "Lcom/tencent/mm/sensitive/processor/BaseHookSysServiceProcessor;", "()V", "afterHookSuccess", "", "service", "", "binderClazzName", "", "serviceName", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  public final void gD(Object paramObject)
  {
    AppMethodBeat.i(240962);
    s.u(paramObject, "service");
    super.gD(paramObject);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.zBn;
    Class localClass = a.a.getClass("android.telephony.TelephonyManager");
    int i;
    label49:
    label55:
    label62:
    label66:
    label77:
    Object localObject2;
    if (localClass == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label153;
      }
      if (localObject1.length != 0) {
        break label143;
      }
      i = 1;
      if (i != 0) {
        break label148;
      }
      i = 1;
      if (i != 1) {
        break label153;
      }
      i = 1;
      if (i == 0) {
        break label158;
      }
      if (localObject1 == null) {
        break label171;
      }
      int j = localObject1.length;
      i = 0;
      if (i >= j) {
        break label171;
      }
      localObject2 = localObject1[i];
      if (!s.p(localObject2.getType().getSimpleName(), "ITelephonyRegistry")) {
        break label164;
      }
    }
    label143:
    label148:
    label153:
    label158:
    label164:
    label171:
    for (localObject1 = localObject2;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((Field)localObject1).setAccessible(true);
        ((Field)localObject1).set(localClass, paramObject);
      }
      AppMethodBeat.o(240962);
      return;
      localObject1 = localClass.getDeclaredFields();
      break;
      i = 0;
      break label49;
      i = 0;
      break label55;
      i = 0;
      break label62;
      localObject1 = null;
      break label66;
      i += 1;
      break label77;
    }
  }
  
  public final String iUj()
  {
    return "telephony.registry";
  }
  
  public final String iUk()
  {
    return "com.android.internal.telephony.ITelephonyRegistry";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sensitive.c.f
 * JD-Core Version:    0.7.0.1
 */