package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class e
  implements Serializable
{
  public int Fe;
  public int akX;
  
  public e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26766);
    this.akX = paramInt1;
    this.Fe = paramInt2;
    if (this.akX > this.Fe)
    {
      paramInt1 = this.Fe;
      this.Fe = this.akX;
      this.akX = paramInt1;
    }
    AppMethodBeat.o(26766);
  }
  
  public e(EditText paramEditText)
  {
    this(paramEditText.getSelectionStart(), paramEditText.getSelectionEnd());
    AppMethodBeat.i(26767);
    AppMethodBeat.o(26767);
  }
  
  public final e gX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26768);
    this.akX = Math.max(0, this.akX - paramInt1);
    this.Fe += paramInt2;
    AppMethodBeat.o(26768);
    return this;
  }
  
  public final boolean isEmpty()
  {
    return this.akX == this.Fe;
  }
  
  public String toString()
  {
    AppMethodBeat.i(26769);
    String str = "[" + this.akX + ", " + this.Fe + "]";
    AppMethodBeat.o(26769);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.e
 * JD-Core Version:    0.7.0.1
 */