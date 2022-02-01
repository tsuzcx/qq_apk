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
import com.tencent.mm.plugin.recordvideo.ui.editor.c.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.d.a;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.protocal.protobuf.enw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameView;", "clearActive", "Ljava/lang/Runnable;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "currActiveItem", "Landroid/view/View;", "deleteStateListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "showDelete", "", "getDeleteStateListener", "()Lkotlin/jvm/functions/Function1;", "setDeleteStateListener", "(Lkotlin/jvm/functions/Function1;)V", "deleteView", "Landroid/widget/TextView;", "deleteViewGroup", "Landroid/view/ViewGroup;", "deleteViewIcon", "Landroid/widget/ImageView;", "deletingItem", "displayArea", "Landroid/graphics/Rect;", "getDisplayArea", "()Landroid/graphics/Rect;", "enableTouch", "forceStaticImage", "heightPercent", "", "itemChangeListener", "itemView", "getItemChangeListener", "setItemChangeListener", "itemLayout", "itemStateResolve", "com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1;", "leftFrame", "locationClickListener", "Landroid/view/View$OnClickListener;", "locationView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "getLocationView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "setLocationView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;)V", "lyricsClickListener", "lyricsView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "getLyricsView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "setLyricsView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;)V", "rightFrame", "safeType", "textClickListener", "tipClickListener", "tipItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "getTipItemView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "setTipItemView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;)V", "topFrame", "activeDeleteView", "active", "addEmojiItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "addLocationItem", "sl", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "addLyricsItem", "lyricsItemInfos", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "addTextItem", "item", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "addTipItem", "text", "", "textColor", "textBgColor", "bringItemsToFront", "checkAddLocationItem", "checkLyricsItem", "checkTipItem", "deleteCheck", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "enableGif", "enable", "frameCheck", "getAllItemViews", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "getItemLayout", "getLocationItemHeight", "getTextContents", "", "initConfig", "initHeightSafeArea", "safeHeight", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "onScale", "scaleFactor", "focusX", "focusY", "onScroll", "distanceX", "distanceY", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pause", "removeLocationView", "callback", "Lkotlin/Function0;", "removeLyricsView", "removeTextItem", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "removeTipItem", "replaceLocationView", "replaceLyricsItem", "requestEditing", "editing", "reset", "resume", "setEnableTouch", "setOnLocationClick", "setOnLyricsClick", "setOnTextClick", "setOnTipClick", "setSafeType", "type", "showBottomFrame", "isShow", "showLeftFrame", "showRightFrame", "showTopFrame", "skipDeleteCheck", "skipFrameCheck", "skipRequestEditing", "toggleDeleteView", "show", "updateValidArea", "validRect", "Companion", "ItemStateResolve", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditorItemContainer
  extends InsectRelativeLayout
  implements CropLayout.b
{
  public static final EditorItemContainer.a NYm;
  public n NYA;
  public t NYB;
  private View.OnClickListener NYC;
  public View.OnClickListener NYD;
  public View.OnClickListener NYE;
  private View.OnClickListener NYF;
  private int NYG;
  private boolean NYH;
  public final c NYI;
  public final Rect NYn;
  private ImageView NYo;
  private ViewGroup NYp;
  public EditorFrameView NYq;
  public EditorFrameView NYr;
  public EditorFrameView NYs;
  public EditorFrameView NYt;
  public boolean NYu;
  private View NYv;
  private b<? super Boolean, ah> NYw;
  private b<? super View, ah> NYx;
  private View NYy;
  public q NYz;
  public float heightPercent;
  public RecordConfigProvider oaV;
  private TextView ymr;
  public final ViewGroup yms;
  public Runnable ymy;
  
  static
  {
    AppMethodBeat.i(76114);
    NYm = new EditorItemContainer.a((byte)0);
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
    this.NYn = new Rect();
    this.ymy = new EditorItemContainer..ExternalSyntheticLambda0(this);
    this.heightPercent = 0.5F;
    this.NYH = true;
    View.inflate(paramContext, b.f.story_capture_editor_item_container, (ViewGroup)this);
    paramContext = findViewById(b.e.editor_item_layout);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.editor_item_layout)");
    this.yms = ((ViewGroup)paramContext);
    paramContext = findViewById(b.e.editor_delete_view);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.editor_delete_view)");
    this.ymr = ((TextView)paramContext);
    paramContext = findViewById(b.e.editor_delete_view_icon);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.editor_delete_view_icon)");
    this.NYo = ((ImageView)paramContext);
    paramContext = findViewById(b.e.editor_delete_view_group);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.editor_delete_view_group)");
    this.NYp = ((ViewGroup)paramContext);
    paramContext = e.NDU;
    e.gGL().set(0, 0, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
    this.NYI = new c(this);
    AppMethodBeat.o(76112);
  }
  
  private final void BA(boolean paramBoolean)
  {
    AppMethodBeat.i(76109);
    EditorFrameView localEditorFrameView = this.NYs;
    if (localEditorFrameView != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (int i = 0;; i = 4)
    {
      localEditorFrameView.setVisibility(i);
      AppMethodBeat.o(76109);
      return;
    }
  }
  
  private final void BB(boolean paramBoolean)
  {
    AppMethodBeat.i(76110);
    EditorFrameView localEditorFrameView = this.NYt;
    if (localEditorFrameView != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (int i = 0;; i = 4)
    {
      localEditorFrameView.setVisibility(i);
      AppMethodBeat.o(76110);
      return;
    }
  }
  
  private final void By(boolean paramBoolean)
  {
    AppMethodBeat.i(76107);
    EditorFrameView localEditorFrameView = this.NYq;
    if (localEditorFrameView != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (int i = 0;; i = 4)
    {
      localEditorFrameView.setVisibility(i);
      AppMethodBeat.o(76107);
      return;
    }
  }
  
  private final void Bz(boolean paramBoolean)
  {
    AppMethodBeat.i(76108);
    EditorFrameView localEditorFrameView = this.NYr;
    if (localEditorFrameView != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (int i = 0;; i = 4)
    {
      localEditorFrameView.setVisibility(i);
      AppMethodBeat.o(76108);
      return;
    }
  }
  
  private static final void a(EditorItemContainer paramEditorItemContainer)
  {
    AppMethodBeat.i(280328);
    kotlin.g.b.s.u(paramEditorItemContainer, "this$0");
    if (paramEditorItemContainer.NYy != null)
    {
      View localView = paramEditorItemContainer.NYy;
      kotlin.g.b.s.checkNotNull(localView);
      paramEditorItemContainer.B(localView, false);
    }
    AppMethodBeat.o(280328);
  }
  
  private final void ox(boolean paramBoolean)
  {
    AppMethodBeat.i(76104);
    this.NYp.setActivated(paramBoolean);
    if (paramBoolean)
    {
      this.ymr.setText(b.h.editor_item_release_to_delete);
      this.NYo.setImageDrawable(bb.m(getContext(), b.g.icons_filled_delete_on, -1));
      AppMethodBeat.o(76104);
      return;
    }
    this.ymr.setText(b.h.editor_item_drag_to_delete);
    this.NYo.setImageDrawable(bb.m(getContext(), b.g.icons_filled_delete, -1));
    AppMethodBeat.o(76104);
  }
  
  public final void B(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(76103);
    kotlin.g.b.s.u(paramView, "itemView");
    if (paramBoolean) {
      if (!kotlin.g.b.s.p(paramView, this.NYy))
      {
        View localView = this.NYy;
        if (localView != null) {
          localView.setActivated(false);
        }
        this.NYy = paramView;
      }
    }
    for (;;)
    {
      paramView.setActivated(paramBoolean);
      AppMethodBeat.o(76103);
      return;
      if (kotlin.g.b.s.p(paramView, this.NYy)) {
        this.NYy = null;
      }
    }
  }
  
  public final boolean La(int paramInt)
  {
    AppMethodBeat.i(76092);
    Object localObject = this.NYp.getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(76092);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(getContext(), 32) + paramInt);
    this.NYp.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(76092);
    return true;
  }
  
  public final void a(enw paramenw)
  {
    AppMethodBeat.i(76096);
    kotlin.g.b.s.u(paramenw, "sl");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject1 = getContext();
    kotlin.g.b.s.s(localObject1, "context");
    this.NYz = new q((Context)localObject1);
    localObject1 = this.NYz;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = e.NDU;
      localObject2 = e.gGL();
      e locale = e.NDU;
      ((q)localObject1).b((Rect)localObject2, e.gGN());
    }
    localObject1 = this.NYz;
    if (localObject1 != null)
    {
      localObject2 = e.NDU;
      ((q)localObject1).setValidArea(e.gGM());
    }
    localObject1 = this.NYz;
    if (localObject1 != null) {
      ((q)localObject1).a(this.NYn, this.heightPercent);
    }
    localObject1 = this.NYz;
    if (localObject1 != null) {
      ((q)localObject1).setLocation(paramenw);
    }
    paramenw = this.NYz;
    if (paramenw != null) {
      paramenw.setStateResolve((b)this.NYI);
    }
    paramenw = this.NYz;
    if (paramenw != null) {
      paramenw.setOnClickListener(this.NYC);
    }
    this.yms.addView((View)this.NYz, (ViewGroup.LayoutParams)localLayoutParams);
    paramenw = this.NYz;
    kotlin.g.b.s.checkNotNull(paramenw);
    B((View)paramenw, false);
    removeCallbacks(this.ymy);
    postDelayed(this.ymy, 1500L);
    AppMethodBeat.o(76096);
  }
  
  public final void bL(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(76097);
    if (this.NYz != null) {
      this.yms.removeView((View)this.NYz);
    }
    this.NYz = null;
    if (parama != null) {
      parama.invoke();
    }
    AppMethodBeat.o(76097);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76111);
    if (!this.NYH)
    {
      AppMethodBeat.o(76111);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(76111);
    return bool;
  }
  
  public final void gKt()
  {
    AppMethodBeat.i(76089);
    Object localObject;
    if (this.NYB != null)
    {
      localObject = this.NYB;
      if (localObject != null) {
        ((t)localObject).bringToFront();
      }
    }
    if (this.NYz != null)
    {
      localObject = this.NYz;
      if (localObject != null) {
        ((q)localObject).bringToFront();
      }
    }
    if (this.NYA != null)
    {
      localObject = this.NYA;
      if (localObject != null) {
        ((n)localObject).bringToFront();
      }
    }
    AppMethodBeat.o(76089);
  }
  
  public final void gKu()
  {
    AppMethodBeat.i(76093);
    if (this.NYB != null)
    {
      this.yms.removeView((View)this.NYB);
      this.NYB = null;
    }
    AppMethodBeat.o(76093);
  }
  
  public final void gKv()
  {
    AppMethodBeat.i(76095);
    if (this.NYA != null) {
      this.yms.removeView((View)this.NYA);
    }
    this.NYA = null;
    AppMethodBeat.o(76095);
  }
  
  public final boolean gKw()
  {
    return this.NYz != null;
  }
  
  public final List<h> getAllItemViews()
  {
    AppMethodBeat.i(76102);
    List localList = (List)new ArrayList();
    int i = 0;
    int k = this.yms.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = this.yms.getChildAt(i);
      if ((localView instanceof h)) {
        localList.add(localView);
      }
      if (j >= k)
      {
        AppMethodBeat.o(76102);
        return localList;
      }
      i = j;
    }
  }
  
  public final b<Boolean, ah> getDeleteStateListener()
  {
    return this.NYw;
  }
  
  public final Rect getDisplayArea()
  {
    return this.NYn;
  }
  
  public final b<View, ah> getItemChangeListener()
  {
    return this.NYx;
  }
  
  public final ViewGroup getItemLayout()
  {
    return this.yms;
  }
  
  public final int getLocationItemHeight()
  {
    AppMethodBeat.i(76106);
    Object localObject = this.NYz;
    if (localObject == null)
    {
      AppMethodBeat.o(76106);
      return 0;
    }
    localObject = ((q)localObject).getBitmap();
    if (localObject == null)
    {
      AppMethodBeat.o(76106);
      return 0;
    }
    int i = ((Bitmap)localObject).getHeight();
    AppMethodBeat.o(76106);
    return i;
  }
  
  public final q getLocationView()
  {
    return this.NYz;
  }
  
  public final n getLyricsView()
  {
    return this.NYA;
  }
  
  public final String getTextContents()
  {
    AppMethodBeat.i(280585);
    int j = this.yms.getChildCount();
    int i;
    Object localObject1;
    Object localObject2;
    if (j >= 0)
    {
      i = 0;
      localObject1 = "";
      if ((this.yms.getChildAt(i) instanceof s))
      {
        localObject2 = this.yms.getChildAt(i);
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.ui.editor.item.TextItemView");
          AppMethodBeat.o(280585);
          throw ((Throwable)localObject1);
        }
        localObject2 = String.valueOf(((s)localObject2).getText());
        if (!Util.isNullOrNil((String)localObject2)) {
          if (kotlin.g.b.s.p(localObject1, ""))
          {
            localObject1 = localObject2;
            label106:
            if (i != j) {
              break label150;
            }
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(280585);
      return localObject1;
      localObject1 = (String)localObject1 + '#' + (String)localObject2;
      break label106;
      break label106;
      label150:
      i += 1;
      break;
      localObject1 = "";
    }
  }
  
  public final t getTipItemView()
  {
    return this.NYB;
  }
  
  public final void jR(List<? extends dki> paramList)
  {
    AppMethodBeat.i(76094);
    kotlin.g.b.s.u(paramList, "lyricsItemInfos");
    this.NYA = new n(getContext());
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.yms.addView((View)this.NYA, (ViewGroup.LayoutParams)localObject1);
    localObject1 = this.NYA;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = e.NDU;
      localObject2 = e.gGL();
      e locale = e.NDU;
      ((n)localObject1).b((Rect)localObject2, e.gGN());
    }
    localObject1 = this.NYA;
    if (localObject1 != null)
    {
      localObject2 = e.NDU;
      ((n)localObject1).setValidArea(e.gGM());
    }
    localObject1 = this.NYA;
    if (localObject1 != null) {
      d.a.a((d)localObject1, this.NYn);
    }
    localObject1 = this.NYA;
    if (localObject1 != null) {
      ((n)localObject1).setStateResolve((b)this.NYI);
    }
    localObject1 = this.NYA;
    if (localObject1 != null) {
      ((n)localObject1).jS(paramList);
    }
    AppMethodBeat.o(76094);
  }
  
  public final void onScroll(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(280574);
    int i = 0;
    int k = this.yms.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = this.yms.getChildAt(i);
      if ((localView instanceof f))
      {
        ((f)localView).getTouchTracker().matrix.postTranslate(paramFloat1, paramFloat2);
        localView.invalidate();
      }
      if ((localView instanceof s))
      {
        ((s)localView).getTouchTracker().matrix.postTranslate(paramFloat1, paramFloat2);
        localView.invalidate();
      }
      if (j >= k)
      {
        AppMethodBeat.o(280574);
        return;
      }
      i = j;
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(76090);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("MicroMsg.EditorItemContainer", "onSizeChanged, w:" + paramInt1 + ", h:" + paramInt2);
    this.NYn.set(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(76090);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76091);
    kotlin.g.b.s.u(paramMotionEvent, "event");
    if ((paramMotionEvent.getActionMasked() == 0) && (this.NYy != null))
    {
      View localView = this.NYy;
      kotlin.g.b.s.checkNotNull(localView);
      B(localView, false);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(76091);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(76105);
    this.NYz = null;
    this.NYB = null;
    this.NYA = null;
    this.yms.removeAllViews();
    AppMethodBeat.o(76105);
  }
  
  public final void s(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(280580);
    int i = 0;
    int k = this.yms.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = this.yms.getChildAt(i);
      if ((localView instanceof f))
      {
        ((f)localView).getTouchTracker().matrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
        localView.invalidate();
      }
      while (j >= k)
      {
        AppMethodBeat.o(280580);
        return;
        if ((localView instanceof s))
        {
          ((s)localView).getTouchTracker().matrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
          localView.invalidate();
        }
      }
      i = j;
    }
  }
  
  public final void setDeleteStateListener(b<? super Boolean, ah> paramb)
  {
    this.NYw = paramb;
  }
  
  public final void setEnableTouch(boolean paramBoolean)
  {
    this.NYH = paramBoolean;
  }
  
  public final void setItemChangeListener(b<? super View, ah> paramb)
  {
    this.NYx = paramb;
  }
  
  public final void setLocationView(q paramq)
  {
    this.NYz = paramq;
  }
  
  public final void setLyricsView(n paramn)
  {
    this.NYA = paramn;
  }
  
  public final void setOnLocationClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76098);
    kotlin.g.b.s.u(paramOnClickListener, "locationClickListener");
    this.NYC = paramOnClickListener;
    AppMethodBeat.o(76098);
  }
  
  public final void setOnLyricsClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76101);
    kotlin.g.b.s.u(paramOnClickListener, "lyricsClickListener");
    this.NYF = paramOnClickListener;
    AppMethodBeat.o(76101);
  }
  
  public final void setOnTextClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76099);
    kotlin.g.b.s.u(paramOnClickListener, "textClickListener");
    this.NYD = paramOnClickListener;
    AppMethodBeat.o(76099);
  }
  
  public final void setOnTipClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76100);
    kotlin.g.b.s.u(paramOnClickListener, "tipClickListener");
    this.NYE = paramOnClickListener;
    AppMethodBeat.o(76100);
  }
  
  public final void setSafeType(int paramInt)
  {
    this.NYG = paramInt;
    if (this.NYG == 0) {
      this.heightPercent = 0.7F;
    }
    while (this.NYG != 1) {
      return;
    }
    this.heightPercent = 0.5F;
  }
  
  public final void setTipItemView(t paramt)
  {
    this.NYB = paramt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void l(View paramView, MotionEvent paramMotionEvent);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements EditorItemContainer.b
  {
    c(EditorItemContainer paramEditorItemContainer) {}
    
    private static final void c(EditorItemContainer paramEditorItemContainer, View paramView)
    {
      AppMethodBeat.i(280259);
      kotlin.g.b.s.u(paramEditorItemContainer, "this$0");
      kotlin.g.b.s.u(paramView, "$itemView");
      EditorItemContainer.k(paramEditorItemContainer).removeView(EditorItemContainer.e(paramEditorItemContainer));
      b localb = paramEditorItemContainer.getItemChangeListener();
      if (localb != null) {
        localb.invoke(EditorItemContainer.e(paramEditorItemContainer));
      }
      EditorItemContainer.l(paramEditorItemContainer);
      EditorItemContainer.m(paramEditorItemContainer);
      if ((paramView instanceof q))
      {
        paramEditorItemContainer.setLocationView(null);
        AppMethodBeat.o(280259);
        return;
      }
      if ((paramView instanceof n))
      {
        paramEditorItemContainer.setLyricsView(null);
        AppMethodBeat.o(280259);
        return;
      }
      if ((paramView instanceof t)) {
        paramEditorItemContainer.setTipItemView(null);
      }
      AppMethodBeat.o(280259);
    }
    
    public final void l(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(76087);
      kotlin.g.b.s.u(paramView, "itemView");
      kotlin.g.b.s.u(paramMotionEvent, "event");
      if (EditorItemContainer.b(this.NYJ)) {
        EditorItemContainer.c(this.NYJ);
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
          this.NYJ.removeCallbacks(EditorItemContainer.d(this.NYJ));
          if (EditorItemContainer.iK(paramView))
          {
            this.NYJ.B(paramView, false);
            AppMethodBeat.o(76087);
            return;
          }
          this.NYJ.B(paramView, true);
          AppMethodBeat.o(76087);
          return;
          if (!EditorItemContainer.a(this.NYJ, paramView)) {
            EditorItemContainer.b(this.NYJ, paramView);
          }
        } while (EditorItemContainer.iL(paramView));
        EditorItemContainer.a(this.NYJ, paramView, paramMotionEvent);
        EditorItemContainer.a(this.NYJ, true);
        AppMethodBeat.o(76087);
        return;
      }
      if (EditorItemContainer.e(this.NYJ) != null) {
        this.NYJ.post(new EditorItemContainer.c..ExternalSyntheticLambda0(this.NYJ, paramView));
      }
      for (;;)
      {
        EditorItemContainer.a(this.NYJ, false);
        EditorItemContainer.g(this.NYJ);
        EditorItemContainer.h(this.NYJ);
        EditorItemContainer.i(this.NYJ);
        EditorItemContainer.j(this.NYJ);
        break;
        if (EditorItemContainer.f(this.NYJ) != null) {
          this.NYJ.postDelayed(EditorItemContainer.d(this.NYJ), 1500L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer
 * JD-Core Version:    0.7.0.1
 */