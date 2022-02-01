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
  private final TextView QFN;
  private final ImageView lIM;
  private final TextView mPa;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143518);
    LayoutInflater.from(paramContext).inflate(2131493312, this);
    this.lIM = ((ImageView)findViewById(2131302468));
    this.QFN = ((TextView)findViewById(2131308746));
    this.mPa = ((TextView)findViewById(2131309195));
    AppMethodBeat.o(143518);
  }
  
  public final ImageView getIcon()
  {
    return this.lIM;
  }
  
  public final void setSubtitle(String paramString)
  {
    AppMethodBeat.i(143519);
    this.QFN.setText(paramString);
    AppMethodBeat.o(143519);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(143520);
    this.mPa.setText(paramString);
    AppMethodBeat.o(143520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.bottomsheet.b
 * JD-Core Version:    0.7.0.1
 */