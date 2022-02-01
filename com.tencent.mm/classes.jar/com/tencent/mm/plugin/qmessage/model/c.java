package com.tencent.mm.plugin.qmessage.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public int Nim;
  public long Nin;
  public long Nio;
  private String Nip;
  private String Niq;
  private String Nir;
  private String Nis;
  public int eQp;
  String extInfo;
  private int oFl;
  private int omO;
  private int osC;
  private int osD;
  private long pTU;
  public String username;
  
  public c()
  {
    AppMethodBeat.i(27719);
    this.eQp = -1;
    this.username = "";
    this.pTU = 0L;
    this.extInfo = "";
    this.Nim = 0;
    this.Nin = 0L;
    this.Nio = 0L;
    this.omO = 0;
    this.oFl = 0;
    this.osC = 0;
    this.osD = 0;
    this.Nip = "";
    this.Niq = "";
    this.Nir = "";
    this.Nis = "";
    AppMethodBeat.o(27719);
  }
  
  public final String bQo()
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
    this.pTU = paramCursor.getLong(1);
    this.extInfo = paramCursor.getString(2);
    this.Nim = paramCursor.getInt(3);
    this.Nin = paramCursor.getLong(4);
    this.Nio = paramCursor.getLong(5);
    this.omO = paramCursor.getInt(6);
    this.oFl = paramCursor.getInt(7);
    this.osC = paramCursor.getInt(8);
    this.osD = paramCursor.getInt(9);
    this.Nip = paramCursor.getString(10);
    this.Niq = paramCursor.getString(11);
    this.Nir = paramCursor.getString(12);
    this.Nis = paramCursor.getString(13);
    AppMethodBeat.o(27720);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(27721);
    ContentValues localContentValues = new ContentValues();
    if ((this.eQp & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.eQp & 0x2) != 0) {
      localContentValues.put("qq", Long.valueOf(this.pTU));
    }
    if ((this.eQp & 0x4) != 0) {
      localContentValues.put("extinfo", bQo());
    }
    if ((this.eQp & 0x8) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.Nim));
    }
    if ((this.eQp & 0x10) != 0) {
      localContentValues.put("extupdateseq", Long.valueOf(this.Nin));
    }
    if ((this.eQp & 0x20) != 0) {
      localContentValues.put("imgupdateseq", Long.valueOf(this.Nio));
    }
    if ((this.eQp & 0x40) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.omO));
    }
    if ((this.eQp & 0x80) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.oFl));
    }
    if ((this.eQp & 0x100) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.osC));
    }
    if ((this.eQp & 0x200) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.osD));
    }
    if ((this.eQp & 0x400) != 0)
    {
      if (this.Nip == null)
      {
        str = "";
        localContentValues.put("reserved5", str);
      }
    }
    else
    {
      if ((this.eQp & 0x800) != 0)
      {
        if (this.Niq != null) {
          break label366;
        }
        str = "";
        label287:
        localContentValues.put("reserved6", str);
      }
      if ((this.eQp & 0x1000) != 0)
      {
        if (this.Nir != null) {
          break label374;
        }
        str = "";
        label315:
        localContentValues.put("reserved7", str);
      }
      if ((this.eQp & 0x2000) != 0) {
        if (this.Nis != null) {
          break label382;
        }
      }
    }
    label366:
    label374:
    label382:
    for (String str = "";; str = this.Nis)
    {
      localContentValues.put("reserved8", str);
      AppMethodBeat.o(27721);
      return localContentValues;
      str = this.Nip;
      break;
      str = this.Niq;
      break label287;
      str = this.Nir;
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
 * Qualified Name:     com.tencent.mm.plugin.qmessage.model.c
 * JD-Core Version:    0.7.0.1
 */