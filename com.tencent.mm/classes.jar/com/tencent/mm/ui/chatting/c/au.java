package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.q;

public class au
  extends a
  implements ab
{
  private ChatFooter.c HYA;
  private View HYv;
  private ViewGroup HYw;
  private boolean HYx;
  private boolean HYy;
  private final long HYz;
  
  public au()
  {
    AppMethodBeat.i(35644);
    this.HYz = 259200000L;
    this.HYA = new ChatFooter.c()
    {
      public final void a(Boolean paramAnonymousBoolean1, Boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(35642);
        if (paramAnonymousBoolean1.booleanValue())
        {
          if (paramAnonymousBoolean2.booleanValue())
          {
            paramAnonymousBoolean1 = au.this;
            paramAnonymousBoolean2 = Boolean.TRUE;
            au.a(paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean2);
            AppMethodBeat.o(35642);
            return;
          }
          au.a(au.this, Boolean.FALSE, Boolean.TRUE);
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
            au.a(au.this, Boolean.TRUE, Boolean.FALSE);
            AppMethodBeat.o(35643);
            return;
          }
          paramAnonymousBoolean1 = au.this;
          paramAnonymousBoolean2 = Boolean.FALSE;
          au.a(paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean2);
        }
        AppMethodBeat.o(35643);
      }
    };
    AppMethodBeat.o(35644);
  }
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(35646);
    if (this.HYv != null)
    {
      this.HYv.clearAnimation();
      this.HYv.setVisibility(8);
      if (paramBoolean2.booleanValue())
      {
        if (paramBoolean1.booleanValue())
        {
          az.ayM();
          c.agA().set(340228, Boolean.TRUE);
          h.wUl.idkeyStat(232L, 1L, 1L, false);
          AppMethodBeat.o(35646);
        }
      }
      else if (paramBoolean1.booleanValue())
      {
        az.ayM();
        c.agA().set(340229, Boolean.TRUE);
        h.wUl.idkeyStat(232L, 2L, 1L, false);
      }
    }
    AppMethodBeat.o(35646);
  }
  
  private void n(final Boolean paramBoolean)
  {
    AppMethodBeat.i(35645);
    this.HYw = ((ViewGroup)this.cLy.findViewById(2131298070));
    this.HYv = View.inflate(this.cLy.HZF.getContext(), 2131495019, null);
    Object localObject = (TextView)this.HYv.findViewById(2131302803);
    if (paramBoolean.booleanValue())
    {
      ((TextView)localObject).setText(this.cLy.HZF.getContext().getString(2131763066));
      this.HYv.setBackgroundResource(2131233521);
    }
    for (localObject = new FrameLayout.LayoutParams(-2, -2, 85);; localObject = new FrameLayout.LayoutParams(-2, -2, 83))
    {
      if ((this.HYw != null) && (this.HYv != null))
      {
        this.HYw.addView(this.HYv, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(this.cLy.HZF.getContext(), 2130772132);
        this.HYv.startAnimation((Animation)localObject);
        this.HYv.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35641);
            if (paramBoolean.booleanValue())
            {
              paramAnonymousView = au.this;
              Boolean localBoolean = Boolean.TRUE;
              au.a(paramAnonymousView, localBoolean, localBoolean);
              ((q)au.this.cLy.bf(q.class)).fne().fH(null);
              AppMethodBeat.o(35641);
              return;
            }
            au.a(au.this, Boolean.TRUE, Boolean.FALSE);
            ((q)au.this.cLy.bf(q.class)).fne().setMode(2);
            AppMethodBeat.o(35641);
          }
        });
      }
      AppMethodBeat.o(35645);
      return;
      ((TextView)localObject).setText(this.cLy.HZF.getContext().getString(2131763070));
      this.HYv.setBackgroundResource(2131233520);
    }
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(35647);
    if (u.aye().booleanValue())
    {
      if (!this.cLy.AzG.fad())
      {
        az.ayM();
        this.HYx = bs.l((Boolean)c.agA().get(340228, null));
        if ((!this.HYx) && (!((f)this.cLy.bf(f.class)).fmH()) && (!((d)this.cLy.bf(d.class)).fmu())) {
          n(Boolean.TRUE);
        }
        az.ayM();
        this.HYy = bs.l((Boolean)c.agA().get(340229, null));
        long l1 = System.currentTimeMillis();
        az.ayM();
        long l2 = bs.a((Long)c.agA().get(340240, null), 0L);
        if ((this.HYx) && (!this.HYy) && (l1 - l2 >= 259200000L)) {
          n(Boolean.FALSE);
        }
      }
      if (((q)this.cLy.bf(q.class)).fne() != null) {
        ((q)this.cLy.bf(q.class)).fne().setTipsShowCallback(this.HYA);
      }
    }
    AppMethodBeat.o(35647);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35648);
    if ((!this.cLy.AzG.fad()) && (u.aye().booleanValue()))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    AppMethodBeat.o(35648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.au
 * JD-Core Version:    0.7.0.1
 */