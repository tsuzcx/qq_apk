package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class e
  implements Serializable
{
  public int OQ;
  public int avj;
  
  public e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30459);
    this.avj = paramInt1;
    this.OQ = paramInt2;
    if (this.avj > this.OQ)
    {
      paramInt1 = this.OQ;
      this.OQ = this.avj;
      this.avj = paramInt1;
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
    return this.avj == this.OQ;
  }
  
  public final e jh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30461);
    this.avj = Math.max(0, this.avj - paramInt1);
    this.OQ += paramInt2;
    AppMethodBeat.o(30461);
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(30462);
    String str = "[" + this.avj + ", " + this.OQ + "]";
    AppMethodBeat.o(30462);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.e
 * JD-Core Version:    0.7.0.1
 */