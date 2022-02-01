package com.tencent.mm.plugin.sns.ui.album;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends RecyclerView.a<b>
{
  List<a.d> AJD;
  a AJE;
  
  public c()
  {
    AppMethodBeat.i(99872);
    this.AJD = new ArrayList();
    this.AJE = null;
    AppMethodBeat.o(99872);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(99873);
    int i = this.AJD.size();
    AppMethodBeat.o(99873);
    return i;
  }
  
  public static abstract interface a
  {
    public abstract void cf(int paramInt, String paramString);
  }
  
  final class b
    extends RecyclerView.w
  {
    public QDisFadeImageView AJF;
    public ImageView ka;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(99871);
      this.AJF = null;
      this.ka = null;
      this.AJF = ((QDisFadeImageView)paramView.findViewById(2131304931));
      this.ka = ((ImageView)paramView.findViewById(2131304932));
      this.ka.setImageDrawable(this.ka.getContext().getResources().getDrawable(2131691166));
      this.AJF.setScaleType(QImageView.a.Lpz);
      this.AJF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99870);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/sns/ui/album/SnsAlbumItemAdapter$SnsAlbumItemViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof c.c)) && (c.a(c.this) != null)) {
            c.a(c.this).cf(((c.c)paramAnonymousView.getTag()).dKr, ((c.c)paramAnonymousView.getTag()).mediaId);
          }
          a.a(this, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumItemAdapter$SnsAlbumItemViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99870);
        }
      });
      AppMethodBeat.o(99871);
    }
  }
  
  final class c
  {
    public int dKr;
    public String mediaId;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.c
 * JD-Core Version:    0.7.0.1
 */