package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.Preference;

public final class d
  extends Preference
{
  private Context context;
  String mTitle;
  private View mView;
  private View.OnTouchListener tOH;
  private TextView titleTv;
  private TextView xif;
  private final int yGD;
  private TextView yGE;
  public boolean yGF;
  public boolean yGG;
  private Boolean yGH;
  private ViewTreeObserver.OnGlobalLayoutListener yGI;
  a yGJ;
  
  public d(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(51791);
    this.yGD = 5;
    this.yGF = false;
    this.yGG = false;
    setLayoutResource(2131494852);
    this.context = paramActivity;
    AppMethodBeat.o(51791);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51792);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(51792);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(51793);
    super.onBindView(paramView);
    if (this.titleTv == null) {
      this.titleTv = ((TextView)paramView.findViewById(16908310));
    }
    if (this.xif == null) {
      this.xif = ((TextView)paramView.findViewById(16908304));
    }
    if (this.yGE == null) {
      this.yGE = ((TextView)paramView.findViewById(2131302452));
    }
    if (this.tOH == null)
    {
      this.tOH = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(51789);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          a.b("com/tencent/mm/plugin/scanner/ui/DescriptionTextPreference$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            ae.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
            d.a(d.this).setVisibility(4);
            d.b(d.this).setMaxLines(2000);
            d.this.yGF = true;
            if (d.c(d.this) != null)
            {
              d.c(d.this).b(d.this.mKey, Boolean.TRUE);
              d.c(d.this).dOY();
            }
          }
          a.a(false, this, "com/tencent/mm/plugin/scanner/ui/DescriptionTextPreference$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(51789);
          return false;
        }
      };
      this.yGE.setOnTouchListener(this.tOH);
    }
    if (this.yGJ != null)
    {
      this.yGH = this.yGJ.ayc(this.mKey);
      if (this.yGH != null) {
        if (this.yGH.booleanValue())
        {
          this.yGE.setVisibility(8);
          this.xif.setMaxLines(2000);
        }
      }
    }
    for (;;)
    {
      if (this.yGI == null)
      {
        this.yGI = new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(51790);
            ae.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + d.b(d.this).getHeight() + ", summaryTv.getLineHeight() = " + d.b(d.this).getLineHeight());
            if ((d.b(d.this).getText() != null) && (d.b(d.this).getHeight() > 0) && (d.b(d.this).getLineHeight() > 0) && (d.d(d.this) == null))
            {
              if ((d.b(d.this).getHeight() / d.b(d.this).getLineHeight() > 5) && (!d.this.yGG) && (!d.this.yGF))
              {
                d.a(d.this).setVisibility(0);
                d.b(d.this).setMaxLines(5);
                d.this.yGG = true;
                if ((d.c(d.this) != null) && (d.c(d.this).ayc(d.this.mKey) == null))
                {
                  d.c(d.this).b(d.this.mKey, Boolean.FALSE);
                  d.c(d.this).dOY();
                }
              }
              ae.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + d.b(d.this).getHeight() / d.b(d.this).getLineHeight());
            }
            d.b(d.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            AppMethodBeat.o(51790);
          }
        };
        this.xif.getViewTreeObserver().addOnGlobalLayoutListener(this.yGI);
      }
      if (!bu.isNullOrNil(this.mTitle)) {
        break;
      }
      this.titleTv.setVisibility(8);
      AppMethodBeat.o(51793);
      return;
      this.yGE.setVisibility(0);
      this.xif.setMaxLines(5);
      continue;
      this.yGE.setVisibility(8);
      this.xif.setMaxLines(6);
      continue;
      this.yGE.setVisibility(8);
      this.xif.setMaxLines(6);
    }
    this.titleTv.setText(this.mTitle);
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(51793);
  }
  
  public static abstract interface a
  {
    public abstract Boolean ayc(String paramString);
    
    public abstract void b(String paramString, Boolean paramBoolean);
    
    public abstract void dOY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.d
 * JD-Core Version:    0.7.0.1
 */