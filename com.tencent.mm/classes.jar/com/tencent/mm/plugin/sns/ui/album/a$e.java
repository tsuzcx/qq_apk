package com.tencent.mm.plugin.sns.ui.album;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class a$e
  extends RecyclerView.v
{
  private TextView set;
  private WeImageView seu;
  
  public a$e(a parama, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(39964);
    this.set = null;
    this.seu = null;
    this.set = ((TextView)paramView.findViewById(2131827897));
    this.seu = ((WeImageView)paramView.findViewById(2131827898));
    this.set.setOnClickListener(new a.e.1(this, parama));
    AppMethodBeat.o(39964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a.e
 * JD-Core Version:    0.7.0.1
 */