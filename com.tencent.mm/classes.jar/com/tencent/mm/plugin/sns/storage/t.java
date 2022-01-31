package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.h.c.eg;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class t
  extends eg
{
  protected static c.a buS;
  public int oLW;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "tagId";
    locala.ujN.put("tagId", "LONG default '0' ");
    localStringBuilder.append(" tagId LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "tagName";
    locala.ujN.put("tagName", "TEXT default '' ");
    localStringBuilder.append(" tagName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "count";
    locala.ujN.put("count", "INTEGER default '0' ");
    localStringBuilder.append(" count INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "memberList";
    locala.ujN.put("memberList", "TEXT default '' ");
    localStringBuilder.append(" memberList TEXT default '' ");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final void cD(List<bml> paramList)
  {
    this.field_memberList = "";
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bml localbml = (bml)paramList.next();
      this.field_memberList = (this.field_memberList + localbml.tFO + ",");
    }
  }
  
  public final void d(Cursor paramCursor)
  {
    super.d(paramCursor);
    this.oLW = ((int)this.ujK);
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.t
 * JD-Core Version:    0.7.0.1
 */