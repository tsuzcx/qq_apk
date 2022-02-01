package com.tencent.mm.plugin.topstory.ui.video;

import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public abstract interface b
{
  public abstract boolean Pd();
  
  public abstract boolean TE(int paramInt);
  
  public abstract void TF(int paramInt);
  
  public abstract void TG(int paramInt);
  
  public abstract void a(dfc paramdfc);
  
  public abstract void a(dpa paramdpa);
  
  public abstract void a(dpa paramdpa, int paramInt1, int paramInt2);
  
  public abstract void a(dpa paramdpa, View paramView);
  
  public abstract void a(dpa paramdpa, f paramf, int paramInt);
  
  public abstract void aEo(String paramString);
  
  public abstract void aEp(String paramString);
  
  public abstract void at(View paramView, int paramInt);
  
  public abstract void diF();
  
  public abstract MMActivity dkN();
  
  public abstract void eta();
  
  public abstract void etb();
  
  public abstract l etd();
  
  public abstract o ete();
  
  public abstract String etf();
  
  public abstract dox etg();
  
  public abstract m eth();
  
  public abstract r eti();
  
  public abstract Point etj();
  
  public abstract aj etk();
  
  public abstract int etl();
  
  public abstract boolean etm();
  
  public abstract boolean etn();
  
  public abstract e eto();
  
  public abstract boolean etp();
  
  public abstract void etq();
  
  public abstract int etr();
  
  public abstract n ets();
  
  public abstract String ett();
  
  public abstract int etu();
  
  public abstract void etv();
  
  public abstract int etw();
  
  public abstract RecyclerView.i getLayoutManager();
  
  public abstract RecyclerView getRecyclerView();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isFullscreenMode();
  
  public abstract void n(List<dpa> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.b
 * JD-Core Version:    0.7.0.1
 */