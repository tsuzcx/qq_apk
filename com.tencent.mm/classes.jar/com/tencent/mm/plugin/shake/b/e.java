package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends i<d>
{
  public static final String[] dXp = { i.a(d.buS, "shakeitem1") };
  public com.tencent.mm.sdk.e.e dXw;
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, d.buS, "shakeitem1", null);
    this.dXw = parame;
    y.d("MicroMsg.NewShakeItemStorage", "ShakeItemStorage");
    parame.gk("shakeitem1", "DROP INDEX IF EXISTS shakeItemUsernameIndex ");
    parame.gk("shakeitem1", "CREATE INDEX IF NOT EXISTS shakeItemNewUsernameIndex ON shakeitem1 ( username )");
  }
  
  public final int Mu(String paramString)
  {
    int i = this.dXw.delete("shakeitem1", "(username=?)", new String[] { paramString });
    if (i > 0) {
      doNotify();
    }
    y.i("MicroMsg.NewShakeItemStorage", "delByusername:" + paramString + " result:" + i);
    return i;
  }
  
  public final boolean a(d paramd, boolean paramBoolean)
  {
    if (paramd == null) {
      return false;
    }
    if ((!paramBoolean) && (!bk.bl(paramd.field_username))) {
      Mu(paramd.field_username);
    }
    paramd.bcw = -1;
    return super.b(paramd);
  }
  
  public final Cursor bzJ()
  {
    return rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by shakeItemID desc ", new String[] { "4" });
  }
  
  public final d bzK()
  {
    d locald = new d();
    Cursor localCursor = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc limit 1", new String[0]);
    if (localCursor.getCount() != 0)
    {
      localCursor.moveToFirst();
      locald.d(localCursor);
    }
    localCursor.close();
    return locald;
  }
  
  public final boolean bzL()
  {
    boolean bool = this.dXw.gk("shakeitem1", "delete from shakeitem1");
    doNotify();
    return bool;
  }
  
  public final void bzM()
  {
    y.i("MicroMsg.NewShakeItemStorage", "setAllOld");
    d locald = new d();
    locald.field_insertBatch = 0;
    locald.bcw = 1024;
    if (-1 != this.dXw.update("shakeitem1", locald.vf(), "insertBatch!=?", new String[] { "0" })) {
      doNotify();
    }
  }
  
  public final int xj(int paramInt)
  {
    int i = this.dXw.delete("shakeitem1", "shakeItemID=?", new String[] { String.valueOf(paramInt) });
    doNotify();
    y.i("MicroMsg.NewShakeItemStorage", "delById id:" + paramInt + " result:" + i);
    return i;
  }
  
  public final boolean xk(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = this.dXw.gk("shakeitem1", "delete from shakeitem1 where type = " + paramInt + " or type is null");; bool = this.dXw.gk("shakeitem1", "delete from shakeitem1 where type = " + paramInt))
    {
      doNotify();
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.e
 * JD-Core Version:    0.7.0.1
 */