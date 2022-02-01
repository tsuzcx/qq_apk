package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.vfs.s;

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
  
  private static String a(a parama, ca paramca)
  {
    AppMethodBeat.i(35190);
    String str = parama.GUe.field_username;
    boolean bool = ((d)parama.bh(d.class)).gOP();
    if ((!parama.gRL()) && (!bool))
    {
      AppMethodBeat.o(35190);
      return str;
    }
    if (parama.gRL())
    {
      parama = bp.Ks(paramca.field_content);
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
    if (parama.gRL()) {
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
      if (ab.IT(str1)) {
        i = 7;
      } else {
        i = 1;
      }
    }
  }
  
  public static boolean at(as paramas)
  {
    AppMethodBeat.i(35192);
    if ((paramas.field_username.equals("medianote")) && ((z.aUc() & 0x4000) == 0))
    {
      AppMethodBeat.o(35192);
      return true;
    }
    AppMethodBeat.o(35192);
    return false;
  }
  
  public static boolean bmI(String paramString)
  {
    AppMethodBeat.i(35194);
    int j;
    int i;
    if ((!ab.IS(paramString)) && (u.HR(paramString)) && (!z.Im(paramString)))
    {
      bg.aVF();
      as localas = c.aSN().Kn(paramString);
      if (localas == null) {
        break label123;
      }
      j = localas.field_type;
      bg.aVF();
      localas = c.aSN().Kn(localas.field_encryptUsername);
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
  
  public static boolean h(ca paramca, String paramString)
  {
    AppMethodBeat.i(35191);
    if ((System.currentTimeMillis() - paramca.field_createTime > 259200000L) && ((Util.isNullOrNil(paramString)) || (!s.YS(paramString))))
    {
      AppMethodBeat.o(35191);
      return true;
    }
    AppMethodBeat.o(35191);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.l
 * JD-Core Version:    0.7.0.1
 */