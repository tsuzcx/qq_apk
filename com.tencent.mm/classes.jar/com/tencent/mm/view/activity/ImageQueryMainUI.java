package com.tencent.mm.view.activity;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMComposeActivity;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/activity/ImageQueryMainUI;", "Lcom/tencent/mm/ui/MMComposeActivity;", "()V", "getLayoutId", "", "compose-image-query_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImageQueryMainUI
  extends MMComposeActivity
{
  public final int getLayoutId()
  {
    return 1;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.activity.ImageQueryMainUI
 * JD-Core Version:    0.7.0.1
 */