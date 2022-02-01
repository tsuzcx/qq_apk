package com.tencent.mm.sticker.loader;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/loader/StickerProcessTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "call", "", "onResult", "success", "", "uniqueId", "IPCStickerTask", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends g
{
  private final String TAG;
  
  public f(StickerLoadInfo paramStickerLoadInfo)
  {
    super(paramStickerLoadInfo);
    AppMethodBeat.i(105949);
    this.TAG = "MicroMsg.StickerProcessTask";
    AppMethodBeat.o(105949);
  }
  
  private static final void a(f paramf, Bundle paramBundle)
  {
    AppMethodBeat.i(233871);
    s.u(paramf, "this$0");
    Log.i(paramf.TAG, "result: ");
    paramf.onResult(paramBundle.getBoolean("task_result"));
    AppMethodBeat.o(233871);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(369555);
    String str = this.acCU.key();
    AppMethodBeat.o(369555);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(105946);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("load_info", (Parcelable)this.acCU);
    j.a(MMApplicationContext.getPackageName(), (Parcelable)localBundle, f.a.class, new f..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(105946);
  }
  
  public final void onResult(boolean paramBoolean)
  {
    AppMethodBeat.i(105947);
    Log.i(this.TAG, "onResult: " + this.acCU.key() + ' ' + paramBoolean);
    super.onResult(paramBoolean);
    AppMethodBeat.o(105947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.f
 * JD-Core Version:    0.7.0.1
 */