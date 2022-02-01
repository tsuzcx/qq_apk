package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.storage.IStorageEx;
import com.tencent.mm.vending.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract interface bw
  extends IStorageEx
{
  public abstract int a(az paramaz, String paramString);
  
  public abstract int a(az paramaz, String paramString, boolean paramBoolean);
  
  public abstract Cursor a(int paramInt, List<String> paramList, String paramString);
  
  public abstract Cursor a(int paramInt, List<String> paramList, String paramString1, boolean paramBoolean, String paramString2);
  
  public abstract Cursor a(List<String> paramList1, int paramInt, List<String> paramList2, String paramString1, boolean paramBoolean, String paramString2);
  
  public abstract b a(com.tencent.mm.plugin.messenger.foundation.a.i parami);
  
  public abstract void a(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc);
  
  public abstract void a(h paramh);
  
  public abstract void a(az paramaz, int paramInt1, int paramInt2);
  
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract boolean aHD(String paramString);
  
  public abstract boolean aaL(String paramString);
  
  public abstract b abK();
  
  public abstract Cursor asE(int paramInt);
  
  public abstract Cursor b(ArrayList<String> paramArrayList, List<String> paramList, String paramString);
  
  public abstract void b(com.tencent.mm.plugin.messenger.foundation.a.i parami);
  
  public abstract void b(a parama);
  
  public abstract void br(ca paramca);
  
  public abstract boolean bwA(String paramString);
  
  public abstract boolean bwB(String paramString);
  
  public abstract boolean bwC(String paramString);
  
  public abstract boolean bwD(String paramString);
  
  public abstract boolean bwE(String paramString);
  
  public abstract boolean bwF(String paramString);
  
  public abstract Cursor bwG(String paramString);
  
  public abstract Cursor bwH(String paramString);
  
  public abstract int bwI(String paramString);
  
  public abstract String bwJ(String paramString);
  
  public abstract int bwK(String paramString);
  
  public abstract az bwL(String paramString);
  
  public abstract int bwM(String paramString);
  
  public abstract void bwN(String paramString);
  
  public abstract void bwO(String paramString);
  
  public abstract int bwP(String paramString);
  
  public abstract void bwv(String paramString);
  
  public abstract boolean bww(String paramString);
  
  public abstract az bwx(String paramString);
  
  public abstract void bwy(String paramString);
  
  public abstract boolean bwz(String paramString);
  
  public abstract void c(a parama);
  
  public abstract void c(String[] paramArrayOfString, String paramString);
  
  public abstract void ch(LinkedList<String> paramLinkedList);
  
  public abstract Cursor d(List<String> paramList, String paramString, boolean paramBoolean);
  
  public abstract String dj(int paramInt, String paramString);
  
  public abstract long e(az paramaz);
  
  public abstract boolean g(az paramaz);
  
  public abstract Cursor h(List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract boolean h(az paramaz);
  
  public abstract boolean hyF();
  
  public abstract HashMap<String, Long> hyG();
  
  public abstract void hyH();
  
  public abstract List<String> hyI();
  
  public abstract List<String> hyJ();
  
  public abstract Cursor hyK();
  
  public abstract int hyL();
  
  public abstract String hyM();
  
  public abstract Cursor hyN();
  
  public abstract Cursor hyO();
  
  public abstract Cursor nK(String paramString1, String paramString2);
  
  public abstract Cursor nL(String paramString1, String paramString2);
  
  public static abstract interface a
  {
    public abstract void a(az paramaz, bw parambw);
  }
  
  public static abstract interface b
  {
    public abstract String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext);
    
    public abstract void a(ca paramca, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bw
 * JD-Core Version:    0.7.0.1
 */