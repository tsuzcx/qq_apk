package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v4.e.o;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class e
  extends RecyclerView.a<h>
{
  protected o<View> BtL = new o();
  protected o<View> BtM = new o();
  public Map<String, WeakReference<h>> BtN = new HashMap();
  public b BtO;
  
  public e(b paramb)
  {
    this.BtO = paramb;
  }
  
  public int Tb(int paramInt)
  {
    return 1;
  }
  
  public final boolean Tc(int paramInt)
  {
    return paramInt < this.BtL.size();
  }
  
  public final boolean Td(int paramInt)
  {
    return paramInt >= this.BtL.size() + this.BtO.epL().eqv();
  }
  
  public final void addHeaderView(View paramView)
  {
    this.BtL.put(this.BtL.size() + 100000, paramView);
  }
  
  public final h b(dod paramdod)
  {
    if ((paramdod != null) && (this.BtN.containsKey(paramdod.tSk)) && (this.BtN.get(paramdod.tSk) != null))
    {
      h localh = (h)((WeakReference)this.BtN.get(paramdod.tSk)).get();
      if ((localh != null) && (localh.Brz != null) && (localh.Brz == paramdod)) {
        return localh;
      }
      this.BtN.remove(paramdod.tSk);
      ad.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "getViewHolderByVideoInfo not match");
    }
    return null;
  }
  
  public final void epR()
  {
    this.BtM.clear();
  }
  
  public final void fC(View paramView)
  {
    this.BtM.put(this.BtM.size() + 200000, paramView);
  }
  
  public final int getFootersCount()
  {
    return this.BtM.size();
  }
  
  public final int getHeadersCount()
  {
    return this.BtL.size();
  }
  
  public final int getItemCount()
  {
    return this.BtO.epL().eqv() + this.BtL.size() + this.BtM.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (Tc(paramInt)) {
      return this.BtL.keyAt(paramInt);
    }
    if (Td(paramInt)) {
      return this.BtM.keyAt(paramInt - this.BtL.size() - this.BtO.epL().eqv());
    }
    return Tb(paramInt);
  }
  
  protected void o(List<dod> paramList, boolean paramBoolean)
  {
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "callbackToSuccess %d %b", new Object[] { Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.e
 * JD-Core Version:    0.7.0.1
 */