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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class AlbumChooserView
  extends LinearLayout
{
  public TextView Lms;
  public ImageView Lmt;
  public boolean Lmu;
  private a Lmv;
  
  public AlbumChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159261);
    this.Lmu = false;
    init(paramContext);
    AppMethodBeat.o(159261);
  }
  
  public AlbumChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159262);
    this.Lmu = false;
    init(paramContext);
    AppMethodBeat.o(159262);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(159263);
    paramContext = LayoutInflater.from(paramContext).inflate(2131492954, this, true);
    this.Lms = ((TextView)paramContext.findViewById(2131296544));
    this.Lmt = ((ImageView)paramContext.findViewById(2131296543));
    this.Lmt.setRotation(90.0F);
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159258);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/widget/AlbumChooserView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (AlbumChooserView.a(AlbumChooserView.this) != null) {
          AlbumChooserView.a(AlbumChooserView.this).cYG();
        }
        a.a(this, "com/tencent/mm/ui/widget/AlbumChooserView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159258);
      }
    });
    AppMethodBeat.o(159263);
  }
  
  public void setOnAlbumChooserViewClick(a parama)
  {
    this.Lmv = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cYG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.AlbumChooserView
 * JD-Core Version:    0.7.0.1
 */