package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int bsY;
  String extInfo;
  private int fCK;
  private int fns;
  private int fsh;
  private int fsi;
  private long gyE;
  public int pHM;
  public long pHN;
  public long pHO;
  private String pHP;
  private String pHQ;
  private String pHR;
  private String pHS;
  public String username;
  
  public d()
  {
    AppMethodBeat.i(24079);
    this.bsY = -1;
    this.username = "";
    this.gyE = 0L;
    this.extInfo = "";
    this.pHM = 0;
    this.pHN = 0L;
    this.pHO = 0L;
    this.fns = 0;
    this.fCK = 0;
    this.fsh = 0;
    this.fsi = 0;
    this.pHP = "";
    this.pHQ = "";
    this.pHR = "";
    this.pHS = "";
    AppMethodBeat.o(24079);
  }
  
  public final String cdp()
  {
    if (this.extInfo == null) {
      return "";
    }
    return this.extInfo;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(24080);
    this.username = paramCursor.getString(0);
    this.gyE = paramCursor.getLong(1);
    this.extInfo = paramCursor.getString(2);
    this.pHM = paramCursor.getInt(3);
    this.pHN = paramCursor.getLong(4);
    this.pHO = paramCursor.getLong(5);
    this.fns = paramCursor.getInt(6);
    this.fCK = paramCursor.getInt(7);
    this.fsh = paramCursor.getInt(8);
    this.fsi = paramCursor.getInt(9);
    this.pHP = paramCursor.getString(10);
    this.pHQ = paramCursor.getString(11);
    this.pHR = paramCursor.getString(12);
    this.pHS = paramCursor.getString(13);
    AppMethodBeat.o(24080);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(24081);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.bsY & 0x2) != 0) {
      localContentValues.put("qq", Long.valueOf(this.gyE));
    }
    if ((this.bsY & 0x4) != 0) {
      localContentValues.put("extinfo", cdp());
    }
    if ((this.bsY & 0x8) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.pHM));
    }
    if ((this.bsY & 0x10) != 0) {
      localContentValues.put("extupdateseq", Long.valueOf(this.pHN));
    }
    if ((this.bsY & 0x20) != 0) {
      localContentValues.put("imgupdateseq", Long.valueOf(this.pHO));
    }
    if ((this.bsY & 0x40) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.fns));
    }
    if ((this.bsY & 0x80) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.fCK));
    }
    if ((this.bsY & 0x100) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.fsh));
    }
    if ((this.bsY & 0x200) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.fsi));
    }
    if ((this.bsY & 0x400) != 0)
    {
      if (this.pHP == null)
      {
        str = "";
        localContentValues.put("reserved5", str);
      }
    }
    else
    {
      if ((this.bsY & 0x800) != 0)
      {
        if (this.pHQ != null) {
          break label366;
        }
        str = "";
        label287:
        localContentValues.put("reserved6", str);
      }
      if ((this.bsY & 0x1000) != 0)
      {
        if (this.pHR != null) {
          break label374;
        }
        str = "";
        label315:
        localContentValues.put("reserved7", str);
      }
      if ((this.bsY & 0x2000) != 0) {
        if (this.pHS != null) {
          break label382;
        }
      }
    }
    label366:
    label374:
    label382:
    for (String str = "";; str = this.pHS)
    {
      localContentValues.put("reserved8", str);
      AppMethodBeat.o(24081);
      return localContentValues;
      str = this.pHP;
      break;
      str = this.pHQ;
      break label287;
      str = this.pHR;
      break label315;
    }
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.d
 * JD-Core Version:    0.7.0.1
 */