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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;

public final class d
  extends Preference
{
  private Context context;
  String mTitle;
  private View mView;
  private View.OnTouchListener tDQ;
  private TextView titleTv;
  private TextView wSo;
  private final int yqD;
  private TextView yqE;
  public boolean yqF;
  public boolean yqG;
  private Boolean yqH;
  private ViewTreeObserver.OnGlobalLayoutListener yqI;
  a yqJ;
  
  public d(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(51791);
    this.yqD = 5;
    this.yqF = false;
    this.yqG = false;
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
    if (this.wSo == null) {
      this.wSo = ((TextView)paramView.findViewById(16908304));
    }
    if (this.yqE == null) {
      this.yqE = ((TextView)paramView.findViewById(2131302452));
    }
    if (this.tDQ == null)
    {
      this.tDQ = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(51789);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          a.b("com/tencent/mm/plugin/scanner/ui/DescriptionTextPreference$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            ad.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
            d.a(d.this).setVisibility(4);
            d.b(d.this).setMaxLines(2000);
            d.this.yqF = true;
            if (d.c(d.this) != null)
            {
              d.c(d.this).a(d.this.mKey, Boolean.TRUE);
              d.c(d.this).dLF();
            }
          }
          a.a(false, this, "com/tencent/mm/plugin/scanner/ui/DescriptionTextPreference$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(51789);
          return false;
        }
      };
      this.yqE.setOnTouchListener(this.tDQ);
    }
    if (this.yqJ != null)
    {
      this.yqH = this.yqJ.awN(this.mKey);
      if (this.yqH != null) {
        if (this.yqH.booleanValue())
        {
          this.yqE.setVisibility(8);
          this.wSo.setMaxLines(2000);
        }
      }
    }
    for (;;)
    {
      if (this.yqI == null)
      {
        this.yqI = new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(51790);
            ad.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + d.b(d.this).getHeight() + ", summaryTv.getLineHeight() = " + d.b(d.this).getLineHeight());
            if ((d.b(d.this).getText() != null) && (d.b(d.this).getHeight() > 0) && (d.b(d.this).getLineHeight() > 0) && (d.d(d.this) == null))
            {
              if ((d.b(d.this).getHeight() / d.b(d.this).getLineHeight() > 5) && (!d.this.yqG) && (!d.this.yqF))
              {
                d.a(d.this).setVisibility(0);
                d.b(d.this).setMaxLines(5);
                d.this.yqG = true;
                if ((d.c(d.this) != null) && (d.c(d.this).awN(d.this.mKey) == null))
                {
                  d.c(d.this).a(d.this.mKey, Boolean.FALSE);
                  d.c(d.this).dLF();
                }
              }
              ad.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + d.b(d.this).getHeight() / d.b(d.this).getLineHeight());
            }
            d.b(d.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            AppMethodBeat.o(51790);
          }
        };
        this.wSo.getViewTreeObserver().addOnGlobalLayoutListener(this.yqI);
      }
      if (!bt.isNullOrNil(this.mTitle)) {
        break;
      }
      this.titleTv.setVisibility(8);
      AppMethodBeat.o(51793);
      return;
      this.yqE.setVisibility(0);
      this.wSo.setMaxLines(5);
      continue;
      this.yqE.setVisibility(8);
      this.wSo.setMaxLines(6);
      continue;
      this.yqE.setVisibility(8);
      this.wSo.setMaxLines(6);
    }
    this.titleTv.setText(this.mTitle);
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(51793);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, Boolean paramBoolean);
    
    public abstract Boolean awN(String paramString);
    
    public abstract void dLF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.d
 * JD-Core Version:    0.7.0.1
 */