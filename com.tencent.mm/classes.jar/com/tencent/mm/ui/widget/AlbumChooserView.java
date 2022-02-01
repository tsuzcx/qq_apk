package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AlbumChooserView
  extends LinearLayout
{
  public TextView Hys;
  public ImageView Hyt;
  public boolean Hyu;
  private a Hyv;
  
  public AlbumChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159261);
    this.Hyu = false;
    init(paramContext);
    AppMethodBeat.o(159261);
  }
  
  public AlbumChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159262);
    this.Hyu = false;
    init(paramContext);
    AppMethodBeat.o(159262);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(159263);
    paramContext = LayoutInflater.from(paramContext).inflate(2131492954, this, true);
    this.Hys = ((TextView)paramContext.findViewById(2131296544));
    this.Hyt = ((ImageView)paramContext.findViewById(2131296543));
    this.Hyt.setRotation(90.0F);
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159258);
        if (AlbumChooserView.a(AlbumChooserView.this) != null) {
          AlbumChooserView.a(AlbumChooserView.this).cAz();
        }
        AppMethodBeat.o(159258);
      }
    });
    AppMethodBeat.o(159263);
  }
  
  public void setOnAlbumChooserViewClick(a parama)
  {
    this.Hyv = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cAz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.AlbumChooserView
 * JD-Core Version:    0.7.0.1
 */