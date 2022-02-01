package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.bv;

public abstract class a
{
  protected b Kkv;
  
  public a(b paramb)
  {
    this.Kkv = paramb;
  }
  
  public boolean a(k paramk, bv parambv, int paramInt)
  {
    return false;
  }
  
  public final k aeb(int paramInt)
  {
    if (this.Kkv == null) {
      return null;
    }
    View localView = this.Kkv.Tq(paramInt);
    if (localView == null) {
      return null;
    }
    return (k)((View)localView).getTag();
  }
  
  public final void aec(int paramInt)
  {
    if (this.Kkv == null) {}
    View localView;
    do
    {
      return;
      localView = this.Kkv.Tq(paramInt);
    } while ((localView == null) || (localView.getTag() == null));
    a((k)localView.getTag(), this.Kkv.adI(paramInt), paramInt);
  }
  
  public void detach()
  {
    this.Kkv = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a
 * JD-Core Version:    0.7.0.1
 */