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
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.booter.z;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.findersdk.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.g;
import com.tencent.mm.ui.chatting.d.b.v;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.ab.class)
public class af
  extends a
  implements com.tencent.mm.ui.chatting.d.b.ab
{
  private View WMt;
  private TextView WMu;
  private int WMv;
  private int WMw = 0;
  private int mVisibleItemCount = 0;
  private Runnable xD;
  
  private boolean hQc()
  {
    AppMethodBeat.i(35441);
    d locald = (d)this.fgR.bC(d.class);
    if ((com.tencent.mm.model.ab.QQ(this.fgR.getTalkerUserName())) || (com.tencent.mm.model.ab.QV(this.fgR.getTalkerUserName())))
    {
      AppMethodBeat.o(35441);
      return true;
    }
    if ((this.fgR.NKq.hxX()) && (locald.hOb() != null))
    {
      if (locald.hOb().YV()) {
        com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
      }
      if (locald.hOb().YU())
      {
        AppMethodBeat.o(35441);
        return true;
      }
    }
    AppMethodBeat.o(35441);
    return false;
  }
  
  public final void avD(int paramInt)
  {
    AppMethodBeat.i(35440);
    if (hQc()) {}
    for (int i = 5; (this.WMv < i) || (this.WMt == null); i = 10)
    {
      AppMethodBeat.o(35440);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.WMt.getLayoutParams();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35440);
      return;
      localLayoutParams.setMargins(0, this.fgR.WQv.getMMResources().getDimensionPixelSize(R.f.LargePadding) * 3, 0, 0);
      AppMethodBeat.o(35440);
      return;
      at localat = (at)this.fgR.bC(at.class);
      int j;
      if (localat.hQE())
      {
        i = localat.hQH();
        if (!localat.hQF()) {
          break label265;
        }
        j = this.fgR.WQv.getMMResources().getDimensionPixelSize(R.f.NormalButtonHeight);
        label189:
        if (!localat.hQG()) {
          break label270;
        }
        paramInt = this.fgR.WQv.getMMResources().getDimensionPixelSize(R.f.Edge_6A);
        label216:
        if (j <= i) {
          break label278;
        }
        if (j <= paramInt) {
          break label275;
        }
        paramInt = j;
      }
      for (;;)
      {
        localLayoutParams.setMargins(0, this.fgR.WQv.getMMResources().getDimensionPixelSize(R.f.LargePadding) + paramInt, 0, 0);
        AppMethodBeat.o(35440);
        return;
        i = 0;
        break;
        label265:
        j = 0;
        break label189;
        label270:
        paramInt = 0;
        break label216;
        label275:
        continue;
        label278:
        if (i > paramInt) {
          paramInt = i;
        }
      }
      localLayoutParams.setMargins(0, this.fgR.WQv.getMMResources().getDimensionPixelSize(R.f.LargePadding), 0, 0);
      AppMethodBeat.o(35440);
      return;
      if (!((at)this.fgR.bC(at.class)).hQE()) {
        localLayoutParams.setMargins(0, this.fgR.WQv.getMMResources().getDimensionPixelSize(R.f.LargePadding), 0, 0);
      }
    }
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(35442);
    super.hGU();
    this.WMt = this.fgR.findViewById(R.h.dxJ);
    this.WMt.setVisibility(8);
    if (((com.tencent.mm.ui.chatting.d.b.h)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.h.class)).hOK()) {
      this.WMv = ((n)com.tencent.mm.kernel.h.ae(n.class)).aEz(this.fgR.getTalkerUserName());
    }
    for (;;)
    {
      Log.i("MicroMsg.HistoryMsgTongueComponent", "[onChattingInit] mUnreadMessageCount:%s", new Object[] { Integer.valueOf(this.WMv) });
      AppMethodBeat.o(35442);
      return;
      if (((com.tencent.mm.ui.chatting.d.b.i)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.i.class)).hOP())
      {
        this.WMv = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).aEz(this.fgR.getTalkerUserName());
      }
      else
      {
        bh.beI();
        az localaz = com.tencent.mm.model.c.bbR().bwx(this.fgR.getTalkerUserName());
        if (localaz != null) {
          this.WMv = localaz.field_unReadCount;
        }
      }
    }
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35443);
    super.hGW();
    d locald = (d)this.fgR.bC(d.class);
    if (locald.hOe()) {
      this.WMv = locald.hOo();
    }
    this.fgR.bC(d.class);
    if (((!Util.isNullOrNil(this.fgR.getTalkerUserName())) && (!this.fgR.hRg()) && (!com.tencent.mm.model.ab.QT(this.fgR.getTalkerUserName())) && (!com.tencent.mm.model.ab.Qm(this.fgR.getTalkerUserName())) && (!com.tencent.mm.model.ab.QO(this.fgR.getTalkerUserName())) && (!com.tencent.mm.model.ab.Qp(this.fgR.getTalkerUserName()))) || (this.fgR.hRh()) || (hQc())) {}
    for (final int i = 1; i == 0; i = 0)
    {
      Log.w("MicroMsg.HistoryMsgTongueComponent", "[tryShowTongue] no show tongue! username:%s unreadCount:%s isBizChat:%s", new Object[] { this.fgR.getTalkerUserName(), Integer.valueOf(this.WMv), Boolean.valueOf(locald.hOe()) });
      this.WMt.setVisibility(8);
      this.WMw = 0;
      AppMethodBeat.o(35443);
      return;
    }
    int j = this.WMv;
    z localz;
    if (hQc())
    {
      i = 5;
      Log.i("MicroMsg.HistoryMsgTongueComponent", "[update] threshold:%s fixUnreadMessage:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j >= i)
      {
        Log.i("MicroMsg.HistoryMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout VISIBLE");
        this.WMu = ((TextView)this.fgR.findViewById(R.h.dxK));
        localz = z.iQZ;
        if (localz.iRd != null) {
          break label450;
        }
        localz.iRe = 1;
        label312:
        if (j <= 999) {
          break label462;
        }
        this.WMu.setText(String.format(this.fgR.WQv.getMMResources().getString(R.l.evb), new Object[] { Integer.valueOf(999) }));
        label358:
        if (!locald.hOe()) {
          break label502;
        }
        bh.beI();
      }
    }
    for (i = com.tencent.mm.model.c.bbP().ci(this.fgR.getTalkerUserName(), locald.hOs()) - this.WMv;; i = com.tencent.mm.model.c.bbO().aOW(this.fgR.getTalkerUserName()) - this.WMv)
    {
      this.WMt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35435);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/HistoryMsgTongueComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          af.a(af.this, 2);
          paramAnonymousView = z.iQZ;
          if (paramAnonymousView.iRd != null) {
            paramAnonymousView.iRd.iRu = 2;
          }
          if (((v)af.this.fgR.bC(v.class)).hPw()) {
            ((v)af.this.fgR.bC(v.class)).hPx();
          }
          for (;;)
          {
            if (com.tencent.mm.model.ab.QV(af.this.fgR.getTalkerUserName())) {
              ((g)af.this.fgR.bC(g.class)).hOD();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HistoryMsgTongueComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35435);
            return;
            af.b(af.this, i);
          }
        }
      });
      if (!((v)this.fgR.bC(v.class)).hPw()) {
        hPZ();
      }
      AppMethodBeat.o(35443);
      return;
      i = 10;
      break;
      label450:
      localz.iRd.iRu = 1;
      break label312;
      label462:
      this.WMu.setText(String.format(this.fgR.WQv.getMMResources().getString(R.l.evb), new Object[] { Integer.valueOf(j) }));
      break label358;
      label502:
      bh.beI();
    }
  }
  
  public final int hPX()
  {
    return this.WMv;
  }
  
  public final void hPY()
  {
    AppMethodBeat.i(35437);
    if (this.WMt == null)
    {
      AppMethodBeat.o(35437);
      return;
    }
    this.WMv = -1;
    if (this.WMt.getVisibility() == 0)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, this.WMt.getWidth(), 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.fgR.WQv.getContext(), 17432581));
      this.WMt.startAnimation(localTranslateAnimation);
    }
    this.WMt.setVisibility(8);
    AppMethodBeat.o(35437);
  }
  
  public final void hPZ()
  {
    AppMethodBeat.i(35438);
    if (hQc()) {}
    for (int i = 5; this.WMv <= i; i = 10)
    {
      Log.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] mUnreadMessageCount is smaller than threshold:".concat(String.valueOf(i)));
      this.WMt.setVisibility(8);
      AppMethodBeat.o(35438);
      return;
    }
    if (this.WMt.getVisibility() == 0)
    {
      Log.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] has show!!!");
      AppMethodBeat.o(35438);
      return;
    }
    if ((com.tencent.mm.model.ab.QQ(this.fgR.getTalkerUserName())) && (this.WMv <= this.mVisibleItemCount))
    {
      Log.i("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] has fold message cell");
      AppMethodBeat.o(35438);
      return;
    }
    this.WMt.removeCallbacks(this.xD);
    View localView = this.WMt;
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35436);
        Log.i("MicroMsg.HistoryMsgTongueComponent", "show animation! GoBackToHistoryMsgLayout!!!");
        af.a(af.this).setVisibility(0);
        af.a(af.this, 1);
        Object localObject = (at)af.this.fgR.bC(at.class);
        if ((((at)localObject).hQE()) || (((at)localObject).hQG()) || (((at)localObject).hQF())) {
          af.this.avD(1);
        }
        for (;;)
        {
          localObject = new TranslateAnimation(af.a(af.this).getWidth(), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject).setDuration(300L);
          ((TranslateAnimation)localObject).setInterpolator(AnimationUtils.loadInterpolator(af.this.fgR.WQv.getContext(), 17432581));
          af.a(af.this).startAnimation((Animation)localObject);
          AppMethodBeat.o(35436);
          return;
          if (af.b(af.this)) {
            af.this.avD(3);
          } else {
            af.this.avD(0);
          }
        }
      }
    };
    this.xD = local2;
    localView.postDelayed(local2, 100L);
    AppMethodBeat.o(35438);
  }
  
  public final void hQa()
  {
    this.WMw = 0;
  }
  
  public final int hQb()
  {
    return this.WMw;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35439);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    this.mVisibleItemCount = paramInt2;
    if ((this.WMv > 0) && (paramInt3 - (paramInt1 + 1) >= this.WMv) && (this.WMt != null) && (this.WMt.getVisibility() == 0))
    {
      Log.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr jacks onScroll dismissMsgTongue mUnreadMessage[%d] [%d,%d]", new Object[] { Integer.valueOf(this.WMv), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1) });
      hPY();
    }
    AppMethodBeat.o(35439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.af
 * JD-Core Version:    0.7.0.1
 */