package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.cjm;
import java.util.Map;

public abstract interface b
  extends a
{
  public abstract void a(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, b.a parama);
  
  public abstract cjm drq();
  
  public abstract Typeface fV(Context paramContext);
  
  public abstract void gD(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.b
 * JD-Core Version:    0.7.0.1
 */