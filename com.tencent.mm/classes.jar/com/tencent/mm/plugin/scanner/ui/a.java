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
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  extends Preference
  implements u.a
{
  private TextView CJb;
  String CJc;
  private ImageView lIM;
  private View mView;
  private f nRm;
  String rcG;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51673);
    this.mView = null;
    this.CJb = null;
    this.CJc = null;
    setLayoutResource(2131496151);
    u.a(this);
    AppMethodBeat.o(51673);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
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
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.rcG)) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.lIM != null)) {
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
    this.CJb = ((TextView)paramView.findViewById(2131299662));
    this.lIM = ((ImageView)paramView.findViewById(2131296451));
    if (!Util.isNullOrNil(this.CJc))
    {
      this.CJb.setText(this.CJc);
      this.CJb.setVisibility(0);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.rcG))
      {
        paramView = u.a(new q(this.rcG));
        if ((paramView != null) && (!paramView.isRecycled()))
        {
          this.lIM.setImageBitmap(paramView);
          this.lIM.setVisibility(0);
        }
      }
      AppMethodBeat.o(51675);
      return;
      this.CJb.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.a
 * JD-Core Version:    0.7.0.1
 */