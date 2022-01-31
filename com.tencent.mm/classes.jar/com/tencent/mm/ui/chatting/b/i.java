package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.l;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.x;
import com.tencent.mm.vfs.e;

public final class i
{
  public static boolean Z(ad paramad)
  {
    return (paramad.field_username.equals("medianote")) && ((q.Gn() & 0x4000) == 0);
  }
  
  public static ViewStub a(x paramx, int paramInt)
  {
    paramx = (ViewStub)paramx.findViewById(paramInt);
    if (paramx != null) {
      paramx.inflate();
    }
    return paramx;
  }
  
  public static void a(a parama, bi parambi, Intent paramIntent)
  {
    if ((parama == null) || (parambi == null)) {
      return;
    }
    String str = parama.getTalkerUserName();
    Object localObject2 = parama.pSb.field_username;
    boolean bool = ((com.tencent.mm.ui.chatting.b.b.c)parama.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG();
    Object localObject1;
    if (!parama.cFD())
    {
      localObject1 = localObject2;
      if (!bool) {}
    }
    else
    {
      if (!parama.cFD()) {
        break label173;
      }
      localObject1 = com.tencent.mm.model.bd.iI(parambi.field_content);
      if ((localObject2 == null) || (localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break label209;
      }
    }
    for (;;)
    {
      localObject2 = new Bundle();
      int i;
      if (parama.cFD()) {
        i = 2;
      }
      for (;;)
      {
        ((Bundle)localObject2).putInt("stat_scene", i);
        ((Bundle)localObject2).putString("stat_msg_id", "msg_" + Long.toString(parambi.field_msgSvrId));
        ((Bundle)localObject2).putString("stat_chat_talker_username", str);
        ((Bundle)localObject2).putString("stat_send_msg_user", (String)localObject1);
        paramIntent.putExtra("_stat_obj", (Bundle)localObject2);
        return;
        label173:
        localObject1 = localObject2;
        if (parambi == null) {
          break;
        }
        localObject1 = parambi.field_bizChatUserId;
        break;
        if (s.hl(str)) {
          i = 7;
        } else {
          i = 1;
        }
      }
      label209:
      localObject1 = localObject2;
    }
  }
  
  public static boolean ads(String paramString)
  {
    int j;
    int i;
    if ((!s.hk(paramString)) && (l.gA(paramString)) && (!q.gS(paramString)))
    {
      au.Hx();
      ad localad = com.tencent.mm.model.c.Fw().abl(paramString);
      if (localad == null) {
        break label108;
      }
      j = localad.field_type;
      au.Hx();
      localad = com.tencent.mm.model.c.Fw().abl(localad.field_encryptUsername);
      if (localad == null) {
        break label103;
      }
      i = localad.field_type;
    }
    for (;;)
    {
      y.i("MicroMsg.ChattingUI.ChattingLogic", "isStranger:%s type:%d etype:%d", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(i) });
      return true;
      return false;
      label103:
      i = -1;
      continue;
      label108:
      i = -1;
      j = -1;
    }
  }
  
  public static boolean e(bi parambi, String paramString)
  {
    return (System.currentTimeMillis() - parambi.field_createTime > 259200000L) && ((bk.bl(paramString)) || (!e.bK(paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.i
 * JD-Core Version:    0.7.0.1
 */