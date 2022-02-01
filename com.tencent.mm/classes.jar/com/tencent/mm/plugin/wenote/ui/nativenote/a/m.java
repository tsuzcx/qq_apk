package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.text.Editable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class m
  extends a
{
  private WXRTEditText ECO;
  
  public m(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30879);
    this.ECO = ((WXRTEditText)paramView.findViewById(2131304265));
    if ((paramk.EAx != 2) || (!this.EBf.EAy))
    {
      this.ECO.setKeyListener(null);
      this.ECO.setFocusable(false);
      this.ECO.setClickable(true);
    }
    this.ECO.pvl = this;
    this.ECO.setEditTextType(0);
    this.EBf.q(this.ECO);
    this.ECO.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30876);
        ba.ajF().ay(new Runnable()
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
    this.ECO.setPosInDataList(paramInt1);
    paramc = (i)paramc;
    paramc.EzC = this.ECO;
    paramc.EzA = null;
    paramc.EzB = null;
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().XY(paramInt1 - 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.ECO.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.ECO.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().XY(paramInt1 + 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.ECO.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      this.ECO.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((this.EBf.EAx != 2) || (!this.EBf.EAy))
    {
      this.ECO.setRichTextEditing(paramc.content);
      com.tencent.mm.pluginsdk.ui.span.k.v(this.ECO);
    }
    for (;;)
    {
      ad.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + lM());
      AppMethodBeat.o(30880);
      return;
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30878);
          m.a(m.this).setRichTextEditing(paramc.content);
          m.a(m.this).ceC();
          m.a(m.this).ceE();
          com.tencent.mm.pluginsdk.ui.span.k.v(m.a(m.this));
          m.a(m.this).ceF();
          m.a(m.this).ceD();
          if (paramc.ptF) {
            if ((paramc.ptH != -1) && (paramc.ptH < m.a(m.this).getText().toString().length()))
            {
              m.a(m.this).setSelection(paramc.ptH);
              m.a(m.this).requestFocus();
              aq.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(30877);
                  if (m.2.this.ECR.ptO != 0)
                  {
                    int i = m.a(m.this).getSelection().avj;
                    if (i == m.2.this.ECR.content.length())
                    {
                      m.a(m.this).ceC();
                      m.a(m.this).getText().append("\n");
                      m.a(m.this).ceD();
                      m.a(m.this).setSelection(i);
                    }
                    m.2.this.ECR.ptO = 0;
                    if (m.2.this.ECR.ptP == 1)
                    {
                      m.a(m.this).a(u.EAZ, Boolean.TRUE);
                      AppMethodBeat.o(30877);
                      return;
                    }
                    if (m.2.this.ECR.ptP == 3)
                    {
                      m.a(m.this).a(u.EAY, Boolean.TRUE);
                      AppMethodBeat.o(30877);
                      return;
                    }
                    if (m.2.this.ECR.ptP == 2) {
                      m.a(m.this).a(u.EBa, Boolean.TRUE);
                    }
                  }
                  AppMethodBeat.o(30877);
                }
              }, 500L);
            }
          }
          for (;;)
          {
            if (paramc.ptN)
            {
              paramc.ptN = false;
              m.a(m.this).ptN = true;
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
  
  public final int cdT()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.m
 * JD-Core Version:    0.7.0.1
 */