package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class AlbumChooserView
  extends LinearLayout
{
  public TextView XZZ;
  public WeImageView Yaa;
  public boolean Yab;
  private a Yac;
  
  public AlbumChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159261);
    this.Yab = false;
    init(paramContext);
    AppMethodBeat.o(159261);
  }
  
  public AlbumChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159262);
    this.Yab = false;
    init(paramContext);
    AppMethodBeat.o(159262);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(159263);
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.album_chooser, this, true);
    this.XZZ = ((TextView)paramContext.findViewById(a.f.album_chooser_txt));
    this.Yaa = ((WeImageView)paramContext.findViewById(a.f.album_chooser_icon));
    this.Yaa.setRotation(90.0F);
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159258);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/widget/AlbumChooserView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (AlbumChooserView.a(AlbumChooserView.this) != null) {
          AlbumChooserView.a(AlbumChooserView.this).euC();
        }
        a.a(this, "com/tencent/mm/ui/widget/AlbumChooserView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159258);
      }
    });
    AppMethodBeat.o(159263);
  }
  
  public void setOnAlbumChooserViewClick(a parama)
  {
    this.Yac = parama;
  }
  
  public static abstract interface a
  {
    public abstract void euC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.AlbumChooserView
 * JD-Core Version:    0.7.0.1
 */