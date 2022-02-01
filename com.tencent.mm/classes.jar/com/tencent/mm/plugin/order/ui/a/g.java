package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class g
  extends Preference
{
  private static int uqH;
  private static float uqI = 16.0F;
  f lxI;
  private View mView;
  String uqJ;
  private String[] uqK;
  private TextUtils.TruncateAt uqL;
  private boolean uqM;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66820);
    this.mView = null;
    this.uqM = false;
    setLayoutResource(2131494710);
    uqH = paramContext.getResources().getColor(2131100614);
    AppMethodBeat.o(66820);
  }
  
  public final void a(String[] paramArrayOfString, TextUtils.TruncateAt paramTruncateAt)
  {
    this.uqK = paramArrayOfString;
    this.uqL = paramTruncateAt;
    this.uqM = true;
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66821);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(66821);
    return paramView;
  }
  
  public final void onBindView(final View paramView)
  {
    AppMethodBeat.i(66822);
    super.onBindView(paramView);
    TextView localTextView1 = (TextView)paramView.findViewById(2131302040);
    final TextView localTextView2 = (TextView)paramView.findViewById(2131302039);
    paramView = (LinearLayout)paramView.findViewById(2131302038);
    localTextView1.setText(getTitle());
    if ((this.uqK == null) || (this.uqK.length <= 1)) {
      localTextView2.setTextColor(uqH);
    }
    for (;;)
    {
      localTextView2.setText(this.uqJ);
      AppMethodBeat.o(66822);
      return;
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66819);
          localTextView2.setVisibility(8);
          int i = 0;
          while (i < g.a(g.this).length)
          {
            paramAnonymousView = g.a(g.this, g.a(g.this)[i]);
            paramView.addView(paramAnonymousView, new LinearLayout.LayoutParams(-2, -2));
            i += 1;
          }
          localTextView2.setOnClickListener(null);
          if (g.b(g.this) != null) {
            g.b(g.this).notifyDataSetChanged();
          }
          AppMethodBeat.o(66819);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.g
 * JD-Core Version:    0.7.0.1
 */