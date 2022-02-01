package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class e
  implements Serializable
{
  public int uG;
  public int uH;
  
  public e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30459);
    this.uG = paramInt1;
    this.uH = paramInt2;
    if (this.uG > this.uH)
    {
      paramInt1 = this.uH;
      this.uH = this.uG;
      this.uG = paramInt1;
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
    return this.uG == this.uH;
  }
  
  public final e nx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30461);
    this.uG = Math.max(0, this.uG - paramInt1);
    this.uH += paramInt2;
    AppMethodBeat.o(30461);
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(30462);
    String str = "[" + this.uG + ", " + this.uH + "]";
    AppMethodBeat.o(30462);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.e
 * JD-Core Version:    0.7.0.1
 */