package com.tencent.mm.plugin.recordvideo.model.audio;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dki;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/LyricsInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "lyricDatas", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "(Ljava/util/List;)V", "lyrics", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLyrics", "()Ljava/util/ArrayList;", "setLyrics", "(Ljava/util/ArrayList;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LyricsInfo
  implements Parcelable
{
  public static final a CREATOR;
  public ArrayList<byte[]> NJq;
  
  static
  {
    AppMethodBeat.i(75437);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(75437);
  }
  
  private LyricsInfo(byte paramByte)
  {
    this();
  }
  
  public LyricsInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(75436);
    int k = paramParcel.readInt();
    int i = 0;
    if (k > 0)
    {
      int j;
      do
      {
        j = i + 1;
        byte[] arrayOfByte = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(arrayOfByte);
        this.NJq.add(arrayOfByte);
        i = j;
      } while (j < k);
    }
    AppMethodBeat.o(75436);
  }
  
  public LyricsInfo(List<? extends dki> paramList)
  {
    AppMethodBeat.i(75434);
    this.NJq = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      dki localdki = (dki)paramList.next();
      this.NJq.add(localdki.toByteArray());
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
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(this.NJq.size());
    Iterator localIterator = ((Iterable)this.NJq).iterator();
    while (localIterator.hasNext())
    {
      byte[] arrayOfByte = (byte[])localIterator.next();
      paramParcel.writeInt(arrayOfByte.length);
      paramParcel.writeByteArray(arrayOfByte);
    }
    AppMethodBeat.o(75433);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/LyricsInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/LyricsInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/recordvideo/model/audio/LyricsInfo;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<LyricsInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.LyricsInfo
 * JD-Core Version:    0.7.0.1
 */