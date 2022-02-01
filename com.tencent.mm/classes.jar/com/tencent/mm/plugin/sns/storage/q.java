package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;

public final class q
{
  private long EmL;
  public int EmM;
  public String EmN;
  private int EmO;
  private long EmP;
  public String EmQ;
  public byte[] EmR;
  long createTime;
  private int kdU;
  public int localid;
  public int offset;
  public int type;
  private String userName;
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97596);
    this.localid = paramCursor.getInt(0);
    long l = paramCursor.getLong(1);
    this.EmL = l;
    this.EmQ = r.Jb(l);
    this.type = paramCursor.getInt(2);
    this.createTime = paramCursor.getLong(3);
    this.userName = paramCursor.getString(4);
    this.EmM = paramCursor.getInt(5);
    this.offset = paramCursor.getInt(6);
    this.kdU = paramCursor.getInt(7);
    this.EmN = paramCursor.getString(8);
    this.EmO = paramCursor.getInt(9);
    this.EmP = paramCursor.getLong(10);
    this.EmQ = paramCursor.getString(11);
    this.EmR = paramCursor.getBlob(12);
    AppMethodBeat.o(97596);
  }
  
  public final ContentValues feY()
  {
    AppMethodBeat.i(97595);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("seqId", Long.valueOf(this.EmL));
    localContentValues.put("type", Integer.valueOf(this.type));
    localContentValues.put("createTime", Long.valueOf(this.createTime));
    localContentValues.put("userName", this.userName);
    localContentValues.put("totallen", Integer.valueOf(this.EmM));
    localContentValues.put("offset", Integer.valueOf(this.offset));
    localContentValues.put("local_flag", Integer.valueOf(this.kdU));
    localContentValues.put("tmp_path", this.EmN);
    localContentValues.put("nums", Integer.valueOf(this.EmO));
    localContentValues.put("try_times", Long.valueOf(this.EmP));
    localContentValues.put("StrId", this.EmQ);
    localContentValues.put("upload_buf", this.EmR);
    AppMethodBeat.o(97595);
    return localContentValues;
  }
  
  public final void feZ()
  {
    this.kdU |= 0x4;
  }
  
  public final void ffa()
  {
    this.kdU &= 0xFFFFFFFB;
  }
  
  public final String ffb()
  {
    return this.EmN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.q
 * JD-Core Version:    0.7.0.1
 */