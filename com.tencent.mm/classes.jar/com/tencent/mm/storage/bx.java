package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.observer.IMvvmObserverOwner;
import com.tencent.mm.sdk.storage.IStorageEx;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import java.util.List;

public abstract interface bx
  extends IMvvmObserverOwner<IStorageObserver<au>, StorageObserverEvent<au>>, IStorageEx
{
  public abstract au JE(String paramString);
  
  public abstract int K(String paramString, byte[] paramArrayOfByte);
  
  public abstract Cursor O(List<String> paramList, boolean paramBoolean);
  
  public abstract Cursor a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract Cursor a(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract Cursor a(String[] paramArrayOfString, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2);
  
  public abstract Cursor a(String[] paramArrayOfString, String paramString, List<String> paramList);
  
  public abstract void a(a parama);
  
  public abstract boolean aA(au paramau);
  
  public abstract boolean aB(au paramau);
  
  public abstract int aC(au paramau);
  
  public abstract void aDW(String paramString);
  
  public abstract void ay(au paramau);
  
  public abstract Cursor ayT(int paramInt);
  
  public abstract boolean az(au paramau);
  
  public abstract Cursor b(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract Cursor b(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract void b(a parama);
  
  public abstract int[] b(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList);
  
  public abstract int[] b(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList);
  
  public abstract String bGD();
  
  public abstract byte[] bxA(String paramString);
  
  public abstract int bxB(String paramString);
  
  public abstract int bxC(String paramString);
  
  public abstract String bxD(String paramString);
  
  public abstract int bxG(String paramString);
  
  public abstract String bxH(String paramString);
  
  public abstract au bxq(String paramString);
  
  public abstract boolean bxr(String paramString);
  
  public abstract au bxs(String paramString);
  
  public abstract Cursor bxt(String paramString);
  
  public abstract au bxu(String paramString);
  
  public abstract au bxv(String paramString);
  
  public abstract au bxw(String paramString);
  
  public abstract long bxx(String paramString);
  
  public abstract boolean bxy(String paramString);
  
  public abstract boolean bxz(String paramString);
  
  public abstract Cursor c(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract int[] c(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList);
  
  public abstract int[] c(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList);
  
  public abstract int cx(String paramString, long paramLong);
  
  public abstract int d(String paramString, au paramau);
  
  public abstract int d(String[] paramArrayOfString1, String... paramVarArgs);
  
  public abstract Cursor d(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList);
  
  public abstract void d(au paramau, boolean paramBoolean);
  
  public abstract int e(String paramString, au paramau);
  
  public abstract int e(String[] paramArrayOfString1, String... paramVarArgs);
  
  public abstract Cursor f(String paramString1, String paramString2, List<String> paramList);
  
  public abstract void f(String paramString, au paramau);
  
  public abstract Cursor g(String paramString1, String paramString2, List<String> paramList);
  
  public abstract Cursor h(String paramString1, String paramString2, List<String> paramList);
  
  public abstract String i(String paramString1, String paramString2, List<String> paramList);
  
  public abstract List<String> iZS();
  
  public abstract List<String> iZT();
  
  public abstract Cursor iZU();
  
  public abstract Cursor iZV();
  
  public abstract Cursor iZW();
  
  public abstract int iZX();
  
  public abstract int jaE();
  
  public abstract Cursor jaF();
  
  public abstract Cursor jaG();
  
  public abstract Cursor jaH();
  
  public abstract Cursor jaI();
  
  public abstract Cursor mO(List<String> paramList);
  
  public abstract Cursor mP(List<String> paramList);
  
  public abstract Cursor mQ(List<String> paramList);
  
  public abstract Cursor mR(List<String> paramList);
  
  public abstract Cursor mU(List<String> paramList);
  
  public abstract Cursor mV(List<String> paramList);
  
  public abstract Cursor mW(List<String> paramList);
  
  public abstract Cursor mX(List<String> paramList);
  
  public abstract Cursor mY(List<String> paramList);
  
  public abstract List<String> mZ(List<String> paramList);
  
  public abstract int[] na(List<String> paramList);
  
  public abstract int[] nb(List<String> paramList);
  
  public abstract Cursor pH(String paramString1, String paramString2);
  
  public abstract int pI(String paramString1, String paramString2);
  
  public abstract au zc(long paramLong);
  
  public static abstract interface a
  {
    public abstract au JE(String paramString);
    
    public abstract void a(bx parambx, au paramau);
    
    public abstract int b(au paramau, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bx
 * JD-Core Version:    0.7.0.1
 */