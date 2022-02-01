package com.tencent.mm.ui.chatting.d.b;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.pluginsdk.model.app.k.a;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.ab;
import com.tencent.mm.ui.chatting.d.ad;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.s.f;
import com.tencent.mm.ui.chatting.s.g;
import java.util.Set;

public abstract interface k
  extends k.a, ad
{
  public abstract boolean DR(long paramLong);
  
  public abstract View DS(long paramLong);
  
  public abstract void J(long paramLong, boolean paramBoolean);
  
  public abstract void a(int paramInt, d.a parama);
  
  public abstract void a(long paramLong, bu parambu, boolean paramBoolean);
  
  public abstract void a(long paramLong, boolean paramBoolean, d.a parama);
  
  public abstract bu ada(int paramInt);
  
  public abstract void adb(int paramInt);
  
  public abstract void adc(int paramInt);
  
  public abstract boolean bE(bu parambu);
  
  public abstract void cwh();
  
  public abstract int dCM();
  
  public abstract void e(View.OnClickListener paramOnClickListener);
  
  public abstract SparseArray<bu> fCi();
  
  public abstract Set<Long> fCk();
  
  public abstract void fCl();
  
  public abstract void fCm();
  
  public abstract void fCn();
  
  public abstract void fCo();
  
  public abstract void fCp();
  
  public abstract void fCq();
  
  public abstract void fCr();
  
  public abstract t.a fCs();
  
  public abstract s.f fCt();
  
  public abstract s.g fCu();
  
  public abstract ab fCv();
  
  public abstract l fCw();
  
  public abstract com.tencent.mm.ui.chatting.c fCx();
  
  public abstract long fCy();
  
  public abstract com.tencent.mm.aw.a.a.c fCz();
  
  public abstract int fpw();
  
  public abstract int getCount();
  
  public abstract boolean isInEditMode();
  
  public abstract void qM(boolean paramBoolean);
  
  public abstract void r(long paramLong, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b.k
 * JD-Core Version:    0.7.0.1
 */