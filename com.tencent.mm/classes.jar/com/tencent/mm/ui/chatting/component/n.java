package com.tencent.mm.ui.chatting.component;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.vfs.y;

public final class n
{
  private static String a(a parama, cc paramcc)
  {
    AppMethodBeat.i(35190);
    String str = parama.Uxa.field_username;
    boolean bool = ((e)parama.cm(e.class)).jqV();
    if ((!parama.juF()) && (!bool))
    {
      AppMethodBeat.o(35190);
      return str;
    }
    if (parama.juF())
    {
      parama = br.JJ(paramcc.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label95;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35190);
      return parama;
      if (paramcc != null) {
        parama = paramcc.field_bizChatUserId;
      } else {
        label95:
        parama = str;
      }
    }
  }
  
  public static void a(a parama, cc paramcc, Intent paramIntent)
  {
    AppMethodBeat.i(35189);
    if ((parama == null) || (paramcc == null))
    {
      AppMethodBeat.o(35189);
      return;
    }
    String str1 = parama.getTalkerUserName();
    String str2 = a(parama, paramcc);
    Bundle localBundle = new Bundle();
    int i;
    if (parama.juF()) {
      i = 2;
    }
    for (;;)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramcc.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str1);
      localBundle.putString("stat_send_msg_user", str2);
      paramIntent.putExtra("_stat_obj", localBundle);
      AppMethodBeat.o(35189);
      return;
      if (ab.IS(str1)) {
        i = 7;
      } else {
        i = 1;
      }
    }
  }
  
  public static boolean aF(au paramau)
  {
    AppMethodBeat.i(35192);
    if ((paramau.field_username.equals("medianote")) && ((z.bAQ() & 0x4000) == 0))
    {
      AppMethodBeat.o(35192);
      return true;
    }
    AppMethodBeat.o(35192);
    return false;
  }
  
  public static boolean bxa(String paramString)
  {
    AppMethodBeat.i(35194);
    int j;
    int i;
    if ((!ab.IR(paramString)) && (u.Ia(paramString)) && (!z.Iy(paramString)))
    {
      bh.bCz();
      au localau = c.bzA().JE(paramString);
      if (localau == null) {
        break label123;
      }
      j = localau.field_type;
      bh.bCz();
      localau = c.bzA().JE(localau.field_encryptUsername);
      if (localau == null) {
        break label118;
      }
      i = localau.field_type;
    }
    for (;;)
    {
      Log.i("MicroMsg.ChattingUI.ChattingLogic", "isStranger:%s type:%d etype:%d", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(i) });
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
  
  public static ViewStub c(MMFragment paramMMFragment, int paramInt)
  {
    AppMethodBeat.i(35193);
    paramMMFragment = (ViewStub)paramMMFragment.findViewById(paramInt);
    if (paramMMFragment != null) {
      paramMMFragment.inflate();
    }
    AppMethodBeat.o(35193);
    return paramMMFragment;
  }
  
  public static boolean j(cc paramcc, String paramString)
  {
    AppMethodBeat.i(35191);
    if ((System.currentTimeMillis() - paramcc.getCreateTime() > 259200000L) && ((Util.isNullOrNil(paramString)) || (!y.ZC(paramString))))
    {
      AppMethodBeat.o(35191);
      return true;
    }
    AppMethodBeat.o(35191);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.n
 * JD-Core Version:    0.7.0.1
 */