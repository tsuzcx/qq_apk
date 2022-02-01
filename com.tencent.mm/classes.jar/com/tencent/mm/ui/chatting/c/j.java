package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.model.p;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
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
  
  public static void a(a parama, bl parambl, Intent paramIntent)
  {
    AppMethodBeat.i(35189);
    if ((parama == null) || (parambl == null))
    {
      AppMethodBeat.o(35189);
      return;
    }
    String str1 = parama.getTalkerUserName();
    String str2 = b(parama, parambl);
    Bundle localBundle = new Bundle();
    int i;
    if (parama.eZa()) {
      i = 2;
    }
    for (;;)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambl.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str1);
      localBundle.putString("stat_send_msg_user", str2);
      paramIntent.putExtra("_stat_obj", localBundle);
      AppMethodBeat.o(35189);
      return;
      if (w.sE(str1)) {
        i = 7;
      } else {
        i = 1;
      }
    }
  }
  
  public static boolean aKH(String paramString)
  {
    AppMethodBeat.i(35194);
    int j;
    int i;
    if ((!w.sD(paramString)) && (p.rL(paramString)) && (!u.se(paramString)))
    {
      az.arV();
      af localaf = c.apM().aHY(paramString);
      if (localaf == null) {
        break label123;
      }
      j = localaf.field_type;
      az.arV();
      localaf = c.apM().aHY(localaf.field_encryptUsername);
      if (localaf == null) {
        break label118;
      }
      i = localaf.field_type;
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
  
  public static boolean aj(af paramaf)
  {
    AppMethodBeat.i(35192);
    if ((paramaf.field_username.equals("medianote")) && ((u.aqK() & 0x4000) == 0))
    {
      AppMethodBeat.o(35192);
      return true;
    }
    AppMethodBeat.o(35192);
    return false;
  }
  
  private static String b(a parama, bl parambl)
  {
    AppMethodBeat.i(35190);
    String str = parama.zgX.field_username;
    boolean bool = ((d)parama.be(d.class)).eWC();
    if ((!parama.eZa()) && (!bool))
    {
      AppMethodBeat.o(35190);
      return str;
    }
    if (parama.eZa())
    {
      parama = bi.uf(parambl.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label95;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35190);
      return parama;
      if (parambl != null) {
        parama = parambl.field_bizChatUserId;
      } else {
        label95:
        parama = str;
      }
    }
  }
  
  public static boolean e(bl parambl, String paramString)
  {
    AppMethodBeat.i(35191);
    if ((System.currentTimeMillis() - parambl.field_createTime > 259200000L) && ((bt.isNullOrNil(paramString)) || (!i.eK(paramString))))
    {
      AppMethodBeat.o(35191);
      return true;
    }
    AppMethodBeat.o(35191);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j
 * JD-Core Version:    0.7.0.1
 */