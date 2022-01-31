package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class k$1
  implements View.OnKeyListener
{
  k$1(k paramk) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() != 0) || (paramKeyEvent.getKeyCode() != 67) || (c.chX().size() == 0)) {}
    WXRTEditText localWXRTEditText;
    do
    {
      return false;
      localWXRTEditText = this.rJk.ciC();
    } while (localWXRTEditText == null);
    paramInt = localWXRTEditText.getRecyclerItemPosition();
    y.i("MicroMsg.Note.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramInt) });
    paramView = c.chX().Dq(paramInt);
    if (paramView == null)
    {
      y.w("MicroMsg.Note.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramKeyEvent = c.chX().Dq(paramInt - 1);
    if (paramKeyEvent == null)
    {
      y.i("MicroMsg.Note.WXRTManager", "get preItem is null %d", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    switch (localWXRTEditText.getEditTextType())
    {
    default: 
    case 0: 
      for (;;)
      {
        return true;
        y.i("MicroMsg.Note.WXRTManager", "Handle Editor Type EDITTEXT");
        int i = localWXRTEditText.getSelectionStart();
        if (i != localWXRTEditText.getSelectionEnd()) {
          break;
        }
        if (i == localWXRTEditText.getParagraphsInSelection().aiH)
        {
          localWXRTEditText.rIy = true;
          this.rJk.b(u.rLa, Boolean.valueOf(false));
          this.rJk.b(u.rLb, Boolean.valueOf(false));
          this.rJk.b(u.rKZ, Boolean.valueOf(false));
          k.a(this.rJk).lD(false);
          k.a(this.rJk).lE(false);
          k.a(this.rJk).lF(false);
          localWXRTEditText.rIy = false;
        }
        if ((i != 0) || (paramInt == 0)) {
          break;
        }
        paramView = localWXRTEditText.a(i.rIO);
        c.chX().cia();
        if (paramKeyEvent.getType() != 1) {
          break label427;
        }
        bool = c.chX().ag(paramInt, true);
        paramKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramKeyEvent;
        i = paramKeyEvent.rGs.getText().toString().length();
        paramKeyEvent.content += paramView;
        paramKeyEvent.rGp = i;
        paramKeyEvent.rGn = true;
        paramKeyEvent.rGt = false;
        label399:
        if (!bool) {
          break label465;
        }
        k.b(this.rJk).cjp().Dj(paramInt - 1);
      }
      label427:
      if (!bk.bl(paramView)) {
        break;
      }
    }
    for (boolean bool = c.chX().ag(paramInt, true);; bool = false)
    {
      paramKeyEvent.rGr.setSelection(0);
      paramKeyEvent.rGn = true;
      paramKeyEvent.rGt = false;
      break label399;
      label465:
      k.b(this.rJk).cjp().eN(paramInt - 1, 2);
      break;
      y.i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
      c.chX().cia();
      if (paramKeyEvent.getType() == 1)
      {
        paramKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramKeyEvent;
        if (bk.bl(paramKeyEvent.content))
        {
          paramView.rGq.setSelection(0);
          paramView.rGn = true;
          paramView.rGt = true;
          c.chX().ag(paramInt - 1, true);
          return true;
        }
        if (paramKeyEvent.content.endsWith("<br/>")) {
          paramKeyEvent.content = paramKeyEvent.content.substring(0, paramKeyEvent.content.length() - 5);
        }
        paramKeyEvent.rGp = -1;
        paramKeyEvent.rGn = true;
        paramKeyEvent.rGt = false;
      }
      for (;;)
      {
        k.b(this.rJk).cjp().eN(paramInt - 1, 2);
        break;
        paramKeyEvent.rGr.setSelection(0);
        paramKeyEvent.rGn = true;
        paramKeyEvent.rGt = false;
      }
      y.i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
      if ((paramView.getType() == 4) && (((l)paramView).rGB.booleanValue()))
      {
        y.i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
        return false;
      }
      if ((!paramView.rGu) && (paramView.getType() != -1))
      {
        c.chX().ah(paramInt, true);
        return true;
      }
      c.chX().cia();
      c.chX().ag(paramInt, false);
      k.b(this.rJk).cjp().Dl(paramInt);
      paramView = new com.tencent.mm.plugin.wenote.model.a.i();
      paramView.rGn = true;
      paramView.rGt = false;
      paramView.content = "";
      paramView.rGp = 0;
      c.chX().a(paramInt, paramView);
      c.chX().eQ(paramInt - 1, paramInt + 1);
      k.b(this.rJk).cjn().bE(paramInt);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.k.1
 * JD-Core Version:    0.7.0.1
 */