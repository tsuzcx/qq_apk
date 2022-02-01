package com.tencent.mm.sticker.loader;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/loader/StickerProcessTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "call", "", "onResult", "success", "", "uniqueId", "IPCStickerTask", "plugin-sticker_release"})
public final class f
  extends g
{
  final String TAG;
  
  public f(StickerLoadInfo paramStickerLoadInfo)
  {
    super(paramStickerLoadInfo);
    AppMethodBeat.i(105949);
    this.TAG = "MicroMsg.StickerProcessTask";
    AppMethodBeat.o(105949);
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(292937);
    String str = this.VbE.key();
    AppMethodBeat.o(292937);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(105946);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("load_info", (Parcelable)this.VbE);
    j.a(MMApplicationContext.getPackageName(), (Parcelable)localBundle, f.a.class, (com.tencent.mm.ipcinvoker.f)new b(this));
    AppMethodBeat.o(105946);
  }
  
  public final void ep(boolean paramBoolean)
  {
    AppMethodBeat.i(105947);
    Log.i(this.TAG, "onResult: " + this.VbE.key() + ' ' + paramBoolean);
    super.ep(paramBoolean);
    AppMethodBeat.o(105947);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    b(f paramf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.f
 * JD-Core Version:    0.7.0.1
 */