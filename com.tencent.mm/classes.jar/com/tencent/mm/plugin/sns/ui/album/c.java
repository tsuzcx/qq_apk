package com.tencent.mm.plugin.sns.ui.album;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
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
  List<a.d> ETw;
  c.a ETx;
  
  public c()
  {
    AppMethodBeat.i(99872);
    this.ETw = new ArrayList();
    this.ETx = null;
    AppMethodBeat.o(99872);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(99873);
    int i = this.ETw.size();
    AppMethodBeat.o(99873);
    return i;
  }
  
  final class b
    extends RecyclerView.v
  {
    public QDisFadeImageView ETy;
    public ImageView kc;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(99871);
      this.ETy = null;
      this.kc = null;
      this.ETy = ((QDisFadeImageView)paramView.findViewById(2131308070));
      this.kc = ((ImageView)paramView.findViewById(2131308071));
      this.kc.setImageDrawable(this.kc.getContext().getResources().getDrawable(2131691480));
      this.ETy.setScaleType(QImageView.a.QEL);
      this.ETy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99870);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/sns/ui/album/SnsAlbumItemAdapter$SnsAlbumItemViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof c.c)) && (c.a(c.this) != null)) {
            c.a(c.this).cw(((c.c)paramAnonymousView.getTag()).ecf, ((c.c)paramAnonymousView.getTag()).mediaId);
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
    public int ecf;
    public String mediaId;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.c
 * JD-Core Version:    0.7.0.1
 */