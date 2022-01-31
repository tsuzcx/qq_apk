package com.tencent.mm.plugin.sns.ui.album;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends RecyclerView.a<c.b>
{
  List<a.d> seA;
  c.a seB;
  
  public c()
  {
    AppMethodBeat.i(39982);
    this.seA = new ArrayList();
    this.seB = null;
    AppMethodBeat.o(39982);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(39983);
    int i = this.seA.size();
    AppMethodBeat.o(39983);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.c
 * JD-Core Version:    0.7.0.1
 */