package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.transmit.SelectConversationUI;

final class e$d
  implements e.c
{
  public static boolean atJ(String paramString)
  {
    AppMethodBeat.i(30454);
    if ((paramString != null) && ((paramString.startsWith("weixin://wesport/recommend")) || (paramString.startsWith("weixin://openNativeUrl/rankMyHomepage")) || (paramString.startsWith("weixin://openNativeUrl/rankSetting"))))
    {
      AppMethodBeat.o(30454);
      return true;
    }
    AppMethodBeat.o(30454);
    return false;
  }
  
  public final boolean a(String paramString1, Context paramContext, MMFragment paramMMFragment, String paramString2)
  {
    AppMethodBeat.i(30455);
    if (bo.isNullOrNil(paramString1))
    {
      ab.d("MicroMsg.BizNativeUrlDispatcher", "nativeUrl is null.");
      AppMethodBeat.o(30455);
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
      AppMethodBeat.o(30455);
      return true;
    }
    if (paramString1.startsWith("weixin://openNativeUrl/rankMyHomepage"))
    {
      paramString1 = r.Zn();
      if (bo.isNullOrNil(paramString1))
      {
        ab.e("MicroMsg.BizNativeUrlDispatcher", "Get username from UserInfo return null or nil.");
        AppMethodBeat.o(30455);
        return false;
      }
      paramMMFragment = new Intent();
      paramMMFragment.putExtra("username", paramString1);
      d.b(paramContext, "exdevice", ".ui.ExdeviceProfileUI", paramMMFragment);
      ab.i("MicroMsg.BizNativeUrlDispatcher", "Jump to ExdeviceProfileUI.");
      AppMethodBeat.o(30455);
      return true;
    }
    if (paramString1.startsWith("weixin://openNativeUrl/rankSetting"))
    {
      d.H(paramContext, "exdevice", ".ui.ExdeviceSettingUI");
      AppMethodBeat.o(30455);
      return true;
    }
    AppMethodBeat.o(30455);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.d
 * JD-Core Version:    0.7.0.1
 */