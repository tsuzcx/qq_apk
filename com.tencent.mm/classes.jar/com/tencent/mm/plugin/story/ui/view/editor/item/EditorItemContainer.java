package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.mm.plugin.story.ui.view.editor.EditorFrameView;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aj;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer;", "Lcom/tencent/mm/emoji/view/InsectRelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomFrame", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorFrameView;", "clearActive", "Ljava/lang/Runnable;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "currActiveItem", "Landroid/view/View;", "deleteStateListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "showDelete", "", "getDeleteStateListener", "()Lkotlin/jvm/functions/Function1;", "setDeleteStateListener", "(Lkotlin/jvm/functions/Function1;)V", "deleteView", "Landroid/widget/TextView;", "deleteViewGroup", "Landroid/view/ViewGroup;", "deleteViewIcon", "Landroid/widget/ImageView;", "deletingItem", "enableTouch", "forceStaticImage", "heightPercent", "", "itemChangeListener", "Lkotlin/Function2;", "itemView", "isShow", "getItemChangeListener", "()Lkotlin/jvm/functions/Function2;", "setItemChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "itemLayout", "itemStateResolve", "com/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$itemStateResolve$1;", "leftFrame", "locationClickListener", "Landroid/view/View$OnClickListener;", "locationView", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/PositionItemView;", "getLocationView", "()Lcom/tencent/mm/plugin/story/ui/view/editor/item/PositionItemView;", "setLocationView", "(Lcom/tencent/mm/plugin/story/ui/view/editor/item/PositionItemView;)V", "lyricsClickListener", "lyricsView", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/LyricsItemView;", "getLyricsView", "()Lcom/tencent/mm/plugin/story/ui/view/editor/item/LyricsItemView;", "setLyricsView", "(Lcom/tencent/mm/plugin/story/ui/view/editor/item/LyricsItemView;)V", "rightFrame", "safeType", "textClickListener", "tipClickListener", "tipItemView", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/TipItemView;", "getTipItemView", "()Lcom/tencent/mm/plugin/story/ui/view/editor/item/TipItemView;", "setTipItemView", "(Lcom/tencent/mm/plugin/story/ui/view/editor/item/TipItemView;)V", "topFrame", "validArea", "Landroid/graphics/Rect;", "activeDeleteView", "active", "addEmojiItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "addLocationItem", "sl", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "addLyricsItem", "lyricsItemInfos", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "addTextItem", "text", "", "textColor", "textBgColor", "addTipItem", "bringItemsToFront", "checkAddLocationItem", "checkLyricsItem", "checkTipItem", "deleteCheck", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "frameCheck", "getAllItemViews", "Lcom/tencent/mm/media/editor/item/IEditable;", "getLocationItemHeight", "initConfig", "initHeightSafeArea", "safeHeight", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pause", "removeLocationView", "callback", "Lkotlin/Function0;", "removeLyricsView", "removeTextItem", "textItem", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/TextItemView;", "removeTipItem", "replaceLocationView", "replaceLyricsItem", "replaceTipView", "requestEditing", "editing", "reset", "resume", "setEnableTouch", "enable", "setOnLocationClick", "setOnLyricsClick", "setOnTextClick", "setOnTipClick", "setSafeType", "type", "showBottomFrame", "showLeftFrame", "showRightFrame", "showTopFrame", "skipDeleteCheck", "skipFrameCheck", "skipRequestEditing", "toggleDeleteView", "show", "Companion", "ItemStateResolve", "plugin-story_release"})
public final class EditorItemContainer
  extends InsectRelativeLayout
{
  public static final EditorItemContainer.a sQS;
  private float heightPercent;
  private TextView lzC;
  public final ViewGroup lzD;
  private Runnable lzI;
  public RecordConfigProvider qaF;
  private EditorFrameView sQA;
  private EditorFrameView sQB;
  private EditorFrameView sQC;
  private boolean sQD;
  private View sQE;
  private a.f.a.b<? super Boolean, y> sQF;
  private a.f.a.m<? super View, ? super Boolean, y> sQG;
  private View sQH;
  public f sQI;
  public d sQJ;
  private h sQK;
  private View.OnClickListener sQL;
  private View.OnClickListener sQM;
  private View.OnClickListener sQN;
  private View.OnClickListener sQO;
  private int sQP;
  private boolean sQQ;
  private final EditorItemContainer.d sQR;
  private final Rect sQw;
  private ImageView sQx;
  private ViewGroup sQy;
  private EditorFrameView sQz;
  
  static
  {
    AppMethodBeat.i(110656);
    sQS = new EditorItemContainer.a((byte)0);
    AppMethodBeat.o(110656);
  }
  
  public EditorItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110655);
    AppMethodBeat.o(110655);
  }
  
  public EditorItemContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110654);
    this.sQw = new Rect();
    this.lzI = ((Runnable)new EditorItemContainer.c(this));
    this.heightPercent = 0.5F;
    this.sQQ = true;
    View.inflate(paramContext, 2130970928, (ViewGroup)this);
    paramContext = findViewById(2131828282);
    j.p(paramContext, "findViewById(R.id.editor_item_layout)");
    this.lzD = ((ViewGroup)paramContext);
    paramContext = findViewById(2131823549);
    j.p(paramContext, "findViewById(R.id.editor_delete_view)");
    this.lzC = ((TextView)paramContext);
    paramContext = findViewById(2131828284);
    j.p(paramContext, "findViewById(R.id.editor_delete_view_icon)");
    this.sQx = ((ImageView)paramContext);
    paramContext = findViewById(2131828283);
    j.p(paramContext, "findViewById(R.id.editor_delete_view_group)");
    this.sQy = ((ViewGroup)paramContext);
    paramContext = com.tencent.mm.plugin.story.f.k.sCp;
    paramContext = com.tencent.mm.plugin.story.f.k.cCr();
    paramAttributeSet = getResources();
    j.p(paramAttributeSet, "resources");
    paramInt = paramAttributeSet.getDisplayMetrics().widthPixels;
    paramAttributeSet = getResources();
    j.p(paramAttributeSet, "resources");
    paramContext.set(0, 0, paramInt, paramAttributeSet.getDisplayMetrics().heightPixels);
    this.sQR = new EditorItemContainer.d(this);
    AppMethodBeat.o(110654);
  }
  
  private final void cFO()
  {
    AppMethodBeat.i(151246);
    Object localObject;
    if (this.sQK != null)
    {
      localObject = this.sQK;
      if (localObject != null) {
        ((h)localObject).bringToFront();
      }
    }
    if (this.sQI != null)
    {
      localObject = this.sQI;
      if (localObject != null) {
        ((f)localObject).bringToFront();
      }
    }
    if (this.sQJ != null)
    {
      localObject = this.sQJ;
      if (localObject != null)
      {
        ((d)localObject).bringToFront();
        AppMethodBeat.o(151246);
        return;
      }
    }
    AppMethodBeat.o(151246);
  }
  
  private final void ha(boolean paramBoolean)
  {
    AppMethodBeat.i(110647);
    this.sQy.setActivated(paramBoolean);
    if (paramBoolean)
    {
      this.lzC.setText(2131299079);
      this.sQx.setImageDrawable(aj.g(getContext(), 2131231452, -1));
      AppMethodBeat.o(110647);
      return;
    }
    this.lzC.setText(2131299078);
    this.sQx.setImageDrawable(aj.g(getContext(), 2131231451, -1));
    AppMethodBeat.o(110647);
  }
  
  private final void mm(boolean paramBoolean)
  {
    AppMethodBeat.i(110650);
    EditorFrameView localEditorFrameView = this.sQz;
    if (localEditorFrameView != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        localEditorFrameView.setVisibility(i);
        AppMethodBeat.o(110650);
        return;
      }
    }
    AppMethodBeat.o(110650);
  }
  
  private final void mn(boolean paramBoolean)
  {
    AppMethodBeat.i(110651);
    EditorFrameView localEditorFrameView = this.sQA;
    if (localEditorFrameView != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        localEditorFrameView.setVisibility(i);
        AppMethodBeat.o(110651);
        return;
      }
    }
    AppMethodBeat.o(110651);
  }
  
  private final void mo(boolean paramBoolean)
  {
    AppMethodBeat.i(110652);
    EditorFrameView localEditorFrameView = this.sQB;
    if (localEditorFrameView != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        localEditorFrameView.setVisibility(i);
        AppMethodBeat.o(110652);
        return;
      }
    }
    AppMethodBeat.o(110652);
  }
  
  private final void mp(boolean paramBoolean)
  {
    AppMethodBeat.i(110653);
    EditorFrameView localEditorFrameView = this.sQC;
    if (localEditorFrameView != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        localEditorFrameView.setVisibility(i);
        AppMethodBeat.o(110653);
        return;
      }
    }
    AppMethodBeat.o(110653);
  }
  
  public final void D(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(151247);
    j.q(paramEmojiInfo, "emojiInfo");
    b localb = new b(getContext(), false);
    Object localObject = this.qaF;
    if (localObject != null)
    {
      localObject = ((RecordConfigProvider)localObject).qbr;
      if (localObject != null) {
        localb.ai(((UICustomParam)localObject).etr, ((UICustomParam)localObject).ets);
      }
    }
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.lzD.addView((View)localb, (ViewGroup.LayoutParams)localObject);
    localObject = com.tencent.mm.plugin.story.f.k.sCp;
    localObject = com.tencent.mm.plugin.story.f.k.cCr();
    com.tencent.mm.plugin.story.f.k localk = com.tencent.mm.plugin.story.f.k.sCp;
    localb.c((Rect)localObject, com.tencent.mm.plugin.story.f.k.cCs());
    c.a.a(localb, this.sQw);
    localb.setStateResolve((EditorItemContainer.b)this.sQR);
    localb.setEmojiInfo(paramEmojiInfo);
    localb.resume();
    if (this.sQD) {
      localb.pause();
    }
    s((View)localb, true);
    removeCallbacks(this.lzI);
    postDelayed(this.lzI, 1500L);
    cFO();
    AppMethodBeat.o(151247);
  }
  
  public final void ag(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(110648);
    Object localObject = getContext();
    j.p(localObject, "context");
    this.sQz = new EditorFrameView((Context)localObject);
    localObject = this.sQz;
    if (localObject != null) {
      ((EditorFrameView)localObject).setPosition(com.tencent.mm.plugin.story.ui.view.editor.a.sOK);
    }
    localObject = this.sQz;
    if (localObject != null) {
      ((EditorFrameView)localObject).setVisibility(4);
    }
    localObject = new RelativeLayout.LayoutParams((int)paramFloat2, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(20);
    addView((View)this.sQz, (ViewGroup.LayoutParams)localObject);
    localObject = getContext();
    j.p(localObject, "context");
    this.sQB = new EditorFrameView((Context)localObject);
    localObject = this.sQB;
    if (localObject != null) {
      ((EditorFrameView)localObject).setPosition(com.tencent.mm.plugin.story.ui.view.editor.a.sOM);
    }
    localObject = this.sQB;
    if (localObject != null) {
      ((EditorFrameView)localObject).setVisibility(4);
    }
    localObject = new RelativeLayout.LayoutParams((int)paramFloat2, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(21);
    addView((View)this.sQB, (ViewGroup.LayoutParams)localObject);
    localObject = com.tencent.mm.plugin.story.f.k.sCp;
    com.tencent.mm.plugin.story.f.k.cCr().left = ((int)paramFloat2);
    localObject = com.tencent.mm.plugin.story.f.k.sCp;
    com.tencent.mm.plugin.story.f.k.cCr().right = ((int)paramFloat2 + (int)paramFloat1);
    localObject = new StringBuilder("logStory: initWidthSafeArea safeAreaRect:");
    com.tencent.mm.plugin.story.f.k localk = com.tencent.mm.plugin.story.f.k.sCp;
    ab.i("MicroMsg.EditorItemContainer", com.tencent.mm.plugin.story.f.k.cCr());
    AppMethodBeat.o(110648);
  }
  
  public final void ah(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(110649);
    Object localObject = getContext();
    j.p(localObject, "context");
    this.sQA = new EditorFrameView((Context)localObject);
    localObject = this.sQA;
    if (localObject != null) {
      ((EditorFrameView)localObject).setPosition(com.tencent.mm.plugin.story.ui.view.editor.a.sOL);
    }
    localObject = this.sQA;
    if (localObject != null) {
      ((EditorFrameView)localObject).setVisibility(4);
    }
    localObject = new RelativeLayout.LayoutParams(-1, (int)paramFloat2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    addView((View)this.sQA, (ViewGroup.LayoutParams)localObject);
    localObject = getContext();
    j.p(localObject, "context");
    this.sQC = new EditorFrameView((Context)localObject);
    localObject = this.sQC;
    if (localObject != null) {
      ((EditorFrameView)localObject).setPosition(com.tencent.mm.plugin.story.ui.view.editor.a.sON);
    }
    localObject = this.sQC;
    if (localObject != null) {
      ((EditorFrameView)localObject).setVisibility(4);
    }
    localObject = new RelativeLayout.LayoutParams(-1, (int)paramFloat2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    addView((View)this.sQC, (ViewGroup.LayoutParams)localObject);
    localObject = com.tencent.mm.plugin.story.f.k.sCp;
    com.tencent.mm.plugin.story.f.k.cCr().top = ((int)paramFloat2);
    localObject = com.tencent.mm.plugin.story.f.k.sCp;
    com.tencent.mm.plugin.story.f.k.cCr().bottom = ((int)paramFloat2 + (int)paramFloat1);
    localObject = new StringBuilder("logStory: initHeightSafeArea safeAreaRect:");
    com.tencent.mm.plugin.story.f.k localk = com.tencent.mm.plugin.story.f.k.sCp;
    ab.i("MicroMsg.EditorItemContainer", com.tencent.mm.plugin.story.f.k.cCr());
    AppMethodBeat.o(110649);
  }
  
  public final void b(chj paramchj)
  {
    AppMethodBeat.i(110640);
    j.q(paramchj, "sl");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject1 = getContext();
    j.p(localObject1, "context");
    this.sQI = new f((Context)localObject1);
    localObject1 = this.sQI;
    if (localObject1 != null)
    {
      Object localObject2 = com.tencent.mm.plugin.story.f.k.sCp;
      localObject2 = com.tencent.mm.plugin.story.f.k.cCr();
      com.tencent.mm.plugin.story.f.k localk = com.tencent.mm.plugin.story.f.k.sCp;
      ((f)localObject1).c((Rect)localObject2, com.tencent.mm.plugin.story.f.k.cCs());
    }
    localObject1 = this.sQI;
    if (localObject1 != null) {
      ((f)localObject1).a(this.sQw, this.heightPercent);
    }
    localObject1 = this.sQI;
    if (localObject1 != null) {
      ((f)localObject1).setLocation(paramchj);
    }
    paramchj = this.sQI;
    if (paramchj != null) {
      paramchj.setStateResolve((EditorItemContainer.b)this.sQR);
    }
    paramchj = this.sQI;
    if (paramchj != null) {
      paramchj.setOnClickListener(this.sQL);
    }
    this.lzD.addView((View)this.sQI, (ViewGroup.LayoutParams)localLayoutParams);
    paramchj = this.sQI;
    if (paramchj == null) {
      j.ebi();
    }
    s((View)paramchj, false);
    removeCallbacks(this.lzI);
    postDelayed(this.lzI, 1500L);
    paramchj = this.sQG;
    if (paramchj != null)
    {
      paramchj.h(this.sQI, Boolean.TRUE);
      AppMethodBeat.o(110640);
      return;
    }
    AppMethodBeat.o(110640);
  }
  
  public final void cFP()
  {
    AppMethodBeat.i(151250);
    if (this.sQK != null)
    {
      this.lzD.removeView((View)this.sQK);
      this.sQK = null;
    }
    AppMethodBeat.o(151250);
  }
  
  public final boolean cFQ()
  {
    return this.sQK != null;
  }
  
  public final void cFR()
  {
    AppMethodBeat.i(151253);
    if (this.sQJ != null) {
      this.lzD.removeView((View)this.sQJ);
    }
    this.sQJ = null;
    AppMethodBeat.o(151253);
  }
  
  public final boolean cFS()
  {
    return this.sQI != null;
  }
  
  public final void dK(List<? extends baz> paramList)
  {
    AppMethodBeat.i(151252);
    j.q(paramList, "lyricsItemInfos");
    this.sQJ = new d(getContext());
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.lzD.addView((View)this.sQJ, (ViewGroup.LayoutParams)localObject1);
    localObject1 = this.sQJ;
    if (localObject1 != null)
    {
      Object localObject2 = com.tencent.mm.plugin.story.f.k.sCp;
      localObject2 = com.tencent.mm.plugin.story.f.k.cCr();
      com.tencent.mm.plugin.story.f.k localk = com.tencent.mm.plugin.story.f.k.sCp;
      ((d)localObject1).setSafeArea$27eda001((Rect)localObject2);
    }
    localObject1 = this.sQJ;
    if (localObject1 != null) {
      c.a.a((c)localObject1, this.sQw);
    }
    localObject1 = this.sQJ;
    if (localObject1 != null) {
      ((d)localObject1).setStateResolve((EditorItemContainer.b)this.sQR);
    }
    localObject1 = this.sQJ;
    if (localObject1 != null)
    {
      ((d)localObject1).dL(paramList);
      AppMethodBeat.o(151252);
      return;
    }
    AppMethodBeat.o(151252);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(151260);
    if (!this.sQQ)
    {
      AppMethodBeat.o(151260);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(151260);
    return bool;
  }
  
  public final List<com.tencent.mm.media.editor.a.h> getAllItemViews()
  {
    AppMethodBeat.i(110644);
    List localList = (List)new ArrayList();
    int i = 0;
    int j = this.lzD.getChildCount();
    while (i < j)
    {
      View localView = this.lzD.getChildAt(i);
      if ((localView instanceof com.tencent.mm.media.editor.a.h)) {
        localList.add(localView);
      }
      i += 1;
    }
    AppMethodBeat.o(110644);
    return localList;
  }
  
  public final a.f.a.b<Boolean, y> getDeleteStateListener()
  {
    return this.sQF;
  }
  
  public final a.f.a.m<View, Boolean, y> getItemChangeListener()
  {
    return this.sQG;
  }
  
  public final int getLocationItemHeight()
  {
    AppMethodBeat.i(151259);
    Object localObject = this.sQI;
    if (localObject != null)
    {
      localObject = ((f)localObject).getBitmap();
      if (localObject != null)
      {
        int i = ((Bitmap)localObject).getHeight();
        AppMethodBeat.o(151259);
        return i;
      }
    }
    AppMethodBeat.o(151259);
    return 0;
  }
  
  public final f getLocationView()
  {
    return this.sQI;
  }
  
  public final d getLyricsView()
  {
    return this.sQJ;
  }
  
  public final h getTipItemView()
  {
    return this.sQK;
  }
  
  public final void h(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151248);
    g localg = new g(getContext());
    Object localObject = this.qaF;
    if (localObject != null)
    {
      localObject = ((RecordConfigProvider)localObject).qbr;
      if (localObject != null) {
        localg.ai(((UICustomParam)localObject).ett, ((UICustomParam)localObject).etu);
      }
    }
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.lzD.addView((View)localg, (ViewGroup.LayoutParams)localObject);
    localObject = com.tencent.mm.plugin.story.f.k.sCp;
    localObject = com.tencent.mm.plugin.story.f.k.cCr();
    com.tencent.mm.plugin.story.f.k localk = com.tencent.mm.plugin.story.f.k.sCp;
    localg.c((Rect)localObject, com.tencent.mm.plugin.story.f.k.cCs());
    localg.a(this.sQw, this.heightPercent);
    localg.setStateResolve((EditorItemContainer.b)this.sQR);
    localg.setText(paramCharSequence, paramInt1, paramInt2);
    localg.setOnClickListener(this.sQM);
    s((View)localg, true);
    removeCallbacks(this.lzI);
    postDelayed(this.lzI, 1500L);
    cFO();
    AppMethodBeat.o(151248);
  }
  
  public final void i(a.f.a.a<y> parama)
  {
    AppMethodBeat.i(110641);
    if (this.sQI != null) {
      this.lzD.removeView((View)this.sQI);
    }
    this.sQI = null;
    if (parama != null)
    {
      parama.invoke();
      AppMethodBeat.o(110641);
      return;
    }
    AppMethodBeat.o(110641);
  }
  
  public final void i(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151249);
    if ((paramCharSequence == null) || (a.l.m.ap(paramCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(151249);
      return;
    }
    this.sQK = new h(getContext());
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    this.lzD.addView((View)this.sQK, (ViewGroup.LayoutParams)localObject1);
    localObject1 = this.sQK;
    if (localObject1 != null)
    {
      Object localObject2 = com.tencent.mm.plugin.story.f.k.sCp;
      localObject2 = com.tencent.mm.plugin.story.f.k.cCr();
      com.tencent.mm.plugin.story.f.k localk = com.tencent.mm.plugin.story.f.k.sCp;
      ((h)localObject1).c((Rect)localObject2, com.tencent.mm.plugin.story.f.k.cCs());
    }
    localObject1 = this.sQK;
    if (localObject1 != null) {
      c.a.a((c)localObject1, this.sQw);
    }
    localObject1 = this.sQK;
    if (localObject1 != null) {
      ((h)localObject1).setStateResolve((EditorItemContainer.b)this.sQR);
    }
    localObject1 = this.sQK;
    if (localObject1 != null) {
      ((h)localObject1).b(paramCharSequence, paramInt1, paramInt2, getLocationItemHeight());
    }
    paramCharSequence = this.sQK;
    if (paramCharSequence != null)
    {
      paramCharSequence.setOnClickListener(this.sQN);
      AppMethodBeat.o(151249);
      return;
    }
    AppMethodBeat.o(151249);
  }
  
  public final void j(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151251);
    if (this.sQK == null)
    {
      AppMethodBeat.o(151251);
      return;
    }
    cFP();
    i(paramCharSequence, paramInt1, paramInt2);
    AppMethodBeat.o(151251);
  }
  
  public final boolean jk(int paramInt)
  {
    AppMethodBeat.i(110639);
    Object localObject = this.sQy.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(110639);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(getContext(), 32) + paramInt);
    this.sQy.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(110639);
    return true;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(110637);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.sQw.set(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(110637);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(110638);
    j.q(paramMotionEvent, "event");
    if ((paramMotionEvent.getActionMasked() == 0) && (this.sQH != null))
    {
      View localView = this.sQH;
      if (localView == null) {
        j.ebi();
      }
      s(localView, false);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(110638);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(151256);
    int j = this.lzD.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.lzD.getChildAt(i);
      if ((localView instanceof b)) {
        ((b)localView).pause();
      }
      i += 1;
    }
    AppMethodBeat.o(151256);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(151258);
    this.sQI = null;
    this.sQK = null;
    this.sQJ = null;
    this.lzD.removeAllViews();
    AppMethodBeat.o(151258);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(151257);
    int j = this.lzD.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.lzD.getChildAt(i);
      if ((localView instanceof b)) {
        ((b)localView).resume();
      }
      i += 1;
    }
    AppMethodBeat.o(151257);
  }
  
  public final void s(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(110645);
    j.q(paramView, "itemView");
    if (paramBoolean) {
      if ((j.e(paramView, this.sQH) ^ true))
      {
        View localView = this.sQH;
        if (localView != null) {
          localView.setActivated(false);
        }
        this.sQH = paramView;
      }
    }
    for (;;)
    {
      paramView.setActivated(paramBoolean);
      AppMethodBeat.o(110645);
      return;
      if (j.e(paramView, this.sQH)) {
        this.sQH = null;
      }
    }
  }
  
  public final void setDeleteStateListener(a.f.a.b<? super Boolean, y> paramb)
  {
    this.sQF = paramb;
  }
  
  public final void setEnableTouch(boolean paramBoolean)
  {
    this.sQQ = paramBoolean;
  }
  
  public final void setItemChangeListener(a.f.a.m<? super View, ? super Boolean, y> paramm)
  {
    this.sQG = paramm;
  }
  
  public final void setLocationView(f paramf)
  {
    this.sQI = paramf;
  }
  
  public final void setLyricsView(d paramd)
  {
    this.sQJ = paramd;
  }
  
  public final void setOnLocationClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110642);
    j.q(paramOnClickListener, "locationClickListener");
    this.sQL = paramOnClickListener;
    AppMethodBeat.o(110642);
  }
  
  public final void setOnLyricsClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(151255);
    j.q(paramOnClickListener, "lyricsClickListener");
    this.sQO = paramOnClickListener;
    AppMethodBeat.o(151255);
  }
  
  public final void setOnTextClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110643);
    j.q(paramOnClickListener, "textClickListener");
    this.sQM = paramOnClickListener;
    AppMethodBeat.o(110643);
  }
  
  public final void setOnTipClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(151254);
    j.q(paramOnClickListener, "tipClickListener");
    this.sQN = paramOnClickListener;
    AppMethodBeat.o(151254);
  }
  
  public final void setSafeType(int paramInt)
  {
    this.sQP = paramInt;
    if (this.sQP == 0) {
      this.heightPercent = 0.7F;
    }
    while (this.sQP != 1) {
      return;
    }
    this.heightPercent = 0.5F;
  }
  
  public final void setTipItemView(h paramh)
  {
    this.sQK = paramh;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  public static final class e
    extends a.f.b.k
    implements a.f.a.a<y>
  {
    public static final e sQV;
    
    static
    {
      AppMethodBeat.i(151245);
      sQV = new e();
      AppMethodBeat.o(151245);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer
 * JD-Core Version:    0.7.0.1
 */