package com.tencent.mm.plugin.sns.ui.album;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends RecyclerView.a<b>
{
  List<a.d> zay;
  a zaz;
  
  public c()
  {
    AppMethodBeat.i(99872);
    this.zay = new ArrayList();
    this.zaz = null;
    AppMethodBeat.o(99872);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(99873);
    int i = this.zay.size();
    AppMethodBeat.o(99873);
    return i;
  }
  
  public static abstract interface a
  {
    public abstract void bY(int paramInt, String paramString);
  }
  
  final class b
    extends RecyclerView.w
  {
    public ImageView ig;
    public QDisFadeImageView zaA;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(99871);
      this.zaA = null;
      this.ig = null;
      this.zaA = ((QDisFadeImageView)paramView.findViewById(2131304931));
      this.ig = ((ImageView)paramView.findViewById(2131304932));
      this.ig.setImageDrawable(am.e(this.ig.getContext().getResources().getDrawable(2131690460), -1));
      this.zaA.setScaleType(QImageView.a.JbU);
      this.zaA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99870);
          if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof c.c)) && (c.a(c.this) != null)) {
            c.a(c.this).bY(((c.c)paramAnonymousView.getTag()).dwR, ((c.c)paramAnonymousView.getTag()).mediaId);
          }
          AppMethodBeat.o(99870);
        }
      });
      AppMethodBeat.o(99871);
    }
  }
  
  final class c
  {
    public int dwR;
    public String mediaId;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.c
 * JD-Core Version:    0.7.0.1
 */