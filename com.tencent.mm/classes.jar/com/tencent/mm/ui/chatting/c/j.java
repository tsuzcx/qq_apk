package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.model.p;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.vfs.i;

public final class j
{
  public static ViewStub a(MMFragment paramMMFragment, int paramInt)
  {
    AppMethodBeat.i(35193);
    paramMMFragment = (ViewStub)paramMMFragment.findViewById(paramInt);
    if (paramMMFragment != null) {
      paramMMFragment.inflate();
    }
    AppMethodBeat.o(35193);
    return paramMMFragment;
  }
  
  public static void a(a parama, bo parambo, Intent paramIntent)
  {
    AppMethodBeat.i(35189);
    if ((parama == null) || (parambo == null))
    {
      AppMethodBeat.o(35189);
      return;
    }
    String str1 = parama.getTalkerUserName();
    String str2 = b(parama, parambo);
    Bundle localBundle = new Bundle();
    int i;
    if (parama.foP()) {
      i = 2;
    }
    for (;;)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambo.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str1);
      localBundle.putString("stat_send_msg_user", str2);
      paramIntent.putExtra("_stat_obj", localBundle);
      AppMethodBeat.o(35189);
      return;
      if (w.wH(str1)) {
        i = 7;
      } else {
        i = 1;
      }
    }
  }
  
  public static boolean aQk(String paramString)
  {
    AppMethodBeat.i(35194);
    int j;
    int i;
    if ((!w.wG(paramString)) && (p.vO(paramString)) && (!u.wh(paramString)))
    {
      az.ayM();
      ai localai = c.awB().aNt(paramString);
      if (localai == null) {
        break label123;
      }
      j = localai.field_type;
      az.ayM();
      localai = c.awB().aNt(localai.field_encryptUsername);
      if (localai == null) {
        break label118;
      }
      i = localai.field_type;
    }
    for (;;)
    {
      ac.i("MicroMsg.ChattingUI.ChattingLogic", "isStranger:%s type:%d etype:%d", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(35194);
      return true;
      AppMethodBeat.o(35194);
      return false;
      label118:
      i = -1;
      continue;
      label123:
      i = -1;
      j = -1;
    }
  }
  
  public static boolean ak(ai paramai)
  {
    AppMethodBeat.i(35192);
    if ((paramai.field_username.equals("medianote")) && ((u.axA() & 0x4000) == 0))
    {
      AppMethodBeat.o(35192);
      return true;
    }
    AppMethodBeat.o(35192);
    return false;
  }
  
  private static String b(a parama, bo parambo)
  {
    AppMethodBeat.i(35190);
    String str = parama.AzG.field_username;
    boolean bool = ((d)parama.bf(d.class)).fmo();
    if ((!parama.foP()) && (!bool))
    {
      AppMethodBeat.o(35190);
      return str;
    }
    if (parama.foP())
    {
      parama = bi.yl(parambo.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label95;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35190);
      return parama;
      if (parambo != null) {
        parama = parambo.field_bizChatUserId;
      } else {
        label95:
        parama = str;
      }
    }
  }
  
  public static boolean e(bo parambo, String paramString)
  {
    AppMethodBeat.i(35191);
    if ((System.currentTimeMillis() - parambo.field_createTime > 259200000L) && ((bs.isNullOrNil(paramString)) || (!i.eA(paramString))))
    {
      AppMethodBeat.o(35191);
      return true;
    }
    AppMethodBeat.o(35191);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j
 * JD-Core Version:    0.7.0.1
 */