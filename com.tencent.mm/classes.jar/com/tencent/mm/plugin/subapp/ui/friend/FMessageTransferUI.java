package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bh.d;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.storage.aw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class FMessageTransferUI
  extends MMActivity
{
  private int bxG;
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("friend_message_transfer_username");
    d.RY().abQ(paramBundle);
    d.RY().cuW();
    String str1 = getIntent().getAction();
    String str2 = "friend_message_accept_" + paramBundle;
    this.bxG = (0x7F000000 | 0x7FFFFFFF & paramBundle.hashCode());
    au.getNotification().cancel(this.bxG);
    if (str2.equals(str1)) {
      a.g(this.mController.uMN, paramBundle, true);
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageTransferUI
 * JD-Core Version:    0.7.0.1
 */