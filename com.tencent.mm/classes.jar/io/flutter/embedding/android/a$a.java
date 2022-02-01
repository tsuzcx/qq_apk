package io.flutter.embedding.android;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.c.a;
import io.flutter.plugin.editing.d;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

final class a$a
  implements c.a
{
  private final d aaoo;
  final Deque<KeyEvent> aaor;
  private final View view;
  
  public a$a(View paramView, d paramd)
  {
    AppMethodBeat.i(255767);
    this.aaor = new ArrayDeque();
    this.view = paramView;
    this.aaoo = paramd;
    AppMethodBeat.o(255767);
  }
  
  final void l(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(255769);
    this.aaor.remove(paramKeyEvent);
    AppMethodBeat.o(255769);
  }
  
  final KeyEvent m(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(255771);
    Iterator localIterator = this.aaor.iterator();
    while (localIterator.hasNext())
    {
      KeyEvent localKeyEvent = (KeyEvent)localIterator.next();
      if (localKeyEvent == paramKeyEvent)
      {
        AppMethodBeat.o(255771);
        return localKeyEvent;
      }
    }
    AppMethodBeat.o(255771);
    return null;
  }
  
  public final void n(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(255772);
    l(paramKeyEvent);
    AppMethodBeat.o(255772);
  }
  
  public final void o(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(255775);
    paramKeyEvent = m(paramKeyEvent);
    if ((this.aaoo.aavc.isAcceptingText()) && (this.aaoo.aavv != null) && (this.aaoo.aavv.sendKeyEvent(paramKeyEvent)))
    {
      l(paramKeyEvent);
      AppMethodBeat.o(255775);
      return;
    }
    if (this.view != null) {
      this.view.getRootView().dispatchKeyEvent(paramKeyEvent);
    }
    AppMethodBeat.o(255775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.a.a
 * JD-Core Version:    0.7.0.1
 */