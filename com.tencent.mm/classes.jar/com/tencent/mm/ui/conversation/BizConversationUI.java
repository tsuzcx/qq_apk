package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.w;

public class BizConversationUI
  extends BaseConversationUI
{
  private View contentView;
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(34153);
    super.onConfigurationChanged(paramConfiguration);
    f.a(this, this.contentView);
    AppMethodBeat.o(34153);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34152);
    super.onCreate(paramBundle);
    if (!aw.RG())
    {
      ab.e("MicroMsg.BizConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(34152);
      return;
    }
    this.contentView = w.hM(this).inflate(2130968894, null);
    setContentView(this.contentView);
    this.conversationFm = new BizConversationUI.BizConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131821947, this.conversationFm).commit();
    f.a(this, this.contentView);
    AppMethodBeat.o(34152);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI
 * JD-Core Version:    0.7.0.1
 */