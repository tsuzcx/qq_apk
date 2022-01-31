package com.tencent.mm.plugin.topstory.ui.video;

import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public abstract interface b
{
  public abstract boolean DP();
  
  public abstract void GA(int paramInt);
  
  public abstract void GB(int paramInt);
  
  public abstract boolean Gz(int paramInt);
  
  public abstract void a(ccp paramccp);
  
  public abstract void a(ckx paramckx);
  
  public abstract void aen(String paramString);
  
  public abstract void aeo(String paramString);
  
  public abstract void ah(View paramView, int paramInt);
  
  public abstract MMActivity bMN();
  
  public abstract void cIZ();
  
  public abstract void cJa();
  
  public abstract l cJc();
  
  public abstract o cJd();
  
  public abstract String cJe();
  
  public abstract ckw cJf();
  
  public abstract m cJg();
  
  public abstract r cJh();
  
  public abstract Point cJi();
  
  public abstract aj cJj();
  
  public abstract int cJk();
  
  public abstract boolean cJl();
  
  public abstract e cJm();
  
  public abstract boolean cJn();
  
  public abstract void cJo();
  
  public abstract int cJp();
  
  public abstract void cJq();
  
  public abstract void cJr();
  
  public abstract n cJs();
  
  public abstract String cJt();
  
  public abstract int cJu();
  
  public abstract void cJv();
  
  public abstract int cJw();
  
  public abstract RecyclerView.i getLayoutManager();
  
  public abstract RecyclerView getRecyclerView();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean gh(int paramInt1, int paramInt2);
  
  public abstract boolean isFullscreenMode();
  
  public abstract void k(List<ckx> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.b
 * JD-Core Version:    0.7.0.1
 */