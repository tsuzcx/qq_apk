package com.tencent.mm.plugin.textstatus.a;

import android.content.Context;
import androidx.lifecycle.q;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.textstatus.proto.h;
import java.util.List;

public abstract interface r
  extends a
{
  public abstract void a(List<String> paramList, b paramb, q paramq);
  
  public abstract boolean aAp(String paramString);
  
  public abstract void bV(Context paramContext, String paramString);
  
  public abstract void bW(Context paramContext, String paramString);
  
  public abstract void bX(Context paramContext, String paramString);
  
  public abstract String bdq(String paramString);
  
  public abstract void d(Context paramContext, boolean paramBoolean, String paramString);
  
  public abstract void dh(String paramString, int paramInt);
  
  public static abstract interface b
  {
    public abstract void onDone(boolean paramBoolean, List<h> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.r
 * JD-Core Version:    0.7.0.1
 */