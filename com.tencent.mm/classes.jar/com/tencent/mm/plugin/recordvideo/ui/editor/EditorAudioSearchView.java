package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.Point;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.nc;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.c.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;)V", "mAdapter", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "mClickClosePanel", "Landroid/view/View;", "mCloseBtn", "Landroid/widget/TextView;", "mEditCleanBtn", "Landroid/widget/ImageView;", "mEditView", "Landroid/widget/EditText;", "mFinishBtn", "Landroid/widget/Button;", "mLastSelectItem", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mLastSelectTimestamp", "", "mRelatedRecId", "getMRelatedRecId", "()J", "setMRelatedRecId", "(J)V", "mScrollListener", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1;", "mSearchIcon", "mSearchNoResultTv", "mSearchOffset", "mSearchPanel", "mSearchRequestId", "mSearchResultView", "Landroidx/recyclerview/widget/RecyclerView;", "mSearchString", "mSearchingView", "Landroid/widget/LinearLayout;", "mSelectedPosition", "mTagsPanel", "mTranslateOffset", "showImeRunnable", "Ljava/lang/Runnable;", "back", "", "backAndPausePlayer", "", "cleanAndPausePlayer", "doSearch", "loadMore", "handleResult", "audioList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "init", "isShow", "reportSelect", "reset", "resetStyle", "bgResId", "textColor", "text", "textCursor", "recMusicIconResId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "selectItem", "position", "selectSearchItem", "setImeVisibility", "visible", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setSelection", "(Ljava/lang/Integer;)V", "setShow", "showNoResult", "showResultList", "Ljava/util/ArrayList;", "showSearchPanel", "showSearching", "showTagsPanel", "AudioSearchCallback", "plugin-recordvideo_release"})
public final class EditorAudioSearchView
  extends RelativeLayout
{
  private View HXA;
  private View HXB;
  private TextView HXC;
  EditText HXD;
  private RecyclerView HXE;
  private TextView HXF;
  private LinearLayout HXG;
  private ImageView HXH;
  private ImageView HXI;
  com.tencent.mm.plugin.recordvideo.ui.a.a HXJ;
  private long HXK;
  private int HXL;
  int HXM;
  private String HXN;
  private AudioCacheInfo HXO;
  private long HXP;
  private long HXQ;
  private a HXR;
  private final l HXS;
  private int HXy;
  private View HXz;
  final String TAG;
  Button qCl;
  private final Runnable vao;
  
  public EditorAudioSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75929);
    this.TAG = "MicroMsg.EditorAudioSearchView";
    this.HXM = -1;
    this.HXS = new l(this);
    this.vao = ((Runnable)new n(this));
    init();
    AppMethodBeat.o(75929);
  }
  
  public EditorAudioSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75930);
    this.TAG = "MicroMsg.EditorAudioSearchView";
    this.HXM = -1;
    this.HXS = new l(this);
    this.vao = ((Runnable)new n(this));
    init();
    AppMethodBeat.o(75930);
  }
  
  private final void fyg()
  {
    AppMethodBeat.i(75921);
    fyj();
    Object localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
    com.tencent.mm.plugin.recordvideo.model.audio.c.fwz().yP(1L);
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
    c.a.fwA();
    reset();
    localObject = this.HXD;
    if (localObject != null) {
      ((EditText)localObject).clearFocus();
    }
    localObject = this.HXR;
    if (localObject != null) {
      ((a)localObject).fyl();
    }
    localObject = this.HXR;
    if (localObject != null)
    {
      ((a)localObject).ehD();
      AppMethodBeat.o(75921);
      return;
    }
    AppMethodBeat.o(75921);
  }
  
  private final void fyh()
  {
    AppMethodBeat.i(75922);
    View localView = this.HXz;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.HXA;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(75922);
      return;
    }
    AppMethodBeat.o(75922);
  }
  
  private final void fyi()
  {
    AppMethodBeat.i(75923);
    Object localObject = this.HXG;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
    localObject = this.HXE;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(8);
    }
    localObject = this.HXF;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      AppMethodBeat.o(75923);
      return;
    }
    AppMethodBeat.o(75923);
  }
  
  private final void fyj()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(75924);
    StringBuilder localStringBuilder;
    Object localObject3;
    if (this.HXO != null)
    {
      localStringBuilder = new StringBuilder();
      localObject3 = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
      if (!Util.isNullOrNil(com.tencent.mm.plugin.recordvideo.model.audio.c.fwz().anP())) {
        break label133;
      }
      localObject3 = this.HXO;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((AudioCacheInfo)localObject3).HLC);
      }
      localStringBuilder.append(localObject1).append(":1:").append(System.currentTimeMillis() - this.HXP);
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.fwz();
      localObject2 = ((nc)localObject1).anP();
      ((nc)localObject1).DR((String)localObject2 + localStringBuilder.toString());
      AppMethodBeat.o(75924);
      return;
      label133:
      localObject2 = localStringBuilder.append(";");
      localObject3 = this.HXO;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((AudioCacheInfo)localObject3).HLC);
      }
      ((StringBuilder)localObject2).append(localObject1).append(":1:").append(System.currentTimeMillis() - this.HXP);
    }
  }
  
  private final void init()
  {
    AppMethodBeat.i(75918);
    View.inflate(getContext(), b.f.story_editor_audio_search_layout, (ViewGroup)this);
    this.HXC = ((TextView)findViewById(b.e.story_editor_audio_search_close));
    this.HXD = ((EditText)findViewById(b.e.story_editor_audio_search_edit));
    this.qCl = ((Button)findViewById(b.e.story_editor_audio_search_finish));
    this.HXE = ((RecyclerView)findViewById(b.e.story_editor_audio_search_result));
    this.HXF = ((TextView)findViewById(b.e.story_editor_audio_search_no_result));
    this.HXG = ((LinearLayout)findViewById(b.e.story_editor_audio_search_loading_layout));
    this.HXH = ((ImageView)findViewById(b.e.story_editor_audio_search_edit_clean));
    this.HXz = findViewById(b.e.story_editor_audio_search_tag_layout);
    this.HXA = findViewById(b.e.story_editor_audio_search_result_layout);
    this.HXB = findViewById(b.e.story_editor_audio_search_click_close_area);
    this.HXI = ((ImageView)findViewById(b.e.story_editor_audio_search_edit_icon));
    Object localObject = this.HXI;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(au.o(getContext(), b.g.icons_filled_search, com.tencent.mm.ci.a.w(getContext(), b.b.video_editor_white_color)));
    }
    localObject = this.qCl;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.HXH;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(au.o(getContext(), b.g.icons_filled_close2, com.tencent.mm.ci.a.w(getContext(), b.b.video_editor_white_color)));
    }
    localObject = this.HXH;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new EditorAudioSearchView.c(this));
    }
    localObject = this.HXE;
    if (localObject != null) {}
    for (localObject = ((RecyclerView)localObject).getLayoutParams(); localObject == null; localObject = null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(75918);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (ax.aB(getContext()) + com.tencent.mm.ci.a.fromDPToPix(getContext(), 16));
    localObject = this.HXE;
    if (localObject != null)
    {
      getContext();
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    localObject = this.HXE;
    if (localObject != null) {
      ((RecyclerView)localObject).a((RecyclerView.l)this.HXS);
    }
    this.HXJ = new com.tencent.mm.plugin.recordvideo.ui.a.a();
    localObject = this.HXE;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.HXJ);
    }
    localObject = this.HXC;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new EditorAudioSearchView.d(this));
    }
    localObject = this.qCl;
    if (localObject != null) {
      ((Button)localObject).setOnClickListener((View.OnClickListener)new e(this));
    }
    localObject = this.HXD;
    if (localObject != null) {
      ((EditText)localObject).setOnFocusChangeListener((View.OnFocusChangeListener)new f(this));
    }
    localObject = this.HXD;
    if (localObject != null) {
      ((EditText)localObject).addTextChangedListener((TextWatcher)new g(this));
    }
    localObject = this.HXD;
    if (localObject != null) {
      ((EditText)localObject).setOnEditorActionListener((TextView.OnEditorActionListener)new h(this));
    }
    localObject = this.HXJ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).uYj = ((m)new i(this));
    }
    localObject = this.HXB;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new EditorAudioSearchView.j(this));
    }
    setOnClickListener((View.OnClickListener)EditorAudioSearchView.k.HXV);
    this.HXy = ax.au(getContext()).y;
    setTranslationY(this.HXy);
    fyh();
    AppMethodBeat.o(75918);
  }
  
  private final void setImeVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(75920);
    if (paramBoolean)
    {
      post(this.vao);
      AppMethodBeat.o(75920);
      return;
    }
    removeCallbacks(this.vao);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      AppMethodBeat.o(75920);
      return;
    }
    AppMethodBeat.o(75920);
  }
  
  public final void acD(int paramInt)
  {
    AppMethodBeat.i(75919);
    Object localObject1 = this.HXJ;
    int i;
    Object localObject2;
    if ((localObject1 == null) || (((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject1).bFx != paramInt))
    {
      this.HXM = paramInt;
      localObject1 = this.HXJ;
      if (localObject1 == null) {
        break label102;
      }
      localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject1).acC(paramInt);
      if (localObject1 == null) {
        break label107;
      }
      i = ((AudioCacheInfo)localObject1).type;
      localObject2 = AudioCacheInfo.HMa;
      if (i != AudioCacheInfo.fwj()) {
        break label107;
      }
      localObject2 = this.HXR;
      if (localObject2 != null) {
        ((a)localObject2).f(null);
      }
    }
    for (;;)
    {
      this.HXO = ((AudioCacheInfo)localObject1);
      this.HXP = System.currentTimeMillis();
      AppMethodBeat.o(75919);
      return;
      label102:
      localObject1 = null;
      break;
      label107:
      if (localObject1 != null)
      {
        i = ((AudioCacheInfo)localObject1).type;
        localObject2 = AudioCacheInfo.HMa;
        if (i == AudioCacheInfo.fwi())
        {
          localObject2 = this.HXJ;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject2).setSelection(Integer.valueOf(paramInt));
          }
          localObject2 = this.HXR;
          if (localObject2 != null) {
            ((a)localObject2).f((AudioCacheInfo)localObject1);
          }
          localObject2 = this.qCl;
          if (localObject2 != null) {
            ((Button)localObject2).setEnabled(true);
          }
          fyj();
        }
      }
    }
  }
  
  public final boolean bVd()
  {
    AppMethodBeat.i(220693);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(220693);
      return true;
    }
    AppMethodBeat.o(220693);
    return false;
  }
  
  public final boolean fyk()
  {
    AppMethodBeat.i(220705);
    if (getVisibility() == 0)
    {
      Object localObject = this.HXD;
      if (localObject != null)
      {
        localObject = ((EditText)localObject).getText();
        if (!Util.isNullOrNil((CharSequence)localObject)) {
          break label54;
        }
        fyg();
      }
      for (;;)
      {
        AppMethodBeat.o(220705);
        return true;
        localObject = null;
        break;
        label54:
        fyj();
        localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
        com.tencent.mm.plugin.recordvideo.model.audio.c.fwz().yP(1L);
        localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
        c.a.fwA();
        reset();
        localObject = this.HXR;
        if (localObject != null) {
          ((a)localObject).fyl();
        }
      }
    }
    AppMethodBeat.o(220705);
    return false;
  }
  
  public final a getCallback()
  {
    return this.HXR;
  }
  
  public final long getMRelatedRecId()
  {
    return this.HXQ;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75927);
    this.HXL = 0;
    this.HXM = -1;
    this.HXK = 0L;
    Object localObject = this.qCl;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.HXD;
    if (localObject != null) {
      ((EditText)localObject).setText(null);
    }
    localObject = this.HXJ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).setSelection(null);
    }
    localObject = this.HXE;
    if (localObject != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject).scrollToPosition(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    }
    localObject = this.HXJ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).gN((List)new LinkedList());
    }
    fyh();
    this.HXN = null;
    this.HXO = null;
    this.HXP = 0L;
    AppMethodBeat.o(75927);
  }
  
  public final void setCallback(a parama)
  {
    this.HXR = parama;
  }
  
  public final void setMRelatedRecId(long paramLong)
  {
    this.HXQ = paramLong;
  }
  
  public final void setMusicPlayer(v paramv)
  {
    AppMethodBeat.i(75926);
    p.k(paramv, "player");
    AppMethodBeat.o(75926);
  }
  
  public final void setSelection(Integer paramInteger)
  {
    AppMethodBeat.i(75928);
    com.tencent.mm.plugin.recordvideo.ui.a.a locala = this.HXJ;
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
      localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
      com.tencent.mm.plugin.recordvideo.model.audio.c.fwz().yS(this.HXQ);
      setVisibility(0);
      animate().translationY(0.0F).start();
      localObject = this.HXD;
      if (localObject != null)
      {
        ((EditText)localObject).requestFocus();
        AppMethodBeat.o(75925);
        return;
      }
      AppMethodBeat.o(75925);
      return;
    }
    animate().translationY(this.HXy).withEndAction((Runnable)new m(this)).start();
    Object localObject = this.HXD;
    if (localObject != null)
    {
      ((EditText)localObject).clearFocus();
      AppMethodBeat.o(75925);
      return;
    }
    AppMethodBeat.o(75925);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "", "onPauseAudio", "", "onSearchAudioCancel", "onSearchAudioFinish", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "onSearchAudioSelected", "plugin-recordvideo_release"})
  public static abstract interface a
  {
    public abstract void b(AudioCacheInfo paramAudioCacheInfo);
    
    public abstract void ehD();
    
    public abstract void f(AudioCacheInfo paramAudioCacheInfo);
    
    public abstract void fyl();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MMSPRBgmSearchResp;", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(EditorAudioSearchView paramEditorAudioSearchView, boolean paramBoolean) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(75907);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = EditorAudioSearchView.c(this.HXT);
      if (paramView != null)
      {
        if ((EditorAudioSearchView.d(this.HXT) == -1) || (EditorAudioSearchView.d(this.HXT) >= paramView.getItemCount())) {
          break label167;
        }
        localObject = this.HXT.getCallback();
        if (localObject != null) {
          ((EditorAudioSearchView.a)localObject).b(paramView.acC(EditorAudioSearchView.d(this.HXT)));
        }
        EditorAudioSearchView.f(this.HXT);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
        com.tencent.mm.plugin.recordvideo.model.audio.c.fwz().yP(0L);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
        c.a.fwA();
      }
      for (;;)
      {
        this.HXT.reset();
        paramView = EditorAudioSearchView.a(this.HXT);
        if (paramView != null) {
          paramView.clearFocus();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75907);
        return;
        label167:
        paramView = this.HXT.getCallback();
        if (paramView != null) {
          paramView.b(null);
        }
        EditorAudioSearchView.f(this.HXT);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
        com.tencent.mm.plugin.recordvideo.model.audio.c.fwz().yP(1L);
        paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
        c.a.fwA();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
  static final class f
    implements View.OnFocusChangeListener
  {
    f(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onFocusChange(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(75908);
      EditorAudioSearchView.a(this.HXT, paramBoolean);
      AppMethodBeat.o(75908);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$5", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "plugin-recordvideo_release"})
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
        paramEditable = EditorAudioSearchView.g(this.HXT);
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
      paramEditable = EditorAudioSearchView.g(this.HXT);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "keyEvent", "Landroid/view/KeyEvent;", "onEditorAction"})
  static final class h
    implements TextView.OnEditorActionListener
  {
    h(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(75910);
      if (3 == paramInt)
      {
        if (EditorAudioSearchView.h(this.HXT) != null)
        {
          String str = EditorAudioSearchView.h(this.HXT);
          p.j(paramTextView, "textView");
          paramKeyEvent = paramTextView.getText();
          if (paramKeyEvent == null) {
            break label399;
          }
          paramKeyEvent = paramKeyEvent.toString();
          if (!Util.isEqual(str, paramKeyEvent))
          {
            EditorAudioSearchView.f(this.HXT);
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
            com.tencent.mm.plugin.recordvideo.model.audio.c.fwz().yP(2L);
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
            c.a.fwA();
            paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
            com.tencent.mm.plugin.recordvideo.model.audio.c.fwz().yS(this.HXT.getMRelatedRecId());
          }
        }
        paramKeyEvent = this.HXT;
        p.j(paramTextView, "textView");
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
        if (!Util.isNullOrNil(EditorAudioSearchView.h(this.HXT)))
        {
          paramTextView = EditorAudioSearchView.c(this.HXT);
          if (paramTextView != null) {
            paramTextView.setSelection(null);
          }
          paramTextView = EditorAudioSearchView.c(this.HXT);
          if (paramTextView != null) {
            paramTextView.setSelection(null);
          }
          paramTextView = EditorAudioSearchView.i(this.HXT);
          if (paramTextView != null)
          {
            paramKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(paramTextView, paramKeyEvent.aFh(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$6", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
            paramTextView.scrollToPosition(((Integer)paramKeyEvent.sf(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(paramTextView, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$6", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          }
          paramTextView = EditorAudioSearchView.c(this.HXT);
          if (paramTextView != null) {
            paramTextView.gN((List)new LinkedList());
          }
          paramTextView = EditorAudioSearchView.j(this.HXT);
          if (paramTextView != null) {
            paramTextView.setEnabled(false);
          }
          EditorAudioSearchView.a(this.HXT, 0L);
          EditorAudioSearchView.e(this.HXT);
          EditorAudioSearchView.a(this.HXT, 0);
          paramTextView = EditorAudioSearchView.c(this.HXT);
          if (paramTextView != null) {
            paramTextView.HWE = EditorAudioSearchView.h(this.HXT);
          }
          EditorAudioSearchView.m(this.HXT);
          EditorAudioSearchView.n(this.HXT);
          EditorAudioSearchView.o(this.HXT);
          EditorAudioSearchView.b(this.HXT, false);
          paramTextView = this.HXT.getCallback();
          if (paramTextView != null) {
            paramTextView.fyl();
          }
        }
        AppMethodBeat.o(75910);
        return false;
        paramKeyEvent = null;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "invoke"})
  static final class i
    extends q
    implements m<Integer, AudioCacheInfo, x>
  {
    i(EditorAudioSearchView paramEditorAudioSearchView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-recordvideo_release"})
  public static final class l
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(216636);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(216636);
          throw paramRecyclerView;
        }
        paramInt = ((LinearLayoutManager)paramRecyclerView).kL();
        paramRecyclerView = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
        com.tencent.mm.plugin.recordvideo.model.audio.c.fwz().yQ(paramInt);
        paramRecyclerView = EditorAudioSearchView.c(this.HXT);
        if ((paramRecyclerView != null) && (paramInt == paramRecyclerView.getItemCount() - 1))
        {
          paramRecyclerView = paramRecyclerView.acC(paramInt);
          if (paramRecyclerView != null)
          {
            paramInt = paramRecyclerView.type;
            paramRecyclerView = AudioCacheInfo.HMa;
            if (paramInt == AudioCacheInfo.fwk()) {
              EditorAudioSearchView.b(this.HXT, true);
            }
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(216636);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(216637);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(216637);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void run()
    {
      AppMethodBeat.i(75916);
      this.HXT.setVisibility(8);
      AppMethodBeat.o(75916);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void run()
    {
      AppMethodBeat.i(75917);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.HXT.getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)EditorAudioSearchView.a(this.HXT), 0);
        AppMethodBeat.o(75917);
        return;
      }
      AppMethodBeat.o(75917);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView
 * JD-Core Version:    0.7.0.1
 */