package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.bi;

public abstract class a
{
  protected c vtH;
  
  public a(c paramc)
  {
    this.vtH = paramc;
  }
  
  public final k Hi(int paramInt)
  {
    if (this.vtH == null) {
      return null;
    }
    View localView = this.vtH.Gs(paramInt);
    if (localView == null) {
      return null;
    }
    return (k)((View)localView).getTag();
  }
  
  public final void Hj(int paramInt)
  {
    if (this.vtH == null) {}
    View localView;
    do
    {
      return;
      localView = this.vtH.Gs(paramInt);
    } while ((localView == null) || (localView.getTag() == null));
    a((k)localView.getTag(), this.vtH.GW(paramInt), paramInt);
  }
  
  public boolean a(k paramk, bi parambi, int paramInt)
  {
    return false;
  }
  
  public void detach()
  {
    this.vtH = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a
 * JD-Core Version:    0.7.0.1
 */