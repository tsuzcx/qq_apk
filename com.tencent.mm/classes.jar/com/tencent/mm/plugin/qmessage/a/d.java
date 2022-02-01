package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int Bqg;
  public long Bqh;
  public long Bqi;
  private String Bqj;
  private String Bqk;
  private String Bql;
  private String Bqm;
  public int cSx;
  String extInfo;
  private int iFr;
  private int iKT;
  private int iKU;
  private int iWj;
  private long kfN;
  public String username;
  
  public d()
  {
    AppMethodBeat.i(27719);
    this.cSx = -1;
    this.username = "";
    this.kfN = 0L;
    this.extInfo = "";
    this.Bqg = 0;
    this.Bqh = 0L;
    this.Bqi = 0L;
    this.iFr = 0;
    this.iWj = 0;
    this.iKT = 0;
    this.iKU = 0;
    this.Bqj = "";
    this.Bqk = "";
    this.Bql = "";
    this.Bqm = "";
    AppMethodBeat.o(27719);
  }
  
  public final String bjg()
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
    this.kfN = paramCursor.getLong(1);
    this.extInfo = paramCursor.getString(2);
    this.Bqg = paramCursor.getInt(3);
    this.Bqh = paramCursor.getLong(4);
    this.Bqi = paramCursor.getLong(5);
    this.iFr = paramCursor.getInt(6);
    this.iWj = paramCursor.getInt(7);
    this.iKT = paramCursor.getInt(8);
    this.iKU = paramCursor.getInt(9);
    this.Bqj = paramCursor.getString(10);
    this.Bqk = paramCursor.getString(11);
    this.Bql = paramCursor.getString(12);
    this.Bqm = paramCursor.getString(13);
    AppMethodBeat.o(27720);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(27721);
    ContentValues localContentValues = new ContentValues();
    if ((this.cSx & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.cSx & 0x2) != 0) {
      localContentValues.put("qq", Long.valueOf(this.kfN));
    }
    if ((this.cSx & 0x4) != 0) {
      localContentValues.put("extinfo", bjg());
    }
    if ((this.cSx & 0x8) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.Bqg));
    }
    if ((this.cSx & 0x10) != 0) {
      localContentValues.put("extupdateseq", Long.valueOf(this.Bqh));
    }
    if ((this.cSx & 0x20) != 0) {
      localContentValues.put("imgupdateseq", Long.valueOf(this.Bqi));
    }
    if ((this.cSx & 0x40) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.iFr));
    }
    if ((this.cSx & 0x80) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.iWj));
    }
    if ((this.cSx & 0x100) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.iKT));
    }
    if ((this.cSx & 0x200) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.iKU));
    }
    if ((this.cSx & 0x400) != 0)
    {
      if (this.Bqj == null)
      {
        str = "";
        localContentValues.put("reserved5", str);
      }
    }
    else
    {
      if ((this.cSx & 0x800) != 0)
      {
        if (this.Bqk != null) {
          break label366;
        }
        str = "";
        label287:
        localContentValues.put("reserved6", str);
      }
      if ((this.cSx & 0x1000) != 0)
      {
        if (this.Bql != null) {
          break label374;
        }
        str = "";
        label315:
        localContentValues.put("reserved7", str);
      }
      if ((this.cSx & 0x2000) != 0) {
        if (this.Bqm != null) {
          break label382;
        }
      }
    }
    label366:
    label374:
    label382:
    for (String str = "";; str = this.Bqm)
    {
      localContentValues.put("reserved8", str);
      AppMethodBeat.o(27721);
      return localContentValues;
      str = this.Bqj;
      break;
      str = this.Bqk;
      break label287;
      str = this.Bql;
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