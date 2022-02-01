package com.tencent.mm.plugin.nfc.b;

import android.nfc.Tag;

public abstract class b
{
  protected Tag wtj;
  public byte[] wtk = null;
  
  public boolean a(Tag paramTag)
  {
    this.wtj = paramTag;
    if (paramTag != null) {
      this.wtk = paramTag.getId();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.b
 * JD-Core Version:    0.7.0.1
 */