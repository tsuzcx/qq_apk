package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.transmit.SelectConversationUI;

public final class f
{
  public static boolean a(String paramString1, Context paramContext, MMFragment paramMMFragment, String paramString2)
  {
    AppMethodBeat.i(34306);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(34306);
      return false;
    }
    Object localObject = null;
    if (paramString1.startsWith("weixin://openNativeUrl/weixinHB")) {
      localObject = new a();
    }
    while ((localObject != null) && (((c)localObject).a(paramString1, paramContext, paramMMFragment, paramString2)))
    {
      AppMethodBeat.o(34306);
      return true;
      if (b.bAz(paramString1)) {
        localObject = new b();
      } else if (d.bAz(paramString1)) {
        localObject = new d();
      }
    }
    AppMethodBeat.o(34306);
    return false;
  }
  
  static final class a
    implements f.c
  {
    public final boolean a(String paramString1, Context paramContext, MMFragment paramMMFragment, String paramString2)
    {
      AppMethodBeat.i(34301);
      if (paramString1.startsWith("weixin://openNativeUrl/weixinHB/startsendnormalhbrequest"))
      {
        paramString1 = new Intent();
        paramString1.putExtra("key_type", 0);
        c.b(paramContext, "luckymoney", ".ui.LuckyMoneyPrepareUI", paramString1);
        AppMethodBeat.o(34301);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/weixinHB/startsendrandomhbrequest"))
      {
        paramString1 = new Intent();
        paramString1.putExtra("key_type", 1);
        c.b(paramContext, "luckymoney", ".ui.LuckyMoneyPrepareUI", paramString1);
        AppMethodBeat.o(34301);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/weixinHB/startsendhblistrequest"))
      {
        paramString1 = new Intent();
        paramString1.putExtra("key_type", 1);
        c.b(paramContext, "luckymoney", ".ui.LuckyMoneyMyRecordUI", paramString1);
        AppMethodBeat.o(34301);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/weixinHB/startreceivehblistrequest"))
      {
        paramString1 = new Intent();
        paramString1.putExtra("key_type", 2);
        c.b(paramContext, "luckymoney", ".ui.LuckyMoneyMyRecordUI", paramString1);
        AppMethodBeat.o(34301);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/weixinHB/openDetail"))
      {
        paramMMFragment = new Intent();
        paramMMFragment.putExtra("key_native_url", paramString1);
        c.b(paramContext, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", paramMMFragment);
        AppMethodBeat.o(34301);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest"))
      {
        paramMMFragment = new Intent();
        paramMMFragment.putExtra("key_way", 5);
        paramMMFragment.putExtra("key_native_url", paramString1);
        paramMMFragment.putExtra("key_static_from_scene", 1);
        c.b(paramContext, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", paramMMFragment);
        AppMethodBeat.o(34301);
        return true;
      }
      AppMethodBeat.o(34301);
      return false;
    }
  }
  
  static final class b
    implements f.c
  {
    public static boolean bAz(String paramString)
    {
      AppMethodBeat.i(34302);
      if ((paramString != null) && ((paramString.startsWith("weixin://openNativeUrl/myDeviceList")) || (paramString.startsWith("weixin://openNativeUrl/bindMyDevice"))))
      {
        AppMethodBeat.o(34302);
        return true;
      }
      AppMethodBeat.o(34302);
      return false;
    }
    
    public final boolean a(String paramString1, Context paramContext, MMFragment paramMMFragment, String paramString2)
    {
      AppMethodBeat.i(34303);
      if (Util.isNullOrNil(paramString1))
      {
        AppMethodBeat.o(34303);
        return false;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/myDeviceList"))
      {
        paramString1 = new Intent();
        paramString1.putExtra("device_brand_name", paramString2);
        c.b(paramContext, "exdevice", ".ui.ExdeviceManageDeviceUI", paramString1);
        AppMethodBeat.o(34303);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/bindMyDevice"))
      {
        AppMethodBeat.o(34303);
        return false;
      }
      AppMethodBeat.o(34303);
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean a(String paramString1, Context paramContext, MMFragment paramMMFragment, String paramString2);
  }
  
  static final class d
    implements f.c
  {
    public static boolean bAz(String paramString)
    {
      AppMethodBeat.i(34304);
      if ((paramString != null) && ((paramString.startsWith("weixin://wesport/recommend")) || (paramString.startsWith("weixin://openNativeUrl/rankMyHomepage")) || (paramString.startsWith("weixin://openNativeUrl/rankSetting"))))
      {
        AppMethodBeat.o(34304);
        return true;
      }
      AppMethodBeat.o(34304);
      return false;
    }
    
    public final boolean a(String paramString1, Context paramContext, MMFragment paramMMFragment, String paramString2)
    {
      AppMethodBeat.i(34305);
      if (Util.isNullOrNil(paramString1))
      {
        Log.d("MicroMsg.BizNativeUrlDispatcher", "nativeUrl is null.");
        AppMethodBeat.o(34305);
        return false;
      }
      if ((paramString1.startsWith("weixin://wesport/recommend")) && (paramMMFragment != null))
      {
        paramString1 = new Intent(paramContext, SelectConversationUI.class);
        paramString1.putExtra("Select_Talker_Name", paramString2);
        paramString1.putExtra("Select_block_List", paramString2);
        paramString1.putExtra("Select_Conv_Type", 3);
        paramString1.putExtra("Select_Send_Card", true);
        paramMMFragment.startActivityForResult(paramString1, 224);
        AppMethodBeat.o(34305);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/rankMyHomepage"))
      {
        paramString1 = z.bAM();
        if (Util.isNullOrNil(paramString1))
        {
          Log.e("MicroMsg.BizNativeUrlDispatcher", "Get username from UserInfo return null or nil.");
          AppMethodBeat.o(34305);
          return false;
        }
        paramMMFragment = new Intent();
        paramMMFragment.putExtra("username", paramString1);
        c.b(paramContext, "exdevice", ".ui.ExdeviceProfileUI", paramMMFragment);
        Log.i("MicroMsg.BizNativeUrlDispatcher", "Jump to ExdeviceProfileUI.");
        AppMethodBeat.o(34305);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/rankSetting"))
      {
        c.ai(paramContext, "exdevice", ".ui.ExdeviceSettingUI");
        AppMethodBeat.o(34305);
        return true;
      }
      AppMethodBeat.o(34305);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f
 * JD-Core Version:    0.7.0.1
 */