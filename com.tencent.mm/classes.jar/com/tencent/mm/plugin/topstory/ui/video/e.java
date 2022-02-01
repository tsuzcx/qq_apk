package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v4.e.o;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class e
  extends RecyclerView.a<h>
{
  protected o<View> BLj = new o();
  protected o<View> BLk = new o();
  public Map<String, WeakReference<h>> BLl = new HashMap();
  public b BLm;
  
  public e(b paramb)
  {
    this.BLm = paramb;
  }
  
  public int TI(int paramInt)
  {
    return 1;
  }
  
  public final boolean TJ(int paramInt)
  {
    return paramInt < this.BLj.size();
  }
  
  public final boolean TK(int paramInt)
  {
    return paramInt >= this.BLj.size() + this.BLm.ets().euc();
  }
  
  public final void addHeaderView(View paramView)
  {
    this.BLj.put(this.BLj.size() + 100000, paramView);
  }
  
  public final h b(dpa paramdpa)
  {
    if ((paramdpa != null) && (this.BLl.containsKey(paramdpa.udb)) && (this.BLl.get(paramdpa.udb) != null))
    {
      h localh = (h)((WeakReference)this.BLl.get(paramdpa.udb)).get();
      if ((localh != null) && (localh.BIY != null) && (localh.BIY == paramdpa)) {
        return localh;
      }
      this.BLl.remove(paramdpa.udb);
      ae.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "getViewHolderByVideoInfo not match");
    }
    return null;
  }
  
  public final void ety()
  {
    this.BLk.clear();
  }
  
  public final void fB(View paramView)
  {
    this.BLk.put(this.BLk.size() + 200000, paramView);
  }
  
  public final int getFootersCount()
  {
    return this.BLk.size();
  }
  
  public final int getHeadersCount()
  {
    return this.BLj.size();
  }
  
  public final int getItemCount()
  {
    return this.BLm.ets().euc() + this.BLj.size() + this.BLk.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (TJ(paramInt)) {
      return this.BLj.keyAt(paramInt);
    }
    if (TK(paramInt)) {
      return this.BLk.keyAt(paramInt - this.BLj.size() - this.BLm.ets().euc());
    }
    return TI(paramInt);
  }
  
  protected void o(List<dpa> paramList, boolean paramBoolean)
  {
    ae.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "callbackToSuccess %d %b", new Object[] { Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.e
 * JD-Core Version:    0.7.0.1
 */