package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;

public final class q
{
  public byte[] KAa;
  private long KzU;
  public int KzV;
  public String KzW;
  private int KzX;
  private long KzY;
  public String KzZ;
  long createTime;
  public int localid;
  private int mVu;
  public int offset;
  public int type;
  private String userName;
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97596);
    this.localid = paramCursor.getInt(0);
    long l = paramCursor.getLong(1);
    this.KzU = l;
    this.KzZ = t.Qu(l);
    this.type = paramCursor.getInt(2);
    this.createTime = paramCursor.getLong(3);
    this.userName = paramCursor.getString(4);
    this.KzV = paramCursor.getInt(5);
    this.offset = paramCursor.getInt(6);
    this.mVu = paramCursor.getInt(7);
    this.KzW = paramCursor.getString(8);
    this.KzX = paramCursor.getInt(9);
    this.KzY = paramCursor.getLong(10);
    this.KzZ = paramCursor.getString(11);
    this.KAa = paramCursor.getBlob(12);
    AppMethodBeat.o(97596);
  }
  
  public final ContentValues fST()
  {
    AppMethodBeat.i(97595);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("seqId", Long.valueOf(this.KzU));
    localContentValues.put("type", Integer.valueOf(this.type));
    localContentValues.put("createTime", Long.valueOf(this.createTime));
    localContentValues.put("userName", this.userName);
    localContentValues.put("totallen", Integer.valueOf(this.KzV));
    localContentValues.put("offset", Integer.valueOf(this.offset));
    localContentValues.put("local_flag", Integer.valueOf(this.mVu));
    localContentValues.put("tmp_path", this.KzW);
    localContentValues.put("nums", Integer.valueOf(this.KzX));
    localContentValues.put("try_times", Long.valueOf(this.KzY));
    localContentValues.put("StrId", this.KzZ);
    localContentValues.put("upload_buf", this.KAa);
    AppMethodBeat.o(97595);
    return localContentValues;
  }
  
  public final void fSU()
  {
    this.mVu |= 0x4;
  }
  
  public final void fSV()
  {
    this.mVu &= 0xFFFFFFFB;
  }
  
  public final String fSW()
  {
    return this.KzW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.q
 * JD-Core Version:    0.7.0.1
 */