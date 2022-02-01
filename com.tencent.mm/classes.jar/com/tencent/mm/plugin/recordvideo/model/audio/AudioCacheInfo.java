package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.recordvideo.e.b;
import com.tencent.mm.protocal.protobuf.bxd;
import com.tencent.mm.protocal.protobuf.bxe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "cachePath", "", "getCachePath", "()Ljava/lang/String;", "setCachePath", "(Ljava/lang/String;)V", "cached", "", "getCached", "()Z", "setCached", "(Z)V", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "failed", "getFailed", "setFailed", "lyricsList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "Lkotlin/collections/ArrayList;", "getLyricsList", "()Ljava/util/ArrayList;", "setLyricsList", "(Ljava/util/ArrayList;)V", "musicId", "getMusicId", "setMusicId", "musicUrl", "getMusicUrl", "setMusicUrl", "position", "getPosition", "setPosition", "request_id", "", "getRequest_id", "()J", "setRequest_id", "(J)V", "showLyrics", "getShowLyrics", "setShowLyrics", "singers", "getSingers", "setSingers", "songName", "getSongName", "setSongName", "source", "getSource", "setSource", "type", "getType", "setType", "describeContents", "()Ljava/lang/Integer;", "toString", "writeToParcel", "", "flags", "Companion", "MusicLrcBean", "plugin-recordvideo_release"})
public final class AudioCacheInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AudioCacheInfo> CREATOR;
  private static final String TAG = "MicroMsg.AudioCacheInfo";
  private static final String xzf = "AUDIO_CACHE_INFO_INDEX_KEY";
  private static final String xzg = "AUDIO_CACHE_INFO_LIST_KEY";
  private static final String xzh = "SELECT_MUTE_ORIGIN_KEY";
  private static final int xzi = 1;
  private static final int xzj = 2;
  private static final int xzk = 3;
  private static final int xzl = 4;
  private static final int xzm = 5;
  private static final int xzn = 0;
  private static final int xzo = 1;
  public static final a xzp;
  public boolean aXj;
  public String cachePath;
  public int dnh;
  int duration;
  public String musicUrl;
  public int position;
  public int type;
  public boolean xwY;
  public int xyZ;
  public ArrayList<c> xza;
  public ArrayList<String> xzb;
  public boolean xzc;
  public String xzd;
  public long xze;
  
  static
  {
    AppMethodBeat.i(75405);
    xzp = new a((byte)0);
    TAG = "MicroMsg.AudioCacheInfo";
    xzf = "AUDIO_CACHE_INFO_INDEX_KEY";
    xzg = "AUDIO_CACHE_INFO_LIST_KEY";
    xzh = "SELECT_MUTE_ORIGIN_KEY";
    xzi = 1;
    xzj = 2;
    xzk = 3;
    xzl = 4;
    xzm = 5;
    xzo = 1;
    CREATOR = (Parcelable.Creator)new AudioCacheInfo.b();
    AppMethodBeat.o(75405);
  }
  
  public AudioCacheInfo()
  {
    AppMethodBeat.i(75403);
    this.xzb = new ArrayList();
    this.xwY = true;
    this.xzd = "";
    this.position = -1;
    this.xze = -1L;
    AppMethodBeat.o(75403);
  }
  
  public AudioCacheInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(75404);
    this.xyZ = paramParcel.readInt();
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
      this.xzc = bool1;
      this.position = paramParcel.readInt();
      this.xze = paramParcel.readLong();
      this.type = paramParcel.readInt();
      paramParcel = paramParcel.readString();
      p.g(paramParcel, "parcel.readString()");
      this.xzd = paramParcel;
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
    String str = "AudioCacheInfo(musicId=" + this.xyZ + ", musicUrl=" + this.musicUrl + ", lyricsList=" + this.xza + ", cachePath=" + this.cachePath + ", cached=" + this.aXj + ", failed=" + this.xzc + ", type=" + this.type + ", songName='" + this.xzd + "', position=" + this.position + ", request_id=" + this.xze + ')';
    AppMethodBeat.o(75402);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(75401);
    p.h(paramParcel, "parcel");
    paramParcel.writeInt(this.xyZ);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.cachePath);
    if (this.aXj)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.xzc) {
        break label112;
      }
    }
    label112:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.position);
      paramParcel.writeLong(this.xze);
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.xzd);
      AppMethodBeat.o(75401);
      return;
      b1 = 0;
      break;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$Companion;", "", "()V", "AUDIO_CACHE_INFO_INDEX_KEY", "", "getAUDIO_CACHE_INFO_INDEX_KEY", "()Ljava/lang/String;", "AUDIO_CACHE_INFO_LIST_KEY", "getAUDIO_CACHE_INFO_LIST_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "SELECT_MUTE_ORIGIN_KEY", "getSELECT_MUTE_ORIGIN_KEY", "SOURCE_TYPE_NORMAL", "", "getSOURCE_TYPE_NORMAL", "()I", "SOURCE_TYPE_SEARCH", "getSOURCE_TYPE_SEARCH", "TAG", "getTAG", "VIEW_TYPE_LOADING", "getVIEW_TYPE_LOADING", "VIEW_TYPE_NORMAL", "getVIEW_TYPE_NORMAL", "VIEW_TYPE_SEARCH_ENTRANCE", "getVIEW_TYPE_SEARCH_ENTRANCE", "VIEW_TYPE_SEARCH_LOADING", "getVIEW_TYPE_SEARCH_LOADING", "VIEW_TYPE_SEARCH_RESULT", "getVIEW_TYPE_SEARCH_RESULT", "createFromMusicInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "type", "createLoadingInfo", "createSearchEntranceInfo", "createSearchLoadingInfo", "plugin-recordvideo_release"})
  public static final class a
  {
    public static AudioCacheInfo a(bxd parambxd, int paramInt)
    {
      boolean bool2 = true;
      AppMethodBeat.i(169930);
      p.h(parambxd, "info");
      AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
      localAudioCacheInfo.xyZ = parambxd.GQZ;
      localAudioCacheInfo.musicUrl = parambxd.GRf;
      Object localObject1 = new ArrayList();
      Object localObject2 = parambxd.GRj;
      p.g(localObject2, "info.lyrics");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        bxe localbxe = (bxe)((Iterator)localObject2).next();
        if (!bt.isNullOrNil(localbxe.GRn))
        {
          Object localObject3 = localbxe.GRn;
          p.g(localObject3, "it.lyrics_content");
          localObject3 = new AudioCacheInfo.c((String)localObject3, localbxe.GRm, localbxe.GRm);
          if (!bt.hj((List)localObject1)) {
            ((AudioCacheInfo.c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).xzr = localbxe.GRm;
          }
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      if (bt.hj((List)localObject1))
      {
        localObject2 = aj.getResources().getString(2131761471);
        p.g(localObject2, "MMApplicationContext.get…ring.music_no_lyrics_tip)");
        ((ArrayList)localObject1).add(new AudioCacheInfo.c((String)localObject2, 0, 0));
      }
      localAudioCacheInfo.xzb.addAll((Collection)parambxd.GRi);
      localAudioCacheInfo.xza = ((ArrayList)localObject1);
      localObject1 = b.xRl;
      localObject1 = parambxd.GQZ + '_' + cf.aCL();
      if (localObject1 == null)
      {
        localObject1 = "";
        localAudioCacheInfo.cachePath = ((String)localObject1);
        if (i.aYo((String)localObject1) <= 0L) {
          break label468;
        }
        bool1 = true;
        label318:
        localAudioCacheInfo.aXj = bool1;
        localAudioCacheInfo.xzc = false;
        localObject1 = parambxd.GRh;
        p.g(localObject1, "info.song_name");
        p.h(localObject1, "<set-?>");
        localAudioCacheInfo.xzd = ((String)localObject1);
        localAudioCacheInfo.type = paramInt;
        localAudioCacheInfo.duration = parambxd.duration;
        if (parambxd.GRl != 1) {
          break label473;
        }
      }
      label468:
      label473:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localAudioCacheInfo.xwY = bool1;
        ad.i(AudioCacheInfo.access$getTAG$cp(), "LogStory: " + localAudioCacheInfo.xyZ + ' ' + localAudioCacheInfo.xza);
        AppMethodBeat.o(169930);
        return localAudioCacheInfo;
        localObject1 = b.iO(b.xRk, (String)localObject1) + ".mixa";
        break;
        bool1 = false;
        break label318;
      }
    }
    
    public static AudioCacheInfo dFZ()
    {
      AppMethodBeat.i(200292);
      AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
      localAudioCacheInfo.type = AudioCacheInfo.dFV();
      AppMethodBeat.o(200292);
      return localAudioCacheInfo;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "", "lrc", "", "startTime", "", "stopTime", "(Ljava/lang/String;II)V", "getLrc", "()Ljava/lang/String;", "setLrc", "(Ljava/lang/String;)V", "getStartTime", "()I", "setStartTime", "(I)V", "getStopTime", "setStopTime", "plugin-recordvideo_release"})
  public static final class c
  {
    public int ddx;
    public String xzq;
    public int xzr;
    
    public c(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75400);
      this.xzq = paramString;
      this.ddx = paramInt1;
      this.xzr = paramInt2;
      AppMethodBeat.o(75400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo
 * JD-Core Version:    0.7.0.1
 */