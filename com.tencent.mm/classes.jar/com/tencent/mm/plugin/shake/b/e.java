package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
  extends j<d>
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(28127);
    SQL_CREATE = new String[] { j.getCreateSQLs(d.info, "shakeitem1") };
    AppMethodBeat.o(28127);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, d.info, "shakeitem1", null);
    AppMethodBeat.i(28109);
    this.db = parame;
    ad.d("MicroMsg.NewShakeItemStorage", "ShakeItemStorage");
    parame.execSQL("shakeitem1", "DROP INDEX IF EXISTS shakeItemUsernameIndex ");
    parame.execSQL("shakeitem1", "CREATE INDEX IF NOT EXISTS shakeItemNewUsernameIndex ON shakeitem1 ( username )");
    AppMethodBeat.o(28109);
  }
  
  public final Cursor Pj(int paramInt)
  {
    AppMethodBeat.i(28117);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc limit ? ", new String[] { "11", String.valueOf(paramInt) });
    AppMethodBeat.o(28117);
    return localCursor;
  }
  
  public final int Pk(int paramInt)
  {
    AppMethodBeat.i(28121);
    int i = this.db.delete("shakeitem1", "shakeItemID=?", new String[] { String.valueOf(paramInt) });
    doNotify();
    ad.i("MicroMsg.NewShakeItemStorage", "delById id:" + paramInt + " result:" + i);
    AppMethodBeat.o(28121);
    return i;
  }
  
  public final boolean Pl(int paramInt)
  {
    AppMethodBeat.i(28123);
    if (paramInt == 0) {}
    for (boolean bool = this.db.execSQL("shakeitem1", "delete from shakeitem1 where type = " + paramInt + " or type is null");; bool = this.db.execSQL("shakeitem1", "delete from shakeitem1 where type = ".concat(String.valueOf(paramInt))))
    {
      doNotify();
      AppMethodBeat.o(28123);
      return bool;
    }
  }
  
  public final boolean a(d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(28120);
    if (paramd == null)
    {
      AppMethodBeat.o(28120);
      return false;
    }
    if ((!paramBoolean) && (!bt.isNullOrNil(paramd.field_username))) {
      axj(paramd.field_username);
    }
    paramd.dDp = -1;
    paramBoolean = super.insert(paramd);
    AppMethodBeat.o(28120);
    return paramBoolean;
  }
  
  public final int axj(String paramString)
  {
    AppMethodBeat.i(28122);
    int i = this.db.delete("shakeitem1", "(username=?)", new String[] { String.valueOf(paramString) });
    if (i > 0) {
      doNotify();
    }
    ad.i("MicroMsg.NewShakeItemStorage", "delByusername:" + paramString + " result:" + i);
    AppMethodBeat.o(28122);
    return i;
  }
  
  public final Cursor dOA()
  {
    AppMethodBeat.i(28116);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", new String[] { "8", "2" });
    AppMethodBeat.o(28116);
    return localCursor;
  }
  
  public final Cursor dOB()
  {
    AppMethodBeat.i(28118);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", new String[] { "11" });
    AppMethodBeat.o(28118);
    return localCursor;
  }
  
  public final d dOC()
  {
    AppMethodBeat.i(28119);
    d locald = new d();
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc limit 1", new String[0]);
    if (localCursor.getCount() != 0)
    {
      localCursor.moveToFirst();
      locald.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(28119);
    return locald;
  }
  
  public final boolean dOD()
  {
    AppMethodBeat.i(28124);
    boolean bool = this.db.execSQL("shakeitem1", "delete from shakeitem1");
    doNotify();
    AppMethodBeat.o(28124);
    return bool;
  }
  
  public final void dOE()
  {
    AppMethodBeat.i(28125);
    ad.i("MicroMsg.NewShakeItemStorage", "setAllOld");
    d locald = new d();
    locald.field_insertBatch = 0;
    locald.dDp = 1024;
    if (-1 != this.db.update("shakeitem1", locald.convertTo(), "insertBatch!=?", new String[] { "0" })) {
      doNotify();
    }
    AppMethodBeat.o(28125);
  }
  
  public final Cursor dOu()
  {
    AppMethodBeat.i(28110);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc ", new String[0]);
    AppMethodBeat.o(28110);
    return localCursor;
  }
  
  public final Cursor dOv()
  {
    AppMethodBeat.i(28111);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by reserved2 desc, shakeItemID desc ", new String[] { "0", "2" });
    AppMethodBeat.o(28111);
    return localCursor;
  }
  
  public final Cursor dOw()
  {
    AppMethodBeat.i(28112);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", new String[] { "0" });
    AppMethodBeat.o(28112);
    return localCursor;
  }
  
  public final Cursor dOx()
  {
    AppMethodBeat.i(28113);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by shakeItemID desc ", new String[] { "4" });
    AppMethodBeat.o(28113);
    return localCursor;
  }
  
  public final Cursor dOy()
  {
    AppMethodBeat.i(28114);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", new String[] { "4", "2" });
    AppMethodBeat.o(28114);
    return localCursor;
  }
  
  public final Cursor dOz()
  {
    AppMethodBeat.i(28115);
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type in (?, ?, ?, ?, ?) order by shakeItemID desc ", new String[] { "7", "6", "8", "9", "10", "12" });
    AppMethodBeat.o(28115);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.e
 * JD-Core Version:    0.7.0.1
 */