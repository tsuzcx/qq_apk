package com.tencent.mm.sdk.vendor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/vendor/HuaweiKt;", "", "()V", "TAG", "", "hasHuaweiMagicWindowFeature", "", "Ljava/lang/Boolean;", "wechat-commons-sdk_release"})
public final class HuaweiKt
{
  public static final HuaweiKt INSTANCE;
  private static final String TAG = "MicroMsg.HuaweiKt";
  private static Boolean hasHuaweiMagicWindowFeature;
  
  static
  {
    AppMethodBeat.i(209895);
    INSTANCE = new HuaweiKt();
    AppMethodBeat.o(209895);
  }
  
  public static final boolean hasHuaweiMagicWindowFeature()
  {
    AppMethodBeat.i(209892);
    Object localObject;
    boolean bool;
    if (hasHuaweiMagicWindowFeature != null)
    {
      localObject = hasHuaweiMagicWindowFeature;
      if (localObject == null) {
        p.iCn();
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(209892);
      return bool;
    }
    try
    {
      localObject = Class.forName("com.huawei.android.os.SystemPropertiesEx");
      p.j(localObject, "Class.forName(\"com.huawe…d.os.SystemPropertiesEx\")");
      Method localMethod = ((Class)localObject).getMethod("getBoolean", new Class[] { String.class, Boolean.TYPE });
      p.j(localMethod, "clazz.getMethod(\"getBool…:class.javaPrimitiveType)");
      localObject = localMethod.invoke(((Class)localObject).newInstance(), new Object[] { "ro.config.hw_magic_window_enable", Boolean.FALSE });
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(209892);
        throw ((Throwable)localObject);
      }
    }
    catch (Throwable localThrowable)
    {
      Log.w("MicroMsg.HuaweiKt", "hasHuaweiMagicWindowFeature: " + localThrowable.getMessage());
      bool = false;
    }
    for (;;)
    {
      Boolean localBoolean = Boolean.valueOf(bool);
      hasHuaweiMagicWindowFeature = localBoolean;
      if (localBoolean == null) {
        p.iCn();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(209892);
      return bool;
      bool = ((Boolean)localBoolean).booleanValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.vendor.HuaweiKt
 * JD-Core Version:    0.7.0.1
 */