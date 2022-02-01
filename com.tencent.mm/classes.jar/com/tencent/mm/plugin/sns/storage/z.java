package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;

public final class z
{
  public String Oxm;
  private long QZr;
  public int QZs;
  private int QZt;
  private long QZu;
  public byte[] QZv;
  long createTime;
  public int localid;
  public int offset;
  private int pSb;
  public String strId;
  public int type;
  private String userName;
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97596);
    this.localid = paramCursor.getInt(0);
    long l = paramCursor.getLong(1);
    this.QZr = l;
    this.strId = t.uA(l);
    this.type = paramCursor.getInt(2);
    this.createTime = paramCursor.getLong(3);
    this.userName = paramCursor.getString(4);
    this.QZs = paramCursor.getInt(5);
    this.offset = paramCursor.getInt(6);
    this.pSb = paramCursor.getInt(7);
    this.Oxm = paramCursor.getString(8);
    this.QZt = paramCursor.getInt(9);
    this.QZu = paramCursor.getLong(10);
    this.strId = paramCursor.getString(11);
    this.QZv = paramCursor.getBlob(12);
    AppMethodBeat.o(97596);
  }
  
  public final ContentValues hlf()
  {
    AppMethodBeat.i(97595);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("seqId", Long.valueOf(this.QZr));
    localContentValues.put("type", Integer.valueOf(this.type));
    localContentValues.put("createTime", Long.valueOf(this.createTime));
    localContentValues.put("userName", this.userName);
    localContentValues.put("totallen", Integer.valueOf(this.QZs));
    localContentValues.put("offset", Integer.valueOf(this.offset));
    localContentValues.put("local_flag", Integer.valueOf(this.pSb));
    localContentValues.put("tmp_path", this.Oxm);
    localContentValues.put("nums", Integer.valueOf(this.QZt));
    localContentValues.put("try_times", Long.valueOf(this.QZu));
    localContentValues.put("StrId", this.strId);
    localContentValues.put("upload_buf", this.QZv);
    AppMethodBeat.o(97595);
    return localContentValues;
  }
  
  public final void hlg()
  {
    this.pSb |= 0x4;
  }
  
  public final void hlh()
  {
    this.pSb &= 0xFFFFFFFB;
  }
  
  public final String hli()
  {
    return this.Oxm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.z
 * JD-Core Version:    0.7.0.1
 */