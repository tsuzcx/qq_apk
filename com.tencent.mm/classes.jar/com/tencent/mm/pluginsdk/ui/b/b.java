package com.tencent.mm.pluginsdk.ui.b;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;

public abstract class b
  implements a
{
  public boolean eUx = false;
  public boolean nwf = false;
  public WeakReference<Context> vUD = null;
  public View view = null;
  
  public b(Context paramContext)
  {
    this.vUD = new WeakReference(paramContext);
    if (getLayoutId() > 0) {
      this.view = View.inflate((Context)this.vUD.get(), getLayoutId(), null);
    }
  }
  
  public boolean aMK()
  {
    return (this.view != null) && (this.view.getVisibility() == 0);
  }
  
  public abstract void destroy();
  
  public abstract int getLayoutId();
  
  public int getOrder()
  {
    return 0;
  }
  
  public View getView()
  {
    return this.view;
  }
  
  public void release() {}
  
  public void setVisibility(int paramInt)
  {
    if (getView() != null) {
      getView().setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.b.b
 * JD-Core Version:    0.7.0.1
 */