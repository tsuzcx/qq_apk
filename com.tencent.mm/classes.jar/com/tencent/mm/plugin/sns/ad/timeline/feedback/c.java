package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.ad.j.j;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.c;
import com.tencent.mm.plugin.sns.storage.ADInfo.c.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class c
  implements PopupWindow.OnDismissListener, b.c
{
  private int IxU;
  private com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a PZn;
  private View PZo;
  private b PZp;
  private a PZq;
  private com.tencent.mm.plugin.sns.ui.listener.c PZr;
  private Set<Integer> PZs;
  private boolean PZt;
  private Context mContext;
  private int xGY;
  
  private c(Context paramContext)
  {
    this(paramContext, b.g.sns_ad_feedback_layout);
  }
  
  private c(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(311037);
    this.PZt = false;
    this.xGY = 0;
    this.mContext = paramContext;
    this.IxU = paramInt;
    this.PZs = new HashSet();
    this.PZq = new a();
    this.PZp = new b(paramContext, this.PZq, this);
    this.xGY = this.mContext.getResources().getDimensionPixelOffset(b.d.sns_ad_feedback_panel_width);
    if ((paramContext instanceof SnsCommentDetailUI))
    {
      this.PZt = true;
      this.PZq.xOq = 1;
    }
    AppMethodBeat.o(311037);
  }
  
  /* Error */
  public static c a(Context paramContext, com.tencent.mm.plugin.sns.ui.listener.c paramc)
  {
    // Byte code:
    //   0: ldc 102
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +41 -> 47
    //   9: new 2	com/tencent/mm/plugin/sns/ad/timeline/feedback/c
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 104	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:<init>	(Landroid/content/Context;)V
    //   17: astore_0
    //   18: aload_0
    //   19: aload_1
    //   20: putfield 106	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZr	Lcom/tencent/mm/plugin/sns/ui/listener/c;
    //   23: ldc 102
    //   25: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: aconst_null
    //   32: astore_0
    //   33: ldc 108
    //   35: ldc 110
    //   37: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: goto -17 -> 23
    //   43: astore_1
    //   44: goto -11 -> 33
    //   47: aconst_null
    //   48: astore_0
    //   49: goto -26 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramContext	Context
    //   0	52	1	paramc	com.tencent.mm.plugin.sns.ui.listener.c
    // Exception table:
    //   from	to	target	type
    //   9	18	30	finally
    //   18	23	43	finally
  }
  
  private void ajz(int paramInt)
  {
    AppMethodBeat.i(311047);
    if (this.PZp != null) {
      this.PZp.ajz(paramInt);
    }
    AppMethodBeat.o(311047);
  }
  
  private void hbK()
  {
    AppMethodBeat.i(311087);
    if (this.PZn != null) {
      this.PZn.dismiss();
    }
    AppMethodBeat.o(311087);
  }
  
  private void hbL()
  {
    AppMethodBeat.i(311098);
    try
    {
      aa.db(this.mContext, this.mContext.getString(b.j.sns_ad_new_feedback_thanks));
      return;
    }
    finally
    {
      AppMethodBeat.o(311098);
    }
  }
  
  private static Rect ji(View paramView)
  {
    AppMethodBeat.i(311060);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    localRect.left = arrayOfInt[0];
    localRect.top = arrayOfInt[1];
    localRect.right = (localRect.left + paramView.getWidth());
    localRect.bottom = (localRect.top + paramView.getHeight());
    AppMethodBeat.o(311060);
    return localRect;
  }
  
  private int s(View paramView1, View paramView2)
  {
    AppMethodBeat.i(311073);
    paramView2.measure(View.MeasureSpec.makeMeasureSpec(this.xGY, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i = paramView2.getMeasuredHeight();
    paramView2 = ji(paramView1);
    Rect localRect = new Rect();
    paramView1.getWindowVisibleDisplayFrame(localRect);
    if (paramView2.bottom + i > localRect.height())
    {
      i = -(paramView2.height() + i);
      AppMethodBeat.o(311073);
      return i;
    }
    AppMethodBeat.o(311073);
    return 0;
  }
  
  public final void a(View paramView, int paramInt, Object paramObject)
  {
    int i = 1;
    Object localObject1 = null;
    AppMethodBeat.i(311161);
    if (paramInt == 5) {
      try
      {
        localObject1 = this.PZs;
        if ((localObject1 != null) && ((paramObject instanceof com.tencent.mm.plugin.sns.ad.timeline.feedback.a.c)))
        {
          i = ((com.tencent.mm.plugin.sns.ad.timeline.feedback.a.c)paramObject).PZC;
          if ((paramView != null) && (paramView.isSelected()))
          {
            ((Set)localObject1).add(Integer.valueOf(i));
            AppMethodBeat.o(311161);
            return;
          }
          ((Set)localObject1).remove(Integer.valueOf(i));
        }
        AppMethodBeat.o(311161);
        return;
      }
      finally
      {
        Log.e("FeedbackPromptManager", "onAction failed : actionId = ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(311161);
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
      AppMethodBeat.o(311161);
      return;
      hbL();
      hbK();
      boolean bool;
      Object localObject2;
      Object localObject3;
      if (this.PZq != null)
      {
        paramView = this.PZq;
        bool = this.PZt;
        paramObject = paramView.PJQ;
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
        AppMethodBeat.o(311161);
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
              paramView.PZu = paramObject.field_snsId;
              if (bool) {
                i = 2;
              }
              paramView.mScene = i;
              paramView.PZv = k.aXd(((ADInfo)localObject3).uxInfo);
              paramView.PZw = ((ADXml)localObject2).adExtInfo;
            }
          }
        }
      }
      hbK();
      Object localObject4;
      String str1;
      String str2;
      try
      {
        paramObject = this.mContext;
        if (paramObject == null) {
          break label471;
        }
        paramView = this.PZq.hbG();
        if (!com.tencent.mm.plugin.sns.ad.j.h.getBooleanExtra(paramView, "complaint_weapp", false)) {
          break label461;
        }
        paramObject = com.tencent.mm.plugin.sns.ad.j.h.getStringExtra(paramView, "appUserName");
        localObject1 = com.tencent.mm.plugin.sns.ad.j.h.getStringExtra(paramView, "appPagePath");
        localObject2 = com.tencent.mm.plugin.sns.ad.j.h.getStringExtra(paramView, "appVersion");
        localObject3 = com.tencent.mm.plugin.sns.ad.j.h.getStringExtra(paramView, "aId");
        localObject4 = com.tencent.mm.plugin.sns.ad.j.h.getStringExtra(paramView, "traceId");
        str1 = com.tencent.mm.plugin.sns.ad.j.h.getStringExtra(paramView, "sceneNote");
        str2 = com.tencent.mm.plugin.sns.ad.j.h.getStringExtra(paramView, "uxInfo");
        i = com.tencent.mm.plugin.sns.ad.j.h.getIntExtra(paramView, "scene", 1045);
        if (TextUtils.isEmpty(paramObject)) {
          Log.w("FeedbackPromptManager", "the app user name is empty");
        }
      }
      finally
      {
        AppMethodBeat.o(311161);
        return;
      }
      t.a(paramObject, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, str1, str2, i);
      AppMethodBeat.o(311161);
      return;
      com.tencent.mm.plugin.sns.d.a.pFn.h(paramView, paramObject);
      label471:
      AppMethodBeat.o(311161);
      return;
      if (this.PZs != null) {
        this.PZs.clear();
      }
      if ((this.PZq != null) && (this.PZq.hbE()) && (this.PZn != null))
      {
        i = s(this.PZo, this.PZn.getContentView());
        ajz(i);
        this.PZn.update(this.PZo, 0, i, -1, -1);
        paramView = this.PZq.ajy(0);
        if (paramView != null)
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(paramView, 0);
        }
        AppMethodBeat.o(311161);
        return;
      }
      hbL();
      hbK();
      if (this.PZr != null) {
        this.PZr.jE(paramView);
      }
      if (this.PZq != null)
      {
        paramView = this.PZq.ajy(1);
        if (paramView != null)
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(paramView, 0);
        }
      }
      AppMethodBeat.o(311161);
      return;
      if (d.isEmpty(this.PZs))
      {
        Log.e("FeedbackPromptManager", "onConfirm but mComplaintReasonIds is null or empty");
        AppMethodBeat.o(311161);
        return;
      }
      hbL();
      hbK();
      if (this.PZr != null) {
        this.PZr.jE(paramView);
      }
      if (this.PZq != null)
      {
        localObject1 = this.PZq;
        paramObject = this.PZs;
        localObject3 = ((a)localObject1).getAdInfo();
        paramView = ((a)localObject1).PJQ;
        localObject1 = ((a)localObject1).PYR;
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
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(paramView, 0);
          break;
          localObject2 = new LinkedList();
          localObject3 = ((ADInfo)localObject3).adUnlikeInfo.hiy();
          if (d.B((Collection)localObject3))
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (ADInfo.c.a)((Iterator)localObject3).next();
              if ((localObject4 != null) && (paramObject.contains(Integer.valueOf(((ADInfo.c.a)localObject4).QHk)))) {
                ((List)localObject2).add(Integer.valueOf(((ADInfo.c.a)localObject4).QHk));
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
            paramObject.QHl = ((List)localObject2).size();
            paramObject.QHm.addAll((Collection)localObject2);
            paramObject.QmE = ((e)localObject1).QmE;
            paramObject.QHn = System.currentTimeMillis();
            paramView = new com.tencent.mm.plugin.sns.model.s(paramView.field_snsId, 8, paramObject);
            continue;
            paramView = null;
          }
        }
      }
    }
  }
  
  /* Error */
  public final boolean a(View paramView, SnsInfo paramSnsInfo)
  {
    // Byte code:
    //   0: ldc_w 497
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 497
    //   13: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_1
    //   19: invokevirtual 500	android/view/View:getTag	()Ljava/lang/Object;
    //   22: astore 7
    //   24: aload 7
    //   26: instanceof 477
    //   29: ifeq +31 -> 60
    //   32: aload 7
    //   34: checkcast 477	com/tencent/mm/plugin/sns/data/e
    //   37: astore 7
    //   39: aload 7
    //   41: ifnonnull +33 -> 74
    //   44: ldc 108
    //   46: ldc_w 502
    //   49: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: ldc_w 497
    //   55: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: iconst_0
    //   59: ireturn
    //   60: ldc 108
    //   62: ldc_w 504
    //   65: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aconst_null
    //   69: astore 7
    //   71: goto -32 -> 39
    //   74: aload_0
    //   75: getfield 67	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZq	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/a;
    //   78: astore 8
    //   80: aload 8
    //   82: aload 7
    //   84: putfield 421	com/tencent/mm/plugin/sns/ad/timeline/feedback/a:PYR	Lcom/tencent/mm/plugin/sns/data/e;
    //   87: aload_2
    //   88: ifnull +42 -> 130
    //   91: aload 8
    //   93: aload_2
    //   94: putfield 250	com/tencent/mm/plugin/sns/ad/timeline/feedback/a:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   97: aload 8
    //   99: invokestatic 510	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   102: invokestatic 516	com/tencent/mm/sdk/platformtools/LocaleUtil:getCurrentLanguage	(Landroid/content/Context;)Ljava/lang/String;
    //   105: putfield 519	com/tencent/mm/plugin/sns/ad/timeline/feedback/a:PYS	Ljava/lang/String;
    //   108: aload_0
    //   109: getfield 67	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZq	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/a;
    //   112: invokevirtual 522	com/tencent/mm/plugin/sns/ad/timeline/feedback/a:hbD	()Z
    //   115: istore 6
    //   117: iload 6
    //   119: ifne +65 -> 184
    //   122: ldc_w 497
    //   125: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: iconst_0
    //   129: ireturn
    //   130: aload 7
    //   132: ifnull -35 -> 97
    //   135: aload 8
    //   137: invokestatic 528	com/tencent/mm/plugin/sns/model/al:hgB	()Lcom/tencent/mm/plugin/sns/storage/w;
    //   140: aload 7
    //   142: getfield 531	com/tencent/mm/plugin/sns/data/e:hES	Ljava/lang/String;
    //   145: invokevirtual 537	com/tencent/mm/plugin/sns/storage/w:aZL	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   148: putfield 250	com/tencent/mm/plugin/sns/ad/timeline/feedback/a:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   151: goto -54 -> 97
    //   154: astore_2
    //   155: ldc_w 539
    //   158: ldc_w 541
    //   161: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: goto -56 -> 108
    //   167: astore_1
    //   168: ldc 108
    //   170: ldc_w 543
    //   173: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: ldc_w 497
    //   179: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: iconst_0
    //   183: ireturn
    //   184: aload_0
    //   185: getfield 124	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZn	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a;
    //   188: ifnonnull +93 -> 281
    //   191: aload_0
    //   192: getfield 55	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:mContext	Landroid/content/Context;
    //   195: invokestatic 549	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   198: aload_0
    //   199: getfield 57	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:IxU	I
    //   202: aconst_null
    //   203: invokevirtual 553	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   206: astore_2
    //   207: aload_0
    //   208: new 126	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a
    //   211: dup
    //   212: aload_0
    //   213: getfield 55	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:mContext	Landroid/content/Context;
    //   216: invokespecial 554	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a:<init>	(Landroid/content/Context;)V
    //   219: putfield 124	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZn	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a;
    //   222: aload_0
    //   223: getfield 124	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZn	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a;
    //   226: aload_2
    //   227: invokevirtual 557	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a:setContentView	(Landroid/view/View;)V
    //   230: aload_0
    //   231: getfield 124	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZn	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a;
    //   234: aload_0
    //   235: getfield 53	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:xGY	I
    //   238: invokevirtual 560	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a:setWidth	(I)V
    //   241: aload_0
    //   242: getfield 124	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZn	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a;
    //   245: bipush 254
    //   247: invokevirtual 563	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a:setHeight	(I)V
    //   250: aload_0
    //   251: getfield 124	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZn	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a;
    //   254: iconst_1
    //   255: invokevirtual 567	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a:setFocusable	(Z)V
    //   258: aload_0
    //   259: getfield 124	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZn	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a;
    //   262: new 569	android/graphics/drawable/ColorDrawable
    //   265: dup
    //   266: iconst_0
    //   267: invokespecial 571	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   270: invokevirtual 575	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   273: aload_0
    //   274: getfield 124	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZn	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a;
    //   277: aload_0
    //   278: invokevirtual 579	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a:setOnDismissListener	(Landroid/widget/PopupWindow$OnDismissListener;)V
    //   281: aload_0
    //   282: getfield 124	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZn	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a;
    //   285: invokevirtual 582	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a:isShowing	()Z
    //   288: istore 6
    //   290: iload 6
    //   292: ifeq +11 -> 303
    //   295: ldc_w 497
    //   298: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: iconst_1
    //   302: ireturn
    //   303: aload_1
    //   304: instanceof 584
    //   307: ifne +182 -> 489
    //   310: aload_1
    //   311: invokevirtual 588	android/view/View:getParent	()Landroid/view/ViewParent;
    //   314: astore_2
    //   315: aload_2
    //   316: ifnull +173 -> 489
    //   319: aload_2
    //   320: checkcast 151	android/view/View
    //   323: astore_1
    //   324: aload_0
    //   325: aload_1
    //   326: putfield 368	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZo	Landroid/view/View;
    //   329: aload_0
    //   330: getfield 74	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZp	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/b;
    //   333: aload_0
    //   334: getfield 124	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZn	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a;
    //   337: invokevirtual 372	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a:getContentView	()Landroid/view/View;
    //   340: invokevirtual 591	com/tencent/mm/plugin/sns/ad/timeline/feedback/b:jh	(Landroid/view/View;)V
    //   343: aload_0
    //   344: aload_0
    //   345: getfield 368	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZo	Landroid/view/View;
    //   348: aload_0
    //   349: getfield 124	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZn	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a;
    //   352: invokevirtual 372	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a:getContentView	()Landroid/view/View;
    //   355: invokespecial 374	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:s	(Landroid/view/View;Landroid/view/View;)I
    //   358: istore 5
    //   360: aload_0
    //   361: iload 5
    //   363: invokespecial 375	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:ajz	(I)V
    //   366: aload_0
    //   367: getfield 124	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZn	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a;
    //   370: astore_1
    //   371: iload 5
    //   373: ifge +119 -> 492
    //   376: getstatic 596	com/tencent/mm/plugin/sns/b$k:SnsAdFeedbackPanelAboveAnchorAnimation	I
    //   379: istore 4
    //   381: aload_1
    //   382: iload 4
    //   384: invokevirtual 599	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a:setAnimationStyle	(I)V
    //   387: aload_0
    //   388: getfield 124	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZn	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a;
    //   391: aload_0
    //   392: getfield 368	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZo	Landroid/view/View;
    //   395: iconst_0
    //   396: iload 5
    //   398: ldc_w 600
    //   401: invokevirtual 604	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a:showAsDropDown	(Landroid/view/View;III)V
    //   404: aload_0
    //   405: getfield 124	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:PZn	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a;
    //   408: astore_2
    //   409: invokestatic 609	com/tencent/mm/ui/aw:isDarkMode	()Z
    //   412: istore 6
    //   414: iload 6
    //   416: ifeq +97 -> 513
    //   419: ldc_w 610
    //   422: fstore_3
    //   423: aload_2
    //   424: invokevirtual 372	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a:getContentView	()Landroid/view/View;
    //   427: invokevirtual 613	android/view/View:getRootView	()Landroid/view/View;
    //   430: astore_1
    //   431: aload_2
    //   432: getfield 614	com/tencent/mm/plugin/sns/ad/timeline/feedback/ui/a:mContext	Landroid/content/Context;
    //   435: ldc_w 616
    //   438: invokevirtual 620	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   441: checkcast 622	android/view/WindowManager
    //   444: astore_2
    //   445: aload_1
    //   446: invokevirtual 626	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   449: checkcast 628	android/view/WindowManager$LayoutParams
    //   452: astore 7
    //   454: aload 7
    //   456: aload 7
    //   458: getfield 631	android/view/WindowManager$LayoutParams:flags	I
    //   461: iconst_2
    //   462: ior
    //   463: putfield 631	android/view/WindowManager$LayoutParams:flags	I
    //   466: aload 7
    //   468: fload_3
    //   469: putfield 635	android/view/WindowManager$LayoutParams:dimAmount	F
    //   472: aload_2
    //   473: aload_1
    //   474: aload 7
    //   476: invokeinterface 639 3 0
    //   481: ldc_w 497
    //   484: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   487: iconst_1
    //   488: ireturn
    //   489: goto -165 -> 324
    //   492: getstatic 642	com/tencent/mm/plugin/sns/b$k:SnsAdFeedbackPanelBelowAnchorAnimation	I
    //   495: istore 4
    //   497: goto -116 -> 381
    //   500: astore_1
    //   501: ldc_w 644
    //   504: ldc_w 646
    //   507: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: goto -29 -> 481
    //   513: ldc_w 647
    //   516: fstore_3
    //   517: goto -94 -> 423
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	520	0	this	c
    //   0	520	1	paramView	View
    //   0	520	2	paramSnsInfo	SnsInfo
    //   422	95	3	f	float
    //   379	117	4	i	int
    //   358	39	5	j	int
    //   115	300	6	bool	boolean
    //   22	453	7	localObject	Object
    //   78	58	8	locala	a
    // Exception table:
    //   from	to	target	type
    //   80	87	154	finally
    //   91	97	154	finally
    //   97	108	154	finally
    //   135	151	154	finally
    //   18	39	167	finally
    //   44	52	167	finally
    //   60	68	167	finally
    //   74	80	167	finally
    //   108	117	167	finally
    //   155	164	167	finally
    //   184	281	167	finally
    //   281	290	167	finally
    //   303	315	167	finally
    //   319	324	167	finally
    //   324	371	167	finally
    //   376	381	167	finally
    //   381	414	167	finally
    //   492	497	167	finally
    //   501	510	167	finally
    //   423	481	500	finally
  }
  
  public final void onDismiss()
  {
    this.PZn = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.c
 * JD-Core Version:    0.7.0.1
 */