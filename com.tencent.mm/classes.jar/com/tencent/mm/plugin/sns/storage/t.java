package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.q;

public final class t
{
  long createTime;
  private int iJP;
  public int offset;
  public int type;
  private String userName;
  private long yvY;
  public int yvZ;
  public int yvp;
  public String ywa;
  private int ywb;
  private long ywc;
  public String ywd;
  public byte[] ywe;
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97596);
    this.yvp = paramCursor.getInt(0);
    long l = paramCursor.getLong(1);
    this.yvY = l;
    this.ywd = q.wW(l);
    this.type = paramCursor.getInt(2);
    this.createTime = paramCursor.getLong(3);
    this.userName = paramCursor.getString(4);
    this.yvZ = paramCursor.getInt(5);
    this.offset = paramCursor.getInt(6);
    this.iJP = paramCursor.getInt(7);
    this.ywa = paramCursor.getString(8);
    this.ywb = paramCursor.getInt(9);
    this.ywc = paramCursor.getLong(10);
    this.ywd = paramCursor.getString(11);
    this.ywe = paramCursor.getBlob(12);
    AppMethodBeat.o(97596);
  }
  
  public final ContentValues dMS()
  {
    AppMethodBeat.i(97595);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("seqId", Long.valueOf(this.yvY));
    localContentValues.put("type", Integer.valueOf(this.type));
    localContentValues.put("createTime", Long.valueOf(this.createTime));
    localContentValues.put("userName", this.userName);
    localContentValues.put("totallen", Integer.valueOf(this.yvZ));
    localContentValues.put("offset", Integer.valueOf(this.offset));
    localContentValues.put("local_flag", Integer.valueOf(this.iJP));
    localContentValues.put("tmp_path", this.ywa);
    localContentValues.put("nums", Integer.valueOf(this.ywb));
    localContentValues.put("try_times", Long.valueOf(this.ywc));
    localContentValues.put("StrId", this.ywd);
    localContentValues.put("upload_buf", this.ywe);
    AppMethodBeat.o(97595);
    return localContentValues;
  }
  
  public final void dMT()
  {
    this.iJP |= 0x4;
  }
  
  public final void dMU()
  {
    this.iJP &= 0xFFFFFFFB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.t
 * JD-Core Version:    0.7.0.1
 */