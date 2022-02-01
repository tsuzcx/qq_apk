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
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.b;
import d.g.a.b;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameView;", "clearActive", "Ljava/lang/Runnable;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "currActiveItem", "Landroid/view/View;", "deleteStateListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "showDelete", "", "getDeleteStateListener", "()Lkotlin/jvm/functions/Function1;", "setDeleteStateListener", "(Lkotlin/jvm/functions/Function1;)V", "deleteView", "Landroid/widget/TextView;", "deleteViewGroup", "Landroid/view/ViewGroup;", "deleteViewIcon", "Landroid/widget/ImageView;", "deletingItem", "displayArea", "Landroid/graphics/Rect;", "getDisplayArea", "()Landroid/graphics/Rect;", "enableTouch", "forceStaticImage", "heightPercent", "", "itemChangeListener", "itemView", "getItemChangeListener", "setItemChangeListener", "itemLayout", "itemStateResolve", "com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1;", "leftFrame", "locationClickListener", "Landroid/view/View$OnClickListener;", "locationView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "getLocationView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "setLocationView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;)V", "lyricsClickListener", "lyricsView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "getLyricsView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "setLyricsView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;)V", "rightFrame", "safeType", "textClickListener", "tipClickListener", "tipItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "getTipItemView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "setTipItemView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;)V", "topFrame", "activeDeleteView", "active", "addEmojiItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "addLocationItem", "sl", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "addLyricsItem", "lyricsItemInfos", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "addTextItem", "item", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "addTipItem", "text", "", "textColor", "textBgColor", "bringItemsToFront", "checkAddLocationItem", "checkLyricsItem", "checkTipItem", "deleteCheck", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "enableGif", "enable", "frameCheck", "getAllItemViews", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "getItemLayout", "getLocationItemHeight", "initConfig", "initHeightSafeArea", "safeHeight", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "onScale", "scaleFactor", "focusX", "focusY", "onScroll", "distanceX", "distanceY", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pause", "removeLocationView", "callback", "Lkotlin/Function0;", "removeLyricsView", "removeTextItem", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "removeTipItem", "replaceLocationView", "replaceLyricsItem", "requestEditing", "editing", "reset", "resume", "setEnableTouch", "setOnLocationClick", "setOnLyricsClick", "setOnTextClick", "setOnTipClick", "setSafeType", "type", "showBottomFrame", "isShow", "showLeftFrame", "showRightFrame", "showTopFrame", "skipDeleteCheck", "skipFrameCheck", "skipRequestEditing", "toggleDeleteView", "show", "updateValidArea", "validRect", "Companion", "ItemStateResolve", "plugin-recordvideo_release"})
public final class EditorItemContainer
  extends InsectRelativeLayout
  implements CropLayout.b
{
  public static final EditorItemContainer.a xOu;
  public float heightPercent;
  private TextView pXj;
  public final ViewGroup pXk;
  public Runnable pXq;
  public RecordConfigProvider sNI;
  public final Rect xNY;
  private ImageView xNZ;
  private ViewGroup xOa;
  public EditorFrameView xOb;
  public EditorFrameView xOc;
  public EditorFrameView xOd;
  public EditorFrameView xOe;
  public boolean xOf;
  private View xOg;
  private b<? super Boolean, z> xOh;
  private b<? super View, z> xOi;
  private View xOj;
  public p xOk;
  public m xOl;
  public s xOm;
  private View.OnClickListener xOn;
  public View.OnClickListener xOo;
  public View.OnClickListener xOp;
  private View.OnClickListener xOq;
  private int xOr;
  private boolean xOs;
  public final d xOt;
  
  static
  {
    AppMethodBeat.i(76114);
    xOu = new EditorItemContainer.a((byte)0);
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
    this.xNY = new Rect();
    this.pXq = ((Runnable)new c(this));
    this.heightPercent = 0.5F;
    this.xOs = true;
    View.inflate(paramContext, 2131495665, (ViewGroup)this);
    paramContext = findViewById(2131299294);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_item_layout)");
    this.pXk = ((ViewGroup)paramContext);
    paramContext = findViewById(2131299290);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_delete_view)");
    this.pXj = ((TextView)paramContext);
    paramContext = findViewById(2131299292);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_delete_view_icon)");
    this.xNZ = ((ImageView)paramContext);
    paramContext = findViewById(2131299291);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_delete_view_group)");
    this.xOa = ((ViewGroup)paramContext);
    paramContext = e.xuo;
    paramContext = e.dEN();
    paramAttributeSet = getResources();
    d.g.b.p.g(paramAttributeSet, "resources");
    paramInt = paramAttributeSet.getDisplayMetrics().widthPixels;
    paramAttributeSet = getResources();
    d.g.b.p.g(paramAttributeSet, "resources");
    paramContext.set(0, 0, paramInt, paramAttributeSet.getDisplayMetrics().heightPixels);
    this.xOt = new d(this);
    AppMethodBeat.o(76112);
  }
  
  private final void kK(boolean paramBoolean)
  {
    AppMethodBeat.i(76104);
    this.xOa.setActivated(paramBoolean);
    if (paramBoolean)
    {
      this.pXj.setText(2131758185);
      this.xNZ.setImageDrawable(ao.k(getContext(), 2131690385, -1));
      AppMethodBeat.o(76104);
      return;
    }
    this.pXj.setText(2131758184);
    this.xNZ.setImageDrawable(ao.k(getContext(), 2131690384, -1));
    AppMethodBeat.o(76104);
  }
  
  private final void qc(boolean paramBoolean)
  {
    AppMethodBeat.i(76107);
    EditorFrameView localEditorFrameView = this.xOb;
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
  
  private final void qd(boolean paramBoolean)
  {
    AppMethodBeat.i(76108);
    EditorFrameView localEditorFrameView = this.xOc;
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
  
  private final void qe(boolean paramBoolean)
  {
    AppMethodBeat.i(76109);
    EditorFrameView localEditorFrameView = this.xOd;
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
  
  private final void qf(boolean paramBoolean)
  {
    AppMethodBeat.i(76110);
    EditorFrameView localEditorFrameView = this.xOe;
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
  
  public final boolean Cy(int paramInt)
  {
    AppMethodBeat.i(76092);
    Object localObject = this.xOa.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(76092);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cc.a.fromDPToPix(getContext(), 32) + paramInt);
    this.xOa.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(76092);
    return true;
  }
  
  public final void I(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(76097);
    if (this.xOk != null) {
      this.pXk.removeView((View)this.xOk);
    }
    this.xOk = null;
    if (parama != null)
    {
      parama.invoke();
      AppMethodBeat.o(76097);
      return;
    }
    AppMethodBeat.o(76097);
  }
  
  public final void a(csd paramcsd)
  {
    AppMethodBeat.i(76096);
    d.g.b.p.h(paramcsd, "sl");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject1 = getContext();
    d.g.b.p.g(localObject1, "context");
    this.xOk = new p((Context)localObject1);
    localObject1 = this.xOk;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = e.xuo;
      localObject2 = e.dEN();
      e locale = e.xuo;
      ((p)localObject1).b((Rect)localObject2, e.dEP());
    }
    localObject1 = this.xOk;
    if (localObject1 != null)
    {
      localObject2 = e.xuo;
      ((p)localObject1).setValidArea(e.dEO());
    }
    localObject1 = this.xOk;
    if (localObject1 != null) {
      ((p)localObject1).a(this.xNY, this.heightPercent);
    }
    localObject1 = this.xOk;
    if (localObject1 != null) {
      ((p)localObject1).setLocation(paramcsd);
    }
    paramcsd = this.xOk;
    if (paramcsd != null) {
      paramcsd.setStateResolve((b)this.xOt);
    }
    paramcsd = this.xOk;
    if (paramcsd != null) {
      paramcsd.setOnClickListener(this.xOn);
    }
    this.pXk.addView((View)this.xOk, (ViewGroup.LayoutParams)localLayoutParams);
    paramcsd = this.xOk;
    if (paramcsd == null) {
      d.g.b.p.gfZ();
    }
    s((View)paramcsd, false);
    removeCallbacks(this.pXq);
    postDelayed(this.pXq, 1500L);
    AppMethodBeat.o(76096);
  }
  
  public final void dHU()
  {
    AppMethodBeat.i(76089);
    Object localObject;
    if (this.xOm != null)
    {
      localObject = this.xOm;
      if (localObject != null) {
        ((s)localObject).bringToFront();
      }
    }
    if (this.xOk != null)
    {
      localObject = this.xOk;
      if (localObject != null) {
        ((p)localObject).bringToFront();
      }
    }
    if (this.xOl != null)
    {
      localObject = this.xOl;
      if (localObject != null)
      {
        ((m)localObject).bringToFront();
        AppMethodBeat.o(76089);
        return;
      }
    }
    AppMethodBeat.o(76089);
  }
  
  public final void dHV()
  {
    AppMethodBeat.i(76093);
    if (this.xOm != null)
    {
      this.pXk.removeView((View)this.xOm);
      this.xOm = null;
    }
    AppMethodBeat.o(76093);
  }
  
  public final void dHW()
  {
    AppMethodBeat.i(76095);
    if (this.xOl != null) {
      this.pXk.removeView((View)this.xOl);
    }
    this.xOl = null;
    AppMethodBeat.o(76095);
  }
  
  public final boolean dHX()
  {
    return this.xOk != null;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76111);
    if (!this.xOs)
    {
      AppMethodBeat.o(76111);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(76111);
    return bool;
  }
  
  public final void fi(List<? extends bwa> paramList)
  {
    AppMethodBeat.i(76094);
    d.g.b.p.h(paramList, "lyricsItemInfos");
    this.xOl = new m(getContext());
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.pXk.addView((View)this.xOl, (ViewGroup.LayoutParams)localObject1);
    localObject1 = this.xOl;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = e.xuo;
      localObject2 = e.dEN();
      e locale = e.xuo;
      ((m)localObject1).b((Rect)localObject2, e.dEP());
    }
    localObject1 = this.xOl;
    if (localObject1 != null)
    {
      localObject2 = e.xuo;
      ((m)localObject1).setValidArea(e.dEO());
    }
    localObject1 = this.xOl;
    if (localObject1 != null) {
      c.a.a((com.tencent.mm.plugin.recordvideo.ui.editor.view.c)localObject1, this.xNY);
    }
    localObject1 = this.xOl;
    if (localObject1 != null) {
      ((m)localObject1).setStateResolve((b)this.xOt);
    }
    localObject1 = this.xOl;
    if (localObject1 != null)
    {
      ((m)localObject1).fj(paramList);
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
    int j = this.pXk.getChildCount();
    while (i < j)
    {
      View localView = this.pXk.getChildAt(i);
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
    return this.xOh;
  }
  
  public final Rect getDisplayArea()
  {
    return this.xNY;
  }
  
  public final b<View, z> getItemChangeListener()
  {
    return this.xOi;
  }
  
  public final ViewGroup getItemLayout()
  {
    return this.pXk;
  }
  
  public final int getLocationItemHeight()
  {
    AppMethodBeat.i(76106);
    Object localObject = this.xOk;
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
    return this.xOk;
  }
  
  public final m getLyricsView()
  {
    return this.xOl;
  }
  
  public final s getTipItemView()
  {
    return this.xOm;
  }
  
  public final void l(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(200660);
    int j = this.pXk.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.pXk.getChildAt(i);
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
    AppMethodBeat.o(200660);
  }
  
  public final void onScroll(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(200659);
    int j = this.pXk.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.pXk.getChildAt(i);
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
    AppMethodBeat.o(200659);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(76090);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ad.i("MicroMsg.EditorItemContainer", "onSizeChanged, w:" + paramInt1 + ", h:" + paramInt2);
    this.xNY.set(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(76090);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76091);
    d.g.b.p.h(paramMotionEvent, "event");
    if ((paramMotionEvent.getActionMasked() == 0) && (this.xOj != null))
    {
      View localView = this.xOj;
      if (localView == null) {
        d.g.b.p.gfZ();
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
    this.xOk = null;
    this.xOm = null;
    this.xOl = null;
    this.pXk.removeAllViews();
    AppMethodBeat.o(76105);
  }
  
  public final void s(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(76103);
    d.g.b.p.h(paramView, "itemView");
    if (paramBoolean) {
      if ((d.g.b.p.i(paramView, this.xOj) ^ true))
      {
        View localView = this.xOj;
        if (localView != null) {
          localView.setActivated(false);
        }
        this.xOj = paramView;
      }
    }
    for (;;)
    {
      paramView.setActivated(paramBoolean);
      AppMethodBeat.o(76103);
      return;
      if (d.g.b.p.i(paramView, this.xOj)) {
        this.xOj = null;
      }
    }
  }
  
  public final void setDeleteStateListener(b<? super Boolean, z> paramb)
  {
    this.xOh = paramb;
  }
  
  public final void setEnableTouch(boolean paramBoolean)
  {
    this.xOs = paramBoolean;
  }
  
  public final void setItemChangeListener(b<? super View, z> paramb)
  {
    this.xOi = paramb;
  }
  
  public final void setLocationView(p paramp)
  {
    this.xOk = paramp;
  }
  
  public final void setLyricsView(m paramm)
  {
    this.xOl = paramm;
  }
  
  public final void setOnLocationClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76098);
    d.g.b.p.h(paramOnClickListener, "locationClickListener");
    this.xOn = paramOnClickListener;
    AppMethodBeat.o(76098);
  }
  
  public final void setOnLyricsClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76101);
    d.g.b.p.h(paramOnClickListener, "lyricsClickListener");
    this.xOq = paramOnClickListener;
    AppMethodBeat.o(76101);
  }
  
  public final void setOnTextClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76099);
    d.g.b.p.h(paramOnClickListener, "textClickListener");
    this.xOo = paramOnClickListener;
    AppMethodBeat.o(76099);
  }
  
  public final void setOnTipClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76100);
    d.g.b.p.h(paramOnClickListener, "tipClickListener");
    this.xOp = paramOnClickListener;
    AppMethodBeat.o(76100);
  }
  
  public final void setSafeType(int paramInt)
  {
    this.xOr = paramInt;
    if (this.xOr == 0) {
      this.heightPercent = 0.7F;
    }
    while (this.xOr != 1) {
      return;
    }
    this.heightPercent = 0.5F;
  }
  
  public final void setTipItemView(s params)
  {
    this.xOm = params;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"})
  public static abstract interface b
  {
    public abstract void c(View paramView, MotionEvent paramMotionEvent);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(EditorItemContainer paramEditorItemContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(76085);
      if (EditorItemContainer.a(this.xOv) != null)
      {
        EditorItemContainer localEditorItemContainer = this.xOv;
        View localView = EditorItemContainer.a(this.xOv);
        if (localView == null) {
          d.g.b.p.gfZ();
        }
        localEditorItemContainer.s(localView, false);
      }
      AppMethodBeat.o(76085);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"})
  public static final class d
    implements EditorItemContainer.b
  {
    public final void c(final View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(76087);
      d.g.b.p.h(paramView, "itemView");
      d.g.b.p.h(paramMotionEvent, "event");
      if (EditorItemContainer.c(this.xOv)) {
        EditorItemContainer.d(this.xOv);
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
          this.xOv.removeCallbacks(EditorItemContainer.e(this.xOv));
          if (EditorItemContainer.eC(paramView))
          {
            this.xOv.s(paramView, false);
            AppMethodBeat.o(76087);
            return;
          }
          this.xOv.s(paramView, true);
          AppMethodBeat.o(76087);
          return;
          if (!EditorItemContainer.a(this.xOv, paramView)) {
            EditorItemContainer.b(this.xOv, paramView);
          }
        } while (EditorItemContainer.eD(paramView));
        EditorItemContainer.a(this.xOv, paramView, paramMotionEvent);
        EditorItemContainer.a(this.xOv, true);
        AppMethodBeat.o(76087);
        return;
      }
      if (EditorItemContainer.f(this.xOv) != null) {
        this.xOv.post((Runnable)new a(this, paramView));
      }
      for (;;)
      {
        EditorItemContainer.a(this.xOv, false);
        EditorItemContainer.i(this.xOv);
        EditorItemContainer.j(this.xOv);
        EditorItemContainer.k(this.xOv);
        EditorItemContainer.l(this.xOv);
        break;
        if (EditorItemContainer.a(this.xOv) != null) {
          this.xOv.postDelayed(EditorItemContainer.e(this.xOv), 1500L);
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(EditorItemContainer.d paramd, View paramView) {}
      
      public final void run()
      {
        AppMethodBeat.i(76086);
        EditorItemContainer.h(this.xOw.xOv).removeView(EditorItemContainer.f(this.xOw.xOv));
        b localb = this.xOw.xOv.getItemChangeListener();
        if (localb != null) {
          localb.invoke(EditorItemContainer.f(this.xOw.xOv));
        }
        EditorItemContainer.g(this.xOw.xOv);
        EditorItemContainer.b(this.xOw.xOv);
        if ((paramView instanceof p))
        {
          this.xOw.xOv.setLocationView(null);
          AppMethodBeat.o(76086);
          return;
        }
        if ((paramView instanceof m))
        {
          this.xOw.xOv.setLyricsView(null);
          AppMethodBeat.o(76086);
          return;
        }
        if ((paramView instanceof s)) {
          this.xOw.xOv.setTipItemView(null);
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