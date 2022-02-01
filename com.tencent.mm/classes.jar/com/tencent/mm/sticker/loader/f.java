package com.tencent.mm.sticker.loader;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/loader/StickerProcessTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "call", "", "onResult", "success", "", "uniqueId", "IPCStickerTask", "plugin-sticker_release"})
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
  
  public final String abi()
  {
    AppMethodBeat.i(202304);
    String str = this.Fdv.AL();
    AppMethodBeat.o(202304);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(105946);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("load_info", (Parcelable)this.Fdv);
    h.a(aj.getPackageName(), (Parcelable)localBundle, f.a.class, (d)new f.b(this));
    AppMethodBeat.o(105946);
  }
  
  public final void df(boolean paramBoolean)
  {
    AppMethodBeat.i(105947);
    ad.i(this.TAG, "onResult: " + this.Fdv.AL() + ' ' + paramBoolean);
    super.df(paramBoolean);
    AppMethodBeat.o(105947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.f
 * JD-Core Version:    0.7.0.1
 */