package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.protocal.protobuf.dnf;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c
  extends eo
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(127270);
    c.a locala = new c.a();
    locala.IhA = new Field[19];
    locala.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "uniqueId";
    locala.IhC.put("uniqueId", "TEXT");
    localStringBuilder.append(" uniqueId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "path";
    locala.IhC.put("path", "INTEGER");
    localStringBuilder.append(" path INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "showType";
    locala.IhC.put("showType", "INTEGER");
    localStringBuilder.append(" showType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "title";
    locala.IhC.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "icon_url";
    locala.IhC.put("icon_url", "TEXT");
    localStringBuilder.append(" icon_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "parents";
    locala.IhC.put("parents", "BLOB");
    localStringBuilder.append(" parents BLOB");
    localStringBuilder.append(", ");
    locala.columns[6] = "tipId";
    locala.IhC.put("tipId", "INTEGER");
    localStringBuilder.append(" tipId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "priority";
    locala.IhC.put("priority", "INTEGER");
    localStringBuilder.append(" priority INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "tipType";
    locala.IhC.put("tipType", "INTEGER");
    localStringBuilder.append(" tipType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "beginShowTime";
    locala.IhC.put("beginShowTime", "LONG");
    localStringBuilder.append(" beginShowTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "exposureTime";
    locala.IhC.put("exposureTime", "LONG");
    localStringBuilder.append(" exposureTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "overdueTime";
    locala.IhC.put("overdueTime", "LONG");
    localStringBuilder.append(" overdueTime LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "disappearTime";
    locala.IhC.put("disappearTime", "LONG");
    localStringBuilder.append(" disappearTime LONG");
    localStringBuilder.append(", ");
    locala.columns[13] = "exposureDisappearTime";
    locala.IhC.put("exposureDisappearTime", "LONG");
    localStringBuilder.append(" exposureDisappearTime LONG");
    localStringBuilder.append(", ");
    locala.columns[14] = "minClientVersion";
    locala.IhC.put("minClientVersion", "INTEGER");
    localStringBuilder.append(" minClientVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "maxClientVersion";
    locala.IhC.put("maxClientVersion", "INTEGER");
    localStringBuilder.append(" maxClientVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "extInfo";
    locala.IhC.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "state";
    locala.IhC.put("state", "INTEGER default '0' ");
    localStringBuilder.append(" state INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "dynamicPath";
    locala.IhC.put("dynamicPath", "TEXT");
    localStringBuilder.append(" dynamicPath TEXT");
    locala.columns[19] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(127270);
  }
  
  public c() {}
  
  public c(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, int paramInt4, int paramInt5, String paramString2)
  {
    this.field_uniqueId = paramString1;
    this.field_tipId = paramInt1;
    this.field_priority = paramInt2;
    this.field_tipType = paramInt3;
    this.field_beginShowTime = paramLong1;
    this.field_overdueTime = paramLong2;
    this.field_disappearTime = paramLong3;
    this.field_minClientVersion = paramInt4;
    this.field_maxClientVersion = paramInt5;
    this.field_extInfo = paramString2;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(127269);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (this.field_parents != null)
    {
      localObject1 = localObject2;
      if (this.field_parents.fVg != null)
      {
        localObject1 = localObject2;
        if (this.field_parents.fVg.size() > 0)
        {
          localObject1 = new StringBuilder();
          localObject2 = this.field_parents.fVg.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append(",");
          }
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    localObject1 = "NewTipsInfo{field_uniqueId='" + this.field_uniqueId + '\'' + ", field_path='" + this.field_path + '\'' + ", field_showType=" + this.field_showType + ", field_title='" + this.field_title + '\'' + ", field_icon_url='" + this.field_icon_url + '\'' + ", field_parents=" + (String)localObject1 + ", field_tipId=" + this.field_tipId + ", field_priority=" + this.field_priority + ", field_tipType=" + this.field_tipType + ", field_beginShowTime=" + this.field_beginShowTime + ", field_overdueTime=" + this.field_overdueTime + ", field_disappearTime=" + this.field_disappearTime + ", field_minClientVersion=" + this.field_minClientVersion + ", field_maxClientVersion=" + this.field_maxClientVersion + ", field_state=" + this.field_state + ", field_dynamicPath='" + this.field_dynamicPath + '\'' + '}';
    AppMethodBeat.o(127269);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.b.c
 * JD-Core Version:    0.7.0.1
 */