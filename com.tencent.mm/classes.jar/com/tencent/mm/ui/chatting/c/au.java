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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.q;

public class au
  extends a
  implements ab
{
  private View GyE;
  private ViewGroup GyF;
  private boolean GyG;
  private boolean GyH;
  private final long GyI;
  private ChatFooter.c GyJ;
  
  public au()
  {
    AppMethodBeat.i(35644);
    this.GyI = 259200000L;
    this.GyJ = new ChatFooter.c()
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
    if (this.GyE != null)
    {
      this.GyE.clearAnimation();
      this.GyE.setVisibility(8);
      if (paramBoolean2.booleanValue())
      {
        if (paramBoolean1.booleanValue())
        {
          az.arV();
          c.afk().set(340228, Boolean.TRUE);
          h.vKh.idkeyStat(232L, 1L, 1L, false);
          AppMethodBeat.o(35646);
        }
      }
      else if (paramBoolean1.booleanValue())
      {
        az.arV();
        c.afk().set(340229, Boolean.TRUE);
        h.vKh.idkeyStat(232L, 2L, 1L, false);
      }
    }
    AppMethodBeat.o(35646);
  }
  
  private void n(final Boolean paramBoolean)
  {
    AppMethodBeat.i(35645);
    this.GyF = ((ViewGroup)this.cOd.findViewById(2131298070));
    this.GyE = View.inflate(this.cOd.GzJ.getContext(), 2131495019, null);
    Object localObject = (TextView)this.GyE.findViewById(2131302803);
    if (paramBoolean.booleanValue())
    {
      ((TextView)localObject).setText(this.cOd.GzJ.getContext().getString(2131763066));
      this.GyE.setBackgroundResource(2131233521);
    }
    for (localObject = new FrameLayout.LayoutParams(-2, -2, 85);; localObject = new FrameLayout.LayoutParams(-2, -2, 83))
    {
      if ((this.GyF != null) && (this.GyE != null))
      {
        this.GyF.addView(this.GyE, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(this.cOd.GzJ.getContext(), 2130772132);
        this.GyE.startAnimation((Animation)localObject);
        this.GyE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35641);
            if (paramBoolean.booleanValue())
            {
              paramAnonymousView = au.this;
              Boolean localBoolean = Boolean.TRUE;
              au.a(paramAnonymousView, localBoolean, localBoolean);
              ((q)au.this.cOd.be(q.class)).eXs().fu(null);
              AppMethodBeat.o(35641);
              return;
            }
            au.a(au.this, Boolean.TRUE, Boolean.FALSE);
            ((q)au.this.cOd.be(q.class)).eXs().setMode(2);
            AppMethodBeat.o(35641);
          }
        });
      }
      AppMethodBeat.o(35645);
      return;
      ((TextView)localObject).setText(this.cOd.GzJ.getContext().getString(2131763070));
      this.GyE.setBackgroundResource(2131233520);
    }
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(35647);
    if (u.aro().booleanValue())
    {
      if (!this.cOd.zgX.eKB())
      {
        az.arV();
        this.GyG = bt.l((Boolean)c.afk().get(340228, null));
        if ((!this.GyG) && (!((f)this.cOd.be(f.class)).eWV()) && (!((d)this.cOd.be(d.class)).eWI())) {
          n(Boolean.TRUE);
        }
        az.arV();
        this.GyH = bt.l((Boolean)c.afk().get(340229, null));
        long l1 = System.currentTimeMillis();
        az.arV();
        long l2 = bt.a((Long)c.afk().get(340240, null), 0L);
        if ((this.GyG) && (!this.GyH) && (l1 - l2 >= 259200000L)) {
          n(Boolean.FALSE);
        }
      }
      if (((q)this.cOd.be(q.class)).eXs() != null) {
        ((q)this.cOd.be(q.class)).eXs().setTipsShowCallback(this.GyJ);
      }
    }
    AppMethodBeat.o(35647);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35648);
    if ((!this.cOd.zgX.eKB()) && (u.aro().booleanValue()))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    AppMethodBeat.o(35648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.au
 * JD-Core Version:    0.7.0.1
 */