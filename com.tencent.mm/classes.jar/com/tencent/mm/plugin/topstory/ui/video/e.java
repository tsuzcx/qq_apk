package com.tencent.mm.plugin.topstory.ui.video;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class e
  extends RecyclerView.a<h>
{
  protected androidx.b.h<View> TLk = new androidx.b.h();
  protected androidx.b.h<View> TLl = new androidx.b.h();
  public Map<String, WeakReference<h>> TLm = new HashMap();
  public b TLn;
  
  public e(b paramb)
  {
    this.TLn = paramb;
  }
  
  protected void I(List<foh> paramList, boolean paramBoolean)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "callbackToSuccess %d %b", new Object[] { Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean) });
  }
  
  public int aoX(int paramInt)
  {
    return 1;
  }
  
  public final boolean aoY(int paramInt)
  {
    return paramInt < this.TLk.size();
  }
  
  public final boolean aoZ(int paramInt)
  {
    return paramInt >= this.TLk.size() + this.TLn.hNK().hOz();
  }
  
  public final h b(foh paramfoh)
  {
    if ((paramfoh != null) && (this.TLm.containsKey(paramfoh.Ido)) && (this.TLm.get(paramfoh.Ido) != null))
    {
      h localh = (h)((WeakReference)this.TLm.get(paramfoh.Ido)).get();
      if ((localh != null) && (localh.TIW != null) && (localh.TIW == paramfoh)) {
        return localh;
      }
      this.TLm.remove(paramfoh.Ido);
      Log.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "getViewHolderByVideoInfo not match");
    }
    return null;
  }
  
  public final void ev(View paramView)
  {
    this.TLk.put(this.TLk.size() + 100000, paramView);
  }
  
  public final int getItemCount()
  {
    return this.TLn.hNK().hOz() + this.TLk.size() + this.TLl.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (aoY(paramInt)) {
      return this.TLk.bo(paramInt);
    }
    if (aoZ(paramInt)) {
      return this.TLl.bo(paramInt - this.TLk.size() - this.TLn.hNK().hOz());
    }
    return aoX(paramInt);
  }
  
  public final int hNP()
  {
    return this.TLk.size();
  }
  
  public final int hNQ()
  {
    return this.TLl.size();
  }
  
  public final void hNR()
  {
    this.TLl.clear();
  }
  
  public final void kn(View paramView)
  {
    this.TLl.put(this.TLl.size() + 200000, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.e
 * JD-Core Version:    0.7.0.1
 */