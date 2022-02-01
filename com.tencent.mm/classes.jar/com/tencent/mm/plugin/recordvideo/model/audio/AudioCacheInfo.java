package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.e.d;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.protocal.protobuf.cun;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "cachePath", "", "getCachePath", "()Ljava/lang/String;", "setCachePath", "(Ljava/lang/String;)V", "cached", "", "getCached", "()Z", "setCached", "(Z)V", "coverUrl", "getCoverUrl", "setCoverUrl", "decodeKey", "getDecodeKey", "setDecodeKey", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "failed", "getFailed", "setFailed", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFinderObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "local", "getLocal", "setLocal", "lyricsList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "Lkotlin/collections/ArrayList;", "getLyricsList", "()Ljava/util/ArrayList;", "setLyricsList", "(Ljava/util/ArrayList;)V", "musicId", "getMusicId", "setMusicId", "musicUrl", "getMusicUrl", "setMusicUrl", "position", "getPosition", "setPosition", "protoInfo", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getProtoInfo", "()Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "setProtoInfo", "(Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;)V", "request_id", "", "getRequest_id", "()J", "setRequest_id", "(J)V", "showLyrics", "getShowLyrics", "setShowLyrics", "singers", "getSingers", "setSingers", "songName", "getSongName", "setSongName", "source", "getSource", "setSource", "tryUseFinderAudio", "getTryUseFinderAudio", "setTryUseFinderAudio", "type", "getType", "setType", "describeContents", "()Ljava/lang/Integer;", "toString", "writeToParcel", "", "flags", "Companion", "MusicLrcBean", "plugin-recordvideo_release"})
public final class AudioCacheInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AudioCacheInfo> CREATOR;
  private static final String HLK = "AUDIO_CACHE_INFO_INDEX_KEY";
  private static final String HLL = "AUDIO_CACHE_INFO_LIST_KEY";
  private static final String HLM = "SELECT_MUTE_ORIGIN_KEY";
  private static final int HLN = 1;
  private static final int HLO = 2;
  private static final int HLP = 3;
  private static final int HLQ = 4;
  private static final int HLR = 5;
  private static final int HLT = 0;
  private static final int HLU = 1;
  private static final int HLV = 2;
  private static final int HLW = 3;
  private static final int HLX = 4;
  private static final int HLY = 5;
  private static final int HLZ = 6;
  public static final a HMa;
  private static final String TAG = "MicroMsg.AudioCacheInfo";
  public boolean HJG;
  public cum HLB;
  public int HLC;
  public ArrayList<c> HLD;
  public ArrayList<String> HLE;
  public boolean HLF;
  public boolean HLG;
  public String HLH;
  public long HLI;
  public boolean HLJ;
  public boolean aGs;
  public String cachePath;
  public String coverUrl;
  public String decodeKey;
  public int duration;
  public String musicUrl;
  public int position;
  public int source;
  public int type;
  public FinderObject xcx;
  
  static
  {
    AppMethodBeat.i(75405);
    HMa = new a((byte)0);
    TAG = "MicroMsg.AudioCacheInfo";
    HLK = "AUDIO_CACHE_INFO_INDEX_KEY";
    HLL = "AUDIO_CACHE_INFO_LIST_KEY";
    HLM = "SELECT_MUTE_ORIGIN_KEY";
    HLN = 1;
    HLO = 2;
    HLP = 3;
    HLQ = 4;
    HLR = 5;
    HLU = 1;
    HLV = 2;
    HLW = 3;
    HLX = 4;
    HLY = 5;
    HLZ = 6;
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(75405);
  }
  
  public AudioCacheInfo()
  {
    AppMethodBeat.i(75403);
    this.HLB = new cum();
    this.HLE = new ArrayList();
    this.HJG = true;
    this.HLH = "";
    this.decodeKey = "";
    this.coverUrl = "";
    this.position = -1;
    this.HLI = -1L;
    AppMethodBeat.o(75403);
  }
  
  public AudioCacheInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(75404);
    this.HLC = paramParcel.readInt();
    this.musicUrl = paramParcel.readString();
    this.cachePath = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.aGs = bool;
      if (paramParcel.readByte() == 0) {
        break label189;
      }
    }
    label189:
    for (boolean bool = true;; bool = false)
    {
      this.HLF = bool;
      this.position = paramParcel.readInt();
      this.HLI = paramParcel.readLong();
      this.type = paramParcel.readInt();
      String str = paramParcel.readString();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.HLH = ((String)localObject);
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.decodeKey = ((String)localObject);
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.coverUrl = ((String)localObject);
      localObject = (a)this.HLB;
      paramParcel = paramParcel.createByteArray();
      try
      {
        ((a)localObject).parseFrom(paramParcel);
        AppMethodBeat.o(75404);
        return;
      }
      catch (Exception paramParcel)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramParcel });
        AppMethodBeat.o(75404);
      }
      bool = false;
      break;
    }
  }
  
  public final void aSq(String paramString)
  {
    AppMethodBeat.i(228928);
    p.k(paramString, "<set-?>");
    this.HLH = paramString;
    AppMethodBeat.o(228928);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void setCoverUrl(String paramString)
  {
    AppMethodBeat.i(228931);
    p.k(paramString, "<set-?>");
    this.coverUrl = paramString;
    AppMethodBeat.o(228931);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75402);
    String str = "AudioCacheInfo(musicId=" + this.HLC + ", musicUrl=" + this.musicUrl + ", lyricsList=" + this.HLD + ", cachePath=" + this.cachePath + ", cached=" + this.aGs + ", failed=" + this.HLF + ", type=" + this.type + ", songName='" + this.HLH + "', position=" + this.position + ", request_id=" + this.HLI + ')';
    AppMethodBeat.o(75402);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(75401);
    p.k(paramParcel, "parcel");
    paramParcel.writeInt(this.HLC);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.cachePath);
    if (this.aGs)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.HLF) {
        break label139;
      }
    }
    label139:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.position);
      paramParcel.writeLong(this.HLI);
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.HLH);
      paramParcel.writeString(this.decodeKey);
      paramParcel.writeString(this.coverUrl);
      paramParcel.writeByteArray(this.HLB.toByteArray());
      AppMethodBeat.o(75401);
      return;
      b1 = 0;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$Companion;", "", "()V", "AUDIO_CACHE_INFO_INDEX_KEY", "", "getAUDIO_CACHE_INFO_INDEX_KEY", "()Ljava/lang/String;", "AUDIO_CACHE_INFO_LIST_KEY", "getAUDIO_CACHE_INFO_LIST_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "SELECT_MUTE_ORIGIN_KEY", "getSELECT_MUTE_ORIGIN_KEY", "SOURCE_TYPE_FINDER_FAV", "", "getSOURCE_TYPE_FINDER_FAV", "()I", "SOURCE_TYPE_FINDER_LIKE", "getSOURCE_TYPE_FINDER_LIKE", "SOURCE_TYPE_FOLLOW_OTHER", "getSOURCE_TYPE_FOLLOW_OTHER", "SOURCE_TYPE_FOLLOW_SELF", "getSOURCE_TYPE_FOLLOW_SELF", "SOURCE_TYPE_NONE", "getSOURCE_TYPE_NONE", "SOURCE_TYPE_NORMAL", "getSOURCE_TYPE_NORMAL", "SOURCE_TYPE_SEARCH", "getSOURCE_TYPE_SEARCH", "TAG", "getTAG", "VIEW_TYPE_LOADING", "getVIEW_TYPE_LOADING", "VIEW_TYPE_NORMAL", "getVIEW_TYPE_NORMAL", "VIEW_TYPE_SEARCH_ENTRANCE", "getVIEW_TYPE_SEARCH_ENTRANCE", "VIEW_TYPE_SEARCH_LOADING", "getVIEW_TYPE_SEARCH_LOADING", "VIEW_TYPE_SEARCH_RESULT", "getVIEW_TYPE_SEARCH_RESULT", "createFromMusicInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "type", "createLoadingInfo", "createSearchEntranceInfo", "createSearchLoadingInfo", "plugin-recordvideo_release"})
  public static final class a
  {
    public static AudioCacheInfo a(cum paramcum, int paramInt)
    {
      boolean bool2 = true;
      AppMethodBeat.i(169930);
      p.k(paramcum, "info");
      AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
      p.k(paramcum, "<set-?>");
      localAudioCacheInfo.HLB = paramcum;
      localAudioCacheInfo.HLC = paramcum.TCc;
      localAudioCacheInfo.musicUrl = paramcum.TCi;
      Object localObject1 = new ArrayList();
      Object localObject2 = paramcum.TCl;
      p.j(localObject2, "info.lyrics");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        cun localcun = (cun)((Iterator)localObject2).next();
        if (!Util.isNullOrNil(localcun.TCp))
        {
          Object localObject3 = localcun.TCp;
          p.j(localObject3, "it.lyrics_content");
          localObject3 = new AudioCacheInfo.c((String)localObject3, localcun.TCo, localcun.TCo);
          if (!Util.isNullOrNil((List)localObject1)) {
            ((AudioCacheInfo.c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).HMc = localcun.TCo;
          }
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      if (Util.isNullOrNil((List)localObject1))
      {
        localObject2 = MMApplicationContext.getResources().getString(b.h.music_no_lyrics_tip);
        p.j(localObject2, "MMApplicationContext.get…ring.music_no_lyrics_tip)");
        ((ArrayList)localObject1).add(new AudioCacheInfo.c((String)localObject2, 0, 0));
      }
      localAudioCacheInfo.HLE.addAll((Collection)paramcum.TCk);
      localAudioCacheInfo.HLD = ((ArrayList)localObject1);
      localObject1 = d.IeU;
      localObject1 = paramcum.TCc + '_' + cm.bfD();
      if (localObject1 == null)
      {
        localObject1 = "";
        localAudioCacheInfo.cachePath = ((String)localObject1);
        if (u.bBQ((String)localObject1) <= 0L) {
          break label475;
        }
        bool1 = true;
        label331:
        localAudioCacheInfo.aGs = bool1;
        localAudioCacheInfo.HLF = false;
        localObject1 = paramcum.SMU;
        p.j(localObject1, "info.song_name");
        localAudioCacheInfo.aSq((String)localObject1);
        localAudioCacheInfo.type = paramInt;
        localAudioCacheInfo.duration = paramcum.duration;
        if (paramcum.TCn != 1) {
          break label480;
        }
      }
      label475:
      label480:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localAudioCacheInfo.HJG = bool1;
        Log.i(AudioCacheInfo.access$getTAG$cp(), "LogStory: " + localAudioCacheInfo.HLC + ' ' + localAudioCacheInfo.HLD);
        AppMethodBeat.o(169930);
        return localAudioCacheInfo;
        localObject1 = d.jU(d.IeT, (String)localObject1) + ".mixa";
        break;
        bool1 = false;
        break label331;
      }
    }
    
    public static AudioCacheInfo fws()
    {
      AppMethodBeat.i(217403);
      AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
      localAudioCacheInfo.type = AudioCacheInfo.fwh();
      AppMethodBeat.o(217403);
      return localAudioCacheInfo;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
  public static final class b
    implements Parcelable.Creator<AudioCacheInfo>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "", "lrc", "", "startTime", "", "stopTime", "(Ljava/lang/String;II)V", "getLrc", "()Ljava/lang/String;", "setLrc", "(Ljava/lang/String;)V", "getStartTime", "()I", "setStartTime", "(I)V", "getStopTime", "setStopTime", "plugin-recordvideo_release"})
  public static final class c
  {
    public String HMb;
    public int HMc;
    public int fod;
    
    public c(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75400);
      this.HMb = paramString;
      this.fod = paramInt1;
      this.HMc = paramInt2;
      AppMethodBeat.o(75400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo
 * JD-Core Version:    0.7.0.1
 */