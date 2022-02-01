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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.base.p;
import java.util.Collections;

public class EmojiPopView
  extends AbstractPopView
  implements com.tencent.mm.al.g
{
  private View IaL;
  private View IaM;
  private View IaN;
  private View IaO;
  private View IaP;
  private TextView IaQ;
  private TextView IaR;
  private WindowManager.LayoutParams IaS;
  private int IaT;
  private String IaU;
  private EmojiInfo IaV;
  private String IaW;
  private boolean IaX;
  private c IaY;
  private Runnable IaZ;
  private ProgressBar fQC;
  private p oJG;
  private EmojiStatusView xBI;
  
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
    this.IaT = -1;
    this.IaX = false;
    this.IaZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(183934);
        EmojiPopView.a(EmojiPopView.this, p.a(EmojiPopView.this.getContext(), EmojiPopView.this.getContext().getString(2131758410), true, 0, null));
        AppMethodBeat.o(183934);
      }
    };
    inflate(paramContext, 2131493788, this);
    this.IaL = findViewById(2131299413);
    this.xBI = ((EmojiStatusView)findViewById(2131300914));
    this.fQC = ((ProgressBar)findViewById(2131303515));
    this.IaM = findViewById(2131299418);
    this.IaN = findViewById(2131299415);
    this.IaO = findViewById(2131299417);
    this.IaP = findViewById(2131299414);
    this.IaQ = ((TextView)findViewById(2131299416));
    this.IaR = ((TextView)findViewById(2131299419));
    setBackground(null);
    this.IaS = new WindowManager.LayoutParams(2, 262400, 1);
    this.IaS.width = -2;
    this.IaS.height = -2;
    this.IaS.gravity = 8388659;
    this.IaO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183935);
        paramAnonymousView = com.tencent.mm.emoji.b.d.fRi;
        com.tencent.mm.emoji.b.d.lI(2);
        EmojiPopView.a(EmojiPopView.this);
        AppMethodBeat.o(183935);
      }
    });
    this.IaP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183936);
        paramAnonymousView = com.tencent.mm.emoji.b.d.fRi;
        com.tencent.mm.emoji.b.d.lI(3);
        EmojiPopView.b(EmojiPopView.this);
        EmojiPopView.c(EmojiPopView.this).setActivated(true);
        EmojiPopView.c(EmojiPopView.this).setVisibility(0);
        EmojiPopView.c(EmojiPopView.this).setText(2131758286);
        AppMethodBeat.o(183936);
      }
    });
    this.IaQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183937);
        if (EmojiPopView.d(EmojiPopView.this))
        {
          paramAnonymousView = com.tencent.mm.emoji.b.d.fRi;
          com.tencent.mm.emoji.b.d.lI(4);
          EmojiPopView.e(EmojiPopView.this);
          AppMethodBeat.o(183937);
          return;
        }
        paramAnonymousView = com.tencent.mm.emoji.b.d.fRi;
        com.tencent.mm.emoji.b.d.lI(5);
        EmojiPopView.f(EmojiPopView.this);
        AppMethodBeat.o(183937);
      }
    });
    if (aj.cbe()) {
      com.tencent.mm.kernel.g.afA().gcy.a(698, this);
    }
    AppMethodBeat.o(105300);
  }
  
  private void bWZ()
  {
    AppMethodBeat.i(183944);
    com.tencent.mm.ui.base.h.d(getContext(), getContext().getString(2131758409), "", "", getContext().getString(2131760315), null, null);
    AppMethodBeat.o(183944);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(183943);
    removeCallbacks(this.IaZ);
    if (this.oJG != null) {
      this.oJG.dismiss();
    }
    AppMethodBeat.o(183943);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(183942);
    postDelayed(this.IaZ, 100L);
    AppMethodBeat.o(183942);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(183941);
    super.dismiss();
    hideLoading();
    AppMethodBeat.o(183941);
  }
  
  public final void gD(View paramView)
  {
    AppMethodBeat.i(105302);
    kn(paramView.getContext());
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.IaS.x = (arrayOfInt[0] - (getMeasuredWidth() - paramView.getMeasuredWidth()) / 2);
    this.IaS.y = (arrayOfInt[1] - getMeasuredHeight() - this.IaG);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    if (j < getWidth() / 2)
    {
      this.IaS.x = (j - a.fromDPToPix(getContext(), 32));
      this.IaL.setBackgroundResource(2131232036);
      this.IaO.setBackgroundResource(2131232037);
      this.IaP.setBackgroundResource(2131232039);
      this.IaQ.setBackgroundResource(2131232038);
      AppMethodBeat.o(105302);
      return;
    }
    if (getWidth() / 2 + j > i)
    {
      this.IaS.x = (j + a.fromDPToPix(getContext(), 32) - getMeasuredWidth());
      this.IaL.setBackgroundResource(2131232072);
      this.IaO.setBackgroundResource(2131232073);
      this.IaP.setBackgroundResource(2131232075);
      this.IaQ.setBackgroundResource(2131232074);
      AppMethodBeat.o(105302);
      return;
    }
    this.IaL.setBackgroundResource(2131232065);
    this.IaO.setBackgroundResource(2131232066);
    this.IaP.setBackgroundResource(2131232068);
    this.IaQ.setBackgroundResource(2131232067);
    AppMethodBeat.o(105302);
  }
  
  public WindowManager.LayoutParams getWindowLayoutParams()
  {
    return this.IaS;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(183939);
    super.onDetachedFromWindow();
    if (aj.cbe()) {
      com.tencent.mm.kernel.g.afA().gcy.b(698, this);
    }
    AppMethodBeat.o(183939);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(183945);
    paramString = Collections.singletonList(this.IaU);
    ad.i("MicroMsg.EmojiPopView", "onSceneEnd: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.IaU, Integer.valueOf(this.IaT) });
    if ((this.IaY != null) && (paramn == this.IaY))
    {
      if (this.IaY.ikN == 3)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.IaT == 0)
          {
            com.tencent.mm.emoji.a.h.abj().dl(true);
            com.tencent.mm.emoji.a.h.abj().dk(true);
          }
          for (;;)
          {
            aw.eLx().FyY.m(this.IaT, paramString);
            dismiss();
            AppMethodBeat.o(183945);
            return;
            com.tencent.mm.emoji.a.h.abj().dn(true);
          }
        }
        bWZ();
        hideLoading();
        AppMethodBeat.o(183945);
        return;
      }
      if (this.IaY.ikN == 2)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.IaT == 0)
          {
            com.tencent.mm.emoji.a.h.abj().dl(true);
            com.tencent.mm.emoji.a.h.abj().dk(true);
          }
          for (;;)
          {
            aw.eLx().FyY.z(paramString, this.IaT);
            dismiss();
            AppMethodBeat.o(183945);
            return;
            com.tencent.mm.emoji.a.h.abj().dn(true);
          }
        }
        bWZ();
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
      this.xBI.setVisibility(4);
      this.fQC.setVisibility(0);
      ad.i("MicroMsg.EmojiPopView", "emoji is null. set null");
      AppMethodBeat.o(105301);
      return;
    }
    if (!paramEmojiInfo.JS().equals(this.IaU))
    {
      this.IaU = paramEmojiInfo.JS();
      this.IaV = paramEmojiInfo;
      this.xBI.setStatusListener(new EmojiStatusView.b()
      {
        public final void lG(int paramAnonymousInt)
        {
          AppMethodBeat.i(183938);
          ad.i("MicroMsg.EmojiPopView", "onStatus: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
      this.xBI.setEmojiInfo(paramEmojiInfo);
    }
    AppMethodBeat.o(105301);
  }
  
  public void setPopupType(int paramInt)
  {
    AppMethodBeat.i(183940);
    if ((!aj.cbe()) || (paramInt == -1) || (this.IaV == null) || (this.IaV.CZ()) || (this.IaV.field_catalog == EmojiGroupInfo.LBO) || (this.IaV.fZV() != EmojiInfo.a.FBv)) {}
    for (int i = 1;; i = 0)
    {
      this.IaX = false;
      if (i == 0) {
        break;
      }
      this.IaN.setVisibility(8);
      this.IaO.setVisibility(8);
      this.IaP.setVisibility(8);
      this.IaM.setVisibility(8);
      this.IaQ.setVisibility(8);
      this.IaR.setVisibility(8);
      ((ConstraintLayout.LayoutParams)this.xBI.getLayoutParams()).goneBottomMargin = a.fromDPToPix(getContext(), 28);
      AppMethodBeat.o(183940);
      return;
    }
    ((ConstraintLayout.LayoutParams)this.xBI.getLayoutParams()).goneBottomMargin = a.fromDPToPix(getContext(), 16);
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.IaN.setVisibility(0);
      this.IaO.setVisibility(0);
      this.IaP.setVisibility(0);
      this.IaM.setVisibility(0);
      this.IaQ.setVisibility(8);
      this.IaR.setVisibility(8);
    }
    for (;;)
    {
      this.IaT = paramInt;
      AppMethodBeat.o(183940);
      return;
      if ((paramInt == 2) || (paramInt == 3))
      {
        this.IaN.setVisibility(0);
        this.IaO.setVisibility(8);
        this.IaP.setVisibility(8);
        this.IaM.setVisibility(8);
        this.IaQ.setVisibility(0);
        this.IaR.setVisibility(0);
        if (bt.isNullOrNil(this.IaV.field_groupId)) {
          this.IaQ.setVisibility(8);
        }
        this.IaW = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().TD(this.IaU);
        this.IaR.setText(this.IaW);
        if (bt.isNullOrNil(this.IaW)) {
          this.IaR.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.popview.EmojiPopView
 * JD-Core Version:    0.7.0.1
 */