package com.tencent.mm.plugin.recordvideo.ui.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "()V", "audioList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "Lkotlin/collections/ArrayList;", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "musicPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "queryString", "", "getQueryString", "()Ljava/lang/String;", "setQueryString", "(Ljava/lang/String;)V", "selectedPosition", "addAudioList", "index", "audios", "", "addSearchAudioList", "getAllItem", "getItem", "getItemCount", "getItemViewType", "getSelection", "isEmptyNoLoading", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setMusicPlayer", "player", "setSelection", "(Ljava/lang/Integer;)V", "updateAudioList", "BaseViewHolder", "Companion", "RecommendMusicLoadingHolder", "RecommendMusicViewHolder", "SearchEntranceViewHolder", "SearchResultLoadingHolder", "SearchResultViewHolder", "plugin-recordvideo_release"})
public final class a
  extends RecyclerView.a<a>
{
  private static final String TAG = "MicroMsg.RecommendMusicAdapter";
  public static final b vpS;
  public m<? super Integer, ? super AudioCacheInfo, y> oOb;
  public int rZ;
  public final ArrayList<AudioCacheInfo> vpP;
  public String vpQ;
  private v vpR;
  
  static
  {
    AppMethodBeat.i(75893);
    vpS = new b((byte)0);
    TAG = "MicroMsg.RecommendMusicAdapter";
    AppMethodBeat.o(75893);
  }
  
  public a()
  {
    AppMethodBeat.i(75892);
    this.vpP = new ArrayList();
    this.rZ = -1;
    AppMethodBeat.o(75892);
  }
  
  public final AudioCacheInfo Ks(int paramInt)
  {
    AppMethodBeat.i(75887);
    AudioCacheInfo localAudioCacheInfo = (AudioCacheInfo)j.C((List)this.vpP, paramInt);
    AppMethodBeat.o(75887);
    return localAudioCacheInfo;
  }
  
  public final void eL(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(75883);
    k.h(paramList, "audios");
    this.vpP.clear();
    this.vpP.addAll((Collection)paramList);
    this.rZ = -1;
    notifyDataSetChanged();
    AppMethodBeat.o(75883);
  }
  
  public final void eM(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(75884);
    k.h(paramList, "audios");
    int j = this.vpP.size();
    Object localObject1 = (List)this.vpP;
    ListIterator localListIterator = ((List)localObject1).listIterator(((List)localObject1).size());
    int i;
    if (localListIterator.hasPrevious())
    {
      localObject1 = localListIterator.previous();
      Object localObject2 = (AudioCacheInfo)localObject1;
      i = ((AudioCacheInfo)localObject2).type;
      AudioCacheInfo.a locala = AudioCacheInfo.viM;
      if (i != AudioCacheInfo.dhO())
      {
        i = ((AudioCacheInfo)localObject2).type;
        locala = AudioCacheInfo.viM;
        if (i != AudioCacheInfo.dhP())
        {
          i = ((AudioCacheInfo)localObject2).type;
          localObject2 = AudioCacheInfo.viM;
          if (i != AudioCacheInfo.dhM()) {
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
        this.vpP.remove(localObject1);
      }
      i = this.vpP.size();
      if (j != i) {
        break label208;
      }
      this.vpP.addAll((Collection)paramList);
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
    this.vpP.addAll((Collection)paramList);
    ck(i);
    aq(j, paramList.size() - 1);
    AppMethodBeat.o(75884);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(75888);
    int i = this.vpP.size();
    AppMethodBeat.o(75888);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(75889);
    Object localObject = Ks(paramInt);
    if (localObject != null)
    {
      paramInt = ((AudioCacheInfo)localObject).type;
      AppMethodBeat.o(75889);
      return paramInt;
    }
    localObject = AudioCacheInfo.viM;
    paramInt = AudioCacheInfo.dhL();
    AppMethodBeat.o(75889);
    return paramInt;
  }
  
  public final void setMusicPlayer(v paramv)
  {
    AppMethodBeat.i(75886);
    k.h(paramv, "player");
    this.vpR = paramv;
    AppMethodBeat.o(75886);
  }
  
  public final void setSelection(Integer paramInteger)
  {
    AppMethodBeat.i(75885);
    if (paramInteger == null)
    {
      ck(this.rZ);
      this.rZ = -1;
      ck(this.rZ);
      AppMethodBeat.o(75885);
      return;
    }
    ck(this.rZ);
    this.rZ = paramInteger.intValue();
    ck(this.rZ);
    AppMethodBeat.o(75885);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
  public class a
    extends RecyclerView.v
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
          int i = this.vpU.ln();
          paramAnonymousView = this.vpU.vpT.Ks(i);
          if (paramAnonymousView != null)
          {
            m localm = this.vpU.vpT.oOb;
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$RecommendMusicLoadingHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"})
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$RecommendMusicViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "loading", "getLoading", "()Landroid/view/View;", "title", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "getTitle", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "waveView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
  public final class d
    extends a.a
  {
    private final View oPA;
    private final ImageView st;
    private final MusicLrcView vpV;
    private final AudioWaveView vpW;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(75878);
      this$1 = localObject.findViewById(2131305446);
      k.g(a.this, "itemView.findViewById(R.…story_item_audio_loading)");
      this.oPA = a.this;
      this$1 = localObject.findViewById(2131305447);
      k.g(a.this, "itemView.findViewById(R.…story_item_audio_preview)");
      this.st = ((ImageView)a.this);
      this$1 = localObject.findViewById(2131305456);
      k.g(a.this, "itemView.findViewById(R.id.story_item_audio_title)");
      this.vpV = ((MusicLrcView)a.this);
      this$1 = localObject.findViewById(2131306869);
      k.g(a.this, "itemView.findViewById(R.id.waveView)");
      this.vpW = ((AudioWaveView)a.this);
      AppMethodBeat.o(75878);
    }
    
    public final void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
    {
      boolean bool = true;
      int i = -16777216;
      AppMethodBeat.i(75877);
      k.h(paramAudioCacheInfo, "info");
      Object localObject1 = this.arI;
      k.g(localObject1, "itemView");
      ((View)localObject1).setEnabled(true);
      if (paramInt == a.a(a.this))
      {
        localObject1 = this.arI;
        k.g(localObject1, "itemView");
        ((View)localObject1).setSelected(bool);
        ad.i(a.access$getTAG$cp(), "LogStory: ".concat(String.valueOf(bool)));
        localObject1 = this.st;
        Object localObject2 = this.arI;
        k.g(localObject2, "itemView");
        localObject2 = ((View)localObject2).getContext();
        if (!bool) {
          break label221;
        }
        paramInt = -16777216;
        label117:
        ((ImageView)localObject1).setImageDrawable(am.i((Context)localObject2, 2131690438, paramInt));
        this.st.setVisibility(0);
        this.vpW.setVisibility(0);
        this.vpW.setShow(bool);
        MusicLrcView.a(this.vpV, paramAudioCacheInfo.viA);
        this.vpV.setShow(bool);
        paramAudioCacheInfo = this.vpV;
        if (!bool) {
          break label226;
        }
      }
      label221:
      label226:
      for (paramInt = i;; paramInt = -1)
      {
        paramAudioCacheInfo.setTextColor(paramInt);
        this.vpV.setVisibility(0);
        this.oPA.setVisibility(8);
        AppMethodBeat.o(75877);
        return;
        bool = false;
        break;
        paramInt = -1;
        break label117;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchEntranceViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"})
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchResultLoadingHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"})
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchResultViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "searchTipView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "getSearchTipView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "searchTitleView", "Landroid/widget/TextView;", "getSearchTitleView", "()Landroid/widget/TextView;", "searchresultIcon", "Landroid/widget/ImageView;", "getSearchresultIcon", "()Landroid/widget/ImageView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
  public final class g
    extends a.a
  {
    private final ImageView vpX;
    private final TextView vpY;
    private final MusicLrcView vpZ;
    
    public g()
    {
      super(localObject);
      AppMethodBeat.i(75882);
      this$1 = localObject.findViewById(2131305451);
      k.g(a.this, "itemView.findViewById(R.…audio_search_result_icon)");
      this.vpX = ((ImageView)a.this);
      this$1 = localObject.findViewById(2131305453);
      k.g(a.this, "itemView.findViewById(R.…udio_search_result_title)");
      this.vpY = ((TextView)a.this);
      this$1 = localObject.findViewById(2131305452);
      k.g(a.this, "itemView.findViewById(R.…_audio_search_result_tip)");
      this.vpZ = ((MusicLrcView)a.this);
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
        localObject1 = this.arI;
        k.g(localObject1, "itemView");
        ((View)localObject1).setSelected(bool);
        localObject1 = this.vpX;
        localObject2 = this.arI;
        k.g(localObject2, "itemView");
        localObject2 = ((View)localObject2).getContext();
        if (!bool) {
          break label158;
        }
        paramInt = -16777216;
        label76:
        ((ImageView)localObject1).setImageDrawable(am.i((Context)localObject2, 2131690438, paramInt));
        localObject2 = this.vpY;
        if (!paramAudioCacheInfo.viB.isEmpty()) {
          break label163;
        }
      }
      for (Object localObject1 = (CharSequence)paramAudioCacheInfo.viD;; localObject1 = (CharSequence)(paramAudioCacheInfo.viD + " - " + (String)localObject1))
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        this.vpZ.e(paramAudioCacheInfo.viA, a.this.vpQ);
        this.vpZ.setShow(bool);
        AppMethodBeat.o(75881);
        return;
        bool = false;
        break;
        label158:
        paramInt = -1;
        break label76;
        label163:
        localObject1 = bt.n((List)paramAudioCacheInfo.viB, ",");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.a.a
 * JD-Core Version:    0.7.0.1
 */