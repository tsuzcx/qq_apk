package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class q$a
  extends c.a
{
  protected TextView mCZ;
  protected ProgressBar pNd;
  protected ImageView zRC;
  protected TextView zRY;
  protected MMNeat7extView zUr;
  
  public final a fh(View paramView)
  {
    AppMethodBeat.i(32999);
    super.eV(paramView);
    this.zUr = ((MMNeat7extView)paramView.findViewById(2131821123));
    this.pNd = ((ProgressBar)paramView.findViewById(2131822728));
    this.zRC = ((ImageView)paramView.findViewById(2131822695));
    this.mCZ = ((TextView)paramView.findViewById(2131822607));
    this.zRY = ((TextView)paramView.findViewById(2131822518));
    this.qFY = ((TextView)paramView.findViewById(2131821122));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    AppMethodBeat.o(32999);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.a
 * JD-Core Version:    0.7.0.1
 */