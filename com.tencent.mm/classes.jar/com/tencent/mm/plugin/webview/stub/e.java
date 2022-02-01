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
  public abstract String PJ(String paramString);
  
  public abstract boolean QX(String paramString);
  
  public abstract boolean Ql(String paramString);
  
  public abstract boolean Qm(String paramString);
  
  public abstract boolean V(long paramLong, String paramString);
  
  public abstract void Y(int paramInt, String paramString1, String paramString2);
  
  public abstract void a(int paramInt1, Bundle paramBundle, int paramInt2);
  
  public abstract void a(f paramf, int paramInt);
  
  public abstract void a(String paramString, Bundle paramBundle, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, Bundle paramBundle);
  
  public abstract void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2);
  
  public abstract boolean a(String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt);
  
  public abstract boolean a(String paramString, boolean paramBoolean, Bundle paramBundle);
  
  public abstract void aP(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract c aU(Bundle paramBundle);
  
  public abstract boolean aV(Bundle paramBundle);
  
  public abstract Bundle aok(int paramInt);
  
  public abstract boolean aol(int paramInt);
  
  public abstract void aom(int paramInt);
  
  public abstract void aon(int paramInt);
  
  public abstract void aoo(int paramInt);
  
  public abstract void aop(int paramInt);
  
  public abstract boolean avA();
  
  public abstract void aw(String paramString1, String paramString2, int paramInt);
  
  public abstract void b(Bundle paramBundle, int paramInt);
  
  public abstract void bD(int paramInt, boolean paramBoolean);
  
  public abstract boolean bdO();
  
  public abstract List<String> bjc();
  
  public abstract boolean bjd();
  
  public abstract String blL(String paramString);
  
  public abstract String blM(String paramString);
  
  public abstract void blN(String paramString);
  
  public abstract String blO(String paramString);
  
  public abstract boolean blP(String paramString);
  
  public abstract String blQ(String paramString);
  
  public abstract void blR(String paramString);
  
  public abstract int blS(String paramString);
  
  public abstract void blT(String paramString);
  
  public abstract void blU(String paramString);
  
  public abstract String blV(String paramString);
  
  public abstract String bld(String paramString);
  
  public abstract void bn(Intent paramIntent);
  
  public abstract String cX(int paramInt, String paramString);
  
  public abstract void dd(String paramString, boolean paramBoolean);
  
  public abstract void favEditTag();
  
  public abstract boolean gWY();
  
  public abstract String[] gWZ();
  
  public abstract String gXa();
  
  public abstract String gXb();
  
  public abstract String gXc();
  
  public abstract Map gXd();
  
  public abstract int gXe();
  
  public abstract int gXf();
  
  public abstract void gXg();
  
  public abstract void gXh();
  
  public abstract boolean gXi();
  
  public abstract boolean gXj();
  
  public abstract boolean gXk();
  
  public abstract List<String> gXl();
  
  public abstract boolean gXm();
  
  public abstract String[] gXn();
  
  public abstract String getLanguage();
  
  public abstract int getPayChannel();
  
  public abstract void hb(String paramString, int paramInt);
  
  public abstract String hc(String paramString, int paramInt);
  
  public abstract void hd(String paramString, int paramInt);
  
  public abstract boolean hh(String paramString);
  
  public abstract boolean isSDCardAvailable();
  
  public abstract Bundle l(int paramInt, Bundle paramBundle);
  
  public abstract int lD(int paramInt1, int paramInt2);
  
  public abstract void lE(int paramInt1, int paramInt2);
  
  public abstract String mD(String paramString1, String paramString2);
  
  public abstract void o(String paramString, boolean paramBoolean, int paramInt);
  
  public abstract Bundle w(int paramInt, Bundle paramBundle);
  
  public abstract void x(int paramInt, Bundle paramBundle);
  
  public abstract Bundle y(int paramInt, Bundle paramBundle);
  
  public abstract void y(int paramInt, List<String> paramList);
  
  public abstract boolean z(int paramInt, Bundle paramBundle);
  
  public static abstract class a
    extends Binder
    implements e
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
    }
    
    public static e L(IBinder paramIBinder)
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
    
    public static e gXo()
    {
      return a.QaH;
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
        bool1 = blP(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (bool1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = PJ(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = Ql(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = QX(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = Qm(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = blL(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = avA();
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
        bool1 = gWY();
        paramParcel2.writeNoException();
        paramInt1 = i2;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = bdO();
        paramParcel2.writeNoException();
        paramInt1 = i3;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = lD(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        lE(paramParcel1.readInt(), paramParcel1.readInt());
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
          localObject2 = aU(paramParcel1);
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
          bool1 = aV(paramParcel1);
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
        paramInt1 = blS(paramParcel1.readString());
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
          bool1 = z(paramInt1, paramParcel1);
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
        bool1 = V(paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = i5;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        blT(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = bjd();
        paramParcel2.writeNoException();
        paramInt1 = i6;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = bjc();
        paramParcel2.writeNoException();
        paramParcel2.writeStringList(paramParcel1);
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        y(paramParcel1.readInt(), paramParcel1.createStringArrayList());
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
        paramParcel1 = blM(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        hb(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        localObject1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        dd((String)localObject1, bool1);
        paramParcel2.writeNoException();
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = hh(paramParcel1.readString());
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
          paramParcel1 = y(paramInt1, paramParcel1);
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
      case 32: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        localObject1 = paramParcel1.readString();
        bool1 = bool2;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        o((String)localObject1, bool1, paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 33: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = aok(paramParcel1.readInt());
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
        bool1 = aol(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = i9;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 35: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        aom(paramParcel1.readInt());
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
        aw(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
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
        blN(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 40: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = blO(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 41: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        aP(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 42: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        a(f.a.M(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 43: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        aon(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 44: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = gWZ();
        paramParcel2.writeNoException();
        paramParcel2.writeStringArray(paramParcel1);
        return true;
      case 45: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = gXa();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 46: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = bld(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 47: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = gXb();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 48: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = blQ(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 49: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = gXd();
        paramParcel2.writeNoException();
        paramParcel2.writeMap(paramParcel1);
        return true;
      case 50: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = mD(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 51: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        blR(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 52: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = hc(paramParcel1.readString(), paramParcel1.readInt());
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
        paramParcel1 = gXc();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 55: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = gXe();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 56: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = gXf();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 57: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        gXg();
        paramParcel2.writeNoException();
        return true;
      case 58: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        gXh();
        paramParcel2.writeNoException();
        return true;
      case 59: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        aoo(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 60: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        aop(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 61: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = paramParcel1.readInt();
        bool1 = bool3;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        bD(paramInt1, bool1);
        paramParcel2.writeNoException();
        return true;
      case 62: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        hd(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 63: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = gXi();
        paramParcel2.writeNoException();
        paramInt1 = i11;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 64: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = blV(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 65: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = gXk();
        paramParcel2.writeNoException();
        paramInt1 = i12;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 66: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = gXj();
        paramParcel2.writeNoException();
        paramInt1 = i13;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 67: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = gXm();
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
        blU(paramParcel1.readString());
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
          paramParcel1 = l(paramInt1, paramParcel1);
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
          bn(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 73: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        Y(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 74: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = gXl();
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
        paramParcel1 = gXn();
        paramParcel2.writeNoException();
        paramParcel2.writeStringArray(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        x(paramInt1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    static final class a
      implements e
    {
      public static e QaH;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final String PJ(String paramString)
      {
        AppMethodBeat.i(79430);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramString = e.a.gXo().PJ(paramString);
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
      
      public final boolean QX(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(79432);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().QX(paramString);
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
      
      public final boolean Ql(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(79431);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().Ql(paramString);
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
      
      public final boolean Qm(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(79433);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().Qm(paramString);
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
      
      public final boolean V(long paramLong, String paramString)
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
          if ((!this.mRemote.transact(20, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().V(paramLong, paramString);
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
      
      public final void Y(int paramInt, String paramString1, String paramString2)
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
          if ((!this.mRemote.transact(73, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().Y(paramInt, paramString1, paramString2);
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
            if ((this.mRemote.transact(14, localParcel1, localParcel2, 0)) || (e.a.gXo() == null)) {
              break;
            }
            e.a.gXo().a(paramInt1, paramBundle, paramInt2);
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
            if ((this.mRemote.transact(42, localParcel1, localParcel2, 0)) || (e.a.gXo() == null)) {
              break;
            }
            e.a.gXo().a(paramf, paramInt);
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
            if ((this.mRemote.transact(38, localParcel1, localParcel2, 0)) || (e.a.gXo() == null)) {
              break;
            }
            e.a.gXo().a(paramString, paramBundle, paramInt);
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
          while ((!this.mRemote.transact(70, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().a(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramBundle);
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
          if ((!this.mRemote.transact(68, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().a(paramString, paramArrayOfInt, paramInt1, paramInt2);
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
                if ((this.mRemote.transact(36, localParcel1, localParcel2, 0)) || (e.a.gXo() == null)) {
                  break;
                }
                bool = e.a.gXo().a(paramString1, paramString2, paramString3, paramBundle1, paramBundle2, paramInt);
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
            if ((this.mRemote.transact(25, localParcel1, localParcel2, 0)) || (e.a.gXo() == null)) {
              break label149;
            }
            paramBoolean = e.a.gXo().a(paramString, paramBoolean, paramBundle);
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
      
      public final void aP(int paramInt1, int paramInt2, int paramInt3)
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
          if ((!this.mRemote.transact(41, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().aP(paramInt1, paramInt2, paramInt3);
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
      
      public final c aU(Bundle paramBundle)
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
          while ((!this.mRemote.transact(15, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramBundle = e.a.gXo().aU(paramBundle);
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
        paramBundle = c.a.K(localParcel2.readStrongBinder());
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(79443);
        return paramBundle;
      }
      
      public final boolean aV(Bundle paramBundle)
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
          while ((!this.mRemote.transact(16, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().aV(paramBundle);
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
      
      /* Error */
      public final Bundle aok(int paramInt)
      {
        // Byte code:
        //   0: ldc 178
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
        //   22: invokevirtual 102	android/os/Parcel:writeInt	(I)V
        //   25: aload_0
        //   26: getfield 20	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
        //   29: bipush 33
        //   31: aload_3
        //   32: aload 4
        //   34: iconst_0
        //   35: invokeinterface 51 5 0
        //   40: ifne +35 -> 75
        //   43: invokestatic 55	com/tencent/mm/plugin/webview/stub/e$a:gXo	()Lcom/tencent/mm/plugin/webview/stub/e;
        //   46: ifnull +29 -> 75
        //   49: invokestatic 55	com/tencent/mm/plugin/webview/stub/e$a:gXo	()Lcom/tencent/mm/plugin/webview/stub/e;
        //   52: iload_1
        //   53: invokeinterface 180 2 0
        //   58: astore_2
        //   59: aload 4
        //   61: invokevirtual 60	android/os/Parcel:recycle	()V
        //   64: aload_3
        //   65: invokevirtual 60	android/os/Parcel:recycle	()V
        //   68: ldc 178
        //   70: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   73: aload_2
        //   74: areturn
        //   75: aload 4
        //   77: invokevirtual 66	android/os/Parcel:readException	()V
        //   80: aload 4
        //   82: invokevirtual 79	android/os/Parcel:readInt	()I
        //   85: ifeq +33 -> 118
        //   88: getstatic 184	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   91: aload 4
        //   93: invokeinterface 190 2 0
        //   98: checkcast 108	android/os/Bundle
        //   101: astore_2
        //   102: aload 4
        //   104: invokevirtual 60	android/os/Parcel:recycle	()V
        //   107: aload_3
        //   108: invokevirtual 60	android/os/Parcel:recycle	()V
        //   111: ldc 178
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
        //   133: ldc 178
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
      
      public final boolean aol(int paramInt)
      {
        boolean bool = false;
        AppMethodBeat.i(79462);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(34, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().aol(paramInt);
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
      
      public final void aom(int paramInt)
      {
        AppMethodBeat.i(79463);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(35, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().aom(paramInt);
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
      
      public final void aon(int paramInt)
      {
        AppMethodBeat.i(79471);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(43, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().aon(paramInt);
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
      
      public final void aoo(int paramInt)
      {
        AppMethodBeat.i(79487);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(59, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().aoo(paramInt);
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
      
      public final void aop(int paramInt)
      {
        AppMethodBeat.i(79488);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(60, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().aop(paramInt);
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
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final boolean avA()
      {
        boolean bool = false;
        AppMethodBeat.i(79435);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().avA();
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
      
      public final void aw(String paramString1, String paramString2, int paramInt)
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
          if ((!this.mRemote.transact(37, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().aw(paramString1, paramString2, paramInt);
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
            if ((this.mRemote.transact(75, localParcel1, localParcel2, 0)) || (e.a.gXo() == null)) {
              break;
            }
            e.a.gXo().b(paramBundle, paramInt);
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
      
      public final void bD(int paramInt, boolean paramBoolean)
      {
        int i = 0;
        AppMethodBeat.i(207329);
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
          if ((!this.mRemote.transact(61, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().bD(paramInt, paramBoolean);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(207329);
        }
      }
      
      public final boolean bdO()
      {
        boolean bool = false;
        AppMethodBeat.i(79438);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(10, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().bdO();
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
      
      public final List<String> bjc()
      {
        AppMethodBeat.i(79451);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(23, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            localObject1 = e.a.gXo().bjc();
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
      
      public final boolean bjd()
      {
        boolean bool = false;
        AppMethodBeat.i(79450);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(22, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().bjd();
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
      
      public final String blL(String paramString)
      {
        AppMethodBeat.i(79434);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramString = e.a.gXo().blL(paramString);
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
      
      public final String blM(String paramString)
      {
        AppMethodBeat.i(79454);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(26, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramString = e.a.gXo().blM(paramString);
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
      
      public final void blN(String paramString)
      {
        AppMethodBeat.i(79467);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(39, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().blN(paramString);
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
      
      public final String blO(String paramString)
      {
        AppMethodBeat.i(79468);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(40, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramString = e.a.gXo().blO(paramString);
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
      public final boolean blP(String paramString)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: ldc_w 268
        //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 4
        //   13: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   16: astore 5
        //   18: aload 4
        //   20: ldc 38
        //   22: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   25: aload 4
        //   27: aload_1
        //   28: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   31: aload_0
        //   32: getfield 20	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
        //   35: iconst_1
        //   36: aload 4
        //   38: aload 5
        //   40: iconst_0
        //   41: invokeinterface 51 5 0
        //   46: ifne +37 -> 83
        //   49: invokestatic 55	com/tencent/mm/plugin/webview/stub/e$a:gXo	()Lcom/tencent/mm/plugin/webview/stub/e;
        //   52: ifnull +31 -> 83
        //   55: invokestatic 55	com/tencent/mm/plugin/webview/stub/e$a:gXo	()Lcom/tencent/mm/plugin/webview/stub/e;
        //   58: aload_1
        //   59: invokeinterface 270 2 0
        //   64: istore_3
        //   65: aload 5
        //   67: invokevirtual 60	android/os/Parcel:recycle	()V
        //   70: aload 4
        //   72: invokevirtual 60	android/os/Parcel:recycle	()V
        //   75: ldc_w 268
        //   78: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   81: iload_3
        //   82: ireturn
        //   83: aload 5
        //   85: invokevirtual 66	android/os/Parcel:readException	()V
        //   88: aload 5
        //   90: invokevirtual 79	android/os/Parcel:readInt	()I
        //   93: istore_2
        //   94: iload_2
        //   95: ifeq +21 -> 116
        //   98: aload 5
        //   100: invokevirtual 60	android/os/Parcel:recycle	()V
        //   103: aload 4
        //   105: invokevirtual 60	android/os/Parcel:recycle	()V
        //   108: ldc_w 268
        //   111: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   114: iload_3
        //   115: ireturn
        //   116: iconst_0
        //   117: istore_3
        //   118: goto -20 -> 98
        //   121: astore_1
        //   122: aload 5
        //   124: invokevirtual 60	android/os/Parcel:recycle	()V
        //   127: aload 4
        //   129: invokevirtual 60	android/os/Parcel:recycle	()V
        //   132: ldc_w 268
        //   135: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   138: aload_1
        //   139: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	140	0	this	a
        //   0	140	1	paramString	String
        //   93	2	2	i	int
        //   1	117	3	bool	boolean
        //   11	117	4	localParcel1	Parcel
        //   16	107	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   18	65	121	finally
        //   83	94	121	finally
      }
      
      public final String blQ(String paramString)
      {
        AppMethodBeat.i(79476);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(48, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramString = e.a.gXo().blQ(paramString);
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
      
      public final void blR(String paramString)
      {
        AppMethodBeat.i(79479);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(51, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().blR(paramString);
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
      
      public final int blS(String paramString)
      {
        AppMethodBeat.i(79445);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(17, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            i = e.a.gXo().blS(paramString);
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
      
      public final void blT(String paramString)
      {
        AppMethodBeat.i(79449);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(21, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().blT(paramString);
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
      
      public final void blU(String paramString)
      {
        AppMethodBeat.i(79497);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(69, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().blU(paramString);
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
      
      public final String blV(String paramString)
      {
        AppMethodBeat.i(79492);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(64, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramString = e.a.gXo().blV(paramString);
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
      
      public final String bld(String paramString)
      {
        AppMethodBeat.i(79474);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(46, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramString = e.a.gXo().bld(paramString);
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
      
      public final void bn(Intent paramIntent)
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
          while ((!this.mRemote.transact(72, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().bn(paramIntent);
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
          if ((!this.mRemote.transact(13, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramString = e.a.gXo().cX(paramInt, paramString);
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
      
      public final void dd(String paramString, boolean paramBoolean)
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
          if ((!this.mRemote.transact(28, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().dd(paramString, paramBoolean);
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
      
      public final void favEditTag()
      {
        AppMethodBeat.i(79446);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(18, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().favEditTag();
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
      
      public final boolean gWY()
      {
        boolean bool = false;
        AppMethodBeat.i(79437);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().gWY();
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
      
      public final String[] gWZ()
      {
        AppMethodBeat.i(79472);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(44, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            arrayOfString = e.a.gXo().gWZ();
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
      
      public final String gXa()
      {
        AppMethodBeat.i(79473);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(45, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            str = e.a.gXo().gXa();
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
      
      public final String gXb()
      {
        AppMethodBeat.i(79475);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(47, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            str = e.a.gXo().gXb();
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
      
      public final String gXc()
      {
        AppMethodBeat.i(79482);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(54, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            str = e.a.gXo().gXc();
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
      
      public final Map gXd()
      {
        AppMethodBeat.i(79477);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(49, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            localObject1 = e.a.gXo().gXd();
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
      
      public final int gXe()
      {
        AppMethodBeat.i(79483);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(55, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            i = e.a.gXo().gXe();
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
      
      public final int gXf()
      {
        AppMethodBeat.i(79484);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(56, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            i = e.a.gXo().gXf();
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
      
      public final void gXg()
      {
        AppMethodBeat.i(79485);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(57, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().gXg();
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
      
      public final void gXh()
      {
        AppMethodBeat.i(79486);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(58, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().gXh();
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
      
      public final boolean gXi()
      {
        boolean bool = false;
        AppMethodBeat.i(79491);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(63, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().gXi();
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
      
      public final boolean gXj()
      {
        boolean bool = false;
        AppMethodBeat.i(79494);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(66, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().gXj();
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
      
      public final boolean gXk()
      {
        boolean bool = false;
        AppMethodBeat.i(79493);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(65, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().gXk();
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
      
      public final List<String> gXl()
      {
        AppMethodBeat.i(79502);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(74, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            localObject1 = e.a.gXo().gXl();
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
      
      public final boolean gXm()
      {
        boolean bool = false;
        AppMethodBeat.i(79495);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(67, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().gXm();
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
      
      public final String[] gXn()
      {
        AppMethodBeat.i(79505);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(77, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            arrayOfString = e.a.gXo().gXn();
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
      
      public final String getLanguage()
      {
        AppMethodBeat.i(79481);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          if ((!this.mRemote.transact(53, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            str = e.a.gXo().getLanguage();
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
          if ((!this.mRemote.transact(76, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            i = e.a.gXo().getPayChannel();
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
      
      public final void hb(String paramString, int paramInt)
      {
        AppMethodBeat.i(79455);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(27, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().hb(paramString, paramInt);
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
      
      public final String hc(String paramString, int paramInt)
      {
        AppMethodBeat.i(79480);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(52, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramString = e.a.gXo().hc(paramString, paramInt);
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
      
      public final void hd(String paramString, int paramInt)
      {
        AppMethodBeat.i(79490);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(62, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().hd(paramString, paramInt);
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
      
      public final boolean hh(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(79457);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(29, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().hh(paramString);
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
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().isSDCardAvailable();
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
      
      public final Bundle l(int paramInt, Bundle paramBundle)
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
          while ((!this.mRemote.transact(71, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramBundle = e.a.gXo().l(paramInt, paramBundle);
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
      
      public final int lD(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(79439);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          if ((!this.mRemote.transact(11, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramInt1 = e.a.gXo().lD(paramInt1, paramInt2);
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
      
      public final void lE(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(79440);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          if ((!this.mRemote.transact(12, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().lE(paramInt1, paramInt2);
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
      
      public final String mD(String paramString1, String paramString2)
      {
        AppMethodBeat.i(79478);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if ((!this.mRemote.transact(50, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramString1 = e.a.gXo().mD(paramString1, paramString2);
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
      
      public final void o(String paramString, boolean paramBoolean, int paramInt)
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
          if ((!this.mRemote.transact(32, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().o(paramString, paramBoolean, paramInt);
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
      
      public final Bundle w(int paramInt, Bundle paramBundle)
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
          while ((!this.mRemote.transact(31, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramBundle = e.a.gXo().w(paramInt, paramBundle);
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
      
      public final void x(int paramInt, Bundle paramBundle)
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
          while ((!this.mRemote.transact(78, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().x(paramInt, paramBundle);
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
      
      public final Bundle y(int paramInt, Bundle paramBundle)
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
          while ((!this.mRemote.transact(30, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            paramBundle = e.a.gXo().y(paramInt, paramBundle);
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
      
      public final void y(int paramInt, List<String> paramList)
      {
        AppMethodBeat.i(79452);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          localParcel1.writeStringList(paramList);
          if ((!this.mRemote.transact(24, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            e.a.gXo().y(paramInt, paramList);
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
      
      public final boolean z(int paramInt, Bundle paramBundle)
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
          while ((!this.mRemote.transact(19, localParcel1, localParcel2, 0)) && (e.a.gXo() != null))
          {
            bool = e.a.gXo().z(paramInt, paramBundle);
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