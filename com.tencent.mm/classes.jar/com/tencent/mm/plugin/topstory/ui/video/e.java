package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v4.e.o;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class e
  extends RecyclerView.a<h>
{
  protected o<View> Aca = new o();
  protected o<View> Acb = new o();
  public Map<String, WeakReference<h>> Acc = new HashMap();
  public b Acd;
  
  public e(b paramb)
  {
    this.Acd = paramb;
  }
  
  public int Rr(int paramInt)
  {
    return 1;
  }
  
  public final boolean Rs(int paramInt)
  {
    return paramInt < this.Aca.size();
  }
  
  public final boolean Rt(int paramInt)
  {
    return paramInt >= this.Aca.size() + this.Acd.edt().eee();
  }
  
  public final void addHeaderView(View paramView)
  {
    this.Aca.put(this.Aca.size() + 100000, paramView);
  }
  
  public final h b(dio paramdio)
  {
    if ((paramdio != null) && (this.Acc.containsKey(paramdio.sVF)) && (this.Acc.get(paramdio.sVF) != null))
    {
      h localh = (h)((WeakReference)this.Acc.get(paramdio.sVF)).get();
      if ((localh != null) && (localh.zZN != null) && (localh.zZN == paramdio)) {
        return localh;
      }
      this.Acc.remove(paramdio.sVF);
      ac.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "getViewHolderByVideoInfo not match");
    }
    return null;
  }
  
  public final void edz()
  {
    this.Acb.clear();
  }
  
  public final void fp(View paramView)
  {
    this.Acb.put(this.Acb.size() + 200000, paramView);
  }
  
  public final int getFootersCount()
  {
    return this.Acb.size();
  }
  
  public final int getHeadersCount()
  {
    return this.Aca.size();
  }
  
  public final int getItemCount()
  {
    return this.Acd.edt().eee() + this.Aca.size() + this.Acb.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (Rs(paramInt)) {
      return this.Aca.keyAt(paramInt);
    }
    if (Rt(paramInt)) {
      return this.Acb.keyAt(paramInt - this.Aca.size() - this.Acd.edt().eee());
    }
    return Rr(paramInt);
  }
  
  protected void n(List<dio> paramList, boolean paramBoolean)
  {
    ac.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "callbackToSuccess %d %b", new Object[] { Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.e
 * JD-Core Version:    0.7.0.1
 */