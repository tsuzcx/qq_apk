package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.text.Editable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

public final class m
  extends a
{
  private WXRTEditText EVk;
  
  public m(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30879);
    this.EVk = ((WXRTEditText)paramView.findViewById(2131304265));
    if ((paramk.EST != 2) || (!this.ETB.ESU))
    {
      this.EVk.setKeyListener(null);
      this.EVk.setFocusable(false);
      this.EVk.setClickable(true);
    }
    this.EVk.pBP = this;
    this.EVk.setEditTextType(0);
    this.ETB.q(this.EVk);
    this.EVk.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30876);
        bc.ajU().aw(new Runnable()
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
    this.EVk.setPosInDataList(paramInt1);
    paramc = (i)paramc;
    paramc.ERY = this.EVk;
    paramc.ERW = null;
    paramc.ERX = null;
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().YE(paramInt1 - 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.EVk.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.EVk.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().YE(paramInt1 + 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.EVk.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      this.EVk.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((this.ETB.EST != 2) || (!this.ETB.ESU))
    {
      this.EVk.setRichTextEditing(paramc.content);
      com.tencent.mm.pluginsdk.ui.span.k.t(this.EVk);
    }
    for (;;)
    {
      ae.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + lM());
      AppMethodBeat.o(30880);
      return;
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30878);
          m.a(m.this).setRichTextEditing(paramc.content);
          m.a(m.this).cfR();
          m.a(m.this).cfT();
          com.tencent.mm.pluginsdk.ui.span.k.t(m.a(m.this));
          m.a(m.this).cfU();
          m.a(m.this).cfS();
          if (paramc.pAj) {
            if ((paramc.pAl != -1) && (paramc.pAl < m.a(m.this).getText().toString().length()))
            {
              m.a(m.this).setSelection(paramc.pAl);
              m.a(m.this).requestFocus();
              ar.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(30877);
                  if (m.2.this.EVn.pAs != 0)
                  {
                    int i = m.a(m.this).getSelection().avj;
                    if (i == m.2.this.EVn.content.length())
                    {
                      m.a(m.this).cfR();
                      m.a(m.this).getText().append("\n");
                      m.a(m.this).cfS();
                      m.a(m.this).setSelection(i);
                    }
                    m.2.this.EVn.pAs = 0;
                    if (m.2.this.EVn.pAt == 1)
                    {
                      m.a(m.this).a(u.ETv, Boolean.TRUE);
                      AppMethodBeat.o(30877);
                      return;
                    }
                    if (m.2.this.EVn.pAt == 3)
                    {
                      m.a(m.this).a(u.ETu, Boolean.TRUE);
                      AppMethodBeat.o(30877);
                      return;
                    }
                    if (m.2.this.EVn.pAt == 2) {
                      m.a(m.this).a(u.ETw, Boolean.TRUE);
                    }
                  }
                  AppMethodBeat.o(30877);
                }
              }, 500L);
            }
          }
          for (;;)
          {
            if (paramc.pAr)
            {
              paramc.pAr = false;
              m.a(m.this).pAr = true;
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
  
  public final int cfi()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.m
 * JD-Core Version:    0.7.0.1
 */