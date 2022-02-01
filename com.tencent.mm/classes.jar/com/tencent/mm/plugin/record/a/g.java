package com.tencent.mm.plugin.record.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.storage.cc;

public abstract interface g
  extends a
{
  public abstract boolean a(Context paramContext, cc paramcc, dl paramdl);
  
  public abstract boolean g(String paramString1, long paramLong, String paramString2);
  
  public abstract void tm(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.g
 * JD-Core Version:    0.7.0.1
 */