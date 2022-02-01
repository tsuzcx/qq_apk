package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.g;
import com.tencent.mm.ui.chatting.component.api.x;

public class bm
  extends a
  implements aj
{
  private View aexr;
  private ViewGroup aexs;
  private boolean aext;
  private boolean aexu;
  private final long aexv;
  private ChatFooter.c aexw;
  
  public bm()
  {
    AppMethodBeat.i(35644);
    this.aexv = 259200000L;
    this.aexw = new ChatFooter.c()
    {
      public final void a(Boolean paramAnonymousBoolean1, Boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(35642);
        if (paramAnonymousBoolean1.booleanValue())
        {
          if (paramAnonymousBoolean2.booleanValue())
          {
            paramAnonymousBoolean1 = bm.this;
            paramAnonymousBoolean2 = Boolean.TRUE;
            bm.a(paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean2);
            AppMethodBeat.o(35642);
            return;
          }
          bm.a(bm.this, Boolean.FALSE, Boolean.TRUE);
        }
        AppMethodBeat.o(35642);
      }
      
      public final void b(Boolean paramAnonymousBoolean1, Boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(35643);
        if (paramAnonymousBoolean1.booleanValue())
        {
          if (paramAnonymousBoolean2.booleanValue())
          {
            bm.a(bm.this, Boolean.TRUE, Boolean.FALSE);
            AppMethodBeat.o(35643);
            return;
          }
          paramAnonymousBoolean1 = bm.this;
          paramAnonymousBoolean2 = Boolean.FALSE;
          bm.a(paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean2);
        }
        AppMethodBeat.o(35643);
      }
    };
    AppMethodBeat.o(35644);
  }
  
  private void L(final Boolean paramBoolean)
  {
    AppMethodBeat.i(35645);
    this.aexs = ((ViewGroup)this.hlc.findViewById(R.h.fxv));
    this.aexr = View.inflate(this.hlc.aezO.getContext(), R.i.gmA, null);
    Object localObject = (TextView)this.aexr.findViewById(R.h.fQF);
    if (paramBoolean.booleanValue())
    {
      ((TextView)localObject).setText(this.hlc.aezO.getContext().getString(R.l.gUT));
      this.aexr.setBackgroundResource(R.g.ofm_pop_down_right_bg);
    }
    for (localObject = new FrameLayout.LayoutParams(-2, -2, 85);; localObject = new FrameLayout.LayoutParams(-2, -2, 83))
    {
      if ((this.aexs != null) && (this.aexr != null))
      {
        this.aexs.addView(this.aexr, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(this.hlc.aezO.getContext(), R.a.shake_y);
        this.aexr.startAnimation((Animation)localObject);
        this.aexr.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35641);
            Object localObject = new b();
            ((b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/TipsBubbleComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
            if (paramBoolean.booleanValue())
            {
              paramAnonymousView = bm.this;
              localObject = Boolean.TRUE;
              bm.a(paramAnonymousView, (Boolean)localObject, (Boolean)localObject);
              ((x)bm.this.hlc.cm(x.class)).jsd().kO(null);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/TipsBubbleComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35641);
              return;
              bm.a(bm.this, Boolean.TRUE, Boolean.FALSE);
              ((x)bm.this.hlc.cm(x.class)).jsd().setMode(2);
            }
          }
        });
      }
      AppMethodBeat.o(35645);
      return;
      ((TextView)localObject).setText(this.hlc.aezO.getContext().getString(R.l.gUU));
      this.aexr.setBackgroundResource(R.g.ofm_pop_down_left_bg);
    }
  }
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(35646);
    if (this.aexr != null)
    {
      this.aexr.clearAnimation();
      this.aexr.setVisibility(8);
      if (paramBoolean2.booleanValue())
      {
        if (paramBoolean1.booleanValue())
        {
          bh.bCz();
          c.ban().B(340228, Boolean.TRUE);
          h.OAn.idkeyStat(232L, 1L, 1L, false);
          AppMethodBeat.o(35646);
        }
      }
      else if (paramBoolean1.booleanValue())
      {
        bh.bCz();
        c.ban().B(340229, Boolean.TRUE);
        h.OAn.idkeyStat(232L, 2L, 1L, false);
      }
    }
    AppMethodBeat.o(35646);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(35647);
    if (z.bBK().booleanValue())
    {
      if (!this.hlc.Uxa.iZC())
      {
        bh.bCz();
        this.aext = Util.nullAsFalse((Boolean)c.ban().d(340228, null));
        if ((!this.aext) && (!((g)this.hlc.cm(g.class)).jrq()) && (!((e)this.hlc.cm(e.class)).jrc())) {
          L(Boolean.TRUE);
        }
        bh.bCz();
        this.aexu = Util.nullAsFalse((Boolean)c.ban().d(340229, null));
        long l1 = System.currentTimeMillis();
        bh.bCz();
        long l2 = Util.nullAs((Long)c.ban().d(340240, null), 0L);
        if ((this.aext) && (!this.aexu) && (l1 - l2 >= 259200000L)) {
          L(Boolean.FALSE);
        }
      }
      if (((x)this.hlc.cm(x.class)).jsd() != null) {
        ((x)this.hlc.cm(x.class)).jsd().setTipsShowCallback(this.aexw);
      }
    }
    AppMethodBeat.o(35647);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35648);
    if ((!this.hlc.Uxa.iZC()) && (z.bBK().booleanValue()))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    AppMethodBeat.o(35648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bm
 * JD-Core Version:    0.7.0.1
 */