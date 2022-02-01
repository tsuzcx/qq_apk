package com.tencent.mm.pluginsdk.d.a;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public static final String[] Fcq = { "retCode", "url" };
  
  public static MatrixCursor YL(int paramInt)
  {
    AppMethodBeat.i(30931);
    ae.i("MicroMsg.ExtCommonUtils", "returnMatrix = ".concat(String.valueOf(paramInt)));
    MatrixCursor localMatrixCursor = new MatrixCursor(com.tencent.mm.plugin.ext.b.a.rkS);
    localMatrixCursor.addRow(new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(30931);
    return localMatrixCursor;
  }
  
  public static MatrixCursor aMN(String paramString)
  {
    AppMethodBeat.i(30932);
    ae.i("MicroMsg.ExtCommonUtils", "returnMatrix = 4207");
    MatrixCursor localMatrixCursor = new MatrixCursor(Fcq);
    localMatrixCursor.addRow(new Object[] { Integer.valueOf(4207), paramString });
    AppMethodBeat.o(30932);
    return localMatrixCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.a.a
 * JD-Core Version:    0.7.0.1
 */