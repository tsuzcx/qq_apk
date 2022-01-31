package com.tencent.mm.ui.widget.a;

import android.support.v7.widget.RecyclerView.a;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.base.l;

public final class d$b
  extends RecyclerView.a<d.b.a>
{
  AdapterView.OnItemClickListener aeW;
  
  public d$b(d paramd) {}
  
  public final int getItemCount()
  {
    if (d.w(this.wnq)) {
      return d.b(this.wnq).size() + d.d(this.wnq).size() + 1;
    }
    return d.b(this.wnq).size() + d.d(this.wnq).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.d.b
 * JD-Core Version:    0.7.0.1
 */