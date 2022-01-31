package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.sns.data.i;

public final class r
{
  long createTime;
  private int ffd;
  private long oLP;
  public int oLQ;
  public String oLR;
  private int oLS;
  private long oLT;
  public String oLU;
  public byte[] oLV;
  public int oLk;
  public int offset;
  public int type;
  private String userName;
  
  public final ContentValues bGY()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("seqId", Long.valueOf(this.oLP));
    localContentValues.put("type", Integer.valueOf(this.type));
    localContentValues.put("createTime", Long.valueOf(this.createTime));
    localContentValues.put("userName", this.userName);
    localContentValues.put("totallen", Integer.valueOf(this.oLQ));
    localContentValues.put("offset", Integer.valueOf(this.offset));
    localContentValues.put("local_flag", Integer.valueOf(this.ffd));
    localContentValues.put("tmp_path", this.oLR);
    localContentValues.put("nums", Integer.valueOf(this.oLS));
    localContentValues.put("try_times", Long.valueOf(this.oLT));
    localContentValues.put("StrId", this.oLU);
    localContentValues.put("upload_buf", this.oLV);
    return localContentValues;
  }
  
  public final void bGZ()
  {
    this.ffd |= 0x4;
  }
  
  public final void bHa()
  {
    this.ffd &= 0xFFFFFFFB;
  }
  
  public final void d(Cursor paramCursor)
  {
    this.oLk = paramCursor.getInt(0);
    long l = paramCursor.getLong(1);
    this.oLP = l;
    this.oLU = i.fN(l);
    this.type = paramCursor.getInt(2);
    this.createTime = paramCursor.getLong(3);
    this.userName = paramCursor.getString(4);
    this.oLQ = paramCursor.getInt(5);
    this.offset = paramCursor.getInt(6);
    this.ffd = paramCursor.getInt(7);
    this.oLR = paramCursor.getString(8);
    this.oLS = paramCursor.getInt(9);
    this.oLT = paramCursor.getLong(10);
    this.oLU = paramCursor.getString(11);
    this.oLV = paramCursor.getBlob(12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.r
 * JD-Core Version:    0.7.0.1
 */