package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenBlackBoardProjector;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getBackgroundView", "Landroid/view/View;", "getLayoutId", "", "initView", "", "Companion", "plugin-multitalk_release"})
public final class d
  extends l
{
  public static final d.a zWc;
  
  static
  {
    AppMethodBeat.i(239922);
    zWc = new d.a((byte)0);
    AppMethodBeat.o(239922);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(239921);
    paramContext = new e.a().E(new int[] { 1, 3, 4 });
    Object localObject1 = getContext();
    kotlin.g.b.p.g(localObject1, "context");
    localObject1 = ((Context)localObject1).getResources().getString(2131765008);
    kotlin.g.b.p.g(localObject1, "context.resources.getStr…_func_send_to_friend_btn)");
    localObject1 = new e.c((String)localObject1, 5);
    Object localObject2 = getContext();
    kotlin.g.b.p.g(localObject2, "context");
    localObject2 = ((Context)localObject2).getResources().getString(2131765006);
    kotlin.g.b.p.g(localObject2, "context.resources.getStr…screen_more_func_fav_btn)");
    localObject2 = new e.c((String)localObject2, 6);
    Object localObject3 = getContext();
    kotlin.g.b.p.g(localObject3, "context");
    localObject3 = ((Context)localObject3).getResources().getString(2131765007);
    kotlin.g.b.p.g(localObject3, "context.resources.getStr…more_func_sav_to_picture)");
    localObject3 = new e.c((String)localObject3, 7);
    Object localObject4 = getContext();
    kotlin.g.b.p.g(localObject4, "context");
    localObject4 = ((Context)localObject4).getResources().getString(2131765019);
    kotlin.g.b.p.g(localObject4, "context.resources.getStr…n_projector_clear_screen)");
    paramContext = paramContext.a(new e.c[] { localObject1, localObject2, localObject3, new e.c((String)localObject4, 8) }).F(new int[] { 11, 9 });
    paramContext.type = 3;
    setScreenFuncConfig(paramContext.epo());
    LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup)this);
    setMReadyLayout((FrameLayout)findViewById(2131297642));
    setMEditLayout((FrameLayout)findViewById(2131297641));
    setBottomRoot((FrameLayout)findViewById(2131297640));
    setTopRoot((FrameLayout)findViewById(2131297643));
    setAvatarRoot((FrameLayout)findViewById(2131297639));
    paramContext = getMEditLayout();
    if (paramContext != null) {
      paramContext.setVisibility(8);
    }
    paramContext = getContext();
    kotlin.g.b.p.g(paramContext, "context");
    setMultiTalkStrokeContext(new b(paramContext, (a)this, getScreenFuncConfig()));
    paramContext = getContext();
    kotlin.g.b.p.g(paramContext, "context");
    setTopUiLayout(new p(paramContext, (a)this));
    paramContext = getContext();
    kotlin.g.b.p.g(paramContext, "context");
    setAvatarLayout(new j(paramContext, (a)this));
    paramContext = getContext();
    kotlin.g.b.p.g(paramContext, "context");
    setBottomUiLayout(new k(paramContext, (a)this, getScreenFuncConfig()));
    setMScreenReportData(new s());
    paramContext = getContext();
    kotlin.g.b.p.g(paramContext, "context");
    setReadyUI(new r(paramContext, (a)this, getScreenFuncConfig()));
    refreshView();
    sd(true);
    paramContext = getViewTreeObserver();
    if (paramContext != null)
    {
      paramContext.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new b(this));
      AppMethodBeat.o(239921);
      return;
    }
    AppMethodBeat.o(239921);
  }
  
  public final View getBackgroundView()
  {
    AppMethodBeat.i(239920);
    View localView = (View)getMEditLayout();
    AppMethodBeat.o(239920);
    return localView;
  }
  
  public final int getLayoutId()
  {
    return 2131495740;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenBlackBoardProjector$initView$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-multitalk_release"})
  public static final class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(239919);
      Object localObject1 = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
      int i;
      if (this.zWd.getMCurrentPageWidth() == 0)
      {
        i = this.zWd.getMCurrentPageWidth();
        localObject2 = this.zWd.getMEditLayout();
        if ((localObject2 != null) && (i == ((FrameLayout)localObject2).getMeasuredWidth()) && (this.zWd.getMCurrentPageHeight() == 0))
        {
          i = this.zWd.getMCurrentPageHeight();
          localObject2 = this.zWd.getMEditLayout();
          if ((localObject2 != null) && (i == ((FrameLayout)localObject2).getMeasuredHeight())) {
            break label370;
          }
        }
      }
      Object localObject2 = this.zWd.getViewTreeObserver();
      if (localObject2 != null) {
        ((ViewTreeObserver)localObject2).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      }
      localObject2 = this.zWd;
      FrameLayout localFrameLayout = this.zWd.getMEditLayout();
      if (localFrameLayout != null)
      {
        i = localFrameLayout.getMeasuredWidth();
        ((d)localObject2).setMCurrentPageWidth(i);
        localObject2 = this.zWd;
        localFrameLayout = this.zWd.getMEditLayout();
        if (localFrameLayout == null) {
          break label381;
        }
        i = localFrameLayout.getMeasuredHeight();
        label187:
        ((d)localObject2).setMCurrentPageHeight(i);
        localObject2 = this.zWd.getMEditLayout();
        if (localObject2 == null) {
          break label386;
        }
        i = ((FrameLayout)localObject2).getMeasuredWidth();
        label213:
        localObject2 = this.zWd.getMEditLayout();
        if (localObject2 == null) {
          break label391;
        }
      }
      label386:
      label391:
      for (int j = ((FrameLayout)localObject2).getMeasuredHeight();; j = 0)
      {
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).setRect(new Rect(0, 0, i, j));
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).backgroundColor = this.zWd.getResources().getColor(2131099745);
        localObject2 = this.zWd.getMultiTalkStrokeContext();
        if (localObject2 != null) {
          b.a((b)localObject2, (com.tencent.mm.media.widget.camerarecordview.b.b)localObject1);
        }
        localObject1 = this.zWd.getMultiTalkStrokeContext();
        if (localObject1 != null) {
          ((b)localObject1).show();
        }
        localObject1 = this.zWd.getMultiTalkStrokeContext();
        if (localObject1 != null) {
          ((b)localObject1).zVL = this.zWd.getMCurrentPageHeight();
        }
        localObject1 = this.zWd.getMultiTalkStrokeContext();
        if (localObject1 != null) {
          ((b)localObject1).zVK = this.zWd.getMCurrentPageWidth();
        }
        localObject1 = this.zWd.getMultiTalkStrokeContext();
        if (localObject1 != null) {
          ((b)localObject1).zVJ = 1.0F;
        }
        this.zWd.epB();
        label370:
        AppMethodBeat.o(239919);
        return;
        i = 0;
        break;
        label381:
        i = 0;
        break label187;
        i = 0;
        break label213;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.d
 * JD-Core Version:    0.7.0.1
 */