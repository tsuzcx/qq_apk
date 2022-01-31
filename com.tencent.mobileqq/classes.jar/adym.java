import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;

class adym
  implements adyk
{
  private IBinder a;
  
  adym(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      localParcel.writeParcelable(paramCompressInfo, 1);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramCompressInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ICompressionCallBack", 2, paramCompressInfo.getMessage(), paramCompressInfo);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b(CompressInfo paramCompressInfo)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      localParcel.writeParcelable(paramCompressInfo, 1);
      this.a.transact(2, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramCompressInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ICompressionCallBack", 2, paramCompressInfo.getMessage(), paramCompressInfo);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void c(CompressInfo paramCompressInfo)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      localParcel.writeParcelable(paramCompressInfo, 1);
      this.a.transact(3, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramCompressInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ICompressionCallBack", 2, paramCompressInfo.getMessage(), paramCompressInfo);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adym
 * JD-Core Version:    0.7.0.1
 */