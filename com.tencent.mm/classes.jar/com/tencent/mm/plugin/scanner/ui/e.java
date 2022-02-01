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
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class e
  extends Preference
  implements u.a
{
  private ImageView CJe;
  String CJf;
  private Context mContext;
  private View mView;
  f screen;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51803);
    this.mView = null;
    this.CJe = null;
    setLayoutResource(2131495965);
    u.a(this);
    this.mContext = paramContext;
    AppMethodBeat.o(51803);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
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
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.CJf)) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {
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
    this.CJe = ((ImageView)paramView.findViewById(2131304573));
    if (!Util.isNullOrNil(this.CJf))
    {
      Bitmap localBitmap = u.a(new q(this.CJf));
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label94;
      }
      this.CJe.setImageBitmap(localBitmap);
      this.CJe.setBackgroundColor(0);
    }
    for (;;)
    {
      ((ImageView)paramView.findViewById(2131304569)).setVisibility(0);
      AppMethodBeat.o(51805);
      return;
      label94:
      this.CJe.setBackgroundColor(this.mContext.getResources().getColor(2131100583));
      this.CJe.setImageBitmap(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.e
 * JD-Core Version:    0.7.0.1
 */