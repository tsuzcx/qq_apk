package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;

public final class r
{
  long createTime;
  private int gwL;
  public int offset;
  public int rCV;
  private long rDA;
  public int rDB;
  public String rDC;
  private int rDD;
  private long rDE;
  public String rDF;
  public byte[] rDG;
  public int type;
  private String userName;
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(37977);
    this.rCV = paramCursor.getInt(0);
    long l = paramCursor.getLong(1);
    this.rDA = l;
    this.rDF = i.lq(l);
    this.type = paramCursor.getInt(2);
    this.createTime = paramCursor.getLong(3);
    this.userName = paramCursor.getString(4);
    this.rDB = paramCursor.getInt(5);
    this.offset = paramCursor.getInt(6);
    this.gwL = paramCursor.getInt(7);
    this.rDC = paramCursor.getString(8);
    this.rDD = paramCursor.getInt(9);
    this.rDE = paramCursor.getLong(10);
    this.rDF = paramCursor.getString(11);
    this.rDG = paramCursor.getBlob(12);
    AppMethodBeat.o(37977);
  }
  
  public final ContentValues ctc()
  {
    AppMethodBeat.i(37976);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("seqId", Long.valueOf(this.rDA));
    localContentValues.put("type", Integer.valueOf(this.type));
    localContentValues.put("createTime", Long.valueOf(this.createTime));
    localContentValues.put("userName", this.userName);
    localContentValues.put("totallen", Integer.valueOf(this.rDB));
    localContentValues.put("offset", Integer.valueOf(this.offset));
    localContentValues.put("local_flag", Integer.valueOf(this.gwL));
    localContentValues.put("tmp_path", this.rDC);
    localContentValues.put("nums", Integer.valueOf(this.rDD));
    localContentValues.put("try_times", Long.valueOf(this.rDE));
    localContentValues.put("StrId", this.rDF);
    localContentValues.put("upload_buf", this.rDG);
    AppMethodBeat.o(37976);
    return localContentValues;
  }
  
  public final void ctd()
  {
    this.gwL |= 0x4;
  }
  
  public final void cte()
  {
    this.gwL &= 0xFFFFFFFB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.r
 * JD-Core Version:    0.7.0.1
 */