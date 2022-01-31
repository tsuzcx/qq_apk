package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

final class MMAutoSwitchEditTextView$c
  implements MMAutoSwitchEditText.b, MMAutoSwitchEditText.c, MMAutoSwitchEditText.d
{
  private MMAutoSwitchEditTextView$c(MMAutoSwitchEditTextView paramMMAutoSwitchEditTextView) {}
  
  public final void OD(int paramInt)
  {
    AppMethodBeat.i(106499);
    if ((MMAutoSwitchEditTextView.a(this.ziY) != null) && (paramInt < MMAutoSwitchEditTextView.a(this.ziY).size()))
    {
      if (paramInt == 0)
      {
        AppMethodBeat.o(106499);
        return;
      }
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)MMAutoSwitchEditTextView.a(this.ziY).get(paramInt - 1);
      if (localMMAutoSwitchEditText != null) {
        localMMAutoSwitchEditText.requestFocus();
      }
    }
    AppMethodBeat.o(106499);
  }
  
  public final void OE(int paramInt)
  {
    AppMethodBeat.i(106498);
    Object localObject = "";
    Iterator localIterator = MMAutoSwitchEditTextView.a(this.ziY).iterator();
    if (localIterator.hasNext())
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
      if (bo.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
        break label226;
      }
      localObject = (String)localObject + localMMAutoSwitchEditText.getText().toString().trim();
    }
    label226:
    for (;;)
    {
      break;
      if ((!bo.isNullOrNil((String)localObject)) && (((String)localObject).length() == MMAutoSwitchEditTextView.b(this.ziY) * MMAutoSwitchEditTextView.c(this.ziY)))
      {
        if (MMAutoSwitchEditTextView.d(this.ziY) != null) {
          MMAutoSwitchEditTextView.d(this.ziY).xv((String)localObject);
        }
        AppMethodBeat.o(106498);
        return;
      }
      if (MMAutoSwitchEditTextView.e(this.ziY) != null) {
        MMAutoSwitchEditTextView.e(this.ziY).arh();
      }
      if ((MMAutoSwitchEditTextView.a(this.ziY) != null) && (paramInt < MMAutoSwitchEditTextView.a(this.ziY).size() - 1))
      {
        localObject = (MMAutoSwitchEditText)MMAutoSwitchEditTextView.a(this.ziY).get(paramInt + 1);
        if (localObject != null) {
          ((MMAutoSwitchEditText)localObject).requestFocus();
        }
      }
      AppMethodBeat.o(106498);
      return;
    }
  }
  
  public final void dDN()
  {
    AppMethodBeat.i(106500);
    String str = "";
    Iterator localIterator = MMAutoSwitchEditTextView.a(this.ziY).iterator();
    if (localIterator.hasNext())
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
      if (bo.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
        break label113;
      }
      str = str + localMMAutoSwitchEditText.getText().toString().trim();
    }
    label113:
    for (;;)
    {
      break;
      if (MMAutoSwitchEditTextView.e(this.ziY) != null) {
        MMAutoSwitchEditTextView.e(this.ziY).arh();
      }
      AppMethodBeat.o(106500);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditTextView.c
 * JD-Core Version:    0.7.0.1
 */