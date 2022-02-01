package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.ca;

public abstract class a
{
  protected f WQM;
  
  public a(f paramf)
  {
    this.WQM = paramf;
  }
  
  public boolean a(p paramp, ca paramca, int paramInt)
  {
    return false;
  }
  
  public p avN(int paramInt)
  {
    if (this.WQM == null) {
      return null;
    }
    View localView = this.WQM.aiI(paramInt);
    if (localView == null) {
      return null;
    }
    return (p)((View)localView).getTag();
  }
  
  public final void avO(int paramInt)
  {
    if (this.WQM == null) {}
    View localView;
    do
    {
      return;
      localView = this.WQM.aiI(paramInt);
    } while ((localView == null) || (localView.getTag() == null));
    a((p)localView.getTag(), this.WQM.avt(paramInt), paramInt);
  }
  
  public void detach()
  {
    this.WQM = null;
  }
  
  protected void onPause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a
 * JD-Core Version:    0.7.0.1
 */