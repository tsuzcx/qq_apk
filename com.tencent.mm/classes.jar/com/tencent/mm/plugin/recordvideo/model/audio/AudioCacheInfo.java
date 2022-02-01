package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.recordvideo.e.b;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "cachePath", "", "getCachePath", "()Ljava/lang/String;", "setCachePath", "(Ljava/lang/String;)V", "cached", "", "getCached", "()Z", "setCached", "(Z)V", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "failed", "getFailed", "setFailed", "lyricsList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "Lkotlin/collections/ArrayList;", "getLyricsList", "()Ljava/util/ArrayList;", "setLyricsList", "(Ljava/util/ArrayList;)V", "musicId", "getMusicId", "setMusicId", "musicUrl", "getMusicUrl", "setMusicUrl", "position", "getPosition", "setPosition", "request_id", "", "getRequest_id", "()J", "setRequest_id", "(J)V", "showLyrics", "getShowLyrics", "setShowLyrics", "singers", "getSingers", "setSingers", "songName", "getSongName", "setSongName", "source", "getSource", "setSource", "type", "getType", "setType", "describeContents", "()Ljava/lang/Integer;", "toString", "writeToParcel", "", "flags", "Companion", "MusicLrcBean", "plugin-recordvideo_release"})
public final class AudioCacheInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AudioCacheInfo> CREATOR;
  private static final String Lnc = "AUDIO_CACHE_INFO_INDEX_KEY";
  private static final String Lnd = "AUDIO_CACHE_INFO_LIST_KEY";
  private static final String Lne = "SELECT_MUTE_ORIGIN_KEY";
  private static final String TAG = "MicroMsg.AudioCacheInfo";
  private static final int viF = 1;
  private static final int viG = 2;
  private static final int viH = 3;
  private static final int viI = 4;
  private static final int viJ = 5;
  private static final int viK = 0;
  private static final int viL = 1;
  public static final a viM;
  public boolean aMb;
  public String cachePath;
  public int dep;
  int duration;
  public String musicUrl;
  public int position;
  public int type;
  public boolean vgw;
  public ArrayList<c> viA;
  public ArrayList<String> viB;
  public boolean viC;
  public String viD;
  public long viE;
  public int viz;
  
  static
  {
    AppMethodBeat.i(75405);
    viM = new a((byte)0);
    TAG = "MicroMsg.AudioCacheInfo";
    Lnc = "AUDIO_CACHE_INFO_INDEX_KEY";
    Lnd = "AUDIO_CACHE_INFO_LIST_KEY";
    Lne = "SELECT_MUTE_ORIGIN_KEY";
    viF = 1;
    viG = 2;
    viH = 3;
    viI = 4;
    viJ = 5;
    viL = 1;
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(75405);
  }
  
  public AudioCacheInfo()
  {
    AppMethodBeat.i(75403);
    this.viB = new ArrayList();
    this.vgw = true;
    this.viD = "";
    this.position = -1;
    this.viE = -1L;
    AppMethodBeat.o(75403);
  }
  
  public AudioCacheInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(75404);
    this.viz = paramParcel.readInt();
    this.musicUrl = paramParcel.readString();
    this.cachePath = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.aMb = bool1;
      if (paramParcel.readByte() == 0) {
        break label120;
      }
    }
    label120:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.viC = bool1;
      this.position = paramParcel.readInt();
      this.viE = paramParcel.readLong();
      this.type = paramParcel.readInt();
      paramParcel = paramParcel.readString();
      k.g(paramParcel, "parcel.readString()");
      this.viD = paramParcel;
      AppMethodBeat.o(75404);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75402);
    String str = "AudioCacheInfo(musicId=" + this.viz + ", musicUrl=" + this.musicUrl + ", lyricsList=" + this.viA + ", cachePath=" + this.cachePath + ", cached=" + this.aMb + ", failed=" + this.viC + ", type=" + this.type + ", songName='" + this.viD + "', position=" + this.position + ", request_id=" + this.viE + ')';
    AppMethodBeat.o(75402);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(75401);
    k.h(paramParcel, "parcel");
    paramParcel.writeInt(this.viz);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.cachePath);
    if (this.aMb)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.viC) {
        break label112;
      }
    }
    label112:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.position);
      paramParcel.writeLong(this.viE);
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.viD);
      AppMethodBeat.o(75401);
      return;
      b1 = 0;
      break;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$Companion;", "", "()V", "AUDIO_CACHE_INFO_INDEX_KEY", "", "getAUDIO_CACHE_INFO_INDEX_KEY", "()Ljava/lang/String;", "AUDIO_CACHE_INFO_LIST_KEY", "getAUDIO_CACHE_INFO_LIST_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "SELECT_MUTE_ORIGIN_KEY", "getSELECT_MUTE_ORIGIN_KEY", "SOURCE_TYPE_NORMAL", "", "getSOURCE_TYPE_NORMAL", "()I", "SOURCE_TYPE_SEARCH", "getSOURCE_TYPE_SEARCH", "TAG", "getTAG", "VIEW_TYPE_LOADING", "getVIEW_TYPE_LOADING", "VIEW_TYPE_NORMAL", "getVIEW_TYPE_NORMAL", "VIEW_TYPE_SEARCH_ENTRANCE", "getVIEW_TYPE_SEARCH_ENTRANCE", "VIEW_TYPE_SEARCH_LOADING", "getVIEW_TYPE_SEARCH_LOADING", "VIEW_TYPE_SEARCH_RESULT", "getVIEW_TYPE_SEARCH_RESULT", "createFromMusicInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "type", "createLoadingInfo", "createSearchEntranceInfo", "createSearchLoadingInfo", "plugin-recordvideo_release"})
  public static final class a
  {
    public static AudioCacheInfo a(boa paramboa, int paramInt)
    {
      boolean bool2 = true;
      AppMethodBeat.i(169930);
      k.h(paramboa, "info");
      AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
      localAudioCacheInfo.viz = paramboa.DLi;
      localAudioCacheInfo.musicUrl = paramboa.DLo;
      Object localObject1 = new ArrayList();
      Object localObject2 = paramboa.DLs;
      k.g(localObject2, "info.lyrics");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        bob localbob = (bob)((Iterator)localObject2).next();
        if (!bt.isNullOrNil(localbob.DLw))
        {
          Object localObject3 = localbob.DLw;
          k.g(localObject3, "it.lyrics_content");
          localObject3 = new AudioCacheInfo.c((String)localObject3, localbob.DLv, localbob.DLv);
          if (!bt.gL((List)localObject1)) {
            ((AudioCacheInfo.c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).viO = localbob.DLv;
          }
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      if (bt.gL((List)localObject1))
      {
        localObject2 = aj.getResources().getString(2131761471);
        k.g(localObject2, "MMApplicationContext.get…ring.music_no_lyrics_tip)");
        ((ArrayList)localObject1).add(new AudioCacheInfo.c((String)localObject2, 0, 0));
      }
      localAudioCacheInfo.viB.addAll((Collection)paramboa.DLr);
      localAudioCacheInfo.viA = ((ArrayList)localObject1);
      localObject1 = b.vtE;
      localObject1 = paramboa.DLi + '_' + ce.asR();
      if (localObject1 == null)
      {
        localObject1 = "";
        localAudioCacheInfo.cachePath = ((String)localObject1);
        if (i.aMN((String)localObject1) <= 0L) {
          break label468;
        }
        bool1 = true;
        label318:
        localAudioCacheInfo.aMb = bool1;
        localAudioCacheInfo.viC = false;
        localObject1 = paramboa.DLq;
        k.g(localObject1, "info.song_name");
        k.h(localObject1, "<set-?>");
        localAudioCacheInfo.viD = ((String)localObject1);
        localAudioCacheInfo.type = paramInt;
        localAudioCacheInfo.duration = paramboa.duration;
        if (paramboa.DLu != 1) {
          break label473;
        }
      }
      label468:
      label473:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localAudioCacheInfo.vgw = bool1;
        ad.i(AudioCacheInfo.access$getTAG$cp(), "LogStory: " + localAudioCacheInfo.viz + ' ' + localAudioCacheInfo.viA);
        AppMethodBeat.o(169930);
        return localAudioCacheInfo;
        localObject1 = b.ii(b.vtD, (String)localObject1) + ".mixa";
        break;
        bool1 = false;
        break label318;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
  public static final class b
    implements Parcelable.Creator<AudioCacheInfo>
  {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "", "lrc", "", "startTime", "", "stopTime", "(Ljava/lang/String;II)V", "getLrc", "()Ljava/lang/String;", "setLrc", "(Ljava/lang/String;)V", "getStartTime", "()I", "setStartTime", "(I)V", "getStopTime", "setStopTime", "plugin-recordvideo_release"})
  public static final class c
  {
    public int cUL;
    public String viN;
    public int viO;
    
    public c(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75400);
      this.viN = paramString;
      this.cUL = paramInt1;
      this.viO = paramInt2;
      AppMethodBeat.o(75400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo
 * JD-Core Version:    0.7.0.1
 */