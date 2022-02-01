package com.tencent.mm.ui.chatting.d.b;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.pluginsdk.model.app.k.a;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.chatting.d.ag;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.t.f;
import com.tencent.mm.ui.chatting.t.g;
import java.util.Set;

public abstract interface k
  extends k.a, ag
{
  public abstract View Fl(long paramLong);
  
  public abstract void Q(long paramLong, boolean paramBoolean);
  
  public abstract boolean VC(long paramLong);
  
  public abstract void a(int paramInt, d.a parama);
  
  public abstract void a(long paramLong, ca paramca, boolean paramBoolean);
  
  public abstract void a(long paramLong, boolean paramBoolean, d.a parama);
  
  public abstract ca avt(int paramInt);
  
  public abstract void avu(int paramInt);
  
  public abstract void avv(int paramInt);
  
  public abstract boolean cn(ca paramca);
  
  public abstract void dkS();
  
  public abstract int dpe();
  
  public abstract int fsW();
  
  public abstract int getCount();
  
  public abstract SparseArray<ca> hNB();
  
  public abstract Set<Long> hND();
  
  public abstract void hNE();
  
  public abstract void hNF();
  
  public abstract void hNG();
  
  public abstract boolean hNH();
  
  public abstract void hNI();
  
  public abstract void hNJ();
  
  public abstract void hNK();
  
  public abstract void hNL();
  
  public abstract x.a hNM();
  
  public abstract t.f hNN();
  
  public abstract t.g hNO();
  
  public abstract af hNP();
  
  public abstract l hNQ();
  
  public abstract com.tencent.mm.ui.chatting.c hNR();
  
  public abstract long hNS();
  
  public abstract com.tencent.mm.ay.a.a.c hNT();
  
  public abstract void k(View.OnClickListener paramOnClickListener);
  
  public abstract void t(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void xM(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b.k
 * JD-Core Version:    0.7.0.1
 */