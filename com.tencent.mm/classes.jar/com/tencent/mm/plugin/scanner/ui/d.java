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
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public final class d
  extends Preference
{
  private ViewTreeObserver.OnGlobalLayoutListener FzV;
  public boolean GDx;
  private TextView MXN;
  private final int OYQ;
  private TextView OYR;
  public boolean OYS;
  private Boolean OYT;
  a OYU;
  private Context context;
  String mTitle;
  private View mView;
  private View.OnTouchListener onTouchListener;
  private TextView titleTv;
  
  public d(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(51791);
    this.OYQ = 5;
    this.OYS = false;
    this.GDx = false;
    setLayoutResource(l.g.OKi);
    this.context = paramActivity;
    AppMethodBeat.o(51791);
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
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
    if (this.MXN == null) {
      this.MXN = ((TextView)paramView.findViewById(16908304));
    }
    if (this.OYR == null) {
      this.OYR = ((TextView)paramView.findViewById(l.f.more));
    }
    if (this.onTouchListener == null)
    {
      this.onTouchListener = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(51789);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            Log.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
            d.a(d.this).setVisibility(4);
            d.b(d.this).setMaxLines(2000);
            d.this.OYS = true;
            if (d.c(d.this) != null)
            {
              d.c(d.this).c(d.this.mKey, Boolean.TRUE);
              d.c(d.this).gSx();
            }
          }
          AppMethodBeat.o(51789);
          return false;
        }
      };
      this.OYR.setOnTouchListener(this.onTouchListener);
    }
    if (this.OYU != null)
    {
      this.OYT = this.OYU.aUW(this.mKey);
      if (this.OYT != null) {
        if (this.OYT.booleanValue())
        {
          this.OYR.setVisibility(8);
          this.MXN.setMaxLines(2000);
        }
      }
    }
    for (;;)
    {
      if (this.FzV == null)
      {
        this.FzV = new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(51790);
            Log.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + d.b(d.this).getHeight() + ", summaryTv.getLineHeight() = " + d.b(d.this).getLineHeight());
            if ((d.b(d.this).getText() != null) && (d.b(d.this).getHeight() > 0) && (d.b(d.this).getLineHeight() > 0) && (d.d(d.this) == null))
            {
              if ((d.b(d.this).getHeight() / d.b(d.this).getLineHeight() > 5) && (!d.this.GDx) && (!d.this.OYS))
              {
                d.a(d.this).setVisibility(0);
                d.b(d.this).setMaxLines(5);
                d.this.GDx = true;
                if ((d.c(d.this) != null) && (d.c(d.this).aUW(d.this.mKey) == null))
                {
                  d.c(d.this).c(d.this.mKey, Boolean.FALSE);
                  d.c(d.this).gSx();
                }
              }
              Log.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + d.b(d.this).getHeight() / d.b(d.this).getLineHeight());
            }
            d.b(d.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            AppMethodBeat.o(51790);
          }
        };
        this.MXN.getViewTreeObserver().addOnGlobalLayoutListener(this.FzV);
      }
      if (!Util.isNullOrNil(this.mTitle)) {
        break;
      }
      this.titleTv.setVisibility(8);
      AppMethodBeat.o(51793);
      return;
      this.OYR.setVisibility(0);
      this.MXN.setMaxLines(5);
      continue;
      this.OYR.setVisibility(8);
      this.MXN.setMaxLines(6);
      continue;
      this.OYR.setVisibility(8);
      this.MXN.setMaxLines(6);
    }
    this.titleTv.setText(this.mTitle);
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(51793);
  }
  
  public static abstract interface a
  {
    public abstract Boolean aUW(String paramString);
    
    public abstract void c(String paramString, Boolean paramBoolean);
    
    public abstract void gSx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.d
 * JD-Core Version:    0.7.0.1
 */