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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Collections;

public class EmojiPopView
  extends AbstractPopView
  implements com.tencent.mm.ak.f
{
  private EmojiStatusView Axe;
  private TextView LRA;
  private TextView LRB;
  private WindowManager.LayoutParams LRC;
  private int LRD;
  private String LRE;
  private EmojiInfo LRF;
  private String LRG;
  private boolean LRH;
  private c LRI;
  private Runnable LRJ;
  private View LRv;
  private View LRw;
  private View LRx;
  private View LRy;
  private View LRz;
  private ProgressBar gqv;
  private p pXj;
  
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
    this.LRD = -1;
    this.LRH = false;
    this.LRJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(183934);
        EmojiPopView.a(EmojiPopView.this, p.a(EmojiPopView.this.getContext(), EmojiPopView.this.getContext().getString(2131758410), true, 0, null));
        AppMethodBeat.o(183934);
      }
    };
    inflate(paramContext, 2131493788, this);
    this.LRv = findViewById(2131299413);
    this.Axe = ((EmojiStatusView)findViewById(2131300914));
    this.gqv = ((ProgressBar)findViewById(2131303515));
    this.LRw = findViewById(2131299418);
    this.LRx = findViewById(2131299415);
    this.LRy = findViewById(2131299417);
    this.LRz = findViewById(2131299414);
    this.LRA = ((TextView)findViewById(2131299416));
    this.LRB = ((TextView)findViewById(2131299419));
    setBackground(null);
    this.LRC = new WindowManager.LayoutParams(2, 262400, 1);
    this.LRC.width = -2;
    this.LRC.height = -2;
    this.LRC.gravity = 8388659;
    this.LRy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183935);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/popview/EmojiPopView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = com.tencent.mm.emoji.b.d.grb;
        com.tencent.mm.emoji.b.d.md(2);
        EmojiPopView.a(EmojiPopView.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183935);
      }
    });
    this.LRz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183936);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/popview/EmojiPopView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = com.tencent.mm.emoji.b.d.grb;
        com.tencent.mm.emoji.b.d.md(3);
        EmojiPopView.b(EmojiPopView.this);
        EmojiPopView.c(EmojiPopView.this).setActivated(true);
        EmojiPopView.c(EmojiPopView.this).setVisibility(0);
        EmojiPopView.c(EmojiPopView.this).setText(2131758286);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183936);
      }
    });
    this.LRA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183937);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/popview/EmojiPopView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (EmojiPopView.d(EmojiPopView.this))
        {
          paramAnonymousView = com.tencent.mm.emoji.b.d.grb;
          com.tencent.mm.emoji.b.d.md(4);
          EmojiPopView.e(EmojiPopView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183937);
          return;
          paramAnonymousView = com.tencent.mm.emoji.b.d.grb;
          com.tencent.mm.emoji.b.d.md(5);
          EmojiPopView.f(EmojiPopView.this);
        }
      }
    });
    if (ak.coh()) {
      g.ajQ().gDv.a(698, this);
    }
    AppMethodBeat.o(105300);
  }
  
  private void ckf()
  {
    AppMethodBeat.i(183944);
    h.e(getContext(), getContext().getString(2131758409), "", "", getContext().getString(2131760315), null, null);
    AppMethodBeat.o(183944);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(183943);
    removeCallbacks(this.LRJ);
    if (this.pXj != null) {
      this.pXj.dismiss();
    }
    AppMethodBeat.o(183943);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(183942);
    postDelayed(this.LRJ, 100L);
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
    return this.LRC;
  }
  
  public final void hq(View paramView)
  {
    AppMethodBeat.i(105302);
    kS(paramView.getContext());
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.LRC.x = (arrayOfInt[0] - (getMeasuredWidth() - paramView.getMeasuredWidth()) / 2);
    this.LRC.y = (arrayOfInt[1] - getMeasuredHeight() - this.LRq);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    if (j < getWidth() / 2)
    {
      this.LRC.x = (j - com.tencent.mm.cb.a.fromDPToPix(getContext(), 32));
      this.LRv.setBackgroundResource(2131232036);
      this.LRy.setBackgroundResource(2131232037);
      this.LRz.setBackgroundResource(2131232039);
      this.LRA.setBackgroundResource(2131232038);
      AppMethodBeat.o(105302);
      return;
    }
    if (getWidth() / 2 + j > i)
    {
      this.LRC.x = (j + com.tencent.mm.cb.a.fromDPToPix(getContext(), 32) - getMeasuredWidth());
      this.LRv.setBackgroundResource(2131232072);
      this.LRy.setBackgroundResource(2131232073);
      this.LRz.setBackgroundResource(2131232075);
      this.LRA.setBackgroundResource(2131232074);
      AppMethodBeat.o(105302);
      return;
    }
    this.LRv.setBackgroundResource(2131232065);
    this.LRy.setBackgroundResource(2131232066);
    this.LRz.setBackgroundResource(2131232068);
    this.LRA.setBackgroundResource(2131232067);
    AppMethodBeat.o(105302);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(183939);
    super.onDetachedFromWindow();
    if (ak.coh()) {
      g.ajQ().gDv.b(698, this);
    }
    AppMethodBeat.o(183939);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(183945);
    paramString = Collections.singletonList(this.LRE);
    ae.i("MicroMsg.EmojiPopView", "onSceneEnd: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.LRE, Integer.valueOf(this.LRD) });
    if ((this.LRI != null) && (paramn == this.LRI))
    {
      if (this.LRI.jgW == 3)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.LRD == 0)
          {
            i.aeX().dm(true);
            i.aeX().dl(true);
          }
          for (;;)
          {
            be.fvc().JfU.s(this.LRD, paramString);
            dismiss();
            AppMethodBeat.o(183945);
            return;
            i.aeX().jdMethod_do(true);
          }
        }
        ckf();
        hideLoading();
        AppMethodBeat.o(183945);
        return;
      }
      if (this.LRI.jgW == 2)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.LRD == 0)
          {
            i.aeX().dm(true);
            i.aeX().dl(true);
          }
          for (;;)
          {
            be.fvc().JfU.C(paramString, this.LRD);
            dismiss();
            AppMethodBeat.o(183945);
            return;
            i.aeX().jdMethod_do(true);
          }
        }
        ckf();
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
      this.Axe.setVisibility(4);
      this.gqv.setVisibility(0);
      ae.i("MicroMsg.EmojiPopView", "emoji is null. set null");
      AppMethodBeat.o(105301);
      return;
    }
    if (!paramEmojiInfo.Lj().equals(this.LRE))
    {
      this.LRE = paramEmojiInfo.Lj();
      this.LRF = paramEmojiInfo;
      this.Axe.setStatusListener(new EmojiStatusView.b()
      {
        public final void mg(int paramAnonymousInt)
        {
          AppMethodBeat.i(183938);
          ae.i("MicroMsg.EmojiPopView", "onStatus: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
      this.Axe.setEmojiInfo(paramEmojiInfo);
    }
    AppMethodBeat.o(105301);
  }
  
  public void setPopupType(int paramInt)
  {
    AppMethodBeat.i(183940);
    if ((!ak.coh()) || (paramInt == -1) || (this.LRF == null) || (this.LRF.Ee()) || (this.LRF.field_catalog == EmojiGroupInfo.OzS) || (this.LRF.fxx() != EmojiInfo.a.Jir)) {}
    for (int i = 1;; i = 0)
    {
      this.LRH = false;
      if (i == 0) {
        break;
      }
      this.LRx.setVisibility(8);
      this.LRy.setVisibility(8);
      this.LRz.setVisibility(8);
      this.LRw.setVisibility(8);
      this.LRA.setVisibility(8);
      this.LRB.setVisibility(8);
      ((ConstraintLayout.LayoutParams)this.Axe.getLayoutParams()).goneBottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 28);
      AppMethodBeat.o(183940);
      return;
    }
    ((ConstraintLayout.LayoutParams)this.Axe.getLayoutParams()).goneBottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.LRx.setVisibility(0);
      this.LRy.setVisibility(0);
      this.LRz.setVisibility(0);
      this.LRw.setVisibility(0);
      this.LRA.setVisibility(8);
      this.LRB.setVisibility(8);
    }
    for (;;)
    {
      this.LRD = paramInt;
      AppMethodBeat.o(183940);
      return;
      if ((paramInt == 2) || (paramInt == 3))
      {
        this.LRx.setVisibility(0);
        this.LRy.setVisibility(8);
        this.LRz.setVisibility(8);
        this.LRw.setVisibility(8);
        this.LRA.setVisibility(0);
        this.LRB.setVisibility(0);
        if (bu.isNullOrNil(this.LRF.field_groupId)) {
          this.LRA.setVisibility(8);
        }
        this.LRG = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().acm(this.LRE);
        this.LRB.setText(this.LRG);
        if (bu.isNullOrNil(this.LRG)) {
          this.LRB.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.popview.EmojiPopView
 * JD-Core Version:    0.7.0.1
 */