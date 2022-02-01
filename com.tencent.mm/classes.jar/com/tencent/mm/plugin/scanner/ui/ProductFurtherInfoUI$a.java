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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ProductFurtherInfoUI$a
  extends q
  implements u.a
{
  private Context mContext;
  List<String> vSo;
  private Map<String, ImageView> vSp;
  private int vSq;
  
  public ProductFurtherInfoUI$a(ProductFurtherInfoUI paramProductFurtherInfoUI, Context paramContext)
  {
    AppMethodBeat.i(51821);
    this.vSo = new ArrayList();
    this.vSp = new HashMap();
    this.mContext = paramContext;
    u.a(this);
    this.vSq = this.mContext.getResources().getColor(2131100491);
    AppMethodBeat.o(51821);
  }
  
  private ImageView amE(String paramString)
  {
    AppMethodBeat.i(51822);
    if (this.vSp.containsKey(paramString))
    {
      paramString = (ImageView)this.vSp.get(paramString);
      AppMethodBeat.o(51822);
      return paramString;
    }
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.vSp.put(paramString, localImageView);
    AppMethodBeat.o(51822);
    return localImageView;
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(51824);
    paramViewGroup.removeView((ImageView)paramObject);
    paramViewGroup = (String)this.vSo.get(paramInt);
    if (this.vSp.containsKey(paramViewGroup)) {
      this.vSp.remove(paramViewGroup);
    }
    AppMethodBeat.o(51824);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(51825);
    int i = this.vSo.size();
    AppMethodBeat.o(51825);
    return i;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(51823);
    Object localObject = (String)this.vSo.get(paramInt);
    ImageView localImageView = amE((String)localObject);
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
        localImageView.setBackgroundColor(this.vSq);
      }
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        ad.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + paramViewGroup.getMessage());
      }
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final void l(final String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(51826);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!bt.isNullOrNil(paramString)))
    {
      paramString = amE(paramString);
      if (paramString != null) {
        aq.f(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.a
 * JD-Core Version:    0.7.0.1
 */