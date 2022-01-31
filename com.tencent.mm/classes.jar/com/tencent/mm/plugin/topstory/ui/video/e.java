package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class e
  extends RecyclerView.a<h>
{
  protected android.support.v4.e.n<View> thJ = new android.support.v4.e.n();
  protected android.support.v4.e.n<View> thK = new android.support.v4.e.n();
  public Map<ckx, h> thL = new HashMap();
  public b thM;
  
  public e(b paramb)
  {
    this.thM = paramb;
  }
  
  public int GD(int paramInt)
  {
    return 1;
  }
  
  public final boolean GE(int paramInt)
  {
    return paramInt < this.thJ.size();
  }
  
  public final boolean GF(int paramInt)
  {
    return paramInt >= this.thJ.size() + this.thM.cJs().cKc();
  }
  
  public final void addHeaderView(View paramView)
  {
    this.thJ.put(this.thJ.size() + 100000, paramView);
  }
  
  public final h b(ckx paramckx)
  {
    if (this.thL.containsKey(paramckx))
    {
      h localh = (h)this.thL.get(paramckx);
      if ((localh != null) && (localh.tfm != null) && (localh.tfm == paramckx)) {
        return localh;
      }
      this.thL.remove(paramckx);
      ab.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "getViewHolderByVideoInfo not match");
    }
    return null;
  }
  
  public final void cJy()
  {
    this.thK.clear();
  }
  
  public final void eo(View paramView)
  {
    this.thK.put(this.thK.size() + 200000, paramView);
  }
  
  public final int getFootersCount()
  {
    return this.thK.size();
  }
  
  public final int getHeadersCount()
  {
    return this.thJ.size();
  }
  
  public final int getItemCount()
  {
    return this.thM.cJs().cKc() + this.thJ.size() + this.thK.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (GE(paramInt)) {
      return this.thJ.keyAt(paramInt);
    }
    if (GF(paramInt)) {
      return this.thK.keyAt(paramInt - this.thJ.size() - this.thM.cJs().cKc());
    }
    return GD(paramInt);
  }
  
  protected void l(List<ckx> paramList, boolean paramBoolean)
  {
    ab.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "callbackToSuccess %d %b", new Object[] { Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.e
 * JD-Core Version:    0.7.0.1
 */