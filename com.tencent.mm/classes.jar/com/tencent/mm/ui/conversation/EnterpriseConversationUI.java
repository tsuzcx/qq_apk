package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.k;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a;
import com.tencent.mm.aj.b;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.w;
import java.util.LinkedList;

public class EnterpriseConversationUI
  extends BaseConversationUI
{
  private View contentView;
  
  public void finish()
  {
    AppMethodBeat.i(34458);
    if ((this.conversationFm != null) && ((this.conversationFm instanceof EnterpriseConversationUI.EnterpriseConversationFmUI))) {
      ((EnterpriseConversationUI.EnterpriseConversationFmUI)this.conversationFm).fSl = (System.currentTimeMillis() / 1000L);
    }
    super.finish();
    AppMethodBeat.o(34458);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34457);
    super.onCreate(paramBundle);
    this.contentView = w.hM(this).inflate(2130968894, null);
    setContentView(this.contentView);
    this.conversationFm = new EnterpriseConversationUI.EnterpriseConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131821947, this.conversationFm).commit();
    com.tencent.mm.pluginsdk.f.a(this, this.contentView);
    AppMethodBeat.o(34457);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI
 * JD-Core Version:    0.7.0.1
 */