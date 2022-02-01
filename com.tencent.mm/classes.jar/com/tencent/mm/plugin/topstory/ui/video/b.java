package com.tencent.mm.plugin.topstory.ui.video;

import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public abstract interface b
{
  public abstract boolean Pf();
  
  public abstract boolean SX(int paramInt);
  
  public abstract void SY(int paramInt);
  
  public abstract void SZ(int paramInt);
  
  public abstract void a(dei paramdei);
  
  public abstract void a(dod paramdod);
  
  public abstract void a(dod paramdod, int paramInt1, int paramInt2);
  
  public abstract void a(dod paramdod, View paramView);
  
  public abstract void a(dod paramdod, f paramf, int paramInt);
  
  public abstract void aCV(String paramString);
  
  public abstract void aCW(String paramString);
  
  public abstract void at(View paramView, int paramInt);
  
  public abstract void dfI();
  
  public abstract MMActivity dhO();
  
  public abstract m epA();
  
  public abstract r epB();
  
  public abstract Point epC();
  
  public abstract aj epD();
  
  public abstract int epE();
  
  public abstract boolean epF();
  
  public abstract boolean epG();
  
  public abstract e epH();
  
  public abstract boolean epI();
  
  public abstract void epJ();
  
  public abstract int epK();
  
  public abstract n epL();
  
  public abstract String epM();
  
  public abstract int epN();
  
  public abstract void epO();
  
  public abstract int epP();
  
  public abstract void ept();
  
  public abstract void epu();
  
  public abstract l epw();
  
  public abstract o epx();
  
  public abstract String epy();
  
  public abstract doa epz();
  
  public abstract RecyclerView.i getLayoutManager();
  
  public abstract RecyclerView getRecyclerView();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isFullscreenMode();
  
  public abstract void n(List<dod> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.b
 * JD-Core Version:    0.7.0.1
 */