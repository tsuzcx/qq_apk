import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qidian.QidianProfileCardActivity.QidianSimpleProfileItem;

public final class alnf
  implements Parcelable.Creator
{
  public QidianProfileCardActivity.QidianSimpleProfileItem a(Parcel paramParcel)
  {
    boolean bool2 = true;
    QidianProfileCardActivity.QidianSimpleProfileItem localQidianSimpleProfileItem = new QidianProfileCardActivity.QidianSimpleProfileItem();
    localQidianSimpleProfileItem.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localQidianSimpleProfileItem.jdField_b_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      localQidianSimpleProfileItem.jdField_a_of_type_Boolean = bool1;
      localQidianSimpleProfileItem.jdField_a_of_type_Int = paramParcel.readInt();
      localQidianSimpleProfileItem.jdField_b_of_type_Int = paramParcel.readInt();
      localQidianSimpleProfileItem.jdField_c_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label109;
      }
      bool1 = true;
      label80:
      localQidianSimpleProfileItem.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label114;
      }
    }
    label109:
    label114:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localQidianSimpleProfileItem.jdField_c_of_type_Boolean = bool1;
      return localQidianSimpleProfileItem;
      bool1 = false;
      break;
      bool1 = false;
      break label80;
    }
  }
  
  public QidianProfileCardActivity.QidianSimpleProfileItem[] a(int paramInt)
  {
    return new QidianProfileCardActivity.QidianSimpleProfileItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alnf
 * JD-Core Version:    0.7.0.1
 */