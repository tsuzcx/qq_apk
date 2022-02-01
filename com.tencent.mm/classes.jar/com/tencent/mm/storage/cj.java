package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cj
{
  public a VHx;
  int VHy;
  int cUP;
  public String name;
  int status;
  
  public cj()
  {
    this.cUP = 135;
    this.name = "";
    this.VHx = null;
    this.VHx = null;
    this.name = "";
    this.status = 0;
    this.VHy = 0;
  }
  
  public cj(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(43298);
    this.cUP = 135;
    this.name = "";
    this.VHx = null;
    this.VHx = new a(paramString);
    this.name = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.status = (i | 0x2);
      this.VHy = paramInt;
      AppMethodBeat.o(43298);
      return;
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(43299);
    if ((this.cUP & 0x2) != 0)
    {
      this.name = paramCursor.getString(1);
      if (this.VHx == null) {
        this.VHx = new a(this.name);
      }
    }
    if ((this.cUP & 0x4) != 0) {
      this.status = paramCursor.getInt(2);
    }
    if ((this.cUP & 0x80) != 0) {
      this.VHy = paramCursor.getInt(7);
    }
    AppMethodBeat.o(43299);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(43300);
    ContentValues localContentValues = new ContentValues();
    if ((this.cUP & 0x2) != 0) {
      localContentValues.put("name", this.name);
    }
    if ((this.cUP & 0x4) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.cUP & 0x80) != 0) {
      localContentValues.put("int_reserved1", Integer.valueOf(this.VHy));
    }
    AppMethodBeat.o(43300);
    return localContentValues;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final boolean hAF()
  {
    return (this.status & 0x2) != 0;
  }
  
  public final boolean hAG()
  {
    return this.VHy == 1;
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
    private String domain;
    private String fPV;
    
    public a(String paramString)
    {
      AppMethodBeat.i(43297);
      int i = paramString.indexOf("@");
      if (i >= 0)
      {
        this.fPV = paramString.substring(0, i);
        this.domain = paramString.substring(i);
        AppMethodBeat.o(43297);
        return;
      }
      this.fPV = paramString;
      this.domain = "";
      AppMethodBeat.o(43297);
    }
    
    public final String bxr(String paramString)
    {
      if (this.domain != null) {
        paramString = this.domain;
      }
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cj
 * JD-Core Version:    0.7.0.1
 */