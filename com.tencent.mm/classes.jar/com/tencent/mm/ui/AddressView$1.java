package com.tencent.mm.ui;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

final class AddressView$1
  extends android.support.v4.view.a
{
  AddressView$1(AddressView paramAddressView) {}
  
  public final void a(View paramView, android.support.v4.view.a.a parama)
  {
    super.a(paramView, parama);
    CharSequence localCharSequence = this.uGv.getContentDescription();
    paramView = localCharSequence;
    if (bk.bl((String)localCharSequence)) {
      paramView = this.uGv.nickName;
    }
    parama.setText(paramView);
  }
  
  public final void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    CharSequence localCharSequence = this.uGv.getContentDescription();
    paramView = localCharSequence;
    if (bk.bl((String)localCharSequence)) {
      paramView = this.uGv.nickName;
    }
    paramAccessibilityEvent.getText().add(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.AddressView.1
 * JD-Core Version:    0.7.0.1
 */