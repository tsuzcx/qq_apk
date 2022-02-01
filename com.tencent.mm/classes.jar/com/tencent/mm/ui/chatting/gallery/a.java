package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.bu;

public abstract class a
{
  protected b JPj;
  
  public a(b paramb)
  {
    this.JPj = paramb;
  }
  
  public boolean a(k paramk, bu parambu, int paramInt)
  {
    return false;
  }
  
  public final k adu(int paramInt)
  {
    if (this.JPj == null) {
      return null;
    }
    View localView = this.JPj.SJ(paramInt);
    if (localView == null) {
      return null;
    }
    return (k)((View)localView).getTag();
  }
  
  public final void adv(int paramInt)
  {
    if (this.JPj == null) {}
    View localView;
    do
    {
      return;
      localView = this.JPj.SJ(paramInt);
    } while ((localView == null) || (localView.getTag() == null));
    a((k)localView.getTag(), this.JPj.ada(paramInt), paramInt);
  }
  
  public void detach()
  {
    this.JPj = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a
 * JD-Core Version:    0.7.0.1
 */