package com.tencent.mm.pluginsdk.d.a;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public static final String[] vJS = { "retCode", "url" };
  
  public static MatrixCursor Ls(int paramInt)
  {
    AppMethodBeat.i(27228);
    ab.i("MicroMsg.ExtCommonUtils", "returnMatrix = ".concat(String.valueOf(paramInt)));
    MatrixCursor localMatrixCursor = new MatrixCursor(com.tencent.mm.plugin.ext.b.a.mdM);
    localMatrixCursor.addRow(new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(27228);
    return localMatrixCursor;
  }
  
  public static MatrixCursor ale(String paramString)
  {
    AppMethodBeat.i(27229);
    ab.i("MicroMsg.ExtCommonUtils", "returnMatrix = 4207");
    MatrixCursor localMatrixCursor = new MatrixCursor(vJS);
    localMatrixCursor.addRow(new Object[] { Integer.valueOf(4207), paramString });
    AppMethodBeat.o(27229);
    return localMatrixCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.a.a
 * JD-Core Version:    0.7.0.1
 */