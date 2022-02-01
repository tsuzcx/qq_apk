package com.tencent.mm.sticker.loader;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/loader/StickerProcessTask$IPCStickerTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Companion", "plugin-sticker_release"})
public final class f$a
  implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
{
  public static final a NNQ;
  private static final String TAG = "MicroMsg.IPCStickerTask";
  
  static
  {
    AppMethodBeat.i(194229);
    NNQ = new a((byte)0);
    TAG = "MicroMsg.IPCStickerTask";
    AppMethodBeat.o(194229);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/loader/StickerProcessTask$IPCStickerTask$Companion;", "", "()V", "KEY_STICKER_LOAD_INFO", "", "KEY_TASK_RESULT", "TAG", "plugin-sticker_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    b(Bundle paramBundle, d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.f.a
 * JD-Core Version:    0.7.0.1
 */