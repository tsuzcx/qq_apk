package com.tencent.mm.plugin.recordvideo.ui.a;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelimage.r;
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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "()V", "audioList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "Lkotlin/collections/ArrayList;", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "queryString", "", "getQueryString", "()Ljava/lang/String;", "setQueryString", "(Ljava/lang/String;)V", "recMusicCardBgResId", "recMusicIconColorResId", "recMusicIconResId", "recMusicTextColor", "recWaveColorResId", "selectedPosition", "addAudioList", "index", "audios", "", "addSearchAudioList", "getAllItem", "getItem", "getItemCount", "getItemViewType", "getSelection", "isEmptyNoLoading", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetStyle", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setSelection", "(Ljava/lang/Integer;)V", "updateAudioList", "BaseViewHolder", "Companion", "RecommendMusicLoadingHolder", "RecommendMusicViewHolder", "SearchEntranceViewHolder", "SearchResultLoadingHolder", "SearchResultViewHolder", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RecyclerView.a<a>
{
  public static final a.b NTo;
  private static final String TAG;
  public final ArrayList<AudioCacheInfo> NTp;
  public String NTq;
  private int NTr;
  private int NTs;
  private int NTt;
  private int NTu;
  private int NTv;
  public int dyx;
  public m<? super Integer, ? super AudioCacheInfo, ah> ykx;
  
  static
  {
    AppMethodBeat.i(75893);
    NTo = new a.b((byte)0);
    TAG = "MicroMsg.RecommendMusicAdapter";
    AppMethodBeat.o(75893);
  }
  
  public a()
  {
    AppMethodBeat.i(75892);
    this.NTp = new ArrayList();
    this.dyx = -1;
    this.NTr = b.d.bg_story_audio_item;
    this.NTs = b.g.finder_bgm_gif_first_page;
    this.NTt = b.b.story_audio_search_item_icon;
    this.NTu = b.b.story_audio_search_item_wave;
    this.NTv = b.b.story_audio_search_item_text;
    AppMethodBeat.o(75892);
  }
  
  public final void a(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5)
  {
    AppMethodBeat.i(279840);
    if ((paramInteger1 != null) && (paramInteger1.intValue() != 0)) {
      this.NTr = paramInteger1.intValue();
    }
    if ((paramInteger2 != null) && (paramInteger2.intValue() != 0)) {
      this.NTs = paramInteger2.intValue();
    }
    if ((paramInteger3 != null) && (paramInteger3.intValue() != 0)) {
      this.NTt = paramInteger3.intValue();
    }
    if ((paramInteger4 != null) && (paramInteger4.intValue() != 0)) {
      this.NTu = paramInteger4.intValue();
    }
    if ((paramInteger5 != null) && (paramInteger5.intValue() != 0)) {
      this.NTv = paramInteger5.intValue();
    }
    AppMethodBeat.o(279840);
  }
  
  public final AudioCacheInfo agS(int paramInt)
  {
    AppMethodBeat.i(75887);
    AudioCacheInfo localAudioCacheInfo = (AudioCacheInfo)p.ae((List)this.NTp, paramInt);
    AppMethodBeat.o(75887);
    return localAudioCacheInfo;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(75888);
    int i = this.NTp.size();
    AppMethodBeat.o(75888);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(75889);
    Object localObject = agS(paramInt);
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf(((AudioCacheInfo)localObject).type))
    {
      localObject = AudioCacheInfo.NIB;
      paramInt = AudioCacheInfo.gHP();
      AppMethodBeat.o(75889);
      return paramInt;
    }
    paramInt = ((Integer)localObject).intValue();
    AppMethodBeat.o(75889);
    return paramInt;
  }
  
  public final void jN(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(75883);
    s.u(paramList, "audios");
    this.NTp.clear();
    this.NTp.addAll((Collection)paramList);
    this.dyx = -1;
    this.bZE.notifyChanged();
    AppMethodBeat.o(75883);
  }
  
  public final void jO(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(279814);
    s.u(paramList, "audios");
    this.NTp.addAll(0, (Collection)paramList);
    this.bZE.notifyChanged();
    AppMethodBeat.o(279814);
  }
  
  public final void jP(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(75884);
    s.u(paramList, "audios");
    int j = this.NTp.size();
    Object localObject1 = (List)this.NTp;
    ListIterator localListIterator = ((List)localObject1).listIterator(((List)localObject1).size());
    int i;
    if (localListIterator.hasPrevious())
    {
      localObject1 = localListIterator.previous();
      Object localObject2 = (AudioCacheInfo)localObject1;
      i = ((AudioCacheInfo)localObject2).type;
      AudioCacheInfo.a locala = AudioCacheInfo.NIB;
      if (i != AudioCacheInfo.gHS())
      {
        i = ((AudioCacheInfo)localObject2).type;
        locala = AudioCacheInfo.NIB;
        if (i != AudioCacheInfo.gHT())
        {
          i = ((AudioCacheInfo)localObject2).type;
          localObject2 = AudioCacheInfo.NIB;
          if (i != AudioCacheInfo.gHQ()) {
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
        this.NTp.remove(localObject1);
      }
      i = this.NTp.size();
      if (j != i) {
        break label208;
      }
      this.NTp.addAll((Collection)paramList);
      bA(j, paramList.size());
      AppMethodBeat.o(75884);
      return;
      label197:
      i = 0;
      break label128;
      break;
      localObject1 = null;
    }
    label208:
    this.NTp.addAll((Collection)paramList);
    fV(i);
    bA(j, paramList.size() - 1);
    AppMethodBeat.o(75884);
  }
  
  public final void setSelection(Integer paramInteger)
  {
    AppMethodBeat.i(75885);
    if (paramInteger == null)
    {
      fV(this.dyx);
      this.dyx = -1;
      fV(this.dyx);
      AppMethodBeat.o(75885);
      return;
    }
    fV(this.dyx);
    this.dyx = paramInteger.intValue();
    fV(this.dyx);
    AppMethodBeat.o(75885);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
      AppMethodBeat.i(75875);
      localObject.setOnClickListener(new a.a..ExternalSyntheticLambda0(this, a.this, localObject));
      AppMethodBeat.o(75875);
    }
    
    private static final void a(a parama, a parama1, View paramView1, View paramView2)
    {
      AppMethodBeat.i(279754);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(parama);
      localb.cH(parama1);
      localb.cH(paramView1);
      localb.cH(paramView2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      s.u(parama1, "this$1");
      s.u(paramView1, "$itemView");
      int i = parama.KJ();
      parama = parama1.agS(i);
      if (parama != null)
      {
        parama1 = parama1.ykx;
        if (parama1 != null) {
          parama1.invoke(Integer.valueOf(i), parama);
        }
      }
      paramView1.requestFocus();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279754);
    }
    
    public void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
    {
      AppMethodBeat.i(75874);
      s.u(paramAudioCacheInfo, "info");
      AppMethodBeat.o(75874);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$RecommendMusicLoadingHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$RecommendMusicViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "coverView", "Landroid/widget/ImageView;", "getCoverView", "()Landroid/widget/ImageView;", "iconView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "loading", "getLoading", "()Landroid/view/View;", "title", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "getTitle", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "waveView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends a.a
  {
    private final MusicLrcView NTx;
    private final AudioWaveView NTy;
    private final ImageView NTz;
    private final WeImageView ukO;
    private final View ylD;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(75878);
      this$1 = localObject.findViewById(b.e.story_item_audio_loading);
      s.s(a.this, "itemView.findViewById(R.…story_item_audio_loading)");
      this.ylD = a.this;
      this$1 = localObject.findViewById(b.e.story_item_audio_preview);
      s.s(a.this, "itemView.findViewById(R.…story_item_audio_preview)");
      this.ukO = ((WeImageView)a.this);
      this$1 = localObject.findViewById(b.e.story_item_audio_title);
      s.s(a.this, "itemView.findViewById(R.id.story_item_audio_title)");
      this.NTx = ((MusicLrcView)a.this);
      this$1 = localObject.findViewById(b.e.waveView);
      s.s(a.this, "itemView.findViewById(R.id.waveView)");
      this.NTy = ((AudioWaveView)a.this);
      this$1 = localObject.findViewById(b.e.story_item_audio_finder_cover);
      s.s(a.this, "itemView.findViewById(R.…_item_audio_finder_cover)");
      this.NTz = ((ImageView)a.this);
      AppMethodBeat.o(75878);
    }
    
    public final void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
    {
      int i = 1;
      AppMethodBeat.i(75877);
      s.u(paramAudioCacheInfo, "info");
      this.caK.setBackground(com.tencent.mm.cd.a.m(this.caK.getContext(), a.a(a.this)));
      Object localObject1 = this.caK.getLayoutParams();
      if (localObject1 != null) {
        ((ViewGroup.LayoutParams)localObject1).width = (com.tencent.mm.cd.a.ms(this.caK.getContext()) - com.tencent.mm.cd.a.fromDPToPix(this.caK.getContext(), 80));
      }
      this.caK.setEnabled(true);
      boolean bool;
      if (paramInt == a.b(a.this))
      {
        bool = true;
        this.caK.setSelected(bool);
        Log.i(a.access$getTAG$cp(), s.X("LogStory: ", Boolean.valueOf(bool)));
        this.NTy.setVisibility(0);
        localObject1 = this.NTy;
        Object localObject2 = com.tencent.mm.cd.a.l(this.caK.getContext(), a.c(a.this));
        s.s(localObject2, "getColorStateList(itemVi…ntext, recWaveColorResId)");
        ((AudioWaveView)localObject1).setColor((ColorStateList)localObject2);
        this.NTy.setShow(bool);
        localObject1 = com.tencent.mm.cd.a.m(this.caK.getContext(), a.d(a.this));
        localObject2 = com.tencent.mm.cd.a.l(this.caK.getContext(), a.e(a.this));
        this.ukO.setImageDrawable((Drawable)localObject1);
        this.ukO.setIconColor(((ColorStateList)localObject2).getColorForState(this.ukO.getDrawableState(), 0));
        this.ukO.setVisibility(0);
        this.NTx.setTextColor(com.tencent.mm.cd.a.l(this.caK.getContext(), a.f(a.this)));
        localObject1 = (Collection)paramAudioCacheInfo.NIE;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label441;
        }
        paramInt = 1;
        label307:
        if (paramInt == 0) {
          break label497;
        }
        localObject2 = this.NTx;
        if (!paramAudioCacheInfo.NIF.isEmpty()) {
          break label446;
        }
        localObject1 = (CharSequence)paramAudioCacheInfo.songName;
        label336:
        ((MusicLrcView)localObject2).setText((CharSequence)localObject1);
        this.NTx.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.NTx.setMarqueeRepeatLimit(-1);
        MusicLrcView.a(this.NTx, false);
        label369:
        this.NTx.setVisibility(0);
        this.ylD.setVisibility(8);
        if (((CharSequence)paramAudioCacheInfo.coverUrl).length() <= 0) {
          break label528;
        }
      }
      label528:
      for (paramInt = i;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label533;
        }
        this.NTz.setVisibility(0);
        r.bKe().loadImage(paramAudioCacheInfo.coverUrl, this.NTz);
        AppMethodBeat.o(75877);
        return;
        bool = false;
        break;
        label441:
        paramInt = 0;
        break label307;
        label446:
        localObject1 = Util.listToString((List)paramAudioCacheInfo.NIF, ",");
        localObject1 = (CharSequence)(paramAudioCacheInfo.songName + " - " + localObject1);
        break label336;
        label497:
        MusicLrcView.a(this.NTx, paramAudioCacheInfo.NIE);
        this.NTx.setEllipsize(null);
        MusicLrcView.a(this.NTx, bool);
        break label369;
      }
      label533:
      this.NTz.setVisibility(8);
      AppMethodBeat.o(75877);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchEntranceViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchResultLoadingHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$SearchResultViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "searchHighlightColor", "", "getSearchHighlightColor", "()I", "searchResultIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getSearchResultIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "searchTipView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "getSearchTipView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "searchTitleView", "Landroid/widget/TextView;", "getSearchTitleView", "()Landroid/widget/TextView;", "update", "", "position", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class g
    extends a.a
  {
    private final WeImageView NTA;
    private final TextView NTB;
    private final MusicLrcView NTC;
    private final int NTD;
    
    public g()
    {
      super(localObject);
      AppMethodBeat.i(75882);
      this$1 = localObject.findViewById(b.e.story_item_audio_search_result_icon);
      s.s(a.this, "itemView.findViewById(R.…audio_search_result_icon)");
      this.NTA = ((WeImageView)a.this);
      this$1 = localObject.findViewById(b.e.story_item_audio_search_result_title);
      s.s(a.this, "itemView.findViewById(R.…udio_search_result_title)");
      this.NTB = ((TextView)a.this);
      this$1 = localObject.findViewById(b.e.story_item_audio_search_result_tip);
      s.s(a.this, "itemView.findViewById(R.…_audio_search_result_tip)");
      this.NTC = ((MusicLrcView)a.this);
      this.NTD = com.tencent.mm.cd.a.w(localObject.getContext(), b.b.video_editor_lyric_hint_foreground);
      AppMethodBeat.o(75882);
    }
    
    public final void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
    {
      AppMethodBeat.i(75881);
      s.u(paramAudioCacheInfo, "info");
      boolean bool;
      Object localObject2;
      if (paramInt == a.b(a.this))
      {
        bool = true;
        this.caK.setSelected(bool);
        localObject1 = com.tencent.mm.cd.a.m(this.caK.getContext(), a.d(a.this));
        localObject2 = com.tencent.mm.cd.a.l(this.caK.getContext(), b.b.story_audio_search_item_icon);
        this.NTA.setImageDrawable((Drawable)localObject1);
        this.NTA.setIconColor(((ColorStateList)localObject2).getColorForState(this.NTA.getDrawableState(), 0));
        if (!paramAudioCacheInfo.NIF.isEmpty()) {
          break label207;
        }
      }
      for (Object localObject1 = paramAudioCacheInfo.songName;; localObject1 = paramAudioCacheInfo.songName + " - " + localObject1)
      {
        localObject2 = this.NTB;
        MusicLrcView.a locala = MusicLrcView.NWU;
        ((TextView)localObject2).setText(MusicLrcView.a.a((String)localObject1, (CharSequence)a.this.NTq, this.NTD));
        this.NTC.h(paramAudioCacheInfo.NIE, a.this.NTq);
        MusicLrcView.a(this.NTC, bool);
        paramAudioCacheInfo = this.caK.findViewById(b.e.story_item_audio_search_result_container);
        if (paramAudioCacheInfo != null) {
          paramAudioCacheInfo.setTag(b.e.finder_accessibility_desc, localObject1);
        }
        AppMethodBeat.o(75881);
        return;
        bool = false;
        break;
        label207:
        localObject1 = Util.listToString((List)paramAudioCacheInfo.NIF, ",");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.a.a
 * JD-Core Version:    0.7.0.1
 */