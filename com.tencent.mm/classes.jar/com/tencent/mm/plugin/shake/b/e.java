package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
  extends j<d>
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(24452);
    SQL_CREATE = new String[] { j.getCreateSQLs(d.info, "shakeitem1") };
    AppMethodBeat.o(24452);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, d.info, "shakeitem1", null);
    AppMethodBeat.i(24434);
    this.db = parame;
    ab.d("MicroMsg.NewShakeItemStorage", "ShakeItemStorage");
    parame.execSQL("shakeitem1", "DROP INDEX IF EXISTS shakeItemUsernameIndex ");
    parame.execSQL("shakeitem1", "CREATE INDEX IF NOT EXISTS shakeItemNewUsernameIndex ON shakeitem1 ( username )");
    AppMethodBeat.o(24434);
  }
  
  public final Cursor Dh(int paramInt)
  {
    AppMethodBeat.i(24442);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc limit ? ", new String[] { "11", String.valueOf(paramInt) });
    AppMethodBeat.o(24442);
    return localCursor;
  }
  
  public final int Di(int paramInt)
  {
    AppMethodBeat.i(24446);
    int i = this.db.delete("shakeitem1", "shakeItemID=?", new String[] { String.valueOf(paramInt) });
    doNotify();
    ab.i("MicroMsg.NewShakeItemStorage", "delById id:" + paramInt + " result:" + i);
    AppMethodBeat.o(24446);
    return i;
  }
  
  public final boolean Dj(int paramInt)
  {
    AppMethodBeat.i(24448);
    if (paramInt == 0) {}
    for (boolean bool = this.db.execSQL("shakeitem1", "delete from shakeitem1 where type = " + paramInt + " or type is null");; bool = this.db.execSQL("shakeitem1", "delete from shakeitem1 where type = ".concat(String.valueOf(paramInt))))
    {
      doNotify();
      AppMethodBeat.o(24448);
      return bool;
    }
  }
  
  public final int Za(String paramString)
  {
    AppMethodBeat.i(24447);
    int i = this.db.delete("shakeitem1", "(username=?)", new String[] { String.valueOf(paramString) });
    if (i > 0) {
      doNotify();
    }
    ab.i("MicroMsg.NewShakeItemStorage", "delByusername:" + paramString + " result:" + i);
    AppMethodBeat.o(24447);
    return i;
  }
  
  public final boolean a(d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(24445);
    if (paramd == null)
    {
      AppMethodBeat.o(24445);
      return false;
    }
    if ((!paramBoolean) && (!bo.isNullOrNil(paramd.field_username))) {
      Za(paramd.field_username);
    }
    paramd.bsY = -1;
    paramBoolean = super.insert(paramd);
    AppMethodBeat.o(24445);
    return paramBoolean;
  }
  
  public final Cursor ckT()
  {
    AppMethodBeat.i(24435);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc ", new String[0]);
    AppMethodBeat.o(24435);
    return localCursor;
  }
  
  public final Cursor ckU()
  {
    AppMethodBeat.i(24436);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by reserved2 desc, shakeItemID desc ", new String[] { "0", "2" });
    AppMethodBeat.o(24436);
    return localCursor;
  }
  
  public final Cursor ckV()
  {
    AppMethodBeat.i(24437);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", new String[] { "0" });
    AppMethodBeat.o(24437);
    return localCursor;
  }
  
  public final Cursor ckW()
  {
    AppMethodBeat.i(24438);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by shakeItemID desc ", new String[] { "4" });
    AppMethodBeat.o(24438);
    return localCursor;
  }
  
  public final Cursor ckX()
  {
    AppMethodBeat.i(24439);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", new String[] { "4", "2" });
    AppMethodBeat.o(24439);
    return localCursor;
  }
  
  public final Cursor ckY()
  {
    AppMethodBeat.i(24440);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type in (?, ?, ?, ?, ?) order by shakeItemID desc ", new String[] { "7", "6", "8", "9", "10", "12" });
    AppMethodBeat.o(24440);
    return localCursor;
  }
  
  public final Cursor ckZ()
  {
    AppMethodBeat.i(24441);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", new String[] { "8", "2" });
    AppMethodBeat.o(24441);
    return localCursor;
  }
  
  public final Cursor cla()
  {
    AppMethodBeat.i(24443);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", new String[] { "11" });
    AppMethodBeat.o(24443);
    return localCursor;
  }
  
  public final d clb()
  {
    AppMethodBeat.i(24444);
    d locald = new d();
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc limit 1", new String[0]);
    if (localCursor.getCount() != 0)
    {
      localCursor.moveToFirst();
      locald.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(24444);
    return locald;
  }
  
  public final boolean clc()
  {
    AppMethodBeat.i(24449);
    boolean bool = this.db.execSQL("shakeitem1", "delete from shakeitem1");
    doNotify();
    AppMethodBeat.o(24449);
    return bool;
  }
  
  public final void cld()
  {
    AppMethodBeat.i(24450);
    ab.i("MicroMsg.NewShakeItemStorage", "setAllOld");
    d locald = new d();
    locald.field_insertBatch = 0;
    locald.bsY = 1024;
    if (-1 != this.db.update("shakeitem1", locald.convertTo(), "insertBatch!=?", new String[] { "0" })) {
      doNotify();
    }
    AppMethodBeat.o(24450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.e
 * JD-Core Version:    0.7.0.1
 */