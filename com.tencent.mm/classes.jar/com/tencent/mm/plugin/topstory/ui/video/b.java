package com.tencent.mm.plugin.topstory.ui.video;

import android.graphics.Point;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.u;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public abstract interface b
{
  public abstract void Np();
  
  public abstract void a(eij parameij);
  
  public abstract void a(esy paramesy);
  
  public abstract void a(esy paramesy, int paramInt1, int paramInt2);
  
  public abstract void a(esy paramesy, View paramView);
  
  public abstract void a(esy paramesy, f paramf, int paramInt);
  
  public abstract void aD(View paramView, int paramInt);
  
  public abstract boolean aeg();
  
  public abstract boolean ajA(int paramInt);
  
  public abstract void ajB(int paramInt);
  
  public abstract void ajC(int paramInt);
  
  public abstract void bfc(String paramString);
  
  public abstract void bfd(String paramString);
  
  public abstract boolean cne();
  
  public abstract Point dpI();
  
  public abstract MMActivity eOa();
  
  public abstract RecyclerView.LayoutManager getLayoutManager();
  
  public abstract RecyclerView getRecyclerView();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract esv gqA();
  
  public abstract m gqB();
  
  public abstract r gqC();
  
  public abstract u gqD();
  
  public abstract int gqE();
  
  public abstract boolean gqF();
  
  public abstract boolean gqG();
  
  public abstract e gqH();
  
  public abstract boolean gqI();
  
  public abstract void gqJ();
  
  public abstract int gqK();
  
  public abstract n gqL();
  
  public abstract String gqM();
  
  public abstract int gqN();
  
  public abstract void gqO();
  
  public abstract int gqP();
  
  public abstract void gqu();
  
  public abstract void gqv();
  
  public abstract l gqx();
  
  public abstract o gqy();
  
  public abstract String gqz();
  
  public abstract void t(List<esy> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.b
 * JD-Core Version:    0.7.0.1
 */