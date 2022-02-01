package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/BizConversationUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "()V", "getLayoutId", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizConversationUI
  extends MMSecDataActivity
{
  public final int getLayoutId()
  {
    return R.i.gid;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI
 * JD-Core Version:    0.7.0.1
 */