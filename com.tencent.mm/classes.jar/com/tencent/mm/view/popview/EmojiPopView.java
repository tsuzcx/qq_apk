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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.emoji.c.m;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.Collections;

public class EmojiPopView
  extends AbstractPopView
  implements com.tencent.mm.am.h
{
  private EmojiStatusView Rum;
  private View agNh;
  private View agNi;
  private View agNj;
  private View agNk;
  private View agNl;
  private TextView agNm;
  private TextView agNn;
  private WindowManager.LayoutParams agNo;
  private int agNp;
  private String agNq;
  private EmojiInfo agNr;
  private String agNs;
  private com.tencent.mm.plugin.emoji.e.c agNt;
  private int agNu;
  private Runnable agNv;
  private ProgressBar mlF;
  private w xEL;
  
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
    this.agNp = -1;
    this.agNu = 0;
    this.agNv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(183934);
        EmojiPopView.a(EmojiPopView.this, w.a(EmojiPopView.this.getContext(), EmojiPopView.this.getContext().getString(a.j.emoji_top_loading), true, 0, null));
        AppMethodBeat.o(183934);
      }
    };
    inflate(paramContext, a.h.emoji_pop_emoji_view, this);
    this.agNh = findViewById(a.g.emoji_pop_root);
    this.Rum = ((EmojiStatusView)findViewById(a.g.image));
    this.mlF = ((ProgressBar)findViewById(a.g.progress));
    this.agNi = findViewById(a.g.emoji_popup_action_vertical_divider);
    this.agNj = findViewById(a.g.emoji_popup_action_divider);
    this.agNk = findViewById(a.g.emoji_popup_action_top);
    this.agNl = findViewById(a.g.emoji_popup_action_delete);
    this.agNm = ((TextView)findViewById(a.g.emoji_popup_action_group_detail));
    this.agNn = ((TextView)findViewById(a.g.emoji_popup_desc));
    setBackground(null);
    this.agNo = new WindowManager.LayoutParams(2, 262400, 1);
    this.agNo.width = -2;
    this.agNo.height = -2;
    this.agNo.gravity = 8388659;
    this.agNk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183935);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/popview/EmojiPopView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = com.tencent.mm.emoji.d.e.mmt;
        com.tencent.mm.emoji.d.e.rG(2);
        EmojiPopView.a(EmojiPopView.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183935);
      }
    });
    this.agNl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183936);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/popview/EmojiPopView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = com.tencent.mm.emoji.d.e.mmt;
        com.tencent.mm.emoji.d.e.rG(3);
        EmojiPopView.b(EmojiPopView.this);
        EmojiPopView.c(EmojiPopView.this).setActivated(true);
        EmojiPopView.c(EmojiPopView.this).setVisibility(0);
        EmojiPopView.c(EmojiPopView.this).setText(a.j.emoji_popup_delete_confirm);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183936);
      }
    });
    this.agNm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183937);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/popview/EmojiPopView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (EmojiPopView.d(EmojiPopView.this) == 1)
        {
          paramAnonymousView = com.tencent.mm.emoji.d.e.mmt;
          com.tencent.mm.emoji.d.e.rG(4);
          EmojiPopView.e(EmojiPopView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183937);
          return;
          if (EmojiPopView.d(EmojiPopView.this) == 2)
          {
            paramAnonymousView = com.tencent.mm.emoji.d.e.mmt;
            com.tencent.mm.emoji.d.e.rG(2);
            EmojiPopView.a(EmojiPopView.this);
          }
          else
          {
            paramAnonymousView = com.tencent.mm.emoji.d.e.mmt;
            com.tencent.mm.emoji.d.e.rG(5);
            EmojiPopView.f(EmojiPopView.this);
          }
        }
      }
    });
    if (MMApplicationContext.isMainProcess()) {
      com.tencent.mm.kernel.h.baD().mCm.a(698, this);
    }
    AppMethodBeat.o(105300);
  }
  
  private void dCu()
  {
    AppMethodBeat.i(183944);
    k.b(getContext(), getContext().getString(a.j.emoji_top_failed), "", "", getContext().getString(a.j.app_i_known), null, null);
    AppMethodBeat.o(183944);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(183943);
    removeCallbacks(this.agNv);
    if (this.xEL != null) {
      this.xEL.dismiss();
    }
    AppMethodBeat.o(183943);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(183942);
    postDelayed(this.agNv, 100L);
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
    return this.agNo;
  }
  
  public final void mB(View paramView)
  {
    AppMethodBeat.i(105302);
    nO(paramView.getContext());
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.agNo.x = (arrayOfInt[0] - (getMeasuredWidth() - paramView.getMeasuredWidth()) / 2);
    this.agNo.y = (arrayOfInt[1] - getMeasuredHeight() - this.agNe);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    if (j < getWidth() / 2)
    {
      this.agNo.x = (j - com.tencent.mm.cd.a.fromDPToPix(getContext(), 32));
      this.agNh.setBackgroundResource(a.f.emoji_left_popup_bg);
      this.agNk.setBackgroundResource(a.f.emoji_left_popup_left_bg);
      this.agNl.setBackgroundResource(a.f.emoji_left_popup_right_bg);
      this.agNm.setBackgroundResource(a.f.emoji_left_popup_option_all_bg);
      AppMethodBeat.o(105302);
      return;
    }
    if (getWidth() / 2 + j > i)
    {
      this.agNo.x = (j + com.tencent.mm.cd.a.fromDPToPix(getContext(), 32) - getMeasuredWidth());
      this.agNh.setBackgroundResource(a.f.emoji_right_popup_bg);
      this.agNk.setBackgroundResource(a.f.emoji_right_popup_left_bg);
      this.agNl.setBackgroundResource(a.f.emoji_right_popup_right_bg);
      this.agNm.setBackgroundResource(a.f.emoji_right_popup_option_all_bg);
      AppMethodBeat.o(105302);
      return;
    }
    this.agNh.setBackgroundResource(a.f.emoji_popup_bg);
    this.agNk.setBackgroundResource(a.f.emoji_popup_left_bg);
    this.agNl.setBackgroundResource(a.f.emoji_popup_right_bg);
    this.agNm.setBackgroundResource(a.f.emoji_popup_option_all_bg);
    AppMethodBeat.o(105302);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(183939);
    super.onDetachedFromWindow();
    if (MMApplicationContext.isMainProcess()) {
      com.tencent.mm.kernel.h.baD().mCm.b(698, this);
    }
    AppMethodBeat.o(183939);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(183945);
    paramString = Collections.singletonList(this.agNq);
    Log.i("MicroMsg.EmojiPopView", "onSceneEnd: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.agNq, Integer.valueOf(this.agNp) });
    if ((this.agNt != null) && (paramp == this.agNt))
    {
      if (this.agNt.pTf == 3)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.agNp == 0)
          {
            l.aUF().fg(true);
            l.aUF().ff(true);
          }
          for (;;)
          {
            bl.jba().adju.V(this.agNp, paramString);
            dismiss();
            AppMethodBeat.o(183945);
            return;
            l.aUF().fi(true);
          }
        }
        dCu();
        hideLoading();
        AppMethodBeat.o(183945);
        return;
      }
      if (this.agNt.pTf == 2)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.agNp == 0)
          {
            l.aUF().fg(true);
            l.aUF().ff(true);
          }
          for (;;)
          {
            bl.jba().adju.ab(paramString, this.agNp);
            paramString = m.mhY;
            m.aUM();
            dismiss();
            AppMethodBeat.o(183945);
            return;
            l.aUF().fi(true);
          }
        }
        dCu();
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
      this.Rum.setVisibility(4);
      this.mlF.setVisibility(0);
      Log.i("MicroMsg.EmojiPopView", "emoji is null. set null");
      AppMethodBeat.o(105301);
      return;
    }
    if (!paramEmojiInfo.getMd5().equals(this.agNq))
    {
      this.agNq = paramEmojiInfo.getMd5();
      this.agNr = paramEmojiInfo;
      this.Rum.setStatusListener(new EmojiStatusView.b()
      {
        public final void rJ(int paramAnonymousInt)
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
      this.Rum.setEmojiInfo(paramEmojiInfo);
    }
    AppMethodBeat.o(105301);
  }
  
  public void setPopupType(int paramInt)
  {
    AppMethodBeat.i(183940);
    int i;
    if ((paramInt == 2) || (paramInt == 3) || (paramInt == 4))
    {
      i = 1;
      if ((MMApplicationContext.isMainProcess()) && ((i == 0) || (!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())) && (paramInt != -1) && (this.agNr != null) && (!this.agNr.aqJ()) && (this.agNr.field_catalog != EmojiGroupInfo.aklE) && (this.agNr.kMj() == EmojiInfo.a.adme)) {
        break label197;
      }
    }
    label197:
    for (int j = 1;; j = 0)
    {
      this.agNu = 0;
      if (j == 0) {
        break label202;
      }
      this.agNj.setVisibility(8);
      this.agNk.setVisibility(8);
      this.agNl.setVisibility(8);
      this.agNi.setVisibility(8);
      this.agNm.setVisibility(8);
      this.agNn.setVisibility(8);
      ((ConstraintLayout.LayoutParams)this.Rum.getLayoutParams()).blz = com.tencent.mm.cd.a.fromDPToPix(getContext(), 28);
      AppMethodBeat.o(183940);
      return;
      i = 0;
      break;
    }
    label202:
    ((ConstraintLayout.LayoutParams)this.Rum.getLayoutParams()).blz = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
    if ((paramInt == 0) || (paramInt == 1)) {
      if (com.tencent.mm.plugin.emoji.g.d.A(this.agNr))
      {
        this.agNj.setVisibility(0);
        this.agNk.setVisibility(8);
        this.agNl.setVisibility(8);
        this.agNi.setVisibility(8);
        this.agNm.setVisibility(0);
        this.agNm.setText(a.j.emoji_top);
        this.agNu = 2;
      }
    }
    for (;;)
    {
      this.agNp = paramInt;
      AppMethodBeat.o(183940);
      return;
      this.agNj.setVisibility(0);
      this.agNk.setVisibility(0);
      this.agNl.setVisibility(0);
      this.agNi.setVisibility(0);
      this.agNm.setVisibility(8);
      this.agNn.setVisibility(8);
      continue;
      if (i != 0)
      {
        this.agNj.setVisibility(0);
        this.agNk.setVisibility(8);
        this.agNl.setVisibility(8);
        this.agNi.setVisibility(8);
        this.agNm.setVisibility(0);
        this.agNn.setVisibility(0);
        if (Util.isNullOrNil(this.agNr.field_groupId)) {
          this.agNm.setVisibility(8);
        }
        this.agNs = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().aoi(this.agNq);
        this.agNn.setText(this.agNs);
        if (Util.isNullOrNil(this.agNs)) {
          this.agNn.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.popview.EmojiPopView
 * JD-Core Version:    0.7.0.1
 */