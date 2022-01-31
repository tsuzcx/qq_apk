package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public final class e
  extends Preference
{
  private Context context;
  String mTitle;
  private View mView;
  private View.OnTouchListener ncf;
  private TextView pAD;
  private final int qwW;
  private TextView qwX;
  public boolean qwY;
  public boolean qwZ;
  private Boolean qxa;
  private ViewTreeObserver.OnGlobalLayoutListener qxb;
  e.a qxc;
  private TextView titleTv;
  
  public e(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(81020);
    this.qwW = 5;
    this.qwY = false;
    this.qwZ = false;
    setLayoutResource(2130970225);
    this.context = paramActivity;
    AppMethodBeat.o(81020);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(81021);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(81021);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(81022);
    super.onBindView(paramView);
    if (this.titleTv == null) {
      this.titleTv = ((TextView)paramView.findViewById(16908310));
    }
    if (this.pAD == null) {
      this.pAD = ((TextView)paramView.findViewById(16908304));
    }
    if (this.qwX == null) {
      this.qwX = ((TextView)paramView.findViewById(2131826233));
    }
    if (this.ncf == null)
    {
      this.ncf = new e.1(this);
      this.qwX.setOnTouchListener(this.ncf);
    }
    if (this.qxc != null)
    {
      this.qxa = this.qxc.YA(this.mKey);
      if (this.qxa != null) {
        if (this.qxa.booleanValue())
        {
          this.qwX.setVisibility(8);
          this.pAD.setMaxLines(2000);
        }
      }
    }
    for (;;)
    {
      if (this.qxb == null)
      {
        this.qxb = new e.2(this);
        this.pAD.getViewTreeObserver().addOnGlobalLayoutListener(this.qxb);
      }
      if (!bo.isNullOrNil(this.mTitle)) {
        break;
      }
      this.titleTv.setVisibility(8);
      AppMethodBeat.o(81022);
      return;
      this.qwX.setVisibility(0);
      this.pAD.setMaxLines(5);
      continue;
      this.qwX.setVisibility(8);
      this.pAD.setMaxLines(6);
      continue;
      this.qwX.setVisibility(8);
      this.pAD.setMaxLines(6);
    }
    this.titleTv.setText(this.mTitle);
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(81022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.e
 * JD-Core Version:    0.7.0.1
 */