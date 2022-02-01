package com.tencent.mm.plugin.surface.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.surface.a.c;
import com.tencent.mm.plugin.surface.c.c;
import com.tencent.mm.plugin.surface.c.e;
import com.tencent.mm.plugin.surface.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/view/SurfaceAppContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "frameSet", "Lcom/tencent/mm/plugin/surface/render/FrameSet;", "name", "", "runBind", "Ljava/lang/Runnable;", "bind", "", "root", "Lcom/tencent/mm/plugin/surface/render/FrameSetRoot;", "info", "checkBind", "destroy", "dispatch", "appId", "event", "data", "init", "attributeSet", "defStyle", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetFrameSetName", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public class SurfaceAppContainer
  extends FrameLayout
{
  public static final SurfaceAppContainer.a SLJ;
  private c SLK;
  private Runnable SLL;
  private String name;
  
  static
  {
    AppMethodBeat.i(265041);
    SLJ = new SurfaceAppContainer.a((byte)0);
    AppMethodBeat.o(265041);
  }
  
  public SurfaceAppContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
    AppMethodBeat.i(265029);
    AppMethodBeat.o(265029);
  }
  
  public SurfaceAppContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(265002);
    this.name = "";
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(265002);
  }
  
  private static final void a(f paramf, String paramString, SurfaceAppContainer paramSurfaceAppContainer)
  {
    Object localObject2 = null;
    AppMethodBeat.i(265034);
    s.u(paramf, "$root");
    s.u(paramString, "$info");
    s.u(paramSurfaceAppContainer, "this$0");
    Log.i("MicroMsg.SurfaceApp.SurfaceContainerView", "notify bind:" + paramf + ", " + paramString);
    Object localObject1 = e.SLi;
    c localc = paramSurfaceAppContainer.SLK;
    localObject1 = localc;
    if (localc == null)
    {
      s.bIx("frameSet");
      localObject1 = null;
    }
    if (!e.has(((c)localObject1).id))
    {
      localObject1 = e.SLi;
      localc = paramSurfaceAppContainer.SLK;
      localObject1 = localc;
      if (localc == null)
      {
        s.bIx("frameSet");
        localObject1 = null;
      }
      e.a((c)localObject1);
    }
    paramSurfaceAppContainer = paramSurfaceAppContainer.SLK;
    if (paramSurfaceAppContainer == null)
    {
      s.bIx("frameSet");
      paramSurfaceAppContainer = localObject2;
    }
    for (;;)
    {
      paramf.a(paramSurfaceAppContainer, paramString);
      AppMethodBeat.o(265034);
      return;
    }
  }
  
  private final void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(265012);
    Object localObject1 = "";
    Object localObject2 = localObject1;
    int j;
    if (paramAttributeSet != null)
    {
      localObject2 = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.SurfaceContainer, paramInt, 0);
      j = ((TypedArray)localObject2).getIndexCount();
      paramContext = (Context)localObject1;
      if (j > 0) {
        paramInt = 0;
      }
    }
    for (;;)
    {
      int i = paramInt + 1;
      paramInt = ((TypedArray)localObject2).getIndex(paramInt);
      paramContext = (Context)localObject1;
      if (paramInt == a.c.SurfaceContainer_name)
      {
        paramAttributeSet = ((TypedArray)localObject2).getString(paramInt);
        paramContext = (Context)localObject1;
        if (paramAttributeSet != null) {
          paramContext = paramAttributeSet;
        }
      }
      if (i >= j)
      {
        ((TypedArray)localObject2).recycle();
        localObject2 = paramContext;
        setBackgroundColor(0);
        this.SLK = new c((String)localObject2, (ViewGroup)this);
        localObject1 = new StringBuilder("SurfaceContainerView init:").append((String)localObject2).append(" #");
        paramAttributeSet = this.SLK;
        paramContext = paramAttributeSet;
        if (paramAttributeSet == null)
        {
          s.bIx("frameSet");
          paramContext = null;
        }
        Log.i("MicroMsg.SurfaceApp.SurfaceContainerView", paramContext.id);
        AppMethodBeat.o(265012);
        return;
      }
      paramInt = i;
      localObject1 = paramContext;
    }
  }
  
  private final void hCb()
  {
    AppMethodBeat.i(265017);
    if ((this.SLL != null) && (getMeasuredWidth() * getMeasuredHeight() != 0))
    {
      Runnable localRunnable = this.SLL;
      s.checkNotNull(localRunnable);
      localRunnable.run();
      this.SLL = null;
    }
    AppMethodBeat.o(265017);
  }
  
  public final void bde(String paramString)
  {
    AppMethodBeat.i(265058);
    s.u(paramString, "name");
    c localc2 = this.SLK;
    c localc1 = localc2;
    if (localc2 == null)
    {
      s.bIx("frameSet");
      localc1 = null;
    }
    localc1.setName(paramString);
    AppMethodBeat.o(265058);
  }
  
  protected void onAttachedToWindow()
  {
    Object localObject2 = null;
    AppMethodBeat.i(265064);
    c localc = this.SLK;
    Object localObject1 = localc;
    if (localc == null)
    {
      s.bIx("frameSet");
      localObject1 = null;
    }
    Log.v("MicroMsg.SurfaceApp.SurfaceContainerView", s.X("onAttachedToWindow#", ((c)localObject1).id));
    super.onAttachedToWindow();
    localObject1 = e.SLi;
    localc = this.SLK;
    localObject1 = localc;
    if (localc == null)
    {
      s.bIx("frameSet");
      localObject1 = null;
    }
    if (!e.has(((c)localObject1).id))
    {
      localObject1 = e.SLi;
      localObject1 = this.SLK;
      if (localObject1 != null) {
        break label105;
      }
      s.bIx("frameSet");
      localObject1 = localObject2;
    }
    label105:
    for (;;)
    {
      e.a((c)localObject1);
      AppMethodBeat.o(265064);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject2 = null;
    AppMethodBeat.i(265069);
    c localc = this.SLK;
    Object localObject1 = localc;
    if (localc == null)
    {
      s.bIx("frameSet");
      localObject1 = null;
    }
    Log.v("MicroMsg.SurfaceApp.SurfaceContainerView", s.X("onDetachedFromWindow#", ((c)localObject1).id));
    super.onDetachedFromWindow();
    localObject1 = e.SLi;
    localObject1 = this.SLK;
    if (localObject1 == null)
    {
      s.bIx("frameSet");
      localObject1 = localObject2;
    }
    for (;;)
    {
      e.b((c)localObject1);
      AppMethodBeat.o(265069);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(265073);
    c localc2 = this.SLK;
    c localc1 = localc2;
    if (localc2 == null)
    {
      s.bIx("frameSet");
      localc1 = null;
    }
    Log.v("MicroMsg.SurfaceApp.SurfaceContainerView", s.X("onMeasure#", localc1.id));
    hCb();
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(265073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.view.SurfaceAppContainer
 * JD-Core Version:    0.7.0.1
 */