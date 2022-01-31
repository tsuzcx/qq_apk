package com.tencent.mm.ui.chatting.f;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class d$d<T>
{
  public int eke;
  public int selection;
  public Bundle zOD;
  public d.a zOE;
  public List<T> zOF;
  public int zOG;
  public SparseArray<T> zOH;
  
  d$d(d.a parama)
  {
    AppMethodBeat.i(32483);
    this.selection = -1;
    this.zOE = parama;
    this.zOF = new LinkedList();
    AppMethodBeat.o(32483);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(32484);
    String str = "LoadedResult{sourceArgs=" + this.zOD + ", mode=" + this.zOE + ", selection=" + this.selection + ", count=" + this.zOG + ", totalCount=" + this.eke + '}';
    AppMethodBeat.o(32484);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.d.d
 * JD-Core Version:    0.7.0.1
 */