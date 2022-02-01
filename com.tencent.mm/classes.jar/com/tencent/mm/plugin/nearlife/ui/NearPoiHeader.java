package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public class NearPoiHeader
  extends LinearLayout
{
  private ImageView KKl;
  private TextView descTv;
  
  public NearPoiHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26622);
    init(paramContext);
    AppMethodBeat.o(26622);
  }
  
  public NearPoiHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26621);
    init(paramContext);
    AppMethodBeat.o(26621);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(26623);
    paramContext = View.inflate(paramContext, R.i.gmn, this);
    this.KKl = ((ImageView)paramContext.findViewById(R.h.location_icon));
    this.descTv = ((TextView)paramContext.findViewById(R.h.fMM));
    AppMethodBeat.o(26623);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(26624);
    this.descTv.setText(paramCharSequence);
    AppMethodBeat.o(26624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearPoiHeader
 * JD-Core Version:    0.7.0.1
 */