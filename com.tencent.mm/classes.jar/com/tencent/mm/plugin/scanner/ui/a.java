package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  extends Preference
  implements x.a
{
  private f hcp;
  private ImageView hok;
  String iZG;
  private View mView = null;
  private TextView nHV = null;
  String nHW = null;
  
  public a(Context paramContext)
  {
    super(paramContext);
    setLayoutResource(R.i.scan_product_preference);
    x.a(this);
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
    if ((!bk.bl(paramString)) && (paramString.equals(this.iZG)) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.hok != null)) {
      ai.d(new a.1(this, paramBitmap));
    }
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.nHV = ((TextView)paramView.findViewById(R.h.digest));
    this.hok = ((ImageView)paramView.findViewById(R.h.actiontext_icon));
    if (!bk.bl(this.nHW))
    {
      this.nHV.setText(this.nHW);
      this.nHV.setVisibility(0);
    }
    for (;;)
    {
      if (!bk.bl(this.iZG))
      {
        paramView = x.a(new q(this.iZG));
        if ((paramView != null) && (!paramView.isRecycled()))
        {
          this.hok.setImageBitmap(paramView);
          this.hok.setVisibility(0);
        }
      }
      return;
      this.nHV.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.a
 * JD-Core Version:    0.7.0.1
 */