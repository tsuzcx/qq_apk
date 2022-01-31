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
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class c
  extends b
{
  private HashMap<String, Bitmap> oSv = new HashMap();
  boolean oSy;
  private int ppD;
  private boolean ppE;
  private boolean ppF;
  c.a ppG;
  private int ppH = 0;
  
  public c(Context paramContext, List<?> paramList, boolean paramBoolean, c.a parama)
  {
    super(paramContext);
    super.cJ(cK(paramList));
    this.ppD = 9;
    this.ppE = paramBoolean;
    this.ppG = parama;
    bKl();
    bKm();
  }
  
  private void bKl()
  {
    int i = 0;
    while (i < this.ppC)
    {
      c.d locald = new c.d(this, (byte)0);
      locald.data = "";
      locald.id = getCount();
      locald.id = getCount();
      add(i, locald);
      i += 1;
    }
  }
  
  private List<c.d> cK(List<?> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      c.d locald = new c.d(this, (byte)0);
      locald.data = localObject;
      locald.id = i;
      localArrayList.add(locald);
      i += 1;
    }
    return localArrayList;
  }
  
  public final void bKm()
  {
    y.v("DynamicGridAdapter", "showAddImg %s, getCount %d, getHeaderCount %d, maxShowCount %d， showing %s", new Object[] { Boolean.valueOf(this.ppE), Integer.valueOf(getCount()), Integer.valueOf(this.ppC), Integer.valueOf(this.ppD), Boolean.valueOf(this.ppF) });
    if ((this.ppE) && (bKn() < this.ppD))
    {
      if (!this.ppF)
      {
        this.ppF = true;
        add("");
      }
      return;
    }
    this.ppF = false;
  }
  
  public final int bKn()
  {
    int j = getCount();
    int k = this.ppC;
    if (this.ppF) {}
    for (int i = 1;; i = 0) {
      return j - k - i;
    }
  }
  
  public final void cJ(List<?> paramList)
  {
    super.cJ(cK(paramList));
    bKl();
    bKm();
  }
  
  public final void clear()
  {
    super.clear();
    this.ppF = false;
  }
  
  public final void eb(int paramInt1, int paramInt2)
  {
    super.eb(paramInt1, paramInt2);
    if (this.ppG != null) {
      this.ppG.dV(paramInt1 - this.ppC, paramInt2 - this.ppC);
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (TextUtils.isEmpty(getItem(paramInt).toString())) {
      return 1;
    }
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from(getContext()).inflate(i.g.sns_preview_view_item, paramViewGroup, false);
      localObject2 = new c.b(this, (View)localObject1, (byte)0);
      ((View)localObject1).setTag(i.f.img_preview_tag, localObject2);
      localObject3 = ((c.b)localObject2).bNu;
      if (this.ppH == 0)
      {
        af.bDu();
        i = s.getScreenWidth();
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i != 0) {
          this.ppH = ((i - this.mContext.getResources().getDimensionPixelSize(i.d.sns_upload_previewimg_view_margin) * 4 - this.mContext.getResources().getDimensionPixelSize(i.d.LargerPadding) * 2) / 3);
        }
      }
      else
      {
        paramView = (LinearLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
        paramView.width = this.ppH;
        paramView.height = this.ppH;
        ((ImageView)localObject3).setLayoutParams(paramView);
        paramView = (View)localObject1;
        paramViewGroup = (ViewGroup)localObject2;
      }
      localObject1 = getItem(paramInt).toString();
      localObject2 = paramViewGroup.bNu;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label315;
      }
      ((ImageView)localObject2).setBackgroundResource(i.c.sns_upload_add_bg);
      ((ImageView)localObject2).setImageResource(i.i.album_post_add_picture_btn);
      ((ImageView)localObject2).setContentDescription(paramViewGroup.bNu.getContext().getString(i.j.sns_add_photo));
      int i = paramViewGroup.ppI.ppH * 35 / 100;
      ((ImageView)localObject2).setPadding(i, i, i, i);
      if (paramInt <= 0) {
        break label288;
      }
      paramViewGroup.view.setTag(Integer.valueOf(-1));
    }
    for (;;)
    {
      if (paramInt >= this.ppC) {
        break label440;
      }
      paramViewGroup.bNu.setVisibility(4);
      return paramView;
      paramViewGroup = (c.b)paramView.getTag(i.f.img_preview_tag);
      break;
      label288:
      if (paramInt < paramViewGroup.ppI.ppC)
      {
        paramViewGroup.view.setTag(Integer.valueOf(2147483647));
        continue;
        label315:
        paramViewGroup.view.setTag(Integer.valueOf(paramInt - paramViewGroup.ppI.ppC));
        ((ImageView)localObject2).setBackgroundDrawable(null);
        ((ImageView)localObject2).setTag(localObject1);
        ((ImageView)localObject2).setContentDescription(paramViewGroup.bNu.getContext().getString(i.j.sns_img));
        ((ImageView)localObject2).setPadding(0, 0, 0, 0);
        localObject3 = (Bitmap)paramViewGroup.ppI.oSv.get(localObject1);
        if (!i.s((Bitmap)localObject3)) {
          new c.c(paramViewGroup.ppI, (ImageView)localObject2, (String)localObject1).p(new String[] { "" });
        } else {
          ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
        }
      }
    }
    label440:
    paramViewGroup.bNu.setVisibility(0);
    paramView.setVisibility(0);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final boolean yZ(int paramInt)
  {
    if (paramInt < this.ppC) {}
    do
    {
      return false;
      if (!this.ppF) {
        break;
      }
    } while (paramInt == getCount() - 1);
    return true;
    return super.yZ(paramInt);
  }
  
  public final boolean za(int paramInt)
  {
    if (paramInt < this.ppC) {}
    do
    {
      return false;
      if (!this.ppF) {
        break;
      }
    } while (paramInt == getCount() - 1);
    return true;
    return super.za(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.c
 * JD-Core Version:    0.7.0.1
 */