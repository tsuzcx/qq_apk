package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class k$1
  implements View.OnKeyListener
{
  k$1(k paramk) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(26831);
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 67))
    {
      if (c.din().size() == 0)
      {
        AppMethodBeat.o(26831);
        return false;
      }
      WXRTEditText localWXRTEditText = this.vzP.diT();
      if (localWXRTEditText == null)
      {
        AppMethodBeat.o(26831);
        return false;
      }
      paramInt = localWXRTEditText.getRecyclerItemPosition();
      ab.i("MicroMsg.Note.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramInt) });
      paramView = c.din().Lj(paramInt);
      if (paramView == null)
      {
        ab.w("MicroMsg.Note.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(26831);
        return false;
      }
      paramKeyEvent = c.din().Lj(paramInt - 1);
      if (paramKeyEvent == null)
      {
        ab.i("MicroMsg.Note.WXRTManager", "get preItem is null %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(26831);
        return false;
      }
      switch (localWXRTEditText.getEditTextType())
      {
      default: 
      case 0: 
        for (;;)
        {
          AppMethodBeat.o(26831);
          return true;
          ab.i("MicroMsg.Note.WXRTManager", "Handle Editor Type EDITTEXT");
          int i = localWXRTEditText.getSelectionStart();
          if (i != localWXRTEditText.getSelectionEnd())
          {
            AppMethodBeat.o(26831);
            return false;
          }
          if (i == localWXRTEditText.getParagraphsInSelection().akX)
          {
            localWXRTEditText.vze = true;
            this.vzP.b(u.vBE, Boolean.FALSE);
            this.vzP.b(u.vBF, Boolean.FALSE);
            this.vzP.b(u.vBD, Boolean.FALSE);
            k.a(this.vzP).oO(false);
            k.a(this.vzP).oP(false);
            k.a(this.vzP).oQ(false);
            localWXRTEditText.vze = false;
          }
          if ((i != 0) || (paramInt == 0))
          {
            AppMethodBeat.o(26831);
            return false;
          }
          paramView = localWXRTEditText.a(i.vzu);
          c.din().diq();
          if (paramKeyEvent.getType() != 1) {
            break;
          }
          bool = c.din().av(paramInt, true);
          paramKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramKeyEvent;
          i = paramKeyEvent.vxb.getText().toString().length();
          paramKeyEvent.content += paramView;
          paramKeyEvent.vwY = i;
          paramKeyEvent.vwW = true;
          paramKeyEvent.vxc = false;
          label450:
          if (!bool) {
            break label516;
          }
          k.b(this.vzP).djQ().Lc(paramInt - 1);
        }
        if (!bo.isNullOrNil(paramView)) {
          break;
        }
      }
    }
    for (boolean bool = c.din().av(paramInt, true);; bool = false)
    {
      paramKeyEvent.vxa.setSelection(0);
      paramKeyEvent.vwW = true;
      paramKeyEvent.vxc = false;
      break label450;
      label516:
      k.b(this.vzP).djQ().gT(paramInt - 1, 2);
      break;
      ab.i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
      c.din().diq();
      if (paramKeyEvent.getType() == 1)
      {
        paramKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramKeyEvent;
        if (bo.isNullOrNil(paramKeyEvent.content))
        {
          paramView.vwZ.setSelection(0);
          paramView.vwW = true;
          paramView.vxc = true;
          c.din().av(paramInt - 1, true);
          AppMethodBeat.o(26831);
          return true;
        }
        if (paramKeyEvent.content.endsWith("<br/>")) {
          paramKeyEvent.content = paramKeyEvent.content.substring(0, paramKeyEvent.content.length() - 5);
        }
        paramKeyEvent.vwY = -1;
        paramKeyEvent.vwW = true;
        paramKeyEvent.vxc = false;
      }
      for (;;)
      {
        k.b(this.vzP).djQ().gT(paramInt - 1, 2);
        break;
        paramKeyEvent.vxa.setSelection(0);
        paramKeyEvent.vwW = true;
        paramKeyEvent.vxc = false;
      }
      ab.i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
      if ((paramView.getType() == 4) && (((l)paramView).vxk.booleanValue()))
      {
        ab.i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
        AppMethodBeat.o(26831);
        return false;
      }
      if ((!paramView.vxd) && (paramView.getType() != -1))
      {
        c.din().aw(paramInt, true);
        AppMethodBeat.o(26831);
        return true;
      }
      c.din().diq();
      c.din().av(paramInt, false);
      k.b(this.vzP).djQ().Le(paramInt);
      paramView = new com.tencent.mm.plugin.wenote.model.a.i();
      paramView.vwW = true;
      paramView.vxc = false;
      paramView.content = "";
      paramView.vwY = 0;
      c.din().a(paramInt, paramView);
      c.din().gW(paramInt - 1, paramInt + 1);
      k.b(this.vzP).djO().bJ(paramInt);
      break;
      AppMethodBeat.o(26831);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.k.1
 * JD-Core Version:    0.7.0.1
 */