package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.a.a.a;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class h$b
  extends BaseAdapter
  implements x.a
{
  private LayoutInflater Lu = null;
  Map<String, WeakReference<ImageView>> nJT = new HashMap();
  private int nJW;
  List<a.a> nJX = new ArrayList();
  
  public h$b(h paramh)
  {
    this.Lu = LayoutInflater.from(h.a(paramh));
    x.a(this);
    this.nJW = h.a(paramh).getResources().getColor(R.e.grid_preference_thumb_bg_color);
  }
  
  public final int getCount()
  {
    return this.nJX.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.nJX.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final a.a locala;
    Object localObject;
    if (paramView == null)
    {
      paramView = this.Lu.inflate(R.i.product_grid_preference_item, paramViewGroup, false);
      paramViewGroup = new h.b.a(this);
      paramViewGroup.nHY = ((ImageView)paramView.findViewById(R.h.grid_preference_thumb));
      paramViewGroup.iIV = ((TextView)paramView.findViewById(R.h.grid_preference_desc));
      paramView.setTag(paramViewGroup);
      locala = (a.a)this.nJX.get(paramInt);
      localObject = x.a(new h.a(locala.iconUrl));
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label210;
      }
      paramViewGroup.nHY.setImageBitmap((Bitmap)localObject);
      paramViewGroup.nHY.setBackgroundColor(0);
    }
    for (;;)
    {
      localObject = locala.nGH;
      paramViewGroup.nHY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new i(this.iXv, locala.nGG, locala.type, this.iXv, h.b.this.getCount(), locala.showType);
          au.Dk().a(paramAnonymousView, 0);
          if (!bk.bl(this.iXv))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_Product_ID", this.iXv);
            d.b(h.b.this.nJY.mContext, "scanner", ".ui.ProductUI", paramAnonymousView);
          }
        }
      });
      paramViewGroup.nHY.setTag(locala.iconUrl);
      this.nJT.put(locala.iconUrl, new WeakReference(paramViewGroup.nHY));
      paramViewGroup.iIV.setText(locala.name);
      return paramView;
      paramViewGroup = (h.b.a)paramView.getTag();
      break;
      label210:
      paramViewGroup.nHY.setBackgroundColor(this.nJW);
      paramViewGroup.nHY.setImageBitmap(null);
    }
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!bk.bl(paramString)))
    {
      y.v("MicroMsg.ProductGridPreference", "On get pic, notifyKey=" + paramString);
      if ((WeakReference)this.nJT.get(paramString) != null)
      {
        ImageView localImageView = (ImageView)((WeakReference)this.nJT.get(paramString)).get();
        if ((localImageView != null) && (paramString.equals((String)localImageView.getTag()))) {
          ai.d(new h.b.2(this, localImageView, paramBitmap));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.h.b
 * JD-Core Version:    0.7.0.1
 */