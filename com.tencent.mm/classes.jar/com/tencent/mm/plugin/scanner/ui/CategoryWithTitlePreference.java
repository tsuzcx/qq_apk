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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class CategoryWithTitlePreference
  extends Preference
  implements u.a
{
  private Context context;
  private int drN;
  private int drO;
  private ImageView fBA;
  private String iconUrl;
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
    this.drN = 34;
    this.drO = 34;
    setLayoutResource(2131494810);
    this.context = paramContext;
    u.a(this);
    AppMethodBeat.o(51780);
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(51784);
    ac.d("MicroMsg.scanner.CategoryWithTitlePreference", "get pic:" + paramString + ", iconurl:" + this.iconUrl);
    if ((!bs.isNullOrNil(paramString)) && (paramString.equals(this.iconUrl)) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.fBA != null)) {
      ap.f(new Runnable()
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
    this.fBA = ((ImageView)paramView.findViewById(2131300874));
    paramView = this.fBA.getLayoutParams();
    paramView.width = BackwardSupportUtil.b.g(this.context, this.drN / 2);
    paramView.height = BackwardSupportUtil.b.g(this.context, this.drO / 2);
    this.fBA.setLayoutParams(paramView);
    if ((this.title != null) && (this.title.length() > 0) && (this.titleTv != null))
    {
      this.titleTv.setVisibility(0);
      this.titleTv.setText(this.title);
      ac.v("MicroMsg.scanner.CategoryWithTitlePreference", "onBindView title : " + this.titleTv.getText());
    }
    if (!bs.isNullOrNil(this.iconUrl))
    {
      paramView = u.a(new n(this.iconUrl));
      if ((paramView != null) && (!paramView.isRecycled()))
      {
        this.fBA.setImageBitmap(paramView);
        this.fBA.setVisibility(0);
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
      if (bs.isNullOrNil(this.title)) {
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
        ac.v("MicroMsg.scanner.CategoryWithTitlePreference", "title : " + this.titleTv.getText());
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