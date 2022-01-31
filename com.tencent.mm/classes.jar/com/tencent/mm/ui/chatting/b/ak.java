package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.b.b.n;

public class ak
  extends a
  implements v
{
  private View vsH;
  private ViewGroup vsI;
  private boolean vsJ;
  private boolean vsK;
  private final long vsL = 259200000L;
  private ChatFooter.c vsM = new ak.2(this);
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    if (this.vsH != null)
    {
      this.vsH.clearAnimation();
      this.vsH.setVisibility(8);
      if (!paramBoolean2.booleanValue()) {
        break label66;
      }
      if (paramBoolean1.booleanValue())
      {
        au.Hx();
        com.tencent.mm.model.c.Dz().o(340228, Boolean.valueOf(true));
        h.nFQ.a(232L, 1L, 1L, false);
      }
    }
    label66:
    while (!paramBoolean1.booleanValue()) {
      return;
    }
    au.Hx();
    com.tencent.mm.model.c.Dz().o(340229, Boolean.valueOf(true));
    h.nFQ.a(232L, 2L, 1L, false);
  }
  
  private void j(Boolean paramBoolean)
  {
    this.vsI = ((ViewGroup)this.byx.findViewById(R.h.chatting_content));
    this.vsH = View.inflate(this.byx.vtz.getContext(), R.i.new_user_tutorial, null);
    Object localObject = (TextView)this.vsH.findViewById(R.h.new_user_guide_tips);
    if (paramBoolean.booleanValue())
    {
      ((TextView)localObject).setText(this.byx.vtz.getContext().getString(R.l.send_picture_video_tips));
      this.vsH.setBackgroundResource(R.g.ofm_pop_down_right_bg);
    }
    for (localObject = new FrameLayout.LayoutParams(-2, -2, 85);; localObject = new FrameLayout.LayoutParams(-2, -2, 83))
    {
      if ((this.vsI != null) && (this.vsH != null))
      {
        this.vsI.addView(this.vsH, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(this.byx.vtz.getContext(), R.a.shake_y);
        this.vsH.startAnimation((Animation)localObject);
        this.vsH.setOnClickListener(new ak.1(this, paramBoolean));
      }
      return;
      ((TextView)localObject).setText(this.byx.vtz.getContext().getString(R.l.send_voice_tips));
      this.vsH.setBackgroundResource(R.g.ofm_pop_down_left_bg);
    }
  }
  
  public final void cyP()
  {
    if (q.GS().booleanValue())
    {
      if (!this.byx.pSb.cua())
      {
        au.Hx();
        this.vsJ = bk.d((Boolean)com.tencent.mm.model.c.Dz().get(340228, null));
        if ((!this.vsJ) && (!((com.tencent.mm.ui.chatting.b.b.e)this.byx.ac(com.tencent.mm.ui.chatting.b.b.e.class)).cDY()) && (!((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDM())) {
          j(Boolean.valueOf(true));
        }
        au.Hx();
        this.vsK = bk.d((Boolean)com.tencent.mm.model.c.Dz().get(340229, null));
        long l1 = System.currentTimeMillis();
        au.Hx();
        long l2 = bk.a((Long)com.tencent.mm.model.c.Dz().get(340240, null), 0L);
        if ((this.vsJ) && (!this.vsK) && (l1 - l2 >= 259200000L)) {
          j(Boolean.valueOf(false));
        }
      }
      if (((n)this.byx.ac(n.class)).cEq() != null) {
        ((n)this.byx.ac(n.class)).cEq().setTipsShowCallback(this.vsM);
      }
    }
  }
  
  public final void cyQ()
  {
    if ((!this.byx.pSb.cua()) && (q.GS().booleanValue())) {
      c(Boolean.valueOf(false), Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ak
 * JD-Core Version:    0.7.0.1
 */