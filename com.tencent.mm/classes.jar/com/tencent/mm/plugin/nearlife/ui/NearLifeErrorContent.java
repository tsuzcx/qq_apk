package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NearLifeErrorContent
  extends FrameLayout
{
  private View contentView;
  private ListView hbO;
  private Context mContext;
  private TextView wHm;
  private View wHn;
  
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
    this.contentView = View.inflate(this.mContext, 2131494996, this);
    this.wHm = ((TextView)this.contentView.findViewById(2131302681));
    this.wHn = this.contentView.findViewById(2131302702);
    AppMethodBeat.o(26618);
  }
  
  public final void Mq(int paramInt)
  {
    AppMethodBeat.i(26619);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26619);
      return;
      this.wHm.setVisibility(8);
      this.wHn.setVisibility(8);
      this.hbO.setVisibility(0);
      AppMethodBeat.o(26619);
      return;
      this.wHm.setVisibility(0);
      this.wHn.setVisibility(8);
      this.hbO.setVisibility(8);
      AppMethodBeat.o(26619);
      return;
      this.wHm.setVisibility(8);
      this.wHn.setVisibility(0);
      this.hbO.setVisibility(8);
    }
  }
  
  public void setListView(ListView paramListView)
  {
    this.hbO = paramListView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeErrorContent
 * JD-Core Version:    0.7.0.1
 */