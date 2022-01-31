package com.tencent.mm.plugin.story.model.audio;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.view.editor.item.e;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "cachePath", "", "getCachePath", "()Ljava/lang/String;", "setCachePath", "(Ljava/lang/String;)V", "cached", "", "getCached", "()Z", "setCached", "(Z)V", "failed", "getFailed", "setFailed", "lyricsList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcBean;", "Lkotlin/collections/ArrayList;", "getLyricsList", "()Ljava/util/ArrayList;", "setLyricsList", "(Ljava/util/ArrayList;)V", "musicId", "", "getMusicId", "()I", "setMusicId", "(I)V", "musicUrl", "getMusicUrl", "setMusicUrl", "position", "getPosition", "setPosition", "request_id", "", "getRequest_id", "()J", "setRequest_id", "(J)V", "singers", "getSingers", "setSingers", "songName", "getSongName", "setSongName", "source", "getSource", "setSource", "type", "getType", "setType", "describeContents", "()Ljava/lang/Integer;", "toString", "writeToParcel", "", "flags", "Companion", "plugin-story_release"})
public final class AudioCacheInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AudioCacheInfo> CREATOR;
  private static final String TAG = "MicroMsg.AudioCacheInfo";
  private static final int swA = 0;
  private static final int swB = 1;
  public static final AudioCacheInfo.a swC;
  private static final int swv = 1;
  private static final int sww = 2;
  private static final int swx = 3;
  private static final int swy = 4;
  private static final int swz = 5;
  public boolean arq;
  public String cachePath;
  public int cpt;
  public String musicUrl;
  public int position;
  public int swp;
  public ArrayList<e> swq;
  public ArrayList<String> swr;
  public boolean sws;
  public String swt;
  public long swu;
  public int type;
  
  static
  {
    AppMethodBeat.i(109176);
    swC = new AudioCacheInfo.a((byte)0);
    TAG = "MicroMsg.AudioCacheInfo";
    swv = 1;
    sww = 2;
    swx = 3;
    swy = 4;
    swz = 5;
    swB = 1;
    CREATOR = (Parcelable.Creator)new AudioCacheInfo.b();
    AppMethodBeat.o(109176);
  }
  
  public AudioCacheInfo()
  {
    AppMethodBeat.i(109174);
    this.swr = new ArrayList();
    this.swt = "";
    this.position = -1;
    this.swu = -1L;
    AppMethodBeat.o(109174);
  }
  
  public AudioCacheInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(109175);
    this.swp = paramParcel.readInt();
    this.musicUrl = paramParcel.readString();
    this.cachePath = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.arq = bool1;
      if (paramParcel.readByte() == 0) {
        break label120;
      }
    }
    label120:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.sws = bool1;
      this.position = paramParcel.readInt();
      this.swu = paramParcel.readLong();
      this.type = paramParcel.readInt();
      paramParcel = paramParcel.readString();
      j.p(paramParcel, "parcel.readString()");
      this.swt = paramParcel;
      AppMethodBeat.o(109175);
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
    AppMethodBeat.i(151062);
    String str = "AudioCacheInfo(musicId=" + this.swp + ", musicUrl=" + this.musicUrl + ", lyricsList=" + this.swq + ", cachePath=" + this.cachePath + ", cached=" + this.arq + ", failed=" + this.sws + ", type=" + this.type + ", songName='" + this.swt + "', position=" + this.position + ", request_id=" + this.swu + ')';
    AppMethodBeat.o(151062);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(109173);
    j.q(paramParcel, "parcel");
    paramParcel.writeInt(this.swp);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.cachePath);
    if (this.arq)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.sws) {
        break label112;
      }
    }
    label112:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.position);
      paramParcel.writeLong(this.swu);
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.swt);
      AppMethodBeat.o(109173);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.audio.AudioCacheInfo
 * JD-Core Version:    0.7.0.1
 */