package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VoiceInputScrollView
  extends ScrollView
{
  private VoiceInputScrollView.a vSB;
  
  public VoiceInputScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VoiceInputScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(27605);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(27605);
  }
  
  public void setOnScrollListener(VoiceInputScrollView.a parama)
  {
    this.vSB = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputScrollView
 * JD-Core Version:    0.7.0.1
 */