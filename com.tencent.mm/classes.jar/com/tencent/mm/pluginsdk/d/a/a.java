package com.tencent.mm.pluginsdk.d.a;

import android.database.MatrixCursor;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static final String[] rSU = { "retCode", "url" };
  
  public static MatrixCursor DA(int paramInt)
  {
    y.i("MicroMsg.ExtCommonUtils", "returnMatrix = " + paramInt);
    MatrixCursor localMatrixCursor = new MatrixCursor(com.tencent.mm.plugin.ext.b.a.jJI);
    localMatrixCursor.addRow(new Object[] { Integer.valueOf(paramInt) });
    return localMatrixCursor;
  }
  
  public static MatrixCursor VH(String paramString)
  {
    y.i("MicroMsg.ExtCommonUtils", "returnMatrix = 4207");
    MatrixCursor localMatrixCursor = new MatrixCursor(rSU);
    localMatrixCursor.addRow(new Object[] { Integer.valueOf(4207), paramString });
    return localMatrixCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.a.a
 * JD-Core Version:    0.7.0.1
 */