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
import com.tencent.mm.cc.a;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Collections;

public class EmojiPopView
  extends AbstractPopView
  implements com.tencent.mm.ak.g
{
  private View JBB;
  private View JBC;
  private View JBD;
  private View JBE;
  private View JBF;
  private TextView JBG;
  private TextView JBH;
  private WindowManager.LayoutParams JBI;
  private int JBJ;
  private String JBK;
  private EmojiInfo JBL;
  private String JBM;
  private boolean JBN;
  private c JBO;
  private Runnable JBP;
  private ProgressBar fUx;
  private p pne;
  private EmojiStatusView yOw;
  
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
    this.JBJ = -1;
    this.JBN = false;
    this.JBP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(183934);
        EmojiPopView.a(EmojiPopView.this, p.a(EmojiPopView.this.getContext(), EmojiPopView.this.getContext().getString(2131758410), true, 0, null));
        AppMethodBeat.o(183934);
      }
    };
    inflate(paramContext, 2131493788, this);
    this.JBB = findViewById(2131299413);
    this.yOw = ((EmojiStatusView)findViewById(2131300914));
    this.fUx = ((ProgressBar)findViewById(2131303515));
    this.JBC = findViewById(2131299418);
    this.JBD = findViewById(2131299415);
    this.JBE = findViewById(2131299417);
    this.JBF = findViewById(2131299414);
    this.JBG = ((TextView)findViewById(2131299416));
    this.JBH = ((TextView)findViewById(2131299419));
    setBackground(null);
    this.JBI = new WindowManager.LayoutParams(2, 262400, 1);
    this.JBI.width = -2;
    this.JBI.height = -2;
    this.JBI.gravity = 8388659;
    this.JBE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183935);
        paramAnonymousView = com.tencent.mm.emoji.b.d.fVd;
        com.tencent.mm.emoji.b.d.lA(2);
        EmojiPopView.a(EmojiPopView.this);
        AppMethodBeat.o(183935);
      }
    });
    this.JBF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183936);
        paramAnonymousView = com.tencent.mm.emoji.b.d.fVd;
        com.tencent.mm.emoji.b.d.lA(3);
        EmojiPopView.b(EmojiPopView.this);
        EmojiPopView.c(EmojiPopView.this).setActivated(true);
        EmojiPopView.c(EmojiPopView.this).setVisibility(0);
        EmojiPopView.c(EmojiPopView.this).setText(2131758286);
        AppMethodBeat.o(183936);
      }
    });
    this.JBG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183937);
        if (EmojiPopView.d(EmojiPopView.this))
        {
          paramAnonymousView = com.tencent.mm.emoji.b.d.fVd;
          com.tencent.mm.emoji.b.d.lA(4);
          EmojiPopView.e(EmojiPopView.this);
          AppMethodBeat.o(183937);
          return;
        }
        paramAnonymousView = com.tencent.mm.emoji.b.d.fVd;
        com.tencent.mm.emoji.b.d.lA(5);
        EmojiPopView.f(EmojiPopView.this);
        AppMethodBeat.o(183937);
      }
    });
    if (ai.cin()) {
      com.tencent.mm.kernel.g.agQ().ghe.a(698, this);
    }
    AppMethodBeat.o(105300);
  }
  
  private void cem()
  {
    AppMethodBeat.i(183944);
    h.d(getContext(), getContext().getString(2131758409), "", "", getContext().getString(2131760315), null, null);
    AppMethodBeat.o(183944);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(183943);
    removeCallbacks(this.JBP);
    if (this.pne != null) {
      this.pne.dismiss();
    }
    AppMethodBeat.o(183943);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(183942);
    postDelayed(this.JBP, 100L);
    AppMethodBeat.o(183942);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(183941);
    super.dismiss();
    hideLoading();
    AppMethodBeat.o(183941);
  }
  
  public final void gU(View paramView)
  {
    AppMethodBeat.i(105302);
    kz(paramView.getContext());
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.JBI.x = (arrayOfInt[0] - (getMeasuredWidth() - paramView.getMeasuredWidth()) / 2);
    this.JBI.y = (arrayOfInt[1] - getMeasuredHeight() - this.JBw);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    if (j < getWidth() / 2)
    {
      this.JBI.x = (j - a.fromDPToPix(getContext(), 32));
      this.JBB.setBackgroundResource(2131232036);
      this.JBE.setBackgroundResource(2131232037);
      this.JBF.setBackgroundResource(2131232039);
      this.JBG.setBackgroundResource(2131232038);
      AppMethodBeat.o(105302);
      return;
    }
    if (getWidth() / 2 + j > i)
    {
      this.JBI.x = (j + a.fromDPToPix(getContext(), 32) - getMeasuredWidth());
      this.JBB.setBackgroundResource(2131232072);
      this.JBE.setBackgroundResource(2131232073);
      this.JBF.setBackgroundResource(2131232075);
      this.JBG.setBackgroundResource(2131232074);
      AppMethodBeat.o(105302);
      return;
    }
    this.JBB.setBackgroundResource(2131232065);
    this.JBE.setBackgroundResource(2131232066);
    this.JBF.setBackgroundResource(2131232068);
    this.JBG.setBackgroundResource(2131232067);
    AppMethodBeat.o(105302);
  }
  
  public WindowManager.LayoutParams getWindowLayoutParams()
  {
    return this.JBI;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(183939);
    super.onDetachedFromWindow();
    if (ai.cin()) {
      com.tencent.mm.kernel.g.agQ().ghe.b(698, this);
    }
    AppMethodBeat.o(183939);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(183945);
    paramString = Collections.singletonList(this.JBK);
    ac.i("MicroMsg.EmojiPopView", "onSceneEnd: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.JBK, Integer.valueOf(this.JBJ) });
    if ((this.JBO != null) && (paramn == this.JBO))
    {
      if (this.JBO.iKU == 3)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.JBJ == 0)
          {
            i.ach().dk(true);
            i.ach().dj(true);
          }
          for (;;)
          {
            az.faZ().GXZ.p(this.JBJ, paramString);
            dismiss();
            AppMethodBeat.o(183945);
            return;
            i.ach().dm(true);
          }
        }
        cem();
        hideLoading();
        AppMethodBeat.o(183945);
        return;
      }
      if (this.JBO.iKU == 2)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.JBJ == 0)
          {
            i.ach().dk(true);
            i.ach().dj(true);
          }
          for (;;)
          {
            az.faZ().GXZ.z(paramString, this.JBJ);
            dismiss();
            AppMethodBeat.o(183945);
            return;
            i.ach().dm(true);
          }
        }
        cem();
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
      this.yOw.setVisibility(4);
      this.fUx.setVisibility(0);
      ac.i("MicroMsg.EmojiPopView", "emoji is null. set null");
      AppMethodBeat.o(105301);
      return;
    }
    if (!paramEmojiInfo.JC().equals(this.JBK))
    {
      this.JBK = paramEmojiInfo.JC();
      this.JBL = paramEmojiInfo;
      this.yOw.setStatusListener(new EmojiStatusView.b()
      {
        public final void lD(int paramAnonymousInt)
        {
          AppMethodBeat.i(183938);
          ac.i("MicroMsg.EmojiPopView", "onStatus: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
      this.yOw.setEmojiInfo(paramEmojiInfo);
    }
    AppMethodBeat.o(105301);
  }
  
  public void setPopupType(int paramInt)
  {
    AppMethodBeat.i(183940);
    if ((!ai.cin()) || (paramInt == -1) || (this.JBL == null) || (this.JBL.CC()) || (this.JBL.field_catalog == EmojiGroupInfo.Jsq) || (this.JBL.fFY() != EmojiInfo.a.Hav)) {}
    for (int i = 1;; i = 0)
    {
      this.JBN = false;
      if (i == 0) {
        break;
      }
      this.JBD.setVisibility(8);
      this.JBE.setVisibility(8);
      this.JBF.setVisibility(8);
      this.JBC.setVisibility(8);
      this.JBG.setVisibility(8);
      this.JBH.setVisibility(8);
      ((ConstraintLayout.LayoutParams)this.yOw.getLayoutParams()).goneBottomMargin = a.fromDPToPix(getContext(), 28);
      AppMethodBeat.o(183940);
      return;
    }
    ((ConstraintLayout.LayoutParams)this.yOw.getLayoutParams()).goneBottomMargin = a.fromDPToPix(getContext(), 16);
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.JBD.setVisibility(0);
      this.JBE.setVisibility(0);
      this.JBF.setVisibility(0);
      this.JBC.setVisibility(0);
      this.JBG.setVisibility(8);
      this.JBH.setVisibility(8);
    }
    for (;;)
    {
      this.JBJ = paramInt;
      AppMethodBeat.o(183940);
      return;
      if ((paramInt == 2) || (paramInt == 3))
      {
        this.JBD.setVisibility(0);
        this.JBE.setVisibility(8);
        this.JBF.setVisibility(8);
        this.JBC.setVisibility(8);
        this.JBG.setVisibility(0);
        this.JBH.setVisibility(0);
        if (bs.isNullOrNil(this.JBL.field_groupId)) {
          this.JBG.setVisibility(8);
        }
        this.JBM = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().XP(this.JBK);
        this.JBH.setText(this.JBM);
        if (bs.isNullOrNil(this.JBM)) {
          this.JBH.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.popview.EmojiPopView
 * JD-Core Version:    0.7.0.1
 */