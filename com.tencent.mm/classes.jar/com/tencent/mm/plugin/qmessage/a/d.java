package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int drx;
  String extInfo;
  private int hFO;
  private int hpt;
  private int huB;
  private int huC;
  private long iLI;
  public String username;
  public int vST;
  public long vSU;
  public long vSV;
  private String vSW;
  private String vSX;
  private String vSY;
  private String vSZ;
  
  public d()
  {
    AppMethodBeat.i(27719);
    this.drx = -1;
    this.username = "";
    this.iLI = 0L;
    this.extInfo = "";
    this.vST = 0;
    this.vSU = 0L;
    this.vSV = 0L;
    this.hpt = 0;
    this.hFO = 0;
    this.huB = 0;
    this.huC = 0;
    this.vSW = "";
    this.vSX = "";
    this.vSY = "";
    this.vSZ = "";
    AppMethodBeat.o(27719);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(27720);
    this.username = paramCursor.getString(0);
    this.iLI = paramCursor.getLong(1);
    this.extInfo = paramCursor.getString(2);
    this.vST = paramCursor.getInt(3);
    this.vSU = paramCursor.getLong(4);
    this.vSV = paramCursor.getLong(5);
    this.hpt = paramCursor.getInt(6);
    this.hFO = paramCursor.getInt(7);
    this.huB = paramCursor.getInt(8);
    this.huC = paramCursor.getInt(9);
    this.vSW = paramCursor.getString(10);
    this.vSX = paramCursor.getString(11);
    this.vSY = paramCursor.getString(12);
    this.vSZ = paramCursor.getString(13);
    AppMethodBeat.o(27720);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(27721);
    ContentValues localContentValues = new ContentValues();
    if ((this.drx & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.drx & 0x2) != 0) {
      localContentValues.put("qq", Long.valueOf(this.iLI));
    }
    if ((this.drx & 0x4) != 0) {
      localContentValues.put("extinfo", drp());
    }
    if ((this.drx & 0x8) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.vST));
    }
    if ((this.drx & 0x10) != 0) {
      localContentValues.put("extupdateseq", Long.valueOf(this.vSU));
    }
    if ((this.drx & 0x20) != 0) {
      localContentValues.put("imgupdateseq", Long.valueOf(this.vSV));
    }
    if ((this.drx & 0x40) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.hpt));
    }
    if ((this.drx & 0x80) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.hFO));
    }
    if ((this.drx & 0x100) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.huB));
    }
    if ((this.drx & 0x200) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.huC));
    }
    if ((this.drx & 0x400) != 0)
    {
      if (this.vSW == null)
      {
        str = "";
        localContentValues.put("reserved5", str);
      }
    }
    else
    {
      if ((this.drx & 0x800) != 0)
      {
        if (this.vSX != null) {
          break label366;
        }
        str = "";
        label287:
        localContentValues.put("reserved6", str);
      }
      if ((this.drx & 0x1000) != 0)
      {
        if (this.vSY != null) {
          break label374;
        }
        str = "";
        label315:
        localContentValues.put("reserved7", str);
      }
      if ((this.drx & 0x2000) != 0) {
        if (this.vSZ != null) {
          break label382;
        }
      }
    }
    label366:
    label374:
    label382:
    for (String str = "";; str = this.vSZ)
    {
      localContentValues.put("reserved8", str);
      AppMethodBeat.o(27721);
      return localContentValues;
      str = this.vSW;
      break;
      str = this.vSX;
      break label287;
      str = this.vSY;
      break label315;
    }
  }
  
  public final String drp()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.d
 * JD-Core Version:    0.7.0.1
 */