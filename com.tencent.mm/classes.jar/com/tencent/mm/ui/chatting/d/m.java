package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.e.a;

public final class m
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
  
  private static String a(a parama, ca paramca)
  {
    AppMethodBeat.i(35190);
    String str = parama.NKq.field_username;
    boolean bool = ((d)parama.bC(d.class)).hOe();
    if ((!parama.hRh()) && (!bool))
    {
      AppMethodBeat.o(35190);
      return str;
    }
    if (parama.hRh())
    {
      parama = bq.RL(paramca.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label95;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35190);
      return parama;
      if (paramca != null) {
        parama = paramca.field_bizChatUserId;
      } else {
        label95:
        parama = str;
      }
    }
  }
  
  public static void a(a parama, ca paramca, Intent paramIntent)
  {
    AppMethodBeat.i(35189);
    if ((parama == null) || (paramca == null))
    {
      AppMethodBeat.o(35189);
      return;
    }
    String str1 = parama.getTalkerUserName();
    String str2 = a(parama, paramca);
    Bundle localBundle = new Bundle();
    int i;
    if (parama.hRh()) {
      i = 2;
    }
    for (;;)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramca.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str1);
      localBundle.putString("stat_send_msg_user", str2);
      paramIntent.putExtra("_stat_obj", localBundle);
      AppMethodBeat.o(35189);
      return;
      if (ab.Qm(str1)) {
        i = 7;
      } else {
        i = 1;
      }
    }
  }
  
  public static boolean az(as paramas)
  {
    AppMethodBeat.i(35192);
    if ((paramas.field_username.equals("medianote")) && ((z.bdd() & 0x4000) == 0))
    {
      AppMethodBeat.o(35192);
      return true;
    }
    AppMethodBeat.o(35192);
    return false;
  }
  
  public static boolean bvT(String paramString)
  {
    AppMethodBeat.i(35194);
    int j;
    int i;
    if ((!ab.Ql(paramString)) && (com.tencent.mm.model.u.Ph(paramString)) && (!z.PD(paramString)))
    {
      bh.beI();
      as localas = c.bbL().RG(paramString);
      if (localas == null) {
        break label123;
      }
      j = localas.field_type;
      bh.beI();
      localas = c.bbL().RG(localas.field_encryptUsername);
      if (localas == null) {
        break label118;
      }
      i = localas.field_type;
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
  
  public static boolean j(ca paramca, String paramString)
  {
    AppMethodBeat.i(35191);
    if ((System.currentTimeMillis() - paramca.field_createTime > 259200000L) && ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.u.agG(paramString))))
    {
      AppMethodBeat.o(35191);
      return true;
    }
    AppMethodBeat.o(35191);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.m
 * JD-Core Version:    0.7.0.1
 */