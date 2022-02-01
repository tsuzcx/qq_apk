package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v4.e.o;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class e
  extends RecyclerView.a<h>
{
  protected o<View> yOj = new o();
  protected o<View> yOk = new o();
  public Map<String, WeakReference<h>> yOl = new HashMap();
  public b yOm;
  
  public e(b paramb)
  {
    this.yOm = paramb;
  }
  
  public int Pl(int paramInt)
  {
    return 1;
  }
  
  public final boolean Pm(int paramInt)
  {
    return paramInt < this.yOj.size();
  }
  
  public final boolean Pn(int paramInt)
  {
    return paramInt >= this.yOj.size() + this.yOm.dOT().dPF();
  }
  
  public final void addHeaderView(View paramView)
  {
    this.yOj.put(this.yOj.size() + 100000, paramView);
  }
  
  public final h b(ddb paramddb)
  {
    if ((paramddb != null) && (this.yOl.containsKey(paramddb.rNP)) && (this.yOl.get(paramddb.rNP) != null))
    {
      h localh = (h)((WeakReference)this.yOl.get(paramddb.rNP)).get();
      if ((localh != null) && (localh.yLU != null) && (localh.yLU == paramddb)) {
        return localh;
      }
      this.yOl.remove(paramddb.rNP);
      ad.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "getViewHolderByVideoInfo not match");
    }
    return null;
  }
  
  public final void dOZ()
  {
    this.yOk.clear();
  }
  
  public final void fc(View paramView)
  {
    this.yOk.put(this.yOk.size() + 200000, paramView);
  }
  
  public final int getFootersCount()
  {
    return this.yOk.size();
  }
  
  public final int getHeadersCount()
  {
    return this.yOj.size();
  }
  
  public final int getItemCount()
  {
    return this.yOm.dOT().dPF() + this.yOj.size() + this.yOk.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (Pm(paramInt)) {
      return this.yOj.keyAt(paramInt);
    }
    if (Pn(paramInt)) {
      return this.yOk.keyAt(paramInt - this.yOj.size() - this.yOm.dOT().dPF());
    }
    return Pl(paramInt);
  }
  
  protected void m(List<ddb> paramList, boolean paramBoolean)
  {
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "callbackToSuccess %d %b", new Object[] { Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.e
 * JD-Core Version:    0.7.0.1
 */