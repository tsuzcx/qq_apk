package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.t.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class m
  extends a
{
  private WXRTEditText QKw;
  
  public m(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30879);
    this.QKw = ((WXRTEditText)paramView.findViewById(R.h.dTc));
    if ((paramk.QHZ != 2) || (!this.QIM.QIa))
    {
      this.QKw.setKeyListener(null);
      this.QKw.setFocusable(false);
      this.QKw.setClickable(true);
    }
    this.QKw.utn = this;
    this.QKw.setEditTextType(0);
    this.QIM.q(this.QKw);
    this.QKw.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30876);
        bh.aHJ().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30875);
            m.a(m.this).hasFocus();
            AppMethodBeat.o(30875);
          }
        });
        AppMethodBeat.o(30876);
      }
    });
    AppMethodBeat.o(30879);
  }
  
  public final void a(final com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    paramInt2 = -1;
    AppMethodBeat.i(30880);
    this.QKw.setPosInDataList(paramInt1);
    final com.tencent.mm.plugin.wenote.model.a.i locali = (com.tencent.mm.plugin.wenote.model.a.i)paramc;
    locali.QHd = this.QKw;
    locali.QHb = null;
    locali.QHc = null;
    paramc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(paramInt1 - 1);
    if ((paramc != null) && (paramc.getType() == 1))
    {
      paramc = (LinearLayout.LayoutParams)this.QKw.getLayoutParams();
      paramc.topMargin = 0;
      this.QKw.setLayoutParams(paramc);
    }
    paramc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(paramInt1 + 1);
    if ((paramc != null) && (paramc.getType() == 1))
    {
      paramc = (LinearLayout.LayoutParams)this.QKw.getLayoutParams();
      paramc.bottomMargin = 0;
      this.QKw.setLayoutParams(paramc);
    }
    switch (this.QIM.QHZ)
    {
    case 3: 
    default: 
      paramc = null;
      if ((this.QIM.QHZ != 2) || (!this.QIM.QIa))
      {
        this.QKw.setRichTextEditing(locali.content);
        l.b(this.QKw, paramc, l.Rsm);
      }
      break;
    }
    for (;;)
    {
      Log.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + mc());
      AppMethodBeat.o(30880);
      return;
      paramc = t.b.Rtu;
      paramInt1 = paramInt2;
      for (;;)
      {
        paramc = paramc.aqS(paramInt1);
        break;
        paramc = t.b.Rtx;
        paramInt1 = paramInt2;
        continue;
        bh.beI();
        String str = com.tencent.mm.model.c.bbO().Oq(this.QIM.msgId).field_talker;
        if (this.QIM.QHP)
        {
          paramc = t.b.Rtw;
          if (str == null) {}
          for (paramInt1 = -1;; paramInt1 = com.tencent.mm.modelappbrand.a.SF(str))
          {
            paramc = paramc.aqS(paramInt1);
            break;
          }
        }
        t.b localb = t.b.Rtv;
        paramc = localb;
        paramInt1 = paramInt2;
        if (str != null)
        {
          paramInt1 = com.tencent.mm.modelappbrand.a.SF(str);
          paramc = localb;
        }
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30878);
          m.a(m.this).setRichTextEditing(locali.content);
          m.a(m.this).cSm();
          m.a(m.this).cSo();
          l.b(m.a(m.this), paramc, l.Rsm);
          m.a(m.this).cSp();
          m.a(m.this).cSn();
          if (locali.urG) {
            if ((locali.urI != -1) && (locali.urI < m.a(m.this).getText().toString().length()))
            {
              m.a(m.this).setSelection(locali.urI);
              m.a(m.this).requestFocus();
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(30877);
                  if (m.2.this.QKz.urP != 0)
                  {
                    int i = m.a(m.this).getSelection().tH;
                    if (i == m.2.this.QKz.content.length())
                    {
                      m.a(m.this).cSm();
                      m.a(m.this).getText().append("\n");
                      m.a(m.this).cSn();
                      m.a(m.this).setSelection(i);
                    }
                    m.2.this.QKz.urP = 0;
                    if (m.2.this.QKz.urQ == 1)
                    {
                      m.a(m.this).a(u.QIB, Boolean.TRUE);
                      AppMethodBeat.o(30877);
                      return;
                    }
                    if (m.2.this.QKz.urQ == 3)
                    {
                      m.a(m.this).a(u.QIA, Boolean.TRUE);
                      AppMethodBeat.o(30877);
                      return;
                    }
                    if (m.2.this.QKz.urQ == 2) {
                      m.a(m.this).a(u.QIC, Boolean.TRUE);
                    }
                  }
                  AppMethodBeat.o(30877);
                }
              }, 500L);
            }
          }
          for (;;)
          {
            if (locali.urO)
            {
              locali.urO = false;
              m.a(m.this).urO = true;
              m.a(m.this).onTextContextMenuItem(16908322);
            }
            AppMethodBeat.o(30878);
            return;
            m.a(m.this).setSelection(m.a(m.this).getText().toString().length());
            break;
            if (m.a(m.this).hasFocus()) {
              m.a(m.this).clearFocus();
            }
          }
        }
      });
    }
  }
  
  public final int cRD()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.m
 * JD-Core Version:    0.7.0.1
 */