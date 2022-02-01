package com.tencent.mm.view.popview;

import android.content.Context;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.base.h;
import java.util.Collections;

public class EmojiPopView
  extends AbstractPopView
  implements i
{
  private EmojiStatusView EGu;
  private View Rqf;
  private View Rqg;
  private View Rqh;
  private View Rqi;
  private View Rqj;
  private TextView Rqk;
  private TextView Rql;
  private WindowManager.LayoutParams Rqm;
  private int Rqn;
  private String Rqo;
  private EmojiInfo Rqp;
  private String Rqq;
  private boolean Rqr;
  private c Rqs;
  private Runnable Rqt;
  private ProgressBar hbv;
  private com.tencent.mm.ui.base.q qVq;
  
  public EmojiPopView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EmojiPopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EmojiPopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(105300);
    this.Rqn = -1;
    this.Rqr = false;
    this.Rqt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(183934);
        EmojiPopView.a(EmojiPopView.this, com.tencent.mm.ui.base.q.a(EmojiPopView.this.getContext(), EmojiPopView.this.getContext().getString(2131758704), true, 0, null));
        AppMethodBeat.o(183934);
      }
    };
    inflate(paramContext, 2131493941, this);
    this.Rqf = findViewById(2131300026);
    this.EGu = ((EmojiStatusView)findViewById(2131302526));
    this.hbv = ((ProgressBar)findViewById(2131306281));
    this.Rqg = findViewById(2131300031);
    this.Rqh = findViewById(2131300028);
    this.Rqi = findViewById(2131300030);
    this.Rqj = findViewById(2131300027);
    this.Rqk = ((TextView)findViewById(2131300029));
    this.Rql = ((TextView)findViewById(2131300032));
    setBackground(null);
    this.Rqm = new WindowManager.LayoutParams(2, 262400, 1);
    this.Rqm.width = -2;
    this.Rqm.height = -2;
    this.Rqm.gravity = 8388659;
    this.Rqi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183935);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/popview/EmojiPopView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = com.tencent.mm.emoji.c.e.hcl;
        com.tencent.mm.emoji.c.e.pl(2);
        EmojiPopView.a(EmojiPopView.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183935);
      }
    });
    this.Rqj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183936);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/popview/EmojiPopView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = com.tencent.mm.emoji.c.e.hcl;
        com.tencent.mm.emoji.c.e.pl(3);
        EmojiPopView.b(EmojiPopView.this);
        EmojiPopView.c(EmojiPopView.this).setActivated(true);
        EmojiPopView.c(EmojiPopView.this).setVisibility(0);
        EmojiPopView.c(EmojiPopView.this).setText(2131758576);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183936);
      }
    });
    this.Rqk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183937);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/popview/EmojiPopView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (EmojiPopView.d(EmojiPopView.this))
        {
          paramAnonymousView = com.tencent.mm.emoji.c.e.hcl;
          com.tencent.mm.emoji.c.e.pl(4);
          EmojiPopView.e(EmojiPopView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183937);
          return;
          paramAnonymousView = com.tencent.mm.emoji.c.e.hcl;
          com.tencent.mm.emoji.c.e.pl(5);
          EmojiPopView.f(EmojiPopView.this);
        }
      }
    });
    if (MMApplicationContext.isMainProcess()) {
      g.aAg().hqi.a(698, this);
    }
    AppMethodBeat.o(105300);
  }
  
  private void cIh()
  {
    AppMethodBeat.i(183944);
    h.c(getContext(), getContext().getString(2131758703), "", "", getContext().getString(2131755874), null, null);
    AppMethodBeat.o(183944);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(183943);
    removeCallbacks(this.Rqt);
    if (this.qVq != null) {
      this.qVq.dismiss();
    }
    AppMethodBeat.o(183943);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(183942);
    postDelayed(this.Rqt, 100L);
    AppMethodBeat.o(183942);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(183941);
    super.dismiss();
    hideLoading();
    AppMethodBeat.o(183941);
  }
  
  public WindowManager.LayoutParams getWindowLayoutParams()
  {
    return this.Rqm;
  }
  
  public final void hI(View paramView)
  {
    AppMethodBeat.i(105302);
    kO(paramView.getContext());
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.Rqm.x = (arrayOfInt[0] - (getMeasuredWidth() - paramView.getMeasuredWidth()) / 2);
    this.Rqm.y = (arrayOfInt[1] - getMeasuredHeight() - this.Rqa);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    if (j < getWidth() / 2)
    {
      this.Rqm.x = (j - com.tencent.mm.cb.a.fromDPToPix(getContext(), 32));
      this.Rqf.setBackgroundResource(2131232127);
      this.Rqi.setBackgroundResource(2131232128);
      this.Rqj.setBackgroundResource(2131232130);
      this.Rqk.setBackgroundResource(2131232129);
      AppMethodBeat.o(105302);
      return;
    }
    if (getWidth() / 2 + j > i)
    {
      this.Rqm.x = (j + com.tencent.mm.cb.a.fromDPToPix(getContext(), 32) - getMeasuredWidth());
      this.Rqf.setBackgroundResource(2131232163);
      this.Rqi.setBackgroundResource(2131232164);
      this.Rqj.setBackgroundResource(2131232166);
      this.Rqk.setBackgroundResource(2131232165);
      AppMethodBeat.o(105302);
      return;
    }
    this.Rqf.setBackgroundResource(2131232156);
    this.Rqi.setBackgroundResource(2131232157);
    this.Rqj.setBackgroundResource(2131232159);
    this.Rqk.setBackgroundResource(2131232158);
    AppMethodBeat.o(105302);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(183939);
    super.onDetachedFromWindow();
    if (MMApplicationContext.isMainProcess()) {
      g.aAg().hqi.b(698, this);
    }
    AppMethodBeat.o(183939);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(183945);
    paramString = Collections.singletonList(this.Rqo);
    Log.i("MicroMsg.EmojiPopView", "onSceneEnd: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.Rqo, Integer.valueOf(this.Rqn) });
    if ((this.Rqs != null) && (paramq == this.Rqs))
    {
      if (this.Rqs.kfa == 3)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.Rqn == 0)
          {
            j.auL().dW(true);
            j.auL().dV(true);
          }
          for (;;)
          {
            bj.gCJ().OpN.x(this.Rqn, paramString);
            dismiss();
            AppMethodBeat.o(183945);
            return;
            j.auL().dY(true);
          }
        }
        cIh();
        hideLoading();
        AppMethodBeat.o(183945);
        return;
      }
      if (this.Rqs.kfa == 2)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.Rqn == 0)
          {
            j.auL().dW(true);
            j.auL().dV(true);
          }
          for (;;)
          {
            bj.gCJ().OpN.I(paramString, this.Rqn);
            dismiss();
            AppMethodBeat.o(183945);
            return;
            j.auL().dY(true);
          }
        }
        cIh();
        hideLoading();
      }
    }
    AppMethodBeat.o(183945);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105301);
    if (paramEmojiInfo == null)
    {
      this.EGu.setVisibility(4);
      this.hbv.setVisibility(0);
      Log.i("MicroMsg.EmojiPopView", "emoji is null. set null");
      AppMethodBeat.o(105301);
      return;
    }
    if (!paramEmojiInfo.getMd5().equals(this.Rqo))
    {
      this.Rqo = paramEmojiInfo.getMd5();
      this.Rqp = paramEmojiInfo;
      this.EGu.setStatusListener(new EmojiStatusView.b()
      {
        public final void po(int paramAnonymousInt)
        {
          AppMethodBeat.i(183938);
          Log.i("MicroMsg.EmojiPopView", "onStatus: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == 1)
          {
            EmojiPopView.g(EmojiPopView.this).setVisibility(8);
            EmojiPopView.h(EmojiPopView.this).setVisibility(0);
            AppMethodBeat.o(183938);
            return;
          }
          EmojiPopView.h(EmojiPopView.this).setVisibility(4);
          EmojiPopView.g(EmojiPopView.this).setVisibility(0);
          AppMethodBeat.o(183938);
        }
      });
      this.EGu.setEmojiInfo(paramEmojiInfo);
    }
    AppMethodBeat.o(105301);
  }
  
  public void setPopupType(int paramInt)
  {
    AppMethodBeat.i(183940);
    if ((!MMApplicationContext.isMainProcess()) || (paramInt == -1) || (this.Rqp == null) || (this.Rqp.NA()) || (this.Rqp.field_catalog == EmojiGroupInfo.Uun) || (this.Rqp.hRH() != EmojiInfo.a.Osj)) {}
    for (int i = 1;; i = 0)
    {
      this.Rqr = false;
      if (i == 0) {
        break;
      }
      this.Rqh.setVisibility(8);
      this.Rqi.setVisibility(8);
      this.Rqj.setVisibility(8);
      this.Rqg.setVisibility(8);
      this.Rqk.setVisibility(8);
      this.Rql.setVisibility(8);
      ((ConstraintLayout.LayoutParams)this.EGu.getLayoutParams()).goneBottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 28);
      AppMethodBeat.o(183940);
      return;
    }
    ((ConstraintLayout.LayoutParams)this.EGu.getLayoutParams()).goneBottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.Rqh.setVisibility(0);
      this.Rqi.setVisibility(0);
      this.Rqj.setVisibility(0);
      this.Rqg.setVisibility(0);
      this.Rqk.setVisibility(8);
      this.Rql.setVisibility(8);
    }
    for (;;)
    {
      this.Rqn = paramInt;
      AppMethodBeat.o(183940);
      return;
      if ((paramInt == 2) || (paramInt == 3) || (paramInt == 4))
      {
        this.Rqh.setVisibility(0);
        this.Rqi.setVisibility(8);
        this.Rqj.setVisibility(8);
        this.Rqg.setVisibility(8);
        this.Rqk.setVisibility(0);
        this.Rql.setVisibility(0);
        if (Util.isNullOrNil(this.Rqp.field_groupId)) {
          this.Rqk.setVisibility(8);
        }
        this.Rqq = ((d)g.ah(d.class)).getProvider().amp(this.Rqo);
        this.Rql.setText(this.Rqq);
        if (Util.isNullOrNil(this.Rqq)) {
          this.Rql.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.popview.EmojiPopView
 * JD-Core Version:    0.7.0.1
 */