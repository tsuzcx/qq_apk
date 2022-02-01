package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int dDp;
  String extInfo;
  private int hHL;
  private int hMT;
  private int hMU;
  private int hYt;
  private long jeR;
  public String username;
  public int xad;
  public long xae;
  public long xaf;
  private String xag;
  private String xah;
  private String xai;
  private String xaj;
  
  public d()
  {
    AppMethodBeat.i(27719);
    this.dDp = -1;
    this.username = "";
    this.jeR = 0L;
    this.extInfo = "";
    this.xad = 0;
    this.xae = 0L;
    this.xaf = 0L;
    this.hHL = 0;
    this.hYt = 0;
    this.hMT = 0;
    this.hMU = 0;
    this.xag = "";
    this.xah = "";
    this.xai = "";
    this.xaj = "";
    AppMethodBeat.o(27719);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(27720);
    this.username = paramCursor.getString(0);
    this.jeR = paramCursor.getLong(1);
    this.extInfo = paramCursor.getString(2);
    this.xad = paramCursor.getInt(3);
    this.xae = paramCursor.getLong(4);
    this.xaf = paramCursor.getLong(5);
    this.hHL = paramCursor.getInt(6);
    this.hYt = paramCursor.getInt(7);
    this.hMT = paramCursor.getInt(8);
    this.hMU = paramCursor.getInt(9);
    this.xag = paramCursor.getString(10);
    this.xah = paramCursor.getString(11);
    this.xai = paramCursor.getString(12);
    this.xaj = paramCursor.getString(13);
    AppMethodBeat.o(27720);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(27721);
    ContentValues localContentValues = new ContentValues();
    if ((this.dDp & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dDp & 0x2) != 0) {
      localContentValues.put("qq", Long.valueOf(this.jeR));
    }
    if ((this.dDp & 0x4) != 0) {
      localContentValues.put("extinfo", dBR());
    }
    if ((this.dDp & 0x8) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.xad));
    }
    if ((this.dDp & 0x10) != 0) {
      localContentValues.put("extupdateseq", Long.valueOf(this.xae));
    }
    if ((this.dDp & 0x20) != 0) {
      localContentValues.put("imgupdateseq", Long.valueOf(this.xaf));
    }
    if ((this.dDp & 0x40) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.hHL));
    }
    if ((this.dDp & 0x80) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.hYt));
    }
    if ((this.dDp & 0x100) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.hMT));
    }
    if ((this.dDp & 0x200) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.hMU));
    }
    if ((this.dDp & 0x400) != 0)
    {
      if (this.xag == null)
      {
        str = "";
        localContentValues.put("reserved5", str);
      }
    }
    else
    {
      if ((this.dDp & 0x800) != 0)
      {
        if (this.xah != null) {
          break label366;
        }
        str = "";
        label287:
        localContentValues.put("reserved6", str);
      }
      if ((this.dDp & 0x1000) != 0)
      {
        if (this.xai != null) {
          break label374;
        }
        str = "";
        label315:
        localContentValues.put("reserved7", str);
      }
      if ((this.dDp & 0x2000) != 0) {
        if (this.xaj != null) {
          break label382;
        }
      }
    }
    label366:
    label374:
    label382:
    for (String str = "";; str = this.xaj)
    {
      localContentValues.put("reserved8", str);
      AppMethodBeat.o(27721);
      return localContentValues;
      str = this.xag;
      break;
      str = this.xah;
      break label287;
      str = this.xai;
      break label315;
    }
  }
  
  public final String dBR()
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