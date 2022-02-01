package com.tencent.mm.plugin.wallet.wecoin.a;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mm.kernel.c.a;

public abstract interface c
  extends a
{
  public abstract d a(FragmentActivity paramFragmentActivity, int paramInt, String paramString, e<Boolean> parame);
  
  public abstract void a(Context paramContext, e<Boolean> parame);
  
  public abstract void a(Context paramContext, String paramString, byte[] paramArrayOfByte, e<Long> parame);
  
  public abstract void a(e<Long> parame);
  
  public abstract b aP(Activity paramActivity);
  
  public abstract void bN(Context paramContext, String paramString);
  
  public abstract boolean dfq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.a.c
 * JD-Core Version:    0.7.0.1
 */