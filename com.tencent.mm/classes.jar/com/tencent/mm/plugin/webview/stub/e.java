package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract interface e
  extends IInterface
{
  public abstract boolean C(long paramLong, String paramString);
  
  public abstract void P(int paramInt, String paramString1, String paramString2);
  
  public abstract Bundle Vs(int paramInt);
  
  public abstract boolean Vt(int paramInt);
  
  public abstract void Vu(int paramInt);
  
  public abstract void Vv(int paramInt);
  
  public abstract void Vw(int paramInt);
  
  public abstract void Vx(int paramInt);
  
  public abstract void Vy(int paramInt);
  
  public abstract boolean YD();
  
  public abstract void a(int paramInt1, Bundle paramBundle, int paramInt2);
  
  public abstract void a(Bundle paramBundle, int paramInt);
  
  public abstract void a(f paramf, int paramInt);
  
  public abstract void a(String paramString, Bundle paramBundle, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, Bundle paramBundle);
  
  public abstract void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2);
  
  public abstract boolean a(String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt);
  
  public abstract boolean a(String paramString, boolean paramBoolean, Bundle paramBundle);
  
  public abstract void aA(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract List<String> aCB();
  
  public abstract boolean aCC();
  
  public abstract String aCP(String paramString);
  
  public abstract String aCQ(String paramString);
  
  public abstract void aCR(String paramString);
  
  public abstract String aCS(String paramString);
  
  public abstract boolean aCT(String paramString);
  
  public abstract String aCU(String paramString);
  
  public abstract void aCV(String paramString);
  
  public abstract int aCW(String paramString);
  
  public abstract void aCX(String paramString);
  
  public abstract void aCY(String paramString);
  
  public abstract String aCZ(String paramString);
  
  public abstract String aCl(String paramString);
  
  public abstract c aG(Bundle paramBundle);
  
  public abstract boolean aH(Bundle paramBundle);
  
  public abstract void aV(Intent paramIntent);
  
  public abstract void ac(String paramString1, String paramString2, int paramInt);
  
  public abstract boolean ayd();
  
  public abstract void cj(String paramString, boolean paramBoolean);
  
  public abstract String cy(int paramInt, String paramString);
  
  public abstract boolean eCC();
  
  public abstract String[] eCD();
  
  public abstract String eCE();
  
  public abstract String eCF();
  
  public abstract String eCG();
  
  public abstract Map eCH();
  
  public abstract int eCI();
  
  public abstract int eCJ();
  
  public abstract void eCK();
  
  public abstract void eCL();
  
  public abstract boolean eCM();
  
  public abstract boolean eCN();
  
  public abstract boolean eCO();
  
  public abstract List<String> eCP();
  
  public abstract int eCQ();
  
  public abstract boolean eCR();
  
  public abstract String[] eCS();
  
  public abstract boolean eJ(String paramString);
  
  public abstract void favEditTag();
  
  public abstract void fo(String paramString, int paramInt);
  
  public abstract String fp(String paramString, int paramInt);
  
  public abstract void fq(String paramString, int paramInt);
  
  public abstract String getLanguage();
  
  public abstract int iN(int paramInt1, int paramInt2);
  
  public abstract void iO(int paramInt1, int paramInt2);
  
  public abstract boolean isSDCardAvailable();
  
  public abstract Bundle k(int paramInt, Bundle paramBundle);
  
  public abstract String kB(String paramString1, String paramString2);
  
  public abstract void l(String paramString, boolean paramBoolean, int paramInt);
  
  public abstract void o(int paramInt, List<String> paramList);
  
  public abstract Bundle t(int paramInt, Bundle paramBundle);
  
  public abstract void v(int paramInt, Bundle paramBundle);
  
  public abstract Bundle w(int paramInt, Bundle paramBundle);
  
  public abstract boolean wG(String paramString);
  
  public abstract boolean wH(String paramString);
  
  public abstract String wk(String paramString);
  
  public abstract boolean x(int paramInt, Bundle paramBundle);
  
  public abstract boolean xr(String paramString);
  
  public static abstract class a
    extends Binder
    implements e
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
    }
    
    public static e G(IBinder paramIBinder)
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
      int i11 = 0;
      int i12 = 0;
      int i13 = 0;
      int i14 = 0;
      int j = 0;
      label1654:
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
        bool1 = aCT(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (bool1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = wk(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = wG(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = xr(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = wH(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = aCP(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = YD();
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
        bool1 = eCC();
        paramParcel2.writeNoException();
        paramInt1 = i2;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = ayd();
        paramParcel2.writeNoException();
        paramInt1 = i3;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = iN(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        iO(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = cy(paramParcel1.readInt(), paramParcel1.readString());
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
          localObject2 = aG(paramParcel1);
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
          bool1 = aH(paramParcel1);
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
        paramInt1 = aCW(paramParcel1.readString());
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
        bool1 = C(paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = i5;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        aCX(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = aCC();
        paramParcel2.writeNoException();
        paramInt1 = i6;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = aCB();
        paramParcel2.writeNoException();
        paramParcel2.writeStringList(paramParcel1);
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        o(paramParcel1.readInt(), paramParcel1.createStringArrayList());
        paramParcel2.writeNoException();
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        localObject1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          bool1 = true;
          if (paramParcel1.readInt() == 0) {
            break label1654;
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
        paramParcel1 = aCQ(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        fo(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        localObject1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        cj((String)localObject1, bool1);
        paramParcel2.writeNoException();
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = eJ(paramParcel1.readString());
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
          paramParcel1 = t(paramInt1, paramParcel1);
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
        paramParcel1 = Vs(paramParcel1.readInt());
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
        bool1 = Vt(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = i9;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 35: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        Vu(paramParcel1.readInt());
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
            break label2181;
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
        ac(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
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
        aCR(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 40: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = aCS(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 41: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        aA(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 42: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        a(f.a.H(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 43: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        Vv(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 44: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = eCD();
        paramParcel2.writeNoException();
        paramParcel2.writeStringArray(paramParcel1);
        return true;
      case 45: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = eCE();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 46: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = aCl(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 47: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = eCF();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 48: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = aCU(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 49: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = eCH();
        paramParcel2.writeNoException();
        paramParcel2.writeMap(paramParcel1);
        return true;
      case 50: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = kB(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 51: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        aCV(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 52: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = fp(paramParcel1.readString(), paramParcel1.readInt());
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
        paramParcel1 = eCG();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 55: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = eCI();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 56: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = eCJ();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 57: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        eCK();
        paramParcel2.writeNoException();
        return true;
      case 58: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        eCL();
        paramParcel2.writeNoException();
        return true;
      case 59: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        Vx(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 60: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        Vy(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 61: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        Vw(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 62: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        fq(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 63: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = eCM();
        paramParcel2.writeNoException();
        paramInt1 = i11;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 64: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = aCZ(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 65: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = eCO();
        paramParcel2.writeNoException();
        paramInt1 = i12;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 66: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = eCN();
        paramParcel2.writeNoException();
        paramInt1 = i13;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 67: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        bool1 = eCR();
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
        aCY(paramParcel1.readString());
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
          paramParcel1 = k(paramInt1, paramParcel1);
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
          aV(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 73: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        P(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 74: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = eCP();
        paramParcel2.writeNoException();
        paramParcel2.writeStringList(paramParcel1);
        return true;
      case 75: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          a((Bundle)localObject1, paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
      case 76: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramInt1 = eCQ();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 77: 
        label2181:
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        paramParcel1 = eCS();
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
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final boolean C(long paramLong, String paramString)
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
          this.mRemote.transact(20, localParcel1, localParcel2, 0);
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
      
      public final void P(int paramInt, String paramString1, String paramString2)
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
          this.mRemote.transact(73, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public final Bundle Vs(int paramInt)
      {
        // Byte code:
        //   0: ldc 75
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 36
        //   17: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: iload_1
        //   22: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   25: aload_0
        //   26: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
        //   29: bipush 33
        //   31: aload_3
        //   32: aload 4
        //   34: iconst_0
        //   35: invokeinterface 53 5 0
        //   40: pop
        //   41: aload 4
        //   43: invokevirtual 56	android/os/Parcel:readException	()V
        //   46: aload 4
        //   48: invokevirtual 60	android/os/Parcel:readInt	()I
        //   51: ifeq +33 -> 84
        //   54: getstatic 81	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   57: aload 4
        //   59: invokeinterface 87 2 0
        //   64: checkcast 77	android/os/Bundle
        //   67: astore_2
        //   68: aload 4
        //   70: invokevirtual 63	android/os/Parcel:recycle	()V
        //   73: aload_3
        //   74: invokevirtual 63	android/os/Parcel:recycle	()V
        //   77: ldc 75
        //   79: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   82: aload_2
        //   83: areturn
        //   84: aconst_null
        //   85: astore_2
        //   86: goto -18 -> 68
        //   89: astore_2
        //   90: aload 4
        //   92: invokevirtual 63	android/os/Parcel:recycle	()V
        //   95: aload_3
        //   96: invokevirtual 63	android/os/Parcel:recycle	()V
        //   99: ldc 75
        //   101: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   104: aload_2
        //   105: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	106	0	this	a
        //   0	106	1	paramInt	int
        //   67	19	2	localBundle	Bundle
        //   89	16	2	localObject	Object
        //   8	88	3	localParcel1	Parcel
        //   12	79	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	68	89	finally
      }
      
      public final boolean Vt(int paramInt)
      {
        boolean bool = false;
        AppMethodBeat.i(79462);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(34, localParcel1, localParcel2, 0);
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
      
      public final void Vu(int paramInt)
      {
        AppMethodBeat.i(79463);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(35, localParcel1, localParcel2, 0);
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
      
      public final void Vv(int paramInt)
      {
        AppMethodBeat.i(79471);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(43, localParcel1, localParcel2, 0);
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
      
      public final void Vw(int paramInt)
      {
        AppMethodBeat.i(79489);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(61, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79489);
        }
      }
      
      public final void Vx(int paramInt)
      {
        AppMethodBeat.i(79487);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(59, localParcel1, localParcel2, 0);
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
      
      public final void Vy(int paramInt)
      {
        AppMethodBeat.i(79488);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(60, localParcel1, localParcel2, 0);
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
      
      public final boolean YD()
      {
        boolean bool = false;
        AppMethodBeat.i(79435);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public final void a(int paramInt1, Bundle paramBundle, int paramInt2)
      {
        // Byte code:
        //   0: ldc 105
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 4
        //   10: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 5
        //   15: aload 4
        //   17: ldc 36
        //   19: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload 4
        //   24: iload_1
        //   25: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   28: aload_2
        //   29: ifnull +60 -> 89
        //   32: aload 4
        //   34: iconst_1
        //   35: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   38: aload_2
        //   39: aload 4
        //   41: iconst_0
        //   42: invokevirtual 109	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   45: aload 4
        //   47: iload_3
        //   48: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   51: aload_0
        //   52: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
        //   55: bipush 14
        //   57: aload 4
        //   59: aload 5
        //   61: iconst_0
        //   62: invokeinterface 53 5 0
        //   67: pop
        //   68: aload 5
        //   70: invokevirtual 56	android/os/Parcel:readException	()V
        //   73: aload 5
        //   75: invokevirtual 63	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 63	android/os/Parcel:recycle	()V
        //   83: ldc 105
        //   85: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   88: return
        //   89: aload 4
        //   91: iconst_0
        //   92: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   95: goto -50 -> 45
        //   98: astore_2
        //   99: aload 5
        //   101: invokevirtual 63	android/os/Parcel:recycle	()V
        //   104: aload 4
        //   106: invokevirtual 63	android/os/Parcel:recycle	()V
        //   109: ldc 105
        //   111: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   114: aload_2
        //   115: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	116	0	this	a
        //   0	116	1	paramInt1	int
        //   0	116	2	paramBundle	Bundle
        //   0	116	3	paramInt2	int
        //   8	97	4	localParcel1	Parcel
        //   13	87	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	28	98	finally
        //   32	45	98	finally
        //   45	73	98	finally
        //   89	95	98	finally
      }
      
      /* Error */
      public final void a(Bundle paramBundle, int paramInt)
      {
        // Byte code:
        //   0: ldc 111
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 36
        //   17: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +55 -> 76
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   29: aload_1
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 109	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_3
        //   36: iload_2
        //   37: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   40: aload_0
        //   41: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
        //   44: bipush 75
        //   46: aload_3
        //   47: aload 4
        //   49: iconst_0
        //   50: invokeinterface 53 5 0
        //   55: pop
        //   56: aload 4
        //   58: invokevirtual 56	android/os/Parcel:readException	()V
        //   61: aload 4
        //   63: invokevirtual 63	android/os/Parcel:recycle	()V
        //   66: aload_3
        //   67: invokevirtual 63	android/os/Parcel:recycle	()V
        //   70: ldc 111
        //   72: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: return
        //   76: aload_3
        //   77: iconst_0
        //   78: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   81: goto -46 -> 35
        //   84: astore_1
        //   85: aload 4
        //   87: invokevirtual 63	android/os/Parcel:recycle	()V
        //   90: aload_3
        //   91: invokevirtual 63	android/os/Parcel:recycle	()V
        //   94: ldc 111
        //   96: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   99: aload_1
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	a
        //   0	101	1	paramBundle	Bundle
        //   0	101	2	paramInt	int
        //   8	83	3	localParcel1	Parcel
        //   12	74	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	20	84	finally
        //   24	35	84	finally
        //   35	61	84	finally
        //   76	81	84	finally
      }
      
      /* Error */
      public final void a(f paramf, int paramInt)
      {
        // Byte code:
        //   0: ldc 113
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 36
        //   17: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +56 -> 77
        //   24: aload_1
        //   25: invokeinterface 119 1 0
        //   30: astore_1
        //   31: aload_3
        //   32: aload_1
        //   33: invokevirtual 122	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload_3
        //   37: iload_2
        //   38: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   41: aload_0
        //   42: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
        //   45: bipush 42
        //   47: aload_3
        //   48: aload 4
        //   50: iconst_0
        //   51: invokeinterface 53 5 0
        //   56: pop
        //   57: aload 4
        //   59: invokevirtual 56	android/os/Parcel:readException	()V
        //   62: aload 4
        //   64: invokevirtual 63	android/os/Parcel:recycle	()V
        //   67: aload_3
        //   68: invokevirtual 63	android/os/Parcel:recycle	()V
        //   71: ldc 113
        //   73: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: return
        //   77: aconst_null
        //   78: astore_1
        //   79: goto -48 -> 31
        //   82: astore_1
        //   83: aload 4
        //   85: invokevirtual 63	android/os/Parcel:recycle	()V
        //   88: aload_3
        //   89: invokevirtual 63	android/os/Parcel:recycle	()V
        //   92: ldc 113
        //   94: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   97: aload_1
        //   98: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	99	0	this	a
        //   0	99	1	paramf	f
        //   0	99	2	paramInt	int
        //   8	81	3	localParcel1	Parcel
        //   12	72	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	20	82	finally
        //   24	31	82	finally
        //   31	62	82	finally
      }
      
      /* Error */
      public final void a(String paramString, Bundle paramBundle, int paramInt)
      {
        // Byte code:
        //   0: ldc 124
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 4
        //   10: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 5
        //   15: aload 4
        //   17: ldc 36
        //   19: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload 4
        //   24: aload_1
        //   25: invokevirtual 47	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   28: aload_2
        //   29: ifnull +60 -> 89
        //   32: aload 4
        //   34: iconst_1
        //   35: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   38: aload_2
        //   39: aload 4
        //   41: iconst_0
        //   42: invokevirtual 109	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   45: aload 4
        //   47: iload_3
        //   48: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   51: aload_0
        //   52: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
        //   55: bipush 38
        //   57: aload 4
        //   59: aload 5
        //   61: iconst_0
        //   62: invokeinterface 53 5 0
        //   67: pop
        //   68: aload 5
        //   70: invokevirtual 56	android/os/Parcel:readException	()V
        //   73: aload 5
        //   75: invokevirtual 63	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 63	android/os/Parcel:recycle	()V
        //   83: ldc 124
        //   85: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   88: return
        //   89: aload 4
        //   91: iconst_0
        //   92: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   95: goto -50 -> 45
        //   98: astore_1
        //   99: aload 5
        //   101: invokevirtual 63	android/os/Parcel:recycle	()V
        //   104: aload 4
        //   106: invokevirtual 63	android/os/Parcel:recycle	()V
        //   109: ldc 124
        //   111: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   114: aload_1
        //   115: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	116	0	this	a
        //   0	116	1	paramString	String
        //   0	116	2	paramBundle	Bundle
        //   0	116	3	paramInt	int
        //   8	97	4	localParcel1	Parcel
        //   13	87	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	28	98	finally
        //   32	45	98	finally
        //   45	73	98	finally
        //   89	95	98	finally
      }
      
      /* Error */
      public final void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, Bundle paramBundle)
      {
        // Byte code:
        //   0: ldc 126
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 8
        //   15: aload 7
        //   17: ldc 36
        //   19: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload 7
        //   24: aload_1
        //   25: invokevirtual 47	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   28: aload 7
        //   30: aload_2
        //   31: invokevirtual 47	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   34: aload 7
        //   36: aload_3
        //   37: invokevirtual 47	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   40: aload 7
        //   42: iload 4
        //   44: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   47: aload 7
        //   49: iload 5
        //   51: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   54: aload 6
        //   56: ifnull +55 -> 111
        //   59: aload 7
        //   61: iconst_1
        //   62: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   65: aload 6
        //   67: aload 7
        //   69: iconst_0
        //   70: invokevirtual 109	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   73: aload_0
        //   74: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
        //   77: bipush 70
        //   79: aload 7
        //   81: aload 8
        //   83: iconst_0
        //   84: invokeinterface 53 5 0
        //   89: pop
        //   90: aload 8
        //   92: invokevirtual 56	android/os/Parcel:readException	()V
        //   95: aload 8
        //   97: invokevirtual 63	android/os/Parcel:recycle	()V
        //   100: aload 7
        //   102: invokevirtual 63	android/os/Parcel:recycle	()V
        //   105: ldc 126
        //   107: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   110: return
        //   111: aload 7
        //   113: iconst_0
        //   114: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   117: goto -44 -> 73
        //   120: astore_1
        //   121: aload 8
        //   123: invokevirtual 63	android/os/Parcel:recycle	()V
        //   126: aload 7
        //   128: invokevirtual 63	android/os/Parcel:recycle	()V
        //   131: ldc 126
        //   133: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   136: aload_1
        //   137: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	138	0	this	a
        //   0	138	1	paramString1	String
        //   0	138	2	paramString2	String
        //   0	138	3	paramString3	String
        //   0	138	4	paramInt1	int
        //   0	138	5	paramInt2	int
        //   0	138	6	paramBundle	Bundle
        //   8	119	7	localParcel1	Parcel
        //   13	109	8	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	54	120	finally
        //   59	73	120	finally
        //   73	95	120	finally
        //   111	117	120	finally
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
          this.mRemote.transact(68, localParcel1, localParcel2, 0);
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
        boolean bool = true;
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
                this.mRemote.transact(36, localParcel1, localParcel2, 0);
                localParcel2.readException();
                paramInt = localParcel2.readInt();
                if (paramInt == 0) {
                  break label176;
                }
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
          continue;
          label176:
          bool = false;
        }
      }
      
      public final boolean a(String paramString, boolean paramBoolean, Bundle paramBundle)
      {
        boolean bool = true;
        AppMethodBeat.i(79453);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        label149:
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
            localParcel1.writeString(paramString);
            int i;
            if (paramBoolean)
            {
              i = 1;
              localParcel1.writeInt(i);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.mRemote.transact(25, localParcel1, localParcel2, 0);
                localParcel2.readException();
                i = localParcel2.readInt();
                if (i == 0) {
                  break label149;
                }
                paramBoolean = bool;
                return paramBoolean;
              }
            }
            else
            {
              i = 0;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
            paramBoolean = false;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
            AppMethodBeat.o(79453);
          }
        }
      }
      
      public final void aA(int paramInt1, int paramInt2, int paramInt3)
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
          this.mRemote.transact(41, localParcel1, localParcel2, 0);
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
      
      public final List<String> aCB()
      {
        AppMethodBeat.i(79451);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(23, localParcel1, localParcel2, 0);
          localParcel2.readException();
          ArrayList localArrayList = localParcel2.createStringArrayList();
          return localArrayList;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79451);
        }
      }
      
      public final boolean aCC()
      {
        boolean bool = false;
        AppMethodBeat.i(79450);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(22, localParcel1, localParcel2, 0);
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
      
      public final String aCP(String paramString)
      {
        AppMethodBeat.i(79434);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
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
      
      public final String aCQ(String paramString)
      {
        AppMethodBeat.i(79454);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(26, localParcel1, localParcel2, 0);
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
      
      public final void aCR(String paramString)
      {
        AppMethodBeat.i(79467);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(39, localParcel1, localParcel2, 0);
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
      
      public final String aCS(String paramString)
      {
        AppMethodBeat.i(79468);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(40, localParcel1, localParcel2, 0);
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
      public final boolean aCT(String paramString)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: ldc 166
        //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 4
        //   12: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   15: astore 5
        //   17: aload 4
        //   19: ldc 36
        //   21: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   24: aload 4
        //   26: aload_1
        //   27: invokevirtual 47	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   30: aload_0
        //   31: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
        //   34: iconst_1
        //   35: aload 4
        //   37: aload 5
        //   39: iconst_0
        //   40: invokeinterface 53 5 0
        //   45: pop
        //   46: aload 5
        //   48: invokevirtual 56	android/os/Parcel:readException	()V
        //   51: aload 5
        //   53: invokevirtual 60	android/os/Parcel:readInt	()I
        //   56: istore_2
        //   57: iload_2
        //   58: ifeq +20 -> 78
        //   61: aload 5
        //   63: invokevirtual 63	android/os/Parcel:recycle	()V
        //   66: aload 4
        //   68: invokevirtual 63	android/os/Parcel:recycle	()V
        //   71: ldc 166
        //   73: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: iload_3
        //   77: ireturn
        //   78: iconst_0
        //   79: istore_3
        //   80: goto -19 -> 61
        //   83: astore_1
        //   84: aload 5
        //   86: invokevirtual 63	android/os/Parcel:recycle	()V
        //   89: aload 4
        //   91: invokevirtual 63	android/os/Parcel:recycle	()V
        //   94: ldc 166
        //   96: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   99: aload_1
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	a
        //   0	101	1	paramString	String
        //   56	2	2	i	int
        //   1	79	3	bool	boolean
        //   10	80	4	localParcel1	Parcel
        //   15	70	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   17	57	83	finally
      }
      
      public final String aCU(String paramString)
      {
        AppMethodBeat.i(79476);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(48, localParcel1, localParcel2, 0);
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
      
      public final void aCV(String paramString)
      {
        AppMethodBeat.i(79479);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(51, localParcel1, localParcel2, 0);
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
      
      public final int aCW(String paramString)
      {
        AppMethodBeat.i(79445);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(17, localParcel1, localParcel2, 0);
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
      
      public final void aCX(String paramString)
      {
        AppMethodBeat.i(79449);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(21, localParcel1, localParcel2, 0);
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
      
      public final void aCY(String paramString)
      {
        AppMethodBeat.i(79497);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(69, localParcel1, localParcel2, 0);
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
      
      public final String aCZ(String paramString)
      {
        AppMethodBeat.i(79492);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(64, localParcel1, localParcel2, 0);
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
      
      public final String aCl(String paramString)
      {
        AppMethodBeat.i(79474);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(46, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public final c aG(Bundle paramBundle)
      {
        // Byte code:
        //   0: ldc 184
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 36
        //   16: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +56 -> 76
        //   23: aload_2
        //   24: iconst_1
        //   25: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   28: aload_1
        //   29: aload_2
        //   30: iconst_0
        //   31: invokevirtual 109	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload_0
        //   35: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
        //   38: bipush 15
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokeinterface 53 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:readException	()V
        //   53: aload_3
        //   54: invokevirtual 187	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   57: invokestatic 193	com/tencent/mm/plugin/webview/stub/c$a:F	(Landroid/os/IBinder;)Lcom/tencent/mm/plugin/webview/stub/c;
        //   60: astore_1
        //   61: aload_3
        //   62: invokevirtual 63	android/os/Parcel:recycle	()V
        //   65: aload_2
        //   66: invokevirtual 63	android/os/Parcel:recycle	()V
        //   69: ldc 184
        //   71: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   74: aload_1
        //   75: areturn
        //   76: aload_2
        //   77: iconst_0
        //   78: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   81: goto -47 -> 34
        //   84: astore_1
        //   85: aload_3
        //   86: invokevirtual 63	android/os/Parcel:recycle	()V
        //   89: aload_2
        //   90: invokevirtual 63	android/os/Parcel:recycle	()V
        //   93: ldc 184
        //   95: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   98: aload_1
        //   99: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	100	0	this	a
        //   0	100	1	paramBundle	Bundle
        //   8	82	2	localParcel1	Parcel
        //   12	74	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	84	finally
        //   23	34	84	finally
        //   34	61	84	finally
        //   76	81	84	finally
      }
      
      public final boolean aH(Bundle paramBundle)
      {
        boolean bool = true;
        AppMethodBeat.i(79444);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(16, localParcel1, localParcel2, 0);
              localParcel2.readException();
              int i = localParcel2.readInt();
              if (i != 0) {
                return bool;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            bool = false;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
            AppMethodBeat.o(79444);
          }
        }
      }
      
      /* Error */
      public final void aV(Intent paramIntent)
      {
        // Byte code:
        //   0: ldc 199
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 36
        //   16: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +47 -> 67
        //   23: aload_2
        //   24: iconst_1
        //   25: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   28: aload_1
        //   29: aload_2
        //   30: iconst_0
        //   31: invokevirtual 202	android/content/Intent:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload_0
        //   35: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
        //   38: bipush 72
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokeinterface 53 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:readException	()V
        //   53: aload_3
        //   54: invokevirtual 63	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 63	android/os/Parcel:recycle	()V
        //   61: ldc 199
        //   63: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   66: return
        //   67: aload_2
        //   68: iconst_0
        //   69: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   72: goto -38 -> 34
        //   75: astore_1
        //   76: aload_3
        //   77: invokevirtual 63	android/os/Parcel:recycle	()V
        //   80: aload_2
        //   81: invokevirtual 63	android/os/Parcel:recycle	()V
        //   84: ldc 199
        //   86: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   89: aload_1
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	a
        //   0	91	1	paramIntent	Intent
        //   8	73	2	localParcel1	Parcel
        //   12	65	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	75	finally
        //   23	34	75	finally
        //   34	53	75	finally
        //   67	72	75	finally
      }
      
      public final void ac(String paramString1, String paramString2, int paramInt)
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
          this.mRemote.transact(37, localParcel1, localParcel2, 0);
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
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final boolean ayd()
      {
        boolean bool = false;
        AppMethodBeat.i(79438);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
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
      
      public final void cj(String paramString, boolean paramBoolean)
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
          this.mRemote.transact(28, localParcel1, localParcel2, 0);
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
      
      public final String cy(int paramInt, String paramString)
      {
        AppMethodBeat.i(79441);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
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
      
      public final boolean eCC()
      {
        boolean bool = false;
        AppMethodBeat.i(79437);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
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
      
      public final String[] eCD()
      {
        AppMethodBeat.i(79472);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(44, localParcel1, localParcel2, 0);
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
      
      public final String eCE()
      {
        AppMethodBeat.i(79473);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(45, localParcel1, localParcel2, 0);
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
      
      public final String eCF()
      {
        AppMethodBeat.i(79475);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(47, localParcel1, localParcel2, 0);
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
      
      public final String eCG()
      {
        AppMethodBeat.i(79482);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(54, localParcel1, localParcel2, 0);
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
      
      public final Map eCH()
      {
        AppMethodBeat.i(79477);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(49, localParcel1, localParcel2, 0);
          localParcel2.readException();
          HashMap localHashMap = localParcel2.readHashMap(getClass().getClassLoader());
          return localHashMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79477);
        }
      }
      
      public final int eCI()
      {
        AppMethodBeat.i(79483);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(55, localParcel1, localParcel2, 0);
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
      
      public final int eCJ()
      {
        AppMethodBeat.i(79484);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(56, localParcel1, localParcel2, 0);
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
      
      public final void eCK()
      {
        AppMethodBeat.i(79485);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(57, localParcel1, localParcel2, 0);
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
      
      public final void eCL()
      {
        AppMethodBeat.i(79486);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(58, localParcel1, localParcel2, 0);
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
      
      public final boolean eCM()
      {
        boolean bool = false;
        AppMethodBeat.i(79491);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(63, localParcel1, localParcel2, 0);
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
      
      public final boolean eCN()
      {
        boolean bool = false;
        AppMethodBeat.i(79494);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(66, localParcel1, localParcel2, 0);
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
      
      public final boolean eCO()
      {
        boolean bool = false;
        AppMethodBeat.i(79493);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(65, localParcel1, localParcel2, 0);
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
      
      public final List<String> eCP()
      {
        AppMethodBeat.i(79502);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(74, localParcel1, localParcel2, 0);
          localParcel2.readException();
          ArrayList localArrayList = localParcel2.createStringArrayList();
          return localArrayList;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79502);
        }
      }
      
      public final int eCQ()
      {
        AppMethodBeat.i(79504);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(76, localParcel1, localParcel2, 0);
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
      
      public final boolean eCR()
      {
        boolean bool = false;
        AppMethodBeat.i(79495);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(67, localParcel1, localParcel2, 0);
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
      
      public final String[] eCS()
      {
        AppMethodBeat.i(79505);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(77, localParcel1, localParcel2, 0);
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
      
      public final boolean eJ(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(79457);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(29, localParcel1, localParcel2, 0);
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
      
      public final void favEditTag()
      {
        AppMethodBeat.i(79446);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(18, localParcel1, localParcel2, 0);
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
      
      public final void fo(String paramString, int paramInt)
      {
        AppMethodBeat.i(79455);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(27, localParcel1, localParcel2, 0);
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
      
      public final String fp(String paramString, int paramInt)
      {
        AppMethodBeat.i(79480);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(52, localParcel1, localParcel2, 0);
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
      
      public final void fq(String paramString, int paramInt)
      {
        AppMethodBeat.i(79490);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(62, localParcel1, localParcel2, 0);
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
      
      public final String getLanguage()
      {
        AppMethodBeat.i(79481);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(53, localParcel1, localParcel2, 0);
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
      
      public final int iN(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(79439);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
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
      
      public final void iO(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(79440);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
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
      
      public final boolean isSDCardAvailable()
      {
        boolean bool = false;
        AppMethodBeat.i(79436);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
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
      
      public final Bundle k(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(79499);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
            localParcel1.writeInt(paramInt);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(71, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramBundle;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramBundle = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
            AppMethodBeat.o(79499);
          }
        }
      }
      
      public final String kB(String paramString1, String paramString2)
      {
        AppMethodBeat.i(79478);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(50, localParcel1, localParcel2, 0);
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
          this.mRemote.transact(32, localParcel1, localParcel2, 0);
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
      
      public final void o(int paramInt, List<String> paramList)
      {
        AppMethodBeat.i(79452);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeInt(paramInt);
          localParcel1.writeStringList(paramList);
          this.mRemote.transact(24, localParcel1, localParcel2, 0);
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
      
      public final Bundle t(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(79459);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
            localParcel1.writeInt(paramInt);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(31, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramBundle;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramBundle = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
            AppMethodBeat.o(79459);
          }
        }
      }
      
      /* Error */
      public final void v(int paramInt, Bundle paramBundle)
      {
        // Byte code:
        //   0: ldc_w 309
        //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   6: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore_3
        //   10: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 4
        //   15: aload_3
        //   16: ldc 36
        //   18: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   21: aload_3
        //   22: iload_1
        //   23: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   26: aload_2
        //   27: ifnull +51 -> 78
        //   30: aload_3
        //   31: iconst_1
        //   32: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokevirtual 109	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   41: aload_0
        //   42: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
        //   45: bipush 78
        //   47: aload_3
        //   48: aload 4
        //   50: iconst_0
        //   51: invokeinterface 53 5 0
        //   56: pop
        //   57: aload 4
        //   59: invokevirtual 56	android/os/Parcel:readException	()V
        //   62: aload 4
        //   64: invokevirtual 63	android/os/Parcel:recycle	()V
        //   67: aload_3
        //   68: invokevirtual 63	android/os/Parcel:recycle	()V
        //   71: ldc_w 309
        //   74: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   77: return
        //   78: aload_3
        //   79: iconst_0
        //   80: invokevirtual 72	android/os/Parcel:writeInt	(I)V
        //   83: goto -42 -> 41
        //   86: astore_2
        //   87: aload 4
        //   89: invokevirtual 63	android/os/Parcel:recycle	()V
        //   92: aload_3
        //   93: invokevirtual 63	android/os/Parcel:recycle	()V
        //   96: ldc_w 309
        //   99: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   102: aload_2
        //   103: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	104	0	this	a
        //   0	104	1	paramInt	int
        //   0	104	2	paramBundle	Bundle
        //   9	84	3	localParcel1	Parcel
        //   13	75	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	26	86	finally
        //   30	41	86	finally
        //   41	62	86	finally
        //   78	83	86	finally
      }
      
      public final Bundle w(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(79458);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
            localParcel1.writeInt(paramInt);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(30, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramBundle;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramBundle = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
            AppMethodBeat.o(79458);
          }
        }
      }
      
      public final boolean wG(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(79431);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
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
      
      public final boolean wH(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(79433);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
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
      
      public final String wk(String paramString)
      {
        AppMethodBeat.i(79430);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
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
      
      public final boolean x(int paramInt, Bundle paramBundle)
      {
        boolean bool = true;
        AppMethodBeat.i(79447);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
            localParcel1.writeInt(paramInt);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(19, localParcel1, localParcel2, 0);
              localParcel2.readException();
              paramInt = localParcel2.readInt();
              if (paramInt != 0) {
                return bool;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            bool = false;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
            AppMethodBeat.o(79447);
          }
        }
      }
      
      public final boolean xr(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(79432);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.e
 * JD-Core Version:    0.7.0.1
 */