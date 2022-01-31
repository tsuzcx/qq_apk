package com.tencent.mm.plugin.wear.model.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends a
{
  public final List<Integer> bYY()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11016));
    localArrayList.add(Integer.valueOf(11017));
    localArrayList.add(Integer.valueOf(11018));
    return localArrayList;
  }
  
  protected final byte[] p(int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "utf8");
      if (bk.bl(paramArrayOfByte))
      {
        y.i("MicroMsg.Wear.HttpFriendServer", "error to get username");
        return null;
      }
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          paramArrayOfByte = "";
        }
        y.i("MicroMsg.Wear.HttpFriendServer", "handle friend request %s", new Object[] { paramArrayOfByte });
        Intent localIntent;
        if (paramInt == 11016)
        {
          localIntent = new Intent();
          localIntent.setClassName(ae.getPackageName(), ae.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
          localIntent.putExtra("friend_message_transfer_username", paramArrayOfByte);
          localIntent.setAction("friend_message_accept_" + paramArrayOfByte);
          localIntent.setFlags(335544320);
          ae.getContext().startActivity(localIntent);
          return null;
        }
        if (paramInt == 11017)
        {
          localIntent = new Intent();
          localIntent.setClassName(ae.getPackageName(), ae.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
          localIntent.putExtra("friend_message_transfer_username", paramArrayOfByte);
          localIntent.setAction("friend_message_ignore_" + paramArrayOfByte);
          localIntent.setFlags(335544320);
          ae.getContext().startActivity(localIntent);
          return null;
        }
      } while (paramInt != 11018);
      paramArrayOfByte = new Intent();
      paramArrayOfByte.setClassName(ae.getPackageName(), ae.getPackageName() + ".plugin.subapp.ui.friend.FMessageConversationUI");
      paramArrayOfByte.setFlags(335544320);
      ae.getContext().startActivity(paramArrayOfByte);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.f
 * JD-Core Version:    0.7.0.1
 */