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
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.a.c;
import com.tencent.mm.plugin.sns.storage.a.c.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;

public final class c
  implements PopupWindow.OnDismissListener, b.c
{
  private Context mContext;
  private int pHU;
  private int uhv;
  private com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a zrr;
  private View zrs;
  private b zrt;
  private a zru;
  private com.tencent.mm.plugin.sns.ui.d.c zrv;
  private int zrw;
  private boolean zrx;
  
  private c(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private c(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(219094);
    this.zrw = 0;
    this.zrx = false;
    this.pHU = 0;
    this.mContext = paramContext;
    this.uhv = 2131496363;
    this.zru = new a();
    this.zrt = new b(paramContext, this.zru, this);
    this.pHU = this.mContext.getResources().getDimensionPixelOffset(2131167051);
    if ((paramContext instanceof SnsCommentDetailUI)) {
      this.zrx = true;
    }
    AppMethodBeat.o(219094);
  }
  
  private void Qh(int paramInt)
  {
    AppMethodBeat.i(219096);
    if (this.zrt != null) {
      this.zrt.Qh(paramInt);
    }
    AppMethodBeat.o(219096);
  }
  
  public static c a(Context paramContext, com.tencent.mm.plugin.sns.ui.d.c paramc)
  {
    AppMethodBeat.i(219093);
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = new c(paramContext);
        ae.w("FeedbackPromptManager", "create new feedback panel failed!");
      }
      catch (Throwable paramContext)
      {
        try
        {
          paramContext.zrv = paramc;
          AppMethodBeat.o(219093);
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
  
  private void dVl()
  {
    AppMethodBeat.i(219100);
    if (this.zrr != null) {
      this.zrr.dismiss();
    }
    AppMethodBeat.o(219100);
  }
  
  private void dVm()
  {
    AppMethodBeat.i(219101);
    try
    {
      t.cn(this.mContext, this.mContext.getString(2131766820));
      AppMethodBeat.o(219101);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219101);
    }
  }
  
  private static Rect eN(View paramView)
  {
    AppMethodBeat.i(219097);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    localRect.left = arrayOfInt[0];
    localRect.top = arrayOfInt[1];
    localRect.right = (localRect.left + paramView.getWidth());
    localRect.bottom = (localRect.top + paramView.getHeight());
    AppMethodBeat.o(219097);
    return localRect;
  }
  
  private int l(View paramView1, View paramView2)
  {
    AppMethodBeat.i(219098);
    paramView2.measure(View.MeasureSpec.makeMeasureSpec(this.pHU, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i = paramView2.getMeasuredHeight();
    paramView2 = eN(paramView1);
    Rect localRect = new Rect();
    paramView1.getWindowVisibleDisplayFrame(localRect);
    if (paramView2.bottom + i > localRect.height())
    {
      i = -(paramView2.height() + i);
      AppMethodBeat.o(219098);
      return i;
    }
    AppMethodBeat.o(219098);
    return 0;
  }
  
  public final void a(View paramView, int paramInt, Object paramObject)
  {
    int i = 1;
    Object localObject1 = null;
    AppMethodBeat.i(219099);
    if (paramInt == 5) {}
    try
    {
      if ((paramObject instanceof b.d)) {
        this.zrw = ((b.d)paramObject).zrp;
      }
      AppMethodBeat.o(219099);
      return;
    }
    catch (Throwable paramView)
    {
      ae.e("FeedbackPromptManager", "onAction failed : actionId = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(219099);
      return;
    }
    switch (paramInt)
    {
    }
    label642:
    for (;;)
    {
      AppMethodBeat.o(219099);
      return;
      dVm();
      dVl();
      paramView = this.zru;
      boolean bool = this.zrx;
      paramObject = paramView.zlW;
      Object localObject2 = paramView.dVj();
      com.tencent.mm.plugin.sns.storage.a locala = paramView.dVi();
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
        com.tencent.mm.plugin.sns.ad.f.g.a(paramView);
        AppMethodBeat.o(219099);
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
              paramView.zry = paramObject.field_snsId;
              if (bool) {
                i = 2;
              }
              paramView.mScene = i;
              paramView.zrz = i.azd(locala.dGD);
              paramView.zrA = ((com.tencent.mm.plugin.sns.storage.b)localObject2).zsJ;
            }
          }
        }
      }
      dVl();
      try
      {
        paramView = this.mContext;
        if (paramView != null)
        {
          paramObject = this.zru.dVf();
          com.tencent.mm.plugin.sns.c.a.iUz.i(paramObject, paramView);
        }
        AppMethodBeat.o(219099);
        return;
      }
      catch (Throwable paramView)
      {
        AppMethodBeat.o(219099);
        return;
      }
      if (this.zru.dVe())
      {
        i = l(this.zrs, this.zrr.getContentView());
        Qh(i);
        this.zrr.update(this.zrs, 0, i, -1, -1);
        paramView = this.zru.Qg(0);
        if (paramView != null)
        {
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.a(paramView, 0);
        }
        AppMethodBeat.o(219099);
        return;
      }
      dVm();
      dVl();
      if (this.zrv != null) {
        this.zrv.fe(paramView);
      }
      paramView = this.zru.Qg(1);
      if (paramView != null)
      {
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramView, 0);
      }
      AppMethodBeat.o(219099);
      return;
      dVm();
      dVl();
      if (this.zrv != null) {
        this.zrv.fe(paramView);
      }
      localObject1 = this.zru;
      i = this.zrw;
      paramView = ((a)localObject1).dVi();
      paramObject = ((a)localObject1).zlW;
      localObject1 = ((a)localObject1).zqW;
      if ((localObject1 != null) && (paramObject != null) && (paramView != null)) {
        if (paramView.zMo == null) {
          break label630;
        }
      }
      for (;;)
      {
        if (paramView == null) {
          break label642;
        }
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramView, 0);
        break;
        paramView = paramView.zMo.dZs();
        if (com.tencent.mm.plugin.sns.ad.f.c.m(paramView))
        {
          localObject2 = paramView.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramView = (a.c.a)((Iterator)localObject2).next();
          } while ((paramView == null) || (paramView.zMK != i));
        }
        label630:
        while (paramView != null)
        {
          paramView.zte = ((com.tencent.mm.plugin.sns.data.b)localObject1).zte;
          paramView.zML = System.currentTimeMillis();
          paramView = new r(paramObject.field_snsId, 8, paramView);
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
    AppMethodBeat.i(219095);
    if (paramView == null)
    {
      AppMethodBeat.o(219095);
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
            ae.e("FeedbackPromptManager", "the unlike tag is null. there is no data for showing window!");
            AppMethodBeat.o(219095);
            return false;
          }
        }
        else
        {
          ae.w("FeedbackPromptManager", "the tag is not AdUnlikeTag");
          localObject = null;
          continue;
        }
        locala = this.zru;
        try
        {
          locala.zqW = ((com.tencent.mm.plugin.sns.data.b)localObject);
          if (paramp == null) {
            continue;
          }
          locala.zlW = paramp;
          locala.zqX = ad.iR(ak.getContext());
        }
        catch (Throwable paramp)
        {
          ae.w("FeedbackDisplayDataSupplier", "there is something wrong in updateData");
          continue;
        }
        bool = this.zru.dVd();
        if (bool) {
          break label184;
        }
        AppMethodBeat.o(219095);
        return false;
      }
      catch (Throwable paramView)
      {
        a locala;
        ae.e("FeedbackPromptManager", "show feedback window has something wrong!");
        AppMethodBeat.o(219095);
        return false;
      }
      if (localObject != null) {
        locala.zlW = ah.dXE().aBr(((com.tencent.mm.plugin.sns.data.b)localObject).dqc);
      }
    }
    label184:
    if (this.zrr == null)
    {
      paramp = LayoutInflater.from(this.mContext).inflate(this.uhv, null);
      this.zrr = new com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a(this.mContext);
      this.zrr.setContentView(paramp);
      this.zrr.setWidth(this.pHU);
      this.zrr.setHeight(-2);
      this.zrr.setFocusable(true);
      this.zrr.setBackgroundDrawable(new ColorDrawable(0));
      this.zrr.setOnDismissListener(this);
    }
    boolean bool = this.zrr.isShowing();
    if (bool)
    {
      AppMethodBeat.o(219095);
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
      this.zrs = paramView;
      this.zrt.eM(this.zrr.getContentView());
      int j = l(this.zrs, this.zrr.getContentView());
      Qh(j);
      paramView = this.zrr;
      int i;
      label381:
      float f;
      if (j < 0)
      {
        i = 2131821780;
        paramView.setAnimationStyle(i);
        this.zrr.showAsDropDown(this.zrs, 0, j, 8388613);
        paramp = this.zrr;
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
          AppMethodBeat.o(219095);
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
          ae.w("FeedbackPopupWindow", "the window dim account is set failed!");
        }
      }
    }
  }
  
  public final void onDismiss()
  {
    this.zrr = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.c
 * JD-Core Version:    0.7.0.1
 */