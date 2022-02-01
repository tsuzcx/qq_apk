package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.v;

public class HelperHeaderPreference
  extends Preference
{
  private a Rqj;
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152254);
    this.Rqj = new a();
    AppMethodBeat.o(152254);
  }
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152255);
    this.Rqj = new a();
    AppMethodBeat.o(152255);
  }
  
  public final void bf(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(152257);
    this.Rqj.fPV = paramString1;
    this.Rqj.jmB = paramString2;
    this.Rqj.hint = paramString3;
    super.ej(null);
    AppMethodBeat.o(152257);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(152256);
    ImageView localImageView = (ImageView)paramView.findViewById(c.e.avatar_iv);
    TextView localTextView1 = (TextView)paramView.findViewById(c.e.status_tv);
    TextView localTextView2 = (TextView)paramView.findViewById(c.e.nickname_tv);
    TextView localTextView3 = (TextView)paramView.findViewById(c.e.hint_tv);
    TextView localTextView4 = (TextView)paramView.findViewById(c.e.feature_tv);
    View localView = paramView.findViewById(c.e.profile_root);
    localTextView4.setText(c.h.feature_introduce);
    if (localImageView != null) {
      a.b.c(localImageView, this.Rqj.fPV);
    }
    if (localTextView1 != null) {
      switch (this.Rqj.status)
      {
      }
    }
    for (;;)
    {
      if (localTextView2 != null) {
        localTextView2.setText(this.Rqj.jmB);
      }
      if (localTextView3 != null) {
        localTextView3.setText(this.Rqj.hint);
      }
      super.onBindView(paramView);
      localView.getViewTreeObserver().addOnPreDrawListener(new HelperHeaderPreference.1(this, localView));
      AppMethodBeat.o(152256);
      return;
      localTextView1.setVisibility(0);
      localTextView1.setTextColor(v.lC(this.mContext));
      localTextView1.setText(c.h.settings_plugins_installed);
      continue;
      localTextView1.setVisibility(0);
      localTextView1.setTextColor(v.lD(this.mContext));
      localTextView1.setText(c.h.settings_plugins_uninstalled);
      continue;
      localTextView1.setVisibility(8);
    }
  }
  
  public final void updateStatus(int paramInt)
  {
    AppMethodBeat.i(152258);
    this.Rqj.status = paramInt;
    super.ej(null);
    AppMethodBeat.o(152258);
  }
  
  public static final class a
  {
    public String fPV;
    public String hint;
    public String jmB;
    public int status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference
 * JD-Core Version:    0.7.0.1
 */