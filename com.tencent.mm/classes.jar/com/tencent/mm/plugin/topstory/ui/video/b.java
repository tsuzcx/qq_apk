package com.tencent.mm.plugin.topstory.ui.video;

import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.mm.protocal.protobuf.ctk;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public abstract interface b
{
  public abstract boolean Ny();
  
  public abstract boolean Ph(int paramInt);
  
  public abstract void Pi(int paramInt);
  
  public abstract void Pj(int paramInt);
  
  public abstract void a(ctk paramctk);
  
  public abstract void a(ddb paramddb);
  
  public abstract void a(ddb paramddb, int paramInt1, int paramInt2);
  
  public abstract void a(ddb paramddb, View paramView);
  
  public abstract void a(ddb paramddb, f paramf, int paramInt);
  
  public abstract void aq(View paramView, int paramInt);
  
  public abstract void asH(String paramString);
  
  public abstract void asI(String paramString);
  
  public abstract MMActivity cKW();
  
  public abstract void cMY();
  
  public abstract void dOB();
  
  public abstract void dOC();
  
  public abstract l dOE();
  
  public abstract o dOF();
  
  public abstract String dOG();
  
  public abstract dcy dOH();
  
  public abstract m dOI();
  
  public abstract r dOJ();
  
  public abstract Point dOK();
  
  public abstract aj dOL();
  
  public abstract int dOM();
  
  public abstract boolean dON();
  
  public abstract boolean dOO();
  
  public abstract e dOP();
  
  public abstract boolean dOQ();
  
  public abstract void dOR();
  
  public abstract int dOS();
  
  public abstract n dOT();
  
  public abstract String dOU();
  
  public abstract int dOV();
  
  public abstract void dOW();
  
  public abstract int dOX();
  
  public abstract RecyclerView.i getLayoutManager();
  
  public abstract RecyclerView getRecyclerView();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isFullscreenMode();
  
  public abstract void l(List<ddb> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.b
 * JD-Core Version:    0.7.0.1
 */