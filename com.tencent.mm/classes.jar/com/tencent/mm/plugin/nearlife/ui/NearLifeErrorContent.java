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
  private TextView ACw;
  private View ACx;
  private View contentView;
  private ListView hUI;
  private Context mContext;
  
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
    this.contentView = View.inflate(this.mContext, 2131495809, this);
    this.ACw = ((TextView)this.contentView.findViewById(2131305235));
    this.ACx = this.contentView.findViewById(2131305256);
    AppMethodBeat.o(26618);
  }
  
  public final void Tx(int paramInt)
  {
    AppMethodBeat.i(26619);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26619);
      return;
      this.ACw.setVisibility(8);
      this.ACx.setVisibility(8);
      this.hUI.setVisibility(0);
      AppMethodBeat.o(26619);
      return;
      this.ACw.setVisibility(0);
      this.ACx.setVisibility(8);
      this.hUI.setVisibility(8);
      AppMethodBeat.o(26619);
      return;
      this.ACw.setVisibility(8);
      this.ACx.setVisibility(0);
      this.hUI.setVisibility(8);
    }
  }
  
  public void setListView(ListView paramListView)
  {
    this.hUI = paramListView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeErrorContent
 * JD-Core Version:    0.7.0.1
 */