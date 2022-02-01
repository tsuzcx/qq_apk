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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pointers.PIntArray;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.base.MMHorList;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class FilterImageView
  extends LinearLayout
{
  static c[] LbE;
  private MMHorList LbA;
  private a LbB;
  private Runnable LbC;
  private Runnable LbD;
  int[] Lbv;
  private View Lbw;
  private ImageView Lbx;
  CropImageView Lby;
  Bitmap Lbz;
  private Activity dtg;
  private int zup;
  
  static
  {
    AppMethodBeat.i(143078);
    LbE = new c[] { new c(new b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12) };
    AppMethodBeat.o(143078);
  }
  
  public FilterImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143069);
    this.zup = 0;
    this.dtg = ((Activity)paramContext);
    paramContext = View.inflate(this.dtg, 2131493675, this);
    this.Lby = ((CropImageView)paramContext.findViewById(2131298870));
    this.Lbx = ((ImageView)paramContext.findViewById(2131298879));
    this.Lbw = paramContext.findViewById(2131298874);
    this.Lby.setOnTouchListener(null);
    this.LbA = ((MMHorList)paramContext.findViewById(2131298867));
    this.LbB = new a();
    this.LbA.setAdapter(this.LbB);
    this.LbA.invalidate();
    this.LbA.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(143067);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        a.b("com/tencent/mm/ui/tools/FilterImageView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousAdapterView = FilterImageView.a(FilterImageView.this);
        paramAnonymousAdapterView.uT = paramAnonymousInt;
        paramAnonymousAdapterView.notifyDataSetChanged();
        try
        {
          FilterImageView.a(FilterImageView.this, FilterImageView.LbE[paramAnonymousInt].LbP);
          FilterImageView.a(FilterImageView.this, FilterImageView.LbE[paramAnonymousInt].LbM, FilterImageView.LbE[paramAnonymousInt].LbN, FilterImageView.LbE[paramAnonymousInt].LbO);
          a.a(this, "com/tencent/mm/ui/tools/FilterImageView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(143067);
          return;
        }
        catch (Exception paramAnonymousAdapterView)
        {
          for (;;)
          {
            ae.e("MicroMsg.FilterView", paramAnonymousAdapterView.toString());
            ae.printErrStackTrace("MicroMsg.FilterView", paramAnonymousAdapterView, "", new Object[0]);
          }
        }
        catch (OutOfMemoryError paramAnonymousAdapterView)
        {
          for (;;)
          {
            ae.e("MicroMsg.FilterView", paramAnonymousAdapterView.toString());
            ae.printErrStackTrace("MicroMsg.FilterView", paramAnonymousAdapterView, "", new Object[0]);
          }
        }
      }
    });
    AppMethodBeat.o(143069);
  }
  
  private boolean ba(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143076);
    if (paramInt2 == 0)
    {
      this.Lbz.setPixels(this.Lbv, 0, this.Lbz.getWidth(), 0, 0, this.Lbz.getWidth(), this.Lbz.getHeight());
      this.Lby.invalidate();
      AppMethodBeat.o(143076);
      return true;
    }
    int j = this.Lbz.getWidth() * this.Lbz.getHeight();
    ae.d("MicroMsg.FilterView", "len:" + j + "  maskCount:" + paramInt1);
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
        localObject3 = this.dtg.getAssets().open("filter/".concat(String.valueOf(localObject3)));
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject4 = new byte[j];
        localObject1 = localObject3;
        localObject2 = localObject3;
        ((InputStream)localObject3).read((byte[])localObject4);
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject4 = h.cu((byte[])localObject4);
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
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject4, this.Lbz.getWidth(), this.Lbz.getHeight(), true);
      if (localObject4 != localObject1)
      {
        ae.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { localObject4.toString() });
        ((Bitmap)localObject4).recycle();
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(143076);
        return false;
      }
      ((Bitmap)localObject1).getPixels(arrayOfInt[i], 0, ((Bitmap)localObject1).getWidth(), 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      ae.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { localObject1.toString() });
      ((Bitmap)localObject1).recycle();
      i += 1;
    }
    paramString = new PIntArray();
    ae.e("MicroMsg.FilterView", "src.len:" + this.Lbv.length);
    i = 0;
    while (i < arrayOfInt.length)
    {
      ae.e("MicroMsg.FilterView", "mask[" + i + "].len:" + arrayOfInt[i].length);
      i += 1;
    }
    ae.e("MicroMsg.FilterView", "before filter");
    ImgFilter.FilterInt(paramInt2, this.Lbv, arrayOfInt, paramInt1, this.Lbz.getWidth(), this.Lbz.getHeight(), paramString);
    ae.e("MicroMsg.FilterView", "after filter");
    this.Lbz.setPixels(paramString.value, 0, this.Lbz.getWidth(), 0, 0, this.Lbz.getWidth(), this.Lbz.getHeight());
    this.Lby.invalidate();
    AppMethodBeat.o(143076);
    return true;
  }
  
  public final void gS(String paramString, int paramInt)
  {
    AppMethodBeat.i(143074);
    ae.i("MicroMsg.FilterView", "filePath before fiterBmp:".concat(String.valueOf(paramString)));
    if ((this.Lbz == null) || (this.Lbz.isRecycled())) {
      this.Lbz = h.a(h.d(paramString, 480, 480, false), paramInt);
    }
    ae.d("MicroMsg.FilterView", "filterBmp w:" + this.Lbz.getWidth() + " h:" + this.Lbz.getHeight());
    this.Lbv = new int[this.Lbz.getWidth() * this.Lbz.getHeight()];
    this.Lbz.getPixels(this.Lbv, 0, this.Lbz.getWidth(), 0, 0, this.Lbz.getWidth(), this.Lbz.getHeight());
    this.Lby.setImageBitmap(this.Lbz);
    AppMethodBeat.o(143074);
  }
  
  public View getCropAreaView()
  {
    return this.Lbw;
  }
  
  public CropImageView getCropImageIV()
  {
    return this.Lby;
  }
  
  public Bitmap getFilterBmp()
  {
    return this.Lbz;
  }
  
  public int getFilterId()
  {
    return this.zup;
  }
  
  public void setCropMaskBackground(int paramInt)
  {
    AppMethodBeat.i(143073);
    if (this.Lbx != null) {
      this.Lbx.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(143073);
  }
  
  public void setCropMaskVisible(int paramInt)
  {
    AppMethodBeat.i(143072);
    if (this.Lbx != null) {
      this.Lbx.setVisibility(paramInt);
    }
    AppMethodBeat.o(143072);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    this.Lbz = paramBitmap;
  }
  
  public void setLimitZoomIn(boolean paramBoolean)
  {
    AppMethodBeat.i(143070);
    if (this.Lby != null) {
      this.Lby.setLimitZoomIn(paramBoolean);
    }
    AppMethodBeat.o(143070);
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(143071);
    if (this.Lby != null) {
      this.Lby.setImageMatrix(paramMatrix);
    }
    AppMethodBeat.o(143071);
  }
  
  public void setOnConfirmImp(Runnable paramRunnable)
  {
    this.LbC = paramRunnable;
  }
  
  public void setOnExitImp(Runnable paramRunnable)
  {
    this.LbD = paramRunnable;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(143075);
    if (paramInt == 0)
    {
      this.LbB.notifyDataSetChanged();
      this.LbA.invalidate();
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(143075);
  }
  
  final class a
    extends BaseAdapter
  {
    int uT = 0;
    
    a() {}
    
    public final int getCount()
    {
      return FilterImageView.LbE.length;
    }
    
    public final Object getItem(int paramInt)
    {
      return FilterImageView.LbE[paramInt];
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
        ((a)localObject1).vk = ((TextView)paramViewGroup.findViewById(2131299965));
        ((a)localObject1).LbG = ((ImageView)paramViewGroup.findViewById(2131299964));
        paramViewGroup.setTag(localObject1);
      }
      for (;;)
      {
        Object localObject2 = ((a)localObject1).vk;
        paramView = localc.LbL;
        String str = ad.fom();
        if (str.equals("zh_CN"))
        {
          paramView = paramView.Kmb;
          label120:
          ((TextView)localObject2).setText(paramView);
        }
        try
        {
          paramView = FilterImageView.b(FilterImageView.this).getAssets().open("filter/" + localc.dEM);
          ((a)localObject1).LbH = h.decodeStream(paramView);
          paramView.close();
          ((a)localObject1).LbG.setImageBitmap(((a)localObject1).LbH);
          paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (paramInt == this.uT)
          {
            paramViewGroup.findViewById(2131299964).setBackgroundResource(2131231418);
            AppMethodBeat.o(143068);
            return paramViewGroup;
            localObject2 = (a)paramView.getTag();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            if (((a)localObject2).LbH == null) {
              continue;
            }
            ae.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { ((a)localObject2).LbH.toString() });
            ((a)localObject2).LbH.recycle();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            continue;
            if ((str.equals("zh_TW")) || (str.equals("zh_HK")))
            {
              paramView = paramView.LbJ;
              break label120;
            }
            paramView = paramView.LbK;
          }
        }
        catch (IOException paramView)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.FilterView", paramView, "", new Object[0]);
            continue;
            paramViewGroup.findViewById(2131299964).setBackgroundResource(2131231419);
          }
        }
      }
    }
    
    final class a
    {
      ImageView LbG;
      Bitmap LbH;
      TextView vk;
      
      a() {}
    }
  }
  
  static final class b
  {
    String Kmb;
    String LbJ;
    String LbK;
    
    b(String paramString1, String paramString2, String paramString3)
    {
      this.Kmb = paramString1;
      this.LbJ = paramString2;
      this.LbK = paramString3;
    }
  }
  
  static final class c
  {
    FilterImageView.b LbL;
    String LbM;
    int LbN;
    int LbO;
    int LbP;
    String dEM;
    
    c(FilterImageView.b paramb, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
    {
      this.LbL = paramb;
      this.LbM = paramString1;
      this.LbN = paramInt1;
      this.LbO = paramInt2;
      this.dEM = paramString2;
      this.LbP = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.FilterImageView
 * JD-Core Version:    0.7.0.1
 */