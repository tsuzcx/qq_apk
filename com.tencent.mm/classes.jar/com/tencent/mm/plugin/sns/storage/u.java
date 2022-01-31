package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class u
  extends i<t>
  implements k
{
  public static final String[] dXp = { i.a(t.buS, "snsTagInfo2") };
  private e dXw;
  
  public u(e parame)
  {
    super(parame, t.buS, "snsTagInfo2", null);
    this.dXw = parame;
  }
  
  public final boolean MQ(String paramString)
  {
    t localt = gv(5L);
    if (bk.bl(localt.field_memberList)) {
      return false;
    }
    return bk.G(localt.field_memberList.split(",")).contains(paramString);
  }
  
  public final boolean a(t paramt)
  {
    if (paramt.field_tagId == 0L) {
      return false;
    }
    long l = paramt.field_tagId;
    Cursor localCursor = this.dXw.a("select *, rowid from snsTagInfo2 where tagId = ? ", new String[] { String.valueOf(l) }, 2);
    boolean bool = localCursor.moveToFirst();
    localCursor.close();
    if (!bool) {
      super.b(paramt);
    }
    for (;;)
    {
      return true;
      super.a(paramt);
    }
  }
  
  public final boolean bCo()
  {
    return bHe().size() != 0;
  }
  
  public final List<Long> bHe()
  {
    Cursor localCursor = this.dXw.a("snsTagInfo2", new String[] { "tagId" }, null, null, null, null, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(Long.valueOf(localCursor.getLong(0)));
    }
    localCursor.close();
    return localArrayList;
  }
  
  public final List<String> fL(long paramLong)
  {
    t localt = gv(paramLong);
    if ((localt.field_memberList != null) && (!localt.field_memberList.equals(""))) {
      return bk.G(localt.field_memberList.split(","));
    }
    return new ArrayList();
  }
  
  public final String fM(long paramLong)
  {
    return gv(paramLong).field_tagName;
  }
  
  public final Cursor getCursor()
  {
    return this.dXw.rawQuery("select *, rowid from snsTagInfo2 where tagId > 5", null);
  }
  
  public final t gv(long paramLong)
  {
    Cursor localCursor = this.dXw.a("select *, rowid from snsTagInfo2 where tagId = ? ", new String[] { String.valueOf(paramLong) }, 2);
    t localt = new t();
    if (localCursor.moveToFirst()) {
      localt.d(localCursor);
    }
    localCursor.close();
    return localt;
  }
  
  public final int gw(long paramLong)
  {
    return this.dXw.delete("snsTagInfo2", " tagId = ? ", new String[] { String.valueOf(paramLong) });
  }
  
  public final boolean u(long paramLong, String paramString)
  {
    paramString = "select tagId, tagName, count, rowid from snsTagInfo2 where tagId > 5 AND  tagName  =\"" + bk.pl(paramString) + "\" AND  tagId != " + paramLong;
    y.d("MicroMsg.SnsTagInfoStorage", "isTagNameExist " + paramString);
    paramString = this.dXw.a(paramString, null, 2);
    boolean bool = paramString.moveToFirst();
    paramString.close();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.u
 * JD-Core Version:    0.7.0.1
 */