package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.util.s;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  extends Preference
  implements x.a
{
  private ImageView iCl;
  private f iLA;
  String lix;
  private View mView;
  private TextView qvv;
  String qvw;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(80899);
    this.mView = null;
    this.qvv = null;
    this.qvw = null;
    setLayoutResource(2130970609);
    x.a(this);
    AppMethodBeat.o(80899);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(80900);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(80900);
    return paramView;
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(80902);
    if ((!bo.isNullOrNil(paramString)) && (paramString.equals(this.lix)) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.iCl != null)) {
      al.d(new a.1(this, paramBitmap));
    }
    AppMethodBeat.o(80902);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(80901);
    super.onBindView(paramView);
    this.qvv = ((TextView)paramView.findViewById(2131822523));
    this.iCl = ((ImageView)paramView.findViewById(2131827436));
    if (!bo.isNullOrNil(this.qvw))
    {
      this.qvv.setText(this.qvw);
      this.qvv.setVisibility(0);
    }
    for (;;)
    {
      if (!bo.isNullOrNil(this.lix))
      {
        paramView = x.a(new s(this.lix));
        if ((paramView != null) && (!paramView.isRecycled()))
        {
          this.iCl.setImageBitmap(paramView);
          this.iCl.setVisibility(0);
        }
      }
      AppMethodBeat.o(80901);
      return;
      this.qvv.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.a
 * JD-Core Version:    0.7.0.1
 */