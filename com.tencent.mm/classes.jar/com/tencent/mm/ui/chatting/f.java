package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.x;

public final class f
{
  public static boolean a(String paramString1, Context paramContext, x paramx, String paramString2)
  {
    if (bk.bl(paramString1)) {
      return false;
    }
    Object localObject = null;
    if (paramString1.startsWith("weixin://openNativeUrl/weixinHB")) {
      localObject = new f.a();
    }
    label150:
    label154:
    for (;;)
    {
      label30:
      if ((localObject != null) && (((f.c)localObject).a(paramString1, paramContext, paramx, paramString2)))
      {
        return true;
        if ((paramString1 != null) && ((paramString1.startsWith("weixin://openNativeUrl/myDeviceList")) || (paramString1.startsWith("weixin://openNativeUrl/bindMyDevice")))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label99;
          }
          localObject = new f.b();
          break;
        }
        label99:
        if ((paramString1 == null) || ((!paramString1.startsWith("weixin://wesport/recommend")) && (!paramString1.startsWith("weixin://openNativeUrl/rankMyHomepage")) && (!paramString1.startsWith("weixin://openNativeUrl/rankSetting")))) {
          break label150;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label154;
        }
        localObject = new f.d();
        break label30;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f
 * JD-Core Version:    0.7.0.1
 */