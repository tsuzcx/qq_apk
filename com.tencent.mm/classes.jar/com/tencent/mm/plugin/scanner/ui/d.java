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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.Preference;

public final class d
  extends Preference
{
  private Context context;
  String mTitle;
  private View mView;
  private View.OnTouchListener sGX;
  private TextView titleTv;
  private TextView vLf;
  private final int xcB;
  private TextView xcC;
  public boolean xcD;
  public boolean xcE;
  private Boolean xcF;
  private ViewTreeObserver.OnGlobalLayoutListener xcG;
  a xcH;
  
  public d(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(51791);
    this.xcB = 5;
    this.xcD = false;
    this.xcE = false;
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
    if (this.vLf == null) {
      this.vLf = ((TextView)paramView.findViewById(16908304));
    }
    if (this.xcC == null) {
      this.xcC = ((TextView)paramView.findViewById(2131302452));
    }
    if (this.sGX == null)
    {
      this.sGX = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(51789);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            ac.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
            d.a(d.this).setVisibility(4);
            d.b(d.this).setMaxLines(2000);
            d.this.xcD = true;
            if (d.c(d.this) != null)
            {
              d.c(d.this).a(d.this.mKey, Boolean.TRUE);
              d.c(d.this).dAh();
            }
          }
          AppMethodBeat.o(51789);
          return false;
        }
      };
      this.xcC.setOnTouchListener(this.sGX);
    }
    if (this.xcH != null)
    {
      this.xcF = this.xcH.arM(this.mKey);
      if (this.xcF != null) {
        if (this.xcF.booleanValue())
        {
          this.xcC.setVisibility(8);
          this.vLf.setMaxLines(2000);
        }
      }
    }
    for (;;)
    {
      if (this.xcG == null)
      {
        this.xcG = new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(51790);
            ac.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + d.b(d.this).getHeight() + ", summaryTv.getLineHeight() = " + d.b(d.this).getLineHeight());
            if ((d.b(d.this).getText() != null) && (d.b(d.this).getHeight() > 0) && (d.b(d.this).getLineHeight() > 0) && (d.d(d.this) == null))
            {
              if ((d.b(d.this).getHeight() / d.b(d.this).getLineHeight() > 5) && (!d.this.xcE) && (!d.this.xcD))
              {
                d.a(d.this).setVisibility(0);
                d.b(d.this).setMaxLines(5);
                d.this.xcE = true;
                if ((d.c(d.this) != null) && (d.c(d.this).arM(d.this.mKey) == null))
                {
                  d.c(d.this).a(d.this.mKey, Boolean.FALSE);
                  d.c(d.this).dAh();
                }
              }
              ac.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + d.b(d.this).getHeight() / d.b(d.this).getLineHeight());
            }
            d.b(d.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            AppMethodBeat.o(51790);
          }
        };
        this.vLf.getViewTreeObserver().addOnGlobalLayoutListener(this.xcG);
      }
      if (!bs.isNullOrNil(this.mTitle)) {
        break;
      }
      this.titleTv.setVisibility(8);
      AppMethodBeat.o(51793);
      return;
      this.xcC.setVisibility(0);
      this.vLf.setMaxLines(5);
      continue;
      this.xcC.setVisibility(8);
      this.vLf.setMaxLines(6);
      continue;
      this.xcC.setVisibility(8);
      this.vLf.setMaxLines(6);
    }
    this.titleTv.setText(this.mTitle);
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(51793);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, Boolean paramBoolean);
    
    public abstract Boolean arM(String paramString);
    
    public abstract void dAh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.d
 * JD-Core Version:    0.7.0.1
 */