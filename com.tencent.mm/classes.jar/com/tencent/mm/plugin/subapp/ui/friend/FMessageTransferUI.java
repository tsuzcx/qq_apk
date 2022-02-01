package com.tencent.mm.plugin.subapp.ui.friend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.d;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;

@i
public class FMessageTransferUI
  extends MMActivity
{
  private int cVT;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29053);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("friend_message_transfer_username");
    if (bt.isNullOrNil(paramBundle)) {
      finish();
    }
    d.aMo().aTT(paramBundle);
    d.aMo().frl();
    String str1 = getIntent().getAction();
    String str2 = "friend_message_accept_".concat(String.valueOf(paramBundle));
    this.cVT = (0x7F000000 | 0x7FFFFFFF & paramBundle.hashCode());
    ba.getNotification().cancel(this.cVT);
    if (str2.equals(str1)) {
      a.h(getContext(), paramBundle, true);
    }
    finish();
    AppMethodBeat.o(29053);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageTransferUI
 * JD-Core Version:    0.7.0.1
 */