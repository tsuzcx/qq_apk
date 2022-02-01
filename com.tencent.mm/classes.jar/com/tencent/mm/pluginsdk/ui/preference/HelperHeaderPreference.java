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
import com.tencent.mm.ui.tools.u;

public class HelperHeaderPreference
  extends Preference
{
  private a YmA;
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152254);
    this.YmA = new a();
    AppMethodBeat.o(152254);
  }
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152255);
    this.YmA = new a();
    AppMethodBeat.o(152255);
  }
  
  public final void bz(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(152257);
    this.YmA.hVQ = paramString1;
    this.YmA.displayName = paramString2;
    this.YmA.hint = paramString3;
    super.gH(null);
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
      a.b.g(localImageView, this.YmA.hVQ);
    }
    if (localTextView1 != null) {
      switch (this.YmA.status)
      {
      }
    }
    for (;;)
    {
      if (localTextView2 != null) {
        localTextView2.setText(this.YmA.displayName);
      }
      if (localTextView3 != null) {
        localTextView3.setText(this.YmA.hint);
      }
      super.onBindView(paramView);
      localView.getViewTreeObserver().addOnPreDrawListener(new HelperHeaderPreference.1(this, localView));
      AppMethodBeat.o(152256);
      return;
      localTextView1.setVisibility(0);
      localTextView1.setTextColor(u.nF(this.mContext));
      localTextView1.setText(c.h.settings_plugins_installed);
      continue;
      localTextView1.setVisibility(0);
      localTextView1.setTextColor(u.nG(this.mContext));
      localTextView1.setText(c.h.settings_plugins_uninstalled);
      continue;
      localTextView1.setVisibility(8);
    }
  }
  
  public final void updateStatus(int paramInt)
  {
    AppMethodBeat.i(152258);
    this.YmA.status = paramInt;
    super.gH(null);
    AppMethodBeat.o(152258);
  }
  
  public static final class a
  {
    public String displayName;
    public String hVQ;
    public String hint;
    public int status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference
 * JD-Core Version:    0.7.0.1
 */