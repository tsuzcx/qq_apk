package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public abstract class e
  extends RecyclerView.a<h>
{
  public android.support.v4.f.n<View> pEn = new android.support.v4.f.n();
  public android.support.v4.f.n<View> pEo = new android.support.v4.f.n();
  public b pEp;
  
  public e(b paramb)
  {
    this.pEp = paramb;
  }
  
  public final void dl(View paramView)
  {
    this.pEo.put(this.pEo.size() + 200000, paramView);
  }
  
  public void g(List<byg> paramList, boolean paramBoolean)
  {
    y.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "callbackToSuccess %d %b", new Object[] { Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean) });
  }
  
  public final int getHeadersCount()
  {
    return this.pEn.size();
  }
  
  public final int getItemCount()
  {
    return this.pEp.bNJ().cVn() + this.pEn.size() + this.pEo.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (zB(paramInt)) {
      return this.pEn.keyAt(paramInt);
    }
    if (zC(paramInt)) {
      return this.pEo.keyAt(paramInt - this.pEn.size() - this.pEp.bNJ().cVn());
    }
    return zA(paramInt);
  }
  
  public int zA(int paramInt)
  {
    return 1;
  }
  
  public final boolean zB(int paramInt)
  {
    return paramInt < this.pEn.size();
  }
  
  public final boolean zC(int paramInt)
  {
    return paramInt >= this.pEn.size() + this.pEp.bNJ().cVn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.e
 * JD-Core Version:    0.7.0.1
 */