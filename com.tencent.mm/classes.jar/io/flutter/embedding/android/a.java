package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.b.a;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private final io.flutter.embedding.engine.c.b IXa;
  private final io.flutter.a.b.b IXb;
  private int IXc;
  
  public a(io.flutter.embedding.engine.c.b paramb, io.flutter.a.b.b paramb1)
  {
    this.IXa = paramb;
    this.IXb = paramb1;
  }
  
  private Character ady(int paramInt)
  {
    AppMethodBeat.i(10057);
    if (paramInt == 0)
    {
      AppMethodBeat.o(10057);
      return null;
    }
    Character localCharacter1 = Character.valueOf((char)paramInt);
    int i;
    Character localCharacter2;
    if ((0x80000000 & paramInt) != 0)
    {
      i = 1;
      if (i == 0) {
        break label89;
      }
      paramInt = 0x7FFFFFFF & paramInt;
      if (this.IXc == 0) {
        break label78;
      }
      this.IXc = KeyCharacterMap.getDeadChar(this.IXc, paramInt);
      localCharacter2 = localCharacter1;
    }
    for (;;)
    {
      AppMethodBeat.o(10057);
      return localCharacter2;
      i = 0;
      break;
      label78:
      this.IXc = paramInt;
      localCharacter2 = localCharacter1;
      continue;
      label89:
      localCharacter2 = localCharacter1;
      if (this.IXc != 0)
      {
        paramInt = KeyCharacterMap.getDeadChar(this.IXc, paramInt);
        if (paramInt > 0) {
          localCharacter1 = Character.valueOf((char)paramInt);
        }
        this.IXc = 0;
        localCharacter2 = localCharacter1;
      }
    }
  }
  
  public final void i(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(10055);
    Object localObject = ady(paramKeyEvent.getUnicodeChar());
    io.flutter.embedding.engine.c.b localb = this.IXa;
    paramKeyEvent = new b.a(paramKeyEvent, (Character)localObject);
    localObject = new HashMap();
    ((Map)localObject).put("type", "keyup");
    ((Map)localObject).put("keymap", "android");
    io.flutter.embedding.engine.c.b.a(paramKeyEvent, (Map)localObject);
    localb.IZr.eA(localObject);
    AppMethodBeat.o(10055);
  }
  
  public final void j(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(10056);
    if ((this.IXb.JbK != null) && (this.IXb.JbG.isAcceptingText())) {
      this.IXb.JbK.sendKeyEvent(paramKeyEvent);
    }
    Object localObject = ady(paramKeyEvent.getUnicodeChar());
    io.flutter.embedding.engine.c.b localb = this.IXa;
    paramKeyEvent = new b.a(paramKeyEvent, (Character)localObject);
    localObject = new HashMap();
    ((Map)localObject).put("type", "keydown");
    ((Map)localObject).put("keymap", "android");
    io.flutter.embedding.engine.c.b.a(paramKeyEvent, (Map)localObject);
    localb.IZr.eA(localObject);
    AppMethodBeat.o(10056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.a
 * JD-Core Version:    0.7.0.1
 */