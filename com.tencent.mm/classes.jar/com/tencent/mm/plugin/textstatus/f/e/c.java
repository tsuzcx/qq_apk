package com.tencent.mm.plugin.textstatus.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "name", "", "id", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getItemId", "", "getItemType", "", "plugin-textstatus_release"})
public final class c
  implements a
{
  public final String id;
  public final String name;
  
  public c(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.id = paramString2;
  }
  
  public final int cxn()
  {
    return 0;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(216242);
    long l = hashCode();
    AppMethodBeat.o(216242);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.e.c
 * JD-Core Version:    0.7.0.1
 */