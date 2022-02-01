package com.tencent.mm.plugin.taskbar.api;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.kernel.c.a;

public abstract interface c
  extends a
{
  public abstract b a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer);
  
  public abstract void a(int paramInt, c.a parama);
  
  public abstract void b(int paramInt, c.a parama);
  
  public abstract void fuu();
  
  public abstract boolean fuv();
  
  public abstract HeaderContainer hn(Context paramContext);
  
  public abstract View ho(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.api.c
 * JD-Core Version:    0.7.0.1
 */