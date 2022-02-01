package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.scanner.l.c;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.util.s;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class b
  extends Preference
  implements r.a
{
  private ImageView OXg;
  String OXh;
  private Context mContext;
  private View mView;
  f screen;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51677);
    this.mView = null;
    this.OXg = null;
    setLayoutResource(l.g.OKl);
    r.a(this);
    this.mContext = paramContext;
    AppMethodBeat.o(51677);
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
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
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.OXh)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.OXg.setImageBitmap(paramBitmap);
      this.OXg.setBackgroundColor(0);
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
    this.OXg = ((ImageView)paramView.findViewById(l.f.OIx));
    if (!Util.isNullOrNil(this.OXh))
    {
      paramView = r.a(new s(this.OXh));
      if ((paramView != null) && (!paramView.isRecycled()))
      {
        this.OXg.setImageBitmap(paramView);
        this.OXg.setBackgroundColor(0);
        AppMethodBeat.o(51679);
        return;
      }
      this.OXg.setBackgroundColor(this.mContext.getResources().getColor(l.c.OHW));
      this.OXg.setImageBitmap(null);
    }
    AppMethodBeat.o(51679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.b
 * JD-Core Version:    0.7.0.1
 */