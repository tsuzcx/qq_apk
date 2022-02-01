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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;

public final class d
  extends Preference
{
  private Context context;
  String mTitle;
  private View mView;
  private View.OnTouchListener ryf;
  private TextView titleTv;
  private TextView uCm;
  private final int vRQ;
  private TextView vRR;
  public boolean vRS;
  public boolean vRT;
  private Boolean vRU;
  private ViewTreeObserver.OnGlobalLayoutListener vRV;
  a vRW;
  
  public d(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(51791);
    this.vRQ = 5;
    this.vRS = false;
    this.vRT = false;
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
    if (this.uCm == null) {
      this.uCm = ((TextView)paramView.findViewById(16908304));
    }
    if (this.vRR == null) {
      this.vRR = ((TextView)paramView.findViewById(2131302452));
    }
    if (this.ryf == null)
    {
      this.ryf = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(51789);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            ad.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
            d.a(d.this).setVisibility(4);
            d.b(d.this).setMaxLines(2000);
            d.this.vRS = true;
            if (d.c(d.this) != null)
            {
              d.c(d.this).a(d.this.mKey, Boolean.TRUE);
              d.c(d.this).dmb();
            }
          }
          AppMethodBeat.o(51789);
          return false;
        }
      };
      this.vRR.setOnTouchListener(this.ryf);
    }
    if (this.vRW != null)
    {
      this.vRU = this.vRW.amD(this.mKey);
      if (this.vRU != null) {
        if (this.vRU.booleanValue())
        {
          this.vRR.setVisibility(8);
          this.uCm.setMaxLines(2000);
        }
      }
    }
    for (;;)
    {
      if (this.vRV == null)
      {
        this.vRV = new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(51790);
            ad.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + d.b(d.this).getHeight() + ", summaryTv.getLineHeight() = " + d.b(d.this).getLineHeight());
            if ((d.b(d.this).getText() != null) && (d.b(d.this).getHeight() > 0) && (d.b(d.this).getLineHeight() > 0) && (d.d(d.this) == null))
            {
              if ((d.b(d.this).getHeight() / d.b(d.this).getLineHeight() > 5) && (!d.this.vRT) && (!d.this.vRS))
              {
                d.a(d.this).setVisibility(0);
                d.b(d.this).setMaxLines(5);
                d.this.vRT = true;
                if ((d.c(d.this) != null) && (d.c(d.this).amD(d.this.mKey) == null))
                {
                  d.c(d.this).a(d.this.mKey, Boolean.FALSE);
                  d.c(d.this).dmb();
                }
              }
              ad.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + d.b(d.this).getHeight() / d.b(d.this).getLineHeight());
            }
            d.b(d.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            AppMethodBeat.o(51790);
          }
        };
        this.uCm.getViewTreeObserver().addOnGlobalLayoutListener(this.vRV);
      }
      if (!bt.isNullOrNil(this.mTitle)) {
        break;
      }
      this.titleTv.setVisibility(8);
      AppMethodBeat.o(51793);
      return;
      this.vRR.setVisibility(0);
      this.uCm.setMaxLines(5);
      continue;
      this.vRR.setVisibility(8);
      this.uCm.setMaxLines(6);
      continue;
      this.vRR.setVisibility(8);
      this.uCm.setMaxLines(6);
    }
    this.titleTv.setText(this.mTitle);
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(51793);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, Boolean paramBoolean);
    
    public abstract Boolean amD(String paramString);
    
    public abstract void dmb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.d
 * JD-Core Version:    0.7.0.1
 */