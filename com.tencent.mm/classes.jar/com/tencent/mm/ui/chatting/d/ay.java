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
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.s;

public class ay
  extends a
  implements ad
{
  private View JNB;
  private ViewGroup JNC;
  private boolean JND;
  private boolean JNE;
  private final long JNF;
  private ChatFooter.c JNG;
  
  public ay()
  {
    AppMethodBeat.i(35644);
    this.JNF = 259200000L;
    this.JNG = new ChatFooter.c()
    {
      public final void a(Boolean paramAnonymousBoolean1, Boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(35642);
        if (paramAnonymousBoolean1.booleanValue())
        {
          if (paramAnonymousBoolean2.booleanValue())
          {
            paramAnonymousBoolean1 = ay.this;
            paramAnonymousBoolean2 = Boolean.TRUE;
            ay.a(paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean2);
            AppMethodBeat.o(35642);
            return;
          }
          ay.a(ay.this, Boolean.FALSE, Boolean.TRUE);
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
            ay.a(ay.this, Boolean.TRUE, Boolean.FALSE);
            AppMethodBeat.o(35643);
            return;
          }
          paramAnonymousBoolean1 = ay.this;
          paramAnonymousBoolean2 = Boolean.FALSE;
          ay.a(paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean2);
        }
        AppMethodBeat.o(35643);
      }
    };
    AppMethodBeat.o(35644);
  }
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(35646);
    if (this.JNB != null)
    {
      this.JNB.clearAnimation();
      this.JNB.setVisibility(8);
      if (paramBoolean2.booleanValue())
      {
        if (paramBoolean1.booleanValue())
        {
          ba.aBQ();
          c.ajl().set(340228, Boolean.TRUE);
          g.yhR.idkeyStat(232L, 1L, 1L, false);
          AppMethodBeat.o(35646);
        }
      }
      else if (paramBoolean1.booleanValue())
      {
        ba.aBQ();
        c.ajl().set(340229, Boolean.TRUE);
        g.yhR.idkeyStat(232L, 2L, 1L, false);
      }
    }
    AppMethodBeat.o(35646);
  }
  
  private void q(final Boolean paramBoolean)
  {
    AppMethodBeat.i(35645);
    this.JNC = ((ViewGroup)this.cWM.findViewById(2131298070));
    this.JNB = View.inflate(this.cWM.JOR.getContext(), 2131495019, null);
    Object localObject = (TextView)this.JNB.findViewById(2131302803);
    if (paramBoolean.booleanValue())
    {
      ((TextView)localObject).setText(this.cWM.JOR.getContext().getString(2131763066));
      this.JNB.setBackgroundResource(2131233521);
    }
    for (localObject = new FrameLayout.LayoutParams(-2, -2, 85);; localObject = new FrameLayout.LayoutParams(-2, -2, 83))
    {
      if ((this.JNC != null) && (this.JNB != null))
      {
        this.JNC.addView(this.JNB, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(this.cWM.JOR.getContext(), 2130772132);
        this.JNB.startAnimation((Animation)localObject);
        this.JNB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35641);
            Object localObject = new b();
            ((b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/TipsBubbleComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
            if (paramBoolean.booleanValue())
            {
              paramAnonymousView = ay.this;
              localObject = Boolean.TRUE;
              ay.a(paramAnonymousView, (Boolean)localObject, (Boolean)localObject);
              ((s)ay.this.cWM.bh(s.class)).fDC().fW(null);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/TipsBubbleComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35641);
              return;
              ay.a(ay.this, Boolean.TRUE, Boolean.FALSE);
              ((s)ay.this.cWM.bh(s.class)).fDC().setMode(2);
            }
          }
        });
      }
      AppMethodBeat.o(35645);
      return;
      ((TextView)localObject).setText(this.cWM.JOR.getContext().getString(2131763070));
      this.JNB.setBackgroundResource(2131233520);
    }
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(35647);
    if (u.aBd().booleanValue())
    {
      if (!this.cWM.BYG.fqg())
      {
        ba.aBQ();
        this.JND = bt.o((Boolean)c.ajl().get(340228, null));
        if ((!this.JND) && (!((f)this.cWM.bh(f.class)).fDa()) && (!((d)this.cWM.bh(d.class)).fCN())) {
          q(Boolean.TRUE);
        }
        ba.aBQ();
        this.JNE = bt.o((Boolean)c.ajl().get(340229, null));
        long l1 = System.currentTimeMillis();
        ba.aBQ();
        long l2 = bt.a((Long)c.ajl().get(340240, null), 0L);
        if ((this.JND) && (!this.JNE) && (l1 - l2 >= 259200000L)) {
          q(Boolean.FALSE);
        }
      }
      if (((s)this.cWM.bh(s.class)).fDC() != null) {
        ((s)this.cWM.bh(s.class)).fDC().setTipsShowCallback(this.JNG);
      }
    }
    AppMethodBeat.o(35647);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35648);
    if ((!this.cWM.BYG.fqg()) && (u.aBd().booleanValue()))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    AppMethodBeat.o(35648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ay
 * JD-Core Version:    0.7.0.1
 */