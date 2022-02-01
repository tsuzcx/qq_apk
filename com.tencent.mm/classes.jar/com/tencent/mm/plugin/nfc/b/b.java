package com.tencent.mm.plugin.nfc.b;

import android.nfc.Tag;

public abstract class b
{
  protected Tag AEe;
  public byte[] AEf = null;
  
  public boolean a(Tag paramTag)
  {
    this.AEe = paramTag;
    if (paramTag != null) {
      this.AEf = paramTag.getId();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.b
 * JD-Core Version:    0.7.0.1
 */