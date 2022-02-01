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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.base.MMHorList;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class FilterImageView
  extends LinearLayout
{
  static c[] KFk;
  int[] KFb;
  private View KFc;
  private ImageView KFd;
  CropImageView KFe;
  Bitmap KFf;
  private MMHorList KFg;
  private a KFh;
  private Runnable KFi;
  private Runnable KFj;
  private Activity dsa;
  private int zdz;
  
  static
  {
    AppMethodBeat.i(143078);
    KFk = new c[] { new c(new b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12) };
    AppMethodBeat.o(143078);
  }
  
  public FilterImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143069);
    this.zdz = 0;
    this.dsa = ((Activity)paramContext);
    paramContext = View.inflate(this.dsa, 2131493675, this);
    this.KFe = ((CropImageView)paramContext.findViewById(2131298870));
    this.KFd = ((ImageView)paramContext.findViewById(2131298879));
    this.KFc = paramContext.findViewById(2131298874);
    this.KFe.setOnTouchListener(null);
    this.KFg = ((MMHorList)paramContext.findViewById(2131298867));
    this.KFh = new a();
    this.KFg.setAdapter(this.KFh);
    this.KFg.invalidate();
    this.KFg.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(143067);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        a.b("com/tencent/mm/ui/tools/FilterImageView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = FilterImageView.a(FilterImageView.this);
        paramAnonymousAdapterView.uT = paramAnonymousInt;
        paramAnonymousAdapterView.notifyDataSetChanged();
        try
        {
          FilterImageView.a(FilterImageView.this, FilterImageView.KFk[paramAnonymousInt].KFv);
          FilterImageView.a(FilterImageView.this, FilterImageView.KFk[paramAnonymousInt].KFs, FilterImageView.KFk[paramAnonymousInt].KFt, FilterImageView.KFk[paramAnonymousInt].KFu);
          a.a(this, "com/tencent/mm/ui/tools/FilterImageView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(143067);
          return;
        }
        catch (Exception paramAnonymousAdapterView)
        {
          for (;;)
          {
            ad.e("MicroMsg.FilterView", paramAnonymousAdapterView.toString());
            ad.printErrStackTrace("MicroMsg.FilterView", paramAnonymousAdapterView, "", new Object[0]);
          }
        }
        catch (OutOfMemoryError paramAnonymousAdapterView)
        {
          for (;;)
          {
            ad.e("MicroMsg.FilterView", paramAnonymousAdapterView.toString());
            ad.printErrStackTrace("MicroMsg.FilterView", paramAnonymousAdapterView, "", new Object[0]);
          }
        }
      }
    });
    AppMethodBeat.o(143069);
  }
  
  private boolean aX(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143076);
    if (paramInt2 == 0)
    {
      this.KFf.setPixels(this.KFb, 0, this.KFf.getWidth(), 0, 0, this.KFf.getWidth(), this.KFf.getHeight());
      this.KFe.invalidate();
      AppMethodBeat.o(143076);
      return true;
    }
    int j = this.KFf.getWidth() * this.KFf.getHeight();
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
        localObject3 = this.dsa.getAssets().open("filter/".concat(String.valueOf(localObject3)));
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject4 = new byte[j];
        localObject1 = localObject3;
        localObject2 = localObject3;
        ((InputStream)localObject3).read((byte[])localObject4);
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject4 = g.cr((byte[])localObject4);
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
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject4, this.KFf.getWidth(), this.KFf.getHeight(), true);
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
    ad.e("MicroMsg.FilterView", "src.len:" + this.KFb.length);
    i = 0;
    while (i < arrayOfInt.length)
    {
      ad.e("MicroMsg.FilterView", "mask[" + i + "].len:" + arrayOfInt[i].length);
      i += 1;
    }
    ad.e("MicroMsg.FilterView", "before filter");
    ImgFilter.FilterInt(paramInt2, this.KFb, arrayOfInt, paramInt1, this.KFf.getWidth(), this.KFf.getHeight(), paramString);
    ad.e("MicroMsg.FilterView", "after filter");
    this.KFf.setPixels(paramString.value, 0, this.KFf.getWidth(), 0, 0, this.KFf.getWidth(), this.KFf.getHeight());
    this.KFe.invalidate();
    AppMethodBeat.o(143076);
    return true;
  }
  
  public final void gJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(143074);
    ad.i("MicroMsg.FilterView", "filePath before fiterBmp:".concat(String.valueOf(paramString)));
    if ((this.KFf == null) || (this.KFf.isRecycled())) {
      this.KFf = g.a(g.d(paramString, 480, 480, false), paramInt);
    }
    ad.d("MicroMsg.FilterView", "filterBmp w:" + this.KFf.getWidth() + " h:" + this.KFf.getHeight());
    this.KFb = new int[this.KFf.getWidth() * this.KFf.getHeight()];
    this.KFf.getPixels(this.KFb, 0, this.KFf.getWidth(), 0, 0, this.KFf.getWidth(), this.KFf.getHeight());
    this.KFe.setImageBitmap(this.KFf);
    AppMethodBeat.o(143074);
  }
  
  public View getCropAreaView()
  {
    return this.KFc;
  }
  
  public CropImageView getCropImageIV()
  {
    return this.KFe;
  }
  
  public Bitmap getFilterBmp()
  {
    return this.KFf;
  }
  
  public int getFilterId()
  {
    return this.zdz;
  }
  
  public void setCropMaskBackground(int paramInt)
  {
    AppMethodBeat.i(143073);
    if (this.KFd != null) {
      this.KFd.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(143073);
  }
  
  public void setCropMaskVisible(int paramInt)
  {
    AppMethodBeat.i(143072);
    if (this.KFd != null) {
      this.KFd.setVisibility(paramInt);
    }
    AppMethodBeat.o(143072);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    this.KFf = paramBitmap;
  }
  
  public void setLimitZoomIn(boolean paramBoolean)
  {
    AppMethodBeat.i(143070);
    if (this.KFe != null) {
      this.KFe.setLimitZoomIn(paramBoolean);
    }
    AppMethodBeat.o(143070);
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(143071);
    if (this.KFe != null) {
      this.KFe.setImageMatrix(paramMatrix);
    }
    AppMethodBeat.o(143071);
  }
  
  public void setOnConfirmImp(Runnable paramRunnable)
  {
    this.KFi = paramRunnable;
  }
  
  public void setOnExitImp(Runnable paramRunnable)
  {
    this.KFj = paramRunnable;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(143075);
    if (paramInt == 0)
    {
      this.KFh.notifyDataSetChanged();
      this.KFg.invalidate();
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
      return FilterImageView.KFk.length;
    }
    
    public final Object getItem(int paramInt)
    {
      return FilterImageView.KFk[paramInt];
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
        ((a)localObject1).KFm = ((ImageView)paramViewGroup.findViewById(2131299964));
        paramViewGroup.setTag(localObject1);
      }
      for (;;)
      {
        Object localObject2 = ((a)localObject1).vk;
        paramView = localc.KFr;
        String str = ac.fks();
        if (str.equals("zh_CN"))
        {
          paramView = paramView.JQQ;
          label120:
          ((TextView)localObject2).setText(paramView);
        }
        try
        {
          paramView = FilterImageView.b(FilterImageView.this).getAssets().open("filter/" + localc.dDH);
          ((a)localObject1).KFn = g.decodeStream(paramView);
          paramView.close();
          ((a)localObject1).KFm.setImageBitmap(((a)localObject1).KFn);
          paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (paramInt == this.uT)
          {
            paramViewGroup.findViewById(2131299964).setBackgroundResource(2131231418);
            AppMethodBeat.o(143068);
            return paramViewGroup;
            localObject2 = (a)paramView.getTag();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            if (((a)localObject2).KFn == null) {
              continue;
            }
            ad.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { ((a)localObject2).KFn.toString() });
            ((a)localObject2).KFn.recycle();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            continue;
            if ((str.equals("zh_TW")) || (str.equals("zh_HK")))
            {
              paramView = paramView.KFp;
              break label120;
            }
            paramView = paramView.KFq;
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
      ImageView KFm;
      Bitmap KFn;
      TextView vk;
      
      a() {}
    }
  }
  
  static final class b
  {
    String JQQ;
    String KFp;
    String KFq;
    
    b(String paramString1, String paramString2, String paramString3)
    {
      this.JQQ = paramString1;
      this.KFp = paramString2;
      this.KFq = paramString3;
    }
  }
  
  static final class c
  {
    FilterImageView.b KFr;
    String KFs;
    int KFt;
    int KFu;
    int KFv;
    String dDH;
    
    c(FilterImageView.b paramb, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
    {
      this.KFr = paramb;
      this.KFs = paramString1;
      this.KFt = paramInt1;
      this.KFu = paramInt2;
      this.dDH = paramString2;
      this.KFv = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.FilterImageView
 * JD-Core Version:    0.7.0.1
 */