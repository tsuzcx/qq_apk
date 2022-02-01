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
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.u;

public class bc
  extends a
  implements af
{
  private View Put;
  private ViewGroup Puu;
  private boolean Puv;
  private boolean Puw;
  private final long Pux;
  private ChatFooter.c Puy;
  
  public bc()
  {
    AppMethodBeat.i(35644);
    this.Pux = 259200000L;
    this.Puy = new ChatFooter.c()
    {
      public final void a(Boolean paramAnonymousBoolean1, Boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(35642);
        if (paramAnonymousBoolean1.booleanValue())
        {
          if (paramAnonymousBoolean2.booleanValue())
          {
            paramAnonymousBoolean1 = bc.this;
            paramAnonymousBoolean2 = Boolean.TRUE;
            bc.a(paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean2);
            AppMethodBeat.o(35642);
            return;
          }
          bc.a(bc.this, Boolean.FALSE, Boolean.TRUE);
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
            bc.a(bc.this, Boolean.TRUE, Boolean.FALSE);
            AppMethodBeat.o(35643);
            return;
          }
          paramAnonymousBoolean1 = bc.this;
          paramAnonymousBoolean2 = Boolean.FALSE;
          bc.a(paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean2);
        }
        AppMethodBeat.o(35643);
      }
    };
    AppMethodBeat.o(35644);
  }
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(35646);
    if (this.Put != null)
    {
      this.Put.clearAnimation();
      this.Put.setVisibility(8);
      if (paramBoolean2.booleanValue())
      {
        if (paramBoolean1.booleanValue())
        {
          bg.aVF();
          c.azQ().set(340228, Boolean.TRUE);
          h.CyF.idkeyStat(232L, 1L, 1L, false);
          AppMethodBeat.o(35646);
        }
      }
      else if (paramBoolean1.booleanValue())
      {
        bg.aVF();
        c.azQ().set(340229, Boolean.TRUE);
        h.CyF.idkeyStat(232L, 2L, 1L, false);
      }
    }
    AppMethodBeat.o(35646);
  }
  
  private void s(final Boolean paramBoolean)
  {
    AppMethodBeat.i(35645);
    this.Puu = ((ViewGroup)this.dom.findViewById(2131298413));
    this.Put = View.inflate(this.dom.Pwc.getContext(), 2131495851, null);
    Object localObject = (TextView)this.Put.findViewById(2131305373);
    if (paramBoolean.booleanValue())
    {
      ((TextView)localObject).setText(this.dom.Pwc.getContext().getString(2131765225));
      this.Put.setBackgroundResource(2131234325);
    }
    for (localObject = new FrameLayout.LayoutParams(-2, -2, 85);; localObject = new FrameLayout.LayoutParams(-2, -2, 83))
    {
      if ((this.Puu != null) && (this.Put != null))
      {
        this.Puu.addView(this.Put, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(this.dom.Pwc.getContext(), 2130772156);
        this.Put.startAnimation((Animation)localObject);
        this.Put.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35641);
            Object localObject = new b();
            ((b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/TipsBubbleComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
            if (paramBoolean.booleanValue())
            {
              paramAnonymousView = bc.this;
              localObject = Boolean.TRUE;
              bc.a(paramAnonymousView, (Boolean)localObject, (Boolean)localObject);
              ((u)bc.this.dom.bh(u.class)).gPO().go(null);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/TipsBubbleComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35641);
              return;
              bc.a(bc.this, Boolean.TRUE, Boolean.FALSE);
              ((u)bc.this.dom.bh(u.class)).gPO().setMode(2);
            }
          }
        });
      }
      AppMethodBeat.o(35645);
      return;
      ((TextView)localObject).setText(this.dom.Pwc.getContext().getString(2131765229));
      this.Put.setBackgroundResource(2131234324);
    }
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35647);
    if (z.aUQ().booleanValue())
    {
      if (!this.dom.GUe.gBM())
      {
        bg.aVF();
        this.Puv = Util.nullAsFalse((Boolean)c.azQ().get(340228, null));
        if ((!this.Puv) && (!((f)this.dom.bh(f.class)).gPi()) && (!((d)this.dom.bh(d.class)).gOV())) {
          s(Boolean.TRUE);
        }
        bg.aVF();
        this.Puw = Util.nullAsFalse((Boolean)c.azQ().get(340229, null));
        long l1 = System.currentTimeMillis();
        bg.aVF();
        long l2 = Util.nullAs((Long)c.azQ().get(340240, null), 0L);
        if ((this.Puv) && (!this.Puw) && (l1 - l2 >= 259200000L)) {
          s(Boolean.FALSE);
        }
      }
      if (((u)this.dom.bh(u.class)).gPO() != null) {
        ((u)this.dom.bh(u.class)).gPO().setTipsShowCallback(this.Puy);
      }
    }
    AppMethodBeat.o(35647);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35648);
    if ((!this.dom.GUe.gBM()) && (z.aUQ().booleanValue()))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    AppMethodBeat.o(35648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bc
 * JD-Core Version:    0.7.0.1
 */