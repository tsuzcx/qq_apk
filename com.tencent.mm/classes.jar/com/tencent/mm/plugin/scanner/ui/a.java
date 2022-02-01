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
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  extends Preference
  implements u.a
{
  private ImageView kEm;
  private f mEx;
  private View mView;
  String pMn;
  private TextView yFj;
  String yFk;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51673);
    this.mView = null;
    this.yFj = null;
    this.yFk = null;
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
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals(this.pMn)) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.kEm != null)) {
      ar.f(new Runnable()
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
    this.yFj = ((TextView)paramView.findViewById(2131299135));
    this.kEm = ((ImageView)paramView.findViewById(2131296419));
    if (!bu.isNullOrNil(this.yFk))
    {
      this.yFj.setText(this.yFk);
      this.yFj.setVisibility(0);
    }
    for (;;)
    {
      if (!bu.isNullOrNil(this.pMn))
      {
        paramView = u.a(new n(this.pMn));
        if ((paramView != null) && (!paramView.isRecycled()))
        {
          this.kEm.setImageBitmap(paramView);
          this.kEm.setVisibility(0);
        }
      }
      AppMethodBeat.o(51675);
      return;
      this.yFj.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.a
 * JD-Core Version:    0.7.0.1
 */