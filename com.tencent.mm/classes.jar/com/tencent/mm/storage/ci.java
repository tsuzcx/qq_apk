package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ci
{
  public a OrA;
  int OrB;
  int cSx;
  public String name;
  int status;
  
  public ci()
  {
    this.cSx = 135;
    this.name = "";
    this.OrA = null;
    this.OrA = null;
    this.name = "";
    this.status = 0;
    this.OrB = 0;
  }
  
  public ci(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(43298);
    this.cSx = 135;
    this.name = "";
    this.OrA = null;
    this.OrA = new a(paramString);
    this.name = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.status = (i | 0x2);
      this.OrB = paramInt;
      AppMethodBeat.o(43298);
      return;
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(43299);
    if ((this.cSx & 0x2) != 0)
    {
      this.name = paramCursor.getString(1);
      if (this.OrA == null) {
        this.OrA = new a(this.name);
      }
    }
    if ((this.cSx & 0x4) != 0) {
      this.status = paramCursor.getInt(2);
    }
    if ((this.cSx & 0x80) != 0) {
      this.OrB = paramCursor.getInt(7);
    }
    AppMethodBeat.o(43299);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(43300);
    ContentValues localContentValues = new ContentValues();
    if ((this.cSx & 0x2) != 0) {
      localContentValues.put("name", this.name);
    }
    if ((this.cSx & 0x4) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.cSx & 0x80) != 0) {
      localContentValues.put("int_reserved1", Integer.valueOf(this.OrB));
    }
    AppMethodBeat.o(43300);
    return localContentValues;
  }
  
  public final boolean gEp()
  {
    return (this.status & 0x2) != 0;
  }
  
  public final boolean gEq()
  {
    return this.OrB == 1;
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
    private String dWq;
    private String domain;
    
    public a(String paramString)
    {
      AppMethodBeat.i(43297);
      int i = paramString.indexOf("@");
      if (i >= 0)
      {
        this.dWq = paramString.substring(0, i);
        this.domain = paramString.substring(i);
        AppMethodBeat.o(43297);
        return;
      }
      this.dWq = paramString;
      this.domain = "";
      AppMethodBeat.o(43297);
    }
    
    public final String bkR(String paramString)
    {
      if (this.domain != null) {
        paramString = this.domain;
      }
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ci
 * JD-Core Version:    0.7.0.1
 */