package com.tencent.mm.plugin.topstory.ui.video;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class e
  extends RecyclerView.a<h>
{
  protected androidx.b.h<View> MYB = new androidx.b.h();
  protected androidx.b.h<View> MYC = new androidx.b.h();
  public Map<String, WeakReference<h>> MYD = new HashMap();
  public b MYE;
  
  public e(b paramb)
  {
    this.MYE = paramb;
  }
  
  public int ajE(int paramInt)
  {
    return 1;
  }
  
  public final boolean ajF(int paramInt)
  {
    return paramInt < this.MYB.size();
  }
  
  public final boolean ajG(int paramInt)
  {
    return paramInt >= this.MYB.size() + this.MYE.gqL().grz();
  }
  
  public final h b(esy paramesy)
  {
    if ((paramesy != null) && (this.MYD.containsKey(paramesy.Crh)) && (this.MYD.get(paramesy.Crh) != null))
    {
      h localh = (h)((WeakReference)this.MYD.get(paramesy.Crh)).get();
      if ((localh != null) && (localh.MWs != null) && (localh.MWs == paramesy)) {
        return localh;
      }
      this.MYD.remove(paramesy.Crh);
      Log.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "getViewHolderByVideoInfo not match");
    }
    return null;
  }
  
  public final void dI(View paramView)
  {
    this.MYB.put(this.MYB.size() + 100000, paramView);
  }
  
  public final int getItemCount()
  {
    return this.MYE.gqL().grz() + this.MYB.size() + this.MYC.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (ajF(paramInt)) {
      return this.MYB.aP(paramInt);
    }
    if (ajG(paramInt)) {
      return this.MYC.aP(paramInt - this.MYB.size() - this.MYE.gqL().grz());
    }
    return ajE(paramInt);
  }
  
  public final int gqR()
  {
    return this.MYB.size();
  }
  
  public final int gqS()
  {
    return this.MYC.size();
  }
  
  public final void gqT()
  {
    this.MYC.clear();
  }
  
  public final void hc(View paramView)
  {
    this.MYC.put(this.MYC.size() + 200000, paramView);
  }
  
  protected void u(List<esy> paramList, boolean paramBoolean)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "callbackToSuccess %d %b", new Object[] { Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.e
 * JD-Core Version:    0.7.0.1
 */