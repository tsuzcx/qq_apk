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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PIntArray;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.MMHorList;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class FilterImageView
  extends LinearLayout
{
  static c[] ArQ;
  int[] ArH;
  private View ArI;
  private ImageView ArJ;
  CropImageView ArK;
  Bitmap ArL;
  private MMHorList ArM;
  private a ArN;
  private Runnable ArO;
  private Runnable ArP;
  private Activity cup;
  private int filterId;
  
  static
  {
    AppMethodBeat.i(107639);
    ArQ = new c[] { new c(new FilterImageView.b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new FilterImageView.b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new FilterImageView.b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new FilterImageView.b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new FilterImageView.b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new FilterImageView.b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new FilterImageView.b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new FilterImageView.b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new FilterImageView.b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new FilterImageView.b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new FilterImageView.b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new FilterImageView.b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12) };
    AppMethodBeat.o(107639);
  }
  
  public FilterImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107629);
    this.filterId = 0;
    this.cup = ((Activity)paramContext);
    paramContext = View.inflate(this.cup, 2130969287, this);
    this.ArK = ((CropImageView)paramContext.findViewById(2131823274));
    this.ArJ = ((ImageView)paramContext.findViewById(2131823277));
    this.ArI = paramContext.findViewById(2131823276);
    this.ArK.setOnTouchListener(null);
    this.ArM = ((MMHorList)paramContext.findViewById(2131823278));
    this.ArN = new a();
    this.ArM.setAdapter(this.ArN);
    this.ArM.invalidate();
    this.ArM.setOnItemClickListener(new FilterImageView.1(this));
    AppMethodBeat.o(107629);
  }
  
  private boolean aJ(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107637);
    if (paramInt2 == 0)
    {
      this.ArL.setPixels(this.ArH, 0, this.ArL.getWidth(), 0, 0, this.ArL.getWidth(), this.ArL.getHeight());
      this.ArK.invalidate();
      AppMethodBeat.o(107637);
      return true;
    }
    int j = this.ArL.getWidth() * this.ArL.getHeight();
    ab.d("MicroMsg.FilterView", "len:" + j + "  maskCount:" + paramInt1);
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { paramInt1, j });
    int i = 0;
    while (i < paramInt1)
    {
      Object localObject3 = String.format(paramString, new Object[] { Integer.valueOf(i) });
      Object localObject2 = null;
      Object localObject1 = null;
      Object localObject4;
      try
      {
        localObject3 = this.cup.getAssets().open("filter/".concat(String.valueOf(localObject3)));
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject4 = new byte[j];
        localObject1 = localObject3;
        localObject2 = localObject3;
        ((InputStream)localObject3).read((byte[])localObject4);
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject4 = d.bT((byte[])localObject4);
        localObject1 = localObject3;
        localObject2 = localObject3;
        ((InputStream)localObject3).close();
        if (localObject3 != null) {
          ((InputStream)localObject3).close();
        }
        if (localObject4 == null)
        {
          AppMethodBeat.o(107637);
          return false;
        }
      }
      catch (Exception paramString)
      {
        localObject2 = localObject1;
        AppMethodBeat.o(107637);
        localObject2 = localObject1;
        throw paramString;
      }
      finally
      {
        if (localObject2 != null) {
          localObject2.close();
        }
        AppMethodBeat.o(107637);
      }
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject4, this.ArL.getWidth(), this.ArL.getHeight(), true);
      if (localObject4 != localObject1)
      {
        ab.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { localObject4.toString() });
        ((Bitmap)localObject4).recycle();
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(107637);
        return false;
      }
      ((Bitmap)localObject1).getPixels(arrayOfInt[i], 0, ((Bitmap)localObject1).getWidth(), 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      ab.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { localObject1.toString() });
      ((Bitmap)localObject1).recycle();
      i += 1;
    }
    paramString = new PIntArray();
    ab.e("MicroMsg.FilterView", "src.len:" + this.ArH.length);
    i = 0;
    while (i < arrayOfInt.length)
    {
      ab.e("MicroMsg.FilterView", "mask[" + i + "].len:" + arrayOfInt[i].length);
      i += 1;
    }
    ab.e("MicroMsg.FilterView", "before filter");
    ImgFilter.FilterInt(paramInt2, this.ArH, arrayOfInt, paramInt1, this.ArL.getWidth(), this.ArL.getHeight(), paramString);
    ab.e("MicroMsg.FilterView", "after filter");
    this.ArL.setPixels(paramString.value, 0, this.ArL.getWidth(), 0, 0, this.ArL.getWidth(), this.ArL.getHeight());
    this.ArK.invalidate();
    AppMethodBeat.o(107637);
    return true;
  }
  
  public final void eW(String paramString, int paramInt)
  {
    AppMethodBeat.i(107635);
    ab.i("MicroMsg.FilterView", "filePath before fiterBmp:".concat(String.valueOf(paramString)));
    if ((this.ArL == null) || (this.ArL.isRecycled())) {
      this.ArL = d.b(d.d(paramString, 480, 480, false), paramInt);
    }
    ab.d("MicroMsg.FilterView", "filterBmp w:" + this.ArL.getWidth() + " h:" + this.ArL.getHeight());
    this.ArH = new int[this.ArL.getWidth() * this.ArL.getHeight()];
    this.ArL.getPixels(this.ArH, 0, this.ArL.getWidth(), 0, 0, this.ArL.getWidth(), this.ArL.getHeight());
    this.ArK.setImageBitmap(this.ArL);
    AppMethodBeat.o(107635);
  }
  
  public View getCropAreaView()
  {
    return this.ArI;
  }
  
  public CropImageView getCropImageIV()
  {
    return this.ArK;
  }
  
  public Bitmap getFilterBmp()
  {
    return this.ArL;
  }
  
  public int getFilterId()
  {
    return this.filterId;
  }
  
  public void setCropMaskBackground(int paramInt)
  {
    AppMethodBeat.i(107634);
    if (this.ArJ != null) {
      this.ArJ.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(107634);
  }
  
  public void setCropMaskVisible(int paramInt)
  {
    AppMethodBeat.i(107633);
    if (this.ArJ != null) {
      this.ArJ.setVisibility(paramInt);
    }
    AppMethodBeat.o(107633);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    this.ArL = paramBitmap;
  }
  
  public void setLimitZoomIn(boolean paramBoolean)
  {
    AppMethodBeat.i(107630);
    if (this.ArK != null) {
      this.ArK.setLimitZoomIn(paramBoolean);
    }
    AppMethodBeat.o(107630);
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(107632);
    if (this.ArK != null) {
      this.ArK.setImageMatrix(paramMatrix);
    }
    AppMethodBeat.o(107632);
  }
  
  public void setOnConfirmImp(Runnable paramRunnable)
  {
    this.ArO = paramRunnable;
  }
  
  public void setOnExitImp(Runnable paramRunnable)
  {
    this.ArP = paramRunnable;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(107636);
    if (paramInt == 0)
    {
      this.ArN.notifyDataSetChanged();
      this.ArM.invalidate();
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(107636);
  }
  
  final class a
    extends BaseAdapter
  {
    int lxQ = 0;
    
    a() {}
    
    public final int getCount()
    {
      return FilterImageView.ArQ.length;
    }
    
    public final Object getItem(int paramInt)
    {
      return FilterImageView.ArQ[paramInt];
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(107628);
      FilterImageView.c localc = (FilterImageView.c)getItem(paramInt);
      Object localObject1;
      if ((paramView == null) || (!(paramView.getTag() instanceof FilterImageView.a.a)))
      {
        paramViewGroup = View.inflate(FilterImageView.b(FilterImageView.this), 2130969582, null);
        localObject1 = new FilterImageView.a.a(this);
        ((FilterImageView.a.a)localObject1).euY = ((TextView)paramViewGroup.findViewById(2131824134));
        ((FilterImageView.a.a)localObject1).ArS = ((ImageView)paramViewGroup.findViewById(2131824133));
        paramViewGroup.setTag(localObject1);
      }
      for (;;)
      {
        Object localObject2 = ((FilterImageView.a.a)localObject1).euY;
        paramView = localc.ArX;
        String str = aa.dsG();
        if (str.equals("zh_CN"))
        {
          paramView = paramView.zLl;
          label120:
          ((TextView)localObject2).setText(paramView);
        }
        try
        {
          paramView = FilterImageView.b(FilterImageView.this).getAssets().open("filter/" + localc.cDz);
          ((FilterImageView.a.a)localObject1).ArT = d.decodeStream(paramView);
          paramView.close();
          ((FilterImageView.a.a)localObject1).ArS.setImageBitmap(((FilterImageView.a.a)localObject1).ArT);
          paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (paramInt == this.lxQ)
          {
            paramViewGroup.findViewById(2131824133).setBackgroundResource(2130838090);
            AppMethodBeat.o(107628);
            return paramViewGroup;
            localObject2 = (FilterImageView.a.a)paramView.getTag();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            if (((FilterImageView.a.a)localObject2).ArT == null) {
              continue;
            }
            ab.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { ((FilterImageView.a.a)localObject2).ArT.toString() });
            ((FilterImageView.a.a)localObject2).ArT.recycle();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            continue;
            if ((str.equals("zh_TW")) || (str.equals("zh_HK")))
            {
              paramView = paramView.ArV;
              break label120;
            }
            paramView = paramView.ArW;
          }
        }
        catch (IOException paramView)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.FilterView", paramView, "", new Object[0]);
            continue;
            paramViewGroup.findViewById(2131824133).setBackgroundResource(2130838091);
          }
        }
      }
    }
  }
  
  static final class c
  {
    FilterImageView.b ArX;
    String ArY;
    int ArZ;
    int Asa;
    int Asb;
    String cDz;
    
    c(FilterImageView.b paramb, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
    {
      this.ArX = paramb;
      this.ArY = paramString1;
      this.ArZ = paramInt1;
      this.Asa = paramInt2;
      this.cDz = paramString2;
      this.Asb = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.FilterImageView
 * JD-Core Version:    0.7.0.1
 */