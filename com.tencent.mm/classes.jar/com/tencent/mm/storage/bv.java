package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.storage.IStorageEx;
import java.util.List;

public abstract interface bv
  extends IStorageEx
{
  public abstract int B(String paramString, byte[] paramArrayOfByte);
  
  public abstract as Kn(String paramString);
  
  public abstract as Nh(long paramLong);
  
  public abstract Cursor a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract Cursor a(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract Cursor a(String[] paramArrayOfString, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2);
  
  public abstract Cursor a(String[] paramArrayOfString, String paramString, List<String> paramList);
  
  public abstract void a(a parama);
  
  public abstract int aNa(String paramString);
  
  public abstract String aZD();
  
  public abstract void am(as paramas);
  
  public abstract boolean an(as paramas);
  
  public abstract boolean ao(as paramas);
  
  public abstract boolean ap(as paramas);
  
  public abstract int aq(as paramas);
  
  public abstract void ayf(String paramString);
  
  public abstract Cursor b(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract Cursor b(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract void b(a parama);
  
  public abstract int[] b(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList);
  
  public abstract int[] b(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList);
  
  public abstract as bjF(String paramString);
  
  public abstract boolean bjG(String paramString);
  
  public abstract as bjH(String paramString);
  
  public abstract Cursor bjI(String paramString);
  
  public abstract as bjJ(String paramString);
  
  public abstract as bjK(String paramString);
  
  public abstract as bjL(String paramString);
  
  public abstract long bjM(String paramString);
  
  public abstract boolean bjN(String paramString);
  
  public abstract boolean bjO(String paramString);
  
  public abstract byte[] bjP(String paramString);
  
  public abstract int bjQ(String paramString);
  
  public abstract String bjR(String paramString);
  
  public abstract int bjS(String paramString);
  
  public abstract String bjT(String paramString);
  
  public abstract int c(String paramString, as paramas);
  
  public abstract int c(String[] paramArrayOfString1, String... paramVarArgs);
  
  public abstract Cursor c(String paramString1, String paramString2, List<String> paramList);
  
  public abstract Cursor c(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract int[] c(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList);
  
  public abstract int[] c(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList);
  
  public abstract int ce(String paramString, long paramLong);
  
  public abstract int d(String paramString, as paramas);
  
  public abstract int d(String[] paramArrayOfString1, String... paramVarArgs);
  
  public abstract Cursor d(String paramString1, String paramString2, List<String> paramList);
  
  public abstract Cursor d(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList);
  
  public abstract void d(as paramas, boolean paramBoolean);
  
  public abstract Cursor e(String paramString1, String paramString2, List<String> paramList);
  
  public abstract void e(String paramString, as paramas);
  
  public abstract String f(String paramString1, String paramString2, List<String> paramList);
  
  public abstract List<String> gBY();
  
  public abstract List<String> gBZ();
  
  public abstract Cursor gCa();
  
  public abstract Cursor gCb();
  
  public abstract Cursor gCc();
  
  public abstract Cursor gCd();
  
  public abstract int gCe();
  
  public abstract int gCn();
  
  public abstract Cursor gCo();
  
  public abstract Cursor gCp();
  
  public abstract Cursor gCq();
  
  public abstract Cursor iJ(List<String> paramList);
  
  public abstract Cursor iK(List<String> paramList);
  
  public abstract Cursor iL(List<String> paramList);
  
  public abstract Cursor iM(List<String> paramList);
  
  public abstract Cursor iP(List<String> paramList);
  
  public abstract Cursor iQ(List<String> paramList);
  
  public abstract Cursor iR(List<String> paramList);
  
  public abstract Cursor iS(List<String> paramList);
  
  public abstract Cursor iT(List<String> paramList);
  
  public abstract List<String> iU(List<String> paramList);
  
  public abstract int[] iV(List<String> paramList);
  
  public abstract int[] iW(List<String> paramList);
  
  public abstract Cursor mR(String paramString1, String paramString2);
  
  public abstract int mS(String paramString1, String paramString2);
  
  public abstract Cursor x(List<String> paramList, boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract as Kn(String paramString);
    
    public abstract void a(bv parambv, as paramas);
    
    public abstract int b(as paramas, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bv
 * JD-Core Version:    0.7.0.1
 */