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
  private View GvA;
  private TextView Gvz;
  private View contentView;
  private ListView kJh;
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
    this.contentView = View.inflate(this.mContext, R.i.ejo, this);
    this.Gvz = ((TextView)this.contentView.findViewById(R.h.dNk));
    this.GvA = this.contentView.findViewById(R.h.dNl);
    AppMethodBeat.o(26618);
  }
  
  public final void aaj(int paramInt)
  {
    AppMethodBeat.i(26619);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26619);
      return;
      this.Gvz.setVisibility(8);
      this.GvA.setVisibility(8);
      this.kJh.setVisibility(0);
      AppMethodBeat.o(26619);
      return;
      this.Gvz.setVisibility(0);
      this.GvA.setVisibility(8);
      this.kJh.setVisibility(8);
      AppMethodBeat.o(26619);
      return;
      this.Gvz.setVisibility(8);
      this.GvA.setVisibility(0);
      this.kJh.setVisibility(8);
    }
  }
  
  public void setListView(ListView paramListView)
  {
    this.kJh = paramListView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeErrorContent
 * JD-Core Version:    0.7.0.1
 */