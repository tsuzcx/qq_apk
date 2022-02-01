package com.tencent.mm.sticker.loader;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/loader/StickerProcessTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "call", "", "onResult", "success", "", "uniqueId", "IPCStickerTask", "plugin-sticker_release"})
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
  
  public final String acg()
  {
    AppMethodBeat.i(210470);
    String str = this.GAW.Ap();
    AppMethodBeat.o(210470);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(105946);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("load_info", (Parcelable)this.GAW);
    h.a(ai.getPackageName(), (Parcelable)localBundle, f.a.class, (d)new b(this));
    AppMethodBeat.o(105946);
  }
  
  public final void de(boolean paramBoolean)
  {
    AppMethodBeat.i(105947);
    ac.i(this.TAG, "onResult: " + this.GAW.Ap() + ' ' + paramBoolean);
    super.de(paramBoolean);
    AppMethodBeat.o(105947);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements d<ResultType>
  {
    b(f paramf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.f
 * JD-Core Version:    0.7.0.1
 */