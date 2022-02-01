package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int dtM;
  String extInfo;
  private int gOT;
  private int gUc;
  private int gUd;
  private int hfl;
  private long ilB;
  public int uKc;
  public long uKd;
  public long uKe;
  private String uKf;
  private String uKg;
  private String uKh;
  private String uKi;
  public String username;
  
  public d()
  {
    AppMethodBeat.i(27719);
    this.dtM = -1;
    this.username = "";
    this.ilB = 0L;
    this.extInfo = "";
    this.uKc = 0;
    this.uKd = 0L;
    this.uKe = 0L;
    this.gOT = 0;
    this.hfl = 0;
    this.gUc = 0;
    this.gUd = 0;
    this.uKf = "";
    this.uKg = "";
    this.uKh = "";
    this.uKi = "";
    AppMethodBeat.o(27719);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(27720);
    this.username = paramCursor.getString(0);
    this.ilB = paramCursor.getLong(1);
    this.extInfo = paramCursor.getString(2);
    this.uKc = paramCursor.getInt(3);
    this.uKd = paramCursor.getLong(4);
    this.uKe = paramCursor.getLong(5);
    this.gOT = paramCursor.getInt(6);
    this.hfl = paramCursor.getInt(7);
    this.gUc = paramCursor.getInt(8);
    this.gUd = paramCursor.getInt(9);
    this.uKf = paramCursor.getString(10);
    this.uKg = paramCursor.getString(11);
    this.uKh = paramCursor.getString(12);
    this.uKi = paramCursor.getString(13);
    AppMethodBeat.o(27720);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(27721);
    ContentValues localContentValues = new ContentValues();
    if ((this.dtM & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dtM & 0x2) != 0) {
      localContentValues.put("qq", Long.valueOf(this.ilB));
    }
    if ((this.dtM & 0x4) != 0) {
      localContentValues.put("extinfo", ddH());
    }
    if ((this.dtM & 0x8) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.uKc));
    }
    if ((this.dtM & 0x10) != 0) {
      localContentValues.put("extupdateseq", Long.valueOf(this.uKd));
    }
    if ((this.dtM & 0x20) != 0) {
      localContentValues.put("imgupdateseq", Long.valueOf(this.uKe));
    }
    if ((this.dtM & 0x40) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.gOT));
    }
    if ((this.dtM & 0x80) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.hfl));
    }
    if ((this.dtM & 0x100) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.gUc));
    }
    if ((this.dtM & 0x200) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.gUd));
    }
    if ((this.dtM & 0x400) != 0)
    {
      if (this.uKf == null)
      {
        str = "";
        localContentValues.put("reserved5", str);
      }
    }
    else
    {
      if ((this.dtM & 0x800) != 0)
      {
        if (this.uKg != null) {
          break label366;
        }
        str = "";
        label287:
        localContentValues.put("reserved6", str);
      }
      if ((this.dtM & 0x1000) != 0)
      {
        if (this.uKh != null) {
          break label374;
        }
        str = "";
        label315:
        localContentValues.put("reserved7", str);
      }
      if ((this.dtM & 0x2000) != 0) {
        if (this.uKi != null) {
          break label382;
        }
      }
    }
    label366:
    label374:
    label382:
    for (String str = "";; str = this.uKi)
    {
      localContentValues.put("reserved8", str);
      AppMethodBeat.o(27721);
      return localContentValues;
      str = this.uKf;
      break;
      str = this.uKg;
      break label287;
      str = this.uKh;
      break label315;
    }
  }
  
  public final String ddH()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.d
 * JD-Core Version:    0.7.0.1
 */