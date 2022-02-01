package com.tencent.mm.ui.chatting.d.b;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.pluginsdk.model.app.k.a;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.chatting.d.af;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.t.f;
import com.tencent.mm.ui.chatting.t.g;
import java.util.Set;

public abstract interface k
  extends k.a, af
{
  public abstract boolean Nu(long paramLong);
  
  public abstract void Q(long paramLong, boolean paramBoolean);
  
  public abstract void a(int paramInt, d.a parama);
  
  public abstract void a(long paramLong, ca paramca, boolean paramBoolean);
  
  public abstract void a(long paramLong, boolean paramBoolean, d.a parama);
  
  public abstract ca amt(int paramInt);
  
  public abstract void amu(int paramInt);
  
  public abstract void amv(int paramInt);
  
  public abstract boolean bT(ca paramca);
  
  public abstract void cVM();
  
  public abstract int cZm();
  
  public abstract int eGR();
  
  public abstract t.a gOA();
  
  public abstract t.f gOB();
  
  public abstract t.g gOC();
  
  public abstract ac gOD();
  
  public abstract l gOE();
  
  public abstract com.tencent.mm.ui.chatting.c gOF();
  
  public abstract long gOG();
  
  public abstract com.tencent.mm.av.a.a.c gOH();
  
  public abstract SparseArray<ca> gOq();
  
  public abstract Set<Long> gOs();
  
  public abstract void gOt();
  
  public abstract void gOu();
  
  public abstract void gOv();
  
  public abstract void gOw();
  
  public abstract void gOx();
  
  public abstract void gOy();
  
  public abstract void gOz();
  
  public abstract int getCount();
  
  public abstract void i(View.OnClickListener paramOnClickListener);
  
  public abstract boolean isInEditMode();
  
  public abstract void s(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void uo(boolean paramBoolean);
  
  public abstract View zh(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b.k
 * JD-Core Version:    0.7.0.1
 */