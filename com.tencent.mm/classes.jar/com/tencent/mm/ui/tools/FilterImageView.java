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
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
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
  static c[] afFg;
  private int Qof;
  int[] afEX;
  private View afEY;
  private ImageView afEZ;
  CropImageView afFa;
  Bitmap afFb;
  private MMHorList afFc;
  private a afFd;
  private Runnable afFe;
  private Runnable afFf;
  private Activity hHU;
  
  static
  {
    AppMethodBeat.i(143078);
    afFg = new c[] { new c(new b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12) };
    AppMethodBeat.o(143078);
  }
  
  public FilterImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143069);
    this.Qof = 0;
    this.hHU = ((Activity)paramContext);
    paramContext = View.inflate(this.hHU, a.h.crop_image_filter, this);
    this.afFa = ((CropImageView)paramContext.findViewById(a.g.cropimage_filter_show_iv));
    this.afEZ = ((ImageView)paramContext.findViewById(a.g.cropimage_iv));
    this.afEY = paramContext.findViewById(a.g.cropimage_frame);
    this.afFa.setOnTouchListener(null);
    this.afFc = ((MMHorList)paramContext.findViewById(a.g.cropimage_filter_gallery));
    this.afFd = new a();
    this.afFc.setAdapter(this.afFd);
    this.afFc.invalidate();
    this.afFc.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(143067);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/ui/tools/FilterImageView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = FilterImageView.a(FilterImageView.this);
        paramAnonymousAdapterView.dyx = paramAnonymousInt;
        paramAnonymousAdapterView.notifyDataSetChanged();
        try
        {
          FilterImageView.a(FilterImageView.this, FilterImageView.afFg[paramAnonymousInt].afFr);
          FilterImageView.a(FilterImageView.this, FilterImageView.afFg[paramAnonymousInt].afFo, FilterImageView.afFg[paramAnonymousInt].afFp, FilterImageView.afFg[paramAnonymousInt].afFq);
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
  
  private boolean bh(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143076);
    if (paramInt2 == 0)
    {
      this.afFb.setPixels(this.afEX, 0, this.afFb.getWidth(), 0, 0, this.afFb.getWidth(), this.afFb.getHeight());
      this.afFa.invalidate();
      AppMethodBeat.o(143076);
      return true;
    }
    int j = this.afFb.getWidth() * this.afFb.getHeight();
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
        localObject3 = this.hHU.getAssets().open("filter/".concat(String.valueOf(localObject3)));
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
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject4, this.afFb.getWidth(), this.afFb.getHeight(), true);
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
    Log.e("MicroMsg.FilterView", "src.len:" + this.afEX.length);
    i = 0;
    while (i < arrayOfInt.length)
    {
      Log.e("MicroMsg.FilterView", "mask[" + i + "].len:" + arrayOfInt[i].length);
      i += 1;
    }
    Log.e("MicroMsg.FilterView", "before filter");
    ImgFilter.FilterInt(paramInt2, this.afEX, arrayOfInt, paramInt1, this.afFb.getWidth(), this.afFb.getHeight(), paramString);
    Log.e("MicroMsg.FilterView", "after filter");
    this.afFb.setPixels(paramString.value, 0, this.afFb.getWidth(), 0, 0, this.afFb.getWidth(), this.afFb.getHeight());
    this.afFa.invalidate();
    AppMethodBeat.o(143076);
    return true;
  }
  
  public View getCropAreaView()
  {
    return this.afEY;
  }
  
  public CropImageView getCropImageIV()
  {
    return this.afFa;
  }
  
  public Bitmap getFilterBmp()
  {
    return this.afFb;
  }
  
  public int getFilterId()
  {
    return this.Qof;
  }
  
  public final void jc(String paramString, int paramInt)
  {
    AppMethodBeat.i(143074);
    Log.i("MicroMsg.FilterView", "filePath before fiterBmp:".concat(String.valueOf(paramString)));
    if ((this.afFb == null) || (this.afFb.isRecycled())) {
      this.afFb = BitmapUtil.rotate(BitmapUtil.extractThumbNail(paramString, 480, 480, false), paramInt);
    }
    Log.d("MicroMsg.FilterView", "filterBmp w:" + this.afFb.getWidth() + " h:" + this.afFb.getHeight());
    this.afEX = new int[this.afFb.getWidth() * this.afFb.getHeight()];
    this.afFb.getPixels(this.afEX, 0, this.afFb.getWidth(), 0, 0, this.afFb.getWidth(), this.afFb.getHeight());
    this.afFa.setImageBitmap(this.afFb);
    AppMethodBeat.o(143074);
  }
  
  public void setCropMaskBackground(int paramInt)
  {
    AppMethodBeat.i(143073);
    if (this.afEZ != null) {
      this.afEZ.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(143073);
  }
  
  public void setCropMaskVisible(int paramInt)
  {
    AppMethodBeat.i(143072);
    if (this.afEZ != null) {
      this.afEZ.setVisibility(paramInt);
    }
    AppMethodBeat.o(143072);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    this.afFb = paramBitmap;
  }
  
  public void setLimitZoomIn(boolean paramBoolean)
  {
    AppMethodBeat.i(143070);
    if (this.afFa != null) {
      this.afFa.setLimitZoomIn(paramBoolean);
    }
    AppMethodBeat.o(143070);
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(143071);
    if (this.afFa != null) {
      this.afFa.setImageMatrix(paramMatrix);
    }
    AppMethodBeat.o(143071);
  }
  
  public void setOnConfirmImp(Runnable paramRunnable)
  {
    this.afFe = paramRunnable;
  }
  
  public void setOnExitImp(Runnable paramRunnable)
  {
    this.afFf = paramRunnable;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(143075);
    if (paramInt == 0)
    {
      this.afFd.notifyDataSetChanged();
      this.afFc.invalidate();
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(143075);
  }
  
  final class a
    extends BaseAdapter
  {
    int dyx = 0;
    
    a() {}
    
    public final int getCount()
    {
      return FilterImageView.afFg.length;
    }
    
    public final Object getItem(int paramInt)
    {
      return FilterImageView.afFg[paramInt];
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
        paramViewGroup = View.inflate(FilterImageView.b(FilterImageView.this), a.h.filter_selecter_item, null);
        localObject1 = new a();
        ((a)localObject1).dyR = ((TextView)paramViewGroup.findViewById(a.g.filter_selecter_tv));
        ((a)localObject1).afFi = ((ImageView)paramViewGroup.findViewById(a.g.filter_selecter_img));
        paramViewGroup.setTag(localObject1);
      }
      for (;;)
      {
        Object localObject2 = ((a)localObject1).dyR;
        paramView = localc.afFn;
        String str = LocaleUtil.getApplicationLanguage();
        if (str.equals("zh_CN"))
        {
          paramView = paramView.LhS;
          label123:
          ((TextView)localObject2).setText(paramView);
        }
        try
        {
          paramView = FilterImageView.b(FilterImageView.this).getAssets().open("filter/" + localc.icon);
          ((a)localObject1).afFj = BackwardSupportUtil.BitmapFactory.decodeStream(paramView);
          paramView.close();
          ((a)localObject1).afFi.setImageBitmap(((a)localObject1).afFj);
          paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (paramInt == this.dyx)
          {
            paramViewGroup.findViewById(a.g.filter_selecter_img).setBackgroundResource(a.f.camera_filter_reviewbox_checked);
            AppMethodBeat.o(143068);
            return paramViewGroup;
            localObject2 = (a)paramView.getTag();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            if (((a)localObject2).afFj == null) {
              continue;
            }
            Log.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { ((a)localObject2).afFj.toString() });
            ((a)localObject2).afFj.recycle();
            localObject1 = localObject2;
            paramViewGroup = paramView;
            continue;
            if ((str.equals("zh_TW")) || (str.equals("zh_HK")))
            {
              paramView = paramView.afFl;
              break label123;
            }
            paramView = paramView.afFm;
          }
        }
        catch (IOException paramView)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.FilterView", paramView, "", new Object[0]);
            continue;
            paramViewGroup.findViewById(a.g.filter_selecter_img).setBackgroundResource(a.f.camera_filter_reviewbox_normal);
          }
        }
      }
    }
    
    final class a
    {
      ImageView afFi;
      Bitmap afFj;
      TextView dyR;
      
      a() {}
    }
  }
  
  static final class b
  {
    String LhS;
    String afFl;
    String afFm;
    
    b(String paramString1, String paramString2, String paramString3)
    {
      this.LhS = paramString1;
      this.afFl = paramString2;
      this.afFm = paramString3;
    }
  }
  
  static final class c
  {
    FilterImageView.b afFn;
    String afFo;
    int afFp;
    int afFq;
    int afFr;
    String icon;
    
    c(FilterImageView.b paramb, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
    {
      this.afFn = paramb;
      this.afFo = paramString1;
      this.afFp = paramInt1;
      this.afFq = paramInt2;
      this.icon = paramString2;
      this.afFr = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.FilterImageView
 * JD-Core Version:    0.7.0.1
 */