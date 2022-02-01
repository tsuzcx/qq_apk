package com.tencent.mm.sdk.vendor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/vendor/HuaweiKt;", "", "()V", "TAG", "", "hasHuaweiMagicWindowFeature", "", "Ljava/lang/Boolean;", "wechat-commons-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HuaweiKt
{
  public static final HuaweiKt INSTANCE;
  private static final String TAG = "MicroMsg.HuaweiKt";
  private static Boolean hasHuaweiMagicWindowFeature;
  
  static
  {
    AppMethodBeat.i(243190);
    INSTANCE = new HuaweiKt();
    AppMethodBeat.o(243190);
  }
  
  public static final boolean hasHuaweiMagicWindowFeature()
  {
    AppMethodBeat.i(243183);
    Object localObject1;
    boolean bool;
    if (hasHuaweiMagicWindowFeature != null)
    {
      localObject1 = hasHuaweiMagicWindowFeature;
      s.checkNotNull(localObject1);
      bool = ((Boolean)localObject1).booleanValue();
      AppMethodBeat.o(243183);
      return bool;
    }
    Boolean localBoolean;
    try
    {
      localObject1 = Class.forName("com.huawei.android.os.SystemPropertiesEx");
      localObject1 = ((Class)localObject1).getMethod("getBoolean", new Class[] { String.class, Boolean.TYPE }).invoke(((Class)localObject1).newInstance(), new Object[] { "ro.config.hw_magic_window_enable", Boolean.FALSE });
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(243183);
        throw ((Throwable)localObject1);
      }
    }
    finally
    {
      Log.w("MicroMsg.HuaweiKt", s.X("hasHuaweiMagicWindowFeature: ", localObject2.getMessage()));
      localBoolean = Boolean.FALSE;
    }
    for (;;)
    {
      hasHuaweiMagicWindowFeature = localBoolean;
      s.checkNotNull(localBoolean);
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(243183);
      return bool;
      bool = ((Boolean)localBoolean).booleanValue();
      localBoolean = Boolean.valueOf(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.vendor.HuaweiKt
 * JD-Core Version:    0.7.0.1
 */