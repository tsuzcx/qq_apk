import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class agkn
  implements agkl
{
  private IBinder a;
  
  agkn(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_1
    //   4: aload_1
    //   5: ldc 26
    //   7: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield 15	agkn:a	Landroid/os/IBinder;
    //   14: iconst_4
    //   15: aload_1
    //   16: aconst_null
    //   17: iconst_1
    //   18: invokeinterface 36 5 0
    //   23: pop
    //   24: aload_1
    //   25: invokevirtual 39	android/os/Parcel:recycle	()V
    //   28: return
    //   29: astore_2
    //   30: aload_1
    //   31: invokevirtual 39	android/os/Parcel:recycle	()V
    //   34: return
    //   35: astore_2
    //   36: aload_1
    //   37: invokevirtual 39	android/os/Parcel:recycle	()V
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	agkn
    //   3	34	1	localParcel	Parcel
    //   29	1	2	localRemoteException	RemoteException
    //   35	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	24	29	android/os/RemoteException
    //   4	24	35	finally
  }
  
  /* Error */
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 9
    //   3: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 10
    //   8: aload 10
    //   10: ldc 26
    //   12: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload 10
    //   17: lload_1
    //   18: invokevirtual 44	android/os/Parcel:writeLong	(J)V
    //   21: aload 10
    //   23: iload_3
    //   24: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   27: aload 10
    //   29: iload 4
    //   31: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   34: aload 10
    //   36: iload 5
    //   38: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   41: aload 10
    //   43: lload 6
    //   45: invokevirtual 44	android/os/Parcel:writeLong	(J)V
    //   48: iload 8
    //   50: ifeq +34 -> 84
    //   53: iload 9
    //   55: istore_3
    //   56: aload 10
    //   58: iload_3
    //   59: i2b
    //   60: invokevirtual 52	android/os/Parcel:writeByte	(B)V
    //   63: aload_0
    //   64: getfield 15	agkn:a	Landroid/os/IBinder;
    //   67: iconst_3
    //   68: aload 10
    //   70: aconst_null
    //   71: iconst_1
    //   72: invokeinterface 36 5 0
    //   77: pop
    //   78: aload 10
    //   80: invokevirtual 39	android/os/Parcel:recycle	()V
    //   83: return
    //   84: iconst_0
    //   85: istore_3
    //   86: goto -30 -> 56
    //   89: astore 11
    //   91: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +16 -> 110
    //   97: ldc 60
    //   99: iconst_2
    //   100: aload 11
    //   102: invokevirtual 64	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   105: aload 11
    //   107: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   110: aload 10
    //   112: invokevirtual 39	android/os/Parcel:recycle	()V
    //   115: return
    //   116: astore 11
    //   118: aload 10
    //   120: invokevirtual 39	android/os/Parcel:recycle	()V
    //   123: aload 11
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	agkn
    //   0	126	1	paramLong1	long
    //   0	126	3	paramInt1	int
    //   0	126	4	paramInt2	int
    //   0	126	5	paramInt3	int
    //   0	126	6	paramLong2	long
    //   0	126	8	paramBoolean	boolean
    //   1	53	9	i	int
    //   6	113	10	localParcel	Parcel
    //   89	17	11	localRemoteException	RemoteException
    //   116	8	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	48	89	android/os/RemoteException
    //   56	78	89	android/os/RemoteException
    //   8	48	116	finally
    //   56	78	116	finally
    //   91	110	116	finally
  }
  
  /* Error */
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 9
    //   8: aload 9
    //   10: ldc 26
    //   12: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload 9
    //   17: lload_1
    //   18: invokevirtual 44	android/os/Parcel:writeLong	(J)V
    //   21: aload 9
    //   23: iload_3
    //   24: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   27: aload 9
    //   29: iload 4
    //   31: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   34: aload 9
    //   36: iload 5
    //   38: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   41: aload 9
    //   43: aload 6
    //   45: invokevirtual 72	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   48: iload 7
    //   50: ifeq +34 -> 84
    //   53: iload 8
    //   55: istore_3
    //   56: aload 9
    //   58: iload_3
    //   59: i2b
    //   60: invokevirtual 52	android/os/Parcel:writeByte	(B)V
    //   63: aload_0
    //   64: getfield 15	agkn:a	Landroid/os/IBinder;
    //   67: iconst_1
    //   68: aload 9
    //   70: aconst_null
    //   71: iconst_1
    //   72: invokeinterface 36 5 0
    //   77: pop
    //   78: aload 9
    //   80: invokevirtual 39	android/os/Parcel:recycle	()V
    //   83: return
    //   84: iconst_0
    //   85: istore_3
    //   86: goto -30 -> 56
    //   89: astore 6
    //   91: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +16 -> 110
    //   97: ldc 60
    //   99: iconst_2
    //   100: aload 6
    //   102: invokevirtual 64	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   105: aload 6
    //   107: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   110: aload 9
    //   112: invokevirtual 39	android/os/Parcel:recycle	()V
    //   115: return
    //   116: astore 6
    //   118: aload 9
    //   120: invokevirtual 39	android/os/Parcel:recycle	()V
    //   123: aload 6
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	agkn
    //   0	126	1	paramLong	long
    //   0	126	3	paramInt1	int
    //   0	126	4	paramInt2	int
    //   0	126	5	paramInt3	int
    //   0	126	6	paramString	String
    //   0	126	7	paramBoolean	boolean
    //   1	53	8	i	int
    //   6	113	9	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	48	89	android/os/RemoteException
    //   56	78	89	android/os/RemoteException
    //   8	48	116	finally
    //   56	78	116	finally
    //   91	110	116	finally
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("IAIOImageProviderCallBack", 2, "carverW notifyVideoUrl");
    }
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      localParcel.writeLong(paramLong);
      localParcel.writeInt(paramInt1);
      localParcel.writeInt(paramInt2);
      localParcel.writeString(paramString1);
      if (paramArrayOfString != null)
      {
        paramInt2 = paramArrayOfString.length;
        localParcel.writeInt(paramInt2);
        paramInt1 = i;
        while (paramInt1 < paramInt2)
        {
          localParcel.writeString(paramArrayOfString[paramInt1]);
          paramInt1 += 1;
        }
      }
      localParcel.writeInt(-1);
      localParcel.writeString(paramString2);
      localParcel.writeParcelable(paramMessageForShortVideo, 0);
      localParcel.writeInt(paramInt3);
      this.a.transact(7, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProviderCallBack", 2, paramString1.getMessage(), paramString1);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      localParcel.writeTypedArray(paramArrayOfAIORichMediaData, 0);
      localParcel.writeInt(paramInt);
      this.a.transact(2, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramArrayOfAIORichMediaData)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProviderCallBack", 2, paramArrayOfAIORichMediaData.getMessage(), paramArrayOfAIORichMediaData);
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
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_1
    //   4: aload_1
    //   5: ldc 26
    //   7: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield 15	agkn:a	Landroid/os/IBinder;
    //   14: iconst_5
    //   15: aload_1
    //   16: aconst_null
    //   17: iconst_1
    //   18: invokeinterface 36 5 0
    //   23: pop
    //   24: aload_1
    //   25: invokevirtual 39	android/os/Parcel:recycle	()V
    //   28: return
    //   29: astore_2
    //   30: aload_1
    //   31: invokevirtual 39	android/os/Parcel:recycle	()V
    //   34: return
    //   35: astore_2
    //   36: aload_1
    //   37: invokevirtual 39	android/os/Parcel:recycle	()V
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	agkn
    //   3	34	1	localParcel	Parcel
    //   29	1	2	localRemoteException	RemoteException
    //   35	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	24	29	android/os/RemoteException
    //   4	24	35	finally
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_1
    //   4: aload_1
    //   5: ldc 26
    //   7: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield 15	agkn:a	Landroid/os/IBinder;
    //   14: bipush 6
    //   16: aload_1
    //   17: aconst_null
    //   18: iconst_1
    //   19: invokeinterface 36 5 0
    //   24: pop
    //   25: aload_1
    //   26: invokevirtual 39	android/os/Parcel:recycle	()V
    //   29: return
    //   30: astore_2
    //   31: aload_1
    //   32: invokevirtual 39	android/os/Parcel:recycle	()V
    //   35: return
    //   36: astore_2
    //   37: aload_1
    //   38: invokevirtual 39	android/os/Parcel:recycle	()V
    //   41: aload_2
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	agkn
    //   3	35	1	localParcel	Parcel
    //   30	1	2	localRemoteException	RemoteException
    //   36	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	25	30	android/os/RemoteException
    //   4	25	36	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkn
 * JD-Core Version:    0.7.0.1
 */