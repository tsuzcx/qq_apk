import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

public abstract class aejc
  extends Binder
  implements aejb, IBinder.DeathRecipient
{
  public aeje a;
  
  protected aejc()
  {
    attachInterface(this, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
  }
  
  public static aejb a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    if ((localIInterface != null) && ((localIInterface instanceof aejb))) {
      return (aejb)localIInterface;
    }
    return new aejd(paramIBinder);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "binder destoryed");
    }
    this.a = null;
  }
  
  public void a(aeje paramaeje)
  {
    try
    {
      paramaeje.asBinder().linkToDeath(this, 0);
      this.a = paramaeje;
      return;
    }
    catch (RemoteException paramaeje)
    {
      binderDied();
    }
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public void binderDied()
  {
    a();
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = false;
    switch (paramInt1)
    {
    default: 
    case 1598968902: 
    case 1: 
    case 2: 
    case 3: 
    case 17: 
    case 18: 
    case 4: 
    case 5: 
      try
      {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      catch (RuntimeException paramParcel1)
      {
        paramParcel1.printStackTrace();
        throw paramParcel1;
      }
      paramParcel2.writeString("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      return true;
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      a(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      b(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      a(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      a((MessageForShortVideo)paramParcel1.readParcelable(MessageForShortVideo.class.getClassLoader()));
      paramParcel2.writeNoException();
      return true;
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      a(aejf.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      paramParcel1 = a(paramParcel1.readLong(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      else
      {
        paramParcel2.writeInt(0);
      }
      break;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      a();
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      a(paramParcel1.readLong(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      a(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      paramParcel1 = a(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      else
      {
        paramParcel2.writeInt(0);
      }
      break;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      b(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      c(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      localObject = new long[paramParcel1.readInt()];
      paramParcel1.readLongArray((long[])localObject);
      a((long[])localObject);
      paramParcel2.writeNoException();
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      d(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      e(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      paramParcel1 = a(paramParcel1.readLong());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      else
      {
        paramParcel2.writeInt(0);
      }
      break;
    case 15: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      c();
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      a(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readBundle());
      paramParcel2.writeNoException();
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      paramInt1 = a(paramParcel1.readLong(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      b(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      paramParcel1 = a(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    paramInt1 = paramParcel1.readInt();
    paramInt2 = paramParcel1.readInt();
    Object localObject = paramParcel1.readString();
    String str1 = paramParcel1.readString();
    String str2 = paramParcel1.readString();
    paramParcel1 = paramParcel1.readString();
    if (paramInt2 == 1) {
      bool = true;
    }
    a(paramInt1, bool, (String)localObject, str1, str2, paramParcel1);
    paramParcel2.writeNoException();
    return true;
    return true;
    return true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aejc
 * JD-Core Version:    0.7.0.1
 */