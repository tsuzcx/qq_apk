package com.tencent.mm.view.popview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.b.l;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.base.s;
import java.util.Collections;

public class EmojiPopView
  extends AbstractPopView
  implements i
{
  private EmojiStatusView KUo;
  private View YRD;
  private View YRE;
  private View YRF;
  private View YRG;
  private View YRH;
  private TextView YRI;
  private TextView YRJ;
  private WindowManager.LayoutParams YRK;
  private int YRL;
  private String YRM;
  private EmojiInfo YRN;
  private String YRO;
  private com.tencent.mm.plugin.emoji.f.c YRP;
  private int YRQ;
  private Runnable YRR;
  private ProgressBar jMF;
  private s uya;
  
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
    this.YRL = -1;
    this.YRQ = 0;
    this.YRR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(183934);
        EmojiPopView.a(EmojiPopView.this, s.a(EmojiPopView.this.getContext(), EmojiPopView.this.getContext().getString(a.j.emoji_top_loading), true, 0, null));
        AppMethodBeat.o(183934);
      }
    };
    inflate(paramContext, a.h.emoji_pop_emoji_view, this);
    this.YRD = findViewById(a.g.emoji_pop_root);
    this.KUo = ((EmojiStatusView)findViewById(a.g.image));
    this.jMF = ((ProgressBar)findViewById(a.g.progress));
    this.YRE = findViewById(a.g.emoji_popup_action_vertical_divider);
    this.YRF = findViewById(a.g.emoji_popup_action_divider);
    this.YRG = findViewById(a.g.emoji_popup_action_top);
    this.YRH = findViewById(a.g.emoji_popup_action_delete);
    this.YRI = ((TextView)findViewById(a.g.emoji_popup_action_group_detail));
    this.YRJ = ((TextView)findViewById(a.g.emoji_popup_desc));
    setBackground(null);
    this.YRK = new WindowManager.LayoutParams(2, 262400, 1);
    this.YRK.width = -2;
    this.YRK.height = -2;
    this.YRK.gravity = 8388659;
    this.YRG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183935);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/popview/EmojiPopView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = com.tencent.mm.emoji.c.e.jNv;
        com.tencent.mm.emoji.c.e.rE(2);
        EmojiPopView.a(EmojiPopView.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183935);
      }
    });
    this.YRH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183936);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/popview/EmojiPopView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = com.tencent.mm.emoji.c.e.jNv;
        com.tencent.mm.emoji.c.e.rE(3);
        EmojiPopView.b(EmojiPopView.this);
        EmojiPopView.c(EmojiPopView.this).setActivated(true);
        EmojiPopView.c(EmojiPopView.this).setVisibility(0);
        EmojiPopView.c(EmojiPopView.this).setText(a.j.emoji_popup_delete_confirm);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183936);
      }
    });
    this.YRI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183937);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/popview/EmojiPopView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (EmojiPopView.d(EmojiPopView.this) == 1)
        {
          paramAnonymousView = com.tencent.mm.emoji.c.e.jNv;
          com.tencent.mm.emoji.c.e.rE(4);
          EmojiPopView.e(EmojiPopView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183937);
          return;
          if (EmojiPopView.d(EmojiPopView.this) == 2)
          {
            paramAnonymousView = com.tencent.mm.emoji.c.e.jNv;
            com.tencent.mm.emoji.c.e.rE(2);
            EmojiPopView.a(EmojiPopView.this);
          }
          else
          {
            paramAnonymousView = com.tencent.mm.emoji.c.e.jNv;
            com.tencent.mm.emoji.c.e.rE(5);
            EmojiPopView.f(EmojiPopView.this);
          }
        }
      }
    });
    if (MMApplicationContext.isMainProcess()) {
      com.tencent.mm.kernel.h.aHF().kcd.a(698, this);
    }
    AppMethodBeat.o(105300);
  }
  
  private void cWO()
  {
    AppMethodBeat.i(183944);
    com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(a.j.emoji_top_failed), "", "", getContext().getString(a.j.app_i_known), null, null);
    AppMethodBeat.o(183944);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(183943);
    removeCallbacks(this.YRR);
    if (this.uya != null) {
      this.uya.dismiss();
    }
    AppMethodBeat.o(183943);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(183942);
    postDelayed(this.YRR, 100L);
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
    return this.YRK;
  }
  
  public final void jd(View paramView)
  {
    AppMethodBeat.i(105302);
    lK(paramView.getContext());
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.YRK.x = (arrayOfInt[0] - (getMeasuredWidth() - paramView.getMeasuredWidth()) / 2);
    this.YRK.y = (arrayOfInt[1] - getMeasuredHeight() - this.YRy);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    if (j < getWidth() / 2)
    {
      this.YRK.x = (j - com.tencent.mm.ci.a.fromDPToPix(getContext(), 32));
      this.YRD.setBackgroundResource(a.f.emoji_left_popup_bg);
      this.YRG.setBackgroundResource(a.f.emoji_left_popup_left_bg);
      this.YRH.setBackgroundResource(a.f.emoji_left_popup_right_bg);
      this.YRI.setBackgroundResource(a.f.emoji_left_popup_option_all_bg);
      AppMethodBeat.o(105302);
      return;
    }
    if (getWidth() / 2 + j > i)
    {
      this.YRK.x = (j + com.tencent.mm.ci.a.fromDPToPix(getContext(), 32) - getMeasuredWidth());
      this.YRD.setBackgroundResource(a.f.emoji_right_popup_bg);
      this.YRG.setBackgroundResource(a.f.emoji_right_popup_left_bg);
      this.YRH.setBackgroundResource(a.f.emoji_right_popup_right_bg);
      this.YRI.setBackgroundResource(a.f.emoji_right_popup_option_all_bg);
      AppMethodBeat.o(105302);
      return;
    }
    this.YRD.setBackgroundResource(a.f.emoji_popup_bg);
    this.YRG.setBackgroundResource(a.f.emoji_popup_left_bg);
    this.YRH.setBackgroundResource(a.f.emoji_popup_right_bg);
    this.YRI.setBackgroundResource(a.f.emoji_popup_option_all_bg);
    AppMethodBeat.o(105302);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(183939);
    super.onDetachedFromWindow();
    if (MMApplicationContext.isMainProcess()) {
      com.tencent.mm.kernel.h.aHF().kcd.b(698, this);
    }
    AppMethodBeat.o(183939);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(183945);
    paramString = Collections.singletonList(this.YRM);
    Log.i("MicroMsg.EmojiPopView", "onSceneEnd: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.YRM, Integer.valueOf(this.YRL) });
    if ((this.YRP != null) && (paramq == this.YRP))
    {
      if (this.YRP.mWz == 3)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.YRL == 0)
          {
            k.aBH().eu(true);
            k.aBH().et(true);
          }
          for (;;)
          {
            bj.hyV().VFH.A(this.YRL, paramString);
            dismiss();
            AppMethodBeat.o(183945);
            return;
            k.aBH().ew(true);
          }
        }
        cWO();
        hideLoading();
        AppMethodBeat.o(183945);
        return;
      }
      if (this.YRP.mWz == 2)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.YRL == 0)
          {
            k.aBH().eu(true);
            k.aBH().et(true);
          }
          for (;;)
          {
            bj.hyV().VFH.J(paramString, this.YRL);
            paramString = l.jIq;
            l.aBO();
            dismiss();
            AppMethodBeat.o(183945);
            return;
            k.aBH().ew(true);
          }
        }
        cWO();
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
      this.KUo.setVisibility(4);
      this.jMF.setVisibility(0);
      Log.i("MicroMsg.EmojiPopView", "emoji is null. set null");
      AppMethodBeat.o(105301);
      return;
    }
    if (!paramEmojiInfo.getMd5().equals(this.YRM))
    {
      this.YRM = paramEmojiInfo.getMd5();
      this.YRN = paramEmojiInfo;
      this.KUo.setStatusListener(new EmojiStatusView.b()
      {
        public final void rH(int paramAnonymousInt)
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
      this.KUo.setEmojiInfo(paramEmojiInfo);
    }
    AppMethodBeat.o(105301);
  }
  
  public void setPopupType(int paramInt)
  {
    AppMethodBeat.i(183940);
    if ((!MMApplicationContext.isMainProcess()) || (paramInt == -1) || (this.YRN == null) || (this.YRN.Qv()) || (this.YRN.field_catalog == EmojiGroupInfo.YCv) || (this.YRN.hBB() != EmojiInfo.a.VIi)) {}
    for (int i = 1;; i = 0)
    {
      this.YRQ = 0;
      if (i == 0) {
        break;
      }
      this.YRF.setVisibility(8);
      this.YRG.setVisibility(8);
      this.YRH.setVisibility(8);
      this.YRE.setVisibility(8);
      this.YRI.setVisibility(8);
      this.YRJ.setVisibility(8);
      ((ConstraintLayout.LayoutParams)this.KUo.getLayoutParams()).Fs = com.tencent.mm.ci.a.fromDPToPix(getContext(), 28);
      AppMethodBeat.o(183940);
      return;
    }
    ((ConstraintLayout.LayoutParams)this.KUo.getLayoutParams()).Fs = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
    if ((paramInt == 0) || (paramInt == 1)) {
      if (com.tencent.mm.plugin.emoji.i.b.A(this.YRN))
      {
        this.YRF.setVisibility(0);
        this.YRG.setVisibility(8);
        this.YRH.setVisibility(8);
        this.YRE.setVisibility(8);
        this.YRI.setVisibility(0);
        this.YRI.setText(a.j.emoji_top);
        this.YRQ = 2;
      }
    }
    for (;;)
    {
      this.YRL = paramInt;
      AppMethodBeat.o(183940);
      return;
      this.YRF.setVisibility(0);
      this.YRG.setVisibility(0);
      this.YRH.setVisibility(0);
      this.YRE.setVisibility(0);
      this.YRI.setVisibility(8);
      this.YRJ.setVisibility(8);
      continue;
      if ((paramInt == 2) || (paramInt == 3) || (paramInt == 4))
      {
        this.YRF.setVisibility(0);
        this.YRG.setVisibility(8);
        this.YRH.setVisibility(8);
        this.YRE.setVisibility(8);
        this.YRI.setVisibility(0);
        this.YRJ.setVisibility(0);
        if (Util.isNullOrNil(this.YRN.field_groupId)) {
          this.YRI.setVisibility(8);
        }
        this.YRO = ((d)com.tencent.mm.kernel.h.ag(d.class)).getProvider().auh(this.YRM);
        this.YRJ.setText(this.YRO);
        if (Util.isNullOrNil(this.YRO)) {
          this.YRJ.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.popview.EmojiPopView
 * JD-Core Version:    0.7.0.1
 */