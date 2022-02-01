package com.tencent.mm.sensitive.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/processor/HookPackageManagerProcessor;", "Lcom/tencent/mm/sensitive/processor/BaseHookSysServiceProcessor;", "()V", "TAG", "", "cachePackageInfo", "", "afterHookSuccess", "", "serviceBinderProxy", "binderClazzName", "hookIPackageManager", "target", "fieldList", "", "Ljava/lang/reflect/Field;", "(Ljava/lang/Object;[Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "serviceName", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  private final String TAG = "HookPackageManagerProcessor";
  
  private static void a(Object paramObject1, Field[] paramArrayOfField, Object paramObject2)
  {
    AppMethodBeat.i(240964);
    int i;
    label18:
    label22:
    label32:
    Field localField;
    if (paramArrayOfField.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label88;
      }
      i = 1;
      if (i == 0) {
        break label93;
      }
      if (paramArrayOfField == null) {
        break label105;
      }
      int j = paramArrayOfField.length;
      i = 0;
      if (i >= j) {
        break label105;
      }
      localField = paramArrayOfField[i];
      if (!s.p(localField.getType().getSimpleName(), "IPackageManager")) {
        break label98;
      }
    }
    label88:
    label93:
    label98:
    label105:
    for (paramArrayOfField = localField;; paramArrayOfField = null)
    {
      if (paramArrayOfField != null)
      {
        paramArrayOfField.setAccessible(true);
        paramArrayOfField.set(paramObject1, paramObject2);
      }
      AppMethodBeat.o(240964);
      return;
      i = 0;
      break;
      i = 0;
      break label18;
      paramArrayOfField = null;
      break label22;
      i += 1;
      break label32;
    }
  }
  
  public final void gD(Object paramObject)
  {
    AppMethodBeat.i(240970);
    s.u(paramObject, "serviceBinderProxy");
    Object localObject = MMApplicationContext.getContext().getPackageManager();
    s.s(localObject, "applicationPkgManager");
    Field[] arrayOfField = localObject.getClass().getDeclaredFields();
    s.s(arrayOfField, "applicationPkgManager.javaClass.declaredFields");
    a(localObject, arrayOfField, paramObject);
    localObject = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.zBn;
    localObject = a.a.getClass("android.app.ActivityThread");
    if (localObject != null)
    {
      arrayOfField = ((Class)localObject).getDeclaredFields();
      s.s(arrayOfField, "activityThread.declaredFields");
      a(localObject, arrayOfField, paramObject);
    }
    AppMethodBeat.o(240970);
  }
  
  public final String iUj()
  {
    return "package";
  }
  
  public final String iUk()
  {
    return "android.content.pm.IPackageManager";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sensitive.c.e
 * JD-Core Version:    0.7.0.1
 */