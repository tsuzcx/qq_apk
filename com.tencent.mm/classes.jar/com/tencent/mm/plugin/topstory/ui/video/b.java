package com.tencent.mm.plugin.topstory.ui.video;

import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public abstract interface b
{
  public abstract void KC();
  
  public abstract boolean Zx();
  
  public abstract void a(dyi paramdyi);
  
  public abstract void a(eiw parameiw);
  
  public abstract void a(eiw parameiw, int paramInt1, int paramInt2);
  
  public abstract void a(eiw parameiw, View paramView);
  
  public abstract void a(eiw parameiw, f paramf, int paramInt);
  
  public abstract void aTE(String paramString);
  
  public abstract void aTF(String paramString);
  
  public abstract boolean abU(int paramInt);
  
  public abstract void abV(int paramInt);
  
  public abstract void abW(int paramInt);
  
  public abstract void ay(View paramView, int paramInt);
  
  public abstract Point cZM();
  
  public abstract MMActivity eeF();
  
  public abstract l fyA();
  
  public abstract o fyB();
  
  public abstract String fyC();
  
  public abstract eit fyD();
  
  public abstract m fyE();
  
  public abstract r fyF();
  
  public abstract aj fyG();
  
  public abstract int fyH();
  
  public abstract boolean fyI();
  
  public abstract boolean fyJ();
  
  public abstract e fyK();
  
  public abstract boolean fyL();
  
  public abstract void fyM();
  
  public abstract int fyN();
  
  public abstract n fyO();
  
  public abstract String fyP();
  
  public abstract int fyQ();
  
  public abstract void fyR();
  
  public abstract int fyS();
  
  public abstract void fyx();
  
  public abstract void fyy();
  
  public abstract RecyclerView.LayoutManager getLayoutManager();
  
  public abstract RecyclerView getRecyclerView();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isFullscreenMode();
  
  public abstract void s(List<eiw> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.b
 * JD-Core Version:    0.7.0.1
 */