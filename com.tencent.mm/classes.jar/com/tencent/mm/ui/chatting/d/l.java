package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.c;
import com.tencent.mm.model.p;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.vfs.i;

public final class l
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
  
  public static void a(a parama, bu parambu, Intent paramIntent)
  {
    AppMethodBeat.i(35189);
    if ((parama == null) || (parambu == null))
    {
      AppMethodBeat.o(35189);
      return;
    }
    String str1 = parama.getTalkerUserName();
    String str2 = b(parama, parambu);
    Bundle localBundle = new Bundle();
    int i;
    if (parama.fFu()) {
      i = 2;
    }
    for (;;)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambu.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str1);
      localBundle.putString("stat_send_msg_user", str2);
      paramIntent.putExtra("_stat_obj", localBundle);
      AppMethodBeat.o(35189);
      return;
      if (w.zE(str1)) {
        i = 7;
      } else {
        i = 1;
      }
    }
  }
  
  public static boolean aWd(String paramString)
  {
    AppMethodBeat.i(35194);
    int j;
    int i;
    if ((!w.zD(paramString)) && (p.yF(paramString)) && (!u.za(paramString)))
    {
      ba.aBQ();
      am localam = c.azp().Bf(paramString);
      if (localam == null) {
        break label123;
      }
      j = localam.field_type;
      ba.aBQ();
      localam = c.azp().Bf(localam.field_encryptUsername);
      if (localam == null) {
        break label118;
      }
      i = localam.field_type;
    }
    for (;;)
    {
      ad.i("MicroMsg.ChattingUI.ChattingLogic", "isStranger:%s type:%d etype:%d", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(i) });
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
  
  public static boolean ak(am paramam)
  {
    AppMethodBeat.i(35192);
    if ((paramam.field_username.equals("medianote")) && ((u.aAq() & 0x4000) == 0))
    {
      AppMethodBeat.o(35192);
      return true;
    }
    AppMethodBeat.o(35192);
    return false;
  }
  
  private static String b(a parama, bu parambu)
  {
    AppMethodBeat.i(35190);
    String str = parama.BYG.field_username;
    boolean bool = ((d)parama.bh(d.class)).fCH();
    if ((!parama.fFu()) && (!bool))
    {
      AppMethodBeat.o(35190);
      return str;
    }
    if (parama.fFu())
    {
      parama = bj.Bk(parambu.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label95;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35190);
      return parama;
      if (parambu != null) {
        parama = parambu.field_bizChatUserId;
      } else {
        label95:
        parama = str;
      }
    }
  }
  
  public static boolean e(bu parambu, String paramString)
  {
    AppMethodBeat.i(35191);
    if ((System.currentTimeMillis() - parambu.field_createTime > 259200000L) && ((bt.isNullOrNil(paramString)) || (!i.fv(paramString))))
    {
      AppMethodBeat.o(35191);
      return true;
    }
    AppMethodBeat.o(35191);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.l
 * JD-Core Version:    0.7.0.1
 */