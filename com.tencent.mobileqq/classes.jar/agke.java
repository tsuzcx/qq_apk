import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;

public final class agke
  implements Parcelable.Creator<AIORichMediaData>
{
  public AIORichMediaData a(Parcel paramParcel)
  {
    Object localObject = paramParcel.readString();
    try
    {
      localObject = AIORichMediaData.a((String)localObject);
      ((AIORichMediaData)localObject).a(paramParcel);
      return localObject;
    }
    catch (ClassNotFoundException paramParcel)
    {
      throw new RuntimeException(paramParcel);
    }
  }
  
  public AIORichMediaData[] a(int paramInt)
  {
    return new AIORichMediaData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agke
 * JD-Core Version:    0.7.0.1
 */