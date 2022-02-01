package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.Point;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.mmdata.rpt.qm;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.a;
import com.tencent.mm.plugin.recordvideo.model.audio.c.a;
import com.tencent.mm.protocal.protobuf.dln;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;)V", "mAdapter", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "mClickClosePanel", "Landroid/view/View;", "mCloseBtn", "Landroid/widget/TextView;", "mEditCleanBtn", "Landroid/widget/ImageView;", "mEditView", "Landroid/widget/EditText;", "mFinishBtn", "Landroid/widget/Button;", "mLastSelectItem", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mLastSelectTimestamp", "", "mRelatedRecId", "getMRelatedRecId", "()J", "setMRelatedRecId", "(J)V", "mScrollListener", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1;", "mSearchIcon", "mSearchNoResultTv", "mSearchOffset", "mSearchPanel", "mSearchRequestId", "mSearchResultView", "Landroidx/recyclerview/widget/RecyclerView;", "mSearchString", "mSearchingView", "Landroid/widget/LinearLayout;", "mSelectedPosition", "mTagsPanel", "mTitleTv", "mTranslateOffset", "showImeRunnable", "Ljava/lang/Runnable;", "back", "", "backAndPausePlayer", "", "cleanAndPausePlayer", "doSearch", "loadMore", "handleResult", "audioList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "init", "isShow", "reportSelect", "reset", "resetStyle", "bgResId", "textColor", "text", "textCursor", "recMusicIconResId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "selectItem", "position", "selectSearchItem", "setImeVisibility", "visible", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setSelection", "(Ljava/lang/Integer;)V", "setShow", "showNoResult", "showResultList", "Ljava/util/ArrayList;", "showSearchPanel", "showSearching", "showTagsPanel", "AudioSearchCallback", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditorAudioSearchView
  extends RelativeLayout
{
  private a NUA;
  private final d NUB;
  private int NUh;
  private View NUi;
  private View NUj;
  private View NUk;
  private TextView NUl;
  EditText NUm;
  private RecyclerView NUn;
  private TextView NUo;
  private LinearLayout NUp;
  private ImageView NUq;
  private ImageView NUr;
  com.tencent.mm.plugin.recordvideo.ui.a.a NUs;
  private long NUt;
  private int NUu;
  int NUv;
  private String NUw;
  private AudioCacheInfo NUx;
  private long NUy;
  private long NUz;
  final String TAG;
  private TextView sUt;
  Button tHj;
  private final Runnable ymo;
  
  public EditorAudioSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75929);
    this.TAG = "MicroMsg.EditorAudioSearchView";
    this.NUv = -1;
    this.NUB = new d(this);
    this.ymo = new EditorAudioSearchView..ExternalSyntheticLambda9(this);
    init();
    AppMethodBeat.o(75929);
  }
  
  public EditorAudioSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75930);
    this.TAG = "MicroMsg.EditorAudioSearchView";
    this.NUv = -1;
    this.NUB = new d(this);
    this.ymo = new EditorAudioSearchView..ExternalSyntheticLambda9(this);
    init();
    AppMethodBeat.o(75930);
  }
  
  private final void Bs(boolean paramBoolean)
  {
    AppMethodBeat.i(280490);
    Log.d(this.TAG, s.X("doSearch ", this.NUw));
    if (Util.isNullOrNil(this.NUw))
    {
      AppMethodBeat.o(280490);
      return;
    }
    if (!paramBoolean)
    {
      localObject = this.NUp;
      if (localObject != null) {
        ((LinearLayout)localObject).setVisibility(0);
      }
      localObject = this.NUn;
      if (localObject != null) {
        ((RecyclerView)localObject).setVisibility(8);
      }
      localObject = this.NUo;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    long l = this.NUt;
    Object localObject = this.NUw;
    s.checkNotNull(localObject);
    new com.tencent.mm.plugin.recordvideo.model.audio.f(l, (String)localObject, this.NUu, this.NUz, (byte)0).bFJ().b(new EditorAudioSearchView..ExternalSyntheticLambda7(this, paramBoolean));
    AppMethodBeat.o(280490);
  }
  
  private static final Void a(EditorAudioSearchView paramEditorAudioSearchView, boolean paramBoolean, b.a parama)
  {
    AppMethodBeat.i(280685);
    s.u(paramEditorAudioSearchView, "this$0");
    int i = parama.errType;
    int j = parama.errCode;
    Object localObject = parama.errMsg;
    Log.i(paramEditorAudioSearchView.TAG, "LogStory: SearchdMusic callback " + i + ' ' + j + ", " + localObject);
    if ((i != 0) || (j != 0))
    {
      if (paramEditorAudioSearchView.NUu == 0) {
        paramEditorAudioSearchView.gJV();
      }
      paramEditorAudioSearchView = com.tencent.mm.vending.c.a.aguz;
      AppMethodBeat.o(280685);
      return paramEditorAudioSearchView;
    }
    parama = (dln)parama.ott;
    paramEditorAudioSearchView.NUt = parama.NII;
    paramEditorAudioSearchView.NUu += 1;
    localObject = parama.ZPz;
    s.s(localObject, "audioList");
    paramEditorAudioSearchView.f((LinkedList)localObject, paramBoolean);
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
    com.tencent.mm.plugin.recordvideo.model.audio.c.gIi().jsg = paramEditorAudioSearchView.NUt;
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.gIi();
    ((qm)localObject).jsc = ((qm)localObject).F("QueryContent", paramEditorAudioSearchView.NUw, true);
    Log.i(paramEditorAudioSearchView.TAG, s.X("get audio list ", parama));
    paramEditorAudioSearchView = com.tencent.mm.vending.c.a.aguz;
    AppMethodBeat.o(280685);
    return paramEditorAudioSearchView;
  }
  
  private static final void a(EditorAudioSearchView paramEditorAudioSearchView)
  {
    AppMethodBeat.i(280656);
    s.u(paramEditorAudioSearchView, "this$0");
    InputMethodManager localInputMethodManager = (InputMethodManager)paramEditorAudioSearchView.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput((View)paramEditorAudioSearchView.NUm, 0);
    }
    AppMethodBeat.o(280656);
  }
  
  private static final void a(EditorAudioSearchView paramEditorAudioSearchView, View paramView)
  {
    AppMethodBeat.i(280557);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramEditorAudioSearchView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramEditorAudioSearchView, "this$0");
    paramView = paramEditorAudioSearchView.NUm;
    if (paramView != null)
    {
      paramView = paramView.getText();
      if (paramView != null) {
        if (((CharSequence)paramView).length() == 0)
        {
          i = 1;
          if (i != 0) {
            break label153;
          }
        }
      }
    }
    label153:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramEditorAudioSearchView = paramEditorAudioSearchView.NUm;
        if (paramEditorAudioSearchView != null) {
          paramEditorAudioSearchView.setText(null);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(280557);
      return;
      i = 0;
      break;
    }
  }
  
  private static final void a(EditorAudioSearchView paramEditorAudioSearchView, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(280591);
    s.u(paramEditorAudioSearchView, "this$0");
    paramEditorAudioSearchView.setImeVisibility(paramBoolean);
    AppMethodBeat.o(280591);
  }
  
  private static final boolean a(EditorAudioSearchView paramEditorAudioSearchView, TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(280611);
    s.u(paramEditorAudioSearchView, "this$0");
    if (3 == paramInt)
    {
      if (paramEditorAudioSearchView.NUw != null)
      {
        String str = paramEditorAudioSearchView.NUw;
        paramKeyEvent = paramTextView.getText();
        if (paramKeyEvent != null) {
          break label393;
        }
        paramKeyEvent = null;
        if (!Util.isEqual(str, paramKeyEvent))
        {
          paramEditorAudioSearchView.gJW();
          paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
          com.tencent.mm.plugin.recordvideo.model.audio.c.gIi().jsd = 2L;
          paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
          c.a.gIj();
          paramKeyEvent = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
          com.tencent.mm.plugin.recordvideo.model.audio.c.gIi().jsh = paramEditorAudioSearchView.getMRelatedRecId();
        }
      }
      paramTextView = paramTextView.getText();
      if (paramTextView != null) {
        break label401;
      }
    }
    label393:
    label401:
    for (paramTextView = null;; paramTextView = paramTextView.toString())
    {
      paramEditorAudioSearchView.NUw = paramTextView;
      if (!Util.isNullOrNil(paramEditorAudioSearchView.NUw))
      {
        paramTextView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.aTg("KEY_SEARCH_MUSIC_COUNT_INT");
        paramTextView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        paramTextView = paramEditorAudioSearchView.NUw;
        s.checkNotNull(paramTextView);
        com.tencent.mm.plugin.recordvideo.f.c.lm("KEY_SEARCH_MUSIC_LIST_STRING", paramTextView);
        paramTextView = paramEditorAudioSearchView.NUs;
        if (paramTextView != null) {
          paramTextView.setSelection(null);
        }
        paramTextView = paramEditorAudioSearchView.NUs;
        if (paramTextView != null) {
          paramTextView.setSelection(null);
        }
        paramTextView = paramEditorAudioSearchView.NUn;
        if (paramTextView != null)
        {
          paramKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramTextView, paramKeyEvent.aYi(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "init$lambda-5", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView;Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramTextView.scrollToPosition(((Integer)paramKeyEvent.sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramTextView, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "init$lambda-5", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView;Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
        }
        paramTextView = paramEditorAudioSearchView.NUs;
        if (paramTextView != null) {
          paramTextView.jN((List)new LinkedList());
        }
        paramTextView = paramEditorAudioSearchView.tHj;
        if (paramTextView != null) {
          paramTextView.setEnabled(false);
        }
        paramEditorAudioSearchView.NUt = 0L;
        paramEditorAudioSearchView.NUv = -1;
        paramEditorAudioSearchView.NUu = 0;
        paramTextView = paramEditorAudioSearchView.NUs;
        if (paramTextView != null) {
          paramTextView.NTq = paramEditorAudioSearchView.NUw;
        }
        paramEditorAudioSearchView.NUx = null;
        paramEditorAudioSearchView.NUy = 0L;
        paramTextView = paramEditorAudioSearchView.NUi;
        if (paramTextView != null) {
          paramTextView.setVisibility(8);
        }
        paramTextView = paramEditorAudioSearchView.NUj;
        if (paramTextView != null) {
          paramTextView.setVisibility(0);
        }
        paramEditorAudioSearchView.Bs(false);
        paramEditorAudioSearchView = paramEditorAudioSearchView.getCallback();
        if (paramEditorAudioSearchView != null) {
          paramEditorAudioSearchView.gJY();
        }
      }
      AppMethodBeat.o(280611);
      return false;
      paramKeyEvent = paramKeyEvent.toString();
      break;
    }
  }
  
  private static final void b(EditorAudioSearchView paramEditorAudioSearchView, View paramView)
  {
    AppMethodBeat.i(280570);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramEditorAudioSearchView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramEditorAudioSearchView, "this$0");
    paramEditorAudioSearchView.gJT();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(280570);
  }
  
  private static final void c(EditorAudioSearchView paramEditorAudioSearchView, View paramView)
  {
    AppMethodBeat.i(280583);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramEditorAudioSearchView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramEditorAudioSearchView, "this$0");
    paramView = paramEditorAudioSearchView.NUs;
    if (paramView != null)
    {
      if ((paramEditorAudioSearchView.NUv == -1) || (paramEditorAudioSearchView.NUv >= paramView.getItemCount())) {
        break label178;
      }
      localObject = paramEditorAudioSearchView.getCallback();
      if (localObject != null) {
        ((a)localObject).b(paramView.agS(paramEditorAudioSearchView.NUv));
      }
      paramEditorAudioSearchView.gJW();
      paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
      com.tencent.mm.plugin.recordvideo.model.audio.c.gIi().jsd = 0L;
      paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
      c.a.gIj();
    }
    for (;;)
    {
      paramEditorAudioSearchView.reset();
      paramEditorAudioSearchView = paramEditorAudioSearchView.NUm;
      if (paramEditorAudioSearchView != null) {
        paramEditorAudioSearchView.clearFocus();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(280583);
      return;
      label178:
      paramView = paramEditorAudioSearchView.getCallback();
      if (paramView != null) {
        paramView.b(null);
      }
      paramEditorAudioSearchView.gJW();
      paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
      com.tencent.mm.plugin.recordvideo.model.audio.c.gIi().jsd = 1L;
      paramView = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
      c.a.gIj();
    }
  }
  
  private static final void d(EditorAudioSearchView paramEditorAudioSearchView, View paramView)
  {
    AppMethodBeat.i(280622);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramEditorAudioSearchView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramEditorAudioSearchView, "this$0");
    paramEditorAudioSearchView.gJT();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(280622);
  }
  
  private final void f(LinkedList<dls> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(280504);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ((Iterable)paramLinkedList).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (dls)localObject2;
      AudioCacheInfo.a locala = AudioCacheInfo.NIB;
      locala = AudioCacheInfo.NIB;
      localObject2 = AudioCacheInfo.a.a((dls)localObject2, AudioCacheInfo.gHR());
      locala = AudioCacheInfo.NIB;
      ((AudioCacheInfo)localObject2).source = AudioCacheInfo.gHY();
      ((AudioCacheInfo)localObject2).position = 0;
      ((AudioCacheInfo)localObject2).NII = getMRelatedRecId();
      localArrayList.add(localObject2);
      i += 1;
    }
    if (paramLinkedList.size() == 10)
    {
      localObject1 = AudioCacheInfo.NIB;
      localObject1 = new AudioCacheInfo();
      ((AudioCacheInfo)localObject1).type = AudioCacheInfo.gHT();
      localArrayList.add(localObject1);
    }
    if ((paramLinkedList.isEmpty()) && (this.NUu == 1))
    {
      gJV();
      AppMethodBeat.o(280504);
      return;
    }
    paramLinkedList = this.NUp;
    if (paramLinkedList != null) {
      paramLinkedList.setVisibility(8);
    }
    paramLinkedList = this.NUn;
    if (paramLinkedList != null) {
      paramLinkedList.setVisibility(0);
    }
    paramLinkedList = this.NUo;
    if (paramLinkedList != null) {
      paramLinkedList.setVisibility(8);
    }
    if (paramBoolean)
    {
      paramLinkedList = this.NUs;
      if (paramLinkedList != null)
      {
        paramLinkedList.jP((List)localArrayList);
        AppMethodBeat.o(280504);
      }
    }
    else
    {
      paramLinkedList = this.NUs;
      if (paramLinkedList != null) {
        paramLinkedList.jN((List)localArrayList);
      }
    }
    AppMethodBeat.o(280504);
  }
  
  private final void gJT()
  {
    AppMethodBeat.i(75921);
    gJW();
    Object localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
    com.tencent.mm.plugin.recordvideo.model.audio.c.gIi().jsd = 1L;
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
    c.a.gIj();
    reset();
    localObject = this.NUm;
    if (localObject != null) {
      ((EditText)localObject).clearFocus();
    }
    localObject = this.NUA;
    if (localObject != null) {
      ((a)localObject).gJY();
    }
    localObject = this.NUA;
    if (localObject != null) {
      ((a)localObject).fjI();
    }
    AppMethodBeat.o(75921);
  }
  
  private final void gJU()
  {
    AppMethodBeat.i(75922);
    View localView = this.NUi;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.NUj;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(75922);
  }
  
  private final void gJV()
  {
    AppMethodBeat.i(75923);
    Object localObject = this.NUp;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
    localObject = this.NUn;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(8);
    }
    localObject = this.NUo;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    AppMethodBeat.o(75923);
  }
  
  private final void gJW()
  {
    Object localObject1 = null;
    StringBuilder localStringBuilder1 = null;
    AppMethodBeat.i(75924);
    StringBuilder localStringBuilder2;
    if (this.NUx != null)
    {
      localStringBuilder2 = new StringBuilder();
      localObject2 = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
      if (!Util.isNullOrNil(com.tencent.mm.plugin.recordvideo.model.audio.c.gIi().jse)) {
        break label115;
      }
      localObject1 = this.NUx;
      if (localObject1 != null) {
        break label104;
      }
    }
    label104:
    for (localObject1 = localStringBuilder1;; localObject1 = Integer.valueOf(((AudioCacheInfo)localObject1).NID))
    {
      localStringBuilder2.append(localObject1).append(":1:").append(System.currentTimeMillis() - this.NUy);
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.gIi();
      ((qm)localObject1).xG(s.X(((qm)localObject1).jse, localStringBuilder2));
      AppMethodBeat.o(75924);
      return;
    }
    label115:
    localStringBuilder1 = localStringBuilder2.append(";");
    Object localObject2 = this.NUx;
    if (localObject2 == null) {}
    for (;;)
    {
      localStringBuilder1.append(localObject1).append(":1:").append(System.currentTimeMillis() - this.NUy);
      break;
      localObject1 = Integer.valueOf(((AudioCacheInfo)localObject2).NID);
    }
  }
  
  private static final void iI(View paramView)
  {
    AppMethodBeat.i(280638);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(280638);
  }
  
  private final void init()
  {
    AppMethodBeat.i(75918);
    View.inflate(getContext(), b.f.story_editor_audio_search_layout, (ViewGroup)this);
    this.NUl = ((TextView)findViewById(b.e.story_editor_audio_search_close));
    this.sUt = ((TextView)findViewById(b.e.story_editor_audio_search_title));
    this.NUm = ((EditText)findViewById(b.e.story_editor_audio_search_edit));
    this.tHj = ((Button)findViewById(b.e.story_editor_audio_search_finish));
    this.NUn = ((RecyclerView)findViewById(b.e.story_editor_audio_search_result));
    this.NUo = ((TextView)findViewById(b.e.story_editor_audio_search_no_result));
    this.NUp = ((LinearLayout)findViewById(b.e.story_editor_audio_search_loading_layout));
    this.NUq = ((ImageView)findViewById(b.e.story_editor_audio_search_edit_clean));
    this.NUi = findViewById(b.e.story_editor_audio_search_tag_layout);
    this.NUj = findViewById(b.e.story_editor_audio_search_result_layout);
    this.NUk = findViewById(b.e.story_editor_audio_search_click_close_area);
    this.NUr = ((ImageView)findViewById(b.e.story_editor_audio_search_edit_icon));
    Object localObject = com.tencent.mm.plugin.recordvideo.util.a.Obi;
    localObject = getContext();
    s.s(localObject, "context");
    float f = com.tencent.mm.plugin.recordvideo.util.a.g((Context)localObject, 17.0F);
    localObject = this.NUl;
    if (localObject != null) {
      ((TextView)localObject).setTextSize(1, f);
    }
    localObject = this.sUt;
    if (localObject != null) {
      ((TextView)localObject).setTextSize(1, f);
    }
    localObject = this.tHj;
    if (localObject != null) {
      ((Button)localObject).setTextSize(1, f);
    }
    localObject = this.NUr;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(bb.m(getContext(), b.g.icons_filled_search, com.tencent.mm.cd.a.w(getContext(), b.b.story_audio_search_music_icon_normal)));
    }
    localObject = this.tHj;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.NUq;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(bb.m(getContext(), b.g.icons_filled_close2, com.tencent.mm.cd.a.w(getContext(), b.b.video_editor_white_color)));
    }
    localObject = this.NUq;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(new EditorAudioSearchView..ExternalSyntheticLambda3(this));
    }
    localObject = this.NUn;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((RecyclerView)localObject).getLayoutParams())
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(75918);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (bf.bk(getContext()) + com.tencent.mm.cd.a.fromDPToPix(getContext(), 16));
    localObject = this.NUn;
    if (localObject != null)
    {
      getContext();
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    localObject = this.NUn;
    if (localObject != null) {
      ((RecyclerView)localObject).a((RecyclerView.l)this.NUB);
    }
    this.NUs = new com.tencent.mm.plugin.recordvideo.ui.a.a();
    localObject = this.NUn;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.NUs);
    }
    localObject = this.NUl;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new EditorAudioSearchView..ExternalSyntheticLambda1(this));
    }
    localObject = this.tHj;
    if (localObject != null) {
      ((Button)localObject).setOnClickListener(new EditorAudioSearchView..ExternalSyntheticLambda2(this));
    }
    localObject = this.NUm;
    if (localObject != null) {
      ((EditText)localObject).setOnFocusChangeListener(new EditorAudioSearchView..ExternalSyntheticLambda5(this));
    }
    localObject = this.NUm;
    if (localObject != null) {
      ((EditText)localObject).addTextChangedListener((TextWatcher)new EditorAudioSearchView.b(this));
    }
    localObject = this.NUm;
    if (localObject != null) {
      ((EditText)localObject).setOnEditorActionListener(new EditorAudioSearchView..ExternalSyntheticLambda6(this));
    }
    localObject = this.NUs;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).ykx = ((m)new c(this));
    }
    localObject = this.NUk;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new EditorAudioSearchView..ExternalSyntheticLambda0(this));
    }
    setOnClickListener(EditorAudioSearchView..ExternalSyntheticLambda4.INSTANCE);
    this.NUh = bf.bf(getContext()).y;
    setTranslationY(this.NUh);
    gJU();
    AppMethodBeat.o(75918);
  }
  
  private final void setImeVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(75920);
    if (paramBoolean)
    {
      post(this.ymo);
      AppMethodBeat.o(75920);
      return;
    }
    removeCallbacks(this.ymo);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
    AppMethodBeat.o(75920);
  }
  
  private static final void setShow$lambda-12(EditorAudioSearchView paramEditorAudioSearchView)
  {
    AppMethodBeat.i(280696);
    s.u(paramEditorAudioSearchView, "this$0");
    paramEditorAudioSearchView.setVisibility(8);
    AppMethodBeat.o(280696);
  }
  
  public final void agT(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(75919);
    Object localObject1 = this.NUs;
    int i;
    label53:
    Object localObject2;
    if ((localObject1 != null) && (((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject1).dyx == paramInt))
    {
      i = 1;
      if (i == 0)
      {
        this.NUv = paramInt;
        localObject1 = this.NUs;
        if (localObject1 != null) {
          break label126;
        }
        localObject1 = null;
        if (localObject1 == null) {
          break label137;
        }
        i = ((AudioCacheInfo)localObject1).type;
        localObject2 = AudioCacheInfo.NIB;
        if (i != AudioCacheInfo.gHS()) {
          break label137;
        }
        i = 1;
        label78:
        if (i == 0) {
          break label142;
        }
        localObject2 = this.NUA;
        if (localObject2 != null) {
          ((a)localObject2).f(null);
        }
      }
    }
    for (;;)
    {
      this.NUx = ((AudioCacheInfo)localObject1);
      this.NUy = System.currentTimeMillis();
      AppMethodBeat.o(75919);
      return;
      i = 0;
      break;
      label126:
      localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject1).agS(paramInt);
      break label53;
      label137:
      i = 0;
      break label78;
      label142:
      i = j;
      if (localObject1 != null)
      {
        int k = ((AudioCacheInfo)localObject1).type;
        localObject2 = AudioCacheInfo.NIB;
        i = j;
        if (k == AudioCacheInfo.gHR()) {
          i = 1;
        }
      }
      if (i != 0)
      {
        localObject2 = this.NUs;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject2).setSelection(Integer.valueOf(paramInt));
        }
        localObject2 = this.NUA;
        if (localObject2 != null) {
          ((a)localObject2).f((AudioCacheInfo)localObject1);
        }
        localObject2 = this.tHj;
        if (localObject2 != null) {
          ((Button)localObject2).setEnabled(true);
        }
        gJW();
      }
    }
  }
  
  public final boolean cvt()
  {
    AppMethodBeat.i(280938);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(280938);
      return true;
    }
    AppMethodBeat.o(280938);
    return false;
  }
  
  public final boolean gJX()
  {
    AppMethodBeat.i(280967);
    if (getVisibility() == 0)
    {
      Object localObject = this.NUm;
      if (localObject == null)
      {
        localObject = null;
        if (!Util.isNullOrNil((CharSequence)localObject)) {
          break label54;
        }
        gJT();
      }
      for (;;)
      {
        AppMethodBeat.o(280967);
        return true;
        localObject = ((EditText)localObject).getText();
        break;
        label54:
        gJW();
        localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
        com.tencent.mm.plugin.recordvideo.model.audio.c.gIi().jsd = 1L;
        localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
        c.a.gIj();
        reset();
        localObject = this.NUA;
        if (localObject != null) {
          ((a)localObject).gJY();
        }
      }
    }
    AppMethodBeat.o(280967);
    return false;
  }
  
  public final a getCallback()
  {
    return this.NUA;
  }
  
  public final long getMRelatedRecId()
  {
    return this.NUz;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75927);
    this.NUu = 0;
    this.NUv = -1;
    this.NUt = 0L;
    Object localObject = this.tHj;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.NUm;
    if (localObject != null) {
      ((EditText)localObject).setText(null);
    }
    localObject = this.NUs;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).setSelection(null);
    }
    localObject = this.NUn;
    if (localObject != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    }
    localObject = this.NUs;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).jN((List)new LinkedList());
    }
    gJU();
    this.NUw = null;
    this.NUx = null;
    this.NUy = 0L;
    AppMethodBeat.o(75927);
  }
  
  public final void setCallback(a parama)
  {
    this.NUA = parama;
  }
  
  public final void setMRelatedRecId(long paramLong)
  {
    this.NUz = paramLong;
  }
  
  public final void setMusicPlayer(v paramv)
  {
    AppMethodBeat.i(75926);
    s.u(paramv, "player");
    AppMethodBeat.o(75926);
  }
  
  public final void setSelection(Integer paramInteger)
  {
    AppMethodBeat.i(75928);
    com.tencent.mm.plugin.recordvideo.ui.a.a locala = this.NUs;
    if (locala != null) {
      locala.setSelection(paramInteger);
    }
    AppMethodBeat.o(75928);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(75925);
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
      com.tencent.mm.plugin.recordvideo.model.audio.c.gIi().jsh = this.NUz;
      setVisibility(0);
      animate().translationY(0.0F).start();
      localObject = this.NUm;
      if (localObject != null)
      {
        ((EditText)localObject).requestFocus();
        AppMethodBeat.o(75925);
      }
    }
    else
    {
      animate().translationY(this.NUh).withEndAction(new EditorAudioSearchView..ExternalSyntheticLambda8(this)).start();
      localObject = this.NUm;
      if (localObject != null) {
        ((EditText)localObject).clearFocus();
      }
    }
    AppMethodBeat.o(75925);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "", "onPauseAudio", "", "onSearchAudioCancel", "onSearchAudioFinish", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "onSearchAudioSelected", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void b(AudioCacheInfo paramAudioCacheInfo);
    
    public abstract void f(AudioCacheInfo paramAudioCacheInfo);
    
    public abstract void fjI();
    
    public abstract void gJY();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<Integer, AudioCacheInfo, ah>
  {
    c(EditorAudioSearchView paramEditorAudioSearchView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    d(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(279894);
      Object localObject = new b();
      ((b)localObject).cH(paramRecyclerView);
      ((b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(279894);
          throw paramRecyclerView;
        }
        paramInt = ((LinearLayoutManager)paramRecyclerView).Jw();
        paramRecyclerView = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
        com.tencent.mm.plugin.recordvideo.model.audio.c.gIi().jsf = paramInt;
        localObject = EditorAudioSearchView.c(this.NUC);
        if (localObject != null)
        {
          paramRecyclerView = this.NUC;
          if (paramInt == ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).getItemCount() - 1)
          {
            localObject = ((com.tencent.mm.plugin.recordvideo.ui.a.a)localObject).agS(paramInt);
            if (localObject == null) {
              break label182;
            }
            paramInt = ((AudioCacheInfo)localObject).type;
            localObject = AudioCacheInfo.NIB;
            if (paramInt != AudioCacheInfo.gHT()) {
              break label182;
            }
          }
        }
      }
      label182:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          EditorAudioSearchView.d(paramRecyclerView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(279894);
        return;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(279897);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(279897);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView
 * JD-Core Version:    0.7.0.1
 */