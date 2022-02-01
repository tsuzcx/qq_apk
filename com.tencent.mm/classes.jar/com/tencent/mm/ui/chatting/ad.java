package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.ui.chatting.g.d.a;

public abstract interface ad
{
  public abstract void a(d.a parama);
  
  public abstract void aaK(int paramInt);
  
  public abstract void aaL(int paramInt);
  
  public abstract void addHeaderView(View paramView);
  
  public abstract void b(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract void bJU();
  
  public abstract void ca(int paramInt);
  
  public abstract void dismissDialog();
  
  public abstract void flA();
  
  public abstract void flB();
  
  public abstract void flF();
  
  public abstract void flG();
  
  public abstract View getChildAt(int paramInt);
  
  public abstract int getFirstVisiblePosition();
  
  public abstract int getHeaderViewsCount();
  
  public abstract int getLastVisiblePosition();
  
  public abstract ListView getListView();
  
  public abstract boolean hideVKB();
  
  public abstract void jF(int paramInt1, int paramInt2);
  
  public abstract boolean removeOptionMenu(int paramInt);
  
  public abstract void setKeepScreenOn(boolean paramBoolean);
  
  public abstract void showOptionMenu(int paramInt, boolean paramBoolean);
  
  public abstract void showOptionMenu(boolean paramBoolean);
  
  public abstract void updateOptionMenuIcon(int paramInt1, int paramInt2);
  
  public abstract void xg(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ad
 * JD-Core Version:    0.7.0.1
 */