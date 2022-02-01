package com.tencent.mm.ui.chatting.d.b;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.pluginsdk.model.app.k.a;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ab;
import com.tencent.mm.ui.chatting.d.ad;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.t.f;
import com.tencent.mm.ui.chatting.t.g;
import java.util.Set;

public abstract interface k
  extends k.a, ad
{
  public abstract boolean Eq(long paramLong);
  
  public abstract View Er(long paramLong);
  
  public abstract void L(long paramLong, boolean paramBoolean);
  
  public abstract void a(int paramInt, d.a parama);
  
  public abstract void a(long paramLong, bv parambv, boolean paramBoolean);
  
  public abstract void a(long paramLong, boolean paramBoolean, d.a parama);
  
  public abstract bv adI(int paramInt);
  
  public abstract void adJ(int paramInt);
  
  public abstract void adK(int paramInt);
  
  public abstract boolean bD(bv parambv);
  
  public abstract void cxI();
  
  public abstract int dGd();
  
  public abstract void e(View.OnClickListener paramOnClickListener);
  
  public abstract long fGA();
  
  public abstract com.tencent.mm.av.a.a.c fGB();
  
  public abstract SparseArray<bv> fGk();
  
  public abstract Set<Long> fGm();
  
  public abstract void fGn();
  
  public abstract void fGo();
  
  public abstract void fGp();
  
  public abstract void fGq();
  
  public abstract void fGr();
  
  public abstract void fGs();
  
  public abstract void fGt();
  
  public abstract t.a fGu();
  
  public abstract t.f fGv();
  
  public abstract t.g fGw();
  
  public abstract ab fGx();
  
  public abstract l fGy();
  
  public abstract com.tencent.mm.ui.chatting.c fGz();
  
  public abstract int ftv();
  
  public abstract int getCount();
  
  public abstract boolean isInEditMode();
  
  public abstract void qT(boolean paramBoolean);
  
  public abstract void r(long paramLong, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b.k
 * JD-Core Version:    0.7.0.1
 */