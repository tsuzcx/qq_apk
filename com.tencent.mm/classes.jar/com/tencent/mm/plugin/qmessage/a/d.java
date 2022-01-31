package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;

public final class d
{
  public int bcw = -1;
  int dXk = 0;
  int ebP = 0;
  int ebQ = 0;
  int emn = 0;
  String extInfo = "";
  long fgW = 0L;
  String ncA = "";
  public int ncu = 0;
  public long ncv = 0L;
  public long ncw = 0L;
  String ncx = "";
  String ncy = "";
  String ncz = "";
  public String username = "";
  
  public final String bti()
  {
    if (this.extInfo == null) {
      return "";
    }
    return this.extInfo;
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if ((this.bcw & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.bcw & 0x2) != 0) {
      localContentValues.put("qq", Long.valueOf(this.fgW));
    }
    if ((this.bcw & 0x4) != 0) {
      localContentValues.put("extinfo", bti());
    }
    if ((this.bcw & 0x8) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.ncu));
    }
    if ((this.bcw & 0x10) != 0) {
      localContentValues.put("extupdateseq", Long.valueOf(this.ncv));
    }
    if ((this.bcw & 0x20) != 0) {
      localContentValues.put("imgupdateseq", Long.valueOf(this.ncw));
    }
    if ((this.bcw & 0x40) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.dXk));
    }
    if ((this.bcw & 0x80) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.emn));
    }
    if ((this.bcw & 0x100) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.ebP));
    }
    if ((this.bcw & 0x200) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.ebQ));
    }
    if ((this.bcw & 0x400) != 0)
    {
      if (this.ncx == null)
      {
        str = "";
        localContentValues.put("reserved5", str);
      }
    }
    else
    {
      if ((this.bcw & 0x800) != 0)
      {
        if (this.ncy != null) {
          break label354;
        }
        str = "";
        label281:
        localContentValues.put("reserved6", str);
      }
      if ((this.bcw & 0x1000) != 0)
      {
        if (this.ncz != null) {
          break label362;
        }
        str = "";
        label309:
        localContentValues.put("reserved7", str);
      }
      if ((this.bcw & 0x2000) != 0) {
        if (this.ncA != null) {
          break label370;
        }
      }
    }
    label354:
    label362:
    label370:
    for (String str = "";; str = this.ncA)
    {
      localContentValues.put("reserved8", str);
      return localContentValues;
      str = this.ncx;
      break;
      str = this.ncy;
      break label281;
      str = this.ncz;
      break label309;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.d
 * JD-Core Version:    0.7.0.1
 */