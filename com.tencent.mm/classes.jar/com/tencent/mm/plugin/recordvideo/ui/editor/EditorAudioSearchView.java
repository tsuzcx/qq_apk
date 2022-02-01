package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gt;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.c.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;)V", "mAdapter", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "mClickClosePanel", "Landroid/view/View;", "mCloseBtn", "Landroid/widget/TextView;", "mEditCleanBtn", "Landroid/widget/ImageView;", "mEditView", "Landroid/widget/EditText;", "mFinishBtn", "Landroid/widget/Button;", "mLastSelectItem", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mLastSelectTimestamp", "", "mRelatedRecId", "getMRelatedRecId", "()J", "setMRelatedRecId", "(J)V", "mScrollListener", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1;", "mSearchIcon", "mSearchNoResultTv", "mSearchOffset", "mSearchPanel", "mSearchRequestId", "mSearchResultView", "Landroid/support/v7/widget/RecyclerView;", "mSearchString", "mSearchingView", "Landroid/widget/LinearLayout;", "mSelectedPosition", "mTagsPanel", "mTranslateOffset", "showImeRunnable", "Ljava/lang/Runnable;", "back", "", "backAndPausePlayer", "", "cleanAndPausePlayer", "doSearch", "loadMore", "handleResult", "audioList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "init", "isShow", "reportSelect", "reset", "resetStyle", "bgResId", "textColor", "text", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "selectItem", "position", "selectSearchItem", "setImeVisibility", "visible", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setSelection", "(Ljava/lang/Integer;)V", "setShow", "showNoResult", "showResultList", "Ljava/util/ArrayList;", "showSearchPanel", "showSearching", "showTagsPanel", "AudioSearchCallback", "plugin-recordvideo_release"})
public final class EditorAudioSearchView
  extends RelativeLayout
{
  private final String TAG;
  private Button mkr;
  private final Runnable pXg;
  private int xJQ;
  private View xJR;
  private View xJS;
  private View xJT;
  private TextView xJU;
  private EditText xJV;
  private RecyclerView xJW;
  private TextView xJX;
  private LinearLayout xJY;
  private ImageView xJZ;
  private ImageView xKa;
  private com.tencent.mm.plugin.recordvideo.ui.a.a xKb;
  private long xKc;
  private int xKd;
  int xKe;
  private String xKf;
  private AudioCacheInfo xKg;
  private long xKh;
  private long xKi;
  private a xKj;
  private final l xKk;
  
  public EditorAudioSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75929);
    this.TAG = "MicroMsg.EditorAudioSearchView";
    this.xKe = -1;
    this.xKk = new l(this);
    this.pXg = ((Runnable)new n(this));
    init();
    AppMethodBeat.o(75929);
  }
  
  public EditorAudioSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75930);
    this.TAG = "MicroMsg.EditorAudioSearchView";
    this.xKe = -1;
    this.xKk = new l(this);
    this.pXg = ((Runnable)new n(this));
    init();
    AppMethodBeat.o(75930);
  }
  
  private final void dHu()
  {
    AppMethodBeat.i(75921);
    dHx();
    Object localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
    com.tencent.mm.plugin.recordvideo.model.audio.c.dGg().lU(1L);
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
    c.a.dGh();
    reset();
    localObject = this.xJV;
    if (localObject != null) {
      ((EditText)localObject).clearFocus();
    }
    localObject = this.xKj;
    if (localObject != null) {
      ((a)localObject).dHz();
    }
    localObject = this.xKj;
    if (localObject != null)
    {
      ((a)localObject).dHA();
      AppMethodBeat.o(75921);
      return;
    }
    AppMethodBeat.o(75921);
  }
  
  private final void dHv()
  {
    AppMethodBeat.i(75922);
    View localView = this.xJR;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.xJS;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(75922);
      return;
    }
    AppMethodBeat.o(75922);
  }
  
  private final void dHw()
  {
    AppMethodBeat.i(75923);
    Object localObject = this.xJY;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
    localObject = this.xJW;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(8);
    }
    localObject = this.xJX;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      AppMethodBeat.o(75923);
      return;
    }
    AppMethodBeat.o(75923);
  }
  
  private final void dHx()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(75924);
    StringBuilder localStringBuilder;
    Object localObject3;
    if (this.xKg != null)
    {
      localStringBuilder = new StringBuilder();
      localObject3 = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
      if (!bt.isNullOrNil(com.tencent.mm.plugin.recordvideo.model.audio.c.dGg().Us())) {
        break label133;
      }
      localObject3 = this.xKg;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((AudioCacheInfo)localObject3).xyZ);
      }
      localStringBuilder.append(localObject1).append(":1:").append(System.currentTimeMillis() - this.xKh);
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.dGg();
      localObject2 = ((gt)localObject1).Us();
      ((gt)localObject1).pC((String)localObject2 + localStringBuilder.toString());
      AppMethodBeat.o(75924);
      return;
      label133:
      localObject2 = localStringBuilder.append(";");
      localObject3 = this.xKg;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((AudioCacheInfo)localObject3).xyZ);
      }
      ((StringBuilder)localObject2).append(localObject1).append(":1:").append(System.currentTimeMillis() - this.xKh);
    }
  }
  
  private final void init()
  {
    AppMethodBeat.i(75918);
    View.inflate(getContext(), 2131495682, (ViewGroup)this);
    this.xJU = ((TextView)findViewById(2131305367));
    this.xJV = ((EditText)findViewById(2131305368));
    this.mkr = ((Button)findViewById(2131305372));
    this.xJW = ((RecyclerView)findViewById(2131305378));
    this.xJX = ((TextView)findViewById(2131305376));
    this.xJY = ((LinearLayout)findViewById(2131305375));
    this.xJZ = ((ImageView)findViewById(2131305369));
    this.xJR = findViewById(2131305381);
    this.xJS = findViewById(2131305379);
    this.xJT = findViewById(2131305366);
    this.xKa = ((ImageView)findViewById(2131305370));
    Object localObject = this.xKa;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(ao.k(getContext(), 2131690473, -1));
    }
    localObject = this.mkr;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.xJZ;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(ao.k(getContext(), 2131690372, -1));
    }
    localObject = this.xJZ;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new c(this));
    }
    localObject = this.xJW;
    if (localObject != null) {}
    for (localObject = ((RecyclerView)localObject).getLayoutParams(); localObject == null; localObject = null)
    {
      localObject = new d.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(75918);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (ar.ej(getContext()) + com.tencent.mm.cc.a.fromDPToPix(getContext(), 16));
    localObject = this.xJW;
    if (localObject != null)
    {
      getContext();
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    }
    localObject = this.xJW;
    if (localObject != null) {
      ((RecyclerView)localObject).a((RecyclerView.m)this.xKk);
    }
    this.xKb = new com.tencent.mm.plugin.recordvideo.ui.a.a();
    localObject = this.xJW;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.xKb);
    }
    localObject = this.xJU;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new d(this));
    }
    localObject = this.mkr;
    if (localObject != null) {
      ((Button)localObject).setOnClickListener((View.OnClickListener)new e(this));
    }
    localObject = this.xJV;
    if (localObject != null) {
      ((EditText)localObject).setOnFocusChangeListener((View.OnFocusChangeListener)new f(this));
    }
    localObject = this.xJV;
    if (localObject != null) {
      ((EditText)localObject).addTextChangedListener((TextWatcher)new g(this));
    }
    localObject = this.xJV;
    if (localObject != null) {
      ((EditText)localObject).setOnEditorActionListener((TextView.OnEditorActionListener)new h(this));
    }
    localObject = this.xKb;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).pVb = ((m)new i(this));
    }
    localObject = this.xJT;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new j(this));
    }
    setOnClickListener((View.OnClickListener)EditorAudioSearchView.k.xKn);
    this.xJQ = ar.ci(getContext()).y;
    setTranslationY(this.xJQ);
    dHv();
    AppMethodBeat.o(75918);
  }
  
  private final void setImeVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(75920);
    if (paramBoolean)
    {
      post(this.pXg);
      AppMethodBeat.o(75920);
      return;
    }
    removeCallbacks(this.pXg);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      AppMethodBeat.o(75920);
      return;
    }
    AppMethodBeat.o(75920);
  }
  
  public final void NR(int paramInt)
  {
    AppMethodBeat.i(75919);
    Object localObject1 = this.xKb;
    int i;
    Object localObject2;
    if ((localObject1 == null) || (((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject1).uT != paramInt))
    {
      this.xKe = paramInt;
      localObject1 = this.xKb;
      if (localObject1 == null) {
        break label102;
      }
      localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject1).NQ(paramInt);
      if (localObject1 == null) {
        break label107;
      }
      i = ((AudioCacheInfo)localObject1).type;
      localObject2 = AudioCacheInfo.xzp;
      if (i != AudioCacheInfo.dFV()) {
        break label107;
      }
      localObject2 = this.xKj;
      if (localObject2 != null) {
        ((a)localObject2).e(null);
      }
    }
    for (;;)
    {
      this.xKg = ((AudioCacheInfo)localObject1);
      this.xKh = System.currentTimeMillis();
      AppMethodBeat.o(75919);
      return;
      label102:
      localObject1 = null;
      break;
      label107:
      if (localObject1 != null)
      {
        i = ((AudioCacheInfo)localObject1).type;
        localObject2 = AudioCacheInfo.xzp;
        if (i == AudioCacheInfo.dFU())
        {
          localObject2 = this.xKb;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject2).setSelection(Integer.valueOf(paramInt));
          }
          localObject2 = this.xKj;
          if (localObject2 != null) {
            ((a)localObject2).e((AudioCacheInfo)localObject1);
          }
          localObject2 = this.mkr;
          if (localObject2 != null) {
            ((Button)localObject2).setEnabled(true);
          }
          dHx();
        }
      }
    }
  }
  
  public final void b(Integer paramInteger1, Integer paramInteger2)
  {
    AppMethodBeat.i(200532);
    Button localButton = this.mkr;
    if (localButton != null)
    {
      if ((paramInteger1 != null) && (paramInteger1.intValue() != 0)) {
        localButton.setBackgroundResource(paramInteger1.intValue());
      }
      if ((paramInteger2 != null) && (paramInteger2.intValue() != 0) && ((localButton instanceof TextView))) {
        localButton.setTextColor(android.support.v4.content.b.n(localButton.getContext(), paramInteger2.intValue()));
      }
      AppMethodBeat.o(200532);
      return;
    }
    AppMethodBeat.o(200532);
  }
  
  public final boolean bni()
  {
    AppMethodBeat.i(200533);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(200533);
      return true;
    }
    AppMethodBeat.o(200533);
    return false;
  }
  
  public final boolean dHy()
  {
    AppMethodBeat.i(200534);
    if (getVisibility() == 0)
    {
      Object localObject = this.xJV;
      if (localObject != null)
      {
        localObject = ((EditText)localObject).getText();
        if (!bt.ai((CharSequence)localObject)) {
          break label54;
        }
        dHu();
      }
      for (;;)
      {
        AppMethodBeat.o(200534);
        return true;
        localObject = null;
        break;
        label54:
        dHx();
        localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
        com.tencent.mm.plugin.recordvideo.model.audio.c.dGg().lU(1L);
        localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
        c.a.dGh();
        reset();
        localObject = this.xKj;
        if (localObject != null) {
          ((a)localObject).dHz();
        }
      }
    }
    AppMethodBeat.o(200534);
    return false;
  }
  
  public final a getCallback()
  {
    return this.xKj;
  }
  
  public final long getMRelatedRecId()
  {
    return this.xKi;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75927);
    this.xKd = 0;
    this.xKe = -1;
    this.xKc = 0L;
    Object localObject = this.mkr;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.xJV;
    if (localObject != null) {
      ((EditText)localObject).setText(null);
    }
    localObject = this.xKb;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).setSelection(null);
    }
    localObject = this.xJW;
    if (localObject != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject).ca(((Integer)locala.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    }
    localObject = this.xKb;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).ff((List)new LinkedList());
    }
    dHv();
    this.xKf = null;
    this.xKg = null;
    this.xKh = 0L;
    AppMethodBeat.o(75927);
  }
  
  public final void setCallback(a parama)
  {
    this.xKj = parama;
  }
  
  public final void setMRelatedRecId(long paramLong)
  {
    this.xKi = paramLong;
  }
  
  public final void setMusicPlayer(com.google.android.exoplayer2.v paramv)
  {
    AppMethodBeat.i(75926);
    p.h(paramv, "player");
    com.tencent.mm.plugin.recordvideo.ui.a.a locala = this.xKb;
    if (locala != null)
    {
      locala.setMusicPlayer(paramv);
      AppMethodBeat.o(75926);
      return;
    }
    AppMethodBeat.o(75926);
  }
  
  public final void setSelection(Integer paramInteger)
  {
    AppMethodBeat.i(75928);
    com.tencent.mm.plugin.recordvideo.ui.a.a locala = this.xKb;
    if (locala != null)
    {
      locala.setSelection(paramInteger);
      AppMethodBeat.o(75928);
      return;
    }
    AppMethodBeat.o(75928);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(75925);
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
      com.tencent.mm.plugin.recordvideo.model.audio.c.dGg().lX(this.xKi);
      setVisibility(0);
      animate().translationY(0.0F).start();
      localObject = this.xJV;
      if (localObject != null)
      {
        ((EditText)localObject).requestFocus();
        AppMethodBeat.o(75925);
        return;
      }
      AppMethodBeat.o(75925);
      return;
    }
    animate().translationY(this.xJQ).withEndAction((Runnable)new m(this)).start();
    Object localObject = this.xJV;
    if (localObject != null)
    {
      ((EditText)localObject).clearFocus();
      AppMethodBeat.o(75925);
      return;
    }
    AppMethodBeat.o(75925);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "", "onPauseAudio", "", "onSearchAudioCancel", "onSearchAudioFinish", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "onSearchAudioSelected", "plugin-recordvideo_release"})
  public static abstract interface a
  {
    public abstract void c(AudioCacheInfo paramAudioCacheInfo);
    
    public abstract void dHA();
    
    public abstract void dHz();
    
    public abstract void e(AudioCacheInfo paramAudioCacheInfo);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MMSPRBgmSearchResp;", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(EditorAudioSearchView paramEditorAudioSearchView, boolean paramBoolean) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(75905);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = EditorAudioSearchView.a(this.xKl);
      if (paramView != null)
      {
        paramView = paramView.getText();
        if (paramView != null) {
          if (((CharSequence)paramView).length() != 0) {
            break label108;
          }
        }
      }
      label108:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          paramView = EditorAudioSearchView.a(this.xKl);
          if (paramView != null) {
            paramView.setText(null);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75905);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(75906);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      EditorAudioSearchView.b(this.xKl);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75906);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(75907);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = EditorAudioSearchView.c(this.xKl);
      if (paramView != null)
      {
        if ((EditorAudioSearchView.d(this.xKl) == -1) || (EditorAudioSearchView.d(this.xKl) >= paramView.getItemCount())) {
          break label167;
        }
        localObject = this.xKl.getCallback();
        if (localObject != null) {
          ((EditorAudioSearchView.a)localObject).c(paramView.NQ(EditorAudioSearchView.d(this.xKl)));
        }
        EditorAudioSearchView.f(this.xKl);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
        com.tencent.mm.plugin.recordvideo.model.audio.c.dGg().lU(0L);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
        c.a.dGh();
      }
      for (;;)
      {
        this.xKl.reset();
        paramView = EditorAudioSearchView.a(this.xKl);
        if (paramView != null) {
          paramView.clearFocus();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75907);
        return;
        label167:
        paramView = this.xKl.getCallback();
        if (paramView != null) {
          paramView.c(null);
        }
        EditorAudioSearchView.f(this.xKl);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
        com.tencent.mm.plugin.recordvideo.model.audio.c.dGg().lU(1L);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
        c.a.dGh();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
  static final class f
    implements View.OnFocusChangeListener
  {
    f(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onFocusChange(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(75908);
      EditorAudioSearchView.a(this.xKl, paramBoolean);
      AppMethodBeat.o(75908);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$5", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "plugin-recordvideo_release"})
  public static final class g
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(75909);
      int i;
      if (paramEditable != null) {
        i = paramEditable.length();
      }
      while (i > 0)
      {
        paramEditable = EditorAudioSearchView.g(this.xKl);
        if (paramEditable != null)
        {
          paramEditable.setVisibility(0);
          AppMethodBeat.o(75909);
          return;
          i = 0;
        }
        else
        {
          AppMethodBeat.o(75909);
          return;
        }
      }
      paramEditable = EditorAudioSearchView.g(this.xKl);
      if (paramEditable != null)
      {
        paramEditable.setVisibility(8);
        AppMethodBeat.o(75909);
        return;
      }
      AppMethodBeat.o(75909);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "keyEvent", "Landroid/view/KeyEvent;", "onEditorAction"})
  static final class h
    implements TextView.OnEditorActionListener
  {
    h(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(75910);
      if (3 == paramInt)
      {
        if (EditorAudioSearchView.h(this.xKl) != null)
        {
          String str = EditorAudioSearchView.h(this.xKl);
          p.g(paramTextView, "textView");
          paramKeyEvent = paramTextView.getText();
          if (paramKeyEvent == null) {
            break label399;
          }
          paramKeyEvent = paramKeyEvent.toString();
          if (!bt.lQ(str, paramKeyEvent))
          {
            EditorAudioSearchView.f(this.xKl);
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
            com.tencent.mm.plugin.recordvideo.model.audio.c.dGg().lU(2L);
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
            c.a.dGh();
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
            com.tencent.mm.plugin.recordvideo.model.audio.c.dGg().lX(this.xKl.getMRelatedRecId());
          }
        }
        paramKeyEvent = this.xKl;
        p.g(paramTextView, "textView");
        paramTextView = paramTextView.getText();
        if (paramTextView == null) {
          break label404;
        }
      }
      label399:
      label404:
      for (paramTextView = paramTextView.toString();; paramTextView = null)
      {
        EditorAudioSearchView.a(paramKeyEvent, paramTextView);
        if (!bt.isNullOrNil(EditorAudioSearchView.h(this.xKl)))
        {
          paramTextView = EditorAudioSearchView.c(this.xKl);
          if (paramTextView != null) {
            paramTextView.setSelection(null);
          }
          paramTextView = EditorAudioSearchView.c(this.xKl);
          if (paramTextView != null) {
            paramTextView.setSelection(null);
          }
          paramTextView = EditorAudioSearchView.i(this.xKl);
          if (paramTextView != null)
          {
            paramKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(paramTextView, paramKeyEvent.ahp(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$6", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
            paramTextView.ca(((Integer)paramKeyEvent.mq(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(paramTextView, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$6", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          }
          paramTextView = EditorAudioSearchView.c(this.xKl);
          if (paramTextView != null) {
            paramTextView.ff((List)new LinkedList());
          }
          paramTextView = EditorAudioSearchView.j(this.xKl);
          if (paramTextView != null) {
            paramTextView.setEnabled(false);
          }
          EditorAudioSearchView.a(this.xKl, 0L);
          EditorAudioSearchView.e(this.xKl);
          EditorAudioSearchView.a(this.xKl, 0);
          paramTextView = EditorAudioSearchView.c(this.xKl);
          if (paramTextView != null) {
            paramTextView.xJc = EditorAudioSearchView.h(this.xKl);
          }
          EditorAudioSearchView.m(this.xKl);
          EditorAudioSearchView.n(this.xKl);
          EditorAudioSearchView.o(this.xKl);
          EditorAudioSearchView.b(this.xKl, false);
          paramTextView = this.xKl.getCallback();
          if (paramTextView != null) {
            paramTextView.dHz();
          }
        }
        AppMethodBeat.o(75910);
        return false;
        paramKeyEvent = null;
        break;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "invoke"})
  static final class i
    extends q
    implements m<Integer, AudioCacheInfo, z>
  {
    i(EditorAudioSearchView paramEditorAudioSearchView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(75912);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      EditorAudioSearchView.b(this.xKl);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75912);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-recordvideo_release"})
  public static final class l
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(200531);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(200531);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(75915);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new d.v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(75915);
          throw paramRecyclerView;
        }
        paramInt = ((LinearLayoutManager)paramRecyclerView).ko();
        paramRecyclerView = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
        com.tencent.mm.plugin.recordvideo.model.audio.c.dGg().lV(paramInt);
        paramRecyclerView = EditorAudioSearchView.c(this.xKl);
        if ((paramRecyclerView != null) && (paramInt == paramRecyclerView.getItemCount() - 1))
        {
          paramRecyclerView = paramRecyclerView.NQ(paramInt);
          if (paramRecyclerView != null)
          {
            paramInt = paramRecyclerView.type;
            paramRecyclerView = AudioCacheInfo.xzp;
            if (paramInt == AudioCacheInfo.dFW()) {
              EditorAudioSearchView.b(this.xKl, true);
            }
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(75915);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void run()
    {
      AppMethodBeat.i(75916);
      this.xKl.setVisibility(8);
      AppMethodBeat.o(75916);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void run()
    {
      AppMethodBeat.i(75917);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.xKl.getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)EditorAudioSearchView.a(this.xKl), 0);
        AppMethodBeat.o(75917);
        return;
      }
      AppMethodBeat.o(75917);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView
 * JD-Core Version:    0.7.0.1
 */