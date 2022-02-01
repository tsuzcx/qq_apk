package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;

public final class t
{
  public int AdJ;
  private long Aes;
  public int Aet;
  public String Aeu;
  private int Aev;
  private long Aew;
  public String Aex;
  public byte[] Aey;
  long createTime;
  private int jfR;
  public int offset;
  public int type;
  private String userName;
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97596);
    this.AdJ = paramCursor.getInt(0);
    long l = paramCursor.getLong(1);
    this.Aes = l;
    this.Aex = r.zV(l);
    this.type = paramCursor.getInt(2);
    this.createTime = paramCursor.getLong(3);
    this.userName = paramCursor.getString(4);
    this.Aet = paramCursor.getInt(5);
    this.offset = paramCursor.getInt(6);
    this.jfR = paramCursor.getInt(7);
    this.Aeu = paramCursor.getString(8);
    this.Aev = paramCursor.getInt(9);
    this.Aew = paramCursor.getLong(10);
    this.Aex = paramCursor.getString(11);
    this.Aey = paramCursor.getBlob(12);
    AppMethodBeat.o(97596);
  }
  
  public final ContentValues ecM()
  {
    AppMethodBeat.i(97595);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("seqId", Long.valueOf(this.Aes));
    localContentValues.put("type", Integer.valueOf(this.type));
    localContentValues.put("createTime", Long.valueOf(this.createTime));
    localContentValues.put("userName", this.userName);
    localContentValues.put("totallen", Integer.valueOf(this.Aet));
    localContentValues.put("offset", Integer.valueOf(this.offset));
    localContentValues.put("local_flag", Integer.valueOf(this.jfR));
    localContentValues.put("tmp_path", this.Aeu);
    localContentValues.put("nums", Integer.valueOf(this.Aev));
    localContentValues.put("try_times", Long.valueOf(this.Aew));
    localContentValues.put("StrId", this.Aex);
    localContentValues.put("upload_buf", this.Aey);
    AppMethodBeat.o(97595);
    return localContentValues;
  }
  
  public final void ecN()
  {
    this.jfR |= 0x4;
  }
  
  public final void ecO()
  {
    this.jfR &= 0xFFFFFFFB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.t
 * JD-Core Version:    0.7.0.1
 */