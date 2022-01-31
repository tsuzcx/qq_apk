package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.widget.ListView;

public abstract interface ad
{
  public abstract void Pu(int paramInt);
  
  public abstract void Pv(int paramInt);
  
  public abstract void aWN();
  
  public abstract void addHeaderView(View paramView);
  
  public abstract void ak(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void bJ(int paramInt);
  
  public abstract void c(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract void dGI();
  
  public abstract void dGJ();
  
  public abstract void dGN();
  
  public abstract void dGO();
  
  public abstract void dismissDialog();
  
  public abstract View getChildAt(int paramInt);
  
  public abstract int getFirstVisiblePosition();
  
  public abstract int getHeaderViewsCount();
  
  public abstract int getLastVisiblePosition();
  
  public abstract ListView getListView();
  
  public abstract void hF(int paramInt1, int paramInt2);
  
  public abstract boolean hideVKB();
  
  public abstract void qT(boolean paramBoolean);
  
  public abstract boolean removeOptionMenu(int paramInt);
  
  public abstract void setKeepScreenOn(boolean paramBoolean);
  
  public abstract void showOptionMenu(int paramInt, boolean paramBoolean);
  
  public abstract void showOptionMenu(boolean paramBoolean);
  
  public abstract void showVKB();
  
  public abstract void updateOptionMenuIcon(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ad
 * JD-Core Version:    0.7.0.1
 */