package com.tencent.mm.plugin.wallet.wecoin.a;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public abstract interface d
  extends com.tencent.mm.kernel.c.a
{
  public abstract c T(Context paramContext, boolean paramBoolean);
  
  public abstract e a(FragmentActivity paramFragmentActivity, h paramh);
  
  public abstract Object a(MMActivity paramMMActivity, k paramk, WeakReference<j> paramWeakReference);
  
  public abstract void a(Context paramContext, a parama);
  
  public abstract void a(Context paramContext, i<Boolean> parami);
  
  public abstract void a(Context paramContext, String paramString1, int paramInt, boolean paramBoolean, String paramString2);
  
  public abstract void a(Context paramContext, String paramString, byte[] paramArrayOfByte, i<Long> parami);
  
  public abstract void a(i<Long> parami);
  
  public abstract void a(i<Long> parami, Context paramContext);
  
  public abstract void a(LinkedList<Integer> paramLinkedList, i<cjj> parami);
  
  public abstract void b(i<Long> parami);
  
  public abstract void cj(Context paramContext, String paramString);
  
  public abstract Long ihk();
  
  public abstract boolean ihl();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.a.d
 * JD-Core Version:    0.7.0.1
 */