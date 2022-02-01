package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class CategoryWithTitlePreference
  extends Preference
  implements u.a
{
  private Context context;
  private ImageView fWT;
  private int iconHeight;
  private String iconUrl;
  private int iconWidth;
  private f screen;
  private String title;
  private TextView titleTv;
  
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
    AppMethodBeat.i(51780);
    this.title = "";
    this.iconWidth = 34;
    this.iconHeight = 34;
    setLayoutResource(2131494810);
    this.context = paramContext;
    u.a(this);
    AppMethodBeat.o(51780);
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(51784);
    ae.d("MicroMsg.scanner.CategoryWithTitlePreference", "get pic:" + paramString + ", iconurl:" + this.iconUrl);
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals(this.iconUrl)) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.fWT != null)) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51779);
          CategoryWithTitlePreference.a(CategoryWithTitlePreference.this).setImageBitmap(paramBitmap);
          CategoryWithTitlePreference.a(CategoryWithTitlePreference.this).setVisibility(0);
          if (CategoryWithTitlePreference.b(CategoryWithTitlePreference.this) != null) {
            CategoryWithTitlePreference.b(CategoryWithTitlePreference.this).notifyDataSetChanged();
          }
          AppMethodBeat.o(51779);
        }
      });
    }
    AppMethodBeat.o(51784);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(51783);
    super.onBindView(paramView);
    this.titleTv = ((TextView)paramView.findViewById(16908310));
    this.fWT = ((ImageView)paramView.findViewById(2131300874));
    paramView = this.fWT.getLayoutParams();
    paramView.width = BackwardSupportUtil.b.h(this.context, this.iconWidth / 2);
    paramView.height = BackwardSupportUtil.b.h(this.context, this.iconHeight / 2);
    this.fWT.setLayoutParams(paramView);
    if ((this.title != null) && (this.title.length() > 0) && (this.titleTv != null))
    {
      this.titleTv.setVisibility(0);
      this.titleTv.setText(this.title);
      ae.v("MicroMsg.scanner.CategoryWithTitlePreference", "onBindView title : " + this.titleTv.getText());
    }
    if (!bu.isNullOrNil(this.iconUrl))
    {
      paramView = u.a(new n(this.iconUrl));
      if ((paramView != null) && (!paramView.isRecycled()))
      {
        this.fWT.setImageBitmap(paramView);
        this.fWT.setVisibility(0);
      }
    }
    AppMethodBeat.o(51783);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(51782);
    if (this.titleTv != null)
    {
      if (this.context != null) {
        this.title = this.context.getString(paramInt);
      }
      if (bu.isNullOrNil(this.title)) {
        break label71;
      }
      this.titleTv.setVisibility(0);
      this.titleTv.setText(this.title);
    }
    for (;;)
    {
      super.setTitle(paramInt);
      AppMethodBeat.o(51782);
      return;
      label71:
      this.titleTv.setVisibility(8);
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(51781);
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      this.title = paramCharSequence.toString();
      if (this.titleTv != null)
      {
        this.titleTv.setVisibility(0);
        this.titleTv.setText(paramCharSequence);
        ae.v("MicroMsg.scanner.CategoryWithTitlePreference", "title : " + this.titleTv.getText());
      }
    }
    for (;;)
    {
      super.setTitle(paramCharSequence);
      AppMethodBeat.o(51781);
      return;
      if (this.titleTv != null) {
        this.titleTv.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.CategoryWithTitlePreference
 * JD-Core Version:    0.7.0.1
 */