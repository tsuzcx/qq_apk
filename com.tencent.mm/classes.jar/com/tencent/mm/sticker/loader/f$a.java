package com.tencent.mm.sticker.loader;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/loader/StickerProcessTask$IPCStickerTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Companion", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$a
  implements d<Bundle, Bundle>
{
  private static final String TAG;
  public static final a acCT;
  
  static
  {
    AppMethodBeat.i(233885);
    acCT = new a((byte)0);
    TAG = "MicroMsg.IPCStickerTask";
    AppMethodBeat.o(233885);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/loader/StickerProcessTask$IPCStickerTask$Companion;", "", "()V", "KEY_STICKER_LOAD_INFO", "", "KEY_TASK_RESULT", "TAG", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Boolean, ah>
  {
    b(Bundle paramBundle, f<Bundle> paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.f.a
 * JD-Core Version:    0.7.0.1
 */