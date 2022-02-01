package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends eb
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(114644);
    c.a locala = new c.a();
    locala.GvF = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "memberUuid";
    locala.GvH.put("memberUuid", "LONG");
    localStringBuilder.append(" memberUuid LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "wxGroupId";
    locala.GvH.put("wxGroupId", "TEXT");
    localStringBuilder.append(" wxGroupId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "userName";
    locala.GvH.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "inviteUserName";
    locala.GvH.put("inviteUserName", "TEXT");
    localStringBuilder.append(" inviteUserName TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "memberId";
    locala.GvH.put("memberId", "LONG");
    localStringBuilder.append(" memberId LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "status";
    locala.GvH.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "createTime";
    locala.GvH.put("createTime", "LONG");
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
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.b
 * JD-Core Version:    0.7.0.1
 */