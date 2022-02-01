package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
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
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kj;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.c.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;)V", "mAdapter", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "mClickClosePanel", "Landroid/view/View;", "mCloseBtn", "Landroid/widget/TextView;", "mEditCleanBtn", "Landroid/widget/ImageView;", "mEditView", "Landroid/widget/EditText;", "mFinishBtn", "Landroid/widget/Button;", "mLastSelectItem", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mLastSelectTimestamp", "", "mRelatedRecId", "getMRelatedRecId", "()J", "setMRelatedRecId", "(J)V", "mScrollListener", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1;", "mSearchIcon", "mSearchNoResultTv", "mSearchOffset", "mSearchPanel", "mSearchRequestId", "mSearchResultView", "Landroid/support/v7/widget/RecyclerView;", "mSearchString", "mSearchingView", "Landroid/widget/LinearLayout;", "mSelectedPosition", "mTagsPanel", "mTranslateOffset", "showImeRunnable", "Ljava/lang/Runnable;", "back", "", "backAndPausePlayer", "", "cleanAndPausePlayer", "doSearch", "loadMore", "handleResult", "audioList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "init", "isShow", "reportSelect", "reset", "resetStyle", "bgResId", "textColor", "text", "textCursor", "recMusicIconResId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "selectItem", "position", "selectSearchItem", "setImeVisibility", "visible", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setSelection", "(Ljava/lang/Integer;)V", "setShow", "showNoResult", "showResultList", "Ljava/util/ArrayList;", "showSearchPanel", "showSearching", "showTagsPanel", "AudioSearchCallback", "plugin-recordvideo_release"})
public final class EditorAudioSearchView
  extends RelativeLayout
{
  private int CaK;
  private View CaL;
  private View CaM;
  private View CaN;
  private TextView CaO;
  EditText CaP;
  private RecyclerView CaQ;
  private TextView CaR;
  private LinearLayout CaS;
  private ImageView CaT;
  private ImageView CaU;
  com.tencent.mm.plugin.recordvideo.ui.a.a CaV;
  int CaW;
  private String CaX;
  private AudioCacheInfo CaY;
  private long CaZ;
  private a Cba;
  private final l Cbb;
  final String TAG;
  Button nAa;
  private final Runnable ruJ;
  private int wKo;
  private long wKp;
  private long wKq;
  
  public EditorAudioSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75929);
    this.TAG = "MicroMsg.EditorAudioSearchView";
    this.CaW = -1;
    this.Cbb = new l(this);
    this.ruJ = ((Runnable)new EditorAudioSearchView.n(this));
    init();
    AppMethodBeat.o(75929);
  }
  
  public EditorAudioSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75930);
    this.TAG = "MicroMsg.EditorAudioSearchView";
    this.CaW = -1;
    this.Cbb = new l(this);
    this.ruJ = ((Runnable)new EditorAudioSearchView.n(this));
    init();
    AppMethodBeat.o(75930);
  }
  
  private final void eLL()
  {
    AppMethodBeat.i(75921);
    eLO();
    Object localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
    com.tencent.mm.plugin.recordvideo.model.audio.c.eKj().th(1L);
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
    c.a.eKk();
    reset();
    localObject = this.CaP;
    if (localObject != null) {
      ((EditText)localObject).clearFocus();
    }
    localObject = this.Cba;
    if (localObject != null) {
      ((a)localObject).eLQ();
    }
    localObject = this.Cba;
    if (localObject != null)
    {
      ((a)localObject).eLR();
      AppMethodBeat.o(75921);
      return;
    }
    AppMethodBeat.o(75921);
  }
  
  private final void eLM()
  {
    AppMethodBeat.i(75922);
    View localView = this.CaL;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.CaM;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(75922);
      return;
    }
    AppMethodBeat.o(75922);
  }
  
  private final void eLN()
  {
    AppMethodBeat.i(75923);
    Object localObject = this.CaS;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
    localObject = this.CaQ;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(8);
    }
    localObject = this.CaR;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      AppMethodBeat.o(75923);
      return;
    }
    AppMethodBeat.o(75923);
  }
  
  private final void eLO()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(75924);
    StringBuilder localStringBuilder;
    Object localObject3;
    if (this.CaY != null)
    {
      localStringBuilder = new StringBuilder();
      localObject3 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
      if (!Util.isNullOrNil(com.tencent.mm.plugin.recordvideo.model.audio.c.eKj().ain())) {
        break label133;
      }
      localObject3 = this.CaY;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((AudioCacheInfo)localObject3).BOX);
      }
      localStringBuilder.append(localObject1).append(":1:").append(System.currentTimeMillis() - this.CaZ);
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.eKj();
      localObject2 = ((kj)localObject1).ain();
      ((kj)localObject1).xF((String)localObject2 + localStringBuilder.toString());
      AppMethodBeat.o(75924);
      return;
      label133:
      localObject2 = localStringBuilder.append(";");
      localObject3 = this.CaY;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((AudioCacheInfo)localObject3).BOX);
      }
      ((StringBuilder)localObject2).append(localObject1).append(":1:").append(System.currentTimeMillis() - this.CaZ);
    }
  }
  
  private final void init()
  {
    AppMethodBeat.i(75918);
    View.inflate(getContext(), 2131496587, (ViewGroup)this);
    this.CaO = ((TextView)findViewById(2131308572));
    this.CaP = ((EditText)findViewById(2131308573));
    this.nAa = ((Button)findViewById(2131308577));
    this.CaQ = ((RecyclerView)findViewById(2131308583));
    this.CaR = ((TextView)findViewById(2131308581));
    this.CaS = ((LinearLayout)findViewById(2131308580));
    this.CaT = ((ImageView)findViewById(2131308574));
    this.CaL = findViewById(2131308586);
    this.CaM = findViewById(2131308584);
    this.CaN = findViewById(2131308571);
    this.CaU = ((ImageView)findViewById(2131308575));
    Object localObject = this.CaU;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(ar.m(getContext(), 2131690669, com.tencent.mm.cb.a.n(getContext(), 2131101307)));
    }
    localObject = this.nAa;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.CaT;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(ar.m(getContext(), 2131690515, com.tencent.mm.cb.a.n(getContext(), 2131101307)));
    }
    localObject = this.CaT;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new EditorAudioSearchView.c(this));
    }
    localObject = this.CaQ;
    if (localObject != null) {}
    for (localObject = ((RecyclerView)localObject).getLayoutParams(); localObject == null; localObject = null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(75918);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (au.aD(getContext()) + com.tencent.mm.cb.a.fromDPToPix(getContext(), 16));
    localObject = this.CaQ;
    if (localObject != null)
    {
      getContext();
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    localObject = this.CaQ;
    if (localObject != null) {
      ((RecyclerView)localObject).a((RecyclerView.l)this.Cbb);
    }
    this.CaV = new com.tencent.mm.plugin.recordvideo.ui.a.a();
    localObject = this.CaQ;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.CaV);
    }
    localObject = this.CaO;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new EditorAudioSearchView.d(this));
    }
    localObject = this.nAa;
    if (localObject != null) {
      ((Button)localObject).setOnClickListener((View.OnClickListener)new e(this));
    }
    localObject = this.CaP;
    if (localObject != null) {
      ((EditText)localObject).setOnFocusChangeListener((View.OnFocusChangeListener)new EditorAudioSearchView.f(this));
    }
    localObject = this.CaP;
    if (localObject != null) {
      ((EditText)localObject).addTextChangedListener((TextWatcher)new EditorAudioSearchView.g(this));
    }
    localObject = this.CaP;
    if (localObject != null) {
      ((EditText)localObject).setOnEditorActionListener((TextView.OnEditorActionListener)new h(this));
    }
    localObject = this.CaV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).rsD = ((m)new i(this));
    }
    localObject = this.CaN;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new EditorAudioSearchView.j(this));
    }
    setOnClickListener((View.OnClickListener)EditorAudioSearchView.k.Cbe);
    this.CaK = au.az(getContext()).y;
    setTranslationY(this.CaK);
    eLM();
    AppMethodBeat.o(75918);
  }
  
  private final void setImeVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(75920);
    if (paramBoolean)
    {
      post(this.ruJ);
      AppMethodBeat.o(75920);
      return;
    }
    removeCallbacks(this.ruJ);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      AppMethodBeat.o(75920);
      return;
    }
    AppMethodBeat.o(75920);
  }
  
  public final void VS(int paramInt)
  {
    AppMethodBeat.i(75919);
    Object localObject1 = this.CaV;
    int i;
    Object localObject2;
    if ((localObject1 == null) || (((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject1).va != paramInt))
    {
      this.CaW = paramInt;
      localObject1 = this.CaV;
      if (localObject1 == null) {
        break label102;
      }
      localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject1).VR(paramInt);
      if (localObject1 == null) {
        break label107;
      }
      i = ((AudioCacheInfo)localObject1).type;
      localObject2 = AudioCacheInfo.BPo;
      if (i != AudioCacheInfo.eJZ()) {
        break label107;
      }
      localObject2 = this.Cba;
      if (localObject2 != null) {
        ((a)localObject2).e(null);
      }
    }
    for (;;)
    {
      this.CaY = ((AudioCacheInfo)localObject1);
      this.CaZ = System.currentTimeMillis();
      AppMethodBeat.o(75919);
      return;
      label102:
      localObject1 = null;
      break;
      label107:
      if (localObject1 != null)
      {
        i = ((AudioCacheInfo)localObject1).type;
        localObject2 = AudioCacheInfo.BPo;
        if (i == AudioCacheInfo.eJY())
        {
          localObject2 = this.CaV;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject2).setSelection(Integer.valueOf(paramInt));
          }
          localObject2 = this.Cba;
          if (localObject2 != null) {
            ((a)localObject2).e((AudioCacheInfo)localObject1);
          }
          localObject2 = this.nAa;
          if (localObject2 != null) {
            ((Button)localObject2).setEnabled(true);
          }
          eLO();
        }
      }
    }
  }
  
  public final boolean bJw()
  {
    AppMethodBeat.i(237614);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(237614);
      return true;
    }
    AppMethodBeat.o(237614);
    return false;
  }
  
  public final boolean eLP()
  {
    AppMethodBeat.i(237615);
    if (getVisibility() == 0)
    {
      Object localObject = this.CaP;
      if (localObject != null)
      {
        localObject = ((EditText)localObject).getText();
        if (!Util.isNullOrNil((CharSequence)localObject)) {
          break label54;
        }
        eLL();
      }
      for (;;)
      {
        AppMethodBeat.o(237615);
        return true;
        localObject = null;
        break;
        label54:
        eLO();
        localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
        com.tencent.mm.plugin.recordvideo.model.audio.c.eKj().th(1L);
        localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
        c.a.eKk();
        reset();
        localObject = this.Cba;
        if (localObject != null) {
          ((a)localObject).eLQ();
        }
      }
    }
    AppMethodBeat.o(237615);
    return false;
  }
  
  public final a getCallback()
  {
    return this.Cba;
  }
  
  public final long getMRelatedRecId()
  {
    return this.wKq;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75927);
    this.wKo = 0;
    this.CaW = -1;
    this.wKp = 0L;
    Object localObject = this.nAa;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.CaP;
    if (localObject != null) {
      ((EditText)localObject).setText(null);
    }
    localObject = this.CaV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).setSelection(null);
    }
    localObject = this.CaQ;
    if (localObject != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    }
    localObject = this.CaV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).gj((List)new LinkedList());
    }
    eLM();
    this.CaX = null;
    this.CaY = null;
    this.CaZ = 0L;
    AppMethodBeat.o(75927);
  }
  
  public final void setCallback(a parama)
  {
    this.Cba = parama;
  }
  
  public final void setMRelatedRecId(long paramLong)
  {
    this.wKq = paramLong;
  }
  
  public final void setMusicPlayer(v paramv)
  {
    AppMethodBeat.i(75926);
    p.h(paramv, "player");
    com.tencent.mm.plugin.recordvideo.ui.a.a locala = this.CaV;
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
    com.tencent.mm.plugin.recordvideo.ui.a.a locala = this.CaV;
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
      localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
      com.tencent.mm.plugin.recordvideo.model.audio.c.eKj().tk(this.wKq);
      setVisibility(0);
      animate().translationY(0.0F).start();
      localObject = this.CaP;
      if (localObject != null)
      {
        ((EditText)localObject).requestFocus();
        AppMethodBeat.o(75925);
        return;
      }
      AppMethodBeat.o(75925);
      return;
    }
    animate().translationY(this.CaK).withEndAction((Runnable)new EditorAudioSearchView.m(this)).start();
    Object localObject = this.CaP;
    if (localObject != null)
    {
      ((EditText)localObject).clearFocus();
      AppMethodBeat.o(75925);
      return;
    }
    AppMethodBeat.o(75925);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "", "onPauseAudio", "", "onSearchAudioCancel", "onSearchAudioFinish", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "onSearchAudioSelected", "plugin-recordvideo_release"})
  public static abstract interface a
  {
    public abstract void b(AudioCacheInfo paramAudioCacheInfo);
    
    public abstract void e(AudioCacheInfo paramAudioCacheInfo);
    
    public abstract void eLQ();
    
    public abstract void eLR();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MMSPRBgmSearchResp;", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(EditorAudioSearchView paramEditorAudioSearchView, boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(75907);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = EditorAudioSearchView.c(this.Cbc);
      if (paramView != null)
      {
        if ((EditorAudioSearchView.d(this.Cbc) == -1) || (EditorAudioSearchView.d(this.Cbc) >= paramView.getItemCount())) {
          break label167;
        }
        localObject = this.Cbc.getCallback();
        if (localObject != null) {
          ((EditorAudioSearchView.a)localObject).b(paramView.VR(EditorAudioSearchView.d(this.Cbc)));
        }
        EditorAudioSearchView.f(this.Cbc);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
        com.tencent.mm.plugin.recordvideo.model.audio.c.eKj().th(0L);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
        c.a.eKk();
      }
      for (;;)
      {
        this.Cbc.reset();
        paramView = EditorAudioSearchView.a(this.Cbc);
        if (paramView != null) {
          paramView.clearFocus();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75907);
        return;
        label167:
        paramView = this.Cbc.getCallback();
        if (paramView != null) {
          paramView.b(null);
        }
        EditorAudioSearchView.f(this.Cbc);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
        com.tencent.mm.plugin.recordvideo.model.audio.c.eKj().th(1L);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
        c.a.eKk();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "keyEvent", "Landroid/view/KeyEvent;", "onEditorAction"})
  static final class h
    implements TextView.OnEditorActionListener
  {
    h(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(75910);
      if (3 == paramInt)
      {
        if (EditorAudioSearchView.h(this.Cbc) != null)
        {
          String str = EditorAudioSearchView.h(this.Cbc);
          p.g(paramTextView, "textView");
          paramKeyEvent = paramTextView.getText();
          if (paramKeyEvent == null) {
            break label399;
          }
          paramKeyEvent = paramKeyEvent.toString();
          if (!Util.isEqual(str, paramKeyEvent))
          {
            EditorAudioSearchView.f(this.Cbc);
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
            com.tencent.mm.plugin.recordvideo.model.audio.c.eKj().th(2L);
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
            c.a.eKk();
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
            com.tencent.mm.plugin.recordvideo.model.audio.c.eKj().tk(this.Cbc.getMRelatedRecId());
          }
        }
        paramKeyEvent = this.Cbc;
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
        if (!Util.isNullOrNil(EditorAudioSearchView.h(this.Cbc)))
        {
          paramTextView = EditorAudioSearchView.c(this.Cbc);
          if (paramTextView != null) {
            paramTextView.setSelection(null);
          }
          paramTextView = EditorAudioSearchView.c(this.Cbc);
          if (paramTextView != null) {
            paramTextView.setSelection(null);
          }
          paramTextView = EditorAudioSearchView.i(this.Cbc);
          if (paramTextView != null)
          {
            paramKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(paramTextView, paramKeyEvent.axQ(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$6", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
            paramTextView.scrollToPosition(((Integer)paramKeyEvent.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(paramTextView, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$6", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          }
          paramTextView = EditorAudioSearchView.c(this.Cbc);
          if (paramTextView != null) {
            paramTextView.gj((List)new LinkedList());
          }
          paramTextView = EditorAudioSearchView.j(this.Cbc);
          if (paramTextView != null) {
            paramTextView.setEnabled(false);
          }
          EditorAudioSearchView.a(this.Cbc, 0L);
          EditorAudioSearchView.e(this.Cbc);
          EditorAudioSearchView.a(this.Cbc, 0);
          paramTextView = EditorAudioSearchView.c(this.Cbc);
          if (paramTextView != null) {
            paramTextView.BZP = EditorAudioSearchView.h(this.Cbc);
          }
          EditorAudioSearchView.m(this.Cbc);
          EditorAudioSearchView.n(this.Cbc);
          EditorAudioSearchView.o(this.Cbc);
          EditorAudioSearchView.b(this.Cbc, false);
          paramTextView = this.Cbc.getCallback();
          if (paramTextView != null) {
            paramTextView.eLQ();
          }
        }
        AppMethodBeat.o(75910);
        return false;
        paramKeyEvent = null;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "invoke"})
  static final class i
    extends q
    implements m<Integer, AudioCacheInfo, x>
  {
    i(EditorAudioSearchView paramEditorAudioSearchView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-recordvideo_release"})
  public static final class l
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(75915);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(75915);
          throw paramRecyclerView;
        }
        paramInt = ((LinearLayoutManager)paramRecyclerView).ku();
        paramRecyclerView = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
        com.tencent.mm.plugin.recordvideo.model.audio.c.eKj().ti(paramInt);
        paramRecyclerView = EditorAudioSearchView.c(this.Cbc);
        if ((paramRecyclerView != null) && (paramInt == paramRecyclerView.getItemCount() - 1))
        {
          paramRecyclerView = paramRecyclerView.VR(paramInt);
          if (paramRecyclerView != null)
          {
            paramInt = paramRecyclerView.type;
            paramRecyclerView = AudioCacheInfo.BPo;
            if (paramInt == AudioCacheInfo.eKa()) {
              EditorAudioSearchView.b(this.Cbc, true);
            }
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(75915);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(237613);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(237613);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView
 * JD-Core Version:    0.7.0.1
 */