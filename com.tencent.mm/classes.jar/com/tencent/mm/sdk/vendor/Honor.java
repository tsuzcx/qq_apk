package com.tencent.mm.sdk.vendor;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/vendor/Honor;", "", "()V", "TAG", "", "isHONOR", "", "Ljava/lang/Boolean;", "ifHONOR", "wechat-commons-sdk_release"})
public final class Honor
{
  public static final Honor INSTANCE;
  public static final String TAG = "MicroMsg.Vendor.Honor";
  private static Boolean isHONOR;
  
  static
  {
    AppMethodBeat.i(209979);
    INSTANCE = new Honor();
    AppMethodBeat.o(209979);
  }
  
  public final boolean ifHONOR()
  {
    boolean bool = true;
    AppMethodBeat.i(209978);
    Object localObject;
    if (isHONOR == null)
    {
      localObject = Build.BRAND;
      String str = Build.MANUFACTURER;
      Log.i("MicroMsg.Vendor.Honor", "Build.BRAND:" + (String)localObject + ", manufacture:" + str);
      if ((!n.L("HONOR", (String)localObject, true)) || (!n.L("HONOR", str, true))) {
        break label103;
      }
    }
    for (;;)
    {
      isHONOR = Boolean.valueOf(bool);
      localObject = isHONOR;
      if (localObject != null) {
        break;
      }
      localObject = new t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(209978);
      throw ((Throwable)localObject);
      label103:
      bool = false;
    }
    bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(209978);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.vendor.Honor
 * JD-Core Version:    0.7.0.1
 */