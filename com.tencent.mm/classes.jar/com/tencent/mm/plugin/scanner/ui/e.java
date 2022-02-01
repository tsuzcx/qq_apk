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
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class e
  extends Preference
  implements r.a
{
  private ImageView OXg;
  String OXh;
  private Context mContext;
  private View mView;
  f screen;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51803);
    this.mView = null;
    this.OXg = null;
    setLayoutResource(l.g.OKu);
    r.a(this);
    this.mContext = paramContext;
    AppMethodBeat.o(51803);
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51804);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(51804);
    return paramView;
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(51806);
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.OXh)) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51802);
          e.a(e.this).setImageBitmap(paramBitmap);
          e.a(e.this).setBackgroundColor(0);
          if (e.b(e.this) != null) {
            e.b(e.this).notifyDataSetChanged();
          }
          AppMethodBeat.o(51802);
        }
      });
    }
    AppMethodBeat.o(51806);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(51805);
    super.onBindView(paramView);
    this.OXg = ((ImageView)paramView.findViewById(l.f.media_thumb));
    if (!Util.isNullOrNil(this.OXh))
    {
      Bitmap localBitmap = r.a(new s(this.OXh));
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label96;
      }
      this.OXg.setImageBitmap(localBitmap);
      this.OXg.setBackgroundColor(0);
    }
    for (;;)
    {
      ((ImageView)paramView.findViewById(l.f.OIM)).setVisibility(0);
      AppMethodBeat.o(51805);
      return;
      label96:
      this.OXg.setBackgroundColor(this.mContext.getResources().getColor(l.c.OHW));
      this.OXg.setImageBitmap(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.e
 * JD-Core Version:    0.7.0.1
 */