package com.tencent.mm.plugin.sns.ui.album;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;

final class a$1
  implements b.a
{
  a$1(a parama) {}
  
  public final void dp(List<a.b> paramList)
  {
    int j = 0;
    AppMethodBeat.i(39959);
    if (paramList == null) {}
    Object localObject;
    for (int i = 0;; i = paramList.size())
    {
      ab.d("MicroMsg.SnsAlbumAdapter", "onLoadingFinish list.size=%s", new Object[] { Integer.valueOf(i) });
      this.sep.sed.clear();
      localObject = new a.b();
      ((a.b)localObject).label = "my_timeline";
      this.sep.sed.add(localObject);
      this.sep.sed.addAll(paramList);
      localObject = this.sep;
      Iterator localIterator = this.sep.sed.iterator();
      i = j;
      while (localIterator.hasNext()) {
        i += ((a.b)localIterator.next()).seq.size();
      }
    }
    ((a)localObject).sel = i;
    if (!paramList.isEmpty())
    {
      localObject = new a.b();
      ((a.b)localObject).label = "loading";
      this.sep.sed.add(localObject);
    }
    this.sep.ajb.notifyChanged();
    if (this.sep.seo != null) {
      this.sep.seo.dq(paramList);
    }
    AppMethodBeat.o(39959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a.1
 * JD-Core Version:    0.7.0.1
 */