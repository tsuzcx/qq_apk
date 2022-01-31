import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qidian.QidianProfileCardActivity.QidianCompoundProfileItem;

public final class akxo
  implements Parcelable.Creator
{
  public QidianProfileCardActivity.QidianCompoundProfileItem a(Parcel paramParcel)
  {
    boolean bool2 = true;
    QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
    localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localQidianCompoundProfileItem.c = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      localQidianCompoundProfileItem.jdField_a_of_type_Boolean = bool1;
      localQidianCompoundProfileItem.jdField_a_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localQidianCompoundProfileItem.jdField_b_of_type_Boolean = bool1;
      localQidianCompoundProfileItem.d = paramParcel.readString();
      localQidianCompoundProfileItem.e = paramParcel.readString();
      return localQidianCompoundProfileItem;
      bool1 = false;
      break;
    }
  }
  
  public QidianProfileCardActivity.QidianCompoundProfileItem[] a(int paramInt)
  {
    return new QidianProfileCardActivity.QidianCompoundProfileItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akxo
 * JD-Core Version:    0.7.0.1
 */