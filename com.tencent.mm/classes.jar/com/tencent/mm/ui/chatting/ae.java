package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.ui.chatting.h.d.a;

public abstract interface ae
{
  public abstract void Gi(boolean paramBoolean);
  
  public abstract void a(d.a parama);
  
  public abstract void avn(int paramInt);
  
  public abstract void avp(int paramInt);
  
  public abstract void b(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract void cAe();
  
  public abstract int cqm();
  
  public abstract void dI(View paramView);
  
  public abstract void dismissDialog();
  
  public abstract View getChildAt(int paramInt);
  
  public abstract int getFirstVisiblePosition();
  
  public abstract int getLastVisiblePosition();
  
  public abstract ListView getListView();
  
  public abstract int hMq();
  
  public abstract void hNg();
  
  public abstract void hNh();
  
  public abstract void hNm();
  
  public abstract void hNo();
  
  public abstract boolean hideVKB();
  
  public abstract boolean isShowingDialog();
  
  public abstract void my(int paramInt1, int paramInt2);
  
  public abstract boolean removeOptionMenu(int paramInt);
  
  public abstract void scrollToPosition(int paramInt);
  
  public abstract void setKeepScreenOn(boolean paramBoolean);
  
  public abstract void showOptionMenu(int paramInt, boolean paramBoolean);
  
  public abstract void showOptionMenu(boolean paramBoolean);
  
  public abstract void updateOptionMenuIcon(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ae
 * JD-Core Version:    0.7.0.1
 */