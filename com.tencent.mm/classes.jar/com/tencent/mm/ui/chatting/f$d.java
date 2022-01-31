package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.x;

final class f$d
  implements f.c
{
  public final boolean a(String paramString1, Context paramContext, x paramx, String paramString2)
  {
    if (bk.bl(paramString1)) {
      y.d("MicroMsg.BizNativeUrlDispatcher", "nativeUrl is null.");
    }
    do
    {
      return false;
      if ((paramString1.startsWith("weixin://wesport/recommend")) && (paramx != null))
      {
        paramString1 = new Intent(paramContext, SelectConversationUI.class);
        paramString1.putExtra("Select_Talker_Name", paramString2);
        paramString1.putExtra("Select_block_List", paramString2);
        paramString1.putExtra("Select_Conv_Type", 3);
        paramString1.putExtra("Select_Send_Card", true);
        paramx.startActivityForResult(paramString1, 224);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/rankMyHomepage"))
      {
        paramString1 = q.Gj();
        if (bk.bl(paramString1))
        {
          y.e("MicroMsg.BizNativeUrlDispatcher", "Get username from UserInfo return null or nil.");
          return false;
        }
        paramx = new Intent();
        paramx.putExtra("username", paramString1);
        d.b(paramContext, "exdevice", ".ui.ExdeviceProfileUI", paramx);
        y.i("MicroMsg.BizNativeUrlDispatcher", "Jump to ExdeviceProfileUI.");
        return true;
      }
    } while (!paramString1.startsWith("weixin://openNativeUrl/rankSetting"));
    d.x(paramContext, "exdevice", ".ui.ExdeviceSettingUI");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.d
 * JD-Core Version:    0.7.0.1
 */