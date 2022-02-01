package com.tenpay.android.wechat;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

class TenpaySecureEditText$5
  implements View.OnTouchListener
{
  private byte _hellAccFlag_;
  
  TenpaySecureEditText$5(TenpaySecureEditText paramTenpaySecureEditText) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199373);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tenpay/android/wechat/TenpaySecureEditText$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    a.a(false, this, "com/tenpay/android/wechat/TenpaySecureEditText$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(199373);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tenpay.android.wechat.TenpaySecureEditText.5
 * JD-Core Version:    0.7.0.1
 */