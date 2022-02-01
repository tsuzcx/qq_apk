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
  List<a.d> Asp;
  a Asq;
  
  public c()
  {
    AppMethodBeat.i(99872);
    this.Asp = new ArrayList();
    this.Asq = null;
    AppMethodBeat.o(99872);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(99873);
    int i = this.Asp.size();
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
    public QDisFadeImageView Asr;
    public ImageView ka;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(99871);
      this.Asr = null;
      this.ka = null;
      this.Asr = ((QDisFadeImageView)paramView.findViewById(2131304931));
      this.ka = ((ImageView)paramView.findViewById(2131304932));
      this.ka.setImageDrawable(this.ka.getContext().getResources().getDrawable(2131691166));
      this.Asr.setScaleType(QImageView.a.KTb);
      this.Asr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99870);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/sns/ui/album/SnsAlbumItemAdapter$SnsAlbumItemViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof c.c)) && (c.a(c.this) != null)) {
            c.a(c.this).cf(((c.c)paramAnonymousView.getTag()).dJd, ((c.c)paramAnonymousView.getTag()).mediaId);
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
    public int dJd;
    public String mediaId;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.c
 * JD-Core Version:    0.7.0.1
 */