package com.tencent.mm.plugin.sns.ui.unread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/unread/SnsUnreadTimeLineUI;", "Lcom/tencent/mm/plugin/sns/ui/SnsWsFoldDetailUI;", "()V", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsUnreadTimeLineUI
  extends SnsWsFoldDetailUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.unread.SnsUnreadTimeLineUI
 * JD-Core Version:    0.7.0.1
 */