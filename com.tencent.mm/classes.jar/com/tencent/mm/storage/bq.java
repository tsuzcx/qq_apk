package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bq
{
  int bsY;
  public String name;
  int status;
  public a yOV;
  private int yOW;
  
  public bq()
  {
    this.bsY = 135;
    this.name = "";
    this.yOV = null;
    this.yOV = null;
    this.name = "";
    this.status = 0;
    this.yOW = 0;
  }
  
  public bq(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(60231);
    this.bsY = 135;
    this.name = "";
    this.yOV = null;
    this.yOV = new a(paramString);
    this.name = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.status = (i | 0x2);
      this.yOW = paramInt;
      AppMethodBeat.o(60231);
      return;
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(60232);
    if ((this.bsY & 0x2) != 0)
    {
      this.name = paramCursor.getString(1);
      if (this.yOV == null) {
        this.yOV = new a(this.name);
      }
    }
    if ((this.bsY & 0x4) != 0) {
      this.status = paramCursor.getInt(2);
    }
    if ((this.bsY & 0x80) != 0) {
      this.yOW = paramCursor.getInt(7);
    }
    AppMethodBeat.o(60232);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(60233);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x2) != 0) {
      localContentValues.put("name", this.name);
    }
    if ((this.bsY & 0x4) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.bsY & 0x80) != 0) {
      localContentValues.put("int_reserved1", Integer.valueOf(this.yOW));
    }
    AppMethodBeat.o(60233);
    return localContentValues;
  }
  
  public final boolean dyH()
  {
    return (this.status & 0x2) != 0;
  }
  
  public final boolean dyI()
  {
    return this.yOW == 1;
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
    private String cDt;
    private String vGN;
    
    public a(String paramString)
    {
      AppMethodBeat.i(60230);
      int i = paramString.indexOf("@");
      if (i >= 0)
      {
        this.cDt = paramString.substring(0, i);
        this.vGN = paramString.substring(i);
        AppMethodBeat.o(60230);
        return;
      }
      this.cDt = paramString;
      this.vGN = "";
      AppMethodBeat.o(60230);
    }
    
    public final String asA(String paramString)
    {
      if (this.vGN != null) {
        paramString = this.vGN;
      }
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bq
 * JD-Core Version:    0.7.0.1
 */