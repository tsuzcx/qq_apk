package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.j;
import android.support.v4.app.o;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.d;
import com.tencent.mm.ai.a.h;
import com.tencent.mm.ai.a.n;
import com.tencent.mm.ai.z;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;

public class BizChatConversationUI
  extends BaseConversationUI
{
  private View contentView;
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    e.a(this, this.contentView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.contentView = com.tencent.mm.ui.y.gt(this).inflate(R.i.bizconversation_activity_container, null);
    setContentView(this.contentView);
    this.conversationFm = new BizChatConversationUI.a();
    getSupportFragmentManager().bP().a(R.h.mm_root_view, this.conversationFm).commit();
    e.a(this, this.contentView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI
 * JD-Core Version:    0.7.0.1
 */