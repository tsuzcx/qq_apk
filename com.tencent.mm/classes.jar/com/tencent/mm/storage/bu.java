package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bu
{
  public a GZM;
  private int GZN;
  int drx;
  public String name;
  int status;
  
  public bu()
  {
    this.drx = 135;
    this.name = "";
    this.GZM = null;
    this.GZM = null;
    this.name = "";
    this.status = 0;
    this.GZN = 0;
  }
  
  public bu(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(43298);
    this.drx = 135;
    this.name = "";
    this.GZM = null;
    this.GZM = new a(paramString);
    this.name = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.status = (i | 0x2);
      this.GZN = paramInt;
      AppMethodBeat.o(43298);
      return;
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(43299);
    if ((this.drx & 0x2) != 0)
    {
      this.name = paramCursor.getString(1);
      if (this.GZM == null) {
        this.GZM = new a(this.name);
      }
    }
    if ((this.drx & 0x4) != 0) {
      this.status = paramCursor.getInt(2);
    }
    if ((this.drx & 0x80) != 0) {
      this.GZN = paramCursor.getInt(7);
    }
    AppMethodBeat.o(43299);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(43300);
    ContentValues localContentValues = new ContentValues();
    if ((this.drx & 0x2) != 0) {
      localContentValues.put("name", this.name);
    }
    if ((this.drx & 0x4) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.drx & 0x80) != 0) {
      localContentValues.put("int_reserved1", Integer.valueOf(this.GZN));
    }
    AppMethodBeat.o(43300);
    return localContentValues;
  }
  
  public final boolean fcv()
  {
    return (this.status & 0x2) != 0;
  }
  
  public final boolean fcw()
  {
    return this.GZN == 1;
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
    private String DbG;
    private String drG;
    
    public a(String paramString)
    {
      AppMethodBeat.i(43297);
      int i = paramString.indexOf("@");
      if (i >= 0)
      {
        this.drG = paramString.substring(0, i);
        this.DbG = paramString.substring(i);
        AppMethodBeat.o(43297);
        return;
      }
      this.drG = paramString;
      this.DbG = "";
      AppMethodBeat.o(43297);
    }
    
    public final String aOB(String paramString)
    {
      if (this.DbG != null) {
        paramString = this.DbG;
      }
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bu
 * JD-Core Version:    0.7.0.1
 */