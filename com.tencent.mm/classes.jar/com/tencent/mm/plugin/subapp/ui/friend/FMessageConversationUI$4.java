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
    AppMethodBeat.i(232016);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(232016);
      return false;
      FMessageConversationUI.a(this.MeO, (int)paramMotionEvent.getRawX());
      FMessageConversationUI.b(this.MeO, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.4
 * JD-Core Version:    0.7.0.1
 */