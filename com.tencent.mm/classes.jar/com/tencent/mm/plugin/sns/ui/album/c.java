package com.tencent.mm.plugin.sns.ui.album;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends RecyclerView.a<b>
{
  List<a.d> Lhy;
  a Lhz;
  
  public c()
  {
    AppMethodBeat.i(99872);
    this.Lhy = new ArrayList();
    this.Lhz = null;
    AppMethodBeat.o(99872);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(99873);
    int i = this.Lhy.size();
    AppMethodBeat.o(99873);
    return i;
  }
  
  public static abstract interface a
  {
    public abstract void cx(int paramInt, String paramString);
  }
  
  final class b
    extends RecyclerView.v
  {
    public QDisFadeImageView LhA;
    public ImageView bwJ;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(99871);
      this.LhA = null;
      this.bwJ = null;
      this.LhA = ((QDisFadeImageView)paramView.findViewById(i.f.sns_album_item_media_img));
      this.bwJ = ((ImageView)paramView.findViewById(i.f.sns_album_item_media_play_icon));
      this.bwJ.setImageDrawable(this.bwJ.getContext().getResources().getDrawable(i.i.shortvideo_play_btn));
      this.LhA.setScaleType(QImageView.a.Ydm);
      this.LhA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99870);
          b localb = new b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/sns/ui/album/SnsAlbumItemAdapter$SnsAlbumItemViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof c.c)) && (c.a(c.this) != null)) {
            c.a(c.this).cx(((c.c)paramAnonymousView.getTag()).fWh, ((c.c)paramAnonymousView.getTag()).mediaId);
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
    public int fWh;
    public String mediaId;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.c
 * JD-Core Version:    0.7.0.1
 */