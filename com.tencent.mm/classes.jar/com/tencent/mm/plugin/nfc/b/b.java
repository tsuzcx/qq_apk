package com.tencent.mm.plugin.nfc.b;

import android.nfc.Tag;

public abstract class b
{
  private Tag Gxi;
  public byte[] Gxj = null;
  
  public boolean a(Tag paramTag)
  {
    this.Gxi = paramTag;
    if (paramTag != null) {
      this.Gxj = paramTag.getId();
    }
    return true;
  }
  
  public final Tag fiZ()
  {
    return this.Gxi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.b
 * JD-Core Version:    0.7.0.1
 */