package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.c;
import io.flutter.embedding.engine.b.c.b;
import io.flutter.plugin.editing.d;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private final c aaon;
  private final d aaoo;
  private int aaop;
  private a.a aaoq;
  
  public a(View paramView, c paramc, d paramd)
  {
    AppMethodBeat.i(255576);
    this.aaon = paramc;
    this.aaoo = paramd;
    paramd.aauW = this;
    this.aaoq = new a.a(paramView, paramd);
    this.aaon.aass = this.aaoq;
    AppMethodBeat.o(255576);
  }
  
  public final void destroy()
  {
    this.aaon.aass = null;
  }
  
  public final boolean j(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(255580);
    int j = paramKeyEvent.getAction();
    if ((j != 0) && (j != 1))
    {
      AppMethodBeat.o(255580);
      return false;
    }
    if (k(paramKeyEvent))
    {
      this.aaoq.l(paramKeyEvent);
      AppMethodBeat.o(255580);
      return false;
    }
    int k = paramKeyEvent.getUnicodeChar();
    Object localObject1;
    Object localObject2;
    if (k == 0)
    {
      localObject1 = null;
      localObject1 = new c.b(paramKeyEvent, (Character)localObject1);
      localObject2 = this.aaoq;
      ((a.a)localObject2).aaor.addLast(paramKeyEvent);
      if (((a.a)localObject2).aaor.size() > 1000L)
      {
        new StringBuilder("There are ").append(((a.a)localObject2).aaor.size()).append(" keyboard events that have not yet received a response. Are responses being sent?");
        io.flutter.b.iAh();
      }
      if (j != 0) {
        break label333;
      }
      paramKeyEvent = this.aaon;
      localObject2 = new HashMap();
      ((Map)localObject2).put("type", "keydown");
      ((Map)localObject2).put("keymap", "android");
      c.a((c.b)localObject1, (Map)localObject2);
      paramKeyEvent.aasl.b(localObject2, paramKeyEvent.p(((c.b)localObject1).aasv));
    }
    for (;;)
    {
      AppMethodBeat.o(255580);
      return true;
      char c1 = (char)k;
      int i;
      label234:
      char c2;
      if ((0x80000000 & k) != 0)
      {
        i = 1;
        if (i == 0) {
          break label294;
        }
        i = 0x7FFFFFFF & k;
        if (this.aaop == 0) {
          break label283;
        }
        this.aaop = KeyCharacterMap.getDeadChar(this.aaop, i);
        c2 = c1;
      }
      for (;;)
      {
        localObject1 = Character.valueOf(c2);
        break;
        i = 0;
        break label234;
        label283:
        this.aaop = i;
        c2 = c1;
        continue;
        label294:
        c2 = c1;
        if (this.aaop != 0)
        {
          i = KeyCharacterMap.getDeadChar(this.aaop, k);
          if (i > 0) {
            c1 = (char)i;
          }
          this.aaop = 0;
          c2 = c1;
        }
      }
      label333:
      paramKeyEvent = this.aaon;
      localObject2 = new HashMap();
      ((Map)localObject2).put("type", "keyup");
      ((Map)localObject2).put("keymap", "android");
      c.a((c.b)localObject1, (Map)localObject2);
      paramKeyEvent.aasl.b(localObject2, paramKeyEvent.p(((c.b)localObject1).aasv));
    }
  }
  
  public final boolean k(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(255581);
    if (this.aaoq.m(paramKeyEvent) != null)
    {
      AppMethodBeat.o(255581);
      return true;
    }
    AppMethodBeat.o(255581);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.a
 * JD-Core Version:    0.7.0.1
 */