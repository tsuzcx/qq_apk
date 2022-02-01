package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.x.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class m
  extends a
{
  private WXRTEditText XDV;
  
  public m(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30879);
    this.XDV = ((WXRTEditText)paramView.findViewById(R.h.fVi));
    if ((paramk.XBx != 2) || (!this.XCl.XBy))
    {
      this.XDV.setKeyListener(null);
      this.XDV.setFocusable(false);
      this.XDV.setClickable(true);
    }
    this.XDV.xzK = this;
    this.XDV.setEditTextType(0);
    this.XCl.q(this.XDV);
    this.XDV.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30876);
        bh.baH().postToWorker(new Runnable()
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
    x.b localb = null;
    paramInt2 = -1;
    AppMethodBeat.i(30880);
    this.XDV.setPosInDataList(paramInt1);
    final com.tencent.mm.plugin.wenote.model.a.i locali = (com.tencent.mm.plugin.wenote.model.a.i)paramc;
    locali.XAB = this.XDV;
    locali.XAz = null;
    locali.XAA = null;
    paramc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(paramInt1 - 1);
    if ((paramc != null) && (paramc.getType() == 1))
    {
      paramc = (LinearLayout.LayoutParams)this.XDV.getLayoutParams();
      paramc.topMargin = 0;
      this.XDV.setLayoutParams(paramc);
    }
    paramc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(paramInt1 + 1);
    if ((paramc != null) && (paramc.getType() == 1))
    {
      paramc = (LinearLayout.LayoutParams)this.XDV.getLayoutParams();
      paramc.bottomMargin = 0;
      this.XDV.setLayoutParams(paramc);
    }
    paramc = localb;
    switch (this.XCl.XBx)
    {
    default: 
      paramc = localb;
    case 3: 
      if ((this.XCl.XBx != 2) || (!this.XCl.XBy))
      {
        this.XDV.setRichTextEditing(locali.content);
        p.b(this.XDV, paramc, p.YoF);
        Log.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + KI());
        AppMethodBeat.o(30880);
        return;
      }
      break;
    case 2: 
      paramc = x.b.YpQ;
    case 4: 
      for (paramInt1 = paramInt2;; paramInt1 = paramInt2)
      {
        paramc = paramc.awY(paramInt1);
        break;
        paramc = x.b.YpT;
      }
    case 1: 
      label228:
      bh.bCz();
      label265:
      paramc = com.tencent.mm.model.c.bzD().sl(this.XCl.msgId);
      if (paramc == null) {}
      break;
    }
    for (paramc = paramc.field_talker;; paramc = null)
    {
      if (this.XCl.XBn)
      {
        localb = x.b.YpS;
        if (paramc == null) {}
        for (paramInt1 = -1;; paramInt1 = com.tencent.mm.modelappbrand.a.KG(paramc))
        {
          paramc = localb.awY(paramInt1);
          break;
        }
      }
      localb = x.b.YpR;
      if (paramc == null)
      {
        paramc = localb;
        paramInt1 = paramInt2;
        break label265;
      }
      paramInt1 = com.tencent.mm.modelappbrand.a.KG(paramc);
      paramc = localb;
      break label265;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30878);
          m.a(m.this).setRichTextEditing(locali.content);
          m.a(m.this).dwE();
          m.a(m.this).dwG();
          p.b(m.a(m.this), paramc, p.YoF);
          m.a(m.this).dwH();
          m.a(m.this).dwF();
          if (locali.xyb) {
            if ((locali.xyd != -1) && (locali.xyd < m.a(m.this).getText().toString().length()))
            {
              m.a(m.this).setSelection(locali.xyd);
              m.a(m.this).requestFocus();
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(30877);
                  if (m.2.this.XDY.xyk != 0)
                  {
                    int i = m.a(m.this).getSelection().uG;
                    if (i == m.2.this.XDY.content.length())
                    {
                      m.a(m.this).dwE();
                      m.a(m.this).getText().append("\n");
                      m.a(m.this).dwF();
                      m.a(m.this).setSelection(i);
                    }
                    m.2.this.XDY.xyk = 0;
                    if (m.2.this.XDY.xyl == 1)
                    {
                      m.a(m.this).a(u.XCa, Boolean.TRUE);
                      AppMethodBeat.o(30877);
                      return;
                    }
                    if (m.2.this.XDY.xyl == 3)
                    {
                      m.a(m.this).a(u.XBZ, Boolean.TRUE);
                      AppMethodBeat.o(30877);
                      return;
                    }
                    if (m.2.this.XDY.xyl == 2) {
                      m.a(m.this).a(u.XCb, Boolean.TRUE);
                    }
                  }
                  AppMethodBeat.o(30877);
                }
              }, 500L);
            }
          }
          for (;;)
          {
            if (locali.xyj)
            {
              locali.xyj = false;
              m.a(m.this).xyj = true;
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
      break label228;
    }
  }
  
  public final int dvW()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.m
 * JD-Core Version:    0.7.0.1
 */