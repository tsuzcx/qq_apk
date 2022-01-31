package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.app.j;
import android.support.v4.app.o;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;

@Keep
public final class AppBrandServiceConversationUI
  extends BaseConversationUI
{
  private static final String TAG = "MicroMsg.AppBrandServiceConversationUI";
  private View contentView;
  
  public final void finish()
  {
    super.finish();
  }
  
  protected final com.tencent.mm.ui.chatting.y getChattingUIFragment()
  {
    return new AppBrandServiceChattingUI.a();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.contentView = com.tencent.mm.ui.y.gt(this).inflate(R.i.bizconversation_activity_container, null);
    setContentView(this.contentView);
    this.conversationFm = new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI();
    getSupportFragmentManager().bP().a(R.h.mm_root_view, this.conversationFm).commit();
    e.a(this, this.contentView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI
 * JD-Core Version:    0.7.0.1
 */