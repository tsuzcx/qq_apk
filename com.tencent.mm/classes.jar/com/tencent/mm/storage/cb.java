package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cb
{
  public a JhI;
  int JhJ;
  int dEu;
  public String name;
  int status;
  
  public cb()
  {
    this.dEu = 135;
    this.name = "";
    this.JhI = null;
    this.JhI = null;
    this.name = "";
    this.status = 0;
    this.JhJ = 0;
  }
  
  public cb(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(43298);
    this.dEu = 135;
    this.name = "";
    this.JhI = null;
    this.JhI = new a(paramString);
    this.name = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.status = (i | 0x2);
      this.JhJ = paramInt;
      AppMethodBeat.o(43298);
      return;
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(43299);
    if ((this.dEu & 0x2) != 0)
    {
      this.name = paramCursor.getString(1);
      if (this.JhI == null) {
        this.JhI = new a(this.name);
      }
    }
    if ((this.dEu & 0x4) != 0) {
      this.status = paramCursor.getInt(2);
    }
    if ((this.dEu & 0x80) != 0) {
      this.JhJ = paramCursor.getInt(7);
    }
    AppMethodBeat.o(43299);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(43300);
    ContentValues localContentValues = new ContentValues();
    if ((this.dEu & 0x2) != 0) {
      localContentValues.put("name", this.name);
    }
    if ((this.dEu & 0x4) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.dEu & 0x80) != 0) {
      localContentValues.put("int_reserved1", Integer.valueOf(this.JhJ));
    }
    AppMethodBeat.o(43300);
    return localContentValues;
  }
  
  public final boolean fwD()
  {
    return (this.status & 0x2) != 0;
  }
  
  public final boolean fwE()
  {
    return this.JhJ == 1;
  }
  
  public final boolean isEnable()
  {
    return (this.status & 0x1) != 0;
  }
  
  public final void setEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int j = this.status;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        this.status = (i | j);
        return;
      }
    }
    this.status &= 0xFFFFFFFE;
  }
  
  public static final class a
  {
    private String EYb;
    private String dED;
    
    public a(String paramString)
    {
      AppMethodBeat.i(43297);
      int i = paramString.indexOf("@");
      if (i >= 0)
      {
        this.dED = paramString.substring(0, i);
        this.EYb = paramString.substring(i);
        AppMethodBeat.o(43297);
        return;
      }
      this.dED = paramString;
      this.EYb = "";
      AppMethodBeat.o(43297);
    }
    
    public final String aVT(String paramString)
    {
      if (this.EYb != null) {
        paramString = this.EYb;
      }
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.cb
 * JD-Core Version:    0.7.0.1
 */