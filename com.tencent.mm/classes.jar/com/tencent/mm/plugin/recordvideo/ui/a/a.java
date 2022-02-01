package com.tencent.mm.plugin.recordvideo.ui.a;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "()V", "audioList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "Lkotlin/collections/ArrayList;", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "musicPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "queryString", "", "getQueryString", "()Ljava/lang/String;", "setQueryString", "(Ljava/lang/String;)V", "recMusicCardBgResId", "recMusicIconColorResId", "recMusicIconResId", "recMusicTextColor", "recWaveColorResId", "selectedPosition", "addAudioList", "index", "audios", "", "addSearchAudioList", "getAllItem", "getItem", "getItemCount", "getItemViewType", "getSelection", "isEmptyNoLoading", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetStyle", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setMusicPlayer", "player", "setSelection", "(Ljava/lang/Integer;)V", "updateAudioList", "BaseViewHolder", "Companion", "RecommendMusicLoadingHolder", "RecommendMusicViewHolder", "SearchEntranceViewHolder", "SearchResultLoadingHolder", "SearchResultViewHolder", "plugin-recordvideo_release"})
public final class a
  extends RecyclerView.a<a>
{
  public static final a.b BZW;
  private static final String TAG = "MicroMsg.RecommendMusicAdapter";
  public final ArrayList<AudioCacheInfo> BZO;
  public String BZP;
  private int BZQ;
  private int BZR;
  private int BZS;
  private int BZT;
  private int BZU;
  private v BZV;
  public m<? super Integer, ? super AudioCacheInfo, x> rsD;
  public int va;
  
  static
  {
    AppMethodBeat.i(75893);
    BZW = new a.b((byte)0);
    TAG = "MicroMsg.RecommendMusicAdapter";
    AppMethodBeat.o(75893);
  }
  
  public a()
  {
    AppMethodBeat.i(75892);
    this.BZO = new ArrayList();
    this.va = -1;
    this.BZQ = 2131231183;
    this.BZR = 2131690227;
    this.BZS = 2131101177;
    this.BZT = 2131101184;
    this.BZU = 2131101179;
    AppMethodBeat.o(75892);
  }
  
  public final AudioCacheInfo VR(int paramInt)
  {
    AppMethodBeat.i(75887);
    AudioCacheInfo localAudioCacheInfo = (AudioCacheInfo)j.L((List)this.BZO, paramInt);
    AppMethodBeat.o(75887);
    return localAudioCacheInfo;
  }
  
  public final void a(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5)
  {
    AppMethodBeat.i(237572);
    if ((paramInteger1 != null) && (paramInteger1.intValue() != 0)) {
      this.BZQ = paramInteger1.intValue();
    }
    if ((paramInteger2 != null) && (paramInteger2.intValue() != 0)) {
      this.BZR = paramInteger2.intValue();
    }
    if ((paramInteger3 != null) && (paramInteger3.intValue() != 0)) {
      this.BZS = paramInteger3.intValue();
    }
    if ((paramInteger4 != null) && (paramInteger4.intValue() != 0)) {
      this.BZT = paramInteger4.intValue();
    }
    if ((paramInteger5 != null) && (paramInteger5.intValue() != 0)) {
      this.BZU = paramInteger5.intValue();
    }
    AppMethodBeat.o(237572);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(75888);
    int i = this.BZO.size();
    AppMethodBeat.o(75888);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(75889);
    Object localObject = VR(paramInt);
    if (localObject != null)
    {
      paramInt = ((AudioCacheInfo)localObject).type;
      AppMethodBeat.o(75889);
      return paramInt;
    }
    localObject = AudioCacheInfo.BPo;
    paramInt = AudioCacheInfo.eJW();
    AppMethodBeat.o(75889);
    return paramInt;
  }
  
  public final void gj(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(75883);
    p.h(paramList, "audios");
    this.BZO.clear();
    this.BZO.addAll((Collection)paramList);
    this.va = -1;
    notifyDataSetChanged();
    AppMethodBeat.o(75883);
  }
  
  public final void gk(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(75884);
    p.h(paramList, "audios");
    int j = this.BZO.size();
    Object localObject1 = (List)this.BZO;
    ListIterator localListIterator = ((List)localObject1).listIterator(((List)localObject1).size());
    int i;
    if (localListIterator.hasPrevious())
    {
      localObject1 = localListIterator.previous();
      Object localObject2 = (AudioCacheInfo)localObject1;
      i = ((AudioCacheInfo)localObject2).type;
      AudioCacheInfo.a locala = AudioCacheInfo.BPo;
      if (i != AudioCacheInfo.eJZ())
      {
        i = ((AudioCacheInfo)localObject2).type;
        locala = AudioCacheInfo.BPo;
        if (i != AudioCacheInfo.eKa())
        {
          i = ((AudioCacheInfo)localObject2).type;
          localObject2 = AudioCacheInfo.BPo;
          if (i != AudioCacheInfo.eJX()) {
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
        this.BZO.remove(localObject1);
      }
      i = this.BZO.size();
      if (j != i) {
        break label208;
      }
      this.BZO.addAll((Collection)paramList);
      as(j, paramList.size());
      AppMethodBeat.o(75884);
      return;
      label197:
      i = 0;
      break label128;
      break;
      localObject1 = null;
    }
    label208:
    this.BZO.addAll((Collection)paramList);
    ci(i);
    as(j, paramList.size() - 1);
    AppMethodBeat.o(75884);
  }
  
  public final void setMusicPlayer(v paramv)
  {
    AppMethodBeat.i(75886);
    p.h(paramv, "player");
    this.BZV = paramv;
    AppMethodBeat.o(75886);
  }
  
  public final void setSelection(Integer paramInteger)
  {
    AppMethodBeat.i(75885);
    if (paramInteger == null)
    {
      ci(this.va);
      this.va = -1;
      ci(this.va);
      AppMethodBeat.o(75885);
      return;
    }
    ci(this.va);
    this.va = paramInteger.intValue();
    ci(this.va);
    AppMethodBeat.o(75885);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
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
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          int i = this.BZY.lR();
          paramAnonymousView = this.BZY.BZX.VR(i);
          if (paramAnonymousView != null)
          {
            localObject = this.BZY.BZX.rsD;
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
      p.h(paramAudioCacheInfo, "info");
      AppMethodBeat.o(75874);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$RecommendMusicLoadingHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$RecommendMusicViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "iconView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "loading", "getLoading", "()Landroid/view/View;", "title", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "getTitle", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "waveView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
  public final class d
    extends a.a
  {
    private final MusicLrcView BZZ;
    private final AudioWaveView Caa;
    private final View rtV;
    private final WeImageView wjf;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(75878);
      this$1 = localObject.findViewById(2131308652);
      p.g(a.this, "itemView.findViewById(R.…story_item_audio_loading)");
      this.rtV = a.this;
      this$1 = localObject.findViewById(2131308653);
      p.g(a.this, "itemView.findViewById(R.…story_item_audio_preview)");
      this.wjf = ((WeImageView)a.this);
      this$1 = localObject.findViewById(2131308662);
      p.g(a.this, "itemView.findViewById(R.id.story_item_audio_title)");
      this.BZZ = ((MusicLrcView)a.this);
      this$1 = localObject.findViewById(2131310336);
      p.g(a.this, "itemView.findViewById(R.id.waveView)");
      this.Caa = ((AudioWaveView)a.this);
      AppMethodBeat.o(75878);
    }
    
    public final void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
    {
      int i = 1;
      AppMethodBeat.i(75877);
      p.h(paramAudioCacheInfo, "info");
      Object localObject1 = this.aus;
      p.g(localObject1, "itemView");
      Object localObject2 = this.aus;
      p.g(localObject2, "itemView");
      ((View)localObject1).setBackground(com.tencent.mm.cb.a.l(((View)localObject2).getContext(), a.a(a.this)));
      localObject1 = this.aus;
      p.g(localObject1, "itemView");
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 != null)
      {
        localObject2 = this.aus;
        p.g(localObject2, "itemView");
        int j = com.tencent.mm.cb.a.jn(((View)localObject2).getContext());
        localObject2 = this.aus;
        p.g(localObject2, "itemView");
        ((ViewGroup.LayoutParams)localObject1).width = (j - com.tencent.mm.cb.a.fromDPToPix(((View)localObject2).getContext(), 80));
      }
      localObject1 = this.aus;
      p.g(localObject1, "itemView");
      ((View)localObject1).setEnabled(true);
      boolean bool;
      if (paramInt == a.b(a.this))
      {
        bool = true;
        localObject1 = this.aus;
        p.g(localObject1, "itemView");
        ((View)localObject1).setSelected(bool);
        Log.i(a.access$getTAG$cp(), "LogStory: ".concat(String.valueOf(bool)));
        this.Caa.setVisibility(0);
        localObject1 = this.Caa;
        localObject2 = this.aus;
        p.g(localObject2, "itemView");
        localObject2 = com.tencent.mm.cb.a.m(((View)localObject2).getContext(), a.c(a.this));
        p.g(localObject2, "ResourceHelper.getColorS…ntext, recWaveColorResId)");
        ((AudioWaveView)localObject1).setColor((ColorStateList)localObject2);
        this.Caa.setShow(bool);
        localObject1 = this.aus;
        p.g(localObject1, "itemView");
        localObject1 = com.tencent.mm.cb.a.l(((View)localObject1).getContext(), a.d(a.this));
        localObject2 = this.aus;
        p.g(localObject2, "itemView");
        localObject2 = com.tencent.mm.cb.a.m(((View)localObject2).getContext(), a.e(a.this));
        this.wjf.setImageDrawable((Drawable)localObject1);
        this.wjf.setIconColor(((ColorStateList)localObject2).getColorForState(this.wjf.getDrawableState(), 0));
        this.wjf.setVisibility(0);
        localObject1 = this.BZZ;
        localObject2 = this.aus;
        p.g(localObject2, "itemView");
        ((MusicLrcView)localObject1).setTextColor(com.tencent.mm.cb.a.m(((View)localObject2).getContext(), a.f(a.this)));
        localObject1 = (Collection)paramAudioCacheInfo.BOY;
        paramInt = i;
        if (localObject1 != null)
        {
          if (!((Collection)localObject1).isEmpty()) {
            break label527;
          }
          paramInt = i;
        }
        label438:
        if (paramInt == 0) {
          break label582;
        }
        localObject1 = this.BZZ;
        if (!paramAudioCacheInfo.BOZ.isEmpty()) {
          break label532;
        }
        paramAudioCacheInfo = (CharSequence)paramAudioCacheInfo.BPc;
        label466:
        ((MusicLrcView)localObject1).setText(paramAudioCacheInfo);
        this.BZZ.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.BZZ.setMarqueeRepeatLimit(-1);
        MusicLrcView.a(this.BZZ, false);
      }
      for (;;)
      {
        this.BZZ.setVisibility(0);
        this.rtV.setVisibility(8);
        AppMethodBeat.o(75877);
        return;
        bool = false;
        break;
        label527:
        paramInt = 0;
        break label438;
        label532:
        localObject2 = Util.listToString((List)paramAudioCacheInfo.BOZ, ",");
        paramAudioCacheInfo = (CharSequence)(paramAudioCacheInfo.BPc + " - " + (String)localObject2);
        break label466;
        label582:
        MusicLrcView.a(this.BZZ, paramAudioCacheInfo.BOY);
        this.BZZ.setEllipsize(null);
        MusicLrcView.a(this.BZZ, bool);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchEntranceViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchResultLoadingHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchResultViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "searchHighlightColor", "", "getSearchHighlightColor", "()I", "searchResultIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getSearchResultIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "searchTipView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "getSearchTipView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "searchTitleView", "Landroid/widget/TextView;", "getSearchTitleView", "()Landroid/widget/TextView;", "update", "", "position", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
  public final class g
    extends a.a
  {
    private final WeImageView Cab;
    private final TextView Cac;
    private final MusicLrcView Cad;
    private final int Cae;
    
    public g()
    {
      super(localObject);
      AppMethodBeat.i(75882);
      this$1 = localObject.findViewById(2131308657);
      p.g(a.this, "itemView.findViewById(R.…audio_search_result_icon)");
      this.Cab = ((WeImageView)a.this);
      this$1 = localObject.findViewById(2131308659);
      p.g(a.this, "itemView.findViewById(R.…udio_search_result_title)");
      this.Cac = ((TextView)a.this);
      this$1 = localObject.findViewById(2131308658);
      p.g(a.this, "itemView.findViewById(R.…_audio_search_result_tip)");
      this.Cad = ((MusicLrcView)a.this);
      this.Cae = com.tencent.mm.cb.a.n(localObject.getContext(), 2131101305);
      AppMethodBeat.o(75882);
    }
    
    public final void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
    {
      AppMethodBeat.i(75881);
      p.h(paramAudioCacheInfo, "info");
      boolean bool;
      Object localObject2;
      if (paramInt == a.b(a.this))
      {
        bool = true;
        localObject1 = this.aus;
        p.g(localObject1, "itemView");
        ((View)localObject1).setSelected(bool);
        localObject1 = this.aus;
        p.g(localObject1, "itemView");
        localObject1 = com.tencent.mm.cb.a.l(((View)localObject1).getContext(), a.d(a.this));
        localObject2 = this.aus;
        p.g(localObject2, "itemView");
        localObject2 = com.tencent.mm.cb.a.m(((View)localObject2).getContext(), 2131101177);
        this.Cab.setImageDrawable((Drawable)localObject1);
        this.Cab.setIconColor(((ColorStateList)localObject2).getColorForState(this.Cab.getDrawableState(), 0));
        if (!paramAudioCacheInfo.BOZ.isEmpty()) {
          break label215;
        }
      }
      for (Object localObject1 = paramAudioCacheInfo.BPc;; localObject1 = paramAudioCacheInfo.BPc + " - " + (String)localObject1)
      {
        localObject2 = this.Cac;
        MusicLrcView.a locala = MusicLrcView.Cee;
        ((TextView)localObject2).setText(MusicLrcView.a.a((String)localObject1, (CharSequence)a.this.BZP, this.Cae));
        this.Cad.f(paramAudioCacheInfo.BOY, a.this.BZP);
        MusicLrcView.a(this.Cad, bool);
        AppMethodBeat.o(75881);
        return;
        bool = false;
        break;
        label215:
        localObject1 = Util.listToString((List)paramAudioCacheInfo.BOZ, ",");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.a.a
 * JD-Core Version:    0.7.0.1
 */