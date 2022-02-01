package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int dEu;
  String extInfo;
  private int hKD;
  private int hPM;
  private int hPN;
  private int ibl;
  private long jhK;
  public String username;
  public int xpU;
  public long xpV;
  public long xpW;
  private String xpX;
  private String xpY;
  private String xpZ;
  private String xqa;
  
  public d()
  {
    AppMethodBeat.i(27719);
    this.dEu = -1;
    this.username = "";
    this.jhK = 0L;
    this.extInfo = "";
    this.xpU = 0;
    this.xpV = 0L;
    this.xpW = 0L;
    this.hKD = 0;
    this.ibl = 0;
    this.hPM = 0;
    this.hPN = 0;
    this.xpX = "";
    this.xpY = "";
    this.xpZ = "";
    this.xqa = "";
    AppMethodBeat.o(27719);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(27720);
    this.username = paramCursor.getString(0);
    this.jhK = paramCursor.getLong(1);
    this.extInfo = paramCursor.getString(2);
    this.xpU = paramCursor.getInt(3);
    this.xpV = paramCursor.getLong(4);
    this.xpW = paramCursor.getLong(5);
    this.hKD = paramCursor.getInt(6);
    this.ibl = paramCursor.getInt(7);
    this.hPM = paramCursor.getInt(8);
    this.hPN = paramCursor.getInt(9);
    this.xpX = paramCursor.getString(10);
    this.xpY = paramCursor.getString(11);
    this.xpZ = paramCursor.getString(12);
    this.xqa = paramCursor.getString(13);
    AppMethodBeat.o(27720);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(27721);
    ContentValues localContentValues = new ContentValues();
    if ((this.dEu & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dEu & 0x2) != 0) {
      localContentValues.put("qq", Long.valueOf(this.jhK));
    }
    if ((this.dEu & 0x4) != 0) {
      localContentValues.put("extinfo", dFi());
    }
    if ((this.dEu & 0x8) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.xpU));
    }
    if ((this.dEu & 0x10) != 0) {
      localContentValues.put("extupdateseq", Long.valueOf(this.xpV));
    }
    if ((this.dEu & 0x20) != 0) {
      localContentValues.put("imgupdateseq", Long.valueOf(this.xpW));
    }
    if ((this.dEu & 0x40) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.hKD));
    }
    if ((this.dEu & 0x80) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.ibl));
    }
    if ((this.dEu & 0x100) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.hPM));
    }
    if ((this.dEu & 0x200) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.hPN));
    }
    if ((this.dEu & 0x400) != 0)
    {
      if (this.xpX == null)
      {
        str = "";
        localContentValues.put("reserved5", str);
      }
    }
    else
    {
      if ((this.dEu & 0x800) != 0)
      {
        if (this.xpY != null) {
          break label366;
        }
        str = "";
        label287:
        localContentValues.put("reserved6", str);
      }
      if ((this.dEu & 0x1000) != 0)
      {
        if (this.xpZ != null) {
          break label374;
        }
        str = "";
        label315:
        localContentValues.put("reserved7", str);
      }
      if ((this.dEu & 0x2000) != 0) {
        if (this.xqa != null) {
          break label382;
        }
      }
    }
    label366:
    label374:
    label382:
    for (String str = "";; str = this.xqa)
    {
      localContentValues.put("reserved8", str);
      AppMethodBeat.o(27721);
      return localContentValues;
      str = this.xpX;
      break;
      str = this.xpY;
      break label287;
      str = this.xpZ;
      break label315;
    }
  }
  
  public final String dFi()
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