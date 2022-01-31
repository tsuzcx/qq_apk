package com.tencent.mm.ui.widget.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends LinearLayout
{
  private final TextView AFw;
  private final ImageView iCl;
  private final TextView iJG;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(142778);
    LayoutInflater.from(paramContext).inflate(2130968897, this);
    this.iCl = ((ImageView)findViewById(2131820929));
    this.AFw = ((TextView)findViewById(2131821949));
    this.iJG = ((TextView)findViewById(2131820680));
    AppMethodBeat.o(142778);
  }
  
  public final ImageView getIcon()
  {
    return this.iCl;
  }
  
  public final void setSubtitle(String paramString)
  {
    AppMethodBeat.i(142779);
    this.AFw.setText(paramString);
    AppMethodBeat.o(142779);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(142780);
    this.iJG.setText(paramString);
    AppMethodBeat.o(142780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.b
 * JD-Core Version:    0.7.0.1
 */