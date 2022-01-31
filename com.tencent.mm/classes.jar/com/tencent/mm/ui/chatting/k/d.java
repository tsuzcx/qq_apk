package com.tencent.mm.ui.chatting.k;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e.d.b;
import java.util.List;

public final class d
  implements e<bi>
{
  private Cursor JM;
  private String drJ;
  private long vzJ;
  private long vzK;
  
  public d(String paramString, long paramLong1, long paramLong2)
  {
    this.drJ = paramString;
    this.vzJ = paramLong1;
    this.vzK = paramLong2;
  }
  
  public final void a(d.b paramb)
  {
    au.Hx();
    this.JM = c.Fy().s(this.drJ, this.vzJ, this.vzK);
    paramb.cN();
  }
  
  public final int cDk()
  {
    au.Hx();
    return c.Fy().HP(this.drJ);
  }
  
  public final void close()
  {
    this.JM.close();
  }
  
  public final void ei(List<bi> paramList)
  {
    this.JM.moveToFirst();
    while (!this.JM.isAfterLast())
    {
      bi localbi = new bi();
      localbi.d(this.JM);
      paramList.add(localbi);
      this.JM.moveToNext();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.d
 * JD-Core Version:    0.7.0.1
 */