package com.tencent.mm.pluginsdk.ui.a;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;

public abstract class b
  implements a
{
  public WeakReference<Context> Ydi = null;
  public boolean isFirst = false;
  public boolean nzL = false;
  public View view = null;
  
  public b(Context paramContext)
  {
    this.Ydi = new WeakReference(paramContext);
    if (getLayoutId() > 0) {
      this.view = View.inflate(paramContext, getLayoutId(), null);
    }
  }
  
  public boolean cMa()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.a.b
 * JD-Core Version:    0.7.0.1
 */