package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.a.b;
import a.f.a.m;
import a.l;
import a.y;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.InsectRelativeLayout;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.ui.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView;", "Lcom/tencent/mm/emoji/view/InsectRelativeLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "audioAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "audioRecycler", "Landroid/support/v7/widget/RecyclerView;", "audioSearchPanel", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView;", "audioTask", "Lcom/tencent/mm/plugin/story/model/audio/AbsGetRecommendAudioTask;", "callback", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;", "getCallback", "()Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;", "setCallback", "(Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;)V", "currentMusicPostion", "destroy", "", "iconLyrics", "Landroid/widget/ImageView;", "iconMuteMusic", "iconMuteOrigin", "lyricsGroup", "Landroid/view/View;", "muteMusicGroup", "muteOrigin", "muteOriginGroup", "panel", "scrollListener", "com/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$scrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$scrollListener$1;", "searchBtn", "searchIv", "showLyrics", "taskFinished", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "withLyric", "withMusic", "addAudioList", "audioList", "", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicInfo;", "back", "checkAutoPlay", "config", "Lcom/tencent/mm/plugin/story/config/EditorConfig;", "checkShowLyrics", "getLyricsItemInfos", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "getMusicRequestId", "", "initAudioSearchPanel", "insectBottom", "bottom", "isShow", "refreshAudioList", "reset", "resetStyle", "bgResId", "textColor", "text", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "selectItem", "position", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setOnVisibleChangeCallback", "setShow", "show", "setShowAudioPanel", "setup", "videoPath", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "startTime", "endTime", "isPhotoToVideo", "showSearchPanel", "toggleLyrics", "on", "updateMusicMuteStatus", "music", "AudioCallback", "plugin-story_release"})
public final class EditorAudioView
  extends InsectRelativeLayout
{
  final String TAG;
  private b<? super Boolean, y> eTl;
  boolean qaU;
  private final View sOe;
  private final RecyclerView sOf;
  final ImageView sOg;
  final ImageView sOh;
  final ImageView sOi;
  final View sOj;
  final View sOk;
  final View sOl;
  private final ImageView sOm;
  private final View sOn;
  public final EditorAudioSearchView sOo;
  private final com.tencent.mm.plugin.story.ui.a.e sOp;
  private int sOq;
  private com.tencent.mm.plugin.story.model.audio.a sOr;
  private boolean sOs;
  boolean sOt;
  boolean sOu;
  boolean sOv;
  private EditorAudioView.a sOw;
  private final EditorAudioView.d sOx;
  boolean srg;
  
  public EditorAudioView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110532);
    AppMethodBeat.o(110532);
  }
  
  public EditorAudioView(final Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110531);
    this.TAG = "MicroMsg.EditorAudioView";
    this.sOx = new EditorAudioView.d(this);
    View.inflate(paramContext, 2130970924, (ViewGroup)this);
    paramAttributeSet = findViewById(2131828261);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_audio_panel)");
    this.sOe = paramAttributeSet;
    paramAttributeSet = findViewById(2131828262);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_esitor_search_btn)");
    this.sOn = paramAttributeSet;
    paramAttributeSet = findViewById(2131828265);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_editor_audio_recycler)");
    this.sOf = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828275);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_editor_audio_search_panel)");
    this.sOo = ((EditorAudioSearchView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828263);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_item_audio_search_icon)");
    this.sOm = ((ImageView)paramAttributeSet);
    this.sOf.setLayoutManager((RecyclerView.i)new LinearLayoutManager(0));
    this.sOp = new com.tencent.mm.plugin.story.ui.a.e();
    new android.support.v7.widget.ak().i(this.sOf);
    this.sOf.setAdapter((RecyclerView.a)this.sOp);
    paramAttributeSet = new StateListDrawable();
    Drawable localDrawable = paramContext.getResources().getDrawable(2131231474);
    paramAttributeSet.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = aj.g(paramContext, 2131231474, -1);
    paramAttributeSet.addState(new int[0], localDrawable);
    this.sOm.setImageDrawable((Drawable)paramAttributeSet);
    this.sOp.lxR = ((m)new EditorAudioView.1(this));
    this.sOf.a((RecyclerView.m)this.sOx);
    paramAttributeSet = findViewById(2131828270);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_…r_audio_mute_origin_icon)");
    this.sOg = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828269);
    a.f.b.j.p(paramAttributeSet, "findViewById<View>(R.id.…editor_audio_mute_origin)");
    this.sOj = paramAttributeSet;
    this.sOg.setImageDrawable(aj.g(paramContext, 2131232141, -1));
    this.sOj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110509);
        paramAnonymousView = this.sOy;
        if (!EditorAudioView.i(this.sOy)) {}
        for (boolean bool = true;; bool = false)
        {
          EditorAudioView.e(paramAnonymousView, bool);
          paramAnonymousView = this.sOy.getCallback();
          if (paramAnonymousView != null) {
            paramAnonymousView.kt(EditorAudioView.i(this.sOy));
          }
          if (!EditorAudioView.i(this.sOy)) {
            break;
          }
          EditorAudioView.j(this.sOy).setImageDrawable(aj.g(paramContext, 2131232142, -1));
          AppMethodBeat.o(110509);
          return;
        }
        EditorAudioView.j(this.sOy).setImageDrawable(aj.g(paramContext, 2131232141, -1));
        AppMethodBeat.o(110509);
      }
    });
    paramAttributeSet = findViewById(2131828273);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_editor_audio_lyrics_icon)");
    this.sOi = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828272);
    a.f.b.j.p(paramAttributeSet, "findViewById<View>(R.id.story_editor_audio_lyrics)");
    this.sOl = paramAttributeSet;
    paramAttributeSet = findViewById(2131828267);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_…or_audio_mute_music_icon)");
    this.sOh = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828266);
    a.f.b.j.p(paramAttributeSet, "findViewById<View>(R.id.…_editor_audio_mute_music)");
    this.sOk = paramAttributeSet;
    this.sOh.setImageDrawable(aj.g(paramContext, 2131232141, -1));
    this.sOk.setOnClickListener((View.OnClickListener)new EditorAudioView.3(this, paramContext));
    this.sOi.setImageDrawable(aj.g(paramContext, 2131232142, -1));
    this.sOl.setOnClickListener((View.OnClickListener)new EditorAudioView.4(this));
    setOnClickListener((View.OnClickListener)new EditorAudioView.5(this));
    this.sOn.setOnClickListener((View.OnClickListener)new EditorAudioView.6(this));
    this.sOe.setTranslationY(getResources().getDimension(2131428728));
    this.sOo.setCallback((EditorAudioSearchView.a)new EditorAudioView.b(this));
    AppMethodBeat.o(110531);
  }
  
  private final List<baz> getLyricsItemInfos()
  {
    AppMethodBeat.i(151206);
    Object localObject2 = this.sOp.Gd(this.sOq);
    Object localObject1 = new ArrayList();
    if (localObject2 != null)
    {
      localObject2 = ((AudioCacheInfo)localObject2).swq;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.plugin.story.ui.view.editor.item.e locale = (com.tencent.mm.plugin.story.ui.view.editor.item.e)((Iterator)localObject2).next();
          baz localbaz = new baz();
          localbaz.xqi = locale.sRe;
          localbaz.startTime = locale.startTime;
          ((ArrayList)localObject1).add(localbaz);
        }
      }
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(151206);
    return localObject1;
  }
  
  private final void mk(boolean paramBoolean)
  {
    AppMethodBeat.i(110526);
    if (!paramBoolean) {
      this.sOh.setImageDrawable(aj.g(getContext(), 2131232142, -1));
    }
    for (;;)
    {
      this.sOt = paramBoolean;
      AppMethodBeat.o(110526);
      return;
      this.sOh.setImageDrawable(aj.g(getContext(), 2131232141, -1));
    }
  }
  
  private final void ml(boolean paramBoolean)
  {
    AppMethodBeat.i(110527);
    if (paramBoolean)
    {
      this.sOo.setShow(true);
      AppMethodBeat.o(110527);
      return;
    }
    this.sOo.setShow(false);
    AppMethodBeat.o(110527);
  }
  
  private final void setShowAudioPanel(boolean paramBoolean)
  {
    AppMethodBeat.i(110525);
    if (paramBoolean)
    {
      this.sOe.setVisibility(0);
      this.sOe.animate().cancel();
      this.sOe.animate().translationY(0.0F).start();
      AppMethodBeat.o(110525);
      return;
    }
    this.sOe.animate().cancel();
    this.sOe.animate().translationY(this.sOe.getHeight()).withEndAction((Runnable)new EditorAudioView.g(this)).start();
    AppMethodBeat.o(110525);
  }
  
  public final void Gg(int paramInt)
  {
    AppMethodBeat.i(110523);
    if (this.sOp.lxQ != paramInt)
    {
      this.sOq = paramInt;
      Object localObject1 = this.sOp.Gd(paramInt);
      int i;
      if (localObject1 != null)
      {
        i = ((AudioCacheInfo)localObject1).type;
        localObject2 = AudioCacheInfo.swC;
        if (i == AudioCacheInfo.cBw())
        {
          localObject2 = this.sOw;
          if (localObject2 != null)
          {
            ((EditorAudioView.a)localObject2).a((AudioCacheInfo)localObject1);
            AppMethodBeat.o(110523);
            return;
          }
          AppMethodBeat.o(110523);
          return;
        }
      }
      if (localObject1 != null)
      {
        i = ((AudioCacheInfo)localObject1).type;
        localObject2 = AudioCacheInfo.swC;
        if (i == AudioCacheInfo.cBu())
        {
          this.sOp.setSelection(null);
          localObject2 = this.sOw;
          if (localObject2 != null) {
            ((EditorAudioView.a)localObject2).a((AudioCacheInfo)localObject1);
          }
          ml(true);
          setShowAudioPanel(false);
          AppMethodBeat.o(110523);
          return;
        }
      }
      this.sOp.setSelection(Integer.valueOf(paramInt));
      Object localObject2 = this.sOw;
      if (localObject2 != null) {
        ((EditorAudioView.a)localObject2).a((AudioCacheInfo)localObject1);
      }
      mk(true);
      if (this.sOu)
      {
        localObject1 = getLyricsItemInfos();
        localObject2 = this.sOw;
        if (localObject2 != null)
        {
          ((EditorAudioView.a)localObject2).b(true, (List)localObject1);
          AppMethodBeat.o(110523);
          return;
        }
      }
    }
    AppMethodBeat.o(110523);
  }
  
  public final boolean Pk()
  {
    AppMethodBeat.i(110529);
    if ((getVisibility() == 0) || (this.sOo.Pk()))
    {
      AppMethodBeat.o(110529);
      return true;
    }
    AppMethodBeat.o(110529);
    return false;
  }
  
  public final void a(String paramString, ArrayList<String> paramArrayList, long paramLong1, long paramLong2, boolean paramBoolean, com.tencent.mm.plugin.story.c.a parama)
  {
    AppMethodBeat.i(151208);
    a.f.b.j.q(paramString, "videoPath");
    a.f.b.j.q(paramArrayList, "imageList");
    a.f.b.j.q(parama, "config");
    if (paramBoolean) {
      this.sOj.setVisibility(8);
    }
    this.sOs = false;
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.coO().post((Runnable)new EditorAudioView.h(this, paramString, paramLong1, paramLong2, parama, paramArrayList));
    if ((parama.srg) && (((a.a)com.tencent.mm.plugin.story.c.a.a.srz.Uw()).srE))
    {
      paramBoolean = true;
      this.srg = paramBoolean;
      if (!this.srg) {
        break label213;
      }
      this.sOl.setVisibility(0);
    }
    for (;;)
    {
      this.sOp.setSelection(Integer.valueOf(-1));
      paramString = new ArrayList();
      if (this.sOp.lxQ != 0) {
        this.sOp.setSelection(Integer.valueOf(-1));
      }
      paramArrayList = AudioCacheInfo.swC;
      paramArrayList = new AudioCacheInfo();
      paramArrayList.type = AudioCacheInfo.cBw();
      paramString.add(paramArrayList);
      this.sOp.dF((List)paramString);
      AppMethodBeat.o(151208);
      return;
      paramBoolean = false;
      break;
      label213:
      this.sOl.setVisibility(8);
    }
  }
  
  public final void back()
  {
    AppMethodBeat.i(151210);
    if (!this.sOo.czN()) {
      setShow(false);
    }
    AppMethodBeat.o(151210);
  }
  
  public final EditorAudioView.a getCallback()
  {
    return this.sOw;
  }
  
  public final long getMusicRequestId()
  {
    com.tencent.mm.plugin.story.model.audio.a locala = this.sOr;
    if (locala != null) {
      return locala.swn;
    }
    return -1L;
  }
  
  public final boolean jk(int paramInt)
  {
    AppMethodBeat.i(110530);
    View localView = this.sOe;
    if (localView.getPaddingBottom() != paramInt) {
      localView.post((Runnable)new EditorAudioView.c(localView, paramInt));
    }
    AppMethodBeat.o(110530);
    return true;
  }
  
  public final void mj(boolean paramBoolean)
  {
    AppMethodBeat.i(151207);
    this.sOu = paramBoolean;
    List localList = getLyricsItemInfos();
    if (paramBoolean)
    {
      this.sOi.setImageDrawable(aj.g(getContext(), 2131232141, -1));
      locala = this.sOw;
      if (locala != null) {
        locala.b(true, localList);
      }
      mk(true);
      Gg(this.sOq);
      AppMethodBeat.o(151207);
      return;
    }
    this.sOi.setImageDrawable(aj.g(getContext(), 2131232142, -1));
    EditorAudioView.a locala = this.sOw;
    if (locala != null)
    {
      locala.b(false, localList);
      AppMethodBeat.o(151207);
      return;
    }
    AppMethodBeat.o(151207);
  }
  
  public final void setCallback(EditorAudioView.a parama)
  {
    this.sOw = parama;
  }
  
  public final void setMusicPlayer(v paramv)
  {
    AppMethodBeat.i(110524);
    a.f.b.j.q(paramv, "player");
    this.sOp.setMusicPlayer(paramv);
    this.sOo.setMusicPlayer(paramv);
    AppMethodBeat.o(110524);
  }
  
  public final void setOnVisibleChangeCallback(b<? super Boolean, y> paramb)
  {
    this.eTl = paramb;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(110528);
    if (paramBoolean)
    {
      setVisibility(0);
      localObject = this.eTl;
      if (localObject != null) {
        ((b)localObject).S(Boolean.TRUE);
      }
      this.sOe.animate().cancel();
      this.sOe.animate().translationY(0.0F).start();
      localObject = com.tencent.mm.plugin.story.model.j.svi;
      j.b.coO().post((Runnable)new EditorAudioView.e(this));
      AppMethodBeat.o(110528);
      return;
    }
    Object localObject = this.eTl;
    if (localObject != null) {
      ((b)localObject).S(Boolean.FALSE);
    }
    this.sOe.animate().cancel();
    this.sOe.animate().translationY(this.sOe.getHeight()).withEndAction((Runnable)new EditorAudioView.f(this)).start();
    AppMethodBeat.o(110528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView
 * JD-Core Version:    0.7.0.1
 */