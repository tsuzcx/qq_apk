package com.tencent.mm.plugin.wear.model.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends a
{
  public final List<Integer> gON()
  {
    AppMethodBeat.i(30079);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11016));
    localArrayList.add(Integer.valueOf(11017));
    localArrayList.add(Integer.valueOf(11018));
    AppMethodBeat.o(30079);
    return localArrayList;
  }
  
  protected final byte[] t(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30080);
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "utf8");
      if (Util.isNullOrNil(paramArrayOfByte))
      {
        Log.i("MicroMsg.Wear.HttpFriendServer", "error to get username");
        AppMethodBeat.o(30080);
        return null;
      }
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = "";
      }
      Log.i("MicroMsg.Wear.HttpFriendServer", "handle friend request %s", new Object[] { paramArrayOfByte });
      if (paramInt != 11016) {
        break label206;
      }
    }
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
    ((Intent)localObject).putExtra("friend_message_transfer_username", paramArrayOfByte);
    ((Intent)localObject).setAction("friend_message_accept_".concat(String.valueOf(paramArrayOfByte)));
    ((Intent)localObject).setFlags(335544320);
    paramArrayOfByte = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfByte, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/wear/model/server/HttpFriendServer", "handleData", "(I[B)[B", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramArrayOfByte.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfByte, "com/tencent/mm/plugin/wear/model/server/HttpFriendServer", "handleData", "(I[B)[B", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    for (;;)
    {
      AppMethodBeat.o(30080);
      return null;
      label206:
      if (paramInt == 11017)
      {
        localObject = new Intent();
        ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
        ((Intent)localObject).putExtra("friend_message_transfer_username", paramArrayOfByte);
        ((Intent)localObject).setAction("friend_message_ignore_".concat(String.valueOf(paramArrayOfByte)));
        ((Intent)localObject).setFlags(335544320);
        paramArrayOfByte = MMApplicationContext.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfByte, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/wear/model/server/HttpFriendServer", "handleData", "(I[B)[B", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramArrayOfByte.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfByte, "com/tencent/mm/plugin/wear/model/server/HttpFriendServer", "handleData", "(I[B)[B", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramInt == 11018)
      {
        localObject = new Intent();
        ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.subapp.ui.friend.FMessageConversationUI");
        ((Intent)localObject).setFlags(335544320);
        paramArrayOfByte = MMApplicationContext.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfByte, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/wear/model/server/HttpFriendServer", "handleData", "(I[B)[B", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramArrayOfByte.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfByte, "com/tencent/mm/plugin/wear/model/server/HttpFriendServer", "handleData", "(I[B)[B", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.f
 * JD-Core Version:    0.7.0.1
 */