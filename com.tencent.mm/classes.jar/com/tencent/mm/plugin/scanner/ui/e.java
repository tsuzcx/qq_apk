package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.preference.Preference;

public final class e
  extends Preference
{
  private Context context;
  private TextView eXr;
  private View.OnTouchListener kFq;
  String mTitle;
  private View mView;
  private TextView mXQ;
  e.a nJA;
  private final int nJu = 5;
  private TextView nJv;
  public boolean nJw = false;
  public boolean nJx = false;
  private Boolean nJy;
  private ViewTreeObserver.OnGlobalLayoutListener nJz;
  
  public e(Activity paramActivity)
  {
    super(paramActivity);
    setLayoutResource(R.i.mm_preference_description_text);
    this.context = paramActivity;
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    return this.mView;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    if (this.eXr == null) {
      this.eXr = ((TextView)paramView.findViewById(16908310));
    }
    if (this.mXQ == null) {
      this.mXQ = ((TextView)paramView.findViewById(16908304));
    }
    if (this.nJv == null) {
      this.nJv = ((TextView)paramView.findViewById(R.h.more));
    }
    if (this.kFq == null)
    {
      this.kFq = new e.1(this);
      this.nJv.setOnTouchListener(this.kFq);
    }
    if (this.nJA != null)
    {
      this.nJy = this.nJA.LY(this.mKey);
      if (this.nJy != null) {
        if (this.nJy.booleanValue())
        {
          this.nJv.setVisibility(8);
          this.mXQ.setMaxLines(2000);
        }
      }
    }
    for (;;)
    {
      if (this.nJz == null)
      {
        this.nJz = new e.2(this);
        this.mXQ.getViewTreeObserver().addOnGlobalLayoutListener(this.nJz);
      }
      if (!bk.bl(this.mTitle)) {
        break;
      }
      this.eXr.setVisibility(8);
      return;
      this.nJv.setVisibility(0);
      this.mXQ.setMaxLines(5);
      continue;
      this.nJv.setVisibility(8);
      this.mXQ.setMaxLines(6);
      continue;
      this.nJv.setVisibility(8);
      this.mXQ.setMaxLines(6);
    }
    this.eXr.setText(this.mTitle);
    this.eXr.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.e
 * JD-Core Version:    0.7.0.1
 */