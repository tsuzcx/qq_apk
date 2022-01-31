import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;

public final class agtf
  implements Parcelable.Creator
{
  public PersonalityLabelPhoto a(Parcel paramParcel)
  {
    return new PersonalityLabelPhoto(paramParcel);
  }
  
  public PersonalityLabelPhoto[] a(int paramInt)
  {
    return new PersonalityLabelPhoto[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agtf
 * JD-Core Version:    0.7.0.1
 */