package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.ui.base.preference.Preference;

public final class f
  extends Preference
{
  private int AQA;
  private int AQB;
  private int AQC;
  private View.OnClickListener hEZ;
  private boolean mClickable;
  private String mContent;
  private View mView;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66815);
    this.mView = null;
    this.AQA = 2147483647;
    this.AQB = -1;
    this.AQC = -1;
    setLayoutResource(2131495438);
    AppMethodBeat.o(66815);
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    this.mContent = paramString;
    this.mClickable = true;
    this.AQB = paramInt1;
    this.AQC = paramInt2;
    this.hEZ = paramOnClickListener;
  }
  
  public final void aJG(String paramString)
  {
    AppMethodBeat.i(66818);
    try
    {
      this.AQA = g.cI(paramString, true);
      AppMethodBeat.o(66818);
      return;
    }
    catch (Exception paramString)
    {
      this.AQA = 2147483647;
      AppMethodBeat.o(66818);
    }
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66816);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(66816);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(66817);
    super.onBindView(paramView);
    Object localObject = (TextView)paramView.findViewById(2131304372);
    paramView = (TextView)paramView.findViewById(2131304371);
    ((TextView)localObject).setText(getTitle());
    if (this.AQA != 2147483647) {
      paramView.setTextColor(this.AQA);
    }
    if (this.mClickable)
    {
      if ((this.AQB >= 0) && (this.AQC > 0))
      {
        localObject = new a(this.mContext);
        SpannableString localSpannableString = new SpannableString(this.mContent);
        ((a)localObject).AQT = new a.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66814);
            if (f.a(f.this) != null) {
              f.a(f.this).onClick(paramAnonymousView);
            }
            AppMethodBeat.o(66814);
          }
        };
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        localSpannableString.setSpan(localObject, this.AQB, this.AQC, 33);
        paramView.setText(localSpannableString);
        AppMethodBeat.o(66817);
        return;
      }
      paramView.setTextColor(this.mContext.getResources().getColor(2131100775));
      paramView.setOnClickListener(this.hEZ);
      paramView.setText(l.b(this.mContext, this.mContent, paramView.getTextSize()));
      AppMethodBeat.o(66817);
      return;
    }
    paramView.setOnClickListener(null);
    paramView.setText(l.b(this.mContext, this.mContent, paramView.getTextSize()));
    AppMethodBeat.o(66817);
  }
  
  public final void setContent(String paramString)
  {
    this.mContent = paramString;
    this.mClickable = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.f
 * JD-Core Version:    0.7.0.1
 */