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
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Collections;

public class EmojiPopView
  extends AbstractPopView
  implements com.tencent.mm.al.f
{
  private EmojiStatusView AfS;
  private View LuI;
  private View LuJ;
  private View LuK;
  private View LuL;
  private View LuM;
  private TextView LuN;
  private TextView LuO;
  private WindowManager.LayoutParams LuP;
  private int LuQ;
  private String LuR;
  private EmojiInfo LuS;
  private String LuT;
  private boolean LuU;
  private c LuV;
  private Runnable LuW;
  private ProgressBar gnZ;
  private p pQE;
  
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
    this.LuQ = -1;
    this.LuU = false;
    this.LuW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(183934);
        EmojiPopView.a(EmojiPopView.this, p.a(EmojiPopView.this.getContext(), EmojiPopView.this.getContext().getString(2131758410), true, 0, null));
        AppMethodBeat.o(183934);
      }
    };
    inflate(paramContext, 2131493788, this);
    this.LuI = findViewById(2131299413);
    this.AfS = ((EmojiStatusView)findViewById(2131300914));
    this.gnZ = ((ProgressBar)findViewById(2131303515));
    this.LuJ = findViewById(2131299418);
    this.LuK = findViewById(2131299415);
    this.LuL = findViewById(2131299417);
    this.LuM = findViewById(2131299414);
    this.LuN = ((TextView)findViewById(2131299416));
    this.LuO = ((TextView)findViewById(2131299419));
    setBackground(null);
    this.LuP = new WindowManager.LayoutParams(2, 262400, 1);
    this.LuP.width = -2;
    this.LuP.height = -2;
    this.LuP.gravity = 8388659;
    this.LuL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183935);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/popview/EmojiPopView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = com.tencent.mm.emoji.b.d.goG;
        com.tencent.mm.emoji.b.d.ma(2);
        EmojiPopView.a(EmojiPopView.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183935);
      }
    });
    this.LuM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183936);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/popview/EmojiPopView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = com.tencent.mm.emoji.b.d.goG;
        com.tencent.mm.emoji.b.d.ma(3);
        EmojiPopView.b(EmojiPopView.this);
        EmojiPopView.c(EmojiPopView.this).setActivated(true);
        EmojiPopView.c(EmojiPopView.this).setVisibility(0);
        EmojiPopView.c(EmojiPopView.this).setText(2131758286);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183936);
      }
    });
    this.LuN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183937);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/popview/EmojiPopView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (EmojiPopView.d(EmojiPopView.this))
        {
          paramAnonymousView = com.tencent.mm.emoji.b.d.goG;
          com.tencent.mm.emoji.b.d.ma(4);
          EmojiPopView.e(EmojiPopView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/popview/EmojiPopView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183937);
          return;
          paramAnonymousView = com.tencent.mm.emoji.b.d.goG;
          com.tencent.mm.emoji.b.d.ma(5);
          EmojiPopView.f(EmojiPopView.this);
        }
      }
    });
    if (aj.cmR()) {
      g.ajB().gAO.a(698, this);
    }
    AppMethodBeat.o(105300);
  }
  
  private void ciP()
  {
    AppMethodBeat.i(183944);
    h.e(getContext(), getContext().getString(2131758409), "", "", getContext().getString(2131760315), null, null);
    AppMethodBeat.o(183944);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(183943);
    removeCallbacks(this.LuW);
    if (this.pQE != null) {
      this.pQE.dismiss();
    }
    AppMethodBeat.o(183943);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(183942);
    postDelayed(this.LuW, 100L);
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
    return this.LuP;
  }
  
  public final void hl(View paramView)
  {
    AppMethodBeat.i(105302);
    kL(paramView.getContext());
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.LuP.x = (arrayOfInt[0] - (getMeasuredWidth() - paramView.getMeasuredWidth()) / 2);
    this.LuP.y = (arrayOfInt[1] - getMeasuredHeight() - this.LuD);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    if (j < getWidth() / 2)
    {
      this.LuP.x = (j - com.tencent.mm.cc.a.fromDPToPix(getContext(), 32));
      this.LuI.setBackgroundResource(2131232036);
      this.LuL.setBackgroundResource(2131232037);
      this.LuM.setBackgroundResource(2131232039);
      this.LuN.setBackgroundResource(2131232038);
      AppMethodBeat.o(105302);
      return;
    }
    if (getWidth() / 2 + j > i)
    {
      this.LuP.x = (j + com.tencent.mm.cc.a.fromDPToPix(getContext(), 32) - getMeasuredWidth());
      this.LuI.setBackgroundResource(2131232072);
      this.LuL.setBackgroundResource(2131232073);
      this.LuM.setBackgroundResource(2131232075);
      this.LuN.setBackgroundResource(2131232074);
      AppMethodBeat.o(105302);
      return;
    }
    this.LuI.setBackgroundResource(2131232065);
    this.LuL.setBackgroundResource(2131232066);
    this.LuM.setBackgroundResource(2131232068);
    this.LuN.setBackgroundResource(2131232067);
    AppMethodBeat.o(105302);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(183939);
    super.onDetachedFromWindow();
    if (aj.cmR()) {
      g.ajB().gAO.b(698, this);
    }
    AppMethodBeat.o(183939);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(183945);
    paramString = Collections.singletonList(this.LuR);
    ad.i("MicroMsg.EmojiPopView", "onSceneEnd: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.LuR, Integer.valueOf(this.LuQ) });
    if ((this.LuV != null) && (paramn == this.LuV))
    {
      if (this.LuV.jed == 3)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.LuQ == 0)
          {
            i.aeL().dm(true);
            i.aeL().dl(true);
          }
          for (;;)
          {
            bd.frc().ILn.q(this.LuQ, paramString);
            dismiss();
            AppMethodBeat.o(183945);
            return;
            i.aeL().jdMethod_do(true);
          }
        }
        ciP();
        hideLoading();
        AppMethodBeat.o(183945);
        return;
      }
      if (this.LuV.jed == 2)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.LuQ == 0)
          {
            i.aeL().dm(true);
            i.aeL().dl(true);
          }
          for (;;)
          {
            bd.frc().ILn.B(paramString, this.LuQ);
            dismiss();
            AppMethodBeat.o(183945);
            return;
            i.aeL().jdMethod_do(true);
          }
        }
        ciP();
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
      this.AfS.setVisibility(4);
      this.gnZ.setVisibility(0);
      ad.i("MicroMsg.EmojiPopView", "emoji is null. set null");
      AppMethodBeat.o(105301);
      return;
    }
    if (!paramEmojiInfo.Lb().equals(this.LuR))
    {
      this.LuR = paramEmojiInfo.Lb();
      this.LuS = paramEmojiInfo;
      this.AfS.setStatusListener(new EmojiStatusView.b()
      {
        public final void md(int paramAnonymousInt)
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
      this.AfS.setEmojiInfo(paramEmojiInfo);
    }
    AppMethodBeat.o(105301);
  }
  
  public void setPopupType(int paramInt)
  {
    AppMethodBeat.i(183940);
    if ((!aj.cmR()) || (paramInt == -1) || (this.LuS == null) || (this.LuS.Eb()) || (this.LuS.field_catalog == EmojiGroupInfo.OeL) || (this.LuS.gzL() != EmojiInfo.a.INK)) {}
    for (int i = 1;; i = 0)
    {
      this.LuU = false;
      if (i == 0) {
        break;
      }
      this.LuK.setVisibility(8);
      this.LuL.setVisibility(8);
      this.LuM.setVisibility(8);
      this.LuJ.setVisibility(8);
      this.LuN.setVisibility(8);
      this.LuO.setVisibility(8);
      ((ConstraintLayout.LayoutParams)this.AfS.getLayoutParams()).goneBottomMargin = com.tencent.mm.cc.a.fromDPToPix(getContext(), 28);
      AppMethodBeat.o(183940);
      return;
    }
    ((ConstraintLayout.LayoutParams)this.AfS.getLayoutParams()).goneBottomMargin = com.tencent.mm.cc.a.fromDPToPix(getContext(), 16);
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.LuK.setVisibility(0);
      this.LuL.setVisibility(0);
      this.LuM.setVisibility(0);
      this.LuJ.setVisibility(0);
      this.LuN.setVisibility(8);
      this.LuO.setVisibility(8);
    }
    for (;;)
    {
      this.LuQ = paramInt;
      AppMethodBeat.o(183940);
      return;
      if ((paramInt == 2) || (paramInt == 3))
      {
        this.LuK.setVisibility(0);
        this.LuL.setVisibility(8);
        this.LuM.setVisibility(8);
        this.LuJ.setVisibility(8);
        this.LuN.setVisibility(0);
        this.LuO.setVisibility(0);
        if (bt.isNullOrNil(this.LuS.field_groupId)) {
          this.LuN.setVisibility(8);
        }
        this.LuT = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().abv(this.LuR);
        this.LuO.setText(this.LuT);
        if (bt.isNullOrNil(this.LuT)) {
          this.LuO.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.popview.EmojiPopView
 * JD-Core Version:    0.7.0.1
 */