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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMHorList;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class FilterImageView
  extends LinearLayout
{
  static c[] QqF;
  private int DEz;
  Bitmap QqA;
  private MMHorList QqB;
  private a QqC;
  private Runnable QqD;
  private Runnable QqE;
  int[] Qqw;
  private View Qqx;
  private ImageView Qqy;
  CropImageView Qqz;
  private Activity dKq;
  
  static
  {
    AppMethodBeat.i(143078);
    QqF = new c[] { new c(new b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12) };
    AppMethodBeat.o(143078);
  }
  
  public FilterImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143069);
    this.DEz = 0;
    this.dKq = ((Activity)paramContext);
    paramContext = View.inflate(this.dKq, 2131493806, this);
    this.Qqz = ((CropImageView)paramContext.findViewById(2131299345));
    this.Qqy = ((ImageView)paramContext.findViewById(2131299354));
    this.Qqx = paramContext.findViewById(2131299349);
    this.Qqz.setOnTouchListener(null);
    this.QqB = ((MMHorList)paramContext.findViewById(2131299342));
    this.QqC = new a();
    this.QqB.setAdapter(this.QqC);
    this.QqB.invalidate();
    this.QqB.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(143067);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/ui/tools/FilterImageView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = FilterImageView.a(FilterImageView.this);
        paramAnonymousAdapterView.va = paramAnonymousInt;
        paramAnonymousAdapterView.notifyDataSetChanged();
        try
        {
          FilterImageView.a(FilterImageView.this, FilterImageView.QqF[paramAnonymousInt].QqQ);
          FilterImageView.a(FilterImageView.this, FilterImageView.QqF[paramAnonymousInt].QqN, FilterImageView.QqF[paramAnonymousInt].QqO, FilterImageView.QqF[paramAnonymousInt].QqP);
          a.a(this, "com/tencent/mm/ui/tools/FilterImageView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(143067);
          return;
        }
        catch (Exception paramAnonymousAdapterView)
        {
          for (;;)
          {
            Log.e("MicroMsg.FilterView", paramAnonymousAdapterView.toString());
            Log.printErrStackTrace("MicroMsg.FilterView", paramAnonymousAdapterView, "", new Object[0]);
          }
        }
        catch (OutOfMemoryError paramAnonymousAdapterView)
        {
          for (;;)
          {
            Log.e("MicroMsg.FilterView", paramAnonymousAdapterView.toString());
            Log.printErrStackTrace("MicroMsg.FilterView", paramAnonymousAdapterView, "", new Object[0]);
          }
        }
      }
    });
    AppMethodBeat.o(143069);
  }
  
  private boolean aV(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143076);
    if (paramInt2 == 0)
    {
      this.QqA.setPixels(this.Qqw, 0, this.QqA.getWidth(), 0, 0, this.QqA.getWidth(), this.QqA.getHeight());
      this.Qqz.invalidate();
      AppMethodBeat.o(143076);
      return true;
    }
    int j = this.QqA.getWidth() * this.QqA.getHeight();
    Log.d("MicroMsg.FilterView", "len:" + j + "  maskCount:" + paramInt1);
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
        localObject3 = this.dKq.getAssets().open("filter/".concat(String.valueOf(localObject3)));
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject4 = new byte[j];
        localObject1 = localObject3;
        localObject2 = localObject3;
        ((InputStream)localObject3).read((byte[])localObject4);
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject4 = BitmapUtil.decodeByteArray((byte[])localObject4);
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
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject4, this.QqA.getWidth(), this.QqA.getHeight(), true);
      if (localObject4 != localObject1)
      {
        Log.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { localObject4.toString() });
        ((Bitmap)localObject4).recycle();
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(143076);
        return false;
      }
      ((Bitmap)localObject1).getPixels(arrayOfInt[i], 0, ((Bitmap)localObject1).getWidth(), 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      Log.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { localObject1.toString() });
      ((Bitmap)localObject1).recycle();
      i += 1;
    }
    paramString = new PIntArray();
    Log.e("MicroMsg.FilterView", "src.len:" + this.Qqw.length);
    i = 0;
    while (i < arrayOfInt.length)
    {
      Log.e("MicroMsg.FilterView", "mask[" + i + "].len:" + arrayOfInt[i].length);
      i += 1;
    }
    Log.e("MicroMsg.FilterView", "before filter");
    ImgFilter.FilterInt(paramInt2, this.Qqw, arrayOfInt, paramInt1, this.QqA.getWidth(), this.QqA.getHeight(), paramString);
    Log.e("MicroMsg.FilterView", "after filter");
    this.QqA.setPixels(paramString.value, 0, this.QqA.getWidth(), 0, 0, this.QqA.getWidth(), this.QqA.getHeight());
    this.Qqz.invalidate();
    AppMethodBeat.o(143076);
    return true;
  }
  
  public View getCropAreaView()
  {
    return this.Qqx;
  }
  
  public CropImageView getCropImageIV()
  {
    return this.Qqz;
  }
  
  public Bitmap getFilterBmp()
  {
    return this.QqA;
  }
  
  public int getFilterId()
  {
    return this.DEz;
  }
  
  public final void hl(String paramString, int paramInt)
  {
    AppMethodBeat.i(143074);
    Log.i("MicroMsg.FilterView", "filePath before fiterBmp:".concat(String.valueOf(paramString)));
    if ((this.QqA == null) || (this.QqA.isRecycled())) {
      this.QqA = BitmapUtil.rotate(BitmapUtil.extractThumbNail(paramString, 480, 480, false), paramInt);
    }
    Log.d("MicroMsg.FilterView", "filterBmp w:" + this.QqA.getWidth() + " h:" + this.QqA.getHeight());
    this.Qqw = new int[this.QqA.getWidth() * this.QqA.getHeight()];
    this.QqA.getPixels(this.Qqw, 0, this.QqA.getWidth(), 0, 0, this.QqA.getWidth(), this.QqA.getHeight());
    this.Qqz.setImageBitmap(this.QqA);
    AppMethodBeat.o(143074);
  }
  
  public void setCropMaskBackground(int paramInt)
  {
    AppMethodBeat.i(143073);
    if (this.Qqy != null) {
      this.Qqy.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(143073);
  }
  
  public void setCropMaskVisible(int paramInt)
  {
    AppMethodBeat.i(143072);
    if (this.Qqy != null) {
      this.Qqy.setVisibility(paramInt);
    }
    AppMethodBeat.o(143072);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    this.QqA = paramBitmap;
  }
  
  public void setLimitZoomIn(boolean paramBoolean)
  {
    AppMethodBeat.i(143070);
    if (this.Qqz != null) {
      this.Qqz.setLimitZoomIn(paramBoolean);
    }
    AppMethodBeat.o(143070);
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(143071);
    if (this.Qqz != null) {
      this.Qqz.setImageMatrix(paramMatrix);
    }
    AppMethodBeat.o(143071);
  }
  
  public void setOnConfirmImp(Runnable paramRunnable)
  {
    this.QqD = paramRunnable;
  }
  
  public void setOnExitImp(Runnable paramRunnable)
  {
    this.QqE = paramRunnable;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(143075);
    if (paramInt == 0)
    {
      this.QqC.notifyDataSetChanged();
      this.QqB.invalidate();
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(143075);
  }
  
  final class a
    extends BaseAdapter
  {
    int va = 0;
    
    a() {}
    
    public final int getCount()
    {
      return FilterImageView.QqF.length;
    }
    
    public final Object getItem(int paramInt)
    {
      return FilterImageView.QqF[paramInt];
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
        paramViewGroup = View.inflate(FilterImageView.b(FilterImageView.this), 2131494185, null);
        localObject1 = new a();
        ((a)localObject1).vr = ((TextView)paramViewGroup.findViewById(2131300721));
        ((a)localObject1).QqH = ((ImageView)paramViewGroup.findViewById(2131300720));
        paramViewGroup.setTag(localObject1);
      }
      for (;;)
      {
        Object localObject2 = ((a)localObject1).vr;
        paramView = localc.QqM;
        String str = LocaleUtil.getApplicationLanguage();
        if (str.equals("zh_CN"))
        {
          paramView = paramView.zGG;
          label120:
          ((TextView)localObject2).setText(paramView);
        }
        try
        {
          paramView = FilterImageView.b(FilterImageView.this).getAssets().open("filter/" + localc.icon);
          ((a)localObject1).QqI = BackwardSupportUtil.BitmapFactory.decodeStream(paramView);
          paramView.close();
          ((a)localObject1).QqH.setImageBitmap(((a)localObject1).QqI);
          paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (paramInt == this.va)
          {
            paramViewGroup.findViewById(2131300720).setBackgroundResource(2131231482);
            AppMethodBeat.o(143068);
            return paramViewGroup;
            localObject2 = (a)paramView.getTag();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            if (((a)localObject2).QqI == null) {
              continue;
            }
            Log.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { ((a)localObject2).QqI.toString() });
            ((a)localObject2).QqI.recycle();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            continue;
            if ((str.equals("zh_TW")) || (str.equals("zh_HK")))
            {
              paramView = paramView.QqK;
              break label120;
            }
            paramView = paramView.QqL;
          }
        }
        catch (IOException paramView)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.FilterView", paramView, "", new Object[0]);
            continue;
            paramViewGroup.findViewById(2131300720).setBackgroundResource(2131231483);
          }
        }
      }
    }
    
    final class a
    {
      ImageView QqH;
      Bitmap QqI;
      TextView vr;
      
      a() {}
    }
  }
  
  static final class b
  {
    String QqK;
    String QqL;
    String zGG;
    
    b(String paramString1, String paramString2, String paramString3)
    {
      this.zGG = paramString1;
      this.QqK = paramString2;
      this.QqL = paramString3;
    }
  }
  
  static final class c
  {
    FilterImageView.b QqM;
    String QqN;
    int QqO;
    int QqP;
    int QqQ;
    String icon;
    
    c(FilterImageView.b paramb, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
    {
      this.QqM = paramb;
      this.QqN = paramString1;
      this.QqO = paramInt1;
      this.QqP = paramInt2;
      this.icon = paramString2;
      this.QqQ = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.FilterImageView
 * JD-Core Version:    0.7.0.1
 */