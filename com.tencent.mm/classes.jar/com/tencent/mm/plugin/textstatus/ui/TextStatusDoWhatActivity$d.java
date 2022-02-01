package com.tencent.mm.plugin.textstatus.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.a;
import com.tencent.mm.plugin.textstatus.b.b;
import com.tencent.mm.plugin.textstatus.b.c;
import com.tencent.mm.plugin.textstatus.b.c.b;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
public final class TextStatusDoWhatActivity$d
  implements f
{
  public final e<?> yx(int paramInt)
  {
    AppMethodBeat.i(237038);
    switch (paramInt)
    {
    case 0: 
    default: 
      locale = (e)new c((c.b)TextStatusDoWhatActivity.d(this.MLa));
      AppMethodBeat.o(237038);
      return locale;
    case -1: 
      locale = (e)new b();
      AppMethodBeat.o(237038);
      return locale;
    }
    e locale = (e)new a();
    AppMethodBeat.o(237038);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity.d
 * JD-Core Version:    0.7.0.1
 */