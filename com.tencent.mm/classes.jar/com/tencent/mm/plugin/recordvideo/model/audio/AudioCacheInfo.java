package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "cachePath", "", "getCachePath", "()Ljava/lang/String;", "setCachePath", "(Ljava/lang/String;)V", "cached", "", "getCached", "()Z", "setCached", "(Z)V", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "failed", "getFailed", "setFailed", "local", "getLocal", "setLocal", "lyricsList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "Lkotlin/collections/ArrayList;", "getLyricsList", "()Ljava/util/ArrayList;", "setLyricsList", "(Ljava/util/ArrayList;)V", "musicId", "getMusicId", "setMusicId", "musicUrl", "getMusicUrl", "setMusicUrl", "position", "getPosition", "setPosition", "protoInfo", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getProtoInfo", "()Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "setProtoInfo", "(Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;)V", "request_id", "", "getRequest_id", "()J", "setRequest_id", "(J)V", "showLyrics", "getShowLyrics", "setShowLyrics", "singers", "getSingers", "setSingers", "songName", "getSongName", "setSongName", "source", "getSource", "setSource", "type", "getType", "setType", "describeContents", "()Ljava/lang/Integer;", "toString", "writeToParcel", "", "flags", "Companion", "MusicLrcBean", "plugin-recordvideo_release"})
public final class AudioCacheInfo
  implements Parcelable
{
  private static final String BPe = "AUDIO_CACHE_INFO_INDEX_KEY";
  private static final String BPf = "AUDIO_CACHE_INFO_LIST_KEY";
  private static final String BPg = "SELECT_MUTE_ORIGIN_KEY";
  private static final int BPh = 1;
  private static final int BPi = 2;
  private static final int BPj = 3;
  private static final int BPk = 4;
  private static final int BPl = 5;
  private static final int BPm = 0;
  private static final int BPn = 1;
  public static final a BPo;
  public static final Parcelable.Creator<AudioCacheInfo> CREATOR;
  private static final String TAG = "MicroMsg.AudioCacheInfo";
  public boolean BNb;
  public clp BOW;
  public int BOX;
  public ArrayList<c> BOY;
  public ArrayList<String> BOZ;
  public boolean BPa;
  public boolean BPb;
  public String BPc;
  public long BPd;
  public boolean aXa;
  public String cachePath;
  public int duration;
  public String musicUrl;
  public int position;
  public int source;
  public int type;
  
  static
  {
    AppMethodBeat.i(75405);
    BPo = new a((byte)0);
    TAG = "MicroMsg.AudioCacheInfo";
    BPe = "AUDIO_CACHE_INFO_INDEX_KEY";
    BPf = "AUDIO_CACHE_INFO_LIST_KEY";
    BPg = "SELECT_MUTE_ORIGIN_KEY";
    BPh = 1;
    BPi = 2;
    BPj = 3;
    BPk = 4;
    BPl = 5;
    BPn = 1;
    CREATOR = (Parcelable.Creator)new AudioCacheInfo.b();
    AppMethodBeat.o(75405);
  }
  
  public AudioCacheInfo()
  {
    AppMethodBeat.i(75403);
    this.BOW = new clp();
    this.BOZ = new ArrayList();
    this.BNb = true;
    this.BPc = "";
    this.position = -1;
    this.BPd = -1L;
    AppMethodBeat.o(75403);
  }
  
  public AudioCacheInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(75404);
    this.BOX = paramParcel.readInt();
    this.musicUrl = paramParcel.readString();
    this.cachePath = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.aXa = bool;
      if (paramParcel.readByte() == 0) {
        break label143;
      }
    }
    label143:
    for (boolean bool = true;; bool = false)
    {
      this.BPa = bool;
      this.position = paramParcel.readInt();
      this.BPd = paramParcel.readLong();
      this.type = paramParcel.readInt();
      String str = paramParcel.readString();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.BPc = ((String)localObject);
      localObject = (a)this.BOW;
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
  
  public final void aIa(String paramString)
  {
    AppMethodBeat.i(237259);
    p.h(paramString, "<set-?>");
    this.BPc = paramString;
    AppMethodBeat.o(237259);
  }
  
  public final void b(clp paramclp)
  {
    AppMethodBeat.i(237258);
    p.h(paramclp, "<set-?>");
    this.BOW = paramclp;
    AppMethodBeat.o(237258);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75402);
    String str = "AudioCacheInfo(musicId=" + this.BOX + ", musicUrl=" + this.musicUrl + ", lyricsList=" + this.BOY + ", cachePath=" + this.cachePath + ", cached=" + this.aXa + ", failed=" + this.BPa + ", type=" + this.type + ", songName='" + this.BPc + "', position=" + this.position + ", request_id=" + this.BPd + ')';
    AppMethodBeat.o(75402);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(75401);
    p.h(paramParcel, "parcel");
    paramParcel.writeInt(this.BOX);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.cachePath);
    if (this.aXa)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.BPa) {
        break label123;
      }
    }
    label123:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.position);
      paramParcel.writeLong(this.BPd);
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.BPc);
      paramParcel.writeByteArray(this.BOW.toByteArray());
      AppMethodBeat.o(75401);
      return;
      b1 = 0;
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$Companion;", "", "()V", "AUDIO_CACHE_INFO_INDEX_KEY", "", "getAUDIO_CACHE_INFO_INDEX_KEY", "()Ljava/lang/String;", "AUDIO_CACHE_INFO_LIST_KEY", "getAUDIO_CACHE_INFO_LIST_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "SELECT_MUTE_ORIGIN_KEY", "getSELECT_MUTE_ORIGIN_KEY", "SOURCE_TYPE_NORMAL", "", "getSOURCE_TYPE_NORMAL", "()I", "SOURCE_TYPE_SEARCH", "getSOURCE_TYPE_SEARCH", "TAG", "getTAG", "VIEW_TYPE_LOADING", "getVIEW_TYPE_LOADING", "VIEW_TYPE_NORMAL", "getVIEW_TYPE_NORMAL", "VIEW_TYPE_SEARCH_ENTRANCE", "getVIEW_TYPE_SEARCH_ENTRANCE", "VIEW_TYPE_SEARCH_LOADING", "getVIEW_TYPE_SEARCH_LOADING", "VIEW_TYPE_SEARCH_RESULT", "getVIEW_TYPE_SEARCH_RESULT", "createFromMusicInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "type", "createLoadingInfo", "createSearchEntranceInfo", "createSearchLoadingInfo", "plugin-recordvideo_release"})
  public static final class a
  {
    public static AudioCacheInfo a(clp paramclp, int paramInt)
    {
      boolean bool2 = true;
      AppMethodBeat.i(169930);
      p.h(paramclp, "info");
      AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
      localAudioCacheInfo.b(paramclp);
      localAudioCacheInfo.BOX = paramclp.MqO;
      localAudioCacheInfo.musicUrl = paramclp.MqU;
      Object localObject1 = new ArrayList();
      Object localObject2 = paramclp.MqY;
      p.g(localObject2, "info.lyrics");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        clq localclq = (clq)((Iterator)localObject2).next();
        if (!Util.isNullOrNil(localclq.Mrc))
        {
          Object localObject3 = localclq.Mrc;
          p.g(localObject3, "it.lyrics_content");
          localObject3 = new AudioCacheInfo.c((String)localObject3, localclq.Mrb, localclq.Mrb);
          if (!Util.isNullOrNil((List)localObject1)) {
            ((AudioCacheInfo.c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).BPq = localclq.Mrb;
          }
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      if (Util.isNullOrNil((List)localObject1))
      {
        localObject2 = MMApplicationContext.getResources().getString(2131763374);
        p.g(localObject2, "MMApplicationContext.get…ring.music_no_lyrics_tip)");
        ((ArrayList)localObject1).add(new AudioCacheInfo.c((String)localObject2, 0, 0));
      }
      localAudioCacheInfo.BOZ.addAll((Collection)paramclp.MqX);
      localAudioCacheInfo.BOY = ((ArrayList)localObject1);
      localObject1 = c.Cic;
      localObject1 = c.aLO(paramclp.MqO + '_' + cl.aWz());
      localAudioCacheInfo.cachePath = ((String)localObject1);
      if (s.boW((String)localObject1) > 0L)
      {
        bool1 = true;
        localAudioCacheInfo.aXa = bool1;
        localAudioCacheInfo.BPa = false;
        localObject1 = paramclp.MqW;
        p.g(localObject1, "info.song_name");
        localAudioCacheInfo.aIa((String)localObject1);
        localAudioCacheInfo.type = paramInt;
        localAudioCacheInfo.duration = paramclp.duration;
        if (paramclp.Mra != 1) {
          break label434;
        }
      }
      label434:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localAudioCacheInfo.BNb = bool1;
        Log.i(AudioCacheInfo.access$getTAG$cp(), "LogStory: " + localAudioCacheInfo.BOX + ' ' + localAudioCacheInfo.BOY);
        AppMethodBeat.o(169930);
        return localAudioCacheInfo;
        bool1 = false;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "", "lrc", "", "startTime", "", "stopTime", "(Ljava/lang/String;II)V", "getLrc", "()Ljava/lang/String;", "setLrc", "(Ljava/lang/String;)V", "getStartTime", "()I", "setStartTime", "(I)V", "getStopTime", "setStopTime", "plugin-recordvideo_release"})
  public static final class c
  {
    public String BPp;
    public int BPq;
    public int dvv;
    
    public c(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(75400);
      this.BPp = paramString;
      this.dvv = paramInt1;
      this.BPq = paramInt2;
      AppMethodBeat.o(75400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo
 * JD-Core Version:    0.7.0.1
 */