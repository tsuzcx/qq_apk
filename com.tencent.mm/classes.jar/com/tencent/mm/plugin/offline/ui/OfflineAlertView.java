package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.z;

public class OfflineAlertView
  extends LinearLayout
{
  private View contentView;
  public int pmi;
  private RelativeLayout pmj;
  boolean pmk;
  private OfflineAlertView.a pml;
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(43452);
    this.pmi = 0;
    this.contentView = null;
    this.pmj = null;
    this.pmk = true;
    this.pml = null;
    init();
    AppMethodBeat.o(43452);
  }
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(43453);
    this.pmi = 0;
    this.contentView = null;
    this.pmj = null;
    this.pmk = true;
    this.pml = null;
    init();
    AppMethodBeat.o(43453);
  }
  
  private void init()
  {
    AppMethodBeat.i(43454);
    this.contentView = LayoutInflater.from(getContext()).inflate(2130971207, this);
    this.pmj = ((RelativeLayout)this.contentView.findViewById(2131829216));
    AppMethodBeat.o(43454);
  }
  
  public final boolean AZ(int paramInt)
  {
    AppMethodBeat.i(43461);
    if (isShowing())
    {
      if (paramInt == this.pmi)
      {
        AppMethodBeat.o(43461);
        return true;
      }
      if ((paramInt == 2) && ((this.pmi == 3) || (this.pmi == 4) || (this.pmi == 2) || (this.pmi == 5)))
      {
        AppMethodBeat.o(43461);
        return true;
      }
      if ((paramInt == 5) && (this.pmi == 4))
      {
        AppMethodBeat.o(43461);
        return true;
      }
      if (paramInt == 6)
      {
        AppMethodBeat.o(43461);
        return true;
      }
      AppMethodBeat.o(43461);
      return false;
    }
    AppMethodBeat.o(43461);
    return true;
  }
  
  public final void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(43457);
    a(paramView, paramOnClickListener, 6);
    AppMethodBeat.o(43457);
  }
  
  final void a(View paramView, View.OnClickListener paramOnClickListener, int paramInt)
  {
    AppMethodBeat.i(43458);
    this.pmi = paramInt;
    setVisibility(0);
    this.pmj.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2130971218, null);
    if (paramInt == 6) {
      ((TextView)localView.findViewById(2131829243)).setText(2131302006);
    }
    for (;;)
    {
      TextView localTextView = (TextView)localView.findViewById(2131829253);
      if (localTextView != null)
      {
        SpannableString localSpannableString = new SpannableString("#  " + getContext().getResources().getString(2131305318));
        Drawable localDrawable = getContext().getResources().getDrawable(2130839138);
        localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        localSpannableString.setSpan(new ImageSpan(localDrawable), 0, 1, 18);
        localTextView.setText(localSpannableString, TextView.BufferType.SPANNABLE);
        localTextView.setOnClickListener(new OfflineAlertView.7(this, paramView));
        localTextView.setVisibility(0);
      }
      this.pmj.addView(localView);
      ((Button)this.contentView.findViewById(2131828490)).setOnClickListener(paramOnClickListener);
      this.pmk = false;
      paramView.post(new OfflineAlertView.8(this, paramView));
      AppMethodBeat.o(43458);
      return;
      if (((paramInt == 3) || (paramInt == 1)) && (b.tM((String)g.RL().Ru().get(274436, null)))) {
        ((TextView)localView.findViewById(2131829243)).setText(2131302015);
      }
    }
  }
  
  public final void a(View paramView, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(43455);
    setVisibility(0);
    this.pmj.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2130971215, null);
    this.pmj.addView(localView);
    paramView.post(new OfflineAlertView.1(this, paramView, paramRunnable1, paramRunnable2));
    AppMethodBeat.o(43455);
  }
  
  public final void b(View paramView, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(43459);
    this.pmi = 5;
    setVisibility(0);
    this.pmk = false;
    this.pmj.removeAllViews();
    Object localObject = LayoutInflater.from(getContext()).inflate(2130971218, null);
    this.pmj.addView((View)localObject);
    ((TextView)((View)localObject).findViewById(2131829243)).setText(2131302003);
    localObject = (Button)((View)localObject).findViewById(2131828490);
    ((Button)localObject).setText(2131302002);
    ((Button)localObject).setOnClickListener(paramOnClickListener);
    paramView.post(new OfflineAlertView.9(this, paramView));
    AppMethodBeat.o(43459);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(43462);
    if (this.pmj != null) {
      this.pmj.removeAllViews();
    }
    setVisibility(8);
    if (this.pml != null) {
      this.pml.onClose();
    }
    this.pmk = true;
    AppMethodBeat.o(43462);
  }
  
  public final void du(View paramView)
  {
    AppMethodBeat.i(43456);
    setVisibility(0);
    this.pmj.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2130971213, null);
    this.pmj.addView(localView);
    h.qsU.e(13750, new Object[] { Integer.valueOf(1) });
    paramView.post(new OfflineAlertView.2(this, paramView));
    AppMethodBeat.o(43456);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(43460);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(43460);
      return true;
    }
    AppMethodBeat.o(43460);
    return false;
  }
  
  public void setDialogState(OfflineAlertView.a parama)
  {
    this.pml = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView
 * JD-Core Version:    0.7.0.1
 */