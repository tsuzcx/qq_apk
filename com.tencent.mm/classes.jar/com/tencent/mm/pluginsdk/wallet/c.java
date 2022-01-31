package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.bkx;
import java.util.Map;

public abstract interface c
  extends a
{
  public abstract void a(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, c.a parama);
  
  public abstract bkx bSo();
  
  public abstract Typeface eA(Context paramContext);
  
  public abstract void eJ(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.c
 * JD-Core Version:    0.7.0.1
 */