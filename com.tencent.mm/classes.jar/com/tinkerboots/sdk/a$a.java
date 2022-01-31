package com.tinkerboots.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.c.a;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.loader.TinkerRuntimeException;

public final class a$a
{
  public a BLD;
  public Class<? extends AbstractResultService> BLE;
  public com.tinkerboots.sdk.a.a.b BLF;
  public com.tencent.tinker.lib.b.b BsN;
  public c BsO;
  public d BsP;
  public final ApplicationLike bXD;
  public final Context context;
  
  public a$a(ApplicationLike paramApplicationLike)
  {
    AppMethodBeat.i(65519);
    if (paramApplicationLike == null)
    {
      paramApplicationLike = new TinkerRuntimeException("applicationLike must not be null.");
      AppMethodBeat.o(65519);
      throw paramApplicationLike;
    }
    this.context = paramApplicationLike.getApplication();
    this.bXD = paramApplicationLike;
    AppMethodBeat.o(65519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tinkerboots.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */