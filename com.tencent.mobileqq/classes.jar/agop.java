import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;

public final class agop
  implements Parcelable.Creator
{
  public PersonalityLabelInfo a(Parcel paramParcel)
  {
    return new PersonalityLabelInfo(paramParcel);
  }
  
  public PersonalityLabelInfo[] a(int paramInt)
  {
    return new PersonalityLabelInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agop
 * JD-Core Version:    0.7.0.1
 */