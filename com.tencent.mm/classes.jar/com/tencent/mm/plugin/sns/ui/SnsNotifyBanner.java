package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsNotifyBanner
  extends RelativeLayout
{
  private View mContentView;
  private LayoutInflater mInflater;
  private TextView yPh;
  private ImageView yPi;
  int yPj;
  private a yPk;
  
  public SnsNotifyBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98934);
    this.yPj = 0;
    init();
    AppMethodBeat.o(98934);
  }
  
  public SnsNotifyBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98933);
    this.yPj = 0;
    init();
    AppMethodBeat.o(98933);
  }
  
  private void init()
  {
    AppMethodBeat.i(98935);
    this.mInflater = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.mContentView = this.mInflater.inflate(2131495573, this, true);
    this.yPh = ((TextView)this.mContentView.findViewById(2131304941));
    this.yPi = ((ImageView)this.mContentView.findViewById(2131304940));
    this.yPi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98931);
        SnsNotifyBanner.this.setVisibility(8);
        AppMethodBeat.o(98931);
      }
    });
    AppMethodBeat.o(98935);
  }
  
  public void setOnClickNotify(a parama)
  {
    AppMethodBeat.i(98936);
    this.yPk = parama;
    this.yPh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98932);
        if (SnsNotifyBanner.a(SnsNotifyBanner.this) == null)
        {
          AppMethodBeat.o(98932);
          return;
        }
        if (SnsNotifyBanner.this.yPj > 0)
        {
          SnsNotifyBanner.this.yPj = 0;
          SnsNotifyBanner.a(SnsNotifyBanner.this);
        }
        for (;;)
        {
          SnsNotifyBanner.this.setVisibility(8);
          AppMethodBeat.o(98932);
          return;
          SnsNotifyBanner.a(SnsNotifyBanner.this);
        }
      }
    });
    AppMethodBeat.o(98936);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotifyBanner
 * JD-Core Version:    0.7.0.1
 */