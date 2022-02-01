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
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.emoji.view.InsectRelativeLayout;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorFrameView;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.widget.cropview.CropLayout.p;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer;", "Lcom/tencent/mm/emoji/view/InsectRelativeLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameView;", "clearActive", "Ljava/lang/Runnable;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "currActiveItem", "Landroid/view/View;", "deleteStateListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "showDelete", "", "getDeleteStateListener", "()Lkotlin/jvm/functions/Function1;", "setDeleteStateListener", "(Lkotlin/jvm/functions/Function1;)V", "deleteView", "Landroid/widget/TextView;", "deleteViewGroup", "Landroid/view/ViewGroup;", "deleteViewIcon", "Landroid/widget/ImageView;", "deletingItem", "displayArea", "Landroid/graphics/Rect;", "getDisplayArea", "()Landroid/graphics/Rect;", "enableTouch", "forceStaticImage", "heightPercent", "", "itemChangeListener", "itemView", "getItemChangeListener", "setItemChangeListener", "itemLayout", "itemStateResolve", "com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1;", "leftFrame", "locationClickListener", "Landroid/view/View$OnClickListener;", "locationView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "getLocationView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "setLocationView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;)V", "lyricsClickListener", "lyricsView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "getLyricsView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "setLyricsView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;)V", "rightFrame", "safeType", "textClickListener", "tipClickListener", "tipItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "getTipItemView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "setTipItemView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;)V", "topFrame", "activeDeleteView", "active", "addEmojiItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "addLocationItem", "sl", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "addLyricsItem", "lyricsItemInfos", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "addTextItem", "text", "", "textColor", "textBgColor", "addTipItem", "bringItemsToFront", "checkAddLocationItem", "checkLyricsItem", "checkTipItem", "deleteCheck", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "enableGif", "enable", "frameCheck", "getAllItemViews", "Lcom/tencent/mm/media/editor/item/IEditable;", "getItemLayout", "getLocationItemHeight", "initConfig", "initHeightSafeArea", "safeHeight", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "onScale", "scaleFactor", "focusX", "focusY", "onScroll", "distanceX", "distanceY", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pause", "removeLocationView", "callback", "Lkotlin/Function0;", "removeLyricsView", "removeTextItem", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "removeTipItem", "replaceLocationView", "replaceLyricsItem", "replaceTipView", "requestEditing", "editing", "reset", "resume", "setEnableTouch", "setOnLocationClick", "setOnLyricsClick", "setOnTextClick", "setOnTipClick", "setSafeType", "type", "showBottomFrame", "isShow", "showLeftFrame", "showRightFrame", "showTopFrame", "skipDeleteCheck", "skipFrameCheck", "skipRequestEditing", "toggleDeleteView", "show", "updateValidArea", "validRect", "Companion", "ItemStateResolve", "plugin-recordvideo_release"})
public final class EditorItemContainer
  extends InsectRelativeLayout
  implements CropLayout.p
{
  public static final a vtm;
  private float heightPercent;
  private TextView oQs;
  public final ViewGroup oQt;
  private Runnable oQz;
  private RecordConfigProvider vcC;
  private final Rect vsQ;
  private ImageView vsR;
  private ViewGroup vsS;
  private EditorFrameView vsT;
  private EditorFrameView vsU;
  private EditorFrameView vsV;
  private EditorFrameView vsW;
  private boolean vsX;
  private View vsY;
  private b<? super Boolean, y> vsZ;
  private b<? super View, y> vta;
  private View vtb;
  private f vtc;
  private e vtd;
  private h vte;
  private View.OnClickListener vtf;
  private View.OnClickListener vtg;
  private View.OnClickListener vth;
  private View.OnClickListener vti;
  private int vtj;
  private boolean vtk;
  private final d vtl;
  
  static
  {
    AppMethodBeat.i(76114);
    vtm = new a((byte)0);
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
    this.vsQ = new Rect();
    this.oQz = ((Runnable)new c(this));
    this.heightPercent = 0.5F;
    this.vtk = true;
    View.inflate(paramContext, 2131495665, (ViewGroup)this);
    paramContext = findViewById(2131299294);
    k.g(paramContext, "findViewById(R.id.editor_item_layout)");
    this.oQt = ((ViewGroup)paramContext);
    paramContext = findViewById(2131299290);
    k.g(paramContext, "findViewById(R.id.editor_delete_view)");
    this.oQs = ((TextView)paramContext);
    paramContext = findViewById(2131299292);
    k.g(paramContext, "findViewById(R.id.editor_delete_view_icon)");
    this.vsR = ((ImageView)paramContext);
    paramContext = findViewById(2131299291);
    k.g(paramContext, "findViewById(R.id.editor_delete_view_group)");
    this.vsS = ((ViewGroup)paramContext);
    paramContext = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    paramContext = com.tencent.mm.plugin.recordvideo.background.f.dgJ();
    paramAttributeSet = getResources();
    k.g(paramAttributeSet, "resources");
    paramInt = paramAttributeSet.getDisplayMetrics().widthPixels;
    paramAttributeSet = getResources();
    k.g(paramAttributeSet, "resources");
    paramContext.set(0, 0, paramInt, paramAttributeSet.getDisplayMetrics().heightPixels);
    this.vtl = new d(this);
    AppMethodBeat.o(76112);
  }
  
  private final void diV()
  {
    AppMethodBeat.i(76089);
    Object localObject;
    if (this.vte != null)
    {
      localObject = this.vte;
      if (localObject != null) {
        ((h)localObject).bringToFront();
      }
    }
    if (this.vtc != null)
    {
      localObject = this.vtc;
      if (localObject != null) {
        ((f)localObject).bringToFront();
      }
    }
    if (this.vtd != null)
    {
      localObject = this.vtd;
      if (localObject != null)
      {
        ((e)localObject).bringToFront();
        AppMethodBeat.o(76089);
        return;
      }
    }
    AppMethodBeat.o(76089);
  }
  
  private final void jV(boolean paramBoolean)
  {
    AppMethodBeat.i(76104);
    this.vsS.setActivated(paramBoolean);
    if (paramBoolean)
    {
      this.oQs.setText(2131758185);
      this.vsR.setImageDrawable(am.i(getContext(), 2131690385, -1));
      AppMethodBeat.o(76104);
      return;
    }
    this.oQs.setText(2131758184);
    this.vsR.setImageDrawable(am.i(getContext(), 2131690384, -1));
    AppMethodBeat.o(76104);
  }
  
  private final void oG(boolean paramBoolean)
  {
    AppMethodBeat.i(76107);
    EditorFrameView localEditorFrameView = this.vsT;
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
  
  private final void oH(boolean paramBoolean)
  {
    AppMethodBeat.i(76108);
    EditorFrameView localEditorFrameView = this.vsU;
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
  
  private final void oI(boolean paramBoolean)
  {
    AppMethodBeat.i(76109);
    EditorFrameView localEditorFrameView = this.vsV;
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
  
  private final void oJ(boolean paramBoolean)
  {
    AppMethodBeat.i(76110);
    EditorFrameView localEditorFrameView = this.vsW;
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
  
  public final void O(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(204314);
    k.h(paramEmojiInfo, "emojiInfo");
    c localc = new c(getContext(), false);
    Object localObject = this.vcC;
    if (localObject != null)
    {
      localObject = ((RecordConfigProvider)localObject).vhI;
      if (localObject != null) {
        localc.U(((UICustomParam)localObject).fGN, ((UICustomParam)localObject).fGO);
      }
    }
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.oQt.addView((View)localc, (ViewGroup.LayoutParams)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    localObject = com.tencent.mm.plugin.recordvideo.background.f.dgJ();
    com.tencent.mm.plugin.recordvideo.background.f localf = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    localc.b((Rect)localObject, com.tencent.mm.plugin.recordvideo.background.f.dgL());
    localObject = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    localc.setValidArea(com.tencent.mm.plugin.recordvideo.background.f.dgK());
    d.a.a(localc, this.vsQ);
    localc.setStateResolve((b)this.vtl);
    localc.setEmojiInfo(paramEmojiInfo);
    localc.resume();
    if (this.vsX) {
      localc.pause();
    }
    s((View)localc, true);
    removeCallbacks(this.oQz);
    postDelayed(this.oQz, 1500L);
    diV();
    AppMethodBeat.o(204314);
  }
  
  public final void R(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(204321);
    Object localObject = getContext();
    k.g(localObject, "context");
    this.vsT = new EditorFrameView((Context)localObject);
    localObject = this.vsT;
    if (localObject != null) {
      ((EditorFrameView)localObject).setPosition(com.tencent.mm.plugin.recordvideo.ui.editor.a.vri);
    }
    localObject = this.vsT;
    if (localObject != null) {
      ((EditorFrameView)localObject).setVisibility(4);
    }
    localObject = new RelativeLayout.LayoutParams((int)paramFloat2, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(20);
    addView((View)this.vsT, (ViewGroup.LayoutParams)localObject);
    localObject = getContext();
    k.g(localObject, "context");
    this.vsV = new EditorFrameView((Context)localObject);
    localObject = this.vsV;
    if (localObject != null) {
      ((EditorFrameView)localObject).setPosition(com.tencent.mm.plugin.recordvideo.ui.editor.a.vrk);
    }
    localObject = this.vsV;
    if (localObject != null) {
      ((EditorFrameView)localObject).setVisibility(4);
    }
    localObject = new RelativeLayout.LayoutParams((int)paramFloat2, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(21);
    addView((View)this.vsV, (ViewGroup.LayoutParams)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    com.tencent.mm.plugin.recordvideo.background.f.dgJ().left = ((int)paramFloat2);
    localObject = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    com.tencent.mm.plugin.recordvideo.background.f.dgJ().right = ((int)paramFloat2 + (int)paramFloat1);
    localObject = new StringBuilder("logStory: initWidthSafeArea safeAreaRect:");
    com.tencent.mm.plugin.recordvideo.background.f localf = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    ad.i("MicroMsg.EditorItemContainer", com.tencent.mm.plugin.recordvideo.background.f.dgJ());
    AppMethodBeat.o(204321);
  }
  
  public final void S(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(204322);
    Object localObject = getContext();
    k.g(localObject, "context");
    this.vsU = new EditorFrameView((Context)localObject);
    localObject = this.vsU;
    if (localObject != null) {
      ((EditorFrameView)localObject).setPosition(com.tencent.mm.plugin.recordvideo.ui.editor.a.vrj);
    }
    localObject = this.vsU;
    if (localObject != null) {
      ((EditorFrameView)localObject).setVisibility(4);
    }
    localObject = new RelativeLayout.LayoutParams(-1, (int)paramFloat2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    addView((View)this.vsU, (ViewGroup.LayoutParams)localObject);
    localObject = getContext();
    k.g(localObject, "context");
    this.vsW = new EditorFrameView((Context)localObject);
    localObject = this.vsW;
    if (localObject != null) {
      ((EditorFrameView)localObject).setPosition(com.tencent.mm.plugin.recordvideo.ui.editor.a.vrl);
    }
    localObject = this.vsW;
    if (localObject != null) {
      ((EditorFrameView)localObject).setVisibility(4);
    }
    localObject = new RelativeLayout.LayoutParams(-1, (int)paramFloat2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    addView((View)this.vsW, (ViewGroup.LayoutParams)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    com.tencent.mm.plugin.recordvideo.background.f.dgJ().top = ((int)paramFloat2);
    localObject = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    com.tencent.mm.plugin.recordvideo.background.f.dgJ().bottom = ((int)paramFloat2 + (int)paramFloat1);
    localObject = new StringBuilder("logStory: initHeightSafeArea safeAreaRect:");
    com.tencent.mm.plugin.recordvideo.background.f localf = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    ad.i("MicroMsg.EditorItemContainer", com.tencent.mm.plugin.recordvideo.background.f.dgJ());
    AppMethodBeat.o(204322);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(204313);
    k.h(paramRecordConfigProvider, "configProvider");
    this.vcC = paramRecordConfigProvider;
    AppMethodBeat.o(204313);
  }
  
  public final void a(chx paramchx)
  {
    AppMethodBeat.i(76096);
    k.h(paramchx, "sl");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject1 = getContext();
    k.g(localObject1, "context");
    this.vtc = new f((Context)localObject1);
    localObject1 = this.vtc;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      localObject2 = com.tencent.mm.plugin.recordvideo.background.f.dgJ();
      com.tencent.mm.plugin.recordvideo.background.f localf = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      ((f)localObject1).b((Rect)localObject2, com.tencent.mm.plugin.recordvideo.background.f.dgL());
    }
    localObject1 = this.vtc;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      ((f)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.f.dgK());
    }
    localObject1 = this.vtc;
    if (localObject1 != null) {
      ((f)localObject1).a(this.vsQ, this.heightPercent);
    }
    localObject1 = this.vtc;
    if (localObject1 != null) {
      ((f)localObject1).setLocation(paramchx);
    }
    paramchx = this.vtc;
    if (paramchx != null) {
      paramchx.setStateResolve((b)this.vtl);
    }
    paramchx = this.vtc;
    if (paramchx != null) {
      paramchx.setOnClickListener(this.vtf);
    }
    this.oQt.addView((View)this.vtc, (ViewGroup.LayoutParams)localLayoutParams);
    paramchx = this.vtc;
    if (paramchx == null) {
      k.fvU();
    }
    s((View)paramchx, false);
    removeCallbacks(this.oQz);
    postDelayed(this.oQz, 1500L);
    AppMethodBeat.o(76096);
  }
  
  public final void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(204324);
    int j = this.oQt.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.oQt.getChildAt(i);
      if ((localView instanceof c))
      {
        ((c)localView).getTouchTracker().dY.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
        localView.invalidate();
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof g))
        {
          ((g)localView).getTouchTracker().dY.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
          localView.invalidate();
        }
      }
    }
    AppMethodBeat.o(204324);
  }
  
  public final void c(chx paramchx)
  {
    AppMethodBeat.i(204318);
    k.h(paramchx, "sl");
    if (this.vtc == null)
    {
      AppMethodBeat.o(204318);
      return;
    }
    y((d.g.a.a)EditorItemContainer.e.vtp);
    a(paramchx);
    AppMethodBeat.o(204318);
  }
  
  public final void diW()
  {
    AppMethodBeat.i(76093);
    if (this.vte != null)
    {
      this.oQt.removeView((View)this.vte);
      this.vte = null;
    }
    AppMethodBeat.o(76093);
  }
  
  public final void diX()
  {
    AppMethodBeat.i(76095);
    if (this.vtd != null) {
      this.oQt.removeView((View)this.vtd);
    }
    this.vtd = null;
    AppMethodBeat.o(76095);
  }
  
  public final boolean diY()
  {
    return this.vtc != null;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76111);
    if (!this.vtk)
    {
      AppMethodBeat.o(76111);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(76111);
    return bool;
  }
  
  public final void eO(List<? extends bmx> paramList)
  {
    AppMethodBeat.i(76094);
    k.h(paramList, "lyricsItemInfos");
    this.vtd = new e(getContext());
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.oQt.addView((View)this.vtd, (ViewGroup.LayoutParams)localObject1);
    localObject1 = this.vtd;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      localObject2 = com.tencent.mm.plugin.recordvideo.background.f.dgJ();
      com.tencent.mm.plugin.recordvideo.background.f localf = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      ((e)localObject1).setSafeArea$27eda001((Rect)localObject2);
    }
    localObject1 = this.vtd;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      ((e)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.f.dgK());
    }
    localObject1 = this.vtd;
    if (localObject1 != null) {
      d.a.a((d)localObject1, this.vsQ);
    }
    localObject1 = this.vtd;
    if (localObject1 != null) {
      ((e)localObject1).setStateResolve((b)this.vtl);
    }
    localObject1 = this.vtd;
    if (localObject1 != null)
    {
      ((e)localObject1).eP(paramList);
      AppMethodBeat.o(76094);
      return;
    }
    AppMethodBeat.o(76094);
  }
  
  public final boolean fYt()
  {
    return this.vtd != null;
  }
  
  public final boolean fYu()
  {
    return this.vte != null;
  }
  
  public final List<com.tencent.mm.media.editor.a.h> getAllItemViews()
  {
    AppMethodBeat.i(76102);
    List localList = (List)new ArrayList();
    int i = 0;
    int j = this.oQt.getChildCount();
    while (i < j)
    {
      View localView = this.oQt.getChildAt(i);
      if ((localView instanceof com.tencent.mm.media.editor.a.h)) {
        localList.add(localView);
      }
      i += 1;
    }
    AppMethodBeat.o(76102);
    return localList;
  }
  
  public final b<Boolean, y> getDeleteStateListener()
  {
    return this.vsZ;
  }
  
  public final Rect getDisplayArea()
  {
    return this.vsQ;
  }
  
  public final b<View, y> getItemChangeListener()
  {
    return this.vta;
  }
  
  public final ViewGroup getItemLayout()
  {
    return this.oQt;
  }
  
  public final int getLocationItemHeight()
  {
    AppMethodBeat.i(76106);
    Object localObject = this.vtc;
    if (localObject != null)
    {
      localObject = ((f)localObject).getBitmap();
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
  
  public final f getLocationView()
  {
    return this.vtc;
  }
  
  public final e getLyricsView()
  {
    return this.vtd;
  }
  
  public final h getTipItemView()
  {
    return this.vte;
  }
  
  public final void iY(List<? extends bmx> paramList)
  {
    AppMethodBeat.i(204317);
    k.h(paramList, "lyricsItemInfos");
    if (this.vtd == null)
    {
      AppMethodBeat.o(204317);
      return;
    }
    diX();
    eO(paramList);
    AppMethodBeat.o(204317);
  }
  
  public final boolean lL(int paramInt)
  {
    AppMethodBeat.i(76092);
    Object localObject = this.vsS.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(76092);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(getContext(), 32) + paramInt);
    this.vsS.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(76092);
    return true;
  }
  
  public final void n(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204315);
    g localg = new g(getContext());
    Object localObject = this.vcC;
    if (localObject != null)
    {
      localObject = ((RecordConfigProvider)localObject).vhI;
      if (localObject != null) {
        localg.U(((UICustomParam)localObject).fGP, ((UICustomParam)localObject).fGQ);
      }
    }
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.oQt.addView((View)localg, (ViewGroup.LayoutParams)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    localObject = com.tencent.mm.plugin.recordvideo.background.f.dgJ();
    com.tencent.mm.plugin.recordvideo.background.f localf = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    localg.b((Rect)localObject, com.tencent.mm.plugin.recordvideo.background.f.dgL());
    localObject = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    localg.setValidArea(com.tencent.mm.plugin.recordvideo.background.f.dgK());
    localg.a(this.vsQ, this.heightPercent);
    localg.setStateResolve((b)this.vtl);
    localg.setText(paramCharSequence, paramInt1, paramInt2);
    localg.setOnClickListener(this.vtg);
    s((View)localg, true);
    removeCallbacks(this.oQz);
    postDelayed(this.oQz, 1500L);
    diV();
    AppMethodBeat.o(204315);
  }
  
  public final void o(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204316);
    if ((paramCharSequence == null) || (n.aC(paramCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(204316);
      return;
    }
    this.vte = new h(getContext());
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    this.oQt.addView((View)this.vte, (ViewGroup.LayoutParams)localObject1);
    localObject1 = this.vte;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      localObject2 = com.tencent.mm.plugin.recordvideo.background.f.dgJ();
      com.tencent.mm.plugin.recordvideo.background.f localf = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      ((h)localObject1).b((Rect)localObject2, com.tencent.mm.plugin.recordvideo.background.f.dgL());
    }
    localObject1 = this.vte;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      ((h)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.f.dgK());
    }
    localObject1 = this.vte;
    if (localObject1 != null) {
      d.a.a((d)localObject1, this.vsQ);
    }
    localObject1 = this.vte;
    if (localObject1 != null) {
      ((h)localObject1).setStateResolve((b)this.vtl);
    }
    localObject1 = this.vte;
    if (localObject1 != null) {
      ((h)localObject1).a(paramCharSequence, paramInt1, paramInt2, getLocationItemHeight());
    }
    paramCharSequence = this.vte;
    if (paramCharSequence != null)
    {
      paramCharSequence.setOnClickListener(this.vth);
      AppMethodBeat.o(204316);
      return;
    }
    AppMethodBeat.o(204316);
  }
  
  public final void onScroll(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(204323);
    int j = this.oQt.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.oQt.getChildAt(i);
      if ((localView instanceof c))
      {
        ((c)localView).getTouchTracker().dY.postTranslate(paramFloat1, paramFloat2);
        localView.invalidate();
      }
      if ((localView instanceof g))
      {
        ((g)localView).getTouchTracker().dY.postTranslate(paramFloat1, paramFloat2);
        localView.invalidate();
      }
      i += 1;
    }
    AppMethodBeat.o(204323);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(76090);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ad.i("MicroMsg.EditorItemContainer", "onSizeChanged, w:" + paramInt1 + ", h:" + paramInt2);
    this.vsQ.set(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(76090);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76091);
    k.h(paramMotionEvent, "event");
    if ((paramMotionEvent.getActionMasked() == 0) && (this.vtb != null))
    {
      View localView = this.vtb;
      if (localView == null) {
        k.fvU();
      }
      s(localView, false);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(76091);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(204319);
    int j = this.oQt.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.oQt.getChildAt(i);
      if ((localView instanceof c)) {
        ((c)localView).pause();
      }
      i += 1;
    }
    AppMethodBeat.o(204319);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(76105);
    this.vtc = null;
    this.vte = null;
    this.vtd = null;
    this.oQt.removeAllViews();
    AppMethodBeat.o(76105);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(204320);
    int j = this.oQt.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.oQt.getChildAt(i);
      if (((localView instanceof c)) && (!this.vsX)) {
        ((c)localView).resume();
      }
      i += 1;
    }
    AppMethodBeat.o(204320);
  }
  
  public final void s(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(76103);
    k.h(paramView, "itemView");
    if (paramBoolean) {
      if ((k.g(paramView, this.vtb) ^ true))
      {
        View localView = this.vtb;
        if (localView != null) {
          localView.setActivated(false);
        }
        this.vtb = paramView;
      }
    }
    for (;;)
    {
      paramView.setActivated(paramBoolean);
      AppMethodBeat.o(76103);
      return;
      if (k.g(paramView, this.vtb)) {
        this.vtb = null;
      }
    }
  }
  
  public final void setDeleteStateListener(b<? super Boolean, y> paramb)
  {
    this.vsZ = paramb;
  }
  
  public final void setEnableTouch(boolean paramBoolean)
  {
    this.vtk = paramBoolean;
  }
  
  public final void setItemChangeListener(b<? super View, y> paramb)
  {
    this.vta = paramb;
  }
  
  public final void setLocationView(f paramf)
  {
    this.vtc = paramf;
  }
  
  public final void setLyricsView(e parame)
  {
    this.vtd = parame;
  }
  
  public final void setOnLocationClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76098);
    k.h(paramOnClickListener, "locationClickListener");
    this.vtf = paramOnClickListener;
    AppMethodBeat.o(76098);
  }
  
  public final void setOnLyricsClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76101);
    k.h(paramOnClickListener, "lyricsClickListener");
    this.vti = paramOnClickListener;
    AppMethodBeat.o(76101);
  }
  
  public final void setOnTextClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76099);
    k.h(paramOnClickListener, "textClickListener");
    this.vtg = paramOnClickListener;
    AppMethodBeat.o(76099);
  }
  
  public final void setOnTipClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76100);
    k.h(paramOnClickListener, "tipClickListener");
    this.vth = paramOnClickListener;
    AppMethodBeat.o(76100);
  }
  
  public final void setSafeType(int paramInt)
  {
    this.vtj = paramInt;
    if (this.vtj == 0) {
      this.heightPercent = 0.7F;
    }
    while (this.vtj != 1) {
      return;
    }
    this.heightPercent = 0.5F;
  }
  
  public final void setTipItemView(h paramh)
  {
    this.vte = paramh;
  }
  
  public final void y(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(76097);
    if (this.vtc != null) {
      this.oQt.removeView((View)this.vtc);
    }
    this.vtc = null;
    if (parama != null)
    {
      parama.invoke();
      AppMethodBeat.o(76097);
      return;
    }
    AppMethodBeat.o(76097);
  }
  
  public final void yZ(boolean paramBoolean)
  {
    AppMethodBeat.i(204312);
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.vsX = bool;
      if (!paramBoolean) {
        break;
      }
      resume();
      AppMethodBeat.o(204312);
      return;
    }
    pause();
    AppMethodBeat.o(204312);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$Companion;", "", "()V", "ClearActiveDelay", "", "DEFAULT", "", "JUMP_BACK", "SAFE_LINE", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"})
  public static abstract interface b
  {
    public abstract void c(View paramView, MotionEvent paramMotionEvent);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(EditorItemContainer paramEditorItemContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(76085);
      if (EditorItemContainer.a(this.vtn) != null)
      {
        EditorItemContainer localEditorItemContainer = this.vtn;
        View localView = EditorItemContainer.a(this.vtn);
        if (localView == null) {
          k.fvU();
        }
        localEditorItemContainer.s(localView, false);
      }
      AppMethodBeat.o(76085);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"})
  public static final class d
    implements EditorItemContainer.b
  {
    public final void c(final View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(76087);
      k.h(paramView, "itemView");
      k.h(paramMotionEvent, "event");
      if (EditorItemContainer.c(this.vtn)) {
        EditorItemContainer.d(this.vtn);
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
          this.vtn.removeCallbacks(EditorItemContainer.e(this.vtn));
          paramMotionEvent = ((d)paramView).getContentBoundary();
          float f1 = (paramMotionEvent[0] + paramMotionEvent[2]) / 2.0F;
          float f2 = paramMotionEvent[1];
          paramView.setTag(new Float[] { Float.valueOf(f1), Float.valueOf((paramMotionEvent[3] + f2) / 2.0F) });
          if (EditorItemContainer.eh(paramView))
          {
            this.vtn.s(paramView, false);
            AppMethodBeat.o(76087);
            return;
          }
          this.vtn.s(paramView, true);
          AppMethodBeat.o(76087);
          return;
          if (!EditorItemContainer.a(this.vtn, paramView)) {
            EditorItemContainer.b(this.vtn, paramView);
          }
        } while (EditorItemContainer.ei(paramView));
        EditorItemContainer.a(this.vtn, paramView, paramMotionEvent);
        EditorItemContainer.a(this.vtn, true);
        AppMethodBeat.o(76087);
        return;
      }
      if (EditorItemContainer.f(this.vtn) != null) {
        this.vtn.post((Runnable)new a(this, paramView));
      }
      for (;;)
      {
        EditorItemContainer.a(this.vtn, false);
        EditorItemContainer.i(this.vtn);
        EditorItemContainer.j(this.vtn);
        EditorItemContainer.k(this.vtn);
        EditorItemContainer.l(this.vtn);
        break;
        if (EditorItemContainer.a(this.vtn) != null) {
          this.vtn.postDelayed(EditorItemContainer.e(this.vtn), 1500L);
        }
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(EditorItemContainer.d paramd, View paramView) {}
      
      public final void run()
      {
        AppMethodBeat.i(76086);
        EditorItemContainer.h(this.vto.vtn).removeView(EditorItemContainer.f(this.vto.vtn));
        b localb = this.vto.vtn.getItemChangeListener();
        if (localb != null) {
          localb.aA(EditorItemContainer.f(this.vto.vtn));
        }
        EditorItemContainer.g(this.vto.vtn);
        EditorItemContainer.b(this.vto.vtn);
        if ((paramView instanceof f))
        {
          this.vto.vtn.setLocationView(null);
          AppMethodBeat.o(76086);
          return;
        }
        if ((paramView instanceof e))
        {
          this.vto.vtn.setLyricsView(null);
          AppMethodBeat.o(76086);
          return;
        }
        if ((paramView instanceof h)) {
          this.vto.vtn.setTipItemView(null);
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