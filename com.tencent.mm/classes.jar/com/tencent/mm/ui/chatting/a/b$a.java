package com.tencent.mm.ui.chatting.a;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

public final class b$a
  extends RecyclerView.v
{
  TextView pIJ;
  ProgressBar progressBar;
  
  public b$a(b paramb, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(35022);
    this.pIJ = ((TextView)paramView.findViewById(R.h.date_info));
    this.progressBar = ((ProgressBar)paramView.findViewById(R.h.load_progress));
    AppMethodBeat.o(35022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b.a
 * JD-Core Version:    0.7.0.1
 */