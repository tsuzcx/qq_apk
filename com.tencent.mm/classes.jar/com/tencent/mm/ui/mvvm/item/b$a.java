package com.tencent.mm.ui.mvvm.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem$Companion;", "", "()V", "FAV", "", "NORMAL", "RECOMMEND_CHATROOM", "RECOMMEND_CONTACT", "SEARCH", "SEARCH_MORE", "genUniqueId", "", "username", "type", "keywordIndex", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
{
  public static String bg(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250528);
    s.u(paramString, "username");
    paramString = paramString + '-' + paramInt1 + '-' + paramInt2;
    AppMethodBeat.o(250528);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.item.b.a
 * JD-Core Version:    0.7.0.1
 */