package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  extends Preference
  implements u.a
{
  private TextView IOB;
  String IOC;
  private View mView;
  private f mrf;
  private ImageView oFa;
  String uFL;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51673);
    this.mView = null;
    this.IOB = null;
    this.IOC = null;
    setLayoutResource(l.g.IEw);
    u.a(this);
    AppMethodBeat.o(51673);
  }
  
  public final View c(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51674);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(51674);
    return paramView;
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(51676);
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.uFL)) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.oFa != null)) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51672);
          a.a(a.this).setImageBitmap(paramBitmap);
          a.a(a.this).setVisibility(0);
          if (a.b(a.this) != null) {
            a.b(a.this).notifyDataSetChanged();
          }
          AppMethodBeat.o(51672);
        }
      });
    }
    AppMethodBeat.o(51676);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(51675);
    super.onBindView(paramView);
    this.IOB = ((TextView)paramView.findViewById(l.f.dEM));
    this.oFa = ((ImageView)paramView.findViewById(l.f.ICu));
    if (!Util.isNullOrNil(this.IOC))
    {
      this.IOB.setText(this.IOC);
      this.IOB.setVisibility(0);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.uFL))
      {
        paramView = u.a(new q(this.uFL));
        if ((paramView != null) && (!paramView.isRecycled()))
        {
          this.oFa.setImageBitmap(paramView);
          this.oFa.setVisibility(0);
        }
      }
      AppMethodBeat.o(51675);
      return;
      this.IOB.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.a
 * JD-Core Version:    0.7.0.1
 */