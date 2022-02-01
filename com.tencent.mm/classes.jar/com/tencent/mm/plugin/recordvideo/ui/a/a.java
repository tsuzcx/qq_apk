package com.tencent.mm.plugin.recordvideo.ui.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.AudioWaveView;
import com.tencent.mm.plugin.recordvideo.ui.editor.MusicLrcView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.am;
import d.a.j;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "()V", "audioList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "Lkotlin/collections/ArrayList;", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "musicPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "queryString", "", "getQueryString", "()Ljava/lang/String;", "setQueryString", "(Ljava/lang/String;)V", "selectedPosition", "addAudioList", "index", "audios", "", "addSearchAudioList", "getAllItem", "getItem", "getItemCount", "getItemViewType", "getSelection", "isEmptyNoLoading", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setMusicPlayer", "player", "setSelection", "(Ljava/lang/Integer;)V", "updateAudioList", "BaseViewHolder", "Companion", "RecommendMusicLoadingHolder", "RecommendMusicViewHolder", "SearchEntranceViewHolder", "SearchResultLoadingHolder", "SearchResultViewHolder", "plugin-recordvideo_release"})
public final class a
  extends RecyclerView.a<a>
{
  private static final String TAG = "MicroMsg.RecommendMusicAdapter";
  public static final a.b wzR;
  public m<? super Integer, ? super AudioCacheInfo, y> prv;
  public int ta;
  public final ArrayList<AudioCacheInfo> wzO;
  public String wzP;
  private v wzQ;
  
  static
  {
    AppMethodBeat.i(75893);
    wzR = new a.b((byte)0);
    TAG = "MicroMsg.RecommendMusicAdapter";
    AppMethodBeat.o(75893);
  }
  
  public a()
  {
    AppMethodBeat.i(75892);
    this.wzO = new ArrayList();
    this.ta = -1;
    AppMethodBeat.o(75892);
  }
  
  public final AudioCacheInfo Mr(int paramInt)
  {
    AppMethodBeat.i(75887);
    AudioCacheInfo localAudioCacheInfo = (AudioCacheInfo)j.C((List)this.wzO, paramInt);
    AppMethodBeat.o(75887);
    return localAudioCacheInfo;
  }
  
  public final void eQ(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(75883);
    k.h(paramList, "audios");
    this.wzO.clear();
    this.wzO.addAll((Collection)paramList);
    this.ta = -1;
    notifyDataSetChanged();
    AppMethodBeat.o(75883);
  }
  
  public final void eR(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(75884);
    k.h(paramList, "audios");
    int j = this.wzO.size();
    Object localObject1 = (List)this.wzO;
    ListIterator localListIterator = ((List)localObject1).listIterator(((List)localObject1).size());
    int i;
    if (localListIterator.hasPrevious())
    {
      localObject1 = localListIterator.previous();
      Object localObject2 = (AudioCacheInfo)localObject1;
      i = ((AudioCacheInfo)localObject2).type;
      AudioCacheInfo.a locala = AudioCacheInfo.wry;
      if (i != AudioCacheInfo.dvz())
      {
        i = ((AudioCacheInfo)localObject2).type;
        locala = AudioCacheInfo.wry;
        if (i != AudioCacheInfo.dvA())
        {
          i = ((AudioCacheInfo)localObject2).type;
          localObject2 = AudioCacheInfo.wry;
          if (i != AudioCacheInfo.dvx()) {
            break label197;
          }
        }
      }
      i = 1;
      label128:
      if (i == 0) {}
    }
    for (;;)
    {
      localObject1 = (AudioCacheInfo)localObject1;
      if (localObject1 != null) {
        this.wzO.remove(localObject1);
      }
      i = this.wzO.size();
      if (j != i) {
        break label208;
      }
      this.wzO.addAll((Collection)paramList);
      aq(j, paramList.size());
      AppMethodBeat.o(75884);
      return;
      label197:
      i = 0;
      break label128;
      break;
      localObject1 = null;
    }
    label208:
    this.wzO.addAll((Collection)paramList);
    cj(i);
    aq(j, paramList.size() - 1);
    AppMethodBeat.o(75884);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(75888);
    int i = this.wzO.size();
    AppMethodBeat.o(75888);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(75889);
    Object localObject = Mr(paramInt);
    if (localObject != null)
    {
      paramInt = ((AudioCacheInfo)localObject).type;
      AppMethodBeat.o(75889);
      return paramInt;
    }
    localObject = AudioCacheInfo.wry;
    paramInt = AudioCacheInfo.dvw();
    AppMethodBeat.o(75889);
    return paramInt;
  }
  
  public final void setMusicPlayer(v paramv)
  {
    AppMethodBeat.i(75886);
    k.h(paramv, "player");
    this.wzQ = paramv;
    AppMethodBeat.o(75886);
  }
  
  public final void setSelection(Integer paramInteger)
  {
    AppMethodBeat.i(75885);
    if (paramInteger == null)
    {
      cj(this.ta);
      this.ta = -1;
      cj(this.ta);
      AppMethodBeat.o(75885);
      return;
    }
    cj(this.ta);
    this.ta = paramInteger.intValue();
    cj(this.ta);
    AppMethodBeat.o(75885);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
  public class a
    extends RecyclerView.w
  {
    public a()
    {
      super();
      AppMethodBeat.i(75875);
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(75873);
          int i = this.wzT.lv();
          paramAnonymousView = this.wzT.wzS.Mr(i);
          if (paramAnonymousView != null)
          {
            m localm = this.wzT.wzS.prv;
            if (localm != null) {
              localm.n(Integer.valueOf(i), paramAnonymousView);
            }
          }
          localObject.requestFocus();
          AppMethodBeat.o(75873);
        }
      });
      AppMethodBeat.o(75875);
    }
    
    public void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
    {
      AppMethodBeat.i(75874);
      k.h(paramAudioCacheInfo, "info");
      AppMethodBeat.o(75874);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$RecommendMusicLoadingHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"})
  public final class c
    extends a.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(75876);
      AppMethodBeat.o(75876);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$RecommendMusicViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "loading", "getLoading", "()Landroid/view/View;", "title", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "getTitle", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "waveView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
  public final class d
    extends a.a
  {
    private final View psM;
    private final ImageView ts;
    private final MusicLrcView wzU;
    private final AudioWaveView wzV;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(75878);
      this$1 = localObject.findViewById(2131305446);
      k.g(a.this, "itemView.findViewById(R.…story_item_audio_loading)");
      this.psM = a.this;
      this$1 = localObject.findViewById(2131305447);
      k.g(a.this, "itemView.findViewById(R.…story_item_audio_preview)");
      this.ts = ((ImageView)a.this);
      this$1 = localObject.findViewById(2131305456);
      k.g(a.this, "itemView.findViewById(R.id.story_item_audio_title)");
      this.wzU = ((MusicLrcView)a.this);
      this$1 = localObject.findViewById(2131306869);
      k.g(a.this, "itemView.findViewById(R.id.waveView)");
      this.wzV = ((AudioWaveView)a.this);
      AppMethodBeat.o(75878);
    }
    
    public final void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
    {
      boolean bool = true;
      int i = -16777216;
      AppMethodBeat.i(75877);
      k.h(paramAudioCacheInfo, "info");
      Object localObject1 = this.asD;
      k.g(localObject1, "itemView");
      ((View)localObject1).setEnabled(true);
      if (paramInt == a.a(a.this))
      {
        localObject1 = this.asD;
        k.g(localObject1, "itemView");
        ((View)localObject1).setSelected(bool);
        ac.i(a.access$getTAG$cp(), "LogStory: ".concat(String.valueOf(bool)));
        localObject1 = this.ts;
        Object localObject2 = this.asD;
        k.g(localObject2, "itemView");
        localObject2 = ((View)localObject2).getContext();
        if (!bool) {
          break label221;
        }
        paramInt = -16777216;
        label117:
        ((ImageView)localObject1).setImageDrawable(am.k((Context)localObject2, 2131690438, paramInt));
        this.ts.setVisibility(0);
        this.wzV.setVisibility(0);
        this.wzV.setShow(bool);
        MusicLrcView.a(this.wzU, paramAudioCacheInfo.wrj);
        this.wzU.setShow(bool);
        paramAudioCacheInfo = this.wzU;
        if (!bool) {
          break label226;
        }
      }
      label221:
      label226:
      for (paramInt = i;; paramInt = -1)
      {
        paramAudioCacheInfo.setTextColor(paramInt);
        this.wzU.setVisibility(0);
        this.psM.setVisibility(8);
        AppMethodBeat.o(75877);
        return;
        bool = false;
        break;
        paramInt = -1;
        break label117;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchEntranceViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"})
  public final class e
    extends a.a
  {
    public e()
    {
      super(localObject);
      AppMethodBeat.i(75879);
      AppMethodBeat.o(75879);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchResultLoadingHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"})
  public final class f
    extends a.a
  {
    public f()
    {
      super(localObject);
      AppMethodBeat.i(75880);
      AppMethodBeat.o(75880);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchResultViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "searchTipView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "getSearchTipView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "searchTitleView", "Landroid/widget/TextView;", "getSearchTitleView", "()Landroid/widget/TextView;", "searchresultIcon", "Landroid/widget/ImageView;", "getSearchresultIcon", "()Landroid/widget/ImageView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
  public final class g
    extends a.a
  {
    private final ImageView wzW;
    private final TextView wzX;
    private final MusicLrcView wzY;
    
    public g()
    {
      super(localObject);
      AppMethodBeat.i(75882);
      this$1 = localObject.findViewById(2131305451);
      k.g(a.this, "itemView.findViewById(R.…audio_search_result_icon)");
      this.wzW = ((ImageView)a.this);
      this$1 = localObject.findViewById(2131305453);
      k.g(a.this, "itemView.findViewById(R.…udio_search_result_title)");
      this.wzX = ((TextView)a.this);
      this$1 = localObject.findViewById(2131305452);
      k.g(a.this, "itemView.findViewById(R.…_audio_search_result_tip)");
      this.wzY = ((MusicLrcView)a.this);
      AppMethodBeat.o(75882);
    }
    
    public final void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
    {
      AppMethodBeat.i(75881);
      k.h(paramAudioCacheInfo, "info");
      boolean bool;
      Object localObject2;
      if (paramInt == a.a(a.this))
      {
        bool = true;
        localObject1 = this.asD;
        k.g(localObject1, "itemView");
        ((View)localObject1).setSelected(bool);
        localObject1 = this.wzW;
        localObject2 = this.asD;
        k.g(localObject2, "itemView");
        localObject2 = ((View)localObject2).getContext();
        if (!bool) {
          break label158;
        }
        paramInt = -16777216;
        label76:
        ((ImageView)localObject1).setImageDrawable(am.k((Context)localObject2, 2131690438, paramInt));
        localObject2 = this.wzX;
        if (!paramAudioCacheInfo.wrk.isEmpty()) {
          break label163;
        }
      }
      for (Object localObject1 = (CharSequence)paramAudioCacheInfo.wrm;; localObject1 = (CharSequence)(paramAudioCacheInfo.wrm + " - " + (String)localObject1))
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        this.wzY.e(paramAudioCacheInfo.wrj, a.this.wzP);
        this.wzY.setShow(bool);
        AppMethodBeat.o(75881);
        return;
        bool = false;
        break;
        label158:
        paramInt = -1;
        break label76;
        label163:
        localObject1 = bs.n((List)paramAudioCacheInfo.wrk, ",");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.a.a
 * JD-Core Version:    0.7.0.1
 */