import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.qcall.PstnCardInfo;

public final class agfz
  implements Parcelable.Creator
{
  public PstnCardInfo a(Parcel paramParcel)
  {
    return new PstnCardInfo(paramParcel);
  }
  
  public PstnCardInfo[] a(int paramInt)
  {
    return new PstnCardInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agfz
 * JD-Core Version:    0.7.0.1
 */