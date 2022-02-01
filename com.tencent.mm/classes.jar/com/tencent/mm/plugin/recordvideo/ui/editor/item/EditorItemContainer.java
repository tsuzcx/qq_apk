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
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.widget.cropview.CropLayout.b;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer;", "Lcom/tencent/mm/emoji/view/InsectRelativeLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameView;", "clearActive", "Ljava/lang/Runnable;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "currActiveItem", "Landroid/view/View;", "deleteStateListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "showDelete", "", "getDeleteStateListener", "()Lkotlin/jvm/functions/Function1;", "setDeleteStateListener", "(Lkotlin/jvm/functions/Function1;)V", "deleteView", "Landroid/widget/TextView;", "deleteViewGroup", "Landroid/view/ViewGroup;", "deleteViewIcon", "Landroid/widget/ImageView;", "deletingItem", "displayArea", "Landroid/graphics/Rect;", "getDisplayArea", "()Landroid/graphics/Rect;", "enableTouch", "forceStaticImage", "heightPercent", "", "itemChangeListener", "itemView", "getItemChangeListener", "setItemChangeListener", "itemLayout", "itemStateResolve", "com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1;", "leftFrame", "locationClickListener", "Landroid/view/View$OnClickListener;", "locationView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "getLocationView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "setLocationView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;)V", "lyricsClickListener", "lyricsView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "getLyricsView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "setLyricsView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;)V", "rightFrame", "safeType", "textClickListener", "tipClickListener", "tipItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "getTipItemView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "setTipItemView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;)V", "topFrame", "activeDeleteView", "active", "addEmojiItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "addLocationItem", "sl", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "addLyricsItem", "lyricsItemInfos", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "addTextItem", "text", "", "textColor", "textBgColor", "addTipItem", "bringItemsToFront", "checkAddLocationItem", "checkLyricsItem", "checkTipItem", "deleteCheck", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "enableGif", "enable", "frameCheck", "getAllItemViews", "Lcom/tencent/mm/media/editor/item/IEditable;", "getItemLayout", "getLocationItemHeight", "initConfig", "initHeightSafeArea", "safeHeight", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "onScale", "scaleFactor", "focusX", "focusY", "onScroll", "distanceX", "distanceY", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pause", "removeLocationView", "callback", "Lkotlin/Function0;", "removeLyricsView", "removeTextItem", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "removeTipItem", "replaceLocationView", "replaceLyricsItem", "replaceTipView", "requestEditing", "editing", "reset", "resume", "setEnableTouch", "setOnLocationClick", "setOnLyricsClick", "setOnTextClick", "setOnTipClick", "setSafeType", "type", "showBottomFrame", "isShow", "showLeftFrame", "showRightFrame", "showTopFrame", "skipDeleteCheck", "skipFrameCheck", "skipRequestEditing", "toggleDeleteView", "show", "updateValidArea", "validRect", "Companion", "ItemStateResolve", "plugin-recordvideo_release"})
public final class EditorItemContainer
  extends InsectRelativeLayout
  implements CropLayout.b
{
  public static final EditorItemContainer.a wDm;
  private float heightPercent;
  private TextView ptF;
  public final ViewGroup ptG;
  private Runnable ptM;
  private RecordConfigProvider rRi;
  public final Rect wCQ;
  private ImageView wCR;
  private ViewGroup wCS;
  private EditorFrameView wCT;
  private EditorFrameView wCU;
  private EditorFrameView wCV;
  private EditorFrameView wCW;
  private boolean wCX;
  private View wCY;
  private b<? super Boolean, y> wCZ;
  private b<? super View, y> wDa;
  private View wDb;
  public f wDc;
  private e wDd;
  public h wDe;
  private View.OnClickListener wDf;
  private View.OnClickListener wDg;
  public View.OnClickListener wDh;
  private View.OnClickListener wDi;
  private int wDj;
  private boolean wDk;
  public final d wDl;
  
  static
  {
    AppMethodBeat.i(76114);
    wDm = new EditorItemContainer.a((byte)0);
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
    this.wCQ = new Rect();
    this.ptM = ((Runnable)new c(this));
    this.heightPercent = 0.5F;
    this.wDk = true;
    View.inflate(paramContext, 2131495665, (ViewGroup)this);
    paramContext = findViewById(2131299294);
    k.g(paramContext, "findViewById(R.id.editor_item_layout)");
    this.ptG = ((ViewGroup)paramContext);
    paramContext = findViewById(2131299290);
    k.g(paramContext, "findViewById(R.id.editor_delete_view)");
    this.ptF = ((TextView)paramContext);
    paramContext = findViewById(2131299292);
    k.g(paramContext, "findViewById(R.id.editor_delete_view_icon)");
    this.wCR = ((ImageView)paramContext);
    paramContext = findViewById(2131299291);
    k.g(paramContext, "findViewById(R.id.editor_delete_view_group)");
    this.wCS = ((ViewGroup)paramContext);
    paramContext = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    paramContext = com.tencent.mm.plugin.recordvideo.background.g.dur();
    paramAttributeSet = getResources();
    k.g(paramAttributeSet, "resources");
    paramInt = paramAttributeSet.getDisplayMetrics().widthPixels;
    paramAttributeSet = getResources();
    k.g(paramAttributeSet, "resources");
    paramContext.set(0, 0, paramInt, paramAttributeSet.getDisplayMetrics().heightPixels);
    this.wDl = new d(this);
    AppMethodBeat.o(76112);
  }
  
  private final void dwR()
  {
    AppMethodBeat.i(76089);
    Object localObject;
    if (this.wDe != null)
    {
      localObject = this.wDe;
      if (localObject != null) {
        ((h)localObject).bringToFront();
      }
    }
    if (this.wDc != null)
    {
      localObject = this.wDc;
      if (localObject != null) {
        ((f)localObject).bringToFront();
      }
    }
    if (this.wDd != null)
    {
      localObject = this.wDd;
      if (localObject != null)
      {
        ((e)localObject).bringToFront();
        AppMethodBeat.o(76089);
        return;
      }
    }
    AppMethodBeat.o(76089);
  }
  
  private final void kz(boolean paramBoolean)
  {
    AppMethodBeat.i(76104);
    this.wCS.setActivated(paramBoolean);
    if (paramBoolean)
    {
      this.ptF.setText(2131758185);
      this.wCR.setImageDrawable(am.k(getContext(), 2131690385, -1));
      AppMethodBeat.o(76104);
      return;
    }
    this.ptF.setText(2131758184);
    this.wCR.setImageDrawable(am.k(getContext(), 2131690384, -1));
    AppMethodBeat.o(76104);
  }
  
  private final void pE(boolean paramBoolean)
  {
    AppMethodBeat.i(76107);
    EditorFrameView localEditorFrameView = this.wCT;
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
  
  private final void pF(boolean paramBoolean)
  {
    AppMethodBeat.i(76108);
    EditorFrameView localEditorFrameView = this.wCU;
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
  
  private final void pG(boolean paramBoolean)
  {
    AppMethodBeat.i(76109);
    EditorFrameView localEditorFrameView = this.wCV;
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
  
  private final void pH(boolean paramBoolean)
  {
    AppMethodBeat.i(76110);
    EditorFrameView localEditorFrameView = this.wCW;
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
  
  public final void C(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(199436);
    k.h(paramEmojiInfo, "emojiInfo");
    c localc = new c(getContext(), false);
    Object localObject = this.rRi;
    if (localObject != null)
    {
      localObject = ((RecordConfigProvider)localObject).wqu;
      if (localObject != null) {
        localc.Y(((UICustomParam)localObject).fKu, ((UICustomParam)localObject).fKv);
      }
    }
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.ptG.addView((View)localc, (ViewGroup.LayoutParams)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    localObject = com.tencent.mm.plugin.recordvideo.background.g.dur();
    com.tencent.mm.plugin.recordvideo.background.g localg = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    localc.b((Rect)localObject, com.tencent.mm.plugin.recordvideo.background.g.dut());
    localObject = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    localc.setValidArea(com.tencent.mm.plugin.recordvideo.background.g.dus());
    d.a.a(localc, this.wCQ);
    localc.setStateResolve((b)this.wDl);
    localc.setEmojiInfo(paramEmojiInfo);
    localc.resume();
    if (this.wCX) {
      localc.pause();
    }
    s((View)localc, true);
    removeCallbacks(this.ptM);
    postDelayed(this.ptM, 1500L);
    dwR();
    AppMethodBeat.o(199436);
  }
  
  public final void E(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(76097);
    if (this.wDc != null) {
      this.ptG.removeView((View)this.wDc);
    }
    this.wDc = null;
    if (parama != null)
    {
      parama.invoke();
      AppMethodBeat.o(76097);
      return;
    }
    AppMethodBeat.o(76097);
  }
  
  public final void V(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(199441);
    Object localObject = getContext();
    k.g(localObject, "context");
    this.wCT = new EditorFrameView((Context)localObject);
    localObject = this.wCT;
    if (localObject != null) {
      ((EditorFrameView)localObject).setPosition(com.tencent.mm.plugin.recordvideo.ui.editor.a.wBg);
    }
    localObject = this.wCT;
    if (localObject != null) {
      ((EditorFrameView)localObject).setVisibility(4);
    }
    localObject = new RelativeLayout.LayoutParams((int)paramFloat2, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(20);
    addView((View)this.wCT, (ViewGroup.LayoutParams)localObject);
    localObject = getContext();
    k.g(localObject, "context");
    this.wCV = new EditorFrameView((Context)localObject);
    localObject = this.wCV;
    if (localObject != null) {
      ((EditorFrameView)localObject).setPosition(com.tencent.mm.plugin.recordvideo.ui.editor.a.wBi);
    }
    localObject = this.wCV;
    if (localObject != null) {
      ((EditorFrameView)localObject).setVisibility(4);
    }
    localObject = new RelativeLayout.LayoutParams((int)paramFloat2, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(21);
    addView((View)this.wCV, (ViewGroup.LayoutParams)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    com.tencent.mm.plugin.recordvideo.background.g.dur().left = ((int)paramFloat2);
    localObject = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    com.tencent.mm.plugin.recordvideo.background.g.dur().right = ((int)paramFloat2 + (int)paramFloat1);
    localObject = new StringBuilder("logStory: initWidthSafeArea safeAreaRect:");
    com.tencent.mm.plugin.recordvideo.background.g localg = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    ac.i("MicroMsg.EditorItemContainer", com.tencent.mm.plugin.recordvideo.background.g.dur());
    AppMethodBeat.o(199441);
  }
  
  public final void W(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(199442);
    Object localObject = getContext();
    k.g(localObject, "context");
    this.wCU = new EditorFrameView((Context)localObject);
    localObject = this.wCU;
    if (localObject != null) {
      ((EditorFrameView)localObject).setPosition(com.tencent.mm.plugin.recordvideo.ui.editor.a.wBh);
    }
    localObject = this.wCU;
    if (localObject != null) {
      ((EditorFrameView)localObject).setVisibility(4);
    }
    localObject = new RelativeLayout.LayoutParams(-1, (int)paramFloat2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    addView((View)this.wCU, (ViewGroup.LayoutParams)localObject);
    localObject = getContext();
    k.g(localObject, "context");
    this.wCW = new EditorFrameView((Context)localObject);
    localObject = this.wCW;
    if (localObject != null) {
      ((EditorFrameView)localObject).setPosition(com.tencent.mm.plugin.recordvideo.ui.editor.a.wBj);
    }
    localObject = this.wCW;
    if (localObject != null) {
      ((EditorFrameView)localObject).setVisibility(4);
    }
    localObject = new RelativeLayout.LayoutParams(-1, (int)paramFloat2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    addView((View)this.wCW, (ViewGroup.LayoutParams)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    com.tencent.mm.plugin.recordvideo.background.g.dur().top = ((int)paramFloat2);
    localObject = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    com.tencent.mm.plugin.recordvideo.background.g.dur().bottom = ((int)paramFloat2 + (int)paramFloat1);
    localObject = new StringBuilder("logStory: initHeightSafeArea safeAreaRect:");
    com.tencent.mm.plugin.recordvideo.background.g localg = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    ac.i("MicroMsg.EditorItemContainer", com.tencent.mm.plugin.recordvideo.background.g.dur());
    AppMethodBeat.o(199442);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(199435);
    k.h(paramRecordConfigProvider, "configProvider");
    this.rRi = paramRecordConfigProvider;
    AppMethodBeat.o(199435);
  }
  
  public final void a(cna paramcna)
  {
    AppMethodBeat.i(76096);
    k.h(paramcna, "sl");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject1 = getContext();
    k.g(localObject1, "context");
    this.wDc = new f((Context)localObject1);
    localObject1 = this.wDc;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.background.g.wmx;
      localObject2 = com.tencent.mm.plugin.recordvideo.background.g.dur();
      com.tencent.mm.plugin.recordvideo.background.g localg = com.tencent.mm.plugin.recordvideo.background.g.wmx;
      ((f)localObject1).b((Rect)localObject2, com.tencent.mm.plugin.recordvideo.background.g.dut());
    }
    localObject1 = this.wDc;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.background.g.wmx;
      ((f)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.g.dus());
    }
    localObject1 = this.wDc;
    if (localObject1 != null) {
      ((f)localObject1).a(this.wCQ, this.heightPercent);
    }
    localObject1 = this.wDc;
    if (localObject1 != null) {
      ((f)localObject1).setLocation(paramcna);
    }
    paramcna = this.wDc;
    if (paramcna != null) {
      paramcna.setStateResolve((b)this.wDl);
    }
    paramcna = this.wDc;
    if (paramcna != null) {
      paramcna.setOnClickListener(this.wDf);
    }
    this.ptG.addView((View)this.wDc, (ViewGroup.LayoutParams)localLayoutParams);
    paramcna = this.wDc;
    if (paramcna == null) {
      k.fOy();
    }
    s((View)paramcna, false);
    removeCallbacks(this.ptM);
    postDelayed(this.ptM, 1500L);
    AppMethodBeat.o(76096);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76111);
    if (!this.wDk)
    {
      AppMethodBeat.o(76111);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(76111);
    return bool;
  }
  
  public final void dwS()
  {
    AppMethodBeat.i(76093);
    if (this.wDe != null)
    {
      this.ptG.removeView((View)this.wDe);
      this.wDe = null;
    }
    AppMethodBeat.o(76093);
  }
  
  public final boolean dwT()
  {
    return this.wDd != null;
  }
  
  public final void dwU()
  {
    AppMethodBeat.i(76095);
    if (this.wDd != null) {
      this.ptG.removeView((View)this.wDd);
    }
    this.wDd = null;
    AppMethodBeat.o(76095);
  }
  
  public final boolean dwV()
  {
    return this.wDc != null;
  }
  
  public final void eT(List<? extends brn> paramList)
  {
    AppMethodBeat.i(199438);
    k.h(paramList, "lyricsItemInfos");
    if (this.wDd == null)
    {
      AppMethodBeat.o(199438);
      return;
    }
    dwU();
    eU(paramList);
    AppMethodBeat.o(199438);
  }
  
  public final void eU(List<? extends brn> paramList)
  {
    AppMethodBeat.i(76094);
    k.h(paramList, "lyricsItemInfos");
    this.wDd = new e(getContext());
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.ptG.addView((View)this.wDd, (ViewGroup.LayoutParams)localObject1);
    localObject1 = this.wDd;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.background.g.wmx;
      localObject2 = com.tencent.mm.plugin.recordvideo.background.g.dur();
      com.tencent.mm.plugin.recordvideo.background.g localg = com.tencent.mm.plugin.recordvideo.background.g.wmx;
      ((e)localObject1).setSafeArea$27eda001((Rect)localObject2);
    }
    localObject1 = this.wDd;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.background.g.wmx;
      ((e)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.g.dus());
    }
    localObject1 = this.wDd;
    if (localObject1 != null) {
      d.a.a((d)localObject1, this.wCQ);
    }
    localObject1 = this.wDd;
    if (localObject1 != null) {
      ((e)localObject1).setStateResolve((b)this.wDl);
    }
    localObject1 = this.wDd;
    if (localObject1 != null)
    {
      ((e)localObject1).eV(paramList);
      AppMethodBeat.o(76094);
      return;
    }
    AppMethodBeat.o(76094);
  }
  
  public final List<com.tencent.mm.media.editor.a.h> getAllItemViews()
  {
    AppMethodBeat.i(76102);
    List localList = (List)new ArrayList();
    int i = 0;
    int j = this.ptG.getChildCount();
    while (i < j)
    {
      View localView = this.ptG.getChildAt(i);
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
    return this.wCZ;
  }
  
  public final Rect getDisplayArea()
  {
    return this.wCQ;
  }
  
  public final b<View, y> getItemChangeListener()
  {
    return this.wDa;
  }
  
  public final ViewGroup getItemLayout()
  {
    return this.ptG;
  }
  
  public final int getLocationItemHeight()
  {
    AppMethodBeat.i(76106);
    Object localObject = this.wDc;
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
    return this.wDc;
  }
  
  public final e getLyricsView()
  {
    return this.wDd;
  }
  
  public final h getTipItemView()
  {
    return this.wDe;
  }
  
  public final void k(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199437);
    g localg = new g(getContext());
    Object localObject = this.rRi;
    if (localObject != null)
    {
      localObject = ((RecordConfigProvider)localObject).wqu;
      if (localObject != null) {
        localg.Y(((UICustomParam)localObject).fKw, ((UICustomParam)localObject).fKx);
      }
    }
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.ptG.addView((View)localg, (ViewGroup.LayoutParams)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    localObject = com.tencent.mm.plugin.recordvideo.background.g.dur();
    com.tencent.mm.plugin.recordvideo.background.g localg1 = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    localg.b((Rect)localObject, com.tencent.mm.plugin.recordvideo.background.g.dut());
    localObject = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    localg.setValidArea(com.tencent.mm.plugin.recordvideo.background.g.dus());
    localg.a(this.wCQ, this.heightPercent);
    localg.setStateResolve((b)this.wDl);
    localg.setText(paramCharSequence, paramInt1, paramInt2);
    localg.setOnClickListener(this.wDg);
    s((View)localg, true);
    removeCallbacks(this.ptM);
    postDelayed(this.ptM, 1500L);
    dwR();
    AppMethodBeat.o(199437);
  }
  
  public final void l(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(199444);
    int j = this.ptG.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.ptG.getChildAt(i);
      if ((localView instanceof c))
      {
        ((c)localView).getTouchTracker().eY.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
        localView.invalidate();
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof g))
        {
          ((g)localView).getTouchTracker().eY.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
          localView.invalidate();
        }
      }
    }
    AppMethodBeat.o(199444);
  }
  
  public final boolean lH(int paramInt)
  {
    AppMethodBeat.i(76092);
    Object localObject = this.wCS.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(76092);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cc.a.fromDPToPix(getContext(), 32) + paramInt);
    this.wCS.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(76092);
    return true;
  }
  
  public final void onScroll(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(199443);
    int j = this.ptG.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.ptG.getChildAt(i);
      if ((localView instanceof c))
      {
        ((c)localView).getTouchTracker().eY.postTranslate(paramFloat1, paramFloat2);
        localView.invalidate();
      }
      if ((localView instanceof g))
      {
        ((g)localView).getTouchTracker().eY.postTranslate(paramFloat1, paramFloat2);
        localView.invalidate();
      }
      i += 1;
    }
    AppMethodBeat.o(199443);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(76090);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ac.i("MicroMsg.EditorItemContainer", "onSizeChanged, w:" + paramInt1 + ", h:" + paramInt2);
    this.wCQ.set(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(76090);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76091);
    k.h(paramMotionEvent, "event");
    if ((paramMotionEvent.getActionMasked() == 0) && (this.wDb != null))
    {
      View localView = this.wDb;
      if (localView == null) {
        k.fOy();
      }
      s(localView, false);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(76091);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(199439);
    int j = this.ptG.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.ptG.getChildAt(i);
      if ((localView instanceof c)) {
        ((c)localView).pause();
      }
      i += 1;
    }
    AppMethodBeat.o(199439);
  }
  
  public final void pn(boolean paramBoolean)
  {
    AppMethodBeat.i(199434);
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.wCX = bool;
      if (!paramBoolean) {
        break;
      }
      resume();
      AppMethodBeat.o(199434);
      return;
    }
    pause();
    AppMethodBeat.o(199434);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(76105);
    this.wDc = null;
    this.wDe = null;
    this.wDd = null;
    this.ptG.removeAllViews();
    AppMethodBeat.o(76105);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(199440);
    int j = this.ptG.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.ptG.getChildAt(i);
      if (((localView instanceof c)) && (!this.wCX)) {
        ((c)localView).resume();
      }
      i += 1;
    }
    AppMethodBeat.o(199440);
  }
  
  public final void s(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(76103);
    k.h(paramView, "itemView");
    if (paramBoolean) {
      if ((k.g(paramView, this.wDb) ^ true))
      {
        View localView = this.wDb;
        if (localView != null) {
          localView.setActivated(false);
        }
        this.wDb = paramView;
      }
    }
    for (;;)
    {
      paramView.setActivated(paramBoolean);
      AppMethodBeat.o(76103);
      return;
      if (k.g(paramView, this.wDb)) {
        this.wDb = null;
      }
    }
  }
  
  public final void setDeleteStateListener(b<? super Boolean, y> paramb)
  {
    this.wCZ = paramb;
  }
  
  public final void setEnableTouch(boolean paramBoolean)
  {
    this.wDk = paramBoolean;
  }
  
  public final void setItemChangeListener(b<? super View, y> paramb)
  {
    this.wDa = paramb;
  }
  
  public final void setLocationView(f paramf)
  {
    this.wDc = paramf;
  }
  
  public final void setLyricsView(e parame)
  {
    this.wDd = parame;
  }
  
  public final void setOnLocationClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76098);
    k.h(paramOnClickListener, "locationClickListener");
    this.wDf = paramOnClickListener;
    AppMethodBeat.o(76098);
  }
  
  public final void setOnLyricsClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76101);
    k.h(paramOnClickListener, "lyricsClickListener");
    this.wDi = paramOnClickListener;
    AppMethodBeat.o(76101);
  }
  
  public final void setOnTextClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76099);
    k.h(paramOnClickListener, "textClickListener");
    this.wDg = paramOnClickListener;
    AppMethodBeat.o(76099);
  }
  
  public final void setOnTipClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(76100);
    k.h(paramOnClickListener, "tipClickListener");
    this.wDh = paramOnClickListener;
    AppMethodBeat.o(76100);
  }
  
  public final void setSafeType(int paramInt)
  {
    this.wDj = paramInt;
    if (this.wDj == 0) {
      this.heightPercent = 0.7F;
    }
    while (this.wDj != 1) {
      return;
    }
    this.heightPercent = 0.5F;
  }
  
  public final void setTipItemView(h paramh)
  {
    this.wDe = paramh;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"})
  public static abstract interface b
  {
    public abstract void c(View paramView, MotionEvent paramMotionEvent);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(EditorItemContainer paramEditorItemContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(76085);
      if (EditorItemContainer.a(this.wDn) != null)
      {
        EditorItemContainer localEditorItemContainer = this.wDn;
        View localView = EditorItemContainer.a(this.wDn);
        if (localView == null) {
          k.fOy();
        }
        localEditorItemContainer.s(localView, false);
      }
      AppMethodBeat.o(76085);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"})
  public static final class d
    implements EditorItemContainer.b
  {
    public final void c(final View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(76087);
      k.h(paramView, "itemView");
      k.h(paramMotionEvent, "event");
      if (EditorItemContainer.c(this.wDn)) {
        EditorItemContainer.d(this.wDn);
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
          this.wDn.removeCallbacks(EditorItemContainer.e(this.wDn));
          paramMotionEvent = ((d)paramView).getContentBoundary();
          float f1 = (paramMotionEvent[0] + paramMotionEvent[2]) / 2.0F;
          float f2 = paramMotionEvent[1];
          paramView.setTag(new Float[] { Float.valueOf(f1), Float.valueOf((paramMotionEvent[3] + f2) / 2.0F) });
          if (EditorItemContainer.eq(paramView))
          {
            this.wDn.s(paramView, false);
            AppMethodBeat.o(76087);
            return;
          }
          this.wDn.s(paramView, true);
          AppMethodBeat.o(76087);
          return;
          if (!EditorItemContainer.a(this.wDn, paramView)) {
            EditorItemContainer.b(this.wDn, paramView);
          }
        } while (EditorItemContainer.er(paramView));
        EditorItemContainer.a(this.wDn, paramView, paramMotionEvent);
        EditorItemContainer.a(this.wDn, true);
        AppMethodBeat.o(76087);
        return;
      }
      if (EditorItemContainer.f(this.wDn) != null) {
        this.wDn.post((Runnable)new a(this, paramView));
      }
      for (;;)
      {
        EditorItemContainer.a(this.wDn, false);
        EditorItemContainer.i(this.wDn);
        EditorItemContainer.j(this.wDn);
        EditorItemContainer.k(this.wDn);
        EditorItemContainer.l(this.wDn);
        break;
        if (EditorItemContainer.a(this.wDn) != null) {
          this.wDn.postDelayed(EditorItemContainer.e(this.wDn), 1500L);
        }
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(EditorItemContainer.d paramd, View paramView) {}
      
      public final void run()
      {
        AppMethodBeat.i(76086);
        EditorItemContainer.h(this.wDo.wDn).removeView(EditorItemContainer.f(this.wDo.wDn));
        b localb = this.wDo.wDn.getItemChangeListener();
        if (localb != null) {
          localb.ay(EditorItemContainer.f(this.wDo.wDn));
        }
        EditorItemContainer.g(this.wDo.wDn);
        EditorItemContainer.b(this.wDo.wDn);
        if ((paramView instanceof f))
        {
          this.wDo.wDn.setLocationView(null);
          AppMethodBeat.o(76086);
          return;
        }
        if ((paramView instanceof e))
        {
          this.wDo.wDn.setLyricsView(null);
          AppMethodBeat.o(76086);
          return;
        }
        if ((paramView instanceof h)) {
          this.wDo.wDn.setTipItemView(null);
        }
        AppMethodBeat.o(76086);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer
 * JD-Core Version:    0.7.0.1
 */