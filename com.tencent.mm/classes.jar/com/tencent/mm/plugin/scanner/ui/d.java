package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.cb.a;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;

public final class d
  extends Preference
  implements x.a
{
  private f dnn;
  private TextView haW = null;
  private ImageView iIS = null;
  String kPW;
  private View mView = null;
  private TextView nJn = null;
  String nJo;
  String nzW;
  
  public d(Context paramContext)
  {
    super(paramContext);
    setLayoutResource(R.i.product_comment_preference);
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
    if ((!bk.bl(paramString)) && (paramString.equals(this.nJo)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.iIS.setImageBitmap(paramBitmap);
      this.iIS.setBackgroundColor(0);
      if (this.dnn != null) {
        this.dnn.notifyDataSetChanged();
      }
    }
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.iIS = ((ImageView)paramView.findViewById(R.h.comment_avatar));
    this.haW = ((TextView)paramView.findViewById(R.h.comment_nickname));
    this.nJn = ((TextView)paramView.findViewById(R.h.comment_content));
    Object localObject;
    if (!bk.bl(this.nJo))
    {
      localObject = x.a(new q(this.nJo));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.iIS.setImageBitmap((Bitmap)localObject);
        this.iIS.setBackgroundColor(0);
        if (bk.bl(this.nzW)) {
          break label284;
        }
        this.haW.setText(j.a(this.mContext, this.nzW, this.haW.getTextSize()));
        label134:
        if (bk.bl(this.kPW)) {
          break label296;
        }
        this.nJn.setText(this.kPW);
      }
    }
    for (;;)
    {
      for (;;)
      {
        if ((bk.bl(this.nzW)) && (bk.bl(this.nJo)))
        {
          paramView = (LinearLayout)paramView.findViewById(R.h.comment_container);
          localObject = paramView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = this.mContext.getResources().getDimensionPixelSize(R.f.product_common_pref_height);
          paramView.setPadding(BackwardSupportUtil.b.b(this.mContext, 9.0F), 0, 0, 0);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        return;
        try
        {
          localObject = BackwardSupportUtil.b.a(ae.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
          this.iIS.setImageBitmap((Bitmap)localObject);
        }
        catch (IOException localIOException)
        {
          this.iIS.setImageBitmap(null);
        }
      }
      break;
      this.iIS.setVisibility(8);
      break;
      label284:
      this.haW.setVisibility(8);
      break label134;
      label296:
      this.nJn.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.d
 * JD-Core Version:    0.7.0.1
 */