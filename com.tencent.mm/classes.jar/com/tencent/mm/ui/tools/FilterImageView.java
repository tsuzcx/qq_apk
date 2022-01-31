package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.pointers.PIntArray;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMHorList;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class FilterImageView
  extends LinearLayout
{
  static c[] vZD = { new c(new FilterImageView.b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new FilterImageView.b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new FilterImageView.b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new FilterImageView.b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new FilterImageView.b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new FilterImageView.b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new FilterImageView.b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new FilterImageView.b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new FilterImageView.b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new FilterImageView.b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new FilterImageView.b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new FilterImageView.b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12) };
  private Activity bMV;
  private int filterId = 0;
  private a vZA;
  private Runnable vZB;
  private Runnable vZC;
  int[] vZu;
  private View vZv;
  private ImageView vZw;
  CropImageView vZx;
  Bitmap vZy;
  private MMHorList vZz;
  
  public FilterImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bMV = ((Activity)paramContext);
    paramContext = View.inflate(this.bMV, a.h.crop_image_filter, this);
    this.vZx = ((CropImageView)paramContext.findViewById(a.g.cropimage_filter_show_iv));
    this.vZw = ((ImageView)paramContext.findViewById(a.g.cropimage_iv));
    this.vZv = paramContext.findViewById(a.g.cropimage_frame);
    this.vZx.setOnTouchListener(null);
    this.vZz = ((MMHorList)paramContext.findViewById(a.g.cropimage_filter_gallery));
    this.vZA = new a();
    this.vZz.setAdapter(this.vZA);
    this.vZz.invalidate();
    this.vZz.setOnItemClickListener(new FilterImageView.1(this));
  }
  
  private boolean as(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt2 == 0)
    {
      this.vZy.setPixels(this.vZu, 0, this.vZy.getWidth(), 0, 0, this.vZy.getWidth(), this.vZy.getHeight());
      this.vZx.invalidate();
      bool1 = true;
    }
    int[][] arrayOfInt;
    for (;;)
    {
      return bool1;
      int j = this.vZy.getWidth() * this.vZy.getHeight();
      y.d("MicroMsg.FilterView", "len:" + j + "  maskCount:" + paramInt1);
      arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { paramInt1, j });
      i = 0;
      label132:
      if (i < paramInt1)
      {
        Object localObject3 = String.format(paramString, new Object[] { Integer.valueOf(i) });
        Object localObject2 = null;
        Object localObject1 = null;
        try
        {
          localObject3 = this.bMV.getAssets().open("filter/" + (String)localObject3);
          localObject1 = localObject3;
          localObject2 = localObject3;
          Object localObject4 = new byte[j];
          localObject1 = localObject3;
          localObject2 = localObject3;
          ((InputStream)localObject3).read((byte[])localObject4);
          localObject1 = localObject3;
          localObject2 = localObject3;
          localObject4 = c.bu((byte[])localObject4);
          localObject1 = localObject3;
          localObject2 = localObject3;
          ((InputStream)localObject3).close();
          if (localObject3 != null) {
            ((InputStream)localObject3).close();
          }
          bool1 = bool2;
          if (localObject4 != null)
          {
            localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject4, this.vZy.getWidth(), this.vZy.getHeight(), true);
            if (localObject4 != localObject1)
            {
              y.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { localObject4.toString() });
              ((Bitmap)localObject4).recycle();
            }
            bool1 = bool2;
            if (localObject1 != null)
            {
              ((Bitmap)localObject1).getPixels(arrayOfInt[i], 0, ((Bitmap)localObject1).getWidth(), 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
              y.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { localObject1.toString() });
              ((Bitmap)localObject1).recycle();
              i += 1;
              break label132;
            }
          }
        }
        catch (Exception paramString)
        {
          localObject2 = localObject1;
          throw paramString;
        }
        finally
        {
          if (localObject2 != null) {
            localObject2.close();
          }
        }
      }
    }
    paramString = new PIntArray();
    y.e("MicroMsg.FilterView", "src.len:" + this.vZu.length);
    int i = 0;
    while (i < arrayOfInt.length)
    {
      y.e("MicroMsg.FilterView", "mask[" + i + "].len:" + arrayOfInt[i].length);
      i += 1;
    }
    y.e("MicroMsg.FilterView", "before filter");
    ImgFilter.FilterInt(paramInt2, this.vZu, arrayOfInt, paramInt1, this.vZy.getWidth(), this.vZy.getHeight(), paramString);
    y.e("MicroMsg.FilterView", "after filter");
    this.vZy.setPixels(paramString.value, 0, this.vZy.getWidth(), 0, 0, this.vZy.getWidth(), this.vZy.getHeight());
    this.vZx.invalidate();
    return true;
  }
  
  public final void dM(String paramString, int paramInt)
  {
    y.i("MicroMsg.FilterView", "filePath before fiterBmp:" + paramString);
    if ((this.vZy == null) || (this.vZy.isRecycled())) {
      this.vZy = c.b(c.e(paramString, 480, 480, false), paramInt);
    }
    y.d("MicroMsg.FilterView", "filterBmp w:" + this.vZy.getWidth() + " h:" + this.vZy.getHeight());
    this.vZu = new int[this.vZy.getWidth() * this.vZy.getHeight()];
    this.vZy.getPixels(this.vZu, 0, this.vZy.getWidth(), 0, 0, this.vZy.getWidth(), this.vZy.getHeight());
    this.vZx.setImageBitmap(this.vZy);
  }
  
  public View getCropAreaView()
  {
    return this.vZv;
  }
  
  public CropImageView getCropImageIV()
  {
    return this.vZx;
  }
  
  public Bitmap getFilterBmp()
  {
    return this.vZy;
  }
  
  public int getFilterId()
  {
    return this.filterId;
  }
  
  public void setCropMaskBackground(int paramInt)
  {
    if (this.vZw != null) {
      this.vZw.setBackgroundResource(paramInt);
    }
  }
  
  public void setCropMaskVisible(int paramInt)
  {
    if (this.vZw != null) {
      this.vZw.setVisibility(paramInt);
    }
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    this.vZy = paramBitmap;
  }
  
  public void setLimitZoomIn(boolean paramBoolean)
  {
    if (this.vZx != null) {
      this.vZx.setLimitZoomIn(paramBoolean);
    }
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    if (this.vZx != null) {
      this.vZx.setImageMatrix(paramMatrix);
    }
  }
  
  public void setOnConfirmImp(Runnable paramRunnable)
  {
    this.vZB = paramRunnable;
  }
  
  public void setOnExitImp(Runnable paramRunnable)
  {
    this.vZC = paramRunnable;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 0)
    {
      this.vZA.notifyDataSetChanged();
      this.vZz.invalidate();
    }
    super.setVisibility(paramInt);
  }
  
  final class a
    extends BaseAdapter
  {
    int lJz = 0;
    
    a() {}
    
    public final int getCount()
    {
      return FilterImageView.vZD.length;
    }
    
    public final Object getItem(int paramInt)
    {
      return FilterImageView.vZD[paramInt];
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      FilterImageView.c localc = (FilterImageView.c)getItem(paramInt);
      Object localObject1;
      if ((paramView == null) || (!(paramView.getTag() instanceof FilterImageView.a.a)))
      {
        paramViewGroup = View.inflate(FilterImageView.b(FilterImageView.this), a.h.filter_selecter_item, null);
        localObject1 = new FilterImageView.a.a(this);
        ((FilterImageView.a.a)localObject1).flb = ((TextView)paramViewGroup.findViewById(a.g.filter_selecter_tv));
        ((FilterImageView.a.a)localObject1).vZF = ((ImageView)paramViewGroup.findViewById(a.g.filter_selecter_img));
        paramViewGroup.setTag(localObject1);
      }
      for (;;)
      {
        Object localObject2 = ((FilterImageView.a.a)localObject1).flb;
        paramView = localc.vZK;
        String str = x.cqJ();
        if (str.equals("zh_CN"))
        {
          paramView = paramView.vvk;
          label118:
          ((TextView)localObject2).setText(paramView);
        }
        try
        {
          paramView = FilterImageView.b(FilterImageView.this).getAssets().open("filter/" + localc.bVO);
          ((FilterImageView.a.a)localObject1).vZG = c.decodeStream(paramView);
          paramView.close();
          ((FilterImageView.a.a)localObject1).vZF.setImageBitmap(((FilterImageView.a.a)localObject1).vZG);
          paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (paramInt == this.lJz)
          {
            paramViewGroup.findViewById(a.g.filter_selecter_img).setBackgroundResource(a.f.camera_filter_reviewbox_checked);
            return paramViewGroup;
            localObject2 = (FilterImageView.a.a)paramView.getTag();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            if (((FilterImageView.a.a)localObject2).vZG == null) {
              continue;
            }
            y.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { ((FilterImageView.a.a)localObject2).vZG.toString() });
            ((FilterImageView.a.a)localObject2).vZG.recycle();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            continue;
            if ((str.equals("zh_TW")) || (str.equals("zh_HK")))
            {
              paramView = paramView.vZI;
              break label118;
            }
            paramView = paramView.vZJ;
          }
        }
        catch (IOException paramView)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.FilterView", paramView, "", new Object[0]);
          }
          paramViewGroup.findViewById(a.g.filter_selecter_img).setBackgroundResource(a.f.camera_filter_reviewbox_normal);
        }
      }
      return paramViewGroup;
    }
  }
  
  static final class c
  {
    String bVO;
    FilterImageView.b vZK;
    String vZL;
    int vZM;
    int vZN;
    int vZO;
    
    c(FilterImageView.b paramb, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
    {
      this.vZK = paramb;
      this.vZL = paramString1;
      this.vZM = paramInt1;
      this.vZN = paramInt2;
      this.bVO = paramString2;
      this.vZO = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.FilterImageView
 * JD-Core Version:    0.7.0.1
 */