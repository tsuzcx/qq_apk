package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.ui.base.preference.Preference;

public final class c
  extends Preference
{
  Bitmap hua;
  View.OnClickListener mOnClickListener;
  private View mView;
  private TextView vuv;
  private ImageView vzw;
  String vzx;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66805);
    this.mView = null;
    this.vzx = "";
    this.hua = null;
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
    this.vuv = ((TextView)paramView.findViewById(2131302027));
    this.vzw = ((ImageView)paramView.findViewById(2131302026));
    this.vuv.setText(this.vzx);
    this.vzw.setImageBitmap(this.hua);
    this.vzw.setOnClickListener(this.mOnClickListener);
    if ((this.vzx != null) && (this.vzx.length() > 48)) {
      this.vuv.setTextSize(0, a.au(this.mContext, 2131165466));
    }
    AppMethodBeat.o(66807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.c
 * JD-Core Version:    0.7.0.1
 */