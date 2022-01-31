package com.tencent.mm.ui.widget.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends LinearLayout
{
  private TextView iJG;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(142776);
    LayoutInflater.from(paramContext).inflate(2130968896, this);
    this.iJG = ((TextView)findViewById(2131820680));
    AppMethodBeat.o(142776);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(142777);
    this.iJG.setText(paramString);
    AppMethodBeat.o(142777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.a
 * JD-Core Version:    0.7.0.1
 */