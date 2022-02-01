package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class AlbumChooserView
  extends LinearLayout
{
  public TextView afRU;
  public WeImageView afRV;
  public boolean afRW;
  private a afRX;
  
  public AlbumChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159261);
    this.afRW = false;
    init(paramContext);
    AppMethodBeat.o(159261);
  }
  
  public AlbumChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159262);
    this.afRW = false;
    init(paramContext);
    AppMethodBeat.o(159262);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(159263);
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.album_chooser, this, true);
    this.afRU = ((TextView)paramContext.findViewById(a.f.album_chooser_txt));
    this.afRV = ((WeImageView)paramContext.findViewById(a.f.album_chooser_icon));
    this.afRV.setRotation(90.0F);
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159258);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/widget/AlbumChooserView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (AlbumChooserView.a(AlbumChooserView.this) != null) {
          AlbumChooserView.a(AlbumChooserView.this).onAlbumChooserViewClick();
        }
        a.a(this, "com/tencent/mm/ui/widget/AlbumChooserView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159258);
      }
    });
    AppMethodBeat.o(159263);
  }
  
  public void setOnAlbumChooserViewClick(a parama)
  {
    this.afRX = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onAlbumChooserViewClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.AlbumChooserView
 * JD-Core Version:    0.7.0.1
 */