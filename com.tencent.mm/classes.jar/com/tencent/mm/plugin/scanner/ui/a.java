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
  private ImageView jFL;
  private f lxI;
  private View mView;
  String oyz;
  private TextView vQB;
  String vQC;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51673);
    this.mView = null;
    this.vQB = null;
    this.vQC = null;
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
  
  public final void l(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(51676);
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals(this.oyz)) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.jFL != null)) {
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
    this.vQB = ((TextView)paramView.findViewById(2131299135));
    this.jFL = ((ImageView)paramView.findViewById(2131296419));
    if (!bt.isNullOrNil(this.vQC))
    {
      this.vQB.setText(this.vQC);
      this.vQB.setVisibility(0);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(this.oyz))
      {
        paramView = u.a(new n(this.oyz));
        if ((paramView != null) && (!paramView.isRecycled()))
        {
          this.jFL.setImageBitmap(paramView);
          this.jFL.setVisibility(0);
        }
      }
      AppMethodBeat.o(51675);
      return;
      this.vQB.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.a
 * JD-Core Version:    0.7.0.1
 */