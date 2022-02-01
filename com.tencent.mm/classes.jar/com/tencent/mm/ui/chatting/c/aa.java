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
import com.tencent.mm.booter.z;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.p;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ak;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.x;

@com.tencent.mm.ui.chatting.c.a.a(foJ=x.class)
public class aa
  extends a
  implements x
{
  private View HWG;
  private TextView HWH;
  private int HWI;
  private int HWJ = 0;
  private Runnable axL;
  
  private boolean fnT()
  {
    AppMethodBeat.i(35441);
    d locald = (d)this.cLy.bf(d.class);
    if ((w.xl(this.cLy.getTalkerUserName())) || (w.xq(this.cLy.getTalkerUserName())))
    {
      AppMethodBeat.o(35441);
      return true;
    }
    if ((this.cLy.AzG.fad()) && (locald.fml() != null) && (((locald.fml().IL()) && (!((b)com.tencent.mm.kernel.g.ab(b.class)).bIO())) || (locald.fml().IK())))
    {
      AppMethodBeat.o(35441);
      return true;
    }
    AppMethodBeat.o(35441);
    return false;
  }
  
  public final void aaY(int paramInt)
  {
    AppMethodBeat.i(35440);
    if (fnT()) {}
    for (int i = 5; (this.HWI < i) || (this.HWG == null); i = 10)
    {
      AppMethodBeat.o(35440);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.HWG.getLayoutParams();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35440);
      return;
      localLayoutParams.setMargins(0, this.cLy.HZF.getMMResources().getDimensionPixelSize(2131165480) * 3, 0, 0);
      AppMethodBeat.o(35440);
      return;
      ak localak = (ak)this.cLy.bf(ak.class);
      int j;
      if (localak.foq())
      {
        i = localak.fot();
        if (!localak.jdMethod_for()) {
          break label261;
        }
        j = this.cLy.HZF.getMMResources().getDimensionPixelSize(2131165511);
        label187:
        if (!localak.fos()) {
          break label266;
        }
        paramInt = this.cLy.HZF.getMMResources().getDimensionPixelSize(2131165298);
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
        localLayoutParams.setMargins(0, this.cLy.HZF.getMMResources().getDimensionPixelSize(2131165480) + paramInt, 0, 0);
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
      localLayoutParams.setMargins(0, this.cLy.HZF.getMMResources().getDimensionPixelSize(2131165480), 0, 0);
      AppMethodBeat.o(35440);
      return;
      if (!((ak)this.cLy.bf(ak.class)).foq()) {
        localLayoutParams.setMargins(0, this.cLy.HZF.getMMResources().getDimensionPixelSize(2131165480), 0, 0);
      }
    }
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(35442);
    super.fgg();
    this.HWG = this.cLy.findViewById(2131298101);
    this.HWG.setVisibility(8);
    com.tencent.mm.model.az.ayM();
    ap localap = com.tencent.mm.model.c.awG().aNI(this.cLy.getTalkerUserName());
    if (localap != null)
    {
      this.HWI = localap.field_unReadCount;
      ac.i("MicroMsg.HistoryMsgTongueComponent", "[onChattingInit] getUnDeliverCount:%s mUnreadMessageCount:%s", new Object[] { Integer.valueOf(localap.field_UnDeliverCount), Integer.valueOf(this.HWI) });
    }
    AppMethodBeat.o(35442);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35443);
    super.fgi();
    d locald = (d)this.cLy.bf(d.class);
    if (locald.fmo()) {
      this.HWI = locald.fmx();
    }
    Object localObject = (d)this.cLy.bf(d.class);
    if (((!bs.isNullOrNil(this.cLy.getTalkerUserName())) && (!this.cLy.foO()) && (!w.xo(this.cLy.getTalkerUserName())) && (!w.wH(this.cLy.getTalkerUserName())) && (!w.xj(this.cLy.getTalkerUserName())) && (!w.wK(this.cLy.getTalkerUserName()))) || (this.cLy.foP()) || (((d)localObject).fmo()) || (fnT())) {}
    for (final int i = 1; i == 0; i = 0)
    {
      ac.w("MicroMsg.HistoryMsgTongueComponent", "[tryShowTongue] no show tongue! username:%s unreadCount:%s isBizChat:%s", new Object[] { this.cLy.getTalkerUserName(), Integer.valueOf(this.HWI), Boolean.valueOf(locald.fmo()) });
      this.HWG.setVisibility(8);
      this.HWJ = 0;
      AppMethodBeat.o(35443);
      return;
    }
    int j = this.HWI;
    if (fnT())
    {
      i = 5;
      ac.i("MicroMsg.HistoryMsgTongueComponent", "[update] threshold:%s fixUnreadMessage:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j >= i)
      {
        ac.i("MicroMsg.HistoryMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout VISIBLE");
        this.HWH = ((TextView)this.cLy.findViewById(2131298102));
        localObject = z.fns;
        if (((z)localObject).fnw != null) {
          break label461;
        }
        ((z)localObject).fnx = 1;
        label323:
        if (j <= 999) {
          break label473;
        }
        this.HWH.setText(String.format(this.cLy.HZF.getMMResources().getString(2131757180), new Object[] { Integer.valueOf(999) }));
        label369:
        if (!locald.fmo()) {
          break label513;
        }
        com.tencent.mm.model.az.ayM();
      }
    }
    for (i = com.tencent.mm.model.c.awE().ca(this.cLy.getTalkerUserName(), locald.fmB()) - this.HWI;; i = com.tencent.mm.model.c.awD().aly(this.cLy.getTalkerUserName()) - this.HWI)
    {
      this.HWG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35435);
          aa.a(aa.this, 2);
          paramAnonymousView = z.fns;
          if (paramAnonymousView.fnw != null) {
            paramAnonymousView.fnw.fnN = 2;
          }
          if (((r)aa.this.cLy.bf(r.class)).fnr()) {
            ((r)aa.this.cLy.bf(r.class)).fns();
          }
          for (;;)
          {
            if (w.xq(aa.this.cLy.getTalkerUserName())) {
              ((com.tencent.mm.ui.chatting.c.b.g)aa.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.g.class)).fmL();
            }
            AppMethodBeat.o(35435);
            return;
            aa.b(aa.this, i);
          }
        }
      });
      if (!((r)this.cLy.bf(r.class)).fnr()) {
        fnQ();
      }
      AppMethodBeat.o(35443);
      return;
      i = 10;
      break;
      label461:
      ((z)localObject).fnw.fnN = 1;
      break label323;
      label473:
      this.HWH.setText(String.format(this.cLy.HZF.getMMResources().getString(2131757180), new Object[] { Integer.valueOf(j) }));
      break label369;
      label513:
      com.tencent.mm.model.az.ayM();
    }
  }
  
  public final int fnO()
  {
    return this.HWI;
  }
  
  public final void fnP()
  {
    AppMethodBeat.i(35437);
    if (this.HWG == null)
    {
      AppMethodBeat.o(35437);
      return;
    }
    this.HWI = -1;
    if (this.HWG.getVisibility() == 0)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, this.HWG.getWidth(), 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.cLy.HZF.getContext(), 17432581));
      this.HWG.startAnimation(localTranslateAnimation);
    }
    this.HWG.setVisibility(8);
    AppMethodBeat.o(35437);
  }
  
  public final void fnQ()
  {
    AppMethodBeat.i(35438);
    if (fnT()) {}
    for (int i = 5; this.HWI <= i; i = 10)
    {
      ac.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] mUnreadMessageCount is smaller than threshold:".concat(String.valueOf(i)));
      this.HWG.setVisibility(8);
      AppMethodBeat.o(35438);
      return;
    }
    if (this.HWG.getVisibility() == 0)
    {
      ac.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] has show!!!");
      AppMethodBeat.o(35438);
      return;
    }
    this.HWG.removeCallbacks(this.axL);
    View localView = this.HWG;
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35436);
        ac.i("MicroMsg.HistoryMsgTongueComponent", "show animation! GoBackToHistoryMsgLayout!!!");
        aa.a(aa.this).setVisibility(0);
        aa.a(aa.this, 1);
        Object localObject = (ak)aa.this.cLy.bf(ak.class);
        if ((((ak)localObject).foq()) || (((ak)localObject).fos())) {
          aa.this.aaY(1);
        }
        for (;;)
        {
          localObject = new TranslateAnimation(aa.a(aa.this).getWidth(), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject).setDuration(300L);
          ((TranslateAnimation)localObject).setInterpolator(AnimationUtils.loadInterpolator(aa.this.cLy.HZF.getContext(), 17432581));
          aa.a(aa.this).startAnimation((Animation)localObject);
          AppMethodBeat.o(35436);
          return;
          if (aa.b(aa.this)) {
            aa.this.aaY(3);
          } else {
            aa.this.aaY(0);
          }
        }
      }
    };
    this.axL = local2;
    localView.postDelayed(local2, 100L);
    AppMethodBeat.o(35438);
  }
  
  public final void fnR()
  {
    this.HWJ = 0;
  }
  
  public final int fnS()
  {
    return this.HWJ;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35439);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((this.HWI > 0) && (paramInt3 - (paramInt1 + 1) >= this.HWI) && (this.HWG != null) && (this.HWG.getVisibility() == 0))
    {
      ac.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr jacks onScroll dismissMsgTongue mUnreadMessage[%d] [%d,%d]", new Object[] { Integer.valueOf(this.HWI), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1) });
      fnP();
    }
    AppMethodBeat.o(35439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.aa
 * JD-Core Version:    0.7.0.1
 */