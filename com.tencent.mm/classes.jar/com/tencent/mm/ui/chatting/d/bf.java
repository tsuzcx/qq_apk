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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.u;

public class bf
  extends a
  implements ag
{
  private View WOM;
  private ViewGroup WON;
  private boolean WOO;
  private boolean WOP;
  private final long WOQ;
  private ChatFooter.c WOR;
  
  public bf()
  {
    AppMethodBeat.i(35644);
    this.WOQ = 259200000L;
    this.WOR = new ChatFooter.c()
    {
      public final void a(Boolean paramAnonymousBoolean1, Boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(35642);
        if (paramAnonymousBoolean1.booleanValue())
        {
          if (paramAnonymousBoolean2.booleanValue())
          {
            paramAnonymousBoolean1 = bf.this;
            paramAnonymousBoolean2 = Boolean.TRUE;
            bf.a(paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean2);
            AppMethodBeat.o(35642);
            return;
          }
          bf.a(bf.this, Boolean.FALSE, Boolean.TRUE);
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
            bf.a(bf.this, Boolean.TRUE, Boolean.FALSE);
            AppMethodBeat.o(35643);
            return;
          }
          paramAnonymousBoolean1 = bf.this;
          paramAnonymousBoolean2 = Boolean.FALSE;
          bf.a(paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean2);
        }
        AppMethodBeat.o(35643);
      }
    };
    AppMethodBeat.o(35644);
  }
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(35646);
    if (this.WOM != null)
    {
      this.WOM.clearAnimation();
      this.WOM.setVisibility(8);
      if (paramBoolean2.booleanValue())
      {
        if (paramBoolean1.booleanValue())
        {
          bh.beI();
          c.aHp().i(340228, Boolean.TRUE);
          h.IzE.idkeyStat(232L, 1L, 1L, false);
          AppMethodBeat.o(35646);
        }
      }
      else if (paramBoolean1.booleanValue())
      {
        bh.beI();
        c.aHp().i(340229, Boolean.TRUE);
        h.IzE.idkeyStat(232L, 2L, 1L, false);
      }
    }
    AppMethodBeat.o(35646);
  }
  
  private void z(final Boolean paramBoolean)
  {
    AppMethodBeat.i(35645);
    this.WON = ((ViewGroup)this.fgR.findViewById(R.h.dxb));
    this.WOM = View.inflate(this.fgR.WQv.getContext(), R.i.ejz, null);
    Object localObject = (TextView)this.WOM.findViewById(R.h.dOE);
    if (paramBoolean.booleanValue())
    {
      ((TextView)localObject).setText(this.fgR.WQv.getContext().getString(R.l.eSj));
      this.WOM.setBackgroundResource(R.g.ofm_pop_down_right_bg);
    }
    for (localObject = new FrameLayout.LayoutParams(-2, -2, 85);; localObject = new FrameLayout.LayoutParams(-2, -2, 83))
    {
      if ((this.WON != null) && (this.WOM != null))
      {
        this.WON.addView(this.WOM, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(this.fgR.WQv.getContext(), R.a.shake_y);
        this.WOM.startAnimation((Animation)localObject);
        this.WOM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35641);
            Object localObject = new b();
            ((b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/TipsBubbleComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
            if (paramBoolean.booleanValue())
            {
              paramAnonymousView = bf.this;
              localObject = Boolean.TRUE;
              bf.a(paramAnonymousView, (Boolean)localObject, (Boolean)localObject);
              ((u)bf.this.fgR.bC(u.class)).hPj().hy(null);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/TipsBubbleComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35641);
              return;
              bf.a(bf.this, Boolean.TRUE, Boolean.FALSE);
              ((u)bf.this.fgR.bC(u.class)).hPj().setMode(2);
            }
          }
        });
      }
      AppMethodBeat.o(35645);
      return;
      ((TextView)localObject).setText(this.fgR.WQv.getContext().getString(R.l.eSk));
      this.WOM.setBackgroundResource(R.g.ofm_pop_down_left_bg);
    }
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(35647);
    if (z.bdS().booleanValue())
    {
      if (!this.fgR.NKq.hxX())
      {
        bh.beI();
        this.WOO = Util.nullAsFalse((Boolean)c.aHp().b(340228, null));
        if ((!this.WOO) && (!((f)this.fgR.bC(f.class)).hOy()) && (!((d)this.fgR.bC(d.class)).hOk())) {
          z(Boolean.TRUE);
        }
        bh.beI();
        this.WOP = Util.nullAsFalse((Boolean)c.aHp().b(340229, null));
        long l1 = System.currentTimeMillis();
        bh.beI();
        long l2 = Util.nullAs((Long)c.aHp().b(340240, null), 0L);
        if ((this.WOO) && (!this.WOP) && (l1 - l2 >= 259200000L)) {
          z(Boolean.FALSE);
        }
      }
      if (((u)this.fgR.bC(u.class)).hPj() != null) {
        ((u)this.fgR.bC(u.class)).hPj().setTipsShowCallback(this.WOR);
      }
    }
    AppMethodBeat.o(35647);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35648);
    if ((!this.fgR.NKq.hxX()) && (z.bdS().booleanValue()))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    AppMethodBeat.o(35648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bf
 * JD-Core Version:    0.7.0.1
 */