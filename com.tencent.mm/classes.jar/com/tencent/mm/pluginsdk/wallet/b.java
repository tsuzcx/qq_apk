package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.czu;
import java.util.Map;

public abstract interface b
  extends a
{
  public abstract void a(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, a parama);
  
  public abstract czu elk();
  
  public abstract Typeface gA(Context paramContext);
  
  public abstract void he(int paramInt1, int paramInt2);
  
  public static abstract interface a
  {
    public abstract void aas(String paramString);
    
    public abstract void onSuccess(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.b
 * JD-Core Version:    0.7.0.1
 */