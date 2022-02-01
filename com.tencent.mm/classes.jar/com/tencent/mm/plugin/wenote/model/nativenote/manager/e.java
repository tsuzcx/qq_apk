package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class e
  implements Serializable
{
  public int Pc;
  public int avh;
  
  public e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30459);
    this.avh = paramInt1;
    this.Pc = paramInt2;
    if (this.avh > this.Pc)
    {
      paramInt1 = this.Pc;
      this.Pc = this.avh;
      this.avh = paramInt1;
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
    return this.avh == this.Pc;
  }
  
  public final e kt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30461);
    this.avh = Math.max(0, this.avh - paramInt1);
    this.Pc += paramInt2;
    AppMethodBeat.o(30461);
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(30462);
    String str = "[" + this.avh + ", " + this.Pc + "]";
    AppMethodBeat.o(30462);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.e
 * JD-Core Version:    0.7.0.1
 */