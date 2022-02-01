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
  private final io.flutter.embedding.engine.c.b KKl;
  private final io.flutter.plugin.b.b KKm;
  private int KKn;
  
  public a(io.flutter.embedding.engine.c.b paramb, io.flutter.plugin.b.b paramb1)
  {
    this.KKl = paramb;
    this.KKm = paramb1;
  }
  
  private Character agt(int paramInt)
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
      if (this.KKn == 0) {
        break label78;
      }
      this.KKn = KeyCharacterMap.getDeadChar(this.KKn, paramInt);
      localCharacter2 = localCharacter1;
    }
    for (;;)
    {
      AppMethodBeat.o(10057);
      return localCharacter2;
      i = 0;
      break;
      label78:
      this.KKn = paramInt;
      localCharacter2 = localCharacter1;
      continue;
      label89:
      localCharacter2 = localCharacter1;
      if (this.KKn != 0)
      {
        paramInt = KeyCharacterMap.getDeadChar(this.KKn, paramInt);
        if (paramInt > 0) {
          localCharacter1 = Character.valueOf((char)paramInt);
        }
        this.KKn = 0;
        localCharacter2 = localCharacter1;
      }
    }
  }
  
  public final void i(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(10055);
    Object localObject = agt(paramKeyEvent.getUnicodeChar());
    io.flutter.embedding.engine.c.b localb = this.KKl;
    paramKeyEvent = new b.a(paramKeyEvent, (Character)localObject);
    localObject = new HashMap();
    ((Map)localObject).put("type", "keyup");
    ((Map)localObject).put("keymap", "android");
    io.flutter.embedding.engine.c.b.a(paramKeyEvent, (Map)localObject);
    localb.KMU.eC(localObject);
    AppMethodBeat.o(10055);
  }
  
  public final void j(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(10056);
    if ((this.KKm.KPo != null) && (this.KKm.KPk.isAcceptingText())) {
      this.KKm.KPo.sendKeyEvent(paramKeyEvent);
    }
    Object localObject = agt(paramKeyEvent.getUnicodeChar());
    io.flutter.embedding.engine.c.b localb = this.KKl;
    paramKeyEvent = new b.a(paramKeyEvent, (Character)localObject);
    localObject = new HashMap();
    ((Map)localObject).put("type", "keydown");
    ((Map)localObject).put("keymap", "android");
    io.flutter.embedding.engine.c.b.a(paramKeyEvent, (Map)localObject);
    localb.KMU.eC(localObject);
    AppMethodBeat.o(10056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.a
 * JD-Core Version:    0.7.0.1
 */