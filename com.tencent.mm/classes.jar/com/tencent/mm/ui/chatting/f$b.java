package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.x;

final class f$b
  implements f.c
{
  public final boolean a(String paramString1, Context paramContext, x paramx, String paramString2)
  {
    if (bk.bl(paramString1)) {}
    do
    {
      return false;
      if (paramString1.startsWith("weixin://openNativeUrl/myDeviceList"))
      {
        paramString1 = new Intent();
        paramString1.putExtra("device_brand_name", paramString2);
        d.b(paramContext, "exdevice", ".ui.ExdeviceManageDeviceUI", paramString1);
        return true;
      }
    } while (!paramString1.startsWith("weixin://openNativeUrl/bindMyDevice"));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.b
 * JD-Core Version:    0.7.0.1
 */