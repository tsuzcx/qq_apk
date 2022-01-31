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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.gallery.h.a;
import java.util.Date;
import java.util.List;

public final class b
  extends RecyclerView.a
{
  private com.tencent.mm.at.a.a.c eiK;
  private String ejr;
  public List<b.c> jfV;
  private boolean kFs;
  public boolean kFv;
  Context mContext;
  public boolean mCr;
  boolean muT;
  long zDF;
  public b zDG;
  
  public b(Context paramContext, List<b.c> paramList, String paramString)
  {
    AppMethodBeat.i(31138);
    this.jfV = null;
    this.eiK = null;
    this.kFs = true;
    this.muT = false;
    this.mCr = false;
    this.jfV = paramList;
    this.ejr = paramString;
    aw.aaz();
    this.kFs = com.tencent.mm.model.c.isSDCardAvailable();
    this.mContext = paramContext;
    im(paramContext);
    AppMethodBeat.o(31138);
  }
  
  public b(Context paramContext, List<b.c> paramList, String paramString, long paramLong)
  {
    AppMethodBeat.i(31139);
    this.jfV = null;
    this.eiK = null;
    this.kFs = true;
    this.muT = false;
    this.mCr = false;
    this.jfV = paramList;
    this.zDF = paramLong;
    this.ejr = paramString;
    aw.aaz();
    this.kFs = com.tencent.mm.model.c.isSDCardAvailable();
    this.muT = true;
    this.mContext = paramContext;
    im(paramContext);
    AppMethodBeat.o(31139);
  }
  
  private void im(Context paramContext)
  {
    AppMethodBeat.i(31140);
    c.a locala = new c.a();
    locala.fHt = 1;
    locala.eOf = true;
    locala.eNT = (com.tencent.mm.cb.a.gw(paramContext) / 4);
    locala.eNS = (com.tencent.mm.cb.a.gw(paramContext) / 4);
    locala.eOa = 2131690341;
    this.eiK = locala.ahY();
    AppMethodBeat.o(31140);
  }
  
  private static long io(long paramLong)
  {
    AppMethodBeat.i(31146);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.dNj().b(localDate);
    AppMethodBeat.o(31146);
    return paramLong;
  }
  
  public final b.c PC(int paramInt)
  {
    AppMethodBeat.i(31148);
    b.c localc = (b.c)this.jfV.get(paramInt);
    AppMethodBeat.o(31148);
    return localc;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(31142);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969685, paramViewGroup, false));
      AppMethodBeat.o(31142);
      return paramViewGroup;
    }
    paramViewGroup = new b.d(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969882, paramViewGroup, false));
    AppMethodBeat.o(31142);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(31144);
    if (!this.kFs)
    {
      ab.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.kFs) });
      AppMethodBeat.o(31144);
      return;
    }
    b.c localc = PC(paramInt);
    if (paramv.aky == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (io(PC(paramInt + 1).timeStamp) != io(localc.timeStamp)))
      {
        ((a)paramv).gpp.setVisibility(8);
        AppMethodBeat.o(31144);
        return;
      }
      ((a)paramv).gpp.setVisibility(0);
      ((a)paramv).gpp.setText(in(localc.timeStamp));
      if (this.kFv)
      {
        ((a)paramv).progressBar.setVisibility(0);
        AppMethodBeat.o(31144);
        return;
      }
      ((a)paramv).progressBar.setVisibility(8);
      AppMethodBeat.o(31144);
      return;
    }
    ((b.d)paramv).mCy.setTag(Integer.valueOf(paramInt));
    ((b.d)paramv).mCD.setTag(Integer.valueOf(paramInt));
    o.ahG().a(localc.imagePath, ((b.d)paramv).mCy, this.eiK);
    if (localc.mCu)
    {
      ((b.d)paramv).mCz.setVisibility(0);
      ((b.d)paramv).kFj.setVisibility(0);
      ((b.d)paramv).kFj.setText(bo.bf(localc.zDI.mCw, ""));
    }
    while (this.mCr)
    {
      ((b.d)paramv).mCD.setVisibility(0);
      ((b.d)paramv).mCC.setVisibility(0);
      if (h.a.dKg().bF(localc.cEE))
      {
        ((b.d)paramv).mCA.setVisibility(0);
        ((b.d)paramv).mCC.setChecked(true);
        AppMethodBeat.o(31144);
        return;
        ((b.d)paramv).kFj.setVisibility(8);
        ((b.d)paramv).mCz.setVisibility(8);
      }
      else
      {
        ((b.d)paramv).mCA.setVisibility(8);
        ((b.d)paramv).mCC.setChecked(false);
        AppMethodBeat.o(31144);
        return;
      }
    }
    ((b.d)paramv).mCD.setVisibility(8);
    ((b.d)paramv).mCC.setVisibility(8);
    AppMethodBeat.o(31144);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    AppMethodBeat.i(31143);
    if ((paramList != null) && (paramList.size() > 0) && ((paramv instanceof b.d)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((b.d)paramv).mCC.setChecked(false);
        ((b.d)paramv).mCC.setVisibility(0);
        ((b.d)paramv).mCD.setVisibility(0);
        AppMethodBeat.o(31143);
        return;
      }
      ((b.d)paramv).mCC.setChecked(false);
      ((b.d)paramv).mCC.setVisibility(8);
      ((b.d)paramv).mCD.setVisibility(8);
      AppMethodBeat.o(31143);
      return;
    }
    super.a(paramv, paramInt, paramList);
    AppMethodBeat.o(31143);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(31147);
    int i = this.jfV.size();
    AppMethodBeat.o(31147);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(31141);
    paramInt = PC(paramInt).type;
    AppMethodBeat.o(31141);
    return paramInt;
  }
  
  public final String in(long paramLong)
  {
    AppMethodBeat.i(31145);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.dNj().a((Date)localObject, this.mContext);
    AppMethodBeat.o(31145);
    return localObject;
  }
  
  public final class a
    extends RecyclerView.v
  {
    TextView gpp;
    ProgressBar progressBar;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(31131);
      this.gpp = ((TextView)paramView.findViewById(2131824015));
      this.progressBar = ((ProgressBar)paramView.findViewById(2131824014));
      AppMethodBeat.o(31131);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, b.c paramc, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b
 * JD-Core Version:    0.7.0.1
 */