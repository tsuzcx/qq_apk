package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;

public final class bq
{
  int bcw = 135;
  public String name = "";
  int status;
  public a uCJ = null;
  public int uCK;
  
  public bq()
  {
    this.uCJ = null;
    this.name = "";
    this.status = 0;
    this.uCK = 0;
  }
  
  public bq(String paramString, boolean paramBoolean, int paramInt)
  {
    this.uCJ = new a(paramString);
    this.name = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.status = (i | 0x2);
      this.uCK = paramInt;
      return;
    }
  }
  
  public final boolean cvY()
  {
    return (this.status & 0x2) != 0;
  }
  
  public final void d(Cursor paramCursor)
  {
    if ((this.bcw & 0x2) != 0)
    {
      this.name = paramCursor.getString(1);
      if (this.uCJ == null) {
        this.uCJ = new a(this.name);
      }
    }
    if ((this.bcw & 0x4) != 0) {
      this.status = paramCursor.getInt(2);
    }
    if ((this.bcw & 0x80) != 0) {
      this.uCK = paramCursor.getInt(7);
    }
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
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if ((this.bcw & 0x2) != 0) {
      localContentValues.put("name", this.name);
    }
    if ((this.bcw & 0x4) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.bcw & 0x80) != 0) {
      localContentValues.put("int_reserved1", Integer.valueOf(this.uCK));
    }
    return localContentValues;
  }
  
  public static final class a
  {
    private String bVI;
    private String ceG;
    
    public a(String paramString)
    {
      int i = paramString.indexOf("@");
      if (i >= 0)
      {
        this.bVI = paramString.substring(0, i);
        this.ceG = paramString.substring(i);
        return;
      }
      this.bVI = paramString;
      this.ceG = "";
    }
    
    public final String aco(String paramString)
    {
      if (this.ceG != null) {
        paramString = this.ceG;
      }
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bq
 * JD-Core Version:    0.7.0.1
 */