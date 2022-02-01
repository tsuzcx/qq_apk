package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorFrameView;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.b;
import d.g.a.b;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameView;", "clearActive", "Ljava/lang/Runnable;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "currActiveItem", "Landroid/view/View;", "deleteStateListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "showDelete", "", "getDeleteStateListener", "()Lkotlin/jvm/functions/Function1;", "setDeleteStateListener", "(Lkotlin/jvm/functions/Function1;)V", "deleteView", "Landroid/widget/TextView;", "deleteViewGroup", "Landroid/view/ViewGroup;", "deleteViewIcon", "Landroid/widget/ImageView;", "deletingItem", "displayArea", "Landroid/graphics/Rect;", "getDisplayArea", "()Landroid/graphics/Rect;", "enableTouch", "forceStaticImage", "heightPercent", "", "itemChangeListener", "itemView", "getItemChangeListener", "setItemChangeListener", "itemLayout", "itemStateResolve", "com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1;", "leftFrame", "locationClickListener", "Landroid/view/View$OnClickListener;", "locationView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "getLocationView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "setLocationView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;)V", "lyricsClickListener", "lyricsView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "getLyricsView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "setLyricsView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;)V", "rightFrame", "safeType", "textClickListener", "tipClickListener", "tipItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "getTipItemView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "setTipItemView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;)V", "topFrame", "activeDeleteView", "active", "addEmojiItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "addLocationItem", "sl", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "addLyricsItem", "lyricsItemInfos", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "addTextItem", "item", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "addTipItem", "text", "", "textColor", "textBgColor", "bringItemsToFront", "checkAddLocationItem", "checkLyricsItem", "checkTipItem", "deleteCheck", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "enableGif", "enable", "frameCheck", "getAllItemViews", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "getItemLayout", "getLocationItemHeight", "initConfig", "initHeightSafeArea", "safeHeight", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "onScale", "scaleFactor", "focusX", "focusY", "onScroll", "distanceX", "distanceY", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pause", "removeLocationView", "callback", "Lkotlin/Function0;", "removeLyricsView", "removeTextItem", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "removeTipItem", "replaceLocationView", "replaceLyricsItem", "requestEditing", "editing", "reset", "resume", "setEnableTouch", "setOnLocationClick", "setOnLyricsClick", "setOnTextClick", "setOnTipClick", "setSafeType", "type", "showBottomFrame", "isShow", "showLeftFrame", "showRightFrame", "showTopFrame", "skipDeleteCheck", "skipFrameCheck", "skipRequestEditing", "toggleDeleteView", "show", "updateValidArea", "validRect", "Companion", "ItemStateResolve", "plugin-recordvideo_release"})
public final class EditorItemContainer
  extends InsectRelativeLayout
  implements CropLayout.b
{
  public static final EditorItemContainer.a yen;
  public float heightPercent;
  private TextView qdO;
  public final ViewGroup qdP;
  public Runnable qdV;
  public RecordConfigProvider sYT;
  public final Rect ydR;
  private ImageView ydS;
  private ViewGroup ydT;
  public EditorFrameView ydU;
  public EditorFrameView ydV;
  public EditorFrameView ydW;
  public EditorFrameView ydX;
  public boolean ydY;
  private View ydZ;
  private b<? super Boolean, z> yea;
  private b<? super View, z> yeb;
  private View yec;
  public p yed;
  public m yee;
  public s yef;
  private View.OnClickListener yeg;
  public View.OnClickListener yeh;
  public View.OnClickListener yei;
  private View.OnClickListener yej;
  private int yek;
  private boolean yel;
  public final d yem;
  
  static
  {
    AppMethodBeat.i(76114);
    yen = new EditorItemContainer.a((byte)0);
    AppMethodBeat.o(76114);
  }
  
  public EditorItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(76113);
    AppMethodBeat.o(76113);
  }
  
  public EditorItemContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(76112);
    this.ydR = new Rect();
    this.qdV = ((Runnable)new c(this));
    this.heightPercent = 0.5F;
    this.yel = true;
    View.inflate(paramContext, 2131495665, (ViewGroup)this);
    paramContext = findViewById(2131299294);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_item_layout)");
    this.qdP = ((ViewGroup)paramContext);
    paramContext = findViewById(2131299290);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_delete_view)");
    this.qdO = ((TextView)paramContext);
    paramContext = findViewById(2131299292);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_delete_view_icon)");
    this.ydS = ((ImageView)paramContext);
    paramContext = findViewById(2131299291);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_delete_view_group)");
    this.ydT = ((ViewGroup)paramContext);
    paramContext = e.xKl;
    paramContext = e.dIe();
    paramAttributeSet = getResources();
    d.g.b.p.g(paramAttributeSet, "resources");
    paramInt = paramAttributeSet.getDisplayMetrics().widthPixels;
    paramAttributeSet = getResources();
    d.g.b.p.g(paramAttributeSet, "resources");
    paramContext.set(0, 0, paramInt, paramAttributeSet.getDisplayMetrics().heightPixels);
    this.yem = new d(this);
    AppMethodBeat.o(76112);
  }
  
  private final void kL(boolean paramBoolean)
  {
    AppMethodBeat.i(76104);
    this.ydT.setActivated(paramBoolean);
    if (paramBoolean)
    {
      this.qdO.setText(2131758185);
      this.ydS.setImageDrawable(ao.k(getContext(), 2131690385, -1));
      AppMethodBeat.o(76104);
      return;
    }
    this.qdO.setText(2131758184);
    this.ydS.setImageDrawable(ao.k(getContext(), 2131690384, -1));
    AppMethodBeat.o(76104);
  }
  
  private final void qj(boolean paramBoolean)
  {
    AppMethodBeat.i(76107);
    EditorFrameView localEditorFrameView = this.ydU;
    if (localEditorFrameView != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        localEditorFrameView.setVisibility(i);
        AppMethodBeat.o(76107);
        return;
      }
    }
    AppMethodBeat.o(76107);
  }
  
  private final void qk(boolean paramBoolean)
  {
    AppMethodBeat.i(76108);
    EditorFrameView localEditorFrameView = this.ydV;
    if (localEditorFrameView != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        localEditorFrameView.setVisibility(i);
        AppMethodBeat.o(76108);
        return;
      }
    }
    AppMethodBeat.o(76108);
  }
  
  private final void ql(boolean paramBoolean)
  {
    AppMethodBeat.i(76109);
    EditorFrameView localEditorFrameView = this.ydW;
    if (localEditorFrameView != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        localEditorFrameView.setVisibility(i);
        AppMethodBeat.o(76109);
        return;
      }
    }
    AppMethodBeat.o(76109);
  }
  
  private final void qm(boolean paramBoolean)
  {
    AppMethodBeat.i(76110);
    EditorFrameView localEditorFrameView = this.ydX;
    if (localEditorFrameView != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        localEditorFrameView.setVisibility(i);
        AppMethodBeat.o(76110);
        return;
      }
    }
    AppMethodBeat.o(76110);
  }
  
  public final boolean CK(int paramInt)
  {
    AppMethodBeat.i(76092);
    Object localObject = this.ydT.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(76092);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(getContext(), 32) + paramInt);
    this.ydT.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(76092);
    return true;
  }
  
  public final void I(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(76097);
    if (this.yed != null) {
      this.qdP.removeView((View)this.yed);
    }
    this.yed = null;
    if (parama != null)
    {
      parama.invoke();
      AppMethodBeat.o(76097);
      return;
    }
    AppMethodBeat.o(76097);
  }
  
  public final void a(csx paramcsx)
  {
    AppMethodBeat.i(76096);
    d.g.b.p.h(paramcsx, "sl");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject1 = getContext();
    d.g.b.p.g(localObject1, "context");
    this.yed = new p((Context)localObject1);
    localObject1 = this.yed;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = e.xKl;
      localObject2 = e.dIe();
      e locale = e.xKl;
      ((p)localObject1).b((Rect)localObject2, e.dIg());
    }
    localObject1 = this.yed;
    if (localObject1 != null)
    {
      localObject2 = e.xKl;
      ((p)localObject1).setValidArea(e.dIf());
    }
    localObject1 = this.yed;
    if (localObject1 != null) {
      ((p)localObject1).a(this.ydR, this.heightPercent);
    }
    localObject1 = this.yed;
    if (localObject1 != null) {
      ((p)localObject1).setLocation(paramcsx);
    }
    paramcsx = this.yed;
    if (paramcsx != null) {
      paramcsx.setStateResolve((b)this.yem);
    }
    paramcsx = this.yed;
    if (paramcsx != null) {
      paramcsx.setOnClickListener(this.yeg);
    }
    this.qdP.addView((View)this.yed, (ViewGroup.LayoutParams)localLayoutParams);
    paramcsx = this.yed;
    if (paramcsx == null) {
      d.g.b.p.gkB();
    }
    s((View)paramcsx, false);
    removeCallbacks(this.qdV);
    postDelayed(this.qdV, 1500L);
    AppMethodBeat.o(76096);
  }
  
  public final void dLl()
  {
    AppMethodBeat.i(76089);
    Object localObject;
    if (this.yef != null)
    {
      localObject = this.yef;
      if (localObject != null) {
        ((s)localObject).bringToFront();
      }
    }
    if (this.yed != null)
    {
      localObject = this.yed;
      if (localObject != null) {
        ((p)localObject).bringToFront();
      }
    }
    if (this.yee != null)
    {
      localObject = this.yee;
      if (localObject != null)
      {
        ((m)localObject).bringToFront();
        AppMethodBeat.o(76089);
        return;
      }
    }
    AppMethodBeat.o(76089);
  }
  
  public final void dLm()
  {
    AppMethodBeat.i(76093);
    if (this.yef != null)
    {
      this.qdP.removeView((View)this.yef);
      this.yef = null;
    }
    AppMethodBeat.o(76093);
  }
  
  public final void dLn()
  {
    AppMethodBeat.i(76095);
    if (this.yee != null) {
      this.qdP.removeView((View)this.yee);
    }
    this.yee = null;
    AppMethodBeat.o(76095);
  }
  
  public final boolean dLo()
  {
    return this.yed != null;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76111);
    if (!this.yel)
    {
      AppMethodBeat.o(76111);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(76111);
    return bool;
  }
  
  public final void fq(List<? extends bwu> paramList)
  {
    AppMethodBeat.i(76094);
    d.g.b.p.h(paramList, "lyricsItemInfos");
    this.yee = new m(getContext());
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.qdP.addView((View)this.yee, (ViewGroup.LayoutParams)localObject1);
    localObject1 = this.yee;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = e.xKl;
      localObject2 = e.dIe();
      e locale = e.xKl;
      ((m)localObject1).b((Rect)localObject2, e.dIg());
    }
    localObject1 = this.yee;
    if (localObject1 != null)
    {
      localObject2 = e.xKl;
      ((m)localObject1).setValidArea(e.dIf());
    }
    localObject1 = this.yee;
    if (localObject1 != null) {
      c.a.a((com.tencent.mm.plugin.recordvideo.ui.editor.view.c)localObject1, this.ydR);
    }
    localObject1 = this.yee;
    if (localObject1 != null) {
      ((m)localObject1).setStateResolve((b)this.yem);
    }
    localObject1 = this.yee;
    if (localObject1 != null)
    {
      ((m)localObject1).fr(paramList);
      AppMethodBeat.o(76094);
      return;
    }
    AppMethodBeat.o(76094);
  }
  
  public final List<g> getAllItemViews()
  {
    AppMethodBeat.i(76102);
    List localList = (List)new ArrayList();
    int i = 0;
    int j = this.qdP.getChildCount();
    while (i < j)
    {
      View localView = this.qdP.getChildAt(i);
      if ((localView instanceof g)) {
        localList.add(localView);
      }
      i += 1;
    }
    AppMethodBeat.o(76102);
    return localList;
  }
  
  public final b<Boolean, z> getDeleteStateListener()
  {
    return this.yea;
  }
  
  public final Rect getDisplayArea()
  {
    return this.ydR;
  }
  
  public final b<View, z> getItemChangeListener()
  {
    return this.yeb;
  }
  
  public final ViewGroup getItemLayout()
  {
    return this.qdP;
  }
  
  public final int getLocationItemHeight()
  {
    AppMethodBeat.i(76106);
    Object localObject = this.yed;
    if (localObject != null)
    {
      localObject = ((p)localObject).getBitmap();
      if (localObject != null)
      {
        int i = ((Bitmap)localObject).getHeight();
        AppMethodBeat.o(76106);
        return i;
      }
    }
    AppMethodBeat.o(76106);
    return 0;
  }
  
  public final p getLocationView()
  {
    return this.yed;
  }
  
  public final m getLyricsView()
  {
    return this.yee;
  }
  
  public final s getTipItemView()
  {
    return this.yef;
  }
  
  public final void l(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(206918);
    int j = this.qdP.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.qdP.getChildAt(i);
      if ((localView instanceof f))
      {
        ((f)localView).getTouchTracker().gR.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
        localView.invalidate();
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof r))
        {
          ((r)localView).getTouchTracker().gR.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
          localView.invalidate();
        }
      }
    }
    AppMethodBeat.o(206918);
  }
  
  public final void onScroll(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206917);
    int j = this.qdP.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.qdP.getChildAt(i);
      if ((localView instanceof f))
      {
        ((f)localView).getTouchTracker().gR.postTranslate(paramFloat1, paramFloat2);
        localView.invalidate();
      }
      if ((localView instanceof r))
      {
        ((r)localView).getTouchTracker().gR.postTranslate(paramFloat1, paramFloat2);
        localView.invalidate();
      }
      i += 1;
    }
    AppMethodBeat.o(206917);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(76090);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ae.i("MicroMsg.EditorItemContainer", "onSizeChanged, w:" + paramInt1 + ", h:" + paramInt2);
    this.ydR.set(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(76090);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76091);
    d.g.b.p.h(paramMotionEvent, "event");
    if ((paramMotionEvent.getActionMasked() == 0) && (this.yec != null))
    {
      View localView = this.yec;
      if (localView == null) {
        d.g.b.p.gkB();
      }
      s(localView, false);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(76091);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(76105);
    this.yed = null;
    this.yef = null;
    this.yee = null;
    this.qdP.removeAllViews();
    AppMethodBeat.o(76105);
  }
  
  public final void s(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(76103);
    d.g.b.p.h(paramView, "itemView");
    if (paramBoolean) {
      if ((d.g.b.p.i(paramView, this.yec) ^ true))
      {
        View localView = this.yec;
        if (localView != null) {
          localView.setActivated(false);
        }
        this.yec = paramView;
      }
    }
    for (;;)
    {
      paramView.setActivated(paramBoolean);
      AppMethodBeat.o(76103);
      return;
      if (d.g.b.p.i(paramView, this.yec)) {
        this.yec = null;
      }
    }
  }
  
  public final void setDeleteStateListener(b<? super Boolean, z> paramb)
  {
    this.yea = paramb;
  }
  
  public final void setEnableTouch(boolean paramBoolean)
  {
    this.yel = paramBoolean;
  }
  
  public final void setItemChangeListener(b<? super View, z> paramb)
  {
    this.yeb = paramb;
  }
  
  public final void setLocationView(p paramp)
  {
    this.yed = paramp;
  }
  
  public final void setLyricsView(m paramm)
  {
    this.yee = paramm;
  }
  
  public final void setOnLocationClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76098);
    d.g.b.p.h(paramOnClickListener, "locationClickListener");
    this.yeg = paramOnClickListener;
    AppMethodBeat.o(76098);
  }
  
  public final void setOnLyricsClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76101);
    d.g.b.p.h(paramOnClickListener, "lyricsClickListener");
    this.yej = paramOnClickListener;
    AppMethodBeat.o(76101);
  }
  
  public final void setOnTextClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76099);
    d.g.b.p.h(paramOnClickListener, "textClickListener");
    this.yeh = paramOnClickListener;
    AppMethodBeat.o(76099);
  }
  
  public final void setOnTipClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76100);
    d.g.b.p.h(paramOnClickListener, "tipClickListener");
    this.yei = paramOnClickListener;
    AppMethodBeat.o(76100);
  }
  
  public final void setSafeType(int paramInt)
  {
    this.yek = paramInt;
    if (this.yek == 0) {
      this.heightPercent = 0.7F;
    }
    while (this.yek != 1) {
      return;
    }
    this.heightPercent = 0.5F;
  }
  
  public final void setTipItemView(s params)
  {
    this.yef = params;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"})
  public static abstract interface b
  {
    public abstract void c(View paramView, MotionEvent paramMotionEvent);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(EditorItemContainer paramEditorItemContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(76085);
      if (EditorItemContainer.a(this.yeo) != null)
      {
        EditorItemContainer localEditorItemContainer = this.yeo;
        View localView = EditorItemContainer.a(this.yeo);
        if (localView == null) {
          d.g.b.p.gkB();
        }
        localEditorItemContainer.s(localView, false);
      }
      AppMethodBeat.o(76085);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"})
  public static final class d
    implements EditorItemContainer.b
  {
    public final void c(final View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(76087);
      d.g.b.p.h(paramView, "itemView");
      d.g.b.p.h(paramMotionEvent, "event");
      if (EditorItemContainer.c(this.yeo)) {
        EditorItemContainer.d(this.yeo);
      }
      switch (paramMotionEvent.getActionMasked())
      {
      default: 
      case 0: 
      case 2: 
        do
        {
          AppMethodBeat.o(76087);
          return;
          this.yeo.removeCallbacks(EditorItemContainer.e(this.yeo));
          if (EditorItemContainer.eC(paramView))
          {
            this.yeo.s(paramView, false);
            AppMethodBeat.o(76087);
            return;
          }
          this.yeo.s(paramView, true);
          AppMethodBeat.o(76087);
          return;
          if (!EditorItemContainer.a(this.yeo, paramView)) {
            EditorItemContainer.b(this.yeo, paramView);
          }
        } while (EditorItemContainer.eD(paramView));
        EditorItemContainer.a(this.yeo, paramView, paramMotionEvent);
        EditorItemContainer.a(this.yeo, true);
        AppMethodBeat.o(76087);
        return;
      }
      if (EditorItemContainer.f(this.yeo) != null) {
        this.yeo.post((Runnable)new a(this, paramView));
      }
      for (;;)
      {
        EditorItemContainer.a(this.yeo, false);
        EditorItemContainer.i(this.yeo);
        EditorItemContainer.j(this.yeo);
        EditorItemContainer.k(this.yeo);
        EditorItemContainer.l(this.yeo);
        break;
        if (EditorItemContainer.a(this.yeo) != null) {
          this.yeo.postDelayed(EditorItemContainer.e(this.yeo), 1500L);
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(EditorItemContainer.d paramd, View paramView) {}
      
      public final void run()
      {
        AppMethodBeat.i(76086);
        EditorItemContainer.h(this.yep.yeo).removeView(EditorItemContainer.f(this.yep.yeo));
        b localb = this.yep.yeo.getItemChangeListener();
        if (localb != null) {
          localb.invoke(EditorItemContainer.f(this.yep.yeo));
        }
        EditorItemContainer.g(this.yep.yeo);
        EditorItemContainer.b(this.yep.yeo);
        if ((paramView instanceof p))
        {
          this.yep.yeo.setLocationView(null);
          AppMethodBeat.o(76086);
          return;
        }
        if ((paramView instanceof m))
        {
          this.yep.yeo.setLyricsView(null);
          AppMethodBeat.o(76086);
          return;
        }
        if ((paramView instanceof s)) {
          this.yep.yeo.setTipItemView(null);
        }
        AppMethodBeat.o(76086);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer
 * JD-Core Version:    0.7.0.1
 */