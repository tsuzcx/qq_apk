package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
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
import com.tencent.mm.g.b.a.ec;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.c.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ap;
import d.g.a.m;
import d.g.b.k;
import d.y;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;)V", "mAdapter", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "mClickClosePanel", "Landroid/view/View;", "mCloseBtn", "Landroid/widget/TextView;", "mEditCleanBtn", "Landroid/widget/ImageView;", "mEditView", "Landroid/widget/EditText;", "mFinishBtn", "Landroid/widget/Button;", "mLastSelectItem", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mLastSelectTimestamp", "", "mRelatedRecId", "getMRelatedRecId", "()J", "setMRelatedRecId", "(J)V", "mScrollListener", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1;", "mSearchIcon", "mSearchNoResultTv", "mSearchOffset", "mSearchPanel", "mSearchRequestId", "mSearchResultView", "Landroid/support/v7/widget/RecyclerView;", "mSearchString", "mSearchingView", "Landroid/widget/LinearLayout;", "mSelectedPosition", "mTagsPanel", "mTranslateOffset", "showImeRunnable", "Ljava/lang/Runnable;", "back", "", "backAndPausePlayer", "", "cleanAndPausePlayer", "doSearch", "loadMore", "handleResult", "audioList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "init", "isShow", "reportSelect", "reset", "resetStyle", "bgResId", "textColor", "text", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "selectItem", "position", "selectSearchItem", "setImeVisibility", "visible", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setSelection", "(Ljava/lang/Integer;)V", "setShow", "showNoResult", "showResultList", "Ljava/util/ArrayList;", "showSearchPanel", "showSearching", "showTagsPanel", "AudioSearchCallback", "plugin-recordvideo_release"})
public final class EditorAudioSearchView
  extends RelativeLayout
{
  private final String TAG;
  private Button lkJ;
  private final Runnable oQp;
  private long vqA;
  public a vqB;
  private final l vqC;
  private int vqi;
  private View vqj;
  private View vqk;
  private View vql;
  private TextView vqm;
  public EditText vqn;
  private RecyclerView vqo;
  private TextView vqp;
  private LinearLayout vqq;
  private ImageView vqr;
  private ImageView vqs;
  private com.tencent.mm.plugin.recordvideo.ui.a.a vqt;
  private long vqu;
  private int vqv;
  int vqw;
  private String vqx;
  private AudioCacheInfo vqy;
  private long vqz;
  
  public EditorAudioSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75929);
    this.TAG = "MicroMsg.EditorAudioSearchView";
    this.vqw = -1;
    this.vqC = new l(this);
    this.oQp = ((Runnable)new EditorAudioSearchView.n(this));
    init();
    AppMethodBeat.o(75929);
  }
  
  public EditorAudioSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75930);
    this.TAG = "MicroMsg.EditorAudioSearchView";
    this.vqw = -1;
    this.vqC = new l(this);
    this.oQp = ((Runnable)new EditorAudioSearchView.n(this));
    init();
    AppMethodBeat.o(75930);
  }
  
  private final void diI()
  {
    AppMethodBeat.i(75922);
    View localView = this.vqj;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.vqk;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(75922);
      return;
    }
    AppMethodBeat.o(75922);
  }
  
  private final void diJ()
  {
    AppMethodBeat.i(75923);
    Object localObject = this.vqq;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
    localObject = this.vqo;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(8);
    }
    localObject = this.vqp;
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
    this.vqm = ((TextView)findViewById(2131305367));
    this.vqn = ((EditText)findViewById(2131305368));
    this.lkJ = ((Button)findViewById(2131305372));
    this.vqo = ((RecyclerView)findViewById(2131305378));
    this.vqp = ((TextView)findViewById(2131305376));
    this.vqq = ((LinearLayout)findViewById(2131305375));
    this.vqr = ((ImageView)findViewById(2131305369));
    this.vqj = findViewById(2131305381);
    this.vqk = findViewById(2131305379);
    this.vql = findViewById(2131305366);
    this.vqs = ((ImageView)findViewById(2131305370));
    Object localObject = this.vqs;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(am.i(getContext(), 2131690473, -1));
    }
    localObject = this.lkJ;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.vqr;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(am.i(getContext(), 2131690372, -1));
    }
    localObject = this.vqr;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new EditorAudioSearchView.c(this));
    }
    localObject = this.vqo;
    if (localObject != null) {}
    for (localObject = ((RecyclerView)localObject).getLayoutParams(); localObject == null; localObject = null)
    {
      localObject = new d.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(75918);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (ap.eb(getContext()) + com.tencent.mm.cd.a.fromDPToPix(getContext(), 16));
    localObject = this.vqo;
    if (localObject != null)
    {
      getContext();
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    }
    localObject = this.vqo;
    if (localObject != null) {
      ((RecyclerView)localObject).a((RecyclerView.m)this.vqC);
    }
    this.vqt = new com.tencent.mm.plugin.recordvideo.ui.a.a();
    localObject = this.vqo;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.vqt);
    }
    localObject = this.vqm;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new EditorAudioSearchView.d(this));
    }
    localObject = this.lkJ;
    if (localObject != null) {
      ((Button)localObject).setOnClickListener((View.OnClickListener)new e(this));
    }
    localObject = this.vqn;
    if (localObject != null) {
      ((EditText)localObject).setOnFocusChangeListener((View.OnFocusChangeListener)new EditorAudioSearchView.f(this));
    }
    localObject = this.vqn;
    if (localObject != null) {
      ((EditText)localObject).addTextChangedListener((TextWatcher)new EditorAudioSearchView.g(this));
    }
    localObject = this.vqn;
    if (localObject != null) {
      ((EditText)localObject).setOnEditorActionListener((TextView.OnEditorActionListener)new h(this));
    }
    localObject = this.vqt;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).oOb = ((m)new i(this));
    }
    localObject = this.vql;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new EditorAudioSearchView.j(this));
    }
    setOnClickListener((View.OnClickListener)EditorAudioSearchView.k.vqF);
    this.vqi = ap.cf(getContext()).y;
    setTranslationY(this.vqi);
    diI();
    AppMethodBeat.o(75918);
  }
  
  private final void setImeVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(75920);
    if (paramBoolean)
    {
      post(this.oQp);
      AppMethodBeat.o(75920);
      return;
    }
    removeCallbacks(this.oQp);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      AppMethodBeat.o(75920);
      return;
    }
    AppMethodBeat.o(75920);
  }
  
  public final void Kt(int paramInt)
  {
    AppMethodBeat.i(75919);
    Object localObject1 = this.vqt;
    int i;
    Object localObject2;
    if ((localObject1 == null) || (((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject1).rZ != paramInt))
    {
      this.vqw = paramInt;
      localObject1 = this.vqt;
      if (localObject1 == null) {
        break label102;
      }
      localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject1).Ks(paramInt);
      if (localObject1 == null) {
        break label107;
      }
      i = ((AudioCacheInfo)localObject1).type;
      localObject2 = AudioCacheInfo.viM;
      if (i != AudioCacheInfo.dhO()) {
        break label107;
      }
      localObject2 = this.vqB;
      if (localObject2 != null) {
        ((a)localObject2).d(null);
      }
    }
    for (;;)
    {
      this.vqy = ((AudioCacheInfo)localObject1);
      this.vqz = System.currentTimeMillis();
      AppMethodBeat.o(75919);
      return;
      label102:
      localObject1 = null;
      break;
      label107:
      if (localObject1 != null)
      {
        i = ((AudioCacheInfo)localObject1).type;
        localObject2 = AudioCacheInfo.viM;
        if (i == AudioCacheInfo.dhN())
        {
          localObject2 = this.vqt;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject2).setSelection(Integer.valueOf(paramInt));
          }
          localObject2 = this.vqB;
          if (localObject2 != null) {
            ((a)localObject2).d((AudioCacheInfo)localObject1);
          }
          localObject2 = this.lkJ;
          if (localObject2 != null) {
            ((Button)localObject2).setEnabled(true);
          }
          diK();
        }
      }
    }
  }
  
  public final void b(Integer paramInteger1, Integer paramInteger2)
  {
    AppMethodBeat.i(204300);
    Button localButton = this.lkJ;
    if (localButton != null)
    {
      if ((paramInteger1 != null) && (paramInteger1.intValue() != 0)) {
        localButton.setBackgroundResource(paramInteger1.intValue());
      }
      if ((paramInteger2 != null) && (paramInteger2.intValue() != 0) && ((localButton instanceof TextView))) {
        localButton.setTextColor(android.support.v4.content.b.n(localButton.getContext(), paramInteger2.intValue()));
      }
      AppMethodBeat.o(204300);
      return;
    }
    AppMethodBeat.o(204300);
  }
  
  public final void diH()
  {
    AppMethodBeat.i(75921);
    diK();
    Object localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
    com.tencent.mm.plugin.recordvideo.model.audio.c.dhX().gN(1L);
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
    c.a.dhY();
    reset();
    localObject = this.vqn;
    if (localObject != null) {
      ((EditText)localObject).clearFocus();
    }
    localObject = this.vqB;
    if (localObject != null) {
      ((a)localObject).diL();
    }
    localObject = this.vqB;
    if (localObject != null)
    {
      ((a)localObject).diM();
      AppMethodBeat.o(75921);
      return;
    }
    AppMethodBeat.o(75921);
  }
  
  public final void diK()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(75924);
    StringBuilder localStringBuilder;
    Object localObject3;
    if (this.vqy != null)
    {
      localStringBuilder = new StringBuilder();
      localObject3 = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
      if (!bt.isNullOrNil(com.tencent.mm.plugin.recordvideo.model.audio.c.dhX().RJ())) {
        break label133;
      }
      localObject3 = this.vqy;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((AudioCacheInfo)localObject3).viz);
      }
      localStringBuilder.append(localObject1).append(":1:").append(System.currentTimeMillis() - this.vqz);
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.dhX();
      localObject2 = ((ec)localObject1).RJ();
      ((ec)localObject1).kt((String)localObject2 + localStringBuilder.toString());
      AppMethodBeat.o(75924);
      return;
      label133:
      localObject2 = localStringBuilder.append(";");
      localObject3 = this.vqy;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((AudioCacheInfo)localObject3).viz);
      }
      ((StringBuilder)localObject2).append(localObject1).append(":1:").append(System.currentTimeMillis() - this.vqz);
    }
  }
  
  public final a getCallback()
  {
    return this.vqB;
  }
  
  public final long getMRelatedRecId()
  {
    return this.vqA;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75927);
    this.vqv = 0;
    this.vqw = -1;
    this.vqu = 0L;
    Object localObject = this.lkJ;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.vqn;
    if (localObject != null) {
      ((EditText)localObject).setText(null);
    }
    localObject = this.vqt;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).setSelection(null);
    }
    localObject = this.vqo;
    if (localObject != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject).ca(((Integer)locala.lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    }
    localObject = this.vqt;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).eL((List)new LinkedList());
    }
    diI();
    this.vqx = null;
    this.vqy = null;
    this.vqz = 0L;
    AppMethodBeat.o(75927);
  }
  
  public final void setCallback(a parama)
  {
    this.vqB = parama;
  }
  
  public final void setMRelatedRecId(long paramLong)
  {
    this.vqA = paramLong;
  }
  
  public final void setMusicPlayer(com.google.android.exoplayer2.v paramv)
  {
    AppMethodBeat.i(75926);
    k.h(paramv, "player");
    com.tencent.mm.plugin.recordvideo.ui.a.a locala = this.vqt;
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
    com.tencent.mm.plugin.recordvideo.ui.a.a locala = this.vqt;
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
      localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
      com.tencent.mm.plugin.recordvideo.model.audio.c.dhX().gQ(this.vqA);
      setVisibility(0);
      animate().translationY(0.0F).start();
      localObject = this.vqn;
      if (localObject != null)
      {
        ((EditText)localObject).requestFocus();
        AppMethodBeat.o(75925);
        return;
      }
      AppMethodBeat.o(75925);
      return;
    }
    animate().translationY(this.vqi).withEndAction((Runnable)new EditorAudioSearchView.m(this)).start();
    Object localObject = this.vqn;
    if (localObject != null)
    {
      ((EditText)localObject).clearFocus();
      AppMethodBeat.o(75925);
      return;
    }
    AppMethodBeat.o(75925);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "", "onPauseAudio", "", "onSearchAudioCancel", "onSearchAudioFinish", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "onSearchAudioSelected", "plugin-recordvideo_release"})
  public static abstract interface a
  {
    public abstract void c(AudioCacheInfo paramAudioCacheInfo);
    
    public abstract void d(AudioCacheInfo paramAudioCacheInfo);
    
    public abstract void diL();
    
    public abstract void diM();
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MMSPRBgmSearchResp;", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(EditorAudioSearchView paramEditorAudioSearchView, boolean paramBoolean) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(75907);
      paramView = EditorAudioSearchView.c(this.vqD);
      if (paramView != null)
      {
        if ((EditorAudioSearchView.d(this.vqD) == -1) || (EditorAudioSearchView.d(this.vqD) >= paramView.getItemCount())) {
          break label126;
        }
        EditorAudioSearchView.a locala = this.vqD.getCallback();
        if (locala != null) {
          locala.c(paramView.Ks(EditorAudioSearchView.d(this.vqD)));
        }
        EditorAudioSearchView.f(this.vqD);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
        com.tencent.mm.plugin.recordvideo.model.audio.c.dhX().gN(0L);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
        c.a.dhY();
      }
      for (;;)
      {
        this.vqD.reset();
        paramView = EditorAudioSearchView.a(this.vqD);
        if (paramView == null) {
          break;
        }
        paramView.clearFocus();
        AppMethodBeat.o(75907);
        return;
        label126:
        paramView = this.vqD.getCallback();
        if (paramView != null) {
          paramView.c(null);
        }
        EditorAudioSearchView.f(this.vqD);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
        com.tencent.mm.plugin.recordvideo.model.audio.c.dhX().gN(1L);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
        c.a.dhY();
      }
      AppMethodBeat.o(75907);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "keyEvent", "Landroid/view/KeyEvent;", "onEditorAction"})
  static final class h
    implements TextView.OnEditorActionListener
  {
    h(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(75910);
      if (3 == paramInt)
      {
        if (EditorAudioSearchView.h(this.vqD) != null)
        {
          String str = EditorAudioSearchView.h(this.vqD);
          k.g(paramTextView, "textView");
          paramKeyEvent = paramTextView.getText();
          if (paramKeyEvent == null) {
            break label399;
          }
          paramKeyEvent = paramKeyEvent.toString();
          if (!bt.kU(str, paramKeyEvent))
          {
            EditorAudioSearchView.f(this.vqD);
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
            com.tencent.mm.plugin.recordvideo.model.audio.c.dhX().gN(2L);
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
            c.a.dhY();
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
            com.tencent.mm.plugin.recordvideo.model.audio.c.dhX().gQ(this.vqD.getMRelatedRecId());
          }
        }
        paramKeyEvent = this.vqD;
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
        if (!bt.isNullOrNil(EditorAudioSearchView.h(this.vqD)))
        {
          paramTextView = EditorAudioSearchView.c(this.vqD);
          if (paramTextView != null) {
            paramTextView.setSelection(null);
          }
          paramTextView = EditorAudioSearchView.c(this.vqD);
          if (paramTextView != null) {
            paramTextView.setSelection(null);
          }
          paramTextView = EditorAudioSearchView.i(this.vqD);
          if (paramTextView != null)
          {
            paramKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(paramTextView, paramKeyEvent.adn(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$6", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
            paramTextView.ca(((Integer)paramKeyEvent.lS(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(paramTextView, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$6", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          }
          paramTextView = EditorAudioSearchView.c(this.vqD);
          if (paramTextView != null) {
            paramTextView.eL((List)new LinkedList());
          }
          paramTextView = EditorAudioSearchView.j(this.vqD);
          if (paramTextView != null) {
            paramTextView.setEnabled(false);
          }
          EditorAudioSearchView.a(this.vqD, 0L);
          EditorAudioSearchView.e(this.vqD);
          EditorAudioSearchView.a(this.vqD, 0);
          paramTextView = EditorAudioSearchView.c(this.vqD);
          if (paramTextView != null) {
            paramTextView.vpQ = EditorAudioSearchView.h(this.vqD);
          }
          EditorAudioSearchView.m(this.vqD);
          EditorAudioSearchView.n(this.vqD);
          EditorAudioSearchView.o(this.vqD);
          EditorAudioSearchView.b(this.vqD, false);
          paramTextView = this.vqD.getCallback();
          if (paramTextView != null) {
            paramTextView.diL();
          }
        }
        AppMethodBeat.o(75910);
        return false;
        paramKeyEvent = null;
        break;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "invoke"})
  static final class i
    extends d.g.b.l
    implements m<Integer, AudioCacheInfo, y>
  {
    i(EditorAudioSearchView paramEditorAudioSearchView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-recordvideo_release"})
  public static final class l
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204299);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(204299);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(75915);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
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
        paramInt = ((LinearLayoutManager)paramRecyclerView).jQ();
        paramRecyclerView = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
        com.tencent.mm.plugin.recordvideo.model.audio.c.dhX().gO(paramInt);
        paramRecyclerView = EditorAudioSearchView.c(this.vqD);
        if ((paramRecyclerView != null) && (paramInt == paramRecyclerView.getItemCount() - 1))
        {
          paramRecyclerView = paramRecyclerView.Ks(paramInt);
          if (paramRecyclerView != null)
          {
            paramInt = paramRecyclerView.type;
            paramRecyclerView = AudioCacheInfo.viM;
            if (paramInt == AudioCacheInfo.dhP()) {
              EditorAudioSearchView.b(this.vqD, true);
            }
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(75915);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView
 * JD-Core Version:    0.7.0.1
 */