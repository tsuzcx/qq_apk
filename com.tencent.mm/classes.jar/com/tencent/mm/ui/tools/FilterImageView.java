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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PIntArray;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.MMHorList;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class FilterImageView
  extends LinearLayout
{
  static c[] HnJ;
  int[] HnA;
  private View HnB;
  private ImageView HnC;
  CropImageView HnD;
  Bitmap HnE;
  private MMHorList HnF;
  private a HnG;
  private Runnable HnH;
  private Runnable HnI;
  private Activity djj;
  private int wBk;
  
  static
  {
    AppMethodBeat.i(143078);
    HnJ = new c[] { new c(new b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12) };
    AppMethodBeat.o(143078);
  }
  
  public FilterImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143069);
    this.wBk = 0;
    this.djj = ((Activity)paramContext);
    paramContext = View.inflate(this.djj, 2131493675, this);
    this.HnD = ((CropImageView)paramContext.findViewById(2131298870));
    this.HnC = ((ImageView)paramContext.findViewById(2131298879));
    this.HnB = paramContext.findViewById(2131298874);
    this.HnD.setOnTouchListener(null);
    this.HnF = ((MMHorList)paramContext.findViewById(2131298867));
    this.HnG = new a();
    this.HnF.setAdapter(this.HnG);
    this.HnF.invalidate();
    this.HnF.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(143067);
        paramAnonymousAdapterView = FilterImageView.a(FilterImageView.this);
        paramAnonymousAdapterView.rZ = paramAnonymousInt;
        paramAnonymousAdapterView.notifyDataSetChanged();
        try
        {
          FilterImageView.a(FilterImageView.this, FilterImageView.HnJ[paramAnonymousInt].HnU);
          FilterImageView.a(FilterImageView.this, FilterImageView.HnJ[paramAnonymousInt].HnR, FilterImageView.HnJ[paramAnonymousInt].HnS, FilterImageView.HnJ[paramAnonymousInt].HnT);
          AppMethodBeat.o(143067);
          return;
        }
        catch (Exception paramAnonymousAdapterView)
        {
          ad.e("MicroMsg.FilterView", paramAnonymousAdapterView.toString());
          ad.printErrStackTrace("MicroMsg.FilterView", paramAnonymousAdapterView, "", new Object[0]);
          AppMethodBeat.o(143067);
          return;
        }
        catch (OutOfMemoryError paramAnonymousAdapterView)
        {
          ad.e("MicroMsg.FilterView", paramAnonymousAdapterView.toString());
          ad.printErrStackTrace("MicroMsg.FilterView", paramAnonymousAdapterView, "", new Object[0]);
          AppMethodBeat.o(143067);
        }
      }
    });
    AppMethodBeat.o(143069);
  }
  
  private boolean aQ(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143076);
    if (paramInt2 == 0)
    {
      this.HnE.setPixels(this.HnA, 0, this.HnE.getWidth(), 0, 0, this.HnE.getWidth(), this.HnE.getHeight());
      this.HnD.invalidate();
      AppMethodBeat.o(143076);
      return true;
    }
    int j = this.HnE.getWidth() * this.HnE.getHeight();
    ad.d("MicroMsg.FilterView", "len:" + j + "  maskCount:" + paramInt1);
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
        localObject3 = this.djj.getAssets().open("filter/".concat(String.valueOf(localObject3)));
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject4 = new byte[j];
        localObject1 = localObject3;
        localObject2 = localObject3;
        ((InputStream)localObject3).read((byte[])localObject4);
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject4 = f.cl((byte[])localObject4);
        localObject1 = localObject3;
        localObject2 = localObject3;
        ((InputStream)localObject3).close();
        if (localObject3 != null) {
          ((InputStream)localObject3).close();
        }
        if (localObject4 == null)
        {
          AppMethodBeat.o(143076);
          return false;
        }
      }
      catch (Exception paramString)
      {
        localObject2 = localObject1;
        AppMethodBeat.o(143076);
        localObject2 = localObject1;
        throw paramString;
      }
      finally
      {
        if (localObject2 != null) {
          localObject2.close();
        }
        AppMethodBeat.o(143076);
      }
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject4, this.HnE.getWidth(), this.HnE.getHeight(), true);
      if (localObject4 != localObject1)
      {
        ad.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { localObject4.toString() });
        ((Bitmap)localObject4).recycle();
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(143076);
        return false;
      }
      ((Bitmap)localObject1).getPixels(arrayOfInt[i], 0, ((Bitmap)localObject1).getWidth(), 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      ad.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { localObject1.toString() });
      ((Bitmap)localObject1).recycle();
      i += 1;
    }
    paramString = new PIntArray();
    ad.e("MicroMsg.FilterView", "src.len:" + this.HnA.length);
    i = 0;
    while (i < arrayOfInt.length)
    {
      ad.e("MicroMsg.FilterView", "mask[" + i + "].len:" + arrayOfInt[i].length);
      i += 1;
    }
    ad.e("MicroMsg.FilterView", "before filter");
    ImgFilter.FilterInt(paramInt2, this.HnA, arrayOfInt, paramInt1, this.HnE.getWidth(), this.HnE.getHeight(), paramString);
    ad.e("MicroMsg.FilterView", "after filter");
    this.HnE.setPixels(paramString.value, 0, this.HnE.getWidth(), 0, 0, this.HnE.getWidth(), this.HnE.getHeight());
    this.HnD.invalidate();
    AppMethodBeat.o(143076);
    return true;
  }
  
  public View getCropAreaView()
  {
    return this.HnB;
  }
  
  public CropImageView getCropImageIV()
  {
    return this.HnD;
  }
  
  public Bitmap getFilterBmp()
  {
    return this.HnE;
  }
  
  public int getFilterId()
  {
    return this.wBk;
  }
  
  public final void gi(String paramString, int paramInt)
  {
    AppMethodBeat.i(143074);
    ad.i("MicroMsg.FilterView", "filePath before fiterBmp:".concat(String.valueOf(paramString)));
    if ((this.HnE == null) || (this.HnE.isRecycled())) {
      this.HnE = f.a(f.e(paramString, 480, 480, false), paramInt);
    }
    ad.d("MicroMsg.FilterView", "filterBmp w:" + this.HnE.getWidth() + " h:" + this.HnE.getHeight());
    this.HnA = new int[this.HnE.getWidth() * this.HnE.getHeight()];
    this.HnE.getPixels(this.HnA, 0, this.HnE.getWidth(), 0, 0, this.HnE.getWidth(), this.HnE.getHeight());
    this.HnD.setImageBitmap(this.HnE);
    AppMethodBeat.o(143074);
  }
  
  public void setCropMaskBackground(int paramInt)
  {
    AppMethodBeat.i(143073);
    if (this.HnC != null) {
      this.HnC.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(143073);
  }
  
  public void setCropMaskVisible(int paramInt)
  {
    AppMethodBeat.i(143072);
    if (this.HnC != null) {
      this.HnC.setVisibility(paramInt);
    }
    AppMethodBeat.o(143072);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    this.HnE = paramBitmap;
  }
  
  public void setLimitZoomIn(boolean paramBoolean)
  {
    AppMethodBeat.i(143070);
    if (this.HnD != null) {
      this.HnD.setLimitZoomIn(paramBoolean);
    }
    AppMethodBeat.o(143070);
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(143071);
    if (this.HnD != null) {
      this.HnD.setImageMatrix(paramMatrix);
    }
    AppMethodBeat.o(143071);
  }
  
  public void setOnConfirmImp(Runnable paramRunnable)
  {
    this.HnH = paramRunnable;
  }
  
  public void setOnExitImp(Runnable paramRunnable)
  {
    this.HnI = paramRunnable;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(143075);
    if (paramInt == 0)
    {
      this.HnG.notifyDataSetChanged();
      this.HnF.invalidate();
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(143075);
  }
  
  final class a
    extends BaseAdapter
  {
    int rZ = 0;
    
    a() {}
    
    public final int getCount()
    {
      return FilterImageView.HnJ.length;
    }
    
    public final Object getItem(int paramInt)
    {
      return FilterImageView.HnJ[paramInt];
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(143068);
      FilterImageView.c localc = (FilterImageView.c)getItem(paramInt);
      Object localObject1;
      if ((paramView == null) || (!(paramView.getTag() instanceof a)))
      {
        paramViewGroup = View.inflate(FilterImageView.b(FilterImageView.this), 2131494005, null);
        localObject1 = new a();
        ((a)localObject1).ss = ((TextView)paramViewGroup.findViewById(2131299965));
        ((a)localObject1).HnL = ((ImageView)paramViewGroup.findViewById(2131299964));
        paramViewGroup.setTag(localObject1);
      }
      for (;;)
      {
        Object localObject2 = ((a)localObject1).ss;
        paramView = localc.HnQ;
        String str = ac.eFu();
        if (str.equals("zh_CN"))
        {
          paramView = paramView.GBD;
          label120:
          ((TextView)localObject2).setText(paramView);
        }
        try
        {
          paramView = FilterImageView.b(FilterImageView.this).getAssets().open("filter/" + localc.dub);
          ((a)localObject1).HnM = f.decodeStream(paramView);
          paramView.close();
          ((a)localObject1).HnL.setImageBitmap(((a)localObject1).HnM);
          paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (paramInt == this.rZ)
          {
            paramViewGroup.findViewById(2131299964).setBackgroundResource(2131231418);
            AppMethodBeat.o(143068);
            return paramViewGroup;
            localObject2 = (a)paramView.getTag();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            if (((a)localObject2).HnM == null) {
              continue;
            }
            ad.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { ((a)localObject2).HnM.toString() });
            ((a)localObject2).HnM.recycle();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            continue;
            if ((str.equals("zh_TW")) || (str.equals("zh_HK")))
            {
              paramView = paramView.HnO;
              break label120;
            }
            paramView = paramView.HnP;
          }
        }
        catch (IOException paramView)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.FilterView", paramView, "", new Object[0]);
            continue;
            paramViewGroup.findViewById(2131299964).setBackgroundResource(2131231419);
          }
        }
      }
    }
    
    final class a
    {
      ImageView HnL;
      Bitmap HnM;
      TextView ss;
      
      a() {}
    }
  }
  
  static final class b
  {
    String GBD;
    String HnO;
    String HnP;
    
    b(String paramString1, String paramString2, String paramString3)
    {
      this.GBD = paramString1;
      this.HnO = paramString2;
      this.HnP = paramString3;
    }
  }
  
  static final class c
  {
    FilterImageView.b HnQ;
    String HnR;
    int HnS;
    int HnT;
    int HnU;
    String dub;
    
    c(FilterImageView.b paramb, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
    {
      this.HnQ = paramb;
      this.HnR = paramString1;
      this.HnS = paramInt1;
      this.HnT = paramInt2;
      this.dub = paramString2;
      this.HnU = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.FilterImageView
 * JD-Core Version:    0.7.0.1
 */