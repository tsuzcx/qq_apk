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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.MMHorList;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class FilterImageView
  extends LinearLayout
{
  static c[] IOf;
  int[] INW;
  private View INX;
  private ImageView INY;
  CropImageView INZ;
  Bitmap IOa;
  private MMHorList IOb;
  private a IOc;
  private Runnable IOd;
  private Runnable IOe;
  private Activity dgE;
  private int xNF;
  
  static
  {
    AppMethodBeat.i(143078);
    IOf = new c[] { new c(new b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12) };
    AppMethodBeat.o(143078);
  }
  
  public FilterImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143069);
    this.xNF = 0;
    this.dgE = ((Activity)paramContext);
    paramContext = View.inflate(this.dgE, 2131493675, this);
    this.INZ = ((CropImageView)paramContext.findViewById(2131298870));
    this.INY = ((ImageView)paramContext.findViewById(2131298879));
    this.INX = paramContext.findViewById(2131298874);
    this.INZ.setOnTouchListener(null);
    this.IOb = ((MMHorList)paramContext.findViewById(2131298867));
    this.IOc = new a();
    this.IOb.setAdapter(this.IOc);
    this.IOb.invalidate();
    this.IOb.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(143067);
        paramAnonymousAdapterView = FilterImageView.a(FilterImageView.this);
        paramAnonymousAdapterView.ta = paramAnonymousInt;
        paramAnonymousAdapterView.notifyDataSetChanged();
        try
        {
          FilterImageView.a(FilterImageView.this, FilterImageView.IOf[paramAnonymousInt].IOq);
          FilterImageView.a(FilterImageView.this, FilterImageView.IOf[paramAnonymousInt].IOn, FilterImageView.IOf[paramAnonymousInt].IOo, FilterImageView.IOf[paramAnonymousInt].IOp);
          AppMethodBeat.o(143067);
          return;
        }
        catch (Exception paramAnonymousAdapterView)
        {
          ac.e("MicroMsg.FilterView", paramAnonymousAdapterView.toString());
          ac.printErrStackTrace("MicroMsg.FilterView", paramAnonymousAdapterView, "", new Object[0]);
          AppMethodBeat.o(143067);
          return;
        }
        catch (OutOfMemoryError paramAnonymousAdapterView)
        {
          ac.e("MicroMsg.FilterView", paramAnonymousAdapterView.toString());
          ac.printErrStackTrace("MicroMsg.FilterView", paramAnonymousAdapterView, "", new Object[0]);
          AppMethodBeat.o(143067);
        }
      }
    });
    AppMethodBeat.o(143069);
  }
  
  private boolean aT(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143076);
    if (paramInt2 == 0)
    {
      this.IOa.setPixels(this.INW, 0, this.IOa.getWidth(), 0, 0, this.IOa.getWidth(), this.IOa.getHeight());
      this.INZ.invalidate();
      AppMethodBeat.o(143076);
      return true;
    }
    int j = this.IOa.getWidth() * this.IOa.getHeight();
    ac.d("MicroMsg.FilterView", "len:" + j + "  maskCount:" + paramInt1);
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
        localObject3 = this.dgE.getAssets().open("filter/".concat(String.valueOf(localObject3)));
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject4 = new byte[j];
        localObject1 = localObject3;
        localObject2 = localObject3;
        ((InputStream)localObject3).read((byte[])localObject4);
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject4 = f.ck((byte[])localObject4);
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
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject4, this.IOa.getWidth(), this.IOa.getHeight(), true);
      if (localObject4 != localObject1)
      {
        ac.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { localObject4.toString() });
        ((Bitmap)localObject4).recycle();
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(143076);
        return false;
      }
      ((Bitmap)localObject1).getPixels(arrayOfInt[i], 0, ((Bitmap)localObject1).getWidth(), 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      ac.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { localObject1.toString() });
      ((Bitmap)localObject1).recycle();
      i += 1;
    }
    paramString = new PIntArray();
    ac.e("MicroMsg.FilterView", "src.len:" + this.INW.length);
    i = 0;
    while (i < arrayOfInt.length)
    {
      ac.e("MicroMsg.FilterView", "mask[" + i + "].len:" + arrayOfInt[i].length);
      i += 1;
    }
    ac.e("MicroMsg.FilterView", "before filter");
    ImgFilter.FilterInt(paramInt2, this.INW, arrayOfInt, paramInt1, this.IOa.getWidth(), this.IOa.getHeight(), paramString);
    ac.e("MicroMsg.FilterView", "after filter");
    this.IOa.setPixels(paramString.value, 0, this.IOa.getWidth(), 0, 0, this.IOa.getWidth(), this.IOa.getHeight());
    this.INZ.invalidate();
    AppMethodBeat.o(143076);
    return true;
  }
  
  public View getCropAreaView()
  {
    return this.INX;
  }
  
  public CropImageView getCropImageIV()
  {
    return this.INZ;
  }
  
  public Bitmap getFilterBmp()
  {
    return this.IOa;
  }
  
  public int getFilterId()
  {
    return this.xNF;
  }
  
  public final void gm(String paramString, int paramInt)
  {
    AppMethodBeat.i(143074);
    ac.i("MicroMsg.FilterView", "filePath before fiterBmp:".concat(String.valueOf(paramString)));
    if ((this.IOa == null) || (this.IOa.isRecycled())) {
      this.IOa = f.a(f.e(paramString, 480, 480, false), paramInt);
    }
    ac.d("MicroMsg.FilterView", "filterBmp w:" + this.IOa.getWidth() + " h:" + this.IOa.getHeight());
    this.INW = new int[this.IOa.getWidth() * this.IOa.getHeight()];
    this.IOa.getPixels(this.INW, 0, this.IOa.getWidth(), 0, 0, this.IOa.getWidth(), this.IOa.getHeight());
    this.INZ.setImageBitmap(this.IOa);
    AppMethodBeat.o(143074);
  }
  
  public void setCropMaskBackground(int paramInt)
  {
    AppMethodBeat.i(143073);
    if (this.INY != null) {
      this.INY.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(143073);
  }
  
  public void setCropMaskVisible(int paramInt)
  {
    AppMethodBeat.i(143072);
    if (this.INY != null) {
      this.INY.setVisibility(paramInt);
    }
    AppMethodBeat.o(143072);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    this.IOa = paramBitmap;
  }
  
  public void setLimitZoomIn(boolean paramBoolean)
  {
    AppMethodBeat.i(143070);
    if (this.INZ != null) {
      this.INZ.setLimitZoomIn(paramBoolean);
    }
    AppMethodBeat.o(143070);
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(143071);
    if (this.INZ != null) {
      this.INZ.setImageMatrix(paramMatrix);
    }
    AppMethodBeat.o(143071);
  }
  
  public void setOnConfirmImp(Runnable paramRunnable)
  {
    this.IOd = paramRunnable;
  }
  
  public void setOnExitImp(Runnable paramRunnable)
  {
    this.IOe = paramRunnable;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(143075);
    if (paramInt == 0)
    {
      this.IOc.notifyDataSetChanged();
      this.IOb.invalidate();
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(143075);
  }
  
  final class a
    extends BaseAdapter
  {
    int ta = 0;
    
    a() {}
    
    public final int getCount()
    {
      return FilterImageView.IOf.length;
    }
    
    public final Object getItem(int paramInt)
    {
      return FilterImageView.IOf[paramInt];
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
        ((a)localObject1).tr = ((TextView)paramViewGroup.findViewById(2131299965));
        ((a)localObject1).IOh = ((ImageView)paramViewGroup.findViewById(2131299964));
        paramViewGroup.setTag(localObject1);
      }
      for (;;)
      {
        Object localObject2 = ((a)localObject1).tr;
        paramView = localc.IOm;
        String str = ab.eUO();
        if (str.equals("zh_CN"))
        {
          paramView = paramView.Iby;
          label120:
          ((TextView)localObject2).setText(paramView);
        }
        try
        {
          paramView = FilterImageView.b(FilterImageView.this).getAssets().open("filter/" + localc.drM);
          ((a)localObject1).IOi = f.decodeStream(paramView);
          paramView.close();
          ((a)localObject1).IOh.setImageBitmap(((a)localObject1).IOi);
          paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (paramInt == this.ta)
          {
            paramViewGroup.findViewById(2131299964).setBackgroundResource(2131231418);
            AppMethodBeat.o(143068);
            return paramViewGroup;
            localObject2 = (a)paramView.getTag();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            if (((a)localObject2).IOi == null) {
              continue;
            }
            ac.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { ((a)localObject2).IOi.toString() });
            ((a)localObject2).IOi.recycle();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            continue;
            if ((str.equals("zh_TW")) || (str.equals("zh_HK")))
            {
              paramView = paramView.IOk;
              break label120;
            }
            paramView = paramView.IOl;
          }
        }
        catch (IOException paramView)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.FilterView", paramView, "", new Object[0]);
            continue;
            paramViewGroup.findViewById(2131299964).setBackgroundResource(2131231419);
          }
        }
      }
    }
    
    final class a
    {
      ImageView IOh;
      Bitmap IOi;
      TextView tr;
      
      a() {}
    }
  }
  
  static final class b
  {
    String IOk;
    String IOl;
    String Iby;
    
    b(String paramString1, String paramString2, String paramString3)
    {
      this.Iby = paramString1;
      this.IOk = paramString2;
      this.IOl = paramString3;
    }
  }
  
  static final class c
  {
    FilterImageView.b IOm;
    String IOn;
    int IOo;
    int IOp;
    int IOq;
    String drM;
    
    c(FilterImageView.b paramb, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
    {
      this.IOm = paramb;
      this.IOn = paramString1;
      this.IOo = paramInt1;
      this.IOp = paramInt2;
      this.drM = paramString2;
      this.IOq = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.FilterImageView
 * JD-Core Version:    0.7.0.1
 */