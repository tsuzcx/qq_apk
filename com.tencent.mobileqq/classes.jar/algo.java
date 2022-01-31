import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.downloadnew.DownloadInfo;

public final class algo
  implements Parcelable.Creator
{
  public DownloadInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localDownloadInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localDownloadInfo.e = paramParcel.readString();
    localDownloadInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
    localDownloadInfo.jdField_a_of_type_Long = paramParcel.readInt();
    localDownloadInfo.jdField_g_of_type_JavaLangString = paramParcel.readString();
    localDownloadInfo.h = paramParcel.readString();
    localDownloadInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localDownloadInfo.jdField_k_of_type_JavaLangString = paramParcel.readString();
    localDownloadInfo.jdField_f_of_type_Int = paramParcel.readInt();
    localDownloadInfo.jdField_g_of_type_Int = paramParcel.readInt();
    localDownloadInfo.jdField_b_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      localDownloadInfo.jdField_c_of_type_Boolean = bool1;
      localDownloadInfo.l = paramParcel.readString();
      localDownloadInfo.j = paramParcel.readInt();
      localDownloadInfo.jdField_k_of_type_Int = paramParcel.readInt();
      localDownloadInfo.m = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label221;
      }
    }
    label221:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localDownloadInfo.jdField_d_of_type_Boolean = bool1;
      localDownloadInfo.n = paramParcel.readString();
      localDownloadInfo.jdField_d_of_type_Long = paramParcel.readLong();
      return localDownloadInfo;
      bool1 = false;
      break;
    }
  }
  
  public DownloadInfo[] a(int paramInt)
  {
    return new DownloadInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     algo
 * JD-Core Version:    0.7.0.1
 */