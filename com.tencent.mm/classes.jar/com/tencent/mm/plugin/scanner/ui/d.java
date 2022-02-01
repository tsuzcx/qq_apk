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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public final class d
  extends Preference
{
  private TextView BfZ;
  private final int CKr;
  private TextView CKs;
  public boolean CKt;
  public boolean CKu;
  private Boolean CKv;
  private ViewTreeObserver.OnGlobalLayoutListener CKw;
  a CKx;
  private View.OnTouchListener aZa;
  private Context context;
  String mTitle;
  private View mView;
  private TextView titleTv;
  
  public d(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(51791);
    this.CKr = 5;
    this.CKt = false;
    this.CKu = false;
    setLayoutResource(2131495587);
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
    if (this.BfZ == null) {
      this.BfZ = ((TextView)paramView.findViewById(16908304));
    }
    if (this.CKs == null) {
      this.CKs = ((TextView)paramView.findViewById(2131304855));
    }
    if (this.aZa == null)
    {
      this.aZa = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(51789);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            Log.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
            d.a(d.this).setVisibility(4);
            d.b(d.this).setMaxLines(2000);
            d.this.CKt = true;
            if (d.c(d.this) != null)
            {
              d.c(d.this).b(d.this.mKey, Boolean.TRUE);
              d.c(d.this).eQI();
            }
          }
          AppMethodBeat.o(51789);
          return false;
        }
      };
      this.CKs.setOnTouchListener(this.aZa);
    }
    if (this.CKx != null)
    {
      this.CKv = this.CKx.aMH(this.mKey);
      if (this.CKv != null) {
        if (this.CKv.booleanValue())
        {
          this.CKs.setVisibility(8);
          this.BfZ.setMaxLines(2000);
        }
      }
    }
    for (;;)
    {
      if (this.CKw == null)
      {
        this.CKw = new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(51790);
            Log.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + d.b(d.this).getHeight() + ", summaryTv.getLineHeight() = " + d.b(d.this).getLineHeight());
            if ((d.b(d.this).getText() != null) && (d.b(d.this).getHeight() > 0) && (d.b(d.this).getLineHeight() > 0) && (d.d(d.this) == null))
            {
              if ((d.b(d.this).getHeight() / d.b(d.this).getLineHeight() > 5) && (!d.this.CKu) && (!d.this.CKt))
              {
                d.a(d.this).setVisibility(0);
                d.b(d.this).setMaxLines(5);
                d.this.CKu = true;
                if ((d.c(d.this) != null) && (d.c(d.this).aMH(d.this.mKey) == null))
                {
                  d.c(d.this).b(d.this.mKey, Boolean.FALSE);
                  d.c(d.this).eQI();
                }
              }
              Log.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + d.b(d.this).getHeight() / d.b(d.this).getLineHeight());
            }
            d.b(d.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            AppMethodBeat.o(51790);
          }
        };
        this.BfZ.getViewTreeObserver().addOnGlobalLayoutListener(this.CKw);
      }
      if (!Util.isNullOrNil(this.mTitle)) {
        break;
      }
      this.titleTv.setVisibility(8);
      AppMethodBeat.o(51793);
      return;
      this.CKs.setVisibility(0);
      this.BfZ.setMaxLines(5);
      continue;
      this.CKs.setVisibility(8);
      this.BfZ.setMaxLines(6);
      continue;
      this.CKs.setVisibility(8);
      this.BfZ.setMaxLines(6);
    }
    this.titleTv.setText(this.mTitle);
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(51793);
  }
  
  public static abstract interface a
  {
    public abstract Boolean aMH(String paramString);
    
    public abstract void b(String paramString, Boolean paramBoolean);
    
    public abstract void eQI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.d
 * JD-Core Version:    0.7.0.1
 */