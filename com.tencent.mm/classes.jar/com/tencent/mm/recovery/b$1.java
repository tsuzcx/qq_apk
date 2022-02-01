package com.tencent.mm.recovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.f;
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
  
  public final void e(File paramFile, int paramInt)
  {
    AppMethodBeat.i(193896);
    super.e(paramFile, paramInt);
    f.i("MicroMsg.recovery.operator", "#onPatchPackageCheckFail, code = ".concat(String.valueOf(paramInt)));
    if (paramInt != 0) {}
    for (paramInt = Math.abs(paramInt) + 10;; paramInt = 0)
    {
      paramFile = i.iQ(this.context);
      paramFile.NBY = false;
      paramFile.NBX = paramInt;
      paramFile.save();
      AppMethodBeat.o(193896);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.recovery.b.1
 * JD-Core Version:    0.7.0.1
 */