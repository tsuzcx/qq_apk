package com.tencent.mm.plugin.webview.preload;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static void aa(int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("ConstantsPreload", "id:%d, key:%d, valye:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt1 == 908) || (paramInt1 == 0))
    {
      h.nFQ.a(paramInt1, paramInt2, paramInt3, false);
      h.nFQ.f(15792, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      return;
    }
    h.nFQ.a(paramInt1, paramInt2, paramInt3, false);
    h.nFQ.a(908L, paramInt2, paramInt3, false);
    h.nFQ.f(15792, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public static void jdMethod_if(int paramInt)
  {
    aa(908, paramInt, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.preload.a
 * JD-Core Version:    0.7.0.1
 */