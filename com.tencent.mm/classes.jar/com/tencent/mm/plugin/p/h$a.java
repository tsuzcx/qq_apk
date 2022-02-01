package com.tencent.mm.plugin.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/MMLiveStorage$Companion;", "", "()V", "TAG", "", "getDbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "T", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "item", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem;)Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-livestorage_release"})
public final class h$a
{
  public static <T extends IAutoDBItem> IAutoDBItem.MAutoDBInfo a(T paramT)
  {
    AppMethodBeat.i(254531);
    p.k(paramT, "item");
    paramT = paramT.getDBInfo();
    CharSequence localCharSequence = (CharSequence)paramT.primaryKey;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramT.primaryKey = "rowid";
      }
      p.j(paramT, "item.dbInfo.also {\n     …          }\n            }");
      AppMethodBeat.o(254531);
      return paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.p.h.a
 * JD-Core Version:    0.7.0.1
 */