import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.ForwardUtils.SectionBase;

public final class acwi
  implements Parcelable.Creator<ForwardUtils.SectionBase>
{
  public ForwardUtils.SectionBase a(Parcel paramParcel)
  {
    return new ForwardUtils.SectionBase(paramParcel);
  }
  
  public ForwardUtils.SectionBase[] a(int paramInt)
  {
    return new ForwardUtils.SectionBase[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwi
 * JD-Core Version:    0.7.0.1
 */