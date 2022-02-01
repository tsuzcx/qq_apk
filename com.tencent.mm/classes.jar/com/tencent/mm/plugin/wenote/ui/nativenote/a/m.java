package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.text.Editable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class m
  extends a
{
  private WXRTEditText BGL;
  
  public m(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30879);
    this.BGL = ((WXRTEditText)paramView.findViewById(2131304265));
    if ((paramk.BEu != 2) || (!this.BFc.BEv))
    {
      this.BGL.setKeyListener(null);
      this.BGL.setFocusable(false);
      this.BGL.setClickable(true);
    }
    this.BGL.oob = this;
    this.BGL.setEditTextType(0);
    this.BFc.q(this.BGL);
    this.BGL.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30876);
        az.afE().ax(new Runnable()
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
    this.BGL.setPosInDataList(paramInt1);
    paramc = (i)paramc;
    paramc.BDz = this.BGL;
    paramc.BDx = null;
    paramc.BDy = null;
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(paramInt1 - 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.BGL.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.BGL.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(paramInt1 + 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.BGL.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      this.BGL.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((this.BFc.BEu != 2) || (!this.BFc.BEv))
    {
      this.BGL.setRichTextEditing(paramc.content);
      com.tencent.mm.pluginsdk.ui.span.k.v(this.BGL);
    }
    for (;;)
    {
      ad.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + lm());
      AppMethodBeat.o(30880);
      return;
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30878);
          m.a(m.this).setRichTextEditing(paramc.content);
          m.a(m.this).bSJ();
          m.a(m.this).bSL();
          com.tencent.mm.pluginsdk.ui.span.k.v(m.a(m.this));
          m.a(m.this).bSM();
          m.a(m.this).bSK();
          if (paramc.omv) {
            if ((paramc.omx != -1) && (paramc.omx < m.a(m.this).getText().toString().length()))
            {
              m.a(m.this).setSelection(paramc.omx);
              m.a(m.this).requestFocus();
              aq.n(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(30877);
                  if (m.2.this.BGO.omE != 0)
                  {
                    int i = m.a(m.this).getSelection().asw;
                    if (i == m.2.this.BGO.content.length())
                    {
                      m.a(m.this).bSJ();
                      m.a(m.this).getText().append("\n");
                      m.a(m.this).bSK();
                      m.a(m.this).setSelection(i);
                    }
                    m.2.this.BGO.omE = 0;
                    if (m.2.this.BGO.omF == 1)
                    {
                      m.a(m.this).a(u.BEW, Boolean.TRUE);
                      AppMethodBeat.o(30877);
                      return;
                    }
                    if (m.2.this.BGO.omF == 3)
                    {
                      m.a(m.this).a(u.BEV, Boolean.TRUE);
                      AppMethodBeat.o(30877);
                      return;
                    }
                    if (m.2.this.BGO.omF == 2) {
                      m.a(m.this).a(u.BEX, Boolean.TRUE);
                    }
                  }
                  AppMethodBeat.o(30877);
                }
              }, 500L);
            }
          }
          for (;;)
          {
            if (paramc.omD)
            {
              paramc.omD = false;
              m.a(m.this).omD = true;
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
  
  public final int bSa()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.m
 * JD-Core Version:    0.7.0.1
 */