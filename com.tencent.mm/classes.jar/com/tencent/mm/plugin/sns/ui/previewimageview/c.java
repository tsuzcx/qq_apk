package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public final class c
  extends b
{
  private int RSS;
  private boolean RST;
  private boolean RSU;
  a RSV;
  private int RSW;
  private HashMap<String, Bitmap> Rip;
  boolean Ris;
  
  public c(Context paramContext, List<?> paramList, int paramInt, boolean paramBoolean, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(369955);
    this.Rip = new HashMap();
    this.RSW = 0;
    super.kY(kZ(paramList));
    this.RSS = paramInt;
    this.RST = paramBoolean;
    this.RSV = parama;
    hrO();
    hrP();
    AppMethodBeat.o(369955);
  }
  
  private void hrO()
  {
    AppMethodBeat.i(100270);
    int i = 0;
    while (i < this.RSR)
    {
      d locald = new d((byte)0);
      locald.cpt = "";
      locald.id = getCount();
      locald.id = getCount();
      add(i, locald);
      i += 1;
    }
    AppMethodBeat.o(100270);
  }
  
  private List<d> kZ(List<?> paramList)
  {
    AppMethodBeat.i(100269);
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      d locald = new d((byte)0);
      locald.cpt = localObject;
      locald.id = i;
      localArrayList.add(locald);
      i += 1;
    }
    AppMethodBeat.o(100269);
    return localArrayList;
  }
  
  private void v(ImageView paramImageView)
  {
    AppMethodBeat.i(308601);
    if (this.RSW == 0)
    {
      al.hgq();
      int i = aa.getScreenWidth();
      if (i == 0)
      {
        AppMethodBeat.o(308601);
        return;
      }
      this.RSW = ((i - this.mContext.getResources().getDimensionPixelSize(b.d.sns_upload_previewimg_view_margin) * 4 - this.mContext.getResources().getDimensionPixelSize(b.d.LargerPadding) * 2) / 3);
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = this.RSW;
    localLayoutParams.height = this.RSW;
    paramImageView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(308601);
  }
  
  public final boolean amC(int paramInt)
  {
    AppMethodBeat.i(100277);
    if (paramInt < this.RSR)
    {
      AppMethodBeat.o(100277);
      return false;
    }
    if (this.RSU)
    {
      if (paramInt != getCount() - 1)
      {
        AppMethodBeat.o(100277);
        return true;
      }
      AppMethodBeat.o(100277);
      return false;
    }
    boolean bool = super.amC(paramInt);
    AppMethodBeat.o(100277);
    return bool;
  }
  
  public final boolean amD(int paramInt)
  {
    AppMethodBeat.i(100278);
    if (paramInt < this.RSR)
    {
      AppMethodBeat.o(100278);
      return false;
    }
    if (this.RSU)
    {
      if (paramInt != getCount() - 1)
      {
        AppMethodBeat.o(100278);
        return true;
      }
      AppMethodBeat.o(100278);
      return false;
    }
    boolean bool = super.amD(paramInt);
    AppMethodBeat.o(100278);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(100272);
    super.clear();
    this.RSU = false;
    AppMethodBeat.o(100272);
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(100276);
    if (TextUtils.isEmpty(getItem(paramInt).toString()))
    {
      AppMethodBeat.o(100276);
      return 1;
    }
    AppMethodBeat.o(100276);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(100275);
    String str;
    ImageView localImageView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(getContext()).inflate(b.g.sns_preview_view_item, paramViewGroup, false);
      paramViewGroup = new b(paramView, (byte)0);
      paramView.setTag(b.f.img_preview_tag, paramViewGroup);
      v(paramViewGroup.RSX);
      v(paramViewGroup.hIz);
      str = getItem(paramInt).toString();
      localImageView = paramViewGroup.hIz;
      if (!TextUtils.isEmpty(str)) {
        break label260;
      }
      paramViewGroup.RSX.setBackgroundResource(b.c.sns_upload_add_bg);
      localImageView.setImageDrawable(bb.m(localImageView.getContext(), b.i.album_post_add_picture_btn, a.w(localImageView.getContext(), b.c.FG_1)));
      localImageView.setContentDescription(paramViewGroup.hIz.getContext().getString(b.j.sns_add_photo));
      int i = paramViewGroup.RSY.RSW * 35 / 100;
      localImageView.setPadding(i, i, i, i);
      if (paramInt <= 0) {
        break label233;
      }
      paramViewGroup.view.setTag(Integer.valueOf(-1));
      label182:
      if (paramInt >= this.RSR) {
        break label385;
      }
      paramViewGroup.hIz.setVisibility(4);
      paramViewGroup.RSX.setVisibility(8);
      paramView.setVisibility(4);
    }
    for (;;)
    {
      AppMethodBeat.o(100275);
      return paramView;
      paramViewGroup = (b)paramView.getTag(b.f.img_preview_tag);
      break;
      label233:
      if (paramInt >= paramViewGroup.RSY.RSR) {
        break label182;
      }
      paramViewGroup.view.setTag(Integer.valueOf(2147483647));
      break label182;
      label260:
      paramViewGroup.view.setTag(Integer.valueOf(paramInt - paramViewGroup.RSY.RSR));
      localImageView.setBackgroundDrawable(null);
      localImageView.setTag(str);
      localImageView.setContentDescription(paramViewGroup.hIz.getContext().getString(b.j.sns_img));
      localImageView.setPadding(0, 0, 0, 0);
      Bitmap localBitmap = (Bitmap)paramViewGroup.RSY.Rip.get(str);
      if (!t.S(localBitmap))
      {
        new c(paramViewGroup.RSY, localImageView, str).A(new String[] { "" });
        break label182;
      }
      localImageView.setImageBitmap(localBitmap);
      break label182;
      label385:
      paramViewGroup.hIz.setVisibility(0);
      paramViewGroup.RSX.setVisibility(0);
      paramView.setVisibility(0);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final void hrP()
  {
    AppMethodBeat.i(100271);
    Log.v("DynamicGridAdapter", "showAddImg %s, getCount %d, getHeaderCount %d, maxShowCount %d， showing %s", new Object[] { Boolean.valueOf(this.RST), Integer.valueOf(getCount()), Integer.valueOf(this.RSR), Integer.valueOf(this.RSS), Boolean.valueOf(this.RSU) });
    if ((this.RST) && (hrQ() < this.RSS))
    {
      if (!this.RSU)
      {
        this.RSU = true;
        add("");
        AppMethodBeat.o(100271);
      }
    }
    else {
      this.RSU = false;
    }
    AppMethodBeat.o(100271);
  }
  
  public final int hrQ()
  {
    AppMethodBeat.i(100274);
    int j = getCount();
    int k = this.RSR;
    if (this.RSU) {}
    for (int i = 1;; i = 0)
    {
      AppMethodBeat.o(100274);
      return j - k - i;
    }
  }
  
  public final void kY(List<?> paramList)
  {
    AppMethodBeat.i(100273);
    super.kY(kZ(paramList));
    hrO();
    hrP();
    AppMethodBeat.o(100273);
  }
  
  public final void lP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100279);
    super.lP(paramInt1, paramInt2);
    if (this.RSV != null) {
      this.RSV.lF(paramInt1 - this.RSR, paramInt2 - this.RSR);
    }
    AppMethodBeat.o(100279);
  }
  
  public static abstract interface a
  {
    public abstract void lF(int paramInt1, int paramInt2);
    
    public abstract void removeItem(int paramInt);
  }
  
  final class b
  {
    ImageView RSX;
    ImageView hIz;
    View view;
    
    private b(View paramView)
    {
      AppMethodBeat.i(100263);
      this.view = paramView;
      this.hIz = ((ImageView)paramView.findViewById(b.f.iv));
      this.RSX = ((ImageView)paramView.findViewById(b.f.bgview));
      AppMethodBeat.o(100263);
    }
  }
  
  final class c
    extends h<String, Integer, Boolean>
  {
    private ImageView hNV;
    private Bitmap orY;
    private String path;
    
    public c(ImageView paramImageView, String paramString)
    {
      this.hNV = paramImageView;
      this.path = paramString;
    }
    
    public final ExecutorService gDT()
    {
      AppMethodBeat.i(179372);
      ExecutorService localExecutorService = al.hgl();
      AppMethodBeat.o(179372);
      return localExecutorService;
    }
  }
  
  final class d
  {
    public Object cpt;
    public int id;
    
    private d() {}
    
    public final int hashCode()
    {
      return this.id;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(100267);
      String str = this.cpt.toString();
      AppMethodBeat.o(100267);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.c
 * JD-Core Version:    0.7.0.1
 */