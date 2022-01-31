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
  private ListView gMh;
  private Context mContext;
  private TextView pfN;
  private View pfO;
  
  public NearLifeErrorContent(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(22991);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(22991);
  }
  
  public NearLifeErrorContent(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(22990);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(22990);
  }
  
  private void init()
  {
    AppMethodBeat.i(22992);
    this.contentView = View.inflate(this.mContext, 2130970339, this);
    this.pfN = ((TextView)this.contentView.findViewById(2131826479));
    this.pfO = this.contentView.findViewById(2131826480);
    AppMethodBeat.o(22992);
  }
  
  public final void AH(int paramInt)
  {
    AppMethodBeat.i(22993);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22993);
      return;
      this.pfN.setVisibility(8);
      this.pfO.setVisibility(8);
      this.gMh.setVisibility(0);
      AppMethodBeat.o(22993);
      return;
      this.pfN.setVisibility(0);
      this.pfO.setVisibility(8);
      this.gMh.setVisibility(8);
      AppMethodBeat.o(22993);
      return;
      this.pfN.setVisibility(8);
      this.pfO.setVisibility(0);
      this.gMh.setVisibility(8);
    }
  }
  
  public void setListView(ListView paramListView)
  {
    this.gMh = paramListView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeErrorContent
 * JD-Core Version:    0.7.0.1
 */