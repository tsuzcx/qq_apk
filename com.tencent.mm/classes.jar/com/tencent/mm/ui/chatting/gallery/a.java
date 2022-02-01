package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.cc;

public abstract class a
{
  protected h aeAg;
  
  public a(h paramh)
  {
    this.aeAg = paramh;
  }
  
  public boolean a(r paramr, cc paramcc, int paramInt)
  {
    return false;
  }
  
  public r aCt(int paramInt)
  {
    if (this.aeAg == null) {
      return null;
    }
    View localView = this.aeAg.aAZ(paramInt);
    if (localView == null) {
      return null;
    }
    return (r)((View)localView).getTag();
  }
  
  public final void aCu(int paramInt)
  {
    if (this.aeAg == null) {}
    View localView;
    do
    {
      return;
      localView = this.aeAg.aAZ(paramInt);
    } while ((localView == null) || (localView.getTag() == null));
    a((r)localView.getTag(), this.aeAg.aBV(paramInt), paramInt);
  }
  
  public void detach()
  {
    this.aeAg = null;
  }
  
  protected void onPause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a
 * JD-Core Version:    0.7.0.1
 */