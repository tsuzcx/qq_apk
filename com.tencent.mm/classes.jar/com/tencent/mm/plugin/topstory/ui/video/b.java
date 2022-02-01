package com.tencent.mm.plugin.topstory.ui.video;

import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public abstract interface b
{
  public abstract boolean Nw();
  
  public abstract boolean Rn(int paramInt);
  
  public abstract void Ro(int paramInt);
  
  public abstract void Rp(int paramInt);
  
  public abstract void a(cyv paramcyv);
  
  public abstract void a(dio paramdio);
  
  public abstract void a(dio paramdio, int paramInt1, int paramInt2);
  
  public abstract void a(dio paramdio, View paramView);
  
  public abstract void a(dio paramdio, f paramf, int paramInt);
  
  public abstract void as(View paramView, int paramInt);
  
  public abstract void axQ(String paramString);
  
  public abstract void axR(String paramString);
  
  public abstract void cWw();
  
  public abstract MMActivity cYC();
  
  public abstract void edb();
  
  public abstract void edc();
  
  public abstract l ede();
  
  public abstract o edf();
  
  public abstract String edg();
  
  public abstract dil edh();
  
  public abstract m edi();
  
  public abstract r edj();
  
  public abstract Point edk();
  
  public abstract aj edl();
  
  public abstract int edm();
  
  public abstract boolean edn();
  
  public abstract boolean edo();
  
  public abstract e edp();
  
  public abstract boolean edq();
  
  public abstract void edr();
  
  public abstract int eds();
  
  public abstract n edt();
  
  public abstract String edu();
  
  public abstract int edv();
  
  public abstract void edw();
  
  public abstract int edx();
  
  public abstract RecyclerView.i getLayoutManager();
  
  public abstract RecyclerView getRecyclerView();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isFullscreenMode();
  
  public abstract void m(List<dio> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.b
 * JD-Core Version:    0.7.0.1
 */