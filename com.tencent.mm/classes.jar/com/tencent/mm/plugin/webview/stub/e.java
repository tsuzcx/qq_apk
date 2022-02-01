package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

public abstract interface e
  extends IInterface
{
  public abstract boolean IS(String paramString);
  
  public abstract boolean IT(String paramString);
  
  public abstract boolean JE(String paramString);
  
  public abstract boolean N(long paramLong, String paramString);
  
  public abstract void U(int paramInt, String paramString1, String paramString2);
  
  public abstract void a(int paramInt1, Bundle paramBundle, int paramInt2);
  
  public abstract void a(f paramf, int paramInt);
  
  public abstract void a(String paramString, Bundle paramBundle, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, Bundle paramBundle);
  
  public abstract void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2);
  
  public abstract boolean a(String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt);
  
  public abstract boolean a(String paramString, boolean paramBoolean, Bundle paramBundle);
  
  public abstract void aL(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean aUM();
  
  public abstract c aY(Bundle paramBundle);
  
  public abstract boolean aZ(Bundle paramBundle);
  
  public abstract List<String> aZM();
  
  public abstract boolean aZN();
  
  public abstract String aZQ(String paramString);
  
  public abstract String aZR(String paramString);
  
  public abstract void aZS(String paramString);
  
  public abstract String aZT(String paramString);
  
  public abstract boolean aZU(String paramString);
  
  public abstract String aZV(String paramString);
  
  public abstract void aZW(String paramString);
  
  public abstract int aZX(String paramString);
  
  public abstract void aZY(String paramString);
  
  public abstract void aZZ(String paramString);
  
  public abstract String aZj(String paramString);
  
  public abstract void agA(int paramInt);
  
  public abstract Bundle agv(int paramInt);
  
  public abstract boolean agw(int paramInt);
  
  public abstract void agx(int paramInt);
  
  public abstract void agy(int paramInt);
  
  public abstract void agz(int paramInt);
  
  public abstract void an(String paramString1, String paramString2, int paramInt);
  
  public abstract boolean apn();
  
  public abstract void b(Bundle paramBundle, int paramInt);
  
  public abstract String baa(String paramString);
  
  public abstract void bm(Intent paramIntent);
  
  public abstract void bs(int paramInt, boolean paramBoolean);
  
  public abstract void cP(String paramString, boolean paramBoolean);
  
  public abstract String cX(int paramInt, String paramString);
  
  public abstract void favEditTag();
  
  public abstract boolean gdW();
  
  public abstract String[] gdX();
  
  public abstract String gdY();
  
  public abstract String gdZ();
  
  public abstract String gea();
  
  public abstract Map geb();
  
  public abstract int gec();
  
  public abstract int ged();
  
  public abstract void gee();
  
  public abstract void gef();
  
  public abstract boolean geg();
  
  public abstract boolean geh();
  
  public abstract boolean gei();
  
  public abstract List<String> gej();
  
  public abstract boolean gek();
  
  public abstract String[] gel();
  
  public abstract String getDisplayName(String paramString);
  
  public abstract String getLanguage();
  
  public abstract int getPayChannel();
  
  public abstract void gt(String paramString, int paramInt);
  
  public abstract String gu(String paramString, int paramInt);
  
  public abstract void gv(String paramString, int paramInt);
  
  public abstract boolean gw(String paramString);
  
  public abstract boolean isSDCardAvailable();
  
  public abstract Bundle j(int paramInt, Bundle paramBundle);
  
  public abstract int kl(int paramInt1, int paramInt2);
  
  public abstract void km(int paramInt1, int paramInt2);
  
  public abstract void l(String paramString, boolean paramBoolean, int paramInt);
  
  public abstract String md(String paramString1, String paramString2);
  
  public abstract Bundle u(int paramInt, Bundle paramBundle);
  
  public abstract void v(int paramInt, Bundle paramBundle);
  
  public abstract void v(int paramInt, List<String> paramList);
  
  public abstract Bundle w(int paramInt, Bundle paramBundle);
  
  public abstract boolean x(int paramInt, Bundle paramBundle);
  
  public static abstract class a
    extends Binder
    implements e
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
    }
    
    public static e H(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof e))) {
        return (e)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static e gem()
    {
      return a.JdI;
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      int i3 = 0;
      int i4 = 0;
      int i = 0;
      int i5 = 0;
      int i6 = 0;
      int i7 = 0;
      boolean bool1 = false;
      int i8 = 0;
      boolean bool2 = false;
      int i9 = 0;
      int i10 = 0;
      boolean bool3 = false;
      int i11 = 0;
      int i12 = 0;
      int i13 = 0;
      int i14 = 0;
      int j = 0;
      label1658:
      String str1;
      String str2;
      String str3;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = aZU(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (bool1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = getDisplayName(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = IS(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = JE(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = IT(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = aZQ(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = apn();
        paramParcel2.writeNoException();
        paramInt1 = n;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = isSDCardAvailable();
        paramParcel2.writeNoException();
        paramInt1 = i1;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = gdW();
        paramParcel2.writeNoException();
        paramInt1 = i2;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = aUM();
        paramParcel2.writeNoException();
        paramInt1 = i3;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = kl(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        km(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = cX(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          a(paramInt1, (Bundle)localObject1, paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          localObject2 = aY(paramParcel1);
          paramParcel2.writeNoException();
          paramParcel1 = (Parcel)localObject1;
          if (localObject2 != null) {
            paramParcel1 = ((c)localObject2).asBinder();
          }
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
        }
      case 16: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          bool1 = aZ(paramParcel1);
          paramParcel2.writeNoException();
          paramInt1 = i4;
          if (bool1) {
            paramInt1 = 1;
          }
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 17: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = aZX(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        favEditTag();
        paramParcel2.writeNoException();
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          bool1 = x(paramInt1, paramParcel1);
          paramParcel2.writeNoException();
          paramInt1 = i;
          if (bool1) {
            paramInt1 = 1;
          }
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 20: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = N(paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = i5;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        aZY(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = aZN();
        paramParcel2.writeNoException();
        paramInt1 = i6;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = aZM();
        paramParcel2.writeNoException();
        paramParcel2.writeStringList(paramParcel1);
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        v(paramParcel1.readInt(), paramParcel1.createStringArrayList());
        paramParcel2.writeNoException();
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        localObject1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          bool1 = true;
          if (paramParcel1.readInt() == 0) {
            break label1658;
          }
        }
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          bool1 = a((String)localObject1, bool1, paramParcel1);
          paramParcel2.writeNoException();
          paramInt1 = i7;
          if (bool1) {
            paramInt1 = 1;
          }
          paramParcel2.writeInt(paramInt1);
          return true;
          bool1 = false;
          break;
        }
      case 26: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = aZR(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        gt(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        localObject1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        cP((String)localObject1, bool1);
        paramParcel2.writeNoException();
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = gw(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = i8;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          paramParcel1 = w(paramInt1, paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 31: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          paramParcel1 = u(paramInt1, paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 32: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        localObject1 = paramParcel1.readString();
        bool1 = bool2;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        l((String)localObject1, bool1, paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 33: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = agv(paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 34: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = agw(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = i9;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 35: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        agx(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 36: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        str1 = paramParcel1.readString();
        str2 = paramParcel1.readString();
        str3 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label2185;
          }
        }
        for (localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject2 = null)
        {
          bool1 = a(str1, str2, str3, (Bundle)localObject1, (Bundle)localObject2, paramParcel1.readInt());
          paramParcel2.writeNoException();
          paramInt1 = i10;
          if (bool1) {
            paramInt1 = 1;
          }
          paramParcel2.writeInt(paramInt1);
          return true;
          localObject1 = null;
          break;
        }
      case 37: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        an(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 38: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        localObject2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          a((String)localObject2, (Bundle)localObject1, paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
      case 39: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        aZS(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 40: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = aZT(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 41: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        aL(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 42: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        a(f.a.I(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 43: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        agy(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 44: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = gdX();
        paramParcel2.writeNoException();
        paramParcel2.writeStringArray(paramParcel1);
        return true;
      case 45: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = gdY();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 46: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = aZj(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 47: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = gdZ();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 48: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = aZV(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 49: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = geb();
        paramParcel2.writeNoException();
        paramParcel2.writeMap(paramParcel1);
        return true;
      case 50: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = md(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 51: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        aZW(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 52: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = gu(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 53: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = getLanguage();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 54: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = gea();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 55: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = gec();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 56: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = ged();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 57: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        gee();
        paramParcel2.writeNoException();
        return true;
      case 58: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        gef();
        paramParcel2.writeNoException();
        return true;
      case 59: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        agz(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 60: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        agA(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 61: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = paramParcel1.readInt();
        bool1 = bool3;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        bs(paramInt1, bool1);
        paramParcel2.writeNoException();
        return true;
      case 62: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        gv(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 63: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = geg();
        paramParcel2.writeNoException();
        paramInt1 = i11;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 64: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = baa(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 65: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = gei();
        paramParcel2.writeNoException();
        paramInt1 = i12;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 66: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = geh();
        paramParcel2.writeNoException();
        paramInt1 = i13;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 67: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = gek();
        paramParcel2.writeNoException();
        paramInt1 = i14;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 68: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        a(paramParcel1.readString(), paramParcel1.createIntArray(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 69: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        aZZ(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 70: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        str1 = paramParcel1.readString();
        str2 = paramParcel1.readString();
        str3 = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a(str1, str2, str3, paramInt1, paramInt2, (Bundle)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 71: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          paramParcel1 = j(paramInt1, paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 72: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          bm(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 73: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        U(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 74: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = gej();
        paramParcel2.writeNoException();
        paramParcel2.writeStringList(paramParcel1);
        return true;
      case 75: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          b((Bundle)localObject1, paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
      case 76: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = getPayChannel();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 77: 
        label2185:
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = gel();
        paramParcel2.writeNoException();
        paramParcel2.writeStringArray(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        v(paramInt1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    static final class a
      implements e
    {
      public static e JdI;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final boolean IS(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(79431);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().IS(paramString);
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79431);
        }
      }
      
      public final boolean IT(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(79433);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().IT(paramString);
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79433);
        }
      }
      
      public final boolean JE(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(79432);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().JE(paramString);
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79432);
        }
      }
      
      public final boolean N(long paramLong, String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(79448);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeLong(paramLong);
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(20, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().N(paramLong, paramString);
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79448);
        }
      }
      
      public final void U(int paramInt, String paramString1, String paramString2)
      {
        AppMethodBeat.i(79501);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if ((!this.mRemote.transact(73, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().U(paramInt, paramString1, paramString2);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79501);
        }
      }
      
      public final void a(int paramInt1, Bundle paramBundle, int paramInt2)
      {
        AppMethodBeat.i(79442);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt1);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          for (;;)
          {
            localParcel1.writeInt(paramInt2);
            if ((this.mRemote.transact(14, localParcel1, localParcel2, 0)) || (e.a.gem() == null)) {
              break;
            }
            e.a.gem().a(paramInt1, paramBundle, paramInt2);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79442);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(79442);
      }
      
      public final void a(f paramf, int paramInt)
      {
        AppMethodBeat.i(79470);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if (paramf != null) {}
          for (IBinder localIBinder = paramf.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeInt(paramInt);
            if ((this.mRemote.transact(42, localParcel1, localParcel2, 0)) || (e.a.gem() == null)) {
              break;
            }
            e.a.gem().a(paramf, paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79470);
        }
      }
      
      public final void a(String paramString, Bundle paramBundle, int paramInt)
      {
        AppMethodBeat.i(79466);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          for (;;)
          {
            localParcel1.writeInt(paramInt);
            if ((this.mRemote.transact(38, localParcel1, localParcel2, 0)) || (e.a.gem() == null)) {
              break;
            }
            e.a.gem().a(paramString, paramBundle, paramInt);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79466);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(79466);
      }
      
      public final void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, Bundle paramBundle)
      {
        AppMethodBeat.i(79498);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(70, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().a(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramBundle);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79498);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(79498);
      }
      
      public final void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(79496);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          localParcel1.writeIntArray(paramArrayOfInt);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          if ((!this.mRemote.transact(68, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().a(paramString, paramArrayOfInt, paramInt1, paramInt2);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79496);
        }
      }
      
      public final boolean a(String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt)
      {
        AppMethodBeat.i(79464);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            if (paramBundle1 != null)
            {
              localParcel1.writeInt(1);
              paramBundle1.writeToParcel(localParcel1, 0);
              if (paramBundle2 != null)
              {
                localParcel1.writeInt(1);
                paramBundle2.writeToParcel(localParcel1, 0);
                localParcel1.writeInt(paramInt);
                if ((this.mRemote.transact(36, localParcel1, localParcel2, 0)) || (e.a.gem() == null)) {
                  break;
                }
                bool = e.a.gem().a(paramString1, paramString2, paramString3, paramBundle1, paramBundle2, paramInt);
                return bool;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
            AppMethodBeat.o(79464);
          }
        }
        localParcel2.readException();
        paramInt = localParcel2.readInt();
        if (paramInt != 0) {}
        for (boolean bool = true;; bool = false)
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79464);
          return bool;
        }
      }
      
      public final boolean a(String paramString, boolean paramBoolean, Bundle paramBundle)
      {
        boolean bool = true;
        AppMethodBeat.i(79453);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if (paramBoolean)
          {
            i = 1;
            localParcel1.writeInt(i);
            if (paramBundle == null) {
              break label122;
            }
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          for (;;)
          {
            if ((this.mRemote.transact(25, localParcel1, localParcel2, 0)) || (e.a.gem() == null)) {
              break label149;
            }
            paramBoolean = e.a.gem().a(paramString, paramBoolean, paramBundle);
            return paramBoolean;
            i = 0;
            break;
            label122:
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79453);
        }
        label149:
        int i = localParcel2.readInt();
        if (i != 0) {}
        for (paramBoolean = bool;; paramBoolean = false)
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79453);
          return paramBoolean;
        }
      }
      
      public final void aL(int paramInt1, int paramInt2, int paramInt3)
      {
        AppMethodBeat.i(79469);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          if ((!this.mRemote.transact(41, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().aL(paramInt1, paramInt2, paramInt3);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79469);
        }
      }
      
      public final boolean aUM()
      {
        boolean bool = false;
        AppMethodBeat.i(79438);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(10, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().aUM();
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79438);
        }
      }
      
      public final c aY(Bundle paramBundle)
      {
        AppMethodBeat.i(79443);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(15, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramBundle = e.a.gem().aY(paramBundle);
            return paramBundle;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79443);
        }
        paramBundle = c.a.G(localParcel2.readStrongBinder());
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(79443);
        return paramBundle;
      }
      
      public final boolean aZ(Bundle paramBundle)
      {
        boolean bool = true;
        AppMethodBeat.i(79444);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(16, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().aZ(paramBundle);
            return bool;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79444);
        }
        int i = localParcel2.readInt();
        if (i != 0) {}
        for (;;)
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79444);
          return bool;
          bool = false;
        }
      }
      
      public final List<String> aZM()
      {
        AppMethodBeat.i(79451);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(23, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            localObject1 = e.a.gem().aZM();
            return localObject1;
          }
          localParcel2.readException();
          Object localObject1 = localParcel2.createStringArrayList();
          return localObject1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79451);
        }
      }
      
      public final boolean aZN()
      {
        boolean bool = false;
        AppMethodBeat.i(79450);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(22, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().aZN();
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79450);
        }
      }
      
      public final String aZQ(String paramString)
      {
        AppMethodBeat.i(79434);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramString = e.a.gem().aZQ(paramString);
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
          AppMethodBeat.o(79434);
        }
      }
      
      public final String aZR(String paramString)
      {
        AppMethodBeat.i(79454);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(26, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramString = e.a.gem().aZR(paramString);
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
          AppMethodBeat.o(79454);
        }
      }
      
      public final void aZS(String paramString)
      {
        AppMethodBeat.i(79467);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(39, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().aZS(paramString);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79467);
        }
      }
      
      public final String aZT(String paramString)
      {
        AppMethodBeat.i(79468);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(40, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramString = e.a.gem().aZT(paramString);
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
          AppMethodBeat.o(79468);
        }
      }
      
      /* Error */
      public final boolean aZU(String paramString)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: ldc 209
        //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 4
        //   12: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   15: astore 5
        //   17: aload 4
        //   19: ldc 38
        //   21: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   24: aload 4
        //   26: aload_1
        //   27: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   30: aload_0
        //   31: getfield 20	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
        //   34: iconst_1
        //   35: aload 4
        //   37: aload 5
        //   39: iconst_0
        //   40: invokeinterface 51 5 0
        //   45: ifne +36 -> 81
        //   48: invokestatic 55	com/tencent/mm/plugin/webview/stub/e$a:gem	()Lcom/tencent/mm/plugin/webview/stub/e;
        //   51: ifnull +30 -> 81
        //   54: invokestatic 55	com/tencent/mm/plugin/webview/stub/e$a:gem	()Lcom/tencent/mm/plugin/webview/stub/e;
        //   57: aload_1
        //   58: invokeinterface 211 2 0
        //   63: istore_3
        //   64: aload 5
        //   66: invokevirtual 60	android/os/Parcel:recycle	()V
        //   69: aload 4
        //   71: invokevirtual 60	android/os/Parcel:recycle	()V
        //   74: ldc 209
        //   76: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   79: iload_3
        //   80: ireturn
        //   81: aload 5
        //   83: invokevirtual 66	android/os/Parcel:readException	()V
        //   86: aload 5
        //   88: invokevirtual 70	android/os/Parcel:readInt	()I
        //   91: istore_2
        //   92: iload_2
        //   93: ifeq +20 -> 113
        //   96: aload 5
        //   98: invokevirtual 60	android/os/Parcel:recycle	()V
        //   101: aload 4
        //   103: invokevirtual 60	android/os/Parcel:recycle	()V
        //   106: ldc 209
        //   108: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   111: iload_3
        //   112: ireturn
        //   113: iconst_0
        //   114: istore_3
        //   115: goto -19 -> 96
        //   118: astore_1
        //   119: aload 5
        //   121: invokevirtual 60	android/os/Parcel:recycle	()V
        //   124: aload 4
        //   126: invokevirtual 60	android/os/Parcel:recycle	()V
        //   129: ldc 209
        //   131: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   134: aload_1
        //   135: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	136	0	this	a
        //   0	136	1	paramString	String
        //   91	2	2	i	int
        //   1	114	3	bool	boolean
        //   10	115	4	localParcel1	Parcel
        //   15	105	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   17	64	118	finally
        //   81	92	118	finally
      }
      
      public final String aZV(String paramString)
      {
        AppMethodBeat.i(79476);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(48, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramString = e.a.gem().aZV(paramString);
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
          AppMethodBeat.o(79476);
        }
      }
      
      public final void aZW(String paramString)
      {
        AppMethodBeat.i(79479);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(51, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().aZW(paramString);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79479);
        }
      }
      
      public final int aZX(String paramString)
      {
        AppMethodBeat.i(79445);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(17, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            i = e.a.gem().aZX(paramString);
            return i;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79445);
        }
      }
      
      public final void aZY(String paramString)
      {
        AppMethodBeat.i(79449);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(21, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().aZY(paramString);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79449);
        }
      }
      
      public final void aZZ(String paramString)
      {
        AppMethodBeat.i(79497);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(69, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().aZZ(paramString);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79497);
        }
      }
      
      public final String aZj(String paramString)
      {
        AppMethodBeat.i(79474);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(46, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramString = e.a.gem().aZj(paramString);
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
          AppMethodBeat.o(79474);
        }
      }
      
      public final void agA(int paramInt)
      {
        AppMethodBeat.i(79488);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(60, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().agA(paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79488);
        }
      }
      
      /* Error */
      public final Bundle agv(int paramInt)
      {
        // Byte code:
        //   0: ldc 243
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 38
        //   17: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: iload_1
        //   22: invokevirtual 93	android/os/Parcel:writeInt	(I)V
        //   25: aload_0
        //   26: getfield 20	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
        //   29: bipush 33
        //   31: aload_3
        //   32: aload 4
        //   34: iconst_0
        //   35: invokeinterface 51 5 0
        //   40: ifne +35 -> 75
        //   43: invokestatic 55	com/tencent/mm/plugin/webview/stub/e$a:gem	()Lcom/tencent/mm/plugin/webview/stub/e;
        //   46: ifnull +29 -> 75
        //   49: invokestatic 55	com/tencent/mm/plugin/webview/stub/e$a:gem	()Lcom/tencent/mm/plugin/webview/stub/e;
        //   52: iload_1
        //   53: invokeinterface 245 2 0
        //   58: astore_2
        //   59: aload 4
        //   61: invokevirtual 60	android/os/Parcel:recycle	()V
        //   64: aload_3
        //   65: invokevirtual 60	android/os/Parcel:recycle	()V
        //   68: ldc 243
        //   70: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   73: aload_2
        //   74: areturn
        //   75: aload 4
        //   77: invokevirtual 66	android/os/Parcel:readException	()V
        //   80: aload 4
        //   82: invokevirtual 70	android/os/Parcel:readInt	()I
        //   85: ifeq +33 -> 118
        //   88: getstatic 249	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   91: aload 4
        //   93: invokeinterface 255 2 0
        //   98: checkcast 99	android/os/Bundle
        //   101: astore_2
        //   102: aload 4
        //   104: invokevirtual 60	android/os/Parcel:recycle	()V
        //   107: aload_3
        //   108: invokevirtual 60	android/os/Parcel:recycle	()V
        //   111: ldc 243
        //   113: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   116: aload_2
        //   117: areturn
        //   118: aconst_null
        //   119: astore_2
        //   120: goto -18 -> 102
        //   123: astore_2
        //   124: aload 4
        //   126: invokevirtual 60	android/os/Parcel:recycle	()V
        //   129: aload_3
        //   130: invokevirtual 60	android/os/Parcel:recycle	()V
        //   133: ldc 243
        //   135: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   138: aload_2
        //   139: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	140	0	this	a
        //   0	140	1	paramInt	int
        //   58	62	2	localBundle	Bundle
        //   123	16	2	localObject	Object
        //   8	122	3	localParcel1	Parcel
        //   12	113	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	59	123	finally
        //   75	102	123	finally
      }
      
      public final boolean agw(int paramInt)
      {
        boolean bool = false;
        AppMethodBeat.i(79462);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(34, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().agw(paramInt);
            return bool;
          }
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79462);
        }
      }
      
      public final void agx(int paramInt)
      {
        AppMethodBeat.i(79463);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(35, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().agx(paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79463);
        }
      }
      
      public final void agy(int paramInt)
      {
        AppMethodBeat.i(79471);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(43, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().agy(paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79471);
        }
      }
      
      public final void agz(int paramInt)
      {
        AppMethodBeat.i(79487);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(59, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().agz(paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79487);
        }
      }
      
      public final void an(String paramString1, String paramString2, int paramInt)
      {
        AppMethodBeat.i(79465);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(37, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().an(paramString1, paramString2, paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79465);
        }
      }
      
      public final boolean apn()
      {
        boolean bool = false;
        AppMethodBeat.i(79435);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().apn();
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79435);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void b(Bundle paramBundle, int paramInt)
      {
        AppMethodBeat.i(79503);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          for (;;)
          {
            localParcel1.writeInt(paramInt);
            if ((this.mRemote.transact(75, localParcel1, localParcel2, 0)) || (e.a.gem() == null)) {
              break;
            }
            e.a.gem().b(paramBundle, paramInt);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79503);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(79503);
      }
      
      public final String baa(String paramString)
      {
        AppMethodBeat.i(79492);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(64, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramString = e.a.gem().baa(paramString);
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
          AppMethodBeat.o(79492);
        }
      }
      
      public final void bm(Intent paramIntent)
      {
        AppMethodBeat.i(79500);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if (paramIntent != null)
          {
            localParcel1.writeInt(1);
            paramIntent.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(72, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().bm(paramIntent);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79500);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(79500);
      }
      
      public final void bs(int paramInt, boolean paramBoolean)
      {
        int i = 0;
        AppMethodBeat.i(224510);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          if ((!this.mRemote.transact(61, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().bs(paramInt, paramBoolean);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(224510);
        }
      }
      
      public final void cP(String paramString, boolean paramBoolean)
      {
        int i = 0;
        AppMethodBeat.i(79456);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          if ((!this.mRemote.transact(28, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().cP(paramString, paramBoolean);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79456);
        }
      }
      
      public final String cX(int paramInt, String paramString)
      {
        AppMethodBeat.i(79441);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(13, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramString = e.a.gem().cX(paramInt, paramString);
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
          AppMethodBeat.o(79441);
        }
      }
      
      public final void favEditTag()
      {
        AppMethodBeat.i(79446);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(18, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().favEditTag();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79446);
        }
      }
      
      public final boolean gdW()
      {
        boolean bool = false;
        AppMethodBeat.i(79437);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().gdW();
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79437);
        }
      }
      
      public final String[] gdX()
      {
        AppMethodBeat.i(79472);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(44, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            arrayOfString = e.a.gem().gdX();
            return arrayOfString;
          }
          localParcel2.readException();
          String[] arrayOfString = localParcel2.createStringArray();
          return arrayOfString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79472);
        }
      }
      
      public final String gdY()
      {
        AppMethodBeat.i(79473);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(45, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            str = e.a.gem().gdY();
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
          AppMethodBeat.o(79473);
        }
      }
      
      public final String gdZ()
      {
        AppMethodBeat.i(79475);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(47, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            str = e.a.gem().gdZ();
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
          AppMethodBeat.o(79475);
        }
      }
      
      public final String gea()
      {
        AppMethodBeat.i(79482);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(54, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            str = e.a.gem().gea();
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
          AppMethodBeat.o(79482);
        }
      }
      
      public final Map geb()
      {
        AppMethodBeat.i(79477);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(49, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            localObject1 = e.a.gem().geb();
            return localObject1;
          }
          localParcel2.readException();
          Object localObject1 = localParcel2.readHashMap(getClass().getClassLoader());
          return localObject1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79477);
        }
      }
      
      public final int gec()
      {
        AppMethodBeat.i(79483);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(55, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            i = e.a.gem().gec();
            return i;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79483);
        }
      }
      
      public final int ged()
      {
        AppMethodBeat.i(79484);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(56, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            i = e.a.gem().ged();
            return i;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79484);
        }
      }
      
      public final void gee()
      {
        AppMethodBeat.i(79485);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(57, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().gee();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79485);
        }
      }
      
      public final void gef()
      {
        AppMethodBeat.i(79486);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(58, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().gef();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79486);
        }
      }
      
      public final boolean geg()
      {
        boolean bool = false;
        AppMethodBeat.i(79491);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(63, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().geg();
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79491);
        }
      }
      
      public final boolean geh()
      {
        boolean bool = false;
        AppMethodBeat.i(79494);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(66, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().geh();
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79494);
        }
      }
      
      public final boolean gei()
      {
        boolean bool = false;
        AppMethodBeat.i(79493);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(65, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().gei();
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79493);
        }
      }
      
      public final List<String> gej()
      {
        AppMethodBeat.i(79502);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(74, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            localObject1 = e.a.gem().gej();
            return localObject1;
          }
          localParcel2.readException();
          Object localObject1 = localParcel2.createStringArrayList();
          return localObject1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79502);
        }
      }
      
      public final boolean gek()
      {
        boolean bool = false;
        AppMethodBeat.i(79495);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(67, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().gek();
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79495);
        }
      }
      
      public final String[] gel()
      {
        AppMethodBeat.i(79505);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(77, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            arrayOfString = e.a.gem().gel();
            return arrayOfString;
          }
          localParcel2.readException();
          String[] arrayOfString = localParcel2.createStringArray();
          return arrayOfString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79505);
        }
      }
      
      public final String getDisplayName(String paramString)
      {
        AppMethodBeat.i(79430);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramString = e.a.gem().getDisplayName(paramString);
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
          AppMethodBeat.o(79430);
        }
      }
      
      public final String getLanguage()
      {
        AppMethodBeat.i(79481);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(53, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            str = e.a.gem().getLanguage();
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
          AppMethodBeat.o(79481);
        }
      }
      
      public final int getPayChannel()
      {
        AppMethodBeat.i(79504);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(76, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            i = e.a.gem().getPayChannel();
            return i;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79504);
        }
      }
      
      public final void gt(String paramString, int paramInt)
      {
        AppMethodBeat.i(79455);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(27, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().gt(paramString, paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79455);
        }
      }
      
      public final String gu(String paramString, int paramInt)
      {
        AppMethodBeat.i(79480);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(52, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramString = e.a.gem().gu(paramString, paramInt);
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
          AppMethodBeat.o(79480);
        }
      }
      
      public final void gv(String paramString, int paramInt)
      {
        AppMethodBeat.i(79490);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(62, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().gv(paramString, paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79490);
        }
      }
      
      public final boolean gw(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(79457);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(29, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().gw(paramString);
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79457);
        }
      }
      
      public final boolean isSDCardAvailable()
      {
        boolean bool = false;
        AppMethodBeat.i(79436);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().isSDCardAvailable();
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79436);
        }
      }
      
      public final Bundle j(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(79499);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(71, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramBundle = e.a.gem().j(paramInt, paramBundle);
            return paramBundle;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79499);
        }
        if (localParcel2.readInt() != 0) {}
        for (paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);; paramBundle = null)
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79499);
          return paramBundle;
        }
      }
      
      public final int kl(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(79439);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          if ((!this.mRemote.transact(11, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramInt1 = e.a.gem().kl(paramInt1, paramInt2);
            return paramInt1;
          }
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          return paramInt1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79439);
        }
      }
      
      public final void km(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(79440);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          if ((!this.mRemote.transact(12, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().km(paramInt1, paramInt2);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79440);
        }
      }
      
      public final void l(String paramString, boolean paramBoolean, int paramInt)
      {
        int i = 0;
        AppMethodBeat.i(79460);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(32, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().l(paramString, paramBoolean, paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79460);
        }
      }
      
      public final String md(String paramString1, String paramString2)
      {
        AppMethodBeat.i(79478);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if ((!this.mRemote.transact(50, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramString1 = e.a.gem().md(paramString1, paramString2);
            return paramString1;
          }
          localParcel2.readException();
          paramString1 = localParcel2.readString();
          return paramString1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79478);
        }
      }
      
      public final Bundle u(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(79459);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(31, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramBundle = e.a.gem().u(paramInt, paramBundle);
            return paramBundle;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79459);
        }
        if (localParcel2.readInt() != 0) {}
        for (paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);; paramBundle = null)
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79459);
          return paramBundle;
        }
      }
      
      public final void v(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(79506);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(78, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().v(paramInt, paramBundle);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79506);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(79506);
      }
      
      public final void v(int paramInt, List<String> paramList)
      {
        AppMethodBeat.i(79452);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          localParcel1.writeStringList(paramList);
          if ((!this.mRemote.transact(24, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            e.a.gem().v(paramInt, paramList);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79452);
        }
      }
      
      public final Bundle w(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(79458);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(30, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            paramBundle = e.a.gem().w(paramInt, paramBundle);
            return paramBundle;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79458);
        }
        if (localParcel2.readInt() != 0) {}
        for (paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);; paramBundle = null)
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79458);
          return paramBundle;
        }
      }
      
      public final boolean x(int paramInt, Bundle paramBundle)
      {
        boolean bool = true;
        AppMethodBeat.i(79447);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(19, localParcel1, localParcel2, 0)) && (e.a.gem() != null))
          {
            bool = e.a.gem().x(paramInt, paramBundle);
            return bool;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79447);
        }
        paramInt = localParcel2.readInt();
        if (paramInt != 0) {}
        for (;;)
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79447);
          return bool;
          bool = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.e
 * JD-Core Version:    0.7.0.1
 */