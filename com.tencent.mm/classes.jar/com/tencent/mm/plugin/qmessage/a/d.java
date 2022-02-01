package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public long HkA;
  public long HkB;
  private String HkC;
  private String HkD;
  private String HkE;
  private String HkF;
  public int Hkz;
  public int cUP;
  String extInfo;
  private int lBa;
  private int lBb;
  private int lME;
  private int lvr;
  private long mXm;
  public String username;
  
  public d()
  {
    AppMethodBeat.i(27719);
    this.cUP = -1;
    this.username = "";
    this.mXm = 0L;
    this.extInfo = "";
    this.Hkz = 0;
    this.HkA = 0L;
    this.HkB = 0L;
    this.lvr = 0;
    this.lME = 0;
    this.lBa = 0;
    this.lBb = 0;
    this.HkC = "";
    this.HkD = "";
    this.HkE = "";
    this.HkF = "";
    AppMethodBeat.o(27719);
  }
  
  public final String bsH()
  {
    if (this.extInfo == null) {
      return "";
    }
    return this.extInfo;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(27720);
    this.username = paramCursor.getString(0);
    this.mXm = paramCursor.getLong(1);
    this.extInfo = paramCursor.getString(2);
    this.Hkz = paramCursor.getInt(3);
    this.HkA = paramCursor.getLong(4);
    this.HkB = paramCursor.getLong(5);
    this.lvr = paramCursor.getInt(6);
    this.lME = paramCursor.getInt(7);
    this.lBa = paramCursor.getInt(8);
    this.lBb = paramCursor.getInt(9);
    this.HkC = paramCursor.getString(10);
    this.HkD = paramCursor.getString(11);
    this.HkE = paramCursor.getString(12);
    this.HkF = paramCursor.getString(13);
    AppMethodBeat.o(27720);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(27721);
    ContentValues localContentValues = new ContentValues();
    if ((this.cUP & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.cUP & 0x2) != 0) {
      localContentValues.put("qq", Long.valueOf(this.mXm));
    }
    if ((this.cUP & 0x4) != 0) {
      localContentValues.put("extinfo", bsH());
    }
    if ((this.cUP & 0x8) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.Hkz));
    }
    if ((this.cUP & 0x10) != 0) {
      localContentValues.put("extupdateseq", Long.valueOf(this.HkA));
    }
    if ((this.cUP & 0x20) != 0) {
      localContentValues.put("imgupdateseq", Long.valueOf(this.HkB));
    }
    if ((this.cUP & 0x40) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.lvr));
    }
    if ((this.cUP & 0x80) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.lME));
    }
    if ((this.cUP & 0x100) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.lBa));
    }
    if ((this.cUP & 0x200) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.lBb));
    }
    if ((this.cUP & 0x400) != 0)
    {
      if (this.HkC == null)
      {
        str = "";
        localContentValues.put("reserved5", str);
      }
    }
    else
    {
      if ((this.cUP & 0x800) != 0)
      {
        if (this.HkD != null) {
          break label366;
        }
        str = "";
        label287:
        localContentValues.put("reserved6", str);
      }
      if ((this.cUP & 0x1000) != 0)
      {
        if (this.HkE != null) {
          break label374;
        }
        str = "";
        label315:
        localContentValues.put("reserved7", str);
      }
      if ((this.cUP & 0x2000) != 0) {
        if (this.HkF != null) {
          break label382;
        }
      }
    }
    label366:
    label374:
    label382:
    for (String str = "";; str = this.HkF)
    {
      localContentValues.put("reserved8", str);
      AppMethodBeat.o(27721);
      return localContentValues;
      str = this.HkC;
      break;
      str = this.HkD;
      break label287;
      str = this.HkE;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.d
 * JD-Core Version:    0.7.0.1
 */