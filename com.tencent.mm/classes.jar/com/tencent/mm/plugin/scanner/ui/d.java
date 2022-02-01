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
  public boolean Bbh;
  private TextView GZI;
  private final int IPT;
  private TextView IPU;
  public boolean IPV;
  private Boolean IPW;
  private ViewTreeObserver.OnGlobalLayoutListener IPX;
  a IPY;
  private View.OnTouchListener aIw;
  private Context context;
  String mTitle;
  private View mView;
  private TextView titleTv;
  
  public d(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(51791);
    this.IPT = 5;
    this.IPV = false;
    this.Bbh = false;
    setLayoutResource(l.g.IEf);
    this.context = paramActivity;
    AppMethodBeat.o(51791);
  }
  
  public final View c(View paramView, ViewGroup paramViewGroup)
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
    if (this.GZI == null) {
      this.GZI = ((TextView)paramView.findViewById(16908304));
    }
    if (this.IPU == null) {
      this.IPU = ((TextView)paramView.findViewById(l.f.srX));
    }
    if (this.aIw == null)
    {
      this.aIw = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(51789);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            Log.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
            d.a(d.this).setVisibility(4);
            d.b(d.this).setMaxLines(2000);
            d.this.IPV = true;
            if (d.c(d.this) != null)
            {
              d.c(d.this).c(d.this.mKey, Boolean.TRUE);
              d.c(d.this).fDJ();
            }
          }
          AppMethodBeat.o(51789);
          return false;
        }
      };
      this.IPU.setOnTouchListener(this.aIw);
    }
    if (this.IPY != null)
    {
      this.IPW = this.IPY.aXo(this.mKey);
      if (this.IPW != null) {
        if (this.IPW.booleanValue())
        {
          this.IPU.setVisibility(8);
          this.GZI.setMaxLines(2000);
        }
      }
    }
    for (;;)
    {
      if (this.IPX == null)
      {
        this.IPX = new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(51790);
            Log.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + d.b(d.this).getHeight() + ", summaryTv.getLineHeight() = " + d.b(d.this).getLineHeight());
            if ((d.b(d.this).getText() != null) && (d.b(d.this).getHeight() > 0) && (d.b(d.this).getLineHeight() > 0) && (d.d(d.this) == null))
            {
              if ((d.b(d.this).getHeight() / d.b(d.this).getLineHeight() > 5) && (!d.this.Bbh) && (!d.this.IPV))
              {
                d.a(d.this).setVisibility(0);
                d.b(d.this).setMaxLines(5);
                d.this.Bbh = true;
                if ((d.c(d.this) != null) && (d.c(d.this).aXo(d.this.mKey) == null))
                {
                  d.c(d.this).c(d.this.mKey, Boolean.FALSE);
                  d.c(d.this).fDJ();
                }
              }
              Log.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + d.b(d.this).getHeight() / d.b(d.this).getLineHeight());
            }
            d.b(d.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            AppMethodBeat.o(51790);
          }
        };
        this.GZI.getViewTreeObserver().addOnGlobalLayoutListener(this.IPX);
      }
      if (!Util.isNullOrNil(this.mTitle)) {
        break;
      }
      this.titleTv.setVisibility(8);
      AppMethodBeat.o(51793);
      return;
      this.IPU.setVisibility(0);
      this.GZI.setMaxLines(5);
      continue;
      this.IPU.setVisibility(8);
      this.GZI.setMaxLines(6);
      continue;
      this.IPU.setVisibility(8);
      this.GZI.setMaxLines(6);
    }
    this.titleTv.setText(this.mTitle);
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(51793);
  }
  
  public static abstract interface a
  {
    public abstract Boolean aXo(String paramString);
    
    public abstract void c(String paramString, Boolean paramBoolean);
    
    public abstract void fDJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.d
 * JD-Core Version:    0.7.0.1
 */