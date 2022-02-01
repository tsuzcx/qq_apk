package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cm
{
  public a adlu;
  int adlv;
  int eQp;
  public String name;
  int status;
  
  public cm()
  {
    this.eQp = 135;
    this.name = "";
    this.adlu = null;
    this.adlu = null;
    this.name = "";
    this.status = 0;
    this.adlv = 0;
  }
  
  public cm(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(43298);
    this.eQp = 135;
    this.name = "";
    this.adlu = null;
    this.adlu = new a(paramString);
    this.name = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.status = (i | 0x2);
      this.adlv = paramInt;
      AppMethodBeat.o(43298);
      return;
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(43299);
    if ((this.eQp & 0x2) != 0)
    {
      this.name = paramCursor.getString(1);
      if (this.adlu == null) {
        this.adlu = new a(this.name);
      }
    }
    if ((this.eQp & 0x4) != 0) {
      this.status = paramCursor.getInt(2);
    }
    if ((this.eQp & 0x80) != 0) {
      this.adlv = paramCursor.getInt(7);
    }
    AppMethodBeat.o(43299);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(43300);
    ContentValues localContentValues = new ContentValues();
    if ((this.eQp & 0x2) != 0) {
      localContentValues.put("name", this.name);
    }
    if ((this.eQp & 0x4) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.eQp & 0x80) != 0) {
      localContentValues.put("int_reserved1", Integer.valueOf(this.adlv));
    }
    AppMethodBeat.o(43300);
    return localContentValues;
  }
  
  public final boolean isEnable()
  {
    return (this.status & 0x1) != 0;
  }
  
  public final boolean jcI()
  {
    return (this.status & 0x2) != 0;
  }
  
  public final boolean jcJ()
  {
    return this.adlv == 1;
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
    private String hVQ;
    
    public a(String paramString)
    {
      AppMethodBeat.i(43297);
      int i = paramString.indexOf("@");
      if (i >= 0)
      {
        this.hVQ = paramString.substring(0, i);
        this.domain = paramString.substring(i);
        AppMethodBeat.o(43297);
        return;
      }
      this.hVQ = paramString;
      this.domain = "";
      AppMethodBeat.o(43297);
    }
    
    public final String byJ(String paramString)
    {
      if (this.domain != null) {
        paramString = this.domain;
      }
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cm
 * JD-Core Version:    0.7.0.1
 */