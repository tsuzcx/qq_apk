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
  private TextView ALg;
  private ImageView AQx;
  String AQy;
  Bitmap iKs;
  View.OnClickListener mOnClickListener;
  private View mView;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66805);
    this.mView = null;
    this.AQy = "";
    this.iKs = null;
    setLayoutResource(2131495435);
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
    this.ALg = ((TextView)paramView.findViewById(2131304366));
    this.AQx = ((ImageView)paramView.findViewById(2131304365));
    this.ALg.setText(this.AQy);
    this.AQx.setImageBitmap(this.iKs);
    this.AQx.setOnClickListener(this.mOnClickListener);
    if ((this.AQy != null) && (this.AQy.length() > 48)) {
      this.ALg.setTextSize(0, a.aG(this.mContext, 2131165482));
    }
    AppMethodBeat.o(66807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.c
 * JD-Core Version:    0.7.0.1
 */