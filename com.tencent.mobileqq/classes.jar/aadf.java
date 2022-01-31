import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;

public final class aadf
  implements Parcelable.Creator
{
  public UpgradeTIMWrapper a(Parcel paramParcel)
  {
    Object localObject = null;
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    String str4 = paramParcel.readString();
    String str5 = paramParcel.readString();
    String str6 = paramParcel.readString();
    int j = 0;
    for (;;)
    {
      try
      {
        int i = paramParcel.readInt();
        j = i;
        String str1 = paramParcel.readString();
        paramParcel.printStackTrace();
      }
      catch (Exception paramParcel)
      {
        try
        {
          paramParcel = paramParcel.readString();
          return new UpgradeTIMWrapper(str2, str3, str4, str5, str6, i, str1, paramParcel);
        }
        catch (Exception paramParcel)
        {
          break label81;
        }
        paramParcel = paramParcel;
        str1 = null;
        i = j;
      }
      label81:
      paramParcel = localObject;
    }
  }
  
  public UpgradeTIMWrapper[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aadf
 * JD-Core Version:    0.7.0.1
 */