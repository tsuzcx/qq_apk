package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.k;
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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.w;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class c
  implements PopupWindow.OnDismissListener, b.c
{
  private int CDQ;
  private com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a JIl;
  private View JIm;
  private b JIn;
  private a JIo;
  private com.tencent.mm.plugin.sns.ui.d.c JIp;
  private Set<Integer> JIq;
  private boolean JIr;
  private Context mContext;
  private int uAv;
  
  private c(Context paramContext)
  {
    this(paramContext, i.g.sns_ad_feedback_layout);
  }
  
  private c(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(233784);
    this.JIr = false;
    this.uAv = 0;
    this.mContext = paramContext;
    this.CDQ = paramInt;
    this.JIq = new HashSet();
    this.JIo = new a();
    this.JIn = new b(paramContext, this.JIo, this);
    this.uAv = this.mContext.getResources().getDimensionPixelOffset(i.d.sns_ad_feedback_panel_width);
    if ((paramContext instanceof SnsCommentDetailUI))
    {
      this.JIr = true;
      this.JIo.JCO = 1;
    }
    AppMethodBeat.o(233784);
  }
  
  public static c a(Context paramContext, com.tencent.mm.plugin.sns.ui.d.c paramc)
  {
    AppMethodBeat.i(233783);
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
          paramContext.JIp = paramc;
          AppMethodBeat.o(233783);
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
  
  private void aeR(int paramInt)
  {
    AppMethodBeat.i(233788);
    if (this.JIn != null) {
      this.JIn.aeR(paramInt);
    }
    AppMethodBeat.o(233788);
  }
  
  private void fLs()
  {
    AppMethodBeat.i(233796);
    if (this.JIl != null) {
      this.JIl.dismiss();
    }
    AppMethodBeat.o(233796);
  }
  
  private void fLt()
  {
    AppMethodBeat.i(233798);
    try
    {
      w.cR(this.mContext, this.mContext.getString(i.j.sns_ad_new_feedback_thanks));
      AppMethodBeat.o(233798);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(233798);
    }
  }
  
  private static Rect gf(View paramView)
  {
    AppMethodBeat.i(233790);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    localRect.left = arrayOfInt[0];
    localRect.top = arrayOfInt[1];
    localRect.right = (localRect.left + paramView.getWidth());
    localRect.bottom = (localRect.top + paramView.getHeight());
    AppMethodBeat.o(233790);
    return localRect;
  }
  
  private int m(View paramView1, View paramView2)
  {
    AppMethodBeat.i(233792);
    paramView2.measure(View.MeasureSpec.makeMeasureSpec(this.uAv, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i = paramView2.getMeasuredHeight();
    paramView2 = gf(paramView1);
    Rect localRect = new Rect();
    paramView1.getWindowVisibleDisplayFrame(localRect);
    if (paramView2.bottom + i > localRect.height())
    {
      i = -(paramView2.height() + i);
      AppMethodBeat.o(233792);
      return i;
    }
    AppMethodBeat.o(233792);
    return 0;
  }
  
  public final void a(View paramView, int paramInt, Object paramObject)
  {
    int i = 1;
    Object localObject1 = null;
    AppMethodBeat.i(233795);
    if (paramInt == 5) {
      try
      {
        localObject1 = this.JIq;
        if ((localObject1 != null) && ((paramObject instanceof com.tencent.mm.plugin.sns.ad.timeline.feedback.a.c)))
        {
          i = ((com.tencent.mm.plugin.sns.ad.timeline.feedback.a.c)paramObject).JIA;
          if ((paramView != null) && (paramView.isSelected()))
          {
            ((Set)localObject1).add(Integer.valueOf(i));
            AppMethodBeat.o(233795);
            return;
          }
          ((Set)localObject1).remove(Integer.valueOf(i));
        }
        AppMethodBeat.o(233795);
        return;
      }
      catch (Throwable paramView)
      {
        Log.e("FeedbackPromptManager", "onAction failed : actionId = ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(233795);
        return;
      }
    }
    switch (paramInt)
    {
    }
    label461:
    label974:
    for (;;)
    {
      AppMethodBeat.o(233795);
      return;
      fLt();
      fLs();
      boolean bool;
      Object localObject2;
      Object localObject3;
      if (this.JIo != null)
      {
        paramView = this.JIo;
        bool = this.JIr;
        paramObject = paramView.Jws;
        localObject2 = paramView.getAdXml();
        localObject3 = paramView.getAdInfo();
        paramView = (View)localObject1;
        if (paramObject != null)
        {
          paramView = (View)localObject1;
          if (localObject2 != null)
          {
            if (localObject3 != null) {
              break label226;
            }
            paramView = (View)localObject1;
          }
        }
      }
      for (;;)
      {
        j.a(paramView);
        AppMethodBeat.o(233795);
        return;
        label226:
        paramView = (View)localObject1;
        if (paramObject != null)
        {
          paramView = (View)localObject1;
          if (localObject3 != null)
          {
            paramView = (View)localObject1;
            if (localObject2 != null)
            {
              paramView = new com.tencent.mm.plugin.sns.ad.timeline.feedback.a.a();
              paramView.JIs = paramObject.field_snsId;
              if (bool) {
                i = 2;
              }
              paramView.mScene = i;
              paramView.JIt = k.aYR(((ADInfo)localObject3).uxInfo);
              paramView.JIu = ((ADXml)localObject2).adExtInfo;
            }
          }
        }
      }
      fLs();
      Object localObject4;
      String str1;
      String str2;
      try
      {
        paramObject = this.mContext;
        if (paramObject == null) {
          break label471;
        }
        paramView = this.JIo.fLo();
        if (!com.tencent.mm.plugin.sns.ad.i.h.getBooleanExtra(paramView, "complaint_weapp", false)) {
          break label461;
        }
        paramObject = com.tencent.mm.plugin.sns.ad.i.h.getStringExtra(paramView, "appUserName");
        localObject1 = com.tencent.mm.plugin.sns.ad.i.h.getStringExtra(paramView, "appPagePath");
        localObject2 = com.tencent.mm.plugin.sns.ad.i.h.getStringExtra(paramView, "appVersion");
        localObject3 = com.tencent.mm.plugin.sns.ad.i.h.getStringExtra(paramView, "aId");
        localObject4 = com.tencent.mm.plugin.sns.ad.i.h.getStringExtra(paramView, "traceId");
        str1 = com.tencent.mm.plugin.sns.ad.i.h.getStringExtra(paramView, "sceneNote");
        str2 = com.tencent.mm.plugin.sns.ad.i.h.getStringExtra(paramView, "uxInfo");
        i = com.tencent.mm.plugin.sns.ad.i.h.getIntExtra(paramView, "scene", 1045);
        if (TextUtils.isEmpty(paramObject))
        {
          Log.w("FeedbackPromptManager", "the app user name is empty");
          AppMethodBeat.o(233795);
          return;
        }
      }
      catch (Throwable paramView)
      {
        AppMethodBeat.o(233795);
        return;
      }
      com.tencent.mm.plugin.sns.data.t.a(paramObject, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, str1, str2, i);
      AppMethodBeat.o(233795);
      return;
      com.tencent.mm.plugin.sns.c.a.mIG.h(paramView, paramObject);
      label471:
      AppMethodBeat.o(233795);
      return;
      if (this.JIq != null) {
        this.JIq.clear();
      }
      if ((this.JIo != null) && (this.JIo.fLm()) && (this.JIl != null))
      {
        i = m(this.JIm, this.JIl.getContentView());
        aeR(i);
        this.JIl.update(this.JIm, 0, i, -1, -1);
        paramView = this.JIo.aeQ(0);
        if (paramView != null)
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(paramView, 0);
        }
        AppMethodBeat.o(233795);
        return;
      }
      fLt();
      fLs();
      if (this.JIp != null) {
        this.JIp.gA(paramView);
      }
      if (this.JIo != null)
      {
        paramView = this.JIo.aeQ(1);
        if (paramView != null)
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(paramView, 0);
        }
      }
      AppMethodBeat.o(233795);
      return;
      if (d.isEmpty(this.JIq))
      {
        Log.e("FeedbackPromptManager", "onConfirm but mComplaintReasonIds is null or empty");
        AppMethodBeat.o(233795);
        return;
      }
      fLt();
      fLs();
      if (this.JIp != null) {
        this.JIp.gA(paramView);
      }
      if (this.JIo != null)
      {
        localObject1 = this.JIo;
        paramObject = this.JIq;
        localObject3 = ((a)localObject1).getAdInfo();
        paramView = ((a)localObject1).Jws;
        localObject1 = ((a)localObject1).JHR;
        if ((!d.isEmpty(paramObject)) && (localObject1 != null) && (paramView != null) && (localObject3 != null)) {
          if (((ADInfo)localObject3).adUnlikeInfo == null) {
            break label971;
          }
        }
        for (;;)
        {
          if (paramView == null) {
            break label974;
          }
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(paramView, 0);
          break;
          localObject2 = new LinkedList();
          localObject3 = ((ADInfo)localObject3).adUnlikeInfo.fQA();
          if (d.n((Collection)localObject3))
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (ADInfo.c.a)((Iterator)localObject3).next();
              if ((localObject4 != null) && (paramObject.contains(Integer.valueOf(((ADInfo.c.a)localObject4).Kjn)))) {
                ((List)localObject2).add(Integer.valueOf(((ADInfo.c.a)localObject4).Kjn));
              }
            }
          }
          if (d.isEmpty((Collection)localObject2))
          {
            paramView = null;
          }
          else
          {
            paramObject = new ADInfo.c.a();
            paramObject.Kjo = ((List)localObject2).size();
            paramObject.Kjp.addAll((Collection)localObject2);
            paramObject.JPX = ((e)localObject1).JPX;
            paramObject.Kjq = System.currentTimeMillis();
            paramView = new s(paramView.field_snsId, 8, paramObject);
            continue;
            paramView = null;
          }
        }
      }
    }
  }
  
  public final boolean a(View paramView, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(233786);
    if (paramView == null)
    {
      AppMethodBeat.o(233786);
      return false;
    }
    Object localObject;
    for (;;)
    {
      try
      {
        localObject = paramView.getTag();
        if ((localObject instanceof e))
        {
          localObject = (e)localObject;
          if (localObject == null)
          {
            Log.e("FeedbackPromptManager", "the unlike tag is null. there is no data for showing window!");
            AppMethodBeat.o(233786);
            return false;
          }
        }
        else
        {
          Log.w("FeedbackPromptManager", "the tag is not AdUnlikeTag");
          localObject = null;
          continue;
        }
        locala = this.JIo;
        try
        {
          locala.JHR = ((e)localObject);
          if (paramSnsInfo == null) {
            continue;
          }
          locala.Jws = paramSnsInfo;
          locala.JHS = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        }
        catch (Throwable paramSnsInfo)
        {
          Log.w("FeedbackDataSupplier", "there is something wrong in updateData");
          continue;
        }
        bool = this.JIo.fLl();
        if (bool) {
          break label184;
        }
        AppMethodBeat.o(233786);
        return false;
      }
      catch (Throwable paramView)
      {
        a locala;
        Log.e("FeedbackPromptManager", "show feedback window has something wrong!");
        AppMethodBeat.o(233786);
        return false;
      }
      if (localObject != null) {
        locala.Jws = aj.fOI().bbl(((e)localObject).fAg);
      }
    }
    label184:
    if (this.JIl == null)
    {
      paramSnsInfo = LayoutInflater.from(this.mContext).inflate(this.CDQ, null);
      this.JIl = new com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a(this.mContext);
      this.JIl.setContentView(paramSnsInfo);
      this.JIl.setWidth(this.uAv);
      this.JIl.setHeight(-2);
      this.JIl.setFocusable(true);
      this.JIl.setBackgroundDrawable(new ColorDrawable(0));
      this.JIl.setOnDismissListener(this);
    }
    boolean bool = this.JIl.isShowing();
    if (bool)
    {
      AppMethodBeat.o(233786);
      return true;
    }
    int i;
    if (!(paramView instanceof ViewGroup))
    {
      paramSnsInfo = paramView.getParent();
      if (paramSnsInfo != null)
      {
        paramView = (View)paramSnsInfo;
        this.JIm = paramView;
        this.JIn.ge(this.JIl.getContentView());
        int j = m(this.JIm, this.JIl.getContentView());
        aeR(j);
        paramView = this.JIl;
        if (j >= 0) {
          break label492;
        }
        i = i.k.SnsAdFeedbackPanelAboveAnchorAnimation;
        paramView.setAnimationStyle(i);
        this.JIl.showAsDropDown(this.JIm, 0, j, 8388613);
        paramSnsInfo = this.JIl;
        bool = ar.isDarkMode();
        if (!bool) {
          break label513;
        }
      }
    }
    label513:
    for (float f = 0.1F;; f = 0.5F) {
      try
      {
        paramView = paramSnsInfo.getContentView().getRootView();
        paramSnsInfo = (WindowManager)paramSnsInfo.mContext.getSystemService("window");
        localObject = (WindowManager.LayoutParams)paramView.getLayoutParams();
        ((WindowManager.LayoutParams)localObject).flags |= 0x2;
        ((WindowManager.LayoutParams)localObject).dimAmount = f;
        paramSnsInfo.updateViewLayout(paramView, (ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(233786);
        return true;
        break;
        label492:
        i = i.k.SnsAdFeedbackPanelBelowAnchorAnimation;
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
    this.JIl = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.c
 * JD-Core Version:    0.7.0.1
 */