package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.h;
import java.util.List;

public abstract interface bd
  extends h
{
  public abstract int F(String paramString, byte[] paramArrayOfByte);
  
  public abstract void V(ad paramad);
  
  public abstract boolean W(ad paramad);
  
  public abstract boolean X(ad paramad);
  
  public abstract boolean Y(ad paramad);
  
  public abstract int Z(ad paramad);
  
  public abstract Cursor a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract Cursor a(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract Cursor a(String[] paramArrayOfString, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2);
  
  public abstract Cursor a(String[] paramArrayOfString, String paramString, List<String> paramList);
  
  public abstract void a(a parama);
  
  public abstract String aeK();
  
  public abstract byte[] arA(String paramString);
  
  public abstract int arB(String paramString);
  
  public abstract int arC(String paramString);
  
  public abstract String arD(String paramString);
  
  public abstract ad arq(String paramString);
  
  public abstract boolean arr(String paramString);
  
  public abstract ad ars(String paramString);
  
  public abstract Cursor art(String paramString);
  
  public abstract ad aru(String paramString);
  
  public abstract ad arv(String paramString);
  
  public abstract ad arw(String paramString);
  
  public abstract long arx(String paramString);
  
  public abstract boolean ary(String paramString);
  
  public abstract boolean arz(String paramString);
  
  public abstract int b(String paramString, ad paramad);
  
  public abstract int b(String[] paramArrayOfString1, String... paramVarArgs);
  
  public abstract Cursor b(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract Cursor b(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract void b(a parama);
  
  public abstract int[] b(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList);
  
  public abstract int c(String paramString, ad paramad);
  
  public abstract int c(String[] paramArrayOfString1, String... paramVarArgs);
  
  public abstract Cursor c(String paramString1, String paramString2, List<String> paramList);
  
  public abstract Cursor c(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract int[] c(String paramString1, String paramString2, String paramString3, List<String> paramList);
  
  public abstract int[] c(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList);
  
  public abstract Cursor d(String paramString1, String paramString2, List<String> paramList);
  
  public abstract void d(String paramString, ad paramad);
  
  public abstract int[] d(String paramString1, String paramString2, String paramString3, List<String> paramList);
  
  public abstract List<String> dwK();
  
  public abstract List<String> dwL();
  
  public abstract Cursor dwM();
  
  public abstract Cursor dwN();
  
  public abstract Cursor dwO();
  
  public abstract Cursor dwP();
  
  public abstract int dwQ();
  
  public abstract Cursor dwZ();
  
  public abstract Cursor dxa();
  
  public abstract Cursor dxb();
  
  public abstract Cursor e(String paramString1, String paramString2, List<String> paramList);
  
  public abstract Cursor eC(List<String> paramList);
  
  public abstract Cursor eD(List<String> paramList);
  
  public abstract Cursor eE(List<String> paramList);
  
  public abstract Cursor eF(List<String> paramList);
  
  public abstract Cursor eI(List<String> paramList);
  
  public abstract Cursor eJ(List<String> paramList);
  
  public abstract Cursor eK(List<String> paramList);
  
  public abstract Cursor eL(List<String> paramList);
  
  public abstract List<String> eM(List<String> paramList);
  
  public abstract int[] eN(List<String> paramList);
  
  public abstract int[] eO(List<String> paramList);
  
  public abstract String f(String paramString1, String paramString2, List<String> paramList);
  
  public abstract Cursor m(List<String> paramList, boolean paramBoolean);
  
  public abstract ad on(long paramLong);
  
  public static abstract interface a
  {
    public abstract void a(bd parambd, ad paramad);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bd
 * JD-Core Version:    0.7.0.1
 */