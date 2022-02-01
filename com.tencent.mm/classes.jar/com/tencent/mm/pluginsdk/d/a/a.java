package com.tencent.mm.pluginsdk.d.a;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public static final String[] DfW = { "retCode", "url" };
  
  public static MatrixCursor Wo(int paramInt)
  {
    AppMethodBeat.i(30931);
    ac.i("MicroMsg.ExtCommonUtils", "returnMatrix = ".concat(String.valueOf(paramInt)));
    MatrixCursor localMatrixCursor = new MatrixCursor(com.tencent.mm.plugin.ext.b.a.qsY);
    localMatrixCursor.addRow(new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(30931);
    return localMatrixCursor;
  }
  
  public static MatrixCursor aFR(String paramString)
  {
    AppMethodBeat.i(30932);
    ac.i("MicroMsg.ExtCommonUtils", "returnMatrix = 4207");
    MatrixCursor localMatrixCursor = new MatrixCursor(DfW);
    localMatrixCursor.addRow(new Object[] { Integer.valueOf(4207), paramString });
    AppMethodBeat.o(30932);
    return localMatrixCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.a.a
 * JD-Core Version:    0.7.0.1
 */