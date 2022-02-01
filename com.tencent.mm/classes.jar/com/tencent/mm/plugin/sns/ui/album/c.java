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
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends RecyclerView.a<b>
{
  List<a.d> RHN;
  c.a RHO;
  
  public c()
  {
    AppMethodBeat.i(99872);
    this.RHN = new ArrayList();
    this.RHO = null;
    AppMethodBeat.o(99872);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(99873);
    int i = this.RHN.size();
    AppMethodBeat.o(99873);
    return i;
  }
  
  final class b
    extends RecyclerView.v
  {
    public QDisFadeImageView RHP;
    public ImageView dpM;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(99871);
      this.RHP = null;
      this.dpM = null;
      this.RHP = ((QDisFadeImageView)paramView.findViewById(b.f.sns_album_item_media_img));
      this.dpM = ((ImageView)paramView.findViewById(b.f.sns_album_item_media_play_icon));
      this.dpM.setImageDrawable(this.dpM.getContext().getResources().getDrawable(b.i.shortvideo_play_btn));
      this.RHP.setScaleType(QImageView.a.afVc);
      this.RHP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99870);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/sns/ui/album/SnsAlbumItemAdapter$SnsAlbumItemViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof c.c)) && (c.a(c.this) != null)) {
            c.a(c.this).dk(((c.c)paramAnonymousView.getTag()).icg, ((c.c)paramAnonymousView.getTag()).mediaId);
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
    public int icg;
    public String mediaId;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.c
 * JD-Core Version:    0.7.0.1
 */