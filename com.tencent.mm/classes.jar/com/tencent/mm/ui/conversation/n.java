package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.bf.a;
import com.tencent.mm.sdk.b.c;

public final class n
  implements a
{
  Activity bMV;
  c iWp = null;
  MessageQueue.IdleHandler uKq;
  Runnable vJr = new n.10(this);
  h vPG;
  c vTT = null;
  c vTU = null;
  ConversationWithAppBrandListView vTt;
  
  public final void i(String paramString1, String paramString2, String paramString3)
  {
    if (this.vPG != null) {
      this.vPG.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n
 * JD-Core Version:    0.7.0.1
 */