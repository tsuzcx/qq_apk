package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.a.m;
import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.text.TextWatcher;
import android.util.AttributeSet;
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
import com.tencent.mm.cb.a;
import com.tencent.mm.g.b.a.bm;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.audio.c;
import com.tencent.mm.plugin.story.model.audio.c.a;
import com.tencent.mm.plugin.story.ui.a.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$AudioSearchCallback;", "getCallback", "()Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$AudioSearchCallback;", "setCallback", "(Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$AudioSearchCallback;)V", "mAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "mClickClosePanel", "Landroid/view/View;", "mCloseBtn", "Landroid/widget/TextView;", "mEditCleanBtn", "Landroid/widget/ImageView;", "mEditView", "Landroid/widget/EditText;", "mFinishBtn", "Landroid/widget/Button;", "mLastSelectItem", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "mLastSelectTimestamp", "", "mRelatedRecId", "getMRelatedRecId", "()J", "setMRelatedRecId", "(J)V", "mScrollListener", "com/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$mScrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$mScrollListener$1;", "mSearchIcon", "mSearchNoResultTv", "mSearchOffset", "mSearchPanel", "mSearchRequestId", "mSearchResultView", "Landroid/support/v7/widget/RecyclerView;", "mSearchString", "mSearchingView", "Landroid/widget/LinearLayout;", "mSelectedPosition", "mTagsPanel", "mTranslateOffset", "showImeRunnable", "Ljava/lang/Runnable;", "back", "", "backAndPausePlayer", "", "cleanAndPausePlayer", "doSearch", "loadMore", "handleResult", "audioList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicInfo;", "init", "isShow", "reportSelect", "reset", "resetStyle", "bgResId", "textColor", "text", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "selectItem", "position", "selectSearchItem", "setImeVisibility", "visible", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setSelection", "(Ljava/lang/Integer;)V", "setShow", "showNoResult", "showResultList", "Ljava/util/ArrayList;", "showSearchPanel", "showSearching", "showTagsPanel", "AudioSearchCallback", "plugin-story_release"})
public final class EditorAudioSearchView
  extends RelativeLayout
{
  private final String TAG;
  private ImageView jdv;
  int lK;
  private final Runnable lzz;
  public Button nJm;
  private int sNI;
  private View sNJ;
  private View sNK;
  private View sNL;
  private TextView sNM;
  private EditText sNN;
  private RecyclerView sNO;
  private TextView sNP;
  private LinearLayout sNQ;
  private ImageView sNR;
  private e sNS;
  private long sNT;
  private int sNU;
  private String sNV;
  private AudioCacheInfo sNW;
  private long sNX;
  private long sNY;
  private EditorAudioSearchView.a sNZ;
  private final l sOa;
  
  public EditorAudioSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(110499);
    this.TAG = "MicroMsg.EditorAudioSearchView";
    this.lK = -1;
    this.sOa = new l(this);
    this.lzz = ((Runnable)new EditorAudioSearchView.n(this));
    init();
    AppMethodBeat.o(110499);
  }
  
  public EditorAudioSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110500);
    this.TAG = "MicroMsg.EditorAudioSearchView";
    this.lK = -1;
    this.sOa = new l(this);
    this.lzz = ((Runnable)new EditorAudioSearchView.n(this));
    init();
    AppMethodBeat.o(110500);
  }
  
  private final void cFA()
  {
    AppMethodBeat.i(110491);
    cFD();
    Object localObject = c.swQ;
    c.cBD().dI(1L);
    localObject = c.swQ;
    c.a.cBE();
    reset();
    localObject = this.sNN;
    if (localObject != null) {
      ((EditText)localObject).clearFocus();
    }
    localObject = this.sNZ;
    if (localObject != null) {
      ((EditorAudioSearchView.a)localObject).cFE();
    }
    localObject = this.sNZ;
    if (localObject != null)
    {
      ((EditorAudioSearchView.a)localObject).cFF();
      AppMethodBeat.o(110491);
      return;
    }
    AppMethodBeat.o(110491);
  }
  
  private final void cFB()
  {
    AppMethodBeat.i(110492);
    View localView = this.sNJ;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.sNK;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(110492);
      return;
    }
    AppMethodBeat.o(110492);
  }
  
  private final void cFC()
  {
    AppMethodBeat.i(110493);
    Object localObject = this.sNQ;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
    localObject = this.sNO;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(8);
    }
    localObject = this.sNP;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      AppMethodBeat.o(110493);
      return;
    }
    AppMethodBeat.o(110493);
  }
  
  private final void cFD()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(110494);
    StringBuilder localStringBuilder;
    Object localObject3;
    if (this.sNW != null)
    {
      localStringBuilder = new StringBuilder();
      localObject3 = c.swQ;
      if (!bo.isNullOrNil(c.cBD().Gw())) {
        break label133;
      }
      localObject3 = this.sNW;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((AudioCacheInfo)localObject3).swp);
      }
      localStringBuilder.append(localObject1).append(":1:").append(System.currentTimeMillis() - this.sNX);
    }
    for (;;)
    {
      localObject1 = c.swQ;
      localObject1 = c.cBD();
      localObject2 = ((bm)localObject1).Gw();
      ((bm)localObject1).gH((String)localObject2 + localStringBuilder.toString());
      AppMethodBeat.o(110494);
      return;
      label133:
      localObject2 = localStringBuilder.append(";");
      localObject3 = this.sNW;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((AudioCacheInfo)localObject3).swp);
      }
      ((StringBuilder)localObject2).append(localObject1).append(":1:").append(System.currentTimeMillis() - this.sNX);
    }
  }
  
  private final void init()
  {
    AppMethodBeat.i(110488);
    View.inflate(getContext(), 2130970944, (ViewGroup)this);
    this.sNM = ((TextView)findViewById(2131828356));
    this.sNN = ((EditText)findViewById(2131828362));
    this.nJm = ((Button)findViewById(2131828358));
    this.sNO = ((RecyclerView)findViewById(2131828369));
    this.sNP = ((TextView)findViewById(2131828365));
    this.sNQ = ((LinearLayout)findViewById(2131828366));
    this.sNR = ((ImageView)findViewById(2131828361));
    this.sNJ = findViewById(2131828363);
    this.sNK = findViewById(2131828364);
    this.sNL = findViewById(2131828370);
    this.jdv = ((ImageView)findViewById(2131828360));
    Object localObject = this.jdv;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(aj.g(getContext(), 2131231474, -1));
    }
    localObject = this.nJm;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.sNR;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(aj.g(getContext(), 2131231447, -1));
    }
    localObject = this.sNR;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new c(this));
    }
    localObject = this.sNO;
    if (localObject != null) {}
    for (localObject = ((RecyclerView)localObject).getLayoutParams(); localObject == null; localObject = null)
    {
      localObject = new a.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(110488);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (am.fx(getContext()) + a.fromDPToPix(getContext(), 16));
    localObject = this.sNO;
    if (localObject != null)
    {
      getContext();
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    }
    localObject = this.sNO;
    if (localObject != null) {
      ((RecyclerView)localObject).a((RecyclerView.m)this.sOa);
    }
    this.sNS = new e();
    localObject = this.sNO;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.sNS);
    }
    localObject = this.sNM;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new EditorAudioSearchView.d(this));
    }
    localObject = this.nJm;
    if (localObject != null) {
      ((Button)localObject).setOnClickListener((View.OnClickListener)new EditorAudioSearchView.e(this));
    }
    localObject = this.sNN;
    if (localObject != null) {
      ((EditText)localObject).setOnFocusChangeListener((View.OnFocusChangeListener)new EditorAudioSearchView.f(this));
    }
    localObject = this.sNN;
    if (localObject != null) {
      ((EditText)localObject).addTextChangedListener((TextWatcher)new EditorAudioSearchView.g(this));
    }
    localObject = this.sNN;
    if (localObject != null) {
      ((EditText)localObject).setOnEditorActionListener((TextView.OnEditorActionListener)new EditorAudioSearchView.h(this));
    }
    localObject = this.sNS;
    if (localObject != null) {
      ((e)localObject).lxR = ((m)new EditorAudioSearchView.i(this));
    }
    localObject = this.sNL;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new EditorAudioSearchView.j(this));
    }
    setOnClickListener((View.OnClickListener)EditorAudioSearchView.k.sOd);
    this.sNI = am.hQ(getContext()).y;
    setTranslationY(this.sNI);
    cFB();
    AppMethodBeat.o(110488);
  }
  
  private final void setImeVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(110490);
    if (paramBoolean)
    {
      post(this.lzz);
      AppMethodBeat.o(110490);
      return;
    }
    removeCallbacks(this.lzz);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      AppMethodBeat.o(110490);
      return;
    }
    AppMethodBeat.o(110490);
  }
  
  public final void Gg(int paramInt)
  {
    AppMethodBeat.i(110489);
    Object localObject1 = this.sNS;
    int i;
    Object localObject2;
    if ((localObject1 == null) || (((e)localObject1).lxQ != paramInt))
    {
      this.lK = paramInt;
      localObject1 = this.sNS;
      if (localObject1 == null) {
        break label102;
      }
      localObject1 = ((e)localObject1).Gd(paramInt);
      if (localObject1 == null) {
        break label107;
      }
      i = ((AudioCacheInfo)localObject1).type;
      localObject2 = AudioCacheInfo.swC;
      if (i != AudioCacheInfo.cBw()) {
        break label107;
      }
      localObject2 = this.sNZ;
      if (localObject2 != null) {
        ((EditorAudioSearchView.a)localObject2).e(null);
      }
    }
    for (;;)
    {
      this.sNW = ((AudioCacheInfo)localObject1);
      this.sNX = System.currentTimeMillis();
      AppMethodBeat.o(110489);
      return;
      label102:
      localObject1 = null;
      break;
      label107:
      if (localObject1 != null)
      {
        i = ((AudioCacheInfo)localObject1).type;
        localObject2 = AudioCacheInfo.swC;
        if (i == AudioCacheInfo.cBv())
        {
          localObject2 = this.sNS;
          if (localObject2 != null) {
            ((e)localObject2).setSelection(Integer.valueOf(paramInt));
          }
          localObject2 = this.sNZ;
          if (localObject2 != null) {
            ((EditorAudioSearchView.a)localObject2).e((AudioCacheInfo)localObject1);
          }
          localObject2 = this.nJm;
          if (localObject2 != null) {
            ((Button)localObject2).setEnabled(true);
          }
          cFD();
        }
      }
    }
  }
  
  public final boolean Pk()
  {
    AppMethodBeat.i(151200);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(151200);
      return true;
    }
    AppMethodBeat.o(151200);
    return false;
  }
  
  public final boolean czN()
  {
    AppMethodBeat.i(151201);
    if (getVisibility() == 0)
    {
      Object localObject = this.sNN;
      if (localObject != null)
      {
        localObject = ((EditText)localObject).getText();
        if (!bo.aa((CharSequence)localObject)) {
          break label54;
        }
        cFA();
      }
      for (;;)
      {
        AppMethodBeat.o(151201);
        return true;
        localObject = null;
        break;
        label54:
        cFD();
        localObject = c.swQ;
        c.cBD().dI(1L);
        localObject = c.swQ;
        c.a.cBE();
        reset();
        localObject = this.sNZ;
        if (localObject != null) {
          ((EditorAudioSearchView.a)localObject).cFE();
        }
      }
    }
    AppMethodBeat.o(151201);
    return false;
  }
  
  public final EditorAudioSearchView.a getCallback()
  {
    return this.sNZ;
  }
  
  public final long getMRelatedRecId()
  {
    return this.sNY;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(110497);
    this.sNU = 0;
    this.lK = -1;
    this.sNT = 0L;
    Object localObject = this.nJm;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.sNN;
    if (localObject != null) {
      ((EditText)localObject).setText(null);
    }
    localObject = this.sNS;
    if (localObject != null) {
      ((e)localObject).setSelection(null);
    }
    localObject = this.sNO;
    if (localObject != null) {
      ((RecyclerView)localObject).bJ(0);
    }
    localObject = this.sNS;
    if (localObject != null) {
      ((e)localObject).dF((List)new LinkedList());
    }
    cFB();
    this.sNV = null;
    this.sNW = null;
    this.sNX = 0L;
    AppMethodBeat.o(110497);
  }
  
  public final void setCallback(EditorAudioSearchView.a parama)
  {
    this.sNZ = parama;
  }
  
  public final void setMRelatedRecId(long paramLong)
  {
    this.sNY = paramLong;
  }
  
  public final void setMusicPlayer(com.google.android.exoplayer2.v paramv)
  {
    AppMethodBeat.i(110496);
    j.q(paramv, "player");
    e locale = this.sNS;
    if (locale != null)
    {
      locale.setMusicPlayer(paramv);
      AppMethodBeat.o(110496);
      return;
    }
    AppMethodBeat.o(110496);
  }
  
  public final void setSelection(Integer paramInteger)
  {
    AppMethodBeat.i(110498);
    e locale = this.sNS;
    if (locale != null)
    {
      locale.setSelection(paramInteger);
      AppMethodBeat.o(110498);
      return;
    }
    AppMethodBeat.o(110498);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(110495);
    if (paramBoolean)
    {
      localObject = c.swQ;
      c.cBD().dL(this.sNY);
      setVisibility(0);
      animate().translationY(0.0F).start();
      localObject = this.sNN;
      if (localObject != null)
      {
        ((EditText)localObject).requestFocus();
        AppMethodBeat.o(110495);
        return;
      }
      AppMethodBeat.o(110495);
      return;
    }
    animate().translationY(this.sNI).withEndAction((Runnable)new EditorAudioSearchView.m(this)).start();
    Object localObject = this.sNN;
    if (localObject != null)
    {
      ((EditText)localObject).clearFocus();
      AppMethodBeat.o(110495);
      return;
    }
    AppMethodBeat.o(110495);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(EditorAudioSearchView paramEditorAudioSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(110476);
      paramView = EditorAudioSearchView.a(this.sOb);
      if (paramView != null)
      {
        paramView = paramView.getText();
        if (paramView != null)
        {
          if (((CharSequence)paramView).length() == 0) {}
          for (int i = 1; i == 0; i = 0)
          {
            paramView = EditorAudioSearchView.a(this.sOb);
            if (paramView == null) {
              break;
            }
            paramView.setText(null);
            AppMethodBeat.o(110476);
            return;
          }
        }
      }
      AppMethodBeat.o(110476);
      return;
      AppMethodBeat.o(110476);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$mScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-story_release"})
  public static final class l
    extends RecyclerView.m
  {
    public final void c(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(110485);
      j.q(paramRecyclerView, "recyclerView");
      super.c(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new a.v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(110485);
          throw paramRecyclerView;
        }
        paramInt = ((LinearLayoutManager)paramRecyclerView).iv();
        paramRecyclerView = c.swQ;
        c.cBD().dJ(paramInt);
        paramRecyclerView = EditorAudioSearchView.c(this.sOb);
        if (paramRecyclerView != null)
        {
          if (paramInt == paramRecyclerView.getItemCount() - 1)
          {
            paramRecyclerView = paramRecyclerView.Gd(paramInt);
            if (paramRecyclerView == null) {
              break label130;
            }
            paramInt = paramRecyclerView.type;
            paramRecyclerView = AudioCacheInfo.swC;
            if (paramInt == AudioCacheInfo.cBx()) {
              EditorAudioSearchView.b(this.sOb, true);
            }
          }
          AppMethodBeat.o(110485);
          return;
          label130:
          AppMethodBeat.o(110485);
          return;
        }
      }
      AppMethodBeat.o(110485);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView
 * JD-Core Version:    0.7.0.1
 */