package com.tencent.mm.ui.chatting.c;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.y;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.p;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ak;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.x;

@com.tencent.mm.ui.chatting.c.a.a(eYT=x.class)
public class aa
  extends a
  implements x
{
  private View GwP;
  private TextView GwQ;
  private int GwR;
  private int GwS = 0;
  private Runnable awR;
  
  private boolean eYh()
  {
    AppMethodBeat.i(35441);
    d locald = (d)this.cOd.be(d.class);
    if ((w.ti(this.cOd.getTalkerUserName())) || (w.tn(this.cOd.getTalkerUserName())))
    {
      AppMethodBeat.o(35441);
      return true;
    }
    if ((this.cOd.zgX.eKB()) && (locald.eWz() != null) && (((locald.eWz().Jc()) && (!((b)com.tencent.mm.kernel.g.ab(b.class)).bBQ())) || (locald.eWz().Jb())))
    {
      AppMethodBeat.o(35441);
      return true;
    }
    AppMethodBeat.o(35441);
    return false;
  }
  
  public final void YN(int paramInt)
  {
    AppMethodBeat.i(35440);
    if (eYh()) {}
    for (int i = 5; (this.GwR < i) || (this.GwP == null); i = 10)
    {
      AppMethodBeat.o(35440);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.GwP.getLayoutParams();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35440);
      return;
      localLayoutParams.setMargins(0, this.cOd.GzJ.getMMResources().getDimensionPixelSize(2131165480) * 3, 0, 0);
      AppMethodBeat.o(35440);
      return;
      ak localak = (ak)this.cOd.be(ak.class);
      int j;
      if (localak.eYE())
      {
        i = localak.eYG();
        if (!localak.eYF()) {
          break label261;
        }
        j = this.cOd.GzJ.getMMResources().getDimensionPixelSize(2131165511);
        label187:
        if (!localak.gai()) {
          break label266;
        }
        paramInt = this.cOd.GzJ.getMMResources().getDimensionPixelSize(2131165298);
        label213:
        if (j <= i) {
          break label274;
        }
        if (j <= paramInt) {
          break label271;
        }
        paramInt = j;
      }
      for (;;)
      {
        localLayoutParams.setMargins(0, this.cOd.GzJ.getMMResources().getDimensionPixelSize(2131165480) + paramInt, 0, 0);
        AppMethodBeat.o(35440);
        return;
        i = 0;
        break;
        label261:
        j = 0;
        break label187;
        label266:
        paramInt = 0;
        break label213;
        label271:
        continue;
        label274:
        if (i > paramInt) {
          paramInt = i;
        }
      }
      localLayoutParams.setMargins(0, this.cOd.GzJ.getMMResources().getDimensionPixelSize(2131165480), 0, 0);
      AppMethodBeat.o(35440);
      return;
      if (!((ak)this.cOd.be(ak.class)).eYE()) {
        localLayoutParams.setMargins(0, this.cOd.GzJ.getMMResources().getDimensionPixelSize(2131165480), 0, 0);
      }
    }
  }
  
  public final void eQA()
  {
    AppMethodBeat.i(35442);
    super.eQA();
    this.GwP = this.cOd.findViewById(2131298101);
    this.GwP.setVisibility(8);
    az.arV();
    am localam = com.tencent.mm.model.c.apR().aIn(this.cOd.getTalkerUserName());
    if (localam != null)
    {
      this.GwR = localam.field_unReadCount;
      ad.i("MicroMsg.HistoryMsgTongueComponent", "[onChattingInit] getUnDeliverCount:%s mUnreadMessageCount:%s", new Object[] { Integer.valueOf(localam.field_UnDeliverCount), Integer.valueOf(this.GwR) });
    }
    AppMethodBeat.o(35442);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35443);
    super.eQC();
    d locald = (d)this.cOd.be(d.class);
    if (locald.eWC()) {
      this.GwR = locald.eWL();
    }
    Object localObject = (d)this.cOd.be(d.class);
    if (((!bt.isNullOrNil(this.cOd.getTalkerUserName())) && (!this.cOd.eYZ()) && (!w.tl(this.cOd.getTalkerUserName())) && (!w.sE(this.cOd.getTalkerUserName())) && (!w.tg(this.cOd.getTalkerUserName())) && (!w.sH(this.cOd.getTalkerUserName()))) || (this.cOd.eZa()) || (((d)localObject).eWC()) || (eYh())) {}
    for (final int i = 1; i == 0; i = 0)
    {
      ad.w("MicroMsg.HistoryMsgTongueComponent", "[tryShowTongue] no show tongue! username:%s unreadCount:%s isBizChat:%s", new Object[] { this.cOd.getTalkerUserName(), Integer.valueOf(this.GwR), Boolean.valueOf(locald.eWC()) });
      this.GwP.setVisibility(8);
      this.GwS = 0;
      AppMethodBeat.o(35443);
      return;
    }
    int j = this.GwR;
    if (eYh())
    {
      i = 5;
      ad.i("MicroMsg.HistoryMsgTongueComponent", "[update] threshold:%s fixUnreadMessage:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j >= i)
      {
        ad.i("MicroMsg.HistoryMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout VISIBLE");
        this.GwQ = ((TextView)this.cOd.findViewById(2131298102));
        localObject = y.fjY;
        if (((y)localObject).fkc != null) {
          break label461;
        }
        ((y)localObject).fkd = 1;
        label323:
        if (j <= 999) {
          break label473;
        }
        this.GwQ.setText(String.format(this.cOd.GzJ.getMMResources().getString(2131757180), new Object[] { Integer.valueOf(999) }));
        label369:
        if (!locald.eWC()) {
          break label513;
        }
        az.arV();
      }
    }
    for (i = com.tencent.mm.model.c.apP().bY(this.cOd.getTalkerUserName(), locald.eWP()) - this.GwR;; i = com.tencent.mm.model.c.apO().agE(this.cOd.getTalkerUserName()) - this.GwR)
    {
      this.GwP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35435);
          aa.a(aa.this, 2);
          paramAnonymousView = y.fjY;
          if (paramAnonymousView.fkc != null) {
            paramAnonymousView.fkc.fkt = 2;
          }
          if (((r)aa.this.cOd.be(r.class)).eXF()) {
            ((r)aa.this.cOd.be(r.class)).eXG();
          }
          for (;;)
          {
            if (w.tn(aa.this.cOd.getTalkerUserName())) {
              ((com.tencent.mm.ui.chatting.c.b.g)aa.this.cOd.be(com.tencent.mm.ui.chatting.c.b.g.class)).eWZ();
            }
            AppMethodBeat.o(35435);
            return;
            aa.b(aa.this, i);
          }
        }
      });
      if (!((r)this.cOd.be(r.class)).eXF()) {
        eYe();
      }
      AppMethodBeat.o(35443);
      return;
      i = 10;
      break;
      label461:
      ((y)localObject).fkc.fkt = 1;
      break label323;
      label473:
      this.GwQ.setText(String.format(this.cOd.GzJ.getMMResources().getString(2131757180), new Object[] { Integer.valueOf(j) }));
      break label369;
      label513:
      az.arV();
    }
  }
  
  public final int eYc()
  {
    return this.GwR;
  }
  
  public final void eYd()
  {
    AppMethodBeat.i(35437);
    if (this.GwP == null)
    {
      AppMethodBeat.o(35437);
      return;
    }
    this.GwR = -1;
    if (this.GwP.getVisibility() == 0)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, this.GwP.getWidth(), 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.cOd.GzJ.getContext(), 17432581));
      this.GwP.startAnimation(localTranslateAnimation);
    }
    this.GwP.setVisibility(8);
    AppMethodBeat.o(35437);
  }
  
  public final void eYe()
  {
    AppMethodBeat.i(35438);
    if (eYh()) {}
    for (int i = 5; this.GwR <= i; i = 10)
    {
      ad.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] mUnreadMessageCount is smaller than threshold:".concat(String.valueOf(i)));
      this.GwP.setVisibility(8);
      AppMethodBeat.o(35438);
      return;
    }
    if (this.GwP.getVisibility() == 0)
    {
      ad.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] has show!!!");
      AppMethodBeat.o(35438);
      return;
    }
    this.GwP.removeCallbacks(this.awR);
    View localView = this.GwP;
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35436);
        ad.i("MicroMsg.HistoryMsgTongueComponent", "show animation! GoBackToHistoryMsgLayout!!!");
        aa.a(aa.this).setVisibility(0);
        aa.a(aa.this, 1);
        Object localObject = (ak)aa.this.cOd.be(ak.class);
        if ((((ak)localObject).eYE()) || (((ak)localObject).gai())) {
          aa.this.YN(1);
        }
        for (;;)
        {
          localObject = new TranslateAnimation(aa.a(aa.this).getWidth(), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject).setDuration(300L);
          ((TranslateAnimation)localObject).setInterpolator(AnimationUtils.loadInterpolator(aa.this.cOd.GzJ.getContext(), 17432581));
          aa.a(aa.this).startAnimation((Animation)localObject);
          AppMethodBeat.o(35436);
          return;
          if (aa.b(aa.this)) {
            aa.this.YN(3);
          } else {
            aa.this.YN(0);
          }
        }
      }
    };
    this.awR = local2;
    localView.postDelayed(local2, 100L);
    AppMethodBeat.o(35438);
  }
  
  public final void eYf()
  {
    this.GwS = 0;
  }
  
  public final int eYg()
  {
    return this.GwS;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35439);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((this.GwR > 0) && (paramInt3 - (paramInt1 + 1) >= this.GwR) && (this.GwP != null) && (this.GwP.getVisibility() == 0))
    {
      ad.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr jacks onScroll dismissMsgTongue mUnreadMessage[%d] [%d,%d]", new Object[] { Integer.valueOf(this.GwR), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1) });
      eYd();
    }
    AppMethodBeat.o(35439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.aa
 * JD-Core Version:    0.7.0.1
 */