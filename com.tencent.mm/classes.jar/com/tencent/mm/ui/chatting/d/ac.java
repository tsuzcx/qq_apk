package com.tencent.mm.ui.chatting.d;

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
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ap;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.h;
import com.tencent.mm.ui.chatting.d.b.t;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.z.class)
public class ac
  extends a
  implements com.tencent.mm.ui.chatting.d.b.z
{
  private View Kgb;
  private TextView Kgc;
  private int Kgd;
  private int Kge = 0;
  private Runnable azC;
  
  private boolean fIu()
  {
    AppMethodBeat.i(35441);
    d locald = (d)this.cXJ.bh(d.class);
    if ((x.AS(this.cXJ.getTalkerUserName())) || (x.AX(this.cXJ.getTalkerUserName())))
    {
      AppMethodBeat.o(35441);
      return true;
    }
    if ((this.cXJ.Cqh.fug()) && (locald.fGG() != null) && (((locald.fGG().Kt()) && (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOd())) || (locald.fGG().Ks())))
    {
      AppMethodBeat.o(35441);
      return true;
    }
    AppMethodBeat.o(35441);
    return false;
  }
  
  public final void adR(int paramInt)
  {
    AppMethodBeat.i(35440);
    if (fIu()) {}
    for (int i = 5; (this.Kgd < i) || (this.Kgb == null); i = 10)
    {
      AppMethodBeat.o(35440);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.Kgb.getLayoutParams();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35440);
      return;
      localLayoutParams.setMargins(0, this.cXJ.Kkd.getMMResources().getDimensionPixelSize(2131165480) * 3, 0, 0);
      AppMethodBeat.o(35440);
      return;
      ap localap = (ap)this.cXJ.bh(ap.class);
      int j;
      if (localap.fIX())
      {
        i = localap.fJa();
        if (!localap.fIY()) {
          break label261;
        }
        j = this.cXJ.Kkd.getMMResources().getDimensionPixelSize(2131165511);
        label187:
        if (!localap.fIZ()) {
          break label266;
        }
        paramInt = this.cXJ.Kkd.getMMResources().getDimensionPixelSize(2131165298);
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
        localLayoutParams.setMargins(0, this.cXJ.Kkd.getMMResources().getDimensionPixelSize(2131165480) + paramInt, 0, 0);
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
      localLayoutParams.setMargins(0, this.cXJ.Kkd.getMMResources().getDimensionPixelSize(2131165480), 0, 0);
      AppMethodBeat.o(35440);
      return;
      if (!((ap)this.cXJ.bh(ap.class)).fIX()) {
        localLayoutParams.setMargins(0, this.cXJ.Kkd.getMMResources().getDimensionPixelSize(2131165480), 0, 0);
      }
    }
  }
  
  public final void fAs()
  {
    AppMethodBeat.i(35442);
    super.fAs();
    this.Kgb = this.cXJ.findViewById(2131298101);
    this.Kgb.setVisibility(8);
    if (((h)this.cXJ.bh(h.class)).fHo()) {
      this.Kgd = ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).ajc(this.cXJ.getTalkerUserName());
    }
    for (;;)
    {
      ae.i("MicroMsg.HistoryMsgTongueComponent", "[onChattingInit] mUnreadMessageCount:%s", new Object[] { Integer.valueOf(this.Kgd) });
      AppMethodBeat.o(35442);
      return;
      if (((com.tencent.mm.ui.chatting.d.b.i)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.i.class)).fHq())
      {
        this.Kgd = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).ajc(this.cXJ.getTalkerUserName());
      }
      else
      {
        bc.aCg();
        au localau = com.tencent.mm.model.c.azL().aVa(this.cXJ.getTalkerUserName());
        if (localau != null) {
          this.Kgd = localau.field_unReadCount;
        }
      }
    }
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35443);
    super.fAu();
    d locald = (d)this.cXJ.bh(d.class);
    if (locald.fGJ()) {
      this.Kgd = locald.fGS();
    }
    Object localObject = (d)this.cXJ.bh(d.class);
    if (((!bu.isNullOrNil(this.cXJ.getTalkerUserName())) && (!this.cXJ.fJA()) && (!x.AV(this.cXJ.getTalkerUserName())) && (!x.Ao(this.cXJ.getTalkerUserName())) && (!x.AQ(this.cXJ.getTalkerUserName())) && (!x.Ar(this.cXJ.getTalkerUserName()))) || (this.cXJ.fJB()) || (((d)localObject).fGJ()) || (fIu())) {}
    for (final int i = 1; i == 0; i = 0)
    {
      ae.w("MicroMsg.HistoryMsgTongueComponent", "[tryShowTongue] no show tongue! username:%s unreadCount:%s isBizChat:%s", new Object[] { this.cXJ.getTalkerUserName(), Integer.valueOf(this.Kgd), Boolean.valueOf(locald.fGJ()) });
      this.Kgb.setVisibility(8);
      this.Kge = 0;
      AppMethodBeat.o(35443);
      return;
    }
    int j = this.Kgd;
    if (fIu())
    {
      i = 5;
      ae.i("MicroMsg.HistoryMsgTongueComponent", "[update] threshold:%s fixUnreadMessage:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j >= i)
      {
        ae.i("MicroMsg.HistoryMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout VISIBLE");
        this.Kgc = ((TextView)this.cXJ.findViewById(2131298102));
        localObject = com.tencent.mm.booter.z.fHE;
        if (((com.tencent.mm.booter.z)localObject).fHI != null) {
          break label461;
        }
        ((com.tencent.mm.booter.z)localObject).fHJ = 1;
        label323:
        if (j <= 999) {
          break label473;
        }
        this.Kgc.setText(String.format(this.cXJ.Kkd.getMMResources().getString(2131757180), new Object[] { Integer.valueOf(999) }));
        label369:
        if (!locald.fGJ()) {
          break label513;
        }
        bc.aCg();
      }
    }
    for (i = com.tencent.mm.model.c.azJ().cf(this.cXJ.getTalkerUserName(), locald.fGW()) - this.Kgd;; i = com.tencent.mm.model.c.azI().arr(this.cXJ.getTalkerUserName()) - this.Kgd)
    {
      this.Kgb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35435);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HistoryMsgTongueComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ac.a(ac.this, 2);
          paramAnonymousView = com.tencent.mm.booter.z.fHE;
          if (paramAnonymousView.fHI != null) {
            paramAnonymousView.fHI.fHZ = 2;
          }
          if (((t)ac.this.cXJ.bh(t.class)).fHS()) {
            ((t)ac.this.cXJ.bh(t.class)).fHT();
          }
          for (;;)
          {
            if (x.AX(ac.this.cXJ.getTalkerUserName())) {
              ((com.tencent.mm.ui.chatting.d.b.g)ac.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.g.class)).fHh();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HistoryMsgTongueComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35435);
            return;
            ac.b(ac.this, i);
          }
        }
      });
      if (!((t)this.cXJ.bh(t.class)).fHS()) {
        fIr();
      }
      AppMethodBeat.o(35443);
      return;
      i = 10;
      break;
      label461:
      ((com.tencent.mm.booter.z)localObject).fHI.fHZ = 1;
      break label323;
      label473:
      this.Kgc.setText(String.format(this.cXJ.Kkd.getMMResources().getString(2131757180), new Object[] { Integer.valueOf(j) }));
      break label369;
      label513:
      bc.aCg();
    }
  }
  
  public final int fIp()
  {
    return this.Kgd;
  }
  
  public final void fIq()
  {
    AppMethodBeat.i(35437);
    if (this.Kgb == null)
    {
      AppMethodBeat.o(35437);
      return;
    }
    this.Kgd = -1;
    if (this.Kgb.getVisibility() == 0)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, this.Kgb.getWidth(), 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.cXJ.Kkd.getContext(), 17432581));
      this.Kgb.startAnimation(localTranslateAnimation);
    }
    this.Kgb.setVisibility(8);
    AppMethodBeat.o(35437);
  }
  
  public final void fIr()
  {
    AppMethodBeat.i(35438);
    if (fIu()) {}
    for (int i = 5; this.Kgd <= i; i = 10)
    {
      ae.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] mUnreadMessageCount is smaller than threshold:".concat(String.valueOf(i)));
      this.Kgb.setVisibility(8);
      AppMethodBeat.o(35438);
      return;
    }
    if (this.Kgb.getVisibility() == 0)
    {
      ae.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] has show!!!");
      AppMethodBeat.o(35438);
      return;
    }
    this.Kgb.removeCallbacks(this.azC);
    View localView = this.Kgb;
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35436);
        ae.i("MicroMsg.HistoryMsgTongueComponent", "show animation! GoBackToHistoryMsgLayout!!!");
        ac.a(ac.this).setVisibility(0);
        ac.a(ac.this, 1);
        Object localObject = (ap)ac.this.cXJ.bh(ap.class);
        if ((((ap)localObject).fIX()) || (((ap)localObject).fIZ()) || (((ap)localObject).fIY())) {
          ac.this.adR(1);
        }
        for (;;)
        {
          localObject = new TranslateAnimation(ac.a(ac.this).getWidth(), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject).setDuration(300L);
          ((TranslateAnimation)localObject).setInterpolator(AnimationUtils.loadInterpolator(ac.this.cXJ.Kkd.getContext(), 17432581));
          ac.a(ac.this).startAnimation((Animation)localObject);
          AppMethodBeat.o(35436);
          return;
          if (ac.b(ac.this)) {
            ac.this.adR(3);
          } else {
            ac.this.adR(0);
          }
        }
      }
    };
    this.azC = local2;
    localView.postDelayed(local2, 100L);
    AppMethodBeat.o(35438);
  }
  
  public final void fIs()
  {
    this.Kge = 0;
  }
  
  public final int fIt()
  {
    return this.Kge;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35439);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((this.Kgd > 0) && (paramInt3 - (paramInt1 + 1) >= this.Kgd) && (this.Kgb != null) && (this.Kgb.getVisibility() == 0))
    {
      ae.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr jacks onScroll dismissMsgTongue mUnreadMessage[%d] [%d,%d]", new Object[] { Integer.valueOf(this.Kgd), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1) });
      fIq();
    }
    AppMethodBeat.o(35439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ac
 * JD-Core Version:    0.7.0.1
 */