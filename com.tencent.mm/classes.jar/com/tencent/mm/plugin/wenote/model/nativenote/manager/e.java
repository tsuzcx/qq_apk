package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class e
  implements Serializable
{
  public int MZ;
  public int atr;
  
  public e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30459);
    this.atr = paramInt1;
    this.MZ = paramInt2;
    if (this.atr > this.MZ)
    {
      paramInt1 = this.MZ;
      this.MZ = this.atr;
      this.atr = paramInt1;
    }
    AppMethodBeat.o(30459);
  }
  
  public e(EditText paramEditText)
  {
    this(paramEditText.getSelectionStart(), paramEditText.getSelectionEnd());
    AppMethodBeat.i(30460);
    AppMethodBeat.o(30460);
  }
  
  public final e iU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30461);
    this.atr = Math.max(0, this.atr - paramInt1);
    this.MZ += paramInt2;
    AppMethodBeat.o(30461);
    return this;
  }
  
  public final boolean isEmpty()
  {
    return this.atr == this.MZ;
  }
  
  public String toString()
  {
    AppMethodBeat.i(30462);
    String str = "[" + this.atr + ", " + this.MZ + "]";
    AppMethodBeat.o(30462);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.e
 * JD-Core Version:    0.7.0.1
 */