package com.tencent.mm.ui.chatting.component.api;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelvideo.aa.a;
import com.tencent.mm.pluginsdk.model.app.k.a;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.anim.content.b.b;
import com.tencent.mm.ui.chatting.component.aj;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.v.f;
import com.tencent.mm.ui.chatting.v.g;
import java.util.Set;

public abstract interface m
  extends k.a, b.b, aj
{
  public abstract void C(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void CD(boolean paramBoolean);
  
  public abstract void a(int paramInt, d.a parama);
  
  public abstract void a(long paramLong, cc paramcc, boolean paramBoolean);
  
  public abstract void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, boolean paramBoolean4, d.a parama);
  
  public abstract cc aBV(int paramInt);
  
  public abstract void aBW(int paramInt);
  
  public abstract void aBX(int paramInt);
  
  public abstract void aZ(Runnable paramRunnable);
  
  public abstract void ab(long paramLong, boolean paramBoolean);
  
  public abstract boolean cB(cc paramcc);
  
  public abstract void dRI();
  
  public abstract int dWF();
  
  public abstract int gEF();
  
  public abstract int getCount();
  
  public abstract View ht(long paramLong);
  
  public abstract com.tencent.mm.modelimage.loader.a.c jqA();
  
  public abstract SparseArray<cc> jqi();
  
  public abstract Set<Long> jqk();
  
  public abstract void jql();
  
  public abstract void jqm();
  
  public abstract void jqn();
  
  public abstract boolean jqo();
  
  public abstract void jqp();
  
  public abstract void jqq();
  
  public abstract void jqr();
  
  public abstract void jqs();
  
  public abstract aa.a jqt();
  
  public abstract v.f jqu();
  
  public abstract v.g jqv();
  
  public abstract ai jqw();
  
  public abstract l jqx();
  
  public abstract com.tencent.mm.ui.chatting.c jqy();
  
  public abstract long jqz();
  
  public abstract void m(View.OnClickListener paramOnClickListener);
  
  public abstract boolean zK(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.api.m
 * JD-Core Version:    0.7.0.1
 */