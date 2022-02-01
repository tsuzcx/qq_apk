package com.tencent.mm.plugin.nfc.b;

import android.nfc.Tag;

public abstract class b
{
  private Tag Mti;
  public byte[] Mtj = null;
  
  public boolean a(Tag paramTag)
  {
    this.Mti = paramTag;
    if (paramTag != null) {
      this.Mtj = paramTag.getId();
    }
    return true;
  }
  
  public final Tag ctW()
  {
    return this.Mti;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.b
 * JD-Core Version:    0.7.0.1
 */