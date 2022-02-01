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
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorFrameView;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameView;", "clearActive", "Ljava/lang/Runnable;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "currActiveItem", "Landroid/view/View;", "deleteStateListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "showDelete", "", "getDeleteStateListener", "()Lkotlin/jvm/functions/Function1;", "setDeleteStateListener", "(Lkotlin/jvm/functions/Function1;)V", "deleteView", "Landroid/widget/TextView;", "deleteViewGroup", "Landroid/view/ViewGroup;", "deleteViewIcon", "Landroid/widget/ImageView;", "deletingItem", "displayArea", "Landroid/graphics/Rect;", "getDisplayArea", "()Landroid/graphics/Rect;", "enableTouch", "forceStaticImage", "heightPercent", "", "itemChangeListener", "itemView", "getItemChangeListener", "setItemChangeListener", "itemLayout", "itemStateResolve", "com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1;", "leftFrame", "locationClickListener", "Landroid/view/View$OnClickListener;", "locationView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "getLocationView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "setLocationView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;)V", "lyricsClickListener", "lyricsView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "getLyricsView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "setLyricsView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;)V", "rightFrame", "safeType", "textClickListener", "tipClickListener", "tipItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "getTipItemView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "setTipItemView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;)V", "topFrame", "activeDeleteView", "active", "addEmojiItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "addLocationItem", "sl", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "addLyricsItem", "lyricsItemInfos", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "addTextItem", "item", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "addTipItem", "text", "", "textColor", "textBgColor", "bringItemsToFront", "checkAddLocationItem", "checkLyricsItem", "checkTipItem", "deleteCheck", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "enableGif", "enable", "frameCheck", "getAllItemViews", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "getItemLayout", "getLocationItemHeight", "initConfig", "initHeightSafeArea", "safeHeight", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "onScale", "scaleFactor", "focusX", "focusY", "onScroll", "distanceX", "distanceY", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pause", "removeLocationView", "callback", "Lkotlin/Function0;", "removeLyricsView", "removeTextItem", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "removeTipItem", "replaceLocationView", "replaceLyricsItem", "requestEditing", "editing", "reset", "resume", "setEnableTouch", "setOnLocationClick", "setOnLyricsClick", "setOnTextClick", "setOnTipClick", "setSafeType", "type", "showBottomFrame", "isShow", "showLeftFrame", "showRightFrame", "showTopFrame", "skipDeleteCheck", "skipFrameCheck", "skipRequestEditing", "toggleDeleteView", "show", "updateValidArea", "validRect", "Companion", "ItemStateResolve", "plugin-recordvideo_release"})
public final class EditorItemContainer
  extends InsectRelativeLayout
  implements CropLayout.b
{
  public static final a Icl;
  public RecordConfigProvider ALV;
  public final Rect IbP;
  private ImageView IbQ;
  private ViewGroup IbR;
  public EditorFrameView IbS;
  public EditorFrameView IbT;
  public EditorFrameView IbU;
  public EditorFrameView IbV;
  public boolean IbW;
  private View IbX;
  private b<? super Boolean, x> IbY;
  private b<? super View, x> IbZ;
  private View Ica;
  public q Icb;
  public n Icc;
  public t Icd;
  private View.OnClickListener Ice;
  public View.OnClickListener Icf;
  public View.OnClickListener Icg;
  private View.OnClickListener Ich;
  private int Ici;
  private boolean Icj;
  public final d Ick;
  public float heightPercent;
  private TextView vaq;
  public final ViewGroup var;
  public Runnable vax;
  
  static
  {
    AppMethodBeat.i(76114);
    Icl = new a((byte)0);
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
    this.IbP = new Rect();
    this.vax = ((Runnable)new c(this));
    this.heightPercent = 0.5F;
    this.Icj = true;
    View.inflate(paramContext, b.f.story_capture_editor_item_container, (ViewGroup)this);
    paramContext = findViewById(b.e.editor_item_layout);
    p.j(paramContext, "findViewById(R.id.editor_item_layout)");
    this.var = ((ViewGroup)paramContext);
    paramContext = findViewById(b.e.editor_delete_view);
    p.j(paramContext, "findViewById(R.id.editor_delete_view)");
    this.vaq = ((TextView)paramContext);
    paramContext = findViewById(b.e.editor_delete_view_icon);
    p.j(paramContext, "findViewById(R.id.editor_delete_view_icon)");
    this.IbQ = ((ImageView)paramContext);
    paramContext = findViewById(b.e.editor_delete_view_group);
    p.j(paramContext, "findViewById(R.id.editor_delete_view_group)");
    this.IbR = ((ViewGroup)paramContext);
    paramContext = e.HGz;
    paramContext = e.fuV();
    paramAttributeSet = getResources();
    p.j(paramAttributeSet, "resources");
    paramInt = paramAttributeSet.getDisplayMetrics().widthPixels;
    paramAttributeSet = getResources();
    p.j(paramAttributeSet, "resources");
    paramContext.set(0, 0, paramInt, paramAttributeSet.getDisplayMetrics().heightPixels);
    this.Ick = new d(this);
    AppMethodBeat.o(76112);
  }
  
  private final void mY(boolean paramBoolean)
  {
    AppMethodBeat.i(76104);
    this.IbR.setActivated(paramBoolean);
    if (paramBoolean)
    {
      this.vaq.setText(b.h.editor_item_release_to_delete);
      this.IbQ.setImageDrawable(au.o(getContext(), b.g.icons_filled_delete_on, -1));
      AppMethodBeat.o(76104);
      return;
    }
    this.vaq.setText(b.h.editor_item_drag_to_delete);
    this.IbQ.setImageDrawable(au.o(getContext(), b.g.icons_filled_delete, -1));
    AppMethodBeat.o(76104);
  }
  
  private final void wW(boolean paramBoolean)
  {
    AppMethodBeat.i(76107);
    EditorFrameView localEditorFrameView = this.IbS;
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
  
  private final void wX(boolean paramBoolean)
  {
    AppMethodBeat.i(76108);
    EditorFrameView localEditorFrameView = this.IbT;
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
  
  private final void wY(boolean paramBoolean)
  {
    AppMethodBeat.i(76109);
    EditorFrameView localEditorFrameView = this.IbU;
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
  
  private final void wZ(boolean paramBoolean)
  {
    AppMethodBeat.i(76110);
    EditorFrameView localEditorFrameView = this.IbV;
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
  
  public final boolean Kc(int paramInt)
  {
    AppMethodBeat.i(76092);
    Object localObject = this.IbR.getLayoutParams();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(76092);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.ci.a.fromDPToPix(getContext(), 32) + paramInt);
    this.IbR.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(76092);
    return true;
  }
  
  public final void a(duy paramduy)
  {
    AppMethodBeat.i(76096);
    p.k(paramduy, "sl");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject1 = getContext();
    p.j(localObject1, "context");
    this.Icb = new q((Context)localObject1);
    localObject1 = this.Icb;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = e.HGz;
      localObject2 = e.fuV();
      e locale = e.HGz;
      ((q)localObject1).b((Rect)localObject2, e.fuX());
    }
    localObject1 = this.Icb;
    if (localObject1 != null)
    {
      localObject2 = e.HGz;
      ((q)localObject1).setValidArea(e.fuW());
    }
    localObject1 = this.Icb;
    if (localObject1 != null) {
      ((q)localObject1).a(this.IbP, this.heightPercent);
    }
    localObject1 = this.Icb;
    if (localObject1 != null) {
      ((q)localObject1).setLocation(paramduy);
    }
    paramduy = this.Icb;
    if (paramduy != null) {
      paramduy.setStateResolve((b)this.Ick);
    }
    paramduy = this.Icb;
    if (paramduy != null) {
      paramduy.setOnClickListener(this.Ice);
    }
    this.var.addView((View)this.Icb, (ViewGroup.LayoutParams)localLayoutParams);
    paramduy = this.Icb;
    if (paramduy == null) {
      p.iCn();
    }
    v((View)paramduy, false);
    removeCallbacks(this.vax);
    postDelayed(this.vax, 1500L);
    AppMethodBeat.o(76096);
  }
  
  public final void ae(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(76097);
    if (this.Icb != null) {
      this.var.removeView((View)this.Icb);
    }
    this.Icb = null;
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
    if (!this.Icj)
    {
      AppMethodBeat.o(76111);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(76111);
    return bool;
  }
  
  public final void fyH()
  {
    AppMethodBeat.i(76089);
    Object localObject;
    if (this.Icd != null)
    {
      localObject = this.Icd;
      if (localObject != null) {
        ((t)localObject).bringToFront();
      }
    }
    if (this.Icb != null)
    {
      localObject = this.Icb;
      if (localObject != null) {
        ((q)localObject).bringToFront();
      }
    }
    if (this.Icc != null)
    {
      localObject = this.Icc;
      if (localObject != null)
      {
        ((n)localObject).bringToFront();
        AppMethodBeat.o(76089);
        return;
      }
    }
    AppMethodBeat.o(76089);
  }
  
  public final void fyI()
  {
    AppMethodBeat.i(76093);
    if (this.Icd != null)
    {
      this.var.removeView((View)this.Icd);
      this.Icd = null;
    }
    AppMethodBeat.o(76093);
  }
  
  public final void fyJ()
  {
    AppMethodBeat.i(76095);
    if (this.Icc != null) {
      this.var.removeView((View)this.Icc);
    }
    this.Icc = null;
    AppMethodBeat.o(76095);
  }
  
  public final boolean fyK()
  {
    return this.Icb != null;
  }
  
  public final void gR(List<? extends ctg> paramList)
  {
    AppMethodBeat.i(76094);
    p.k(paramList, "lyricsItemInfos");
    this.Icc = new n(getContext());
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.var.addView((View)this.Icc, (ViewGroup.LayoutParams)localObject1);
    localObject1 = this.Icc;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = e.HGz;
      localObject2 = e.fuV();
      e locale = e.HGz;
      ((n)localObject1).b((Rect)localObject2, e.fuX());
    }
    localObject1 = this.Icc;
    if (localObject1 != null)
    {
      localObject2 = e.HGz;
      ((n)localObject1).setValidArea(e.fuW());
    }
    localObject1 = this.Icc;
    if (localObject1 != null) {
      c.a.a((com.tencent.mm.plugin.recordvideo.ui.editor.view.c)localObject1, this.IbP);
    }
    localObject1 = this.Icc;
    if (localObject1 != null) {
      ((n)localObject1).setStateResolve((b)this.Ick);
    }
    localObject1 = this.Icc;
    if (localObject1 != null)
    {
      ((n)localObject1).gS(paramList);
      AppMethodBeat.o(76094);
      return;
    }
    AppMethodBeat.o(76094);
  }
  
  public final List<h> getAllItemViews()
  {
    AppMethodBeat.i(76102);
    List localList = (List)new ArrayList();
    int i = 0;
    int j = this.var.getChildCount();
    while (i < j)
    {
      View localView = this.var.getChildAt(i);
      if ((localView instanceof h)) {
        localList.add(localView);
      }
      i += 1;
    }
    AppMethodBeat.o(76102);
    return localList;
  }
  
  public final b<Boolean, x> getDeleteStateListener()
  {
    return this.IbY;
  }
  
  public final Rect getDisplayArea()
  {
    return this.IbP;
  }
  
  public final b<View, x> getItemChangeListener()
  {
    return this.IbZ;
  }
  
  public final ViewGroup getItemLayout()
  {
    return this.var;
  }
  
  public final int getLocationItemHeight()
  {
    AppMethodBeat.i(76106);
    Object localObject = this.Icb;
    if (localObject != null)
    {
      localObject = ((q)localObject).getBitmap();
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
  
  public final q getLocationView()
  {
    return this.Icb;
  }
  
  public final n getLyricsView()
  {
    return this.Icc;
  }
  
  public final t getTipItemView()
  {
    return this.Icd;
  }
  
  public final void onScroll(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(220542);
    int j = this.var.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.var.getChildAt(i);
      if ((localView instanceof f))
      {
        ((f)localView).getTouchTracker().aHZ.postTranslate(paramFloat1, paramFloat2);
        localView.invalidate();
      }
      if ((localView instanceof s))
      {
        ((s)localView).getTouchTracker().aHZ.postTranslate(paramFloat1, paramFloat2);
        localView.invalidate();
      }
      i += 1;
    }
    AppMethodBeat.o(220542);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(76090);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("MicroMsg.EditorItemContainer", "onSizeChanged, w:" + paramInt1 + ", h:" + paramInt2);
    this.IbP.set(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(76090);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76091);
    p.k(paramMotionEvent, "event");
    if ((paramMotionEvent.getActionMasked() == 0) && (this.Ica != null))
    {
      View localView = this.Ica;
      if (localView == null) {
        p.iCn();
      }
      v(localView, false);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(76091);
    return bool;
  }
  
  public final void p(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(220545);
    int j = this.var.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.var.getChildAt(i);
      if ((localView instanceof f))
      {
        ((f)localView).getTouchTracker().aHZ.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
        localView.invalidate();
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof s))
        {
          ((s)localView).getTouchTracker().aHZ.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
          localView.invalidate();
        }
      }
    }
    AppMethodBeat.o(220545);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(76105);
    this.Icb = null;
    this.Icd = null;
    this.Icc = null;
    this.var.removeAllViews();
    AppMethodBeat.o(76105);
  }
  
  public final void setDeleteStateListener(b<? super Boolean, x> paramb)
  {
    this.IbY = paramb;
  }
  
  public final void setEnableTouch(boolean paramBoolean)
  {
    this.Icj = paramBoolean;
  }
  
  public final void setItemChangeListener(b<? super View, x> paramb)
  {
    this.IbZ = paramb;
  }
  
  public final void setLocationView(q paramq)
  {
    this.Icb = paramq;
  }
  
  public final void setLyricsView(n paramn)
  {
    this.Icc = paramn;
  }
  
  public final void setOnLocationClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76098);
    p.k(paramOnClickListener, "locationClickListener");
    this.Ice = paramOnClickListener;
    AppMethodBeat.o(76098);
  }
  
  public final void setOnLyricsClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76101);
    p.k(paramOnClickListener, "lyricsClickListener");
    this.Ich = paramOnClickListener;
    AppMethodBeat.o(76101);
  }
  
  public final void setOnTextClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76099);
    p.k(paramOnClickListener, "textClickListener");
    this.Icf = paramOnClickListener;
    AppMethodBeat.o(76099);
  }
  
  public final void setOnTipClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76100);
    p.k(paramOnClickListener, "tipClickListener");
    this.Icg = paramOnClickListener;
    AppMethodBeat.o(76100);
  }
  
  public final void setSafeType(int paramInt)
  {
    this.Ici = paramInt;
    if (this.Ici == 0) {
      this.heightPercent = 0.7F;
    }
    while (this.Ici != 1) {
      return;
    }
    this.heightPercent = 0.5F;
  }
  
  public final void setTipItemView(t paramt)
  {
    this.Icd = paramt;
  }
  
  public final void v(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(76103);
    p.k(paramView, "itemView");
    if (paramBoolean) {
      if ((p.h(paramView, this.Ica) ^ true))
      {
        View localView = this.Ica;
        if (localView != null) {
          localView.setActivated(false);
        }
        this.Ica = paramView;
      }
    }
    for (;;)
    {
      paramView.setActivated(paramBoolean);
      AppMethodBeat.o(76103);
      return;
      if (p.h(paramView, this.Ica)) {
        this.Ica = null;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$Companion;", "", "()V", "ClearActiveDelay", "", "DEFAULT", "", "JUMP_BACK", "SAFE_LINE", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"})
  public static abstract interface b
  {
    public abstract void e(View paramView, MotionEvent paramMotionEvent);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(EditorItemContainer paramEditorItemContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(76085);
      if (EditorItemContainer.a(this.Icm) != null)
      {
        EditorItemContainer localEditorItemContainer = this.Icm;
        View localView = EditorItemContainer.a(this.Icm);
        if (localView == null) {
          p.iCn();
        }
        localEditorItemContainer.v(localView, false);
      }
      AppMethodBeat.o(76085);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"})
  public static final class d
    implements EditorItemContainer.b
  {
    public final void e(final View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(76087);
      p.k(paramView, "itemView");
      p.k(paramMotionEvent, "event");
      if (EditorItemContainer.c(this.Icm)) {
        EditorItemContainer.d(this.Icm);
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
          this.Icm.removeCallbacks(EditorItemContainer.e(this.Icm));
          if (EditorItemContainer.fP(paramView))
          {
            this.Icm.v(paramView, false);
            AppMethodBeat.o(76087);
            return;
          }
          this.Icm.v(paramView, true);
          AppMethodBeat.o(76087);
          return;
          if (!EditorItemContainer.a(this.Icm, paramView)) {
            EditorItemContainer.b(this.Icm, paramView);
          }
        } while (EditorItemContainer.fQ(paramView));
        EditorItemContainer.a(this.Icm, paramView, paramMotionEvent);
        EditorItemContainer.a(this.Icm, true);
        AppMethodBeat.o(76087);
        return;
      }
      if (EditorItemContainer.f(this.Icm) != null) {
        this.Icm.post((Runnable)new a(this, paramView));
      }
      for (;;)
      {
        EditorItemContainer.a(this.Icm, false);
        EditorItemContainer.i(this.Icm);
        EditorItemContainer.j(this.Icm);
        EditorItemContainer.k(this.Icm);
        EditorItemContainer.l(this.Icm);
        break;
        if (EditorItemContainer.a(this.Icm) != null) {
          this.Icm.postDelayed(EditorItemContainer.e(this.Icm), 1500L);
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(EditorItemContainer.d paramd, View paramView) {}
      
      public final void run()
      {
        AppMethodBeat.i(76086);
        EditorItemContainer.h(this.Icn.Icm).removeView(EditorItemContainer.f(this.Icn.Icm));
        b localb = this.Icn.Icm.getItemChangeListener();
        if (localb != null) {
          localb.invoke(EditorItemContainer.f(this.Icn.Icm));
        }
        EditorItemContainer.g(this.Icn.Icm);
        EditorItemContainer.b(this.Icn.Icm);
        if ((paramView instanceof q))
        {
          this.Icn.Icm.setLocationView(null);
          AppMethodBeat.o(76086);
          return;
        }
        if ((paramView instanceof n))
        {
          this.Icn.Icm.setLyricsView(null);
          AppMethodBeat.o(76086);
          return;
        }
        if ((paramView instanceof t)) {
          this.Icn.Icm.setTipItemView(null);
        }
        AppMethodBeat.o(76086);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer
 * JD-Core Version:    0.7.0.1
 */