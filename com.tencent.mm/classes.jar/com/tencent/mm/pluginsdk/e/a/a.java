package com.tencent.mm.pluginsdk.e.a;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static final String[] QSu = { "retCode", "url" };
  
  public static MatrixCursor apu(int paramInt)
  {
    AppMethodBeat.i(30931);
    Log.i("MicroMsg.ExtCommonUtils", "returnMatrix = ".concat(String.valueOf(paramInt)));
    MatrixCursor localMatrixCursor = new MatrixCursor(com.tencent.mm.plugin.ext.b.a.wst);
    localMatrixCursor.addRow(new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(30931);
    return localMatrixCursor;
  }
  
  public static MatrixCursor bpi(String paramString)
  {
    AppMethodBeat.i(30932);
    Log.i("MicroMsg.ExtCommonUtils", "returnMatrix = 4207");
    MatrixCursor localMatrixCursor = new MatrixCursor(QSu);
    localMatrixCursor.addRow(new Object[] { Integer.valueOf(4207), paramString });
    AppMethodBeat.o(30932);
    return localMatrixCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.a.a
 * JD-Core Version:    0.7.0.1
 */