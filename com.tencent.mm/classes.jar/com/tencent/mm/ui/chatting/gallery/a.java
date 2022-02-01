package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.bo;

public abstract class a
{
  protected b HZU;
  
  public a(b paramb)
  {
    this.HZU = paramb;
  }
  
  public boolean a(k paramk, bo parambo, int paramInt)
  {
    return false;
  }
  
  public final k abi(int paramInt)
  {
    if (this.HZU == null) {
      return null;
    }
    View localView = this.HZU.QZ(paramInt);
    if (localView == null) {
      return null;
    }
    return (k)((View)localView).getTag();
  }
  
  public final void abj(int paramInt)
  {
    if (this.HZU == null) {}
    View localView;
    do
    {
      return;
      localView = this.HZU.QZ(paramInt);
    } while ((localView == null) || (localView.getTag() == null));
    a((k)localView.getTag(), this.HZU.aaP(paramInt), paramInt);
  }
  
  public void detach()
  {
    this.HZU = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a
 * JD-Core Version:    0.7.0.1
 */