package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class b
  extends Preference
  implements u.a
{
  private ImageView CJe;
  String CJf;
  private Context mContext;
  private View mView;
  f screen;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51677);
    this.mView = null;
    this.CJe = null;
    setLayoutResource(2131495951);
    u.a(this);
    this.mContext = paramContext;
    AppMethodBeat.o(51677);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51678);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(51678);
    return paramView;
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(51680);
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.CJf)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.CJe.setImageBitmap(paramBitmap);
      this.CJe.setBackgroundColor(0);
      if (this.screen != null) {
        this.screen.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(51680);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(51679);
    super.onBindView(paramView);
    this.CJe = ((ImageView)paramView.findViewById(2131297329));
    if (!Util.isNullOrNil(this.CJf))
    {
      paramView = u.a(new q(this.CJf));
      if ((paramView != null) && (!paramView.isRecycled()))
      {
        this.CJe.setImageBitmap(paramView);
        this.CJe.setBackgroundColor(0);
        AppMethodBeat.o(51679);
        return;
      }
      this.CJe.setBackgroundColor(this.mContext.getResources().getColor(2131100583));
      this.CJe.setImageBitmap(null);
    }
    AppMethodBeat.o(51679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.b
 * JD-Core Version:    0.7.0.1
 */