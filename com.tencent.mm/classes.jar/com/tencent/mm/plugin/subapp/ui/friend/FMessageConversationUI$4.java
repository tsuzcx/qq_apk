package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FMessageConversationUI$4
  implements View.OnTouchListener
{
  FMessageConversationUI$4(FMessageConversationUI paramFMessageConversationUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(232072);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(232072);
      return false;
      FMessageConversationUI.a(this.FKR, (int)paramMotionEvent.getRawX());
      FMessageConversationUI.b(this.FKR, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.4
 * JD-Core Version:    0.7.0.1
 */