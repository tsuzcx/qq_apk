package com.tencent.mm.plugin.textstatus.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.a;
import com.tencent.mm.plugin.textstatus.b.b;
import com.tencent.mm.plugin.textstatus.b.c;
import com.tencent.mm.plugin.textstatus.b.c.b;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
public final class TextStatusDoWhatActivity$c
  implements f
{
  public final e<?> EC(int paramInt)
  {
    AppMethodBeat.i(216469);
    switch (paramInt)
    {
    case 0: 
    default: 
      locale = (e)new c((c.b)TextStatusDoWhatActivity.a(this.GdG));
      AppMethodBeat.o(216469);
      return locale;
    case -1: 
      locale = (e)new b();
      AppMethodBeat.o(216469);
      return locale;
    }
    e locale = (e)new a();
    AppMethodBeat.o(216469);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity.c
 * JD-Core Version:    0.7.0.1
 */