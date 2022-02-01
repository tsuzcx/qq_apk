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
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract interface by
  extends IStorageEx
{
  public static final ArrayList<Integer> adkl = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(10), Integer.valueOf(66), Integer.valueOf(132) }));
  public static final ArrayList<Integer> adkm = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(10), Integer.valueOf(66), Integer.valueOf(132) }));
  public static final ArrayList<Integer> adkn = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(10), Integer.valueOf(66) }));
  
  public abstract Cursor I(List<String> paramList, String paramString);
  
  public abstract boolean Te(String paramString);
  
  public abstract String Z(int paramInt, String paramString);
  
  public abstract int a(bb parambb, String paramString, boolean paramBoolean);
  
  public abstract Cursor a(int paramInt, List<String> paramList, String paramString);
  
  public abstract Cursor a(int paramInt1, List<String> paramList, String paramString, int paramInt2);
  
  public abstract Cursor a(int paramInt, List<String> paramList, String paramString1, boolean paramBoolean, String paramString2);
  
  public abstract Cursor a(List<String> paramList1, int paramInt, List<String> paramList2, String paramString1, boolean paramBoolean, String paramString2);
  
  public abstract b a(com.tencent.mm.plugin.messenger.foundation.a.i parami);
  
  public abstract void a(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc);
  
  public abstract void a(h paramh);
  
  public abstract void a(bb parambb, int paramInt1, int paramInt2);
  
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract b aDH();
  
  public abstract boolean aEb(String paramString);
  
  public abstract Cursor ayU(int paramInt);
  
  public abstract Cursor b(ArrayList<String> paramArrayList, List<String> paramList, String paramString);
  
  public abstract void b(com.tencent.mm.plugin.messenger.foundation.a.i parami);
  
  public abstract void b(a parama);
  
  public abstract void bH(cc paramcc);
  
  public abstract void bxK(String paramString);
  
  public abstract boolean bxL(String paramString);
  
  public abstract bb bxM(String paramString);
  
  public abstract void bxN(String paramString);
  
  public abstract boolean bxO(String paramString);
  
  public abstract boolean bxP(String paramString);
  
  public abstract boolean bxQ(String paramString);
  
  public abstract boolean bxR(String paramString);
  
  public abstract boolean bxS(String paramString);
  
  public abstract boolean bxT(String paramString);
  
  public abstract boolean bxU(String paramString);
  
  public abstract boolean bxV(String paramString);
  
  public abstract boolean bxW(String paramString);
  
  public abstract Cursor bxY(String paramString);
  
  public abstract Cursor bxZ(String paramString);
  
  public abstract Cursor bya(String paramString);
  
  public abstract int byb(String paramString);
  
  public abstract String byc(String paramString);
  
  public abstract int byd(String paramString);
  
  public abstract bb bye(String paramString);
  
  public abstract int byf(String paramString);
  
  public abstract void byg(String paramString);
  
  public abstract void byh(String paramString);
  
  public abstract int byi(String paramString);
  
  public abstract int c(bb parambb, String paramString);
  
  public abstract void c(a parama);
  
  public abstract void cv(LinkedList<String> paramLinkedList);
  
  public abstract Cursor d(List<String> paramList, String paramString, boolean paramBoolean);
  
  public abstract void e(String[] paramArrayOfString, String paramString);
  
  public abstract long h(bb parambb);
  
  public abstract boolean j(bb parambb);
  
  public abstract boolean jaK();
  
  public abstract HashMap<String, Long> jaL();
  
  public abstract void jaM();
  
  public abstract List<String> jaO();
  
  public abstract Cursor jaP();
  
  public abstract int jaQ();
  
  public abstract String jaR();
  
  public abstract Cursor jaS();
  
  public abstract List<bb> jaT();
  
  public abstract Cursor jaU();
  
  public abstract boolean k(bb parambb);
  
  public abstract boolean l(bb parambb);
  
  public abstract boolean m(bb parambb);
  
  public abstract List<String> nd(List<String> paramList);
  
  public abstract Cursor p(List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract Cursor pJ(String paramString1, String paramString2);
  
  public static abstract interface a
  {
    public abstract void a(bb parambb, by paramby);
  }
  
  public static abstract interface b
  {
    public abstract String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext);
    
    public abstract void a(cc paramcc, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.by
 * JD-Core Version:    0.7.0.1
 */