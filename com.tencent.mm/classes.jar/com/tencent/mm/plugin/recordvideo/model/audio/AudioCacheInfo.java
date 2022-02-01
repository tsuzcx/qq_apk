package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.recordvideo.e.b;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.bxy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "cachePath", "", "getCachePath", "()Ljava/lang/String;", "setCachePath", "(Ljava/lang/String;)V", "cached", "", "getCached", "()Z", "setCached", "(Z)V", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "failed", "getFailed", "setFailed", "lyricsList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "Lkotlin/collections/ArrayList;", "getLyricsList", "()Ljava/util/ArrayList;", "setLyricsList", "(Ljava/util/ArrayList;)V", "musicId", "getMusicId", "setMusicId", "musicUrl", "getMusicUrl", "setMusicUrl", "position", "getPosition", "setPosition", "request_id", "", "getRequest_id", "()J", "setRequest_id", "(J)V", "showLyrics", "getShowLyrics", "setShowLyrics", "singers", "getSingers", "setSingers", "songName", "getSongName", "setSongName", "source", "getSource", "setSource", "type", "getType", "setType", "describeContents", "()Ljava/lang/Integer;", "toString", "writeToParcel", "", "flags", "Companion", "MusicLrcBean", "plugin-recordvideo_release"})
public final class AudioCacheInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AudioCacheInfo> CREATOR;
  private static final String TAG = "MicroMsg.AudioCacheInfo";
  private static final String xPb = "AUDIO_CACHE_INFO_INDEX_KEY";
  private static final String xPc = "AUDIO_CACHE_INFO_LIST_KEY";
  private static final String xPd = "SELECT_MUTE_ORIGIN_KEY";
  private static final int xPe = 1;
  private static final int xPf = 2;
  private static final int xPg = 3;
  private static final int xPh = 4;
  private static final int xPi = 5;
  private static final int xPj = 0;
  private static final int xPk = 1;
  public static final a xPl;
  public boolean aXj;
  public String cachePath;
  public int doj;
  int duration;
  public String musicUrl;
  public int position;
  public int type;
  public boolean xMV;
  public int xOV;
  public ArrayList<c> xOW;
  public ArrayList<String> xOX;
  public boolean xOY;
  public String xOZ;
  public long xPa;
  
  static
  {
    AppMethodBeat.i(75405);
    xPl = new a((byte)0);
    TAG = "MicroMsg.AudioCacheInfo";
    xPb = "AUDIO_CACHE_INFO_INDEX_KEY";
    xPc = "AUDIO_CACHE_INFO_LIST_KEY";
    xPd = "SELECT_MUTE_ORIGIN_KEY";
    xPe = 1;
    xPf = 2;
    xPg = 3;
    xPh = 4;
    xPi = 5;
    xPk = 1;
    CREATOR = (Parcelable.Creator)new AudioCacheInfo.b();
    AppMethodBeat.o(75405);
  }
  
  public AudioCacheInfo()
  {
    AppMethodBeat.i(75403);
    this.xOX = new ArrayList();
    this.xMV = true;
    this.xOZ = "";
    this.position = -1;
    this.xPa = -1L;
    AppMethodBeat.o(75403);
  }
  
  public AudioCacheInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(75404);
    this.xOV = paramParcel.readInt();
    this.musicUrl = paramParcel.readString();
    this.cachePath = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.aXj = bool1;
      if (paramParcel.readByte() == 0) {
        break label120;
      }
    }
    label120:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.xOY = bool1;
      this.position = paramParcel.readInt();
      this.xPa = paramParcel.readLong();
      this.type = paramParcel.readInt();
      paramParcel = paramParcel.readString();
      p.g(paramParcel, "parcel.readString()");
      this.xOZ = paramParcel;
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
    String str = "AudioCacheInfo(musicId=" + this.xOV + ", musicUrl=" + this.musicUrl + ", lyricsList=" + this.xOW + ", cachePath=" + this.cachePath + ", cached=" + this.aXj + ", failed=" + this.xOY + ", type=" + this.type + ", songName='" + this.xOZ + "', position=" + this.position + ", request_id=" + this.xPa + ')';
    AppMethodBeat.o(75402);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(75401);
    p.h(paramParcel, "parcel");
    paramParcel.writeInt(this.xOV);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.cachePath);
    if (this.aXj)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.xOY) {
        break label112;
      }
    }
    label112:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.position);
      paramParcel.writeLong(this.xPa);
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.xOZ);
      AppMethodBeat.o(75401);
      return;
      b1 = 0;
      break;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$Companion;", "", "()V", "AUDIO_CACHE_INFO_INDEX_KEY", "", "getAUDIO_CACHE_INFO_INDEX_KEY", "()Ljava/lang/String;", "AUDIO_CACHE_INFO_LIST_KEY", "getAUDIO_CACHE_INFO_LIST_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "SELECT_MUTE_ORIGIN_KEY", "getSELECT_MUTE_ORIGIN_KEY", "SOURCE_TYPE_NORMAL", "", "getSOURCE_TYPE_NORMAL", "()I", "SOURCE_TYPE_SEARCH", "getSOURCE_TYPE_SEARCH", "TAG", "getTAG", "VIEW_TYPE_LOADING", "getVIEW_TYPE_LOADING", "VIEW_TYPE_NORMAL", "getVIEW_TYPE_NORMAL", "VIEW_TYPE_SEARCH_ENTRANCE", "getVIEW_TYPE_SEARCH_ENTRANCE", "VIEW_TYPE_SEARCH_LOADING", "getVIEW_TYPE_SEARCH_LOADING", "VIEW_TYPE_SEARCH_RESULT", "getVIEW_TYPE_SEARCH_RESULT", "createFromMusicInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "type", "createLoadingInfo", "createSearchEntranceInfo", "createSearchLoadingInfo", "plugin-recordvideo_release"})
  public static final class a
  {
    public static AudioCacheInfo a(bxx parambxx, int paramInt)
    {
      boolean bool2 = true;
      AppMethodBeat.i(169930);
      p.h(parambxx, "info");
      AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
      localAudioCacheInfo.xOV = parambxx.HkA;
      localAudioCacheInfo.musicUrl = parambxx.HkG;
      Object localObject1 = new ArrayList();
      Object localObject2 = parambxx.HkK;
      p.g(localObject2, "info.lyrics");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        bxy localbxy = (bxy)((Iterator)localObject2).next();
        if (!bu.isNullOrNil(localbxy.HkO))
        {
          Object localObject3 = localbxy.HkO;
          p.g(localObject3, "it.lyrics_content");
          localObject3 = new AudioCacheInfo.c((String)localObject3, localbxy.HkN, localbxy.HkN);
          if (!bu.ht((List)localObject1)) {
            ((AudioCacheInfo.c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).xPn = localbxy.HkN;
          }
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      if (bu.ht((List)localObject1))
      {
        localObject2 = ak.getResources().getString(2131761471);
        p.g(localObject2, "MMApplicationContext.get…ring.music_no_lyrics_tip)");
        ((ArrayList)localObject1).add(new AudioCacheInfo.c((String)localObject2, 0, 0));
      }
      localAudioCacheInfo.xOX.addAll((Collection)parambxx.HkJ);
      localAudioCacheInfo.xOW = ((ArrayList)localObject1);
      localObject1 = b.yhe;
      localObject1 = parambxx.HkA + '_' + ch.aDb();
      if (localObject1 == null)
      {
        localObject1 = "";
        localAudioCacheInfo.cachePath = ((String)localObject1);
        if (o.aZR((String)localObject1) <= 0L) {
          break label468;
        }
        bool1 = true;
        label318:
        localAudioCacheInfo.aXj = bool1;
        localAudioCacheInfo.xOY = false;
        localObject1 = parambxx.HkI;
        p.g(localObject1, "info.song_name");
        p.h(localObject1, "<set-?>");
        localAudioCacheInfo.xOZ = ((String)localObject1);
        localAudioCacheInfo.type = paramInt;
        localAudioCacheInfo.duration = parambxx.duration;
        if (parambxx.HkM != 1) {
          break label473;
        }
      }
      label468:
      label473:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localAudioCacheInfo.xMV = bool1;
        ae.i(AudioCacheInfo.access$getTAG$cp(), "LogStory: " + localAudioCacheInfo.xOV + ' ' + localAudioCacheInfo.xOW);
        AppMethodBeat.o(169930);
        return localAudioCacheInfo;
        localObject1 = b.iU(b.yhd, (String)localObject1) + ".mixa";
        break;
        bool1 = false;
        break label318;
      }
    }
    
    public static AudioCacheInfo dJq()
    {
      AppMethodBeat.i(206553);
      AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
      localAudioCacheInfo.type = AudioCacheInfo.dJm();
      AppMethodBeat.o(206553);
      return localAudioCacheInfo;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "", "lrc", "", "startTime", "", "stopTime", "(Ljava/lang/String;II)V", "getLrc", "()Ljava/lang/String;", "setLrc", "(Ljava/lang/String;)V", "getStartTime", "()I", "setStartTime", "(I)V", "getStopTime", "setStopTime", "plugin-recordvideo_release"})
  public static final class c
  {
    public int dez;
    public String xPm;
    public int xPn;
    
    public c(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75400);
      this.xPm = paramString;
      this.dez = paramInt1;
      this.xPn = paramInt2;
      AppMethodBeat.o(75400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo
 * JD-Core Version:    0.7.0.1
 */