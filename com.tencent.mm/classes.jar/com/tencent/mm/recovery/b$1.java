package com.tencent.mm.recovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.e;
import com.tencent.mm.recoveryv2.i;
import com.tencent.tinker.lib.d.b;
import java.io.File;

final class b$1
  extends b
{
  b$1(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void h(File paramFile, int paramInt)
  {
    AppMethodBeat.i(242760);
    super.h(paramFile, paramInt);
    e.i("MicroMsg.recovery.operator", "#onPatchPackageCheckFail, code = ".concat(String.valueOf(paramInt)));
    if (paramInt != 0) {}
    for (paramInt = Math.abs(paramInt) + 10;; paramInt = 0)
    {
      paramFile = i.lV(this.context);
      paramFile.acks = false;
      paramFile.ackr = paramInt;
      paramFile.sz();
      AppMethodBeat.o(242760);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.recovery.b.1
 * JD-Core Version:    0.7.0.1
 */