package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.qqmail.b.o;

final class MailAddrsViewControl$8
  extends GestureDetector.SimpleOnGestureListener
{
  MailAddrsViewControl$8(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  private void bul()
  {
    o localo = (o)MailAddrsViewControl.c(this.nir).getTag();
    if (MailAddrsViewControl.g(this.nir) != null)
    {
      MailAddrsViewControl.g(this.nir);
      MailAddrsViewControl.c(this.nir);
    }
    Intent localIntent = new Intent(this.nir.getContext(), MailAddrProfileUI.class);
    localIntent.putExtra("name", localo.name);
    localIntent.putExtra("addr", localo.lCF);
    if (!MailAddrsViewControl.h(this.nir)) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("can_compose", bool);
      this.nir.getContext().startActivity(localIntent);
      return;
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    bul();
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((MailAddrsViewControl.g(this.nir) != null) && (MailAddrsViewControl.c(this.nir) != null))
    {
      MailAddrsViewControl.g(this.nir);
      MailAddrsViewControl.c(this.nir);
      MailAddrsViewControl.c(this.nir).getTag();
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (!MailAddrsViewControl.h(this.nir)) {
      bul();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.8
 * JD-Core Version:    0.7.0.1
 */