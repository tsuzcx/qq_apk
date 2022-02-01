package com.tencent.mm.plugin.recordvideo.ui.a;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.AudioWaveView;
import com.tencent.mm.plugin.recordvideo.ui.editor.MusicLrcView;
import com.tencent.mm.plugin.recordvideo.ui.editor.MusicLrcView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "()V", "audioList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "Lkotlin/collections/ArrayList;", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "queryString", "", "getQueryString", "()Ljava/lang/String;", "setQueryString", "(Ljava/lang/String;)V", "recMusicCardBgResId", "recMusicIconColorResId", "recMusicIconResId", "recMusicTextColor", "recWaveColorResId", "selectedPosition", "addAudioList", "index", "audios", "", "addSearchAudioList", "getAllItem", "getItem", "getItemCount", "getItemViewType", "getSelection", "isEmptyNoLoading", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetStyle", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setSelection", "(Ljava/lang/Integer;)V", "updateAudioList", "BaseViewHolder", "Companion", "RecommendMusicLoadingHolder", "RecommendMusicViewHolder", "SearchEntranceViewHolder", "SearchResultLoadingHolder", "SearchResultViewHolder", "plugin-recordvideo_release"})
public final class a
  extends RecyclerView.a<a>
{
  public static final b HWK;
  private static final String TAG = "MicroMsg.RecommendMusicAdapter";
  public final ArrayList<AudioCacheInfo> HWD;
  public String HWE;
  private int HWF;
  private int HWG;
  private int HWH;
  private int HWI;
  private int HWJ;
  public int bFx;
  public m<? super Integer, ? super AudioCacheInfo, x> uYj;
  
  static
  {
    AppMethodBeat.i(75893);
    HWK = new b((byte)0);
    TAG = "MicroMsg.RecommendMusicAdapter";
    AppMethodBeat.o(75893);
  }
  
  public a()
  {
    AppMethodBeat.i(75892);
    this.HWD = new ArrayList();
    this.bFx = -1;
    this.HWF = b.d.bg_story_audio_item;
    this.HWG = b.g.finder_bgm_gif_first_page;
    this.HWH = b.b.story_audio_search_item_icon;
    this.HWI = b.b.story_audio_search_item_wave;
    this.HWJ = b.b.story_audio_search_item_text;
    AppMethodBeat.o(75892);
  }
  
  public final void a(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5)
  {
    AppMethodBeat.i(216319);
    if ((paramInteger1 != null) && (paramInteger1.intValue() != 0)) {
      this.HWF = paramInteger1.intValue();
    }
    if ((paramInteger2 != null) && (paramInteger2.intValue() != 0)) {
      this.HWG = paramInteger2.intValue();
    }
    if ((paramInteger3 != null) && (paramInteger3.intValue() != 0)) {
      this.HWH = paramInteger3.intValue();
    }
    if ((paramInteger4 != null) && (paramInteger4.intValue() != 0)) {
      this.HWI = paramInteger4.intValue();
    }
    if ((paramInteger5 != null) && (paramInteger5.intValue() != 0)) {
      this.HWJ = paramInteger5.intValue();
    }
    AppMethodBeat.o(216319);
  }
  
  public final AudioCacheInfo acC(int paramInt)
  {
    AppMethodBeat.i(75887);
    AudioCacheInfo localAudioCacheInfo = (AudioCacheInfo)j.M((List)this.HWD, paramInt);
    AppMethodBeat.o(75887);
    return localAudioCacheInfo;
  }
  
  public final void gN(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(75883);
    p.k(paramList, "audios");
    this.HWD.clear();
    this.HWD.addAll((Collection)paramList);
    this.bFx = -1;
    notifyDataSetChanged();
    AppMethodBeat.o(75883);
  }
  
  public final void gO(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(216309);
    p.k(paramList, "audios");
    this.HWD.addAll(0, (Collection)paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(216309);
  }
  
  public final void gP(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(75884);
    p.k(paramList, "audios");
    int j = this.HWD.size();
    Object localObject1 = (List)this.HWD;
    ListIterator localListIterator = ((List)localObject1).listIterator(((List)localObject1).size());
    int i;
    if (localListIterator.hasPrevious())
    {
      localObject1 = localListIterator.previous();
      Object localObject2 = (AudioCacheInfo)localObject1;
      i = ((AudioCacheInfo)localObject2).type;
      AudioCacheInfo.a locala = AudioCacheInfo.HMa;
      if (i != AudioCacheInfo.fwj())
      {
        i = ((AudioCacheInfo)localObject2).type;
        locala = AudioCacheInfo.HMa;
        if (i != AudioCacheInfo.fwk())
        {
          i = ((AudioCacheInfo)localObject2).type;
          localObject2 = AudioCacheInfo.HMa;
          if (i != AudioCacheInfo.fwh()) {
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
        this.HWD.remove(localObject1);
      }
      i = this.HWD.size();
      if (j != i) {
        break label208;
      }
      this.HWD.addAll((Collection)paramList);
      aG(j, paramList.size());
      AppMethodBeat.o(75884);
      return;
      label197:
      i = 0;
      break label128;
      break;
      localObject1 = null;
    }
    label208:
    this.HWD.addAll((Collection)paramList);
    cL(i);
    aG(j, paramList.size() - 1);
    AppMethodBeat.o(75884);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(75888);
    int i = this.HWD.size();
    AppMethodBeat.o(75888);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(75889);
    Object localObject = acC(paramInt);
    if (localObject != null)
    {
      paramInt = ((AudioCacheInfo)localObject).type;
      AppMethodBeat.o(75889);
      return paramInt;
    }
    localObject = AudioCacheInfo.HMa;
    paramInt = AudioCacheInfo.fwg();
    AppMethodBeat.o(75889);
    return paramInt;
  }
  
  public final void setSelection(Integer paramInteger)
  {
    AppMethodBeat.i(75885);
    if (paramInteger == null)
    {
      cL(this.bFx);
      this.bFx = -1;
      cL(this.bFx);
      AppMethodBeat.o(75885);
      return;
    }
    cL(this.bFx);
    this.bFx = paramInteger.intValue();
    cL(this.bFx);
    AppMethodBeat.o(75885);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
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
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          int i = this.HWM.md();
          paramAnonymousView = this.HWM.HWL.acC(i);
          if (paramAnonymousView != null)
          {
            localObject = this.HWM.HWL.uYj;
            if (localObject != null) {
              ((m)localObject).invoke(Integer.valueOf(i), paramAnonymousView);
            }
          }
          localObject.requestFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(75873);
        }
      });
      AppMethodBeat.o(75875);
    }
    
    public void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
    {
      AppMethodBeat.i(75874);
      p.k(paramAudioCacheInfo, "info");
      AppMethodBeat.o(75874);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$RecommendMusicLoadingHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$RecommendMusicViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "coverView", "Landroid/widget/ImageView;", "getCoverView", "()Landroid/widget/ImageView;", "iconView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "loading", "getLoading", "()Landroid/view/View;", "title", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "getTitle", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "waveView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
  public final class d
    extends a.a
  {
    private final WeImageView ATn;
    private final MusicLrcView HWN;
    private final AudioWaveView HWO;
    private final ImageView HWP;
    private final View uZA;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(75878);
      this$1 = localObject.findViewById(b.e.story_item_audio_loading);
      p.j(a.this, "itemView.findViewById(R.…story_item_audio_loading)");
      this.uZA = a.this;
      this$1 = localObject.findViewById(b.e.story_item_audio_preview);
      p.j(a.this, "itemView.findViewById(R.…story_item_audio_preview)");
      this.ATn = ((WeImageView)a.this);
      this$1 = localObject.findViewById(b.e.story_item_audio_title);
      p.j(a.this, "itemView.findViewById(R.id.story_item_audio_title)");
      this.HWN = ((MusicLrcView)a.this);
      this$1 = localObject.findViewById(b.e.waveView);
      p.j(a.this, "itemView.findViewById(R.id.waveView)");
      this.HWO = ((AudioWaveView)a.this);
      this$1 = localObject.findViewById(b.e.story_item_audio_finder_cover);
      p.j(a.this, "itemView.findViewById(R.…_item_audio_finder_cover)");
      this.HWP = ((ImageView)a.this);
      AppMethodBeat.o(75878);
    }
    
    public final void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
    {
      int i = 1;
      AppMethodBeat.i(75877);
      p.k(paramAudioCacheInfo, "info");
      Object localObject1 = this.amk;
      p.j(localObject1, "itemView");
      Object localObject2 = this.amk;
      p.j(localObject2, "itemView");
      ((View)localObject1).setBackground(com.tencent.mm.ci.a.m(((View)localObject2).getContext(), a.a(a.this)));
      localObject1 = this.amk;
      p.j(localObject1, "itemView");
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 != null)
      {
        localObject2 = this.amk;
        p.j(localObject2, "itemView");
        int j = com.tencent.mm.ci.a.kr(((View)localObject2).getContext());
        localObject2 = this.amk;
        p.j(localObject2, "itemView");
        ((ViewGroup.LayoutParams)localObject1).width = (j - com.tencent.mm.ci.a.fromDPToPix(((View)localObject2).getContext(), 80));
      }
      localObject1 = this.amk;
      p.j(localObject1, "itemView");
      ((View)localObject1).setEnabled(true);
      boolean bool;
      if (paramInt == a.b(a.this))
      {
        bool = true;
        localObject1 = this.amk;
        p.j(localObject1, "itemView");
        ((View)localObject1).setSelected(bool);
        Log.i(a.access$getTAG$cp(), "LogStory: ".concat(String.valueOf(bool)));
        this.HWO.setVisibility(0);
        localObject1 = this.HWO;
        localObject2 = this.amk;
        p.j(localObject2, "itemView");
        localObject2 = com.tencent.mm.ci.a.l(((View)localObject2).getContext(), a.c(a.this));
        p.j(localObject2, "ResourceHelper.getColorS…ntext, recWaveColorResId)");
        ((AudioWaveView)localObject1).setColor((ColorStateList)localObject2);
        this.HWO.setShow(bool);
        localObject1 = this.amk;
        p.j(localObject1, "itemView");
        localObject1 = com.tencent.mm.ci.a.m(((View)localObject1).getContext(), a.d(a.this));
        localObject2 = this.amk;
        p.j(localObject2, "itemView");
        localObject2 = com.tencent.mm.ci.a.l(((View)localObject2).getContext(), a.e(a.this));
        this.ATn.setImageDrawable((Drawable)localObject1);
        this.ATn.setIconColor(((ColorStateList)localObject2).getColorForState(this.ATn.getDrawableState(), 0));
        this.ATn.setVisibility(0);
        localObject1 = this.HWN;
        localObject2 = this.amk;
        p.j(localObject2, "itemView");
        ((MusicLrcView)localObject1).setTextColor(com.tencent.mm.ci.a.l(((View)localObject2).getContext(), a.f(a.this)));
        localObject1 = (Collection)paramAudioCacheInfo.HLD;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label570;
        }
        paramInt = 1;
        label436:
        if (paramInt == 0) {
          break label626;
        }
        localObject2 = this.HWN;
        if (!paramAudioCacheInfo.HLE.isEmpty()) {
          break label575;
        }
        localObject1 = (CharSequence)paramAudioCacheInfo.HLH;
        label465:
        ((MusicLrcView)localObject2).setText((CharSequence)localObject1);
        this.HWN.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.HWN.setMarqueeRepeatLimit(-1);
        MusicLrcView.a(this.HWN, false);
        label498:
        this.HWN.setVisibility(0);
        this.uZA.setVisibility(8);
        if (((CharSequence)paramAudioCacheInfo.coverUrl).length() <= 0) {
          break label657;
        }
      }
      label657:
      for (paramInt = i;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label662;
        }
        this.HWP.setVisibility(0);
        com.tencent.mm.ay.q.bml().loadImage(paramAudioCacheInfo.coverUrl, this.HWP);
        AppMethodBeat.o(75877);
        return;
        bool = false;
        break;
        label570:
        paramInt = 0;
        break label436;
        label575:
        localObject1 = Util.listToString((List)paramAudioCacheInfo.HLE, ",");
        localObject1 = (CharSequence)(paramAudioCacheInfo.HLH + " - " + (String)localObject1);
        break label465;
        label626:
        MusicLrcView.a(this.HWN, paramAudioCacheInfo.HLD);
        this.HWN.setEllipsize(null);
        MusicLrcView.a(this.HWN, bool);
        break label498;
      }
      label662:
      this.HWP.setVisibility(8);
      AppMethodBeat.o(75877);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchEntranceViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchResultLoadingHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchResultViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "searchHighlightColor", "", "getSearchHighlightColor", "()I", "searchResultIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getSearchResultIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "searchTipView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "getSearchTipView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "searchTitleView", "Landroid/widget/TextView;", "getSearchTitleView", "()Landroid/widget/TextView;", "update", "", "position", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
  public final class g
    extends a.a
  {
    private final WeImageView HWQ;
    private final TextView HWR;
    private final MusicLrcView HWS;
    private final int HWT;
    
    public g()
    {
      super(localObject);
      AppMethodBeat.i(75882);
      this$1 = localObject.findViewById(b.e.story_item_audio_search_result_icon);
      p.j(a.this, "itemView.findViewById(R.…audio_search_result_icon)");
      this.HWQ = ((WeImageView)a.this);
      this$1 = localObject.findViewById(b.e.story_item_audio_search_result_title);
      p.j(a.this, "itemView.findViewById(R.…udio_search_result_title)");
      this.HWR = ((TextView)a.this);
      this$1 = localObject.findViewById(b.e.story_item_audio_search_result_tip);
      p.j(a.this, "itemView.findViewById(R.…_audio_search_result_tip)");
      this.HWS = ((MusicLrcView)a.this);
      this.HWT = com.tencent.mm.ci.a.w(localObject.getContext(), b.b.video_editor_lyric_hint_foreground);
      AppMethodBeat.o(75882);
    }
    
    public final void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
    {
      AppMethodBeat.i(75881);
      p.k(paramAudioCacheInfo, "info");
      boolean bool;
      Object localObject2;
      if (paramInt == a.b(a.this))
      {
        bool = true;
        localObject1 = this.amk;
        p.j(localObject1, "itemView");
        ((View)localObject1).setSelected(bool);
        localObject1 = this.amk;
        p.j(localObject1, "itemView");
        localObject1 = com.tencent.mm.ci.a.m(((View)localObject1).getContext(), a.d(a.this));
        localObject2 = this.amk;
        p.j(localObject2, "itemView");
        localObject2 = com.tencent.mm.ci.a.l(((View)localObject2).getContext(), b.b.story_audio_search_item_icon);
        this.HWQ.setImageDrawable((Drawable)localObject1);
        this.HWQ.setIconColor(((ColorStateList)localObject2).getColorForState(this.HWQ.getDrawableState(), 0));
        if (!paramAudioCacheInfo.HLE.isEmpty()) {
          break label216;
        }
      }
      for (Object localObject1 = paramAudioCacheInfo.HLH;; localObject1 = paramAudioCacheInfo.HLH + " - " + (String)localObject1)
      {
        localObject2 = this.HWR;
        MusicLrcView.a locala = MusicLrcView.Iau;
        ((TextView)localObject2).setText(MusicLrcView.a.a((String)localObject1, (CharSequence)a.this.HWE, this.HWT));
        this.HWS.f(paramAudioCacheInfo.HLD, a.this.HWE);
        MusicLrcView.a(this.HWS, bool);
        AppMethodBeat.o(75881);
        return;
        bool = false;
        break;
        label216:
        localObject1 = Util.listToString((List)paramAudioCacheInfo.HLE, ",");
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements m<Boolean, String, x>
  {
    h(AudioCacheInfo paramAudioCacheInfo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.a.a
 * JD-Core Version:    0.7.0.1
 */