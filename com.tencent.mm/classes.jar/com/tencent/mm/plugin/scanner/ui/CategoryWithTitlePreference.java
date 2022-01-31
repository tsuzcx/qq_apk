package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class CategoryWithTitlePreference
  extends Preference
  implements x.a
{
  private Context context;
  private f dnn;
  private TextView eXr;
  private ImageView heN;
  private int iJe = 34;
  private String iconUrl;
  private int nGy = 34;
  private String title = "";
  
  public CategoryWithTitlePreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CategoryWithTitlePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CategoryWithTitlePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(R.i.mm_preference_category_with_title);
    this.context = paramContext;
    x.a(this);
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    y.d("MicroMsg.scanner.CategoryWithTitlePreference", "get pic:" + paramString + ", iconurl:" + this.iconUrl);
    if ((!bk.bl(paramString)) && (paramString.equals(this.iconUrl)) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.heN != null)) {
      ai.d(new CategoryWithTitlePreference.1(this, paramBitmap));
    }
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.eXr = ((TextView)paramView.findViewById(16908310));
    this.heN = ((ImageView)paramView.findViewById(R.h.icon));
    paramView = this.heN.getLayoutParams();
    paramView.width = BackwardSupportUtil.b.b(this.context, this.iJe / 2);
    paramView.height = BackwardSupportUtil.b.b(this.context, this.nGy / 2);
    this.heN.setLayoutParams(paramView);
    if ((this.title != null) && (this.title.length() > 0) && (this.eXr != null))
    {
      this.eXr.setVisibility(0);
      this.eXr.setText(this.title);
      y.v("MicroMsg.scanner.CategoryWithTitlePreference", "onBindView title : " + this.eXr.getText());
    }
    if (!bk.bl(this.iconUrl))
    {
      paramView = x.a(new q(this.iconUrl));
      if ((paramView != null) && (!paramView.isRecycled()))
      {
        this.heN.setImageBitmap(paramView);
        this.heN.setVisibility(0);
      }
    }
  }
  
  public final void setTitle(int paramInt)
  {
    if (this.eXr != null)
    {
      if (this.context != null) {
        this.title = this.context.getString(paramInt);
      }
      if (bk.bl(this.title)) {
        break label61;
      }
      this.eXr.setVisibility(0);
      this.eXr.setText(this.title);
    }
    for (;;)
    {
      super.setTitle(paramInt);
      return;
      label61:
      this.eXr.setVisibility(8);
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      this.title = paramCharSequence.toString();
      if (this.eXr != null)
      {
        this.eXr.setVisibility(0);
        this.eXr.setText(paramCharSequence);
        y.v("MicroMsg.scanner.CategoryWithTitlePreference", "title : " + this.eXr.getText());
      }
    }
    for (;;)
    {
      super.setTitle(paramCharSequence);
      return;
      if (this.eXr != null) {
        this.eXr.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.CategoryWithTitlePreference
 * JD-Core Version:    0.7.0.1
 */