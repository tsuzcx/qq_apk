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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;

public final class m
  extends a
{
  private WXRTEditText CYS;
  
  public m(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30879);
    this.CYS = ((WXRTEditText)paramView.findViewById(2131304265));
    if ((paramk.CWB != 2) || (!this.CXj.CWC))
    {
      this.CYS.setKeyListener(null);
      this.CYS.setFocusable(false);
      this.CYS.setClickable(true);
    }
    this.CYS.oRB = this;
    this.CYS.setEditTextType(0);
    this.CXj.q(this.CYS);
    this.CYS.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30876);
        az.agU().az(new Runnable()
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
    this.CYS.setPosInDataList(paramInt1);
    paramc = (i)paramc;
    paramc.CVF = this.CYS;
    paramc.CVD = null;
    paramc.CVE = null;
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(paramInt1 - 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.CYS.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.CYS.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(paramInt1 + 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.CYS.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      this.CYS.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((this.CXj.CWB != 2) || (!this.CXj.CWC))
    {
      this.CYS.setRichTextEditing(paramc.content);
      com.tencent.mm.pluginsdk.ui.span.k.v(this.CYS);
    }
    for (;;)
    {
      ac.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + lu());
      AppMethodBeat.o(30880);
      return;
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30878);
          m.a(m.this).setRichTextEditing(paramc.content);
          m.a(m.this).bZY();
          m.a(m.this).caa();
          com.tencent.mm.pluginsdk.ui.span.k.v(m.a(m.this));
          m.a(m.this).cab();
          m.a(m.this).bZZ();
          if (paramc.oPV) {
            if ((paramc.oPX != -1) && (paramc.oPX < m.a(m.this).getText().toString().length()))
            {
              m.a(m.this).setSelection(paramc.oPX);
              m.a(m.this).requestFocus();
              ap.n(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(30877);
                  if (m.2.this.CYV.oQe != 0)
                  {
                    int i = m.a(m.this).getSelection().atr;
                    if (i == m.2.this.CYV.content.length())
                    {
                      m.a(m.this).bZY();
                      m.a(m.this).getText().append("\n");
                      m.a(m.this).bZZ();
                      m.a(m.this).setSelection(i);
                    }
                    m.2.this.CYV.oQe = 0;
                    if (m.2.this.CYV.oQf == 1)
                    {
                      m.a(m.this).a(u.CXd, Boolean.TRUE);
                      AppMethodBeat.o(30877);
                      return;
                    }
                    if (m.2.this.CYV.oQf == 3)
                    {
                      m.a(m.this).a(u.CXc, Boolean.TRUE);
                      AppMethodBeat.o(30877);
                      return;
                    }
                    if (m.2.this.CYV.oQf == 2) {
                      m.a(m.this).a(u.CXe, Boolean.TRUE);
                    }
                  }
                  AppMethodBeat.o(30877);
                }
              }, 500L);
            }
          }
          for (;;)
          {
            if (paramc.oQd)
            {
              paramc.oQd = false;
              m.a(m.this).oQd = true;
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
  
  public final int bZp()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.m
 * JD-Core Version:    0.7.0.1
 */