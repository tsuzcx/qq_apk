import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;

public final class agtt
  implements Parcelable.Creator
{
  public SegmentKeeper a(Parcel paramParcel)
  {
    return new SegmentKeeper(paramParcel);
  }
  
  public SegmentKeeper[] a(int paramInt)
  {
    return new SegmentKeeper[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agtt
 * JD-Core Version:    0.7.0.1
 */