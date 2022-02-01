package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;

public class HelperHeaderPreference
  extends Preference
{
  private a Kpu;
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152254);
    this.Kpu = new a();
    AppMethodBeat.o(152254);
  }
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152255);
    this.Kpu = new a();
    AppMethodBeat.o(152255);
  }
  
  public final void bk(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(152257);
    this.Kpu.dWq = paramString1;
    this.Kpu.gCv = paramString2;
    this.Kpu.hint = paramString3;
    super.callChangeListener(null);
    AppMethodBeat.o(152257);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(152256);
    ImageView localImageView = (ImageView)paramView.findViewById(2131297134);
    TextView localTextView1 = (TextView)paramView.findViewById(2131308405);
    TextView localTextView2 = (TextView)paramView.findViewById(2131305440);
    TextView localTextView3 = (TextView)paramView.findViewById(2131302335);
    TextView localTextView4 = (TextView)paramView.findViewById(2131300550);
    final View localView = paramView.findViewById(2131306255);
    localTextView4.setText(2131759368);
    if (localImageView != null) {
      a.b.c(localImageView, this.Kpu.dWq);
    }
    if (localTextView1 != null) {
      switch (this.Kpu.status)
      {
      }
    }
    for (;;)
    {
      if (localTextView2 != null) {
        localTextView2.setText(this.Kpu.gCv);
      }
      if (localTextView3 != null) {
        localTextView3.setText(this.Kpu.hint);
      }
      super.onBindView(paramView);
      localView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(152253);
          localView.getViewTreeObserver().removeOnPreDrawListener(this);
          int[] arrayOfInt = new int[2];
          localView.getLocationOnScreen(arrayOfInt);
          int k = arrayOfInt[1];
          int j = a.fromDPToPix(HelperHeaderPreference.this.mContext, 60);
          int m = au.getStatusBarHeight(HelperHeaderPreference.this.mContext);
          int n = au.eu(HelperHeaderPreference.this.mContext);
          Log.i("MicroMsg.HelperHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
          int i = j;
          if (m > 0)
          {
            i = j;
            if (n > 0) {
              i = a.aH(HelperHeaderPreference.this.mContext, 2131165296) + n;
            }
          }
          j = i;
          if (k == 0) {
            j = i + m;
          }
          if (j != localView.getPaddingTop())
          {
            localView.setPadding(localView.getPaddingLeft(), j, localView.getPaddingRight(), localView.getPaddingBottom());
            AppMethodBeat.o(152253);
            return false;
          }
          AppMethodBeat.o(152253);
          return true;
        }
      });
      AppMethodBeat.o(152256);
      return;
      localTextView1.setVisibility(0);
      localTextView1.setTextColor(u.kF(this.mContext));
      localTextView1.setText(2131765542);
      continue;
      localTextView1.setVisibility(0);
      localTextView1.setTextColor(u.kG(this.mContext));
      localTextView1.setText(2131765550);
      continue;
      localTextView1.setVisibility(8);
    }
  }
  
  public final void updateStatus(int paramInt)
  {
    AppMethodBeat.i(152258);
    this.Kpu.status = paramInt;
    super.callChangeListener(null);
    AppMethodBeat.o(152258);
  }
  
  public static final class a
  {
    public String dWq;
    public String gCv;
    public String hint;
    public int status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference
 * JD-Core Version:    0.7.0.1
 */