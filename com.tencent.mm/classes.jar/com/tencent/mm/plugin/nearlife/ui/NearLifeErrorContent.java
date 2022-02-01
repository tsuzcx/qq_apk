package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public class NearLifeErrorContent
  extends FrameLayout
{
  private TextView Mry;
  private View Mrz;
  private View contentView;
  private Context mContext;
  private ListView nlI;
  
  public NearLifeErrorContent(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26617);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(26617);
  }
  
  public NearLifeErrorContent(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26616);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(26616);
  }
  
  private void init()
  {
    AppMethodBeat.i(26618);
    this.contentView = View.inflate(this.mContext, R.i.gmp, this);
    this.Mry = ((TextView)this.contentView.findViewById(R.h.fPe));
    this.Mrz = this.contentView.findViewById(R.h.fPm);
    AppMethodBeat.o(26618);
  }
  
  public final void aeC(int paramInt)
  {
    AppMethodBeat.i(26619);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26619);
      return;
      this.Mry.setVisibility(8);
      this.Mrz.setVisibility(8);
      this.nlI.setVisibility(0);
      AppMethodBeat.o(26619);
      return;
      this.Mry.setVisibility(0);
      this.Mrz.setVisibility(8);
      this.nlI.setVisibility(8);
      AppMethodBeat.o(26619);
      return;
      this.Mry.setVisibility(8);
      this.Mrz.setVisibility(0);
      this.nlI.setVisibility(8);
    }
  }
  
  public void setListView(ListView paramListView)
  {
    this.nlI = paramListView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeErrorContent
 * JD-Core Version:    0.7.0.1
 */