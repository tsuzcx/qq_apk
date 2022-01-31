package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;

final class e$b
  implements e.c
{
  public static boolean atJ(String paramString)
  {
    AppMethodBeat.i(30452);
    if ((paramString != null) && ((paramString.startsWith("weixin://openNativeUrl/myDeviceList")) || (paramString.startsWith("weixin://openNativeUrl/bindMyDevice"))))
    {
      AppMethodBeat.o(30452);
      return true;
    }
    AppMethodBeat.o(30452);
    return false;
  }
  
  public final boolean a(String paramString1, Context paramContext, MMFragment paramMMFragment, String paramString2)
  {
    AppMethodBeat.i(30453);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(30453);
      return false;
    }
    if (paramString1.startsWith("weixin://openNativeUrl/myDeviceList"))
    {
      paramString1 = new Intent();
      paramString1.putExtra("device_brand_name", paramString2);
      d.b(paramContext, "exdevice", ".ui.ExdeviceManageDeviceUI", paramString1);
      AppMethodBeat.o(30453);
      return true;
    }
    if (paramString1.startsWith("weixin://openNativeUrl/bindMyDevice"))
    {
      AppMethodBeat.o(30453);
      return false;
    }
    AppMethodBeat.o(30453);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.b
 * JD-Core Version:    0.7.0.1
 */