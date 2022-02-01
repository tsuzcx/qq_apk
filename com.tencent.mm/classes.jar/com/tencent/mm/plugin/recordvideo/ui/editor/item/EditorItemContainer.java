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
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameView;", "clearActive", "Ljava/lang/Runnable;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "currActiveItem", "Landroid/view/View;", "deleteStateListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "showDelete", "", "getDeleteStateListener", "()Lkotlin/jvm/functions/Function1;", "setDeleteStateListener", "(Lkotlin/jvm/functions/Function1;)V", "deleteView", "Landroid/widget/TextView;", "deleteViewGroup", "Landroid/view/ViewGroup;", "deleteViewIcon", "Landroid/widget/ImageView;", "deletingItem", "displayArea", "Landroid/graphics/Rect;", "getDisplayArea", "()Landroid/graphics/Rect;", "enableTouch", "forceStaticImage", "heightPercent", "", "itemChangeListener", "itemView", "getItemChangeListener", "setItemChangeListener", "itemLayout", "itemStateResolve", "com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1;", "leftFrame", "locationClickListener", "Landroid/view/View$OnClickListener;", "locationView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "getLocationView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "setLocationView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;)V", "lyricsClickListener", "lyricsView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "getLyricsView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "setLyricsView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;)V", "rightFrame", "safeType", "textClickListener", "tipClickListener", "tipItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "getTipItemView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "setTipItemView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;)V", "topFrame", "activeDeleteView", "active", "addEmojiItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "addLocationItem", "sl", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "addLyricsItem", "lyricsItemInfos", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "addTextItem", "item", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "addTipItem", "text", "", "textColor", "textBgColor", "bringItemsToFront", "checkAddLocationItem", "checkLyricsItem", "checkTipItem", "deleteCheck", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "enableGif", "enable", "frameCheck", "getAllItemViews", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "getItemLayout", "getLocationItemHeight", "initConfig", "initHeightSafeArea", "safeHeight", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "onScale", "scaleFactor", "focusX", "focusY", "onScroll", "distanceX", "distanceY", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pause", "removeLocationView", "callback", "Lkotlin/Function0;", "removeLyricsView", "removeTextItem", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "removeTipItem", "replaceLocationView", "replaceLyricsItem", "requestEditing", "editing", "reset", "resume", "setEnableTouch", "setOnLocationClick", "setOnLyricsClick", "setOnTextClick", "setOnTipClick", "setSafeType", "type", "showBottomFrame", "isShow", "showLeftFrame", "showRightFrame", "showTopFrame", "skipDeleteCheck", "skipFrameCheck", "skipRequestEditing", "toggleDeleteView", "show", "updateValidArea", "validRect", "Companion", "ItemStateResolve", "plugin-recordvideo_release"})
public final class EditorItemContainer
  extends InsectRelativeLayout
  implements CropLayout.b
{
  public static final EditorItemContainer.a Cfp;
  public final Rect CeT;
  private ImageView CeU;
  private ViewGroup CeV;
  public EditorFrameView CeW;
  public EditorFrameView CeX;
  public EditorFrameView CeY;
  public EditorFrameView CeZ;
  public boolean Cfa;
  private View Cfb;
  private b<? super Boolean, x> Cfc;
  private b<? super View, x> Cfd;
  private View Cfe;
  public p Cff;
  public m Cfg;
  public s Cfh;
  private View.OnClickListener Cfi;
  public View.OnClickListener Cfj;
  public View.OnClickListener Cfk;
  private View.OnClickListener Cfl;
  private int Cfm;
  private boolean Cfn;
  public final d Cfo;
  public float heightPercent;
  private TextView ruM;
  public final ViewGroup ruN;
  public Runnable ruT;
  public RecordConfigProvider wdm;
  
  static
  {
    AppMethodBeat.i(76114);
    Cfp = new EditorItemContainer.a((byte)0);
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
    this.CeT = new Rect();
    this.ruT = ((Runnable)new c(this));
    this.heightPercent = 0.5F;
    this.Cfn = true;
    View.inflate(paramContext, 2131496570, (ViewGroup)this);
    paramContext = findViewById(2131299888);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.editor_item_layout)");
    this.ruN = ((ViewGroup)paramContext);
    paramContext = findViewById(2131299880);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.editor_delete_view)");
    this.ruM = ((TextView)paramContext);
    paramContext = findViewById(2131299882);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.editor_delete_view_icon)");
    this.CeU = ((ImageView)paramContext);
    paramContext = findViewById(2131299881);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.editor_delete_view_group)");
    this.CeV = ((ViewGroup)paramContext);
    paramContext = e.BKp;
    paramContext = e.eIR();
    paramAttributeSet = getResources();
    kotlin.g.b.p.g(paramAttributeSet, "resources");
    paramInt = paramAttributeSet.getDisplayMetrics().widthPixels;
    paramAttributeSet = getResources();
    kotlin.g.b.p.g(paramAttributeSet, "resources");
    paramContext.set(0, 0, paramInt, paramAttributeSet.getDisplayMetrics().heightPixels);
    this.Cfo = new d(this);
    AppMethodBeat.o(76112);
  }
  
  private final void lN(boolean paramBoolean)
  {
    AppMethodBeat.i(76104);
    this.CeV.setActivated(paramBoolean);
    if (paramBoolean)
    {
      this.ruM.setText(2131758472);
      this.CeU.setImageDrawable(ar.m(getContext(), 2131690530, -1));
      AppMethodBeat.o(76104);
      return;
    }
    this.ruM.setText(2131758471);
    this.CeU.setImageDrawable(ar.m(getContext(), 2131690529, -1));
    AppMethodBeat.o(76104);
  }
  
  private final void tA(boolean paramBoolean)
  {
    AppMethodBeat.i(76107);
    EditorFrameView localEditorFrameView = this.CeW;
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
  
  private final void tB(boolean paramBoolean)
  {
    AppMethodBeat.i(76108);
    EditorFrameView localEditorFrameView = this.CeX;
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
  
  private final void tC(boolean paramBoolean)
  {
    AppMethodBeat.i(76109);
    EditorFrameView localEditorFrameView = this.CeY;
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
  
  private final void tD(boolean paramBoolean)
  {
    AppMethodBeat.i(76110);
    EditorFrameView localEditorFrameView = this.CeZ;
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
  
  public final boolean Gv(int paramInt)
  {
    AppMethodBeat.i(76092);
    Object localObject = this.CeV.getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(76092);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(getContext(), 32) + paramInt);
    this.CeV.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(76092);
    return true;
  }
  
  public final void a(dlg paramdlg)
  {
    AppMethodBeat.i(76096);
    kotlin.g.b.p.h(paramdlg, "sl");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject1 = getContext();
    kotlin.g.b.p.g(localObject1, "context");
    this.Cff = new p((Context)localObject1);
    localObject1 = this.Cff;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = e.BKp;
      localObject2 = e.eIR();
      e locale = e.BKp;
      ((p)localObject1).b((Rect)localObject2, e.eIT());
    }
    localObject1 = this.Cff;
    if (localObject1 != null)
    {
      localObject2 = e.BKp;
      ((p)localObject1).setValidArea(e.eIS());
    }
    localObject1 = this.Cff;
    if (localObject1 != null) {
      ((p)localObject1).a(this.CeT, this.heightPercent);
    }
    localObject1 = this.Cff;
    if (localObject1 != null) {
      ((p)localObject1).setLocation(paramdlg);
    }
    paramdlg = this.Cff;
    if (paramdlg != null) {
      paramdlg.setStateResolve((b)this.Cfo);
    }
    paramdlg = this.Cff;
    if (paramdlg != null) {
      paramdlg.setOnClickListener(this.Cfi);
    }
    this.ruN.addView((View)this.Cff, (ViewGroup.LayoutParams)localLayoutParams);
    paramdlg = this.Cff;
    if (paramdlg == null) {
      kotlin.g.b.p.hyc();
    }
    t((View)paramdlg, false);
    removeCallbacks(this.ruT);
    postDelayed(this.ruT, 1500L);
    AppMethodBeat.o(76096);
  }
  
  public final void ab(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(76097);
    if (this.Cff != null) {
      this.ruN.removeView((View)this.Cff);
    }
    this.Cff = null;
    if (parama != null)
    {
      parama.invoke();
      AppMethodBeat.o(76097);
      return;
    }
    AppMethodBeat.o(76097);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76111);
    if (!this.Cfn)
    {
      AppMethodBeat.o(76111);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(76111);
    return bool;
  }
  
  public final void eMl()
  {
    AppMethodBeat.i(76089);
    Object localObject;
    if (this.Cfh != null)
    {
      localObject = this.Cfh;
      if (localObject != null) {
        ((s)localObject).bringToFront();
      }
    }
    if (this.Cff != null)
    {
      localObject = this.Cff;
      if (localObject != null) {
        ((p)localObject).bringToFront();
      }
    }
    if (this.Cfg != null)
    {
      localObject = this.Cfg;
      if (localObject != null)
      {
        ((m)localObject).bringToFront();
        AppMethodBeat.o(76089);
        return;
      }
    }
    AppMethodBeat.o(76089);
  }
  
  public final void eMm()
  {
    AppMethodBeat.i(76093);
    if (this.Cfh != null)
    {
      this.ruN.removeView((View)this.Cfh);
      this.Cfh = null;
    }
    AppMethodBeat.o(76093);
  }
  
  public final void eMn()
  {
    AppMethodBeat.i(76095);
    if (this.Cfg != null) {
      this.ruN.removeView((View)this.Cfg);
    }
    this.Cfg = null;
    AppMethodBeat.o(76095);
  }
  
  public final boolean eMo()
  {
    return this.Cff != null;
  }
  
  public final List<g> getAllItemViews()
  {
    AppMethodBeat.i(76102);
    List localList = (List)new ArrayList();
    int i = 0;
    int j = this.ruN.getChildCount();
    while (i < j)
    {
      View localView = this.ruN.getChildAt(i);
      if ((localView instanceof g)) {
        localList.add(localView);
      }
      i += 1;
    }
    AppMethodBeat.o(76102);
    return localList;
  }
  
  public final b<Boolean, x> getDeleteStateListener()
  {
    return this.Cfc;
  }
  
  public final Rect getDisplayArea()
  {
    return this.CeT;
  }
  
  public final b<View, x> getItemChangeListener()
  {
    return this.Cfd;
  }
  
  public final ViewGroup getItemLayout()
  {
    return this.ruN;
  }
  
  public final int getLocationItemHeight()
  {
    AppMethodBeat.i(76106);
    Object localObject = this.Cff;
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
    return this.Cff;
  }
  
  public final m getLyricsView()
  {
    return this.Cfg;
  }
  
  public final s getTipItemView()
  {
    return this.Cfh;
  }
  
  public final void gl(List<? extends ckm> paramList)
  {
    AppMethodBeat.i(76094);
    kotlin.g.b.p.h(paramList, "lyricsItemInfos");
    this.Cfg = new m(getContext());
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.ruN.addView((View)this.Cfg, (ViewGroup.LayoutParams)localObject1);
    localObject1 = this.Cfg;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = e.BKp;
      localObject2 = e.eIR();
      e locale = e.BKp;
      ((m)localObject1).b((Rect)localObject2, e.eIT());
    }
    localObject1 = this.Cfg;
    if (localObject1 != null)
    {
      localObject2 = e.BKp;
      ((m)localObject1).setValidArea(e.eIS());
    }
    localObject1 = this.Cfg;
    if (localObject1 != null) {
      c.a.a((com.tencent.mm.plugin.recordvideo.ui.editor.view.c)localObject1, this.CeT);
    }
    localObject1 = this.Cfg;
    if (localObject1 != null) {
      ((m)localObject1).setStateResolve((b)this.Cfo);
    }
    localObject1 = this.Cfg;
    if (localObject1 != null)
    {
      ((m)localObject1).gm(paramList);
      AppMethodBeat.o(76094);
      return;
    }
    AppMethodBeat.o(76094);
  }
  
  public final void o(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(237759);
    int j = this.ruN.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.ruN.getChildAt(i);
      if ((localView instanceof f))
      {
        ((f)localView).getTouchTracker().gT.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
        localView.invalidate();
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof r))
        {
          ((r)localView).getTouchTracker().gT.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
          localView.invalidate();
        }
      }
    }
    AppMethodBeat.o(237759);
  }
  
  public final void onScroll(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237758);
    int j = this.ruN.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.ruN.getChildAt(i);
      if ((localView instanceof f))
      {
        ((f)localView).getTouchTracker().gT.postTranslate(paramFloat1, paramFloat2);
        localView.invalidate();
      }
      if ((localView instanceof r))
      {
        ((r)localView).getTouchTracker().gT.postTranslate(paramFloat1, paramFloat2);
        localView.invalidate();
      }
      i += 1;
    }
    AppMethodBeat.o(237758);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(76090);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("MicroMsg.EditorItemContainer", "onSizeChanged, w:" + paramInt1 + ", h:" + paramInt2);
    this.CeT.set(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(76090);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76091);
    kotlin.g.b.p.h(paramMotionEvent, "event");
    if ((paramMotionEvent.getActionMasked() == 0) && (this.Cfe != null))
    {
      View localView = this.Cfe;
      if (localView == null) {
        kotlin.g.b.p.hyc();
      }
      t(localView, false);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(76091);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(76105);
    this.Cff = null;
    this.Cfh = null;
    this.Cfg = null;
    this.ruN.removeAllViews();
    AppMethodBeat.o(76105);
  }
  
  public final void setDeleteStateListener(b<? super Boolean, x> paramb)
  {
    this.Cfc = paramb;
  }
  
  public final void setEnableTouch(boolean paramBoolean)
  {
    this.Cfn = paramBoolean;
  }
  
  public final void setItemChangeListener(b<? super View, x> paramb)
  {
    this.Cfd = paramb;
  }
  
  public final void setLocationView(p paramp)
  {
    this.Cff = paramp;
  }
  
  public final void setLyricsView(m paramm)
  {
    this.Cfg = paramm;
  }
  
  public final void setOnLocationClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76098);
    kotlin.g.b.p.h(paramOnClickListener, "locationClickListener");
    this.Cfi = paramOnClickListener;
    AppMethodBeat.o(76098);
  }
  
  public final void setOnLyricsClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76101);
    kotlin.g.b.p.h(paramOnClickListener, "lyricsClickListener");
    this.Cfl = paramOnClickListener;
    AppMethodBeat.o(76101);
  }
  
  public final void setOnTextClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76099);
    kotlin.g.b.p.h(paramOnClickListener, "textClickListener");
    this.Cfj = paramOnClickListener;
    AppMethodBeat.o(76099);
  }
  
  public final void setOnTipClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76100);
    kotlin.g.b.p.h(paramOnClickListener, "tipClickListener");
    this.Cfk = paramOnClickListener;
    AppMethodBeat.o(76100);
  }
  
  public final void setSafeType(int paramInt)
  {
    this.Cfm = paramInt;
    if (this.Cfm == 0) {
      this.heightPercent = 0.7F;
    }
    while (this.Cfm != 1) {
      return;
    }
    this.heightPercent = 0.5F;
  }
  
  public final void setTipItemView(s params)
  {
    this.Cfh = params;
  }
  
  public final void t(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(76103);
    kotlin.g.b.p.h(paramView, "itemView");
    if (paramBoolean) {
      if ((kotlin.g.b.p.j(paramView, this.Cfe) ^ true))
      {
        View localView = this.Cfe;
        if (localView != null) {
          localView.setActivated(false);
        }
        this.Cfe = paramView;
      }
    }
    for (;;)
    {
      paramView.setActivated(paramBoolean);
      AppMethodBeat.o(76103);
      return;
      if (kotlin.g.b.p.j(paramView, this.Cfe)) {
        this.Cfe = null;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"})
  public static abstract interface b
  {
    public abstract void d(View paramView, MotionEvent paramMotionEvent);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(EditorItemContainer paramEditorItemContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(76085);
      if (EditorItemContainer.a(this.Cfq) != null)
      {
        EditorItemContainer localEditorItemContainer = this.Cfq;
        View localView = EditorItemContainer.a(this.Cfq);
        if (localView == null) {
          kotlin.g.b.p.hyc();
        }
        localEditorItemContainer.t(localView, false);
      }
      AppMethodBeat.o(76085);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"})
  public static final class d
    implements EditorItemContainer.b
  {
    public final void d(final View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(76087);
      kotlin.g.b.p.h(paramView, "itemView");
      kotlin.g.b.p.h(paramMotionEvent, "event");
      if (EditorItemContainer.c(this.Cfq)) {
        EditorItemContainer.d(this.Cfq);
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
          this.Cfq.removeCallbacks(EditorItemContainer.e(this.Cfq));
          if (EditorItemContainer.eK(paramView))
          {
            this.Cfq.t(paramView, false);
            AppMethodBeat.o(76087);
            return;
          }
          this.Cfq.t(paramView, true);
          AppMethodBeat.o(76087);
          return;
          if (!EditorItemContainer.a(this.Cfq, paramView)) {
            EditorItemContainer.b(this.Cfq, paramView);
          }
        } while (EditorItemContainer.eL(paramView));
        EditorItemContainer.a(this.Cfq, paramView, paramMotionEvent);
        EditorItemContainer.a(this.Cfq, true);
        AppMethodBeat.o(76087);
        return;
      }
      if (EditorItemContainer.f(this.Cfq) != null) {
        this.Cfq.post((Runnable)new a(this, paramView));
      }
      for (;;)
      {
        EditorItemContainer.a(this.Cfq, false);
        EditorItemContainer.i(this.Cfq);
        EditorItemContainer.j(this.Cfq);
        EditorItemContainer.k(this.Cfq);
        EditorItemContainer.l(this.Cfq);
        break;
        if (EditorItemContainer.a(this.Cfq) != null) {
          this.Cfq.postDelayed(EditorItemContainer.e(this.Cfq), 1500L);
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(EditorItemContainer.d paramd, View paramView) {}
      
      public final void run()
      {
        AppMethodBeat.i(76086);
        EditorItemContainer.h(this.Cfr.Cfq).removeView(EditorItemContainer.f(this.Cfr.Cfq));
        b localb = this.Cfr.Cfq.getItemChangeListener();
        if (localb != null) {
          localb.invoke(EditorItemContainer.f(this.Cfr.Cfq));
        }
        EditorItemContainer.g(this.Cfr.Cfq);
        EditorItemContainer.b(this.Cfr.Cfq);
        if ((paramView instanceof p))
        {
          this.Cfr.Cfq.setLocationView(null);
          AppMethodBeat.o(76086);
          return;
        }
        if ((paramView instanceof m))
        {
          this.Cfr.Cfq.setLyricsView(null);
          AppMethodBeat.o(76086);
          return;
        }
        if ((paramView instanceof s)) {
          this.Cfr.Cfq.setTipItemView(null);
        }
        AppMethodBeat.o(76086);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer
 * JD-Core Version:    0.7.0.1
 */