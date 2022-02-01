package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class br
{
  public a FAK;
  private int FAL;
  int dtM;
  public String name;
  int status;
  
  public br()
  {
    this.dtM = 135;
    this.name = "";
    this.FAK = null;
    this.FAK = null;
    this.name = "";
    this.status = 0;
    this.FAL = 0;
  }
  
  public br(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(43298);
    this.dtM = 135;
    this.name = "";
    this.FAK = null;
    this.FAK = new a(paramString);
    this.name = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.status = (i | 0x2);
      this.FAL = paramInt;
      AppMethodBeat.o(43298);
      return;
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(43299);
    if ((this.dtM & 0x2) != 0)
    {
      this.name = paramCursor.getString(1);
      if (this.FAK == null) {
        this.FAK = new a(this.name);
      }
    }
    if ((this.dtM & 0x4) != 0) {
      this.status = paramCursor.getInt(2);
    }
    if ((this.dtM & 0x80) != 0) {
      this.FAL = paramCursor.getInt(7);
    }
    AppMethodBeat.o(43299);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(43300);
    ContentValues localContentValues = new ContentValues();
    if ((this.dtM & 0x2) != 0) {
      localContentValues.put("name", this.name);
    }
    if ((this.dtM & 0x4) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.dtM & 0x80) != 0) {
      localContentValues.put("int_reserved1", Integer.valueOf(this.FAL));
    }
    AppMethodBeat.o(43300);
    return localContentValues;
  }
  
  public final boolean eMR()
  {
    return (this.status & 0x2) != 0;
  }
  
  public final boolean eMS()
  {
    return this.FAL == 1;
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
    private String BJx;
    private String dtV;
    
    public a(String paramString)
    {
      AppMethodBeat.i(43297);
      int i = paramString.indexOf("@");
      if (i >= 0)
      {
        this.dtV = paramString.substring(0, i);
        this.BJx = paramString.substring(i);
        AppMethodBeat.o(43297);
        return;
      }
      this.dtV = paramString;
      this.BJx = "";
      AppMethodBeat.o(43297);
    }
    
    public final String aJf(String paramString)
    {
      if (this.BJx != null) {
        paramString = this.BJx;
      }
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.br
 * JD-Core Version:    0.7.0.1
 */