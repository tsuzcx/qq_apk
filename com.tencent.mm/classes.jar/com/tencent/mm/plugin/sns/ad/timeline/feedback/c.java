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
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.c;
import com.tencent.mm.plugin.sns.storage.ADInfo.c.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.u;
import java.util.Iterator;
import java.util.List;

public final class c
  implements PopupWindow.OnDismissListener, b.c
{
  private com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a Dys;
  private View Dyt;
  private b Dyu;
  private a Dyv;
  private com.tencent.mm.plugin.sns.ui.d.c Dyw;
  private int Dyx;
  private boolean Dyy;
  private Context mContext;
  private int qXG;
  private int xzP;
  
  private c(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private c(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(202172);
    this.Dyx = 0;
    this.Dyy = false;
    this.qXG = 0;
    this.mContext = paramContext;
    this.xzP = 2131496366;
    this.Dyv = new a();
    this.Dyu = new b(paramContext, this.Dyv, this);
    this.qXG = this.mContext.getResources().getDimensionPixelOffset(2131166950);
    if ((paramContext instanceof SnsCommentDetailUI)) {
      this.Dyy = true;
    }
    AppMethodBeat.o(202172);
  }
  
  private void XM(int paramInt)
  {
    AppMethodBeat.i(202174);
    if (this.Dyu != null) {
      this.Dyu.XM(paramInt);
    }
    AppMethodBeat.o(202174);
  }
  
  public static c a(Context paramContext, com.tencent.mm.plugin.sns.ui.d.c paramc)
  {
    AppMethodBeat.i(202171);
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = new c(paramContext);
        Log.w("FeedbackPromptManager", "create new feedback panel failed!");
      }
      catch (Throwable paramContext)
      {
        try
        {
          paramContext.Dyw = paramc;
          AppMethodBeat.o(202171);
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
  
  private void eXP()
  {
    AppMethodBeat.i(202178);
    if (this.Dys != null) {
      this.Dys.dismiss();
    }
    AppMethodBeat.o(202178);
  }
  
  private void eXQ()
  {
    AppMethodBeat.i(202179);
    try
    {
      u.cG(this.mContext, this.mContext.getString(2131765978));
      AppMethodBeat.o(202179);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202179);
    }
  }
  
  private static Rect eZ(View paramView)
  {
    AppMethodBeat.i(202175);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    localRect.left = arrayOfInt[0];
    localRect.top = arrayOfInt[1];
    localRect.right = (localRect.left + paramView.getWidth());
    localRect.bottom = (localRect.top + paramView.getHeight());
    AppMethodBeat.o(202175);
    return localRect;
  }
  
  private int m(View paramView1, View paramView2)
  {
    AppMethodBeat.i(202176);
    paramView2.measure(View.MeasureSpec.makeMeasureSpec(this.qXG, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i = paramView2.getMeasuredHeight();
    paramView2 = eZ(paramView1);
    Rect localRect = new Rect();
    paramView1.getWindowVisibleDisplayFrame(localRect);
    if (paramView2.bottom + i > localRect.height())
    {
      i = -(paramView2.height() + i);
      AppMethodBeat.o(202176);
      return i;
    }
    AppMethodBeat.o(202176);
    return 0;
  }
  
  public final void a(View paramView, int paramInt, Object paramObject)
  {
    int i = 1;
    Object localObject1 = null;
    AppMethodBeat.i(202177);
    if (paramInt == 5) {}
    try
    {
      if ((paramObject instanceof b.d)) {
        this.Dyx = ((b.d)paramObject).Dyq;
      }
      AppMethodBeat.o(202177);
      return;
    }
    catch (Throwable paramView)
    {
      Log.e("FeedbackPromptManager", "onAction failed : actionId = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(202177);
      return;
    }
    switch (paramInt)
    {
    }
    label642:
    for (;;)
    {
      AppMethodBeat.o(202177);
      return;
      eXQ();
      eXP();
      paramView = this.Dyv;
      boolean bool = this.Dyy;
      paramObject = paramView.DqO;
      Object localObject2 = paramView.getAdXml();
      ADInfo localADInfo = paramView.getAdInfo();
      paramView = (View)localObject1;
      if (paramObject != null)
      {
        paramView = (View)localObject1;
        if (localObject2 != null)
        {
          if (localADInfo != null) {
            break label168;
          }
          paramView = (View)localObject1;
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.sns.ad.i.i.a(paramView);
        AppMethodBeat.o(202177);
        return;
        label168:
        paramView = (View)localObject1;
        if (paramObject != null)
        {
          paramView = (View)localObject1;
          if (localADInfo != null)
          {
            paramView = (View)localObject1;
            if (localObject2 != null)
            {
              paramView = new com.tencent.mm.plugin.sns.ad.timeline.feedback.a.a();
              paramView.Dyz = paramObject.field_snsId;
              if (bool) {
                i = 2;
              }
              paramView.mScene = i;
              paramView.DyA = com.tencent.mm.plugin.sns.data.i.aNZ(localADInfo.uxInfo);
              paramView.DyB = ((ADXml)localObject2).adExtInfo;
            }
          }
        }
      }
      eXP();
      try
      {
        paramView = this.mContext;
        if (paramView != null)
        {
          paramObject = this.Dyv.eXL();
          com.tencent.mm.plugin.sns.c.a.jRt.i(paramObject, paramView);
        }
        AppMethodBeat.o(202177);
        return;
      }
      catch (Throwable paramView)
      {
        AppMethodBeat.o(202177);
        return;
      }
      if (this.Dyv.eXK())
      {
        i = m(this.Dyt, this.Dys.getContentView());
        XM(i);
        this.Dys.update(this.Dyt, 0, i, -1, -1);
        paramView = this.Dyv.XL(0);
        if (paramView != null)
        {
          g.aAi();
          g.aAg().hqi.a(paramView, 0);
        }
        AppMethodBeat.o(202177);
        return;
      }
      eXQ();
      eXP();
      if (this.Dyw != null) {
        this.Dyw.ft(paramView);
      }
      paramView = this.Dyv.XL(1);
      if (paramView != null)
      {
        g.aAi();
        g.aAg().hqi.a(paramView, 0);
      }
      AppMethodBeat.o(202177);
      return;
      eXQ();
      eXP();
      if (this.Dyw != null) {
        this.Dyw.ft(paramView);
      }
      localObject1 = this.Dyv;
      i = this.Dyx;
      paramView = ((a)localObject1).getAdInfo();
      paramObject = ((a)localObject1).DqO;
      localObject1 = ((a)localObject1).DxX;
      if ((localObject1 != null) && (paramObject != null) && (paramView != null)) {
        if (paramView.adUnlikeInfo == null) {
          break label630;
        }
      }
      for (;;)
      {
        if (paramView == null) {
          break label642;
        }
        g.aAi();
        g.aAg().hqi.a(paramView, 0);
        break;
        paramView = paramView.adUnlikeInfo.fcH();
        if (com.tencent.mm.plugin.sns.ad.i.c.o(paramView))
        {
          localObject2 = paramView.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramView = (ADInfo.c.a)((Iterator)localObject2).next();
          } while ((paramView == null) || (paramView.DWd != i));
        }
        label630:
        while (paramView != null)
        {
          paramView.DDs = ((com.tencent.mm.plugin.sns.data.c)localObject1).DDs;
          paramView.DWe = System.currentTimeMillis();
          paramView = new s(paramObject.field_snsId, 8, paramView);
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
  
  public final boolean a(View paramView, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202173);
    if (paramView == null)
    {
      AppMethodBeat.o(202173);
      return false;
    }
    Object localObject;
    for (;;)
    {
      try
      {
        localObject = paramView.getTag();
        if ((localObject instanceof com.tencent.mm.plugin.sns.data.c))
        {
          localObject = (com.tencent.mm.plugin.sns.data.c)localObject;
          if (localObject == null)
          {
            Log.e("FeedbackPromptManager", "the unlike tag is null. there is no data for showing window!");
            AppMethodBeat.o(202173);
            return false;
          }
        }
        else
        {
          Log.w("FeedbackPromptManager", "the tag is not AdUnlikeTag");
          localObject = null;
          continue;
        }
        locala = this.Dyv;
        try
        {
          locala.DxX = ((com.tencent.mm.plugin.sns.data.c)localObject);
          if (paramSnsInfo == null) {
            continue;
          }
          locala.DqO = paramSnsInfo;
          locala.DxY = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        }
        catch (Throwable paramSnsInfo)
        {
          Log.w("FeedbackDisplayDataSupplier", "there is something wrong in updateData");
          continue;
        }
        bool = this.Dyv.eXJ();
        if (bool) {
          break label184;
        }
        AppMethodBeat.o(202173);
        return false;
      }
      catch (Throwable paramView)
      {
        a locala;
        Log.e("FeedbackPromptManager", "show feedback window has something wrong!");
        AppMethodBeat.o(202173);
        return false;
      }
      if (localObject != null) {
        locala.DqO = aj.faO().aQm(((com.tencent.mm.plugin.sns.data.c)localObject).dHp);
      }
    }
    label184:
    if (this.Dys == null)
    {
      paramSnsInfo = LayoutInflater.from(this.mContext).inflate(this.xzP, null);
      this.Dys = new com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a(this.mContext);
      this.Dys.setContentView(paramSnsInfo);
      this.Dys.setWidth(this.qXG);
      this.Dys.setHeight(-2);
      this.Dys.setFocusable(true);
      this.Dys.setBackgroundDrawable(new ColorDrawable(0));
      this.Dys.setOnDismissListener(this);
    }
    boolean bool = this.Dys.isShowing();
    if (bool)
    {
      AppMethodBeat.o(202173);
      return true;
    }
    if (!(paramView instanceof ViewGroup))
    {
      paramSnsInfo = paramView.getParent();
      if (paramSnsInfo != null) {
        paramView = (View)paramSnsInfo;
      }
    }
    for (;;)
    {
      this.Dyt = paramView;
      this.Dyu.eY(this.Dys.getContentView());
      int j = m(this.Dyt, this.Dys.getContentView());
      XM(j);
      paramView = this.Dys;
      int i;
      label381:
      float f;
      if (j < 0)
      {
        i = 2131821340;
        paramView.setAnimationStyle(i);
        this.Dys.showAsDropDown(this.Dyt, 0, j, 8388613);
        paramSnsInfo = this.Dys;
        bool = ao.isDarkMode();
        if (!bool) {
          break label500;
        }
        f = 0.1F;
      }
      try
      {
        for (;;)
        {
          paramView = paramSnsInfo.getContentView().getRootView();
          paramSnsInfo = (WindowManager)paramSnsInfo.mContext.getSystemService("window");
          localObject = (WindowManager.LayoutParams)paramView.getLayoutParams();
          ((WindowManager.LayoutParams)localObject).flags |= 0x2;
          ((WindowManager.LayoutParams)localObject).dimAmount = f;
          paramSnsInfo.updateViewLayout(paramView, (ViewGroup.LayoutParams)localObject);
          AppMethodBeat.o(202173);
          return true;
          break;
          i = 2131821341;
          break label381;
          label500:
          f = 0.5F;
        }
      }
      catch (Throwable paramView)
      {
        for (;;)
        {
          Log.w("FeedbackPopupWindow", "the window dim account is set failed!");
        }
      }
    }
  }
  
  public final void onDismiss()
  {
    this.Dys = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.c
 * JD-Core Version:    0.7.0.1
 */