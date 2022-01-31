package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;

public class ad
  extends a
  implements v
{
  public final void cyM()
  {
    Intent localIntent = this.byx.vtz.getContext().getIntent();
    if (localIntent.getIntExtra("SendAppMessageWrapper_Scene", 0) != 3) {
      return;
    }
    localIntent.setClass(this.byx.vtz.getContext(), SendAppMessageWrapperUI.class);
    localIntent.putExtra("Select_Conv_User", this.byx.getTalkerUserName());
    this.byx.a(localIntent, 228, new ad.1(this, localIntent));
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ad
 * JD-Core Version:    0.7.0.1
 */