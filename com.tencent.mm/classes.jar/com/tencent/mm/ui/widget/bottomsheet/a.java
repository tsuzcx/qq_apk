package com.tencent.mm.ui.widget.bottomsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends LinearLayout
{
  private TextView mPa;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143515);
    LayoutInflater.from(paramContext).inflate(2131493311, this);
    this.mPa = ((TextView)findViewById(2131309195));
    AppMethodBeat.o(143515);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(143516);
    this.mPa.setText(paramString);
    AppMethodBeat.o(143516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.bottomsheet.a
 * JD-Core Version:    0.7.0.1
 */