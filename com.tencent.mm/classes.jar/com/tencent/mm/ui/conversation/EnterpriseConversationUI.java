package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.j;
import android.support.v4.app.o;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.as;
import com.tencent.mm.platformtools.b.b;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;

public class EnterpriseConversationUI
  extends BaseConversationUI
{
  private View contentView;
  
  public void finish()
  {
    if ((this.conversationFm != null) && ((this.conversationFm instanceof EnterpriseConversationUI.a))) {
      ((EnterpriseConversationUI.a)this.conversationFm).eCu = (System.currentTimeMillis() / 1000L);
    }
    super.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.contentView = com.tencent.mm.ui.y.gt(this).inflate(R.i.bizconversation_activity_container, null);
    setContentView(this.contentView);
    this.conversationFm = new EnterpriseConversationUI.a();
    getSupportFragmentManager().bP().a(R.h.mm_root_view, this.conversationFm).commit();
    e.a(this, this.contentView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI
 * JD-Core Version:    0.7.0.1
 */