package com.tencent.mm.plugin.music.model.e;

import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class d
  extends i<c>
{
  public e dXw;
  public f<String, c> mAr;
  
  public d(e parame)
  {
    super(parame, c.buS, "PieceMusicInfo", null);
    this.dXw = parame;
    this.mAr = new f(20);
  }
  
  public final c JF(String paramString)
  {
    if (this.mAr.get(paramString) != null) {
      return (c)this.mAr.get(paramString);
    }
    Object localObject = String.format("Select * From PieceMusicInfo Where musicId=?", new Object[0]);
    localObject = this.dXw.a((String)localObject, new String[] { paramString }, 2);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
    {
      c localc = new c();
      localc.d((Cursor)localObject);
      ((Cursor)localObject).close();
      this.mAr.put(paramString, localc);
      return localc;
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.d
 * JD-Core Version:    0.7.0.1
 */