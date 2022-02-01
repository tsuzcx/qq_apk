package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.ca;

public abstract class a
{
  protected b Pwu;
  
  public a(b paramb)
  {
    this.Pwu = paramb;
  }
  
  public boolean a(k paramk, ca paramca, int paramInt)
  {
    return false;
  }
  
  public final k amM(int paramInt)
  {
    if (this.Pwu == null) {
      return null;
    }
    View localView = this.Pwu.abm(paramInt);
    if (localView == null) {
      return null;
    }
    return (k)((View)localView).getTag();
  }
  
  public final void amN(int paramInt)
  {
    if (this.Pwu == null) {}
    View localView;
    do
    {
      return;
      localView = this.Pwu.abm(paramInt);
    } while ((localView == null) || (localView.getTag() == null));
    a((k)localView.getTag(), this.Pwu.amt(paramInt), paramInt);
  }
  
  public void detach()
  {
    this.Pwu = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a
 * JD-Core Version:    0.7.0.1
 */