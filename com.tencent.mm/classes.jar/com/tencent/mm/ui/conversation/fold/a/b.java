package com.tencent.mm.ui.conversation.fold.a;

import android.animation.Animator;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public final c afuf;
  public final SparseArray<Animator> afug;
  public int afuh;
  public int afui;
  public int afuj;
  public long afuk;
  public int aful;
  public int afum;
  public boolean afun;
  
  public b(c paramc)
  {
    AppMethodBeat.i(256850);
    this.afug = new SparseArray();
    this.afuh = 150;
    this.afui = 100;
    this.afuj = 250;
    this.afun = true;
    this.afuf = paramc;
    this.afuk = -1L;
    this.aful = -1;
    this.afum = -1;
    AppMethodBeat.o(256850);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(256855);
    int i = 0;
    while (i < this.afug.size())
    {
      ((Animator)this.afug.get(this.afug.keyAt(i))).cancel();
      i += 1;
    }
    this.afug.clear();
    this.aful = -1;
    this.afum = -1;
    this.afuk = -1L;
    this.afun = true;
    AppMethodBeat.o(256855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.fold.a.b
 * JD-Core Version:    0.7.0.1
 */