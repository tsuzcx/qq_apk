package com.tencent.mm.sdk.trafficcard;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public abstract interface ITencentSmartcardOpenService
  extends IInterface
{
  public abstract String checkIssueConditions(Map paramMap);
  
  public abstract String checkServiceStatus(Map paramMap);
  
  public abstract String deleteCard(Map paramMap);
  
  public abstract String doAction(String paramString, Map paramMap);
  
  public abstract String issueCard(Map paramMap);
  
  public abstract String preIssueCard(Map paramMap);
  
  public abstract String queryCplc();
  
  public abstract String queryTrafficCardInfo(String paramString, int paramInt);
  
  public abstract String recharge(Map paramMap);
  
  public abstract String startSetDefault(Map paramMap);
  
  public static class Default
    implements ITencentSmartcardOpenService
  {
    public IBinder asBinder()
    {
      return null;
    }
    
    public String checkIssueConditions(Map paramMap)
    {
      return null;
    }
    
    public String checkServiceStatus(Map paramMap)
    {
      return null;
    }
    
    public String deleteCard(Map paramMap)
    {
      return null;
    }
    
    public String doAction(String paramString, Map paramMap)
    {
      return null;
    }
    
    public String issueCard(Map paramMap)
    {
      return null;
    }
    
    public String preIssueCard(Map paramMap)
    {
      return null;
    }
    
    public String queryCplc()
    {
      return null;
    }
    
    public String queryTrafficCardInfo(String paramString, int paramInt)
    {
      return null;
    }
    
    public String recharge(Map paramMap)
    {
      return null;
    }
    
    public String startSetDefault(Map paramMap)
    {
      return null;
    }
  }
  
  public static abstract class Stub
    extends Binder
    implements ITencentSmartcardOpenService
  {
    private static final String DESCRIPTOR = "com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService";
    static final int TRANSACTION_checkIssueConditions = 9;
    static final int TRANSACTION_checkServiceStatus = 7;
    static final int TRANSACTION_deleteCard = 6;
    static final int TRANSACTION_doAction = 10;
    static final int TRANSACTION_issueCard = 3;
    static final int TRANSACTION_preIssueCard = 2;
    static final int TRANSACTION_queryCplc = 1;
    static final int TRANSACTION_queryTrafficCardInfo = 5;
    static final int TRANSACTION_recharge = 4;
    static final int TRANSACTION_startSetDefault = 8;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
    }
    
    public static ITencentSmartcardOpenService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
      if ((localIInterface != null) && ((localIInterface instanceof ITencentSmartcardOpenService))) {
        return (ITencentSmartcardOpenService)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public static ITencentSmartcardOpenService getDefaultImpl()
    {
      return Proxy.sDefaultImpl;
    }
    
    public static boolean setDefaultImpl(ITencentSmartcardOpenService paramITencentSmartcardOpenService)
    {
      if ((Proxy.sDefaultImpl == null) && (paramITencentSmartcardOpenService != null))
      {
        Proxy.sDefaultImpl = paramITencentSmartcardOpenService;
        return true;
      }
      return false;
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
        paramParcel2.writeString("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
        paramParcel1 = queryCplc();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
        paramParcel1 = preIssueCard(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
        paramParcel1 = issueCard(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
        paramParcel1 = recharge(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
        paramParcel1 = queryTrafficCardInfo(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
        paramParcel1 = deleteCard(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
        paramParcel1 = checkServiceStatus(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
        paramParcel1 = startSetDefault(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
        paramParcel1 = checkIssueConditions(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
      paramParcel1 = doAction(paramParcel1.readString(), paramParcel1.readHashMap(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    }
    
    static class Proxy
      implements ITencentSmartcardOpenService
    {
      public static ITencentSmartcardOpenService sDefaultImpl;
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public String checkIssueConditions(Map paramMap)
      {
        AppMethodBeat.i(278006);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (ITencentSmartcardOpenService.Stub.getDefaultImpl() != null))
          {
            paramMap = ITencentSmartcardOpenService.Stub.getDefaultImpl().checkIssueConditions(paramMap);
            return paramMap;
          }
          localParcel2.readException();
          paramMap = localParcel2.readString();
          return paramMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(278006);
        }
      }
      
      public String checkServiceStatus(Map paramMap)
      {
        AppMethodBeat.i(278004);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (ITencentSmartcardOpenService.Stub.getDefaultImpl() != null))
          {
            paramMap = ITencentSmartcardOpenService.Stub.getDefaultImpl().checkServiceStatus(paramMap);
            return paramMap;
          }
          localParcel2.readException();
          paramMap = localParcel2.readString();
          return paramMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(278004);
        }
      }
      
      public String deleteCard(Map paramMap)
      {
        AppMethodBeat.i(278003);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (ITencentSmartcardOpenService.Stub.getDefaultImpl() != null))
          {
            paramMap = ITencentSmartcardOpenService.Stub.getDefaultImpl().deleteCard(paramMap);
            return paramMap;
          }
          localParcel2.readException();
          paramMap = localParcel2.readString();
          return paramMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(278003);
        }
      }
      
      public String doAction(String paramString, Map paramMap)
      {
        AppMethodBeat.i(278007);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
          localParcel1.writeString(paramString);
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(10, localParcel1, localParcel2, 0)) && (ITencentSmartcardOpenService.Stub.getDefaultImpl() != null))
          {
            paramString = ITencentSmartcardOpenService.Stub.getDefaultImpl().doAction(paramString, paramMap);
            return paramString;
          }
          localParcel2.readException();
          paramString = localParcel2.readString();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(278007);
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService";
      }
      
      public String issueCard(Map paramMap)
      {
        AppMethodBeat.i(278000);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (ITencentSmartcardOpenService.Stub.getDefaultImpl() != null))
          {
            paramMap = ITencentSmartcardOpenService.Stub.getDefaultImpl().issueCard(paramMap);
            return paramMap;
          }
          localParcel2.readException();
          paramMap = localParcel2.readString();
          return paramMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(278000);
        }
      }
      
      public String preIssueCard(Map paramMap)
      {
        AppMethodBeat.i(277998);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (ITencentSmartcardOpenService.Stub.getDefaultImpl() != null))
          {
            paramMap = ITencentSmartcardOpenService.Stub.getDefaultImpl().preIssueCard(paramMap);
            return paramMap;
          }
          localParcel2.readException();
          paramMap = localParcel2.readString();
          return paramMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(277998);
        }
      }
      
      public String queryCplc()
      {
        AppMethodBeat.i(277997);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (ITencentSmartcardOpenService.Stub.getDefaultImpl() != null))
          {
            str = ITencentSmartcardOpenService.Stub.getDefaultImpl().queryCplc();
            return str;
          }
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(277997);
        }
      }
      
      public String queryTrafficCardInfo(String paramString, int paramInt)
      {
        AppMethodBeat.i(278002);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (ITencentSmartcardOpenService.Stub.getDefaultImpl() != null))
          {
            paramString = ITencentSmartcardOpenService.Stub.getDefaultImpl().queryTrafficCardInfo(paramString, paramInt);
            return paramString;
          }
          localParcel2.readException();
          paramString = localParcel2.readString();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(278002);
        }
      }
      
      public String recharge(Map paramMap)
      {
        AppMethodBeat.i(278001);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (ITencentSmartcardOpenService.Stub.getDefaultImpl() != null))
          {
            paramMap = ITencentSmartcardOpenService.Stub.getDefaultImpl().recharge(paramMap);
            return paramMap;
          }
          localParcel2.readException();
          paramMap = localParcel2.readString();
          return paramMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(278001);
        }
      }
      
      public String startSetDefault(Map paramMap)
      {
        AppMethodBeat.i(278005);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (ITencentSmartcardOpenService.Stub.getDefaultImpl() != null))
          {
            paramMap = ITencentSmartcardOpenService.Stub.getDefaultImpl().startSetDefault(paramMap);
            return paramMap;
          }
          localParcel2.readException();
          paramMap = localParcel2.readString();
          return paramMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(278005);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService
 * JD-Core Version:    0.7.0.1
 */