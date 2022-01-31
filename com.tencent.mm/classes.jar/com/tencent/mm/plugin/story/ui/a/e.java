package com.tencent.mm.plugin.story.ui.a;

import a.f.a.m;
import a.l;
import a.y;
import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a;
import com.tencent.mm.plugin.story.ui.view.AudioWaveView;
import com.tencent.mm.plugin.story.ui.view.editor.item.MusicLrcView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.aj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "()V", "audioList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "Lkotlin/collections/ArrayList;", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "musicPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "queryString", "", "getQueryString", "()Ljava/lang/String;", "setQueryString", "(Ljava/lang/String;)V", "selectedPosition", "addAudioList", "index", "audios", "", "addSearchAudioList", "getItem", "getItemCount", "getItemViewType", "getSelection", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setMusicPlayer", "player", "setSelection", "(Ljava/lang/Integer;)V", "updateAudioList", "BaseViewHolder", "Companion", "RecommendMusicLoadingHolder", "RecommendMusicViewHolder", "SearchEntranceViewHolder", "SearchResultLoadingHolder", "SearchResultViewHolder", "plugin-story_release"})
public final class e
  extends RecyclerView.a<e.a>
{
  private static final String TAG = "MicroMsg.RecommendMusicAdapter";
  public static final e.b sIl;
  public int lxQ;
  public m<? super Integer, ? super AudioCacheInfo, y> lxR;
  public final ArrayList<AudioCacheInfo> sIi;
  public String sIj;
  private v sIk;
  
  static
  {
    AppMethodBeat.i(110121);
    sIl = new e.b((byte)0);
    TAG = "MicroMsg.RecommendMusicAdapter";
    AppMethodBeat.o(110121);
  }
  
  public e()
  {
    AppMethodBeat.i(110120);
    this.sIi = new ArrayList();
    this.lxQ = -1;
    AppMethodBeat.o(110120);
  }
  
  public final AudioCacheInfo Gd(int paramInt)
  {
    AppMethodBeat.i(110115);
    AudioCacheInfo localAudioCacheInfo = (AudioCacheInfo)a.a.j.w((List)this.sIi, paramInt);
    AppMethodBeat.o(110115);
    return localAudioCacheInfo;
  }
  
  public final void dF(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(110111);
    a.f.b.j.q(paramList, "audios");
    this.sIi.clear();
    this.sIi.addAll((Collection)paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(110111);
  }
  
  public final void dG(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(110112);
    a.f.b.j.q(paramList, "audios");
    int j = this.sIi.size();
    Object localObject1 = (List)this.sIi;
    ListIterator localListIterator = ((List)localObject1).listIterator(((List)localObject1).size());
    int i;
    if (localListIterator.hasPrevious())
    {
      localObject1 = localListIterator.previous();
      Object localObject2 = (AudioCacheInfo)localObject1;
      i = ((AudioCacheInfo)localObject2).type;
      AudioCacheInfo.a locala = AudioCacheInfo.swC;
      if (i != AudioCacheInfo.cBw())
      {
        i = ((AudioCacheInfo)localObject2).type;
        locala = AudioCacheInfo.swC;
        if (i != AudioCacheInfo.cBx())
        {
          i = ((AudioCacheInfo)localObject2).type;
          localObject2 = AudioCacheInfo.swC;
          if (i != AudioCacheInfo.cBu()) {
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
        this.sIi.remove(localObject1);
      }
      i = this.sIi.size();
      if (j != i) {
        break label208;
      }
      this.sIi.addAll((Collection)paramList);
      ap(j, paramList.size());
      AppMethodBeat.o(110112);
      return;
      label197:
      i = 0;
      break label128;
      break;
      localObject1 = null;
    }
    label208:
    this.sIi.addAll((Collection)paramList);
    bR(i);
    ap(j, paramList.size() - 1);
    AppMethodBeat.o(110112);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(110116);
    int i = this.sIi.size();
    AppMethodBeat.o(110116);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(110117);
    Object localObject = Gd(paramInt);
    if (localObject != null)
    {
      paramInt = ((AudioCacheInfo)localObject).type;
      AppMethodBeat.o(110117);
      return paramInt;
    }
    localObject = AudioCacheInfo.swC;
    paramInt = AudioCacheInfo.cBt();
    AppMethodBeat.o(110117);
    return paramInt;
  }
  
  public final void setMusicPlayer(v paramv)
  {
    AppMethodBeat.i(110114);
    a.f.b.j.q(paramv, "player");
    this.sIk = paramv;
    AppMethodBeat.o(110114);
  }
  
  public final void setSelection(Integer paramInteger)
  {
    AppMethodBeat.i(110113);
    if (paramInteger == null)
    {
      bR(this.lxQ);
      this.lxQ = -1;
      bR(this.lxQ);
      AppMethodBeat.o(110113);
      return;
    }
    bR(this.lxQ);
    this.lxQ = paramInteger.intValue();
    bR(this.lxQ);
    AppMethodBeat.o(110113);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$RecommendMusicViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "loading", "getLoading", "()Landroid/view/View;", "title", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView;", "getTitle", "()Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView;", "waveView", "Lcom/tencent/mm/plugin/story/ui/view/AudioWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/story/ui/view/AudioWaveView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "plugin-story_release"})
  public final class d
    extends e.a
  {
    private final ImageView nCN;
    private final View sIo;
    private final MusicLrcView sIp;
    private final AudioWaveView sIq;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(110106);
      this$1 = localObject.findViewById(2131828367);
      a.f.b.j.p(e.this, "itemView.findViewById(R.…story_item_audio_loading)");
      this.sIo = e.this;
      this$1 = localObject.findViewById(2131828426);
      a.f.b.j.p(e.this, "itemView.findViewById(R.…story_item_audio_preview)");
      this.nCN = ((ImageView)e.this);
      this$1 = localObject.findViewById(2131828428);
      a.f.b.j.p(e.this, "itemView.findViewById(R.id.story_item_audio_title)");
      this.sIp = ((MusicLrcView)e.this);
      this$1 = localObject.findViewById(2131828427);
      a.f.b.j.p(e.this, "itemView.findViewById(R.id.waveView)");
      this.sIq = ((AudioWaveView)e.this);
      AppMethodBeat.o(110106);
    }
    
    public final void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
    {
      boolean bool = true;
      int i = -16777216;
      AppMethodBeat.i(110105);
      a.f.b.j.q(paramAudioCacheInfo, "info");
      Object localObject1 = this.aku;
      a.f.b.j.p(localObject1, "itemView");
      ((View)localObject1).setEnabled(true);
      if (paramInt == e.a(e.this))
      {
        localObject1 = this.aku;
        a.f.b.j.p(localObject1, "itemView");
        ((View)localObject1).setSelected(bool);
        ab.i(e.access$getTAG$cp(), "LogStory: ".concat(String.valueOf(bool)));
        localObject1 = this.nCN;
        Object localObject2 = this.aku;
        a.f.b.j.p(localObject2, "itemView");
        localObject2 = ((View)localObject2).getContext();
        if (!bool) {
          break label221;
        }
        paramInt = -16777216;
        label117:
        ((ImageView)localObject1).setImageDrawable(aj.g((Context)localObject2, 2131231464, paramInt));
        this.nCN.setVisibility(0);
        this.sIq.setVisibility(0);
        this.sIq.setShow(bool);
        MusicLrcView.a(this.sIp, paramAudioCacheInfo.swq);
        this.sIp.setShow(bool);
        paramAudioCacheInfo = this.sIp;
        if (!bool) {
          break label226;
        }
      }
      label221:
      label226:
      for (paramInt = i;; paramInt = -1)
      {
        paramAudioCacheInfo.setTextColor(paramInt);
        this.sIp.setVisibility(0);
        this.sIo.setVisibility(8);
        AppMethodBeat.o(110105);
        return;
        bool = false;
        break;
        paramInt = -1;
        break label117;
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$SearchEntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-story_release"})
  public final class e
    extends e.a
  {
    public e()
    {
      super(localObject);
      AppMethodBeat.i(110107);
      AppMethodBeat.o(110107);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$SearchResultLoadingHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-story_release"})
  public final class f
    extends e.a
  {
    public f()
    {
      super(localObject);
      AppMethodBeat.i(110108);
      AppMethodBeat.o(110108);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$SearchResultViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "searchTipView", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView;", "getSearchTipView", "()Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView;", "searchTitleView", "Landroid/widget/TextView;", "getSearchTitleView", "()Landroid/widget/TextView;", "searchresultIcon", "Landroid/widget/ImageView;", "getSearchresultIcon", "()Landroid/widget/ImageView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "plugin-story_release"})
  public final class g
    extends e.a
  {
    private final ImageView sIr;
    private final TextView sIs;
    private final MusicLrcView sIt;
    
    public g()
    {
      super(localObject);
      AppMethodBeat.i(110110);
      this$1 = localObject.findViewById(2131828433);
      a.f.b.j.p(e.this, "itemView.findViewById(R.…audio_search_result_icon)");
      this.sIr = ((ImageView)e.this);
      this$1 = localObject.findViewById(2131828434);
      a.f.b.j.p(e.this, "itemView.findViewById(R.…udio_search_result_title)");
      this.sIs = ((TextView)e.this);
      this$1 = localObject.findViewById(2131828435);
      a.f.b.j.p(e.this, "itemView.findViewById(R.…_audio_search_result_tip)");
      this.sIt = ((MusicLrcView)e.this);
      AppMethodBeat.o(110110);
    }
    
    public final void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
    {
      AppMethodBeat.i(110109);
      a.f.b.j.q(paramAudioCacheInfo, "info");
      boolean bool;
      Object localObject2;
      if (paramInt == e.a(e.this))
      {
        bool = true;
        localObject1 = this.aku;
        a.f.b.j.p(localObject1, "itemView");
        ((View)localObject1).setSelected(bool);
        localObject1 = this.sIr;
        localObject2 = this.aku;
        a.f.b.j.p(localObject2, "itemView");
        localObject2 = ((View)localObject2).getContext();
        if (!bool) {
          break label158;
        }
        paramInt = -16777216;
        label76:
        ((ImageView)localObject1).setImageDrawable(aj.g((Context)localObject2, 2131231464, paramInt));
        localObject2 = this.sIs;
        if (!paramAudioCacheInfo.swr.isEmpty()) {
          break label163;
        }
      }
      for (Object localObject1 = (CharSequence)paramAudioCacheInfo.swt;; localObject1 = (CharSequence)(paramAudioCacheInfo.swt + " - " + (String)localObject1))
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        this.sIt.f(paramAudioCacheInfo.swq, e.this.sIj);
        this.sIt.setShow(bool);
        AppMethodBeat.o(110109);
        return;
        bool = false;
        break;
        label158:
        paramInt = -1;
        break label76;
        label163:
        localObject1 = bo.d((List)paramAudioCacheInfo.swr, ",");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.e
 * JD-Core Version:    0.7.0.1
 */