package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fp;
import com.tencent.mm.protocal.protobuf.fnj;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends fp
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(127270);
    info = fp.aJm();
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
      if (this.field_parents.lPK != null)
      {
        localObject1 = localObject2;
        if (this.field_parents.lPK.size() > 0)
        {
          localObject1 = new StringBuilder();
          localObject2 = this.field_parents.lPK.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append(",");
          }
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    localObject1 = "NewTipsInfo{field_uniqueId='" + this.field_uniqueId + '\'' + ", field_path='" + this.field_path + '\'' + ", field_showType=" + this.field_showType + ", field_title='" + this.field_title + '\'' + ", field_icon_url='" + this.field_icon_url + '\'' + ", field_parents=" + (String)localObject1 + ", field_tipId=" + this.field_tipId + ", field_priority=" + this.field_priority + ", field_tipType=" + this.field_tipType + ", field_beginShowTime=" + this.field_beginShowTime + ", field_overdueTime=" + this.field_overdueTime + ", field_disappearTime=" + this.field_disappearTime + ", field_minClientVersion=" + this.field_minClientVersion + ", field_maxClientVersion=" + this.field_maxClientVersion + ", field_lang=" + this.field_lang + ", field_state=" + this.field_state + ", field_dynamicPath='" + this.field_dynamicPath + '\'' + '}';
    AppMethodBeat.o(127269);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.b.c
 * JD-Core Version:    0.7.0.1
 */