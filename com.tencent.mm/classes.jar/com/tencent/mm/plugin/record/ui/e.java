package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.ui.a.b;
import java.util.List;

public final class e
  extends h
  implements c
{
  int fromScene = 0;
  
  public e(Context paramContext, h.a parama)
  {
    super(paramContext, parama);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.f paramf)
  {
    bvK();
  }
  
  public final void a(a parama)
  {
    this.ntO = parama;
    this.ntu.clear();
    this.ntu.addAll(parama.ntu);
    notifyDataSetChanged();
  }
  
  public final void d(b paramb)
  {
    paramb.aYU = 0;
    paramb.fromScene = this.fromScene;
    paramb.bIt = ((f)this.ntO).bIt;
    paramb.bWL = ((f)this.ntO).bWL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.e
 * JD-Core Version:    0.7.0.1
 */