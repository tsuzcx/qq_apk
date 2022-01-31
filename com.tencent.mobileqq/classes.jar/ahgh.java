import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;

public final class ahgh
  implements Parcelable.Creator
{
  public RevokeMsgInfo a(Parcel paramParcel)
  {
    RevokeMsgInfo localRevokeMsgInfo = new RevokeMsgInfo();
    localRevokeMsgInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localRevokeMsgInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localRevokeMsgInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localRevokeMsgInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localRevokeMsgInfo.b = paramParcel.readLong();
    localRevokeMsgInfo.jdField_c_of_type_Long = paramParcel.readLong();
    localRevokeMsgInfo.d = paramParcel.readString();
    localRevokeMsgInfo.e = paramParcel.readInt();
    return localRevokeMsgInfo;
  }
  
  public RevokeMsgInfo[] a(int paramInt)
  {
    return new RevokeMsgInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgh
 * JD-Core Version:    0.7.0.1
 */