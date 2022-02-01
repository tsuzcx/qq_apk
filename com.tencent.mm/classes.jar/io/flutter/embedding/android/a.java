package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.b.a;
import io.flutter.plugin.b.c;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private final io.flutter.embedding.engine.c.b SMo;
  private final c SMp;
  private int SMq;
  
  public a(io.flutter.embedding.engine.c.b paramb, c paramc)
  {
    this.SMo = paramb;
    this.SMp = paramc;
  }
  
  private Character atm(int paramInt)
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
      if (this.SMq == 0) {
        break label78;
      }
      this.SMq = KeyCharacterMap.getDeadChar(this.SMq, paramInt);
      localCharacter2 = localCharacter1;
    }
    for (;;)
    {
      AppMethodBeat.o(10057);
      return localCharacter2;
      i = 0;
      break;
      label78:
      this.SMq = paramInt;
      localCharacter2 = localCharacter1;
      continue;
      label89:
      localCharacter2 = localCharacter1;
      if (this.SMq != 0)
      {
        paramInt = KeyCharacterMap.getDeadChar(this.SMq, paramInt);
        if (paramInt > 0) {
          localCharacter1 = Character.valueOf((char)paramInt);
        }
        this.SMq = 0;
        localCharacter2 = localCharacter1;
      }
    }
  }
  
  public final void j(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(10055);
    Object localObject = atm(paramKeyEvent.getUnicodeChar());
    io.flutter.embedding.engine.c.b localb = this.SMo;
    paramKeyEvent = new b.a(paramKeyEvent, (Character)localObject);
    localObject = new HashMap();
    ((Map)localObject).put("type", "keyup");
    ((Map)localObject).put("keymap", "android");
    io.flutter.embedding.engine.c.b.a(paramKeyEvent, (Map)localObject);
    localb.SPQ.eN(localObject);
    AppMethodBeat.o(10055);
  }
  
  public final void k(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(10056);
    if ((this.SMp.SSL != null) && (this.SMp.SSy.isAcceptingText())) {
      this.SMp.SSL.sendKeyEvent(paramKeyEvent);
    }
    Object localObject = atm(paramKeyEvent.getUnicodeChar());
    io.flutter.embedding.engine.c.b localb = this.SMo;
    paramKeyEvent = new b.a(paramKeyEvent, (Character)localObject);
    localObject = new HashMap();
    ((Map)localObject).put("type", "keydown");
    ((Map)localObject).put("keymap", "android");
    io.flutter.embedding.engine.c.b.a(paramKeyEvent, (Map)localObject);
    localb.SPQ.eN(localObject);
    AppMethodBeat.o(10056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.a
 * JD-Core Version:    0.7.0.1
 */