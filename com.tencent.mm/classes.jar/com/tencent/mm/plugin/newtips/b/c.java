package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.fa;
import com.tencent.mm.protocal.protobuf.esa;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c
  extends fa
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(127270);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[19];
    localMAutoDBInfo.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "uniqueId";
    localMAutoDBInfo.colsMap.put("uniqueId", "TEXT");
    localStringBuilder.append(" uniqueId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "path";
    localMAutoDBInfo.colsMap.put("path", "INTEGER");
    localStringBuilder.append(" path INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "showType";
    localMAutoDBInfo.colsMap.put("showType", "INTEGER");
    localStringBuilder.append(" showType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "icon_url";
    localMAutoDBInfo.colsMap.put("icon_url", "TEXT");
    localStringBuilder.append(" icon_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "parents";
    localMAutoDBInfo.colsMap.put("parents", "BLOB");
    localStringBuilder.append(" parents BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "tipId";
    localMAutoDBInfo.colsMap.put("tipId", "INTEGER");
    localStringBuilder.append(" tipId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "priority";
    localMAutoDBInfo.colsMap.put("priority", "INTEGER");
    localStringBuilder.append(" priority INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "tipType";
    localMAutoDBInfo.colsMap.put("tipType", "INTEGER");
    localStringBuilder.append(" tipType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "beginShowTime";
    localMAutoDBInfo.colsMap.put("beginShowTime", "LONG");
    localStringBuilder.append(" beginShowTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "exposureTime";
    localMAutoDBInfo.colsMap.put("exposureTime", "LONG");
    localStringBuilder.append(" exposureTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "overdueTime";
    localMAutoDBInfo.colsMap.put("overdueTime", "LONG");
    localStringBuilder.append(" overdueTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "disappearTime";
    localMAutoDBInfo.colsMap.put("disappearTime", "LONG");
    localStringBuilder.append(" disappearTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "exposureDisappearTime";
    localMAutoDBInfo.colsMap.put("exposureDisappearTime", "LONG");
    localStringBuilder.append(" exposureDisappearTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "minClientVersion";
    localMAutoDBInfo.colsMap.put("minClientVersion", "INTEGER");
    localStringBuilder.append(" minClientVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "maxClientVersion";
    localMAutoDBInfo.colsMap.put("maxClientVersion", "INTEGER");
    localStringBuilder.append(" maxClientVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "extInfo";
    localMAutoDBInfo.colsMap.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER default '0' ");
    localStringBuilder.append(" state INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "dynamicPath";
    localMAutoDBInfo.colsMap.put("dynamicPath", "TEXT");
    localStringBuilder.append(" dynamicPath TEXT");
    localMAutoDBInfo.columns[19] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
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
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
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
      if (this.field_parents.jmy != null)
      {
        localObject1 = localObject2;
        if (this.field_parents.jmy.size() > 0)
        {
          localObject1 = new StringBuilder();
          localObject2 = this.field_parents.jmy.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.b.c
 * JD-Core Version:    0.7.0.1
 */