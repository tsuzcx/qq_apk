package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.view.n;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R.e;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ProductFurtherInfoUI$a
  extends n
  implements x.a
{
  private Context mContext;
  List<String> nJS = new ArrayList();
  private Map<String, ImageView> nJT = new HashMap();
  private int nJU;
  
  public ProductFurtherInfoUI$a(ProductFurtherInfoUI paramProductFurtherInfoUI, Context paramContext)
  {
    this.mContext = paramContext;
    x.a(this);
    this.nJU = this.mContext.getResources().getColor(R.e.hint_text_color_dark_bg);
  }
  
  private ImageView LZ(String paramString)
  {
    if (this.nJT.containsKey(paramString)) {
      return (ImageView)this.nJT.get(paramString);
    }
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.nJT.put(paramString, localImageView);
    return localImageView;
  }
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((ImageView)paramObject);
    paramViewGroup = (String)this.nJS.get(paramInt);
    if (this.nJT.containsKey(paramViewGroup)) {
      this.nJT.remove(paramViewGroup);
    }
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final Object b(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = (String)this.nJS.get(paramInt);
    ImageView localImageView = LZ((String)localObject);
    localObject = x.a(new q((String)localObject));
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      localImageView.setImageBitmap((Bitmap)localObject);
      localImageView.setBackgroundColor(0);
    }
    for (;;)
    {
      try
      {
        paramViewGroup.addView(localImageView);
        return localImageView;
      }
      catch (Exception paramViewGroup)
      {
        y.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + paramViewGroup.getMessage());
      }
      localImageView.setImageBitmap(null);
      localImageView.setBackgroundColor(this.nJU);
    }
    return localImageView;
  }
  
  public final int getCount()
  {
    return this.nJS.size();
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!bk.bl(paramString)))
    {
      paramString = LZ(paramString);
      if (paramString != null) {
        ai.d(new ProductFurtherInfoUI.a.1(this, paramString, paramBitmap));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.a
 * JD-Core Version:    0.7.0.1
 */