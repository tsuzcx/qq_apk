package com.tencent.mm.plugin.p.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.sdk.sql.ColumnOrder;
import com.tencent.mm.sdk.sql.ISqlCondition;
import com.tencent.mm.sdk.sql.ISqlOrder;
import com.tencent.mm.sdk.sql.Sql.BitAndEqual;
import com.tencent.mm.sdk.sql.Sql.BitAndNotEqual;
import com.tencent.mm.storage.as;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/contact/ContactLiveStorage$Companion;", "", "()V", "ALL_KEY", "", "MAX_ASCII", "", "TAG", "THREAD_TAG", "calculateContactShowHead", "displayName", "getNormalContactCondition", "Lcom/tencent/mm/sdk/sql/ISqlCondition;", "getShowHeadOrder", "", "Lcom/tencent/mm/sdk/sql/ISqlOrder;", "plugin-livestorage_release"})
public final class a$a
{
  public static char aNg(String paramString)
  {
    AppMethodBeat.i(254369);
    p.k(paramString, "displayName");
    paramString = paramString.toCharArray();
    p.j(paramString, "(this as java.lang.String).toCharArray()");
    paramString = e.c(paramString);
    char c1;
    if (paramString != null)
    {
      c1 = paramString.charValue();
      if ('a' <= c1) {
        break label72;
      }
      label42:
      if ('A' <= c1)
      {
        c2 = c1;
        if ('Z' >= c1) {
          break label59;
        }
      }
    }
    for (char c2 = '{';; c2 = (char)(c1 - ' '))
    {
      label59:
      AppMethodBeat.o(254369);
      return c2;
      c1 = ' ';
      break;
      label72:
      if ('z' < c1) {
        break label42;
      }
    }
  }
  
  public static List<ISqlOrder> eLW()
  {
    AppMethodBeat.i(292920);
    List localList = j.listOf(new ISqlOrder[] { (ISqlOrder)new ColumnOrder("showHead", false, 2, null), (ISqlOrder)new a.a.a() });
    AppMethodBeat.o(292920);
    return localList;
  }
  
  public static ISqlCondition eLX()
  {
    AppMethodBeat.i(292921);
    ISqlCondition localISqlCondition = new Sql.BitAndNotEqual("type", d.axN(), 0).and((ISqlCondition)new Sql.BitAndEqual("type", d.axY(), 0)).and((ISqlCondition)new Sql.BitAndEqual("type", d.axO(), 0)).and((ISqlCondition)new Sql.BitAndEqual("verifyFlag", as.hya(), 0));
    AppMethodBeat.o(292921);
    return localISqlCondition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.p.a.a.a
 * JD-Core Version:    0.7.0.1
 */