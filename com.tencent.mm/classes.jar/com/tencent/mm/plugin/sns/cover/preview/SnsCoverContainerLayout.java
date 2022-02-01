package com.tencent.mm.plugin.sns.cover.preview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.nq;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.cover.a.c;
import com.tencent.mm.plugin.sns.cover.a.d;
import com.tencent.mm.plugin.sns.cover.a.e;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.base.MMOverScrollView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/preview/SnsCoverContainerLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/sns/cover/api/SnsCoverStatusProvider;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/sns/storage/SnsCover;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backPreview", "Lcom/tencent/mm/plugin/sns/cover/api/AbsSnsBackPreview;", "backViewHeight", "", "bottomMaskView", "Landroid/view/View;", "coverClickListener", "Lkotlin/Function0;", "", "getCoverClickListener", "()Lkotlin/jvm/functions/Function0;", "setCoverClickListener", "(Lkotlin/jvm/functions/Function0;)V", "coverReporter", "Lcom/tencent/mm/plugin/sns/cover/report/SnsCoverPageReporter;", "getCoverReporter", "()Lcom/tencent/mm/plugin/sns/cover/report/SnsCoverPageReporter;", "expandScrollHeight", "expandTranslation", "", "externalMargin", "getExternalMargin", "()I", "setExternalMargin", "(I)V", "foldTranslation", "maskViewHeight", "onViewSizeChanged", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "previewHeight", "getOnViewSizeChanged", "()Lkotlin/jvm/functions/Function2;", "setOnViewSizeChanged", "(Lkotlin/jvm/functions/Function2;)V", "rootView", "Landroid/view/ViewGroup;", "snsCover", "snsCoverStatus", "Lcom/tencent/mm/plugin/sns/cover/api/SnsCoverStatus;", "topMaskView", "getBackWidthAndHeight", "", "getPreviewType", "getSnsCoverReporter", "Lcom/tencent/mm/plugin/sns/cover/api/ISnsCoverReporter;", "getStatus", "onAttachedToWindow", "onBackPressed", "", "onChanged", "t", "onDestroy", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onPause", "onPostClose", "onPostOpen", "onPreClose", "onPreOpen", "onResume", "opening", "percent", "replaceBackView", "cover", "setCoverReportData", "isSelf", "userName", "", "setPreview", "isPreview", "showTopMask", "show", "updateBackView", "info", "updateViewSize", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsCoverContainerLayout
  extends FrameLayout
  implements y<q>, e
{
  public static final SnsCoverContainerLayout.a QlD;
  public com.tencent.mm.plugin.sns.cover.a.a QlE;
  private final View QlF;
  public final View QlG;
  public d QlH;
  private float QlI;
  private float QlJ;
  private int QlK;
  private int QlL;
  private int QlM;
  private kotlin.g.a.a<ah> QlN;
  public q QlO;
  private int QlP;
  public final com.tencent.mm.plugin.sns.cover.c.a QlQ;
  private m<? super Integer, ? super Integer, ah> mWA;
  private ViewGroup pzj;
  
  static
  {
    AppMethodBeat.i(307442);
    QlD = new SnsCoverContainerLayout.a((byte)0);
    AppMethodBeat.o(307442);
  }
  
  public SnsCoverContainerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(307427);
    this.QlH = new d();
    paramAttributeSet = new int[2];
    paramAttributeSet[0] = ao.mX(paramContext).width;
    paramAttributeSet[1] = 0;
    paramAttributeSet[1] = ((int)(paramAttributeSet[0] * 1.777778F));
    this.QlK = paramAttributeSet[1];
    this.QlL = this.QlK;
    this.QlQ = new com.tencent.mm.plugin.sns.cover.c.a();
    this.QlG = new View(paramContext);
    this.QlF = new View(paramContext);
    this.QlG.setBackgroundResource(b.c.BW_20);
    this.QlF.setBackgroundResource(b.c.sns_bg_color);
    paramContext = new FrameLayout.LayoutParams(-1, this.QlL);
    addView(this.QlF, (ViewGroup.LayoutParams)paramContext);
    addView(this.QlG, (ViewGroup.LayoutParams)paramContext);
    al.hgG().QYK.QZH.a((y)this);
    AppMethodBeat.o(307427);
  }
  
  private static final void a(SnsCoverContainerLayout paramSnsCoverContainerLayout, View paramView)
  {
    AppMethodBeat.i(307435);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSnsCoverContainerLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/cover/preview/SnsCoverContainerLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSnsCoverContainerLayout, "this$0");
    paramSnsCoverContainerLayout = paramSnsCoverContainerLayout.getCoverClickListener();
    if (paramSnsCoverContainerLayout != null) {
      paramSnsCoverContainerLayout.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/cover/preview/SnsCoverContainerLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(307435);
  }
  
  public final void a(q paramq)
  {
    int j = 1;
    AppMethodBeat.i(307520);
    Object localObject1 = new StringBuilder("updateBackView info:").append(paramq).append("  useNewVersion:");
    Object localObject2 = com.tencent.mm.plugin.sns.cover.b.a.QkS;
    Log.i("MicroMsg.SnsCoverContainerLayout", com.tencent.mm.plugin.sns.cover.b.a.hes());
    this.QlO = paramq;
    boolean bool;
    if (paramq == null)
    {
      i = 0;
      localObject1 = getChildAt(0);
      if ((!(localObject1 instanceof com.tencent.mm.plugin.sns.cover.a.a)) || (((com.tencent.mm.plugin.sns.cover.a.a)localObject1).getType() != i)) {
        break label411;
      }
      localObject1 = (com.tencent.mm.plugin.sns.cover.a.a)localObject1;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.sns.cover.a.a)localObject1).a((com.tencent.mm.plugin.sns.cover.a.b)paramq);
      }
      if (paramq != null)
      {
        localObject1 = getCoverReporter();
        if (this.QlH.isPreview) {
          break label688;
        }
        bool = true;
        label135:
        s.u(paramq, "coverInfo");
        if (((com.tencent.mm.plugin.sns.cover.c.a)localObject1).Qml != null) {
          ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).DB(bool);
        }
        ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).Qmm = paramq.field_isLike;
        ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).Qml = new nq();
        localObject2 = ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).Qml;
        if (localObject2 != null) {
          ((nq)localObject2).jfw = 2;
        }
        localObject2 = ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).Qml;
        if (localObject2 != null) {
          ((nq)localObject2).vK(paramq.field_userName);
        }
        localObject2 = ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).Qml;
        if (localObject2 != null) {
          if (!s.p(paramq.field_userName, h.baE().ban().d(2, null))) {
            break label694;
          }
        }
      }
    }
    label411:
    label675:
    label688:
    label694:
    for (int i = j;; i = 0)
    {
      ((nq)localObject2).jfx = i;
      localObject2 = ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).Qml;
      if (localObject2 != null) {
        ((nq)localObject2).jfy = paramq.field_type;
      }
      localObject2 = ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).Qml;
      if (localObject2 != null)
      {
        Long localLong = Long.valueOf(paramq.field_snsBgId);
        s.s(localLong, "coverInfo.snsObjId");
        ((nq)localObject2).jfz = ((Number)localLong).longValue();
      }
      localObject1 = ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).Qml;
      if (localObject1 != null) {
        ((nq)localObject1).iow = System.currentTimeMillis();
      }
      localObject1 = getCoverReporter();
      paramq = paramq.toString();
      s.s(paramq, "it.toString()");
      s.u(paramq, "info");
      localObject1 = ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).Qml;
      if (localObject1 != null) {
        ((nq)localObject1).vL(n.bV(paramq, ",", ";"));
      }
      AppMethodBeat.o(307520);
      return;
      i = paramq.field_type;
      break;
      if ((localObject1 instanceof com.tencent.mm.plugin.sns.cover.a.a))
      {
        ((com.tencent.mm.plugin.sns.cover.a.a)localObject1).onPause();
        ((com.tencent.mm.plugin.sns.cover.a.a)localObject1).onDestroy();
        removeViewAt(0);
      }
      localObject1 = this.QlE;
      float f;
      if (localObject1 == null)
      {
        f = 0.0F;
        label453:
        localObject1 = a.QlC;
        localObject1 = getContext();
        s.s(localObject1, "context");
        this.QlE = a.aW((Context)localObject1, i);
        localObject1 = this.QlE;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.sns.cover.a.a)localObject1).setCoverFoldStatusProvider((e)this);
        }
        j.QFS.QGN.jfr = i;
        j.QFS.akY(1);
        localObject1 = this.QlE;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.sns.cover.a.a)localObject1).setTranslationY(f);
        }
        localObject1 = new FrameLayout.LayoutParams(-1, this.QlK);
        localObject2 = this.QlE;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.sns.cover.a.a)localObject2).setOnClickListener(new SnsCoverContainerLayout..ExternalSyntheticLambda0(this));
        }
        addView((View)this.QlE, 0, (ViewGroup.LayoutParams)localObject1);
        localObject1 = this.QlE;
        if (localObject1 != null) {
          break label662;
        }
        localObject1 = null;
        label604:
        if (localObject1 != null) {
          ((View)localObject1).setBackgroundResource(b.e.sns_cover_top_mask);
        }
        localObject1 = this.QlE;
        if (localObject1 != null) {
          break label675;
        }
      }
      for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.sns.cover.a.a)localObject1).findViewById(b.f.sns_cover_preview_bottom_mask))
      {
        if (localObject1 != null) {
          ((View)localObject1).setBackgroundResource(b.e.sns_cover_bottom_mask);
        }
        localObject1 = this.QlE;
        break;
        f = ((com.tencent.mm.plugin.sns.cover.a.a)localObject1).getTranslationY();
        break label453;
        localObject1 = ((com.tencent.mm.plugin.sns.cover.a.a)localObject1).findViewById(b.f.sns_cover_preview_top_mask);
        break label604;
      }
      bool = false;
      break label135;
    }
  }
  
  public final void dj(float paramFloat)
  {
    AppMethodBeat.i(307490);
    com.tencent.mm.plugin.sns.cover.a.a locala = this.QlE;
    if (locala != null) {
      locala.setTranslationY((this.QlI - this.QlJ) * paramFloat + this.QlJ);
    }
    AppMethodBeat.o(307490);
  }
  
  public final void etM()
  {
    AppMethodBeat.i(307525);
    Log.i("MicroMsg.SnsCoverContainerLayout", "[" + hashCode() + "] onPreClose");
    com.tencent.mm.plugin.sns.cover.a.a locala = this.QlE;
    if (locala != null) {
      locala.etM();
    }
    AppMethodBeat.o(307525);
  }
  
  public final kotlin.g.a.a<ah> getCoverClickListener()
  {
    return this.QlN;
  }
  
  public final com.tencent.mm.plugin.sns.cover.c.a getCoverReporter()
  {
    return this.QlQ;
  }
  
  public final int getExternalMargin()
  {
    return this.QlP;
  }
  
  public final m<Integer, Integer, ah> getOnViewSizeChanged()
  {
    return this.mWA;
  }
  
  public final int getPreviewType()
  {
    AppMethodBeat.i(307495);
    com.tencent.mm.plugin.sns.cover.a.a locala = this.QlE;
    if (locala == null)
    {
      AppMethodBeat.o(307495);
      return 0;
    }
    int i = locala.getType();
    AppMethodBeat.o(307495);
    return i;
  }
  
  public final c getSnsCoverReporter()
  {
    return (c)this.QlQ;
  }
  
  public final d getStatus()
  {
    return this.QlH;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(307509);
    super.onAttachedToWindow();
    Object localObject2 = (ViewGroup)this;
    Object localObject1;
    label51:
    do
    {
      if (localObject2 != null) {
        ((ViewGroup)localObject2).setClipChildren(false);
      }
      if (localObject2 != null) {
        ((ViewGroup)localObject2).setClipToPadding(false);
      }
      if (localObject2 != null) {
        break label107;
      }
      localObject1 = null;
      if (!(localObject1 instanceof ViewGroup)) {
        break label115;
      }
      localObject1 = (ViewGroup)localObject1;
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      localObject2 = localObject1;
    } while (!(localObject1 instanceof MMOverScrollView));
    localObject2 = localObject1;
    for (;;)
    {
      if (localObject2 == null) {
        break label125;
      }
      this.pzj = ((ViewGroup)localObject2);
      if (((ViewGroup)localObject2).getId() == 16908290) {
        break label125;
      }
      localObject1 = ((ViewGroup)localObject2).getParent();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject2 = (ViewGroup)localObject1;
        continue;
        label107:
        localObject1 = ((ViewGroup)localObject2).getParent();
        break;
        label115:
        localObject1 = null;
        break label51;
      }
      localObject2 = null;
    }
    label125:
    AppMethodBeat.o(307509);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(307515);
    super.onDetachedFromWindow();
    this.pzj = null;
    AppMethodBeat.o(307515);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(307502);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("MicroMsg.SnsCoverContainerLayout", "onLayout: " + paramBoolean + ", " + paramInt2 + ", " + paramInt4);
    if (paramBoolean)
    {
      getLocationInWindow(new int[2]);
      this.QlF.setTranslationY(getHeight());
      this.QlG.setTranslationY(-this.QlL);
      this.QlK = ((int)(getWidth() * 1.777778F));
      paramInt1 = getHeight();
      localObject = this.pzj;
      if (localObject != null) {
        paramInt1 = ((ViewGroup)localObject).getHeight() - getContext().getResources().getDimensionPixelSize(b.d.Edge_8A);
      }
      if (this.QlK > paramInt1) {
        this.QlK = paramInt1;
      }
      if (this.QlK < getHeight()) {
        this.QlK = getHeight();
      }
      this.QlI = (getHeight() - this.QlK);
      this.QlJ = ((getHeight() - this.QlK) / 2.0F);
      this.QlM = (this.QlK - getHeight() - this.QlP);
      Log.i("MicroMsg.SnsCoverContainerLayout", "updateViewSize: " + this.QlK + ", " + this.QlM);
      localObject = this.QlE;
      if (localObject != null) {
        break label391;
      }
      localObject = null;
      if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != this.QlK))
      {
        ((ViewGroup.LayoutParams)localObject).height = this.QlK;
        com.tencent.mm.plugin.sns.cover.a.a locala = this.QlE;
        if (locala != null) {
          locala.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      localObject = this.mWA;
      if (localObject != null) {
        ((m)localObject).invoke(Integer.valueOf(this.QlK), Integer.valueOf(this.QlM));
      }
      localObject = this.QlE;
      if (localObject != null) {
        break label401;
      }
    }
    label391:
    label401:
    for (Object localObject = null;; localObject = Float.valueOf(((com.tencent.mm.plugin.sns.cover.a.a)localObject).getTranslationY()))
    {
      if (s.a((Float)localObject, 0.0F)) {
        dj(0.0F);
      }
      AppMethodBeat.o(307502);
      return;
      localObject = ((com.tencent.mm.plugin.sns.cover.a.a)localObject).getLayoutParams();
      break;
    }
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(307527);
    Log.i("MicroMsg.SnsCoverContainerLayout", "[" + hashCode() + "] onPostClose");
    this.QlG.setVisibility(0);
    this.QlH.evb = true;
    com.tencent.mm.plugin.sns.cover.a.a locala = this.QlE;
    if (locala != null) {
      locala.onPostClose();
    }
    AppMethodBeat.o(307527);
  }
  
  public final void setCoverClickListener(kotlin.g.a.a<ah> parama)
  {
    this.QlN = parama;
  }
  
  public final void setExternalMargin(int paramInt)
  {
    this.QlP = paramInt;
  }
  
  public final void setOnViewSizeChanged(m<? super Integer, ? super Integer, ah> paramm)
  {
    this.mWA = paramm;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.QlH.isPreview = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.preview.SnsCoverContainerLayout
 * JD-Core Version:    0.7.0.1
 */