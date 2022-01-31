package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.vfs.e;

public final class i
{
  public static ViewStub a(MMFragment paramMMFragment, int paramInt)
  {
    AppMethodBeat.i(31303);
    paramMMFragment = (ViewStub)paramMMFragment.findViewById(paramInt);
    if (paramMMFragment != null) {
      paramMMFragment.inflate();
    }
    AppMethodBeat.o(31303);
    return paramMMFragment;
  }
  
  public static void a(a parama, bi parambi, Intent paramIntent)
  {
    AppMethodBeat.i(31299);
    if ((parama == null) || (parambi == null))
    {
      AppMethodBeat.o(31299);
      return;
    }
    String str1 = parama.getTalkerUserName();
    String str2 = b(parama, parambi);
    Bundle localBundle = new Bundle();
    int i;
    if (parama.dJF()) {
      i = 2;
    }
    for (;;)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambi.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str1);
      localBundle.putString("stat_send_msg_user", str2);
      paramIntent.putExtra("_stat_obj", localBundle);
      AppMethodBeat.o(31299);
      return;
      if (t.nU(str1)) {
        i = 7;
      } else {
        i = 1;
      }
    }
  }
  
  public static boolean ac(ad paramad)
  {
    AppMethodBeat.i(31302);
    if ((paramad.field_username.equals("medianote")) && ((r.Zr() & 0x4000) == 0))
    {
      AppMethodBeat.o(31302);
      return true;
    }
    AppMethodBeat.o(31302);
    return false;
  }
  
  public static boolean atT(String paramString)
  {
    AppMethodBeat.i(31305);
    int j;
    int i;
    if ((!t.nT(paramString)) && (m.ni(paramString)) && (!r.nB(paramString)))
    {
      aw.aaz();
      ad localad = c.YA().arw(paramString);
      if (localad == null) {
        break label126;
      }
      j = localad.field_type;
      aw.aaz();
      localad = c.YA().arw(localad.field_encryptUsername);
      if (localad == null) {
        break label121;
      }
      i = localad.field_type;
    }
    for (;;)
    {
      ab.i("MicroMsg.ChattingUI.ChattingLogic", "isStranger:%s type:%d etype:%d", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(31305);
      return true;
      AppMethodBeat.o(31305);
      return false;
      label121:
      i = -1;
      continue;
      label126:
      i = -1;
      j = -1;
    }
  }
  
  private static String b(a parama, bi parambi)
  {
    AppMethodBeat.i(31300);
    String str = parama.txj.field_username;
    boolean bool = ((d)parama.ay(d.class)).dHv();
    if ((!parama.dJF()) && (!bool))
    {
      AppMethodBeat.o(31300);
      return str;
    }
    if (parama.dJF())
    {
      parama = bf.pu(parambi.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label98;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(31300);
      return parama;
      if (parambi != null) {
        parama = parambi.field_bizChatUserId;
      } else {
        label98:
        parama = str;
      }
    }
  }
  
  public static boolean e(bi parambi, String paramString)
  {
    AppMethodBeat.i(31301);
    if ((System.currentTimeMillis() - parambi.field_createTime > 259200000L) && ((bo.isNullOrNil(paramString)) || (!e.cN(paramString))))
    {
      AppMethodBeat.o(31301);
      return true;
    }
    AppMethodBeat.o(31301);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.i
 * JD-Core Version:    0.7.0.1
 */