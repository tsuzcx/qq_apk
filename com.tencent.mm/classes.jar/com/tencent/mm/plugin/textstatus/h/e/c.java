package com.tencent.mm.plugin.textstatus.h.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "name", "", "iconId", "(Ljava/lang/String;Ljava/lang/String;)V", "getIconId", "()Ljava/lang/String;", "getName", "getItemId", "", "getItemType", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements a
{
  public final String iconId;
  public final String name;
  
  public c(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.iconId = paramString2;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(290475);
    long l = hashCode();
    AppMethodBeat.o(290475);
    return l;
  }
  
  public final int bZB()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.e.c
 * JD-Core Version:    0.7.0.1
 */