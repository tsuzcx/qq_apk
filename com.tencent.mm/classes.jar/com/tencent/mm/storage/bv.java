package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.observer.ILifecycleObserverOwner;
import com.tencent.mm.sdk.storage.IStorageEx;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import java.util.List;

public abstract interface bv
  extends ILifecycleObserverOwner<IStorageObserver<Object>, StorageObserverEvent<Object>>, IStorageEx
{
  public abstract int G(String paramString, byte[] paramArrayOfByte);
  
  public abstract as RG(String paramString);
  
  public abstract as UT(long paramLong);
  
  public abstract Cursor a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract Cursor a(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract Cursor a(String[] paramArrayOfString, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2);
  
  public abstract Cursor a(String[] paramArrayOfString, String paramString, List<String> paramList);
  
  public abstract void a(a parama);
  
  public abstract void aHy(String paramString);
  
  public abstract void as(as paramas);
  
  public abstract boolean at(as paramas);
  
  public abstract boolean au(as paramas);
  
  public abstract boolean av(as paramas);
  
  public abstract int aw(as paramas);
  
  public abstract Cursor b(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract Cursor b(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract void b(a parama);
  
  public abstract int[] b(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList);
  
  public abstract int[] b(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList);
  
  public abstract String biT();
  
  public abstract as bwc(String paramString);
  
  public abstract boolean bwd(String paramString);
  
  public abstract as bwe(String paramString);
  
  public abstract Cursor bwf(String paramString);
  
  public abstract as bwg(String paramString);
  
  public abstract as bwh(String paramString);
  
  public abstract as bwj(String paramString);
  
  public abstract long bwk(String paramString);
  
  public abstract boolean bwl(String paramString);
  
  public abstract boolean bwm(String paramString);
  
  public abstract byte[] bwn(String paramString);
  
  public abstract int bwo(String paramString);
  
  public abstract int bwp(String paramString);
  
  public abstract String bwq(String paramString);
  
  public abstract int bwr(String paramString);
  
  public abstract String bws(String paramString);
  
  public abstract int c(String paramString, as paramas);
  
  public abstract int c(String[] paramArrayOfString1, String... paramVarArgs);
  
  public abstract Cursor c(List<String> paramList1, String paramString, List<String> paramList2);
  
  public abstract int[] c(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList);
  
  public abstract int[] c(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList);
  
  public abstract int cl(String paramString, long paramLong);
  
  public abstract int d(String paramString, as paramas);
  
  public abstract int d(String[] paramArrayOfString1, String... paramVarArgs);
  
  public abstract Cursor d(String paramString1, String paramString2, List<String> paramList);
  
  public abstract Cursor d(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList);
  
  public abstract void d(as paramas, boolean paramBoolean);
  
  public abstract Cursor e(String paramString1, String paramString2, List<String> paramList);
  
  public abstract void e(String paramString, as paramas);
  
  public abstract Cursor f(String paramString1, String paramString2, List<String> paramList);
  
  public abstract String g(String paramString1, String paramString2, List<String> paramList);
  
  public abstract Cursor hyA();
  
  public abstract Cursor hyB();
  
  public abstract Cursor hyC();
  
  public abstract Cursor hyD();
  
  public abstract List<String> hyk();
  
  public abstract List<String> hyl();
  
  public abstract Cursor hym();
  
  public abstract Cursor hyn();
  
  public abstract Cursor hyo();
  
  public abstract Cursor hyp();
  
  public abstract int hyq();
  
  public abstract int hyz();
  
  public abstract Cursor jB(List<String> paramList);
  
  public abstract Cursor jC(List<String> paramList);
  
  public abstract Cursor jD(List<String> paramList);
  
  public abstract Cursor jE(List<String> paramList);
  
  public abstract Cursor jH(List<String> paramList);
  
  public abstract Cursor jI(List<String> paramList);
  
  public abstract Cursor jJ(List<String> paramList);
  
  public abstract Cursor jK(List<String> paramList);
  
  public abstract Cursor jL(List<String> paramList);
  
  public abstract List<String> jM(List<String> paramList);
  
  public abstract int[] jN(List<String> paramList);
  
  public abstract int[] jO(List<String> paramList);
  
  public abstract Cursor nI(String paramString1, String paramString2);
  
  public abstract int nJ(String paramString1, String paramString2);
  
  public abstract Cursor z(List<String> paramList, boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract as RG(String paramString);
    
    public abstract void a(bv parambv, as paramas);
    
    public abstract int b(as paramas, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bv
 * JD-Core Version:    0.7.0.1
 */