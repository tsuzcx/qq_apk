package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.preference.Preference;

public final class f
  extends Preference
  implements x.a
{
  com.tencent.mm.ui.base.preference.f dnn;
  String jaX;
  private Context mContext;
  private View mView = null;
  private ImageView nHY = null;
  
  public f(Context paramContext)
  {
    super(paramContext);
    setLayoutResource(R.i.product_media_preference);
    x.a(this);
    this.mContext = paramContext;
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    return this.mView;
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if ((!bk.bl(paramString)) && (paramString.equals(this.jaX)) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {
      ai.d(new f.1(this, paramBitmap));
    }
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.nHY = ((ImageView)paramView.findViewById(R.h.media_thumb));
    if (!bk.bl(this.jaX))
    {
      Bitmap localBitmap = x.a(new q(this.jaX));
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label86;
      }
      this.nHY.setImageBitmap(localBitmap);
      this.nHY.setBackgroundColor(0);
    }
    for (;;)
    {
      ((ImageView)paramView.findViewById(R.h.media_play_btn)).setVisibility(0);
      return;
      label86:
      this.nHY.setBackgroundColor(this.mContext.getResources().getColor(R.e.grid_preference_thumb_bg_color));
      this.nHY.setImageBitmap(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.f
 * JD-Core Version:    0.7.0.1
 */