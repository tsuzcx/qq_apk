package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public final class i
  extends Preference
{
  private View mView;
  private int prS;
  String prT;
  
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(43920);
    this.mView = null;
    this.prS = 2147483647;
    setLayoutResource(2130970099);
    AppMethodBeat.o(43920);
  }
  
  public final void WN(String paramString)
  {
    AppMethodBeat.i(43923);
    try
    {
      this.prS = Color.parseColor(paramString);
      AppMethodBeat.o(43923);
      return;
    }
    catch (Exception paramString)
    {
      this.prS = -1;
      AppMethodBeat.o(43923);
    }
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(43921);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(43921);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(43922);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(2131825996);
    paramView = (TextView)paramView.findViewById(2131825997);
    localTextView.setText(getTitle());
    paramView.setText(this.prT);
    if (this.prS != 2147483647) {
      paramView.setTextColor(this.prS);
    }
    AppMethodBeat.o(43922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.i
 * JD-Core Version:    0.7.0.1
 */