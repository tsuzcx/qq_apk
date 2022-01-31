package com.tencent.mm.ui.chatting.a;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.bo;

public class c$a
  extends RecyclerView.v
{
  public ImageView egq;
  public TextView ekh;
  public TextView gpL;
  public TextView gzk;
  public View ngZ;
  
  public c$a(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(31151);
    this.ngZ = paramView;
    this.egq = ((ImageView)paramView.findViewById(2131820599));
    this.gzk = ((TextView)paramView.findViewById(2131820611));
    this.ekh = ((TextView)paramView.findViewById(2131820618));
    this.gpL = ((TextView)paramView.findViewById(2131820619));
    this.gpL.setSingleLine(false);
    this.gpL.setMaxLines(2);
    paramView.setOnClickListener(new c.a.1(this));
    paramView.setOnLongClickListener(new c.a.2(this));
    AppMethodBeat.o(31151);
  }
  
  public static void c(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(31152);
    if (!bo.isNullOrNil(paramString))
    {
      paramTextView.getContext();
      paramTextView.setText(f.a(paramTextView.getText(), paramString));
    }
    AppMethodBeat.o(31152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c.a
 * JD-Core Version:    0.7.0.1
 */