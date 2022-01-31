package com.tencent.mm.plugin.nfc.b;

import android.nfc.Tag;

public abstract class b
{
  protected Tag pgo;
  public byte[] pgp = null;
  
  public boolean a(Tag paramTag)
  {
    this.pgo = paramTag;
    if (paramTag != null) {
      this.pgp = paramTag.getId();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.b
 * JD-Core Version:    0.7.0.1
 */