package com.tencent.mm.ui.chatting.d;

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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.s;

public class az
  extends a
  implements ad
{
  private boolean KiA;
  private boolean KiB;
  private final long KiC;
  private ChatFooter.c KiD;
  private View Kiy;
  private ViewGroup Kiz;
  
  public az()
  {
    AppMethodBeat.i(35644);
    this.KiC = 259200000L;
    this.KiD = new ChatFooter.c()
    {
      public final void a(Boolean paramAnonymousBoolean1, Boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(35642);
        if (paramAnonymousBoolean1.booleanValue())
        {
          if (paramAnonymousBoolean2.booleanValue())
          {
            paramAnonymousBoolean1 = az.this;
            paramAnonymousBoolean2 = Boolean.TRUE;
            az.a(paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean2);
            AppMethodBeat.o(35642);
            return;
          }
          az.a(az.this, Boolean.FALSE, Boolean.TRUE);
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
            az.a(az.this, Boolean.TRUE, Boolean.FALSE);
            AppMethodBeat.o(35643);
            return;
          }
          paramAnonymousBoolean1 = az.this;
          paramAnonymousBoolean2 = Boolean.FALSE;
          az.a(paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean2);
        }
        AppMethodBeat.o(35643);
      }
    };
    AppMethodBeat.o(35644);
  }
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(35646);
    if (this.Kiy != null)
    {
      this.Kiy.clearAnimation();
      this.Kiy.setVisibility(8);
      if (paramBoolean2.booleanValue())
      {
        if (paramBoolean1.booleanValue())
        {
          bc.aCg();
          c.ajA().set(340228, Boolean.TRUE);
          g.yxI.idkeyStat(232L, 1L, 1L, false);
          AppMethodBeat.o(35646);
        }
      }
      else if (paramBoolean1.booleanValue())
      {
        bc.aCg();
        c.ajA().set(340229, Boolean.TRUE);
        g.yxI.idkeyStat(232L, 2L, 1L, false);
      }
    }
    AppMethodBeat.o(35646);
  }
  
  private void q(final Boolean paramBoolean)
  {
    AppMethodBeat.i(35645);
    this.Kiz = ((ViewGroup)this.cXJ.findViewById(2131298070));
    this.Kiy = View.inflate(this.cXJ.Kkd.getContext(), 2131495019, null);
    Object localObject = (TextView)this.Kiy.findViewById(2131302803);
    if (paramBoolean.booleanValue())
    {
      ((TextView)localObject).setText(this.cXJ.Kkd.getContext().getString(2131763066));
      this.Kiy.setBackgroundResource(2131233521);
    }
    for (localObject = new FrameLayout.LayoutParams(-2, -2, 85);; localObject = new FrameLayout.LayoutParams(-2, -2, 83))
    {
      if ((this.Kiz != null) && (this.Kiy != null))
      {
        this.Kiz.addView(this.Kiy, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(this.cXJ.Kkd.getContext(), 2130772132);
        this.Kiy.startAnimation((Animation)localObject);
        this.Kiy.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35641);
            Object localObject = new b();
            ((b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/TipsBubbleComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
            if (paramBoolean.booleanValue())
            {
              paramAnonymousView = az.this;
              localObject = Boolean.TRUE;
              az.a(paramAnonymousView, (Boolean)localObject, (Boolean)localObject);
              ((s)az.this.cXJ.bh(s.class)).fHF().fV(null);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/TipsBubbleComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35641);
              return;
              az.a(az.this, Boolean.TRUE, Boolean.FALSE);
              ((s)az.this.cXJ.bh(s.class)).fHF().setMode(2);
            }
          }
        });
      }
      AppMethodBeat.o(35645);
      return;
      ((TextView)localObject).setText(this.cXJ.Kkd.getContext().getString(2131763070));
      this.Kiy.setBackgroundResource(2131233520);
    }
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(35647);
    if (v.aBt().booleanValue())
    {
      if (!this.cXJ.Cqh.fug())
      {
        bc.aCg();
        this.KiA = bu.o((Boolean)c.ajA().get(340228, null));
        if ((!this.KiA) && (!((f)this.cXJ.bh(f.class)).fHc()) && (!((d)this.cXJ.bh(d.class)).fGP())) {
          q(Boolean.TRUE);
        }
        bc.aCg();
        this.KiB = bu.o((Boolean)c.ajA().get(340229, null));
        long l1 = System.currentTimeMillis();
        bc.aCg();
        long l2 = bu.a((Long)c.ajA().get(340240, null), 0L);
        if ((this.KiA) && (!this.KiB) && (l1 - l2 >= 259200000L)) {
          q(Boolean.FALSE);
        }
      }
      if (((s)this.cXJ.bh(s.class)).fHF() != null) {
        ((s)this.cXJ.bh(s.class)).fHF().setTipsShowCallback(this.KiD);
      }
    }
    AppMethodBeat.o(35647);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35648);
    if ((!this.cXJ.Cqh.fug()) && (v.aBt().booleanValue()))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    AppMethodBeat.o(35648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.az
 * JD-Core Version:    0.7.0.1
 */