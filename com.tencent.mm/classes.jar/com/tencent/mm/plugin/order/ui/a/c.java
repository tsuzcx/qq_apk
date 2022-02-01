package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.preference.Preference;

public final class c
  extends Preference
{
  Bitmap hPl;
  View.OnClickListener mOnClickListener;
  private View mView;
  private TextView wPz;
  private ImageView wUB;
  String wUC;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66805);
    this.mView = null;
    this.wUC = "";
    this.hPl = null;
    setLayoutResource(2131494706);
    AppMethodBeat.o(66805);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66806);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(66806);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(66807);
    super.onBindView(paramView);
    this.wPz = ((TextView)paramView.findViewById(2131302027));
    this.wUB = ((ImageView)paramView.findViewById(2131302026));
    this.wPz.setText(this.wUC);
    this.wUB.setImageBitmap(this.hPl);
    this.wUB.setOnClickListener(this.mOnClickListener);
    if ((this.wUC != null) && (this.wUC.length() > 48)) {
      this.wPz.setTextSize(0, a.ax(this.mContext, 2131165466));
    }
    AppMethodBeat.o(66807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.c
 * JD-Core Version:    0.7.0.1
 */