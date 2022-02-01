package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.viewpager.widget.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.l.c;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ProductFurtherInfoUI$a
  extends a
  implements u.a
{
  List<String> IQq;
  private Map<String, ImageView> IQr;
  private int IQs;
  private Context mContext;
  
  public ProductFurtherInfoUI$a(ProductFurtherInfoUI paramProductFurtherInfoUI, Context paramContext)
  {
    AppMethodBeat.i(51821);
    this.IQq = new ArrayList();
    this.IQr = new HashMap();
    this.mContext = paramContext;
    u.a(this);
    this.IQs = this.mContext.getResources().getColor(l.c.hint_text_color_dark_bg);
    AppMethodBeat.o(51821);
  }
  
  private ImageView aXp(String paramString)
  {
    AppMethodBeat.i(51822);
    if (this.IQr.containsKey(paramString))
    {
      paramString = (ImageView)this.IQr.get(paramString);
      AppMethodBeat.o(51822);
      return paramString;
    }
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.IQr.put(paramString, localImageView);
    AppMethodBeat.o(51822);
    return localImageView;
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(51824);
    paramViewGroup.removeView((ImageView)paramObject);
    paramViewGroup = (String)this.IQq.get(paramInt);
    if (this.IQr.containsKey(paramViewGroup)) {
      this.IQr.remove(paramViewGroup);
    }
    AppMethodBeat.o(51824);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(51825);
    int i = this.IQq.size();
    AppMethodBeat.o(51825);
    return i;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(51823);
    Object localObject = (String)this.IQq.get(paramInt);
    ImageView localImageView = aXp((String)localObject);
    localObject = u.a(new q((String)localObject));
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
        localImageView.setBackgroundColor(this.IQs);
      }
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        Log.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + paramViewGroup.getMessage());
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
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!Util.isNullOrNil(paramString)))
    {
      paramString = aXp(paramString);
      if (paramString != null) {
        MMHandlerThread.postToMainThread(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.a
 * JD-Core Version:    0.7.0.1
 */