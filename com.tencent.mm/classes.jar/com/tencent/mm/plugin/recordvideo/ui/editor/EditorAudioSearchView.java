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
import com.tencent.mm.g.b.a.fs;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.c.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ap;
import d.g.a.m;
import d.g.b.k;
import d.y;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;)V", "mAdapter", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "mClickClosePanel", "Landroid/view/View;", "mCloseBtn", "Landroid/widget/TextView;", "mEditCleanBtn", "Landroid/widget/ImageView;", "mEditView", "Landroid/widget/EditText;", "mFinishBtn", "Landroid/widget/Button;", "mLastSelectItem", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mLastSelectTimestamp", "", "mRelatedRecId", "getMRelatedRecId", "()J", "setMRelatedRecId", "(J)V", "mScrollListener", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1;", "mSearchIcon", "mSearchNoResultTv", "mSearchOffset", "mSearchPanel", "mSearchRequestId", "mSearchResultView", "Landroid/support/v7/widget/RecyclerView;", "mSearchString", "mSearchingView", "Landroid/widget/LinearLayout;", "mSelectedPosition", "mTagsPanel", "mTranslateOffset", "showImeRunnable", "Ljava/lang/Runnable;", "back", "", "backAndPausePlayer", "", "cleanAndPausePlayer", "doSearch", "loadMore", "handleResult", "audioList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "init", "isShow", "reportSelect", "reset", "resetStyle", "bgResId", "textColor", "text", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "selectItem", "position", "selectSearchItem", "setImeVisibility", "visible", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setSelection", "(Ljava/lang/Integer;)V", "setShow", "showNoResult", "showResultList", "Ljava/util/ArrayList;", "showSearchPanel", "showSearching", "showTagsPanel", "AudioSearchCallback", "plugin-recordvideo_release"})
public final class EditorAudioSearchView
  extends RelativeLayout
{
  private final String TAG;
  private Button lKB;
  private final Runnable ptC;
  private final l wAA;
  private int wAg;
  private View wAh;
  private View wAi;
  private View wAj;
  private TextView wAk;
  public EditText wAl;
  private RecyclerView wAm;
  private TextView wAn;
  private LinearLayout wAo;
  private ImageView wAp;
  private ImageView wAq;
  private com.tencent.mm.plugin.recordvideo.ui.a.a wAr;
  private long wAs;
  private int wAt;
  int wAu;
  private String wAv;
  private AudioCacheInfo wAw;
  private long wAx;
  private long wAy;
  public a wAz;
  
  public EditorAudioSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75929);
    this.TAG = "MicroMsg.EditorAudioSearchView";
    this.wAu = -1;
    this.wAA = new l(this);
    this.ptC = ((Runnable)new n(this));
    init();
    AppMethodBeat.o(75929);
  }
  
  public EditorAudioSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75930);
    this.TAG = "MicroMsg.EditorAudioSearchView";
    this.wAu = -1;
    this.wAA = new l(this);
    this.ptC = ((Runnable)new n(this));
    init();
    AppMethodBeat.o(75930);
  }
  
  private final void dwE()
  {
    AppMethodBeat.i(75922);
    View localView = this.wAh;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.wAi;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(75922);
      return;
    }
    AppMethodBeat.o(75922);
  }
  
  private final void dwF()
  {
    AppMethodBeat.i(75923);
    Object localObject = this.wAo;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
    localObject = this.wAm;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(8);
    }
    localObject = this.wAn;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      AppMethodBeat.o(75923);
      return;
    }
    AppMethodBeat.o(75923);
  }
  
  private final void init()
  {
    AppMethodBeat.i(75918);
    View.inflate(getContext(), 2131495682, (ViewGroup)this);
    this.wAk = ((TextView)findViewById(2131305367));
    this.wAl = ((EditText)findViewById(2131305368));
    this.lKB = ((Button)findViewById(2131305372));
    this.wAm = ((RecyclerView)findViewById(2131305378));
    this.wAn = ((TextView)findViewById(2131305376));
    this.wAo = ((LinearLayout)findViewById(2131305375));
    this.wAp = ((ImageView)findViewById(2131305369));
    this.wAh = findViewById(2131305381);
    this.wAi = findViewById(2131305379);
    this.wAj = findViewById(2131305366);
    this.wAq = ((ImageView)findViewById(2131305370));
    Object localObject = this.wAq;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(am.k(getContext(), 2131690473, -1));
    }
    localObject = this.lKB;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.wAp;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(am.k(getContext(), 2131690372, -1));
    }
    localObject = this.wAp;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new c(this));
    }
    localObject = this.wAm;
    if (localObject != null) {}
    for (localObject = ((RecyclerView)localObject).getLayoutParams(); localObject == null; localObject = null)
    {
      localObject = new d.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(75918);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (ap.ej(getContext()) + com.tencent.mm.cc.a.fromDPToPix(getContext(), 16));
    localObject = this.wAm;
    if (localObject != null)
    {
      getContext();
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    }
    localObject = this.wAm;
    if (localObject != null) {
      ((RecyclerView)localObject).a((RecyclerView.m)this.wAA);
    }
    this.wAr = new com.tencent.mm.plugin.recordvideo.ui.a.a();
    localObject = this.wAm;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.wAr);
    }
    localObject = this.wAk;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new d(this));
    }
    localObject = this.lKB;
    if (localObject != null) {
      ((Button)localObject).setOnClickListener((View.OnClickListener)new e(this));
    }
    localObject = this.wAl;
    if (localObject != null) {
      ((EditText)localObject).setOnFocusChangeListener((View.OnFocusChangeListener)new f(this));
    }
    localObject = this.wAl;
    if (localObject != null) {
      ((EditText)localObject).addTextChangedListener((TextWatcher)new g(this));
    }
    localObject = this.wAl;
    if (localObject != null) {
      ((EditText)localObject).setOnEditorActionListener((TextView.OnEditorActionListener)new h(this));
    }
    localObject = this.wAr;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).prv = ((m)new i(this));
    }
    localObject = this.wAj;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new j(this));
    }
    setOnClickListener((View.OnClickListener)EditorAudioSearchView.k.wAD);
    this.wAg = ap.cl(getContext()).y;
    setTranslationY(this.wAg);
    dwE();
    AppMethodBeat.o(75918);
  }
  
  private final void setImeVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(75920);
    if (paramBoolean)
    {
      post(this.ptC);
      AppMethodBeat.o(75920);
      return;
    }
    removeCallbacks(this.ptC);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      AppMethodBeat.o(75920);
      return;
    }
    AppMethodBeat.o(75920);
  }
  
  public final void Ms(int paramInt)
  {
    AppMethodBeat.i(75919);
    Object localObject1 = this.wAr;
    int i;
    Object localObject2;
    if ((localObject1 == null) || (((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject1).ta != paramInt))
    {
      this.wAu = paramInt;
      localObject1 = this.wAr;
      if (localObject1 == null) {
        break label102;
      }
      localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject1).Mr(paramInt);
      if (localObject1 == null) {
        break label107;
      }
      i = ((AudioCacheInfo)localObject1).type;
      localObject2 = AudioCacheInfo.wry;
      if (i != AudioCacheInfo.dvz()) {
        break label107;
      }
      localObject2 = this.wAz;
      if (localObject2 != null) {
        ((a)localObject2).e(null);
      }
    }
    for (;;)
    {
      this.wAw = ((AudioCacheInfo)localObject1);
      this.wAx = System.currentTimeMillis();
      AppMethodBeat.o(75919);
      return;
      label102:
      localObject1 = null;
      break;
      label107:
      if (localObject1 != null)
      {
        i = ((AudioCacheInfo)localObject1).type;
        localObject2 = AudioCacheInfo.wry;
        if (i == AudioCacheInfo.dvy())
        {
          localObject2 = this.wAr;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject2).setSelection(Integer.valueOf(paramInt));
          }
          localObject2 = this.wAz;
          if (localObject2 != null) {
            ((a)localObject2).e((AudioCacheInfo)localObject1);
          }
          localObject2 = this.lKB;
          if (localObject2 != null) {
            ((Button)localObject2).setEnabled(true);
          }
          dwG();
        }
      }
    }
  }
  
  public final void b(Integer paramInteger1, Integer paramInteger2)
  {
    AppMethodBeat.i(199419);
    Button localButton = this.lKB;
    if (localButton != null)
    {
      if ((paramInteger1 != null) && (paramInteger1.intValue() != 0)) {
        localButton.setBackgroundResource(paramInteger1.intValue());
      }
      if ((paramInteger2 != null) && (paramInteger2.intValue() != 0) && ((localButton instanceof TextView))) {
        localButton.setTextColor(android.support.v4.content.b.n(localButton.getContext(), paramInteger2.intValue()));
      }
      AppMethodBeat.o(199419);
      return;
    }
    AppMethodBeat.o(199419);
  }
  
  public final void dwD()
  {
    AppMethodBeat.i(75921);
    dwG();
    Object localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
    com.tencent.mm.plugin.recordvideo.model.audio.c.dvI().ki(1L);
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
    c.a.dvJ();
    reset();
    localObject = this.wAl;
    if (localObject != null) {
      ((EditText)localObject).clearFocus();
    }
    localObject = this.wAz;
    if (localObject != null) {
      ((a)localObject).dwH();
    }
    localObject = this.wAz;
    if (localObject != null)
    {
      ((a)localObject).dwI();
      AppMethodBeat.o(75921);
      return;
    }
    AppMethodBeat.o(75921);
  }
  
  public final void dwG()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(75924);
    StringBuilder localStringBuilder;
    Object localObject3;
    if (this.wAw != null)
    {
      localStringBuilder = new StringBuilder();
      localObject3 = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
      if (!bs.isNullOrNil(com.tencent.mm.plugin.recordvideo.model.audio.c.dvI().Sl())) {
        break label133;
      }
      localObject3 = this.wAw;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((AudioCacheInfo)localObject3).wri);
      }
      localStringBuilder.append(localObject1).append(":1:").append(System.currentTimeMillis() - this.wAx);
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.dvI();
      localObject2 = ((fs)localObject1).Sl();
      ((fs)localObject1).nl((String)localObject2 + localStringBuilder.toString());
      AppMethodBeat.o(75924);
      return;
      label133:
      localObject2 = localStringBuilder.append(";");
      localObject3 = this.wAw;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((AudioCacheInfo)localObject3).wri);
      }
      ((StringBuilder)localObject2).append(localObject1).append(":1:").append(System.currentTimeMillis() - this.wAx);
    }
  }
  
  public final a getCallback()
  {
    return this.wAz;
  }
  
  public final long getMRelatedRecId()
  {
    return this.wAy;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75927);
    this.wAt = 0;
    this.wAu = -1;
    this.wAs = 0L;
    Object localObject = this.lKB;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.wAl;
    if (localObject != null) {
      ((EditText)localObject).setText(null);
    }
    localObject = this.wAr;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).setSelection(null);
    }
    localObject = this.wAm;
    if (localObject != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject).ca(((Integer)locala.lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    }
    localObject = this.wAr;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).eQ((List)new LinkedList());
    }
    dwE();
    this.wAv = null;
    this.wAw = null;
    this.wAx = 0L;
    AppMethodBeat.o(75927);
  }
  
  public final void setCallback(a parama)
  {
    this.wAz = parama;
  }
  
  public final void setMRelatedRecId(long paramLong)
  {
    this.wAy = paramLong;
  }
  
  public final void setMusicPlayer(com.google.android.exoplayer2.v paramv)
  {
    AppMethodBeat.i(75926);
    k.h(paramv, "player");
    com.tencent.mm.plugin.recordvideo.ui.a.a locala = this.wAr;
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
    com.tencent.mm.plugin.recordvideo.ui.a.a locala = this.wAr;
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
      localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
      com.tencent.mm.plugin.recordvideo.model.audio.c.dvI().kl(this.wAy);
      setVisibility(0);
      animate().translationY(0.0F).start();
      localObject = this.wAl;
      if (localObject != null)
      {
        ((EditText)localObject).requestFocus();
        AppMethodBeat.o(75925);
        return;
      }
      AppMethodBeat.o(75925);
      return;
    }
    animate().translationY(this.wAg).withEndAction((Runnable)new m(this)).start();
    Object localObject = this.wAl;
    if (localObject != null)
    {
      ((EditText)localObject).clearFocus();
      AppMethodBeat.o(75925);
      return;
    }
    AppMethodBeat.o(75925);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "", "onPauseAudio", "", "onSearchAudioCancel", "onSearchAudioFinish", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "onSearchAudioSelected", "plugin-recordvideo_release"})
  public static abstract interface a
  {
    public abstract void c(AudioCacheInfo paramAudioCacheInfo);
    
    public abstract void dwH();
    
    public abstract void dwI();
    
    public abstract void e(AudioCacheInfo paramAudioCacheInfo);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MMSPRBgmSearchResp;", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(EditorAudioSearchView paramEditorAudioSearchView, boolean paramBoolean) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(75905);
      paramView = EditorAudioSearchView.a(this.wAB);
      if (paramView != null)
      {
        paramView = paramView.getText();
        if (paramView != null)
        {
          if (((CharSequence)paramView).length() == 0) {}
          for (int i = 1; i == 0; i = 0)
          {
            paramView = EditorAudioSearchView.a(this.wAB);
            if (paramView == null) {
              break;
            }
            paramView.setText(null);
            AppMethodBeat.o(75905);
            return;
          }
        }
      }
      AppMethodBeat.o(75905);
      return;
      AppMethodBeat.o(75905);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(75906);
      EditorAudioSearchView.b(this.wAB);
      AppMethodBeat.o(75906);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(75907);
      paramView = EditorAudioSearchView.c(this.wAB);
      if (paramView != null)
      {
        if ((EditorAudioSearchView.d(this.wAB) == -1) || (EditorAudioSearchView.d(this.wAB) >= paramView.getItemCount())) {
          break label126;
        }
        EditorAudioSearchView.a locala = this.wAB.getCallback();
        if (locala != null) {
          locala.c(paramView.Mr(EditorAudioSearchView.d(this.wAB)));
        }
        EditorAudioSearchView.f(this.wAB);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
        com.tencent.mm.plugin.recordvideo.model.audio.c.dvI().ki(0L);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
        c.a.dvJ();
      }
      for (;;)
      {
        this.wAB.reset();
        paramView = EditorAudioSearchView.a(this.wAB);
        if (paramView == null) {
          break;
        }
        paramView.clearFocus();
        AppMethodBeat.o(75907);
        return;
        label126:
        paramView = this.wAB.getCallback();
        if (paramView != null) {
          paramView.c(null);
        }
        EditorAudioSearchView.f(this.wAB);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
        com.tencent.mm.plugin.recordvideo.model.audio.c.dvI().ki(1L);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
        c.a.dvJ();
      }
      AppMethodBeat.o(75907);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
  static final class f
    implements View.OnFocusChangeListener
  {
    f(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onFocusChange(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(75908);
      EditorAudioSearchView.a(this.wAB, paramBoolean);
      AppMethodBeat.o(75908);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$5", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "plugin-recordvideo_release"})
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
        paramEditable = EditorAudioSearchView.g(this.wAB);
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
      paramEditable = EditorAudioSearchView.g(this.wAB);
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "keyEvent", "Landroid/view/KeyEvent;", "onEditorAction"})
  static final class h
    implements TextView.OnEditorActionListener
  {
    h(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(75910);
      if (3 == paramInt)
      {
        if (EditorAudioSearchView.h(this.wAB) != null)
        {
          String str = EditorAudioSearchView.h(this.wAB);
          k.g(paramTextView, "textView");
          paramKeyEvent = paramTextView.getText();
          if (paramKeyEvent == null) {
            break label399;
          }
          paramKeyEvent = paramKeyEvent.toString();
          if (!bs.lr(str, paramKeyEvent))
          {
            EditorAudioSearchView.f(this.wAB);
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
            com.tencent.mm.plugin.recordvideo.model.audio.c.dvI().ki(2L);
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
            c.a.dvJ();
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
            com.tencent.mm.plugin.recordvideo.model.audio.c.dvI().kl(this.wAB.getMRelatedRecId());
          }
        }
        paramKeyEvent = this.wAB;
        k.g(paramTextView, "textView");
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
        if (!bs.isNullOrNil(EditorAudioSearchView.h(this.wAB)))
        {
          paramTextView = EditorAudioSearchView.c(this.wAB);
          if (paramTextView != null) {
            paramTextView.setSelection(null);
          }
          paramTextView = EditorAudioSearchView.c(this.wAB);
          if (paramTextView != null) {
            paramTextView.setSelection(null);
          }
          paramTextView = EditorAudioSearchView.i(this.wAB);
          if (paramTextView != null)
          {
            paramKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(paramTextView, paramKeyEvent.aeD(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$6", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
            paramTextView.ca(((Integer)paramKeyEvent.lR(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(paramTextView, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$6", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          }
          paramTextView = EditorAudioSearchView.c(this.wAB);
          if (paramTextView != null) {
            paramTextView.eQ((List)new LinkedList());
          }
          paramTextView = EditorAudioSearchView.j(this.wAB);
          if (paramTextView != null) {
            paramTextView.setEnabled(false);
          }
          EditorAudioSearchView.a(this.wAB, 0L);
          EditorAudioSearchView.e(this.wAB);
          EditorAudioSearchView.a(this.wAB, 0);
          paramTextView = EditorAudioSearchView.c(this.wAB);
          if (paramTextView != null) {
            paramTextView.wzP = EditorAudioSearchView.h(this.wAB);
          }
          EditorAudioSearchView.m(this.wAB);
          EditorAudioSearchView.n(this.wAB);
          EditorAudioSearchView.o(this.wAB);
          EditorAudioSearchView.b(this.wAB, false);
          paramTextView = this.wAB.getCallback();
          if (paramTextView != null) {
            paramTextView.dwH();
          }
        }
        AppMethodBeat.o(75910);
        return false;
        paramKeyEvent = null;
        break;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "invoke"})
  static final class i
    extends d.g.b.l
    implements m<Integer, AudioCacheInfo, y>
  {
    i(EditorAudioSearchView paramEditorAudioSearchView)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(75912);
      EditorAudioSearchView.b(this.wAB);
      AppMethodBeat.o(75912);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-recordvideo_release"})
  public static final class l
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199418);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt1);
      localb.lS(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(199418);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(75915);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      k.h(paramRecyclerView, "recyclerView");
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
        paramInt = ((LinearLayoutManager)paramRecyclerView).jY();
        paramRecyclerView = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
        com.tencent.mm.plugin.recordvideo.model.audio.c.dvI().kj(paramInt);
        paramRecyclerView = EditorAudioSearchView.c(this.wAB);
        if ((paramRecyclerView != null) && (paramInt == paramRecyclerView.getItemCount() - 1))
        {
          paramRecyclerView = paramRecyclerView.Mr(paramInt);
          if (paramRecyclerView != null)
          {
            paramInt = paramRecyclerView.type;
            paramRecyclerView = AudioCacheInfo.wry;
            if (paramInt == AudioCacheInfo.dvA()) {
              EditorAudioSearchView.b(this.wAB, true);
            }
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(75915);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void run()
    {
      AppMethodBeat.i(75916);
      this.wAB.setVisibility(8);
      AppMethodBeat.o(75916);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void run()
    {
      AppMethodBeat.i(75917);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.wAB.getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)EditorAudioSearchView.a(this.wAB), 0);
        AppMethodBeat.o(75917);
        return;
      }
      AppMethodBeat.o(75917);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView
 * JD-Core Version:    0.7.0.1
 */