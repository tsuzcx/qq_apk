package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.util.s;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  extends Preference
  implements r.a
{
  private TextView OXd;
  String OXe;
  private View mView;
  private f pkD;
  private ImageView rIe;
  String xOn;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51673);
    this.mView = null;
    this.OXd = null;
    this.OXe = null;
    setLayoutResource(l.g.OKz);
    r.a(this);
    AppMethodBeat.o(51673);
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
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
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.xOn)) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.rIe != null)) {
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
    this.OXd = ((TextView)paramView.findViewById(l.f.fFQ));
    this.rIe = ((ImageView)paramView.findViewById(l.f.OIv));
    if (!Util.isNullOrNil(this.OXe))
    {
      this.OXd.setText(this.OXe);
      this.OXd.setVisibility(0);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.xOn))
      {
        paramView = r.a(new s(this.xOn));
        if ((paramView != null) && (!paramView.isRecycled()))
        {
          this.rIe.setImageBitmap(paramView);
          this.rIe.setVisibility(0);
        }
      }
      AppMethodBeat.o(51675);
      return;
      this.OXd.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.a
 * JD-Core Version:    0.7.0.1
 */