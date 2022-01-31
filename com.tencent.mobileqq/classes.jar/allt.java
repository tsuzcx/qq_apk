import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.widget.ExpandableListConnector.GroupMetadata;

public final class allt
  implements Parcelable.Creator
{
  public ExpandableListConnector.GroupMetadata a(Parcel paramParcel)
  {
    return ExpandableListConnector.GroupMetadata.a(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readLong());
  }
  
  public ExpandableListConnector.GroupMetadata[] a(int paramInt)
  {
    return new ExpandableListConnector.GroupMetadata[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     allt
 * JD-Core Version:    0.7.0.1
 */