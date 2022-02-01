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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class g
  extends Preference
{
  private static int AQE;
  private static float AQF = 16.0F;
  String AQG;
  private String[] AQH;
  private TextUtils.TruncateAt AQI;
  private boolean AQJ;
  private View mView;
  f nRm;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66820);
    this.mView = null;
    this.AQJ = false;
    setLayoutResource(2131495439);
    AQE = paramContext.getResources().getColor(2131100782);
    AppMethodBeat.o(66820);
  }
  
  public final void a(String[] paramArrayOfString, TextUtils.TruncateAt paramTruncateAt)
  {
    this.AQH = paramArrayOfString;
    this.AQI = paramTruncateAt;
    this.AQJ = true;
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
    TextView localTextView1 = (TextView)paramView.findViewById(2131304379);
    final TextView localTextView2 = (TextView)paramView.findViewById(2131304378);
    paramView = (LinearLayout)paramView.findViewById(2131304377);
    localTextView1.setText(getTitle());
    if ((this.AQH == null) || (this.AQH.length <= 1)) {
      localTextView2.setTextColor(AQE);
    }
    for (;;)
    {
      localTextView2.setText(this.AQG);
      AppMethodBeat.o(66822);
      return;
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66819);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/order/ui/preference/MallOrderDeployablePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
          a.a(this, "com/tencent/mm/plugin/order/ui/preference/MallOrderDeployablePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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