import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.ShieldOperationItem;

public final class akgi
  implements Parcelable.Creator<ShieldOperationItem>
{
  public ShieldOperationItem a(Parcel paramParcel)
  {
    ShieldOperationItem localShieldOperationItem = new ShieldOperationItem();
    localShieldOperationItem.jdField_a_of_type_Int = paramParcel.readInt();
    localShieldOperationItem.b = paramParcel.readInt();
    localShieldOperationItem.c = paramParcel.readInt();
    localShieldOperationItem.jdField_a_of_type_ArrayOfLong = paramParcel.createLongArray();
    localShieldOperationItem.d = paramParcel.readInt();
    return localShieldOperationItem;
  }
  
  public ShieldOperationItem[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akgi
 * JD-Core Version:    0.7.0.1
 */