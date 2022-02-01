package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.ui.chatting.h.d.a;

public abstract interface ae
{
  public abstract void BN(boolean paramBoolean);
  
  public abstract void a(d.a parama);
  
  public abstract void addHeaderView(View paramView);
  
  public abstract void amm(int paramInt);
  
  public abstract void amo(int paramInt);
  
  public abstract void b(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract int cda();
  
  public abstract void cmy();
  
  public abstract void dismissDialog();
  
  public abstract void gNX();
  
  public abstract void gNY();
  
  public abstract void gOc();
  
  public abstract void gOe();
  
  public abstract View getChildAt(int paramInt);
  
  public abstract int getFirstVisiblePosition();
  
  public abstract int getHeaderViewsCount();
  
  public abstract int getLastVisiblePosition();
  
  public abstract ListView getListView();
  
  public abstract boolean hideVKB();
  
  public abstract void lf(int paramInt1, int paramInt2);
  
  public abstract boolean removeOptionMenu(int paramInt);
  
  public abstract void scrollToPosition(int paramInt);
  
  public abstract void setKeepScreenOn(boolean paramBoolean);
  
  public abstract void showOptionMenu(int paramInt, boolean paramBoolean);
  
  public abstract void showOptionMenu(boolean paramBoolean);
  
  public abstract void updateOptionMenuIcon(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ae
 * JD-Core Version:    0.7.0.1
 */