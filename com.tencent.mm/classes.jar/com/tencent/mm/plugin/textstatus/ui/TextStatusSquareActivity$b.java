package com.tencent.mm.plugin.textstatus.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.d;
import com.tencent.mm.view.recyclerview.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
public final class TextStatusSquareActivity$b
  implements f
{
  public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
  {
    AppMethodBeat.i(216666);
    switch (paramInt)
    {
    default: 
      locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.textstatus.b.e();
      AppMethodBeat.o(216666);
      return locale;
    }
    com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new d();
    AppMethodBeat.o(216666);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusSquareActivity.b
 * JD-Core Version:    0.7.0.1
 */