package com.tencent.mm.plugin.scanner.api;

import android.content.Context;
import java.util.List;

public abstract interface c
  extends com.tencent.mm.kernel.c.a
{
  public abstract String Iq(long paramLong);
  
  public abstract void Ir(long paramLong);
  
  public abstract void Is(long paramLong);
  
  public abstract long a(e parame, g paramg);
  
  public abstract void a(Context paramContext, ScanGoodsRequest paramScanGoodsRequest);
  
  public abstract void a(Context paramContext, ScanGoodsRequest paramScanGoodsRequest, int paramInt);
  
  public abstract long b(e parame, g paramg);
  
  public abstract long c(e parame, g paramg);
  
  public abstract com.tencent.mm.plugin.scanner.api.a.a gT(Context paramContext);
  
  public abstract boolean gy(List<Float> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.api.c
 * JD-Core Version:    0.7.0.1
 */