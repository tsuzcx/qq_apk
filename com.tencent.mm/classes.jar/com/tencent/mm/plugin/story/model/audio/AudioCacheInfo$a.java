package com.tencent.mm.plugin.story.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "SOURCE_TYPE_NORMAL", "", "getSOURCE_TYPE_NORMAL", "()I", "SOURCE_TYPE_SEARCH", "getSOURCE_TYPE_SEARCH", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEW_TYPE_LOADING", "getVIEW_TYPE_LOADING", "VIEW_TYPE_NORMAL", "getVIEW_TYPE_NORMAL", "VIEW_TYPE_SEARCH_ENTRANCE", "getVIEW_TYPE_SEARCH_ENTRANCE", "VIEW_TYPE_SEARCH_LOADING", "getVIEW_TYPE_SEARCH_LOADING", "VIEW_TYPE_SEARCH_RESULT", "getVIEW_TYPE_SEARCH_RESULT", "createFromMusicInfo", "info", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicInfo;", "type", "createLoadingInfo", "createSearchEntranceInfo", "createSearchLoadingInfo", "plugin-story_release"})
public final class AudioCacheInfo$a
{
  public static AudioCacheInfo a(bsq parambsq, int paramInt)
  {
    AppMethodBeat.i(109172);
    a.f.b.j.q(parambsq, "info");
    AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
    localAudioCacheInfo.swp = parambsq.xGe;
    localAudioCacheInfo.musicUrl = parambsq.xGk;
    Object localObject1 = new ArrayList();
    Object localObject2 = parambsq.xGo;
    a.f.b.j.p(localObject2, "info.lyrics");
    localObject2 = ((Iterable)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        a.a.j.eaS();
      }
      localObject3 = (bsr)localObject3;
      Object localObject4 = AudioCacheInfo.swC;
      localObject4 = ((bsr)localObject3).xGq;
      a.f.b.j.p(localObject4, "it.lyrics_content");
      localObject4 = new com.tencent.mm.plugin.story.ui.view.editor.item.e((String)localObject4, ((bsr)localObject3).xGp, ((bsr)localObject3).xGp);
      if ((i > 0) && (i < parambsq.xGo.size())) {
        ((com.tencent.mm.plugin.story.ui.view.editor.item.e)((ArrayList)localObject1).get(i - 1)).sRf = ((bsr)localObject3).xGp;
      }
      ((ArrayList)localObject1).add(localObject4);
      i += 1;
    }
    localAudioCacheInfo.swr.addAll((Collection)parambsq.xGn);
    localAudioCacheInfo.swq = ((ArrayList)localObject1);
    localObject1 = com.tencent.mm.plugin.story.model.l.adb(parambsq.xGe + '_' + cb.abq());
    localAudioCacheInfo.cachePath = ((String)localObject1);
    if (com.tencent.mm.vfs.e.avI((String)localObject1) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      localAudioCacheInfo.arq = bool;
      localAudioCacheInfo.sws = false;
      parambsq = parambsq.xGm;
      a.f.b.j.p(parambsq, "info.song_name");
      a.f.b.j.q(parambsq, "<set-?>");
      localAudioCacheInfo.swt = parambsq;
      localAudioCacheInfo.type = paramInt;
      ab.i(AudioCacheInfo.access$getTAG$cp(), "LogStory: " + localAudioCacheInfo.swp + ' ' + localAudioCacheInfo.swq);
      AppMethodBeat.o(109172);
      return localAudioCacheInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a
 * JD-Core Version:    0.7.0.1
 */