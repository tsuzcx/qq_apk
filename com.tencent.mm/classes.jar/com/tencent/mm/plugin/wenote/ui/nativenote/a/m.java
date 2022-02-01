package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.wenote.model.a.i;
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
  private WXRTEditText JLd;
  
  public m(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30879);
    this.JLd = ((WXRTEditText)paramView.findViewById(2131307188));
    if ((paramk.JIH != 2) || (!this.JJu.JII))
    {
      this.JLd.setKeyListener(null);
      this.JLd.setFocusable(false);
      this.JLd.setClickable(true);
    }
    this.JLd.qRh = this;
    this.JLd.setEditTextType(0);
    this.JJu.q(this.JLd);
    this.JLd.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30876);
        bg.aAk().postToWorker(new Runnable()
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
    AppMethodBeat.i(30880);
    this.JLd.setPosInDataList(paramInt1);
    final i locali = (i)paramc;
    locali.JHL = this.JLd;
    locali.JHJ = null;
    locali.JHK = null;
    paramc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(paramInt1 - 1);
    if ((paramc != null) && (paramc.getType() == 1))
    {
      paramc = (LinearLayout.LayoutParams)this.JLd.getLayoutParams();
      paramc.topMargin = 0;
      this.JLd.setLayoutParams(paramc);
    }
    paramc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(paramInt1 + 1);
    if ((paramc != null) && (paramc.getType() == 1))
    {
      paramc = (LinearLayout.LayoutParams)this.JLd.getLayoutParams();
      paramc.bottomMargin = 0;
      this.JLd.setLayoutParams(paramc);
    }
    switch (this.JJu.JIH)
    {
    case 3: 
    default: 
      paramc = null;
      if ((this.JJu.JIH != 2) || (!this.JJu.JII))
      {
        this.JLd.setRichTextEditing(locali.content);
        l.b(this.JLd, paramc, l.Krf);
      }
      break;
    }
    for (;;)
    {
      Log.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + lQ());
      AppMethodBeat.o(30880);
      return;
      paramc = t.b.Ksn.grZ();
      break;
      paramc = t.b.Ksq.grZ();
      break;
      if (this.JJu.JIx)
      {
        paramc = t.b.Ksp.grZ();
        break;
      }
      paramc = t.b.Kso.grZ();
      break;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30878);
          m.a(m.this).setRichTextEditing(locali.content);
          m.a(m.this).cDH();
          m.a(m.this).cDJ();
          l.b(m.a(m.this), paramc, l.Krf);
          m.a(m.this).cDK();
          m.a(m.this).cDI();
          if (locali.qPA) {
            if ((locali.qPC != -1) && (locali.qPC < m.a(m.this).getText().toString().length()))
            {
              m.a(m.this).setSelection(locali.qPC);
              m.a(m.this).requestFocus();
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(30877);
                  if (m.2.this.JLg.qPJ != 0)
                  {
                    int i = m.a(m.this).getSelection().avh;
                    if (i == m.2.this.JLg.content.length())
                    {
                      m.a(m.this).cDH();
                      m.a(m.this).getText().append("\n");
                      m.a(m.this).cDI();
                      m.a(m.this).setSelection(i);
                    }
                    m.2.this.JLg.qPJ = 0;
                    if (m.2.this.JLg.qPK == 1)
                    {
                      m.a(m.this).a(u.JJj, Boolean.TRUE);
                      AppMethodBeat.o(30877);
                      return;
                    }
                    if (m.2.this.JLg.qPK == 3)
                    {
                      m.a(m.this).a(u.JJi, Boolean.TRUE);
                      AppMethodBeat.o(30877);
                      return;
                    }
                    if (m.2.this.JLg.qPK == 2) {
                      m.a(m.this).a(u.JJk, Boolean.TRUE);
                    }
                  }
                  AppMethodBeat.o(30877);
                }
              }, 500L);
            }
          }
          for (;;)
          {
            if (locali.qPI)
            {
              locali.qPI = false;
              m.a(m.this).qPI = true;
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
  
  public final int cCY()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.m
 * JD-Core Version:    0.7.0.1
 */