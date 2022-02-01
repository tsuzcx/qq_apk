package com.tencent.mm.sdk.vendor;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/vendor/Honor;", "", "()V", "TAG", "", "isHONOR", "", "Ljava/lang/Boolean;", "ifHONOR", "wechat-commons-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Honor
{
  public static final Honor INSTANCE;
  public static final String TAG = "MicroMsg.Vendor.Honor";
  private static Boolean isHONOR;
  
  static
  {
    AppMethodBeat.i(243182);
    INSTANCE = new Honor();
    AppMethodBeat.o(243182);
  }
  
  public final boolean ifHONOR()
  {
    boolean bool = true;
    AppMethodBeat.i(243186);
    Object localObject;
    if (isHONOR == null)
    {
      localObject = Build.BRAND;
      String str = Build.MANUFACTURER;
      Log.i("MicroMsg.Vendor.Honor", "Build.BRAND:" + localObject + ", manufacture:" + str);
      if ((!n.T("HONOR", (String)localObject, true)) || (!n.T("HONOR", str, true))) {
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
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(243186);
      throw ((Throwable)localObject);
      label103:
      bool = false;
    }
    bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(243186);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.vendor.Honor
 * JD-Core Version:    0.7.0.1
 */