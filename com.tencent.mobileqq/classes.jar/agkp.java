import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mobileqq.pic.CompressInfo;

public abstract class agkp
  extends Binder
  implements agko
{
  public agkp()
  {
    attachInterface(this, "com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
  }
  
  public static agko a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
    if ((localIInterface != null) && ((localIInterface instanceof agko))) {
      return (agko)localIInterface;
    }
    return new agkq(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      a((CompressInfo)paramParcel1.readParcelable(CompressInfo.class.getClassLoader()));
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      b((CompressInfo)paramParcel1.readParcelable(CompressInfo.class.getClassLoader()));
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
    c((CompressInfo)paramParcel1.readParcelable(CompressInfo.class.getClassLoader()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkp
 * JD-Core Version:    0.7.0.1
 */