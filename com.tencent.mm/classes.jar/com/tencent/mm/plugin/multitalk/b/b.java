package com.tencent.mm.plugin.multitalk.b;

import com.tencent.mm.h.c.cu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends cu
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "memberUuid";
    locala.ujN.put("memberUuid", "LONG");
    localStringBuilder.append(" memberUuid LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "wxGroupId";
    locala.ujN.put("wxGroupId", "TEXT");
    localStringBuilder.append(" wxGroupId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "userName";
    locala.ujN.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "inviteUserName";
    locala.ujN.put("inviteUserName", "TEXT");
    localStringBuilder.append(" inviteUserName TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "memberId";
    locala.ujN.put("memberId", "LONG");
    localStringBuilder.append(" memberId LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "status";
    locala.ujN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "createTime";
    locala.ujN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.b
 * JD-Core Version:    0.7.0.1
 */