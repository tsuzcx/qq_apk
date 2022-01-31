package com.tencent.mm.ui.conversation;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class n$1
  extends ah
{
  n$1(n paramn) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.vTV.vPG != null)
    {
      this.vTV.vPG.clearCache();
      this.vTV.vPG.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n.1
 * JD-Core Version:    0.7.0.1
 */