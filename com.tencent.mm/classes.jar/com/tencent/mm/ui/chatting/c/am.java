package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.o;

public class am
  extends a
  implements v
{
  private ChatFooter.c zIA;
  private View zIv;
  private ViewGroup zIw;
  private boolean zIx;
  private boolean zIy;
  private final long zIz;
  
  public am()
  {
    AppMethodBeat.i(31742);
    this.zIz = 259200000L;
    this.zIA = new am.2(this);
    AppMethodBeat.o(31742);
  }
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(31744);
    if (this.zIv != null)
    {
      this.zIv.clearAnimation();
      this.zIv.setVisibility(8);
      if (paramBoolean2.booleanValue())
      {
        if (paramBoolean1.booleanValue())
        {
          aw.aaz();
          c.Ru().set(340228, Boolean.TRUE);
          h.qsU.idkeyStat(232L, 1L, 1L, false);
          AppMethodBeat.o(31744);
        }
      }
      else if (paramBoolean1.booleanValue())
      {
        aw.aaz();
        c.Ru().set(340229, Boolean.TRUE);
        h.qsU.idkeyStat(232L, 2L, 1L, false);
      }
    }
    AppMethodBeat.o(31744);
  }
  
  private void l(Boolean paramBoolean)
  {
    AppMethodBeat.i(31743);
    this.zIw = ((ViewGroup)this.caz.findViewById(2131822440));
    this.zIv = View.inflate(this.caz.zJz.getContext(), 2130970361, null);
    Object localObject = (TextView)this.zIv.findViewById(2131826549);
    if (paramBoolean.booleanValue())
    {
      ((TextView)localObject).setText(this.caz.zJz.getContext().getString(2131303117));
      this.zIv.setBackgroundResource(2130839861);
    }
    for (localObject = new FrameLayout.LayoutParams(-2, -2, 85);; localObject = new FrameLayout.LayoutParams(-2, -2, 83))
    {
      if ((this.zIw != null) && (this.zIv != null))
      {
        this.zIw.addView(this.zIv, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(this.caz.zJz.getContext(), 2131034254);
        this.zIv.startAnimation((Animation)localObject);
        this.zIv.setOnClickListener(new am.1(this, paramBoolean));
      }
      AppMethodBeat.o(31743);
      return;
      ((TextView)localObject).setText(this.caz.zJz.getContext().getString(2131303121));
      this.zIv.setBackgroundResource(2130839860);
    }
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(31745);
    if (r.ZU().booleanValue())
    {
      if (!this.caz.txj.dwz())
      {
        aw.aaz();
        this.zIx = bo.e((Boolean)c.Ru().get(340228, null));
        if ((!this.zIx) && (!((f)this.caz.ay(f.class)).dHO()) && (!((d)this.caz.ay(d.class)).dHB())) {
          l(Boolean.TRUE);
        }
        aw.aaz();
        this.zIy = bo.e((Boolean)c.Ru().get(340229, null));
        long l1 = System.currentTimeMillis();
        aw.aaz();
        long l2 = bo.a((Long)c.Ru().get(340240, null), 0L);
        if ((this.zIx) && (!this.zIy) && (l1 - l2 >= 259200000L)) {
          l(Boolean.FALSE);
        }
      }
      if (((o)this.caz.ay(o.class)).dIg() != null) {
        ((o)this.caz.ay(o.class)).dIg().setTipsShowCallback(this.zIA);
      }
    }
    AppMethodBeat.o(31745);
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31746);
    if ((!this.caz.txj.dwz()) && (r.ZU().booleanValue()))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    AppMethodBeat.o(31746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.am
 * JD-Core Version:    0.7.0.1
 */