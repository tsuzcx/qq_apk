package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Iterator;

final class MMAutoSwitchEditTextView$c
  implements MMAutoSwitchEditText.b, MMAutoSwitchEditText.c, MMAutoSwitchEditText.d
{
  private MMAutoSwitchEditTextView$c(MMAutoSwitchEditTextView paramMMAutoSwitchEditTextView) {}
  
  public final void Gm(int paramInt)
  {
    if ((MMAutoSwitchEditTextView.a(this.uUx) == null) || (paramInt >= MMAutoSwitchEditTextView.a(this.uUx).size()) || (paramInt == 0)) {}
    MMAutoSwitchEditText localMMAutoSwitchEditText;
    do
    {
      return;
      localMMAutoSwitchEditText = (MMAutoSwitchEditText)MMAutoSwitchEditTextView.a(this.uUx).get(paramInt - 1);
    } while (localMMAutoSwitchEditText == null);
    localMMAutoSwitchEditText.requestFocus();
  }
  
  public final void Gn(int paramInt)
  {
    Object localObject = "";
    Iterator localIterator = MMAutoSwitchEditTextView.a(this.uUx).iterator();
    if (localIterator.hasNext())
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
      if (bk.bl(localMMAutoSwitchEditText.getText().toString().trim())) {
        break label211;
      }
      localObject = (String)localObject + localMMAutoSwitchEditText.getText().toString().trim();
    }
    label211:
    for (;;)
    {
      break;
      if ((!bk.bl((String)localObject)) && (((String)localObject).length() == MMAutoSwitchEditTextView.b(this.uUx) * MMAutoSwitchEditTextView.c(this.uUx))) {
        if (MMAutoSwitchEditTextView.d(this.uUx) != null) {
          MMAutoSwitchEditTextView.d(this.uUx).pZ((String)localObject);
        }
      }
      do
      {
        do
        {
          return;
          if (MMAutoSwitchEditTextView.e(this.uUx) != null) {
            MMAutoSwitchEditTextView.e(this.uUx).XE();
          }
        } while ((MMAutoSwitchEditTextView.a(this.uUx) == null) || (paramInt >= MMAutoSwitchEditTextView.a(this.uUx).size() - 1));
        localObject = (MMAutoSwitchEditText)MMAutoSwitchEditTextView.a(this.uUx).get(paramInt + 1);
      } while (localObject == null);
      ((MMAutoSwitchEditText)localObject).requestFocus();
      return;
    }
  }
  
  public final void cAC()
  {
    String str = "";
    Iterator localIterator = MMAutoSwitchEditTextView.a(this.uUx).iterator();
    if (localIterator.hasNext())
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
      if (bk.bl(localMMAutoSwitchEditText.getText().toString().trim())) {
        break label103;
      }
      str = str + localMMAutoSwitchEditText.getText().toString().trim();
    }
    label103:
    for (;;)
    {
      break;
      if (MMAutoSwitchEditTextView.e(this.uUx) != null) {
        MMAutoSwitchEditTextView.e(this.uUx).XE();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditTextView.c
 * JD-Core Version:    0.7.0.1
 */