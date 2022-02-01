package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.q;

public final class t
{
  long createTime;
  private int ijI;
  public int offset;
  public int type;
  private String userName;
  public int xiB;
  private long xjh;
  public int xji;
  public String xjj;
  private int xjk;
  private long xjl;
  public String xjm;
  public byte[] xjn;
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97596);
    this.xiB = paramCursor.getInt(0);
    long l = paramCursor.getLong(1);
    this.xjh = l;
    this.xjm = q.st(l);
    this.type = paramCursor.getInt(2);
    this.createTime = paramCursor.getLong(3);
    this.userName = paramCursor.getString(4);
    this.xji = paramCursor.getInt(5);
    this.offset = paramCursor.getInt(6);
    this.ijI = paramCursor.getInt(7);
    this.xjj = paramCursor.getString(8);
    this.xjk = paramCursor.getInt(9);
    this.xjl = paramCursor.getLong(10);
    this.xjm = paramCursor.getString(11);
    this.xjn = paramCursor.getBlob(12);
    AppMethodBeat.o(97596);
  }
  
  public final ContentValues dyv()
  {
    AppMethodBeat.i(97595);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("seqId", Long.valueOf(this.xjh));
    localContentValues.put("type", Integer.valueOf(this.type));
    localContentValues.put("createTime", Long.valueOf(this.createTime));
    localContentValues.put("userName", this.userName);
    localContentValues.put("totallen", Integer.valueOf(this.xji));
    localContentValues.put("offset", Integer.valueOf(this.offset));
    localContentValues.put("local_flag", Integer.valueOf(this.ijI));
    localContentValues.put("tmp_path", this.xjj);
    localContentValues.put("nums", Integer.valueOf(this.xjk));
    localContentValues.put("try_times", Long.valueOf(this.xjl));
    localContentValues.put("StrId", this.xjm);
    localContentValues.put("upload_buf", this.xjn);
    AppMethodBeat.o(97595);
    return localContentValues;
  }
  
  public final void dyw()
  {
    this.ijI |= 0x4;
  }
  
  public final void dyx()
  {
    this.ijI &= 0xFFFFFFFB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.t
 * JD-Core Version:    0.7.0.1
 */