package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.bi;

public abstract class a
{
  protected c zJI;
  
  public a(c paramc)
  {
    this.zJI = paramc;
  }
  
  public final k PP(int paramInt)
  {
    if (this.zJI == null) {
      return null;
    }
    View localView = this.zJI.Gm(paramInt);
    if (localView == null) {
      return null;
    }
    return (k)((View)localView).getTag();
  }
  
  public final void PQ(int paramInt)
  {
    if (this.zJI == null) {}
    View localView;
    do
    {
      return;
      localView = this.zJI.Gm(paramInt);
    } while ((localView == null) || (localView.getTag() == null));
    a((k)localView.getTag(), this.zJI.Pz(paramInt), paramInt);
  }
  
  public boolean a(k paramk, bi parambi, int paramInt)
  {
    return false;
  }
  
  public void detach()
  {
    this.zJI = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a
 * JD-Core Version:    0.7.0.1
 */