package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.gallery.h.a;
import java.util.Date;
import java.util.List;

public final class b
  extends RecyclerView.a
{
  private String drJ;
  private com.tencent.mm.as.a.a.c drd = null;
  public List<b.c> heL = null;
  boolean kax = false;
  private boolean khG = true;
  public boolean khH;
  public boolean khJ = false;
  Context mContext;
  long voj;
  public b vok;
  
  public b(Context paramContext, List<b.c> paramList, String paramString)
  {
    this.heL = paramList;
    this.drJ = paramString;
    au.Hx();
    this.khG = com.tencent.mm.model.c.isSDCardAvailable();
    this.mContext = paramContext;
    gR(paramContext);
  }
  
  public b(Context paramContext, List<b.c> paramList, String paramString, long paramLong)
  {
    this.heL = paramList;
    this.voj = paramLong;
    this.drJ = paramString;
    au.Hx();
    this.khG = com.tencent.mm.model.c.isSDCardAvailable();
    this.kax = true;
    this.mContext = paramContext;
    gR(paramContext);
  }
  
  private static long eM(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return com.tencent.mm.ui.gridviewheaders.a.cIz().b(localDate);
  }
  
  private void gR(Context paramContext)
  {
    c.a locala = new c.a();
    locala.erk = 1;
    locala.erF = true;
    locala.erm = (com.tencent.mm.cb.a.fj(paramContext) / 4);
    locala.erl = (com.tencent.mm.cb.a.fj(paramContext) / 4);
    locala.ery = R.e.pic_thum_bg_color;
    this.drd = locala.OV();
  }
  
  public final b.c GZ(int paramInt)
  {
    return (b.c)this.heL.get(paramInt);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2147483647) {
      return new b.a(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gallery_date_item, paramViewGroup, false));
    }
    return new b.d(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.image_gallary_grid_item, paramViewGroup, false));
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    if (!this.khG)
    {
      y.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.khG) });
      return;
    }
    b.c localc = GZ(paramInt);
    if (paramv.aii == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (eM(GZ(paramInt + 1).timeStamp) != eM(localc.timeStamp)))
      {
        ((b.a)paramv).eXs.setVisibility(8);
        return;
      }
      ((b.a)paramv).eXs.setVisibility(0);
      ((b.a)paramv).eXs.setText(eL(localc.timeStamp));
      if (this.khH)
      {
        ((b.a)paramv).frw.setVisibility(0);
        return;
      }
      ((b.a)paramv).frw.setVisibility(8);
      return;
    }
    ((b.d)paramv).khQ.setTag(Integer.valueOf(paramInt));
    ((b.d)paramv).khW.setTag(Integer.valueOf(paramInt));
    o.ON().a(localc.imagePath, ((b.d)paramv).khQ, this.drd);
    if (localc.khM)
    {
      ((b.d)paramv).khR.setVisibility(0);
      ((b.d)paramv).khS.setVisibility(0);
      ((b.d)paramv).khS.setText(bk.aM(localc.vom.khO, ""));
    }
    while (this.khJ)
    {
      ((b.d)paramv).khW.setVisibility(0);
      ((b.d)paramv).khV.setVisibility(0);
      if (h.a.cGc().bx(localc.bWO))
      {
        ((b.d)paramv).khT.setVisibility(0);
        ((b.d)paramv).khV.setChecked(true);
        return;
        ((b.d)paramv).khS.setVisibility(8);
        ((b.d)paramv).khR.setVisibility(8);
      }
      else
      {
        ((b.d)paramv).khT.setVisibility(8);
        ((b.d)paramv).khV.setChecked(false);
        return;
      }
    }
    ((b.d)paramv).khW.setVisibility(8);
    ((b.d)paramv).khV.setVisibility(8);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && ((paramv instanceof b.d)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((b.d)paramv).khV.setChecked(false);
        ((b.d)paramv).khV.setVisibility(0);
        ((b.d)paramv).khW.setVisibility(0);
        return;
      }
      ((b.d)paramv).khV.setChecked(false);
      ((b.d)paramv).khV.setVisibility(8);
      ((b.d)paramv).khW.setVisibility(8);
      return;
    }
    super.a(paramv, paramInt, paramList);
  }
  
  public final String eL(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return com.tencent.mm.ui.gridviewheaders.a.cIz().a(localDate, this.mContext);
  }
  
  public final int getItemCount()
  {
    return this.heL.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return GZ(paramInt).type;
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, b.c paramc, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b
 * JD-Core Version:    0.7.0.1
 */