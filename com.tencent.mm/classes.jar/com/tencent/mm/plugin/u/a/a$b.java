package com.tencent.mm.plugin.u.a;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ab;

final class a$b
  extends AsyncTask<String, Integer, d>
{
  a$b(a parama) {}
  
  private d D(String... paramVarArgs)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(80739);
    ab.d("dktest", "doInBackground :".concat(String.valueOf(paramVarArgs)));
    if ((paramVarArgs == null) || (paramVarArgs.length != 1))
    {
      AppMethodBeat.o(80739);
      return null;
    }
    localObject1 = localObject3;
    localObject2 = localObject4;
    try
    {
      this.pPl.pPk = System.currentTimeMillis();
      localObject1 = localObject3;
      localObject2 = localObject4;
      g.a locala = new g.a();
      localObject1 = localObject3;
      localObject2 = localObject4;
      paramVarArgs = this.pPl.XE(paramVarArgs[0]);
      localObject1 = paramVarArgs;
      localObject2 = paramVarArgs;
      ab.d("MicroMsg.scanner.DecodeFile", "time: " + locala.Mm());
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      for (;;)
      {
        ab.e("MicroMsg.scanner.DecodeFile", "decode failed, OutOfMemoryError");
        paramVarArgs = (String[])localObject1;
      }
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.scanner.DecodeFile", paramVarArgs, "decode failed due to Exception", new Object[] { "" });
        paramVarArgs = (String[])localObject2;
      }
    }
    AppMethodBeat.o(80739);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.a.b
 * JD-Core Version:    0.7.0.1
 */