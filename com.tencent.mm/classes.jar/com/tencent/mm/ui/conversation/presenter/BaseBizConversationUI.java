package com.tencent.mm.ui.conversation.presenter;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.conversation.BaseConversationUI;

public abstract class BaseBizConversationUI
  extends BaseConversationUI
{
  MMActivity.a onActResult = null;
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.onActResult != null)
    {
      this.onActResult.c(paramInt1, paramInt2, paramIntent);
      this.onActResult = null;
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.BaseBizConversationUI
 * JD-Core Version:    0.7.0.1
 */