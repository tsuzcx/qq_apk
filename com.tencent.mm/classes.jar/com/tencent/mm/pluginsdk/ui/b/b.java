package com.tencent.mm.pluginsdk.ui.b;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;

public abstract class b
  implements a
{
  public WeakReference<Context> BZM = null;
  public boolean gqE = false;
  public boolean isFirst = false;
  public View view = null;
  
  public b(Context paramContext)
  {
    this.BZM = new WeakReference(paramContext);
    if (getLayoutId() > 0) {
      this.view = View.inflate(paramContext, getLayoutId(), null);
    }
  }
  
  public boolean boZ()
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