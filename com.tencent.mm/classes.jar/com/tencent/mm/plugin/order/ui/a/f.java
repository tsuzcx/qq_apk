package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.base.preference.Preference;

public final class f
  extends Preference
{
  private View.OnClickListener lPx;
  private String mContent;
  private View mView;
  private boolean nob;
  private int prD;
  private int prE;
  private int prF;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(43908);
    this.mView = null;
    this.prD = 2147483647;
    this.prE = -1;
    this.prF = -1;
    setLayoutResource(2130970095);
    AppMethodBeat.o(43908);
  }
  
  public final void WM(String paramString)
  {
    AppMethodBeat.i(43911);
    try
    {
      this.prD = Color.parseColor(paramString);
      AppMethodBeat.o(43911);
      return;
    }
    catch (Exception paramString)
    {
      this.prD = 2147483647;
      AppMethodBeat.o(43911);
    }
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    this.mContent = paramString;
    this.nob = true;
    this.prE = paramInt1;
    this.prF = paramInt2;
    this.lPx = paramOnClickListener;
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(43909);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(43909);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(43910);
    super.onBindView(paramView);
    Object localObject = (TextView)paramView.findViewById(2131825977);
    paramView = (TextView)paramView.findViewById(2131825978);
    ((TextView)localObject).setText(getTitle());
    if (this.prD != 2147483647) {
      paramView.setTextColor(this.prD);
    }
    if (this.nob)
    {
      if ((this.prE >= 0) && (this.prF > 0))
      {
        localObject = new a(this.mContext);
        SpannableString localSpannableString = new SpannableString(this.mContent);
        ((a)localObject).prW = new f.1(this);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        localSpannableString.setSpan(localObject, this.prE, this.prF, 33);
        paramView.setText(localSpannableString);
        AppMethodBeat.o(43910);
        return;
      }
      paramView.setTextColor(this.mContext.getResources().getColor(2131690267));
      paramView.setOnClickListener(this.lPx);
      paramView.setText(j.b(this.mContext, this.mContent, paramView.getTextSize()));
      AppMethodBeat.o(43910);
      return;
    }
    paramView.setOnClickListener(null);
    paramView.setText(j.b(this.mContext, this.mContent, paramView.getTextSize()));
    AppMethodBeat.o(43910);
  }
  
  public final void setContent(String paramString)
  {
    this.mContent = paramString;
    this.nob = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.f
 * JD-Core Version:    0.7.0.1
 */