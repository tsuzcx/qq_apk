package com.tencent.mm.plugin.nfc.b;

import android.nfc.Tag;

public abstract class b
{
  protected Tag vnR;
  public byte[] vnS = null;
  
  public boolean a(Tag paramTag)
  {
    this.vnR = paramTag;
    if (paramTag != null) {
      this.vnS = paramTag.getId();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.b
 * JD-Core Version:    0.7.0.1
 */