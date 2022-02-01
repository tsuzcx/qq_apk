package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.el;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends el
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(114644);
    c.a locala = new c.a();
    locala.IBL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "memberUuid";
    locala.IBN.put("memberUuid", "LONG");
    localStringBuilder.append(" memberUuid LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "wxGroupId";
    locala.IBN.put("wxGroupId", "TEXT");
    localStringBuilder.append(" wxGroupId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "userName";
    locala.IBN.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "inviteUserName";
    locala.IBN.put("inviteUserName", "TEXT");
    localStringBuilder.append(" inviteUserName TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "memberId";
    locala.IBN.put("memberId", "LONG");
    localStringBuilder.append(" memberId LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "status";
    locala.IBN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "createTime";
    locala.IBN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(114644);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.b
 * JD-Core Version:    0.7.0.1
 */