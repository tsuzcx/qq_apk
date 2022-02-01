import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.photo.ImageInfo;

public final class ajod
  implements Parcelable.Creator<ImageInfo>
{
  public ImageInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    ImageInfo localImageInfo = new ImageInfo();
    if (paramParcel.readInt() == 0)
    {
      bool1 = false;
      localImageInfo.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 0) {
        break label412;
      }
      bool1 = false;
      label35:
      localImageInfo.jdField_b_of_type_Boolean = bool1;
      localImageInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() != 0) {
        break label417;
      }
      bool1 = false;
      label59:
      localImageInfo.jdField_c_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 0) {
        break label422;
      }
      bool1 = false;
      label74:
      localImageInfo.jdField_d_of_type_Boolean = bool1;
      localImageInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_a_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {
        break label427;
      }
      bool1 = false;
      label116:
      localImageInfo.jdField_e_of_type_Boolean = bool1;
      localImageInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_b_of_type_Int = paramParcel.readInt();
      localImageInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_c_of_type_Int = paramParcel.readInt();
      localImageInfo.jdField_d_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {
        break label432;
      }
      bool1 = false;
      label176:
      localImageInfo.jdField_f_of_type_Boolean = bool1;
      localImageInfo.jdField_a_of_type_Long = paramParcel.readLong();
      if (paramParcel.readInt() != 0) {
        break label437;
      }
      bool1 = false;
      label200:
      localImageInfo.jdField_h_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 0) {
        break label442;
      }
      bool1 = false;
      label215:
      localImageInfo.jdField_i_of_type_Boolean = bool1;
      localImageInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_b_of_type_Long = paramParcel.readLong();
      localImageInfo.g = paramParcel.readString();
      localImageInfo.jdField_c_of_type_Long = paramParcel.readLong();
      localImageInfo.jdField_h_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_f_of_type_Int = paramParcel.readInt();
      localImageInfo.jdField_f_of_type_Int = paramParcel.readInt();
      localImageInfo.jdField_h_of_type_Int = paramParcel.readInt();
      localImageInfo.jdField_i_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_k_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label447;
      }
      bool1 = true;
      label321:
      localImageInfo.o = bool1;
      if (paramParcel.readInt() != 1) {
        break label452;
      }
      bool1 = true;
      label337:
      localImageInfo.n = bool1;
      if (paramParcel.readInt() != 1) {
        break label457;
      }
    }
    label412:
    label417:
    label422:
    label427:
    label432:
    label437:
    label442:
    label447:
    label452:
    label457:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localImageInfo.p = bool1;
      localImageInfo.jdField_d_of_type_Long = paramParcel.readLong();
      localImageInfo.j = paramParcel.readString();
      localImageInfo.jdField_k_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_l_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_l_of_type_Int = paramParcel.readInt();
      return localImageInfo;
      bool1 = true;
      break;
      bool1 = true;
      break label35;
      bool1 = true;
      break label59;
      bool1 = true;
      break label74;
      bool1 = true;
      break label116;
      bool1 = true;
      break label176;
      bool1 = true;
      break label200;
      bool1 = true;
      break label215;
      bool1 = false;
      break label321;
      bool1 = false;
      break label337;
    }
  }
  
  public ImageInfo[] a(int paramInt)
  {
    return new ImageInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajod
 * JD-Core Version:    0.7.0.1
 */