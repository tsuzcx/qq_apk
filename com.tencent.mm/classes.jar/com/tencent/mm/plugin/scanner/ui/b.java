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
import com.tencent.mm.plugin.scanner.l.c;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class b
  extends Preference
  implements u.a
{
  private ImageView IOE;
  String IOF;
  private Context mContext;
  private View mView;
  f screen;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51677);
    this.mView = null;
    this.IOE = null;
    setLayoutResource(l.g.IEi);
    u.a(this);
    this.mContext = paramContext;
    AppMethodBeat.o(51677);
  }
  
  public final View c(View paramView, ViewGroup paramViewGroup)
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
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.IOF)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.IOE.setImageBitmap(paramBitmap);
      this.IOE.setBackgroundColor(0);
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
    this.IOE = ((ImageView)paramView.findViewById(l.f.ICw));
    if (!Util.isNullOrNil(this.IOF))
    {
      paramView = u.a(new q(this.IOF));
      if ((paramView != null) && (!paramView.isRecycled()))
      {
        this.IOE.setImageBitmap(paramView);
        this.IOE.setBackgroundColor(0);
        AppMethodBeat.o(51679);
        return;
      }
      this.IOE.setBackgroundColor(this.mContext.getResources().getColor(l.c.IBU));
      this.IOE.setImageBitmap(null);
    }
    AppMethodBeat.o(51679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.b
 * JD-Core Version:    0.7.0.1
 */