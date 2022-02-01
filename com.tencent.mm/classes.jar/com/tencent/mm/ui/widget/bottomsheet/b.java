package com.tencent.mm.ui.widget.bottomsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends LinearLayout
{
  private final TextView KUC;
  private final ImageView kAX;
  private final TextView lCL;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143518);
    LayoutInflater.from(paramContext).inflate(2131493236, this);
    this.kAX = ((ImageView)findViewById(2131300874));
    this.KUC = ((TextView)findViewById(2131305529));
    this.lCL = ((TextView)findViewById(2131305902));
    AppMethodBeat.o(143518);
  }
  
  public final ImageView getIcon()
  {
    return this.kAX;
  }
  
  public final void setSubtitle(String paramString)
  {
    AppMethodBeat.i(143519);
    this.KUC.setText(paramString);
    AppMethodBeat.o(143519);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(143520);
    this.lCL.setText(paramString);
    AppMethodBeat.o(143520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.bottomsheet.b
 * JD-Core Version:    0.7.0.1
 */