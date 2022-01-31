package com.tencent.mm.plugin.nfc.b;

import android.nfc.Tag;

public abstract class b
{
  public Tag mGi;
  public byte[] mGj = null;
  
  public boolean a(Tag paramTag)
  {
    this.mGi = paramTag;
    if (paramTag != null) {
      this.mGj = paramTag.getId();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.b
 * JD-Core Version:    0.7.0.1
 */