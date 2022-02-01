package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ca
{
  public a INb;
  int INc;
  int dDp;
  public String name;
  int status;
  
  public ca()
  {
    this.dDp = 135;
    this.name = "";
    this.INb = null;
    this.INb = null;
    this.name = "";
    this.status = 0;
    this.INc = 0;
  }
  
  public ca(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(43298);
    this.dDp = 135;
    this.name = "";
    this.INb = null;
    this.INb = new a(paramString);
    this.name = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.status = (i | 0x2);
      this.INc = paramInt;
      AppMethodBeat.o(43298);
      return;
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(43299);
    if ((this.dDp & 0x2) != 0)
    {
      this.name = paramCursor.getString(1);
      if (this.INb == null) {
        this.INb = new a(this.name);
      }
    }
    if ((this.dDp & 0x4) != 0) {
      this.status = paramCursor.getInt(2);
    }
    if ((this.dDp & 0x80) != 0) {
      this.INc = paramCursor.getInt(7);
    }
    AppMethodBeat.o(43299);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(43300);
    ContentValues localContentValues = new ContentValues();
    if ((this.dDp & 0x2) != 0) {
      localContentValues.put("name", this.name);
    }
    if ((this.dDp & 0x4) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.dDp & 0x80) != 0) {
      localContentValues.put("int_reserved1", Integer.valueOf(this.INc));
    }
    AppMethodBeat.o(43300);
    return localContentValues;
  }
  
  public final boolean fsC()
  {
    return (this.status & 0x2) != 0;
  }
  
  public final boolean fsD()
  {
    return this.INc == 1;
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
    private String EFF;
    private String dDy;
    
    public a(String paramString)
    {
      AppMethodBeat.i(43297);
      int i = paramString.indexOf("@");
      if (i >= 0)
      {
        this.dDy = paramString.substring(0, i);
        this.EFF = paramString.substring(i);
        AppMethodBeat.o(43297);
        return;
      }
      this.dDy = paramString;
      this.EFF = "";
      AppMethodBeat.o(43297);
    }
    
    public final String aUs(String paramString)
    {
      if (this.EFF != null) {
        paramString = this.EFF;
      }
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ca
 * JD-Core Version:    0.7.0.1
 */