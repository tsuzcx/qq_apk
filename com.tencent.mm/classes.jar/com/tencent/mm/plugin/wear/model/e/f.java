package com.tencent.mm.plugin.wear.model.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends a
{
  public final List<Integer> cYL()
  {
    AppMethodBeat.i(26397);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11016));
    localArrayList.add(Integer.valueOf(11017));
    localArrayList.add(Integer.valueOf(11018));
    AppMethodBeat.o(26397);
    return localArrayList;
  }
  
  protected final byte[] q(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26398);
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "utf8");
      if (bo.isNullOrNil(paramArrayOfByte))
      {
        ab.i("MicroMsg.Wear.HttpFriendServer", "error to get username");
        AppMethodBeat.o(26398);
        return null;
      }
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = "";
      }
      ab.i("MicroMsg.Wear.HttpFriendServer", "handle friend request %s", new Object[] { paramArrayOfByte });
      if (paramInt != 11016) {
        break label149;
      }
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(ah.getPackageName(), ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
    localIntent.putExtra("friend_message_transfer_username", paramArrayOfByte);
    localIntent.setAction("friend_message_accept_".concat(String.valueOf(paramArrayOfByte)));
    localIntent.setFlags(335544320);
    ah.getContext().startActivity(localIntent);
    for (;;)
    {
      AppMethodBeat.o(26398);
      return null;
      label149:
      if (paramInt == 11017)
      {
        localIntent = new Intent();
        localIntent.setClassName(ah.getPackageName(), ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
        localIntent.putExtra("friend_message_transfer_username", paramArrayOfByte);
        localIntent.setAction("friend_message_ignore_".concat(String.valueOf(paramArrayOfByte)));
        localIntent.setFlags(335544320);
        ah.getContext().startActivity(localIntent);
      }
      else if (paramInt == 11018)
      {
        paramArrayOfByte = new Intent();
        paramArrayOfByte.setClassName(ah.getPackageName(), ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageConversationUI");
        paramArrayOfByte.setFlags(335544320);
        ah.getContext().startActivity(paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.f
 * JD-Core Version:    0.7.0.1
 */