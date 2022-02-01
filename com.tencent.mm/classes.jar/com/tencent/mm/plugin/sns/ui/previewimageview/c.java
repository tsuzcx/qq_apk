package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public final class c
  extends b
{
  private HashMap<String, Bitmap> KIO;
  boolean KIR;
  private int LpZ;
  private boolean Lqa;
  private boolean Lqb;
  a Lqc;
  private int Lqd;
  
  public c(Context paramContext, List<?> paramList, boolean paramBoolean, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(100268);
    this.KIO = new HashMap();
    this.Lqd = 0;
    super.hU(hV(paramList));
    this.LpZ = 9;
    this.Lqa = paramBoolean;
    this.Lqc = parama;
    fYF();
    fYG();
    AppMethodBeat.o(100268);
  }
  
  private void fYF()
  {
    AppMethodBeat.i(100270);
    int i = 0;
    while (i < this.LpY)
    {
      d locald = new d((byte)0);
      locald.bnW = "";
      locald.id = getCount();
      locald.id = getCount();
      add(i, locald);
      i += 1;
    }
    AppMethodBeat.o(100270);
  }
  
  private List<d> hV(List<?> paramList)
  {
    AppMethodBeat.i(100269);
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      d locald = new d((byte)0);
      locald.bnW = localObject;
      locald.id = i;
      localArrayList.add(locald);
      i += 1;
    }
    AppMethodBeat.o(100269);
    return localArrayList;
  }
  
  public final boolean ahA(int paramInt)
  {
    AppMethodBeat.i(100277);
    if (paramInt < this.LpY)
    {
      AppMethodBeat.o(100277);
      return false;
    }
    if (this.Lqb)
    {
      if (paramInt != getCount() - 1)
      {
        AppMethodBeat.o(100277);
        return true;
      }
      AppMethodBeat.o(100277);
      return false;
    }
    boolean bool = super.ahA(paramInt);
    AppMethodBeat.o(100277);
    return bool;
  }
  
  public final boolean ahB(int paramInt)
  {
    AppMethodBeat.i(100278);
    if (paramInt < this.LpY)
    {
      AppMethodBeat.o(100278);
      return false;
    }
    if (this.Lqb)
    {
      if (paramInt != getCount() - 1)
      {
        AppMethodBeat.o(100278);
        return true;
      }
      AppMethodBeat.o(100278);
      return false;
    }
    boolean bool = super.ahB(paramInt);
    AppMethodBeat.o(100278);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(100272);
    super.clear();
    this.Lqb = false;
    AppMethodBeat.o(100272);
  }
  
  public final void fYG()
  {
    AppMethodBeat.i(100271);
    Log.v("DynamicGridAdapter", "showAddImg %s, getCount %d, getHeaderCount %d, maxShowCount %d， showing %s", new Object[] { Boolean.valueOf(this.Lqa), Integer.valueOf(getCount()), Integer.valueOf(this.LpY), Integer.valueOf(this.LpZ), Boolean.valueOf(this.Lqb) });
    if ((this.Lqa) && (fYH() < this.LpZ))
    {
      if (!this.Lqb)
      {
        this.Lqb = true;
        add("");
        AppMethodBeat.o(100271);
      }
    }
    else {
      this.Lqb = false;
    }
    AppMethodBeat.o(100271);
  }
  
  public final int fYH()
  {
    AppMethodBeat.i(100274);
    int j = getCount();
    int k = this.LpY;
    if (this.Lqb) {}
    for (int i = 1;; i = 0)
    {
      AppMethodBeat.o(100274);
      return j - k - i;
    }
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
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from(getContext()).inflate(i.g.sns_preview_view_item, paramViewGroup, false);
      localObject2 = new b((View)localObject1, (byte)0);
      ((View)localObject1).setTag(i.f.img_preview_tag, localObject2);
      localObject3 = ((b)localObject2).fDJ;
      if (this.Lqd == 0)
      {
        aj.fOx();
        i = r.getScreenWidth();
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i != 0) {
          this.Lqd = ((i - this.mContext.getResources().getDimensionPixelSize(i.d.sns_upload_previewimg_view_margin) * 4 - this.mContext.getResources().getDimensionPixelSize(i.d.LargerPadding) * 2) / 3);
        }
      }
      else
      {
        paramView = (LinearLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
        paramView.width = this.Lqd;
        paramView.height = this.Lqd;
        ((ImageView)localObject3).setLayoutParams(paramView);
        paramView = (View)localObject1;
        paramViewGroup = (ViewGroup)localObject2;
      }
      localObject1 = getItem(paramInt).toString();
      localObject2 = paramViewGroup.fDJ;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label325;
      }
      ((ImageView)localObject2).setBackgroundResource(i.c.sns_upload_add_bg);
      ((ImageView)localObject2).setImageResource(i.i.album_post_add_picture_btn);
      ((ImageView)localObject2).setContentDescription(paramViewGroup.fDJ.getContext().getString(i.j.sns_add_photo));
      int i = paramViewGroup.Lqe.Lqd * 35 / 100;
      ((ImageView)localObject2).setPadding(i, i, i, i);
      if (paramInt <= 0) {
        break label298;
      }
      paramViewGroup.view.setTag(Integer.valueOf(-1));
      label261:
      if (paramInt >= this.LpY) {
        break label450;
      }
      paramViewGroup.fDJ.setVisibility(4);
    }
    for (;;)
    {
      AppMethodBeat.o(100275);
      return paramView;
      paramViewGroup = (b)paramView.getTag(i.f.img_preview_tag);
      break;
      label298:
      if (paramInt >= paramViewGroup.Lqe.LpY) {
        break label261;
      }
      paramViewGroup.view.setTag(Integer.valueOf(2147483647));
      break label261;
      label325:
      paramViewGroup.view.setTag(Integer.valueOf(paramInt - paramViewGroup.Lqe.LpY));
      ((ImageView)localObject2).setBackgroundDrawable(null);
      ((ImageView)localObject2).setTag(localObject1);
      ((ImageView)localObject2).setContentDescription(paramViewGroup.fDJ.getContext().getString(i.j.sns_img));
      ((ImageView)localObject2).setPadding(0, 0, 0, 0);
      localObject3 = (Bitmap)paramViewGroup.Lqe.KIO.get(localObject1);
      if (!t.K((Bitmap)localObject3))
      {
        new c(paramViewGroup.Lqe, (ImageView)localObject2, (String)localObject1).y(new String[] { "" });
        break label261;
      }
      ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
      break label261;
      label450:
      paramViewGroup.fDJ.setVisibility(0);
      paramView.setVisibility(0);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final void hU(List<?> paramList)
  {
    AppMethodBeat.i(100273);
    super.hU(hV(paramList));
    fYF();
    fYG();
    AppMethodBeat.o(100273);
  }
  
  public final void kc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100279);
    super.kc(paramInt1, paramInt2);
    if (this.Lqc != null) {
      this.Lqc.jT(paramInt1 - this.LpY, paramInt2 - this.LpY);
    }
    AppMethodBeat.o(100279);
  }
  
  public static abstract interface a
  {
    public abstract void jT(int paramInt1, int paramInt2);
    
    public abstract void removeItem(int paramInt);
  }
  
  final class b
  {
    ImageView fDJ;
    View view;
    
    private b(View paramView)
    {
      AppMethodBeat.i(100263);
      this.view = paramView;
      this.fDJ = ((ImageView)paramView.findViewById(i.f.iv));
      AppMethodBeat.o(100263);
    }
  }
  
  final class c
    extends h<String, Integer, Boolean>
  {
    private ImageView fIv;
    private Bitmap lAx;
    private String path;
    
    public c(ImageView paramImageView, String paramString)
    {
      this.fIv = paramImageView;
      this.path = paramString;
    }
    
    public final ExecutorService fsl()
    {
      AppMethodBeat.i(179372);
      ExecutorService localExecutorService = aj.fOs();
      AppMethodBeat.o(179372);
      return localExecutorService;
    }
  }
  
  final class d
  {
    public Object bnW;
    public int id;
    
    private d() {}
    
    public final int hashCode()
    {
      return this.id;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(100267);
      String str = this.bnW.toString();
      AppMethodBeat.o(100267);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.c
 * JD-Core Version:    0.7.0.1
 */