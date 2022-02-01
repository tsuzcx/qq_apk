package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelverify.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;

@k
public class FMessageTransferUI
  extends MMActivity
{
  private int hjO;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29053);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("friend_message_transfer_username");
    if (Util.isNullOrNil(paramBundle)) {
      finish();
    }
    d.bNI().byk(paramBundle);
    d.bNI().jbf();
    String str1 = getIntent().getAction();
    String str2 = "friend_message_accept_".concat(String.valueOf(paramBundle));
    this.hjO = (0x7F000000 | 0x7FFFFFFF & paramBundle.hashCode());
    bh.getNotification().cancel(this.hjO);
    if (str2.equals(str1)) {
      a.i(getContext(), paramBundle, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageTransferUI
 * JD-Core Version:    0.7.0.1
 */