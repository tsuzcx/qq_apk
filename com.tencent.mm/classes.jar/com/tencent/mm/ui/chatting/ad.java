package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.ui.chatting.h.d.a;

public abstract interface ad
{
  public abstract void a(d.a parama);
  
  public abstract void acU(int paramInt);
  
  public abstract void acW(int paramInt);
  
  public abstract void addHeaderView(View paramView);
  
  public abstract void b(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract int bFG();
  
  public abstract void bOo();
  
  public abstract void ca(int paramInt);
  
  public abstract void dismissDialog();
  
  public abstract void fBQ();
  
  public abstract void fBR();
  
  public abstract void fBV();
  
  public abstract void fBX();
  
  public abstract View getChildAt(int paramInt);
  
  public abstract int getFirstVisiblePosition();
  
  public abstract int getHeaderViewsCount();
  
  public abstract int getLastVisiblePosition();
  
  public abstract ListView getListView();
  
  public abstract boolean hideVKB();
  
  public abstract void jR(int paramInt1, int paramInt2);
  
  public abstract boolean removeOptionMenu(int paramInt);
  
  public abstract void setKeepScreenOn(boolean paramBoolean);
  
  public abstract void showOptionMenu(int paramInt, boolean paramBoolean);
  
  public abstract void showOptionMenu(boolean paramBoolean);
  
  public abstract void updateOptionMenuIcon(int paramInt1, int paramInt2);
  
  public abstract void xR(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ad
 * JD-Core Version:    0.7.0.1
 */