package com.tencent.mm.plugin.nearlife.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NearPoiHeader
  extends LinearLayout
{
  private TextView hsI;
  private ImageView oyP;
  
  public NearPoiHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(22995);
    init(paramContext);
    AppMethodBeat.o(22995);
  }
  
  @TargetApi(11)
  public NearPoiHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(22994);
    init(paramContext);
    AppMethodBeat.o(22994);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(22996);
    paramContext = View.inflate(paramContext, 2130970337, this);
    this.oyP = ((ImageView)paramContext.findViewById(2131826468));
    this.hsI = ((TextView)paramContext.findViewById(2131826469));
    AppMethodBeat.o(22996);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(22997);
    this.hsI.setText(paramCharSequence);
    AppMethodBeat.o(22997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearPoiHeader
 * JD-Core Version:    0.7.0.1
 */