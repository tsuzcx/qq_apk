package com.tencent.mm.ui.base;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.LinkedList;

final class MMTagPanel$1
  implements View.OnKeyListener
{
  MMTagPanel$1(MMTagPanel paramMMTagPanel) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (67 == paramInt))
    {
      y.d("MicroMsg.MMTagPanel", "on del click, selection[%d, %d]", new Object[] { Integer.valueOf(MMTagPanel.a(this.uYn).getSelectionStart()), Integer.valueOf(MMTagPanel.a(this.uYn).getSelectionEnd()) });
      if ((MMTagPanel.a(this.uYn).getSelectionStart() != 0) || (MMTagPanel.a(this.uYn).getSelectionStart() != MMTagPanel.a(this.uYn).getSelectionEnd())) {
        break label100;
      }
      paramInt = 1;
      if (paramInt != 0) {
        break label105;
      }
    }
    label100:
    label105:
    do
    {
      return false;
      paramInt = 0;
      break;
      this.uYn.aSc();
    } while ((MMTagPanel.b(this.uYn) == null) || (MMTagPanel.b(this.uYn).isEmpty()));
    if ((!MMTagPanel.c(this.uYn)) && (MMTagPanel.d(this.uYn) == null))
    {
      MMTagPanel.a(this.uYn, (MMTagPanel.d)MMTagPanel.b(this.uYn).getLast());
      this.uYn.a(MMTagPanel.d(this.uYn).uYz, false, true);
      MMTagPanel.a(this.uYn).setCursorVisible(false);
      return false;
    }
    if ((MMTagPanel.d(this.uYn) != null) && (MMTagPanel.b(this.uYn) != null) && (MMTagPanel.b(this.uYn).getLast() != null) && (!bk.bl(MMTagPanel.d(this.uYn).uYy)) && (!bk.bl(((MMTagPanel.d)MMTagPanel.b(this.uYn).getLast()).uYy)) && (!MMTagPanel.d(this.uYn).uYy.equals(((MMTagPanel.d)MMTagPanel.b(this.uYn).getLast()).uYy)))
    {
      y.i("MicroMsg.MMTagPanel", "change hight");
      this.uYn.cBd();
      MMTagPanel.a(this.uYn, (MMTagPanel.d)MMTagPanel.b(this.uYn).getLast());
      this.uYn.a(MMTagPanel.d(this.uYn).uYz, false, true);
      MMTagPanel.a(this.uYn).setCursorVisible(false);
      return false;
    }
    paramView = ((MMTagPanel.d)MMTagPanel.b(this.uYn).getLast()).uYy;
    this.uYn.removeTag(paramView);
    if (MMTagPanel.e(this.uYn) != null) {
      MMTagPanel.e(this.uYn).Be(paramView);
    }
    this.uYn.cBd();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.1
 * JD-Core Version:    0.7.0.1
 */