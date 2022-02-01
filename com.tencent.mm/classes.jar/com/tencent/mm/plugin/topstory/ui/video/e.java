package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v4.e.o;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class e
  extends RecyclerView.a<h>
{
  protected o<View> GlP = new o();
  protected o<View> GlQ = new o();
  public Map<String, WeakReference<h>> GlR = new HashMap();
  public b GlS;
  
  public e(b paramb)
  {
    this.GlS = paramb;
  }
  
  public int abY(int paramInt)
  {
    return 1;
  }
  
  public final boolean abZ(int paramInt)
  {
    return paramInt < this.GlP.size();
  }
  
  public final boolean aca(int paramInt)
  {
    return paramInt >= this.GlP.size() + this.GlS.fyO().fzy();
  }
  
  public final void addHeaderView(View paramView)
  {
    this.GlP.put(this.GlP.size() + 100000, paramView);
  }
  
  public final h b(eiw parameiw)
  {
    if ((parameiw != null) && (this.GlR.containsKey(parameiw.psI)) && (this.GlR.get(parameiw.psI) != null))
    {
      h localh = (h)((WeakReference)this.GlR.get(parameiw.psI)).get();
      if ((localh != null) && (localh.GjH != null) && (localh.GjH == parameiw)) {
        return localh;
      }
      this.GlR.remove(parameiw.psI);
      Log.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "getViewHolderByVideoInfo not match");
    }
    return null;
  }
  
  public final void fT(View paramView)
  {
    this.GlQ.put(this.GlQ.size() + 200000, paramView);
  }
  
  public final void fyU()
  {
    this.GlQ.clear();
  }
  
  public final int getFootersCount()
  {
    return this.GlQ.size();
  }
  
  public final int getHeadersCount()
  {
    return this.GlP.size();
  }
  
  public final int getItemCount()
  {
    return this.GlS.fyO().fzy() + this.GlP.size() + this.GlQ.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (abZ(paramInt)) {
      return this.GlP.keyAt(paramInt);
    }
    if (aca(paramInt)) {
      return this.GlQ.keyAt(paramInt - this.GlP.size() - this.GlS.fyO().fzy());
    }
    return abY(paramInt);
  }
  
  protected void t(List<eiw> paramList, boolean paramBoolean)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "callbackToSuccess %d %b", new Object[] { Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.e
 * JD-Core Version:    0.7.0.1
 */