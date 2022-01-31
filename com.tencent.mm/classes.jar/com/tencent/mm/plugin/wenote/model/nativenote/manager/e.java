package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.EditText;
import java.io.Serializable;

public class e
  implements Serializable
{
  public int Eo;
  public int aiH;
  
  public e(int paramInt1, int paramInt2)
  {
    this.aiH = paramInt1;
    this.Eo = paramInt2;
    if (this.aiH > this.Eo)
    {
      paramInt1 = this.Eo;
      this.Eo = this.aiH;
      this.aiH = paramInt1;
    }
  }
  
  public e(EditText paramEditText)
  {
    this(paramEditText.getSelectionStart(), paramEditText.getSelectionEnd());
  }
  
  public final e eR(int paramInt1, int paramInt2)
  {
    this.aiH = Math.max(0, this.aiH - paramInt1);
    this.Eo += paramInt2;
    return this;
  }
  
  public final boolean isEmpty()
  {
    return this.aiH == this.Eo;
  }
  
  public String toString()
  {
    return "[" + this.aiH + ", " + this.Eo + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.e
 * JD-Core Version:    0.7.0.1
 */