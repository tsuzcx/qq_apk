package com.tencent.mm.plugin.p.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.sql.ISqlOrder;
import com.tencent.mm.sdk.sql.ISqlOrder.DefaultImpls;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/livestorage/contact/ContactLiveStorage$Companion$getShowHeadOrder$1", "Lcom/tencent/mm/sdk/sql/ISqlOrder;", "toSql", "", "plugin-livestorage_release"})
public final class a$a$a
  implements ISqlOrder
{
  public final String[] params()
  {
    AppMethodBeat.i(292919);
    String[] arrayOfString = ISqlOrder.DefaultImpls.params(this);
    AppMethodBeat.o(292919);
    return arrayOfString;
  }
  
  public final String toSql()
  {
    AppMethodBeat.i(292918);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
    ((StringBuffer)localObject).append(" else upper(quanPin) end asc, ");
    ((StringBuffer)localObject).append(" case when length(conRemark) > 0 then upper(conRemark) ");
    ((StringBuffer)localObject).append(" else upper(quanPin) end asc, ");
    ((StringBuffer)localObject).append(" upper(quanPin) asc, ");
    ((StringBuffer)localObject).append(" upper(nickname) asc, ");
    ((StringBuffer)localObject).append(" upper(username) asc ");
    localObject = ((StringBuffer)localObject).toString();
    p.j(localObject, "sb.toString()");
    AppMethodBeat.o(292918);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.p.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */