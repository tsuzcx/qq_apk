package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.util.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "cachePath", "", "getCachePath", "()Ljava/lang/String;", "setCachePath", "(Ljava/lang/String;)V", "cached", "", "getCached", "()Z", "setCached", "(Z)V", "coverUrl", "getCoverUrl", "setCoverUrl", "decodeKey", "getDecodeKey", "setDecodeKey", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "failed", "getFailed", "setFailed", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFinderObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "local", "getLocal", "setLocal", "lyricsList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "Lkotlin/collections/ArrayList;", "getLyricsList", "()Ljava/util/ArrayList;", "setLyricsList", "(Ljava/util/ArrayList;)V", "musicId", "getMusicId", "setMusicId", "musicUrl", "getMusicUrl", "setMusicUrl", "position", "getPosition", "setPosition", "protoInfo", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getProtoInfo", "()Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "setProtoInfo", "(Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;)V", "request_id", "", "getRequest_id", "()J", "setRequest_id", "(J)V", "showLyrics", "getShowLyrics", "setShowLyrics", "singers", "getSingers", "setSingers", "songName", "getSongName", "setSongName", "source", "getSource", "setSource", "tryUseFinderAudio", "getTryUseFinderAudio", "setTryUseFinderAudio", "type", "getType", "setType", "describeContents", "()Ljava/lang/Integer;", "toString", "writeToParcel", "", "flags", "Companion", "MusicLrcBean", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AudioCacheInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AudioCacheInfo> CREATOR;
  public static final a NIB;
  private static final String NIK;
  private static final String NIL;
  private static final String NIM;
  private static final int NIN;
  private static final int NIO;
  private static final int NIP;
  private static final int NIQ;
  private static final int NIR;
  private static final int NIS = 0;
  private static final int NIT;
  private static final int NIU;
  private static final int NIV;
  private static final int NIW;
  private static final int NIX;
  private static final int NIY;
  private static final String TAG;
  public FinderObject ABJ;
  public boolean NGF;
  public dls NIC;
  public int NID;
  public ArrayList<c> NIE;
  public ArrayList<String> NIF;
  public boolean NIG;
  public boolean NIH;
  public long NII;
  public boolean NIJ;
  public String cachePath;
  public boolean cached;
  public String coverUrl;
  public String decodeKey;
  public int duration;
  public String musicUrl;
  public int position;
  public String songName;
  public int source;
  public int type;
  
  static
  {
    AppMethodBeat.i(75405);
    NIB = new a((byte)0);
    TAG = "MicroMsg.AudioCacheInfo";
    NIK = "AUDIO_CACHE_INFO_INDEX_KEY";
    NIL = "AUDIO_CACHE_INFO_LIST_KEY";
    NIM = "SELECT_MUTE_ORIGIN_KEY";
    NIN = 1;
    NIO = 2;
    NIP = 3;
    NIQ = 4;
    NIR = 5;
    NIT = 1;
    NIU = 2;
    NIV = 3;
    NIW = 4;
    NIX = 5;
    NIY = 6;
    CREATOR = (Parcelable.Creator)new AudioCacheInfo.b();
    AppMethodBeat.o(75405);
  }
  
  public AudioCacheInfo()
  {
    AppMethodBeat.i(75403);
    this.NIC = new dls();
    this.NIF = new ArrayList();
    this.NGF = true;
    this.songName = "";
    this.decodeKey = "";
    this.coverUrl = "";
    this.position = -1;
    this.NII = -1L;
    AppMethodBeat.o(75403);
  }
  
  public AudioCacheInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(75404);
    this.NID = paramParcel.readInt();
    this.musicUrl = paramParcel.readString();
    this.cachePath = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.cached = bool;
      if (paramParcel.readByte() == 0) {
        break label189;
      }
    }
    label189:
    for (boolean bool = true;; bool = false)
    {
      this.NIG = bool;
      this.position = paramParcel.readInt();
      this.NII = paramParcel.readLong();
      this.type = paramParcel.readInt();
      String str = paramParcel.readString();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.songName = ((String)localObject);
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
      localObject = (a)this.NIC;
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
  
  public final void aPk(String paramString)
  {
    AppMethodBeat.i(279661);
    s.u(paramString, "<set-?>");
    this.songName = paramString;
    AppMethodBeat.o(279661);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void setCoverUrl(String paramString)
  {
    AppMethodBeat.i(279665);
    s.u(paramString, "<set-?>");
    this.coverUrl = paramString;
    AppMethodBeat.o(279665);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75402);
    String str = "AudioCacheInfo(musicId=" + this.NID + ", musicUrl=" + this.musicUrl + ", lyricsList=" + this.NIE + ", cachePath=" + this.cachePath + ", cached=" + this.cached + ", failed=" + this.NIG + ", type=" + this.type + ", songName='" + this.songName + "', position=" + this.position + ", request_id=" + this.NII + ')';
    AppMethodBeat.o(75402);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(75401);
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(this.NID);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.cachePath);
    if (this.cached)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.NIG) {
        break label139;
      }
    }
    label139:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.position);
      paramParcel.writeLong(this.NII);
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.songName);
      paramParcel.writeString(this.decodeKey);
      paramParcel.writeString(this.coverUrl);
      paramParcel.writeByteArray(this.NIC.toByteArray());
      AppMethodBeat.o(75401);
      return;
      b1 = 0;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$Companion;", "", "()V", "AUDIO_CACHE_INFO_INDEX_KEY", "", "getAUDIO_CACHE_INFO_INDEX_KEY", "()Ljava/lang/String;", "AUDIO_CACHE_INFO_LIST_KEY", "getAUDIO_CACHE_INFO_LIST_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "SELECT_MUTE_ORIGIN_KEY", "getSELECT_MUTE_ORIGIN_KEY", "SOURCE_TYPE_FINDER_FAV", "", "getSOURCE_TYPE_FINDER_FAV", "()I", "SOURCE_TYPE_FINDER_LIKE", "getSOURCE_TYPE_FINDER_LIKE", "SOURCE_TYPE_FOLLOW_OTHER", "getSOURCE_TYPE_FOLLOW_OTHER", "SOURCE_TYPE_FOLLOW_SELF", "getSOURCE_TYPE_FOLLOW_SELF", "SOURCE_TYPE_NONE", "getSOURCE_TYPE_NONE", "SOURCE_TYPE_NORMAL", "getSOURCE_TYPE_NORMAL", "SOURCE_TYPE_SEARCH", "getSOURCE_TYPE_SEARCH", "TAG", "getTAG", "VIEW_TYPE_LOADING", "getVIEW_TYPE_LOADING", "VIEW_TYPE_NORMAL", "getVIEW_TYPE_NORMAL", "VIEW_TYPE_SEARCH_ENTRANCE", "getVIEW_TYPE_SEARCH_ENTRANCE", "VIEW_TYPE_SEARCH_LOADING", "getVIEW_TYPE_SEARCH_LOADING", "VIEW_TYPE_SEARCH_RESULT", "getVIEW_TYPE_SEARCH_RESULT", "createFromMusicInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "type", "createLoadingInfo", "createSearchEntranceInfo", "createSearchLoadingInfo", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static AudioCacheInfo a(dls paramdls, int paramInt)
    {
      boolean bool2 = true;
      AppMethodBeat.i(169930);
      s.u(paramdls, "info");
      AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
      s.u(paramdls, "<set-?>");
      localAudioCacheInfo.NIC = paramdls;
      localAudioCacheInfo.NID = paramdls.aaRI;
      localAudioCacheInfo.musicUrl = paramdls.aaRO;
      Object localObject1 = new ArrayList();
      Object localObject2 = paramdls.aaRR;
      s.s(localObject2, "info.lyrics");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        dlt localdlt = (dlt)((Iterator)localObject2).next();
        if (!Util.isNullOrNil(localdlt.aaRV))
        {
          Object localObject3 = localdlt.aaRV;
          s.s(localObject3, "it.lyrics_content");
          localObject3 = new AudioCacheInfo.c((String)localObject3, localdlt.aaRU, localdlt.aaRU);
          if (!Util.isNullOrNil((List)localObject1)) {
            ((AudioCacheInfo.c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).NJa = localdlt.aaRU;
          }
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      if (Util.isNullOrNil((List)localObject1))
      {
        localObject2 = MMApplicationContext.getResources().getString(b.h.music_no_lyrics_tip);
        s.s(localObject2, "getResources().getString…ring.music_no_lyrics_tip)");
        ((ArrayList)localObject1).add(new AudioCacheInfo.c((String)localObject2, 0, 0));
      }
      localAudioCacheInfo.NIF.addAll((Collection)paramdls.aaRQ);
      localAudioCacheInfo.NIE = ((ArrayList)localObject1);
      localObject1 = f.Obq;
      localObject1 = paramdls.aaRI + '_' + cn.bDv();
      if (localObject1 == null)
      {
        localObject1 = "";
        localAudioCacheInfo.cachePath = ((String)localObject1);
        if (y.bEl((String)localObject1) <= 0L) {
          break label462;
        }
        bool1 = true;
        label331:
        localAudioCacheInfo.cached = bool1;
        localAudioCacheInfo.NIG = false;
        localObject1 = paramdls.ZTw;
        s.s(localObject1, "info.song_name");
        localAudioCacheInfo.aPk((String)localObject1);
        localAudioCacheInfo.type = paramInt;
        localAudioCacheInfo.duration = paramdls.duration;
        if (paramdls.aaRT != 1) {
          break label467;
        }
      }
      label462:
      label467:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localAudioCacheInfo.NGF = bool1;
        Log.i(AudioCacheInfo.access$getTAG$cp(), "LogStory: " + localAudioCacheInfo.NID + ' ' + localAudioCacheInfo.NIE);
        AppMethodBeat.o(169930);
        return localAudioCacheInfo;
        localObject1 = s.X(f.lq(f.Obt, (String)localObject1), ".mixa");
        break;
        bool1 = false;
        break label331;
      }
    }
    
    public static AudioCacheInfo gIb()
    {
      AppMethodBeat.i(279634);
      AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
      localAudioCacheInfo.type = AudioCacheInfo.gHQ();
      AppMethodBeat.o(279634);
      return localAudioCacheInfo;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "", "lrc", "", "startTime", "", "stopTime", "(Ljava/lang/String;II)V", "getLrc", "()Ljava/lang/String;", "setLrc", "(Ljava/lang/String;)V", "getStartTime", "()I", "setStartTime", "(I)V", "getStopTime", "setStopTime", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public String NIZ;
    public int NJa;
    public int startTime;
    
    public c(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75400);
      this.NIZ = paramString;
      this.startTime = paramInt1;
      this.NJa = paramInt2;
      AppMethodBeat.o(75400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo
 * JD-Core Version:    0.7.0.1
 */