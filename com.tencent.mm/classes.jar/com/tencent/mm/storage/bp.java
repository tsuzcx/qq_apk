package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.h;
import java.util.List;

public abstract interface bp
  extends h
{
  public abstract int B(String paramString, byte[] paramArrayOfByte);
  
  public abstract am Bf(String paramString);
  
  public abstract am DE(long paramLong);
  
  public abstract Cursor a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract Cursor a(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract Cursor a(String[] paramArrayOfString, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2);
  
  public abstract Cursor a(String[] paramArrayOfString, String paramString, List<String> paramList);
  
  public abstract void a(a parama);
  
  public abstract String aFv();
  
  public abstract am aTf(String paramString);
  
  public abstract boolean aTg(String paramString);
  
  public abstract am aTh(String paramString);
  
  public abstract Cursor aTi(String paramString);
  
  public abstract am aTj(String paramString);
  
  public abstract am aTk(String paramString);
  
  public abstract am aTl(String paramString);
  
  public abstract long aTm(String paramString);
  
  public abstract boolean aTn(String paramString);
  
  public abstract boolean aTo(String paramString);
  
  public abstract byte[] aTp(String paramString);
  
  public abstract int aTq(String paramString);
  
  public abstract int aTr(String paramString);
  
  public abstract String aTs(String paramString);
  
  public abstract int aTt(String paramString);
  
  public abstract String aTu(String paramString);
  
  public abstract void ad(am paramam);
  
  public abstract boolean ae(am paramam);
  
  public abstract boolean af(am paramam);
  
  public abstract boolean ag(am paramam);
  
  public abstract int ah(am paramam);
  
  public abstract void akd(String paramString);
  
  public abstract Cursor b(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract Cursor b(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract void b(a parama);
  
  public abstract int[] b(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList);
  
  public abstract int[] b(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList);
  
  public abstract int c(String paramString, am paramam);
  
  public abstract int c(String[] paramArrayOfString1, String... paramVarArgs);
  
  public abstract Cursor c(String paramString1, String paramString2, List<String> paramList);
  
  public abstract Cursor c(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract int[] c(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList);
  
  public abstract int[] c(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList);
  
  public abstract int ci(String paramString, long paramLong);
  
  public abstract int d(String paramString, am paramam);
  
  public abstract int d(String[] paramArrayOfString1, String... paramVarArgs);
  
  public abstract Cursor d(String paramString1, String paramString2, List<String> paramList);
  
  public abstract Cursor d(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList);
  
  public abstract void d(am paramam, boolean paramBoolean);
  
  public abstract Cursor e(String paramString1, String paramString2, List<String> paramList);
  
  public abstract void e(String paramString, am paramam);
  
  public abstract String f(String paramString1, String paramString2, List<String> paramList);
  
  public abstract Cursor fqH();
  
  public abstract Cursor fqI();
  
  public abstract Cursor fqJ();
  
  public abstract List<String> fqs();
  
  public abstract List<String> fqt();
  
  public abstract Cursor fqu();
  
  public abstract Cursor fqv();
  
  public abstract Cursor fqw();
  
  public abstract Cursor fqx();
  
  public abstract int fqy();
  
  public abstract Cursor hB(List<String> paramList);
  
  public abstract Cursor hC(List<String> paramList);
  
  public abstract Cursor hD(List<String> paramList);
  
  public abstract Cursor hE(List<String> paramList);
  
  public abstract Cursor hF(List<String> paramList);
  
  public abstract List<String> hG(List<String> paramList);
  
  public abstract int[] hH(List<String> paramList);
  
  public abstract int[] hI(List<String> paramList);
  
  public abstract Cursor hv(List<String> paramList);
  
  public abstract Cursor hw(List<String> paramList);
  
  public abstract Cursor hx(List<String> paramList);
  
  public abstract Cursor hy(List<String> paramList);
  
  public abstract Cursor lW(String paramString1, String paramString2);
  
  public abstract int lX(String paramString1, String paramString2);
  
  public abstract Cursor r(List<String> paramList, boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract am Bf(String paramString);
    
    public abstract void a(bp parambp, am paramam);
    
    public abstract int b(am paramam, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bp
 * JD-Core Version:    0.7.0.1
 */