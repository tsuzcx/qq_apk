package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.vfs.o;

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
  
  public static void a(a parama, bv parambv, Intent paramIntent)
  {
    AppMethodBeat.i(35189);
    if ((parama == null) || (parambv == null))
    {
      AppMethodBeat.o(35189);
      return;
    }
    String str1 = parama.getTalkerUserName();
    String str2 = b(parama, parambv);
    Bundle localBundle = new Bundle();
    int i;
    if (parama.fJB()) {
      i = 2;
    }
    for (;;)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambv.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str1);
      localBundle.putString("stat_send_msg_user", str2);
      paramIntent.putExtra("_stat_obj", localBundle);
      AppMethodBeat.o(35189);
      return;
      if (x.Ao(str1)) {
        i = 7;
      } else {
        i = 1;
      }
    }
  }
  
  public static boolean aXE(String paramString)
  {
    AppMethodBeat.i(35194);
    int j;
    int i;
    if ((!x.An(paramString)) && (q.zp(paramString)) && (!v.zK(paramString)))
    {
      bc.aCg();
      an localan = c.azF().BH(paramString);
      if (localan == null) {
        break label123;
      }
      j = localan.field_type;
      bc.aCg();
      localan = c.azF().BH(localan.field_encryptUsername);
      if (localan == null) {
        break label118;
      }
      i = localan.field_type;
    }
    for (;;)
    {
      ae.i("MicroMsg.ChattingUI.ChattingLogic", "isStranger:%s type:%d etype:%d", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(i) });
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
  
  public static boolean ar(an paraman)
  {
    AppMethodBeat.i(35192);
    if ((paraman.field_username.equals("medianote")) && ((v.aAG() & 0x4000) == 0))
    {
      AppMethodBeat.o(35192);
      return true;
    }
    AppMethodBeat.o(35192);
    return false;
  }
  
  private static String b(a parama, bv parambv)
  {
    AppMethodBeat.i(35190);
    String str = parama.Cqh.field_username;
    boolean bool = ((d)parama.bh(d.class)).fGJ();
    if ((!parama.fJB()) && (!bool))
    {
      AppMethodBeat.o(35190);
      return str;
    }
    if (parama.fJB())
    {
      parama = bl.BM(parambv.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label95;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35190);
      return parama;
      if (parambv != null) {
        parama = parambv.field_bizChatUserId;
      } else {
        label95:
        parama = str;
      }
    }
  }
  
  public static boolean f(bv parambv, String paramString)
  {
    AppMethodBeat.i(35191);
    if ((System.currentTimeMillis() - parambv.field_createTime > 259200000L) && ((bu.isNullOrNil(paramString)) || (!o.fB(paramString))))
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