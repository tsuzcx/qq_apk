package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.bl;

public abstract class a
{
  protected b GzZ;
  
  public a(b paramb)
  {
    this.GzZ = paramb;
  }
  
  public final k YW(int paramInt)
  {
    if (this.GzZ == null) {
      return null;
    }
    View localView = this.GzZ.OT(paramInt);
    if (localView == null) {
      return null;
    }
    return (k)((View)localView).getTag();
  }
  
  public final void YX(int paramInt)
  {
    if (this.GzZ == null) {}
    View localView;
    do
    {
      return;
      localView = this.GzZ.OT(paramInt);
    } while ((localView == null) || (localView.getTag() == null));
    a((k)localView.getTag(), this.GzZ.YE(paramInt), paramInt);
  }
  
  public boolean a(k paramk, bl parambl, int paramInt)
  {
    return false;
  }
  
  public void detach()
  {
    this.GzZ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a
 * JD-Core Version:    0.7.0.1
 */