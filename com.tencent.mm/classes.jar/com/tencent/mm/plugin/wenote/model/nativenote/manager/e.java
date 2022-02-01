package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class e
  implements Serializable
{
  public int Mc;
  public int asw;
  
  public e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30459);
    this.asw = paramInt1;
    this.Mc = paramInt2;
    if (this.asw > this.Mc)
    {
      paramInt1 = this.Mc;
      this.Mc = this.asw;
      this.asw = paramInt1;
    }
    AppMethodBeat.o(30459);
  }
  
  public e(EditText paramEditText)
  {
    this(paramEditText.getSelectionStart(), paramEditText.getSelectionEnd());
    AppMethodBeat.i(30460);
    AppMethodBeat.o(30460);
  }
  
  public final e iH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30461);
    this.asw = Math.max(0, this.asw - paramInt1);
    this.Mc += paramInt2;
    AppMethodBeat.o(30461);
    return this;
  }
  
  public final boolean isEmpty()
  {
    return this.asw == this.Mc;
  }
  
  public String toString()
  {
    AppMethodBeat.i(30462);
    String str = "[" + this.asw + ", " + this.Mc + "]";
    AppMethodBeat.o(30462);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.e
 * JD-Core Version:    0.7.0.1
 */