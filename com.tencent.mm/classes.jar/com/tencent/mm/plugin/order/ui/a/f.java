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
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.ui.base.preference.Preference;

public final class f
  extends Preference
{
  private boolean mClickable;
  private String mContent;
  private View mView;
  private View.OnClickListener pgj;
  private int uqD;
  private int uqE;
  private int uqF;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66815);
    this.mView = null;
    this.uqD = 2147483647;
    this.uqE = -1;
    this.uqF = -1;
    setLayoutResource(2131494709);
    AppMethodBeat.o(66815);
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    this.mContent = paramString;
    this.mClickable = true;
    this.uqE = paramInt1;
    this.uqF = paramInt2;
    this.pgj = paramOnClickListener;
  }
  
  public final void akg(String paramString)
  {
    AppMethodBeat.i(66818);
    try
    {
      this.uqD = g.bW(paramString, true);
      AppMethodBeat.o(66818);
      return;
    }
    catch (Exception paramString)
    {
      this.uqD = 2147483647;
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
    Object localObject = (TextView)paramView.findViewById(2131302033);
    paramView = (TextView)paramView.findViewById(2131302032);
    ((TextView)localObject).setText(getTitle());
    if (this.uqD != 2147483647) {
      paramView.setTextColor(this.uqD);
    }
    if (this.mClickable)
    {
      if ((this.uqE >= 0) && (this.uqF > 0))
      {
        localObject = new a(this.mContext);
        SpannableString localSpannableString = new SpannableString(this.mContent);
        ((a)localObject).uqW = new a.a()
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
        localSpannableString.setSpan(localObject, this.uqE, this.uqF, 33);
        paramView.setText(localSpannableString);
        AppMethodBeat.o(66817);
        return;
      }
      paramView.setTextColor(this.mContext.getResources().getColor(2131100607));
      paramView.setOnClickListener(this.pgj);
      paramView.setText(k.b(this.mContext, this.mContent, paramView.getTextSize()));
      AppMethodBeat.o(66817);
      return;
    }
    paramView.setOnClickListener(null);
    paramView.setText(k.b(this.mContext, this.mContent, paramView.getTextSize()));
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