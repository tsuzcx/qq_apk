package com.tencent.mm.ui.chatting.e;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.presenter.c;

public abstract interface a$a
  extends c<a.b>
{
  public abstract void I(boolean paramBoolean, int paramInt);
  
  public abstract void MN(int paramInt);
  
  public abstract String bVz();
  
  public abstract b cA(String paramString, long paramLong);
  
  public abstract boolean dSE();
  
  public abstract void dSF();
  
  public abstract void dSG();
  
  public abstract <T extends RecyclerView.a> T dSN();
  
  public abstract <T extends RecyclerView.LayoutManager> T fT(Context paramContext);
  
  public abstract RecyclerView.h gl(Context paramContext);
  
  public abstract int juK();
  
  public abstract void juL();
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.a.a
 * JD-Core Version:    0.7.0.1
 */