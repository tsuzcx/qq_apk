import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

public abstract class aejh
  extends Binder
  implements aejg
{
  public aejh()
  {
    attachInterface(this, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
  }
  
  public static aejg a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
    if ((localIInterface != null) && ((localIInterface instanceof aejg))) {
      return (aejg)localIInterface;
    }
    return new aeji(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      l1 = paramParcel1.readLong();
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      i = paramParcel1.readInt();
      paramParcel2 = paramParcel1.readString();
      if (paramParcel1.readByte() != 0) {}
      for (bool = true;; bool = false)
      {
        a(l1, paramInt1, paramInt2, i, paramParcel2, bool);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      a((AIORichMediaData[])paramParcel1.createTypedArray(AIORichMediaData.CREATOR), paramParcel1.readInt());
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      l1 = paramParcel1.readLong();
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      i = paramParcel1.readInt();
      long l2 = paramParcel1.readLong();
      if (paramParcel1.readByte() == 1) {}
      for (bool = true;; bool = false)
      {
        a(l1, paramInt1, paramInt2, i, l2, bool);
        return true;
      }
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      a();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      b();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      c();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IAIOImageProviderCallBack", 2, "carverW onTransact -> case TRANSACTION_notifyVideoURL");
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
    long l1 = paramParcel1.readLong();
    paramInt2 = paramParcel1.readInt();
    int i = paramParcel1.readInt();
    paramParcel2 = paramParcel1.readString();
    int j = paramParcel1.readInt();
    String[] arrayOfString = new String[j];
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      arrayOfString[paramInt1] = paramParcel1.readString();
      paramInt1 += 1;
    }
    a(l1, paramInt2, i, paramParcel2, arrayOfString, paramParcel1.readString(), (MessageForShortVideo)paramParcel1.readParcelable(MessageForShortVideo.class.getClassLoader()), paramParcel1.readInt());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aejh
 * JD-Core Version:    0.7.0.1
 */