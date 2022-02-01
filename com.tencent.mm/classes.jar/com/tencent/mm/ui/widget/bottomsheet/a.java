package com.tencent.mm.ui.widget.bottomsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;

public final class a
  extends LinearLayout
{
  private TextView pPT;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143515);
    LayoutInflater.from(paramContext).inflate(a.h.bottom_sheet_view_title_with_arrow, this);
    this.pPT = ((TextView)findViewById(a.g.title));
    AppMethodBeat.o(143515);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(143516);
    this.pPT.setText(paramString);
    AppMethodBeat.o(143516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.bottomsheet.a
 * JD-Core Version:    0.7.0.1
 */