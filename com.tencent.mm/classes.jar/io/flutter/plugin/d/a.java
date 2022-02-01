package io.flutter.plugin.d;

import android.annotation.TargetApi;
import android.view.PointerIcon;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.e;
import io.flutter.embedding.engine.c.e.a;
import java.util.HashMap;

@TargetApi(24)
public final class a
{
  static HashMap<String, Integer> SSZ;
  private final e SOb;
  final a SSY;
  
  public a(a parama, e parame)
  {
    AppMethodBeat.i(214859);
    this.SSY = parama;
    this.SOb = parame;
    parame.SQc = new e.a()
    {
      public final void btg(String paramAnonymousString)
      {
        AppMethodBeat.i(214857);
        a.a locala = a.this.SSY;
        a locala1 = a.this;
        if (a.SSZ == null) {
          a.SSZ = new a.2(locala1);
        }
        int i = ((Integer)a.SSZ.getOrDefault(paramAnonymousString, Integer.valueOf(1000))).intValue();
        locala.setPointerIcon(locala1.SSY.atp(i));
        AppMethodBeat.o(214857);
      }
    };
    AppMethodBeat.o(214859);
  }
  
  public static abstract interface a
  {
    public abstract PointerIcon atp(int paramInt);
    
    public abstract void setPointerIcon(PointerIcon paramPointerIcon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.plugin.d.a
 * JD-Core Version:    0.7.0.1
 */