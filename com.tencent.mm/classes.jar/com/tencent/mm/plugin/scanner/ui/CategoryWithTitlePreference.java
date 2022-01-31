package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.util.s;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class CategoryWithTitlePreference
  extends Preference
  implements x.a
{
  private int cDA;
  private int cDB;
  private Context context;
  private ImageView iQd;
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
    AppMethodBeat.i(81001);
    this.title = "";
    this.cDA = 34;
    this.cDB = 34;
    setLayoutResource(2130970185);
    this.context = paramContext;
    x.a(this);
    AppMethodBeat.o(81001);
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(81005);
    ab.d("MicroMsg.scanner.CategoryWithTitlePreference", "get pic:" + paramString + ", iconurl:" + this.iconUrl);
    if ((!bo.isNullOrNil(paramString)) && (paramString.equals(this.iconUrl)) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.iQd != null)) {
      al.d(new CategoryWithTitlePreference.1(this, paramBitmap));
    }
    AppMethodBeat.o(81005);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(81004);
    super.onBindView(paramView);
    this.titleTv = ((TextView)paramView.findViewById(16908310));
    this.iQd = ((ImageView)paramView.findViewById(2131820929));
    paramView = this.iQd.getLayoutParams();
    paramView.width = BackwardSupportUtil.b.b(this.context, this.cDA / 2);
    paramView.height = BackwardSupportUtil.b.b(this.context, this.cDB / 2);
    this.iQd.setLayoutParams(paramView);
    if ((this.title != null) && (this.title.length() > 0) && (this.titleTv != null))
    {
      this.titleTv.setVisibility(0);
      this.titleTv.setText(this.title);
      ab.v("MicroMsg.scanner.CategoryWithTitlePreference", "onBindView title : " + this.titleTv.getText());
    }
    if (!bo.isNullOrNil(this.iconUrl))
    {
      paramView = x.a(new s(this.iconUrl));
      if ((paramView != null) && (!paramView.isRecycled()))
      {
        this.iQd.setImageBitmap(paramView);
        this.iQd.setVisibility(0);
      }
    }
    AppMethodBeat.o(81004);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(81003);
    if (this.titleTv != null)
    {
      if (this.context != null) {
        this.title = this.context.getString(paramInt);
      }
      if (bo.isNullOrNil(this.title)) {
        break label71;
      }
      this.titleTv.setVisibility(0);
      this.titleTv.setText(this.title);
    }
    for (;;)
    {
      super.setTitle(paramInt);
      AppMethodBeat.o(81003);
      return;
      label71:
      this.titleTv.setVisibility(8);
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(81002);
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      this.title = paramCharSequence.toString();
      if (this.titleTv != null)
      {
        this.titleTv.setVisibility(0);
        this.titleTv.setText(paramCharSequence);
        ab.v("MicroMsg.scanner.CategoryWithTitlePreference", "title : " + this.titleTv.getText());
      }
    }
    for (;;)
    {
      super.setTitle(paramCharSequence);
      AppMethodBeat.o(81002);
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