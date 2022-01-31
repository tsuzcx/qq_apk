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
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.util.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ProductFurtherInfoUI$a
  extends q
  implements x.a
{
  private Context mContext;
  List<String> qxu;
  private Map<String, ImageView> qxv;
  private int qxw;
  
  public ProductFurtherInfoUI$a(ProductFurtherInfoUI paramProductFurtherInfoUI, Context paramContext)
  {
    AppMethodBeat.i(81049);
    this.qxu = new ArrayList();
    this.qxv = new HashMap();
    this.mContext = paramContext;
    x.a(this);
    this.qxw = this.mContext.getResources().getColor(2131690169);
    AppMethodBeat.o(81049);
  }
  
  private ImageView YB(String paramString)
  {
    AppMethodBeat.i(81051);
    if (this.qxv.containsKey(paramString))
    {
      paramString = (ImageView)this.qxv.get(paramString);
      AppMethodBeat.o(81051);
      return paramString;
    }
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.qxv.put(paramString, localImageView);
    AppMethodBeat.o(81051);
    return localImageView;
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(81053);
    paramViewGroup.removeView((ImageView)paramObject);
    paramViewGroup = (String)this.qxu.get(paramInt);
    if (this.qxv.containsKey(paramViewGroup)) {
      this.qxv.remove(paramViewGroup);
    }
    AppMethodBeat.o(81053);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(81054);
    int i = this.qxu.size();
    AppMethodBeat.o(81054);
    return i;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(81052);
    Object localObject = (String)this.qxu.get(paramInt);
    ImageView localImageView = YB((String)localObject);
    localObject = x.a(new s((String)localObject));
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
        AppMethodBeat.o(81052);
        return localImageView;
        localImageView.setImageBitmap(null);
        localImageView.setBackgroundColor(this.qxw);
      }
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        ab.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + paramViewGroup.getMessage());
      }
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(81055);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!bo.isNullOrNil(paramString)))
    {
      paramString = YB(paramString);
      if (paramString != null) {
        al.d(new ProductFurtherInfoUI.a.1(this, paramString, paramBitmap));
      }
    }
    AppMethodBeat.o(81055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.a
 * JD-Core Version:    0.7.0.1
 */