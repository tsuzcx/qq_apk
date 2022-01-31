package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.o;

final class MailAddrsViewControl$8
  extends GestureDetector.SimpleOnGestureListener
{
  MailAddrsViewControl$8(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  private void cex()
  {
    AppMethodBeat.i(68345);
    o localo = (o)MailAddrsViewControl.c(this.pNE).getTag();
    if (MailAddrsViewControl.g(this.pNE) != null)
    {
      MailAddrsViewControl.g(this.pNE);
      MailAddrsViewControl.c(this.pNE);
    }
    Intent localIntent = new Intent(this.pNE.getContext(), MailAddrProfileUI.class);
    localIntent.putExtra("name", localo.name);
    localIntent.putExtra("addr", localo.nZR);
    if (!MailAddrsViewControl.h(this.pNE)) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("can_compose", bool);
      this.pNE.getContext().startActivity(localIntent);
      AppMethodBeat.o(68345);
      return;
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(68348);
    cex();
    AppMethodBeat.o(68348);
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(68347);
    if ((MailAddrsViewControl.g(this.pNE) != null) && (MailAddrsViewControl.c(this.pNE) != null))
    {
      MailAddrsViewControl.g(this.pNE);
      MailAddrsViewControl.c(this.pNE);
      MailAddrsViewControl.c(this.pNE).getTag();
    }
    AppMethodBeat.o(68347);
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(68346);
    if (!MailAddrsViewControl.h(this.pNE)) {
      cex();
    }
    AppMethodBeat.o(68346);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.8
 * JD-Core Version:    0.7.0.1
 */