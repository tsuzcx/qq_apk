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
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  extends Preference
  implements u.a
{
  private ImageView kAX;
  private View mView;
  private f mzx;
  String pFJ;
  private TextView ypk;
  String ypl;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51673);
    this.mView = null;
    this.ypk = null;
    this.ypl = null;
    setLayoutResource(2131495301);
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
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals(this.pFJ)) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.kAX != null)) {
      aq.f(new Runnable()
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
    this.ypk = ((TextView)paramView.findViewById(2131299135));
    this.kAX = ((ImageView)paramView.findViewById(2131296419));
    if (!bt.isNullOrNil(this.ypl))
    {
      this.ypk.setText(this.ypl);
      this.ypk.setVisibility(0);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(this.pFJ))
      {
        paramView = u.a(new n(this.pFJ));
        if ((paramView != null) && (!paramView.isRecycled()))
        {
          this.kAX.setImageBitmap(paramView);
          this.kAX.setVisibility(0);
        }
      }
      AppMethodBeat.o(51675);
      return;
      this.ypk.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.a
 * JD-Core Version:    0.7.0.1
 */