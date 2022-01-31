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
  Bitmap frG;
  View.OnClickListener mOnClickListener;
  private View mView;
  private TextView pmO;
  private ImageView prA;
  String prB;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(43898);
    this.mView = null;
    this.prB = "";
    this.frG = null;
    setLayoutResource(2130970092);
    AppMethodBeat.o(43898);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(43899);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(43899);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(43900);
    super.onBindView(paramView);
    this.pmO = ((TextView)paramView.findViewById(2131825972));
    this.prA = ((ImageView)paramView.findViewById(2131825971));
    this.pmO.setText(this.prB);
    this.prA.setImageBitmap(this.frG);
    this.prA.setOnClickListener(this.mOnClickListener);
    if ((this.prB != null) && (this.prB.length() > 48)) {
      this.pmO.setTextSize(0, a.ao(this.mContext, 2131427758));
    }
    AppMethodBeat.o(43900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.c
 * JD-Core Version:    0.7.0.1
 */