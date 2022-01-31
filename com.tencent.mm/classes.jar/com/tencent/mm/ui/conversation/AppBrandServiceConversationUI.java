package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.w;

@Keep
public final class AppBrandServiceConversationUI
  extends BaseConversationUI
{
  private static final String TAG = "MicroMsg.AppBrandServiceConversationUI";
  private View contentView;
  
  public final void finish()
  {
    AppMethodBeat.i(34024);
    super.finish();
    AppMethodBeat.o(34024);
  }
  
  protected final ChattingUIFragment getChattingUIFragment()
  {
    AppMethodBeat.i(34025);
    AppBrandServiceChattingUI.AppBrandServiceChattingFmUI localAppBrandServiceChattingFmUI = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI();
    AppMethodBeat.o(34025);
    return localAppBrandServiceChattingFmUI;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34023);
    super.onCreate(paramBundle);
    this.contentView = w.hM(this).inflate(2130968894, null);
    setContentView(this.contentView);
    this.conversationFm = new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131821947, this.conversationFm).commit();
    f.a(this, this.contentView);
    AppMethodBeat.o(34023);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI
 * JD-Core Version:    0.7.0.1
 */