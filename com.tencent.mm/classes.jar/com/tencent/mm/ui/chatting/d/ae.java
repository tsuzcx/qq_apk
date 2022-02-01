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
import com.tencent.mm.booter.z;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.i.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.h;
import com.tencent.mm.ui.chatting.d.b.v;

@com.tencent.mm.ui.chatting.d.a.a(gRF=com.tencent.mm.ui.chatting.d.b.ab.class)
public class ae
  extends a
  implements com.tencent.mm.ui.chatting.d.b.ab
{
  private View PrT;
  private TextView PrU;
  private int PrV;
  private int PrW = 0;
  private Runnable azA;
  
  private boolean gQF()
  {
    AppMethodBeat.i(35441);
    d locald = (d)this.dom.bh(d.class);
    if ((com.tencent.mm.model.ab.Jx(this.dom.getTalkerUserName())) || (com.tencent.mm.model.ab.JC(this.dom.getTalkerUserName())))
    {
      AppMethodBeat.o(35441);
      return true;
    }
    if ((this.dom.GUe.gBM()) && (locald.gOM() != null) && (((locald.gOM().UD()) && (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).clc())) || (locald.gOM().UC())))
    {
      AppMethodBeat.o(35441);
      return true;
    }
    AppMethodBeat.o(35441);
    return false;
  }
  
  public final void amC(int paramInt)
  {
    AppMethodBeat.i(35440);
    if (gQF()) {}
    for (int i = 5; (this.PrV < i) || (this.PrT == null); i = 10)
    {
      AppMethodBeat.o(35440);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.PrT.getLayoutParams();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35440);
      return;
      localLayoutParams.setMargins(0, this.dom.Pwc.getMMResources().getDimensionPixelSize(2131165498) * 3, 0, 0);
      AppMethodBeat.o(35440);
      return;
      com.tencent.mm.ui.chatting.d.b.as localas = (com.tencent.mm.ui.chatting.d.b.as)this.dom.bh(com.tencent.mm.ui.chatting.d.b.as.class);
      int j;
      if (localas.gRh())
      {
        i = localas.gRk();
        if (!localas.gRi()) {
          break label261;
        }
        j = this.dom.Pwc.getMMResources().getDimensionPixelSize(2131165529);
        label187:
        if (!localas.gRj()) {
          break label266;
        }
        paramInt = this.dom.Pwc.getMMResources().getDimensionPixelSize(2131165308);
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
        localLayoutParams.setMargins(0, this.dom.Pwc.getMMResources().getDimensionPixelSize(2131165498) + paramInt, 0, 0);
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
      localLayoutParams.setMargins(0, this.dom.Pwc.getMMResources().getDimensionPixelSize(2131165498), 0, 0);
      AppMethodBeat.o(35440);
      return;
      if (!((com.tencent.mm.ui.chatting.d.b.as)this.dom.bh(com.tencent.mm.ui.chatting.d.b.as.class)).gRh()) {
        localLayoutParams.setMargins(0, this.dom.Pwc.getMMResources().getDimensionPixelSize(2131165498), 0, 0);
      }
    }
  }
  
  public final void gIk()
  {
    AppMethodBeat.i(35442);
    super.gIk();
    this.PrT = this.dom.findViewById(2131298451);
    this.PrT.setVisibility(8);
    if (((h)this.dom.bh(h.class)).gPu()) {
      this.PrV = ((n)com.tencent.mm.kernel.g.af(n.class)).avf(this.dom.getTalkerUserName());
    }
    for (;;)
    {
      Log.i("MicroMsg.HistoryMsgTongueComponent", "[onChattingInit] mUnreadMessageCount:%s", new Object[] { Integer.valueOf(this.PrV) });
      AppMethodBeat.o(35442);
      return;
      if (((com.tencent.mm.ui.chatting.d.b.i)this.dom.bh(com.tencent.mm.ui.chatting.d.b.i.class)).gPw())
      {
        this.PrV = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.c.class)).avf(this.dom.getTalkerUserName());
      }
      else
      {
        bg.aVF();
        az localaz = com.tencent.mm.model.c.aST().bjY(this.dom.getTalkerUserName());
        if (localaz != null) {
          this.PrV = localaz.field_unReadCount;
        }
      }
    }
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35443);
    super.gIm();
    d locald = (d)this.dom.bh(d.class);
    if (locald.gOP()) {
      this.PrV = locald.gOY();
    }
    Object localObject = (d)this.dom.bh(d.class);
    if (((!Util.isNullOrNil(this.dom.getTalkerUserName())) && (!this.dom.gRK()) && (!com.tencent.mm.model.ab.JA(this.dom.getTalkerUserName())) && (!com.tencent.mm.model.ab.IT(this.dom.getTalkerUserName())) && (!com.tencent.mm.model.ab.Jv(this.dom.getTalkerUserName())) && (!com.tencent.mm.model.ab.IW(this.dom.getTalkerUserName()))) || (this.dom.gRL()) || (((d)localObject).gOP()) || (gQF())) {}
    for (final int i = 1; i == 0; i = 0)
    {
      Log.w("MicroMsg.HistoryMsgTongueComponent", "[tryShowTongue] no show tongue! username:%s unreadCount:%s isBizChat:%s", new Object[] { this.dom.getTalkerUserName(), Integer.valueOf(this.PrV), Boolean.valueOf(locald.gOP()) });
      this.PrT.setVisibility(8);
      this.PrW = 0;
      AppMethodBeat.o(35443);
      return;
    }
    int j = this.PrV;
    if (gQF())
    {
      i = 5;
      Log.i("MicroMsg.HistoryMsgTongueComponent", "[update] threshold:%s fixUnreadMessage:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j >= i)
      {
        Log.i("MicroMsg.HistoryMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout VISIBLE");
        this.PrU = ((TextView)this.dom.findViewById(2131298452));
        localObject = z.gmQ;
        if (((z)localObject).gmU != null) {
          break label461;
        }
        ((z)localObject).gmV = 1;
        label323:
        if (j <= 999) {
          break label473;
        }
        this.PrU.setText(String.format(this.dom.Pwc.getMMResources().getString(2131757384), new Object[] { Integer.valueOf(999) }));
        label369:
        if (!locald.gOP()) {
          break label513;
        }
        bg.aVF();
      }
    }
    for (i = com.tencent.mm.model.c.aSR().cb(this.dom.getTalkerUserName(), locald.gPc()) - this.PrV;; i = com.tencent.mm.model.c.aSQ().aEM(this.dom.getTalkerUserName()) - this.PrV)
    {
      this.PrT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35435);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HistoryMsgTongueComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          ae.a(ae.this, 2);
          paramAnonymousView = z.gmQ;
          if (paramAnonymousView.gmU != null) {
            paramAnonymousView.gmU.gnl = 2;
          }
          if (((v)ae.this.dom.bh(v.class)).gQb()) {
            ((v)ae.this.dom.bh(v.class)).gQc();
          }
          for (;;)
          {
            if (com.tencent.mm.model.ab.JC(ae.this.dom.getTalkerUserName())) {
              ((com.tencent.mm.ui.chatting.d.b.g)ae.this.dom.bh(com.tencent.mm.ui.chatting.d.b.g.class)).gPn();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HistoryMsgTongueComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35435);
            return;
            ae.b(ae.this, i);
          }
        }
      });
      if (!((v)this.dom.bh(v.class)).gQb()) {
        gQC();
      }
      AppMethodBeat.o(35443);
      return;
      i = 10;
      break;
      label461:
      ((z)localObject).gmU.gnl = 1;
      break label323;
      label473:
      this.PrU.setText(String.format(this.dom.Pwc.getMMResources().getString(2131757384), new Object[] { Integer.valueOf(j) }));
      break label369;
      label513:
      bg.aVF();
    }
  }
  
  public final int gQA()
  {
    return this.PrV;
  }
  
  public final void gQB()
  {
    AppMethodBeat.i(35437);
    if (this.PrT == null)
    {
      AppMethodBeat.o(35437);
      return;
    }
    this.PrV = -1;
    if (this.PrT.getVisibility() == 0)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, this.PrT.getWidth(), 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.dom.Pwc.getContext(), 17432581));
      this.PrT.startAnimation(localTranslateAnimation);
    }
    this.PrT.setVisibility(8);
    AppMethodBeat.o(35437);
  }
  
  public final void gQC()
  {
    AppMethodBeat.i(35438);
    if (gQF()) {}
    for (int i = 5; this.PrV <= i; i = 10)
    {
      Log.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] mUnreadMessageCount is smaller than threshold:".concat(String.valueOf(i)));
      this.PrT.setVisibility(8);
      AppMethodBeat.o(35438);
      return;
    }
    if (this.PrT.getVisibility() == 0)
    {
      Log.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] has show!!!");
      AppMethodBeat.o(35438);
      return;
    }
    this.PrT.removeCallbacks(this.azA);
    View localView = this.PrT;
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35436);
        Log.i("MicroMsg.HistoryMsgTongueComponent", "show animation! GoBackToHistoryMsgLayout!!!");
        ae.a(ae.this).setVisibility(0);
        ae.a(ae.this, 1);
        Object localObject = (com.tencent.mm.ui.chatting.d.b.as)ae.this.dom.bh(com.tencent.mm.ui.chatting.d.b.as.class);
        if ((((com.tencent.mm.ui.chatting.d.b.as)localObject).gRh()) || (((com.tencent.mm.ui.chatting.d.b.as)localObject).gRj()) || (((com.tencent.mm.ui.chatting.d.b.as)localObject).gRi())) {
          ae.this.amC(1);
        }
        for (;;)
        {
          localObject = new TranslateAnimation(ae.a(ae.this).getWidth(), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject).setDuration(300L);
          ((TranslateAnimation)localObject).setInterpolator(AnimationUtils.loadInterpolator(ae.this.dom.Pwc.getContext(), 17432581));
          ae.a(ae.this).startAnimation((Animation)localObject);
          AppMethodBeat.o(35436);
          return;
          if (ae.b(ae.this)) {
            ae.this.amC(3);
          } else {
            ae.this.amC(0);
          }
        }
      }
    };
    this.azA = local2;
    localView.postDelayed(local2, 100L);
    AppMethodBeat.o(35438);
  }
  
  public final void gQD()
  {
    this.PrW = 0;
  }
  
  public final int gQE()
  {
    return this.PrW;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35439);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((this.PrV > 0) && (paramInt3 - (paramInt1 + 1) >= this.PrV) && (this.PrT != null) && (this.PrT.getVisibility() == 0))
    {
      Log.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr jacks onScroll dismissMsgTongue mUnreadMessage[%d] [%d,%d]", new Object[] { Integer.valueOf(this.PrV), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1) });
      gQB();
    }
    AppMethodBeat.o(35439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ae
 * JD-Core Version:    0.7.0.1
 */