package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ProductFurtherInfoUI$a
  extends q
  implements u.a
{
  private Context mContext;
  List<String> yHb;
  private Map<String, ImageView> yHc;
  private int yHd;
  
  public ProductFurtherInfoUI$a(ProductFurtherInfoUI paramProductFurtherInfoUI, Context paramContext)
  {
    AppMethodBeat.i(51821);
    this.yHb = new ArrayList();
    this.yHc = new HashMap();
    this.mContext = paramContext;
    u.a(this);
    this.yHd = this.mContext.getResources().getColor(2131100491);
    AppMethodBeat.o(51821);
  }
  
  private ImageView ayd(String paramString)
  {
    AppMethodBeat.i(51822);
    if (this.yHc.containsKey(paramString))
    {
      paramString = (ImageView)this.yHc.get(paramString);
      AppMethodBeat.o(51822);
      return paramString;
    }
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.yHc.put(paramString, localImageView);
    AppMethodBeat.o(51822);
    return localImageView;
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(51824);
    paramViewGroup.removeView((ImageView)paramObject);
    paramViewGroup = (String)this.yHb.get(paramInt);
    if (this.yHc.containsKey(paramViewGroup)) {
      this.yHc.remove(paramViewGroup);
    }
    AppMethodBeat.o(51824);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(51825);
    int i = this.yHb.size();
    AppMethodBeat.o(51825);
    return i;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(51823);
    Object localObject = (String)this.yHb.get(paramInt);
    ImageView localImageView = ayd((String)localObject);
    localObject = u.a(new n((String)localObject));
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      localImageView.setImageBitmap((Bitmap)localObject);
      localImageView.setBackgroundColor(0);
    }
    try
    {
      for (;;)
      {
        paramViewGroup.addView(localImageView);
        AppMethodBeat.o(51823);
        return localImageView;
        localImageView.setImageBitmap(null);
        localImageView.setBackgroundColor(this.yHd);
      }
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        ae.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + paramViewGroup.getMessage());
      }
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final void k(final String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(51826);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!bu.isNullOrNil(paramString)))
    {
      paramString = ayd(paramString);
      if (paramString != null) {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(51820);
            paramString.setImageBitmap(paramBitmap);
            paramString.setBackgroundColor(0);
            AppMethodBeat.o(51820);
          }
        });
      }
    }
    AppMethodBeat.o(51826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.a
 * JD-Core Version:    0.7.0.1
 */