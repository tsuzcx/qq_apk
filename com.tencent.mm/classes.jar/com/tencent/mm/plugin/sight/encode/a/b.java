package com.tencent.mm.plugin.sight.encode.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.i;
import java.util.List;

public final class b
{
  public static void a(a parama, final int paramInt)
  {
    AppMethodBeat.i(116211);
    if (parama == null)
    {
      AppMethodBeat.o(116211);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116207);
        this.xFu.onError(paramInt);
        AppMethodBeat.o(116207);
      }
    });
    AppMethodBeat.o(116211);
  }
  
  public static abstract interface a
  {
    public abstract void onError(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.a.b
 * JD-Core Version:    0.7.0.1
 */