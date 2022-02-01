package com.tencent.mm.plugin.recordvideo.model.audio;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/audio/LyricsInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "lyricDatas", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "(Ljava/util/List;)V", "lyrics", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLyrics", "()Ljava/util/ArrayList;", "setLyrics", "(Ljava/util/ArrayList;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "plugin-recordvideo_release"})
public final class LyricsInfo
  implements Parcelable
{
  public static final a CREATOR;
  public ArrayList<byte[]> BPI;
  
  static
  {
    AppMethodBeat.i(75437);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(75437);
  }
  
  public LyricsInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(75436);
    int j = paramParcel.readInt();
    int i = 0;
    while (i < j)
    {
      byte[] arrayOfByte = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(arrayOfByte);
      this.BPI.add(arrayOfByte);
      i += 1;
    }
    AppMethodBeat.o(75436);
  }
  
  public LyricsInfo(List<? extends ckm> paramList)
  {
    AppMethodBeat.i(75434);
    this.BPI = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      ckm localckm = (ckm)paramList.next();
      this.BPI.add(localckm.toByteArray());
    }
    AppMethodBeat.o(75434);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(75433);
    p.h(paramParcel, "parcel");
    paramParcel.writeInt(this.BPI.size());
    Iterator localIterator = ((Iterable)this.BPI).iterator();
    while (localIterator.hasNext())
    {
      byte[] arrayOfByte = (byte[])localIterator.next();
      paramParcel.writeInt(arrayOfByte.length);
      paramParcel.writeByteArray(arrayOfByte);
    }
    AppMethodBeat.o(75433);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/audio/LyricsInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/LyricsInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/recordvideo/model/audio/LyricsInfo;", "plugin-recordvideo_release"})
  public static final class a
    implements Parcelable.Creator<LyricsInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.LyricsInfo
 * JD-Core Version:    0.7.0.1
 */