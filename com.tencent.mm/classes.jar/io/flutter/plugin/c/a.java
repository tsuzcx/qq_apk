package io.flutter.plugin.c;

import android.annotation.TargetApi;
import android.view.PointerIcon;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.f;
import io.flutter.embedding.engine.b.f.a;
import java.util.HashMap;

@TargetApi(24)
public final class a
{
  static HashMap<String, Integer> aavL;
  private final f aaqa;
  final a aavK;
  
  public a(a parama, f paramf)
  {
    AppMethodBeat.i(255673);
    this.aavK = parama;
    this.aaqa = paramf;
    paramf.aasx = new f.a()
    {
      public final void bGi(String paramAnonymousString)
      {
        AppMethodBeat.i(255940);
        a.a locala = a.this.aavK;
        a locala1 = a.this;
        if (a.aavL == null) {
          a.aavL = new a.2(locala1);
        }
        int i = ((Integer)a.aavL.getOrDefault(paramAnonymousString, Integer.valueOf(1000))).intValue();
        locala.setPointerIcon(locala1.aavK.aDk(i));
        AppMethodBeat.o(255940);
      }
    };
    AppMethodBeat.o(255673);
  }
  
  public final void destroy()
  {
    this.aaqa.aasx = null;
  }
  
  public static abstract interface a
  {
    public abstract PointerIcon aDk(int paramInt);
    
    public abstract void setPointerIcon(PointerIcon paramPointerIcon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.c.a
 * JD-Core Version:    0.7.0.1
 */