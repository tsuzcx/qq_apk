package com.tencent.mm.ui.base;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.LinkedList;

final class MMTagPanel$1
  implements View.OnKeyListener
{
  MMTagPanel$1(MMTagPanel paramMMTagPanel) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106810);
    if ((paramKeyEvent.getAction() == 0) && (67 == paramInt))
    {
      ab.d("MicroMsg.MMTagPanel", "on del click, selection[%d, %d]", new Object[] { Integer.valueOf(MMTagPanel.a(this.zmE).getSelectionStart()), Integer.valueOf(MMTagPanel.a(this.zmE).getSelectionEnd()) });
      if ((MMTagPanel.a(this.zmE).getSelectionStart() == 0) && (MMTagPanel.a(this.zmE).getSelectionStart() == MMTagPanel.a(this.zmE).getSelectionEnd())) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0)
      {
        AppMethodBeat.o(106810);
        return false;
      }
      this.zmE.byt();
      if ((MMTagPanel.b(this.zmE) == null) || (MMTagPanel.b(this.zmE).isEmpty()))
      {
        AppMethodBeat.o(106810);
        return false;
      }
      if ((MMTagPanel.c(this.zmE)) || (MMTagPanel.d(this.zmE) != null)) {
        break label230;
      }
      MMTagPanel.a(this.zmE, (MMTagPanel.d)MMTagPanel.b(this.zmE).getLast());
      this.zmE.a(MMTagPanel.d(this.zmE).zmP, false, true);
      MMTagPanel.a(this.zmE).setCursorVisible(false);
    }
    for (;;)
    {
      AppMethodBeat.o(106810);
      return false;
      label230:
      if ((MMTagPanel.d(this.zmE) != null) && (MMTagPanel.b(this.zmE) != null) && (MMTagPanel.b(this.zmE).getLast() != null) && (!bo.isNullOrNil(MMTagPanel.d(this.zmE).zmO)) && (!bo.isNullOrNil(((MMTagPanel.d)MMTagPanel.b(this.zmE).getLast()).zmO)) && (!MMTagPanel.d(this.zmE).zmO.equals(((MMTagPanel.d)MMTagPanel.b(this.zmE).getLast()).zmO)))
      {
        ab.i("MicroMsg.MMTagPanel", "change hight");
        this.zmE.dEq();
        MMTagPanel.a(this.zmE, (MMTagPanel.d)MMTagPanel.b(this.zmE).getLast());
        this.zmE.a(MMTagPanel.d(this.zmE).zmP, false, true);
        MMTagPanel.a(this.zmE).setCursorVisible(false);
      }
      else
      {
        paramView = ((MMTagPanel.d)MMTagPanel.b(this.zmE).getLast()).zmO;
        this.zmE.removeTag(paramView);
        if (MMTagPanel.e(this.zmE) != null) {
          MMTagPanel.e(this.zmE).Lg(paramView);
        }
        this.zmE.dEq();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.1
 * JD-Core Version:    0.7.0.1
 */