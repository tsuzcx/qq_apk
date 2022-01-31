import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberInfo;

public final class agrc
  implements Parcelable.Creator
{
  public ReceiptMessageReadMemberListFragment.MemberInfo a(Parcel paramParcel)
  {
    return new ReceiptMessageReadMemberListFragment.MemberInfo(paramParcel);
  }
  
  public ReceiptMessageReadMemberListFragment.MemberInfo[] a(int paramInt)
  {
    return new ReceiptMessageReadMemberListFragment.MemberInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agrc
 * JD-Core Version:    0.7.0.1
 */