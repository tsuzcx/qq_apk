package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.recordvideo.e.b;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "cachePath", "", "getCachePath", "()Ljava/lang/String;", "setCachePath", "(Ljava/lang/String;)V", "cached", "", "getCached", "()Z", "setCached", "(Z)V", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "failed", "getFailed", "setFailed", "lyricsList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "Lkotlin/collections/ArrayList;", "getLyricsList", "()Ljava/util/ArrayList;", "setLyricsList", "(Ljava/util/ArrayList;)V", "musicId", "getMusicId", "setMusicId", "musicUrl", "getMusicUrl", "setMusicUrl", "position", "getPosition", "setPosition", "request_id", "", "getRequest_id", "()J", "setRequest_id", "(J)V", "showLyrics", "getShowLyrics", "setShowLyrics", "singers", "getSingers", "setSingers", "songName", "getSongName", "setSongName", "source", "getSource", "setSource", "type", "getType", "setType", "describeContents", "()Ljava/lang/Integer;", "toString", "writeToParcel", "", "flags", "Companion", "MusicLrcBean", "plugin-recordvideo_release"})
public final class AudioCacheInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AudioCacheInfo> CREATOR;
  private static final String TAG = "MicroMsg.AudioCacheInfo";
  private static final String wro = "AUDIO_CACHE_INFO_INDEX_KEY";
  private static final String wrp = "AUDIO_CACHE_INFO_LIST_KEY";
  private static final String wrq = "SELECT_MUTE_ORIGIN_KEY";
  private static final int wrr = 1;
  private static final int wrs = 2;
  private static final int wrt = 3;
  private static final int wru = 4;
  private static final int wrv = 5;
  private static final int wrw = 0;
  private static final int wrx = 1;
  public static final a wry;
  public boolean aMR;
  public String cachePath;
  public int dbL;
  int duration;
  public String musicUrl;
  public int position;
  public int type;
  public boolean wpi;
  public int wri;
  public ArrayList<c> wrj;
  public ArrayList<String> wrk;
  public boolean wrl;
  public String wrm;
  public long wrn;
  
  static
  {
    AppMethodBeat.i(75405);
    wry = new a((byte)0);
    TAG = "MicroMsg.AudioCacheInfo";
    wro = "AUDIO_CACHE_INFO_INDEX_KEY";
    wrp = "AUDIO_CACHE_INFO_LIST_KEY";
    wrq = "SELECT_MUTE_ORIGIN_KEY";
    wrr = 1;
    wrs = 2;
    wrt = 3;
    wru = 4;
    wrv = 5;
    wrx = 1;
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(75405);
  }
  
  public AudioCacheInfo()
  {
    AppMethodBeat.i(75403);
    this.wrk = new ArrayList();
    this.wpi = true;
    this.wrm = "";
    this.position = -1;
    this.wrn = -1L;
    AppMethodBeat.o(75403);
  }
  
  public AudioCacheInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(75404);
    this.wri = paramParcel.readInt();
    this.musicUrl = paramParcel.readString();
    this.cachePath = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.aMR = bool1;
      if (paramParcel.readByte() == 0) {
        break label120;
      }
    }
    label120:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.wrl = bool1;
      this.position = paramParcel.readInt();
      this.wrn = paramParcel.readLong();
      this.type = paramParcel.readInt();
      paramParcel = paramParcel.readString();
      k.g(paramParcel, "parcel.readString()");
      this.wrm = paramParcel;
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
    String str = "AudioCacheInfo(musicId=" + this.wri + ", musicUrl=" + this.musicUrl + ", lyricsList=" + this.wrj + ", cachePath=" + this.cachePath + ", cached=" + this.aMR + ", failed=" + this.wrl + ", type=" + this.type + ", songName='" + this.wrm + "', position=" + this.position + ", request_id=" + this.wrn + ')';
    AppMethodBeat.o(75402);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(75401);
    k.h(paramParcel, "parcel");
    paramParcel.writeInt(this.wri);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.cachePath);
    if (this.aMR)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.wrl) {
        break label112;
      }
    }
    label112:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.position);
      paramParcel.writeLong(this.wrn);
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.wrm);
      AppMethodBeat.o(75401);
      return;
      b1 = 0;
      break;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$Companion;", "", "()V", "AUDIO_CACHE_INFO_INDEX_KEY", "", "getAUDIO_CACHE_INFO_INDEX_KEY", "()Ljava/lang/String;", "AUDIO_CACHE_INFO_LIST_KEY", "getAUDIO_CACHE_INFO_LIST_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "SELECT_MUTE_ORIGIN_KEY", "getSELECT_MUTE_ORIGIN_KEY", "SOURCE_TYPE_NORMAL", "", "getSOURCE_TYPE_NORMAL", "()I", "SOURCE_TYPE_SEARCH", "getSOURCE_TYPE_SEARCH", "TAG", "getTAG", "VIEW_TYPE_LOADING", "getVIEW_TYPE_LOADING", "VIEW_TYPE_NORMAL", "getVIEW_TYPE_NORMAL", "VIEW_TYPE_SEARCH_ENTRANCE", "getVIEW_TYPE_SEARCH_ENTRANCE", "VIEW_TYPE_SEARCH_LOADING", "getVIEW_TYPE_SEARCH_LOADING", "VIEW_TYPE_SEARCH_RESULT", "getVIEW_TYPE_SEARCH_RESULT", "createFromMusicInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "type", "createLoadingInfo", "createSearchEntranceInfo", "createSearchLoadingInfo", "plugin-recordvideo_release"})
  public static final class a
  {
    public static AudioCacheInfo a(bsq parambsq, int paramInt)
    {
      boolean bool2 = true;
      AppMethodBeat.i(169930);
      k.h(parambsq, "info");
      AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
      localAudioCacheInfo.wri = parambsq.Fhx;
      localAudioCacheInfo.musicUrl = parambsq.FhD;
      Object localObject1 = new ArrayList();
      Object localObject2 = parambsq.FhH;
      k.g(localObject2, "info.lyrics");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        bsr localbsr = (bsr)((Iterator)localObject2).next();
        if (!bs.isNullOrNil(localbsr.FhL))
        {
          Object localObject3 = localbsr.FhL;
          k.g(localObject3, "it.lyrics_content");
          localObject3 = new AudioCacheInfo.c((String)localObject3, localbsr.FhK, localbsr.FhK);
          if (!bs.gY((List)localObject1)) {
            ((AudioCacheInfo.c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).wrA = localbsr.FhK;
          }
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      if (bs.gY((List)localObject1))
      {
        localObject2 = ai.getResources().getString(2131761471);
        k.g(localObject2, "MMApplicationContext.get…ring.music_no_lyrics_tip)");
        ((ArrayList)localObject1).add(new AudioCacheInfo.c((String)localObject2, 0, 0));
      }
      localAudioCacheInfo.wrk.addAll((Collection)parambsq.FhG);
      localAudioCacheInfo.wrj = ((ArrayList)localObject1);
      localObject1 = b.wDE;
      localObject1 = parambsq.Fhx + '_' + ce.azI();
      if (localObject1 == null)
      {
        localObject1 = "";
        localAudioCacheInfo.cachePath = ((String)localObject1);
        if (i.aSp((String)localObject1) <= 0L) {
          break label468;
        }
        bool1 = true;
        label318:
        localAudioCacheInfo.aMR = bool1;
        localAudioCacheInfo.wrl = false;
        localObject1 = parambsq.FhF;
        k.g(localObject1, "info.song_name");
        k.h(localObject1, "<set-?>");
        localAudioCacheInfo.wrm = ((String)localObject1);
        localAudioCacheInfo.type = paramInt;
        localAudioCacheInfo.duration = parambsq.duration;
        if (parambsq.FhJ != 1) {
          break label473;
        }
      }
      label468:
      label473:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localAudioCacheInfo.wpi = bool1;
        ac.i(AudioCacheInfo.access$getTAG$cp(), "LogStory: " + localAudioCacheInfo.wri + ' ' + localAudioCacheInfo.wrj);
        AppMethodBeat.o(169930);
        return localAudioCacheInfo;
        localObject1 = b.iB(b.wDD, (String)localObject1) + ".mixa";
        break;
        bool1 = false;
        break label318;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
  public static final class b
    implements Parcelable.Creator<AudioCacheInfo>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "", "lrc", "", "startTime", "", "stopTime", "(Ljava/lang/String;II)V", "getLrc", "()Ljava/lang/String;", "setLrc", "(Ljava/lang/String;)V", "getStartTime", "()I", "setStartTime", "(I)V", "getStopTime", "setStopTime", "plugin-recordvideo_release"})
  public static final class c
  {
    public int cSh;
    public int wrA;
    public String wrz;
    
    public c(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75400);
      this.wrz = paramString;
      this.cSh = paramInt1;
      this.wrA = paramInt2;
      AppMethodBeat.o(75400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo
 * JD-Core Version:    0.7.0.1
 */