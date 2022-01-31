import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;

public final class ahyg
  implements Parcelable.Creator
{
  public TeamWorkFileImportInfo a(Parcel paramParcel)
  {
    return new TeamWorkFileImportInfo(paramParcel);
  }
  
  public TeamWorkFileImportInfo[] a(int paramInt)
  {
    return new TeamWorkFileImportInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahyg
 * JD-Core Version:    0.7.0.1
 */