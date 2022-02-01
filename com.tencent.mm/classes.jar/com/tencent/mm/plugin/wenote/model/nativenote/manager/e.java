package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class e
  implements Serializable
{
  public int tH;
  public int tI;
  
  public e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30459);
    this.tH = paramInt1;
    this.tI = paramInt2;
    if (this.tH > this.tI)
    {
      paramInt1 = this.tI;
      this.tI = this.tH;
      this.tH = paramInt1;
    }
    AppMethodBeat.o(30459);
  }
  
  public e(EditText paramEditText)
  {
    this(paramEditText.getSelectionStart(), paramEditText.getSelectionEnd());
    AppMethodBeat.i(30460);
    AppMethodBeat.o(30460);
  }
  
  public final boolean isEmpty()
  {
    return this.tH == this.tI;
  }
  
  public final e lN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30461);
    this.tH = Math.max(0, this.tH - paramInt1);
    this.tI += paramInt2;
    AppMethodBeat.o(30461);
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(30462);
    String str = "[" + this.tH + ", " + this.tI + "]";
    AppMethodBeat.o(30462);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.e
 * JD-Core Version:    0.7.0.1
 */