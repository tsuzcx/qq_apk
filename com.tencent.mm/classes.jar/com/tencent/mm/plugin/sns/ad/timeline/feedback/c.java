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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ad.e.d;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.a.c;
import com.tencent.mm.plugin.sns.storage.a.c.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;

public final class c
  implements PopupWindow.OnDismissListener, b.c
{
  private Context mContext;
  private int oXG;
  private int sYG;
  private com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a xLB;
  private View xLC;
  private b xLD;
  private a xLE;
  private com.tencent.mm.plugin.sns.ui.d.b xLF;
  private int xLG;
  private boolean xLH;
  
  private c(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private c(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(199982);
    this.xLG = 0;
    this.xLH = false;
    this.oXG = 0;
    this.mContext = paramContext;
    this.sYG = 2131496363;
    this.xLE = new a();
    this.xLD = new b(paramContext, this.xLE, this);
    this.oXG = this.mContext.getResources().getDimensionPixelOffset(2131167051);
    if ((paramContext instanceof SnsCommentDetailUI)) {
      this.xLH = true;
    }
    AppMethodBeat.o(199982);
  }
  
  private void NX(int paramInt)
  {
    AppMethodBeat.i(199984);
    if (this.xLD != null) {
      this.xLD.NX(paramInt);
    }
    AppMethodBeat.o(199984);
  }
  
  public static c a(Context paramContext, com.tencent.mm.plugin.sns.ui.d.b paramb)
  {
    AppMethodBeat.i(199981);
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = new c(paramContext);
        ac.w("FeedbackPromptManager", "create new feedback panel failed!");
      }
      catch (Throwable paramContext)
      {
        try
        {
          paramContext.xLF = paramb;
          AppMethodBeat.o(199981);
          return paramContext;
        }
        catch (Throwable paramb)
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
  
  private void dFT()
  {
    AppMethodBeat.i(199988);
    if (this.xLB != null) {
      this.xLB.dismiss();
    }
    AppMethodBeat.o(199988);
  }
  
  private void dFU()
  {
    AppMethodBeat.i(199989);
    try
    {
      t.ch(this.mContext, this.mContext.getString(2131766820));
      AppMethodBeat.o(199989);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(199989);
    }
  }
  
  private static Rect eA(View paramView)
  {
    AppMethodBeat.i(199985);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    localRect.left = arrayOfInt[0];
    localRect.top = arrayOfInt[1];
    localRect.right = (localRect.left + paramView.getWidth());
    localRect.bottom = (localRect.top + paramView.getHeight());
    AppMethodBeat.o(199985);
    return localRect;
  }
  
  private int k(View paramView1, View paramView2)
  {
    AppMethodBeat.i(199986);
    paramView2.measure(View.MeasureSpec.makeMeasureSpec(this.oXG, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i = paramView2.getMeasuredHeight();
    paramView2 = eA(paramView1);
    Rect localRect = new Rect();
    paramView1.getWindowVisibleDisplayFrame(localRect);
    if (paramView2.bottom + i > localRect.height())
    {
      i = -(paramView2.height() + i);
      AppMethodBeat.o(199986);
      return i;
    }
    AppMethodBeat.o(199986);
    return 0;
  }
  
  public final void a(View paramView, int paramInt, Object paramObject)
  {
    int i = 1;
    Object localObject1 = null;
    AppMethodBeat.i(199987);
    if (paramInt == 5) {}
    try
    {
      if ((paramObject instanceof b.d)) {
        this.xLG = ((b.d)paramObject).xLz;
      }
      AppMethodBeat.o(199987);
      return;
    }
    catch (Throwable paramView)
    {
      ac.e("FeedbackPromptManager", "onAction failed : actionId = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(199987);
      return;
    }
    switch (paramInt)
    {
    }
    label642:
    for (;;)
    {
      AppMethodBeat.o(199987);
      return;
      dFU();
      dFT();
      paramView = this.xLE;
      boolean bool = this.xLH;
      paramObject = paramView.xHc;
      Object localObject2 = paramView.dFR();
      com.tencent.mm.plugin.sns.storage.a locala = paramView.dFQ();
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
        d.a(paramView);
        AppMethodBeat.o(199987);
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
              paramView.xLI = paramObject.field_snsId;
              if (bool) {
                i = 2;
              }
              paramView.mScene = i;
              paramView.xLJ = h.asK(locala.dtx);
              paramView.xLK = ((com.tencent.mm.plugin.sns.storage.b)localObject2).xOm;
            }
          }
        }
      }
      dFT();
      try
      {
        paramView = this.mContext;
        if (paramView != null)
        {
          paramObject = this.xLE.dFN();
          com.tencent.mm.plugin.sns.c.a.iyx.i(paramObject, paramView);
        }
        AppMethodBeat.o(199987);
        return;
      }
      catch (Throwable paramView)
      {
        AppMethodBeat.o(199987);
        return;
      }
      if (this.xLE.eEw())
      {
        i = k(this.xLC, this.xLB.getContentView());
        NX(i);
        this.xLB.update(this.xLC, 0, i, -1, -1);
        paramView = this.xLE.NW(0);
        if (paramView != null)
        {
          g.agS();
          g.agQ().ghe.a(paramView, 0);
        }
        AppMethodBeat.o(199987);
        return;
      }
      dFU();
      dFT();
      if (this.xLF != null) {
        this.xLF.eQ(paramView);
      }
      paramView = this.xLE.NW(1);
      if (paramView != null)
      {
        g.agS();
        g.agQ().ghe.a(paramView, 0);
      }
      AppMethodBeat.o(199987);
      return;
      dFU();
      dFT();
      if (this.xLF != null) {
        this.xLF.eQ(paramView);
      }
      localObject1 = this.xLE;
      i = this.xLG;
      paramView = ((a)localObject1).dFQ();
      paramObject = ((a)localObject1).xHc;
      localObject1 = ((a)localObject1).xLg;
      if ((localObject1 != null) && (paramObject != null) && (paramView != null)) {
        if (paramView.yeS == null) {
          break label630;
        }
      }
      for (;;)
      {
        if (paramView == null) {
          break label642;
        }
        g.agS();
        g.agQ().ghe.a(paramView, 0);
        break;
        paramView = paramView.yeS.dJD();
        if (com.tencent.mm.plugin.sns.ad.e.b.m(paramView))
        {
          localObject2 = paramView.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramView = (a.c.a)((Iterator)localObject2).next();
          } while ((paramView == null) || (paramView.yfn != i));
        }
        label630:
        while (paramView != null)
        {
          paramView.xMz = ((com.tencent.mm.plugin.sns.data.b)localObject1).xMz;
          paramView.yfo = System.currentTimeMillis();
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
    AppMethodBeat.i(199983);
    if (paramView == null)
    {
      AppMethodBeat.o(199983);
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
            ac.e("FeedbackPromptManager", "the unlike tag is null. there is no data for showing window!");
            AppMethodBeat.o(199983);
            return false;
          }
        }
        else
        {
          ac.w("FeedbackPromptManager", "the tag is not AdUnlikeTag");
          localObject = null;
          continue;
        }
        locala = this.xLE;
        try
        {
          locala.xLg = ((com.tencent.mm.plugin.sns.data.b)localObject);
          if (paramp == null) {
            continue;
          }
          locala.xHc = paramp;
          locala.xLh = ab.iC(ai.getContext());
        }
        catch (Throwable paramp)
        {
          ac.w("FeedbackDisplayDataSupplier", "there is something wrong in updateData");
          continue;
        }
        bool = this.xLE.eBz();
        if (bool) {
          break label184;
        }
        AppMethodBeat.o(199983);
        return false;
      }
      catch (Throwable paramView)
      {
        a locala;
        ac.e("FeedbackPromptManager", "show feedback window has something wrong!");
        AppMethodBeat.o(199983);
        return false;
      }
      if (localObject != null) {
        locala.xHc = af.dHR().auT(((com.tencent.mm.plugin.sns.data.b)localObject).ddB);
      }
    }
    label184:
    if (this.xLB == null)
    {
      paramp = LayoutInflater.from(this.mContext).inflate(this.sYG, null);
      this.xLB = new com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a(this.mContext);
      this.xLB.setContentView(paramp);
      this.xLB.setWidth(this.oXG);
      this.xLB.setHeight(-2);
      this.xLB.setFocusable(true);
      this.xLB.setBackgroundDrawable(new ColorDrawable(0));
      this.xLB.setOnDismissListener(this);
    }
    boolean bool = this.xLB.isShowing();
    if (bool)
    {
      AppMethodBeat.o(199983);
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
      this.xLC = paramView;
      this.xLD.ez(this.xLB.getContentView());
      int j = k(this.xLC, this.xLB.getContentView());
      NX(j);
      paramView = this.xLB;
      int i;
      label381:
      float f;
      if (j < 0)
      {
        i = 2131821780;
        paramView.setAnimationStyle(i);
        this.xLB.showAsDropDown(this.xLC, 0, j, 8388613);
        paramp = this.xLB;
        bool = aj.DT();
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
          AppMethodBeat.o(199983);
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
          ac.w("FeedbackPopupWindow", "the window dim account is set failed!");
        }
      }
    }
  }
  
  public final void onDismiss()
  {
    this.xLB = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.c
 * JD-Core Version:    0.7.0.1
 */