package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.a.c;
import com.tencent.mm.plugin.sns.storage.a.c.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;

public final class c
  implements PopupWindow.OnDismissListener, b.c
{
  private Context mContext;
  private int pBq;
  private int tWx;
  private com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a zaQ;
  private View zaR;
  private b zaS;
  private a zaT;
  private com.tencent.mm.plugin.sns.ui.d.c zaU;
  private int zaV;
  private boolean zaW;
  
  private c(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private c(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(197628);
    this.zaV = 0;
    this.zaW = false;
    this.pBq = 0;
    this.mContext = paramContext;
    this.tWx = 2131496363;
    this.zaT = new a();
    this.zaS = new b(paramContext, this.zaT, this);
    this.pBq = this.mContext.getResources().getDimensionPixelOffset(2131167051);
    if ((paramContext instanceof SnsCommentDetailUI)) {
      this.zaW = true;
    }
    AppMethodBeat.o(197628);
  }
  
  private void PA(int paramInt)
  {
    AppMethodBeat.i(197630);
    if (this.zaS != null) {
      this.zaS.PA(paramInt);
    }
    AppMethodBeat.o(197630);
  }
  
  public static c a(Context paramContext, com.tencent.mm.plugin.sns.ui.d.c paramc)
  {
    AppMethodBeat.i(197627);
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = new c(paramContext);
        ad.w("FeedbackPromptManager", "create new feedback panel failed!");
      }
      catch (Throwable paramContext)
      {
        try
        {
          paramContext.zaU = paramc;
          AppMethodBeat.o(197627);
          return paramContext;
        }
        catch (Throwable paramc)
        {
          break label33;
        }
        paramContext = paramContext;
        paramContext = null;
      }
      label33:
      continue;
      paramContext = null;
    }
  }
  
  private void dRN()
  {
    AppMethodBeat.i(197634);
    if (this.zaQ != null) {
      this.zaQ.dismiss();
    }
    AppMethodBeat.o(197634);
  }
  
  private void dRO()
  {
    AppMethodBeat.i(197635);
    try
    {
      t.cm(this.mContext, this.mContext.getString(2131766820));
      AppMethodBeat.o(197635);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197635);
    }
  }
  
  private static Rect eN(View paramView)
  {
    AppMethodBeat.i(197631);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    localRect.left = arrayOfInt[0];
    localRect.top = arrayOfInt[1];
    localRect.right = (localRect.left + paramView.getWidth());
    localRect.bottom = (localRect.top + paramView.getHeight());
    AppMethodBeat.o(197631);
    return localRect;
  }
  
  private int l(View paramView1, View paramView2)
  {
    AppMethodBeat.i(197632);
    paramView2.measure(View.MeasureSpec.makeMeasureSpec(this.pBq, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i = paramView2.getMeasuredHeight();
    paramView2 = eN(paramView1);
    Rect localRect = new Rect();
    paramView1.getWindowVisibleDisplayFrame(localRect);
    if (paramView2.bottom + i > localRect.height())
    {
      i = -(paramView2.height() + i);
      AppMethodBeat.o(197632);
      return i;
    }
    AppMethodBeat.o(197632);
    return 0;
  }
  
  public final void a(View paramView, int paramInt, Object paramObject)
  {
    int i = 1;
    Object localObject1 = null;
    AppMethodBeat.i(197633);
    if (paramInt == 5) {}
    try
    {
      if ((paramObject instanceof b.d)) {
        this.zaV = ((b.d)paramObject).zaO;
      }
      AppMethodBeat.o(197633);
      return;
    }
    catch (Throwable paramView)
    {
      ad.e("FeedbackPromptManager", "onAction failed : actionId = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(197633);
      return;
    }
    switch (paramInt)
    {
    }
    label642:
    for (;;)
    {
      AppMethodBeat.o(197633);
      return;
      dRO();
      dRN();
      paramView = this.zaT;
      boolean bool = this.zaW;
      paramObject = paramView.yVM;
      Object localObject2 = paramView.dRL();
      com.tencent.mm.plugin.sns.storage.a locala = paramView.dRK();
      paramView = (View)localObject1;
      if (paramObject != null)
      {
        paramView = (View)localObject1;
        if (localObject2 != null)
        {
          if (locala != null) {
            break label168;
          }
          paramView = (View)localObject1;
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.sns.ad.e.g.a(paramView);
        AppMethodBeat.o(197633);
        return;
        label168:
        paramView = (View)localObject1;
        if (paramObject != null)
        {
          paramView = (View)localObject1;
          if (locala != null)
          {
            paramView = (View)localObject1;
            if (localObject2 != null)
            {
              paramView = new com.tencent.mm.plugin.sns.ad.timeline.feedback.a.a();
              paramView.zaX = paramObject.field_snsId;
              if (bool) {
                i = 2;
              }
              paramView.mScene = i;
              paramView.zaY = h.axM(locala.dFy);
              paramView.zaZ = ((com.tencent.mm.plugin.sns.storage.b)localObject2).zeg;
            }
          }
        }
      }
      dRN();
      try
      {
        paramView = this.mContext;
        if (paramView != null)
        {
          paramObject = this.zaT.dRH();
          com.tencent.mm.plugin.sns.c.a.iRG.i(paramObject, paramView);
        }
        AppMethodBeat.o(197633);
        return;
      }
      catch (Throwable paramView)
      {
        AppMethodBeat.o(197633);
        return;
      }
      if (this.zaT.dRG())
      {
        i = l(this.zaR, this.zaQ.getContentView());
        PA(i);
        this.zaQ.update(this.zaR, 0, i, -1, -1);
        paramView = this.zaT.Pz(0);
        if (paramView != null)
        {
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(paramView, 0);
        }
        AppMethodBeat.o(197633);
        return;
      }
      dRO();
      dRN();
      if (this.zaU != null) {
        this.zaU.ff(paramView);
      }
      paramView = this.zaT.Pz(1);
      if (paramView != null)
      {
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(paramView, 0);
      }
      AppMethodBeat.o(197633);
      return;
      dRO();
      dRN();
      if (this.zaU != null) {
        this.zaU.ff(paramView);
      }
      localObject1 = this.zaT;
      i = this.zaV;
      paramView = ((a)localObject1).dRK();
      paramObject = ((a)localObject1).yVM;
      localObject1 = ((a)localObject1).zav;
      if ((localObject1 != null) && (paramObject != null) && (paramView != null)) {
        if (paramView.zuT == null) {
          break label630;
        }
      }
      for (;;)
      {
        if (paramView == null) {
          break label642;
        }
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(paramView, 0);
        break;
        paramView = paramView.zuT.dVR();
        if (com.tencent.mm.plugin.sns.ad.e.b.m(paramView))
        {
          localObject2 = paramView.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramView = (a.c.a)((Iterator)localObject2).next();
          } while ((paramView == null) || (paramView.zvp != i));
        }
        label630:
        while (paramView != null)
        {
          paramView.zcr = ((com.tencent.mm.plugin.sns.data.b)localObject1).zcr;
          paramView.zvq = System.currentTimeMillis();
          paramView = new com.tencent.mm.plugin.sns.model.q(paramObject.field_snsId, 8, paramView);
          break;
          paramView = null;
          continue;
          paramView = null;
          break;
        }
        paramView = null;
      }
    }
  }
  
  public final boolean a(View paramView, p paramp)
  {
    AppMethodBeat.i(197629);
    if (paramView == null)
    {
      AppMethodBeat.o(197629);
      return false;
    }
    Object localObject;
    for (;;)
    {
      try
      {
        localObject = paramView.getTag();
        if ((localObject instanceof com.tencent.mm.plugin.sns.data.b))
        {
          localObject = (com.tencent.mm.plugin.sns.data.b)localObject;
          if (localObject == null)
          {
            ad.e("FeedbackPromptManager", "the unlike tag is null. there is no data for showing window!");
            AppMethodBeat.o(197629);
            return false;
          }
        }
        else
        {
          ad.w("FeedbackPromptManager", "the tag is not AdUnlikeTag");
          localObject = null;
          continue;
        }
        locala = this.zaT;
        try
        {
          locala.zav = ((com.tencent.mm.plugin.sns.data.b)localObject);
          if (paramp == null) {
            continue;
          }
          locala.yVM = paramp;
          locala.zaw = ac.iM(aj.getContext());
        }
        catch (Throwable paramp)
        {
          ad.w("FeedbackDisplayDataSupplier", "there is something wrong in updateData");
          continue;
        }
        bool = this.zaT.dRF();
        if (bool) {
          break label184;
        }
        AppMethodBeat.o(197629);
        return false;
      }
      catch (Throwable paramView)
      {
        a locala;
        ad.e("FeedbackPromptManager", "show feedback window has something wrong!");
        AppMethodBeat.o(197629);
        return false;
      }
      if (localObject != null) {
        locala.yVM = ag.dUe().aAa(((com.tencent.mm.plugin.sns.data.b)localObject).doX);
      }
    }
    label184:
    if (this.zaQ == null)
    {
      paramp = LayoutInflater.from(this.mContext).inflate(this.tWx, null);
      this.zaQ = new com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a(this.mContext);
      this.zaQ.setContentView(paramp);
      this.zaQ.setWidth(this.pBq);
      this.zaQ.setHeight(-2);
      this.zaQ.setFocusable(true);
      this.zaQ.setBackgroundDrawable(new ColorDrawable(0));
      this.zaQ.setOnDismissListener(this);
    }
    boolean bool = this.zaQ.isShowing();
    if (bool)
    {
      AppMethodBeat.o(197629);
      return true;
    }
    if (!(paramView instanceof ViewGroup))
    {
      paramp = paramView.getParent();
      if (paramp != null) {
        paramView = (View)paramp;
      }
    }
    for (;;)
    {
      this.zaR = paramView;
      this.zaS.eM(this.zaQ.getContentView());
      int j = l(this.zaR, this.zaQ.getContentView());
      PA(j);
      paramView = this.zaQ;
      int i;
      label381:
      float f;
      if (j < 0)
      {
        i = 2131821780;
        paramView.setAnimationStyle(i);
        this.zaQ.showAsDropDown(this.zaR, 0, j, 8388613);
        paramp = this.zaQ;
        bool = al.isDarkMode();
        if (!bool) {
          break label500;
        }
        f = 0.1F;
      }
      try
      {
        for (;;)
        {
          paramView = paramp.getContentView().getRootView();
          paramp = (WindowManager)paramp.mContext.getSystemService("window");
          localObject = (WindowManager.LayoutParams)paramView.getLayoutParams();
          ((WindowManager.LayoutParams)localObject).flags |= 0x2;
          ((WindowManager.LayoutParams)localObject).dimAmount = f;
          paramp.updateViewLayout(paramView, (ViewGroup.LayoutParams)localObject);
          AppMethodBeat.o(197629);
          return true;
          break;
          i = 2131821781;
          break label381;
          label500:
          f = 0.5F;
        }
      }
      catch (Throwable paramView)
      {
        for (;;)
        {
          ad.w("FeedbackPopupWindow", "the window dim account is set failed!");
        }
      }
    }
  }
  
  public final void onDismiss()
  {
    this.zaQ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.c
 * JD-Core Version:    0.7.0.1
 */