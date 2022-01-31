import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;

public final class albh
  implements Parcelable.Creator<SpriteTaskParam>
{
  public SpriteTaskParam a(Parcel paramParcel)
  {
    return new SpriteTaskParam(paramParcel);
  }
  
  public SpriteTaskParam[] a(int paramInt)
  {
    return new SpriteTaskParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albh
 * JD-Core Version:    0.7.0.1
 */