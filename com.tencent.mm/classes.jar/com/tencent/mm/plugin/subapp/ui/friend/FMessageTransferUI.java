package com.tencent.mm.plugin.subapp.ui.friend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.model.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class FMessageTransferUI
  extends MMActivity
{
  private int bZI;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25374);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("friend_message_transfer_username");
    if (bo.isNullOrNil(paramBundle)) {
      finish();
    }
    d.ali().asa(paramBundle);
    d.ali().dxz();
    String str1 = getIntent().getAction();
    String str2 = "friend_message_accept_".concat(String.valueOf(paramBundle));
    this.bZI = (0x7F000000 | 0x7FFFFFFF & paramBundle.hashCode());
    com.tencent.mm.model.aw.getNotification().cancel(this.bZI);
    if (str2.equals(str1)) {
      a.g(getContext(), paramBundle, true);
    }
    finish();
    AppMethodBeat.o(25374);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageTransferUI
 * JD-Core Version:    0.7.0.1
 */